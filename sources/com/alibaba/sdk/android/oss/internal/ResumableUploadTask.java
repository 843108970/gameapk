package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.ListPartsRequest;
import com.alibaba.sdk.android.oss.model.ListPartsResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.PartSummary;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ResumableUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex = new ArrayList();
    private long mFirstPartSize;
    private File mRecordFile;

    public ResumableUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
    }

    /* access modifiers changed from: protected */
    public void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), (OSSCompletedCallback<AbortMultipartUploadRequest, AbortMultipartUploadResult>) null).waitUntilFinished();
        }
    }

    /* access modifiers changed from: protected */
    public void checkException() throws IOException, ServiceException, ClientException {
        if (this.mContext.getCancellationHandler().isCancelled() && ((ResumableUploadRequest) this.mRequest).deleteUploadOnCancelling().booleanValue()) {
            abortThisUpload();
            if (this.mRecordFile != null) {
                this.mRecordFile.delete();
            }
        }
        super.checkException();
    }

    /* access modifiers changed from: protected */
    public ResumableUploadResult doMultipartUpload() throws IOException, ClientException, ServiceException, InterruptedException {
        long j = this.mUploadedLength;
        checkCancel();
        int[] iArr = new int[2];
        checkPartSize(iArr);
        final int i = iArr[0];
        final int i2 = iArr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            if (this.mUploadedLength > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            } else if (this.mFirstPartSize != ((long) i)) {
                throw new ClientException("The part size setting is inconsistent with before");
            } else if (this.mProgressCallback != null) {
                this.mProgressCallback.onProgress(this.mRequest, this.mUploadedLength, this.mFileLength);
            }
        }
        for (final int i3 = 0; i3 < i2; i3++) {
            if ((this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i3 + 1))) && this.mPoolExecutor != null) {
                if (i3 == i2 - 1) {
                    i = (int) Math.min((long) i, this.mFileLength - j);
                }
                this.mPoolExecutor.execute(new Runnable() {
                    public void run() {
                        ResumableUploadTask.this.uploadPart(i3, i, i2);
                    }
                });
                j += (long) i;
            }
        }
        if (checkWaitCondition(i2)) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        if (!(this.mRecordFile == null || completeMultipartUploadResult == null)) {
            this.mRecordFile.delete();
        }
        releasePool();
        return new ResumableUploadResult(completeMultipartUploadResult);
    }

    /* access modifiers changed from: protected */
    public void initMultipartUploadId() throws IOException, ClientException, ServiceException {
        String uploadFilePath = ((ResumableUploadRequest) this.mRequest).getUploadFilePath();
        this.mUploadedLength = 0;
        this.mUploadFile = new File(uploadFilePath);
        this.mFileLength = this.mUploadFile.length();
        if (this.mFileLength == 0) {
            throw new ClientException("file length must not be 0");
        }
        if (!OSSUtils.isEmptyString(((ResumableUploadRequest) this.mRequest).getRecordDirectory())) {
            String calculateMd5Str = BinaryUtil.calculateMd5Str((BinaryUtil.calculateMd5Str(uploadFilePath) + ((ResumableUploadRequest) this.mRequest).getBucketName() + ((ResumableUploadRequest) this.mRequest).getObjectKey() + String.valueOf(((ResumableUploadRequest) this.mRequest).getPartSize())).getBytes());
            StringBuilder sb = new StringBuilder();
            sb.append(((ResumableUploadRequest) this.mRequest).getRecordDirectory());
            sb.append("/");
            sb.append(calculateMd5Str);
            this.mRecordFile = new File(sb.toString());
            if (this.mRecordFile.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.mRecordFile));
                this.mUploadId = bufferedReader.readLine();
                bufferedReader.close();
                OSSLog.logDebug("[initUploadId] - Found record file, uploadid: " + this.mUploadId);
                OSSAsyncTask<ListPartsResult> listParts = this.mApiOperation.listParts(new ListPartsRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), (OSSCompletedCallback<ListPartsRequest, ListPartsResult>) null);
                try {
                    List<PartSummary> parts = listParts.getResult().getParts();
                    for (int i = 0; i < parts.size(); i++) {
                        PartSummary partSummary = parts.get(i);
                        this.mPartETags.add(new PartETag(partSummary.getPartNumber(), partSummary.getETag()));
                        this.mUploadedLength += partSummary.getSize();
                        this.mAlreadyUploadIndex.add(Integer.valueOf(partSummary.getPartNumber()));
                        if (i == 0) {
                            this.mFirstPartSize = partSummary.getSize();
                        }
                    }
                } catch (ServiceException e) {
                    if (e.getStatusCode() == 404) {
                        this.mUploadId = null;
                    } else {
                        throw e;
                    }
                } catch (ClientException e2) {
                    throw e2;
                }
                listParts.waitUntilFinished();
            }
            if (!this.mRecordFile.exists() && !this.mRecordFile.createNewFile()) {
                throw new ClientException("Can't create file at path: " + this.mRecordFile.getAbsolutePath() + "\nPlease make sure the directory exist!");
            }
        }
        if (OSSUtils.isEmptyString(this.mUploadId)) {
            this.mUploadId = this.mApiOperation.initMultipartUpload(new InitiateMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), ((ResumableUploadRequest) this.mRequest).getMetadata()), (OSSCompletedCallback<InitiateMultipartUploadRequest, InitiateMultipartUploadResult>) null).getResult().getUploadId();
            if (this.mRecordFile != null) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.mRecordFile));
                bufferedWriter.write(this.mUploadId);
                bufferedWriter.close();
            }
        }
        ((ResumableUploadRequest) this.mRequest).setUploadId(this.mUploadId);
    }

    /* access modifiers changed from: protected */
    public void processException(Exception exc) {
        synchronized (this.mLock) {
            this.mPartExceptionCount++;
            if (this.mUploadException == null || !exc.getMessage().equals(this.mUploadException.getMessage())) {
                this.mUploadException = exc;
            }
            OSSLog.logThrowable2Local(exc);
            if (this.mContext.getCancellationHandler().isCancelled() && !this.mIsCancel) {
                this.mIsCancel = true;
                this.mLock.notify();
            }
        }
    }
}

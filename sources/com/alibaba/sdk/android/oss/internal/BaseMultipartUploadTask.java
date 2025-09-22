package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.hlzn.socketclient.b.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class BaseMultipartUploadTask<Request extends MultipartUploadRequest, Result extends CompleteMultipartUploadResult> implements Callable<Result> {
    protected final int CPU_SIZE = (Runtime.getRuntime().availableProcessors() * 2);
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected InternalRequestOperation mApiOperation;
    protected OSSCompletedCallback<Request, Result> mCompletedCallback;
    protected ExecutionContext mContext;
    protected long mFileLength;
    protected boolean mIsCancel;
    protected Object mLock;
    protected List<PartETag> mPartETags;
    protected int mPartExceptionCount;
    protected ThreadPoolExecutor mPoolExecutor;
    protected OSSProgressCallback<Request> mProgressCallback;
    protected Request mRequest;
    protected Exception mUploadException;
    protected File mUploadFile;
    protected String mUploadId;
    protected long mUploadedLength;

    public BaseMultipartUploadTask(InternalRequestOperation internalRequestOperation, Request request, OSSCompletedCallback<Request, Result> oSSCompletedCallback, ExecutionContext executionContext) {
        this.MAX_CORE_POOL_SIZE = this.CPU_SIZE < 5 ? this.CPU_SIZE : 5;
        this.MAX_IMUM_POOL_SIZE = this.CPU_SIZE;
        this.KEEP_ALIVE_TIME = 3000;
        this.MAX_QUEUE_SIZE = a.t;
        this.mPoolExecutor = new ThreadPoolExecutor(this.MAX_CORE_POOL_SIZE, this.MAX_IMUM_POOL_SIZE, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(a.t), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mPartETags = new ArrayList();
        this.mLock = new Object();
        this.mUploadedLength = 0;
        this.mApiOperation = internalRequestOperation;
        this.mRequest = request;
        this.mProgressCallback = request.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
    }

    /* access modifiers changed from: protected */
    public abstract void abortThisUpload();

    public Result call() throws Exception {
        try {
            initMultipartUploadId();
            Result doMultipartUpload = doMultipartUpload();
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onSuccess(this.mRequest, doMultipartUpload);
            }
            return doMultipartUpload;
        } catch (ServiceException e) {
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onFailure(this.mRequest, (ClientException) null, e);
            }
            throw e;
        } catch (Exception e2) {
            ClientException clientException = new ClientException(e2.toString(), e2);
            if (this.mCompletedCallback != null) {
                this.mCompletedCallback.onFailure(this.mRequest, clientException, (ServiceException) null);
            }
            throw clientException;
        }
    }

    /* access modifiers changed from: protected */
    public void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            IOException iOException = new IOException("multipart cancel");
            throw new ClientException(iOException.getMessage(), iOException);
        }
    }

    /* access modifiers changed from: protected */
    public void checkException() throws IOException, ServiceException, ClientException {
        if (this.mUploadException != null) {
            releasePool();
            if (this.mUploadException instanceof IOException) {
                throw ((IOException) this.mUploadException);
            } else if (this.mUploadException instanceof ServiceException) {
                throw ((ServiceException) this.mUploadException);
            } else if (this.mUploadException instanceof ClientException) {
                throw ((ClientException) this.mUploadException);
            } else {
                throw new ClientException(this.mUploadException.getMessage(), this.mUploadException);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void checkPartSize(int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        int i = (int) (this.mFileLength / partSize);
        if (this.mFileLength % partSize != 0) {
            i++;
        }
        if (i > 5000) {
            partSize = this.mFileLength / 5000;
        }
        iArr[0] = (int) partSize;
        iArr[1] = i;
    }

    /* access modifiers changed from: protected */
    public boolean checkWaitCondition(int i) {
        return this.mPartETags.size() != i;
    }

    /* access modifiers changed from: protected */
    public CompleteMultipartUploadResult completeMultipartUploadResult() throws ClientException, ServiceException {
        CompleteMultipartUploadResult completeMultipartUploadResult = null;
        if (this.mPartETags.size() > 0) {
            Collections.sort(this.mPartETags, new Comparator<PartETag>() {
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                        return -1;
                    }
                    return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
                }
            });
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, this.mPartETags);
            completeMultipartUploadRequest.setMetadata(this.mRequest.getMetadata());
            if (this.mRequest.getCallbackParam() != null) {
                completeMultipartUploadRequest.setCallbackParam(this.mRequest.getCallbackParam());
            }
            if (this.mRequest.getCallbackVars() != null) {
                completeMultipartUploadRequest.setCallbackVars(this.mRequest.getCallbackVars());
            }
            completeMultipartUploadResult = this.mApiOperation.completeMultipartUpload(completeMultipartUploadRequest, (OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult>) null).getResult();
        }
        this.mUploadedLength = 0;
        return completeMultipartUploadResult;
    }

    /* access modifiers changed from: protected */
    public abstract Result doMultipartUpload() throws IOException, ServiceException, ClientException, InterruptedException;

    /* access modifiers changed from: protected */
    public abstract void initMultipartUploadId() throws IOException, ClientException, ServiceException;

    /* access modifiers changed from: protected */
    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    /* access modifiers changed from: protected */
    public void onProgressCallback(Request request, long j, long j2) {
        if (this.mProgressCallback != null) {
            this.mProgressCallback.onProgress(request, j, j2);
        }
    }

    /* access modifiers changed from: protected */
    public void preUploadPart(int i, int i2, int i3) throws Exception {
    }

    /* access modifiers changed from: protected */
    public abstract void processException(Exception exc);

    /* access modifiers changed from: protected */
    public void releasePool() {
        if (this.mPoolExecutor != null) {
            this.mPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a7 A[SYNTHETIC, Splitter:B:38:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadPart(int r9, int r10, int r11) {
        /*
            r8 = this;
            r0 = 0
            r8.checkCancel()     // Catch:{ Exception -> 0x0096 }
            r8.preUploadPart(r9, r10, r11)     // Catch:{ Exception -> 0x0096 }
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0096 }
            java.io.File r2 = r8.mUploadFile     // Catch:{ Exception -> 0x0096 }
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0096 }
            com.alibaba.sdk.android.oss.model.UploadPartRequest r2 = new com.alibaba.sdk.android.oss.model.UploadPartRequest     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            Request r3 = r8.mRequest     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            java.lang.String r3 = r3.getBucketName()     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            Request r4 = r8.mRequest     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            java.lang.String r4 = r4.getObjectKey()     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            java.lang.String r5 = r8.mUploadId     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            int r6 = r9 + 1
            r2.<init>(r3, r4, r5, r6)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            long r3 = (long) r9     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            Request r9 = r8.mRequest     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            long r5 = r9.getPartSize()     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            long r3 = r3 * r5
            byte[] r9 = new byte[r10]     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            r1.seek(r3)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            r3 = 0
            r1.readFully(r9, r3, r10)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            r2.setPartContent(r9)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            java.lang.String r9 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateBase64Md5((byte[]) r9)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            r2.setMd5Digest(r9)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation r9 = r8.mApiOperation     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            com.alibaba.sdk.android.oss.internal.OSSAsyncTask r9 = r9.uploadPart(r2, r0)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            com.alibaba.sdk.android.oss.model.OSSResult r9 = r9.getResult()     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            com.alibaba.sdk.android.oss.model.UploadPartResult r9 = (com.alibaba.sdk.android.oss.model.UploadPartResult) r9     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            java.lang.Object r0 = r8.mLock     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            monitor-enter(r0)     // Catch:{ Exception -> 0x0090, all -> 0x008e }
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r3 = r8.mPartETags     // Catch:{ all -> 0x008b }
            com.alibaba.sdk.android.oss.model.PartETag r4 = new com.alibaba.sdk.android.oss.model.PartETag     // Catch:{ all -> 0x008b }
            int r2 = r2.getPartNumber()     // Catch:{ all -> 0x008b }
            java.lang.String r9 = r9.getETag()     // Catch:{ all -> 0x008b }
            r4.<init>(r2, r9)     // Catch:{ all -> 0x008b }
            r3.add(r4)     // Catch:{ all -> 0x008b }
            long r2 = r8.mUploadedLength     // Catch:{ all -> 0x008b }
            long r9 = (long) r10     // Catch:{ all -> 0x008b }
            long r4 = r2 + r9
            r8.mUploadedLength = r4     // Catch:{ all -> 0x008b }
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r9 = r8.mPartETags     // Catch:{ all -> 0x008b }
            int r9 = r9.size()     // Catch:{ all -> 0x008b }
            int r10 = r8.mPartExceptionCount     // Catch:{ all -> 0x008b }
            int r11 = r11 - r10
            if (r9 != r11) goto L_0x0077
            r8.notifyMultipartThread()     // Catch:{ all -> 0x008b }
        L_0x0077:
            Request r3 = r8.mRequest     // Catch:{ all -> 0x008b }
            long r4 = r8.mUploadedLength     // Catch:{ all -> 0x008b }
            long r6 = r8.mFileLength     // Catch:{ all -> 0x008b }
            r2 = r8
            r2.onProgressCallback(r3, r4, r6)     // Catch:{ all -> 0x008b }
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            r1.close()     // Catch:{ IOException -> 0x0086 }
            return
        L_0x0086:
            r9 = move-exception
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r9)
            return
        L_0x008b:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            throw r9     // Catch:{ Exception -> 0x0090, all -> 0x008e }
        L_0x008e:
            r9 = move-exception
            goto L_0x00a5
        L_0x0090:
            r9 = move-exception
            r0 = r1
            goto L_0x0097
        L_0x0093:
            r9 = move-exception
            r1 = r0
            goto L_0x00a5
        L_0x0096:
            r9 = move-exception
        L_0x0097:
            r8.processException(r9)     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x00a4
            r0.close()     // Catch:{ IOException -> 0x00a0 }
            return
        L_0x00a0:
            r9 = move-exception
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r9)
        L_0x00a4:
            return
        L_0x00a5:
            if (r1 == 0) goto L_0x00af
            r1.close()     // Catch:{ IOException -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r10 = move-exception
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r10)
        L_0x00af:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.uploadPart(int, int, int):void");
    }
}

package com.alibaba.sdk.android.oss;

import android.content.Context;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLogToFileUtils;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.internal.ExtensionRequestOperation;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.internal.ObjectURLPresigner;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.AppendObjectRequest;
import com.alibaba.sdk.android.oss.model.AppendObjectResult;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.CopyObjectRequest;
import com.alibaba.sdk.android.oss.model.CopyObjectResult;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.alibaba.sdk.android.oss.model.CreateBucketResult;
import com.alibaba.sdk.android.oss.model.DeleteBucketRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketResult;
import com.alibaba.sdk.android.oss.model.DeleteObjectRequest;
import com.alibaba.sdk.android.oss.model.DeleteObjectResult;
import com.alibaba.sdk.android.oss.model.GeneratePresignedUrlRequest;
import com.alibaba.sdk.android.oss.model.GetBucketACLRequest;
import com.alibaba.sdk.android.oss.model.GetBucketACLResult;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.GetObjectResult;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.alibaba.sdk.android.oss.model.ListPartsRequest;
import com.alibaba.sdk.android.oss.model.ListPartsResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OSSClient implements OSS {
    private ClientConfiguration conf;
    private OSSCredentialProvider credentialProvider;
    private URI endpointURI;
    private ExtensionRequestOperation extensionRequestOperation;
    private InternalRequestOperation internalRequestOperation;

    public OSSClient(Context context, String str, OSSCredentialProvider oSSCredentialProvider) {
        this(context, str, oSSCredentialProvider, (ClientConfiguration) null);
    }

    public OSSClient(Context context, String str, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        OSSLogToFileUtils.init(context.getApplicationContext(), clientConfiguration);
        try {
            String trim = str.trim();
            if (!trim.startsWith("http")) {
                trim = "http://" + trim;
            }
            this.endpointURI = new URI(trim);
            if (oSSCredentialProvider == null) {
                throw new IllegalArgumentException("CredentialProvider can't be null.");
            }
            this.credentialProvider = oSSCredentialProvider;
            this.conf = clientConfiguration == null ? ClientConfiguration.getDefaultConf() : clientConfiguration;
            this.internalRequestOperation = new InternalRequestOperation(context.getApplicationContext(), this.endpointURI, oSSCredentialProvider, this.conf);
            this.extensionRequestOperation = new ExtensionRequestOperation(this.internalRequestOperation);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Endpoint must be a string like 'http://oss-cn-****.aliyuncs.com',or your cname like 'http://image.cnamedomain.com'!");
        }
    }

    public AbortMultipartUploadResult abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.abortMultipartUpload(abortMultipartUploadRequest, (OSSCompletedCallback<AbortMultipartUploadRequest, AbortMultipartUploadResult>) null).getResult();
    }

    public void abortResumableUpload(ResumableUploadRequest resumableUploadRequest) throws IOException {
        this.extensionRequestOperation.abortResumableUpload(resumableUploadRequest);
    }

    public AppendObjectResult appendObject(AppendObjectRequest appendObjectRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.appendObject(appendObjectRequest, (OSSCompletedCallback<AppendObjectRequest, AppendObjectResult>) null).getResult();
    }

    public OSSAsyncTask<AbortMultipartUploadResult> asyncAbortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest, OSSCompletedCallback<AbortMultipartUploadRequest, AbortMultipartUploadResult> oSSCompletedCallback) {
        return this.internalRequestOperation.abortMultipartUpload(abortMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<AppendObjectResult> asyncAppendObject(AppendObjectRequest appendObjectRequest, OSSCompletedCallback<AppendObjectRequest, AppendObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.appendObject(appendObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<CompleteMultipartUploadResult> asyncCompleteMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest, OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult> oSSCompletedCallback) {
        return this.internalRequestOperation.completeMultipartUpload(completeMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<CopyObjectResult> asyncCopyObject(CopyObjectRequest copyObjectRequest, OSSCompletedCallback<CopyObjectRequest, CopyObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.copyObject(copyObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<CreateBucketResult> asyncCreateBucket(CreateBucketRequest createBucketRequest, OSSCompletedCallback<CreateBucketRequest, CreateBucketResult> oSSCompletedCallback) {
        return this.internalRequestOperation.createBucket(createBucketRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<DeleteBucketResult> asyncDeleteBucket(DeleteBucketRequest deleteBucketRequest, OSSCompletedCallback<DeleteBucketRequest, DeleteBucketResult> oSSCompletedCallback) {
        return this.internalRequestOperation.deleteBucket(deleteBucketRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<DeleteObjectResult> asyncDeleteObject(DeleteObjectRequest deleteObjectRequest, OSSCompletedCallback<DeleteObjectRequest, DeleteObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.deleteObject(deleteObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<GetBucketACLResult> asyncGetBucketACL(GetBucketACLRequest getBucketACLRequest, OSSCompletedCallback<GetBucketACLRequest, GetBucketACLResult> oSSCompletedCallback) {
        return this.internalRequestOperation.getBucketACL(getBucketACLRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<GetObjectResult> asyncGetObject(GetObjectRequest getObjectRequest, OSSCompletedCallback<GetObjectRequest, GetObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.getObject(getObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<HeadObjectResult> asyncHeadObject(HeadObjectRequest headObjectRequest, OSSCompletedCallback<HeadObjectRequest, HeadObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.headObject(headObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<InitiateMultipartUploadResult> asyncInitMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest, OSSCompletedCallback<InitiateMultipartUploadRequest, InitiateMultipartUploadResult> oSSCompletedCallback) {
        return this.internalRequestOperation.initMultipartUpload(initiateMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ListObjectsResult> asyncListObjects(ListObjectsRequest listObjectsRequest, OSSCompletedCallback<ListObjectsRequest, ListObjectsResult> oSSCompletedCallback) {
        return this.internalRequestOperation.listObjects(listObjectsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ListPartsResult> asyncListParts(ListPartsRequest listPartsRequest, OSSCompletedCallback<ListPartsRequest, ListPartsResult> oSSCompletedCallback) {
        return this.internalRequestOperation.listParts(listPartsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<CompleteMultipartUploadResult> asyncMultipartUpload(MultipartUploadRequest multipartUploadRequest, OSSCompletedCallback<MultipartUploadRequest, CompleteMultipartUploadResult> oSSCompletedCallback) {
        return this.extensionRequestOperation.multipartUpload(multipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<PutObjectResult> asyncPutObject(PutObjectRequest putObjectRequest, OSSCompletedCallback<PutObjectRequest, PutObjectResult> oSSCompletedCallback) {
        return this.internalRequestOperation.putObject(putObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<ResumableUploadResult> asyncResumableUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback) {
        return this.extensionRequestOperation.resumableUpload(resumableUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask<UploadPartResult> asyncUploadPart(UploadPartRequest uploadPartRequest, OSSCompletedCallback<UploadPartRequest, UploadPartResult> oSSCompletedCallback) {
        return this.internalRequestOperation.uploadPart(uploadPartRequest, oSSCompletedCallback);
    }

    public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.completeMultipartUpload(completeMultipartUploadRequest, (OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult>) null).getResult();
    }

    public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.copyObject(copyObjectRequest, (OSSCompletedCallback<CopyObjectRequest, CopyObjectResult>) null).getResult();
    }

    public CreateBucketResult createBucket(CreateBucketRequest createBucketRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.createBucket(createBucketRequest, (OSSCompletedCallback<CreateBucketRequest, CreateBucketResult>) null).getResult();
    }

    public DeleteBucketResult deleteBucket(DeleteBucketRequest deleteBucketRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.deleteBucket(deleteBucketRequest, (OSSCompletedCallback<DeleteBucketRequest, DeleteBucketResult>) null).getResult();
    }

    public DeleteObjectResult deleteObject(DeleteObjectRequest deleteObjectRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.deleteObject(deleteObjectRequest, (OSSCompletedCallback<DeleteObjectRequest, DeleteObjectResult>) null).getResult();
    }

    public boolean doesObjectExist(String str, String str2) throws ClientException, ServiceException {
        return this.extensionRequestOperation.doesObjectExist(str, str2);
    }

    public GetBucketACLResult getBucketACL(GetBucketACLRequest getBucketACLRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.getBucketACL(getBucketACLRequest, (OSSCompletedCallback<GetBucketACLRequest, GetBucketACLResult>) null).getResult();
    }

    public GetObjectResult getObject(GetObjectRequest getObjectRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.getObject(getObjectRequest, (OSSCompletedCallback<GetObjectRequest, GetObjectResult>) null).getResult();
    }

    public HeadObjectResult headObject(HeadObjectRequest headObjectRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.headObject(headObjectRequest, (OSSCompletedCallback<HeadObjectRequest, HeadObjectResult>) null).getResult();
    }

    public InitiateMultipartUploadResult initMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.initMultipartUpload(initiateMultipartUploadRequest, (OSSCompletedCallback<InitiateMultipartUploadRequest, InitiateMultipartUploadResult>) null).getResult();
    }

    public ListObjectsResult listObjects(ListObjectsRequest listObjectsRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.listObjects(listObjectsRequest, (OSSCompletedCallback<ListObjectsRequest, ListObjectsResult>) null).getResult();
    }

    public ListPartsResult listParts(ListPartsRequest listPartsRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.listParts(listPartsRequest, (OSSCompletedCallback<ListPartsRequest, ListPartsResult>) null).getResult();
    }

    public CompleteMultipartUploadResult multipartUpload(MultipartUploadRequest multipartUploadRequest) throws ClientException, ServiceException {
        return this.extensionRequestOperation.multipartUpload(multipartUploadRequest, (OSSCompletedCallback<MultipartUploadRequest, CompleteMultipartUploadResult>) null).getResult();
    }

    public String presignConstrainedObjectURL(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws ClientException {
        return new ObjectURLPresigner(this.endpointURI, this.credentialProvider, this.conf).presignConstrainedURL(generatePresignedUrlRequest);
    }

    public String presignConstrainedObjectURL(String str, String str2, long j) throws ClientException {
        return new ObjectURLPresigner(this.endpointURI, this.credentialProvider, this.conf).presignConstrainedURL(str, str2, j);
    }

    public String presignPublicObjectURL(String str, String str2) {
        return new ObjectURLPresigner(this.endpointURI, this.credentialProvider, this.conf).presignPublicURL(str, str2);
    }

    public PutObjectResult putObject(PutObjectRequest putObjectRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.putObject(putObjectRequest, (OSSCompletedCallback<PutObjectRequest, PutObjectResult>) null).getResult();
    }

    public ResumableUploadResult resumableUpload(ResumableUploadRequest resumableUploadRequest) throws ClientException, ServiceException {
        return this.extensionRequestOperation.resumableUpload(resumableUploadRequest, (OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult>) null).getResult();
    }

    public void updateCredentialProvider(OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
        this.internalRequestOperation.setCredentialProvider(oSSCredentialProvider);
    }

    public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws ClientException, ServiceException {
        return this.internalRequestOperation.uploadPart(uploadPartRequest, (OSSCompletedCallback<UploadPartRequest, UploadPartResult>) null).getResult();
    }
}

package com.cyjh.http.oss;

import android.content.Context;
import android.util.Log;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.e;
import com.cyjh.common.util.n;
import com.cyjh.http.bean.response.AliCloudServerResponse;
import java.io.File;

public class MyOSSUtils {
    /* access modifiers changed from: private */
    public static String TAG = "MyOSSUtils";
    /* access modifiers changed from: private */
    public AliCloudServerResponse aliCloudServerResponse;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public OSS oss;

    public static class Builder {
        /* access modifiers changed from: private */
        public AliCloudServerResponse aliCloudServerResponse;
        /* access modifiers changed from: private */
        public int connectionTimeout = 15000;
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public int maxConcurrentRequest = 5;
        /* access modifiers changed from: private */
        public int maxErrorRetry = 2;
        /* access modifiers changed from: private */
        public int socketTimeout = 15000;

        public Builder(Context context2, AliCloudServerResponse aliCloudServerResponse2) {
            this.context = context2;
            this.aliCloudServerResponse = aliCloudServerResponse2;
        }

        public MyOSSUtils build() {
            return new MyOSSUtils(this);
        }

        public Builder setConnectionTimeout(int i) {
            this.connectionTimeout = i;
            return this;
        }

        public Builder setMaxConcurrentRequest(int i) {
            this.maxConcurrentRequest = i;
            return this;
        }

        public Builder setMaxErrorRetry(int i) {
            this.maxErrorRetry = i;
            return this;
        }

        public Builder setSocketTimeout(int i) {
            this.socketTimeout = i;
            return this;
        }
    }

    public interface UploadFileCallBack {
        void uploadFail(String str);

        void uploadProgress(long j, long j2);

        void uploadSuc(String str, String str2);
    }

    private MyOSSUtils(Builder builder) {
        this.aliCloudServerResponse = builder.aliCloudServerResponse;
        this.mContext = builder.context;
        MyOSSAuthCredentialsProvider myOSSAuthCredentialsProvider = new MyOSSAuthCredentialsProvider(this.aliCloudServerResponse);
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setConnectionTimeout(builder.connectionTimeout);
        clientConfiguration.setSocketTimeout(builder.socketTimeout);
        clientConfiguration.setMaxConcurrentRequest(builder.maxConcurrentRequest);
        clientConfiguration.setMaxErrorRetry(builder.maxErrorRetry);
        this.oss = new OSSClient(this.mContext, this.aliCloudServerResponse.OssEndpoint, myOSSAuthCredentialsProvider, clientConfiguration);
    }

    public boolean isTokenExpireTime() {
        try {
            if (this.aliCloudServerResponse == null) {
                return true;
            }
            return this.aliCloudServerResponse.AliCloundExpireTime.longValue() - Long.valueOf(System.currentTimeMillis() / 1000).longValue() < 3;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void uploadFile(String str, final String str2, final UploadFileCallBack uploadFileCallBack) {
        final File file = new File(str);
        if (file.exists()) {
            PutObjectRequest putObjectRequest = new PutObjectRequest(this.aliCloudServerResponse.OssBucket, str2, str);
            putObjectRequest.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
                public void onProgress(PutObjectRequest putObjectRequest, long j, long j2) {
                    uploadFileCallBack.uploadProgress(j, j2);
                }
            });
            this.oss.asyncPutObject(putObjectRequest, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                public void onFailure(PutObjectRequest putObjectRequest, ClientException clientException, ServiceException serviceException) {
                    uploadFileCallBack.uploadFail(file.getName());
                    File b2 = e.b(MyOSSUtils.this.mContext);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("message=");
                    stringBuffer.append(putObjectRequest.toString());
                    n.b(b2, stringBuffer.toString(), "UTF-8");
                    if (clientException != null) {
                        String access$900 = MyOSSUtils.TAG;
                        ad.c(access$900, "uploadFile --> ex=" + clientException.getMessage());
                        stringBuffer.append("clientException=");
                        stringBuffer.append(clientException.getMessage());
                        stringBuffer.append("\n");
                        Log.e("zzz", "MyOSSUtils--uploadImage--clientException" + clientException.getMessage());
                        clientException.printStackTrace();
                        n.b(b2, stringBuffer.toString(), "UTF-8");
                    }
                    if (serviceException != null) {
                        Log.e("uploadImage--ErrorCode", serviceException.getErrorCode());
                        Log.e("uploadImage--RequestId", serviceException.getRequestId());
                        Log.e("uploadImage--HostId", serviceException.getHostId());
                        Log.e("uploadImage--RawMessage", serviceException.getRawMessage());
                        stringBuffer.append("ErrorCode=");
                        stringBuffer.append(serviceException.getErrorCode());
                        stringBuffer.append("\n");
                        stringBuffer.append("RequestId=");
                        stringBuffer.append(serviceException.getRequestId());
                        stringBuffer.append("\n");
                        stringBuffer.append("HostId=");
                        stringBuffer.append(serviceException.getHostId());
                        stringBuffer.append("\n");
                        stringBuffer.append("RawMessage=");
                        stringBuffer.append(serviceException.getRawMessage());
                        stringBuffer.append("\n\n\n");
                        n.b(b2, stringBuffer.toString(), "UTF-8");
                    }
                }

                public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
                    String presignPublicObjectURL = MyOSSUtils.this.oss.presignPublicObjectURL(MyOSSUtils.this.aliCloudServerResponse.OssBucket, str2);
                    String access$900 = MyOSSUtils.TAG;
                    ad.c(access$900, "onSuccess --> uploadOssUrl=" + presignPublicObjectURL);
                    uploadFileCallBack.uploadSuc(presignPublicObjectURL, file.getName());
                }
            });
        }
    }
}

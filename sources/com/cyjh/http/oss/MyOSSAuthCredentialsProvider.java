package com.cyjh.http.oss;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.cyjh.http.bean.response.AliCloudServerResponse;

public class MyOSSAuthCredentialsProvider extends OSSFederationCredentialProvider {
    private AliCloudServerResponse aliCloudServerResponse;
    private AuthDecoder mDecoder;

    public interface AuthDecoder {
        String decode(String str);
    }

    public MyOSSAuthCredentialsProvider(AliCloudServerResponse aliCloudServerResponse2) {
        this.aliCloudServerResponse = aliCloudServerResponse2;
    }

    public OSSFederationToken getFederationToken() {
        try {
            if (this.aliCloudServerResponse != null) {
                return new OSSFederationToken(this.aliCloudServerResponse.AliCloundAccessKeyId, this.aliCloudServerResponse.AliCloundAccessKeySecret, this.aliCloudServerResponse.AliCloundSecurityToken, this.aliCloudServerResponse.AliCloundExpireTime.longValue());
            }
            throw new ClientException("ErrorMessage: " + "Token信息为null");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setDecoder(AuthDecoder authDecoder) {
        this.mDecoder = authDecoder;
    }
}

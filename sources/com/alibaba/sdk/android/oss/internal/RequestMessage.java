package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alibaba.sdk.android.oss.common.utils.HttpUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpdnsMini;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RequestMessage {
    private String bucketName;
    private OSSCredentialProvider credentialProvider;
    private URI endpoint;
    private Map<String, String> headers = new HashMap();
    private boolean httpDnsEnable = false;
    private boolean isAuthorizationRequired = true;
    private boolean isInCustomCnameExcludeList = false;
    private HttpMethod method;
    private String objectKey;
    private Map<String, String> parameters = new LinkedHashMap();
    private long readStreamLength;
    private byte[] uploadData;
    private String uploadFilePath;
    private InputStream uploadInputStream;

    public String buildCanonicalURL() {
        OSSUtils.assertTrue(this.endpoint != null, "Endpoint haven't been set!");
        String scheme = this.endpoint.getScheme();
        String host = this.endpoint.getHost();
        if (!OSSUtils.isCname(host) && this.bucketName != null) {
            host = this.bucketName + "." + host;
        }
        String str = null;
        if (isHttpDnsEnable()) {
            str = HttpdnsMini.getInstance().getIpByHostAsync(host);
        } else {
            OSSLog.logDebug("[buildCannonicalURL], disable httpdns");
        }
        if (str == null) {
            str = host;
        }
        if (OSSUtils.isCname(host) && isInCustomCnameExcludeList() && this.bucketName != null) {
            host = this.bucketName + "." + host;
        }
        this.headers.put(HttpHeaders.HOST, host);
        String str2 = scheme + "://" + str;
        if (this.objectKey != null) {
            str2 = str2 + "/" + HttpUtil.urlEncode(this.objectKey, "utf-8");
        }
        String paramToQueryString = OSSUtils.paramToQueryString(this.parameters, "utf-8");
        StringBuilder sb = new StringBuilder();
        sb.append("request---------------------\n");
        sb.append("request url=" + str2 + "\n");
        sb.append("request params=" + paramToQueryString + "\n");
        for (String next : this.headers.keySet()) {
            sb.append("requestHeader [" + next + "]: ");
            sb.append(this.headers.get(next) + "\n");
        }
        OSSLog.logDebug(sb.toString());
        if (OSSUtils.isEmptyString(paramToQueryString)) {
            return str2;
        }
        return str2 + "?" + paramToQueryString;
    }

    public void createBucketRequestBodyMarshall(String str) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append("<CreateBucketConfiguration>");
            stringBuffer.append("<LocationConstraint>" + str + "</LocationConstraint>");
            stringBuffer.append("</CreateBucketConfiguration>");
            byte[] bytes = stringBuffer.toString().getBytes("utf-8");
            setUploadInputStream(new ByteArrayInputStream(bytes), (long) bytes.length);
        }
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public OSSCredentialProvider getCredentialProvider() {
        return this.credentialProvider;
    }

    public URI getEndpoint() {
        return this.endpoint;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public long getReadStreamLength() {
        return this.readStreamLength;
    }

    public byte[] getUploadData() {
        return this.uploadData;
    }

    public String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public InputStream getUploadInputStream() {
        return this.uploadInputStream;
    }

    public boolean isAuthorizationRequired() {
        return this.isAuthorizationRequired;
    }

    public boolean isHttpDnsEnable() {
        return this.httpDnsEnable;
    }

    public boolean isInCustomCnameExcludeList() {
        return this.isInCustomCnameExcludeList;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCredentialProvider(OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
    }

    public void setEndpoint(URI uri) {
        this.endpoint = uri;
    }

    public void setHttpDnsEnable(boolean z) {
        this.httpDnsEnable = z;
    }

    public void setIsAuthorizationRequired(boolean z) {
        this.isAuthorizationRequired = z;
    }

    public void setIsInCustomCnameExcludeList(boolean z) {
        this.isInCustomCnameExcludeList = z;
    }

    public void setMethod(HttpMethod httpMethod) {
        this.method = httpMethod;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setParameters(Map<String, String> map) {
        this.parameters = map;
    }

    public void setUploadData(byte[] bArr) {
        this.uploadData = bArr;
    }

    public void setUploadFilePath(String str) {
        this.uploadFilePath = str;
    }

    public void setUploadInputStream(InputStream inputStream, long j) {
        if (inputStream != null) {
            this.uploadInputStream = inputStream;
            this.readStreamLength = j;
        }
    }
}

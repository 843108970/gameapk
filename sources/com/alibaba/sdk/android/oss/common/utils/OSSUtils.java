package com.alibaba.sdk.android.oss.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.sdk.android.oss.common.auth.HmacSHA1Signature;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.model.CopyObjectRequest;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketRequest;
import com.alibaba.sdk.android.oss.model.GetBucketACLRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.cyjh.common.util.s;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class OSSUtils {
    private static final String NEW_LINE = "\n";
    private static final List<String> SIGNED_PARAMTERS = Arrays.asList(new String[]{RequestParameters.SUBRESOURCE_ACL, RequestParameters.SUBRESOURCE_UPLOADS, RequestParameters.SUBRESOURCE_LOCATION, RequestParameters.SUBRESOURCE_CORS, RequestParameters.SUBRESOURCE_LOGGING, RequestParameters.SUBRESOURCE_WEBSITE, RequestParameters.SUBRESOURCE_REFERER, RequestParameters.SUBRESOURCE_LIFECYCLE, RequestParameters.SUBRESOURCE_DELETE, RequestParameters.SUBRESOURCE_APPEND, RequestParameters.UPLOAD_ID, RequestParameters.PART_NUMBER, RequestParameters.SECURITY_TOKEN, RequestParameters.POSITION, RequestParameters.RESPONSE_HEADER_CACHE_CONTROL, RequestParameters.RESPONSE_HEADER_CONTENT_DISPOSITION, RequestParameters.RESPONSE_HEADER_CONTENT_ENCODING, RequestParameters.RESPONSE_HEADER_CONTENT_LANGUAGE, RequestParameters.RESPONSE_HEADER_CONTENT_TYPE, RequestParameters.RESPONSE_HEADER_EXPIRES, RequestParameters.X_OSS_PROCESS});

    private enum MetadataDirective {
        COPY("COPY"),
        REPLACE("REPLACE");
        
        private final String directiveAsString;

        private MetadataDirective(String str) {
            this.directiveAsString = str;
        }

        public final String toString() {
            return this.directiveAsString;
        }
    }

    public static void addDateHeader(Map<String, String> map, String str, Date date) {
        if (date != null) {
            map.put(str, DateUtil.formatRfc822Date(date));
        }
    }

    public static void addHeader(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    public static void addStringListHeader(Map<String, String> map, String str, List<String> list) {
        if (list != null && !list.isEmpty()) {
            map.put(str, join(list));
        }
    }

    public static void assertTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String buildBaseLogInfo(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("=====[device info]=====\n");
        sb.append("[INFO]: android_version：" + Build.VERSION.RELEASE + "\n");
        sb.append("[INFO]: mobile_model：" + Build.MODEL + "\n");
        String operatorName = getOperatorName(context);
        if (!TextUtils.isEmpty(operatorName)) {
            sb.append("[INFO]: operator_name：" + operatorName + "\n");
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        String str = "unconnected";
        String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        if (activeNetworkInfo != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
            str2 = activeNetworkInfo.getTypeName() + s.a.f1696a;
            str = "connected";
        }
        sb.append("[INFO]: network_state：" + str + "\n");
        StringBuilder sb2 = new StringBuilder("[INFO]: network_type：");
        sb2.append(str2);
        sb.append(sb2.toString());
        return sb.toString();
    }

    public static String buildCanonicalString(RequestMessage requestMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append(requestMessage.getMethod().toString() + "\n");
        Map<String, String> headers = requestMessage.getHeaders();
        TreeMap treeMap = new TreeMap();
        if (headers != null) {
            for (Map.Entry next : headers.entrySet()) {
                if (next.getKey() != null) {
                    String lowerCase = ((String) next.getKey()).toLowerCase();
                    if (lowerCase.equals("Content-Type".toLowerCase()) || lowerCase.equals(HttpHeaders.CONTENT_MD5.toLowerCase()) || lowerCase.equals("Date".toLowerCase()) || lowerCase.startsWith(OSSHeaders.OSS_PREFIX)) {
                        treeMap.put(lowerCase, ((String) next.getValue()).trim());
                    }
                }
            }
        }
        if (!treeMap.containsKey("Content-Type".toLowerCase())) {
            treeMap.put("Content-Type".toLowerCase(), "");
        }
        if (!treeMap.containsKey(HttpHeaders.CONTENT_MD5.toLowerCase())) {
            treeMap.put(HttpHeaders.CONTENT_MD5.toLowerCase(), "");
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (str.startsWith(OSSHeaders.OSS_PREFIX)) {
                sb.append(str);
                sb.append(':');
            }
            sb.append(value);
            sb.append("\n");
        }
        sb.append(buildCanonicalizedResource(requestMessage.getBucketName(), requestMessage.getObjectKey(), requestMessage.getParameters()));
        return sb.toString();
    }

    public static String buildCanonicalizedResource(String str, String str2, Map<String, String> map) {
        String str3;
        if (str == null && str2 == null) {
            str3 = "/";
        } else if (str2 == null) {
            str3 = "/" + str + "/";
        } else {
            str3 = "/" + str + "/" + str2;
        }
        return buildCanonicalizedResource(str3, map);
    }

    public static String buildCanonicalizedResource(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (map != null) {
            String[] strArr = (String[]) map.keySet().toArray(new String[map.size()]);
            Arrays.sort(strArr);
            char c2 = '?';
            for (String str2 : strArr) {
                if (SIGNED_PARAMTERS.contains(str2)) {
                    sb.append(c2);
                    sb.append(str2);
                    String str3 = map.get(str2);
                    if (!isEmptyString(str3)) {
                        sb.append("=");
                        sb.append(str3);
                    }
                    c2 = '&';
                }
            }
        }
        return sb.toString();
    }

    public static String buildXMLFromPartEtagList(List<PartETag> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("<CompleteMultipartUpload>\n");
        for (PartETag next : list) {
            sb.append("<Part>\n");
            sb.append("<PartNumber>" + next.getPartNumber() + "</PartNumber>\n");
            sb.append("<ETag>" + next.getETag() + "</ETag>\n");
            sb.append("</Part>\n");
        }
        sb.append("</CompleteMultipartUpload>\n");
        return sb.toString();
    }

    public static boolean checkParamRange(long j, long j2, boolean z, long j3, boolean z2) {
        return (!z || !z2) ? (!z || z2) ? (z || z2) ? j2 < j && j <= j3 : j2 < j && j < j3 : j2 <= j && j < j3 : j2 <= j && j <= j3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r2 = r2.getMimeTypeFromExtension(r4.substring(r4.lastIndexOf(46) + 1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String determineContentType(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
            if (r2 == 0) goto L_0x0003
            return r2
        L_0x0003:
            android.webkit.MimeTypeMap r2 = android.webkit.MimeTypeMap.getSingleton()
            r0 = 46
            if (r3 == 0) goto L_0x001c
            int r1 = r3.lastIndexOf(r0)
            int r1 = r1 + 1
            java.lang.String r3 = r3.substring(r1)
            java.lang.String r3 = r2.getMimeTypeFromExtension(r3)
            if (r3 == 0) goto L_0x001c
            return r3
        L_0x001c:
            if (r4 == 0) goto L_0x002f
            int r3 = r4.lastIndexOf(r0)
            int r3 = r3 + 1
            java.lang.String r3 = r4.substring(r3)
            java.lang.String r2 = r2.getMimeTypeFromExtension(r3)
            if (r2 == 0) goto L_0x002f
            return r2
        L_0x002f:
            java.lang.String r2 = "application/octet-stream"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.utils.OSSUtils.determineContentType(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean doesRequestNeedObjectKey(OSSRequest oSSRequest) {
        return !(oSSRequest instanceof ListObjectsRequest) && !(oSSRequest instanceof CreateBucketRequest) && !(oSSRequest instanceof DeleteBucketRequest) && !(oSSRequest instanceof GetBucketACLRequest);
    }

    public static void ensureBucketNameValid(String str) {
        if (!validateBucketName(str)) {
            throw new IllegalArgumentException("The bucket name is invalid. \nA bucket name must: \n1) be comprised of lower-case characters, numbers or dash(-); \n2) start with lower case or numbers; \n3) be between 3-63 characters long. ");
        }
    }

    public static void ensureObjectKeyValid(String str) {
        if (!validateObjectKey(str)) {
            throw new IllegalArgumentException("The object key is invalid. \nAn object name should be: \n1) between 1 - 1023 bytes long when encoded as UTF-8 \n2) cannot contain LF or CR or unsupported chars in XML1.0, \n3) cannot begin with \"/\" or \"\\\".");
        }
    }

    public static void ensureRequestValid(OSSRequest oSSRequest, RequestMessage requestMessage) {
        ensureBucketNameValid(requestMessage.getBucketName());
        if (doesRequestNeedObjectKey(oSSRequest)) {
            ensureObjectKeyValid(requestMessage.getObjectKey());
        }
        if (oSSRequest instanceof CopyObjectRequest) {
            ensureObjectKeyValid(((CopyObjectRequest) oSSRequest).getDestinationKey());
        }
    }

    private static String getOperatorName(Context context) {
        String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        return simOperator != null ? (simOperator.equals("46000") || simOperator.equals("46002")) ? "CMCC" : simOperator.equals("46001") ? "CUCC" : simOperator.equals("46003") ? "CTCC" : simOperator : "";
    }

    public static boolean isCname(String str) {
        for (String endsWith : OSSConstants.DEFAULT_CNAME_EXCLUDE_LIST) {
            if (str.toLowerCase().endsWith(endsWith)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmptyString(String str) {
        return TextUtils.isEmpty(str);
    }

    public static boolean isInCustomCnameExcludeList(String str, List<String> list) {
        for (String lowerCase : list) {
            if (str.endsWith(lowerCase.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static String join(List<String> list) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String next : list) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(next);
            z = false;
        }
        return sb.toString();
    }

    public static String paramToQueryString(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            String str3 = (String) next.getValue();
            if (!z) {
                sb.append("&");
            }
            sb.append(HttpUtil.urlEncode(str2, str));
            if (!isEmptyString(str3)) {
                sb.append("=");
                sb.append(HttpUtil.urlEncode(str3, str));
            }
            z = false;
        }
        return sb.toString();
    }

    public static void populateCopyObjectHeaders(CopyObjectRequest copyObjectRequest, Map<String, String> map) {
        map.put(OSSHeaders.COPY_OBJECT_SOURCE, "/" + copyObjectRequest.getSourceBucketName() + "/" + HttpUtil.urlEncode(copyObjectRequest.getSourceKey(), "utf-8"));
        addDateHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_MODIFIED_SINCE, copyObjectRequest.getModifiedSinceConstraint());
        addDateHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_UNMODIFIED_SINCE, copyObjectRequest.getUnmodifiedSinceConstraint());
        addStringListHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_MATCH, copyObjectRequest.getMatchingETagConstraints());
        addStringListHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_NONE_MATCH, copyObjectRequest.getNonmatchingEtagConstraints());
        addHeader(map, OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION, copyObjectRequest.getServerSideEncryption());
        ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
        if (newObjectMetadata != null) {
            map.put(OSSHeaders.COPY_OBJECT_METADATA_DIRECTIVE, MetadataDirective.REPLACE.toString());
            populateRequestMetadata(map, newObjectMetadata);
        }
        removeHeader(map, "Content-Length");
    }

    public static void populateListObjectsRequestParameters(ListObjectsRequest listObjectsRequest, Map<String, String> map) {
        if (listObjectsRequest.getPrefix() != null) {
            map.put(RequestParameters.PREFIX, listObjectsRequest.getPrefix());
        }
        if (listObjectsRequest.getMarker() != null) {
            map.put(RequestParameters.MARKER, listObjectsRequest.getMarker());
        }
        if (listObjectsRequest.getDelimiter() != null) {
            map.put(RequestParameters.DELIMITER, listObjectsRequest.getDelimiter());
        }
        if (listObjectsRequest.getMaxKeys() != null) {
            map.put(RequestParameters.MAX_KEYS, Integer.toString(listObjectsRequest.getMaxKeys().intValue()));
        }
        if (listObjectsRequest.getEncodingType() != null) {
            map.put(RequestParameters.ENCODING_TYPE, listObjectsRequest.getEncodingType());
        }
    }

    public static String populateMapToBase64JsonString(Map<String, String> map) {
        return Base64.encodeToString(new JSONObject(map).toString().getBytes(), 2);
    }

    public static void populateRequestMetadata(Map<String, String> map, ObjectMetadata objectMetadata) {
        if (objectMetadata != null) {
            Map<String, Object> rawMetadata = objectMetadata.getRawMetadata();
            if (rawMetadata != null) {
                for (Map.Entry next : rawMetadata.entrySet()) {
                    map.put(next.getKey(), next.getValue().toString());
                }
            }
            Map<String, String> userMetadata = objectMetadata.getUserMetadata();
            if (userMetadata != null) {
                for (Map.Entry next2 : userMetadata.entrySet()) {
                    String str = (String) next2.getKey();
                    String str2 = (String) next2.getValue();
                    if (str != null) {
                        str = str.trim();
                    }
                    if (str2 != null) {
                        str2 = str2.trim();
                    }
                    map.put(str, str2);
                }
            }
        }
    }

    public static void removeHeader(Map<String, String> map, String str) {
        if (str != null && map.containsKey(str)) {
            map.remove(str);
        }
    }

    public static String sign(String str, String str2, String str3) {
        try {
            String trim = new HmacSHA1Signature().computeSignature(str2, str3).trim();
            return "OSS " + str + ":" + trim;
        } catch (Exception e) {
            throw new IllegalStateException("Compute signature failed!", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void signRequest(com.alibaba.sdk.android.oss.internal.RequestMessage r6) throws java.io.IOException {
        /*
            boolean r0 = r6.isAuthorizationRequired()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider r0 = r6.getCredentialProvider()
            if (r0 != 0) goto L_0x0015
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "当前CredentialProvider为空！！！\n1. 请检查您是否在初始化OSSService时设置CredentialProvider;\n2. 如果您bucket为公共权限，请确认获取到Bucket后已经调用Bucket中接口声明ACL;"
            r6.<init>(r0)
            throw r6
        L_0x0015:
            com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider r0 = r6.getCredentialProvider()
            r1 = 0
            boolean r2 = r0 instanceof com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider
            if (r2 == 0) goto L_0x0042
            r1 = r0
            com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider r1 = (com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider) r1
            com.alibaba.sdk.android.oss.common.auth.OSSFederationToken r1 = r1.getValidFederationToken()
            if (r1 != 0) goto L_0x0034
            java.lang.String r6 = "Can't get a federation token"
            com.alibaba.sdk.android.oss.common.OSSLog.logError(r6)
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r0 = "Can't get a federation token"
            r6.<init>(r0)
            throw r6
        L_0x0034:
            java.util.Map r3 = r6.getHeaders()
            java.lang.String r4 = "x-oss-security-token"
            java.lang.String r5 = r1.getSecurityToken()
            r3.put(r4, r5)
            goto L_0x004e
        L_0x0042:
            boolean r3 = r0 instanceof com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider
            if (r3 == 0) goto L_0x004e
            r1 = r0
            com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider r1 = (com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider) r1
            com.alibaba.sdk.android.oss.common.auth.OSSFederationToken r1 = r1.getFederationToken()
            goto L_0x0034
        L_0x004e:
            java.lang.String r3 = buildCanonicalString(r6)
            java.lang.String r4 = "---initValue---"
            if (r2 != 0) goto L_0x0079
            boolean r2 = r0 instanceof com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider
            if (r2 == 0) goto L_0x005b
            goto L_0x0079
        L_0x005b:
            boolean r1 = r0 instanceof com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider
            if (r1 == 0) goto L_0x006e
            com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider r0 = (com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider) r0
            java.lang.String r1 = r0.getAccessKeyId()
            java.lang.String r0 = r0.getAccessKeySecret()
            java.lang.String r4 = sign(r1, r0, r3)
            goto L_0x0085
        L_0x006e:
            boolean r1 = r0 instanceof com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider
            if (r1 == 0) goto L_0x0085
            com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider r0 = (com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider) r0
            java.lang.String r4 = r0.signContent(r3)
            goto L_0x0085
        L_0x0079:
            java.lang.String r0 = r1.getTempAK()
            java.lang.String r1 = r1.getTempSK()
            java.lang.String r4 = sign(r0, r1, r3)
        L_0x0085:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "signed content: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = "   \n ---------   signature: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug((java.lang.String) r0, (boolean) r1)
            java.util.Map r6 = r6.getHeaders()
            java.lang.String r0 = "Authorization"
            r6.put(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.utils.OSSUtils.signRequest(com.alibaba.sdk.android.oss.internal.RequestMessage):void");
    }

    public static boolean validateBucketName(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-z0-9][a-z0-9_\\-]{2,62}$");
    }

    public static boolean validateObjectKey(String str) {
        if (str == null || str.length() <= 0 || str.length() > 1023) {
            return false;
        }
        try {
            str.getBytes("utf-8");
            char[] charArray = str.toCharArray();
            char c2 = charArray[0];
            if (c2 == '/' || c2 == '\\') {
                return false;
            }
            for (char c3 : charArray) {
                if (c3 != 9 && c3 < ' ') {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
        }
        return false;
    }
}

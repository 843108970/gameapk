package com.alibaba.sdk.android.oss.internal;

import b.ae;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.AppendObjectResult;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.CopyObjectResult;
import com.alibaba.sdk.android.oss.model.CreateBucketResult;
import com.alibaba.sdk.android.oss.model.DeleteBucketResult;
import com.alibaba.sdk.android.oss.model.DeleteObjectResult;
import com.alibaba.sdk.android.oss.model.GetBucketACLResult;
import com.alibaba.sdk.android.oss.model.GetObjectResult;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.alibaba.sdk.android.oss.model.ListPartsResult;
import com.alibaba.sdk.android.oss.model.OSSObjectSummary;
import com.alibaba.sdk.android.oss.model.PartSummary;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import com.cyjh.elfin.a.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.text.ParseException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class ResponseParsers {
    public static final DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();

    public static final class AbortMultipartUploadResponseParser extends AbstractResponseParser<AbortMultipartUploadResult> {
        public final AbortMultipartUploadResult parseData(ae aeVar, AbortMultipartUploadResult abortMultipartUploadResult) throws IOException {
            return abortMultipartUploadResult;
        }
    }

    public static final class AppendObjectResponseParser extends AbstractResponseParser<AppendObjectResult> {
        public final AppendObjectResult parseData(ae aeVar, AppendObjectResult appendObjectResult) throws IOException {
            String a2 = aeVar.a(OSSHeaders.OSS_NEXT_APPEND_POSITION);
            if (a2 != null) {
                appendObjectResult.setNextPosition(Long.valueOf(a2));
            }
            appendObjectResult.setObjectCRC64(aeVar.a(OSSHeaders.OSS_HASH_CRC64_ECMA));
            return appendObjectResult;
        }
    }

    public static final class CompleteMultipartUploadResponseParser extends AbstractResponseParser<CompleteMultipartUploadResult> {
        public final CompleteMultipartUploadResult parseData(ae aeVar, CompleteMultipartUploadResult completeMultipartUploadResult) throws Exception {
            if (aeVar.a("Content-Type").equals("application/xml")) {
                return ResponseParsers.parseCompleteMultipartUploadResponseXML(aeVar.d().byteStream(), completeMultipartUploadResult);
            }
            if (aeVar.d() != null) {
                completeMultipartUploadResult.setServerCallbackReturnBody(aeVar.d().string());
            }
            return completeMultipartUploadResult;
        }
    }

    public static final class CopyObjectResponseParser extends AbstractResponseParser<CopyObjectResult> {
        public final CopyObjectResult parseData(ae aeVar, CopyObjectResult copyObjectResult) throws Exception {
            return ResponseParsers.parseCopyObjectResponseXML(aeVar.d().byteStream(), copyObjectResult);
        }
    }

    public static final class CreateBucketResponseParser extends AbstractResponseParser<CreateBucketResult> {
        public final CreateBucketResult parseData(ae aeVar, CreateBucketResult createBucketResult) throws IOException {
            if (createBucketResult.getResponseHeader().containsKey("Location")) {
                createBucketResult.bucketLocation = createBucketResult.getResponseHeader().get("Location");
            }
            return createBucketResult;
        }
    }

    public static final class DeleteBucketResponseParser extends AbstractResponseParser<DeleteBucketResult> {
        public final DeleteBucketResult parseData(ae aeVar, DeleteBucketResult deleteBucketResult) throws IOException {
            return deleteBucketResult;
        }
    }

    public static final class DeleteObjectResponseParser extends AbstractResponseParser<DeleteObjectResult> {
        public final DeleteObjectResult parseData(ae aeVar, DeleteObjectResult deleteObjectResult) throws IOException {
            return deleteObjectResult;
        }
    }

    public static final class GetBucketACLResponseParser extends AbstractResponseParser<GetBucketACLResult> {
        public final GetBucketACLResult parseData(ae aeVar, GetBucketACLResult getBucketACLResult) throws Exception {
            return ResponseParsers.parseGetBucketACLResponse(aeVar.d().byteStream(), getBucketACLResult);
        }
    }

    public static final class GetObjectResponseParser extends AbstractResponseParser<GetObjectResult> {
        public final boolean needCloseResponse() {
            return false;
        }

        public final GetObjectResult parseData(ae aeVar, GetObjectResult getObjectResult) throws IOException {
            getObjectResult.setMetadata(ResponseParsers.parseObjectMetadata(getObjectResult.getResponseHeader()));
            getObjectResult.setContentLength(aeVar.d().contentLength());
            getObjectResult.setObjectContent(aeVar.d().byteStream());
            return getObjectResult;
        }
    }

    public static final class HeadObjectResponseParser extends AbstractResponseParser<HeadObjectResult> {
        public final HeadObjectResult parseData(ae aeVar, HeadObjectResult headObjectResult) throws IOException {
            headObjectResult.setMetadata(ResponseParsers.parseObjectMetadata(headObjectResult.getResponseHeader()));
            return headObjectResult;
        }
    }

    public static final class InitMultipartResponseParser extends AbstractResponseParser<InitiateMultipartUploadResult> {
        public final InitiateMultipartUploadResult parseData(ae aeVar, InitiateMultipartUploadResult initiateMultipartUploadResult) throws Exception {
            return ResponseParsers.parseInitMultipartResponseXML(aeVar.d().byteStream(), initiateMultipartUploadResult);
        }
    }

    public static final class ListObjectsResponseParser extends AbstractResponseParser<ListObjectsResult> {
        public final ListObjectsResult parseData(ae aeVar, ListObjectsResult listObjectsResult) throws Exception {
            return ResponseParsers.parseObjectListResponse(aeVar.d().byteStream(), listObjectsResult);
        }
    }

    public static final class ListPartsResponseParser extends AbstractResponseParser<ListPartsResult> {
        public final ListPartsResult parseData(ae aeVar, ListPartsResult listPartsResult) throws Exception {
            return ResponseParsers.parseListPartsResponseXML(aeVar.d().byteStream(), listPartsResult);
        }
    }

    public static final class PutObjectResponseParser extends AbstractResponseParser<PutObjectResult> {
        public final PutObjectResult parseData(ae aeVar, PutObjectResult putObjectResult) throws IOException {
            putObjectResult.setETag(ResponseParsers.trimQuotes(aeVar.a("ETag")));
            if (aeVar.d().contentLength() > 0) {
                putObjectResult.setServerCallbackReturnBody(aeVar.d().string());
            }
            return putObjectResult;
        }
    }

    public static final class UploadPartResponseParser extends AbstractResponseParser<UploadPartResult> {
        public final UploadPartResult parseData(ae aeVar, UploadPartResult uploadPartResult) throws IOException {
            uploadPartResult.setETag(ResponseParsers.trimQuotes(aeVar.a("ETag")));
            return uploadPartResult;
        }
    }

    public static String checkChildNotNullAndGetValue(Node node) {
        if (node.getFirstChild() != null) {
            return node.getFirstChild().getNodeValue();
        }
        return null;
    }

    private static String parseCommonPrefixXML(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            String nodeName = item.getNodeName();
            if (nodeName != null && nodeName.equals("Prefix")) {
                return checkChildNotNullAndGetValue(item);
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    public static CompleteMultipartUploadResult parseCompleteMultipartUploadResponseXML(InputStream inputStream, CompleteMultipartUploadResult completeMultipartUploadResult) throws ParserConfigurationException, IOException, SAXException {
        Element documentElement = domFactory.newDocumentBuilder().parse(inputStream).getDocumentElement();
        OSSLog.logDebug("[item] - " + documentElement.getNodeName());
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            String nodeName = item.getNodeName();
            if (nodeName != null) {
                if (nodeName.equalsIgnoreCase("Location")) {
                    completeMultipartUploadResult.setLocation(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equalsIgnoreCase("Bucket")) {
                    completeMultipartUploadResult.setBucketName(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equalsIgnoreCase("Key")) {
                    completeMultipartUploadResult.setObjectKey(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equalsIgnoreCase("ETag")) {
                    completeMultipartUploadResult.setETag(checkChildNotNullAndGetValue(item));
                }
            }
        }
        return completeMultipartUploadResult;
    }

    /* access modifiers changed from: private */
    public static CopyObjectResult parseCopyObjectResponseXML(InputStream inputStream, CopyObjectResult copyObjectResult) throws ParseException, ParserConfigurationException, IOException, SAXException {
        Element documentElement = domFactory.newDocumentBuilder().parse(inputStream).getDocumentElement();
        OSSLog.logDebug("[item] - " + documentElement.getNodeName());
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            String nodeName = item.getNodeName();
            if (nodeName != null) {
                if (nodeName.equals("LastModified")) {
                    copyObjectResult.setLastModified(DateUtil.parseIso8601Date(checkChildNotNullAndGetValue(item)));
                } else if (nodeName.equals("ETag")) {
                    copyObjectResult.setEtag(checkChildNotNullAndGetValue(item));
                }
            }
        }
        return copyObjectResult;
    }

    /* access modifiers changed from: private */
    public static GetBucketACLResult parseGetBucketACLResponse(InputStream inputStream, GetBucketACLResult getBucketACLResult) throws ParserConfigurationException, IOException, SAXException, ParseException {
        Element documentElement = domFactory.newDocumentBuilder().parse(inputStream).getDocumentElement();
        OSSLog.logDebug("[parseGetBucketACLResponse - " + documentElement.getNodeName());
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            String nodeName = item.getNodeName();
            if (nodeName != null) {
                if (nodeName.equals("Owner")) {
                    NodeList childNodes2 = item.getChildNodes();
                    for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                        Node item2 = childNodes2.item(i2);
                        String nodeName2 = item2.getNodeName();
                        if (nodeName2 != null) {
                            if (nodeName2.equals("ID")) {
                                getBucketACLResult.setBucketOwnerID(checkChildNotNullAndGetValue(item2));
                            } else if (nodeName2.equals("DisplayName")) {
                                getBucketACLResult.setBucketOwner(checkChildNotNullAndGetValue(item2));
                            }
                        }
                    }
                } else if (nodeName.equals("AccessControlList")) {
                    NodeList childNodes3 = item.getChildNodes();
                    for (int i3 = 0; i3 < childNodes3.getLength(); i3++) {
                        Node item3 = childNodes3.item(i3);
                        String nodeName3 = item3.getNodeName();
                        if (nodeName3 != null && nodeName3.equals("Grant")) {
                            getBucketACLResult.setBucketACL(checkChildNotNullAndGetValue(item3));
                        }
                    }
                }
            }
        }
        return getBucketACLResult;
    }

    /* access modifiers changed from: private */
    public static InitiateMultipartUploadResult parseInitMultipartResponseXML(InputStream inputStream, InitiateMultipartUploadResult initiateMultipartUploadResult) throws IOException, SAXException, ParserConfigurationException {
        Element documentElement = domFactory.newDocumentBuilder().parse(inputStream).getDocumentElement();
        OSSLog.logDebug("[item] - " + documentElement.getNodeName());
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            String nodeName = item.getNodeName();
            if (nodeName != null) {
                if (nodeName.equalsIgnoreCase("UploadId")) {
                    initiateMultipartUploadResult.setUploadId(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equalsIgnoreCase("Bucket")) {
                    initiateMultipartUploadResult.setBucketName(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equalsIgnoreCase("Key")) {
                    initiateMultipartUploadResult.setObjectKey(checkChildNotNullAndGetValue(item));
                }
            }
        }
        return initiateMultipartUploadResult;
    }

    /* access modifiers changed from: private */
    public static ListPartsResult parseListPartsResponseXML(InputStream inputStream, ListPartsResult listPartsResult) throws ParserConfigurationException, IOException, SAXException, ParseException {
        String checkChildNotNullAndGetValue;
        Element documentElement = domFactory.newDocumentBuilder().parse(inputStream).getDocumentElement();
        OSSLog.logDebug("[parseObjectListResponse] - " + documentElement.getNodeName());
        ArrayList arrayList = new ArrayList();
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            String nodeName = item.getNodeName();
            if (nodeName != null) {
                if (nodeName.equals("Bucket")) {
                    listPartsResult.setBucketName(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equals("Key")) {
                    listPartsResult.setKey(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equals("UploadId")) {
                    listPartsResult.setUploadId(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equals("PartNumberMarker")) {
                    String checkChildNotNullAndGetValue2 = checkChildNotNullAndGetValue(item);
                    if (checkChildNotNullAndGetValue2 != null) {
                        listPartsResult.setPartNumberMarker(Integer.valueOf(checkChildNotNullAndGetValue2).intValue());
                    }
                } else if (nodeName.equals("NextPartNumberMarker")) {
                    String checkChildNotNullAndGetValue3 = checkChildNotNullAndGetValue(item);
                    if (checkChildNotNullAndGetValue3 != null) {
                        listPartsResult.setNextPartNumberMarker(Integer.valueOf(checkChildNotNullAndGetValue3).intValue());
                    }
                } else if (nodeName.equals("MaxParts")) {
                    String checkChildNotNullAndGetValue4 = checkChildNotNullAndGetValue(item);
                    if (checkChildNotNullAndGetValue4 != null) {
                        listPartsResult.setMaxParts(Integer.valueOf(checkChildNotNullAndGetValue4).intValue());
                    }
                } else if (nodeName.equals("IsTruncated")) {
                    String checkChildNotNullAndGetValue5 = checkChildNotNullAndGetValue(item);
                    if (checkChildNotNullAndGetValue5 != null) {
                        listPartsResult.setTruncated(Boolean.valueOf(checkChildNotNullAndGetValue5).booleanValue());
                    }
                } else if (nodeName.equals("StorageClass")) {
                    String checkChildNotNullAndGetValue6 = checkChildNotNullAndGetValue(item);
                    if (checkChildNotNullAndGetValue6 != null) {
                        listPartsResult.setStorageClass(checkChildNotNullAndGetValue6);
                    }
                } else if (nodeName.equals("Part")) {
                    NodeList childNodes2 = item.getChildNodes();
                    PartSummary partSummary = new PartSummary();
                    for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                        Node item2 = childNodes2.item(i2);
                        String nodeName2 = item2.getNodeName();
                        if (nodeName2 != null) {
                            if (nodeName2.equals("PartNumber")) {
                                String checkChildNotNullAndGetValue7 = checkChildNotNullAndGetValue(item2);
                                if (checkChildNotNullAndGetValue7 != null) {
                                    partSummary.setPartNumber(Integer.valueOf(checkChildNotNullAndGetValue7).intValue());
                                }
                            } else if (nodeName2.equals("LastModified")) {
                                partSummary.setLastModified(DateUtil.parseIso8601Date(checkChildNotNullAndGetValue(item2)));
                            } else if (nodeName2.equals("ETag")) {
                                partSummary.setETag(checkChildNotNullAndGetValue(item2));
                            } else if (nodeName2.equals("Size") && (checkChildNotNullAndGetValue = checkChildNotNullAndGetValue(item2)) != null) {
                                partSummary.setSize((long) Integer.valueOf(checkChildNotNullAndGetValue).intValue());
                            }
                        }
                    }
                    arrayList.add(partSummary);
                }
            }
        }
        listPartsResult.setParts(arrayList);
        return listPartsResult;
    }

    /* access modifiers changed from: private */
    public static ListObjectsResult parseObjectListResponse(InputStream inputStream, ListObjectsResult listObjectsResult) throws ParserConfigurationException, IOException, SAXException, ParseException {
        String parseCommonPrefixXML;
        Element documentElement = domFactory.newDocumentBuilder().parse(inputStream).getDocumentElement();
        OSSLog.logDebug("[parseObjectListResponse] - " + documentElement.getNodeName());
        listObjectsResult.clearCommonPrefixes();
        listObjectsResult.clearObjectSummaries();
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            String nodeName = item.getNodeName();
            if (nodeName != null) {
                if (nodeName.equals("Name")) {
                    listObjectsResult.setBucketName(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equals("Prefix")) {
                    listObjectsResult.setPrefix(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equals("Marker")) {
                    listObjectsResult.setMarker(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equals("Delimiter")) {
                    listObjectsResult.setDelimiter(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equals("EncodingType")) {
                    listObjectsResult.setEncodingType(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equals("MaxKeys")) {
                    String checkChildNotNullAndGetValue = checkChildNotNullAndGetValue(item);
                    if (checkChildNotNullAndGetValue != null) {
                        listObjectsResult.setMaxKeys(Integer.valueOf(checkChildNotNullAndGetValue).intValue());
                    }
                } else if (nodeName.equals("NextMarker")) {
                    listObjectsResult.setNextMarker(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equals("IsTruncated")) {
                    String checkChildNotNullAndGetValue2 = checkChildNotNullAndGetValue(item);
                    if (checkChildNotNullAndGetValue2 != null) {
                        listObjectsResult.setTruncated(Boolean.valueOf(checkChildNotNullAndGetValue2).booleanValue());
                    }
                } else if (nodeName.equals("Contents")) {
                    if (item.getChildNodes() != null) {
                        listObjectsResult.addObjectSummary(parseObjectSummaryXML(item.getChildNodes()));
                    }
                } else if (!(!nodeName.equals("CommonPrefixes") || item.getChildNodes() == null || (parseCommonPrefixXML = parseCommonPrefixXML(item.getChildNodes())) == null)) {
                    listObjectsResult.addCommonPrefix(parseCommonPrefixXML);
                }
            }
        }
        return listObjectsResult;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.sdk.android.oss.model.ObjectMetadata parseObjectMetadata(java.util.Map<java.lang.String, java.lang.String> r4) throws java.io.IOException {
        /*
            com.alibaba.sdk.android.oss.model.ObjectMetadata r0 = new com.alibaba.sdk.android.oss.model.ObjectMetadata     // Catch:{ Exception -> 0x0084 }
            r0.<init>()     // Catch:{ Exception -> 0x0084 }
            java.util.Set r1 = r4.keySet()     // Catch:{ Exception -> 0x0084 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0084 }
        L_0x000d:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0084 }
            if (r2 == 0) goto L_0x0083
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0084 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0084 }
            java.lang.String r3 = "x-oss-meta-"
            int r3 = r2.indexOf(r3)     // Catch:{ Exception -> 0x0084 }
            if (r3 < 0) goto L_0x002b
            java.lang.Object r3 = r4.get(r2)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0084 }
            r0.addUserMetadata(r2, r3)     // Catch:{ Exception -> 0x0084 }
            goto L_0x000d
        L_0x002b:
            java.lang.String r3 = "Last-Modified"
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x0084 }
            if (r3 != 0) goto L_0x006a
            java.lang.String r3 = "Date"
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x0084 }
            if (r3 == 0) goto L_0x003c
            goto L_0x006a
        L_0x003c:
            java.lang.String r3 = "Content-Length"
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x0084 }
            if (r3 == 0) goto L_0x0052
            java.lang.Object r3 = r4.get(r2)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0084 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x0084 }
        L_0x004e:
            r0.setHeader(r2, r3)     // Catch:{ Exception -> 0x0084 }
            goto L_0x000d
        L_0x0052:
            java.lang.String r3 = "ETag"
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x0084 }
            if (r3 == 0) goto L_0x0065
            java.lang.Object r3 = r4.get(r2)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0084 }
            java.lang.String r3 = trimQuotes(r3)     // Catch:{ Exception -> 0x0084 }
            goto L_0x004e
        L_0x0065:
            java.lang.Object r3 = r4.get(r2)     // Catch:{ Exception -> 0x0084 }
            goto L_0x004e
        L_0x006a:
            java.lang.Object r3 = r4.get(r2)     // Catch:{ ParseException -> 0x0078 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ ParseException -> 0x0078 }
            java.util.Date r3 = com.alibaba.sdk.android.oss.common.utils.DateUtil.parseRfc822Date(r3)     // Catch:{ ParseException -> 0x0078 }
            r0.setHeader(r2, r3)     // Catch:{ ParseException -> 0x0078 }
            goto L_0x000d
        L_0x0078:
            r4 = move-exception
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0084 }
            java.lang.String r1 = r4.getMessage()     // Catch:{ Exception -> 0x0084 }
            r0.<init>(r1, r4)     // Catch:{ Exception -> 0x0084 }
            throw r0     // Catch:{ Exception -> 0x0084 }
        L_0x0083:
            return r0
        L_0x0084:
            r4 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = r4.getMessage()
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResponseParsers.parseObjectMetadata(java.util.Map):com.alibaba.sdk.android.oss.model.ObjectMetadata");
    }

    private static OSSObjectSummary parseObjectSummaryXML(NodeList nodeList) throws ParseException {
        OSSObjectSummary oSSObjectSummary = new OSSObjectSummary();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            String nodeName = item.getNodeName();
            if (nodeName != null) {
                if (nodeName.equals("Key")) {
                    oSSObjectSummary.setKey(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equals("LastModified")) {
                    oSSObjectSummary.setLastModified(DateUtil.parseIso8601Date(checkChildNotNullAndGetValue(item)));
                } else if (nodeName.equals("Size")) {
                    String checkChildNotNullAndGetValue = checkChildNotNullAndGetValue(item);
                    if (checkChildNotNullAndGetValue != null) {
                        oSSObjectSummary.setSize((long) Integer.valueOf(checkChildNotNullAndGetValue).intValue());
                    }
                } else if (nodeName.equals("ETag")) {
                    oSSObjectSummary.setETag(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equals("Type")) {
                    oSSObjectSummary.setType(checkChildNotNullAndGetValue(item));
                } else if (nodeName.equals("StorageClass")) {
                    oSSObjectSummary.setStorageClass(checkChildNotNullAndGetValue(item));
                }
            }
        }
        return oSSObjectSummary;
    }

    public static ServiceException parseResponseErrorXML(ae aeVar, boolean z) throws IOException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int a2 = aeVar.a();
        String a3 = aeVar.a(OSSHeaders.OSS_HEADER_REQUEST_ID);
        String str8 = null;
        if (!z) {
            try {
                str5 = aeVar.d().string();
                try {
                    NodeList childNodes = domFactory.newDocumentBuilder().parse(new InputSource(new StringReader(str5))).getDocumentElement().getChildNodes();
                    int i = 0;
                    str6 = null;
                    str2 = null;
                    while (i < childNodes.getLength()) {
                        try {
                            Node item = childNodes.item(i);
                            String nodeName = item.getNodeName();
                            if (nodeName != null) {
                                if (nodeName.equals("Code")) {
                                    str8 = checkChildNotNullAndGetValue(item);
                                }
                                if (nodeName.equals(b.d)) {
                                    str6 = checkChildNotNullAndGetValue(item);
                                }
                                if (nodeName.equals("RequestId")) {
                                    a3 = checkChildNotNullAndGetValue(item);
                                }
                                if (nodeName.equals("HostId")) {
                                    str2 = checkChildNotNullAndGetValue(item);
                                }
                            }
                            i++;
                        } catch (SAXException e) {
                            e = e;
                            e.printStackTrace();
                            str = str5;
                            str4 = str8;
                            str8 = str6;
                            str3 = a3;
                            return new ServiceException(a2, str8, str4, str3, str2, str);
                        } catch (ParserConfigurationException e2) {
                            e = e2;
                            e.printStackTrace();
                            str = str5;
                            str4 = str8;
                            str8 = str6;
                            str3 = a3;
                            return new ServiceException(a2, str8, str4, str3, str2, str);
                        }
                    }
                } catch (SAXException e3) {
                    e = e3;
                    str7 = null;
                    str2 = str6;
                    e.printStackTrace();
                    str = str5;
                    str4 = str8;
                    str8 = str6;
                    str3 = a3;
                    return new ServiceException(a2, str8, str4, str3, str2, str);
                } catch (ParserConfigurationException e4) {
                    e = e4;
                    str6 = null;
                    str2 = str6;
                    e.printStackTrace();
                    str = str5;
                    str4 = str8;
                    str8 = str6;
                    str3 = a3;
                    return new ServiceException(a2, str8, str4, str3, str2, str);
                }
            } catch (SAXException e5) {
                e = e5;
                str5 = null;
                str7 = null;
                str2 = str6;
                e.printStackTrace();
                str = str5;
                str4 = str8;
                str8 = str6;
                str3 = a3;
                return new ServiceException(a2, str8, str4, str3, str2, str);
            } catch (ParserConfigurationException e6) {
                e = e6;
                str5 = null;
                str6 = null;
                str2 = str6;
                e.printStackTrace();
                str = str5;
                str4 = str8;
                str8 = str6;
                str3 = a3;
                return new ServiceException(a2, str8, str4, str3, str2, str);
            }
            str = str5;
            str4 = str8;
            str8 = str6;
            str3 = a3;
        } else {
            str3 = a3;
            str4 = null;
            str2 = null;
            str = null;
        }
        return new ServiceException(a2, str8, str4, str3, str2, str);
    }

    public static String trimQuotes(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("\"")) {
            trim = trim.substring(1);
        }
        return trim.endsWith("\"") ? trim.substring(0, trim.length() - 1) : trim;
    }
}

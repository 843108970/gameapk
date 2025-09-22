package com.alibaba.sdk.android.oss.network;

import b.z;
import com.alibaba.sdk.android.oss.internal.OSSRetryHandler;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParser;
import com.alibaba.sdk.android.oss.model.OSSResult;
import java.util.concurrent.Callable;

public class OSSRequestTask<T extends OSSResult> implements Callable<T> {
    private z client;
    private ExecutionContext context;
    private int currentRetryCount = 0;
    private RequestMessage message;
    private ResponseParser<T> responseParser;
    private OSSRetryHandler retryHandler;

    public OSSRequestTask(RequestMessage requestMessage, ResponseParser responseParser2, ExecutionContext executionContext, int i) {
        this.responseParser = responseParser2;
        this.message = requestMessage;
        this.context = executionContext;
        this.client = executionContext.getClient();
        this.retryHandler = new OSSRetryHandler(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.alibaba.sdk.android.oss.ClientException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.alibaba.sdk.android.oss.ClientException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.alibaba.sdk.android.oss.ClientException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.alibaba.sdk.android.oss.ClientException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: b.ae} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: b.ae} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: b.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: b.ae} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: b.ae} */
    /* JADX WARNING: type inference failed for: r2v0, types: [b.e] */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v31 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0264 A[SYNTHETIC, Splitter:B:73:0x0264] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02ea  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T call() throws java.lang.Exception {
        /*
            r13 = this;
            r0 = 1
            r1 = 0
            com.alibaba.sdk.android.oss.network.ExecutionContext r2 = r13.context     // Catch:{ Exception -> 0x0213 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x0213 }
            if (r2 == 0) goto L_0x0017
            com.alibaba.sdk.android.oss.network.ExecutionContext r2 = r13.context     // Catch:{ Exception -> 0x0213 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Exception -> 0x0213 }
            java.lang.String r2 = com.alibaba.sdk.android.oss.common.utils.OSSUtils.buildBaseLogInfo(r2)     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.common.OSSLog.logInfo(r2)     // Catch:{ Exception -> 0x0213 }
        L_0x0017:
            java.lang.String r2 = "[call] - "
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r2)     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.network.ExecutionContext r2 = r13.context     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.model.OSSRequest r2 = r2.getRequest()     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r13.message     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.common.utils.OSSUtils.ensureRequestValid(r2, r3)     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.internal.RequestMessage r3 = r13.message     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.common.utils.OSSUtils.signRequest(r3)     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.network.ExecutionContext r3 = r13.context     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.network.CancellationHandler r3 = r3.getCancellationHandler()     // Catch:{ Exception -> 0x0213 }
            boolean r3 = r3.isCancelled()     // Catch:{ Exception -> 0x0213 }
            if (r3 == 0) goto L_0x0040
            java.io.InterruptedIOException r2 = new java.io.InterruptedIOException     // Catch:{ Exception -> 0x0213 }
            java.lang.String r3 = "This task is cancelled!"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0213 }
            throw r2     // Catch:{ Exception -> 0x0213 }
        L_0x0040:
            b.ac$a r3 = new b.ac$a     // Catch:{ Exception -> 0x0213 }
            r3.<init>()     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.internal.RequestMessage r4 = r13.message     // Catch:{ Exception -> 0x0213 }
            java.lang.String r4 = r4.buildCanonicalURL()     // Catch:{ Exception -> 0x0213 }
            b.ac$a r3 = r3.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.internal.RequestMessage r4 = r13.message     // Catch:{ Exception -> 0x0213 }
            java.util.Map r4 = r4.getHeaders()     // Catch:{ Exception -> 0x0213 }
            java.util.Set r4 = r4.keySet()     // Catch:{ Exception -> 0x0213 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0213 }
        L_0x005d:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x0213 }
            if (r5 == 0) goto L_0x007a
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x0213 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.internal.RequestMessage r6 = r13.message     // Catch:{ Exception -> 0x0213 }
            java.util.Map r6 = r6.getHeaders()     // Catch:{ Exception -> 0x0213 }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ Exception -> 0x0213 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0213 }
            b.ac$a r3 = r3.b(r5, r6)     // Catch:{ Exception -> 0x0213 }
            goto L_0x005d
        L_0x007a:
            com.alibaba.sdk.android.oss.internal.RequestMessage r4 = r13.message     // Catch:{ Exception -> 0x0213 }
            java.util.Map r4 = r4.getHeaders()     // Catch:{ Exception -> 0x0213 }
            java.lang.String r5 = "Content-Type"
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x0213 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0213 }
            int[] r5 = com.alibaba.sdk.android.oss.network.OSSRequestTask.AnonymousClass1.$SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.internal.RequestMessage r6 = r13.message     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.common.HttpMethod r6 = r6.getMethod()     // Catch:{ Exception -> 0x0213 }
            int r6 = r6.ordinal()     // Catch:{ Exception -> 0x0213 }
            r5 = r5[r6]     // Catch:{ Exception -> 0x0213 }
            r6 = 0
            switch(r5) {
                case 1: goto L_0x00ae;
                case 2: goto L_0x00ae;
                case 3: goto L_0x00a8;
                case 4: goto L_0x00a2;
                case 5: goto L_0x009c;
                default: goto L_0x009a;
            }     // Catch:{ Exception -> 0x0213 }
        L_0x009a:
            goto L_0x0136
        L_0x009c:
            b.ac$a r3 = r3.c()     // Catch:{ Exception -> 0x0213 }
            goto L_0x0136
        L_0x00a2:
            b.ac$a r3 = r3.b()     // Catch:{ Exception -> 0x0213 }
            goto L_0x0136
        L_0x00a8:
            b.ac$a r3 = r3.a()     // Catch:{ Exception -> 0x0213 }
            goto L_0x0136
        L_0x00ae:
            if (r4 == 0) goto L_0x00b2
            r5 = 1
            goto L_0x00b3
        L_0x00b2:
            r5 = 0
        L_0x00b3:
            java.lang.String r7 = "Content type can't be null when upload!"
            com.alibaba.sdk.android.oss.common.utils.OSSUtils.assertTrue(r5, r7)     // Catch:{ Exception -> 0x0213 }
            r7 = 0
            com.alibaba.sdk.android.oss.internal.RequestMessage r5 = r13.message     // Catch:{ Exception -> 0x0213 }
            byte[] r5 = r5.getUploadData()     // Catch:{ Exception -> 0x0213 }
            if (r5 == 0) goto L_0x00d6
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.internal.RequestMessage r7 = r13.message     // Catch:{ Exception -> 0x0213 }
            byte[] r7 = r7.getUploadData()     // Catch:{ Exception -> 0x0213 }
            r5.<init>(r7)     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.internal.RequestMessage r7 = r13.message     // Catch:{ Exception -> 0x0213 }
            byte[] r7 = r7.getUploadData()     // Catch:{ Exception -> 0x0213 }
            int r7 = r7.length     // Catch:{ Exception -> 0x0213 }
            long r7 = (long) r7     // Catch:{ Exception -> 0x0213 }
            goto L_0x010b
        L_0x00d6:
            com.alibaba.sdk.android.oss.internal.RequestMessage r5 = r13.message     // Catch:{ Exception -> 0x0213 }
            java.lang.String r5 = r5.getUploadFilePath()     // Catch:{ Exception -> 0x0213 }
            if (r5 == 0) goto L_0x00f5
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.internal.RequestMessage r7 = r13.message     // Catch:{ Exception -> 0x0213 }
            java.lang.String r7 = r7.getUploadFilePath()     // Catch:{ Exception -> 0x0213 }
            r5.<init>(r7)     // Catch:{ Exception -> 0x0213 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0213 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x0213 }
            long r8 = r5.length()     // Catch:{ Exception -> 0x0213 }
            r5 = r7
            r7 = r8
            goto L_0x010b
        L_0x00f5:
            com.alibaba.sdk.android.oss.internal.RequestMessage r5 = r13.message     // Catch:{ Exception -> 0x0213 }
            java.io.InputStream r5 = r5.getUploadInputStream()     // Catch:{ Exception -> 0x0213 }
            if (r5 == 0) goto L_0x010a
            com.alibaba.sdk.android.oss.internal.RequestMessage r5 = r13.message     // Catch:{ Exception -> 0x0213 }
            java.io.InputStream r5 = r5.getUploadInputStream()     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.internal.RequestMessage r7 = r13.message     // Catch:{ Exception -> 0x0213 }
            long r7 = r7.getReadStreamLength()     // Catch:{ Exception -> 0x0213 }
            goto L_0x010b
        L_0x010a:
            r5 = r1
        L_0x010b:
            if (r5 == 0) goto L_0x0122
            com.alibaba.sdk.android.oss.internal.RequestMessage r9 = r13.message     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.common.HttpMethod r9 = r9.getMethod()     // Catch:{ Exception -> 0x0213 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.network.ExecutionContext r10 = r13.context     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.network.ProgressTouchableRequestBody r4 = com.alibaba.sdk.android.oss.network.NetworkProgressHelper.addProgressRequestBody(r5, r7, r4, r10)     // Catch:{ Exception -> 0x0213 }
            b.ac$a r3 = r3.a((java.lang.String) r9, (b.ad) r4)     // Catch:{ Exception -> 0x0213 }
            goto L_0x0136
        L_0x0122:
            com.alibaba.sdk.android.oss.internal.RequestMessage r4 = r13.message     // Catch:{ Exception -> 0x0213 }
            com.alibaba.sdk.android.oss.common.HttpMethod r4 = r4.getMethod()     // Catch:{ Exception -> 0x0213 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0213 }
            byte[] r5 = new byte[r6]     // Catch:{ Exception -> 0x0213 }
            b.ad r5 = b.ad.create((b.x) r1, (byte[]) r5)     // Catch:{ Exception -> 0x0213 }
            b.ac$a r3 = r3.a((java.lang.String) r4, (b.ad) r5)     // Catch:{ Exception -> 0x0213 }
        L_0x0136:
            b.ac r3 = r3.d()     // Catch:{ Exception -> 0x0213 }
            boolean r2 = r2 instanceof com.alibaba.sdk.android.oss.model.GetObjectRequest     // Catch:{ Exception -> 0x0210 }
            if (r2 == 0) goto L_0x014d
            b.z r2 = r13.client     // Catch:{ Exception -> 0x0210 }
            com.alibaba.sdk.android.oss.network.ExecutionContext r4 = r13.context     // Catch:{ Exception -> 0x0210 }
            b.z r2 = com.alibaba.sdk.android.oss.network.NetworkProgressHelper.addProgressResponseListener(r2, r4)     // Catch:{ Exception -> 0x0210 }
            r13.client = r2     // Catch:{ Exception -> 0x0210 }
            java.lang.String r2 = "getObject"
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r2)     // Catch:{ Exception -> 0x0210 }
        L_0x014d:
            b.z r2 = r13.client     // Catch:{ Exception -> 0x0210 }
            b.e r2 = r2.a((b.ac) r3)     // Catch:{ Exception -> 0x0210 }
            com.alibaba.sdk.android.oss.network.ExecutionContext r4 = r13.context     // Catch:{ Exception -> 0x020b }
            com.alibaba.sdk.android.oss.network.CancellationHandler r4 = r4.getCancellationHandler()     // Catch:{ Exception -> 0x020b }
            r4.setCall(r2)     // Catch:{ Exception -> 0x020b }
            b.ae r4 = r2.b()     // Catch:{ Exception -> 0x020b }
            b.u r5 = r4.c()     // Catch:{ Exception -> 0x0206 }
            java.util.Map r5 = r5.c()     // Catch:{ Exception -> 0x0206 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0206 }
            r7.<init>()     // Catch:{ Exception -> 0x0206 }
            java.lang.String r8 = "response:---------------------\n"
            r7.append(r8)     // Catch:{ Exception -> 0x0206 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0206 }
            java.lang.String r9 = "response code: "
            r8.<init>(r9)     // Catch:{ Exception -> 0x0206 }
            int r9 = r4.a()     // Catch:{ Exception -> 0x0206 }
            r8.append(r9)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r9 = " for url: "
            r8.append(r9)     // Catch:{ Exception -> 0x0206 }
            b.v r9 = r3.a()     // Catch:{ Exception -> 0x0206 }
            r8.append(r9)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r9 = "\n"
            r8.append(r9)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0206 }
            r7.append(r8)     // Catch:{ Exception -> 0x0206 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0206 }
            java.lang.String r9 = "response msg: "
            r8.<init>(r9)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r9 = r4.b()     // Catch:{ Exception -> 0x0206 }
            r8.append(r9)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r9 = "\n"
            r8.append(r9)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0206 }
            r7.append(r8)     // Catch:{ Exception -> 0x0206 }
            java.util.Set r8 = r5.keySet()     // Catch:{ Exception -> 0x0206 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x0206 }
        L_0x01ba:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x0206 }
            if (r9 == 0) goto L_0x01fd
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x0206 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0206 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0206 }
            java.lang.String r11 = "responseHeader ["
            r10.<init>(r11)     // Catch:{ Exception -> 0x0206 }
            r10.append(r9)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r11 = "]: "
            r10.append(r11)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0206 }
            r7.append(r10)     // Catch:{ Exception -> 0x0206 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0206 }
            r10.<init>()     // Catch:{ Exception -> 0x0206 }
            java.lang.Object r9 = r5.get(r9)     // Catch:{ Exception -> 0x0206 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ Exception -> 0x0206 }
            java.lang.Object r9 = r9.get(r6)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0206 }
            r10.append(r9)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r9 = "\n"
            r10.append(r9)     // Catch:{ Exception -> 0x0206 }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x0206 }
            r7.append(r9)     // Catch:{ Exception -> 0x0206 }
            goto L_0x01ba
        L_0x01fd:
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0206 }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r5)     // Catch:{ Exception -> 0x0206 }
            r6 = r1
            goto L_0x023f
        L_0x0206:
            r5 = move-exception
            r12 = r5
            r5 = r2
            r2 = r12
            goto L_0x0217
        L_0x020b:
            r4 = move-exception
            r5 = r2
            r2 = r4
            r4 = r1
            goto L_0x0217
        L_0x0210:
            r2 = move-exception
            r4 = r1
            goto L_0x0216
        L_0x0213:
            r2 = move-exception
            r3 = r1
            r4 = r3
        L_0x0216:
            r5 = r4
        L_0x0217:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Encounter local execpiton: "
            r6.<init>(r7)
            java.lang.String r7 = r2.toString()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.alibaba.sdk.android.oss.common.OSSLog.logError(r6)
            boolean r6 = com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()
            if (r6 == 0) goto L_0x0235
            r2.printStackTrace()
        L_0x0235:
            com.alibaba.sdk.android.oss.ClientException r6 = new com.alibaba.sdk.android.oss.ClientException
            java.lang.String r7 = r2.getMessage()
            r6.<init>(r7, r2)
            r2 = r5
        L_0x023f:
            if (r4 == 0) goto L_0x0252
            java.lang.String r5 = "Date"
            java.lang.String r5 = r4.a((java.lang.String) r5)
            java.util.Date r5 = com.alibaba.sdk.android.oss.common.utils.DateUtil.parseRfc822Date(r5)     // Catch:{ Exception -> 0x0252 }
            long r7 = r5.getTime()     // Catch:{ Exception -> 0x0252 }
            com.alibaba.sdk.android.oss.common.utils.DateUtil.setCurrentServerTime(r7)     // Catch:{ Exception -> 0x0252 }
        L_0x0252:
            if (r6 != 0) goto L_0x027e
            int r5 = r4.a()
            r7 = 203(0xcb, float:2.84E-43)
            if (r5 == r7) goto L_0x0264
            int r5 = r4.a()
            r7 = 300(0x12c, float:4.2E-43)
            if (r5 < r7) goto L_0x027e
        L_0x0264:
            java.lang.String r3 = r3.b()     // Catch:{ IOException -> 0x0273 }
            java.lang.String r5 = "HEAD"
            boolean r3 = r3.equals(r5)     // Catch:{ IOException -> 0x0273 }
            com.alibaba.sdk.android.oss.ServiceException r6 = com.alibaba.sdk.android.oss.internal.ResponseParsers.parseResponseErrorXML(r4, r3)     // Catch:{ IOException -> 0x0273 }
            goto L_0x02a8
        L_0x0273:
            r3 = move-exception
            com.alibaba.sdk.android.oss.ClientException r6 = new com.alibaba.sdk.android.oss.ClientException
            java.lang.String r5 = r3.getMessage()
            r6.<init>(r5, r3)
            goto L_0x02a8
        L_0x027e:
            if (r6 != 0) goto L_0x02a8
            com.alibaba.sdk.android.oss.internal.ResponseParser<T> r3 = r13.responseParser     // Catch:{ IOException -> 0x029e }
            com.alibaba.sdk.android.oss.model.OSSResult r3 = r3.parse(r4)     // Catch:{ IOException -> 0x029e }
            com.alibaba.sdk.android.oss.network.ExecutionContext r5 = r13.context     // Catch:{ IOException -> 0x029e }
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback r5 = r5.getCompletedCallback()     // Catch:{ IOException -> 0x029e }
            if (r5 == 0) goto L_0x029d
            com.alibaba.sdk.android.oss.network.ExecutionContext r5 = r13.context     // Catch:{ Exception -> 0x029d }
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback r5 = r5.getCompletedCallback()     // Catch:{ Exception -> 0x029d }
            com.alibaba.sdk.android.oss.network.ExecutionContext r6 = r13.context     // Catch:{ Exception -> 0x029d }
            com.alibaba.sdk.android.oss.model.OSSRequest r6 = r6.getRequest()     // Catch:{ Exception -> 0x029d }
            r5.onSuccess(r6, r3)     // Catch:{ Exception -> 0x029d }
        L_0x029d:
            return r3
        L_0x029e:
            r3 = move-exception
            com.alibaba.sdk.android.oss.ClientException r6 = new com.alibaba.sdk.android.oss.ClientException
            java.lang.String r5 = r3.getMessage()
            r6.<init>(r5, r3)
        L_0x02a8:
            if (r2 == 0) goto L_0x02b0
            boolean r2 = r2.e()
            if (r2 != 0) goto L_0x02bc
        L_0x02b0:
            com.alibaba.sdk.android.oss.network.ExecutionContext r2 = r13.context
            com.alibaba.sdk.android.oss.network.CancellationHandler r2 = r2.getCancellationHandler()
            boolean r2 = r2.isCancelled()
            if (r2 == 0) goto L_0x02cc
        L_0x02bc:
            com.alibaba.sdk.android.oss.ClientException r2 = new com.alibaba.sdk.android.oss.ClientException
            java.lang.String r3 = "Task is cancelled!"
            java.lang.Throwable r5 = r6.getCause()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)
            r2.<init>(r3, r5, r6)
            goto L_0x02cd
        L_0x02cc:
            r2 = r6
        L_0x02cd:
            com.alibaba.sdk.android.oss.internal.OSSRetryHandler r3 = r13.retryHandler
            int r5 = r13.currentRetryCount
            com.alibaba.sdk.android.oss.internal.OSSRetryType r3 = r3.shouldRetry(r2, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "[run] - retry, retry type: "
            r5.<init>(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            com.alibaba.sdk.android.oss.common.OSSLog.logError(r5)
            com.alibaba.sdk.android.oss.internal.OSSRetryType r5 = com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldRetry
            if (r3 != r5) goto L_0x0305
            int r1 = r13.currentRetryCount
            int r1 = r1 + r0
            r13.currentRetryCount = r1
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.alibaba.sdk.android.oss.callback.OSSRetryCallback r0 = r0.getRetryCallback()
            if (r0 == 0) goto L_0x0300
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.alibaba.sdk.android.oss.callback.OSSRetryCallback r0 = r0.getRetryCallback()
            r0.onRetryCallback()
        L_0x0300:
            com.alibaba.sdk.android.oss.model.OSSResult r0 = r13.call()
            return r0
        L_0x0305:
            com.alibaba.sdk.android.oss.internal.OSSRetryType r5 = com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry
            if (r3 != r5) goto L_0x0337
            if (r4 == 0) goto L_0x031c
            com.alibaba.sdk.android.oss.internal.RequestMessage r1 = r13.message
            java.util.Map r1 = r1.getHeaders()
            java.lang.String r2 = "Date"
            java.lang.String r3 = "Date"
            java.lang.String r3 = r4.a((java.lang.String) r3)
            r1.put(r2, r3)
        L_0x031c:
            int r1 = r13.currentRetryCount
            int r1 = r1 + r0
            r13.currentRetryCount = r1
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.alibaba.sdk.android.oss.callback.OSSRetryCallback r0 = r0.getRetryCallback()
            if (r0 == 0) goto L_0x0332
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.alibaba.sdk.android.oss.callback.OSSRetryCallback r0 = r0.getRetryCallback()
            r0.onRetryCallback()
        L_0x0332:
            com.alibaba.sdk.android.oss.model.OSSResult r0 = r13.call()
            return r0
        L_0x0337:
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.ClientException
            if (r0 == 0) goto L_0x0356
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback r0 = r0.getCompletedCallback()
            if (r0 == 0) goto L_0x0370
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback r0 = r0.getCompletedCallback()
            com.alibaba.sdk.android.oss.network.ExecutionContext r3 = r13.context
            com.alibaba.sdk.android.oss.model.OSSRequest r3 = r3.getRequest()
            r4 = r2
            com.alibaba.sdk.android.oss.ClientException r4 = (com.alibaba.sdk.android.oss.ClientException) r4
            r0.onFailure(r3, r4, r1)
            goto L_0x0370
        L_0x0356:
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback r0 = r0.getCompletedCallback()
            if (r0 == 0) goto L_0x0370
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r13.context
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback r0 = r0.getCompletedCallback()
            com.alibaba.sdk.android.oss.network.ExecutionContext r3 = r13.context
            com.alibaba.sdk.android.oss.model.OSSRequest r3 = r3.getRequest()
            r4 = r2
            com.alibaba.sdk.android.oss.ServiceException r4 = (com.alibaba.sdk.android.oss.ServiceException) r4
            r0.onFailure(r3, r1, r4)
        L_0x0370:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.network.OSSRequestTask.call():com.alibaba.sdk.android.oss.model.OSSResult");
    }
}

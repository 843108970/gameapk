package com.lidroid.xutils.http.client;

import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;

public class RetryHandler implements HttpRequestRetryHandler {
    private static final int RETRY_SLEEP_INTERVAL = 500;
    private static HashSet<Class<?>> exceptionBlackList = new HashSet<>();
    private static HashSet<Class<?>> exceptionWhiteList = new HashSet<>();
    private final int maxRetries;

    static {
        exceptionWhiteList.add(NoHttpResponseException.class);
        exceptionWhiteList.add(UnknownHostException.class);
        exceptionWhiteList.add(SocketException.class);
        exceptionBlackList.add(InterruptedIOException.class);
        exceptionBlackList.add(SSLHandshakeException.class);
    }

    public RetryHandler(int i) {
        this.maxRetries = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retryRequest(java.io.IOException r5, int r6, org.apache.http.protocol.HttpContext r7) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0073
            if (r7 != 0) goto L_0x0006
            return r0
        L_0x0006:
            java.lang.String r1 = "http.request_sent"
            java.lang.Object r1 = r7.getAttribute(r1)
            if (r1 != 0) goto L_0x0010
            r1 = 0
            goto L_0x0016
        L_0x0010:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
        L_0x0016:
            int r2 = r4.maxRetries
            r3 = 1
            if (r6 <= r2) goto L_0x001d
        L_0x001b:
            r3 = 0
            goto L_0x0034
        L_0x001d:
            java.util.HashSet<java.lang.Class<?>> r6 = exceptionBlackList
            java.lang.Class r2 = r5.getClass()
            boolean r6 = r6.contains(r2)
            if (r6 == 0) goto L_0x002a
            goto L_0x001b
        L_0x002a:
            java.util.HashSet<java.lang.Class<?>> r6 = exceptionWhiteList
            java.lang.Class r5 = r5.getClass()
            boolean r5 = r6.contains(r5)
        L_0x0034:
            if (r3 == 0) goto L_0x006a
            java.lang.String r5 = "http.request"
            java.lang.Object r5 = r7.getAttribute(r5)     // Catch:{ Throwable -> 0x0062 }
            if (r5 == 0) goto L_0x005c
            boolean r6 = r5 instanceof org.apache.http.client.methods.HttpRequestBase     // Catch:{ Throwable -> 0x0062 }
            if (r6 == 0) goto L_0x004f
            org.apache.http.client.methods.HttpRequestBase r5 = (org.apache.http.client.methods.HttpRequestBase) r5     // Catch:{ Throwable -> 0x0062 }
            java.lang.String r6 = "GET"
            java.lang.String r5 = r5.getMethod()     // Catch:{ Throwable -> 0x0062 }
        L_0x004a:
            boolean r5 = r6.equals(r5)     // Catch:{ Throwable -> 0x0062 }
            goto L_0x006b
        L_0x004f:
            boolean r6 = r5 instanceof org.apache.http.impl.client.RequestWrapper     // Catch:{ Throwable -> 0x0062 }
            if (r6 == 0) goto L_0x006a
            org.apache.http.impl.client.RequestWrapper r5 = (org.apache.http.impl.client.RequestWrapper) r5     // Catch:{ Throwable -> 0x0062 }
            java.lang.String r6 = "GET"
            java.lang.String r5 = r5.getMethod()     // Catch:{ Throwable -> 0x0062 }
            goto L_0x004a
        L_0x005c:
            java.lang.String r5 = "retry error, curr request is null"
            com.lidroid.xutils.util.LogUtils.e(r5)     // Catch:{ Throwable -> 0x0062 }
            goto L_0x0068
        L_0x0062:
            r5 = move-exception
            java.lang.String r6 = "retry error"
            com.lidroid.xutils.util.LogUtils.e(r6, r5)
        L_0x0068:
            r5 = 0
            goto L_0x006b
        L_0x006a:
            r5 = r3
        L_0x006b:
            if (r5 == 0) goto L_0x0072
            r6 = 500(0x1f4, double:2.47E-321)
            android.os.SystemClock.sleep(r6)
        L_0x0072:
            return r5
        L_0x0073:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.client.RetryHandler.retryRequest(java.io.IOException, int, org.apache.http.protocol.HttpContext):boolean");
    }
}

package com.umeng.commonsdk.stateless;

import android.content.Context;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private String f3857a = "10.0.0.172";

    /* renamed from: b  reason: collision with root package name */
    private int f3858b = 80;

    /* renamed from: c  reason: collision with root package name */
    private Context f3859c;

    public e(Context context) {
        this.f3859c = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        r0 = (r0 = r0.getActiveNetworkInfo()).getExtraInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a() {
        /*
            r4 = this;
            android.content.Context r0 = r4.f3859c
            r1 = 0
            if (r0 == 0) goto L_0x0061
            android.content.Context r0 = r4.f3859c
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            android.content.Context r3 = r4.f3859c
            java.lang.String r3 = r3.getPackageName()
            int r0 = r0.checkPermission(r2, r3)
            if (r0 == 0) goto L_0x001a
            return r1
        L_0x001a:
            android.content.Context r0 = r4.f3859c     // Catch:{ Throwable -> 0x005b }
            java.lang.String r2 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ Throwable -> 0x005b }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Throwable -> 0x005b }
            android.content.Context r2 = r4.f3859c     // Catch:{ Throwable -> 0x005b }
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r2 = com.umeng.commonsdk.statistics.common.DeviceConfig.checkPermission(r2, r3)     // Catch:{ Throwable -> 0x005b }
            if (r2 != 0) goto L_0x002f
            return r1
        L_0x002f:
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch:{ Throwable -> 0x005b }
            if (r0 == 0) goto L_0x0061
            int r2 = r0.getType()     // Catch:{ Throwable -> 0x005b }
            r3 = 1
            if (r2 == r3) goto L_0x0061
            java.lang.String r0 = r0.getExtraInfo()     // Catch:{ Throwable -> 0x005b }
            if (r0 == 0) goto L_0x0061
            java.lang.String r2 = "cmwap"
            boolean r2 = r0.equals(r2)     // Catch:{ Throwable -> 0x005b }
            if (r2 != 0) goto L_0x005a
            java.lang.String r2 = "3gwap"
            boolean r2 = r0.equals(r2)     // Catch:{ Throwable -> 0x005b }
            if (r2 != 0) goto L_0x005a
            java.lang.String r2 = "uniwap"
            boolean r0 = r0.equals(r2)     // Catch:{ Throwable -> 0x005b }
            if (r0 == 0) goto L_0x0061
        L_0x005a:
            return r3
        L_0x005b:
            r0 = move-exception
            android.content.Context r2 = r4.f3859c
            com.umeng.commonsdk.proguard.e.a(r2, r0)
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.e.a():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b3, code lost:
        if (r10 == null) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b5, code lost:
        r10.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b8, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d0, code lost:
        if (r10 == null) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d3, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cd A[SYNTHETIC, Splitter:B:36:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d7 A[SYNTHETIC, Splitter:B:43:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(byte[] r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            if (r9 == 0) goto L_0x00e0
            if (r10 != 0) goto L_0x0008
            goto L_0x00e0
        L_0x0008:
            r2 = 0
            boolean r3 = r8.a()     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            if (r3 == 0) goto L_0x0039
            java.net.Proxy r3 = new java.net.Proxy     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            java.net.Proxy$Type r4 = java.net.Proxy.Type.HTTP     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            java.lang.String r6 = r8.f3857a     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            int r7 = r8.f3858b     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            r5.<init>(r6, r7)     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            r3.<init>(r4, r5)     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            java.net.URL r4 = new java.net.URL     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            java.lang.String r6 = "https://plbslog.umeng.com/"
            r5.<init>(r6)     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            r5.append(r10)     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            java.lang.String r10 = r5.toString()     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            r4.<init>(r10)     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            java.net.URLConnection r10 = r4.openConnection(r3)     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
        L_0x0036:
            javax.net.ssl.HttpsURLConnection r10 = (javax.net.ssl.HttpsURLConnection) r10     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            goto L_0x0051
        L_0x0039:
            java.net.URL r3 = new java.net.URL     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            java.lang.String r5 = "https://plbslog.umeng.com/"
            r4.<init>(r5)     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            r4.append(r10)     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            java.lang.String r10 = r4.toString()     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            r3.<init>(r10)     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            java.net.URLConnection r10 = r3.openConnection()     // Catch:{ Throwable -> 0x00c4, all -> 0x00c1 }
            goto L_0x0036
        L_0x0051:
            com.umeng.commonsdk.stateless.e$1 r3 = new com.umeng.commonsdk.stateless.e$1     // Catch:{ Throwable -> 0x00bf }
            r3.<init>()     // Catch:{ Throwable -> 0x00bf }
            javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(r3)     // Catch:{ Throwable -> 0x00bf }
            java.lang.String r3 = "TLS"
            javax.net.ssl.SSLContext r3 = javax.net.ssl.SSLContext.getInstance(r3)     // Catch:{ Throwable -> 0x00bf }
            java.security.SecureRandom r4 = new java.security.SecureRandom     // Catch:{ Throwable -> 0x00bf }
            r4.<init>()     // Catch:{ Throwable -> 0x00bf }
            r3.init(r2, r2, r4)     // Catch:{ Throwable -> 0x00bf }
            javax.net.ssl.SSLSocketFactory r3 = r3.getSocketFactory()     // Catch:{ Throwable -> 0x00bf }
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r3)     // Catch:{ Throwable -> 0x00bf }
            java.lang.String r3 = "X-Umeng-UTC"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x00bf }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Throwable -> 0x00bf }
            r10.setRequestProperty(r3, r4)     // Catch:{ Throwable -> 0x00bf }
            java.lang.String r3 = "Msg-Type"
            java.lang.String r4 = "envelope/json"
            r10.setRequestProperty(r3, r4)     // Catch:{ Throwable -> 0x00bf }
            r3 = 30000(0x7530, float:4.2039E-41)
            r10.setConnectTimeout(r3)     // Catch:{ Throwable -> 0x00bf }
            r10.setReadTimeout(r3)     // Catch:{ Throwable -> 0x00bf }
            java.lang.String r3 = "POST"
            r10.setRequestMethod(r3)     // Catch:{ Throwable -> 0x00bf }
            r10.setDoOutput(r0)     // Catch:{ Throwable -> 0x00bf }
            r10.setDoInput(r0)     // Catch:{ Throwable -> 0x00bf }
            r10.setUseCaches(r1)     // Catch:{ Throwable -> 0x00bf }
            java.io.OutputStream r3 = r10.getOutputStream()     // Catch:{ Throwable -> 0x00bf }
            r3.write(r9)     // Catch:{ Throwable -> 0x00bc, all -> 0x00b9 }
            r3.flush()     // Catch:{ Throwable -> 0x00bc, all -> 0x00b9 }
            r10.connect()     // Catch:{ Throwable -> 0x00bc, all -> 0x00b9 }
            int r9 = r10.getResponseCode()     // Catch:{ Throwable -> 0x00bc, all -> 0x00b9 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r9 != r2) goto L_0x00ae
            r1 = 1
        L_0x00ae:
            if (r3 == 0) goto L_0x00b3
            r3.close()     // Catch:{ Exception -> 0x00b3 }
        L_0x00b3:
            if (r10 == 0) goto L_0x00d3
        L_0x00b5:
            r10.disconnect()
            return r1
        L_0x00b9:
            r9 = move-exception
            r2 = r3
            goto L_0x00d5
        L_0x00bc:
            r9 = move-exception
            r2 = r3
            goto L_0x00c6
        L_0x00bf:
            r9 = move-exception
            goto L_0x00c6
        L_0x00c1:
            r9 = move-exception
            r10 = r2
            goto L_0x00d5
        L_0x00c4:
            r9 = move-exception
            r10 = r2
        L_0x00c6:
            android.content.Context r0 = r8.f3859c     // Catch:{ all -> 0x00d4 }
            com.umeng.commonsdk.proguard.e.a(r0, r9)     // Catch:{ all -> 0x00d4 }
            if (r2 == 0) goto L_0x00d0
            r2.close()     // Catch:{ Exception -> 0x00d0 }
        L_0x00d0:
            if (r10 == 0) goto L_0x00d3
            goto L_0x00b5
        L_0x00d3:
            return r1
        L_0x00d4:
            r9 = move-exception
        L_0x00d5:
            if (r2 == 0) goto L_0x00da
            r2.close()     // Catch:{ Exception -> 0x00da }
        L_0x00da:
            if (r10 == 0) goto L_0x00df
            r10.disconnect()
        L_0x00df:
            throw r9
        L_0x00e0:
            java.lang.String r9 = "walle"
            java.lang.Object[] r10 = new java.lang.Object[r0]
            java.lang.String r0 = "[stateless] sendMessage, envelopeByte == null || path == null "
            r10[r1] = r0
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r9, (java.lang.Object[]) r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.e.a(byte[], java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0095, code lost:
        if (r9 == null) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0097, code lost:
        r9.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b2, code lost:
        if (r9 == null) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b5, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00af A[SYNTHETIC, Splitter:B:38:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b9 A[SYNTHETIC, Splitter:B:45:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(byte[] r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x00c2
            if (r9 != 0) goto L_0x0006
            return r0
        L_0x0006:
            r1 = 0
            boolean r2 = r7.a()     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            if (r2 == 0) goto L_0x0037
            java.net.Proxy r2 = new java.net.Proxy     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            java.net.Proxy$Type r3 = java.net.Proxy.Type.HTTP     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            java.net.InetSocketAddress r4 = new java.net.InetSocketAddress     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            java.lang.String r5 = r7.f3857a     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            int r6 = r7.f3858b     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            r4.<init>(r5, r6)     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            r2.<init>(r3, r4)     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            java.net.URL r3 = new java.net.URL     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            java.lang.String r5 = "https://plbslog.umeng.com/"
            r4.<init>(r5)     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            r4.append(r9)     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            java.lang.String r9 = r4.toString()     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            r3.<init>(r9)     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            java.net.URLConnection r9 = r3.openConnection(r2)     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
        L_0x0034:
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            goto L_0x004f
        L_0x0037:
            java.net.URL r2 = new java.net.URL     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            java.lang.String r4 = "https://plbslog.umeng.com/"
            r3.<init>(r4)     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            r3.append(r9)     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            java.lang.String r9 = r3.toString()     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            r2.<init>(r9)     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            java.net.URLConnection r9 = r2.openConnection()     // Catch:{ Throwable -> 0x00a6, all -> 0x00a3 }
            goto L_0x0034
        L_0x004f:
            java.lang.String r2 = "X-Umeng-UTC"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x00a1 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Throwable -> 0x00a1 }
            r9.setRequestProperty(r2, r3)     // Catch:{ Throwable -> 0x00a1 }
            java.lang.String r2 = "Msg-Type"
            java.lang.String r3 = "envelope/json"
            r9.setRequestProperty(r2, r3)     // Catch:{ Throwable -> 0x00a1 }
            r2 = 30000(0x7530, float:4.2039E-41)
            r9.setConnectTimeout(r2)     // Catch:{ Throwable -> 0x00a1 }
            r9.setReadTimeout(r2)     // Catch:{ Throwable -> 0x00a1 }
            java.lang.String r2 = "POST"
            r9.setRequestMethod(r2)     // Catch:{ Throwable -> 0x00a1 }
            r2 = 1
            r9.setDoOutput(r2)     // Catch:{ Throwable -> 0x00a1 }
            r9.setDoInput(r2)     // Catch:{ Throwable -> 0x00a1 }
            r9.setUseCaches(r0)     // Catch:{ Throwable -> 0x00a1 }
            java.io.OutputStream r3 = r9.getOutputStream()     // Catch:{ Throwable -> 0x00a1 }
            r3.write(r8)     // Catch:{ Throwable -> 0x009e, all -> 0x009b }
            r3.flush()     // Catch:{ Throwable -> 0x009e, all -> 0x009b }
            r9.connect()     // Catch:{ Throwable -> 0x009e, all -> 0x009b }
            int r8 = r9.getResponseCode()     // Catch:{ Throwable -> 0x009e, all -> 0x009b }
            r1 = 200(0xc8, float:2.8E-43)
            if (r8 != r1) goto L_0x0090
            r0 = 1
        L_0x0090:
            if (r3 == 0) goto L_0x0095
            r3.close()     // Catch:{ Exception -> 0x0095 }
        L_0x0095:
            if (r9 == 0) goto L_0x00b5
        L_0x0097:
            r9.disconnect()
            return r0
        L_0x009b:
            r8 = move-exception
            r1 = r3
            goto L_0x00b7
        L_0x009e:
            r8 = move-exception
            r1 = r3
            goto L_0x00a8
        L_0x00a1:
            r8 = move-exception
            goto L_0x00a8
        L_0x00a3:
            r8 = move-exception
            r9 = r1
            goto L_0x00b7
        L_0x00a6:
            r8 = move-exception
            r9 = r1
        L_0x00a8:
            android.content.Context r2 = r7.f3859c     // Catch:{ all -> 0x00b6 }
            com.umeng.commonsdk.proguard.e.a(r2, r8)     // Catch:{ all -> 0x00b6 }
            if (r1 == 0) goto L_0x00b2
            r1.close()     // Catch:{ Exception -> 0x00b2 }
        L_0x00b2:
            if (r9 == 0) goto L_0x00b5
            goto L_0x0097
        L_0x00b5:
            return r0
        L_0x00b6:
            r8 = move-exception
        L_0x00b7:
            if (r1 == 0) goto L_0x00bc
            r1.close()     // Catch:{ Exception -> 0x00bc }
        L_0x00bc:
            if (r9 == 0) goto L_0x00c1
            r9.disconnect()
        L_0x00c1:
            throw r8
        L_0x00c2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.e.b(byte[], java.lang.String):boolean");
    }
}

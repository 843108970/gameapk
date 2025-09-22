package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.noise.ABTest;

public class c {
    private static boolean e = false;

    /* renamed from: a  reason: collision with root package name */
    private String f3948a = "10.0.0.172";

    /* renamed from: b  reason: collision with root package name */
    private int f3949b = 80;

    /* renamed from: c  reason: collision with root package name */
    private Context f3950c;
    private b d;

    public c(Context context) {
        this.f3950c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f3950c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f3950c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        b.e = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        int testPolicy = ABTest.getService(this.f3950c).getTestPolicy();
        if (testPolicy == -1) {
            return;
        }
        if (testPolicy == 0) {
            b.e = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        } else if (testPolicy == 1) {
            b.e = new String[]{UMServerURL.SECONDARY_URL, UMServerURL.DEFAULT_URL};
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        r0 = (r0 = r0.getActiveNetworkInfo()).getExtraInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b() {
        /*
            r4 = this;
            android.content.Context r0 = r4.f3950c
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            android.content.Context r2 = r4.f3950c
            java.lang.String r2 = r2.getPackageName()
            int r0 = r0.checkPermission(r1, r2)
            r1 = 0
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            android.content.Context r0 = r4.f3950c     // Catch:{ Throwable -> 0x0057 }
            java.lang.String r2 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ Throwable -> 0x0057 }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ Throwable -> 0x0057 }
            android.content.Context r2 = r4.f3950c     // Catch:{ Throwable -> 0x0057 }
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r2 = com.umeng.commonsdk.statistics.common.DeviceConfig.checkPermission(r2, r3)     // Catch:{ Throwable -> 0x0057 }
            if (r2 != 0) goto L_0x002b
            return r1
        L_0x002b:
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch:{ Throwable -> 0x0057 }
            if (r0 == 0) goto L_0x005d
            int r2 = r0.getType()     // Catch:{ Throwable -> 0x0057 }
            r3 = 1
            if (r2 == r3) goto L_0x005d
            java.lang.String r0 = r0.getExtraInfo()     // Catch:{ Throwable -> 0x0057 }
            if (r0 == 0) goto L_0x005d
            java.lang.String r2 = "cmwap"
            boolean r2 = r0.equals(r2)     // Catch:{ Throwable -> 0x0057 }
            if (r2 != 0) goto L_0x0056
            java.lang.String r2 = "3gwap"
            boolean r2 = r0.equals(r2)     // Catch:{ Throwable -> 0x0057 }
            if (r2 != 0) goto L_0x0056
            java.lang.String r2 = "uniwap"
            boolean r0 = r0.equals(r2)     // Catch:{ Throwable -> 0x0057 }
            if (r0 == 0) goto L_0x005d
        L_0x0056:
            return r3
        L_0x0057:
            r0 = move-exception
            android.content.Context r2 = r4.f3950c
            com.umeng.commonsdk.proguard.e.a(r2, r0)
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.internal.c.b():boolean");
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0145 A[SYNTHETIC, Splitter:B:65:0x0145] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0152 A[SYNTHETIC, Splitter:B:74:0x0152] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0157  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a(byte[] r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 0
            com.umeng.commonsdk.statistics.internal.b r1 = r6.d     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            if (r1 == 0) goto L_0x000a
            com.umeng.commonsdk.statistics.internal.b r1 = r6.d     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            r1.onRequestStart()     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
        L_0x000a:
            boolean r1 = r6.b()     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            if (r1 == 0) goto L_0x002c
            java.net.Proxy r1 = new java.net.Proxy     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            java.net.Proxy$Type r2 = java.net.Proxy.Type.HTTP     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            java.net.InetSocketAddress r3 = new java.net.InetSocketAddress     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            java.lang.String r4 = r6.f3948a     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            int r5 = r6.f3949b     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            r3.<init>(r4, r5)     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            r1.<init>(r2, r3)     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            java.net.URL r2 = new java.net.URL     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            r2.<init>(r8)     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            java.net.URLConnection r8 = r2.openConnection(r1)     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
        L_0x0029:
            javax.net.ssl.HttpsURLConnection r8 = (javax.net.ssl.HttpsURLConnection) r8     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            goto L_0x0036
        L_0x002c:
            java.net.URL r1 = new java.net.URL     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            r1.<init>(r8)     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            java.net.URLConnection r8 = r1.openConnection()     // Catch:{ Throwable -> 0x0136, all -> 0x0133 }
            goto L_0x0029
        L_0x0036:
            boolean r1 = e     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r2 = 1
            if (r1 != 0) goto L_0x005a
            com.umeng.commonsdk.statistics.internal.c$1 r1 = new com.umeng.commonsdk.statistics.internal.c$1     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r1.<init>()     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(r1)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            java.lang.String r1 = "TLS"
            javax.net.ssl.SSLContext r1 = javax.net.ssl.SSLContext.getInstance(r1)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            java.security.SecureRandom r3 = new java.security.SecureRandom     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r3.<init>()     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r1.init(r0, r0, r3)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            javax.net.ssl.SSLSocketFactory r1 = r1.getSocketFactory()     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r1)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            e = r2     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
        L_0x005a:
            java.lang.String r1 = "X-Umeng-UTC"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r8.setRequestProperty(r1, r3)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            java.lang.String r1 = "X-Umeng-Sdk"
            android.content.Context r3 = r6.f3950c     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            com.umeng.commonsdk.statistics.internal.a r3 = com.umeng.commonsdk.statistics.internal.a.a((android.content.Context) r3)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            java.lang.String r3 = r3.b()     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r8.setRequestProperty(r1, r3)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            java.lang.String r1 = "Content-Type"
            android.content.Context r3 = r6.f3950c     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            com.umeng.commonsdk.statistics.internal.a r3 = com.umeng.commonsdk.statistics.internal.a.a((android.content.Context) r3)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            java.lang.String r3 = r3.a()     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r8.setRequestProperty(r1, r3)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            java.lang.String r1 = "Msg-Type"
            java.lang.String r3 = "envelope/json"
            r8.setRequestProperty(r1, r3)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r1 = 30000(0x7530, float:4.2039E-41)
            r8.setConnectTimeout(r1)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r8.setReadTimeout(r1)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            java.lang.String r1 = "POST"
            r8.setRequestMethod(r1)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r8.setDoOutput(r2)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r8.setDoInput(r2)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r1 = 0
            r8.setUseCaches(r1)     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            java.io.OutputStream r3 = r8.getOutputStream()     // Catch:{ Throwable -> 0x0130, all -> 0x012e }
            r3.write(r7)     // Catch:{ Throwable -> 0x012c }
            r3.flush()     // Catch:{ Throwable -> 0x012c }
            r8.connect()     // Catch:{ Throwable -> 0x012c }
            com.umeng.commonsdk.statistics.internal.b r7 = r6.d     // Catch:{ Throwable -> 0x012c }
            if (r7 == 0) goto L_0x00b9
            com.umeng.commonsdk.statistics.internal.b r7 = r6.d     // Catch:{ Throwable -> 0x012c }
            r7.onRequestEnd()     // Catch:{ Throwable -> 0x012c }
        L_0x00b9:
            int r7 = r8.getResponseCode()     // Catch:{ Throwable -> 0x012c }
            java.lang.String r4 = "Content-Type"
            java.lang.String r4 = r8.getHeaderField(r4)     // Catch:{ Throwable -> 0x012c }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x012c }
            if (r5 != 0) goto L_0x00d2
            java.lang.String r5 = "application/thrift"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Throwable -> 0x012c }
            if (r4 == 0) goto L_0x00d2
            r1 = 1
        L_0x00d2:
            boolean r2 = com.umeng.commonsdk.statistics.b.f     // Catch:{ Throwable -> 0x012c }
            if (r2 == 0) goto L_0x00ef
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x012c }
            java.lang.String r4 = "status code : "
            r2.<init>(r4)     // Catch:{ Throwable -> 0x012c }
            r2.append(r7)     // Catch:{ Throwable -> 0x012c }
            java.lang.String r4 = "; isThrifit:"
            r2.append(r4)     // Catch:{ Throwable -> 0x012c }
            r2.append(r1)     // Catch:{ Throwable -> 0x012c }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x012c }
            com.umeng.commonsdk.statistics.common.MLog.d((java.lang.String) r2)     // Catch:{ Throwable -> 0x012c }
        L_0x00ef:
            r2 = 200(0xc8, float:2.8E-43)
            if (r7 != r2) goto L_0x0121
            if (r1 == 0) goto L_0x0121
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x012c }
            java.lang.String r2 = "Send message to server. status code is: "
            r1.<init>(r2)     // Catch:{ Throwable -> 0x012c }
            r1.append(r7)     // Catch:{ Throwable -> 0x012c }
            java.lang.String r7 = r1.toString()     // Catch:{ Throwable -> 0x012c }
            com.umeng.commonsdk.statistics.common.MLog.i((java.lang.String) r7)     // Catch:{ Throwable -> 0x012c }
            java.io.InputStream r7 = r8.getInputStream()     // Catch:{ Throwable -> 0x012c }
            byte[] r1 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r7)     // Catch:{ all -> 0x011c }
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r7)     // Catch:{ Throwable -> 0x012c }
            if (r3 == 0) goto L_0x0116
            r3.close()     // Catch:{ Exception -> 0x0116 }
        L_0x0116:
            if (r8 == 0) goto L_0x011b
            r8.disconnect()
        L_0x011b:
            return r1
        L_0x011c:
            r1 = move-exception
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r7)     // Catch:{ Throwable -> 0x012c }
            throw r1     // Catch:{ Throwable -> 0x012c }
        L_0x0121:
            if (r3 == 0) goto L_0x0126
            r3.close()     // Catch:{ Exception -> 0x0126 }
        L_0x0126:
            if (r8 == 0) goto L_0x012b
            r8.disconnect()
        L_0x012b:
            return r0
        L_0x012c:
            r7 = move-exception
            goto L_0x0139
        L_0x012e:
            r7 = move-exception
            goto L_0x0150
        L_0x0130:
            r7 = move-exception
            r3 = r0
            goto L_0x0139
        L_0x0133:
            r7 = move-exception
            r8 = r0
            goto L_0x0150
        L_0x0136:
            r7 = move-exception
            r8 = r0
            r3 = r8
        L_0x0139:
            java.lang.String r1 = "IOException,Failed to send message."
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r1, (java.lang.Throwable) r7)     // Catch:{ all -> 0x014e }
            android.content.Context r1 = r6.f3950c     // Catch:{ all -> 0x014e }
            com.umeng.commonsdk.proguard.e.a(r1, r7)     // Catch:{ all -> 0x014e }
            if (r3 == 0) goto L_0x0148
            r3.close()     // Catch:{ Exception -> 0x0148 }
        L_0x0148:
            if (r8 == 0) goto L_0x014d
            r8.disconnect()
        L_0x014d:
            return r0
        L_0x014e:
            r7 = move-exception
            r0 = r3
        L_0x0150:
            if (r0 == 0) goto L_0x0155
            r0.close()     // Catch:{ Exception -> 0x0155 }
        L_0x0155:
            if (r8 == 0) goto L_0x015a
            r8.disconnect()
        L_0x015a:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.internal.c.a(byte[], java.lang.String):byte[]");
    }

    public byte[] a(byte[] bArr, boolean z) {
        a();
        byte[] bArr2 = null;
        int i = 0;
        while (true) {
            if (i >= b.e.length) {
                break;
            }
            bArr2 = a(bArr, b.e[i]);
            if (bArr2 == null) {
                if (this.d != null) {
                    this.d.onRequestFailed();
                }
                i++;
            } else if (this.d != null) {
                this.d.onRequestSucceed(z);
                return bArr2;
            }
        }
        return bArr2;
    }
}

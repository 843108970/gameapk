package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private static String f3824a = "239.192.152.163";

    /* renamed from: b  reason: collision with root package name */
    private static int f3825b = 48809;

    /* renamed from: c  reason: collision with root package name */
    private WifiManager.MulticastLock f3826c;
    private WifiManager d;
    private Context e;

    public u(Context context) {
        if (context != null) {
            this.e = context;
            this.d = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        }
    }

    private void a() {
        try {
            if (this.d != null) {
                this.f3826c = this.d.createMulticastLock("multicast.test");
                if (this.f3826c != null) {
                    this.f3826c.acquire();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Context context) {
        String uMIDString = UMConfigure.getUMIDString(context);
        if (!TextUtils.isEmpty(uMIDString)) {
            a(context, uMIDString);
        }
    }

    private static void a(Context context, String str) {
        a(context, f3824a, f3825b, str);
    }

    private static void a(Context context, String str, int i, String str2) {
        new u(context).a(str, i, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004d A[SYNTHETIC, Splitter:B:23:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005b A[Catch:{ Exception -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0063 A[SYNTHETIC, Splitter:B:33:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0071 A[Catch:{ Exception -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r4, int r5, java.lang.String r6) {
        /*
            r3 = this;
            r3.a()
            r0 = 0
            java.net.MulticastSocket r1 = new java.net.MulticastSocket     // Catch:{ Exception -> 0x0045 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0045 }
            java.net.InetAddress r0 = java.net.InetAddress.getByName(r4)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            r1.joinGroup(r0)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            r0 = 1
            r1.setLoopbackMode(r0)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            java.net.DatagramPacket r0 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            byte[] r2 = r6.getBytes()     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            byte[] r6 = r6.getBytes()     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            int r6 = r6.length     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            java.net.InetAddress r4 = java.net.InetAddress.getByName(r4)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            r0.<init>(r2, r6, r4, r5)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            r1.send(r0)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            r1.close()     // Catch:{ Exception -> 0x002d }
            goto L_0x0033
        L_0x002d:
            r4 = move-exception
            android.content.Context r5 = r3.e
            com.umeng.commonsdk.proguard.e.a(r5, r4)
        L_0x0033:
            android.net.wifi.WifiManager$MulticastLock r4 = r3.f3826c     // Catch:{ Exception -> 0x003c }
            if (r4 == 0) goto L_0x003c
            android.net.wifi.WifiManager$MulticastLock r4 = r3.f3826c     // Catch:{ Exception -> 0x003c }
            r4.release()     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            return
        L_0x003d:
            r4 = move-exception
            goto L_0x0061
        L_0x003f:
            r4 = move-exception
            r0 = r1
            goto L_0x0046
        L_0x0042:
            r4 = move-exception
            r1 = r0
            goto L_0x0061
        L_0x0045:
            r4 = move-exception
        L_0x0046:
            android.content.Context r5 = r3.e     // Catch:{ all -> 0x0042 }
            com.umeng.commonsdk.proguard.e.a(r5, r4)     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0057
            r0.close()     // Catch:{ Exception -> 0x0051 }
            goto L_0x0057
        L_0x0051:
            r4 = move-exception
            android.content.Context r5 = r3.e
            com.umeng.commonsdk.proguard.e.a(r5, r4)
        L_0x0057:
            android.net.wifi.WifiManager$MulticastLock r4 = r3.f3826c     // Catch:{ Exception -> 0x0060 }
            if (r4 == 0) goto L_0x0060
            android.net.wifi.WifiManager$MulticastLock r4 = r3.f3826c     // Catch:{ Exception -> 0x0060 }
            r4.release()     // Catch:{ Exception -> 0x0060 }
        L_0x0060:
            return
        L_0x0061:
            if (r1 == 0) goto L_0x006d
            r1.close()     // Catch:{ Exception -> 0x0067 }
            goto L_0x006d
        L_0x0067:
            r5 = move-exception
            android.content.Context r6 = r3.e
            com.umeng.commonsdk.proguard.e.a(r6, r5)
        L_0x006d:
            android.net.wifi.WifiManager$MulticastLock r5 = r3.f3826c     // Catch:{ Exception -> 0x0076 }
            if (r5 == 0) goto L_0x0076
            android.net.wifi.WifiManager$MulticastLock r5 = r3.f3826c     // Catch:{ Exception -> 0x0076 }
            r5.release()     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.u.a(java.lang.String, int, java.lang.String):void");
    }
}

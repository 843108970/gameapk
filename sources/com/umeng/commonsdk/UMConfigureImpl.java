package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.amap.UMAmapConfig;
import com.umeng.commonsdk.amap.b;
import com.umeng.commonsdk.framework.c;
import com.umeng.commonsdk.proguard.d;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.proguard.h;
import com.umeng.commonsdk.proguard.j;
import com.umeng.commonsdk.proguard.k;
import com.umeng.commonsdk.proguard.l;
import com.umeng.commonsdk.proguard.r;
import com.umeng.commonsdk.proguard.t;
import com.umeng.commonsdk.stateless.UMSLEnvelopeBuild;
import org.json.JSONObject;

public class UMConfigureImpl {

    /* renamed from: a  reason: collision with root package name */
    private static b f3654a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3655b = false;

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void a(android.content.Context r8) {
        /*
            java.lang.Class<com.umeng.commonsdk.UMConfigureImpl> r0 = com.umeng.commonsdk.UMConfigureImpl.class
            monitor-enter(r0)
            if (r8 == 0) goto L_0x009a
            r1 = 0
            r2 = 1
            android.content.Context r3 = r8.getApplicationContext()     // Catch:{ Throwable -> 0x0074 }
            com.umeng.commonsdk.amap.a r8 = new com.umeng.commonsdk.amap.a     // Catch:{ Throwable -> 0x0070 }
            r8.<init>(r3)     // Catch:{ Throwable -> 0x0070 }
            java.lang.Class r8 = r8.a()     // Catch:{ Throwable -> 0x0070 }
            if (r8 == 0) goto L_0x0064
            java.lang.String r8 = com.umeng.commonsdk.framework.b.a((android.content.Context) r3)     // Catch:{ Throwable -> 0x0070 }
            java.lang.String r4 = r3.getPackageName()     // Catch:{ Throwable -> 0x0070 }
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Throwable -> 0x0070 }
            if (r5 != 0) goto L_0x0062
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x0070 }
            if (r5 != 0) goto L_0x0062
            boolean r8 = r8.equals(r4)     // Catch:{ Throwable -> 0x0070 }
            if (r8 == 0) goto L_0x0062
            com.umeng.commonsdk.amap.b r8 = f3654a     // Catch:{ Throwable -> 0x0070 }
            if (r8 != 0) goto L_0x003d
            com.umeng.commonsdk.amap.b r8 = new com.umeng.commonsdk.amap.b     // Catch:{ Throwable -> 0x0070 }
            r4 = 10000(0x2710, double:4.9407E-320)
            r8.<init>(r3, r2, r4)     // Catch:{ Throwable -> 0x0070 }
            f3654a = r8     // Catch:{ Throwable -> 0x0070 }
        L_0x003d:
            com.umeng.commonsdk.amap.b r8 = f3654a     // Catch:{ Throwable -> 0x0070 }
            boolean r8 = r8.isAlive()     // Catch:{ Throwable -> 0x0070 }
            if (r8 != 0) goto L_0x0057
            java.lang.String r8 = "AmapLBS"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0070 }
            java.lang.String r5 = "[lbs-build] begin write LBS"
            r4[r1] = r5     // Catch:{ Throwable -> 0x0070 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r8, (java.lang.Object[]) r4)     // Catch:{ Throwable -> 0x0070 }
            com.umeng.commonsdk.amap.b r8 = f3654a     // Catch:{ Throwable -> 0x0070 }
            r8.start()     // Catch:{ Throwable -> 0x0070 }
            monitor-exit(r0)
            return
        L_0x0057:
            java.lang.String r8 = "AmapLBS"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0070 }
            java.lang.String r5 = "[lbs-build] not write start"
            r4[r1] = r5     // Catch:{ Throwable -> 0x0070 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r8, (java.lang.Object[]) r4)     // Catch:{ Throwable -> 0x0070 }
        L_0x0062:
            monitor-exit(r0)
            return
        L_0x0064:
            java.lang.String r8 = "AmapLBS"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0070 }
            java.lang.String r5 = "[lbs-send] not get AMAP !!!"
            r4[r1] = r5     // Catch:{ Throwable -> 0x0070 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r8, (java.lang.Object[]) r4)     // Catch:{ Throwable -> 0x0070 }
            goto L_0x009a
        L_0x0070:
            r8 = move-exception
            goto L_0x0078
        L_0x0072:
            r8 = move-exception
            goto L_0x0098
        L_0x0074:
            r3 = move-exception
            r7 = r3
            r3 = r8
            r8 = r7
        L_0x0078:
            java.lang.String r4 = "AmapLBS"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0072 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            java.lang.String r6 = "e is "
            r5.<init>(r6)     // Catch:{ all -> 0x0072 }
            java.lang.String r6 = r8.getMessage()     // Catch:{ all -> 0x0072 }
            r5.append(r6)     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0072 }
            r2[r1] = r5     // Catch:{ all -> 0x0072 }
            com.umeng.commonsdk.statistics.common.e.c((java.lang.String) r4, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0072 }
            com.umeng.commonsdk.proguard.e.a(r3, r8)     // Catch:{ all -> 0x0072 }
            monitor-exit(r0)
            return
        L_0x0098:
            monitor-exit(r0)
            throw r8
        L_0x009a:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.UMConfigureImpl.a(android.content.Context):void");
    }

    private static void b(final Context context) {
        if (context != null) {
            try {
                String a2 = com.umeng.commonsdk.framework.b.a(context);
                String packageName = context.getPackageName();
                if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(packageName) && a2.equals(packageName)) {
                    new Thread(new Runnable() {
                        public final void run() {
                            try {
                                JSONObject b2 = h.b(context);
                                if (b2 != null && b2.length() > 0) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("lbs", b2);
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("tp", jSONObject);
                                    UMSLEnvelopeBuild uMSLEnvelopeBuild = new UMSLEnvelopeBuild();
                                    uMSLEnvelopeBuild.buildSLEnvelope(context, uMSLEnvelopeBuild.buildSLBaseHeader(context), jSONObject2, UMAmapConfig.AMAP_CACHE_PATH);
                                }
                            } catch (Exception e) {
                                e.a(context, e);
                            }
                        }
                    }).start();
                }
            } catch (Throwable th) {
                e.a(context, th);
            }
        }
    }

    private static synchronized void c(final Context context) {
        synchronized (UMConfigureImpl.class) {
            if (context != null) {
                try {
                    if (!f3655b) {
                        new Thread(new Runnable() {
                            public final void run() {
                                try {
                                    String a2 = com.umeng.commonsdk.framework.b.a(context);
                                    String packageName = context.getPackageName();
                                    if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(packageName) && a2.equals(packageName)) {
                                        h.a(context);
                                        try {
                                            if (!l.a(context).a()) {
                                                l.a(context).b();
                                            }
                                        } catch (Throwable th) {
                                            com.umeng.commonsdk.statistics.common.e.c(c.d, "e is " + th);
                                            th.printStackTrace();
                                        }
                                        try {
                                            t.b(context);
                                        } catch (Exception e) {
                                            com.umeng.commonsdk.statistics.common.e.c(c.d, "e is " + e);
                                        }
                                        try {
                                            j.n(context);
                                        } catch (Exception e2) {
                                            com.umeng.commonsdk.statistics.common.e.c(c.d, "e is " + e2);
                                        }
                                        try {
                                            j.d(context);
                                        } catch (Exception e3) {
                                            com.umeng.commonsdk.statistics.common.e.c(c.d, "e is " + e3);
                                        }
                                        try {
                                            r.b(context);
                                        } catch (Exception e4) {
                                            com.umeng.commonsdk.statistics.common.e.c(c.d, "e is " + e4);
                                        }
                                        try {
                                            d.a(context);
                                        } catch (Exception e5) {
                                            com.umeng.commonsdk.statistics.common.e.c(c.d, "e is " + e5);
                                        }
                                        try {
                                            d.b(context);
                                        } catch (Throwable unused) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    e.a(context, th2);
                                }
                            }
                        }).start();
                        String a2 = com.umeng.commonsdk.framework.b.a(context);
                        String packageName = context.getPackageName();
                        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(packageName) && a2.equals(packageName)) {
                            j.r(context);
                        }
                        try {
                            if (!k.a(context).a()) {
                                k.a(context).b();
                            }
                        } catch (Throwable th) {
                            com.umeng.commonsdk.statistics.common.e.c(c.d, "e is " + th);
                            e.a(context, th);
                        }
                        f3655b = true;
                    }
                } catch (Exception e) {
                    com.umeng.commonsdk.statistics.common.e.c(c.d, "e is " + e);
                    e.a(context, e);
                } catch (Throwable th2) {
                    com.umeng.commonsdk.statistics.common.e.c(c.d, "e is " + th2.getMessage());
                    e.a(context, th2);
                }
            }
        }
    }

    public static void init(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            a(applicationContext);
            b(applicationContext);
            c(applicationContext);
        }
    }
}

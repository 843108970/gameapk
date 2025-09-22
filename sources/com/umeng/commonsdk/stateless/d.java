package com.umeng.commonsdk.stateless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.e;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3853a = 273;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static Context f3854b = null;

    /* renamed from: c  reason: collision with root package name */
    private static HandlerThread f3855c = null;
    private static Handler d = null;
    private static Object e = new Object();
    private static final int f = 512;
    private static IntentFilter g = null;
    /* access modifiers changed from: private */
    public static boolean h = false;
    private static BroadcastReceiver i = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager;
            if (context != null && intent != null) {
                try {
                    if (intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        Context unused = d.f3854b = context.getApplicationContext();
                        if (d.f3854b != null && (connectivityManager = (ConnectivityManager) d.f3854b.getSystemService("connectivity")) != null) {
                            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                                e.a("walle", "[stateless] net reveiver disconnected --->>>");
                                boolean unused2 = d.h = false;
                                return;
                            }
                            boolean unused3 = d.h = true;
                            e.a("walle", "[stateless] net reveiver ok --->>>");
                            d.b(273);
                        }
                    }
                } catch (Throwable th) {
                    com.umeng.commonsdk.proguard.e.a(context, th);
                }
            }
        }
    };

    public d(Context context) {
        synchronized (e) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    f3854b = applicationContext;
                    if (applicationContext != null && f3855c == null) {
                        HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                        f3855c = handlerThread;
                        handlerThread.start();
                        if (d == null) {
                            d = new Handler(f3855c.getLooper()) {
                                public void handleMessage(Message message) {
                                    int i = message.what;
                                    if (i == 273) {
                                        d.e();
                                    } else if (i == 512) {
                                        d.f();
                                    }
                                }
                            };
                        }
                        if (DeviceConfig.checkPermission(f3854b, "android.permission.ACCESS_NETWORK_STATE")) {
                            e.a("walle", "[stateless] begin register receiver");
                            if (g == null) {
                                IntentFilter intentFilter = new IntentFilter();
                                g = intentFilter;
                                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                                if (i != null) {
                                    e.a("walle", "[stateless] register receiver ok");
                                    f3854b.registerReceiver(i, g);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    com.umeng.commonsdk.proguard.e.a(context, th);
                }
            }
        }
    }

    public static void a() {
        b(512);
    }

    public static void a(int i2) {
        if (h && d != null) {
            Message obtainMessage = d.obtainMessage();
            obtainMessage.what = i2;
            d.sendMessage(obtainMessage);
        }
    }

    public static void b(int i2) {
        try {
            if (h && d != null && !d.hasMessages(i2)) {
                e.a("walle", "[stateless] sendMsgOnce !!!!");
                Message obtainMessage = d.obtainMessage();
                obtainMessage.what = i2;
                d.sendMessage(obtainMessage);
            }
        } catch (Throwable th) {
            com.umeng.commonsdk.proguard.e.a(f3854b, th);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:12|13|14|15|16|17|18|(4:20|(1:22)|23|24)(2:25|28)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066 A[Catch:{ Throwable -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094 A[Catch:{ Throwable -> 0x00a0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e() {
        /*
            boolean r0 = h
            if (r0 == 0) goto L_0x00a6
            android.content.Context r0 = f3854b
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            android.content.Context r0 = f3854b     // Catch:{ Throwable -> 0x00a0 }
            java.io.File r0 = com.umeng.commonsdk.stateless.f.a((android.content.Context) r0)     // Catch:{ Throwable -> 0x00a0 }
            if (r0 == 0) goto L_0x009f
            java.io.File r1 = r0.getParentFile()     // Catch:{ Throwable -> 0x00a0 }
            if (r1 == 0) goto L_0x009f
            java.io.File r1 = r0.getParentFile()     // Catch:{ Throwable -> 0x00a0 }
            java.lang.String r1 = r1.getName()     // Catch:{ Throwable -> 0x00a0 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x00a0 }
            if (r1 != 0) goto L_0x009f
            com.umeng.commonsdk.stateless.e r1 = new com.umeng.commonsdk.stateless.e     // Catch:{ Throwable -> 0x00a0 }
            android.content.Context r2 = f3854b     // Catch:{ Throwable -> 0x00a0 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x00a0 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x00a0 }
            java.io.File r3 = r0.getParentFile()     // Catch:{ Throwable -> 0x00a0 }
            java.lang.String r3 = r3.getName()     // Catch:{ Throwable -> 0x00a0 }
            r4 = 0
            byte[] r3 = android.util.Base64.decode(r3, r4)     // Catch:{ Throwable -> 0x00a0 }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x00a0 }
            java.lang.String r3 = "walle"
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ Throwable -> 0x00a0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00a0 }
            java.lang.String r8 = "[stateless] handleProcessNext, pathUrl is "
            r7.<init>(r8)     // Catch:{ Throwable -> 0x00a0 }
            r7.append(r2)     // Catch:{ Throwable -> 0x00a0 }
            java.lang.String r7 = r7.toString()     // Catch:{ Throwable -> 0x00a0 }
            r6[r4] = r7     // Catch:{ Throwable -> 0x00a0 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r3, (java.lang.Object[]) r6)     // Catch:{ Throwable -> 0x00a0 }
            r3 = 0
            java.lang.String r6 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x0060 }
            byte[] r6 = com.umeng.commonsdk.stateless.f.a((java.lang.String) r6)     // Catch:{ Exception -> 0x0060 }
            r3 = r6
        L_0x0060:
            boolean r1 = r1.a(r3, r2)     // Catch:{ Throwable -> 0x00a0 }
            if (r1 == 0) goto L_0x0094
            java.lang.String r1 = "walle"
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ Throwable -> 0x00a0 }
            java.lang.String r3 = "[stateless] Send envelope file success, delete it."
            r2[r4] = r3     // Catch:{ Throwable -> 0x00a0 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ Throwable -> 0x00a0 }
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x00a0 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Throwable -> 0x00a0 }
            r1.<init>(r0)     // Catch:{ Throwable -> 0x00a0 }
            boolean r0 = r1.delete()     // Catch:{ Throwable -> 0x00a0 }
            if (r0 != 0) goto L_0x008e
            java.lang.String r0 = "walle"
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ Throwable -> 0x00a0 }
            java.lang.String r3 = "[stateless] Failed to delete already processed file. We try again after delete failed."
            r2[r4] = r3     // Catch:{ Throwable -> 0x00a0 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ Throwable -> 0x00a0 }
            r1.delete()     // Catch:{ Throwable -> 0x00a0 }
        L_0x008e:
            r0 = 273(0x111, float:3.83E-43)
            b(r0)     // Catch:{ Throwable -> 0x00a0 }
            return
        L_0x0094:
            java.lang.String r0 = "walle"
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ Throwable -> 0x00a0 }
            java.lang.String r2 = "[stateless] Send envelope file failed, abandon and wait next trigger!"
            r1[r4] = r2     // Catch:{ Throwable -> 0x00a0 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Throwable -> 0x00a0 }
        L_0x009f:
            return
        L_0x00a0:
            r0 = move-exception
            android.content.Context r1 = f3854b
            com.umeng.commonsdk.proguard.e.a(r1, r0)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.e():void");
    }

    /* access modifiers changed from: private */
    public static void f() {
        if (g != null) {
            if (i != null) {
                if (f3854b != null) {
                    f3854b.unregisterReceiver(i);
                }
                i = null;
            }
            g = null;
        }
        if (f3855c != null) {
            f3855c.quit();
            if (f3855c != null) {
                f3855c = null;
            }
            if (d != null) {
                d = null;
            }
        }
    }
}

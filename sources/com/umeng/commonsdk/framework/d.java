package com.umeng.commonsdk.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.umeng.commonsdk.proguard.j;
import com.umeng.commonsdk.proguard.u;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.e;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ImLatent;
import java.io.File;

class d {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f3672a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f3673b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f3674c = null;
    private static final int d = 273;
    private static final int e = 512;
    private static final int f = 769;
    private static a g = null;
    /* access modifiers changed from: private */
    public static ConnectivityManager h = null;
    /* access modifiers changed from: private */
    public static NetworkInfo i = null;
    private static IntentFilter j = null;
    private static StatTracer k = null;
    private static ImLatent l = null;
    /* access modifiers changed from: private */
    public static boolean m = false;
    private static BroadcastReceiver n = new BroadcastReceiver() {
        public final void onReceive(final Context context, Intent intent) {
            new Thread(new Runnable() {
                public void run() {
                    j.d(context);
                }
            }).start();
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                final Context a2 = c.a();
                ConnectivityManager unused = d.h = (ConnectivityManager) a2.getSystemService("connectivity");
                try {
                    NetworkInfo unused2 = d.i = d.h.getActiveNetworkInfo();
                    if (d.i == null || !d.i.isAvailable()) {
                        e.c("--->>> network disconnected.");
                        boolean unused3 = d.m = false;
                        return;
                    }
                    e.c("--->>> network isAvailable, check if there are any files to send.");
                    boolean unused4 = d.m = true;
                    d.c(273);
                    if (d.i.getType() == 1) {
                        e.c("--->>> wifi connection available, send uop packet now.");
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    u.a(a2);
                                } catch (Throwable th) {
                                    com.umeng.commonsdk.proguard.e.a(a2, th);
                                }
                            }
                        }).start();
                    }
                } catch (Throwable th) {
                    com.umeng.commonsdk.proguard.e.a(a2, th);
                }
            }
        }
    };

    static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        public void onEvent(int i, String str) {
            if ((i & 8) == 8) {
                e.b("--->>> envelope file created >>> " + str);
                d.c(273);
            }
        }
    }

    public d(Context context, Handler handler) {
        f3674c = handler;
        if (f3672a == null) {
            HandlerThread handlerThread = new HandlerThread("NetWorkSender");
            f3672a = handlerThread;
            handlerThread.start();
            if (g == null) {
                a aVar = new a(b.h(context));
                g = aVar;
                aVar.startWatching();
                e.b("--->>> FileMonitor has already started!");
            }
            Context a2 = c.a();
            if (DeviceConfig.checkPermission(a2, "android.permission.ACCESS_NETWORK_STATE") && j == null) {
                IntentFilter intentFilter = new IntentFilter();
                j = intentFilter;
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                if (n != null) {
                    a2.registerReceiver(n, j);
                }
            }
            if (k == null) {
                k = StatTracer.getInstance(context);
                l = ImLatent.getService(context, k);
            }
            if (f3673b == null) {
                f3673b = new Handler(f3672a.getLooper()) {
                    public void handleMessage(Message message) {
                        int i = message.what;
                        if (i == 273) {
                            e.b("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                            d.j();
                        } else if (i == 512) {
                            d.i();
                        }
                    }
                };
            }
        }
    }

    public static void a() {
        c(512);
    }

    private static void a(int i2, int i3) {
        if (m && f3674c != null) {
            f3674c.removeMessages(i2);
            Message obtainMessage = f3674c.obtainMessage();
            obtainMessage.what = i2;
            f3674c.sendMessageDelayed(obtainMessage, (long) i3);
        }
    }

    private static void a(int i2, long j2) {
        if (m && f3673b != null) {
            Message obtainMessage = f3673b.obtainMessage();
            obtainMessage.what = i2;
            f3673b.sendMessageDelayed(obtainMessage, j2);
        }
    }

    public static void b() {
        b(273);
    }

    private static void b(int i2) {
        if (m && f3673b != null && !f3673b.hasMessages(i2)) {
            Message obtainMessage = f3673b.obtainMessage();
            obtainMessage.what = i2;
            f3673b.sendMessage(obtainMessage);
        }
    }

    public static void c() {
        a((int) f, 3000);
    }

    /* access modifiers changed from: private */
    public static void c(int i2) {
        if (m && f3673b != null) {
            Message obtainMessage = f3673b.obtainMessage();
            obtainMessage.what = i2;
            f3673b.sendMessage(obtainMessage);
        }
    }

    private static void h() {
        if (f3672a != null) {
            f3672a = null;
        }
        if (f3673b != null) {
            f3673b = null;
        }
        if (f3674c != null) {
            f3674c = null;
        }
        if (l != null) {
            l = null;
        }
        if (k != null) {
            k = null;
        }
    }

    /* access modifiers changed from: private */
    public static void i() {
        if (g != null) {
            g.stopWatching();
            g = null;
        }
        if (j != null) {
            if (n != null) {
                c.a().unregisterReceiver(n);
                n = null;
            }
            j = null;
        }
        e.b("--->>> handleQuit: Quit sender thread.");
        if (f3672a != null) {
            f3672a.quit();
            h();
        }
    }

    /* access modifiers changed from: private */
    public static void j() {
        e.b("--->>> handleProcessNext: Enter...");
        if (m) {
            Context a2 = c.a();
            try {
                if (b.c(a2) > 0) {
                    e.b("--->>> The envelope file exists.");
                    if (b.c(a2) > 100) {
                        e.b("--->>> Number of envelope files is greater than 100, remove old files first.");
                        b.d(a2);
                    }
                    File e2 = b.e(a2);
                    if (e2 != null) {
                        String path = e2.getPath();
                        e.b("--->>> Ready to send envelope file [" + path + "].");
                        com.umeng.commonsdk.statistics.d dVar = new com.umeng.commonsdk.statistics.d(a2);
                        if (l != null && l.isLatentActivite()) {
                            l.latentDeactivite();
                            long delayTime = l.getDelayTime();
                            if (delayTime > 0) {
                                e.c("start lacency policy, wait [" + delayTime + "] milliseconds .");
                                Thread.sleep(delayTime * 1000);
                            }
                        }
                        if (dVar.a(e2)) {
                            e.b("--->>> Send envelope file success, delete it.");
                            if (!b.a(e2)) {
                                e.b("--->>> Failed to delete already processed file. We try again after delete failed.");
                                b.a(e2);
                            }
                            c(273);
                            return;
                        }
                        e.b("--->>> Send envelope file failed, abandon and wait next trigger!");
                        return;
                    }
                }
                e.b("--->>> The envelope file not exists, start auto process for module cache data.");
                c();
            } catch (Throwable th) {
                com.umeng.commonsdk.proguard.e.a(a2, th);
            }
        }
    }
}

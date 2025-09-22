package com.cyjh.elfin.services;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.cyjh.common.util.ad;
import com.cyjh.elfin.e.c.k;
import com.elfin.engin.c;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BootService extends BaseService {

    /* renamed from: b  reason: collision with root package name */
    public static final int f2069b = 272;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2070c = 1;
    /* access modifiers changed from: private */
    public static final String d = "BootService";
    /* access modifiers changed from: private */
    public ScheduledFuture<?> e;
    /* access modifiers changed from: private */
    public a f = new a((byte) 0);
    private ScheduledExecutorService g;

    private static class a extends Handler {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void handleMessage(Message message) {
            if (message.what == 272) {
                ad.c(BootService.d, "MyServiceHandler handleMessage --> BootService开机启动运行脚本");
                k.a(11);
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        ad.c(d, "onCreate -->");
        this.g = new ScheduledThreadPoolExecutor(1);
    }

    public void onDestroy() {
        super.onDestroy();
        ad.c(d, "onDestroy -->");
        this.f.removeCallbacksAndMessages((Object) null);
        if (this.e != null) {
            this.e.cancel(true);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        ad.c(d, "onStartCommand -->");
        this.e = this.g.scheduleAtFixedRate(new TimerTask() {
            public final void run() {
                ad.c(BootService.d, "onStartCommand -->222");
                if (c.a().f2901a) {
                    BootService.this.f.obtainMessage(272).sendToTarget();
                    c.a().f2901a = false;
                    if (BootService.this.e != null) {
                        BootService.this.e.cancel(true);
                    }
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
        return super.onStartCommand(intent, i, i2);
    }
}

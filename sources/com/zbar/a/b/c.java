package com.zbar.a.b;

import android.os.Handler;
import android.os.Looper;
import com.cyjh.elfin.ui.activity.SweepCodeActivity;
import java.util.concurrent.CountDownLatch;

final class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    SweepCodeActivity f4004a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f4005b;

    /* renamed from: c  reason: collision with root package name */
    private final CountDownLatch f4006c = new CountDownLatch(1);

    c(SweepCodeActivity sweepCodeActivity) {
        this.f4004a = sweepCodeActivity;
    }

    /* access modifiers changed from: package-private */
    public final Handler a() {
        try {
            this.f4006c.await();
        } catch (InterruptedException unused) {
        }
        return this.f4005b;
    }

    public final void run() {
        Looper.prepare();
        this.f4005b = new b(this.f4004a);
        this.f4006c.countDown();
        Looper.loop();
    }
}

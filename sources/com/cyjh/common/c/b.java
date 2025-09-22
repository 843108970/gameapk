package com.cyjh.common.c;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;

public abstract class b extends CountDownTimer {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f1629a = 1;

    /* renamed from: b  reason: collision with root package name */
    private Handler f1630b = new Handler(Looper.getMainLooper());

    public b(int i) {
        super((long) (i * 1000), 1000);
    }

    /* access modifiers changed from: protected */
    public abstract void a(int i);

    public void onTick(long j) {
        int round = Math.round((((float) j) * 1.0f) / 1000.0f);
        if (round == this.f1629a * 2) {
            this.f1630b.postDelayed(new Runnable() {
                public final void run() {
                    b.this.a(b.this.f1629a);
                }
            }, (long) (this.f1629a * 1000));
        }
        a(round);
    }
}

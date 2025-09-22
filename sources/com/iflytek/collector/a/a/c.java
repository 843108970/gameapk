package com.iflytek.collector.a.a;

import android.os.SystemClock;

class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3495a;

    c(b bVar) {
        this.f3495a = bVar;
    }

    public void run() {
        SystemClock.sleep(5000);
        new i(this.f3495a.f3494c).run();
    }
}

package com.umeng.analytics.pro;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

public class j implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f3633a;

    /* renamed from: b  reason: collision with root package name */
    private n f3634b;

    public j() {
        if (Thread.getDefaultUncaughtExceptionHandler() != this) {
            this.f3633a = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    private void a(Throwable th) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.f3634b.a(th);
        } else {
            this.f3634b.a((Throwable) null);
        }
    }

    public void a(n nVar) {
        this.f3634b = nVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        if (this.f3633a != null && this.f3633a != Thread.getDefaultUncaughtExceptionHandler()) {
            this.f3633a.uncaughtException(thread, th);
        }
    }
}

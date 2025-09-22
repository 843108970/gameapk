package com.zbar.a.b;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class e {

    /* renamed from: b  reason: collision with root package name */
    private static final int f4008b = 300;

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f4009a = Executors.newSingleThreadScheduledExecutor(new a((byte) 0));

    /* renamed from: c  reason: collision with root package name */
    private final Activity f4010c;
    private ScheduledFuture<?> d = null;

    private static final class a implements ThreadFactory {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    public e(Activity activity) {
        this.f4010c = activity;
        a();
    }

    private void c() {
        b();
        this.f4009a.shutdown();
    }

    public final void a() {
        b();
        this.d = this.f4009a.schedule(new d(this.f4010c), 300, TimeUnit.SECONDS);
    }

    public final void b() {
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
    }
}

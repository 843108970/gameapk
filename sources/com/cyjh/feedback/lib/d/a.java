package com.cyjh.feedback.lib.d;

import android.support.annotation.NonNull;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static final int f2405b = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    private static final int f2406c = Math.max(2, Math.min(f2405b - 1, 4));
    private static final int d = ((f2405b * 2) + 1);
    private static final int e = 30;
    private static final ThreadFactory f = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f2408a = new AtomicInteger(1);

        public final Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "ThreadPoolProxy #" + this.f2408a.getAndIncrement());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f2407a;

    protected a() {
        if (this.f2407a == null || this.f2407a.isShutdown() || this.f2407a.isTerminated()) {
            synchronized (a.class) {
                if (this.f2407a == null || this.f2407a.isShutdown() || this.f2407a.isTerminated()) {
                    this.f2407a = new ThreadPoolExecutor(f2406c, d, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(10), f, new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
    }

    private void a() {
        if (this.f2407a == null || this.f2407a.isShutdown() || this.f2407a.isTerminated()) {
            synchronized (a.class) {
                if (this.f2407a == null || this.f2407a.isShutdown() || this.f2407a.isTerminated()) {
                    this.f2407a = new ThreadPoolExecutor(f2406c, d, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(10), f, new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
    }

    private void b(Runnable runnable) {
        if (runnable != null) {
            this.f2407a.remove(runnable);
        }
    }

    public final void a(Runnable runnable) {
        if (runnable != null) {
            this.f2407a.execute(runnable);
        }
    }
}

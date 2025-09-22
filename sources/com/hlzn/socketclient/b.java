package com.hlzn.socketclient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f3425a;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f3426b;

    private synchronized void a() {
        c();
    }

    private void a(Runnable runnable) {
        if (this.f3425a == null) {
            a();
        }
        this.f3425a.execute(runnable);
    }

    private synchronized void b() {
        d();
    }

    private void b(Runnable runnable) {
        if (this.f3426b == null) {
            b();
        }
        this.f3426b.execute(runnable);
    }

    private synchronized void c() {
        e();
        this.f3425a = Executors.newFixedThreadPool(3);
    }

    private synchronized void d() {
        f();
        this.f3426b = Executors.newFixedThreadPool(1);
    }

    private synchronized void e() {
        if (this.f3425a != null) {
            try {
                this.f3425a.shutdownNow();
                this.f3425a = null;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    this.f3425a = null;
                }
            }
        }
    }

    private synchronized void f() {
        if (this.f3426b != null) {
            try {
                this.f3426b.shutdownNow();
                this.f3426b = null;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    this.f3426b = null;
                }
            }
        }
    }
}

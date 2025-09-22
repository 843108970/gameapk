package org.jdeferred.a;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f4368b = true;

    /* renamed from: c  reason: collision with root package name */
    protected final ExecutorService f4369c;
    protected boolean d;

    public c() {
        this.d = true;
        this.f4369c = Executors.newCachedThreadPool();
    }

    public c(ExecutorService executorService) {
        this.d = true;
        this.f4369c = executorService;
    }

    private void a(boolean z) {
        this.d = z;
    }

    private boolean a(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f4369c.awaitTermination(j, timeUnit);
    }

    private ExecutorService b() {
        return this.f4369c;
    }

    private boolean c() {
        return this.f4369c.isShutdown();
    }

    private boolean d() {
        return this.f4369c.isTerminated();
    }

    private void e() {
        this.f4369c.shutdown();
    }

    private List<Runnable> f() {
        return this.f4369c.shutdownNow();
    }

    public final boolean a() {
        return this.d;
    }

    /* access modifiers changed from: protected */
    public final void b(Runnable runnable) {
        this.f4369c.submit(runnable);
    }

    /* access modifiers changed from: protected */
    public final void b(Callable callable) {
        this.f4369c.submit(callable);
    }
}

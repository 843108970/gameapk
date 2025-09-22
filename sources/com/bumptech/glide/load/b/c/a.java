package com.bumptech.glide.load.b.c;

import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class a implements ExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1090a = "source";

    /* renamed from: b  reason: collision with root package name */
    private static final String f1091b = "disk-cache";

    /* renamed from: c  reason: collision with root package name */
    private static final int f1092c = 1;
    private static final String d = "GlideExecutor";
    private static final String e = "source-unlimited";
    private static final String f = "animation";
    private static final long g = TimeUnit.SECONDS.toMillis(10);
    private static final int h = 4;
    private static volatile int i;
    private final ExecutorService j;

    /* renamed from: com.bumptech.glide.load.b.c.a$a  reason: collision with other inner class name */
    private static final class C0013a implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private static final int f1093c = 9;

        /* renamed from: a  reason: collision with root package name */
        final b f1094a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f1095b;
        private final String d;
        private int e;

        C0013a(String str, b bVar, boolean z) {
            this.d = str;
            this.f1094a = bVar;
            this.f1095b = z;
        }

        public final synchronized Thread newThread(@NonNull Runnable runnable) {
            AnonymousClass1 r0;
            r0 = new Thread(runnable, "glide-" + this.d + "-thread-" + this.e) {
                public final void run() {
                    Process.setThreadPriority(9);
                    if (C0013a.this.f1095b) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        C0013a.this.f1094a.a(th);
                    }
                }
            };
            this.e = this.e + 1;
            return r0;
        }
    }

    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f1097a = new b() {
            public final void a(Throwable th) {
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final b f1098b = new b() {
            public final void a(Throwable th) {
                if (Log.isLoggable(a.d, 6)) {
                    Log.e(a.d, "Request threw uncaught throwable", th);
                }
            }
        };

        /* renamed from: c  reason: collision with root package name */
        public static final b f1099c = new b() {
            public final void a(Throwable th) {
                throw new RuntimeException("Request threw uncaught throwable", th);
            }
        };
        public static final b d = f1098b;

        void a(Throwable th);
    }

    @VisibleForTesting
    private a(ExecutorService executorService) {
        this.j = executorService;
    }

    public static a a() {
        return a(f1091b, b.d);
    }

    private static a a(int i2, b bVar) {
        return new a(new ThreadPoolExecutor(0, i2, g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C0013a(f, bVar, true)));
    }

    private static a a(int i2, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i2, i2, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C0013a(str, bVar, false)));
    }

    private static a a(b bVar) {
        return a(f1091b, bVar);
    }

    private static a a(String str, b bVar) {
        return new a(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C0013a(str, bVar, true)));
    }

    public static a b() {
        return a(e(), f1090a, b.d);
    }

    private static a b(b bVar) {
        return a(e(), f1090a, bVar);
    }

    public static a c() {
        return new a(new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, g, TimeUnit.MILLISECONDS, new SynchronousQueue(), new C0013a(e, b.d, false)));
    }

    public static a d() {
        return new a(new ThreadPoolExecutor(0, e() >= 4 ? 2 : 1, g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C0013a(f, b.d, true)));
    }

    private static int e() {
        if (i == 0) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            if (Build.VERSION.SDK_INT < 17) {
                availableProcessors = Math.max(b.a(), availableProcessors);
            }
            i = Math.min(4, availableProcessors);
        }
        return i;
    }

    public final boolean awaitTermination(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.j.awaitTermination(j2, timeUnit);
    }

    public final void execute(@NonNull Runnable runnable) {
        this.j.execute(runnable);
    }

    @NonNull
    public final <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.j.invokeAll(collection);
    }

    @NonNull
    public final <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.j.invokeAll(collection, j2, timeUnit);
    }

    @NonNull
    public final <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.j.invokeAny(collection);
    }

    public final <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.j.invokeAny(collection, j2, timeUnit);
    }

    public final boolean isShutdown() {
        return this.j.isShutdown();
    }

    public final boolean isTerminated() {
        return this.j.isTerminated();
    }

    public final void shutdown() {
        this.j.shutdown();
    }

    @NonNull
    public final List<Runnable> shutdownNow() {
        return this.j.shutdownNow();
    }

    @NonNull
    public final Future<?> submit(@NonNull Runnable runnable) {
        return this.j.submit(runnable);
    }

    @NonNull
    public final <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.j.submit(runnable, t);
    }

    public final <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.j.submit(callable);
    }

    public final String toString() {
        return this.j.toString();
    }
}

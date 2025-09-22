package com.cyjh.elfin.e.c;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import com.umeng.commonsdk.proguard.v;
import java.lang.Thread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f1950a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Integer, Map<Integer, ExecutorService>> f1951b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Map<d, ExecutorService> f1952c = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public static final int d = Runtime.getRuntime().availableProcessors();
    private static final Timer e = new Timer();
    private static final byte f = -1;
    private static final byte g = -2;
    private static final byte h = -4;
    private static final byte i = -8;
    private static Executor j;

    private static final class a extends LinkedBlockingQueue<Runnable> {
        private int mCapacity = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        /* access modifiers changed from: private */
        public volatile e mPool;

        a() {
        }

        a(int i) {
            this.mCapacity = i;
        }

        a(boolean z) {
            if (z) {
                this.mCapacity = 0;
            }
        }

        public final boolean offer(@NonNull Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }
    }

    public static abstract class b<T> extends d<T> {
        public final void a(Throwable th) {
            Log.e("ThreadUtils", "onFail: ", th);
        }

        public final void b() {
            Log.e("ThreadUtils", "onCancel: " + Thread.currentThread());
        }
    }

    public static class c<T> {

        /* renamed from: a  reason: collision with root package name */
        private CountDownLatch f1957a = new CountDownLatch(1);

        /* renamed from: b  reason: collision with root package name */
        private AtomicBoolean f1958b = new AtomicBoolean();

        /* renamed from: c  reason: collision with root package name */
        private T f1959c;

        private T a() {
            if (!this.f1958b.get()) {
                try {
                    this.f1957a.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.f1959c;
        }

        private void a(T t) {
            if (this.f1958b.compareAndSet(false, true)) {
                this.f1959c = t;
                this.f1957a.countDown();
            }
        }
    }

    public static abstract class d<T> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private static final int f1960a = 0;

        /* renamed from: b  reason: collision with root package name */
        private static final int f1961b = 1;

        /* renamed from: c  reason: collision with root package name */
        private static final int f1962c = 2;
        private static final int f = 3;
        private static final int g = 4;
        private static final int h = 5;
        private static final int i = 6;
        final AtomicInteger d = new AtomicInteger(0);
        /* access modifiers changed from: package-private */
        public a e;
        /* access modifiers changed from: private */
        public volatile boolean j;
        private volatile Thread k;
        private Timer l;
        private long m;
        private Executor n;

        public interface a {
            void a();
        }

        private d<T> a(long j2, a aVar) {
            this.m = j2;
            this.e = aVar;
            return this;
        }

        private d<T> a(Executor executor) {
            this.n = executor;
            return this;
        }

        private void a(boolean z) {
            this.j = z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r3.k == null) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            r3.k.interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            r3.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ void b(com.cyjh.elfin.e.c.q.d r3) {
            /*
                java.util.concurrent.atomic.AtomicInteger r0 = r3.d
                monitor-enter(r0)
                java.util.concurrent.atomic.AtomicInteger r1 = r3.d     // Catch:{ all -> 0x0022 }
                int r1 = r1.get()     // Catch:{ all -> 0x0022 }
                r2 = 1
                if (r1 <= r2) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                return
            L_0x000e:
                java.util.concurrent.atomic.AtomicInteger r1 = r3.d     // Catch:{ all -> 0x0022 }
                r2 = 6
                r1.set(r2)     // Catch:{ all -> 0x0022 }
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                java.lang.Thread r0 = r3.k
                if (r0 == 0) goto L_0x001e
                java.lang.Thread r0 = r3.k
                r0.interrupt()
            L_0x001e:
                r3.d()
                return
            L_0x0022:
                r3 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.e.c.q.d.b(com.cyjh.elfin.e.c.q$d):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r3.k == null) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            r3.k.interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            i().execute(new com.cyjh.elfin.e.c.q.d.AnonymousClass5(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void e() {
            /*
                r3 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r3.d
                monitor-enter(r0)
                java.util.concurrent.atomic.AtomicInteger r1 = r3.d     // Catch:{ all -> 0x002b }
                int r1 = r1.get()     // Catch:{ all -> 0x002b }
                r2 = 1
                if (r1 <= r2) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return
            L_0x000e:
                java.util.concurrent.atomic.AtomicInteger r1 = r3.d     // Catch:{ all -> 0x002b }
                r2 = 4
                r1.set(r2)     // Catch:{ all -> 0x002b }
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                java.lang.Thread r0 = r3.k
                if (r0 == 0) goto L_0x001e
                java.lang.Thread r0 = r3.k
                r0.interrupt()
            L_0x001e:
                java.util.concurrent.Executor r0 = r3.i()
                com.cyjh.elfin.e.c.q$d$5 r1 = new com.cyjh.elfin.e.c.q$d$5
                r1.<init>()
                r0.execute(r1)
                return
            L_0x002b:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.e.c.q.d.e():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r3.k == null) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            r3.k.interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void f() {
            /*
                r3 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r3.d
                monitor-enter(r0)
                java.util.concurrent.atomic.AtomicInteger r1 = r3.d     // Catch:{ all -> 0x0022 }
                int r1 = r1.get()     // Catch:{ all -> 0x0022 }
                r2 = 1
                if (r1 <= r2) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                return
            L_0x000e:
                java.util.concurrent.atomic.AtomicInteger r1 = r3.d     // Catch:{ all -> 0x0022 }
                r2 = 6
                r1.set(r2)     // Catch:{ all -> 0x0022 }
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                java.lang.Thread r0 = r3.k
                if (r0 == 0) goto L_0x001e
                java.lang.Thread r0 = r3.k
                r0.interrupt()
            L_0x001e:
                r3.d()
                return
            L_0x0022:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0022 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.e.c.q.d.f():void");
        }

        private boolean g() {
            return this.d.get() >= 4;
        }

        private boolean h() {
            return this.d.get() > 1;
        }

        private Executor i() {
            return this.n == null ? q.b() : this.n;
        }

        public abstract T a() throws Throwable;

        public abstract void a(T t);

        public abstract void a(Throwable th);

        public abstract void b();

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r3.k == null) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            r3.k.interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            i().execute(new com.cyjh.elfin.e.c.q.d.AnonymousClass5(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void c() {
            /*
                r3 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r3.d
                monitor-enter(r0)
                java.util.concurrent.atomic.AtomicInteger r1 = r3.d     // Catch:{ all -> 0x002b }
                int r1 = r1.get()     // Catch:{ all -> 0x002b }
                r2 = 1
                if (r1 <= r2) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return
            L_0x000e:
                java.util.concurrent.atomic.AtomicInteger r1 = r3.d     // Catch:{ all -> 0x002b }
                r2 = 4
                r1.set(r2)     // Catch:{ all -> 0x002b }
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                java.lang.Thread r0 = r3.k
                if (r0 == 0) goto L_0x001e
                java.lang.Thread r0 = r3.k
                r0.interrupt()
            L_0x001e:
                java.util.concurrent.Executor r0 = r3.i()
                com.cyjh.elfin.e.c.q$d$5 r1 = new com.cyjh.elfin.e.c.q$d$5
                r1.<init>()
                r0.execute(r1)
                return
            L_0x002b:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.e.c.q.d.c():void");
        }

        /* access modifiers changed from: protected */
        @CallSuper
        public final void d() {
            q.f1952c.remove(this);
            if (this.l != null) {
                this.l.cancel();
                this.l = null;
                this.e = null;
            }
        }

        public void run() {
            if (this.j) {
                if (this.k == null) {
                    if (this.d.compareAndSet(0, 1)) {
                        this.k = Thread.currentThread();
                        if (this.e != null) {
                            Log.w("ThreadUtils", "Scheduled task doesn't support timeout.");
                        }
                    } else {
                        return;
                    }
                } else if (this.d.get() != 1) {
                    return;
                }
            } else if (this.d.compareAndSet(0, 1)) {
                this.k = Thread.currentThread();
                if (this.e != null) {
                    this.l = new Timer();
                    this.l.schedule(new TimerTask() {
                        public final void run() {
                            boolean z = true;
                            if (d.this.d.get() <= 1) {
                                z = false;
                            }
                            if (!z && d.this.e != null) {
                                d.b(d.this);
                            }
                        }
                    }, this.m);
                }
            } else {
                return;
            }
            try {
                final Object a2 = a();
                if (this.j) {
                    if (this.d.get() == 1) {
                        i().execute(new Runnable() {
                            public final void run() {
                                d.this.a(a2);
                            }
                        });
                    }
                } else if (this.d.compareAndSet(1, 3)) {
                    i().execute(new Runnable() {
                        public final void run() {
                            d.this.a(a2);
                            d.this.d();
                        }
                    });
                }
            } catch (InterruptedException unused) {
                this.d.compareAndSet(4, 5);
            } catch (Throwable th) {
                if (this.d.compareAndSet(1, 2)) {
                    i().execute(new Runnable() {
                        public final void run() {
                            d.this.a(th);
                            d.this.d();
                        }
                    });
                }
            }
        }
    }

    static final class e extends ThreadPoolExecutor {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f1971a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        private a f1972b;

        private e(int i, int i2, long j, TimeUnit timeUnit, a aVar, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, aVar, threadFactory);
            e unused = aVar.mPool = this;
            this.f1972b = aVar;
        }

        private int a() {
            return this.f1971a.get();
        }

        static /* synthetic */ ExecutorService a(int i, int i2) {
            int i3 = i;
            int i4 = i2;
            if (i3 == -8) {
                return new e(q.d + 1, (q.d * 2) + 1, 30, TimeUnit.SECONDS, new a(true), new f(v.r, i4));
            } else if (i3 == -4) {
                return new e((q.d * 2) + 1, (q.d * 2) + 1, 30, TimeUnit.SECONDS, new a(), new f("io", i4));
            } else {
                switch (i3) {
                    case -2:
                        return new e(0, 128, 60, TimeUnit.SECONDS, new a(true), new f("cached", i4));
                    case -1:
                        return new e(1, 1, 0, TimeUnit.MILLISECONDS, new a(), new f("single", i4));
                    default:
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        a aVar = new a();
                        return new e(i3, i3, 0, timeUnit, aVar, new f("fixed(" + i3 + ")", i4));
                }
            }
        }

        private static ExecutorService b(int i, int i2) {
            int i3 = i;
            int i4 = i2;
            if (i3 == -8) {
                return new e(q.d + 1, (q.d * 2) + 1, 30, TimeUnit.SECONDS, new a(true), new f(v.r, i4));
            } else if (i3 == -4) {
                return new e((q.d * 2) + 1, (q.d * 2) + 1, 30, TimeUnit.SECONDS, new a(), new f("io", i4));
            } else {
                switch (i3) {
                    case -2:
                        return new e(0, 128, 60, TimeUnit.SECONDS, new a(true), new f("cached", i4));
                    case -1:
                        return new e(1, 1, 0, TimeUnit.MILLISECONDS, new a(), new f("single", i4));
                    default:
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        a aVar = new a();
                        return new e(i3, i3, 0, timeUnit, aVar, new f("fixed(" + i3 + ")", i4));
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void afterExecute(Runnable runnable, Throwable th) {
            this.f1971a.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        public final void execute(@NonNull Runnable runnable) {
            if (!isShutdown()) {
                this.f1971a.incrementAndGet();
                try {
                    super.execute(runnable);
                } catch (RejectedExecutionException unused) {
                    Log.e("ThreadUtils", "This will not happen!");
                    this.f1972b.offer(runnable);
                } catch (Throwable unused2) {
                    this.f1971a.decrementAndGet();
                }
            }
        }
    }

    static final class f extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        f(String str, int i) {
            this(str, i, false);
        }

        f(String str, int i, boolean z) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i;
            this.isDaemon = z;
        }

        public final Thread newThread(@NonNull Runnable runnable) {
            AnonymousClass1 r0 = new Thread(runnable, this.namePrefix + getAndIncrement()) {
                public final void run() {
                    try {
                        super.run();
                    } catch (Throwable th) {
                        Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                    }
                }
            };
            r0.setDaemon(this.isDaemon);
            r0.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public final void uncaughtException(Thread thread, Throwable th) {
                    System.out.println(th);
                }
            });
            r0.setPriority(this.priority);
            return r0;
        }
    }

    private static ExecutorService a(@IntRange(from = 1) int i2) {
        return b(i2, 5);
    }

    private static ExecutorService a(@IntRange(from = 1) int i2, @IntRange(from = 1, to = 10) int i3) {
        return b(i2, i3);
    }

    private static <T> void a(@IntRange(from = 1) int i2, d<T> dVar) {
        b(b(i2, 5), dVar);
    }

    private static <T> void a(@IntRange(from = 1) int i2, d<T> dVar, @IntRange(from = 1, to = 10) int i3) {
        b(b(i2, i3), dVar);
    }

    private static <T> void a(@IntRange(from = 1) int i2, d<T> dVar, long j2, long j3, TimeUnit timeUnit) {
        b(b(i2, 5), dVar, j2, j3, timeUnit);
    }

    private static <T> void a(@IntRange(from = 1) int i2, d<T> dVar, long j2, long j3, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i3) {
        b(b(i2, i3), dVar, j2, j3, timeUnit);
    }

    private static <T> void a(@IntRange(from = 1) int i2, d<T> dVar, long j2, TimeUnit timeUnit) {
        c(b(i2, 5), dVar, j2, timeUnit);
    }

    private static <T> void a(@IntRange(from = 1) int i2, d<T> dVar, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i3) {
        c(b(i2, i3), dVar, j2, timeUnit);
    }

    public static <T> void a(d<T> dVar) {
        b(b(-8, 5), dVar);
    }

    private static <T> void a(d<T> dVar, @IntRange(from = 1, to = 10) int i2) {
        b(b(-1, i2), dVar);
    }

    private static <T> void a(d<T> dVar, long j2, long j3, TimeUnit timeUnit) {
        b(b(-1, 5), dVar, j2, j3, timeUnit);
    }

    private static <T> void a(d<T> dVar, long j2, long j3, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        b(b(-1, i2), dVar, j2, j3, timeUnit);
    }

    private static <T> void a(d<T> dVar, long j2, TimeUnit timeUnit) {
        c(b(-1, 5), dVar, j2, timeUnit);
    }

    private static <T> void a(d<T> dVar, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        c(b(-1, i2), dVar, j2, timeUnit);
    }

    public static void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f1950a.post(runnable);
        }
    }

    private static void a(Runnable runnable, long j2) {
        f1950a.postDelayed(runnable, j2);
    }

    private static void a(List<d> list) {
        if (list != null && list.size() != 0) {
            for (d next : list) {
                if (next != null) {
                    next.c();
                }
            }
        }
    }

    private static void a(Executor executor) {
        j = executor;
    }

    private static void a(ExecutorService executorService) {
        d dVar;
        if (executorService instanceof e) {
            for (Map.Entry next : f1952c.entrySet()) {
                if (next.getValue() == executorService && (dVar = (d) next.getKey()) != null) {
                    dVar.c();
                }
            }
            return;
        }
        Log.e("ThreadUtils", "The executorService is not ThreadUtils's pool.");
    }

    private static <T> void a(ExecutorService executorService, d<T> dVar) {
        b(executorService, dVar);
    }

    private static <T> void a(ExecutorService executorService, d<T> dVar, long j2, long j3, TimeUnit timeUnit) {
        b(executorService, dVar, j2, j3, timeUnit);
    }

    private static <T> void a(ExecutorService executorService, d<T> dVar, long j2, TimeUnit timeUnit) {
        c(executorService, dVar, j2, timeUnit);
    }

    private static void a(d... dVarArr) {
        if (dVarArr != null && dVarArr.length != 0) {
            for (d dVar : dVarArr) {
                if (dVar != null) {
                    dVar.c();
                }
            }
        }
    }

    static /* synthetic */ Executor b() {
        if (j == null) {
            j = new Executor() {
                public final void execute(@NonNull Runnable runnable) {
                    q.a(runnable);
                }
            };
        }
        return j;
    }

    private static ExecutorService b(@IntRange(from = 1, to = 10) int i2) {
        return b(-1, i2);
    }

    private static ExecutorService b(int i2, int i3) {
        ExecutorService executorService;
        synchronized (f1951b) {
            Map map = f1951b.get(Integer.valueOf(i2));
            if (map == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                executorService = e.a(i2, i3);
                concurrentHashMap.put(Integer.valueOf(i3), executorService);
                f1951b.put(Integer.valueOf(i2), concurrentHashMap);
            } else {
                executorService = (ExecutorService) map.get(Integer.valueOf(i3));
                if (executorService == null) {
                    executorService = e.a(i2, i3);
                    map.put(Integer.valueOf(i3), executorService);
                }
            }
        }
        return executorService;
    }

    private static <T> void b(@IntRange(from = 1) int i2, d<T> dVar, long j2, TimeUnit timeUnit) {
        b(b(i2, 5), dVar, 0, j2, timeUnit);
    }

    private static <T> void b(@IntRange(from = 1) int i2, d<T> dVar, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i3) {
        b(b(i2, i3), dVar, 0, j2, timeUnit);
    }

    private static <T> void b(d<T> dVar) {
        b(b(-1, 5), dVar);
    }

    private static <T> void b(d<T> dVar, @IntRange(from = 1, to = 10) int i2) {
        b(b(-2, i2), dVar);
    }

    private static <T> void b(d<T> dVar, long j2, long j3, TimeUnit timeUnit) {
        b(b(-2, 5), dVar, j2, j3, timeUnit);
    }

    private static <T> void b(d<T> dVar, long j2, long j3, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        b(b(-2, i2), dVar, j2, j3, timeUnit);
    }

    private static <T> void b(d<T> dVar, long j2, TimeUnit timeUnit) {
        b(b(-1, 5), dVar, 0, j2, timeUnit);
    }

    private static <T> void b(d<T> dVar, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        b(b(-1, i2), dVar, 0, j2, timeUnit);
    }

    private static <T> void b(ExecutorService executorService, d<T> dVar) {
        c(executorService, dVar, 0, 0, (TimeUnit) null);
    }

    private static <T> void b(ExecutorService executorService, d<T> dVar, long j2, long j3, TimeUnit timeUnit) {
        c(executorService, dVar, j2, j3, timeUnit);
    }

    private static <T> void b(ExecutorService executorService, d<T> dVar, long j2, TimeUnit timeUnit) {
        b(executorService, dVar, 0, j2, timeUnit);
    }

    private static ExecutorService c(@IntRange(from = 1, to = 10) int i2) {
        return b(-2, i2);
    }

    private static <T> void c(d<T> dVar) {
        b(b(-2, 5), dVar);
    }

    private static <T> void c(d<T> dVar, @IntRange(from = 1, to = 10) int i2) {
        b(b(-4, i2), dVar);
    }

    private static <T> void c(d<T> dVar, long j2, long j3, TimeUnit timeUnit) {
        b(b(-4, 5), dVar, j2, j3, timeUnit);
    }

    private static <T> void c(d<T> dVar, long j2, long j3, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        b(b(-4, i2), dVar, j2, j3, timeUnit);
    }

    private static <T> void c(d<T> dVar, long j2, TimeUnit timeUnit) {
        c(b(-2, 5), dVar, j2, timeUnit);
    }

    private static <T> void c(d<T> dVar, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        c(b(-2, i2), dVar, j2, timeUnit);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r10 != 0) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        if (r8 != 0) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        r6.execute(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        e.schedule(new com.cyjh.elfin.e.c.q.AnonymousClass1(), r12.toMillis(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        com.cyjh.elfin.e.c.q.d.a((com.cyjh.elfin.e.c.q.d) r7);
        e.scheduleAtFixedRate(new com.cyjh.elfin.e.c.q.AnonymousClass2(), r12.toMillis(r8), r12.toMillis(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> void c(final java.util.concurrent.ExecutorService r6, final com.cyjh.elfin.e.c.q.d<T> r7, long r8, long r10, java.util.concurrent.TimeUnit r12) {
        /*
            java.util.Map<com.cyjh.elfin.e.c.q$d, java.util.concurrent.ExecutorService> r0 = f1952c
            monitor-enter(r0)
            java.util.Map<com.cyjh.elfin.e.c.q$d, java.util.concurrent.ExecutorService> r1 = f1952c     // Catch:{ all -> 0x004d }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0014
            java.lang.String r6 = "ThreadUtils"
            java.lang.String r7 = "Task can only be executed once."
            android.util.Log.e(r6, r7)     // Catch:{ all -> 0x004d }
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x0014:
            java.util.Map<com.cyjh.elfin.e.c.q$d, java.util.concurrent.ExecutorService> r1 = f1952c     // Catch:{ all -> 0x004d }
            r1.put(r7, r6)     // Catch:{ all -> 0x004d }
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x0037
            int r10 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r10 != 0) goto L_0x0028
            r6.execute(r7)
            return
        L_0x0028:
            com.cyjh.elfin.e.c.q$1 r10 = new com.cyjh.elfin.e.c.q$1
            r10.<init>(r6, r7)
            java.util.Timer r6 = e
            long r7 = r12.toMillis(r8)
            r6.schedule(r10, r7)
            return
        L_0x0037:
            r7.j = true
            com.cyjh.elfin.e.c.q$2 r1 = new com.cyjh.elfin.e.c.q$2
            r1.<init>(r6, r7)
            java.util.Timer r0 = e
            long r2 = r12.toMillis(r8)
            long r4 = r12.toMillis(r10)
            r0.scheduleAtFixedRate(r1, r2, r4)
            return
        L_0x004d:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.e.c.q.c(java.util.concurrent.ExecutorService, com.cyjh.elfin.e.c.q$d, long, long, java.util.concurrent.TimeUnit):void");
    }

    private static <T> void c(ExecutorService executorService, d<T> dVar, long j2, TimeUnit timeUnit) {
        c(executorService, dVar, j2, 0, timeUnit);
    }

    private static ExecutorService d(@IntRange(from = 1, to = 10) int i2) {
        return b(-4, i2);
    }

    private static <T> void d(d<T> dVar) {
        b(b(-4, 5), dVar);
    }

    private static <T> void d(d<T> dVar, @IntRange(from = 1, to = 10) int i2) {
        b(b(-8, i2), dVar);
    }

    private static <T> void d(d<T> dVar, long j2, long j3, TimeUnit timeUnit) {
        b(b(-8, 5), dVar, j2, j3, timeUnit);
    }

    private static <T> void d(d<T> dVar, long j2, long j3, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        b(b(-8, i2), dVar, j2, j3, timeUnit);
    }

    private static <T> void d(d<T> dVar, long j2, TimeUnit timeUnit) {
        b(b(-2, 5), dVar, 0, j2, timeUnit);
    }

    private static <T> void d(d<T> dVar, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        b(b(-2, i2), dVar, 0, j2, timeUnit);
    }

    private static boolean d() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static Handler e() {
        return f1950a;
    }

    private static ExecutorService e(@IntRange(from = 1, to = 10) int i2) {
        return b(-8, i2);
    }

    private static void e(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
    }

    private static <T> void e(d<T> dVar, long j2, TimeUnit timeUnit) {
        c(b(-4, 5), dVar, j2, timeUnit);
    }

    private static <T> void e(d<T> dVar, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        c(b(-4, i2), dVar, j2, timeUnit);
    }

    private static ExecutorService f() {
        return b(-1, 5);
    }

    private static ExecutorService f(int i2) {
        return b(i2, 5);
    }

    private static <T> void f(d<T> dVar, long j2, TimeUnit timeUnit) {
        b(b(-4, 5), dVar, 0, j2, timeUnit);
    }

    private static <T> void f(d<T> dVar, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        b(b(-4, i2), dVar, 0, j2, timeUnit);
    }

    private static ExecutorService g() {
        return b(-2, 5);
    }

    private static <T> void g(d<T> dVar, long j2, TimeUnit timeUnit) {
        c(b(-8, 5), dVar, j2, timeUnit);
    }

    private static <T> void g(d<T> dVar, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        c(b(-8, i2), dVar, j2, timeUnit);
    }

    private static ExecutorService h() {
        return b(-4, 5);
    }

    private static <T> void h(d<T> dVar, long j2, TimeUnit timeUnit) {
        b(b(-8, 5), dVar, 0, j2, timeUnit);
    }

    private static <T> void h(d<T> dVar, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = 10) int i2) {
        b(b(-8, i2), dVar, 0, j2, timeUnit);
    }

    private static ExecutorService i() {
        return b(-8, 5);
    }

    private static Executor j() {
        if (j == null) {
            j = new Executor() {
                public final void execute(@NonNull Runnable runnable) {
                    q.a(runnable);
                }
            };
        }
        return j;
    }
}

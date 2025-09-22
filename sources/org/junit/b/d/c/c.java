package org.junit.b.d.c;

import java.lang.Thread;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.junit.e.a.j;

public final class c extends j {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public final j f4488a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeUnit f4489b;

    /* renamed from: c  reason: collision with root package name */
    private final long f4490c;
    private final boolean d;
    private volatile ThreadGroup e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4491a;
        /* access modifiers changed from: package-private */

        /* renamed from: b  reason: collision with root package name */
        public long f4492b;
        /* access modifiers changed from: package-private */

        /* renamed from: c  reason: collision with root package name */
        public TimeUnit f4493c;

        private a() {
            this.f4491a = false;
            this.f4492b = 0;
            this.f4493c = TimeUnit.SECONDS;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        private a a(boolean z) {
            this.f4491a = z;
            return this;
        }

        public final a a(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout must be non-negative");
            } else if (timeUnit == null) {
                throw new NullPointerException("TimeUnit cannot be null");
            } else {
                this.f4492b = j;
                this.f4493c = timeUnit;
                return this;
            }
        }

        public final c a(j jVar) {
            if (jVar != null) {
                return new c(this, jVar, (byte) 0);
            }
            throw new NullPointerException("statement cannot be null");
        }
    }

    private class b implements Callable<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final CountDownLatch f4494a;

        private b() {
            this.f4494a = new CountDownLatch(1);
        }

        /* synthetic */ b(c cVar, byte b2) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Throwable call() throws Exception {
            try {
                this.f4494a.countDown();
                c.this.f4488a.a();
                return null;
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                return th;
            }
        }

        private void b() throws InterruptedException {
            this.f4494a.await();
        }
    }

    private c(a aVar, j jVar) {
        this.e = null;
        this.f4488a = jVar;
        this.f4490c = aVar.f4492b;
        this.f4489b = aVar.f4493c;
        this.d = aVar.f4491a;
    }

    /* synthetic */ c(a aVar, j jVar, byte b2) {
        this(aVar, jVar);
    }

    @Deprecated
    private c(j jVar, long j) {
        this(b().a(j, TimeUnit.MILLISECONDS), jVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ae A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Exception a(java.lang.Thread r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.StackTraceElement[] r1 = r17.getStackTrace()
            boolean r2 = r0.d
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x006b
            java.lang.ThreadGroup r2 = r0.e
            if (r2 == 0) goto L_0x006b
            java.lang.ThreadGroup r2 = r0.e
            int r7 = r2.activeCount()
            int r7 = r7 * 2
            r8 = 100
            int r7 = java.lang.Math.max(r7, r8)
            r8 = 0
        L_0x0021:
            java.lang.Thread[] r9 = new java.lang.Thread[r7]
            int r10 = r2.enumerate(r9)
            if (r10 < r7) goto L_0x0031
            int r7 = r7 + 100
            int r8 = r8 + r5
            r9 = 5
            if (r8 < r9) goto L_0x0021
            r7 = r4
            goto L_0x0042
        L_0x0031:
            int r2 = r9.length
            int r2 = java.lang.Math.min(r10, r2)
            java.lang.Thread[] r7 = new java.lang.Thread[r2]
            r8 = 0
        L_0x0039:
            if (r8 >= r2) goto L_0x0042
            r10 = r9[r8]
            r7[r8] = r10
            int r8 = r8 + 1
            goto L_0x0039
        L_0x0042:
            if (r7 == 0) goto L_0x006b
            r8 = 0
            int r2 = r7.length
            r10 = r8
            r8 = 0
            r9 = r4
        L_0x004a:
            if (r8 >= r2) goto L_0x0065
            r12 = r7[r8]
            java.lang.Thread$State r13 = r12.getState()
            java.lang.Thread$State r14 = java.lang.Thread.State.RUNNABLE
            if (r13 != r14) goto L_0x0062
            long r13 = d(r12)
            if (r9 == 0) goto L_0x0060
            int r15 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r15 <= 0) goto L_0x0062
        L_0x0060:
            r9 = r12
            r10 = r13
        L_0x0062:
            int r8 = r8 + 1
            goto L_0x004a
        L_0x0065:
            r8 = r17
            if (r9 == r8) goto L_0x006d
            r4 = r9
            goto L_0x006d
        L_0x006b:
            r8 = r17
        L_0x006d:
            org.junit.e.a.l r2 = new org.junit.e.a.l
            long r9 = r0.f4490c
            java.util.concurrent.TimeUnit r7 = r0.f4489b
            r2.<init>(r9, r7)
            if (r1 == 0) goto L_0x007e
            r2.setStackTrace(r1)
            r17.interrupt()
        L_0x007e:
            if (r4 == 0) goto L_0x00ae
            java.lang.Exception r1 = new java.lang.Exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Appears to be stuck in thread "
            r7.<init>(r8)
            java.lang.String r8 = r4.getName()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r1.<init>(r7)
            java.lang.StackTraceElement[] r4 = b(r4)
            r1.setStackTrace(r4)
            org.junit.e.a.f r4 = new org.junit.e.a.f
            java.lang.Throwable[] r3 = new java.lang.Throwable[r3]
            r3[r6] = r2
            r3[r5] = r1
            java.util.List r1 = java.util.Arrays.asList(r3)
            r4.<init>(r1)
            return r4
        L_0x00ae:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.b.d.c.c.a(java.lang.Thread):java.lang.Exception");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r3 != r19) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Throwable a(java.util.concurrent.FutureTask<java.lang.Throwable> r18, java.lang.Thread r19) {
        /*
            r17 = this;
            r1 = r17
            r2 = 0
            long r4 = r1.f4490c     // Catch:{ InterruptedException -> 0x00d2, ExecutionException -> 0x00cb, TimeoutException -> 0x0020 }
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0017
            long r4 = r1.f4490c     // Catch:{ InterruptedException -> 0x00d2, ExecutionException -> 0x00cb, TimeoutException -> 0x0020 }
            java.util.concurrent.TimeUnit r6 = r1.f4489b     // Catch:{ InterruptedException -> 0x00d2, ExecutionException -> 0x00cb, TimeoutException -> 0x0020 }
            r7 = r18
            java.lang.Object r4 = r7.get(r4, r6)     // Catch:{ InterruptedException -> 0x00d2, ExecutionException -> 0x00cb, TimeoutException -> 0x0020 }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ InterruptedException -> 0x00d2, ExecutionException -> 0x00cb, TimeoutException -> 0x0020 }
            return r4
        L_0x0017:
            r7 = r18
            java.lang.Object r4 = r18.get()     // Catch:{ InterruptedException -> 0x00d2, ExecutionException -> 0x00cb, TimeoutException -> 0x0020 }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ InterruptedException -> 0x00d2, ExecutionException -> 0x00cb, TimeoutException -> 0x0020 }
            return r4
        L_0x0020:
            java.lang.StackTraceElement[] r4 = r19.getStackTrace()
            boolean r5 = r1.d
            r6 = 2
            r7 = 0
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x0086
            java.lang.ThreadGroup r5 = r1.e
            if (r5 == 0) goto L_0x0086
            java.lang.ThreadGroup r5 = r1.e
            int r10 = r5.activeCount()
            int r10 = r10 * 2
            r11 = 100
            int r10 = java.lang.Math.max(r10, r11)
            r11 = 0
        L_0x003f:
            java.lang.Thread[] r12 = new java.lang.Thread[r10]
            int r13 = r5.enumerate(r12)
            if (r13 < r10) goto L_0x004f
            int r10 = r10 + 100
            int r11 = r11 + r8
            r12 = 5
            if (r11 < r12) goto L_0x003f
            r10 = r7
            goto L_0x0060
        L_0x004f:
            int r5 = r12.length
            int r5 = java.lang.Math.min(r13, r5)
            java.lang.Thread[] r10 = new java.lang.Thread[r5]
            r11 = 0
        L_0x0057:
            if (r11 >= r5) goto L_0x0060
            r13 = r12[r11]
            r10[r11] = r13
            int r11 = r11 + 1
            goto L_0x0057
        L_0x0060:
            if (r10 == 0) goto L_0x0086
            int r5 = r10.length
            r11 = r2
            r3 = r7
            r2 = 0
        L_0x0066:
            if (r2 >= r5) goto L_0x0081
            r13 = r10[r2]
            java.lang.Thread$State r14 = r13.getState()
            java.lang.Thread$State r15 = java.lang.Thread.State.RUNNABLE
            if (r14 != r15) goto L_0x007e
            long r14 = d(r13)
            if (r3 == 0) goto L_0x007c
            int r16 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r16 <= 0) goto L_0x007e
        L_0x007c:
            r3 = r13
            r11 = r14
        L_0x007e:
            int r2 = r2 + 1
            goto L_0x0066
        L_0x0081:
            r2 = r19
            if (r3 == r2) goto L_0x0088
            goto L_0x0089
        L_0x0086:
            r2 = r19
        L_0x0088:
            r3 = r7
        L_0x0089:
            org.junit.e.a.l r5 = new org.junit.e.a.l
            long r10 = r1.f4490c
            java.util.concurrent.TimeUnit r7 = r1.f4489b
            r5.<init>(r10, r7)
            if (r4 == 0) goto L_0x009a
            r5.setStackTrace(r4)
            r19.interrupt()
        L_0x009a:
            if (r3 == 0) goto L_0x00ca
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r7 = "Appears to be stuck in thread "
            r4.<init>(r7)
            java.lang.String r7 = r3.getName()
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r2.<init>(r4)
            java.lang.StackTraceElement[] r3 = b(r3)
            r2.setStackTrace(r3)
            org.junit.e.a.f r3 = new org.junit.e.a.f
            java.lang.Throwable[] r4 = new java.lang.Throwable[r6]
            r4[r9] = r5
            r4[r8] = r2
            java.util.List r2 = java.util.Arrays.asList(r4)
            r3.<init>(r2)
            return r3
        L_0x00ca:
            return r5
        L_0x00cb:
            r0 = move-exception
            r2 = r0
            java.lang.Throwable r2 = r2.getCause()
            return r2
        L_0x00d2:
            r0 = move-exception
            r2 = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.b.d.c.c.a(java.util.concurrent.FutureTask, java.lang.Thread):java.lang.Throwable");
    }

    private static Thread[] a(ThreadGroup threadGroup) {
        int max = Math.max(threadGroup.activeCount() * 2, 100);
        int i = 0;
        do {
            Thread[] threadArr = new Thread[max];
            int enumerate = threadGroup.enumerate(threadArr);
            if (enumerate >= max) {
                max += 100;
                i++;
            } else {
                int min = Math.min(enumerate, threadArr.length);
                Thread[] threadArr2 = new Thread[min];
                for (int i2 = 0; i2 < min; i2++) {
                    threadArr2[i2] = threadArr[i2];
                }
                return threadArr2;
            }
        } while (i < 5);
        return null;
    }

    private static Thread[] a(Thread[] threadArr, int i) {
        int min = Math.min(i, threadArr.length);
        Thread[] threadArr2 = new Thread[min];
        for (int i2 = 0; i2 < min; i2++) {
            threadArr2[i2] = threadArr[i2];
        }
        return threadArr2;
    }

    public static a b() {
        return new a((byte) 0);
    }

    private static StackTraceElement[] b(Thread thread) {
        try {
            return thread.getStackTrace();
        } catch (SecurityException unused) {
            return new StackTraceElement[0];
        }
    }

    private Thread c(Thread thread) {
        Thread[] threadArr;
        if (this.e == null) {
            return null;
        }
        ThreadGroup threadGroup = this.e;
        int max = Math.max(threadGroup.activeCount() * 2, 100);
        int i = 0;
        while (true) {
            Thread[] threadArr2 = new Thread[max];
            int enumerate = threadGroup.enumerate(threadArr2);
            if (enumerate >= max) {
                max += 100;
                i++;
                if (i >= 5) {
                    threadArr = null;
                    break;
                }
            } else {
                int min = Math.min(enumerate, threadArr2.length);
                threadArr = new Thread[min];
                for (int i2 = 0; i2 < min; i2++) {
                    threadArr[i2] = threadArr2[i2];
                }
            }
        }
        if (threadArr == null) {
            return null;
        }
        long j = 0;
        Thread thread2 = null;
        for (Thread thread3 : threadArr) {
            if (thread3.getState() == Thread.State.RUNNABLE) {
                long d2 = d(thread3);
                if (thread2 == null || d2 > j) {
                    thread2 = thread3;
                    j = d2;
                }
            }
        }
        if (thread2 == thread) {
            return null;
        }
        return thread2;
    }

    private static long d(Thread thread) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        if (!threadMXBean.isThreadCpuTimeSupported()) {
            return 0;
        }
        try {
            return threadMXBean.getThreadCpuTime(thread.getId());
        } catch (UnsupportedOperationException unused) {
            return 0;
        }
    }

    public final void a() throws Throwable {
        b bVar = new b(this, (byte) 0);
        FutureTask futureTask = new FutureTask(bVar);
        this.e = new ThreadGroup("FailOnTimeoutGroup");
        Thread thread = new Thread(this.e, futureTask, "Time-limited test");
        thread.setDaemon(true);
        thread.start();
        bVar.f4494a.await();
        Throwable a2 = a((FutureTask<Throwable>) futureTask, thread);
        if (a2 != null) {
            throw a2;
        }
    }
}

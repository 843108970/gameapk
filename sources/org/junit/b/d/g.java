package org.junit.b.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.a;
import org.junit.b.b;
import org.junit.e.a.l;
import org.junit.f;
import org.junit.k;
import org.junit.m;
import org.junit.runner.b.c;

@Deprecated
public final class g {

    /* renamed from: a  reason: collision with root package name */
    final c f4512a;

    /* renamed from: b  reason: collision with root package name */
    final org.junit.runner.c f4513b;

    /* renamed from: c  reason: collision with root package name */
    k f4514c;
    private final Object d;

    public g(Object obj, k kVar, c cVar, org.junit.runner.c cVar2) {
        this.d = obj;
        this.f4512a = cVar;
        this.f4513b = cVar2;
        this.f4514c = kVar;
    }

    private void a(final long j) {
        a((Runnable) new Runnable() {
            public final void run() {
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                Future submit = newSingleThreadExecutor.submit(new Callable<Object>() {
                    public final Object call() throws Exception {
                        g.this.a();
                        return null;
                    }
                });
                newSingleThreadExecutor.shutdown();
                try {
                    if (!newSingleThreadExecutor.awaitTermination(r3, TimeUnit.MILLISECONDS)) {
                        newSingleThreadExecutor.shutdownNow();
                    }
                    submit.get(0, TimeUnit.MILLISECONDS);
                } catch (TimeoutException unused) {
                    g.this.a((Throwable) new l(r3, TimeUnit.MILLISECONDS));
                } catch (Exception e) {
                    g.this.a((Throwable) e);
                }
            }
        });
    }

    private void b() {
        if (this.f4514c.f4522a.getAnnotation(k.class) != null) {
            this.f4512a.b(this.f4513b);
            return;
        }
        this.f4512a.a(this.f4513b);
        try {
            m mVar = (m) this.f4514c.f4522a.getAnnotation(m.class);
            final long b2 = mVar == null ? 0 : mVar.b();
            a(b2 > 0 ? new Runnable() {
                public final void run() {
                    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                    Future submit = newSingleThreadExecutor.submit(new Callable<Object>() {
                        public final Object call() throws Exception {
                            g.this.a();
                            return null;
                        }
                    });
                    newSingleThreadExecutor.shutdown();
                    try {
                        if (!newSingleThreadExecutor.awaitTermination(b2, TimeUnit.MILLISECONDS)) {
                            newSingleThreadExecutor.shutdownNow();
                        }
                        submit.get(0, TimeUnit.MILLISECONDS);
                    } catch (TimeoutException unused) {
                        g.this.a((Throwable) new l(b2, TimeUnit.MILLISECONDS));
                    } catch (Exception e) {
                        g.this.a((Throwable) e);
                    }
                }
            } : new Runnable() {
                public final void run() {
                    g.this.a();
                }
            });
        } finally {
            this.f4512a.c(this.f4513b);
        }
    }

    private void c() {
        a((Runnable) new Runnable() {
            public final void run() {
                g.this.a();
            }
        });
    }

    private void d() throws c {
        try {
            for (Method invoke : this.f4514c.f4523b.a(f.class)) {
                invoke.invoke(this.d, new Object[0]);
            }
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (b unused) {
            throw new c();
        } catch (Throwable th) {
            a(th);
            throw new c();
        }
    }

    private void e() {
        Throwable th;
        for (Method invoke : this.f4514c.f4523b.a(a.class)) {
            try {
                invoke.invoke(this.d, new Object[0]);
            } catch (InvocationTargetException e) {
                th = e.getTargetException();
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return;
        a(th);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            k kVar = this.f4514c;
            kVar.f4522a.invoke(this.d, new Object[0]);
            if (this.f4514c.b()) {
                a((Throwable) new AssertionError("Expected exception: " + this.f4514c.a().getName()));
            }
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (!(targetException instanceof b)) {
                if (!this.f4514c.b()) {
                    a(targetException);
                } else if (this.f4514c.a(targetException)) {
                    a((Throwable) new Exception("Unexpected exception, expected<" + this.f4514c.a().getName() + "> but was<" + targetException.getClass().getName() + ">", targetException));
                }
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0043 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Runnable r5) {
        /*
            r4 = this;
            org.junit.b.d.k r0 = r4.f4514c     // Catch:{ InvocationTargetException -> 0x002e }
            org.junit.b.d.j r0 = r0.f4523b     // Catch:{ InvocationTargetException -> 0x002e }
            java.lang.Class<org.junit.f> r1 = org.junit.f.class
            java.util.List r0 = r0.a(r1)     // Catch:{ InvocationTargetException -> 0x002e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ InvocationTargetException -> 0x002e }
        L_0x000e:
            boolean r1 = r0.hasNext()     // Catch:{ InvocationTargetException -> 0x002e }
            if (r1 == 0) goto L_0x0023
            java.lang.Object r1 = r0.next()     // Catch:{ InvocationTargetException -> 0x002e }
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1     // Catch:{ InvocationTargetException -> 0x002e }
            java.lang.Object r2 = r4.d     // Catch:{ InvocationTargetException -> 0x002e }
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ InvocationTargetException -> 0x002e }
            r1.invoke(r2, r3)     // Catch:{ InvocationTargetException -> 0x002e }
            goto L_0x000e
        L_0x0023:
            r5.run()     // Catch:{ c -> 0x004f, Exception -> 0x0043 }
            r4.e()
            return
        L_0x002a:
            r5 = move-exception
            goto L_0x004b
        L_0x002c:
            r5 = move-exception
            goto L_0x0034
        L_0x002e:
            r5 = move-exception
            java.lang.Throwable r5 = r5.getTargetException()     // Catch:{ b -> 0x003d, Throwable -> 0x002c }
            throw r5     // Catch:{ b -> 0x003d, Throwable -> 0x002c }
        L_0x0034:
            r4.a((java.lang.Throwable) r5)     // Catch:{ c -> 0x004f, Exception -> 0x0043 }
            org.junit.b.d.c r5 = new org.junit.b.d.c     // Catch:{ c -> 0x004f, Exception -> 0x0043 }
            r5.<init>()     // Catch:{ c -> 0x004f, Exception -> 0x0043 }
            throw r5     // Catch:{ c -> 0x004f, Exception -> 0x0043 }
        L_0x003d:
            org.junit.b.d.c r5 = new org.junit.b.d.c     // Catch:{ c -> 0x004f, Exception -> 0x0043 }
            r5.<init>()     // Catch:{ c -> 0x004f, Exception -> 0x0043 }
            throw r5     // Catch:{ c -> 0x004f, Exception -> 0x0043 }
        L_0x0043:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ all -> 0x002a }
            java.lang.String r0 = "test should never throw an exception to this level"
            r5.<init>(r0)     // Catch:{ all -> 0x002a }
            throw r5     // Catch:{ all -> 0x002a }
        L_0x004b:
            r4.e()
            throw r5
        L_0x004f:
            r4.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.b.d.g.a(java.lang.Runnable):void");
    }

    /* access modifiers changed from: protected */
    public final void a(Throwable th) {
        this.f4512a.a(new org.junit.runner.b.a(this.f4513b, th));
    }
}

package org.jdeferred.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.jdeferred.b.b;
import org.jdeferred.c;
import org.jdeferred.d;
import org.jdeferred.e;
import org.jdeferred.f;
import org.jdeferred.p;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    protected final Logger f4364a = LoggerFactory.getLogger(a.class);

    protected static void a(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalArgumentException("Arguments is null or its length is empty");
        }
    }

    public final p<Void, Throwable, Void> a(Runnable runnable) {
        return a(new d(runnable));
    }

    public final <D> p<D, Throwable, Void> a(Callable<D> callable) {
        return a(new d(callable));
    }

    public final <D> p<D, Throwable, Void> a(final Future<D> future) {
        return a(new c<D, Void>(e.a.AUTO$273301ba) {
            public final D call() throws Exception {
                try {
                    return r2.get();
                } catch (InterruptedException e) {
                    throw e;
                } catch (ExecutionException e2) {
                    if (e2.getCause() instanceof Exception) {
                        throw ((Exception) e2.getCause());
                    }
                    throw e2;
                }
            }
        });
    }

    public final <D, P> p<D, Throwable, P> a(c<D, P> cVar) {
        return a(new d(cVar));
    }

    public <D, P> p<D, Throwable, P> a(d<D, P> dVar) {
        if (dVar.b() == e.a.AUTO$273301ba || (dVar.b() == e.a.DEFAULT$273301ba && a())) {
            b((Runnable) dVar);
        }
        return dVar.a();
    }

    public final <P> p<Void, Throwable, P> a(f<P> fVar) {
        return a(new d(fVar));
    }

    public <D, F, P> p<D, F, P> a(p<D, F, P> pVar) {
        return pVar;
    }

    public final p<org.jdeferred.b.c, org.jdeferred.b.e, b> a(Runnable... runnableArr) {
        a((Object[]) runnableArr);
        p[] pVarArr = new p[runnableArr.length];
        for (int i = 0; i < runnableArr.length; i++) {
            if (runnableArr[i] instanceof f) {
                pVarArr[i] = a(runnableArr[i]);
            } else {
                pVarArr[i] = a(new d(runnableArr[i]));
            }
        }
        return a(pVarArr);
    }

    public final p<org.jdeferred.b.c, org.jdeferred.b.e, b> a(Callable<?>... callableArr) {
        a((Object[]) callableArr);
        p[] pVarArr = new p[callableArr.length];
        for (int i = 0; i < callableArr.length; i++) {
            if (callableArr[i] instanceof c) {
                pVarArr[i] = a(callableArr[i]);
            } else {
                pVarArr[i] = a(new d(callableArr[i]));
            }
        }
        return a(pVarArr);
    }

    public final p<org.jdeferred.b.c, org.jdeferred.b.e, b> a(Future<?>... futureArr) {
        a((Object[]) futureArr);
        p[] pVarArr = new p[futureArr.length];
        for (int i = 0; i < futureArr.length; i++) {
            final Future<?> future = futureArr[i];
            pVarArr[i] = a(new c<D, Void>(e.a.AUTO$273301ba) {
                public final D call() throws Exception {
                    try {
                        return future.get();
                    } catch (InterruptedException e) {
                        throw e;
                    } catch (ExecutionException e2) {
                        if (e2.getCause() instanceof Exception) {
                            throw ((Exception) e2.getCause());
                        }
                        throw e2;
                    }
                }
            });
        }
        return a(pVarArr);
    }

    public final p<org.jdeferred.b.c, org.jdeferred.b.e, b> a(c<?, ?>... cVarArr) {
        a((Object[]) cVarArr);
        p[] pVarArr = new p[cVarArr.length];
        for (int i = 0; i < cVarArr.length; i++) {
            pVarArr[i] = a(cVarArr[i]);
        }
        return a(pVarArr);
    }

    public final p<org.jdeferred.b.c, org.jdeferred.b.e, b> a(d<?, ?>... dVarArr) {
        a((Object[]) dVarArr);
        p[] pVarArr = new p[dVarArr.length];
        for (int i = 0; i < dVarArr.length; i++) {
            pVarArr[i] = a(dVarArr[i]);
        }
        return a(pVarArr);
    }

    public final p<org.jdeferred.b.c, org.jdeferred.b.e, b> a(f<?>... fVarArr) {
        a((Object[]) fVarArr);
        p[] pVarArr = new p[fVarArr.length];
        for (int i = 0; i < fVarArr.length; i++) {
            pVarArr[i] = a(fVarArr[i]);
        }
        return a(pVarArr);
    }

    public p<org.jdeferred.b.c, org.jdeferred.b.e, b> a(p... pVarArr) {
        a((Object[]) pVarArr);
        return new org.jdeferred.b.a(pVarArr);
    }

    public abstract boolean a();

    /* access modifiers changed from: protected */
    public abstract void b(Runnable runnable);

    /* access modifiers changed from: protected */
    public abstract void b(Callable callable);
}

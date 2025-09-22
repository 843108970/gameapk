package org.jdeferred.a;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jdeferred.a;
import org.jdeferred.g;
import org.jdeferred.h;
import org.jdeferred.i;
import org.jdeferred.j;
import org.jdeferred.k;
import org.jdeferred.l;
import org.jdeferred.m;
import org.jdeferred.n;
import org.jdeferred.o;
import org.jdeferred.p;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class b<D, F, P> implements p<D, F, P> {

    /* renamed from: b  reason: collision with root package name */
    protected final Logger f4366b = LoggerFactory.getLogger(b.class);

    /* renamed from: c  reason: collision with root package name */
    protected volatile int f4367c = p.a.PENDING$173726b0;
    protected final List<g<D>> d = new CopyOnWriteArrayList();
    protected final List<j<F>> e = new CopyOnWriteArrayList();
    protected final List<m<P>> f = new CopyOnWriteArrayList();
    protected final List<a<D, F>> g = new CopyOnWriteArrayList();
    protected D h;
    protected F i;

    public final p<D, F, P> a(a<D, F> aVar) {
        synchronized (this) {
            if (c()) {
                this.g.add(aVar);
            } else {
                a(aVar, this.f4367c, this.h, this.i);
            }
        }
        return this;
    }

    public final p<D, F, P> a(g<D> gVar) {
        return b(gVar);
    }

    public final p<D, F, P> a(g<D> gVar, j<F> jVar) {
        b(gVar);
        a(jVar);
        return this;
    }

    public final p<D, F, P> a(g<D> gVar, j<F> jVar, m<P> mVar) {
        b(gVar);
        a(jVar);
        a(mVar);
        return this;
    }

    public final <D_OUT, F_OUT, P_OUT> p<D_OUT, F_OUT, P_OUT> a(h<D, D_OUT> hVar) {
        return new f(this, hVar, (k) null, (n) null);
    }

    public final <D_OUT, F_OUT, P_OUT> p<D_OUT, F_OUT, P_OUT> a(h<D, D_OUT> hVar, k<F, F_OUT> kVar) {
        return new f(this, hVar, kVar, (n) null);
    }

    public final <D_OUT, F_OUT, P_OUT> p<D_OUT, F_OUT, P_OUT> a(h<D, D_OUT> hVar, k<F, F_OUT> kVar, n<P, P_OUT> nVar) {
        return new f(this, hVar, kVar, nVar);
    }

    public final <D_OUT, F_OUT, P_OUT> p<D_OUT, F_OUT, P_OUT> a(i<D, D_OUT, F_OUT, P_OUT> iVar) {
        return new h(this, iVar, (l) null, (o) null);
    }

    public final <D_OUT, F_OUT, P_OUT> p<D_OUT, F_OUT, P_OUT> a(i<D, D_OUT, F_OUT, P_OUT> iVar, l<F, D_OUT, F_OUT, P_OUT> lVar) {
        return new h(this, iVar, lVar, (o) null);
    }

    public final <D_OUT, F_OUT, P_OUT> p<D_OUT, F_OUT, P_OUT> a(i<D, D_OUT, F_OUT, P_OUT> iVar, l<F, D_OUT, F_OUT, P_OUT> lVar, o<P, D_OUT, F_OUT, P_OUT> oVar) {
        return new h(this, iVar, lVar, oVar);
    }

    public final p<D, F, P> a(j<F> jVar) {
        synchronized (this) {
            if (e()) {
                a(jVar, this.i);
            } else {
                this.e.add(jVar);
            }
        }
        return this;
    }

    public final p<D, F, P> a(m<P> mVar) {
        this.f.add(mVar);
        return this;
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, D d2, F f2) {
        for (a a2 : this.g) {
            try {
                a(a2, i2, d2, f2);
            } catch (Exception e2) {
                this.f4366b.error("an uncaught exception occured in a AlwaysCallback", (Throwable) e2);
            }
        }
        this.g.clear();
        synchronized (this) {
            notifyAll();
        }
    }

    public final void a(long j) throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            while (c()) {
                if (j <= 0) {
                    try {
                        wait();
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        throw e2;
                    }
                } else {
                    wait(j - (System.currentTimeMillis() - currentTimeMillis));
                }
                if (j > 0) {
                    if (System.currentTimeMillis() - currentTimeMillis >= j) {
                        return;
                    }
                }
            }
        }
    }

    public void a(a<D, F> aVar, int i2, D d2, F f2) {
    }

    public void a(g<D> gVar, D d2) {
        gVar.a(d2);
    }

    public void a(j<F> jVar, F f2) {
        jVar.a(f2);
    }

    public void a(m<P> mVar, P p) {
        mVar.a(p);
    }

    public final int b() {
        return this.f4367c;
    }

    public final p<D, F, P> b(g<D> gVar) {
        synchronized (this) {
            if (d()) {
                a(gVar, this.h);
            } else {
                this.d.add(gVar);
            }
        }
        return this;
    }

    public final boolean c() {
        return this.f4367c == p.a.PENDING$173726b0;
    }

    /* access modifiers changed from: protected */
    public final void d(D d2) {
        for (g a2 : this.d) {
            try {
                a(a2, d2);
            } catch (Exception e2) {
                this.f4366b.error("an uncaught exception occured in a DoneCallback", (Throwable) e2);
            }
        }
        this.d.clear();
    }

    public final boolean d() {
        return this.f4367c == p.a.RESOLVED$173726b0;
    }

    /* access modifiers changed from: protected */
    public final void e(F f2) {
        for (j a2 : this.e) {
            try {
                a(a2, f2);
            } catch (Exception e2) {
                this.f4366b.error("an uncaught exception occured in a FailCallback", (Throwable) e2);
            }
        }
        this.e.clear();
    }

    public final boolean e() {
        return this.f4367c == p.a.REJECTED$173726b0;
    }

    public final void f() throws InterruptedException {
        a(-1);
    }

    /* access modifiers changed from: protected */
    public final void f(P p) {
        for (m a2 : this.f) {
            try {
                a(a2, p);
            } catch (Exception e2) {
                this.f4366b.error("an uncaught exception occured in a ProgressCallback", (Throwable) e2);
            }
        }
    }
}

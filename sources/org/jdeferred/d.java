package org.jdeferred;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.jdeferred.e;

public final class d<D, P> extends FutureTask<D> {

    /* renamed from: a  reason: collision with root package name */
    protected final b<D, Throwable, P> f4418a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f4419b;

    public d(Runnable runnable) {
        super(runnable, (Object) null);
        this.f4418a = new org.jdeferred.a.d();
        this.f4419b = e.a.DEFAULT$273301ba;
    }

    public d(Callable<D> callable) {
        super(callable);
        this.f4418a = new org.jdeferred.a.d();
        this.f4419b = e.a.DEFAULT$273301ba;
    }

    public d(c<D, P> cVar) {
        super(cVar);
        this.f4418a = cVar.f4416a;
        this.f4419b = cVar.f4417b;
    }

    public d(f<P> fVar) {
        super(fVar, (Object) null);
        this.f4418a = fVar.f4420a;
        this.f4419b = fVar.f4421b;
    }

    public final p<D, Throwable, P> a() {
        return this.f4418a.a();
    }

    public final int b() {
        return this.f4419b;
    }

    /* access modifiers changed from: protected */
    public final void done() {
        try {
            if (isCancelled()) {
                this.f4418a.b(new CancellationException());
            }
            this.f4418a.a(get());
        } catch (InterruptedException unused) {
        } catch (ExecutionException e) {
            this.f4418a.b(e.getCause());
        }
    }
}

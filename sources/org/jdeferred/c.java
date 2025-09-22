package org.jdeferred;

import java.util.concurrent.Callable;
import org.jdeferred.a.d;
import org.jdeferred.e;

public abstract class c<D, P> implements Callable<D> {

    /* renamed from: a  reason: collision with root package name */
    final b<D, Throwable, P> f4416a;

    /* renamed from: b  reason: collision with root package name */
    final int f4417b;

    public c() {
        this.f4416a = new d();
        this.f4417b = e.a.DEFAULT$273301ba;
    }

    public c(int i) {
        this.f4416a = new d();
        this.f4417b = i;
    }

    private b<D, Throwable, P> a() {
        return this.f4416a;
    }

    private void a(P p) {
        this.f4416a.c(p);
    }

    private int b() {
        return this.f4417b;
    }
}

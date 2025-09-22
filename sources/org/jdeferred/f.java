package org.jdeferred;

import org.jdeferred.a.d;
import org.jdeferred.e;

public abstract class f<P> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final b<Void, Throwable, P> f4420a;

    /* renamed from: b  reason: collision with root package name */
    final int f4421b;

    public f() {
        this.f4420a = new d();
        this.f4421b = e.a.DEFAULT$273301ba;
    }

    private f(int i) {
        this.f4420a = new d();
        this.f4421b = i;
    }

    private b<Void, Throwable, P> a() {
        return this.f4420a;
    }

    private void a(P p) {
        this.f4420a.c(p);
    }

    private int b() {
        return this.f4421b;
    }
}

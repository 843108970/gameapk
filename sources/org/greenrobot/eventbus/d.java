package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class d {
    private static final ExecutorService l = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    boolean f4309a = true;

    /* renamed from: b  reason: collision with root package name */
    boolean f4310b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f4311c = true;
    boolean d = true;
    boolean e;
    boolean f = true;
    boolean g;
    boolean h;
    ExecutorService i = l;
    List<Class<?>> j;
    List<org.greenrobot.eventbus.a.d> k;

    d() {
    }

    private c a() {
        c cVar;
        synchronized (c.class) {
            if (c.f4302b != null) {
                throw new e("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
            cVar = new c(this);
            c.f4302b = cVar;
        }
        return cVar;
    }

    private d a(Class<?> cls) {
        if (this.j == null) {
            this.j = new ArrayList();
        }
        this.j.add(cls);
        return this;
    }

    private d a(ExecutorService executorService) {
        this.i = executorService;
        return this;
    }

    private d a(org.greenrobot.eventbus.a.d dVar) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(dVar);
        return this;
    }

    private d a(boolean z) {
        this.f4309a = z;
        return this;
    }

    private c b() {
        return new c(this);
    }

    private d b(boolean z) {
        this.f4310b = z;
        return this;
    }

    private d c(boolean z) {
        this.f4311c = z;
        return this;
    }

    private d d(boolean z) {
        this.d = z;
        return this;
    }

    private d e(boolean z) {
        this.e = z;
        return this;
    }

    private d f(boolean z) {
        this.f = z;
        return this;
    }

    private d g(boolean z) {
        this.g = z;
        return this;
    }

    private d h(boolean z) {
        this.h = z;
        return this;
    }
}

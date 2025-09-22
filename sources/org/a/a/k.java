package org.a.a;

import org.a.b;
import org.a.g;
import org.a.i;
import org.a.m;

public final class k<T> extends b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final org.a.k<T> f4256a;

    private k(org.a.k<T> kVar) {
        this.f4256a = kVar;
    }

    @i
    public static <T> org.a.k<T> a(org.a.k<T> kVar) {
        return new k(kVar);
    }

    @i
    private static <T> org.a.k<T> b(T t) {
        return a(i.b(t));
    }

    public final boolean a(Object obj) {
        return !this.f4256a.a(obj);
    }

    public final void describeTo(g gVar) {
        gVar.a("not ").a((m) this.f4256a);
    }
}

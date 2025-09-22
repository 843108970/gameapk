package org.a.a;

import org.a.b;
import org.a.g;
import org.a.i;
import org.a.k;
import org.a.m;

public final class f<T> extends b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final k<T> f4250a;

    private f(k<T> kVar) {
        this.f4250a = kVar;
    }

    @Deprecated
    @i
    private static <T> k<T> a(Class<T> cls) {
        return a(j.a(cls));
    }

    @i
    public static <T> k<T> a(k<T> kVar) {
        return new f(kVar);
    }

    @i
    private static <T> k<T> b(Class<T> cls) {
        return a(j.a(cls));
    }

    @i
    private static <T> k<T> b(T t) {
        return a(i.b(t));
    }

    public final void a(Object obj, g gVar) {
        this.f4250a.a(obj, gVar);
    }

    public final boolean a(Object obj) {
        return this.f4250a.a(obj);
    }

    public final void describeTo(g gVar) {
        gVar.a("is ").a((m) this.f4250a);
    }
}

package org.a.a;

import org.a.b;
import org.a.g;
import org.a.i;
import org.a.k;

public final class m<T> extends b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f4257a;

    public m(T t) {
        this.f4257a = t;
    }

    @i
    private static <T> k<T> b(T t) {
        return new m(t);
    }

    @i
    private static <T> k<T> c(T t) {
        return new m(t);
    }

    public final boolean a(Object obj) {
        return obj == this.f4257a;
    }

    public final void describeTo(g gVar) {
        gVar.a("sameInstance(").a((Object) this.f4257a).a(")");
    }
}

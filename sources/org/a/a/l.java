package org.a.a;

import org.a.b;
import org.a.g;
import org.a.i;
import org.a.k;

public final class l<T> extends b<T> {
    @i
    private static k<Object> b() {
        return new l();
    }

    @i
    private static k<Object> c() {
        return k.a(new l());
    }

    @i
    private static <T> k<T> d() {
        return new l();
    }

    @i
    private static <T> k<T> e() {
        return k.a(new l());
    }

    public final boolean a(Object obj) {
        return obj == null;
    }

    public final void describeTo(g gVar) {
        gVar.a("null");
    }
}

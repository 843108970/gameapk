package org.junit.c;

import org.a.a.c;
import org.a.a.e;
import org.a.a.h;
import org.a.a.o;
import org.a.k;

public final class a {
    @Deprecated
    private static <T> k<Iterable<? super T>> a(T t) {
        return h.b(t);
    }

    @Deprecated
    private static k<String> a(String str) {
        return o.b(str);
    }

    @Deprecated
    private static <T> k<Iterable<? super T>> a(k<? super T> kVar) {
        return h.a(kVar);
    }

    @Deprecated
    private static <T> k<Iterable<T>> a(T... tArr) {
        return h.a(tArr);
    }

    @Deprecated
    private static <T> k<Iterable<T>> a(k<? super T>... kVarArr) {
        return h.a(kVarArr);
    }

    @Deprecated
    private static <T> k<Iterable<T>> b(k<T> kVar) {
        return e.a(kVar);
    }

    @Deprecated
    private static <T> c.a<T> c(k<? super T> kVar) {
        return c.b(kVar);
    }

    @Deprecated
    private static <T> c.b<T> d(k<? super T> kVar) {
        return c.c(kVar);
    }

    private static <T extends Throwable> k<T> e(k<T> kVar) {
        return org.junit.b.b.a.a(kVar);
    }

    private static <T extends Exception> k<T> f(k<T> kVar) {
        return org.junit.b.b.a.b(kVar);
    }
}

package org.junit.d;

import org.junit.e.a.j;
import org.junit.runner.c;

public final class h extends j {

    /* renamed from: a  reason: collision with root package name */
    private final j f4543a;

    public h(j jVar, Iterable<l> iterable, c cVar) {
        for (l a2 : iterable) {
            jVar = a2.a(jVar, cVar);
        }
        this.f4543a = jVar;
    }

    private static j a(j jVar, Iterable<l> iterable, c cVar) {
        for (l a2 : iterable) {
            jVar = a2.a(jVar, cVar);
        }
        return jVar;
    }

    public final void a() throws Throwable {
        this.f4543a.a();
    }
}

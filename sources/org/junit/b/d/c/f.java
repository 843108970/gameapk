package org.junit.b.d.c;

import java.util.List;
import org.junit.e.a.d;
import org.junit.e.a.j;

public final class f extends j {

    /* renamed from: a  reason: collision with root package name */
    private final j f4501a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f4502b;

    /* renamed from: c  reason: collision with root package name */
    private final List<d> f4503c;

    public f(j jVar, List<d> list, Object obj) {
        this.f4501a = jVar;
        this.f4503c = list;
        this.f4502b = obj;
    }

    public final void a() throws Throwable {
        for (d a2 : this.f4503c) {
            a2.a(this.f4502b, new Object[0]);
        }
        this.f4501a.a();
    }
}

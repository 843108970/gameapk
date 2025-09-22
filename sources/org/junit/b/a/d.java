package org.junit.b.a;

import org.junit.runner.b.c;
import org.junit.runner.k;

public final class d extends k {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f4460a;

    public d(Class<?> cls) {
        this.f4460a = cls;
    }

    public final void a(c cVar) {
        cVar.b(org.junit.runner.c.createSuiteDescription(this.f4460a));
    }

    public final org.junit.runner.c b() {
        return org.junit.runner.c.createSuiteDescription(this.f4460a);
    }
}

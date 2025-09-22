package org.junit.b.c;

import java.util.Comparator;
import org.junit.runner.a.e;
import org.junit.runner.h;
import org.junit.runner.k;

public final class c extends h {

    /* renamed from: a  reason: collision with root package name */
    private final h f4470a;

    /* renamed from: b  reason: collision with root package name */
    private final Comparator<org.junit.runner.c> f4471b;

    public c(h hVar, Comparator<org.junit.runner.c> comparator) {
        this.f4470a = hVar;
        this.f4471b = comparator;
    }

    public final k a() {
        k a2 = this.f4470a.a();
        new e(this.f4471b).a(a2);
        return a2;
    }
}

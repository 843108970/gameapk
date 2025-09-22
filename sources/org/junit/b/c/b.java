package org.junit.b.c;

import org.junit.runner.a.a;
import org.junit.runner.a.c;
import org.junit.runner.h;
import org.junit.runner.k;

public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    private final h f4468a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4469b;

    public b(h hVar, a aVar) {
        this.f4468a = hVar;
        this.f4469b = aVar;
    }

    public final k a() {
        try {
            k a2 = this.f4468a.a();
            this.f4469b.a((Object) a2);
            return a2;
        } catch (c unused) {
            return new org.junit.b.d.b(a.class, new Exception(String.format("No tests found matching %s from %s", new Object[]{this.f4469b.a(), this.f4468a.toString()})));
        }
    }
}

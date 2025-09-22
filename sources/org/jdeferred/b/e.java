package org.jdeferred.b;

import org.jdeferred.p;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final int f4410a;

    /* renamed from: b  reason: collision with root package name */
    private final p f4411b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f4412c;

    public e(int i, p pVar, Object obj) {
        this.f4410a = i;
        this.f4411b = pVar;
        this.f4412c = obj;
    }

    private int a() {
        return this.f4410a;
    }

    private p b() {
        return this.f4411b;
    }

    private Object c() {
        return this.f4412c;
    }

    public final String toString() {
        return "OneReject [index=" + this.f4410a + ", promise=" + this.f4411b + ", reject=" + this.f4412c + "]";
    }
}

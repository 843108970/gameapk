package org.jdeferred.b;

import org.jdeferred.p;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final int f4413a;

    /* renamed from: b  reason: collision with root package name */
    private final p f4414b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f4415c;

    public f(int i, p pVar, Object obj) {
        this.f4413a = i;
        this.f4414b = pVar;
        this.f4415c = obj;
    }

    private int a() {
        return this.f4413a;
    }

    private p b() {
        return this.f4414b;
    }

    private Object c() {
        return this.f4415c;
    }

    public final String toString() {
        return "OneResult [index=" + this.f4413a + ", promise=" + this.f4414b + ", result=" + this.f4415c + "]";
    }
}

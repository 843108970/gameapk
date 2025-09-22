package org.junit.b.c;

import org.junit.runner.h;
import org.junit.runner.k;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Object f4465a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f4466b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4467c;
    private volatile k d;

    public a(Class<?> cls) {
        this(cls, true);
    }

    public a(Class<?> cls, boolean z) {
        this.f4465a = new Object();
        this.f4466b = cls;
        this.f4467c = z;
    }

    public final k a() {
        if (this.d == null) {
            synchronized (this.f4465a) {
                if (this.d == null) {
                    this.d = new org.junit.b.a.a(this.f4467c).b(this.f4466b);
                }
            }
        }
        return this.d;
    }
}

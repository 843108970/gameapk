package com.google.a.g.a.a.a;

import com.google.a.h;

final class p extends q {

    /* renamed from: c  reason: collision with root package name */
    static final int f3167c = 10;

    /* renamed from: a  reason: collision with root package name */
    final int f3168a;

    /* renamed from: b  reason: collision with root package name */
    final int f3169b;

    p(int i, int i2, int i3) throws h {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw h.getFormatInstance();
        }
        this.f3168a = i2;
        this.f3169b = i3;
    }

    private int b() {
        return this.f3168a;
    }

    private int c() {
        return this.f3169b;
    }

    private int d() {
        return (this.f3168a * 10) + this.f3169b;
    }

    private boolean e() {
        return this.f3168a == 10;
    }

    private boolean f() {
        return this.f3168a == 10 || this.f3169b == 10;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.f3169b == 10;
    }
}

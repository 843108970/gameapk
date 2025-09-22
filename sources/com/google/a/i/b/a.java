package com.google.a.i.b;

import com.google.a.t;

public final class a extends t {

    /* renamed from: c  reason: collision with root package name */
    final float f3316c;

    a(float f, float f2, float f3) {
        super(f, f2);
        this.f3316c = f3;
    }

    private boolean a(float f, float f2, float f3) {
        if (Math.abs(f2 - this.f3357b) > f || Math.abs(f3 - this.f3356a) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f3316c);
        return abs <= 1.0f || abs <= this.f3316c;
    }

    private a b(float f, float f2, float f3) {
        return new a((this.f3356a + f2) / 2.0f, (this.f3357b + f) / 2.0f, (this.f3316c + f3) / 2.0f);
    }
}

package com.google.a.i.b;

import com.google.a.t;

public final class d extends t {

    /* renamed from: c  reason: collision with root package name */
    public final float f3322c;
    final int d;

    d(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    d(float f, float f2, float f3, int i) {
        super(f, f2);
        this.f3322c = f3;
        this.d = i;
    }

    private float a() {
        return this.f3322c;
    }

    private boolean a(float f, float f2, float f3) {
        if (Math.abs(f2 - this.f3357b) > f || Math.abs(f3 - this.f3356a) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f3322c);
        return abs <= 1.0f || abs <= this.f3322c;
    }

    private int b() {
        return this.d;
    }

    private d b(float f, float f2, float f3) {
        int i = this.d + 1;
        float f4 = (((float) this.d) * this.f3356a) + f2;
        float f5 = (float) i;
        return new d(f4 / f5, ((((float) this.d) * this.f3357b) + f) / f5, ((((float) this.d) * this.f3322c) + f3) / f5, i);
    }
}

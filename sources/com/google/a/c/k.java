package com.google.a.c;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    final float f3083a;

    /* renamed from: b  reason: collision with root package name */
    final float f3084b;

    /* renamed from: c  reason: collision with root package name */
    final float f3085c;
    final float d;
    final float e;
    final float f;
    final float g;
    final float h;
    final float i;

    private k(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f3083a = f2;
        this.f3084b = f5;
        this.f3085c = f8;
        this.d = f3;
        this.e = f6;
        this.f = f9;
        this.g = f4;
        this.h = f7;
        this.i = f10;
    }

    private k a() {
        return new k((this.e * this.i) - (this.f * this.h), (this.f * this.g) - (this.d * this.i), (this.d * this.h) - (this.e * this.g), (this.f3085c * this.h) - (this.f3084b * this.i), (this.f3083a * this.i) - (this.f3085c * this.g), (this.f3084b * this.g) - (this.f3083a * this.h), (this.f3084b * this.f) - (this.f3085c * this.e), (this.f3085c * this.d) - (this.f3083a * this.f), (this.f3083a * this.e) - (this.f3084b * this.d));
    }

    private static k a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = ((f2 - f4) + f6) - f8;
        float f11 = ((f3 - f5) + f7) - f9;
        if (f10 == 0.0f && f11 == 0.0f) {
            return new k(f4 - f2, f6 - f4, f2, f5 - f3, f7 - f5, f3, 0.0f, 0.0f, 1.0f);
        }
        float f12 = f4 - f6;
        float f13 = f8 - f6;
        float f14 = f5 - f7;
        float f15 = f9 - f7;
        float f16 = (f12 * f15) - (f13 * f14);
        float f17 = ((f15 * f10) - (f13 * f11)) / f16;
        float f18 = ((f12 * f11) - (f10 * f14)) / f16;
        return new k((f4 - f2) + (f17 * f4), (f18 * f8) + (f8 - f2), f2, (f5 - f3) + (f17 * f5), (f9 - f3) + (f18 * f9), f3, f17, f18, 1.0f);
    }

    public static k a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        k a2 = a(f2, f3, f4, f5, f6, f7, f8, f9);
        k kVar = new k((a2.e * a2.i) - (a2.f * a2.h), (a2.f * a2.g) - (a2.d * a2.i), (a2.d * a2.h) - (a2.e * a2.g), (a2.f3085c * a2.h) - (a2.f3084b * a2.i), (a2.f3083a * a2.i) - (a2.f3085c * a2.g), (a2.f3084b * a2.g) - (a2.f3083a * a2.h), (a2.f3084b * a2.f) - (a2.f3085c * a2.e), (a2.f3085c * a2.d) - (a2.f3083a * a2.f), (a2.f3083a * a2.e) - (a2.f3084b * a2.d));
        k a3 = a(f10, f11, f12, f13, f14, f15, f16, f17);
        return new k((a3.g * kVar.f3085c) + (a3.f3083a * kVar.f3083a) + (a3.d * kVar.f3084b), (a3.g * kVar.f) + (a3.f3083a * kVar.d) + (a3.d * kVar.e), (a3.g * kVar.i) + (a3.f3083a * kVar.g) + (a3.d * kVar.h), (a3.h * kVar.f3085c) + (a3.f3084b * kVar.f3083a) + (a3.e * kVar.f3084b), (a3.h * kVar.f) + (a3.f3084b * kVar.d) + (a3.e * kVar.e), (a3.h * kVar.i) + (a3.f3084b * kVar.g) + (a3.e * kVar.h), (a3.i * kVar.f3085c) + (a3.f3085c * kVar.f3083a) + (a3.f * kVar.f3084b), (a3.i * kVar.f) + (a3.f3085c * kVar.d) + (a3.f * kVar.e), (a3.f3085c * kVar.g) + (a3.f * kVar.h) + (a3.i * kVar.i));
    }

    private k a(k kVar) {
        return new k((this.g * kVar.f3085c) + (this.f3083a * kVar.f3083a) + (this.d * kVar.f3084b), (this.g * kVar.f) + (this.f3083a * kVar.d) + (this.d * kVar.e), (this.g * kVar.i) + (this.f3083a * kVar.g) + (this.d * kVar.h), (this.h * kVar.f3085c) + (this.f3084b * kVar.f3083a) + (this.e * kVar.f3084b), (this.h * kVar.f) + (this.f3084b * kVar.d) + (this.e * kVar.e), (this.h * kVar.i) + (this.f3084b * kVar.g) + (this.e * kVar.h), (this.i * kVar.f3085c) + (this.f3085c * kVar.f3083a) + (this.f * kVar.f3084b), (this.i * kVar.f) + (this.f3085c * kVar.d) + (this.f * kVar.e), (this.i * kVar.i) + (this.f3085c * kVar.g) + (this.f * kVar.h));
    }

    private void a(float[] fArr) {
        float[] fArr2 = fArr;
        int length = fArr2.length;
        float f2 = this.f3083a;
        float f3 = this.f3084b;
        float f4 = this.f3085c;
        float f5 = this.d;
        float f6 = this.e;
        float f7 = this.f;
        float f8 = this.g;
        float f9 = this.h;
        float f10 = this.i;
        for (int i2 = 0; i2 < length; i2 += 2) {
            float f11 = fArr2[i2];
            int i3 = i2 + 1;
            float f12 = fArr2[i3];
            float f13 = (f4 * f11) + (f7 * f12) + f10;
            fArr2[i2] = (((f2 * f11) + (f5 * f12)) + f8) / f13;
            fArr2[i3] = (((f11 * f3) + (f12 * f6)) + f9) / f13;
        }
    }

    private void a(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr[i2];
            float f3 = fArr2[i2];
            float f4 = (this.f3085c * f2) + (this.f * f3) + this.i;
            fArr[i2] = (((this.f3083a * f2) + (this.d * f3)) + this.g) / f4;
            fArr2[i2] = (((this.f3084b * f2) + (this.e * f3)) + this.h) / f4;
        }
    }

    private static k b(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        k a2 = a(f2, f3, f4, f5, f6, f7, f8, f9);
        return new k((a2.e * a2.i) - (a2.f * a2.h), (a2.f * a2.g) - (a2.d * a2.i), (a2.d * a2.h) - (a2.e * a2.g), (a2.f3085c * a2.h) - (a2.f3084b * a2.i), (a2.f3083a * a2.i) - (a2.f3085c * a2.g), (a2.f3084b * a2.g) - (a2.f3083a * a2.h), (a2.f3084b * a2.f) - (a2.f3085c * a2.e), (a2.f3085c * a2.d) - (a2.f3083a * a2.f), (a2.f3083a * a2.e) - (a2.f3084b * a2.d));
    }
}

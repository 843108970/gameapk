package com.google.a.h.a.a;

import com.google.a.h.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f3239a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final int[] f3240b = new int[a.f3232a];

    /* renamed from: c  reason: collision with root package name */
    public final int[] f3241c = new int[a.f3232a];
    public final c d;
    public final c e;
    final int f = a.f3232a;

    private b() {
        int i = 1;
        for (int i2 = 0; i2 < 929; i2++) {
            this.f3240b[i2] = i;
            i = (i * 3) % a.f3232a;
        }
        for (int i3 = 0; i3 < 928; i3++) {
            this.f3241c[this.f3240b[i3]] = i3;
        }
        this.d = new c(this, new int[]{0});
        this.e = new c(this, new int[]{1});
    }

    private c a() {
        return this.d;
    }

    private int b(int i) {
        return this.f3240b[i];
    }

    private c b() {
        return this.e;
    }

    private int c() {
        return this.f;
    }

    private int c(int i) {
        if (i != 0) {
            return this.f3241c[i];
        }
        throw new IllegalArgumentException();
    }

    public final int a(int i) {
        if (i != 0) {
            return this.f3240b[(this.f - this.f3241c[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public final c a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.d;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new c(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final int b(int i, int i2) {
        return (i + i2) % this.f;
    }

    public final int c(int i, int i2) {
        return ((this.f + i) - i2) % this.f;
    }

    public final int d(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.f3240b[(this.f3241c[i] + this.f3241c[i2]) % (this.f - 1)];
    }
}

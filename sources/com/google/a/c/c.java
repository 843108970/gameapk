package com.google.a.c;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f3072a;

    /* renamed from: b  reason: collision with root package name */
    public int f3073b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f3074c;

    public c(byte[] bArr) {
        this.f3074c = bArr;
    }

    private int b() {
        return this.f3073b;
    }

    private int c() {
        return this.f3072a;
    }

    public final int a() {
        return ((this.f3074c.length - this.f3072a) * 8) - this.f3073b;
    }

    public final int a(int i) {
        byte b2;
        if (i <= 0 || i > 32 || i > a()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        if (this.f3073b > 0) {
            int i2 = 8 - this.f3073b;
            int i3 = i < i2 ? i : i2;
            int i4 = i2 - i3;
            b2 = (((255 >> (8 - i3)) << i4) & this.f3074c[this.f3072a]) >> i4;
            i -= i3;
            this.f3073b += i3;
            if (this.f3073b == 8) {
                this.f3073b = 0;
                this.f3072a++;
            }
        } else {
            b2 = 0;
        }
        if (i <= 0) {
            return b2;
        }
        while (i >= 8) {
            b2 = (b2 << 8) | (this.f3074c[this.f3072a] & 255);
            this.f3072a++;
            i -= 8;
        }
        if (i <= 0) {
            return b2;
        }
        int i5 = 8 - i;
        int i6 = (b2 << i) | ((((255 >> i5) << i5) & this.f3074c[this.f3072a]) >> i5);
        this.f3073b += i;
        return i6;
    }
}

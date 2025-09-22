package com.zbar.a.c;

public final class c extends b {
    private static final int g = 2;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f4014c;
    public final int d;
    public final int e;
    public final int f;
    private final int h;

    public c(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i5 + i3 > i || i6 + i4 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f4014c = bArr;
        this.d = i;
        this.h = i2;
        this.e = i3;
        this.f = i4;
    }

    private void a(int i, int i2) {
        byte[] bArr = this.f4014c;
        int i3 = (this.f * this.d) + this.e;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = (i / 2) + i3;
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b2 = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b2;
                i7++;
                i6--;
            }
            i4++;
            i3 += this.d;
        }
    }

    private int[] g() {
        int i = this.f4012a / 2;
        int i2 = this.f4013b / 2;
        int[] iArr = new int[(i * i2)];
        byte[] bArr = this.f4014c;
        int i3 = (this.f * this.d) + this.e;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * i;
            for (int i6 = 0; i6 < i; i6++) {
                iArr[i5 + i6] = ((bArr[(i6 * 2) + i3] & 255) * 65793) | -16777216;
            }
            i3 += this.d * 2;
        }
        return iArr;
    }

    private int h() {
        return this.f4012a / 2;
    }

    private int i() {
        return this.f4013b / 2;
    }

    public final b a(int i, int i2, int i3, int i4) {
        return new c(this.f4014c, this.d, this.h, this.e + i, this.f + i2, i3, i4);
    }

    public final byte[] a() {
        int i = this.f4012a;
        int i2 = this.f4013b;
        if (i == this.d && i2 == this.h) {
            return this.f4014c;
        }
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        int i4 = (this.f * this.d) + this.e;
        if (i == this.d) {
            System.arraycopy(this.f4014c, i4, bArr, 0, i3);
            return bArr;
        }
        byte[] bArr2 = this.f4014c;
        for (int i5 = 0; i5 < i2; i5++) {
            System.arraycopy(bArr2, i4, bArr, i5 * i, i);
            i4 += this.d;
        }
        return bArr;
    }

    public final byte[] a(int i, byte[] bArr) {
        if (i < 0 || i >= this.f4013b) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int i2 = this.f4012a;
        if (bArr == null || bArr.length < i2) {
            bArr = new byte[i2];
        }
        System.arraycopy(this.f4014c, ((i + this.f) * this.d) + this.e, bArr, 0, i2);
        return bArr;
    }

    public final boolean b() {
        return true;
    }
}

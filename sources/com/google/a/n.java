package com.google.a;

public final class n extends j {

    /* renamed from: c  reason: collision with root package name */
    private static final int f3351c = 2;
    private final byte[] d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;

    private n(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i5 + i3 > i || i6 + i4 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.d = bArr;
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
    }

    private void a(int i, int i2) {
        byte[] bArr = this.d;
        int i3 = (this.h * this.e) + this.g;
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
            i3 += this.e;
        }
    }

    private int[] g() {
        int i = this.f3346a / 2;
        int i2 = this.f3347b / 2;
        int[] iArr = new int[(i * i2)];
        byte[] bArr = this.d;
        int i3 = (this.h * this.e) + this.g;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * i;
            for (int i6 = 0; i6 < i; i6++) {
                iArr[i5 + i6] = ((bArr[(i6 << 1) + i3] & 255) * 65793) | -16777216;
            }
            i3 += this.e << 1;
        }
        return iArr;
    }

    private int h() {
        return this.f3346a / 2;
    }

    private int i() {
        return this.f3347b / 2;
    }

    public final j a(int i, int i2, int i3, int i4) {
        return new n(this.d, this.e, this.f, this.g + i, this.h + i2, i3, i4);
    }

    public final byte[] a() {
        int i = this.f3346a;
        int i2 = this.f3347b;
        if (i == this.e && i2 == this.f) {
            return this.d;
        }
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        int i4 = (this.h * this.e) + this.g;
        if (i == this.e) {
            System.arraycopy(this.d, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            System.arraycopy(this.d, i4, bArr, i5 * i, i);
            i4 += this.e;
        }
        return bArr;
    }

    public final byte[] a(int i, byte[] bArr) {
        if (i < 0 || i >= this.f3347b) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i)));
        }
        int i2 = this.f3346a;
        if (bArr == null || bArr.length < i2) {
            bArr = new byte[i2];
        }
        System.arraycopy(this.d, ((i + this.h) * this.e) + this.g, bArr, 0, i2);
        return bArr;
    }

    public final boolean b() {
        return true;
    }
}

package com.google.a;

public final class o extends j {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f3352c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public o(int i, int i2, int[] iArr) {
        super(i, i2);
        this.d = i;
        this.e = i2;
        this.f = 0;
        this.g = 0;
        int i3 = i * i2;
        this.f3352c = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            this.f3352c[i4] = (byte) (((((i5 >> 16) & 255) + ((i5 >> 7) & 510)) + (i5 & 255)) / 4);
        }
    }

    private o(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i5 + i3 > i || i6 + i4 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f3352c = bArr;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }

    public final j a(int i, int i2, int i3, int i4) {
        return new o(this.f3352c, this.d, this.e, this.f + i, this.g + i2, i3, i4);
    }

    public final byte[] a() {
        int i = this.f3346a;
        int i2 = this.f3347b;
        if (i == this.d && i2 == this.e) {
            return this.f3352c;
        }
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        int i4 = (this.g * this.d) + this.f;
        if (i == this.d) {
            System.arraycopy(this.f3352c, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            System.arraycopy(this.f3352c, i4, bArr, i5 * i, i);
            i4 += this.d;
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
        System.arraycopy(this.f3352c, ((i + this.g) * this.d) + this.f, bArr, 0, i2);
        return bArr;
    }

    public final boolean b() {
        return true;
    }
}

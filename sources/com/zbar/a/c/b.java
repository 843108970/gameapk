package com.zbar.a.c;

import org.apache.commons.io.FilenameUtils;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f4012a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4013b;

    protected b(int i, int i2) {
        this.f4012a = i;
        this.f4013b = i2;
    }

    private int g() {
        return this.f4012a;
    }

    private int h() {
        return this.f4013b;
    }

    public b a(int i, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public abstract byte[] a();

    public abstract byte[] a(int i, byte[] bArr);

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public b d() {
        return new a(this);
    }

    public b e() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public b f() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.f4013b * (this.f4012a + 1));
        byte[] bArr = new byte[this.f4012a];
        for (int i = 0; i < this.f4013b; i++) {
            bArr = a(i, bArr);
            for (int i2 = 0; i2 < this.f4012a; i2++) {
                byte b2 = bArr[i2] & 255;
                sb.append(b2 < 64 ? '#' : b2 < 128 ? '+' : b2 < 192 ? FilenameUtils.EXTENSION_SEPARATOR : ' ');
            }
            sb.append(10);
        }
        return sb.toString();
    }
}

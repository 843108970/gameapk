package com.google.a;

import org.apache.commons.io.FilenameUtils;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public final int f3346a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3347b;

    protected j(int i, int i2) {
        this.f3346a = i;
        this.f3347b = i2;
    }

    private int g() {
        return this.f3346a;
    }

    private int h() {
        return this.f3347b;
    }

    public j a(int i, int i2, int i3, int i4) {
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

    public j d() {
        return new i(this);
    }

    public j e() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public j f() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.f3347b * (this.f3346a + 1));
        byte[] bArr = new byte[this.f3346a];
        for (int i = 0; i < this.f3347b; i++) {
            bArr = a(i, bArr);
            for (int i2 = 0; i2 < this.f3346a; i2++) {
                byte b2 = bArr[i2] & 255;
                sb.append(b2 < 64 ? '#' : b2 < 128 ? '+' : b2 < 192 ? FilenameUtils.EXTENSION_SEPARATOR : ' ');
            }
            sb.append(10);
        }
        return sb.toString();
    }
}

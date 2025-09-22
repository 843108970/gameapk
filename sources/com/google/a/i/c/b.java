package com.google.a.i.c;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final byte[][] f3331a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3332b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3333c;

    public b(int i, int i2) {
        this.f3331a = (byte[][]) Array.newInstance(byte.class, new int[]{i2, i});
        this.f3332b = i;
        this.f3333c = i2;
    }

    private int a() {
        return this.f3333c;
    }

    private void a(int i, int i2, byte b2) {
        this.f3331a[i2][i] = b2;
    }

    private int b() {
        return this.f3332b;
    }

    private byte[][] c() {
        return this.f3331a;
    }

    private void d() {
        for (byte[] fill : this.f3331a) {
            Arrays.fill(fill, (byte) -1);
        }
    }

    public final byte a(int i, int i2) {
        return this.f3331a[i2][i];
    }

    public final void a(int i, int i2, int i3) {
        this.f3331a[i2][i] = (byte) i3;
    }

    public final void a(int i, int i2, boolean z) {
        this.f3331a[i2][i] = z ? (byte) 1 : 0;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder((this.f3332b * 2 * this.f3333c) + 2);
        for (int i = 0; i < this.f3333c; i++) {
            byte[] bArr = this.f3331a[i];
            for (int i2 = 0; i2 < this.f3332b; i2++) {
                switch (bArr[i2]) {
                    case 0:
                        str = " 0";
                        break;
                    case 1:
                        str = " 1";
                        break;
                    default:
                        str = "  ";
                        break;
                }
                sb.append(str);
            }
            sb.append(10);
        }
        return sb.toString();
    }
}

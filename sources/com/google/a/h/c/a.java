package com.google.a.h.c;

import java.lang.reflect.Array;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    int f3274a;

    /* renamed from: b  reason: collision with root package name */
    private final b[] f3275b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3276c;
    private final int d;

    public a(int i, int i2) {
        this.f3275b = new b[i];
        int length = this.f3275b.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f3275b[i3] = new b(((i2 + 4) * 17) + 1);
        }
        this.d = i2 * 17;
        this.f3276c = i;
        this.f3274a = -1;
    }

    private void a(int i, int i2, byte b2) {
        this.f3275b[i2].f3277a[i] = b2;
    }

    private void b() {
        this.f3274a++;
    }

    private byte[][] c() {
        return a(1, 1);
    }

    /* access modifiers changed from: package-private */
    public final b a() {
        return this.f3275b[this.f3274a];
    }

    public final byte[][] a(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, new int[]{this.f3276c * i2, this.d * i});
        int i3 = this.f3276c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = (i3 - i4) - 1;
            b bVar = this.f3275b[i4 / i2];
            byte[] bArr2 = new byte[(bVar.f3277a.length * i)];
            for (int i6 = 0; i6 < bArr2.length; i6++) {
                bArr2[i6] = bVar.f3277a[i6 / i];
            }
            bArr[i5] = bArr2;
        }
        return bArr;
    }
}

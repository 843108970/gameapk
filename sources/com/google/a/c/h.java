package com.google.a.c;

import com.google.a.b;
import com.google.a.j;
import com.google.a.m;

public class h extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final int f3078b = 5;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3079c = 3;
    private static final int d = 32;
    private static final byte[] e = new byte[0];
    private byte[] f = e;
    private final int[] g = new int[32];

    public h(j jVar) {
        super(jVar);
    }

    private static int a(int[] iArr) throws m {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] > i) {
                i = iArr[i4];
                i3 = i4;
            }
            if (iArr[i4] > i2) {
                i2 = iArr[i4];
            }
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 - i3;
            int i9 = iArr[i7] * i8 * i8;
            if (i9 > i5) {
                i6 = i7;
                i5 = i9;
            }
        }
        if (i3 > i6) {
            int i10 = i3;
            i3 = i6;
            i6 = i10;
        }
        if (i6 - i3 <= length / 16) {
            throw m.getNotFoundInstance();
        }
        int i11 = i6 - 1;
        int i12 = -1;
        int i13 = i11;
        while (i11 > i3) {
            int i14 = i11 - i3;
            int i15 = i14 * i14 * (i6 - i11) * (i2 - iArr[i11]);
            if (i15 > i12) {
                i13 = i11;
                i12 = i15;
            }
            i11--;
        }
        return i13 << 3;
    }

    private void a(int i) {
        if (this.f.length < i) {
            this.f = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.g[i2] = 0;
        }
    }

    public b a(j jVar) {
        return new h(jVar);
    }

    public final a a(int i, a aVar) throws m {
        j jVar = this.f3002a;
        int i2 = jVar.f3346a;
        if (aVar == null || aVar.f3055b < i2) {
            aVar = new a(i2);
        } else {
            aVar.b();
        }
        a(i2);
        byte[] a2 = jVar.a(i, this.f);
        int[] iArr = this.g;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (a2[i3] & 255) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int a3 = a(iArr);
        if (i2 < 3) {
            for (int i5 = 0; i5 < i2; i5++) {
                if ((a2[i5] & 255) < a3) {
                    aVar.b(i5);
                }
            }
        } else {
            byte b2 = a2[1] & 255;
            byte b3 = a2[0] & 255;
            int i6 = 1;
            while (i6 < i2 - 1) {
                int i7 = i6 + 1;
                byte b4 = a2[i7] & 255;
                if ((((b2 << 2) - b3) - b4) / 2 < a3) {
                    aVar.b(i6);
                }
                b3 = b2;
                i6 = i7;
                b2 = b4;
            }
        }
        return aVar;
    }

    public b a() throws m {
        j jVar = this.f3002a;
        int i = jVar.f3346a;
        int i2 = jVar.f3347b;
        b bVar = new b(i, i2);
        a(i);
        int[] iArr = this.g;
        for (int i3 = 1; i3 < 5; i3++) {
            byte[] a2 = jVar.a((i2 * i3) / 5, this.f);
            int i4 = (i << 2) / 5;
            for (int i5 = i / 5; i5 < i4; i5++) {
                int i6 = (a2[i5] & 255) >> 3;
                iArr[i6] = iArr[i6] + 1;
            }
        }
        int a3 = a(iArr);
        byte[] a4 = jVar.a();
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i7 * i;
            for (int i9 = 0; i9 < i; i9++) {
                if ((a4[i8 + i9] & 255) < a3) {
                    bVar.b(i9, i7);
                }
            }
        }
        return bVar;
    }
}

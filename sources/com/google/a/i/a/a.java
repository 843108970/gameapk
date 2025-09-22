package com.google.a.i.a;

import com.google.a.c.b;
import com.google.a.h;

final class a {

    /* renamed from: a  reason: collision with root package name */
    final b f3295a;

    /* renamed from: b  reason: collision with root package name */
    j f3296b;

    /* renamed from: c  reason: collision with root package name */
    g f3297c;
    boolean d;

    a(b bVar) throws h {
        int i = bVar.f3062b;
        if (i < 21 || (i & 3) != 1) {
            throw h.getFormatInstance();
        }
        this.f3295a = bVar;
    }

    private int a(int i, int i2, int i3) {
        return this.d ? this.f3295a.a(i2, i) : this.f3295a.a(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    private byte[] c() throws h {
        int i;
        g a2 = a();
        j b2 = b();
        c cVar = c.values()[a2.f3306b];
        int i2 = this.f3295a.f3062b;
        cVar.unmaskBitMatrix(this.f3295a, i2);
        int a3 = b2.a();
        b bVar = new b(a3);
        bVar.a(0, 0, 9, 9);
        int i3 = a3 - 8;
        bVar.a(i3, 0, 8, 9);
        bVar.a(0, i3, 9, 8);
        int length = b2.f3309b.length;
        int i4 = 0;
        while (true) {
            i = 2;
            if (i4 >= length) {
                break;
            }
            int i5 = b2.f3309b[i4] - 2;
            for (int i6 = 0; i6 < length; i6++) {
                if (!((i4 == 0 && (i6 == 0 || i6 == length - 1)) || (i4 == length - 1 && i6 == 0))) {
                    bVar.a(b2.f3309b[i6] - 2, i5, 5, 5);
                }
            }
            i4++;
        }
        int i7 = a3 - 17;
        int i8 = 6;
        bVar.a(6, 9, 1, i7);
        bVar.a(9, 6, i7, 1);
        if (b2.f3308a > 6) {
            int i9 = a3 - 11;
            bVar.a(i9, 0, 3, 6);
            bVar.a(0, i9, 6, 3);
        }
        byte[] bArr = new byte[b2.f3310c];
        int i10 = i2 - 1;
        int i11 = i10;
        int i12 = 0;
        boolean z = true;
        int i13 = 0;
        int i14 = 0;
        while (i11 > 0) {
            if (i11 == i8) {
                i11--;
            }
            int i15 = i14;
            int i16 = i13;
            int i17 = i12;
            int i18 = 0;
            while (i18 < i2) {
                int i19 = z ? i10 - i18 : i18;
                int i20 = i16;
                int i21 = i17;
                int i22 = 0;
                while (i22 < i) {
                    int i23 = i11 - i22;
                    if (!bVar.a(i23, i19)) {
                        i15++;
                        int i24 = i20 << 1;
                        int i25 = this.f3295a.a(i23, i19) ? i24 | 1 : i24;
                        if (i15 == 8) {
                            bArr[i21] = (byte) i25;
                            i21++;
                            i15 = 0;
                            i20 = 0;
                        } else {
                            i20 = i25;
                        }
                    }
                    i22++;
                    i = 2;
                }
                i18++;
                i17 = i21;
                i16 = i20;
                i = 2;
            }
            z = !z;
            i11 -= 2;
            i12 = i17;
            i13 = i16;
            i14 = i15;
            i8 = 6;
            i = 2;
        }
        if (i12 == b2.f3310c) {
            return bArr;
        }
        throw h.getFormatInstance();
    }

    private void d() {
        if (this.f3297c != null) {
            c.values()[this.f3297c.f3306b].unmaskBitMatrix(this.f3295a, this.f3295a.f3062b);
        }
    }

    private void e() {
        this.f3296b = null;
        this.f3297c = null;
        this.d = true;
    }

    private void f() {
        int i = 0;
        while (i < this.f3295a.f3061a) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f3295a.f3062b; i3++) {
                if (this.f3295a.a(i, i3) != this.f3295a.a(i3, i)) {
                    this.f3295a.c(i3, i);
                    this.f3295a.c(i, i3);
                }
            }
            i = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public final g a() throws h {
        if (this.f3297c != null) {
            return this.f3297c;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = a(i3, 8, i2);
        }
        int a2 = a(8, 7, a(8, 8, a(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            a2 = a(8, i4, a2);
        }
        int i5 = this.f3295a.f3062b;
        int i6 = i5 - 7;
        for (int i7 = i5 - 1; i7 >= i6; i7--) {
            i = a(8, i7, i);
        }
        for (int i8 = i5 - 8; i8 < i5; i8++) {
            i = a(i8, 8, i);
        }
        this.f3297c = g.b(a2, i);
        if (this.f3297c != null) {
            return this.f3297c;
        }
        throw h.getFormatInstance();
    }

    /* access modifiers changed from: package-private */
    public final j b() throws h {
        if (this.f3296b != null) {
            return this.f3296b;
        }
        int i = this.f3295a.f3062b;
        int i2 = (i - 17) / 4;
        if (i2 <= 6) {
            return j.b(i2);
        }
        int i3 = i - 11;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i - 9; i7 >= i3; i7--) {
                i5 = a(i7, i6, i5);
            }
        }
        j c2 = j.c(i5);
        if (c2 == null || c2.a() != i) {
            for (int i8 = 5; i8 >= 0; i8--) {
                for (int i9 = i - 9; i9 >= i3; i9--) {
                    i4 = a(i8, i9, i4);
                }
            }
            j c3 = j.c(i4);
            if (c3 == null || c3.a() != i) {
                throw h.getFormatInstance();
            }
            this.f3296b = c3;
            return c3;
        }
        this.f3296b = c2;
        return c2;
    }
}

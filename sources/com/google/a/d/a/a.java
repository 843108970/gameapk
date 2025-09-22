package com.google.a.d.a;

import com.google.a.c.b;
import com.google.a.h;

final class a {

    /* renamed from: a  reason: collision with root package name */
    final b f3091a;

    /* renamed from: b  reason: collision with root package name */
    final b f3092b;

    /* renamed from: c  reason: collision with root package name */
    final e f3093c;

    a(b bVar) throws h {
        int i = bVar.f3062b;
        if (i < 8 || i > 144 || (i & 1) != 0) {
            throw h.getFormatInstance();
        }
        this.f3093c = e.a(bVar.f3062b, bVar.f3061a);
        this.f3091a = b(bVar);
        this.f3092b = new b(this.f3091a.f3061a, this.f3091a.f3062b);
    }

    private int a(int i, int i2) {
        int i3 = i - 1;
        int i4 = (a(i3, 0, i, i2) ? 1 : 0) << true;
        if (a(i3, 1, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(i3, 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 1;
        if (a(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (a(1, i8, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (a(2, i8, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return a(3, i8, i, i2) ? i11 | 1 : i11;
    }

    private e a() {
        return this.f3093c;
    }

    private static e a(b bVar) throws h {
        return e.a(bVar.f3062b, bVar.f3061a);
    }

    private int b(int i, int i2) {
        int i3 = (a(i + -3, 0, i, i2) ? 1 : 0) << true;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i2 - 1;
        if (a(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        return a(1, i9, i, i2) ? i10 | 1 : i10;
    }

    private b b(b bVar) {
        b bVar2 = bVar;
        int i = this.f3093c.f3102b;
        int i2 = this.f3093c.f3103c;
        if (bVar2.f3062b != i) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int i3 = this.f3093c.d;
        int i4 = this.f3093c.e;
        int i5 = i / i3;
        int i6 = i2 / i4;
        b bVar3 = new b(i6 * i4, i5 * i3);
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = i7 * i3;
            for (int i9 = 0; i9 < i6; i9++) {
                int i10 = i9 * i4;
                for (int i11 = 0; i11 < i3; i11++) {
                    int i12 = ((i3 + 2) * i7) + 1 + i11;
                    int i13 = i8 + i11;
                    for (int i14 = 0; i14 < i4; i14++) {
                        if (bVar2.a(((i4 + 2) * i9) + 1 + i14, i12)) {
                            bVar3.b(i10 + i14, i13);
                        }
                    }
                }
            }
        }
        return bVar3;
    }

    private byte[] b() throws h {
        byte[] bArr = new byte[this.f3093c.g];
        int i = this.f3091a.f3062b;
        int i2 = this.f3091a.f3061a;
        int i3 = 4;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i3 == i && i4 == 0 && !z) {
                int i6 = i5 + 1;
                int i7 = i - 1;
                int i8 = (a(i7, 0, i, i2) ? 1 : 0) << true;
                if (a(i7, 1, i, i2)) {
                    i8 |= 1;
                }
                int i9 = i8 << 1;
                if (a(i7, 2, i, i2)) {
                    i9 |= 1;
                }
                int i10 = i9 << 1;
                if (a(0, i2 - 2, i, i2)) {
                    i10 |= 1;
                }
                int i11 = i10 << 1;
                int i12 = i2 - 1;
                if (a(0, i12, i, i2)) {
                    i11 |= 1;
                }
                int i13 = i11 << 1;
                if (a(1, i12, i, i2)) {
                    i13 |= 1;
                }
                int i14 = i13 << 1;
                if (a(2, i12, i, i2)) {
                    i14 |= 1;
                }
                int i15 = i14 << 1;
                if (a(3, i12, i, i2)) {
                    i15 |= 1;
                }
                bArr[i5] = (byte) i15;
                i3 -= 2;
                i4 += 2;
                i5 = i6;
                z = true;
            } else {
                int i16 = i - 2;
                if (i3 == i16 && i4 == 0 && (i2 & 3) != 0 && !z2) {
                    int i17 = i5 + 1;
                    int i18 = (a(i + -3, 0, i, i2) ? 1 : 0) << true;
                    if (a(i16, 0, i, i2)) {
                        i18 |= 1;
                    }
                    int i19 = i18 << 1;
                    if (a(i - 1, 0, i, i2)) {
                        i19 |= 1;
                    }
                    int i20 = i19 << 1;
                    if (a(0, i2 - 4, i, i2)) {
                        i20 |= 1;
                    }
                    int i21 = i20 << 1;
                    if (a(0, i2 - 3, i, i2)) {
                        i21 |= 1;
                    }
                    int i22 = i21 << 1;
                    if (a(0, i2 - 2, i, i2)) {
                        i22 |= 1;
                    }
                    int i23 = i22 << 1;
                    int i24 = i2 - 1;
                    if (a(0, i24, i, i2)) {
                        i23 |= 1;
                    }
                    int i25 = i23 << 1;
                    if (a(1, i24, i, i2)) {
                        i25 |= 1;
                    }
                    bArr[i5] = (byte) i25;
                    i3 -= 2;
                    i4 += 2;
                    i5 = i17;
                    z2 = true;
                } else if (i3 == i + 4 && i4 == 2 && (i2 & 7) == 0 && !z3) {
                    int i26 = i5 + 1;
                    int i27 = i - 1;
                    int i28 = (a(i27, 0, i, i2) ? 1 : 0) << true;
                    int i29 = i2 - 1;
                    if (a(i27, i29, i, i2)) {
                        i28 |= 1;
                    }
                    int i30 = i28 << 1;
                    int i31 = i2 - 3;
                    if (a(0, i31, i, i2)) {
                        i30 |= 1;
                    }
                    int i32 = i30 << 1;
                    int i33 = i2 - 2;
                    if (a(0, i33, i, i2)) {
                        i32 |= 1;
                    }
                    int i34 = i26;
                    int i35 = i32 << 1;
                    if (a(0, i29, i, i2)) {
                        i35 |= 1;
                    }
                    int i36 = i35 << 1;
                    if (a(1, i31, i, i2)) {
                        i36 |= 1;
                    }
                    int i37 = i36 << 1;
                    if (a(1, i33, i, i2)) {
                        i37 |= 1;
                    }
                    int i38 = i37 << 1;
                    if (a(1, i29, i, i2)) {
                        i38 |= 1;
                    }
                    bArr[i5] = (byte) i38;
                    i3 -= 2;
                    i4 += 2;
                    i5 = i34;
                    z3 = true;
                } else if (i3 == i16 && i4 == 0 && (i2 & 7) == 4 && !z4) {
                    int i39 = i5 + 1;
                    int i40 = (a(i + -3, 0, i, i2) ? 1 : 0) << true;
                    if (a(i16, 0, i, i2)) {
                        i40 |= 1;
                    }
                    int i41 = i40 << 1;
                    if (a(i - 1, 0, i, i2)) {
                        i41 |= 1;
                    }
                    int i42 = i41 << 1;
                    if (a(0, i2 - 2, i, i2)) {
                        i42 |= 1;
                    }
                    int i43 = i42 << 1;
                    int i44 = i2 - 1;
                    if (a(0, i44, i, i2)) {
                        i43 |= 1;
                    }
                    int i45 = i43 << 1;
                    if (a(1, i44, i, i2)) {
                        i45 |= 1;
                    }
                    int i46 = i45 << 1;
                    if (a(2, i44, i, i2)) {
                        i46 |= 1;
                    }
                    int i47 = i46 << 1;
                    if (a(3, i44, i, i2)) {
                        i47 |= 1;
                    }
                    bArr[i5] = (byte) i47;
                    i3 -= 2;
                    i4 += 2;
                    i5 = i39;
                    z4 = true;
                } else {
                    do {
                        if (i3 < i && i4 >= 0 && !this.f3092b.a(i4, i3)) {
                            bArr[i5] = (byte) b(i3, i4, i, i2);
                            i5++;
                        }
                        i3 -= 2;
                        i4 += 2;
                        if (i3 < 0) {
                            break;
                        }
                    } while (i4 < i2);
                    int i48 = i3 + 1;
                    int i49 = i4 + 3;
                    do {
                        if (i48 >= 0 && i49 < i2 && !this.f3092b.a(i49, i48)) {
                            bArr[i5] = (byte) b(i48, i49, i, i2);
                            i5++;
                        }
                        i48 += 2;
                        i49 -= 2;
                        if (i48 >= i) {
                            break;
                        }
                    } while (i49 >= 0);
                    i3 = i48 + 3;
                    i4 = i49 + 1;
                }
            }
            if (i3 >= i && i4 >= i2) {
                break;
            }
        }
        if (i5 == this.f3093c.g) {
            return bArr;
        }
        throw h.getFormatInstance();
    }

    private int c(int i, int i2) {
        int i3 = i - 1;
        int i4 = (a(i3, 0, i, i2) ? 1 : 0) << true;
        int i5 = i2 - 1;
        if (a(i3, i5, i, i2)) {
            i4 |= 1;
        }
        int i6 = i4 << 1;
        int i7 = i2 - 3;
        if (a(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        int i9 = i2 - 2;
        if (a(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (a(0, i5, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (a(1, i7, i, i2)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(1, i9, i, i2)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return a(1, i5, i, i2) ? i13 | 1 : i13;
    }

    private int d(int i, int i2) {
        int i3 = (a(i + -3, 0, i, i2) ? 1 : 0) << true;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        int i7 = i2 - 1;
        if (a(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        if (a(1, i7, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (a(2, i7, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        return a(3, i7, i, i2) ? i10 | 1 : i10;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.f3092b.b(i2, i);
        return this.f3091a.a(i2, i);
    }

    /* access modifiers changed from: package-private */
    public final int b(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (a(i5, i6, i3, i4) ? 1 : 0) << true;
        int i8 = i2 - 1;
        if (a(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (a(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (a(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return a(i, i2, i3, i4) ? i15 | 1 : i15;
    }
}

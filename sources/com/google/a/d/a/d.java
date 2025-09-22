package com.google.a.d.a;

import com.google.a.c.b;
import com.google.a.c.b.a;
import com.google.a.c.b.c;
import com.google.a.c.e;
import com.google.a.d.a.e;
import com.google.a.h;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final c f3100a = new c(a.f);

    private e a(boolean[][] zArr) throws h, com.google.a.d {
        return a(b.a(zArr));
    }

    private void a(byte[] bArr, int i) throws com.google.a.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f3100a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (com.google.a.c.b.e unused) {
            throw com.google.a.d.getChecksumInstance();
        }
    }

    public final e a(b bVar) throws h, com.google.a.d {
        boolean z;
        boolean z2;
        a aVar = new a(bVar);
        e eVar = aVar.f3093c;
        byte[] bArr = new byte[aVar.f3093c.g];
        int i = aVar.f3091a.f3062b;
        int i2 = aVar.f3091a.f3061a;
        int i3 = 0;
        int i4 = 4;
        int i5 = 0;
        boolean z3 = false;
        int i6 = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            if (i4 == i && i5 == 0 && !z3) {
                int i7 = i6 + 1;
                int i8 = i - 1;
                int i9 = (aVar.a(i8, i3, i, i2) ? 1 : 0) << true;
                if (aVar.a(i8, 1, i, i2)) {
                    i9 |= 1;
                }
                int i10 = i9 << 1;
                if (aVar.a(i8, 2, i, i2)) {
                    i10 |= 1;
                }
                int i11 = i10 << 1;
                if (aVar.a(i3, i2 - 2, i, i2)) {
                    i11 |= 1;
                }
                int i12 = i11 << 1;
                int i13 = i2 - 1;
                if (aVar.a(i3, i13, i, i2)) {
                    i12 |= 1;
                }
                int i14 = i12 << 1;
                if (aVar.a(1, i13, i, i2)) {
                    i14 |= 1;
                }
                int i15 = i14 << 1;
                if (aVar.a(2, i13, i, i2)) {
                    i15 |= 1;
                }
                int i16 = i15 << 1;
                if (aVar.a(3, i13, i, i2)) {
                    i16 |= 1;
                }
                bArr[i6] = (byte) i16;
                i4 -= 2;
                i5 += 2;
                i6 = i7;
                z2 = true;
                z = true;
            } else {
                int i17 = i - 2;
                if (i4 == i17 && i5 == 0 && (i2 & 3) != 0 && !z4) {
                    int i18 = i6 + 1;
                    int i19 = (aVar.a(i + -3, 0, i, i2) ? 1 : 0) << true;
                    if (aVar.a(i17, 0, i, i2)) {
                        i19 |= 1;
                    }
                    int i20 = i19 << 1;
                    if (aVar.a(i - 1, 0, i, i2)) {
                        i20 |= 1;
                    }
                    int i21 = i20 << 1;
                    if (aVar.a(0, i2 - 4, i, i2)) {
                        i21 |= 1;
                    }
                    int i22 = i21 << 1;
                    if (aVar.a(0, i2 - 3, i, i2)) {
                        i22 |= 1;
                    }
                    int i23 = i22 << 1;
                    if (aVar.a(0, i2 - 2, i, i2)) {
                        i23 |= 1;
                    }
                    int i24 = i23 << 1;
                    int i25 = i2 - 1;
                    if (aVar.a(0, i25, i, i2)) {
                        i24 |= 1;
                    }
                    int i26 = i24 << 1;
                    if (aVar.a(1, i25, i, i2)) {
                        i26 |= 1;
                    }
                    bArr[i6] = (byte) i26;
                    i4 -= 2;
                    i5 += 2;
                    z = z3;
                    i6 = i18;
                    z4 = true;
                } else if (i4 == i + 4 && i5 == 2 && (i2 & 7) == 0 && !z5) {
                    int i27 = i6 + 1;
                    int i28 = i - 1;
                    int i29 = (aVar.a(i28, 0, i, i2) ? 1 : 0) << true;
                    int i30 = i2 - 1;
                    if (aVar.a(i28, i30, i, i2)) {
                        i29 |= 1;
                    }
                    int i31 = i29 << 1;
                    int i32 = i2 - 3;
                    if (aVar.a(0, i32, i, i2)) {
                        i31 |= 1;
                    }
                    int i33 = i31 << 1;
                    int i34 = i2 - 2;
                    int i35 = i27;
                    if (aVar.a(0, i34, i, i2)) {
                        i33 |= 1;
                    }
                    z = z3;
                    int i36 = i33 << 1;
                    if (aVar.a(0, i30, i, i2)) {
                        i36 |= 1;
                    }
                    int i37 = i36 << 1;
                    if (aVar.a(1, i32, i, i2)) {
                        i37 |= 1;
                    }
                    int i38 = i37 << 1;
                    if (aVar.a(1, i34, i, i2)) {
                        i38 |= 1;
                    }
                    int i39 = i38 << 1;
                    if (aVar.a(1, i30, i, i2)) {
                        i39 |= 1;
                    }
                    bArr[i6] = (byte) i39;
                    i4 -= 2;
                    i5 += 2;
                    i6 = i35;
                    z5 = true;
                } else {
                    z = z3;
                    if (i4 == i17 && i5 == 0) {
                        if ((i2 & 7) == 4 && !z6) {
                            int i40 = i6 + 1;
                            z2 = true;
                            int i41 = (aVar.a(i + -3, 0, i, i2) ? 1 : 0) << true;
                            if (aVar.a(i17, 0, i, i2)) {
                                i41 |= 1;
                            }
                            int i42 = i41 << 1;
                            if (aVar.a(i - 1, 0, i, i2)) {
                                i42 |= 1;
                            }
                            int i43 = i42 << 1;
                            if (aVar.a(0, i2 - 2, i, i2)) {
                                i43 |= 1;
                            }
                            int i44 = i43 << 1;
                            int i45 = i2 - 1;
                            if (aVar.a(0, i45, i, i2)) {
                                i44 |= 1;
                            }
                            int i46 = i44 << 1;
                            if (aVar.a(1, i45, i, i2)) {
                                i46 |= 1;
                            }
                            int i47 = i46 << 1;
                            if (aVar.a(2, i45, i, i2)) {
                                i47 |= 1;
                            }
                            int i48 = i47 << 1;
                            if (aVar.a(3, i45, i, i2)) {
                                i48 |= 1;
                            }
                            bArr[i6] = (byte) i48;
                            i4 -= 2;
                            i5 += 2;
                            i6 = i40;
                            z6 = true;
                        }
                    }
                    z2 = true;
                    do {
                        if (i4 < i && i5 >= 0 && !aVar.f3092b.a(i5, i4)) {
                            bArr[i6] = (byte) aVar.b(i4, i5, i, i2);
                            i6++;
                        }
                        i4 -= 2;
                        i5 += 2;
                        if (i4 < 0) {
                            break;
                        }
                    } while (i5 < i2);
                    int i49 = i4 + 1;
                    int i50 = i5 + 3;
                    do {
                        if (i49 >= 0 && i50 < i2 && !aVar.f3092b.a(i50, i49)) {
                            bArr[i6] = (byte) aVar.b(i49, i50, i, i2);
                            i6++;
                        }
                        i49 += 2;
                        i50 -= 2;
                        if (i49 >= i) {
                            break;
                        }
                    } while (i50 >= 0);
                    i4 = i49 + 3;
                    i5 = i50 + 1;
                }
                z2 = true;
            }
            if (i4 >= i && i5 >= i2) {
                break;
            }
            z3 = z;
            i3 = 0;
        }
        if (i6 != aVar.f3093c.g) {
            throw h.getFormatInstance();
        }
        e.b bVar2 = eVar.f;
        e.a[] aVarArr = bVar2.f3107b;
        int i51 = 0;
        for (e.a aVar2 : aVarArr) {
            i51 += aVar2.f3104a;
        }
        b[] bVarArr = new b[i51];
        int length = aVarArr.length;
        int i52 = 0;
        int i53 = 0;
        while (i52 < length) {
            e.a aVar3 = aVarArr[i52];
            int i54 = i53;
            int i55 = 0;
            while (i55 < aVar3.f3104a) {
                int i56 = aVar3.f3105b;
                bVarArr[i54] = new b(i56, new byte[(bVar2.f3106a + i56)]);
                i55++;
                i54++;
            }
            i52++;
            i53 = i54;
        }
        int length2 = bVarArr[0].f3095b.length - bVar2.f3106a;
        int i57 = length2 - 1;
        int i58 = 0;
        int i59 = 0;
        while (i58 < i57) {
            int i60 = i59;
            int i61 = 0;
            while (i61 < i53) {
                bVarArr[i61].f3095b[i58] = bArr[i60];
                i61++;
                i60++;
            }
            i58++;
            i59 = i60;
        }
        if (eVar.f3101a != 24) {
            z2 = false;
        }
        int i62 = z2 ? 8 : i53;
        int i63 = 0;
        while (i63 < i62) {
            bVarArr[i63].f3095b[i57] = bArr[i59];
            i63++;
            i59++;
        }
        int length3 = bVarArr[0].f3095b.length;
        while (length2 < length3) {
            int i64 = 0;
            while (i64 < i53) {
                int i65 = z2 ? (i64 + 8) % i53 : i64;
                bVarArr[i65].f3095b[(!z2 || i65 <= 7) ? length2 : length2 - 1] = bArr[i59];
                i64++;
                i59++;
            }
            length2++;
        }
        if (i59 != bArr.length) {
            throw new IllegalArgumentException();
        }
        int i66 = 0;
        for (b bVar3 : bVarArr) {
            i66 += bVar3.f3094a;
        }
        byte[] bArr2 = new byte[i66];
        int length4 = bVarArr.length;
        for (int i67 = 0; i67 < length4; i67++) {
            b bVar4 = bVarArr[i67];
            byte[] bArr3 = bVar4.f3095b;
            int i68 = bVar4.f3094a;
            a(bArr3, i68);
            for (int i69 = 0; i69 < i68; i69++) {
                bArr2[(i69 * length4) + i67] = bArr3[i69];
            }
        }
        return c.a(bArr2);
    }
}

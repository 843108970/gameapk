package com.google.a.e;

import com.google.a.c.b;
import com.google.a.d;
import com.google.a.e;
import com.google.a.e.a.c;
import com.google.a.h;
import com.google.a.m;
import com.google.a.p;
import com.google.a.r;
import com.google.a.s;
import com.google.a.t;
import java.util.Map;

public final class a implements p {

    /* renamed from: a  reason: collision with root package name */
    private static final t[] f3128a = new t[0];

    /* renamed from: b  reason: collision with root package name */
    private static final int f3129b = 30;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3130c = 33;
    private final c d = new c();

    private static b a(b bVar) throws m {
        int i = bVar.f3061a;
        int i2 = -1;
        int i3 = bVar.f3062b;
        int i4 = -1;
        int i5 = i;
        int i6 = 0;
        while (i6 < bVar.f3062b) {
            int i7 = i4;
            int i8 = i2;
            int i9 = i5;
            for (int i10 = 0; i10 < bVar.f3063c; i10++) {
                int i11 = bVar.d[(bVar.f3063c * i6) + i10];
                if (i11 != 0) {
                    if (i6 < i3) {
                        i3 = i6;
                    }
                    if (i6 > i7) {
                        i7 = i6;
                    }
                    int i12 = i10 << 5;
                    int i13 = 31;
                    if (i12 < i9) {
                        int i14 = 0;
                        while ((i11 << (31 - i14)) == 0) {
                            i14++;
                        }
                        int i15 = i14 + i12;
                        if (i15 < i9) {
                            i9 = i15;
                        }
                    }
                    if (i12 + 31 > i8) {
                        while ((i11 >>> i13) == 0) {
                            i13--;
                        }
                        int i16 = i12 + i13;
                        if (i16 > i8) {
                            i8 = i16;
                        }
                    }
                }
            }
            i6++;
            i5 = i9;
            i2 = i8;
            i4 = i7;
        }
        int[] iArr = (i2 < i5 || i4 < i3) ? null : new int[]{i5, i3, (i2 - i5) + 1, (i4 - i3) + 1};
        if (iArr == null) {
            throw m.getNotFoundInstance();
        }
        int i17 = iArr[0];
        int i18 = iArr[1];
        int i19 = iArr[2];
        int i20 = iArr[3];
        b bVar2 = new b(30, 33);
        for (int i21 = 0; i21 < 33; i21++) {
            int i22 = (((i21 * i20) + (i20 / 2)) / 33) + i18;
            for (int i23 = 0; i23 < 30; i23++) {
                if (bVar.a(((((i23 * i19) + (i19 / 2)) + (((i21 & 1) * i19) / 2)) / 30) + i17, i22)) {
                    bVar2.b(i23, i21);
                }
            }
        }
        return bVar2;
    }

    public final r a(com.google.a.c cVar) throws m, d, h {
        return a(cVar, (Map<e, ?>) null);
    }

    public final r a(com.google.a.c cVar, Map<e, ?> map) throws m, d, h {
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            throw m.getNotFoundInstance();
        }
        b c2 = cVar.c();
        int i = c2.f3061a;
        int i2 = -1;
        int i3 = c2.f3062b;
        int i4 = -1;
        int i5 = i;
        int i6 = 0;
        while (i6 < c2.f3062b) {
            int i7 = i3;
            int i8 = i5;
            for (int i9 = 0; i9 < c2.f3063c; i9++) {
                int i10 = c2.d[(c2.f3063c * i6) + i9];
                if (i10 != 0) {
                    if (i6 < i7) {
                        i7 = i6;
                    }
                    if (i6 > i4) {
                        i4 = i6;
                    }
                    int i11 = i9 << 5;
                    int i12 = 31;
                    if (i11 < i8) {
                        int i13 = 0;
                        while ((i10 << (31 - i13)) == 0) {
                            i13++;
                        }
                        int i14 = i13 + i11;
                        if (i14 < i8) {
                            i8 = i14;
                        }
                    }
                    if (i11 + 31 > i2) {
                        while ((i10 >>> i12) == 0) {
                            i12--;
                        }
                        int i15 = i11 + i12;
                        if (i15 > i2) {
                            i2 = i15;
                        }
                    }
                }
            }
            i6++;
            i5 = i8;
            i3 = i7;
        }
        int[] iArr = (i2 < i5 || i4 < i3) ? null : new int[]{i5, i3, (i2 - i5) + 1, (i4 - i3) + 1};
        if (iArr == null) {
            throw m.getNotFoundInstance();
        }
        int i16 = iArr[0];
        int i17 = iArr[1];
        int i18 = iArr[2];
        int i19 = iArr[3];
        b bVar = new b(30, 33);
        for (int i20 = 0; i20 < 33; i20++) {
            int i21 = (((i20 * i19) + (i19 / 2)) / 33) + i17;
            for (int i22 = 0; i22 < 30; i22++) {
                if (c2.a(((((i22 * i18) + (i18 / 2)) + (((i20 & 1) * i18) / 2)) / 30) + i16, i21)) {
                    bVar.b(i22, i20);
                }
            }
        }
        com.google.a.c.e a2 = this.d.a(bVar);
        r rVar = new r(a2.f3077c, a2.f3075a, f3128a, com.google.a.a.MAXICODE);
        String str = a2.e;
        if (str != null) {
            rVar.a(s.ERROR_CORRECTION_LEVEL, str);
        }
        return rVar;
    }

    public final void a() {
    }
}

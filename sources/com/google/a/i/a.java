package com.google.a.i;

import com.google.a.c;
import com.google.a.c.b;
import com.google.a.c.g;
import com.google.a.d;
import com.google.a.h;
import com.google.a.i.a.e;
import com.google.a.i.a.i;
import com.google.a.m;
import com.google.a.p;
import com.google.a.r;
import com.google.a.s;
import com.google.a.t;
import java.util.List;
import java.util.Map;

public class a implements p {

    /* renamed from: b  reason: collision with root package name */
    private static final t[] f3293b = new t[0];

    /* renamed from: a  reason: collision with root package name */
    protected final e f3294a = new e();

    private static float a(int[] iArr, b bVar) throws m {
        int i = bVar.f3062b;
        int i2 = bVar.f3061a;
        int i3 = iArr[0];
        boolean z = true;
        int i4 = iArr[1];
        int i5 = 0;
        while (i3 < i2 && i4 < i) {
            if (z != bVar.a(i3, i4)) {
                i5++;
                if (i5 == 5) {
                    break;
                }
                z = !z;
            }
            i3++;
            i4++;
        }
        if (i3 != i2 && i4 != i) {
            return ((float) (i3 - iArr[0])) / 7.0f;
        }
        throw m.getNotFoundInstance();
    }

    private static b a(b bVar) throws m {
        int[] b2 = bVar.b();
        int[] c2 = bVar.c();
        if (b2 == null || c2 == null) {
            throw m.getNotFoundInstance();
        }
        int i = bVar.f3062b;
        int i2 = bVar.f3061a;
        int i3 = b2[0];
        int i4 = b2[1];
        boolean z = true;
        int i5 = 0;
        while (i3 < i2 && i4 < i) {
            if (z != bVar.a(i3, i4)) {
                i5++;
                if (i5 == 5) {
                    break;
                }
                z = !z;
            }
            i3++;
            i4++;
        }
        if (i3 == i2 || i4 == i) {
            throw m.getNotFoundInstance();
        }
        float f = ((float) (i3 - b2[0])) / 7.0f;
        int i6 = b2[1];
        int i7 = c2[1];
        int i8 = b2[0];
        int i9 = c2[0];
        if (i8 >= i9 || i6 >= i7) {
            throw m.getNotFoundInstance();
        }
        int i10 = i7 - i6;
        if (i10 == i9 - i8 || (i9 = i8 + i10) < bVar.f3061a) {
            int round = Math.round(((float) ((i9 - i8) + 1)) / f);
            int round2 = Math.round(((float) (i10 + 1)) / f);
            if (round <= 0 || round2 <= 0) {
                throw m.getNotFoundInstance();
            } else if (round2 != round) {
                throw m.getNotFoundInstance();
            } else {
                int i11 = (int) (f / 2.0f);
                int i12 = i6 + i11;
                int i13 = i8 + i11;
                int i14 = (((int) (((float) (round - 1)) * f)) + i13) - i9;
                if (i14 > 0) {
                    if (i14 > i11) {
                        throw m.getNotFoundInstance();
                    }
                    i13 -= i14;
                }
                int i15 = (((int) (((float) (round2 - 1)) * f)) + i12) - i7;
                if (i15 > 0) {
                    if (i15 > i11) {
                        throw m.getNotFoundInstance();
                    }
                    i12 -= i15;
                }
                b bVar2 = new b(round, round2);
                for (int i16 = 0; i16 < round2; i16++) {
                    int i17 = ((int) (((float) i16) * f)) + i12;
                    for (int i18 = 0; i18 < round; i18++) {
                        if (bVar.a(((int) (((float) i18) * f)) + i13, i17)) {
                            bVar2.b(i18, i16);
                        }
                    }
                }
                return bVar2;
            }
        } else {
            throw m.getNotFoundInstance();
        }
    }

    private e b() {
        return this.f3294a;
    }

    public final r a(c cVar) throws m, d, h {
        return a(cVar, (Map<com.google.a.e, ?>) null);
    }

    public final r a(c cVar, Map<com.google.a.e, ?> map) throws m, d, h {
        t[] tVarArr;
        com.google.a.c.e eVar;
        if (map == null || !map.containsKey(com.google.a.e.PURE_BARCODE)) {
            g a2 = new com.google.a.i.b.c(cVar.c()).a(map);
            com.google.a.c.e a3 = this.f3294a.a(a2.d, map);
            tVarArr = a2.e;
            eVar = a3;
        } else {
            b c2 = cVar.c();
            int[] b2 = c2.b();
            int[] c3 = c2.c();
            if (b2 == null || c3 == null) {
                throw m.getNotFoundInstance();
            }
            int i = c2.f3062b;
            int i2 = c2.f3061a;
            int i3 = b2[0];
            int i4 = b2[1];
            boolean z = true;
            int i5 = 0;
            while (i3 < i2 && i4 < i) {
                if (z != c2.a(i3, i4)) {
                    i5++;
                    if (i5 == 5) {
                        break;
                    }
                    z = !z;
                }
                i3++;
                i4++;
            }
            if (i3 == i2 || i4 == i) {
                throw m.getNotFoundInstance();
            }
            float f = ((float) (i3 - b2[0])) / 7.0f;
            int i6 = b2[1];
            int i7 = c3[1];
            int i8 = b2[0];
            int i9 = c3[0];
            if (i8 >= i9 || i6 >= i7) {
                throw m.getNotFoundInstance();
            }
            int i10 = i7 - i6;
            if (i10 == i9 - i8 || (i9 = i8 + i10) < c2.f3061a) {
                int round = Math.round(((float) ((i9 - i8) + 1)) / f);
                int round2 = Math.round(((float) (i10 + 1)) / f);
                if (round <= 0 || round2 <= 0) {
                    throw m.getNotFoundInstance();
                } else if (round2 != round) {
                    throw m.getNotFoundInstance();
                } else {
                    int i11 = (int) (f / 2.0f);
                    int i12 = i6 + i11;
                    int i13 = i8 + i11;
                    int i14 = (((int) (((float) (round - 1)) * f)) + i13) - i9;
                    if (i14 > 0) {
                        if (i14 > i11) {
                            throw m.getNotFoundInstance();
                        }
                        i13 -= i14;
                    }
                    int i15 = (((int) (((float) (round2 - 1)) * f)) + i12) - i7;
                    if (i15 > 0) {
                        if (i15 > i11) {
                            throw m.getNotFoundInstance();
                        }
                        i12 -= i15;
                    }
                    b bVar = new b(round, round2);
                    for (int i16 = 0; i16 < round2; i16++) {
                        int i17 = ((int) (((float) i16) * f)) + i12;
                        for (int i18 = 0; i18 < round; i18++) {
                            if (c2.a(((int) (((float) i18) * f)) + i13, i17)) {
                                bVar.b(i18, i16);
                            }
                        }
                    }
                    eVar = this.f3294a.a(bVar, map);
                    tVarArr = f3293b;
                }
            } else {
                throw m.getNotFoundInstance();
            }
        }
        if (eVar.h instanceof i) {
            ((i) eVar.h).a(tVarArr);
        }
        r rVar = new r(eVar.f3077c, eVar.f3075a, tVarArr, com.google.a.a.QR_CODE);
        List<byte[]> list = eVar.d;
        if (list != null) {
            rVar.a(s.BYTE_SEGMENTS, list);
        }
        String str = eVar.e;
        if (str != null) {
            rVar.a(s.ERROR_CORRECTION_LEVEL, str);
        }
        if (eVar.a()) {
            rVar.a(s.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVar.j));
            rVar.a(s.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVar.i));
        }
        return rVar;
    }

    public final void a() {
    }
}

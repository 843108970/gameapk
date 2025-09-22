package com.google.a.d;

import com.google.a.a;
import com.google.a.d.c.e;
import com.google.a.d.c.i;
import com.google.a.d.c.j;
import com.google.a.d.c.k;
import com.google.a.d.c.l;
import com.google.a.f;
import com.google.a.g;
import com.google.a.v;
import java.util.Map;

public final class b implements v {
    private static com.google.a.c.b a(e eVar, k kVar, int i, int i2) {
        com.google.a.c.b bVar;
        int b2 = kVar.b();
        int c2 = kVar.c();
        com.google.a.i.c.b bVar2 = new com.google.a.i.c.b(kVar.d(), kVar.e());
        int i3 = 0;
        for (int i4 = 0; i4 < c2; i4++) {
            if (i4 % kVar.e == 0) {
                int i5 = 0;
                for (int i6 = 0; i6 < kVar.d(); i6++) {
                    bVar2.a(i5, i3, i6 % 2 == 0);
                    i5++;
                }
                i3++;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < b2; i8++) {
                if (i8 % kVar.d == 0) {
                    bVar2.a(i7, i3, true);
                    i7++;
                }
                bVar2.a(i7, i3, eVar.f3114b[(eVar.f3113a * i4) + i8] == 1);
                i7++;
                if (i8 % kVar.d == kVar.d - 1) {
                    bVar2.a(i7, i3, i4 % 2 == 0);
                    i7++;
                }
            }
            i3++;
            if (i4 % kVar.e == kVar.e - 1) {
                int i9 = 0;
                for (int i10 = 0; i10 < kVar.d(); i10++) {
                    bVar2.a(i9, i3, true);
                    i9++;
                }
                i3++;
            }
        }
        int i11 = bVar2.f3332b;
        int i12 = bVar2.f3333c;
        int max = Math.max(i, i11);
        int max2 = Math.max(i2, i12);
        int min = Math.min(max / i11, max2 / i12);
        int i13 = (max - (i11 * min)) / 2;
        int i14 = (max2 - (i12 * min)) / 2;
        if (i2 < i12 || i < i11) {
            bVar = new com.google.a.c.b(i11, i12);
            i13 = 0;
            i14 = 0;
        } else {
            bVar = new com.google.a.c.b(i, i2);
        }
        bVar.a();
        int i15 = 0;
        while (i15 < i12) {
            int i16 = i13;
            int i17 = 0;
            while (i17 < i11) {
                if (bVar2.a(i17, i15) == 1) {
                    bVar.a(i16, i14, min, min);
                }
                i17++;
                i16 += min;
            }
            i15++;
            i14 += min;
        }
        return bVar;
    }

    private static com.google.a.c.b a(com.google.a.i.c.b bVar, int i, int i2) {
        com.google.a.c.b bVar2;
        int i3 = bVar.f3332b;
        int i4 = bVar.f3333c;
        int max = Math.max(i, i3);
        int max2 = Math.max(i2, i4);
        int min = Math.min(max / i3, max2 / i4);
        int i5 = (max - (i3 * min)) / 2;
        int i6 = (max2 - (i4 * min)) / 2;
        if (i2 < i4 || i < i3) {
            bVar2 = new com.google.a.c.b(i3, i4);
            i5 = 0;
            i6 = 0;
        } else {
            bVar2 = new com.google.a.c.b(i, i2);
        }
        bVar2.a();
        int i7 = 0;
        while (i7 < i4) {
            int i8 = i5;
            int i9 = 0;
            while (i9 < i3) {
                if (bVar.a(i9, i7) == 1) {
                    bVar2.a(i8, i6, min, min);
                }
                i9++;
                i8 += min;
            }
            i7++;
            i6 += min;
        }
        return bVar2;
    }

    public final com.google.a.c.b a(String str, a aVar, int i, int i2) {
        return a(str, aVar, i, i2, (Map<g, ?>) null);
    }

    public final com.google.a.c.b a(String str, a aVar, int i, int i2, Map<g, ?> map) {
        f fVar;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (aVar != a.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(aVar)));
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i + 'x' + i2);
        } else {
            l lVar = l.FORCE_NONE;
            f fVar2 = null;
            if (map != null) {
                l lVar2 = (l) map.get(g.DATA_MATRIX_SHAPE);
                if (lVar2 != null) {
                    lVar = lVar2;
                }
                fVar = (f) map.get(g.MIN_SIZE);
                if (fVar == null) {
                    fVar = null;
                }
                f fVar3 = (f) map.get(g.MAX_SIZE);
                if (fVar3 != null) {
                    fVar2 = fVar3;
                }
            } else {
                fVar = null;
            }
            String a2 = j.a(str, lVar, fVar, fVar2);
            k a3 = k.a(a2.length(), lVar, fVar, fVar2, true);
            e eVar = new e(i.a(a2, a3), a3.b(), a3.c());
            eVar.a();
            return a(eVar, a3, i, i2);
        }
    }
}

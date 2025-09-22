package com.google.a.i;

import com.google.a.a;
import com.google.a.g;
import com.google.a.i.c.c;
import com.google.a.i.c.f;
import com.google.a.v;
import com.google.a.w;
import java.util.Map;

public final class b implements v {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3315a = 4;

    private static com.google.a.c.b a(f fVar, int i, int i2, int i3) {
        com.google.a.i.c.b bVar = fVar.f;
        if (bVar == null) {
            throw new IllegalStateException();
        }
        int i4 = bVar.f3332b;
        int i5 = bVar.f3333c;
        int i6 = i3 << 1;
        int i7 = i4 + i6;
        int i8 = i6 + i5;
        int max = Math.max(i, i7);
        int max2 = Math.max(i2, i8);
        int min = Math.min(max / i7, max2 / i8);
        int i9 = (max - (i4 * min)) / 2;
        int i10 = (max2 - (i5 * min)) / 2;
        com.google.a.c.b bVar2 = new com.google.a.c.b(max, max2);
        int i11 = 0;
        while (i11 < i5) {
            int i12 = i9;
            int i13 = 0;
            while (i13 < i4) {
                if (bVar.a(i13, i11) == 1) {
                    bVar2.a(i12, i10, min, min);
                }
                i13++;
                i12 += min;
            }
            i11++;
            i10 += min;
        }
        return bVar2;
    }

    public final com.google.a.c.b a(String str, a aVar, int i, int i2) throws w {
        return a(str, aVar, i, i2, (Map<g, ?>) null);
    }

    public final com.google.a.c.b a(String str, a aVar, int i, int i2, Map<g, ?> map) throws w {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (aVar != a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(aVar)));
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            com.google.a.i.a.f fVar = com.google.a.i.a.f.L;
            int i3 = 4;
            if (map != null) {
                if (map.containsKey(g.ERROR_CORRECTION)) {
                    fVar = com.google.a.i.a.f.valueOf(map.get(g.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(g.MARGIN)) {
                    i3 = Integer.parseInt(map.get(g.MARGIN).toString());
                }
            }
            return a(c.a(str, fVar, map), i, i2, i3);
        }
    }
}

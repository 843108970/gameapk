package com.google.a.a;

import com.google.a.a.c.a;
import com.google.a.c.b;
import com.google.a.g;
import com.google.a.v;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public final class c implements v {
    private static b a(a aVar, int i, int i2) {
        b bVar = aVar.e;
        if (bVar == null) {
            throw new IllegalStateException();
        }
        int i3 = bVar.f3061a;
        int i4 = bVar.f3062b;
        int max = Math.max(i, i3);
        int max2 = Math.max(i2, i4);
        int min = Math.min(max / i3, max2 / i4);
        int i5 = (max - (i3 * min)) / 2;
        int i6 = (max2 - (i4 * min)) / 2;
        b bVar2 = new b(max, max2);
        int i7 = 0;
        while (i7 < i4) {
            int i8 = i5;
            int i9 = 0;
            while (i9 < i3) {
                if (bVar.a(i9, i7)) {
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

    private static b a(String str, com.google.a.a aVar, int i, int i2, Charset charset, int i3, int i4) {
        if (aVar == com.google.a.a.AZTEC) {
            return a(com.google.a.a.c.c.a(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(aVar)));
    }

    public final b a(String str, com.google.a.a aVar, int i, int i2) {
        return a(str, aVar, i, i2, (Map<g, ?>) null);
    }

    public final b a(String str, com.google.a.a aVar, int i, int i2, Map<g, ?> map) {
        Charset charset = StandardCharsets.ISO_8859_1;
        int i3 = 33;
        int i4 = 0;
        if (map != null) {
            if (map.containsKey(g.CHARACTER_SET)) {
                charset = Charset.forName(map.get(g.CHARACTER_SET).toString());
            }
            if (map.containsKey(g.ERROR_CORRECTION)) {
                i3 = Integer.parseInt(map.get(g.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(g.AZTEC_LAYERS)) {
                i4 = Integer.parseInt(map.get(g.AZTEC_LAYERS).toString());
            }
        }
        if (aVar == com.google.a.a.AZTEC) {
            return a(com.google.a.a.c.c.a(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(aVar)));
    }
}

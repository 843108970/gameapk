package com.google.a.g;

import com.google.a.a;
import com.google.a.c.b;
import com.google.a.g;
import com.google.a.v;
import com.google.a.w;
import java.util.Map;

public abstract class s implements v {
    protected static int a(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = i;
        boolean z2 = z;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            int i6 = i2;
            int i7 = 0;
            while (i7 < i5) {
                zArr[i6] = z2;
                i7++;
                i6++;
            }
            i4 += i5;
            z2 = !z2;
            i3++;
            i2 = i6;
        }
        return i4;
    }

    private static b a(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = i3 + length;
        int max = Math.max(i, i4);
        int max2 = Math.max(1, i2);
        int i5 = max / i4;
        b bVar = new b(max, max2);
        int i6 = (max - (length * i5)) / 2;
        int i7 = 0;
        while (i7 < length) {
            if (zArr[i7]) {
                bVar.a(i6, 0, i5, max2);
            }
            i7++;
            i6 += i5;
        }
        return bVar;
    }

    public int a() {
        return 10;
    }

    public final b a(String str, a aVar, int i, int i2) throws w {
        return a(str, aVar, i, i2, (Map<g, ?>) null);
    }

    public b a(String str, a aVar, int i, int i2, Map<g, ?> map) throws w {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        } else {
            int a2 = a();
            if (map != null && map.containsKey(g.MARGIN)) {
                a2 = Integer.parseInt(map.get(g.MARGIN).toString());
            }
            return a(a(str), i, i2, a2);
        }
    }

    public abstract boolean[] a(String str);
}

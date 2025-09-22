package com.google.a.g;

import com.google.a.a;
import com.google.a.c.b;
import com.google.a.g;
import com.google.a.h;
import com.google.a.w;
import java.util.Map;

public final class ab extends z {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3189a = 51;

    public final b a(String str, a aVar, int i, int i2, Map<g, ?> map) throws w {
        if (aVar == a.UPC_E) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int length = str.length();
        switch (length) {
            case 7:
                try {
                    str = str + y.b(aa.b(str));
                    break;
                } catch (h e) {
                    throw new IllegalArgumentException(e);
                }
            case 8:
                try {
                    if (!y.a((CharSequence) str)) {
                        throw new IllegalArgumentException("Contents do not pass checksum");
                    }
                } catch (h unused) {
                    throw new IllegalArgumentException("Illegal contents");
                }
                break;
            default:
                throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
        }
        int digit = Character.digit(str.charAt(0), 10);
        if (digit == 0 || digit == 1) {
            int i = aa.f3188a[digit][Character.digit(str.charAt(7), 10)];
            boolean[] zArr = new boolean[51];
            int a2 = a(zArr, 0, y.f3230b, true) + 0;
            for (int i2 = 1; i2 <= 6; i2++) {
                int digit2 = Character.digit(str.charAt(i2), 10);
                if (((i >> (6 - i2)) & 1) == 1) {
                    digit2 += 10;
                }
                a2 += a(zArr, a2, y.f[digit2], false);
            }
            a(zArr, a2, y.d, false);
            return zArr;
        }
        throw new IllegalArgumentException("Number system must be 0 or 1");
    }
}

package com.google.a.g;

import com.google.a.a;
import com.google.a.c.b;
import com.google.a.g;
import com.google.a.h;
import com.google.a.w;
import java.util.Map;

public final class j extends z {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3206a = 95;

    public final b a(String str, a aVar, int i, int i2, Map<g, ?> map) throws w {
        if (aVar == a.EAN_13) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int length = str.length();
        switch (length) {
            case 12:
                try {
                    str = str + y.b(str);
                    break;
                } catch (h e) {
                    throw new IllegalArgumentException(e);
                }
            case 13:
                try {
                    if (!y.a((CharSequence) str)) {
                        throw new IllegalArgumentException("Contents do not pass checksum");
                    }
                } catch (h unused) {
                    throw new IllegalArgumentException("Illegal contents");
                }
                break;
            default:
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
        }
        int i = i.f3205a[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int a2 = a(zArr, 0, y.f3230b, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int digit = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                digit += 10;
            }
            a2 += a(zArr, a2, y.f[digit], false);
        }
        int a3 = a2 + a(zArr, a2, y.f3231c, false);
        for (int i3 = 7; i3 <= 12; i3++) {
            a3 += a(zArr, a3, y.e[Character.digit(str.charAt(i3), 10)], true);
        }
        a(zArr, a3, y.f3230b, true);
        return zArr;
    }
}

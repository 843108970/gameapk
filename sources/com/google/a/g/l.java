package com.google.a.g;

import com.google.a.a;
import com.google.a.c.b;
import com.google.a.g;
import com.google.a.h;
import com.google.a.w;
import java.util.Map;

public final class l extends z {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3208a = 67;

    public final b a(String str, a aVar, int i, int i2, Map<g, ?> map) throws w {
        if (aVar == a.EAN_8) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int length = str.length();
        switch (length) {
            case 7:
                try {
                    str = str + y.b(str);
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
        boolean[] zArr = new boolean[67];
        int a2 = a(zArr, 0, y.f3230b, true) + 0;
        for (int i = 0; i <= 3; i++) {
            a2 += a(zArr, a2, y.e[Character.digit(str.charAt(i), 10)], false);
        }
        int a3 = a2 + a(zArr, a2, y.f3231c, false);
        for (int i2 = 4; i2 <= 7; i2++) {
            a3 += a(zArr, a3, y.e[Character.digit(str.charAt(i2), 10)], true);
        }
        a(zArr, a3, y.f3230b, true);
        return zArr;
    }
}

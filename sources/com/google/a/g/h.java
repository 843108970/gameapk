package com.google.a.g;

import com.google.a.a;
import com.google.a.c.b;
import com.google.a.g;
import com.google.a.w;
import java.util.Map;

public final class h extends s {
    private static int a(String str, int i) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }

    @Deprecated
    private static int a(boolean[] zArr, int i, int[] iArr) {
        return b(zArr, i, iArr);
    }

    private static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    private static int b(boolean[] zArr, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = i;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            zArr[i2] = iArr[i3] != 0;
            i3++;
            i2 = i4;
        }
        return 9;
    }

    public final b a(String str, a aVar, int i, int i2, Map<g, ?> map) throws w {
        if (aVar == a.CODE_93) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        int[] iArr = new int[9];
        a(g.f3203b[47], iArr);
        boolean[] zArr = new boolean[(((str.length() + 2 + 2) * 9) + 1)];
        int b2 = b(zArr, 0, iArr);
        for (int i = 0; i < length; i++) {
            a(g.f3203b["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i))], iArr);
            b2 += b(zArr, b2, iArr);
        }
        int a2 = a(str, 20);
        a(g.f3203b[a2], iArr);
        int b3 = b2 + b(zArr, b2, iArr);
        a(g.f3203b[a(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(a2), 15)], iArr);
        int b4 = b3 + b(zArr, b3, iArr);
        a(g.f3203b[47], iArr);
        zArr[b4 + b(zArr, b4, iArr)] = true;
        return zArr;
    }
}

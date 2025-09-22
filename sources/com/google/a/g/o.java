package com.google.a.g;

import com.google.a.a;
import com.google.a.c.b;
import com.google.a.g;
import com.google.a.w;
import java.util.Map;

public final class o extends s {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3214a = {1, 1, 1, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3215b = {3, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    private static final int f3216c = 3;
    private static final int d = 1;
    private static final int[][] e = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    public final b a(String str, a aVar, int i, int i2, Map<g, ?> map) throws w {
        if (aVar == a.ITF) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        } else if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        } else {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int a2 = a(zArr, 0, f3214a, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[10];
                for (int i2 = 0; i2 < 5; i2++) {
                    int i3 = i2 * 2;
                    iArr[i3] = e[digit][i2];
                    iArr[i3 + 1] = e[digit2][i2];
                }
                a2 += a(zArr, a2, iArr, true);
            }
            a(zArr, a2, f3215b, true);
            return zArr;
        }
    }
}

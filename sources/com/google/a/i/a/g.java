package com.google.a.i.a;

import android.support.v7.widget.ActivityChooserView;

final class g {

    /* renamed from: c  reason: collision with root package name */
    private static final int f3304c = 21522;
    private static final int[][] d = {new int[]{f3304c, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: a  reason: collision with root package name */
    final f f3305a;

    /* renamed from: b  reason: collision with root package name */
    final byte f3306b;

    private g(int i) {
        this.f3305a = f.forBits((i >> 3) & 3);
        this.f3306b = (byte) (i & 7);
    }

    static int a(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    private f a() {
        return this.f3305a;
    }

    private byte b() {
        return this.f3306b;
    }

    static g b(int i, int i2) {
        g c2 = c(i, i2);
        return c2 != null ? c2 : c(i ^ f3304c, i2 ^ f3304c);
    }

    private static g c(int i, int i2) {
        int bitCount;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i4 = 0;
        for (int[] iArr : d) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new g(iArr[1]);
            }
            int bitCount2 = Integer.bitCount(i ^ i5);
            if (bitCount2 < i3) {
                i4 = iArr[1];
                i3 = bitCount2;
            }
            if (i != i2 && (bitCount = Integer.bitCount(i5 ^ i2)) < i3) {
                i4 = iArr[1];
                i3 = bitCount;
            }
        }
        if (i3 <= 3) {
            return new g(i4);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f3305a == gVar.f3305a && this.f3306b == gVar.f3306b;
    }

    public final int hashCode() {
        return (this.f3305a.ordinal() << 3) | this.f3306b;
    }
}

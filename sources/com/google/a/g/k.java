package com.google.a.g;

import com.google.a.c.a;
import com.google.a.m;

public final class k extends y {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f3207a = new int[4];

    /* access modifiers changed from: protected */
    public final int a(a aVar, int[] iArr, StringBuilder sb) throws m {
        int[] iArr2 = this.f3207a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = aVar.f3055b;
        int i2 = iArr[1];
        int i3 = 0;
        while (i3 < 4 && i2 < i) {
            sb.append((char) (a(aVar, iArr2, i2, e) + 48));
            int i4 = i2;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            i3++;
            i2 = i4;
        }
        int i6 = a(aVar, i2, true, f3231c)[1];
        int i7 = 0;
        while (i7 < 4 && i6 < i) {
            sb.append((char) (a(aVar, iArr2, i6, e) + 48));
            int i8 = i6;
            for (int i9 : iArr2) {
                i8 += i9;
            }
            i7++;
            i6 = i8;
        }
        return i6;
    }

    /* access modifiers changed from: package-private */
    public final com.google.a.a b() {
        return com.google.a.a.EAN_8;
    }
}

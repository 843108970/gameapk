package com.google.a.g;

import com.google.a.c.a;
import com.google.a.m;

public final class i extends y {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f3205a = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] g = new int[4];

    private static void a(StringBuilder sb, int i) throws m {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f3205a[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw m.getNotFoundInstance();
    }

    /* access modifiers changed from: protected */
    public final int a(a aVar, int[] iArr, StringBuilder sb) throws m {
        int[] iArr2 = this.g;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = aVar.f3055b;
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 6 && i2 < i) {
            int a2 = a(aVar, iArr2, i2, f);
            sb.append((char) ((a2 % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (a2 >= 10) {
                i4 = (1 << (5 - i3)) | i4;
            }
            i3++;
            i2 = i5;
        }
        for (int i7 = 0; i7 < 10; i7++) {
            if (i4 == f3205a[i7]) {
                sb.insert(0, (char) (i7 + 48));
                int i8 = a(aVar, i2, true, f3231c)[1];
                int i9 = 0;
                while (i9 < 6 && i8 < i) {
                    sb.append((char) (a(aVar, iArr2, i8, e) + 48));
                    int i10 = i8;
                    for (int i11 : iArr2) {
                        i10 += i11;
                    }
                    i9++;
                    i8 = i10;
                }
                return i8;
            }
        }
        throw m.getNotFoundInstance();
    }

    /* access modifiers changed from: package-private */
    public final com.google.a.a b() {
        return com.google.a.a.EAN_13;
    }
}

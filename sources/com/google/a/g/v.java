package com.google.a.g;

import com.google.a.c.a;
import com.google.a.m;
import com.google.a.r;
import com.google.a.s;
import com.google.a.t;
import java.util.EnumMap;
import java.util.Map;

final class v {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f3221a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f3222b = new StringBuilder();

    v() {
    }

    private int a(a aVar, int[] iArr, StringBuilder sb) throws m {
        int[] iArr2 = this.f3221a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = aVar.f3055b;
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 2 && i2 < i) {
            int a2 = y.a(aVar, iArr2, i2, y.f);
            sb.append((char) ((a2 % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (a2 >= 10) {
                i4 = (1 << (1 - i3)) | i4;
            }
            i2 = i3 != 1 ? aVar.d(aVar.c(i5)) : i5;
            i3++;
        }
        if (sb.length() != 2) {
            throw m.getNotFoundInstance();
        } else if (Integer.parseInt(sb.toString()) % 4 == i4) {
            return i2;
        } else {
            throw m.getNotFoundInstance();
        }
    }

    private static Map<s, Object> a(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(s.class);
        enumMap.put(s.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }

    /* access modifiers changed from: package-private */
    public final r a(int i, a aVar, int[] iArr) throws m {
        EnumMap enumMap;
        a aVar2 = aVar;
        StringBuilder sb = this.f3222b;
        sb.setLength(0);
        int[] iArr2 = this.f3221a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = aVar2.f3055b;
        int i3 = iArr[1];
        int i4 = 0;
        int i5 = 0;
        while (i4 < 2 && i3 < i2) {
            int a2 = y.a(aVar2, iArr2, i3, y.f);
            sb.append((char) ((a2 % 10) + 48));
            int i6 = i3;
            for (int i7 : iArr2) {
                i6 += i7;
            }
            if (a2 >= 10) {
                i5 = (1 << (1 - i4)) | i5;
            }
            i3 = i4 != 1 ? aVar2.d(aVar2.c(i6)) : i6;
            i4++;
        }
        if (sb.length() != 2) {
            throw m.getNotFoundInstance();
        } else if (Integer.parseInt(sb.toString()) % 4 != i5) {
            throw m.getNotFoundInstance();
        } else {
            String sb2 = sb.toString();
            if (sb2.length() != 2) {
                enumMap = null;
            } else {
                enumMap = new EnumMap(s.class);
                enumMap.put(s.ISSUE_NUMBER, Integer.valueOf(sb2));
            }
            float f = (float) i;
            r rVar = new r(sb2, (byte[]) null, new t[]{new t(((float) (iArr[0] + iArr[1])) / 2.0f, f), new t((float) i3, f)}, com.google.a.a.UPC_EAN_EXTENSION);
            if (enumMap != null) {
                rVar.a((Map<s, Object>) enumMap);
            }
            return rVar;
        }
    }
}

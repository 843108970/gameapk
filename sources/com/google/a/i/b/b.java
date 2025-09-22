package com.google.a.i.b;

import com.google.a.m;
import com.google.a.u;
import java.util.ArrayList;
import java.util.List;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final com.google.a.c.b f3317a;

    /* renamed from: b  reason: collision with root package name */
    final List<a> f3318b = new ArrayList(5);

    /* renamed from: c  reason: collision with root package name */
    final int f3319c;
    final int d;
    final int e;
    final int f;
    private final float g;
    private final int[] h;
    private final u i;

    b(com.google.a.c.b bVar, int i2, int i3, int i4, int i5, float f2, u uVar) {
        this.f3317a = bVar;
        this.f3319c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = f2;
        this.h = new int[3];
        this.i = uVar;
    }

    private float a(int i2, int i3, int i4, int i5) {
        com.google.a.c.b bVar = this.f3317a;
        int i6 = bVar.f3062b;
        int[] iArr = this.h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i7 = i2;
        while (i7 >= 0 && bVar.a(i3, i7) && iArr[1] <= i4) {
            iArr[1] = iArr[1] + 1;
            i7--;
        }
        if (i7 < 0 || iArr[1] > i4) {
            return Float.NaN;
        }
        while (i7 >= 0 && !bVar.a(i3, i7) && iArr[0] <= i4) {
            iArr[0] = iArr[0] + 1;
            i7--;
        }
        if (iArr[0] > i4) {
            return Float.NaN;
        }
        int i8 = i2 + 1;
        while (i8 < i6 && bVar.a(i3, i8) && iArr[1] <= i4) {
            iArr[1] = iArr[1] + 1;
            i8++;
        }
        if (i8 == i6 || iArr[1] > i4) {
            return Float.NaN;
        }
        while (i8 < i6 && !bVar.a(i3, i8) && iArr[2] <= i4) {
            iArr[2] = iArr[2] + 1;
            i8++;
        }
        if (iArr[2] <= i4 && Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i5) * 5 < i5 * 2 && a(iArr)) {
            return a(iArr, i8);
        }
        return Float.NaN;
    }

    private static float a(int[] iArr, int i2) {
        return ((float) (i2 - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    private a a() throws m {
        a a2;
        a a3;
        int i2 = this.f3319c;
        int i3 = this.f;
        int i4 = this.e + i2;
        int i5 = this.d + (i3 / 2);
        int[] iArr = new int[3];
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i8 = i2;
            while (i8 < i4 && !this.f3317a.a(i8, i7)) {
                i8++;
            }
            int i9 = 0;
            while (i8 < i4) {
                if (!this.f3317a.a(i8, i7)) {
                    if (i9 == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i9 != 2) {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                } else if (a(iArr) && (a3 = a(iArr, i7, i8)) != null) {
                    return a3;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i9 = 1;
                }
                i8++;
            }
            if (a(iArr) && (a2 = a(iArr, i7, i4)) != null) {
                return a2;
            }
        }
        if (!this.f3318b.isEmpty()) {
            return this.f3318b.get(0);
        }
        throw m.getNotFoundInstance();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0100 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.i.b.a a(int[] r13, int r14, int r15) {
        /*
            r12 = this;
            r0 = 0
            r1 = r13[r0]
            r2 = 1
            r3 = r13[r2]
            int r1 = r1 + r3
            r3 = 2
            r4 = r13[r3]
            int r1 = r1 + r4
            float r15 = a(r13, r15)
            int r4 = (int) r15
            r5 = r13[r2]
            int r5 = r5 * 2
            com.google.a.c.b r6 = r12.f3317a
            int r7 = r6.f3062b
            int[] r8 = r12.h
            r8[r0] = r0
            r8[r2] = r0
            r8[r3] = r0
            r9 = r14
        L_0x0021:
            if (r9 < 0) goto L_0x0035
            boolean r10 = r6.a((int) r4, (int) r9)
            if (r10 == 0) goto L_0x0035
            r10 = r8[r2]
            if (r10 > r5) goto L_0x0035
            r10 = r8[r2]
            int r10 = r10 + r2
            r8[r2] = r10
            int r9 = r9 + -1
            goto L_0x0021
        L_0x0035:
            r10 = 2143289344(0x7fc00000, float:NaN)
            if (r9 < 0) goto L_0x00ab
            r11 = r8[r2]
            if (r11 <= r5) goto L_0x003f
            goto L_0x00ab
        L_0x003f:
            if (r9 < 0) goto L_0x0053
            boolean r11 = r6.a((int) r4, (int) r9)
            if (r11 != 0) goto L_0x0053
            r11 = r8[r0]
            if (r11 > r5) goto L_0x0053
            r11 = r8[r0]
            int r11 = r11 + r2
            r8[r0] = r11
            int r9 = r9 + -1
            goto L_0x003f
        L_0x0053:
            r9 = r8[r0]
            if (r9 <= r5) goto L_0x0058
            goto L_0x00ab
        L_0x0058:
            int r14 = r14 + r2
        L_0x0059:
            if (r14 >= r7) goto L_0x006d
            boolean r9 = r6.a((int) r4, (int) r14)
            if (r9 == 0) goto L_0x006d
            r9 = r8[r2]
            if (r9 > r5) goto L_0x006d
            r9 = r8[r2]
            int r9 = r9 + r2
            r8[r2] = r9
            int r14 = r14 + 1
            goto L_0x0059
        L_0x006d:
            if (r14 == r7) goto L_0x00ab
            r9 = r8[r2]
            if (r9 <= r5) goto L_0x0074
            goto L_0x00ab
        L_0x0074:
            if (r14 >= r7) goto L_0x0088
            boolean r9 = r6.a((int) r4, (int) r14)
            if (r9 != 0) goto L_0x0088
            r9 = r8[r3]
            if (r9 > r5) goto L_0x0088
            r9 = r8[r3]
            int r9 = r9 + r2
            r8[r3] = r9
            int r14 = r14 + 1
            goto L_0x0074
        L_0x0088:
            r4 = r8[r3]
            if (r4 <= r5) goto L_0x008d
            goto L_0x00ab
        L_0x008d:
            r4 = r8[r0]
            r5 = r8[r2]
            int r4 = r4 + r5
            r5 = r8[r3]
            int r4 = r4 + r5
            int r4 = r4 - r1
            int r4 = java.lang.Math.abs(r4)
            int r4 = r4 * 5
            int r1 = r1 * 2
            if (r4 < r1) goto L_0x00a1
            goto L_0x00ab
        L_0x00a1:
            boolean r1 = r12.a(r8)
            if (r1 == 0) goto L_0x00ab
            float r10 = a(r8, r14)
        L_0x00ab:
            boolean r14 = java.lang.Float.isNaN(r10)
            if (r14 != 0) goto L_0x011e
            r14 = r13[r0]
            r1 = r13[r2]
            int r14 = r14 + r1
            r13 = r13[r3]
            int r14 = r14 + r13
            float r13 = (float) r14
            r14 = 1077936128(0x40400000, float:3.0)
            float r13 = r13 / r14
            java.util.List<com.google.a.i.b.a> r14 = r12.f3318b
            java.util.Iterator r14 = r14.iterator()
        L_0x00c3:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x0114
            java.lang.Object r1 = r14.next()
            com.google.a.i.b.a r1 = (com.google.a.i.b.a) r1
            float r3 = r1.f3357b
            float r3 = r10 - r3
            float r3 = java.lang.Math.abs(r3)
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 > 0) goto L_0x00fd
            float r3 = r1.f3356a
            float r3 = r15 - r3
            float r3 = java.lang.Math.abs(r3)
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 > 0) goto L_0x00fd
            float r3 = r1.f3316c
            float r3 = r13 - r3
            float r3 = java.lang.Math.abs(r3)
            r4 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x00fb
            float r4 = r1.f3316c
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x00fd
        L_0x00fb:
            r3 = 1
            goto L_0x00fe
        L_0x00fd:
            r3 = 0
        L_0x00fe:
            if (r3 == 0) goto L_0x00c3
            float r14 = r1.f3356a
            float r14 = r14 + r15
            r15 = 1073741824(0x40000000, float:2.0)
            float r14 = r14 / r15
            float r0 = r1.f3357b
            float r0 = r0 + r10
            float r0 = r0 / r15
            float r1 = r1.f3316c
            float r1 = r1 + r13
            float r1 = r1 / r15
            com.google.a.i.b.a r13 = new com.google.a.i.b.a
            r13.<init>(r14, r0, r1)
            return r13
        L_0x0114:
            com.google.a.i.b.a r14 = new com.google.a.i.b.a
            r14.<init>(r15, r10, r13)
            java.util.List<com.google.a.i.b.a> r13 = r12.f3318b
            r13.add(r14)
        L_0x011e:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.i.b.b.a(int[], int, int):com.google.a.i.b.a");
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int[] iArr) {
        float f2 = this.g;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - ((float) iArr[i2])) >= f3) {
                return false;
            }
        }
        return true;
    }
}

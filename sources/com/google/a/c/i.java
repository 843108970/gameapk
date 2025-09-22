package com.google.a.c;

import com.google.a.m;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static i f3080a = new f();

    public static i a() {
        return f3080a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.a.c.b r9, float[] r10) throws com.google.a.m {
        /*
            int r0 = r9.f3061a
            int r9 = r9.f3062b
            r1 = 0
            r2 = 1
            r3 = 0
            r4 = 1
        L_0x0008:
            int r5 = r10.length
            r6 = 0
            r7 = -1
            if (r3 >= r5) goto L_0x0045
            if (r4 == 0) goto L_0x0045
            r4 = r10[r3]
            int r4 = (int) r4
            int r5 = r3 + 1
            r8 = r10[r5]
            int r8 = (int) r8
            if (r4 < r7) goto L_0x0040
            if (r4 > r0) goto L_0x0040
            if (r8 < r7) goto L_0x0040
            if (r8 <= r9) goto L_0x0020
            goto L_0x0040
        L_0x0020:
            if (r4 != r7) goto L_0x0026
            r10[r3] = r6
        L_0x0024:
            r4 = 1
            goto L_0x002f
        L_0x0026:
            if (r4 != r0) goto L_0x002e
            int r4 = r0 + -1
            float r4 = (float) r4
            r10[r3] = r4
            goto L_0x0024
        L_0x002e:
            r4 = 0
        L_0x002f:
            if (r8 != r7) goto L_0x0035
            r10[r5] = r6
        L_0x0033:
            r4 = 1
            goto L_0x003d
        L_0x0035:
            if (r8 != r9) goto L_0x003d
            int r4 = r9 + -1
            float r4 = (float) r4
            r10[r5] = r4
            goto L_0x0033
        L_0x003d:
            int r3 = r3 + 2
            goto L_0x0008
        L_0x0040:
            com.google.a.m r9 = com.google.a.m.getNotFoundInstance()
            throw r9
        L_0x0045:
            int r3 = r10.length
            int r3 = r3 + -2
            r4 = 1
        L_0x0049:
            if (r3 < 0) goto L_0x0083
            if (r4 == 0) goto L_0x0083
            r4 = r10[r3]
            int r4 = (int) r4
            int r5 = r3 + 1
            r8 = r10[r5]
            int r8 = (int) r8
            if (r4 < r7) goto L_0x007e
            if (r4 > r0) goto L_0x007e
            if (r8 < r7) goto L_0x007e
            if (r8 <= r9) goto L_0x005e
            goto L_0x007e
        L_0x005e:
            if (r4 != r7) goto L_0x0064
            r10[r3] = r6
        L_0x0062:
            r4 = 1
            goto L_0x006d
        L_0x0064:
            if (r4 != r0) goto L_0x006c
            int r4 = r0 + -1
            float r4 = (float) r4
            r10[r3] = r4
            goto L_0x0062
        L_0x006c:
            r4 = 0
        L_0x006d:
            if (r8 != r7) goto L_0x0073
            r10[r5] = r6
        L_0x0071:
            r4 = 1
            goto L_0x007b
        L_0x0073:
            if (r8 != r9) goto L_0x007b
            int r4 = r9 + -1
            float r4 = (float) r4
            r10[r5] = r4
            goto L_0x0071
        L_0x007b:
            int r3 = r3 + -2
            goto L_0x0049
        L_0x007e:
            com.google.a.m r9 = com.google.a.m.getNotFoundInstance()
            throw r9
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.c.i.a(com.google.a.c.b, float[]):void");
    }

    private static void a(i iVar) {
        f3080a = iVar;
    }

    public abstract b a(b bVar, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws m;

    public abstract b a(b bVar, int i, int i2, k kVar) throws m;
}

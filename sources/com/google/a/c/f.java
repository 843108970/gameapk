package com.google.a.c;

import com.google.a.m;

public final class f extends i {
    public final b a(b bVar, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws m {
        return a(bVar, i, i2, k.a(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.c.b a(com.google.a.c.b r23, int r24, int r25, com.google.a.c.k r26) throws com.google.a.m {
        /*
            r22 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            if (r1 <= 0) goto L_0x0117
            if (r2 > 0) goto L_0x000e
            goto L_0x0117
        L_0x000e:
            com.google.a.c.b r4 = new com.google.a.c.b
            r4.<init>(r1, r2)
            int r1 = r1 * 2
            float[] r1 = new float[r1]
            r6 = 0
        L_0x0018:
            if (r6 >= r2) goto L_0x0116
            int r7 = r1.length
            float r8 = (float) r6
            r9 = 1056964608(0x3f000000, float:0.5)
            float r8 = r8 + r9
            r10 = 0
        L_0x0020:
            if (r10 >= r7) goto L_0x002f
            int r11 = r10 / 2
            float r11 = (float) r11
            float r11 = r11 + r9
            r1[r10] = r11
            int r11 = r10 + 1
            r1[r11] = r8
            int r10 = r10 + 2
            goto L_0x0020
        L_0x002f:
            int r8 = r1.length
            float r9 = r3.f3083a
            float r10 = r3.f3084b
            float r11 = r3.f3085c
            float r12 = r3.d
            float r13 = r3.e
            float r14 = r3.f
            float r15 = r3.g
            float r5 = r3.h
            float r2 = r3.i
            r3 = 0
        L_0x0043:
            if (r3 >= r8) goto L_0x006e
            r16 = r1[r3]
            int r17 = r3 + 1
            r18 = r1[r17]
            float r19 = r11 * r16
            float r20 = r14 * r18
            float r19 = r19 + r20
            float r19 = r19 + r2
            float r20 = r9 * r16
            float r21 = r12 * r18
            float r20 = r20 + r21
            float r20 = r20 + r15
            float r20 = r20 / r19
            r1[r3] = r20
            float r16 = r16 * r10
            float r18 = r18 * r13
            float r16 = r16 + r18
            float r16 = r16 + r5
            float r16 = r16 / r19
            r1[r17] = r16
            int r3 = r3 + 2
            goto L_0x0043
        L_0x006e:
            int r2 = r0.f3061a
            int r3 = r0.f3062b
            r5 = 1
            r8 = 0
            r9 = 1
        L_0x0075:
            int r10 = r1.length
            r11 = 0
            r12 = -1
            if (r8 >= r10) goto L_0x00b2
            if (r9 == 0) goto L_0x00b2
            r9 = r1[r8]
            int r9 = (int) r9
            int r10 = r8 + 1
            r13 = r1[r10]
            int r13 = (int) r13
            if (r9 < r12) goto L_0x00ad
            if (r9 > r2) goto L_0x00ad
            if (r13 < r12) goto L_0x00ad
            if (r13 <= r3) goto L_0x008d
            goto L_0x00ad
        L_0x008d:
            if (r9 != r12) goto L_0x0093
            r1[r8] = r11
        L_0x0091:
            r9 = 1
            goto L_0x009c
        L_0x0093:
            if (r9 != r2) goto L_0x009b
            int r9 = r2 + -1
            float r9 = (float) r9
            r1[r8] = r9
            goto L_0x0091
        L_0x009b:
            r9 = 0
        L_0x009c:
            if (r13 != r12) goto L_0x00a2
            r1[r10] = r11
        L_0x00a0:
            r9 = 1
            goto L_0x00aa
        L_0x00a2:
            if (r13 != r3) goto L_0x00aa
            int r9 = r3 + -1
            float r9 = (float) r9
            r1[r10] = r9
            goto L_0x00a0
        L_0x00aa:
            int r8 = r8 + 2
            goto L_0x0075
        L_0x00ad:
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x00b2:
            int r8 = r1.length
            int r8 = r8 + -2
            r9 = 1
        L_0x00b6:
            if (r8 < 0) goto L_0x00f0
            if (r9 == 0) goto L_0x00f0
            r9 = r1[r8]
            int r9 = (int) r9
            int r10 = r8 + 1
            r13 = r1[r10]
            int r13 = (int) r13
            if (r9 < r12) goto L_0x00eb
            if (r9 > r2) goto L_0x00eb
            if (r13 < r12) goto L_0x00eb
            if (r13 <= r3) goto L_0x00cb
            goto L_0x00eb
        L_0x00cb:
            if (r9 != r12) goto L_0x00d1
            r1[r8] = r11
        L_0x00cf:
            r9 = 1
            goto L_0x00da
        L_0x00d1:
            if (r9 != r2) goto L_0x00d9
            int r9 = r2 + -1
            float r9 = (float) r9
            r1[r8] = r9
            goto L_0x00cf
        L_0x00d9:
            r9 = 0
        L_0x00da:
            if (r13 != r12) goto L_0x00e0
            r1[r10] = r11
        L_0x00de:
            r9 = 1
            goto L_0x00e8
        L_0x00e0:
            if (r13 != r3) goto L_0x00e8
            int r9 = r3 + -1
            float r9 = (float) r9
            r1[r10] = r9
            goto L_0x00de
        L_0x00e8:
            int r8 = r8 + -2
            goto L_0x00b6
        L_0x00eb:
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x00f0:
            r2 = 0
        L_0x00f1:
            if (r2 >= r7) goto L_0x010e
            r3 = r1[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0109 }
            int r3 = (int) r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0109 }
            int r5 = r2 + 1
            r5 = r1[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0109 }
            int r5 = (int) r5     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0109 }
            boolean r3 = r0.a((int) r3, (int) r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0109 }
            if (r3 == 0) goto L_0x0106
            int r3 = r2 / 2
            r4.b((int) r3, (int) r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0109 }
        L_0x0106:
            int r2 = r2 + 2
            goto L_0x00f1
        L_0x0109:
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x010e:
            int r6 = r6 + 1
            r2 = r25
            r3 = r26
            goto L_0x0018
        L_0x0116:
            return r4
        L_0x0117:
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.c.f.a(com.google.a.c.b, int, int, com.google.a.c.k):com.google.a.c.b");
    }
}

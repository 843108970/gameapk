package com.google.a.d;

import com.google.a.c;
import com.google.a.c.b;
import com.google.a.d.a.d;
import com.google.a.e;
import com.google.a.h;
import com.google.a.m;
import com.google.a.p;
import com.google.a.r;
import com.google.a.t;
import java.util.Map;

public final class a implements p {

    /* renamed from: a  reason: collision with root package name */
    private static final t[] f3089a = new t[0];

    /* renamed from: b  reason: collision with root package name */
    private final d f3090b = new d();

    private static int a(int[] iArr, b bVar) throws m {
        int i = bVar.f3061a;
        int i2 = iArr[0];
        int i3 = iArr[1];
        while (i2 < i && bVar.a(i2, i3)) {
            i2++;
        }
        if (i2 == i) {
            throw m.getNotFoundInstance();
        }
        int i4 = i2 - iArr[0];
        if (i4 != 0) {
            return i4;
        }
        throw m.getNotFoundInstance();
    }

    private static b a(b bVar) throws m {
        int[] b2 = bVar.b();
        int[] c2 = bVar.c();
        if (b2 == null || c2 == null) {
            throw m.getNotFoundInstance();
        }
        int i = bVar.f3061a;
        int i2 = b2[0];
        int i3 = b2[1];
        while (i2 < i && bVar.a(i2, i3)) {
            i2++;
        }
        if (i2 == i) {
            throw m.getNotFoundInstance();
        }
        int i4 = i2 - b2[0];
        if (i4 == 0) {
            throw m.getNotFoundInstance();
        }
        int i5 = b2[1];
        int i6 = c2[1];
        int i7 = b2[0];
        int i8 = ((c2[0] - i7) + 1) / i4;
        int i9 = ((i6 - i5) + 1) / i4;
        if (i8 <= 0 || i9 <= 0) {
            throw m.getNotFoundInstance();
        }
        int i10 = i4 / 2;
        int i11 = i5 + i10;
        int i12 = i7 + i10;
        b bVar2 = new b(i8, i9);
        for (int i13 = 0; i13 < i9; i13++) {
            int i14 = (i13 * i4) + i11;
            for (int i15 = 0; i15 < i8; i15++) {
                if (bVar.a((i15 * i4) + i12, i14)) {
                    bVar2.b(i15, i13);
                }
            }
        }
        return bVar2;
    }

    public final r a(c cVar) throws m, com.google.a.d, h {
        return a(cVar, (Map<e, ?>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x02f9  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.r a(com.google.a.c r28, java.util.Map<com.google.a.e, ?> r29) throws com.google.a.m, com.google.a.d, com.google.a.h {
        /*
            r27 = this;
            r0 = r27
            r1 = r29
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x008e
            com.google.a.e r4 = com.google.a.e.PURE_BARCODE
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x008e
            com.google.a.c.b r1 = r28.c()
            int[] r4 = r1.b()
            int[] r5 = r1.c()
            if (r4 == 0) goto L_0x0089
            if (r5 != 0) goto L_0x0021
            goto L_0x0089
        L_0x0021:
            int r6 = r1.f3061a
            r7 = r4[r2]
            r8 = r4[r3]
        L_0x0027:
            if (r7 >= r6) goto L_0x0032
            boolean r9 = r1.a((int) r7, (int) r8)
            if (r9 == 0) goto L_0x0032
            int r7 = r7 + 1
            goto L_0x0027
        L_0x0032:
            if (r7 != r6) goto L_0x0039
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0039:
            r6 = r4[r2]
            int r7 = r7 - r6
            if (r7 != 0) goto L_0x0043
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0043:
            r6 = r4[r3]
            r8 = r5[r3]
            r4 = r4[r2]
            r5 = r5[r2]
            int r5 = r5 - r4
            int r5 = r5 + r3
            int r5 = r5 / r7
            int r8 = r8 - r6
            int r8 = r8 + r3
            int r8 = r8 / r7
            if (r5 <= 0) goto L_0x0084
            if (r8 > 0) goto L_0x0056
            goto L_0x0084
        L_0x0056:
            int r3 = r7 / 2
            int r6 = r6 + r3
            int r4 = r4 + r3
            com.google.a.c.b r3 = new com.google.a.c.b
            r3.<init>(r5, r8)
            r9 = 0
        L_0x0060:
            if (r9 >= r8) goto L_0x007a
            int r10 = r9 * r7
            int r10 = r10 + r6
            r11 = 0
        L_0x0066:
            if (r11 >= r5) goto L_0x0077
            int r12 = r11 * r7
            int r12 = r12 + r4
            boolean r12 = r1.a((int) r12, (int) r10)
            if (r12 == 0) goto L_0x0074
            r3.b((int) r11, (int) r9)
        L_0x0074:
            int r11 = r11 + 1
            goto L_0x0066
        L_0x0077:
            int r9 = r9 + 1
            goto L_0x0060
        L_0x007a:
            com.google.a.d.a.d r1 = r0.f3090b
            com.google.a.c.e r1 = r1.a((com.google.a.c.b) r3)
            com.google.a.t[] r2 = f3089a
            goto L_0x032f
        L_0x0084:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0089:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x008e:
            com.google.a.d.b.a r1 = new com.google.a.d.b.a
            com.google.a.c.b r4 = r28.c()
            r1.<init>(r4)
            com.google.a.c.a.c r4 = r1.f3109b
            com.google.a.t[] r4 = r4.a()
            r5 = r4[r2]
            r6 = r4[r3]
            r7 = 2
            r8 = r4[r7]
            r9 = 3
            r4 = r4[r9]
            java.util.ArrayList r10 = new java.util.ArrayList
            r11 = 4
            r10.<init>(r11)
            com.google.a.d.b.a$a r12 = r1.b(r5, r6)
            r10.add(r12)
            com.google.a.d.b.a$a r12 = r1.b(r5, r8)
            r10.add(r12)
            com.google.a.d.b.a$a r12 = r1.b(r6, r4)
            r10.add(r12)
            com.google.a.d.b.a$a r12 = r1.b(r8, r4)
            r10.add(r12)
            com.google.a.d.b.a$b r12 = new com.google.a.d.b.a$b
            r13 = 0
            r12.<init>()
            java.util.Collections.sort(r10, r12)
            java.lang.Object r12 = r10.get(r2)
            com.google.a.d.b.a$a r12 = (com.google.a.d.b.a.C0050a) r12
            java.lang.Object r10 = r10.get(r3)
            com.google.a.d.b.a$a r10 = (com.google.a.d.b.a.C0050a) r10
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            com.google.a.t r15 = r12.f3110a
            com.google.a.d.b.a.a((java.util.Map<com.google.a.t, java.lang.Integer>) r14, (com.google.a.t) r15)
            com.google.a.t r12 = r12.f3111b
            com.google.a.d.b.a.a((java.util.Map<com.google.a.t, java.lang.Integer>) r14, (com.google.a.t) r12)
            com.google.a.t r12 = r10.f3110a
            com.google.a.d.b.a.a((java.util.Map<com.google.a.t, java.lang.Integer>) r14, (com.google.a.t) r12)
            com.google.a.t r10 = r10.f3111b
            com.google.a.d.b.a.a((java.util.Map<com.google.a.t, java.lang.Integer>) r14, (com.google.a.t) r10)
            java.util.Set r10 = r14.entrySet()
            java.util.Iterator r10 = r10.iterator()
            r12 = r13
            r15 = r12
            r16 = r15
        L_0x0103:
            boolean r17 = r10.hasNext()
            if (r17 == 0) goto L_0x012f
            java.lang.Object r17 = r10.next()
            r13 = r17
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r17 = r13.getKey()
            com.google.a.t r17 = (com.google.a.t) r17
            java.lang.Object r13 = r13.getValue()
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            if (r13 != r7) goto L_0x0127
            r15 = r17
        L_0x0125:
            r13 = 0
            goto L_0x0103
        L_0x0127:
            if (r12 != 0) goto L_0x012c
            r12 = r17
            goto L_0x0125
        L_0x012c:
            r16 = r17
            goto L_0x0125
        L_0x012f:
            if (r12 == 0) goto L_0x034d
            if (r15 == 0) goto L_0x034d
            if (r16 != 0) goto L_0x0137
            goto L_0x034d
        L_0x0137:
            com.google.a.t[] r10 = new com.google.a.t[r9]
            r10[r2] = r12
            r10[r3] = r15
            r10[r7] = r16
            com.google.a.t.a(r10)
            r12 = r10[r2]
            r13 = r10[r3]
            r10 = r10[r7]
            boolean r15 = r14.containsKey(r5)
            if (r15 != 0) goto L_0x0150
            r4 = r5
            goto L_0x015f
        L_0x0150:
            boolean r5 = r14.containsKey(r6)
            if (r5 != 0) goto L_0x0158
            r4 = r6
            goto L_0x015f
        L_0x0158:
            boolean r5 = r14.containsKey(r8)
            if (r5 != 0) goto L_0x015f
            r4 = r8
        L_0x015f:
            com.google.a.d.b.a$a r5 = r1.b(r10, r4)
            int r5 = r5.f3112c
            com.google.a.d.b.a$a r6 = r1.b(r12, r4)
            int r6 = r6.f3112c
            r8 = r5 & 1
            if (r8 != r3) goto L_0x0171
            int r5 = r5 + 1
        L_0x0171:
            int r5 = r5 + r7
            r8 = r6 & 1
            if (r8 != r3) goto L_0x0178
            int r6 = r6 + 1
        L_0x0178:
            int r6 = r6 + r7
            int r8 = r5 * 4
            int r14 = r6 * 7
            if (r8 >= r14) goto L_0x0249
            int r8 = r6 * 4
            int r14 = r5 * 7
            if (r8 < r14) goto L_0x0187
            goto L_0x0249
        L_0x0187:
            int r5 = java.lang.Math.min(r6, r5)
            int r6 = com.google.a.d.b.a.a((com.google.a.t) r13, (com.google.a.t) r12)
            float r6 = (float) r6
            float r5 = (float) r5
            float r6 = r6 / r5
            int r8 = com.google.a.d.b.a.a((com.google.a.t) r10, (com.google.a.t) r4)
            float r14 = r4.f3356a
            float r15 = r10.f3356a
            float r14 = r14 - r15
            float r8 = (float) r8
            float r14 = r14 / r8
            float r15 = r4.f3357b
            float r9 = r10.f3357b
            float r15 = r15 - r9
            float r15 = r15 / r8
            com.google.a.t r8 = new com.google.a.t
            float r9 = r4.f3356a
            float r14 = r14 * r6
            float r9 = r9 + r14
            float r14 = r4.f3357b
            float r6 = r6 * r15
            float r14 = r14 + r6
            r8.<init>(r9, r14)
            int r6 = com.google.a.d.b.a.a((com.google.a.t) r13, (com.google.a.t) r10)
            float r6 = (float) r6
            float r6 = r6 / r5
            int r5 = com.google.a.d.b.a.a((com.google.a.t) r12, (com.google.a.t) r4)
            float r9 = r4.f3356a
            float r14 = r12.f3356a
            float r9 = r9 - r14
            float r5 = (float) r5
            float r9 = r9 / r5
            float r14 = r4.f3357b
            float r15 = r12.f3357b
            float r14 = r14 - r15
            float r14 = r14 / r5
            com.google.a.t r5 = new com.google.a.t
            float r15 = r4.f3356a
            float r9 = r9 * r6
            float r15 = r15 + r9
            float r9 = r4.f3357b
            float r6 = r6 * r14
            float r9 = r9 + r6
            r5.<init>(r15, r9)
            boolean r6 = r1.a(r8)
            if (r6 != 0) goto L_0x01e7
            boolean r6 = r1.a(r5)
            if (r6 != 0) goto L_0x0215
            r18 = 0
            goto L_0x0217
        L_0x01e7:
            boolean r6 = r1.a(r5)
            if (r6 != 0) goto L_0x01ee
            goto L_0x0212
        L_0x01ee:
            com.google.a.d.b.a$a r6 = r1.b(r10, r8)
            int r6 = r6.f3112c
            com.google.a.d.b.a$a r9 = r1.b(r12, r8)
            int r9 = r9.f3112c
            int r6 = r6 - r9
            int r6 = java.lang.Math.abs(r6)
            com.google.a.d.b.a$a r9 = r1.b(r10, r5)
            int r9 = r9.f3112c
            com.google.a.d.b.a$a r14 = r1.b(r12, r5)
            int r14 = r14.f3112c
            int r9 = r9 - r14
            int r9 = java.lang.Math.abs(r9)
            if (r6 > r9) goto L_0x0215
        L_0x0212:
            r18 = r8
            goto L_0x0217
        L_0x0215:
            r18 = r5
        L_0x0217:
            if (r18 != 0) goto L_0x021a
            goto L_0x021c
        L_0x021a:
            r4 = r18
        L_0x021c:
            com.google.a.d.b.a$a r5 = r1.b(r10, r4)
            int r5 = r5.f3112c
            com.google.a.d.b.a$a r6 = r1.b(r12, r4)
            int r6 = r6.f3112c
            int r5 = java.lang.Math.max(r5, r6)
            int r5 = r5 + r3
            r6 = r5 & 1
            if (r6 != r3) goto L_0x0233
            int r5 = r5 + 1
        L_0x0233:
            r25 = r5
            com.google.a.c.b r1 = r1.f3108a
            r19 = r1
            r20 = r10
            r21 = r13
            r22 = r12
            r23 = r4
            r24 = r25
        L_0x0243:
            com.google.a.c.b r1 = com.google.a.d.b.a.a(r19, r20, r21, r22, r23, r24, r25)
            goto L_0x0313
        L_0x0249:
            int r8 = com.google.a.d.b.a.a((com.google.a.t) r13, (com.google.a.t) r12)
            float r8 = (float) r8
            float r9 = (float) r5
            float r8 = r8 / r9
            int r9 = com.google.a.d.b.a.a((com.google.a.t) r10, (com.google.a.t) r4)
            float r14 = r4.f3356a
            float r15 = r10.f3356a
            float r14 = r14 - r15
            float r9 = (float) r9
            float r14 = r14 / r9
            float r15 = r4.f3357b
            float r7 = r10.f3357b
            float r15 = r15 - r7
            float r15 = r15 / r9
            com.google.a.t r7 = new com.google.a.t
            float r9 = r4.f3356a
            float r14 = r14 * r8
            float r9 = r9 + r14
            float r14 = r4.f3357b
            float r8 = r8 * r15
            float r14 = r14 + r8
            r7.<init>(r9, r14)
            int r8 = com.google.a.d.b.a.a((com.google.a.t) r13, (com.google.a.t) r10)
            float r8 = (float) r8
            float r9 = (float) r6
            float r8 = r8 / r9
            int r9 = com.google.a.d.b.a.a((com.google.a.t) r12, (com.google.a.t) r4)
            float r14 = r4.f3356a
            float r15 = r12.f3356a
            float r14 = r14 - r15
            float r9 = (float) r9
            float r14 = r14 / r9
            float r15 = r4.f3357b
            float r2 = r12.f3357b
            float r15 = r15 - r2
            float r15 = r15 / r9
            com.google.a.t r2 = new com.google.a.t
            float r9 = r4.f3356a
            float r14 = r14 * r8
            float r9 = r9 + r14
            float r14 = r4.f3357b
            float r8 = r8 * r15
            float r14 = r14 + r8
            r2.<init>(r9, r14)
            boolean r8 = r1.a(r7)
            if (r8 != 0) goto L_0x02a6
            boolean r5 = r1.a(r2)
            if (r5 != 0) goto L_0x02e2
            r18 = 0
            goto L_0x02e4
        L_0x02a6:
            boolean r8 = r1.a(r2)
            if (r8 != 0) goto L_0x02ad
            goto L_0x02df
        L_0x02ad:
            com.google.a.d.b.a$a r8 = r1.b(r10, r7)
            int r8 = r8.f3112c
            int r8 = r5 - r8
            int r8 = java.lang.Math.abs(r8)
            com.google.a.d.b.a$a r9 = r1.b(r12, r7)
            int r9 = r9.f3112c
            int r9 = r6 - r9
            int r9 = java.lang.Math.abs(r9)
            int r8 = r8 + r9
            com.google.a.d.b.a$a r9 = r1.b(r10, r2)
            int r9 = r9.f3112c
            int r5 = r5 - r9
            int r5 = java.lang.Math.abs(r5)
            com.google.a.d.b.a$a r9 = r1.b(r12, r2)
            int r9 = r9.f3112c
            int r6 = r6 - r9
            int r6 = java.lang.Math.abs(r6)
            int r5 = r5 + r6
            if (r8 > r5) goto L_0x02e2
        L_0x02df:
            r18 = r7
            goto L_0x02e4
        L_0x02e2:
            r18 = r2
        L_0x02e4:
            if (r18 != 0) goto L_0x02e7
            goto L_0x02e9
        L_0x02e7:
            r4 = r18
        L_0x02e9:
            com.google.a.d.b.a$a r2 = r1.b(r10, r4)
            int r2 = r2.f3112c
            com.google.a.d.b.a$a r5 = r1.b(r12, r4)
            int r5 = r5.f3112c
            r6 = r2 & 1
            if (r6 != r3) goto L_0x02fb
            int r2 = r2 + 1
        L_0x02fb:
            r24 = r2
            r2 = r5 & 1
            if (r2 != r3) goto L_0x0303
            int r5 = r5 + 1
        L_0x0303:
            r25 = r5
            com.google.a.c.b r1 = r1.f3108a
            r19 = r1
            r20 = r10
            r21 = r13
            r22 = r12
            r23 = r4
            goto L_0x0243
        L_0x0313:
            com.google.a.c.g r2 = new com.google.a.c.g
            com.google.a.t[] r5 = new com.google.a.t[r11]
            r6 = 0
            r5[r6] = r10
            r5[r3] = r13
            r3 = 2
            r5[r3] = r12
            r3 = 3
            r5[r3] = r4
            r2.<init>(r1, r5)
            com.google.a.d.a.d r1 = r0.f3090b
            com.google.a.c.b r3 = r2.d
            com.google.a.c.e r1 = r1.a((com.google.a.c.b) r3)
            com.google.a.t[] r2 = r2.e
        L_0x032f:
            com.google.a.r r3 = new com.google.a.r
            java.lang.String r4 = r1.f3077c
            byte[] r5 = r1.f3075a
            com.google.a.a r6 = com.google.a.a.DATA_MATRIX
            r3.<init>(r4, r5, r2, r6)
            java.util.List<byte[]> r2 = r1.d
            if (r2 == 0) goto L_0x0343
            com.google.a.s r4 = com.google.a.s.BYTE_SEGMENTS
            r3.a(r4, r2)
        L_0x0343:
            java.lang.String r1 = r1.e
            if (r1 == 0) goto L_0x034c
            com.google.a.s r2 = com.google.a.s.ERROR_CORRECTION_LEVEL
            r3.a(r2, r1)
        L_0x034c:
            return r3
        L_0x034d:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.a.a(com.google.a.c, java.util.Map):com.google.a.r");
    }

    public final void a() {
    }
}

package com.google.a.f.a.a;

import com.google.a.i.b.d;
import com.google.a.i.b.e;
import com.google.a.i.b.f;
import com.google.a.m;
import com.google.a.t;
import com.google.a.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class b extends e {
    private static final f[] e = new f[0];
    private static final float f = 180.0f;
    private static final float g = 9.0f;
    private static final float h = 0.05f;
    private static final float i = 0.5f;

    private static final class a implements Serializable, Comparator<d> {
        private a() {
        }

        public final int compare(d dVar, d dVar2) {
            double d = (double) (dVar2.f3322c - dVar.f3322c);
            if (d < 0.0d) {
                return -1;
            }
            return d > 0.0d ? 1 : 0;
        }
    }

    private b(com.google.a.c.b bVar) {
        super(bVar);
    }

    b(com.google.a.c.b bVar, byte b2) {
        super(bVar, (u) null);
    }

    private d[][] b() throws m {
        List<d> list = this.d;
        int size = list.size();
        int i2 = 3;
        if (size < 3) {
            throw m.getNotFoundInstance();
        } else if (size == 3) {
            return new d[][]{new d[]{list.get(0), list.get(1), list.get(2)}};
        } else {
            Collections.sort(list, new a());
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (i3 < size - 2) {
                d dVar = list.get(i3);
                if (dVar != null) {
                    int i4 = i3 + 1;
                    while (i4 < size - 1) {
                        d dVar2 = list.get(i4);
                        if (dVar2 != null) {
                            float min = (dVar.f3322c - dVar2.f3322c) / Math.min(dVar.f3322c, dVar2.f3322c);
                            float abs = Math.abs(dVar.f3322c - dVar2.f3322c);
                            float f2 = i;
                            int i5 = (abs > i ? 1 : (abs == i ? 0 : -1));
                            float f3 = h;
                            if (i5 > 0 && min >= h) {
                                break;
                            }
                            int i6 = i4 + 1;
                            while (i6 < size) {
                                d dVar3 = list.get(i6);
                                if (dVar3 != null) {
                                    float min2 = (dVar2.f3322c - dVar3.f3322c) / Math.min(dVar2.f3322c, dVar3.f3322c);
                                    if (Math.abs(dVar2.f3322c - dVar3.f3322c) > f2 && min2 >= f3) {
                                        break;
                                    }
                                    d[] dVarArr = new d[i2];
                                    dVarArr[0] = dVar;
                                    dVarArr[1] = dVar2;
                                    dVarArr[2] = dVar3;
                                    t.a(dVarArr);
                                    f fVar = new f(dVarArr);
                                    float a2 = t.a(fVar.f3327b, fVar.f3326a);
                                    float a3 = t.a(fVar.f3328c, fVar.f3326a);
                                    float a4 = t.a(fVar.f3327b, fVar.f3328c);
                                    float f4 = (a2 + a4) / (dVar.f3322c * 2.0f);
                                    if (f4 <= f && f4 >= g && Math.abs((a2 - a4) / Math.min(a2, a4)) < 0.1f) {
                                        float sqrt = (float) Math.sqrt((double) ((a2 * a2) + (a4 * a4)));
                                        if (Math.abs((a3 - sqrt) / Math.min(a3, sqrt)) < 0.1f) {
                                            arrayList.add(dVarArr);
                                        }
                                    }
                                }
                                i6++;
                                i2 = 3;
                                f2 = i;
                                f3 = h;
                            }
                        }
                        i4++;
                        i2 = 3;
                    }
                }
                i3++;
                i2 = 3;
            }
            if (!arrayList.isEmpty()) {
                return (d[][]) arrayList.toArray(new d[arrayList.size()][]);
            }
            throw m.getNotFoundInstance();
        }
    }

    /* JADX WARNING: type inference failed for: r1v10, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.i.b.f[] a() throws com.google.a.m {
        /*
            r19 = this;
            r0 = r19
            com.google.a.c.b r1 = r0.f3325c
            int r2 = r1.f3062b
            int r3 = r1.f3061a
            int r4 = r2 * 3
            int r4 = r4 / 388
            r5 = 3
            if (r4 >= r5) goto L_0x0010
            r4 = 3
        L_0x0010:
            r6 = 5
            int[] r6 = new int[r6]
            int r7 = r4 + -1
        L_0x0015:
            r8 = 0
            r9 = 1
            if (r7 >= r2) goto L_0x006a
            b(r6)
            r10 = 0
            r11 = 0
        L_0x001e:
            if (r10 >= r3) goto L_0x005f
            boolean r12 = r1.a((int) r10, (int) r7)
            if (r12 == 0) goto L_0x0032
            r12 = r11 & 1
            if (r12 != r9) goto L_0x002c
            int r11 = r11 + 1
        L_0x002c:
            r12 = r6[r11]
            int r12 = r12 + r9
            r6[r11] = r12
            goto L_0x005c
        L_0x0032:
            r12 = r11 & 1
            if (r12 != 0) goto L_0x0057
            r12 = 4
            if (r11 != r12) goto L_0x004f
            boolean r11 = a((int[]) r6)
            if (r11 == 0) goto L_0x004a
            boolean r11 = r0.a(r6, r7, r10)
            if (r11 == 0) goto L_0x004a
            b(r6)
            r11 = 0
            goto L_0x005c
        L_0x004a:
            c(r6)
            r11 = 3
            goto L_0x005c
        L_0x004f:
            int r11 = r11 + 1
            r12 = r6[r11]
            int r12 = r12 + r9
            r6[r11] = r12
            goto L_0x005c
        L_0x0057:
            r12 = r6[r11]
            int r12 = r12 + r9
            r6[r11] = r12
        L_0x005c:
            int r10 = r10 + 1
            goto L_0x001e
        L_0x005f:
            boolean r8 = a((int[]) r6)
            if (r8 == 0) goto L_0x0068
            r0.a(r6, r7, r3)
        L_0x0068:
            int r7 = r7 + r4
            goto L_0x0015
        L_0x006a:
            java.util.List<com.google.a.i.b.d> r1 = r0.d
            int r2 = r1.size()
            if (r2 >= r5) goto L_0x0077
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0077:
            r3 = 2
            if (r2 != r5) goto L_0x009a
            com.google.a.i.b.d[][] r2 = new com.google.a.i.b.d[r9][]
            com.google.a.i.b.d[] r4 = new com.google.a.i.b.d[r5]
            java.lang.Object r5 = r1.get(r8)
            com.google.a.i.b.d r5 = (com.google.a.i.b.d) r5
            r4[r8] = r5
            java.lang.Object r5 = r1.get(r9)
            com.google.a.i.b.d r5 = (com.google.a.i.b.d) r5
            r4[r9] = r5
            java.lang.Object r1 = r1.get(r3)
            com.google.a.i.b.d r1 = (com.google.a.i.b.d) r1
            r4[r3] = r1
            r2[r8] = r4
            goto L_0x01bc
        L_0x009a:
            com.google.a.f.a.a.b$a r4 = new com.google.a.f.a.a.b$a
            r6 = 0
            r4.<init>()
            java.util.Collections.sort(r1, r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r6 = 0
        L_0x00a9:
            int r7 = r2 + -2
            if (r6 >= r7) goto L_0x01a9
            java.lang.Object r7 = r1.get(r6)
            com.google.a.i.b.d r7 = (com.google.a.i.b.d) r7
            if (r7 == 0) goto L_0x019f
            int r10 = r6 + 1
        L_0x00b7:
            int r11 = r2 + -1
            if (r10 >= r11) goto L_0x019f
            java.lang.Object r11 = r1.get(r10)
            com.google.a.i.b.d r11 = (com.google.a.i.b.d) r11
            if (r11 == 0) goto L_0x0195
            float r12 = r7.f3322c
            float r13 = r11.f3322c
            float r12 = r12 - r13
            float r13 = r7.f3322c
            float r14 = r11.f3322c
            float r13 = java.lang.Math.min(r13, r14)
            float r12 = r12 / r13
            float r13 = r7.f3322c
            float r14 = r11.f3322c
            float r13 = r13 - r14
            float r13 = java.lang.Math.abs(r13)
            r14 = 1056964608(0x3f000000, float:0.5)
            int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            r15 = 1028443341(0x3d4ccccd, float:0.05)
            if (r13 <= 0) goto L_0x00e7
            int r12 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r12 >= 0) goto L_0x019f
        L_0x00e7:
            int r12 = r10 + 1
        L_0x00e9:
            if (r12 >= r2) goto L_0x0195
            java.lang.Object r13 = r1.get(r12)
            com.google.a.i.b.d r13 = (com.google.a.i.b.d) r13
            if (r13 == 0) goto L_0x0186
            float r3 = r11.f3322c
            float r9 = r13.f3322c
            float r3 = r3 - r9
            float r9 = r11.f3322c
            float r8 = r13.f3322c
            float r8 = java.lang.Math.min(r9, r8)
            float r3 = r3 / r8
            float r8 = r11.f3322c
            float r9 = r13.f3322c
            float r8 = r8 - r9
            float r8 = java.lang.Math.abs(r8)
            int r8 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x0112
            int r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x0195
        L_0x0112:
            com.google.a.i.b.d[] r3 = new com.google.a.i.b.d[r5]
            r8 = 0
            r3[r8] = r7
            r9 = 1
            r3[r9] = r11
            r16 = 2
            r3[r16] = r13
            com.google.a.t.a(r3)
            com.google.a.i.b.f r13 = new com.google.a.i.b.f
            r13.<init>(r3)
            com.google.a.i.b.d r5 = r13.f3327b
            com.google.a.i.b.d r8 = r13.f3326a
            float r5 = com.google.a.t.a(r5, r8)
            com.google.a.i.b.d r8 = r13.f3328c
            com.google.a.i.b.d r9 = r13.f3326a
            float r8 = com.google.a.t.a(r8, r9)
            com.google.a.i.b.d r9 = r13.f3327b
            com.google.a.i.b.d r13 = r13.f3328c
            float r9 = com.google.a.t.a(r9, r13)
            float r13 = r5 + r9
            float r14 = r7.f3322c
            r17 = 1073741824(0x40000000, float:2.0)
            float r14 = r14 * r17
            float r13 = r13 / r14
            r14 = 1127481344(0x43340000, float:180.0)
            int r14 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0188
            r14 = 1091567616(0x41100000, float:9.0)
            int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r13 < 0) goto L_0x0188
            float r13 = r5 - r9
            float r14 = java.lang.Math.min(r5, r9)
            float r13 = r13 / r14
            float r13 = java.lang.Math.abs(r13)
            r14 = 1036831949(0x3dcccccd, float:0.1)
            int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r13 >= 0) goto L_0x0188
            float r5 = r5 * r5
            float r9 = r9 * r9
            float r5 = r5 + r9
            double r14 = (double) r5
            double r13 = java.lang.Math.sqrt(r14)
            float r5 = (float) r13
            float r9 = r8 - r5
            float r5 = java.lang.Math.min(r8, r5)
            float r9 = r9 / r5
            float r5 = java.lang.Math.abs(r9)
            r8 = 1036831949(0x3dcccccd, float:0.1)
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x0188
            r4.add(r3)
            goto L_0x0188
        L_0x0186:
            r16 = 2
        L_0x0188:
            int r12 = r12 + 1
            r3 = 2
            r5 = 3
            r8 = 0
            r9 = 1
            r14 = 1056964608(0x3f000000, float:0.5)
            r15 = 1028443341(0x3d4ccccd, float:0.05)
            goto L_0x00e9
        L_0x0195:
            r16 = 2
            int r10 = r10 + 1
            r3 = 2
            r5 = 3
            r8 = 0
            r9 = 1
            goto L_0x00b7
        L_0x019f:
            r16 = 2
            int r6 = r6 + 1
            r3 = 2
            r5 = 3
            r8 = 0
            r9 = 1
            goto L_0x00a9
        L_0x01a9:
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L_0x01eb
            int r1 = r4.size()
            com.google.a.i.b.d[][] r1 = new com.google.a.i.b.d[r1][]
            java.lang.Object[] r1 = r4.toArray(r1)
            r2 = r1
            com.google.a.i.b.d[][] r2 = (com.google.a.i.b.d[][]) r2
        L_0x01bc:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r3 = r2.length
            r4 = 0
        L_0x01c3:
            if (r4 >= r3) goto L_0x01d5
            r5 = r2[r4]
            com.google.a.t.a(r5)
            com.google.a.i.b.f r6 = new com.google.a.i.b.f
            r6.<init>(r5)
            r1.add(r6)
            int r4 = r4 + 1
            goto L_0x01c3
        L_0x01d5:
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x01de
            com.google.a.i.b.f[] r1 = e
            return r1
        L_0x01de:
            int r2 = r1.size()
            com.google.a.i.b.f[] r2 = new com.google.a.i.b.f[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            com.google.a.i.b.f[] r1 = (com.google.a.i.b.f[]) r1
            return r1
        L_0x01eb:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.f.a.a.b.a():com.google.a.i.b.f[]");
    }
}

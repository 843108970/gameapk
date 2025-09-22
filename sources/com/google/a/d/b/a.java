package com.google.a.d.b;

import com.google.a.c.a.c;
import com.google.a.c.i;
import com.google.a.m;
import com.google.a.t;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import org.apache.commons.io.IOUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final com.google.a.c.b f3108a;

    /* renamed from: b  reason: collision with root package name */
    public final c f3109b;

    /* renamed from: com.google.a.d.b.a$a  reason: collision with other inner class name */
    private static final class C0050a {

        /* renamed from: a  reason: collision with root package name */
        public final t f3110a;

        /* renamed from: b  reason: collision with root package name */
        public final t f3111b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3112c;

        private C0050a(t tVar, t tVar2, int i) {
            this.f3110a = tVar;
            this.f3111b = tVar2;
            this.f3112c = i;
        }

        /* synthetic */ C0050a(t tVar, t tVar2, int i, byte b2) {
            this(tVar, tVar2, i);
        }

        private t a() {
            return this.f3110a;
        }

        private t b() {
            return this.f3111b;
        }

        private int c() {
            return this.f3112c;
        }

        public final String toString() {
            return this.f3110a + "/" + this.f3111b + IOUtils.DIR_SEPARATOR_UNIX + this.f3112c;
        }
    }

    private static final class b implements Serializable, Comparator<C0050a> {
        private b() {
        }

        public final int compare(C0050a aVar, C0050a aVar2) {
            return aVar.f3112c - aVar2.f3112c;
        }
    }

    public a(com.google.a.c.b bVar) throws m {
        this.f3108a = bVar;
        this.f3109b = new c(bVar);
    }

    public static int a(t tVar, t tVar2) {
        return com.google.a.c.a.a.a(t.a(tVar, tVar2));
    }

    public static com.google.a.c.b a(com.google.a.c.b bVar, t tVar, t tVar2, t tVar3, t tVar4, int i, int i2) throws m {
        t tVar5 = tVar;
        t tVar6 = tVar2;
        t tVar7 = tVar3;
        t tVar8 = tVar4;
        i a2 = i.a();
        int i3 = i;
        float f = ((float) i3) - 0.5f;
        int i4 = i2;
        float f2 = ((float) i4) - 0.5f;
        float f3 = tVar5.f3356a;
        float f4 = tVar5.f3357b;
        float f5 = tVar8.f3356a;
        float f6 = tVar8.f3357b;
        float f7 = tVar7.f3356a;
        float f8 = tVar7.f3357b;
        return a2.a(bVar, i3, i4, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, f3, f4, f5, f6, f7, f8, tVar6.f3356a, tVar6.f3357b);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x026d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.a.c.g a() throws com.google.a.m {
        /*
            r26 = this;
            r0 = r26
            com.google.a.c.a.c r1 = r0.f3109b
            com.google.a.t[] r1 = r1.a()
            r2 = 0
            r3 = r1[r2]
            r4 = 1
            r5 = r1[r4]
            r6 = 2
            r7 = r1[r6]
            r8 = 3
            r1 = r1[r8]
            java.util.ArrayList r9 = new java.util.ArrayList
            r10 = 4
            r9.<init>(r10)
            com.google.a.d.b.a$a r11 = r0.b(r3, r5)
            r9.add(r11)
            com.google.a.d.b.a$a r11 = r0.b(r3, r7)
            r9.add(r11)
            com.google.a.d.b.a$a r11 = r0.b(r5, r1)
            r9.add(r11)
            com.google.a.d.b.a$a r11 = r0.b(r7, r1)
            r9.add(r11)
            com.google.a.d.b.a$b r11 = new com.google.a.d.b.a$b
            r12 = 0
            r11.<init>()
            java.util.Collections.sort(r9, r11)
            java.lang.Object r11 = r9.get(r2)
            com.google.a.d.b.a$a r11 = (com.google.a.d.b.a.C0050a) r11
            java.lang.Object r9 = r9.get(r4)
            com.google.a.d.b.a$a r9 = (com.google.a.d.b.a.C0050a) r9
            java.util.HashMap r13 = new java.util.HashMap
            r13.<init>()
            com.google.a.t r14 = r11.f3110a
            a((java.util.Map<com.google.a.t, java.lang.Integer>) r13, (com.google.a.t) r14)
            com.google.a.t r11 = r11.f3111b
            a((java.util.Map<com.google.a.t, java.lang.Integer>) r13, (com.google.a.t) r11)
            com.google.a.t r11 = r9.f3110a
            a((java.util.Map<com.google.a.t, java.lang.Integer>) r13, (com.google.a.t) r11)
            com.google.a.t r9 = r9.f3111b
            a((java.util.Map<com.google.a.t, java.lang.Integer>) r13, (com.google.a.t) r9)
            java.util.Set r9 = r13.entrySet()
            java.util.Iterator r9 = r9.iterator()
            r11 = r12
            r14 = r11
            r15 = r14
        L_0x006f:
            boolean r16 = r9.hasNext()
            if (r16 == 0) goto L_0x009b
            java.lang.Object r16 = r9.next()
            r12 = r16
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r16 = r12.getKey()
            com.google.a.t r16 = (com.google.a.t) r16
            java.lang.Object r12 = r12.getValue()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            if (r12 != r6) goto L_0x0093
            r14 = r16
        L_0x0091:
            r12 = 0
            goto L_0x006f
        L_0x0093:
            if (r11 != 0) goto L_0x0098
            r11 = r16
            goto L_0x0091
        L_0x0098:
            r15 = r16
            goto L_0x0091
        L_0x009b:
            if (r11 == 0) goto L_0x0291
            if (r14 == 0) goto L_0x0291
            if (r15 != 0) goto L_0x00a3
            goto L_0x0291
        L_0x00a3:
            com.google.a.t[] r9 = new com.google.a.t[r8]
            r9[r2] = r11
            r9[r4] = r14
            r9[r6] = r15
            com.google.a.t.a(r9)
            r11 = r9[r2]
            r12 = r9[r4]
            r9 = r9[r6]
            boolean r14 = r13.containsKey(r3)
            if (r14 != 0) goto L_0x00bc
            r1 = r3
            goto L_0x00cb
        L_0x00bc:
            boolean r3 = r13.containsKey(r5)
            if (r3 != 0) goto L_0x00c4
            r1 = r5
            goto L_0x00cb
        L_0x00c4:
            boolean r3 = r13.containsKey(r7)
            if (r3 != 0) goto L_0x00cb
            r1 = r7
        L_0x00cb:
            com.google.a.d.b.a$a r3 = r0.b(r9, r1)
            int r3 = r3.f3112c
            com.google.a.d.b.a$a r5 = r0.b(r11, r1)
            int r5 = r5.f3112c
            r7 = r3 & 1
            if (r7 != r4) goto L_0x00dd
            int r3 = r3 + 1
        L_0x00dd:
            int r3 = r3 + r6
            r7 = r5 & 1
            if (r7 != r4) goto L_0x00e4
            int r5 = r5 + 1
        L_0x00e4:
            int r5 = r5 + r6
            int r7 = r3 * 4
            int r13 = r5 * 7
            if (r7 >= r13) goto L_0x01b5
            int r7 = r5 * 4
            int r13 = r3 * 7
            if (r7 < r13) goto L_0x00f3
            goto L_0x01b5
        L_0x00f3:
            int r3 = java.lang.Math.min(r5, r3)
            int r5 = a((com.google.a.t) r12, (com.google.a.t) r11)
            float r5 = (float) r5
            float r3 = (float) r3
            float r5 = r5 / r3
            int r7 = a((com.google.a.t) r9, (com.google.a.t) r1)
            float r13 = r1.f3356a
            float r14 = r9.f3356a
            float r13 = r13 - r14
            float r7 = (float) r7
            float r13 = r13 / r7
            float r14 = r1.f3357b
            float r15 = r9.f3357b
            float r14 = r14 - r15
            float r14 = r14 / r7
            com.google.a.t r7 = new com.google.a.t
            float r15 = r1.f3356a
            float r13 = r13 * r5
            float r15 = r15 + r13
            float r13 = r1.f3357b
            float r5 = r5 * r14
            float r13 = r13 + r5
            r7.<init>(r15, r13)
            int r5 = a((com.google.a.t) r12, (com.google.a.t) r9)
            float r5 = (float) r5
            float r5 = r5 / r3
            int r3 = a((com.google.a.t) r11, (com.google.a.t) r1)
            float r13 = r1.f3356a
            float r14 = r11.f3356a
            float r13 = r13 - r14
            float r3 = (float) r3
            float r13 = r13 / r3
            float r14 = r1.f3357b
            float r15 = r11.f3357b
            float r14 = r14 - r15
            float r14 = r14 / r3
            com.google.a.t r3 = new com.google.a.t
            float r15 = r1.f3356a
            float r13 = r13 * r5
            float r15 = r15 + r13
            float r13 = r1.f3357b
            float r5 = r5 * r14
            float r13 = r13 + r5
            r3.<init>(r15, r13)
            boolean r5 = r0.a(r7)
            if (r5 != 0) goto L_0x0153
            boolean r5 = r0.a(r3)
            if (r5 != 0) goto L_0x0181
            r17 = 0
            goto L_0x0183
        L_0x0153:
            boolean r5 = r0.a(r3)
            if (r5 != 0) goto L_0x015a
            goto L_0x017e
        L_0x015a:
            com.google.a.d.b.a$a r5 = r0.b(r9, r7)
            int r5 = r5.f3112c
            com.google.a.d.b.a$a r13 = r0.b(r11, r7)
            int r13 = r13.f3112c
            int r5 = r5 - r13
            int r5 = java.lang.Math.abs(r5)
            com.google.a.d.b.a$a r13 = r0.b(r9, r3)
            int r13 = r13.f3112c
            com.google.a.d.b.a$a r14 = r0.b(r11, r3)
            int r14 = r14.f3112c
            int r13 = r13 - r14
            int r13 = java.lang.Math.abs(r13)
            if (r5 > r13) goto L_0x0181
        L_0x017e:
            r17 = r7
            goto L_0x0183
        L_0x0181:
            r17 = r3
        L_0x0183:
            if (r17 != 0) goto L_0x0186
            goto L_0x0188
        L_0x0186:
            r1 = r17
        L_0x0188:
            com.google.a.d.b.a$a r3 = r0.b(r9, r1)
            int r3 = r3.f3112c
            com.google.a.d.b.a$a r5 = r0.b(r11, r1)
            int r5 = r5.f3112c
            int r3 = java.lang.Math.max(r3, r5)
            int r3 = r3 + r4
            r5 = r3 & 1
            if (r5 != r4) goto L_0x019f
            int r3 = r3 + 1
        L_0x019f:
            r24 = r3
            com.google.a.c.b r3 = r0.f3108a
            r18 = r3
            r19 = r9
            r20 = r12
            r21 = r11
            r22 = r1
            r23 = r24
        L_0x01af:
            com.google.a.c.b r3 = a(r18, r19, r20, r21, r22, r23, r24)
            goto L_0x027f
        L_0x01b5:
            int r7 = a((com.google.a.t) r12, (com.google.a.t) r11)
            float r7 = (float) r7
            float r13 = (float) r3
            float r7 = r7 / r13
            int r13 = a((com.google.a.t) r9, (com.google.a.t) r1)
            float r14 = r1.f3356a
            float r15 = r9.f3356a
            float r14 = r14 - r15
            float r13 = (float) r13
            float r14 = r14 / r13
            float r15 = r1.f3357b
            float r8 = r9.f3357b
            float r15 = r15 - r8
            float r15 = r15 / r13
            com.google.a.t r8 = new com.google.a.t
            float r13 = r1.f3356a
            float r14 = r14 * r7
            float r13 = r13 + r14
            float r14 = r1.f3357b
            float r7 = r7 * r15
            float r14 = r14 + r7
            r8.<init>(r13, r14)
            int r7 = a((com.google.a.t) r12, (com.google.a.t) r9)
            float r7 = (float) r7
            float r13 = (float) r5
            float r7 = r7 / r13
            int r13 = a((com.google.a.t) r11, (com.google.a.t) r1)
            float r14 = r1.f3356a
            float r15 = r11.f3356a
            float r14 = r14 - r15
            float r13 = (float) r13
            float r14 = r14 / r13
            float r15 = r1.f3357b
            float r6 = r11.f3357b
            float r15 = r15 - r6
            float r15 = r15 / r13
            com.google.a.t r6 = new com.google.a.t
            float r13 = r1.f3356a
            float r14 = r14 * r7
            float r13 = r13 + r14
            float r14 = r1.f3357b
            float r7 = r7 * r15
            float r14 = r14 + r7
            r6.<init>(r13, r14)
            boolean r7 = r0.a(r8)
            if (r7 != 0) goto L_0x0212
            boolean r3 = r0.a(r6)
            if (r3 != 0) goto L_0x024e
            r17 = 0
            goto L_0x0250
        L_0x0212:
            boolean r7 = r0.a(r6)
            if (r7 != 0) goto L_0x0219
            goto L_0x024b
        L_0x0219:
            com.google.a.d.b.a$a r7 = r0.b(r9, r8)
            int r7 = r7.f3112c
            int r7 = r3 - r7
            int r7 = java.lang.Math.abs(r7)
            com.google.a.d.b.a$a r13 = r0.b(r11, r8)
            int r13 = r13.f3112c
            int r13 = r5 - r13
            int r13 = java.lang.Math.abs(r13)
            int r7 = r7 + r13
            com.google.a.d.b.a$a r13 = r0.b(r9, r6)
            int r13 = r13.f3112c
            int r3 = r3 - r13
            int r3 = java.lang.Math.abs(r3)
            com.google.a.d.b.a$a r13 = r0.b(r11, r6)
            int r13 = r13.f3112c
            int r5 = r5 - r13
            int r5 = java.lang.Math.abs(r5)
            int r3 = r3 + r5
            if (r7 > r3) goto L_0x024e
        L_0x024b:
            r17 = r8
            goto L_0x0250
        L_0x024e:
            r17 = r6
        L_0x0250:
            if (r17 != 0) goto L_0x0253
            goto L_0x0255
        L_0x0253:
            r1 = r17
        L_0x0255:
            com.google.a.d.b.a$a r3 = r0.b(r9, r1)
            int r3 = r3.f3112c
            com.google.a.d.b.a$a r5 = r0.b(r11, r1)
            int r5 = r5.f3112c
            r6 = r3 & 1
            if (r6 != r4) goto L_0x0267
            int r3 = r3 + 1
        L_0x0267:
            r23 = r3
            r3 = r5 & 1
            if (r3 != r4) goto L_0x026f
            int r5 = r5 + 1
        L_0x026f:
            r24 = r5
            com.google.a.c.b r3 = r0.f3108a
            r18 = r3
            r19 = r9
            r20 = r12
            r21 = r11
            r22 = r1
            goto L_0x01af
        L_0x027f:
            com.google.a.c.g r5 = new com.google.a.c.g
            com.google.a.t[] r6 = new com.google.a.t[r10]
            r6[r2] = r9
            r6[r4] = r12
            r2 = 2
            r6[r2] = r11
            r2 = 3
            r6[r2] = r1
            r5.<init>(r3, r6)
            return r5
        L_0x0291:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.b.a.a():com.google.a.c.g");
    }

    private t a(t tVar, t tVar2, t tVar3, t tVar4, int i) {
        float f = (float) i;
        float a2 = ((float) a(tVar, tVar2)) / f;
        float a3 = (float) a(tVar3, tVar4);
        t tVar5 = new t(tVar4.f3356a + (((tVar4.f3356a - tVar3.f3356a) / a3) * a2), tVar4.f3357b + (a2 * ((tVar4.f3357b - tVar3.f3357b) / a3)));
        float a4 = ((float) a(tVar, tVar3)) / f;
        float a5 = (float) a(tVar2, tVar4);
        t tVar6 = new t(tVar4.f3356a + (((tVar4.f3356a - tVar2.f3356a) / a5) * a4), tVar4.f3357b + (a4 * ((tVar4.f3357b - tVar2.f3357b) / a5)));
        if (a(tVar5)) {
            return (a(tVar6) && Math.abs(b(tVar3, tVar5).f3112c - b(tVar2, tVar5).f3112c) > Math.abs(b(tVar3, tVar6).f3112c - b(tVar2, tVar6).f3112c)) ? tVar6 : tVar5;
        }
        if (a(tVar6)) {
            return tVar6;
        }
        return null;
    }

    private t a(t tVar, t tVar2, t tVar3, t tVar4, int i, int i2) {
        float a2 = ((float) a(tVar, tVar2)) / ((float) i);
        float a3 = (float) a(tVar3, tVar4);
        t tVar5 = new t(tVar4.f3356a + (((tVar4.f3356a - tVar3.f3356a) / a3) * a2), tVar4.f3357b + (a2 * ((tVar4.f3357b - tVar3.f3357b) / a3)));
        float a4 = ((float) a(tVar, tVar3)) / ((float) i2);
        float a5 = (float) a(tVar2, tVar4);
        t tVar6 = new t(tVar4.f3356a + (((tVar4.f3356a - tVar2.f3356a) / a5) * a4), tVar4.f3357b + (a4 * ((tVar4.f3357b - tVar2.f3357b) / a5)));
        if (a(tVar5)) {
            return (a(tVar6) && Math.abs(i - b(tVar3, tVar5).f3112c) + Math.abs(i2 - b(tVar2, tVar5).f3112c) > Math.abs(i - b(tVar3, tVar6).f3112c) + Math.abs(i2 - b(tVar2, tVar6).f3112c)) ? tVar6 : tVar5;
        }
        if (a(tVar6)) {
            return tVar6;
        }
        return null;
    }

    public static void a(Map<t, Integer> map, t tVar) {
        Integer num = map.get(tVar);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        map.put(tVar, Integer.valueOf(i));
    }

    public final boolean a(t tVar) {
        return tVar.f3356a >= 0.0f && tVar.f3356a < ((float) this.f3108a.f3061a) && tVar.f3357b > 0.0f && tVar.f3357b < ((float) this.f3108a.f3062b);
    }

    public final C0050a b(t tVar, t tVar2) {
        int i;
        int i2;
        a aVar = this;
        t tVar3 = tVar;
        t tVar4 = tVar2;
        int i3 = (int) tVar3.f3356a;
        int i4 = (int) tVar3.f3357b;
        int i5 = (int) tVar4.f3356a;
        int i6 = (int) tVar4.f3357b;
        boolean z = Math.abs(i6 - i4) > Math.abs(i5 - i3);
        if (z) {
            int i7 = i4;
            i4 = i3;
            i3 = i7;
            int i8 = i6;
            i6 = i5;
            i5 = i8;
        }
        int abs = Math.abs(i5 - i3);
        int abs2 = Math.abs(i6 - i4);
        int i9 = (-abs) / 2;
        int i10 = -1;
        int i11 = i4 < i6 ? 1 : -1;
        if (i3 < i5) {
            i10 = 1;
        }
        boolean a2 = aVar.f3108a.a(z ? i4 : i3, z ? i3 : i4);
        int i12 = 0;
        while (i3 != i5) {
            com.google.a.c.b bVar = aVar.f3108a;
            int i13 = z ? i4 : i3;
            if (z) {
                i = i5;
                i2 = i3;
            } else {
                i = i5;
                i2 = i4;
            }
            boolean a3 = bVar.a(i13, i2);
            if (a3 != a2) {
                i12++;
                a2 = a3;
            }
            i9 += abs2;
            if (i9 > 0) {
                if (i4 == i6) {
                    break;
                }
                i4 += i11;
                i9 -= abs;
            }
            i3 += i10;
            i5 = i;
            aVar = this;
        }
        return new C0050a(tVar3, tVar4, i12, (byte) 0);
    }
}

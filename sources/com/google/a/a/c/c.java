package com.google.a.a.c;

import com.google.a.c.a;
import com.google.a.c.b;
import com.google.a.c.b.d;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2989a = 33;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2990b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f2991c = 32;
    private static final int d = 4;
    private static final int[] e = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private c() {
    }

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    private static a a(byte[] bArr) {
        return a(bArr, 33, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (r12 == 32) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.a.a.c.a a(byte[] r19, int r20, int r21) {
        /*
            com.google.a.a.c.d r1 = new com.google.a.a.c.d
            r2 = r19
            r1.<init>(r2)
            com.google.a.a.c.f r2 = com.google.a.a.c.f.f2997a
            java.util.List r2 = java.util.Collections.singletonList(r2)
            r3 = 0
            r4 = r2
            r2 = 0
        L_0x0010:
            byte[] r5 = r1.i
            int r5 = r5.length
            r6 = 3
            r7 = 5
            r8 = 4
            r9 = 32
            r10 = 2
            r11 = 1
            if (r2 >= r5) goto L_0x007d
            int r5 = r2 + 1
            byte[] r12 = r1.i
            int r12 = r12.length
            if (r5 >= r12) goto L_0x0028
            byte[] r12 = r1.i
            byte r12 = r12[r5]
            goto L_0x0029
        L_0x0028:
            r12 = 0
        L_0x0029:
            byte[] r13 = r1.i
            byte r13 = r13[r2]
            r14 = 13
            if (r13 == r14) goto L_0x004e
            r10 = 44
            if (r13 == r10) goto L_0x0048
            r8 = 46
            if (r13 == r8) goto L_0x0045
            r6 = 58
            if (r13 == r6) goto L_0x003f
        L_0x003d:
            r6 = 0
            goto L_0x0055
        L_0x003f:
            if (r12 != r9) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r7 = 0
        L_0x0043:
            r6 = r7
            goto L_0x0055
        L_0x0045:
            if (r12 != r9) goto L_0x003d
            goto L_0x0055
        L_0x0048:
            if (r12 != r9) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r8 = 0
        L_0x004c:
            r6 = r8
            goto L_0x0055
        L_0x004e:
            r6 = 10
            if (r12 != r6) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r10 = 0
        L_0x0054:
            r6 = r10
        L_0x0055:
            if (r6 <= 0) goto L_0x005e
            java.util.Collection r2 = com.google.a.a.c.d.a((java.lang.Iterable<com.google.a.a.c.f>) r4, (int) r2, (int) r6)
            r4 = r2
            r2 = r5
            goto L_0x007b
        L_0x005e:
            java.util.LinkedList r5 = new java.util.LinkedList
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x0067:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0077
            java.lang.Object r6 = r4.next()
            com.google.a.a.c.f r6 = (com.google.a.a.c.f) r6
            r1.a((com.google.a.a.c.f) r6, (int) r2, (java.util.Collection<com.google.a.a.c.f>) r5)
            goto L_0x0067
        L_0x0077:
            java.util.Collection r4 = com.google.a.a.c.d.a(r5)
        L_0x007b:
            int r2 = r2 + r11
            goto L_0x0010
        L_0x007d:
            com.google.a.a.c.d$1 r2 = new com.google.a.a.c.d$1
            r2.<init>()
            java.lang.Object r2 = java.util.Collections.min(r4, r2)
            com.google.a.a.c.f r2 = (com.google.a.a.c.f) r2
            byte[] r1 = r1.i
            com.google.a.c.a r1 = r2.a((byte[]) r1)
            int r2 = r1.f3055b
            int r2 = r2 * r20
            int r2 = r2 / 100
            r4 = 11
            int r2 = r2 + r4
            int r5 = r1.f3055b
            int r5 = r5 + r2
            if (r21 == 0) goto L_0x00f0
            if (r21 >= 0) goto L_0x00a0
            r5 = 1
            goto L_0x00a1
        L_0x00a0:
            r5 = 0
        L_0x00a1:
            int r6 = java.lang.Math.abs(r21)
            if (r5 == 0) goto L_0x00a8
            r9 = 4
        L_0x00a8:
            if (r6 <= r9) goto L_0x00be
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Illegal value %s for layers"
            java.lang.Object[] r4 = new java.lang.Object[r11]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)
            r4[r3] = r0
            java.lang.String r0 = java.lang.String.format(r2, r4)
            r1.<init>(r0)
            throw r1
        L_0x00be:
            int r0 = a((int) r6, (boolean) r5)
            int[] r9 = e
            r9 = r9[r6]
            int r12 = r0 % r9
            int r12 = r0 - r12
            com.google.a.c.a r1 = a((com.google.a.c.a) r1, (int) r9)
            int r13 = r1.f3055b
            int r13 = r13 + r2
            if (r13 <= r12) goto L_0x00db
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Data to large for user specified layer"
            r0.<init>(r1)
            throw r0
        L_0x00db:
            if (r5 == 0) goto L_0x00eb
            int r2 = r1.f3055b
            int r12 = r9 << 6
            if (r2 <= r12) goto L_0x00eb
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Data to large for user specified layer"
            r0.<init>(r1)
            throw r0
        L_0x00eb:
            r12 = r1
            r14 = r5
            r15 = r6
            r13 = r9
            goto L_0x0134
        L_0x00f0:
            r0 = 0
            r12 = r0
            r0 = 0
            r13 = 0
        L_0x00f4:
            if (r0 <= r9) goto L_0x00fe
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Data too large for an Aztec code"
            r0.<init>(r1)
            throw r0
        L_0x00fe:
            if (r0 > r6) goto L_0x0102
            r14 = 1
            goto L_0x0103
        L_0x0102:
            r14 = 0
        L_0x0103:
            if (r14 == 0) goto L_0x0108
            int r15 = r0 + 1
            goto L_0x0109
        L_0x0108:
            r15 = r0
        L_0x0109:
            int r3 = a((int) r15, (boolean) r14)
            if (r5 > r3) goto L_0x028a
            if (r12 == 0) goto L_0x0117
            int[] r17 = e
            r6 = r17[r15]
            if (r13 == r6) goto L_0x0120
        L_0x0117:
            int[] r6 = e
            r6 = r6[r15]
            com.google.a.c.a r12 = a((com.google.a.c.a) r1, (int) r6)
            r13 = r6
        L_0x0120:
            int r6 = r3 % r13
            int r6 = r3 - r6
            if (r14 == 0) goto L_0x012c
            int r9 = r12.f3055b
            int r11 = r13 << 6
            if (r9 > r11) goto L_0x028a
        L_0x012c:
            int r9 = r12.f3055b
            int r9 = r9 + r2
            if (r9 <= r6) goto L_0x0133
            goto L_0x028a
        L_0x0133:
            r0 = r3
        L_0x0134:
            com.google.a.c.a r0 = a((com.google.a.c.a) r12, (int) r0, (int) r13)
            int r1 = r12.f3055b
            int r1 = r1 / r13
            com.google.a.c.a r2 = new com.google.a.c.a
            r2.<init>()
            if (r14 == 0) goto L_0x0154
            int r3 = r15 + -1
            r2.b(r3, r10)
            int r3 = r1 + -1
            r5 = 6
            r2.b(r3, r5)
            r3 = 28
        L_0x014f:
            com.google.a.c.a r2 = a((com.google.a.c.a) r2, (int) r3, (int) r8)
            goto L_0x0161
        L_0x0154:
            int r3 = r15 + -1
            r2.b(r3, r7)
            int r3 = r1 + -1
            r2.b(r3, r4)
            r3 = 40
            goto L_0x014f
        L_0x0161:
            if (r14 == 0) goto L_0x0164
            goto L_0x0166
        L_0x0164:
            r4 = 14
        L_0x0166:
            int r3 = r15 << 2
            int r4 = r4 + r3
            int[] r3 = new int[r4]
            if (r14 == 0) goto L_0x0178
            r5 = 0
        L_0x016e:
            int r6 = r3.length
            if (r5 >= r6) goto L_0x0176
            r3[r5] = r5
            int r5 = r5 + 1
            goto L_0x016e
        L_0x0176:
            r5 = r4
            goto L_0x019e
        L_0x0178:
            int r5 = r4 + 1
            int r6 = r4 / 2
            int r8 = r6 + -1
            int r8 = r8 / 15
            int r8 = r8 * 2
            int r5 = r5 + r8
            int r8 = r5 / 2
            r9 = 0
        L_0x0186:
            if (r9 >= r6) goto L_0x019e
            int r11 = r9 / 15
            int r11 = r11 + r9
            int r12 = r6 - r9
            r13 = 1
            int r12 = r12 - r13
            int r17 = r8 - r11
            int r17 = r17 + -1
            r3[r12] = r17
            int r12 = r6 + r9
            int r11 = r11 + r8
            int r11 = r11 + r13
            r3[r12] = r11
            int r9 = r9 + 1
            goto L_0x0186
        L_0x019e:
            com.google.a.c.b r6 = new com.google.a.c.b
            r6.<init>(r5)
            r8 = 0
            r9 = 0
        L_0x01a5:
            if (r8 >= r15) goto L_0x023e
            int r11 = r15 - r8
            int r11 = r11 << r10
            if (r14 == 0) goto L_0x01af
            r12 = 9
            goto L_0x01b1
        L_0x01af:
            r12 = 12
        L_0x01b1:
            int r11 = r11 + r12
            r12 = 0
        L_0x01b3:
            if (r12 >= r11) goto L_0x0231
            int r13 = r12 << 1
            r7 = 0
        L_0x01b8:
            if (r7 >= r10) goto L_0x022a
            int r17 = r9 + r13
            int r10 = r17 + r7
            boolean r10 = r0.a((int) r10)
            if (r10 == 0) goto L_0x01d3
            int r10 = r8 << 1
            int r17 = r10 + r7
            r18 = r1
            r1 = r3[r17]
            int r10 = r10 + r12
            r10 = r3[r10]
            r6.b((int) r1, (int) r10)
            goto L_0x01d5
        L_0x01d3:
            r18 = r1
        L_0x01d5:
            int r1 = r11 << 1
            int r1 = r1 + r9
            int r1 = r1 + r13
            int r1 = r1 + r7
            boolean r1 = r0.a((int) r1)
            if (r1 == 0) goto L_0x01f1
            int r1 = r8 << 1
            int r10 = r1 + r12
            r10 = r3[r10]
            int r17 = r4 + -1
            int r17 = r17 - r1
            int r17 = r17 - r7
            r1 = r3[r17]
            r6.b((int) r10, (int) r1)
        L_0x01f1:
            int r1 = r11 << 2
            int r1 = r1 + r9
            int r1 = r1 + r13
            int r1 = r1 + r7
            boolean r1 = r0.a((int) r1)
            if (r1 == 0) goto L_0x020b
            int r1 = r4 + -1
            int r10 = r8 << 1
            int r1 = r1 - r10
            int r10 = r1 - r7
            r10 = r3[r10]
            int r1 = r1 - r12
            r1 = r3[r1]
            r6.b((int) r10, (int) r1)
        L_0x020b:
            int r1 = r11 * 6
            int r1 = r1 + r9
            int r1 = r1 + r13
            int r1 = r1 + r7
            boolean r1 = r0.a((int) r1)
            if (r1 == 0) goto L_0x0224
            int r1 = r4 + -1
            int r10 = r8 << 1
            int r1 = r1 - r10
            int r1 = r1 - r12
            r1 = r3[r1]
            int r10 = r10 + r7
            r10 = r3[r10]
            r6.b((int) r1, (int) r10)
        L_0x0224:
            int r7 = r7 + 1
            r1 = r18
            r10 = 2
            goto L_0x01b8
        L_0x022a:
            r18 = r1
            int r12 = r12 + 1
            r7 = 5
            r10 = 2
            goto L_0x01b3
        L_0x0231:
            r18 = r1
            int r1 = r11 << 3
            int r9 = r9 + r1
            int r8 = r8 + 1
            r1 = r18
            r7 = 5
            r10 = 2
            goto L_0x01a5
        L_0x023e:
            r18 = r1
            a(r6, r14, r5, r2)
            if (r14 == 0) goto L_0x024c
            int r0 = r5 / 2
            r3 = 5
            a((com.google.a.c.b) r6, (int) r0, (int) r3)
            goto L_0x0278
        L_0x024c:
            int r0 = r5 / 2
            r1 = 7
            a((com.google.a.c.b) r6, (int) r0, (int) r1)
            r1 = 0
            r7 = 2
            r16 = 0
        L_0x0256:
            int r2 = r4 / 2
            r9 = 1
            int r2 = r2 - r9
            if (r1 >= r2) goto L_0x0278
            r2 = r0 & 1
        L_0x025e:
            if (r2 >= r5) goto L_0x0273
            int r3 = r0 - r16
            r6.b((int) r3, (int) r2)
            int r8 = r0 + r16
            r6.b((int) r8, (int) r2)
            r6.b((int) r2, (int) r3)
            r6.b((int) r2, (int) r8)
            int r2 = r2 + 2
            goto L_0x025e
        L_0x0273:
            int r1 = r1 + 15
            int r16 = r16 + 16
            goto L_0x0256
        L_0x0278:
            com.google.a.a.c.a r0 = new com.google.a.a.c.a
            r0.<init>()
            r0.f2985a = r14
            r0.f2986b = r5
            r0.f2987c = r15
            r1 = r18
            r0.d = r1
            r0.e = r6
            return r0
        L_0x028a:
            r3 = 5
            r7 = 2
            r9 = 1
            int r0 = r0 + 1
            r3 = 0
            r6 = 3
            r7 = 5
            r9 = 32
            r10 = 2
            r11 = 1
            goto L_0x00f4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.c.c.a(byte[], int, int):com.google.a.a.c.a");
    }

    private static a a(a aVar, int i) {
        a aVar2 = new a();
        int i2 = aVar.f3055b;
        int i3 = (1 << i) - 2;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                int i7 = i4 + i6;
                if (i7 >= i2 || aVar.a(i7)) {
                    i5 |= 1 << ((i - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 != i3) {
                if (i8 == 0) {
                    i8 = i5 | 1;
                } else {
                    aVar2.b(i5, i);
                    i4 += i;
                }
            }
            aVar2.b(i8, i);
            i4--;
            i4 += i;
        }
        return aVar2;
    }

    private static a a(a aVar, int i, int i2) {
        com.google.a.c.b.a aVar2;
        int i3 = aVar.f3055b / i2;
        if (i2 == 4) {
            aVar2 = com.google.a.c.b.a.d;
        } else if (i2 == 6) {
            aVar2 = com.google.a.c.b.a.f3066c;
        } else if (i2 == 8) {
            aVar2 = com.google.a.c.b.a.g;
        } else if (i2 == 10) {
            aVar2 = com.google.a.c.b.a.f3065b;
        } else if (i2 != 12) {
            throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i2)));
        } else {
            aVar2 = com.google.a.c.b.a.f3064a;
        }
        d dVar = new d(aVar2);
        int i4 = i / i2;
        int[] b2 = b(aVar, i2, i4);
        dVar.a(b2, i4 - i3);
        a aVar3 = new a();
        aVar3.b(0, i % i2);
        for (int b3 : b2) {
            aVar3.b(b3, i2);
        }
        return aVar3;
    }

    private static a a(boolean z, int i, int i2) {
        int i3;
        a aVar = new a();
        if (z) {
            aVar.b(i - 1, 2);
            aVar.b(i2 - 1, 6);
            i3 = 28;
        } else {
            aVar.b(i - 1, 5);
            aVar.b(i2 - 1, 11);
            i3 = 40;
        }
        return a(aVar, i3, 4);
    }

    private static com.google.a.c.b.a a(int i) {
        if (i == 4) {
            return com.google.a.c.b.a.d;
        }
        if (i == 6) {
            return com.google.a.c.b.a.f3066c;
        }
        if (i == 8) {
            return com.google.a.c.b.a.g;
        }
        if (i == 10) {
            return com.google.a.c.b.a.f3065b;
        }
        if (i == 12) {
            return com.google.a.c.b.a.f3064a;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i)));
    }

    private static void a(b bVar, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 > i6) {
                    break;
                }
                bVar.b(i5, i4);
                bVar.b(i5, i6);
                bVar.b(i4, i5);
                bVar.b(i6, i5);
                i5++;
            }
        }
        int i7 = i - i2;
        bVar.b(i7, i7);
        int i8 = i7 + 1;
        bVar.b(i8, i7);
        bVar.b(i7, i8);
        int i9 = i + i2;
        bVar.b(i9, i7);
        bVar.b(i9, i8);
        bVar.b(i9, i9 - 1);
    }

    private static void a(b bVar, boolean z, int i, a aVar) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (aVar.a(i3)) {
                    bVar.b(i4, i2 - 5);
                }
                if (aVar.a(i3 + 7)) {
                    bVar.b(i2 + 5, i4);
                }
                if (aVar.a(20 - i3)) {
                    bVar.b(i4, i2 + 5);
                }
                if (aVar.a(27 - i3)) {
                    bVar.b(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (aVar.a(i3)) {
                bVar.b(i5, i2 - 7);
            }
            if (aVar.a(i3 + 10)) {
                bVar.b(i2 + 7, i5);
            }
            if (aVar.a(29 - i3)) {
                bVar.b(i5, i2 + 7);
            }
            if (aVar.a(39 - i3)) {
                bVar.b(i2 - 7, i5);
            }
            i3++;
        }
    }

    private static int[] b(a aVar, int i, int i2) {
        int[] iArr = new int[i2];
        int i3 = aVar.f3055b / i;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                i5 |= aVar.a((i4 * i) + i6) ? 1 << ((i - i6) - 1) : 0;
            }
            iArr[i4] = i5;
        }
        return iArr;
    }
}

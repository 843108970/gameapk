package com.google.a.i.c;

import com.google.a.c.a;
import com.google.a.i.a.f;
import com.google.a.i.a.j;
import com.google.a.w;
import java.util.Arrays;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f3340a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f3341b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f3342c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    private static final int[][] d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    private static final int e = 7973;
    private static final int f = 1335;
    private static final int g = 21522;

    private e() {
    }

    private static int a(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    private static int a(int i, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int numberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(i2);
        int i3 = i << (numberOfLeadingZeros - 1);
        while (32 - Integer.numberOfLeadingZeros(i3) >= numberOfLeadingZeros) {
            i3 ^= i2 << ((32 - Integer.numberOfLeadingZeros(i3)) - numberOfLeadingZeros);
        }
        return i3;
    }

    private static void a(int i, int i2, b bVar) throws w {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (!b((int) bVar.a(i4, i2))) {
                throw new w();
            }
            bVar.a(i4, i2, 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0069, code lost:
        r10 = r10 + r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0078, code lost:
        r10 = r10 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0079, code lost:
        if (r10 != 0) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007b, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007d, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007e, code lost:
        if (r10 == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0080, code lost:
        if (r9 != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0082, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        r9 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.a.c.a r12, int r13, com.google.a.i.c.b r14) throws com.google.a.w {
        /*
            int r0 = r14.f3332b
            r1 = 1
            int r0 = r0 - r1
            int r2 = r14.f3333c
            int r2 = r2 - r1
            r3 = -1
            r4 = 0
            r6 = r2
            r2 = 0
            r5 = -1
        L_0x000c:
            if (r0 <= 0) goto L_0x0094
            r7 = 6
            if (r0 != r7) goto L_0x0013
            int r0 = r0 + -1
        L_0x0013:
            if (r6 < 0) goto L_0x008e
            int r7 = r14.f3333c
            if (r6 >= r7) goto L_0x008e
            r7 = r2
            r2 = 0
        L_0x001b:
            r8 = 2
            if (r2 >= r8) goto L_0x008b
            int r8 = r0 - r2
            byte r9 = r14.a(r8, r6)
            boolean r9 = b((int) r9)
            if (r9 == 0) goto L_0x0088
            int r9 = r12.f3055b
            if (r7 >= r9) goto L_0x0035
            boolean r9 = r12.a((int) r7)
            int r7 = r7 + 1
            goto L_0x0036
        L_0x0035:
            r9 = 0
        L_0x0036:
            if (r13 == r3) goto L_0x0085
            switch(r13) {
                case 0: goto L_0x0076;
                case 1: goto L_0x0073;
                case 2: goto L_0x0070;
                case 3: goto L_0x006b;
                case 4: goto L_0x0065;
                case 5: goto L_0x005d;
                case 6: goto L_0x0053;
                case 7: goto L_0x004b;
                default: goto L_0x003b;
            }
        L_0x003b:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Invalid mask pattern: "
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r13 = r14.concat(r13)
            r12.<init>(r13)
            throw r12
        L_0x004b:
            int r10 = r6 * r8
            int r10 = r10 % 3
            int r11 = r6 + r8
            r11 = r11 & r1
            goto L_0x0069
        L_0x0053:
            int r10 = r6 * r8
            r11 = r10 & 1
            int r10 = r10 % 3
            int r11 = r11 + r10
            r10 = r11 & 1
            goto L_0x0079
        L_0x005d:
            int r10 = r6 * r8
            r11 = r10 & 1
            int r10 = r10 % 3
            int r10 = r10 + r11
            goto L_0x0079
        L_0x0065:
            int r10 = r6 / 2
            int r11 = r8 / 3
        L_0x0069:
            int r10 = r10 + r11
            goto L_0x0078
        L_0x006b:
            int r10 = r6 + r8
            int r10 = r10 % 3
            goto L_0x0079
        L_0x0070:
            int r10 = r8 % 3
            goto L_0x0079
        L_0x0073:
            r10 = r6 & 1
            goto L_0x0079
        L_0x0076:
            int r10 = r6 + r8
        L_0x0078:
            r10 = r10 & r1
        L_0x0079:
            if (r10 != 0) goto L_0x007d
            r10 = 1
            goto L_0x007e
        L_0x007d:
            r10 = 0
        L_0x007e:
            if (r10 == 0) goto L_0x0085
            if (r9 != 0) goto L_0x0084
            r9 = 1
            goto L_0x0085
        L_0x0084:
            r9 = 0
        L_0x0085:
            r14.a((int) r8, (int) r6, (boolean) r9)
        L_0x0088:
            int r2 = r2 + 1
            goto L_0x001b
        L_0x008b:
            int r6 = r6 + r5
            r2 = r7
            goto L_0x0013
        L_0x008e:
            int r5 = -r5
            int r6 = r6 + r5
            int r0 = r0 + -2
            goto L_0x000c
        L_0x0094:
            int r13 = r12.f3055b
            if (r2 == r13) goto L_0x00b6
            com.google.a.w r13 = new com.google.a.w
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "Not all bits consumed: "
            r14.<init>(r0)
            r14.append(r2)
            r0 = 47
            r14.append(r0)
            int r12 = r12.f3055b
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            r13.<init>((java.lang.String) r12)
            throw r13
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.i.c.e.a(com.google.a.c.a, int, com.google.a.i.c.b):void");
    }

    static void a(a aVar, f fVar, j jVar, int i, b bVar) throws w {
        j jVar2 = jVar;
        int i2 = i;
        b bVar2 = bVar;
        int i3 = 0;
        for (byte[] fill : bVar2.f3331a) {
            Arrays.fill(fill, (byte) -1);
        }
        int length = f3340a[0].length;
        d(0, 0, bVar2);
        d(bVar2.f3332b - length, 0, bVar2);
        d(0, bVar2.f3332b - length, bVar2);
        a(0, 7, bVar2);
        a(bVar2.f3332b - 8, 7, bVar2);
        a(0, bVar2.f3332b - 8, bVar2);
        b(7, 0, bVar2);
        b((bVar2.f3333c - 7) - 1, 0, bVar2);
        b(7, bVar2.f3333c - 7, bVar2);
        if (bVar2.a(8, bVar2.f3333c - 8) == 0) {
            throw new w();
        }
        bVar2.a(8, bVar2.f3333c - 8, 1);
        int i4 = 5;
        if (jVar2.f3308a >= 2) {
            int[] iArr = f3342c[jVar2.f3308a - 1];
            int length2 = iArr.length;
            int i5 = 0;
            while (i5 < length2) {
                int i6 = iArr[i5];
                if (i6 >= 0) {
                    int length3 = iArr.length;
                    int i7 = 0;
                    while (i7 < length3) {
                        int i8 = iArr[i7];
                        if (i8 >= 0 && b((int) bVar2.a(i8, i6))) {
                            int i9 = i8 - 2;
                            int i10 = i6 - 2;
                            int i11 = 0;
                            while (i11 < i4) {
                                int[] iArr2 = f3341b[i11];
                                while (i3 < i4) {
                                    bVar2.a(i9 + i3, i10 + i11, iArr2[i3]);
                                    i3++;
                                    i4 = 5;
                                }
                                i11++;
                                i3 = 0;
                                i4 = 5;
                            }
                        }
                        i7++;
                        i3 = 0;
                        i4 = 5;
                    }
                }
                i5++;
                i3 = 0;
                i4 = 5;
            }
        }
        int i12 = 8;
        while (i12 < bVar2.f3332b - 8) {
            int i13 = i12 + 1;
            int i14 = i13 % 2;
            if (b((int) bVar2.a(i12, 6))) {
                bVar2.a(i12, 6, i14);
            }
            if (b((int) bVar2.a(6, i12))) {
                bVar2.a(6, i12, i14);
            }
            i12 = i13;
        }
        a aVar2 = new a();
        if (!(i2 >= 0 && i2 < 8)) {
            throw new w("Invalid mask pattern");
        }
        int bits = (fVar.getBits() << 3) | i2;
        aVar2.b(bits, 5);
        aVar2.b(a(bits, (int) f), 10);
        a aVar3 = new a();
        aVar3.b(g, 15);
        if (aVar2.f3055b != aVar3.f3055b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i15 = 0; i15 < aVar2.f3054a.length; i15++) {
            int[] iArr3 = aVar2.f3054a;
            iArr3[i15] = iArr3[i15] ^ aVar3.f3054a[i15];
        }
        if (aVar2.f3055b != 15) {
            throw new w("should not happen but we got: " + aVar2.f3055b);
        }
        for (int i16 = 0; i16 < aVar2.f3055b; i16++) {
            boolean a2 = aVar2.a((aVar2.f3055b - 1) - i16);
            int[] iArr4 = d[i16];
            bVar2.a(iArr4[0], iArr4[1], a2);
            if (i16 < 8) {
                bVar2.a((bVar2.f3332b - i16) - 1, 8, a2);
            } else {
                bVar2.a(8, (bVar2.f3333c - 7) + (i16 - 8), a2);
            }
        }
        b(jVar2, bVar2);
        a(aVar, i2, bVar2);
    }

    private static void a(f fVar, int i, a aVar) throws w {
        if (!(i >= 0 && i < 8)) {
            throw new w("Invalid mask pattern");
        }
        int bits = (fVar.getBits() << 3) | i;
        aVar.b(bits, 5);
        aVar.b(a(bits, (int) f), 10);
        a aVar2 = new a();
        aVar2.b(g, 15);
        if (aVar.f3055b != aVar2.f3055b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i2 = 0; i2 < aVar.f3054a.length; i2++) {
            int[] iArr = aVar.f3054a;
            iArr[i2] = iArr[i2] ^ aVar2.f3054a[i2];
        }
        if (aVar.f3055b != 15) {
            throw new w("should not happen but we got: " + aVar.f3055b);
        }
    }

    private static void a(f fVar, int i, b bVar) throws w {
        a aVar = new a();
        if (!(i >= 0 && i < 8)) {
            throw new w("Invalid mask pattern");
        }
        int bits = (fVar.getBits() << 3) | i;
        aVar.b(bits, 5);
        aVar.b(a(bits, (int) f), 10);
        a aVar2 = new a();
        aVar2.b(g, 15);
        if (aVar.f3055b != aVar2.f3055b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i2 = 0; i2 < aVar.f3054a.length; i2++) {
            int[] iArr = aVar.f3054a;
            iArr[i2] = iArr[i2] ^ aVar2.f3054a[i2];
        }
        if (aVar.f3055b != 15) {
            throw new w("should not happen but we got: " + aVar.f3055b);
        }
        for (int i3 = 0; i3 < aVar.f3055b; i3++) {
            boolean a2 = aVar.a((aVar.f3055b - 1) - i3);
            int[] iArr2 = d[i3];
            bVar.a(iArr2[0], iArr2[1], a2);
            if (i3 < 8) {
                bVar.a((bVar.f3332b - i3) - 1, 8, a2);
            } else {
                bVar.a(8, (bVar.f3333c - 7) + (i3 - 8), a2);
            }
        }
    }

    private static void a(j jVar, a aVar) throws w {
        aVar.b(jVar.f3308a, 6);
        aVar.b(a(jVar.f3308a, (int) e), 12);
        if (aVar.f3055b != 18) {
            throw new w("should not happen but we got: " + aVar.f3055b);
        }
    }

    private static void a(j jVar, b bVar) throws w {
        j jVar2 = jVar;
        b bVar2 = bVar;
        int length = f3340a[0].length;
        d(0, 0, bVar2);
        d(bVar2.f3332b - length, 0, bVar2);
        d(0, bVar2.f3332b - length, bVar2);
        a(0, 7, bVar2);
        a(bVar2.f3332b - 8, 7, bVar2);
        a(0, bVar2.f3332b - 8, bVar2);
        b(7, 0, bVar2);
        b((bVar2.f3333c - 7) - 1, 0, bVar2);
        b(7, bVar2.f3333c - 7, bVar2);
        if (bVar2.a(8, bVar2.f3333c - 8) == 0) {
            throw new w();
        }
        bVar2.a(8, bVar2.f3333c - 8, 1);
        if (jVar2.f3308a >= 2) {
            int[] iArr = f3342c[jVar2.f3308a - 1];
            for (int i : iArr) {
                if (i >= 0) {
                    for (int i2 : iArr) {
                        if (i2 >= 0 && b((int) bVar2.a(i2, i))) {
                            int i3 = i2 - 2;
                            int i4 = i - 2;
                            int i5 = 0;
                            while (true) {
                                if (i5 >= 5) {
                                    break;
                                }
                                int[] iArr2 = f3341b[i5];
                                int i6 = 0;
                                for (int i7 = 5; i6 < i7; i7 = 5) {
                                    bVar2.a(i3 + i6, i4 + i5, iArr2[i6]);
                                    i6++;
                                }
                                i5++;
                            }
                        }
                    }
                }
            }
        }
        int i8 = 8;
        while (i8 < bVar2.f3332b - 8) {
            int i9 = i8 + 1;
            int i10 = i9 % 2;
            if (b((int) bVar2.a(i8, 6))) {
                bVar2.a(i8, 6, i10);
            }
            if (b((int) bVar2.a(6, i8))) {
                bVar2.a(6, i8, i10);
            }
            i8 = i9;
        }
    }

    private static void a(b bVar) {
        for (byte[] fill : bVar.f3331a) {
            Arrays.fill(fill, (byte) -1);
        }
    }

    private static void b(int i, int i2, b bVar) throws w {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (!b((int) bVar.a(i, i4))) {
                throw new w();
            }
            bVar.a(i, i4, 0);
        }
    }

    private static void b(j jVar, b bVar) throws w {
        if (jVar.f3308a >= 7) {
            a aVar = new a();
            aVar.b(jVar.f3308a, 6);
            aVar.b(a(jVar.f3308a, (int) e), 12);
            if (aVar.f3055b != 18) {
                throw new w("should not happen but we got: " + aVar.f3055b);
            }
            int i = 0;
            int i2 = 17;
            while (i < 6) {
                int i3 = i2;
                for (int i4 = 0; i4 < 3; i4++) {
                    boolean a2 = aVar.a(i3);
                    i3--;
                    bVar.a(i, (bVar.f3333c - 11) + i4, a2);
                    bVar.a((bVar.f3333c - 11) + i4, i, a2);
                }
                i++;
                i2 = i3;
            }
        }
    }

    private static void b(b bVar) {
        int i = 8;
        while (i < bVar.f3332b - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (b((int) bVar.a(i, 6))) {
                bVar.a(i, 6, i3);
            }
            if (b((int) bVar.a(6, i))) {
                bVar.a(6, i, i3);
            }
            i = i2;
        }
    }

    private static boolean b(int i) {
        return i == -1;
    }

    private static void c(int i, int i2, b bVar) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = f3341b[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                bVar.a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void c(j jVar, b bVar) {
        j jVar2 = jVar;
        b bVar2 = bVar;
        if (jVar2.f3308a >= 2) {
            int[] iArr = f3342c[jVar2.f3308a - 1];
            for (int i : iArr) {
                if (i >= 0) {
                    for (int i2 : iArr) {
                        if (i2 >= 0 && b((int) bVar2.a(i2, i))) {
                            int i3 = i2 - 2;
                            int i4 = i - 2;
                            for (int i5 = 0; i5 < 5; i5++) {
                                int[] iArr2 = f3341b[i5];
                                for (int i6 = 0; i6 < 5; i6++) {
                                    bVar2.a(i3 + i6, i4 + i5, iArr2[i6]);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void c(b bVar) throws w {
        if (bVar.a(8, bVar.f3333c - 8) == 0) {
            throw new w();
        }
        bVar.a(8, bVar.f3333c - 8, 1);
    }

    private static void d(int i, int i2, b bVar) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = f3340a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                bVar.a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void d(b bVar) throws w {
        int length = f3340a[0].length;
        d(0, 0, bVar);
        d(bVar.f3332b - length, 0, bVar);
        d(0, bVar.f3332b - length, bVar);
        a(0, 7, bVar);
        a(bVar.f3332b - 8, 7, bVar);
        a(0, bVar.f3332b - 8, bVar);
        b(7, 0, bVar);
        b((bVar.f3333c - 7) - 1, 0, bVar);
        b(7, bVar.f3333c - 7, bVar);
    }
}

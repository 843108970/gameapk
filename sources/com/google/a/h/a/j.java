package com.google.a.h.a;

import com.google.a.c.e;
import com.google.a.d;
import com.google.a.h;
import com.google.a.h.a.a.a;
import com.google.a.h.a.a.b;
import com.google.a.h.a.a.c;
import com.google.a.m;
import com.google.a.t;
import java.lang.reflect.Array;
import java.util.Formatter;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3263a = 2;

    /* renamed from: b  reason: collision with root package name */
    private static final int f3264b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3265c = 512;
    private static final a d = new a();

    private j() {
    }

    private static int a(int i) {
        return 2 << i;
    }

    private static int a(f fVar, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        d dVar = null;
        int i4 = i - i3;
        if (a(fVar, i4)) {
            dVar = fVar.f3256b[i4].c(i2);
        }
        if (dVar != null) {
            return z ? dVar.f3249b : dVar.f3248a;
        }
        d a2 = fVar.f3256b[i].a(i2);
        if (a2 != null) {
            return z ? a2.f3248a : a2.f3249b;
        }
        if (a(fVar, i4)) {
            a2 = fVar.f3256b[i4].a(i2);
        }
        if (a2 != null) {
            return z ? a2.f3249b : a2.f3248a;
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!a(fVar, i)) {
                return z ? fVar.f3257c.f : fVar.f3257c.g;
            }
            for (d dVar2 : fVar.f3256b[i].f3260b) {
                if (dVar2 != null) {
                    return (z ? dVar2.f3249b : dVar2.f3248a) + (i3 * i5 * (dVar2.f3249b - dVar2.f3248a));
                }
            }
            i5++;
        }
    }

    private static int a(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    private static int a(int[] iArr, int[] iArr2, int i) throws d {
        int i2;
        c cVar;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i3 = i;
        if ((iArr4 == null || iArr4.length <= (i3 / 2) + 3) && i3 >= 0 && i3 <= 512) {
            a aVar = d;
            c cVar2 = new c(aVar.f3238a, iArr3);
            int[] iArr5 = new int[i3];
            int i4 = i3;
            boolean z = false;
            while (true) {
                i2 = 1;
                if (i4 <= 0) {
                    break;
                }
                int b2 = cVar2.b(aVar.f3238a.f3240b[i4]);
                iArr5[i3 - i4] = b2;
                if (b2 != 0) {
                    z = true;
                }
                i4--;
            }
            if (!z) {
                return 0;
            }
            c cVar3 = aVar.f3238a.e;
            if (iArr4 != null) {
                c cVar4 = cVar3;
                for (int length : iArr4) {
                    cVar4 = cVar4.c(new c(aVar.f3238a, new int[]{aVar.f3238a.c(0, aVar.f3238a.f3240b[(iArr3.length - 1) - length]), 1}));
                }
            }
            c cVar5 = new c(aVar.f3238a, iArr5);
            c a2 = aVar.f3238a.a(i3, 1);
            if (a2.f3243b.length - 1 >= cVar5.f3243b.length - 1) {
                c cVar6 = a2;
                a2 = cVar5;
                cVar5 = cVar6;
            }
            c cVar7 = aVar.f3238a.d;
            c cVar8 = aVar.f3238a.e;
            c cVar9 = a2;
            c cVar10 = cVar5;
            c cVar11 = cVar9;
            while (cVar11.f3243b.length - i2 >= i3 / 2) {
                if (cVar11.a()) {
                    throw d.getChecksumInstance();
                }
                c cVar12 = aVar.f3238a.d;
                int a3 = aVar.f3238a.a(cVar11.a(cVar11.f3243b.length - i2));
                while (cVar10.f3243b.length - i2 >= cVar11.f3243b.length - i2 && !cVar10.a()) {
                    int length2 = (cVar10.f3243b.length - i2) - (cVar11.f3243b.length - i2);
                    int d2 = aVar.f3238a.d(cVar10.a(cVar10.f3243b.length - i2), a3);
                    cVar12 = cVar12.a(aVar.f3238a.a(length2, d2));
                    if (length2 < 0) {
                        throw new IllegalArgumentException();
                    }
                    if (d2 == 0) {
                        cVar = cVar11.f3242a.d;
                    } else {
                        int length3 = cVar11.f3243b.length;
                        int[] iArr6 = new int[(length2 + length3)];
                        for (int i5 = 0; i5 < length3; i5++) {
                            iArr6[i5] = cVar11.f3242a.d(cVar11.f3243b[i5], d2);
                        }
                        cVar = new c(cVar11.f3242a, iArr6);
                    }
                    cVar10 = cVar10.b(cVar);
                    i2 = 1;
                }
                i2 = 1;
                c cVar13 = cVar10;
                cVar10 = cVar11;
                cVar11 = cVar13;
                c cVar14 = cVar8;
                cVar8 = cVar12.c(cVar8).b(cVar7).b();
                cVar7 = cVar14;
            }
            int a4 = cVar8.a(0);
            if (a4 == 0) {
                throw d.getChecksumInstance();
            }
            int a5 = aVar.f3238a.a(a4);
            c[] cVarArr = {cVar8.c(a5), cVar11.c(a5)};
            c cVar15 = cVarArr[0];
            c cVar16 = cVarArr[1];
            int[] a6 = aVar.a(cVar15);
            int[] a7 = aVar.a(cVar16, cVar15, a6);
            for (int i6 = 0; i6 < a6.length; i6++) {
                int length4 = iArr3.length - 1;
                b bVar = aVar.f3238a;
                int i7 = a6[i6];
                if (i7 == 0) {
                    throw new IllegalArgumentException();
                }
                int i8 = length4 - bVar.f3241c[i7];
                if (i8 < 0) {
                    throw d.getChecksumInstance();
                }
                iArr3[i8] = aVar.f3238a.c(iArr3[i8], a7[i6]);
            }
            return a6.length;
        }
        throw d.getChecksumInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0225, code lost:
        r16 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x022b, code lost:
        throw com.google.a.d.getChecksumInstance();
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0231 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.a.c.e a(int r23, int[] r24, int[] r25, int[] r26, int[][] r27) throws com.google.a.h, com.google.a.d {
        /*
            r0 = r24
            r1 = r25
            r2 = r26
            int r3 = r2.length
            int[] r3 = new int[r3]
            r4 = 100
        L_0x000b:
            int r5 = r4 + -1
            if (r4 <= 0) goto L_0x025e
            r6 = 0
        L_0x0010:
            int r7 = r3.length
            if (r6 >= r7) goto L_0x0020
            r7 = r2[r6]
            r8 = r27[r6]
            r9 = r3[r6]
            r8 = r8[r9]
            r0[r7] = r8
            int r6 = r6 + 1
            goto L_0x0010
        L_0x0020:
            r6 = 1
            int r7 = r0.length     // Catch:{ d -> 0x022c }
            if (r7 != 0) goto L_0x0029
            com.google.a.h r7 = com.google.a.h.getFormatInstance()     // Catch:{ d -> 0x022c }
            throw r7     // Catch:{ d -> 0x022c }
        L_0x0029:
            int r8 = r23 + 1
            int r8 = r6 << r8
            if (r1 == 0) goto L_0x0036
            int r9 = r1.length     // Catch:{ d -> 0x022c }
            int r10 = r8 / 2
            int r10 = r10 + 3
            if (r9 > r10) goto L_0x0225
        L_0x0036:
            if (r8 < 0) goto L_0x0225
            r9 = 512(0x200, float:7.175E-43)
            if (r8 <= r9) goto L_0x003e
            goto L_0x0225
        L_0x003e:
            com.google.a.h.a.a.a r9 = d     // Catch:{ d -> 0x022c }
            com.google.a.h.a.a.c r10 = new com.google.a.h.a.a.c     // Catch:{ d -> 0x022c }
            com.google.a.h.a.a.b r11 = r9.f3238a     // Catch:{ d -> 0x022c }
            r10.<init>(r11, r0)     // Catch:{ d -> 0x022c }
            int[] r11 = new int[r8]     // Catch:{ d -> 0x022c }
            r12 = r8
            r13 = 0
        L_0x004b:
            if (r12 <= 0) goto L_0x0061
            com.google.a.h.a.a.b r14 = r9.f3238a     // Catch:{ d -> 0x022c }
            int[] r14 = r14.f3240b     // Catch:{ d -> 0x022c }
            r14 = r14[r12]     // Catch:{ d -> 0x022c }
            int r14 = r10.b((int) r14)     // Catch:{ d -> 0x022c }
            int r15 = r8 - r12
            r11[r15] = r14     // Catch:{ d -> 0x022c }
            if (r14 == 0) goto L_0x005e
            r13 = 1
        L_0x005e:
            int r12 = r12 + -1
            goto L_0x004b
        L_0x0061:
            if (r13 != 0) goto L_0x0068
            r16 = r5
            r4 = 0
            goto L_0x01eb
        L_0x0068:
            com.google.a.h.a.a.b r10 = r9.f3238a     // Catch:{ d -> 0x022c }
            com.google.a.h.a.a.c r10 = r10.e     // Catch:{ d -> 0x022c }
            if (r1 == 0) goto L_0x00a6
            int r13 = r1.length     // Catch:{ d -> 0x022c }
            r14 = r10
            r10 = 0
        L_0x0071:
            if (r10 >= r13) goto L_0x00a6
            r15 = r1[r10]     // Catch:{ d -> 0x022c }
            com.google.a.h.a.a.b r4 = r9.f3238a     // Catch:{ d -> 0x022c }
            int r12 = r0.length     // Catch:{ d -> 0x022c }
            int r12 = r12 - r6
            int r12 = r12 - r15
            int[] r4 = r4.f3240b     // Catch:{ d -> 0x022c }
            r4 = r4[r12]     // Catch:{ d -> 0x022c }
            com.google.a.h.a.a.c r12 = new com.google.a.h.a.a.c     // Catch:{ d -> 0x022c }
            com.google.a.h.a.a.b r6 = r9.f3238a     // Catch:{ d -> 0x022c }
            r16 = r5
            r2 = 2
            int[] r5 = new int[r2]     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.b r2 = r9.f3238a     // Catch:{ d -> 0x022e }
            r17 = r13
            r13 = 0
            int r2 = r2.c(r13, r4)     // Catch:{ d -> 0x022e }
            r5[r13] = r2     // Catch:{ d -> 0x022e }
            r2 = 1
            r5[r2] = r2     // Catch:{ d -> 0x022e }
            r12.<init>(r6, r5)     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.c r14 = r14.c((com.google.a.h.a.a.c) r12)     // Catch:{ d -> 0x022e }
            int r10 = r10 + 1
            r5 = r16
            r13 = r17
            r2 = r26
            r6 = 1
            goto L_0x0071
        L_0x00a6:
            r16 = r5
            com.google.a.h.a.a.c r2 = new com.google.a.h.a.a.c     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.b r4 = r9.f3238a     // Catch:{ d -> 0x022e }
            r2.<init>(r4, r11)     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.b r4 = r9.f3238a     // Catch:{ d -> 0x022e }
            r5 = 1
            com.google.a.h.a.a.c r4 = r4.a(r8, r5)     // Catch:{ d -> 0x022e }
            int[] r6 = r4.f3243b     // Catch:{ d -> 0x022e }
            int r6 = r6.length     // Catch:{ d -> 0x022e }
            int r6 = r6 - r5
            int[] r10 = r2.f3243b     // Catch:{ d -> 0x022e }
            int r10 = r10.length     // Catch:{ d -> 0x022e }
            int r10 = r10 - r5
            if (r6 >= r10) goto L_0x00c1
            goto L_0x00c6
        L_0x00c1:
            r21 = r4
            r4 = r2
            r2 = r21
        L_0x00c6:
            com.google.a.h.a.a.b r5 = r9.f3238a     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.c r5 = r5.d     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.b r6 = r9.f3238a     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.c r6 = r6.e     // Catch:{ d -> 0x022e }
            r21 = r4
            r4 = r2
            r2 = r21
        L_0x00d3:
            int[] r10 = r2.f3243b     // Catch:{ d -> 0x022e }
            int r10 = r10.length     // Catch:{ d -> 0x022e }
            r11 = 1
            int r10 = r10 - r11
            int r11 = r8 / 2
            if (r10 < r11) goto L_0x018d
            boolean r10 = r2.a()     // Catch:{ d -> 0x022e }
            if (r10 == 0) goto L_0x00e7
            com.google.a.d r2 = com.google.a.d.getChecksumInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x00e7:
            com.google.a.h.a.a.b r10 = r9.f3238a     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.c r10 = r10.d     // Catch:{ d -> 0x022e }
            int[] r11 = r2.f3243b     // Catch:{ d -> 0x022e }
            int r11 = r11.length     // Catch:{ d -> 0x022e }
            r12 = 1
            int r11 = r11 - r12
            int r11 = r2.a((int) r11)     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.b r12 = r9.f3238a     // Catch:{ d -> 0x022e }
            int r11 = r12.a(r11)     // Catch:{ d -> 0x022e }
        L_0x00fa:
            int[] r12 = r4.f3243b     // Catch:{ d -> 0x022e }
            int r12 = r12.length     // Catch:{ d -> 0x022e }
            r13 = 1
            int r12 = r12 - r13
            int[] r14 = r2.f3243b     // Catch:{ d -> 0x022e }
            int r14 = r14.length     // Catch:{ d -> 0x022e }
            int r14 = r14 - r13
            if (r12 < r14) goto L_0x0175
            boolean r12 = r4.a()     // Catch:{ d -> 0x022e }
            if (r12 != 0) goto L_0x0175
            int[] r12 = r4.f3243b     // Catch:{ d -> 0x022e }
            int r12 = r12.length     // Catch:{ d -> 0x022e }
            int r12 = r12 - r13
            int[] r14 = r2.f3243b     // Catch:{ d -> 0x022e }
            int r14 = r14.length     // Catch:{ d -> 0x022e }
            int r14 = r14 - r13
            int r12 = r12 - r14
            com.google.a.h.a.a.b r14 = r9.f3238a     // Catch:{ d -> 0x022e }
            int[] r13 = r4.f3243b     // Catch:{ d -> 0x022e }
            int r13 = r13.length     // Catch:{ d -> 0x022e }
            r15 = 1
            int r13 = r13 - r15
            int r13 = r4.a((int) r13)     // Catch:{ d -> 0x022e }
            int r13 = r14.d(r13, r11)     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.b r14 = r9.f3238a     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.c r14 = r14.a(r12, r13)     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.c r10 = r10.a((com.google.a.h.a.a.c) r14)     // Catch:{ d -> 0x022e }
            if (r12 >= 0) goto L_0x0135
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ d -> 0x022e }
            r2.<init>()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x0135:
            if (r13 != 0) goto L_0x0141
            com.google.a.h.a.a.b r12 = r2.f3242a     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.c r12 = r12.d     // Catch:{ d -> 0x022e }
            r18 = r10
            r19 = r11
            r10 = r12
            goto L_0x016c
        L_0x0141:
            int[] r14 = r2.f3243b     // Catch:{ d -> 0x022e }
            int r14 = r14.length     // Catch:{ d -> 0x022e }
            int r12 = r12 + r14
            int[] r12 = new int[r12]     // Catch:{ d -> 0x022e }
            r18 = r10
            r10 = 0
        L_0x014a:
            if (r10 >= r14) goto L_0x0163
            r19 = r11
            com.google.a.h.a.a.b r11 = r2.f3242a     // Catch:{ d -> 0x022e }
            r20 = r14
            int[] r14 = r2.f3243b     // Catch:{ d -> 0x022e }
            r14 = r14[r10]     // Catch:{ d -> 0x022e }
            int r11 = r11.d(r14, r13)     // Catch:{ d -> 0x022e }
            r12[r10] = r11     // Catch:{ d -> 0x022e }
            int r10 = r10 + 1
            r11 = r19
            r14 = r20
            goto L_0x014a
        L_0x0163:
            r19 = r11
            com.google.a.h.a.a.c r10 = new com.google.a.h.a.a.c     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.b r11 = r2.f3242a     // Catch:{ d -> 0x022e }
            r10.<init>(r11, r12)     // Catch:{ d -> 0x022e }
        L_0x016c:
            com.google.a.h.a.a.c r4 = r4.b((com.google.a.h.a.a.c) r10)     // Catch:{ d -> 0x022e }
            r10 = r18
            r11 = r19
            goto L_0x00fa
        L_0x0175:
            com.google.a.h.a.a.c r10 = r10.c((com.google.a.h.a.a.c) r6)     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.c r5 = r10.b((com.google.a.h.a.a.c) r5)     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.c r5 = r5.b()     // Catch:{ d -> 0x022e }
            r21 = r4
            r4 = r2
            r2 = r21
            r22 = r6
            r6 = r5
            r5 = r22
            goto L_0x00d3
        L_0x018d:
            r4 = 0
            int r5 = r6.a((int) r4)     // Catch:{ d -> 0x022e }
            if (r5 != 0) goto L_0x0199
            com.google.a.d r2 = com.google.a.d.getChecksumInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x0199:
            com.google.a.h.a.a.b r4 = r9.f3238a     // Catch:{ d -> 0x022e }
            int r4 = r4.a(r5)     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.c r5 = r6.c((int) r4)     // Catch:{ d -> 0x022e }
            com.google.a.h.a.a.c r2 = r2.c((int) r4)     // Catch:{ d -> 0x022e }
            r4 = 2
            com.google.a.h.a.a.c[] r4 = new com.google.a.h.a.a.c[r4]     // Catch:{ d -> 0x022e }
            r6 = 0
            r4[r6] = r5     // Catch:{ d -> 0x022e }
            r5 = 1
            r4[r5] = r2     // Catch:{ d -> 0x022e }
            r2 = r4[r6]     // Catch:{ d -> 0x022e }
            r4 = r4[r5]     // Catch:{ d -> 0x022e }
            int[] r5 = r9.a(r2)     // Catch:{ d -> 0x022e }
            int[] r2 = r9.a((com.google.a.h.a.a.c) r4, (com.google.a.h.a.a.c) r2, (int[]) r5)     // Catch:{ d -> 0x022e }
            r4 = 0
        L_0x01bd:
            int r6 = r5.length     // Catch:{ d -> 0x022e }
            if (r4 >= r6) goto L_0x01ea
            int r6 = r0.length     // Catch:{ d -> 0x022e }
            r10 = 1
            int r6 = r6 - r10
            com.google.a.h.a.a.b r10 = r9.f3238a     // Catch:{ d -> 0x022e }
            r11 = r5[r4]     // Catch:{ d -> 0x022e }
            if (r11 != 0) goto L_0x01cf
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ d -> 0x022e }
            r2.<init>()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x01cf:
            int[] r10 = r10.f3241c     // Catch:{ d -> 0x022e }
            r10 = r10[r11]     // Catch:{ d -> 0x022e }
            int r6 = r6 - r10
            if (r6 >= 0) goto L_0x01db
            com.google.a.d r2 = com.google.a.d.getChecksumInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x01db:
            com.google.a.h.a.a.b r10 = r9.f3238a     // Catch:{ d -> 0x022e }
            r11 = r0[r6]     // Catch:{ d -> 0x022e }
            r12 = r2[r4]     // Catch:{ d -> 0x022e }
            int r10 = r10.c(r11, r12)     // Catch:{ d -> 0x022e }
            r0[r6] = r10     // Catch:{ d -> 0x022e }
            int r4 = r4 + 1
            goto L_0x01bd
        L_0x01ea:
            int r4 = r5.length     // Catch:{ d -> 0x022e }
        L_0x01eb:
            int r2 = r0.length     // Catch:{ d -> 0x022e }
            r5 = 4
            if (r2 >= r5) goto L_0x01f4
            com.google.a.h r2 = com.google.a.h.getFormatInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x01f4:
            r2 = 0
            r5 = r0[r2]     // Catch:{ d -> 0x022e }
            int r2 = r0.length     // Catch:{ d -> 0x022e }
            if (r5 <= r2) goto L_0x01ff
            com.google.a.h r2 = com.google.a.h.getFormatInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x01ff:
            if (r5 != 0) goto L_0x020f
            int r2 = r0.length     // Catch:{ d -> 0x022e }
            if (r8 >= r2) goto L_0x020a
            int r2 = r0.length     // Catch:{ d -> 0x022e }
            int r2 = r2 - r8
            r5 = 0
            r0[r5] = r2     // Catch:{ d -> 0x022e }
            goto L_0x020f
        L_0x020a:
            com.google.a.h r2 = com.google.a.h.getFormatInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x020f:
            java.lang.String r2 = java.lang.String.valueOf(r23)     // Catch:{ d -> 0x022e }
            com.google.a.c.e r2 = com.google.a.h.a.e.a((int[]) r0, (java.lang.String) r2)     // Catch:{ d -> 0x022e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ d -> 0x022e }
            r2.f = r4     // Catch:{ d -> 0x022e }
            int r4 = r1.length     // Catch:{ d -> 0x022e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ d -> 0x022e }
            r2.g = r4     // Catch:{ d -> 0x022e }
            return r2
        L_0x0225:
            r16 = r5
            com.google.a.d r2 = com.google.a.d.getChecksumInstance()     // Catch:{ d -> 0x022e }
            throw r2     // Catch:{ d -> 0x022e }
        L_0x022c:
            r16 = r5
        L_0x022e:
            int r2 = r3.length
            if (r2 != 0) goto L_0x0236
            com.google.a.d r0 = com.google.a.d.getChecksumInstance()
            throw r0
        L_0x0236:
            r2 = 0
        L_0x0237:
            int r4 = r3.length
            if (r2 >= r4) goto L_0x0258
            r4 = r3[r2]
            r5 = r27[r2]
            int r5 = r5.length
            r6 = 1
            int r5 = r5 - r6
            if (r4 >= r5) goto L_0x0249
            r4 = r3[r2]
            int r4 = r4 + r6
            r3[r2] = r4
            goto L_0x0258
        L_0x0249:
            r4 = 0
            r3[r2] = r4
            int r5 = r3.length
            int r5 = r5 - r6
            if (r2 != r5) goto L_0x0255
            com.google.a.d r0 = com.google.a.d.getChecksumInstance()
            throw r0
        L_0x0255:
            int r2 = r2 + 1
            goto L_0x0237
        L_0x0258:
            r4 = r16
            r2 = r26
            goto L_0x000b
        L_0x025e:
            com.google.a.d r0 = com.google.a.d.getChecksumInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.a.j.a(int, int[], int[], int[], int[][]):com.google.a.c.e");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0064, code lost:
        if (r3.e != r4.e) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0456, code lost:
        if (r3[0] != r5) goto L_0x0458;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0129, code lost:
        if (r5 != false) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0131, code lost:
        r0 = r1.f3248a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013e, code lost:
        if (r5 != false) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0151, code lost:
        if (r5 != false) goto L_0x012b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x00a4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.a.c.e a(com.google.a.c.b r26, com.google.a.t r27, com.google.a.t r28, com.google.a.t r29, com.google.a.t r30, int r31, int r32) throws com.google.a.m, com.google.a.h, com.google.a.d {
        /*
            com.google.a.h.a.c r6 = new com.google.a.h.a.c
            r0 = r6
            r1 = r26
            r2 = r27
            r3 = r28
            r4 = r29
            r5 = r30
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = 0
            r9 = r6
            r2 = 0
            r3 = 0
            r4 = 0
            r10 = 0
        L_0x0016:
            r11 = 2
            if (r2 >= r11) goto L_0x00c9
            if (r27 == 0) goto L_0x0029
            r6 = 1
            r3 = r26
            r4 = r9
            r5 = r27
            r7 = r31
            r8 = r32
            com.google.a.h.a.h r3 = a((com.google.a.c.b) r3, (com.google.a.h.a.c) r4, (com.google.a.t) r5, (boolean) r6, (int) r7, (int) r8)
        L_0x0029:
            r14 = r3
            if (r29 == 0) goto L_0x003b
            r6 = 0
            r3 = r26
            r4 = r9
            r5 = r29
            r7 = r31
            r8 = r32
            com.google.a.h.a.h r3 = a((com.google.a.c.b) r3, (com.google.a.h.a.c) r4, (com.google.a.t) r5, (boolean) r6, (int) r7, (int) r8)
            r10 = r3
        L_0x003b:
            if (r14 != 0) goto L_0x0042
            if (r10 != 0) goto L_0x0042
        L_0x003f:
            r4 = 0
            goto L_0x00a2
        L_0x0042:
            if (r14 == 0) goto L_0x0067
            com.google.a.h.a.a r3 = r14.a()
            if (r3 != 0) goto L_0x004b
            goto L_0x0067
        L_0x004b:
            if (r10 == 0) goto L_0x006f
            com.google.a.h.a.a r4 = r10.a()
            if (r4 != 0) goto L_0x0054
            goto L_0x006f
        L_0x0054:
            int r5 = r3.f3235a
            int r6 = r4.f3235a
            if (r5 == r6) goto L_0x006f
            int r5 = r3.f3236b
            int r6 = r4.f3236b
            if (r5 == r6) goto L_0x006f
            int r5 = r3.e
            int r4 = r4.e
            if (r5 == r4) goto L_0x006f
            goto L_0x0069
        L_0x0067:
            if (r10 != 0) goto L_0x006b
        L_0x0069:
            r3 = 0
            goto L_0x006f
        L_0x006b:
            com.google.a.h.a.a r3 = r10.a()
        L_0x006f:
            if (r3 != 0) goto L_0x0072
            goto L_0x003f
        L_0x0072:
            com.google.a.h.a.c r4 = a((com.google.a.h.a.h) r14)
            com.google.a.h.a.c r5 = a((com.google.a.h.a.h) r10)
            if (r4 != 0) goto L_0x007e
            r4 = r5
            goto L_0x009c
        L_0x007e:
            if (r5 != 0) goto L_0x0081
            goto L_0x009c
        L_0x0081:
            com.google.a.h.a.c r6 = new com.google.a.h.a.c
            com.google.a.c.b r7 = r4.f3245a
            com.google.a.t r8 = r4.f3246b
            com.google.a.t r4 = r4.f3247c
            com.google.a.t r15 = r5.d
            com.google.a.t r5 = r5.e
            r19 = r15
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r4
            r20 = r5
            r15.<init>(r16, r17, r18, r19, r20)
            r4 = r6
        L_0x009c:
            com.google.a.h.a.f r5 = new com.google.a.h.a.f
            r5.<init>(r3, r4)
            r4 = r5
        L_0x00a2:
            if (r4 != 0) goto L_0x00a9
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x00a9:
            if (r2 != 0) goto L_0x00c6
            com.google.a.h.a.c r3 = r4.f3257c
            if (r3 == 0) goto L_0x00c6
            com.google.a.h.a.c r3 = r4.f3257c
            int r3 = r3.h
            int r5 = r9.h
            if (r3 < r5) goto L_0x00bf
            com.google.a.h.a.c r3 = r4.f3257c
            int r3 = r3.i
            int r5 = r9.i
            if (r3 <= r5) goto L_0x00c6
        L_0x00bf:
            com.google.a.h.a.c r9 = r4.f3257c
            int r2 = r2 + 1
            r3 = r14
            goto L_0x0016
        L_0x00c6:
            r4.f3257c = r9
            goto L_0x00ca
        L_0x00c9:
            r14 = r3
        L_0x00ca:
            int r2 = r4.d
            r3 = 1
            int r2 = r2 + r3
            com.google.a.h.a.g[] r5 = r4.f3256b
            r5[r1] = r14
            com.google.a.h.a.g[] r5 = r4.f3256b
            r5[r2] = r10
            if (r14 == 0) goto L_0x00da
            r5 = 1
            goto L_0x00db
        L_0x00da:
            r5 = 0
        L_0x00db:
            r7 = r31
            r8 = r32
            r6 = 1
        L_0x00e0:
            if (r6 > r2) goto L_0x01f5
            if (r5 == 0) goto L_0x00e6
            r10 = r6
            goto L_0x00e8
        L_0x00e6:
            int r10 = r2 - r6
        L_0x00e8:
            com.google.a.h.a.g[] r12 = r4.f3256b
            r12 = r12[r10]
            if (r12 != 0) goto L_0x01ea
            if (r10 == 0) goto L_0x00f9
            if (r10 != r2) goto L_0x00f3
            goto L_0x00f9
        L_0x00f3:
            com.google.a.h.a.g r12 = new com.google.a.h.a.g
            r12.<init>(r9)
            goto L_0x0103
        L_0x00f9:
            com.google.a.h.a.h r12 = new com.google.a.h.a.h
            if (r10 != 0) goto L_0x00ff
            r13 = 1
            goto L_0x0100
        L_0x00ff:
            r13 = 0
        L_0x0100:
            r12.<init>(r9, r13)
        L_0x0103:
            com.google.a.h.a.g[] r13 = r4.f3256b
            r13[r10] = r12
            int r13 = r9.h
            r15 = r8
            r8 = r7
            r7 = -1
        L_0x010c:
            int r0 = r9.i
            if (r13 > r0) goto L_0x01e4
            if (r5 == 0) goto L_0x0114
            r0 = 1
            goto L_0x0115
        L_0x0114:
            r0 = -1
        L_0x0115:
            int r3 = r10 - r0
            boolean r16 = a((com.google.a.h.a.f) r4, (int) r3)
            if (r16 == 0) goto L_0x0126
            com.google.a.h.a.g[] r1 = r4.f3256b
            r1 = r1[r3]
            com.google.a.h.a.d r1 = r1.c(r13)
            goto L_0x0127
        L_0x0126:
            r1 = 0
        L_0x0127:
            if (r1 == 0) goto L_0x0134
            if (r5 == 0) goto L_0x0131
        L_0x012b:
            int r0 = r1.f3249b
        L_0x012d:
            r25 = r2
            goto L_0x019b
        L_0x0131:
            int r0 = r1.f3248a
            goto L_0x012d
        L_0x0134:
            com.google.a.h.a.g[] r1 = r4.f3256b
            r1 = r1[r10]
            com.google.a.h.a.d r1 = r1.a(r13)
            if (r1 == 0) goto L_0x0141
            if (r5 == 0) goto L_0x012b
            goto L_0x0131
        L_0x0141:
            boolean r16 = a((com.google.a.h.a.f) r4, (int) r3)
            if (r16 == 0) goto L_0x014f
            com.google.a.h.a.g[] r1 = r4.f3256b
            r1 = r1[r3]
            com.google.a.h.a.d r1 = r1.a(r13)
        L_0x014f:
            if (r1 == 0) goto L_0x0154
            if (r5 == 0) goto L_0x0131
            goto L_0x012b
        L_0x0154:
            r1 = r10
            r3 = 0
        L_0x0156:
            int r1 = r1 - r0
            boolean r16 = a((com.google.a.h.a.f) r4, (int) r1)
            if (r16 == 0) goto L_0x018e
            com.google.a.h.a.g[] r11 = r4.f3256b
            r11 = r11[r1]
            com.google.a.h.a.d[] r11 = r11.f3260b
            int r14 = r11.length
            r24 = r1
            r1 = 0
        L_0x0167:
            if (r1 >= r14) goto L_0x0186
            r25 = r2
            r2 = r11[r1]
            if (r2 == 0) goto L_0x0181
            if (r5 == 0) goto L_0x0174
            int r1 = r2.f3249b
            goto L_0x0176
        L_0x0174:
            int r1 = r2.f3248a
        L_0x0176:
            int r0 = r0 * r3
            int r3 = r2.f3249b
            int r2 = r2.f3248a
            int r3 = r3 - r2
            int r0 = r0 * r3
            int r0 = r0 + r1
            goto L_0x019b
        L_0x0181:
            int r1 = r1 + 1
            r2 = r25
            goto L_0x0167
        L_0x0186:
            r25 = r2
            int r3 = r3 + 1
            r1 = r24
            r11 = 2
            goto L_0x0156
        L_0x018e:
            r25 = r2
            if (r5 == 0) goto L_0x0197
            com.google.a.h.a.c r0 = r4.f3257c
            int r0 = r0.f
            goto L_0x019b
        L_0x0197:
            com.google.a.h.a.c r0 = r4.f3257c
            int r0 = r0.g
        L_0x019b:
            if (r0 < 0) goto L_0x01a5
            int r1 = r9.g
            if (r0 <= r1) goto L_0x01a2
            goto L_0x01a5
        L_0x01a2:
            r1 = r0
            r0 = -1
            goto L_0x01a9
        L_0x01a5:
            r0 = -1
            if (r7 == r0) goto L_0x01d9
            r1 = r7
        L_0x01a9:
            int r2 = r9.f
            int r3 = r9.g
            r11 = r15
            r15 = r26
            r16 = r2
            r17 = r3
            r18 = r5
            r19 = r1
            r20 = r13
            r21 = r8
            r22 = r11
            com.google.a.h.a.d r2 = a(r15, r16, r17, r18, r19, r20, r21, r22)
            if (r2 == 0) goto L_0x01da
            r12.a(r13, r2)
            int r3 = r2.c()
            int r8 = java.lang.Math.min(r8, r3)
            int r2 = r2.c()
            int r15 = java.lang.Math.max(r11, r2)
            r7 = r1
            goto L_0x01db
        L_0x01d9:
            r11 = r15
        L_0x01da:
            r15 = r11
        L_0x01db:
            int r13 = r13 + 1
            r2 = r25
            r1 = 0
            r3 = 1
            r11 = 2
            goto L_0x010c
        L_0x01e4:
            r25 = r2
            r11 = r15
            r7 = r8
            r8 = r11
            goto L_0x01ec
        L_0x01ea:
            r25 = r2
        L_0x01ec:
            int r6 = r6 + 1
            r2 = r25
            r1 = 0
            r3 = 1
            r11 = 2
            goto L_0x00e0
        L_0x01f5:
            com.google.a.h.a.a r0 = r4.f3255a
            int r0 = r0.e
            int r1 = r4.d
            r2 = 2
            int r1 = r1 + r2
            int[] r0 = new int[]{r0, r1}
            java.lang.Class<com.google.a.h.a.b> r1 = com.google.a.h.a.b.class
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r1, r0)
            com.google.a.h.a.b[][] r0 = (com.google.a.h.a.b[][]) r0
            r1 = 0
        L_0x020a:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x0222
            r2 = 0
        L_0x020e:
            r3 = r0[r1]
            int r3 = r3.length
            if (r2 >= r3) goto L_0x021f
            r3 = r0[r1]
            com.google.a.h.a.b r5 = new com.google.a.h.a.b
            r5.<init>()
            r3[r2] = r5
            int r2 = r2 + 1
            goto L_0x020e
        L_0x021f:
            int r1 = r1 + 1
            goto L_0x020a
        L_0x0222:
            com.google.a.h.a.g[] r1 = r4.f3256b
            r2 = 0
            r1 = r1[r2]
            r4.a((com.google.a.h.a.g) r1)
            com.google.a.h.a.g[] r1 = r4.f3256b
            int r3 = r4.d
            r5 = 1
            int r3 = r3 + r5
            r1 = r1[r3]
            r4.a((com.google.a.h.a.g) r1)
            r1 = 928(0x3a0, float:1.3E-42)
            r3 = 928(0x3a0, float:1.3E-42)
        L_0x0239:
            com.google.a.h.a.g[] r6 = r4.f3256b
            r6 = r6[r2]
            if (r6 == 0) goto L_0x029b
            com.google.a.h.a.g[] r6 = r4.f3256b
            int r7 = r4.d
            int r7 = r7 + r5
            r6 = r6[r7]
            if (r6 != 0) goto L_0x0249
            goto L_0x029b
        L_0x0249:
            com.google.a.h.a.g[] r6 = r4.f3256b
            r6 = r6[r2]
            com.google.a.h.a.d[] r2 = r6.f3260b
            com.google.a.h.a.g[] r6 = r4.f3256b
            int r7 = r4.d
            int r7 = r7 + r5
            r5 = r6[r7]
            com.google.a.h.a.d[] r5 = r5.f3260b
            r6 = 0
        L_0x0259:
            int r7 = r2.length
            if (r6 >= r7) goto L_0x029b
            r7 = r2[r6]
            if (r7 == 0) goto L_0x0297
            r7 = r5[r6]
            if (r7 == 0) goto L_0x0297
            r7 = r2[r6]
            int r7 = r7.e
            r8 = r5[r6]
            int r8 = r8.e
            if (r7 != r8) goto L_0x0297
            r7 = 1
        L_0x026f:
            int r8 = r4.d
            if (r7 > r8) goto L_0x0297
            com.google.a.h.a.g[] r8 = r4.f3256b
            r8 = r8[r7]
            com.google.a.h.a.d[] r8 = r8.f3260b
            r8 = r8[r6]
            if (r8 == 0) goto L_0x0293
            r9 = r2[r6]
            int r9 = r9.e
            r8.e = r9
            boolean r8 = r8.a()
            if (r8 != 0) goto L_0x0293
            com.google.a.h.a.g[] r8 = r4.f3256b
            r8 = r8[r7]
            com.google.a.h.a.d[] r8 = r8.f3260b
            r9 = 0
            r8[r6] = r9
            goto L_0x0294
        L_0x0293:
            r9 = 0
        L_0x0294:
            int r7 = r7 + 1
            goto L_0x026f
        L_0x0297:
            r9 = 0
            int r6 = r6 + 1
            goto L_0x0259
        L_0x029b:
            r9 = 0
            com.google.a.h.a.g[] r2 = r4.f3256b
            r23 = 0
            r2 = r2[r23]
            if (r2 != 0) goto L_0x02a6
            r6 = 0
            goto L_0x02e2
        L_0x02a6:
            com.google.a.h.a.g[] r2 = r4.f3256b
            r2 = r2[r23]
            com.google.a.h.a.d[] r2 = r2.f3260b
            r5 = 0
            r6 = 0
        L_0x02ae:
            int r7 = r2.length
            if (r5 >= r7) goto L_0x02e2
            r7 = r2[r5]
            if (r7 == 0) goto L_0x02df
            r7 = r2[r5]
            int r7 = r7.e
            r10 = r6
            r6 = 1
            r8 = 0
        L_0x02bc:
            int r11 = r4.d
            r12 = 1
            int r11 = r11 + r12
            if (r6 >= r11) goto L_0x02de
            r11 = 2
            if (r8 >= r11) goto L_0x02de
            com.google.a.h.a.g[] r11 = r4.f3256b
            r11 = r11[r6]
            com.google.a.h.a.d[] r11 = r11.f3260b
            r11 = r11[r5]
            if (r11 == 0) goto L_0x02db
            int r8 = com.google.a.h.a.f.a((int) r7, (int) r8, (com.google.a.h.a.d) r11)
            boolean r11 = r11.a()
            if (r11 != 0) goto L_0x02db
            int r10 = r10 + 1
        L_0x02db:
            int r6 = r6 + 1
            goto L_0x02bc
        L_0x02de:
            r6 = r10
        L_0x02df:
            int r5 = r5 + 1
            goto L_0x02ae
        L_0x02e2:
            com.google.a.h.a.g[] r2 = r4.f3256b
            int r5 = r4.d
            r7 = 1
            int r5 = r5 + r7
            r2 = r2[r5]
            if (r2 != 0) goto L_0x02ee
            r8 = 0
            goto L_0x032a
        L_0x02ee:
            com.google.a.h.a.g[] r2 = r4.f3256b
            int r5 = r4.d
            int r5 = r5 + r7
            r2 = r2[r5]
            com.google.a.h.a.d[] r2 = r2.f3260b
            r5 = 0
            r8 = 0
        L_0x02f9:
            int r10 = r2.length
            if (r5 >= r10) goto L_0x032a
            r10 = r2[r5]
            if (r10 == 0) goto L_0x0326
            r10 = r2[r5]
            int r10 = r10.e
            int r11 = r4.d
            int r11 = r11 + r7
            r7 = 0
        L_0x0308:
            if (r11 <= 0) goto L_0x0326
            r12 = 2
            if (r7 >= r12) goto L_0x0326
            com.google.a.h.a.g[] r12 = r4.f3256b
            r12 = r12[r11]
            com.google.a.h.a.d[] r12 = r12.f3260b
            r12 = r12[r5]
            if (r12 == 0) goto L_0x0323
            int r7 = com.google.a.h.a.f.a((int) r10, (int) r7, (com.google.a.h.a.d) r12)
            boolean r12 = r12.a()
            if (r12 != 0) goto L_0x0323
            int r8 = r8 + 1
        L_0x0323:
            int r11 = r11 + -1
            goto L_0x0308
        L_0x0326:
            int r5 = r5 + 1
            r7 = 1
            goto L_0x02f9
        L_0x032a:
            int r2 = r6 + r8
            if (r2 != 0) goto L_0x0331
            r2 = 0
            goto L_0x03f6
        L_0x0331:
            r5 = 1
        L_0x0332:
            int r6 = r4.d
            r7 = 1
            int r6 = r6 + r7
            if (r5 >= r6) goto L_0x03f6
            com.google.a.h.a.g[] r6 = r4.f3256b
            r6 = r6[r5]
            com.google.a.h.a.d[] r6 = r6.f3260b
            r7 = 0
        L_0x033f:
            int r8 = r6.length
            if (r7 >= r8) goto L_0x03f2
            r8 = r6[r7]
            if (r8 == 0) goto L_0x03ee
            r8 = r6[r7]
            boolean r8 = r8.a()
            if (r8 != 0) goto L_0x03ee
            r8 = r6[r7]
            com.google.a.h.a.g[] r10 = r4.f3256b
            int r11 = r5 + -1
            r10 = r10[r11]
            com.google.a.h.a.d[] r10 = r10.f3260b
            com.google.a.h.a.g[] r11 = r4.f3256b
            int r12 = r5 + 1
            r11 = r11[r12]
            if (r11 == 0) goto L_0x0367
            com.google.a.h.a.g[] r11 = r4.f3256b
            r11 = r11[r12]
            com.google.a.h.a.d[] r11 = r11.f3260b
            goto L_0x0368
        L_0x0367:
            r11 = r10
        L_0x0368:
            r12 = 14
            com.google.a.h.a.d[] r13 = new com.google.a.h.a.d[r12]
            r14 = r10[r7]
            r15 = 2
            r13[r15] = r14
            r14 = 3
            r15 = r11[r7]
            r13[r14] = r15
            if (r7 <= 0) goto L_0x038a
            int r14 = r7 + -1
            r15 = r6[r14]
            r16 = 0
            r13[r16] = r15
            r15 = 4
            r16 = r10[r14]
            r13[r15] = r16
            r15 = 5
            r14 = r11[r14]
            r13[r15] = r14
        L_0x038a:
            r14 = 1
            if (r7 <= r14) goto L_0x03a1
            r14 = 8
            int r15 = r7 + -2
            r16 = r6[r15]
            r13[r14] = r16
            r14 = 10
            r16 = r10[r15]
            r13[r14] = r16
            r14 = 11
            r15 = r11[r15]
            r13[r14] = r15
        L_0x03a1:
            int r14 = r6.length
            r15 = 1
            int r14 = r14 - r15
            if (r7 >= r14) goto L_0x03b6
            int r14 = r7 + 1
            r16 = r6[r14]
            r13[r15] = r16
            r15 = 6
            r16 = r10[r14]
            r13[r15] = r16
            r15 = 7
            r14 = r11[r14]
            r13[r15] = r14
        L_0x03b6:
            int r14 = r6.length
            r15 = 2
            int r14 = r14 - r15
            if (r7 >= r14) goto L_0x03cf
            r14 = 9
            int r15 = r7 + 2
            r16 = r6[r15]
            r13[r14] = r16
            r14 = 12
            r10 = r10[r15]
            r13[r14] = r10
            r10 = 13
            r11 = r11[r15]
            r13[r10] = r11
        L_0x03cf:
            r10 = 0
        L_0x03d0:
            if (r10 >= r12) goto L_0x03ee
            r11 = r13[r10]
            if (r11 == 0) goto L_0x03e8
            boolean r14 = r11.a()
            if (r14 == 0) goto L_0x03e8
            int r14 = r11.f3250c
            int r15 = r8.f3250c
            if (r14 != r15) goto L_0x03e8
            int r11 = r11.e
            r8.e = r11
            r11 = 1
            goto L_0x03e9
        L_0x03e8:
            r11 = 0
        L_0x03e9:
            if (r11 != 0) goto L_0x03ee
            int r10 = r10 + 1
            goto L_0x03d0
        L_0x03ee:
            int r7 = r7 + 1
            goto L_0x033f
        L_0x03f2:
            int r5 = r5 + 1
            goto L_0x0332
        L_0x03f6:
            if (r2 <= 0) goto L_0x0400
            if (r2 < r3) goto L_0x03fb
            goto L_0x0400
        L_0x03fb:
            r3 = r2
            r2 = 0
            r5 = 1
            goto L_0x0239
        L_0x0400:
            com.google.a.h.a.g[] r2 = r4.f3256b
            int r3 = r2.length
            r5 = 0
            r6 = 0
        L_0x0405:
            if (r5 >= r3) goto L_0x042d
            r7 = r2[r5]
            if (r7 == 0) goto L_0x0428
            com.google.a.h.a.d[] r7 = r7.f3260b
            int r8 = r7.length
            r9 = 0
        L_0x040f:
            if (r9 >= r8) goto L_0x0428
            r10 = r7[r9]
            if (r10 == 0) goto L_0x0425
            int r11 = r10.e
            if (r11 < 0) goto L_0x0425
            int r12 = r0.length
            if (r11 >= r12) goto L_0x0425
            r11 = r0[r11]
            r11 = r11[r6]
            int r10 = r10.d
            r11.a(r10)
        L_0x0425:
            int r9 = r9 + 1
            goto L_0x040f
        L_0x0428:
            int r6 = r6 + 1
            int r5 = r5 + 1
            goto L_0x0405
        L_0x042d:
            r5 = 0
            r2 = r0[r5]
            r3 = 1
            r2 = r2[r3]
            int[] r3 = r2.a()
            int r5 = r4.d
            com.google.a.h.a.a r6 = r4.f3255a
            int r6 = r6.e
            int r5 = r5 * r6
            com.google.a.h.a.a r6 = r4.f3255a
            int r6 = r6.f3236b
            r7 = 2
            int r6 = r7 << r6
            int r5 = r5 - r6
            int r6 = r3.length
            if (r6 != 0) goto L_0x0453
            if (r5 <= 0) goto L_0x044e
            if (r5 <= r1) goto L_0x0458
        L_0x044e:
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x0453:
            r1 = 0
            r3 = r3[r1]
            if (r3 == r5) goto L_0x045b
        L_0x0458:
            r2.a(r5)
        L_0x045b:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.google.a.h.a.a r2 = r4.f3255a
            int r2 = r2.e
            int r3 = r4.d
            int r2 = r2 * r3
            int[] r2 = new int[r2]
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
        L_0x0475:
            com.google.a.h.a.a r7 = r4.f3255a
            int r7 = r7.e
            if (r6 >= r7) goto L_0x04b8
            r7 = 0
        L_0x047c:
            int r8 = r4.d
            if (r7 >= r8) goto L_0x04b3
            r8 = r0[r6]
            int r9 = r7 + 1
            r8 = r8[r9]
            int[] r8 = r8.a()
            int r10 = r4.d
            int r10 = r10 * r6
            int r10 = r10 + r7
            int r7 = r8.length
            if (r7 != 0) goto L_0x049c
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            r1.add(r7)
            r7 = 0
            r11 = 1
            goto L_0x04b1
        L_0x049c:
            int r7 = r8.length
            r11 = 1
            if (r7 != r11) goto L_0x04a6
            r7 = 0
            r8 = r8[r7]
            r2[r10] = r8
            goto L_0x04b1
        L_0x04a6:
            r7 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r5.add(r10)
            r3.add(r8)
        L_0x04b1:
            r7 = r9
            goto L_0x047c
        L_0x04b3:
            r7 = 0
            r11 = 1
            int r6 = r6 + 1
            goto L_0x0475
        L_0x04b8:
            r7 = 0
            int r0 = r3.size()
            int[][] r0 = new int[r0][]
        L_0x04bf:
            int r6 = r0.length
            if (r7 >= r6) goto L_0x04cd
            java.lang.Object r6 = r3.get(r7)
            int[] r6 = (int[]) r6
            r0[r7] = r6
            int r7 = r7 + 1
            goto L_0x04bf
        L_0x04cd:
            com.google.a.h.a.a r3 = r4.f3255a
            int r3 = r3.f3236b
            int[] r1 = com.google.a.h.a.a((java.util.Collection<java.lang.Integer>) r1)
            int[] r4 = com.google.a.h.a.a((java.util.Collection<java.lang.Integer>) r5)
            com.google.a.c.e r0 = a(r3, r2, r1, r4, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.a.j.a(com.google.a.c.b, com.google.a.t, com.google.a.t, com.google.a.t, com.google.a.t, int, int):com.google.a.c.e");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0253, code lost:
        if (r5[0] != r7) goto L_0x0255;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.a.c.e a(com.google.a.h.a.f r20) throws com.google.a.h, com.google.a.d, com.google.a.m {
        /*
            r0 = r20
            com.google.a.h.a.a r1 = r0.f3255a
            int r1 = r1.e
            int r2 = r0.d
            r3 = 2
            int r2 = r2 + r3
            int[] r1 = new int[]{r1, r2}
            java.lang.Class<com.google.a.h.a.b> r2 = com.google.a.h.a.b.class
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r2, r1)
            com.google.a.h.a.b[][] r1 = (com.google.a.h.a.b[][]) r1
            r2 = 0
            r4 = 0
        L_0x0018:
            int r5 = r1.length
            if (r4 >= r5) goto L_0x0030
            r5 = 0
        L_0x001c:
            r6 = r1[r4]
            int r6 = r6.length
            if (r5 >= r6) goto L_0x002d
            r6 = r1[r4]
            com.google.a.h.a.b r7 = new com.google.a.h.a.b
            r7.<init>()
            r6[r5] = r7
            int r5 = r5 + 1
            goto L_0x001c
        L_0x002d:
            int r4 = r4 + 1
            goto L_0x0018
        L_0x0030:
            com.google.a.h.a.g[] r4 = r0.f3256b
            r4 = r4[r2]
            r0.a((com.google.a.h.a.g) r4)
            com.google.a.h.a.g[] r4 = r0.f3256b
            int r5 = r0.d
            r6 = 1
            int r5 = r5 + r6
            r4 = r4[r5]
            r0.a((com.google.a.h.a.g) r4)
            r5 = 928(0x3a0, float:1.3E-42)
        L_0x0044:
            com.google.a.h.a.g[] r7 = r0.f3256b
            r7 = r7[r2]
            if (r7 == 0) goto L_0x00a3
            com.google.a.h.a.g[] r7 = r0.f3256b
            int r8 = r0.d
            int r8 = r8 + r6
            r7 = r7[r8]
            if (r7 != 0) goto L_0x0054
            goto L_0x00a3
        L_0x0054:
            com.google.a.h.a.g[] r7 = r0.f3256b
            r7 = r7[r2]
            com.google.a.h.a.d[] r7 = r7.f3260b
            com.google.a.h.a.g[] r8 = r0.f3256b
            int r9 = r0.d
            int r9 = r9 + r6
            r8 = r8[r9]
            com.google.a.h.a.d[] r8 = r8.f3260b
            r9 = 0
        L_0x0064:
            int r10 = r7.length
            if (r9 >= r10) goto L_0x00a3
            r10 = r7[r9]
            if (r10 == 0) goto L_0x00a0
            r10 = r8[r9]
            if (r10 == 0) goto L_0x00a0
            r10 = r7[r9]
            int r10 = r10.e
            r11 = r8[r9]
            int r11 = r11.e
            if (r10 != r11) goto L_0x00a0
            r10 = 1
        L_0x007a:
            int r11 = r0.d
            if (r10 > r11) goto L_0x00a0
            com.google.a.h.a.g[] r11 = r0.f3256b
            r11 = r11[r10]
            com.google.a.h.a.d[] r11 = r11.f3260b
            r11 = r11[r9]
            if (r11 == 0) goto L_0x009d
            r12 = r7[r9]
            int r12 = r12.e
            r11.e = r12
            boolean r11 = r11.a()
            if (r11 != 0) goto L_0x009d
            com.google.a.h.a.g[] r11 = r0.f3256b
            r11 = r11[r10]
            com.google.a.h.a.d[] r11 = r11.f3260b
            r12 = 0
            r11[r9] = r12
        L_0x009d:
            int r10 = r10 + 1
            goto L_0x007a
        L_0x00a0:
            int r9 = r9 + 1
            goto L_0x0064
        L_0x00a3:
            com.google.a.h.a.g[] r7 = r0.f3256b
            r7 = r7[r2]
            if (r7 != 0) goto L_0x00ab
            r9 = 0
            goto L_0x00e5
        L_0x00ab:
            com.google.a.h.a.g[] r7 = r0.f3256b
            r7 = r7[r2]
            com.google.a.h.a.d[] r7 = r7.f3260b
            r8 = 0
            r9 = 0
        L_0x00b3:
            int r10 = r7.length
            if (r8 >= r10) goto L_0x00e5
            r10 = r7[r8]
            if (r10 == 0) goto L_0x00e2
            r10 = r7[r8]
            int r10 = r10.e
            r12 = r9
            r9 = 1
            r11 = 0
        L_0x00c1:
            int r13 = r0.d
            int r13 = r13 + r6
            if (r9 >= r13) goto L_0x00e1
            if (r11 >= r3) goto L_0x00e1
            com.google.a.h.a.g[] r13 = r0.f3256b
            r13 = r13[r9]
            com.google.a.h.a.d[] r13 = r13.f3260b
            r13 = r13[r8]
            if (r13 == 0) goto L_0x00de
            int r11 = com.google.a.h.a.f.a((int) r10, (int) r11, (com.google.a.h.a.d) r13)
            boolean r13 = r13.a()
            if (r13 != 0) goto L_0x00de
            int r12 = r12 + 1
        L_0x00de:
            int r9 = r9 + 1
            goto L_0x00c1
        L_0x00e1:
            r9 = r12
        L_0x00e2:
            int r8 = r8 + 1
            goto L_0x00b3
        L_0x00e5:
            com.google.a.h.a.g[] r7 = r0.f3256b
            int r8 = r0.d
            int r8 = r8 + r6
            r7 = r7[r8]
            if (r7 != 0) goto L_0x00f0
            r10 = 0
            goto L_0x012c
        L_0x00f0:
            com.google.a.h.a.g[] r7 = r0.f3256b
            int r8 = r0.d
            int r8 = r8 + r6
            r7 = r7[r8]
            com.google.a.h.a.d[] r7 = r7.f3260b
            r8 = 0
            r10 = 0
        L_0x00fb:
            int r11 = r7.length
            if (r8 >= r11) goto L_0x012c
            r11 = r7[r8]
            if (r11 == 0) goto L_0x0129
            r11 = r7[r8]
            int r11 = r11.e
            int r12 = r0.d
            int r12 = r12 + r6
            r13 = r10
            r10 = 0
        L_0x010b:
            if (r12 <= 0) goto L_0x0128
            if (r10 >= r3) goto L_0x0128
            com.google.a.h.a.g[] r14 = r0.f3256b
            r14 = r14[r12]
            com.google.a.h.a.d[] r14 = r14.f3260b
            r14 = r14[r8]
            if (r14 == 0) goto L_0x0125
            int r10 = com.google.a.h.a.f.a((int) r11, (int) r10, (com.google.a.h.a.d) r14)
            boolean r14 = r14.a()
            if (r14 != 0) goto L_0x0125
            int r13 = r13 + 1
        L_0x0125:
            int r12 = r12 + -1
            goto L_0x010b
        L_0x0128:
            r10 = r13
        L_0x0129:
            int r8 = r8 + 1
            goto L_0x00fb
        L_0x012c:
            int r7 = r9 + r10
            if (r7 != 0) goto L_0x0133
            r7 = 0
            goto L_0x01f8
        L_0x0133:
            r8 = 1
        L_0x0134:
            int r9 = r0.d
            int r9 = r9 + r6
            if (r8 >= r9) goto L_0x01f8
            com.google.a.h.a.g[] r9 = r0.f3256b
            r9 = r9[r8]
            com.google.a.h.a.d[] r9 = r9.f3260b
            r10 = 0
        L_0x0140:
            int r11 = r9.length
            if (r10 >= r11) goto L_0x01f4
            r11 = r9[r10]
            if (r11 == 0) goto L_0x01f0
            r11 = r9[r10]
            boolean r11 = r11.a()
            if (r11 != 0) goto L_0x01f0
            r11 = r9[r10]
            com.google.a.h.a.g[] r12 = r0.f3256b
            int r13 = r8 + -1
            r12 = r12[r13]
            com.google.a.h.a.d[] r12 = r12.f3260b
            com.google.a.h.a.g[] r13 = r0.f3256b
            int r14 = r8 + 1
            r13 = r13[r14]
            if (r13 == 0) goto L_0x0168
            com.google.a.h.a.g[] r13 = r0.f3256b
            r13 = r13[r14]
            com.google.a.h.a.d[] r13 = r13.f3260b
            goto L_0x0169
        L_0x0168:
            r13 = r12
        L_0x0169:
            r14 = 14
            com.google.a.h.a.d[] r15 = new com.google.a.h.a.d[r14]
            r16 = r12[r10]
            r15[r3] = r16
            r16 = 3
            r17 = r13[r10]
            r15[r16] = r17
            if (r10 <= 0) goto L_0x018b
            int r16 = r10 + -1
            r17 = r9[r16]
            r15[r2] = r17
            r17 = 4
            r18 = r12[r16]
            r15[r17] = r18
            r17 = 5
            r16 = r13[r16]
            r15[r17] = r16
        L_0x018b:
            if (r10 <= r6) goto L_0x01a1
            r16 = 8
            int r17 = r10 + -2
            r18 = r9[r17]
            r15[r16] = r18
            r16 = 10
            r18 = r12[r17]
            r15[r16] = r18
            r16 = 11
            r17 = r13[r17]
            r15[r16] = r17
        L_0x01a1:
            int r4 = r9.length
            int r4 = r4 - r6
            if (r10 >= r4) goto L_0x01b7
            int r4 = r10 + 1
            r16 = r9[r4]
            r15[r6] = r16
            r16 = 6
            r17 = r12[r4]
            r15[r16] = r17
            r16 = 7
            r4 = r13[r4]
            r15[r16] = r4
        L_0x01b7:
            int r4 = r9.length
            int r4 = r4 - r3
            if (r10 >= r4) goto L_0x01cf
            r4 = 9
            int r16 = r10 + 2
            r17 = r9[r16]
            r15[r4] = r17
            r4 = 12
            r12 = r12[r16]
            r15[r4] = r12
            r4 = 13
            r12 = r13[r16]
            r15[r4] = r12
        L_0x01cf:
            r4 = 0
        L_0x01d0:
            if (r4 >= r14) goto L_0x01f0
            r12 = r15[r4]
            if (r12 == 0) goto L_0x01e8
            boolean r13 = r12.a()
            if (r13 == 0) goto L_0x01e8
            int r13 = r12.f3250c
            int r14 = r11.f3250c
            if (r13 != r14) goto L_0x01e8
            int r12 = r12.e
            r11.e = r12
            r12 = 1
            goto L_0x01e9
        L_0x01e8:
            r12 = 0
        L_0x01e9:
            if (r12 != 0) goto L_0x01f0
            int r4 = r4 + 1
            r14 = 14
            goto L_0x01d0
        L_0x01f0:
            int r10 = r10 + 1
            goto L_0x0140
        L_0x01f4:
            int r8 = r8 + 1
            goto L_0x0134
        L_0x01f8:
            if (r7 <= 0) goto L_0x0200
            if (r7 < r5) goto L_0x01fd
            goto L_0x0200
        L_0x01fd:
            r5 = r7
            goto L_0x0044
        L_0x0200:
            com.google.a.h.a.g[] r4 = r0.f3256b
            int r5 = r4.length
            r7 = 0
            r8 = 0
        L_0x0205:
            if (r7 >= r5) goto L_0x022d
            r9 = r4[r7]
            if (r9 == 0) goto L_0x0228
            com.google.a.h.a.d[] r9 = r9.f3260b
            int r10 = r9.length
            r11 = 0
        L_0x020f:
            if (r11 >= r10) goto L_0x0228
            r12 = r9[r11]
            if (r12 == 0) goto L_0x0225
            int r13 = r12.e
            if (r13 < 0) goto L_0x0225
            int r14 = r1.length
            if (r13 >= r14) goto L_0x0225
            r13 = r1[r13]
            r13 = r13[r8]
            int r12 = r12.d
            r13.a(r12)
        L_0x0225:
            int r11 = r11 + 1
            goto L_0x020f
        L_0x0228:
            int r8 = r8 + 1
            int r7 = r7 + 1
            goto L_0x0205
        L_0x022d:
            r4 = r1[r2]
            r4 = r4[r6]
            int[] r5 = r4.a()
            int r7 = r0.d
            com.google.a.h.a.a r8 = r0.f3255a
            int r8 = r8.e
            int r7 = r7 * r8
            com.google.a.h.a.a r8 = r0.f3255a
            int r8 = r8.f3236b
            int r3 = r3 << r8
            int r7 = r7 - r3
            int r3 = r5.length
            if (r3 != 0) goto L_0x0251
            if (r7 <= 0) goto L_0x024c
            r3 = 928(0x3a0, float:1.3E-42)
            if (r7 <= r3) goto L_0x0255
        L_0x024c:
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x0251:
            r3 = r5[r2]
            if (r3 == r7) goto L_0x0258
        L_0x0255:
            r4.a(r7)
        L_0x0258:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.google.a.h.a.a r4 = r0.f3255a
            int r4 = r4.e
            int r5 = r0.d
            int r4 = r4 * r5
            int[] r4 = new int[r4]
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8 = 0
        L_0x0272:
            com.google.a.h.a.a r9 = r0.f3255a
            int r9 = r9.e
            if (r8 >= r9) goto L_0x02ae
            r9 = 0
        L_0x0279:
            int r10 = r0.d
            if (r9 >= r10) goto L_0x02ab
            r10 = r1[r8]
            int r11 = r9 + 1
            r10 = r10[r11]
            int[] r10 = r10.a()
            int r12 = r0.d
            int r12 = r12 * r8
            int r12 = r12 + r9
            int r9 = r10.length
            if (r9 != 0) goto L_0x0297
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            r3.add(r9)
            goto L_0x02a9
        L_0x0297:
            int r9 = r10.length
            if (r9 != r6) goto L_0x029f
            r9 = r10[r2]
            r4[r12] = r9
            goto L_0x02a9
        L_0x029f:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            r7.add(r9)
            r5.add(r10)
        L_0x02a9:
            r9 = r11
            goto L_0x0279
        L_0x02ab:
            int r8 = r8 + 1
            goto L_0x0272
        L_0x02ae:
            int r1 = r5.size()
            int[][] r1 = new int[r1][]
        L_0x02b4:
            int r6 = r1.length
            if (r2 >= r6) goto L_0x02c2
            java.lang.Object r6 = r5.get(r2)
            int[] r6 = (int[]) r6
            r1[r2] = r6
            int r2 = r2 + 1
            goto L_0x02b4
        L_0x02c2:
            com.google.a.h.a.a r0 = r0.f3255a
            int r0 = r0.f3236b
            int[] r2 = com.google.a.h.a.a((java.util.Collection<java.lang.Integer>) r3)
            int[] r3 = com.google.a.h.a.a((java.util.Collection<java.lang.Integer>) r7)
            com.google.a.c.e r0 = a(r0, r4, r2, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.a.j.a(com.google.a.h.a.f):com.google.a.c.e");
    }

    private static e a(int[] iArr, int i, int[] iArr2) throws h, d {
        c cVar;
        c cVar2;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        if (iArr3.length == 0) {
            throw h.getFormatInstance();
        }
        int i2 = 1;
        int i3 = 1 << (i + 1);
        if ((iArr4 == null || iArr4.length <= (i3 / 2) + 3) && i3 >= 0 && i3 <= 512) {
            a aVar = d;
            c cVar3 = new c(aVar.f3238a, iArr3);
            int[] iArr5 = new int[i3];
            int i4 = 0;
            boolean z = false;
            for (int i5 = i3; i5 > 0; i5--) {
                int b2 = cVar3.b(aVar.f3238a.f3240b[i5]);
                iArr5[i3 - i5] = b2;
                if (b2 != 0) {
                    z = true;
                }
            }
            if (z) {
                c cVar4 = aVar.f3238a.e;
                int i6 = 2;
                if (iArr4 != null) {
                    int length = iArr4.length;
                    c cVar5 = cVar4;
                    int i7 = 0;
                    while (i7 < length) {
                        int i8 = iArr4[i7];
                        int i9 = aVar.f3238a.f3240b[(iArr3.length - 1) - i8];
                        b bVar = aVar.f3238a;
                        int[] iArr6 = new int[i6];
                        iArr6[0] = aVar.f3238a.c(0, i9);
                        iArr6[1] = 1;
                        cVar5 = cVar5.c(new c(bVar, iArr6));
                        i7++;
                        i6 = 2;
                    }
                }
                c cVar6 = new c(aVar.f3238a, iArr5);
                c a2 = aVar.f3238a.a(i3, 1);
                if (a2.f3243b.length - 1 >= cVar6.f3243b.length - 1) {
                    c cVar7 = a2;
                    a2 = cVar6;
                    cVar6 = cVar7;
                }
                c cVar8 = aVar.f3238a.d;
                c cVar9 = aVar.f3238a.e;
                while (true) {
                    c cVar10 = r7;
                    c cVar11 = cVar6;
                    cVar6 = cVar10;
                    if (cVar6.f3243b.length - i2 < i3 / 2) {
                        int a3 = cVar9.a(0);
                        if (a3 == 0) {
                            throw d.getChecksumInstance();
                        }
                        int a4 = aVar.f3238a.a(a3);
                        c[] cVarArr = {cVar9.c(a4), cVar6.c(a4)};
                        c cVar12 = cVarArr[0];
                        c cVar13 = cVarArr[1];
                        int[] a5 = aVar.a(cVar12);
                        int[] a6 = aVar.a(cVar13, cVar12, a5);
                        for (int i10 = 0; i10 < a5.length; i10++) {
                            int length2 = iArr3.length - 1;
                            b bVar2 = aVar.f3238a;
                            int i11 = a5[i10];
                            if (i11 == 0) {
                                throw new IllegalArgumentException();
                            }
                            int i12 = length2 - bVar2.f3241c[i11];
                            if (i12 < 0) {
                                throw d.getChecksumInstance();
                            }
                            iArr3[i12] = aVar.f3238a.c(iArr3[i12], a6[i10]);
                        }
                        i4 = a5.length;
                    } else if (cVar6.a()) {
                        throw d.getChecksumInstance();
                    } else {
                        c cVar14 = aVar.f3238a.d;
                        int a7 = aVar.f3238a.a(cVar6.a(cVar6.f3243b.length - i2));
                        while (cVar11.f3243b.length - i2 >= cVar6.f3243b.length - i2 && !cVar11.a()) {
                            int length3 = (cVar11.f3243b.length - i2) - (cVar6.f3243b.length - i2);
                            int d2 = aVar.f3238a.d(cVar11.a(cVar11.f3243b.length - i2), a7);
                            c a8 = cVar14.a(aVar.f3238a.a(length3, d2));
                            if (length3 < 0) {
                                throw new IllegalArgumentException();
                            }
                            if (d2 == 0) {
                                cVar2 = cVar6.f3242a.d;
                                cVar = a8;
                            } else {
                                int length4 = cVar6.f3243b.length;
                                int[] iArr7 = new int[(length3 + length4)];
                                int i13 = 0;
                                while (i13 < length4) {
                                    iArr7[i13] = cVar6.f3242a.d(cVar6.f3243b[i13], d2);
                                    i13++;
                                    a8 = a8;
                                }
                                cVar = a8;
                                cVar2 = new c(cVar6.f3242a, iArr7);
                            }
                            cVar11 = cVar11.b(cVar2);
                            cVar14 = cVar;
                            i2 = 1;
                        }
                        cVar8 = cVar9;
                        cVar9 = cVar14.c(cVar9).b(cVar8).b();
                        i2 = 1;
                    }
                }
            }
            if (iArr3.length < 4) {
                throw h.getFormatInstance();
            }
            int i14 = iArr3[0];
            if (i14 > iArr3.length) {
                throw h.getFormatInstance();
            }
            if (i14 == 0) {
                if (i3 < iArr3.length) {
                    iArr3[0] = iArr3.length - i3;
                } else {
                    throw h.getFormatInstance();
                }
            }
            e a9 = e.a(iArr3, String.valueOf(i));
            a9.f = Integer.valueOf(i4);
            a9.g = Integer.valueOf(iArr4.length);
            return a9;
        }
        throw d.getChecksumInstance();
    }

    private static c a(h hVar) throws m {
        int[] iArr;
        t tVar;
        t tVar2;
        t tVar3;
        t tVar4;
        int i;
        h hVar2 = hVar;
        if (hVar2 == null) {
            return null;
        }
        a a2 = hVar.a();
        int i2 = 0;
        if (a2 == null) {
            iArr = null;
        } else {
            c cVar = hVar2.f3259a;
            int b2 = hVar2.b((int) (hVar2.f3261c ? cVar.f3247c : cVar.e).f3357b);
            d[] dVarArr = hVar2.f3260b;
            int i3 = -1;
            int i4 = 0;
            int i5 = 1;
            for (int b3 = hVar2.b((int) (hVar2.f3261c ? cVar.f3246b : cVar.d).f3357b); b3 < b2; b3++) {
                if (dVarArr[b3] != null) {
                    d dVar = dVarArr[b3];
                    dVar.b();
                    int i6 = dVar.e - i3;
                    if (i6 == 0) {
                        i4++;
                    } else {
                        if (i6 == 1) {
                            i5 = Math.max(i5, i4);
                            i3 = dVar.e;
                        } else if (dVar.e >= a2.e) {
                            dVarArr[b3] = null;
                        } else {
                            i3 = dVar.e;
                        }
                        i4 = 1;
                    }
                }
            }
            iArr = new int[a2.e];
            for (d dVar2 : hVar2.f3260b) {
                if (dVar2 != null && (i = dVar2.e) < iArr.length) {
                    iArr[i] = iArr[i] + 1;
                }
            }
        }
        if (iArr == null) {
            return null;
        }
        int i7 = -1;
        for (int max : iArr) {
            i7 = Math.max(i7, max);
        }
        int i8 = 0;
        for (int i9 : iArr) {
            i8 += i7 - i9;
            if (i9 > 0) {
                break;
            }
        }
        d[] dVarArr2 = hVar2.f3260b;
        int i10 = 0;
        while (i8 > 0 && dVarArr2[i10] == null) {
            i8--;
            i10++;
        }
        int i11 = 0;
        for (int length = iArr.length - 1; length >= 0; length--) {
            i11 += i7 - iArr[length];
            if (iArr[length] > 0) {
                break;
            }
        }
        int length2 = dVarArr2.length - 1;
        while (i11 > 0 && dVarArr2[length2] == null) {
            i11--;
            length2--;
        }
        c cVar2 = hVar2.f3259a;
        boolean z = hVar2.f3261c;
        t tVar5 = cVar2.f3246b;
        t tVar6 = cVar2.f3247c;
        t tVar7 = cVar2.d;
        t tVar8 = cVar2.e;
        if (i8 > 0) {
            t tVar9 = z ? cVar2.f3246b : cVar2.d;
            int i12 = ((int) tVar9.f3357b) - i8;
            if (i12 >= 0) {
                i2 = i12;
            }
            t tVar10 = new t(tVar9.f3356a, (float) i2);
            if (z) {
                tVar = tVar7;
                tVar2 = tVar10;
            } else {
                tVar2 = tVar5;
                tVar = tVar10;
            }
        } else {
            tVar2 = tVar5;
            tVar = tVar7;
        }
        if (i11 > 0) {
            t tVar11 = z ? cVar2.f3247c : cVar2.e;
            int i13 = ((int) tVar11.f3357b) + i11;
            if (i13 >= cVar2.f3245a.f3062b) {
                i13 = cVar2.f3245a.f3062b - 1;
            }
            t tVar12 = new t(tVar11.f3356a, (float) i13);
            if (z) {
                tVar4 = tVar12;
            } else {
                tVar4 = tVar6;
                tVar3 = tVar12;
                return new c(cVar2.f3245a, tVar2, tVar4, tVar, tVar3);
            }
        } else {
            tVar4 = tVar6;
        }
        tVar3 = tVar8;
        return new c(cVar2.f3245a, tVar2, tVar4, tVar, tVar3);
    }

    private static d a(com.google.a.c.b bVar, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int a2;
        int a3;
        com.google.a.c.b bVar2 = bVar;
        int i8 = i;
        int i9 = i2;
        int i10 = i4;
        boolean z2 = true;
        boolean z3 = z;
        int i11 = i3;
        int i12 = z ? -1 : 1;
        int i13 = 0;
        loop0:
        while (true) {
            if (i13 >= 2) {
                break;
            }
            while (true) {
                if (!z3) {
                    if (i11 >= i9) {
                        break;
                    }
                } else if (i11 < i8) {
                    break;
                }
                if (z3 != bVar2.a(i11, i10)) {
                    break;
                } else if (Math.abs(i3 - i11) > 2) {
                    i11 = i3;
                    break loop0;
                } else {
                    i11 += i12;
                }
            }
            i12 = -i12;
            z3 = !z3;
            i13++;
        }
        int[] iArr = new int[8];
        int i14 = z ? 1 : -1;
        boolean z4 = z;
        int i15 = i11;
        int i16 = 0;
        while (true) {
            if (!z) {
                if (i15 < i8) {
                    break;
                }
            } else if (i15 >= i9) {
                break;
            }
            if (i16 >= 8) {
                break;
            } else if (bVar2.a(i15, i10) == z4) {
                iArr[i16] = iArr[i16] + 1;
                i15 += i14;
            } else {
                i16++;
                z4 = !z4;
            }
        }
        if (i16 != 8) {
            if (z) {
                i8 = i9;
            }
            if (!(i15 == i8 && i16 == 7)) {
                iArr = null;
            }
        }
        if (iArr == null) {
            return null;
        }
        int a4 = com.google.a.c.a.a.a(iArr);
        if (z) {
            i7 = i11 + a4;
        } else {
            for (int i17 = 0; i17 < iArr.length / 2; i17++) {
                int i18 = iArr[i17];
                iArr[i17] = iArr[(iArr.length - 1) - i17];
                iArr[(iArr.length - 1) - i17] = i18;
            }
            i7 = i11;
            i11 -= a4;
        }
        if (i5 - 2 > a4 || a4 > i6 + 2) {
            z2 = false;
        }
        if (!z2 || (a3 = com.google.a.h.a.a(a2)) == -1) {
            return null;
        }
        int[] b2 = b((a2 = i.a(iArr)));
        return new d(i11, i7, ((((b2[0] - b2[2]) + b2[4]) - b2[6]) + 9) % 9, a3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r1.e != r2.e) goto L_0x002d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.a.h.a.f a(com.google.a.h.a.h r8, com.google.a.h.a.h r9) throws com.google.a.m {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0006
            if (r9 != 0) goto L_0x0006
            return r0
        L_0x0006:
            if (r8 == 0) goto L_0x002b
            com.google.a.h.a.a r1 = r8.a()
            if (r1 != 0) goto L_0x000f
            goto L_0x002b
        L_0x000f:
            if (r9 == 0) goto L_0x0033
            com.google.a.h.a.a r2 = r9.a()
            if (r2 != 0) goto L_0x0018
            goto L_0x0033
        L_0x0018:
            int r3 = r1.f3235a
            int r4 = r2.f3235a
            if (r3 == r4) goto L_0x0033
            int r3 = r1.f3236b
            int r4 = r2.f3236b
            if (r3 == r4) goto L_0x0033
            int r3 = r1.e
            int r2 = r2.e
            if (r3 == r2) goto L_0x0033
            goto L_0x002d
        L_0x002b:
            if (r9 != 0) goto L_0x002f
        L_0x002d:
            r1 = r0
            goto L_0x0033
        L_0x002f:
            com.google.a.h.a.a r1 = r9.a()
        L_0x0033:
            if (r1 != 0) goto L_0x0036
            return r0
        L_0x0036:
            com.google.a.h.a.c r8 = a((com.google.a.h.a.h) r8)
            com.google.a.h.a.c r9 = a((com.google.a.h.a.h) r9)
            if (r8 != 0) goto L_0x0042
            r8 = r9
            goto L_0x0056
        L_0x0042:
            if (r9 != 0) goto L_0x0045
            goto L_0x0056
        L_0x0045:
            com.google.a.h.a.c r0 = new com.google.a.h.a.c
            com.google.a.c.b r3 = r8.f3245a
            com.google.a.t r4 = r8.f3246b
            com.google.a.t r5 = r8.f3247c
            com.google.a.t r6 = r9.d
            com.google.a.t r7 = r9.e
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            r8 = r0
        L_0x0056:
            com.google.a.h.a.f r9 = new com.google.a.h.a.f
            r9.<init>(r1, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.a.j.a(com.google.a.h.a.h, com.google.a.h.a.h):com.google.a.h.a.f");
    }

    private static h a(com.google.a.c.b bVar, c cVar, t tVar, boolean z, int i, int i2) {
        c cVar2 = cVar;
        t tVar2 = tVar;
        boolean z2 = z;
        h hVar = new h(cVar2, z2);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int i5 = (int) tVar2.f3356a;
            int i6 = (int) tVar2.f3357b;
            while (i6 <= cVar2.i && i6 >= cVar2.h) {
                com.google.a.c.b bVar2 = bVar;
                d a2 = a(bVar2, 0, bVar2.f3061a, z2, i5, i6, i, i2);
                if (a2 != null) {
                    hVar.a(i6, a2);
                    i5 = z2 ? a2.f3248a : a2.f3249b;
                }
                i6 += i4;
            }
            i3++;
        }
        return hVar;
    }

    private static String a(b[][] bVarArr) {
        Throwable th;
        Formatter formatter = new Formatter();
        int i = 0;
        while (i < bVarArr.length) {
            try {
                formatter.format("Row %2d: ", new Object[]{Integer.valueOf(i)});
                for (b bVar : bVarArr[i]) {
                    if (bVar.a().length == 0) {
                        formatter.format("        ", (Object[]) null);
                    } else {
                        formatter.format("%4d(%2d)", new Object[]{Integer.valueOf(bVar.a()[0]), bVar.f3244a.get(Integer.valueOf(bVar.a()[0]))});
                    }
                }
                formatter.format("%n", new Object[0]);
                i++;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
        throw th;
    }

    private static void a(f fVar, b[][] bVarArr) throws m {
        b bVar = bVarArr[0][1];
        int[] a2 = bVar.a();
        int i = (fVar.d * fVar.f3255a.e) - (2 << fVar.f3255a.f3236b);
        if (a2.length == 0) {
            if (i <= 0 || i > 928) {
                throw m.getNotFoundInstance();
            }
            bVar.a(i);
        } else if (a2[0] != i) {
            bVar.a(i);
        }
    }

    private static void a(int[] iArr, int i) throws h {
        if (iArr.length < 4) {
            throw h.getFormatInstance();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw h.getFormatInstance();
        } else if (i2 != 0) {
        } else {
            if (i < iArr.length) {
                iArr[0] = iArr.length - i;
                return;
            }
            throw h.getFormatInstance();
        }
    }

    private static boolean a(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + 2;
    }

    private static boolean a(f fVar, int i) {
        return i >= 0 && i <= fVar.d + 1;
    }

    private static int[] a(com.google.a.c.b bVar, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        boolean z2 = z;
        int i6 = 0;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
            } else if (i3 >= i2) {
                break;
            }
            if (i6 >= 8) {
                break;
            } else if (bVar.a(i3, i4) == z2) {
                iArr[i6] = iArr[i6] + 1;
                i3 += i5;
            } else {
                i6++;
                z2 = !z2;
            }
        }
        if (i6 == 8) {
            return iArr;
        }
        if (z) {
            i = i2;
        }
        if (i3 == i && i6 == 7) {
            return iArr;
        }
        return null;
    }

    private static int b(com.google.a.c.b bVar, int i, int i2, boolean z, int i3, int i4) {
        boolean z2 = z;
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (!z2) {
                    if (i6 >= i2) {
                        break;
                    }
                } else if (i6 < i) {
                    break;
                }
                if (z2 != bVar.a(i6, i4)) {
                    break;
                } else if (Math.abs(i3 - i6) > 2) {
                    return i3;
                } else {
                    i6 += i5;
                }
            }
            i5 = -i5;
            z2 = !z2;
        }
        return i6;
    }

    private static int b(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static a b(h hVar, h hVar2) {
        a a2;
        a a3;
        if (hVar == null || (a2 = hVar.a()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.a();
        } else if (hVar2 == null || (a3 = hVar2.a()) == null || a2.f3235a == a3.f3235a || a2.f3236b == a3.f3236b || a2.e == a3.e) {
            return a2;
        } else {
            return null;
        }
    }

    private static int[] b(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static b[][] b(f fVar) {
        int i;
        int i2;
        int i3;
        boolean z;
        f fVar2 = fVar;
        b[][] bVarArr = (b[][]) Array.newInstance(b.class, new int[]{fVar2.f3255a.e, fVar2.d + 2});
        int i4 = 0;
        for (int i5 = 0; i5 < bVarArr.length; i5++) {
            for (int i6 = 0; i6 < bVarArr[i5].length; i6++) {
                bVarArr[i5][i6] = new b();
            }
        }
        fVar2.a(fVar2.f3256b[0]);
        fVar2.a(fVar2.f3256b[fVar2.d + 1]);
        int i7 = com.google.a.h.a.f3233b;
        while (true) {
            if (!(fVar2.f3256b[i4] == null || fVar2.f3256b[fVar2.d + 1] == null)) {
                d[] dVarArr = fVar2.f3256b[i4].f3260b;
                d[] dVarArr2 = fVar2.f3256b[fVar2.d + 1].f3260b;
                for (int i8 = 0; i8 < dVarArr.length; i8++) {
                    if (!(dVarArr[i8] == null || dVarArr2[i8] == null || dVarArr[i8].e != dVarArr2[i8].e)) {
                        for (int i9 = 1; i9 <= fVar2.d; i9++) {
                            d dVar = fVar2.f3256b[i9].f3260b[i8];
                            if (dVar != null) {
                                dVar.e = dVarArr[i8].e;
                                if (!dVar.a()) {
                                    fVar2.f3256b[i9].f3260b[i8] = null;
                                }
                            }
                        }
                    }
                }
            }
            if (fVar2.f3256b[i4] == null) {
                i = 0;
            } else {
                d[] dVarArr3 = fVar2.f3256b[i4].f3260b;
                i = 0;
                for (int i10 = 0; i10 < dVarArr3.length; i10++) {
                    if (dVarArr3[i10] != null) {
                        int i11 = dVarArr3[i10].e;
                        int i12 = i;
                        int i13 = 0;
                        for (int i14 = 1; i14 < fVar2.d + 1 && i13 < 2; i14++) {
                            d dVar2 = fVar2.f3256b[i14].f3260b[i10];
                            if (dVar2 != null) {
                                i13 = f.a(i11, i13, dVar2);
                                if (!dVar2.a()) {
                                    i12++;
                                }
                            }
                        }
                        i = i12;
                    }
                }
            }
            if (fVar2.f3256b[fVar2.d + 1] == null) {
                i2 = 0;
            } else {
                d[] dVarArr4 = fVar2.f3256b[fVar2.d + 1].f3260b;
                i2 = 0;
                for (int i15 = 0; i15 < dVarArr4.length; i15++) {
                    if (dVarArr4[i15] != null) {
                        int i16 = dVarArr4[i15].e;
                        int i17 = i2;
                        int i18 = 0;
                        for (int i19 = fVar2.d + 1; i19 > 0 && i18 < 2; i19--) {
                            d dVar3 = fVar2.f3256b[i19].f3260b[i15];
                            if (dVar3 != null) {
                                i18 = f.a(i16, i18, dVar3);
                                if (!dVar3.a()) {
                                    i17++;
                                }
                            }
                        }
                        i2 = i17;
                    }
                }
            }
            int i20 = i + i2;
            if (i20 != 0) {
                int i21 = 1;
                while (i21 < fVar2.d + 1) {
                    d[] dVarArr5 = fVar2.f3256b[i21].f3260b;
                    int i22 = 0;
                    while (i22 < dVarArr5.length) {
                        if (dVarArr5[i22] != null && !dVarArr5[i22].a()) {
                            d dVar4 = dVarArr5[i22];
                            d[] dVarArr6 = fVar2.f3256b[i21 - 1].f3260b;
                            int i23 = i21 + 1;
                            d[] dVarArr7 = fVar2.f3256b[i23] != null ? fVar2.f3256b[i23].f3260b : dVarArr6;
                            d[] dVarArr8 = new d[14];
                            dVarArr8[2] = dVarArr6[i22];
                            dVarArr8[3] = dVarArr7[i22];
                            if (i22 > 0) {
                                int i24 = i22 - 1;
                                dVarArr8[i4] = dVarArr5[i24];
                                dVarArr8[4] = dVarArr6[i24];
                                dVarArr8[5] = dVarArr7[i24];
                            }
                            if (i22 > 1) {
                                int i25 = i22 - 2;
                                dVarArr8[8] = dVarArr5[i25];
                                dVarArr8[10] = dVarArr6[i25];
                                dVarArr8[11] = dVarArr7[i25];
                            }
                            if (i22 < dVarArr5.length - 1) {
                                int i26 = i22 + 1;
                                dVarArr8[1] = dVarArr5[i26];
                                dVarArr8[6] = dVarArr6[i26];
                                dVarArr8[7] = dVarArr7[i26];
                            }
                            if (i22 < dVarArr5.length - 2) {
                                int i27 = i22 + 2;
                                dVarArr8[9] = dVarArr5[i27];
                                dVarArr8[12] = dVarArr6[i27];
                                dVarArr8[13] = dVarArr7[i27];
                            }
                            for (int i28 = 0; i28 < 14; i28++) {
                                d dVar5 = dVarArr8[i28];
                                if (dVar5 == null || !dVar5.a() || dVar5.f3250c != dVar4.f3250c) {
                                    z = false;
                                } else {
                                    dVar4.e = dVar5.e;
                                    z = true;
                                }
                                if (z) {
                                    break;
                                }
                            }
                        }
                        i22++;
                        i4 = 0;
                    }
                    i21++;
                    i4 = 0;
                }
                i4 = i20;
            }
            if (i4 <= 0 || i4 >= i7) {
                int i29 = 0;
            } else {
                i7 = i4;
                i4 = 0;
            }
        }
        int i292 = 0;
        for (g gVar : fVar2.f3256b) {
            if (gVar != null) {
                for (d dVar6 : gVar.f3260b) {
                    if (dVar6 != null && (i3 = dVar6.e) >= 0 && i3 < bVarArr.length) {
                        bVarArr[i3][i292].a(dVar6.d);
                    }
                }
            }
            i292++;
        }
        return bVarArr;
    }

    private static int c(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }
}

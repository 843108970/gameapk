package com.google.a.i.c;

import android.support.v7.widget.ActivityChooserView;
import com.google.a.c.a;
import com.google.a.c.d;
import com.google.a.g;
import com.google.a.i.a.f;
import com.google.a.i.a.h;
import com.google.a.i.a.j;
import com.google.a.w;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    static final String f3334a = "ISO-8859-1";

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3335b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private c() {
    }

    private static int a(int i) {
        if (i < f3335b.length) {
            return f3335b[i];
        }
        return -1;
    }

    private static int a(a aVar, f fVar, j jVar, b bVar) throws w {
        b bVar2 = bVar;
        boolean z = false;
        int i = -1;
        int i2 = 0;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        while (i2 < 8) {
            e.a(aVar, fVar, jVar, i2, bVar2);
            int a2 = d.a(bVar2, true) + d.a(bVar2, z);
            byte[][] bArr = bVar2.f3331a;
            int i4 = bVar2.f3332b;
            int i5 = bVar2.f3333c;
            int i6 = 0;
            int i7 = 0;
            while (i6 < i5 - 1) {
                byte[] bArr2 = bArr[i6];
                int i8 = i7;
                int i9 = 0;
                while (i9 < i4 - 1) {
                    byte b2 = bArr2[i9];
                    int i10 = i9 + 1;
                    if (b2 == bArr2[i10]) {
                        int i11 = i6 + 1;
                        if (b2 == bArr[i11][i9] && b2 == bArr[i11][i10]) {
                            i8++;
                        }
                    }
                    i9 = i10;
                }
                i6++;
                i7 = i8;
            }
            int i12 = a2 + (i7 * 3);
            byte[][] bArr3 = bVar2.f3331a;
            int i13 = bVar2.f3332b;
            int i14 = bVar2.f3333c;
            int i15 = 0;
            int i16 = 0;
            while (i15 < i14) {
                int i17 = i16;
                int i18 = 0;
                while (i18 < i13) {
                    byte[] bArr4 = bArr3[i15];
                    int i19 = i18 + 6;
                    if (i19 < i13 && bArr4[i18] == 1 && bArr4[i18 + 1] == 0 && bArr4[i18 + 2] == 1 && bArr4[i18 + 3] == 1 && bArr4[i18 + 4] == 1 && bArr4[i18 + 5] == 0 && bArr4[i19] == 1 && (d.a(bArr4, i18 - 4, i18) || d.a(bArr4, i18 + 7, i18 + 11))) {
                        i17++;
                    }
                    int i20 = i15 + 6;
                    if (i20 < i14 && bArr3[i15][i18] == 1 && bArr3[i15 + 1][i18] == 0 && bArr3[i15 + 2][i18] == 1 && bArr3[i15 + 3][i18] == 1 && bArr3[i15 + 4][i18] == 1 && bArr3[i15 + 5][i18] == 0 && bArr3[i20][i18] == 1 && (d.a(bArr3, i18, i15 - 4, i15) || d.a(bArr3, i18, i15 + 7, i15 + 11))) {
                        i17++;
                    }
                    i18++;
                    a aVar2 = aVar;
                    f fVar2 = fVar;
                }
                i15++;
                i16 = i17;
                a aVar3 = aVar;
                f fVar3 = fVar;
            }
            int i21 = i12 + (i16 * 40);
            byte[][] bArr5 = bVar2.f3331a;
            int i22 = bVar2.f3332b;
            int i23 = bVar2.f3333c;
            int i24 = 0;
            int i25 = 0;
            while (i24 < i23) {
                byte[] bArr6 = bArr5[i24];
                int i26 = i25;
                for (int i27 = 0; i27 < i22; i27++) {
                    if (bArr6[i27] == 1) {
                        i26++;
                    }
                }
                i24++;
                i25 = i26;
            }
            int i28 = bVar2.f3333c * bVar2.f3332b;
            int abs = i21 + (((Math.abs((i25 << 1) - i28) * 10) / i28) * 10);
            if (abs < i3) {
                i = i2;
                i3 = abs;
            }
            i2++;
            z = false;
        }
        return i;
    }

    private static int a(h hVar, a aVar, a aVar2, j jVar) {
        return aVar.f3055b + hVar.getCharacterCountBits(jVar) + aVar2.f3055b;
    }

    private static int a(b bVar) {
        int a2 = d.a(bVar, true) + d.a(bVar, false);
        byte[][] bArr = bVar.f3331a;
        int i = bVar.f3332b;
        int i2 = bVar.f3333c;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2 - 1) {
            byte[] bArr2 = bArr[i3];
            int i5 = i4;
            int i6 = 0;
            while (i6 < i - 1) {
                byte b2 = bArr2[i6];
                int i7 = i6 + 1;
                if (b2 == bArr2[i7]) {
                    int i8 = i3 + 1;
                    if (b2 == bArr[i8][i6] && b2 == bArr[i8][i7]) {
                        i5++;
                    }
                }
                i6 = i7;
            }
            i3++;
            i4 = i5;
        }
        int i9 = a2 + (i4 * 3);
        byte[][] bArr3 = bVar.f3331a;
        int i10 = bVar.f3332b;
        int i11 = bVar.f3333c;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = i13;
            for (int i15 = 0; i15 < i10; i15++) {
                byte[] bArr4 = bArr3[i12];
                int i16 = i15 + 6;
                if (i16 < i10 && bArr4[i15] == 1 && bArr4[i15 + 1] == 0 && bArr4[i15 + 2] == 1 && bArr4[i15 + 3] == 1 && bArr4[i15 + 4] == 1 && bArr4[i15 + 5] == 0 && bArr4[i16] == 1 && (d.a(bArr4, i15 - 4, i15) || d.a(bArr4, i15 + 7, i15 + 11))) {
                    i14++;
                }
                int i17 = i12 + 6;
                if (i17 < i11 && bArr3[i12][i15] == 1 && bArr3[i12 + 1][i15] == 0 && bArr3[i12 + 2][i15] == 1 && bArr3[i12 + 3][i15] == 1 && bArr3[i12 + 4][i15] == 1 && bArr3[i12 + 5][i15] == 0 && bArr3[i17][i15] == 1 && (d.a(bArr3, i15, i12 - 4, i12) || d.a(bArr3, i15, i12 + 7, i12 + 11))) {
                    i14++;
                }
            }
            i12++;
            i13 = i14;
        }
        int i18 = i9 + (i13 * 40);
        byte[][] bArr5 = bVar.f3331a;
        int i19 = bVar.f3332b;
        int i20 = bVar.f3333c;
        int i21 = 0;
        int i22 = 0;
        while (i21 < i20) {
            byte[] bArr6 = bArr5[i21];
            int i23 = i22;
            for (int i24 = 0; i24 < i19; i24++) {
                if (bArr6[i24] == 1) {
                    i23++;
                }
            }
            i21++;
            i22 = i23;
        }
        int i25 = bVar.f3333c * bVar.f3332b;
        return i18 + (((Math.abs((i22 << 1) - i25) * 10) / i25) * 10);
    }

    private static a a(a aVar, int i, int i2, int i3) throws w {
        char c2;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (aVar.a() != i5) {
            throw new w("Number of bits and data bytes does not match");
        }
        ArrayList<a> arrayList = new ArrayList<>(i6);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i7 < i6) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            if (i7 >= i6) {
                throw new w("Block ID too large");
            }
            int i11 = i4 % i6;
            int i12 = i6 - i11;
            int i13 = i4 / i6;
            int i14 = i13 + 1;
            int i15 = i5 / i6;
            int i16 = i15 + 1;
            int i17 = i13 - i15;
            int i18 = i14 - i16;
            if (i17 != i18) {
                throw new w("EC bytes mismatch");
            } else if (i6 != i12 + i11) {
                throw new w("RS blocks mismatch");
            } else if (i4 != ((i15 + i17) * i12) + ((i16 + i18) * i11)) {
                throw new w("Total bytes mismatch");
            } else {
                if (i7 < i12) {
                    c2 = 0;
                    iArr[0] = i15;
                    iArr2[0] = i17;
                } else {
                    c2 = 0;
                    iArr[0] = i16;
                    iArr2[0] = i18;
                }
                int i19 = iArr[c2];
                byte[] bArr = new byte[i19];
                aVar.a(i8 << 3, bArr, i19);
                byte[] a2 = a(bArr, iArr2[c2]);
                arrayList.add(new a(bArr, a2));
                i9 = Math.max(i9, i19);
                i10 = Math.max(i10, a2.length);
                i8 += iArr[c2];
                i7++;
            }
        }
        if (i5 != i8) {
            throw new w("Data bytes does not match offset");
        }
        a aVar2 = new a();
        for (int i20 = 0; i20 < i9; i20++) {
            for (a aVar3 : arrayList) {
                byte[] bArr2 = aVar3.f3329a;
                if (i20 < bArr2.length) {
                    aVar2.b(bArr2[i20], 8);
                }
            }
        }
        for (int i21 = 0; i21 < i10; i21++) {
            for (a aVar4 : arrayList) {
                byte[] bArr3 = aVar4.f3330b;
                if (i21 < bArr3.length) {
                    aVar2.b(bArr3[i21], 8);
                }
            }
        }
        if (i4 == aVar2.a()) {
            return aVar2;
        }
        throw new w("Interleaving error: " + i4 + " and " + aVar2.a() + " differ.");
    }

    private static h a(String str) {
        return a(str, (String) null);
    }

    private static h a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && b(str)) {
            return h.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (a((int) charAt) == -1) {
                return h.BYTE;
            } else {
                z = true;
            }
        }
        return z ? h.ALPHANUMERIC : z2 ? h.NUMERIC : h.BYTE;
    }

    private static j a(int i, f fVar) throws w {
        for (int i2 = 1; i2 <= 40; i2++) {
            j b2 = j.b(i2);
            if (a(i, b2, fVar)) {
                return b2;
            }
        }
        throw new w("Data too big");
    }

    private static j a(f fVar, h hVar, a aVar, a aVar2) throws w {
        return a(a(hVar, aVar, aVar2, a(a(hVar, aVar, aVar2, j.b(1)), fVar)), fVar);
    }

    private static f a(String str, f fVar) throws w {
        return a(str, fVar, (Map<g, ?>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cb A[LOOP:0: B:31:0x0098->B:46:0x00cb, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x00c3 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.a.i.c.f a(java.lang.String r12, com.google.a.i.a.f r13, java.util.Map<com.google.a.g, ?> r14) throws com.google.a.w {
        /*
            java.lang.String r0 = "ISO-8859-1"
            r1 = 0
            r2 = 1
            if (r14 == 0) goto L_0x0010
            com.google.a.g r3 = com.google.a.g.CHARACTER_SET
            boolean r3 = r14.containsKey(r3)
            if (r3 == 0) goto L_0x0010
            r3 = 1
            goto L_0x0011
        L_0x0010:
            r3 = 0
        L_0x0011:
            if (r3 == 0) goto L_0x001d
            com.google.a.g r0 = com.google.a.g.CHARACTER_SET
            java.lang.Object r0 = r14.get(r0)
            java.lang.String r0 = r0.toString()
        L_0x001d:
            com.google.a.i.a.h r4 = a((java.lang.String) r12, (java.lang.String) r0)
            com.google.a.c.a r5 = new com.google.a.c.a
            r5.<init>()
            com.google.a.i.a.h r6 = com.google.a.i.a.h.BYTE
            r7 = 4
            r8 = 8
            if (r4 != r6) goto L_0x0045
            if (r3 == 0) goto L_0x0045
            com.google.a.c.d r3 = com.google.a.c.d.getCharacterSetECIByName(r0)
            if (r3 == 0) goto L_0x0045
            com.google.a.i.a.h r6 = com.google.a.i.a.h.ECI
            int r6 = r6.getBits()
            r5.b(r6, r7)
            int r3 = r3.getValue()
            r5.b(r3, r8)
        L_0x0045:
            if (r14 == 0) goto L_0x0051
            com.google.a.g r3 = com.google.a.g.GS1_FORMAT
            boolean r3 = r14.containsKey(r3)
            if (r3 == 0) goto L_0x0051
            r3 = 1
            goto L_0x0052
        L_0x0051:
            r3 = 0
        L_0x0052:
            if (r3 == 0) goto L_0x006d
            com.google.a.g r3 = com.google.a.g.GS1_FORMAT
            java.lang.Object r3 = r14.get(r3)
            java.lang.String r3 = r3.toString()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x006d
            com.google.a.i.a.h r3 = com.google.a.i.a.h.FNC1_FIRST_POSITION
            a((com.google.a.i.a.h) r3, (com.google.a.c.a) r5)
        L_0x006d:
            a((com.google.a.i.a.h) r4, (com.google.a.c.a) r5)
            com.google.a.c.a r3 = new com.google.a.c.a
            r3.<init>()
            int[] r6 = com.google.a.i.c.c.AnonymousClass1.f3336a
            int r9 = r4.ordinal()
            r6 = r6[r9]
            r9 = -1
            switch(r6) {
                case 1: goto L_0x0132;
                case 2: goto L_0x00f7;
                case 3: goto L_0x00e1;
                case 4: goto L_0x0091;
                default: goto L_0x0081;
            }
        L_0x0081:
            com.google.a.w r12 = new com.google.a.w
            java.lang.String r13 = "Invalid mode: "
            java.lang.String r14 = java.lang.String.valueOf(r4)
            java.lang.String r13 = r13.concat(r14)
            r12.<init>((java.lang.String) r13)
            throw r12
        L_0x0091:
            java.lang.String r0 = "Shift_JIS"
            byte[] r0 = r12.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x00da }
            int r6 = r0.length
        L_0x0098:
            if (r1 >= r6) goto L_0x0175
            byte r7 = r0[r1]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r10 = r1 + 1
            byte r10 = r0[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r8
            r7 = r7 | r10
            r10 = 33088(0x8140, float:4.6366E-41)
            if (r7 < r10) goto L_0x00b2
            r11 = 40956(0x9ffc, float:5.7392E-41)
            if (r7 > r11) goto L_0x00b2
        L_0x00b0:
            int r7 = r7 - r10
            goto L_0x00c1
        L_0x00b2:
            r10 = 57408(0xe040, float:8.0446E-41)
            if (r7 < r10) goto L_0x00c0
            r10 = 60351(0xebbf, float:8.457E-41)
            if (r7 > r10) goto L_0x00c0
            r10 = 49472(0xc140, float:6.9325E-41)
            goto L_0x00b0
        L_0x00c0:
            r7 = -1
        L_0x00c1:
            if (r7 != r9) goto L_0x00cb
            com.google.a.w r12 = new com.google.a.w
            java.lang.String r13 = "Invalid byte sequence"
            r12.<init>((java.lang.String) r13)
            throw r12
        L_0x00cb:
            int r10 = r7 >> 8
            int r10 = r10 * 192
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r10 = r10 + r7
            r7 = 13
            r3.b(r10, r7)
            int r1 = r1 + 2
            goto L_0x0098
        L_0x00da:
            r12 = move-exception
            com.google.a.w r13 = new com.google.a.w
            r13.<init>((java.lang.Throwable) r12)
            throw r13
        L_0x00e1:
            byte[] r0 = r12.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x00f0 }
            int r6 = r0.length
        L_0x00e6:
            if (r1 >= r6) goto L_0x0175
            byte r7 = r0[r1]
            r3.b(r7, r8)
            int r1 = r1 + 1
            goto L_0x00e6
        L_0x00f0:
            r12 = move-exception
            com.google.a.w r13 = new com.google.a.w
            r13.<init>((java.lang.Throwable) r12)
            throw r13
        L_0x00f7:
            int r0 = r12.length()
        L_0x00fb:
            if (r1 >= r0) goto L_0x0175
            char r6 = r12.charAt(r1)
            int r6 = a((int) r6)
            if (r6 != r9) goto L_0x010d
            com.google.a.w r12 = new com.google.a.w
            r12.<init>()
            throw r12
        L_0x010d:
            int r7 = r1 + 1
            if (r7 >= r0) goto L_0x012c
            char r7 = r12.charAt(r7)
            int r7 = a((int) r7)
            if (r7 != r9) goto L_0x0121
            com.google.a.w r12 = new com.google.a.w
            r12.<init>()
            throw r12
        L_0x0121:
            int r6 = r6 * 45
            int r6 = r6 + r7
            r7 = 11
            r3.b(r6, r7)
            int r1 = r1 + 2
            goto L_0x00fb
        L_0x012c:
            r1 = 6
            r3.b(r6, r1)
            r1 = r7
            goto L_0x00fb
        L_0x0132:
            int r0 = r12.length()
        L_0x0136:
            if (r1 >= r0) goto L_0x0175
            char r6 = r12.charAt(r1)
            int r6 = r6 + -48
            int r8 = r1 + 2
            if (r8 >= r0) goto L_0x015e
            int r9 = r1 + 1
            char r9 = r12.charAt(r9)
            int r9 = r9 + -48
            char r8 = r12.charAt(r8)
            int r8 = r8 + -48
            int r6 = r6 * 100
            r10 = 10
            int r9 = r9 * 10
            int r6 = r6 + r9
            int r6 = r6 + r8
            r3.b(r6, r10)
            int r1 = r1 + 3
            goto L_0x0136
        L_0x015e:
            int r1 = r1 + 1
            if (r1 >= r0) goto L_0x0171
            char r1 = r12.charAt(r1)
            int r1 = r1 + -48
            int r6 = r6 * 10
            int r6 = r6 + r1
            r1 = 7
            r3.b(r6, r1)
            r1 = r8
            goto L_0x0136
        L_0x0171:
            r3.b(r6, r7)
            goto L_0x0136
        L_0x0175:
            if (r14 == 0) goto L_0x01a3
            com.google.a.g r0 = com.google.a.g.QR_VERSION
            boolean r0 = r14.containsKey(r0)
            if (r0 == 0) goto L_0x01a3
            com.google.a.g r0 = com.google.a.g.QR_VERSION
            java.lang.Object r14 = r14.get(r0)
            java.lang.String r14 = r14.toString()
            int r14 = java.lang.Integer.parseInt(r14)
            com.google.a.i.a.j r14 = com.google.a.i.a.j.b(r14)
            int r0 = a((com.google.a.i.a.h) r4, (com.google.a.c.a) r5, (com.google.a.c.a) r3, (com.google.a.i.a.j) r14)
            boolean r0 = a((int) r0, (com.google.a.i.a.j) r14, (com.google.a.i.a.f) r13)
            if (r0 != 0) goto L_0x01b7
            com.google.a.w r12 = new com.google.a.w
            java.lang.String r13 = "Data too big for requested version"
            r12.<init>((java.lang.String) r13)
            throw r12
        L_0x01a3:
            com.google.a.i.a.j r14 = com.google.a.i.a.j.b(r2)
            int r14 = a((com.google.a.i.a.h) r4, (com.google.a.c.a) r5, (com.google.a.c.a) r3, (com.google.a.i.a.j) r14)
            com.google.a.i.a.j r14 = a((int) r14, (com.google.a.i.a.f) r13)
            int r14 = a((com.google.a.i.a.h) r4, (com.google.a.c.a) r5, (com.google.a.c.a) r3, (com.google.a.i.a.j) r14)
            com.google.a.i.a.j r14 = a((int) r14, (com.google.a.i.a.f) r13)
        L_0x01b7:
            com.google.a.c.a r0 = new com.google.a.c.a
            r0.<init>()
            r0.a((com.google.a.c.a) r5)
            com.google.a.i.a.h r1 = com.google.a.i.a.h.BYTE
            if (r4 != r1) goto L_0x01c8
            int r12 = r3.a()
            goto L_0x01cc
        L_0x01c8:
            int r12 = r12.length()
        L_0x01cc:
            int r1 = r4.getCharacterCountBits(r14)
            int r5 = r2 << r1
            if (r12 < r5) goto L_0x01ef
            com.google.a.w r13 = new com.google.a.w
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r12)
            java.lang.String r12 = " is bigger than "
            r14.append(r12)
            int r5 = r5 - r2
            r14.append(r5)
            java.lang.String r12 = r14.toString()
            r13.<init>((java.lang.String) r12)
            throw r13
        L_0x01ef:
            r0.b(r12, r1)
            r0.a((com.google.a.c.a) r3)
            com.google.a.i.a.j$b r12 = r14.a((com.google.a.i.a.f) r13)
            int r1 = r14.f3310c
            int r2 = r12.b()
            int r1 = r1 - r2
            a((int) r1, (com.google.a.c.a) r0)
            int r2 = r14.f3310c
            int r12 = r12.a()
            com.google.a.c.a r12 = a((com.google.a.c.a) r0, (int) r2, (int) r1, (int) r12)
            com.google.a.i.c.f r0 = new com.google.a.i.c.f
            r0.<init>()
            r0.f3345c = r13
            r0.f3344b = r4
            r0.d = r14
            int r1 = r14.a()
            com.google.a.i.c.b r2 = new com.google.a.i.c.b
            r2.<init>(r1, r1)
            int r1 = a((com.google.a.c.a) r12, (com.google.a.i.a.f) r13, (com.google.a.i.a.j) r14, (com.google.a.i.c.b) r2)
            r0.e = r1
            com.google.a.i.c.e.a(r12, r13, r14, r1, r2)
            r0.f = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.i.c.c.a(java.lang.String, com.google.a.i.a.f, java.util.Map):com.google.a.i.c.f");
    }

    private static void a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws w {
        if (i4 >= i3) {
            throw new w("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new w("EC bytes mismatch");
        } else if (i3 != i6 + i5) {
            throw new w("RS blocks mismatch");
        } else if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
            throw new w("Total bytes mismatch");
        } else if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
        } else {
            iArr[0] = i10;
            iArr2[0] = i12;
        }
    }

    private static void a(int i, a aVar) throws w {
        int i2 = i << 3;
        if (aVar.f3055b > i2) {
            throw new w("data bits cannot fit in the QR Code" + aVar.f3055b + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && aVar.f3055b < i2; i3++) {
            aVar.a(false);
        }
        int i4 = aVar.f3055b & 7;
        if (i4 > 0) {
            while (i4 < 8) {
                aVar.a(false);
                i4++;
            }
        }
        int a2 = i - aVar.a();
        for (int i5 = 0; i5 < a2; i5++) {
            aVar.b((i5 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.f3055b != i2) {
            throw new w("Bits size does not equal capacity");
        }
    }

    private static void a(int i, j jVar, h hVar, a aVar) throws w {
        int characterCountBits = hVar.getCharacterCountBits(jVar);
        int i2 = 1 << characterCountBits;
        if (i >= i2) {
            throw new w(i + " is bigger than " + (i2 - 1));
        }
        aVar.b(i, characterCountBits);
    }

    private static void a(d dVar, a aVar) {
        aVar.b(h.ECI.getBits(), 4);
        aVar.b(dVar.getValue(), 8);
    }

    private static void a(h hVar, a aVar) {
        aVar.b(hVar.getBits(), 4);
    }

    private static void a(CharSequence charSequence, a aVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                aVar.b((charAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    aVar.b((charAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    aVar.b(charAt, 4);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d A[LOOP:0: B:4:0x0008->B:19:0x003d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0035 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r6, com.google.a.c.a r7) throws com.google.a.w {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x004d }
            int r0 = r6.length
            r1 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x004c
            byte r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            byte r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L_0x0024
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L_0x0024
        L_0x0022:
            int r2 = r2 - r3
            goto L_0x0033
        L_0x0024:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L_0x0032
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L_0x0032
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L_0x0022
        L_0x0032:
            r2 = -1
        L_0x0033:
            if (r2 != r4) goto L_0x003d
            com.google.a.w r6 = new com.google.a.w
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x003d:
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.b(r3, r2)
            int r1 = r1 + 2
            goto L_0x0008
        L_0x004c:
            return
        L_0x004d:
            r6 = move-exception
            com.google.a.w r7 = new com.google.a.w
            r7.<init>((java.lang.Throwable) r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.i.c.c.a(java.lang.String, com.google.a.c.a):void");
    }

    private static void a(String str, a aVar, String str2) throws w {
        try {
            for (byte b2 : str.getBytes(str2)) {
                aVar.b(b2, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new w((Throwable) e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[LOOP:0: B:8:0x0026->B:23:0x0059, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0051 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r5, com.google.a.i.a.h r6, com.google.a.c.a r7, java.lang.String r8) throws com.google.a.w {
        /*
            int[] r0 = com.google.a.i.c.c.AnonymousClass1.f3336a
            int r1 = r6.ordinal()
            r0 = r0[r1]
            r1 = 8
            r2 = -1
            r3 = 0
            switch(r0) {
                case 1: goto L_0x00c3;
                case 2: goto L_0x0087;
                case 3: goto L_0x0070;
                case 4: goto L_0x001f;
                default: goto L_0x000f;
            }
        L_0x000f:
            com.google.a.w r5 = new com.google.a.w
            java.lang.String r7 = "Invalid mode: "
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r6 = r7.concat(r6)
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x001f:
            java.lang.String r6 = "Shift_JIS"
            byte[] r5 = r5.getBytes(r6)     // Catch:{ UnsupportedEncodingException -> 0x0069 }
            int r6 = r5.length
        L_0x0026:
            if (r3 >= r6) goto L_0x0068
            byte r8 = r5[r3]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r0 = r3 + 1
            byte r0 = r5[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r8 = r8 << r1
            r8 = r8 | r0
            r0 = 33088(0x8140, float:4.6366E-41)
            if (r8 < r0) goto L_0x0040
            r4 = 40956(0x9ffc, float:5.7392E-41)
            if (r8 > r4) goto L_0x0040
        L_0x003e:
            int r8 = r8 - r0
            goto L_0x004f
        L_0x0040:
            r0 = 57408(0xe040, float:8.0446E-41)
            if (r8 < r0) goto L_0x004e
            r0 = 60351(0xebbf, float:8.457E-41)
            if (r8 > r0) goto L_0x004e
            r0 = 49472(0xc140, float:6.9325E-41)
            goto L_0x003e
        L_0x004e:
            r8 = -1
        L_0x004f:
            if (r8 != r2) goto L_0x0059
            com.google.a.w r5 = new com.google.a.w
            java.lang.String r6 = "Invalid byte sequence"
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0059:
            int r0 = r8 >> 8
            int r0 = r0 * 192
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r0 = r0 + r8
            r8 = 13
            r7.b(r0, r8)
            int r3 = r3 + 2
            goto L_0x0026
        L_0x0068:
            return
        L_0x0069:
            r5 = move-exception
            com.google.a.w r6 = new com.google.a.w
            r6.<init>((java.lang.Throwable) r5)
            throw r6
        L_0x0070:
            byte[] r5 = r5.getBytes(r8)     // Catch:{ UnsupportedEncodingException -> 0x0080 }
            int r6 = r5.length
        L_0x0075:
            if (r3 >= r6) goto L_0x007f
            byte r8 = r5[r3]
            r7.b(r8, r1)
            int r3 = r3 + 1
            goto L_0x0075
        L_0x007f:
            return
        L_0x0080:
            r5 = move-exception
            com.google.a.w r6 = new com.google.a.w
            r6.<init>((java.lang.Throwable) r5)
            throw r6
        L_0x0087:
            int r6 = r5.length()
        L_0x008b:
            if (r3 >= r6) goto L_0x00c2
            char r8 = r5.charAt(r3)
            int r8 = a((int) r8)
            if (r8 != r2) goto L_0x009d
            com.google.a.w r5 = new com.google.a.w
            r5.<init>()
            throw r5
        L_0x009d:
            int r0 = r3 + 1
            if (r0 >= r6) goto L_0x00bc
            char r0 = r5.charAt(r0)
            int r0 = a((int) r0)
            if (r0 != r2) goto L_0x00b1
            com.google.a.w r5 = new com.google.a.w
            r5.<init>()
            throw r5
        L_0x00b1:
            int r8 = r8 * 45
            int r8 = r8 + r0
            r0 = 11
            r7.b(r8, r0)
            int r3 = r3 + 2
            goto L_0x008b
        L_0x00bc:
            r1 = 6
            r7.b(r8, r1)
            r3 = r0
            goto L_0x008b
        L_0x00c2:
            return
        L_0x00c3:
            int r6 = r5.length()
        L_0x00c7:
            if (r3 >= r6) goto L_0x0107
            char r8 = r5.charAt(r3)
            int r8 = r8 + -48
            int r0 = r3 + 2
            if (r0 >= r6) goto L_0x00ef
            int r1 = r3 + 1
            char r1 = r5.charAt(r1)
            int r1 = r1 + -48
            char r0 = r5.charAt(r0)
            int r0 = r0 + -48
            int r8 = r8 * 100
            r2 = 10
            int r1 = r1 * 10
            int r8 = r8 + r1
            int r8 = r8 + r0
            r7.b(r8, r2)
            int r3 = r3 + 3
            goto L_0x00c7
        L_0x00ef:
            int r3 = r3 + 1
            if (r3 >= r6) goto L_0x0102
            char r1 = r5.charAt(r3)
            int r1 = r1 + -48
            int r8 = r8 * 10
            int r8 = r8 + r1
            r1 = 7
            r7.b(r8, r1)
            r3 = r0
            goto L_0x00c7
        L_0x0102:
            r0 = 4
            r7.b(r8, r0)
            goto L_0x00c7
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.i.c.c.a(java.lang.String, com.google.a.i.a.h, com.google.a.c.a, java.lang.String):void");
    }

    private static boolean a(int i, j jVar, f fVar) {
        return jVar.f3310c - jVar.a(fVar).b() >= (i + 7) / 8;
    }

    private static byte[] a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new com.google.a.c.b.d(com.google.a.c.b.a.e).a(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    private static void b(CharSequence charSequence, a aVar) throws w {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a2 = a((int) charSequence.charAt(i));
            if (a2 == -1) {
                throw new w();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int a3 = a((int) charSequence.charAt(i2));
                if (a3 == -1) {
                    throw new w();
                }
                aVar.b((a2 * 45) + a3, 11);
                i += 2;
            } else {
                aVar.b(a2, 6);
                i = i2;
            }
        }
    }

    private static boolean b(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                byte b2 = bytes[i] & 255;
                if ((b2 < 129 || b2 > 159) && (b2 < 224 || b2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }
}

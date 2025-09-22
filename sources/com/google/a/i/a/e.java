package com.google.a.i.a;

import com.google.a.c.b;
import com.google.a.c.b.a;
import com.google.a.c.b.c;
import com.google.a.d;
import com.google.a.h;
import com.google.a.i.a.j;
import java.util.Map;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final c f3303a = new c(a.e);

    private com.google.a.c.e a(b bVar) throws d, h {
        return a(bVar, (Map<com.google.a.e, ?>) null);
    }

    private com.google.a.c.e a(a aVar, Map<com.google.a.e, ?> map) throws h, d {
        int i;
        a aVar2 = aVar;
        j b2 = aVar.b();
        f fVar = aVar.a().f3305a;
        g a2 = aVar.a();
        j b3 = aVar.b();
        c cVar = c.values()[a2.f3306b];
        int i2 = aVar2.f3295a.f3062b;
        cVar.unmaskBitMatrix(aVar2.f3295a, i2);
        int a3 = b3.a();
        b bVar = new b(a3);
        bVar.a(0, 0, 9, 9);
        int i3 = a3 - 8;
        bVar.a(i3, 0, 8, 9);
        bVar.a(0, i3, 9, 8);
        int length = b3.f3309b.length;
        int i4 = 0;
        while (true) {
            i = 2;
            if (i4 >= length) {
                break;
            }
            int i5 = b3.f3309b[i4] - 2;
            for (int i6 = 0; i6 < length; i6++) {
                if (!((i4 == 0 && (i6 == 0 || i6 == length - 1)) || (i4 == length - 1 && i6 == 0))) {
                    bVar.a(b3.f3309b[i6] - 2, i5, 5, 5);
                }
            }
            i4++;
        }
        int i7 = a3 - 17;
        int i8 = 6;
        bVar.a(6, 9, 1, i7);
        bVar.a(9, 6, i7, 1);
        if (b3.f3308a > 6) {
            int i9 = a3 - 11;
            bVar.a(i9, 0, 3, 6);
            bVar.a(0, i9, 6, 3);
        }
        byte[] bArr = new byte[b3.f3310c];
        int i10 = i2 - 1;
        int i11 = i10;
        int i12 = 0;
        boolean z = true;
        int i13 = 0;
        int i14 = 0;
        while (i11 > 0) {
            if (i11 == i8) {
                i11--;
            }
            int i15 = i14;
            int i16 = i13;
            int i17 = i12;
            int i18 = 0;
            while (i18 < i2) {
                int i19 = z ? i10 - i18 : i18;
                int i20 = i16;
                int i21 = i17;
                int i22 = 0;
                while (i22 < i) {
                    int i23 = i11 - i22;
                    if (!bVar.a(i23, i19)) {
                        int i24 = i15 + 1;
                        int i25 = i20 << 1;
                        int i26 = aVar2.f3295a.a(i23, i19) ? i25 | 1 : i25;
                        if (i24 == 8) {
                            bArr[i21] = (byte) i26;
                            i21++;
                            i15 = 0;
                            i20 = 0;
                        } else {
                            i20 = i26;
                            i15 = i24;
                        }
                    }
                    i22++;
                    i = 2;
                }
                i18++;
                i17 = i21;
                i16 = i20;
                i = 2;
            }
            z = !z;
            i11 -= 2;
            i12 = i17;
            i13 = i16;
            i14 = i15;
            i8 = 6;
            i = 2;
        }
        if (i12 != b3.f3310c) {
            throw h.getFormatInstance();
        } else if (bArr.length != b2.f3310c) {
            throw new IllegalArgumentException();
        } else {
            j.b a4 = b2.a(fVar);
            j.a[] aVarArr = a4.f3314b;
            int i27 = 0;
            for (j.a aVar3 : aVarArr) {
                i27 += aVar3.f3311a;
            }
            b[] bVarArr = new b[i27];
            int length2 = aVarArr.length;
            int i28 = 0;
            int i29 = 0;
            while (i28 < length2) {
                j.a aVar4 = aVarArr[i28];
                int i30 = i29;
                int i31 = 0;
                while (i31 < aVar4.f3311a) {
                    int i32 = aVar4.f3312b;
                    bVarArr[i30] = new b(i32, new byte[(a4.f3313a + i32)]);
                    i31++;
                    i30++;
                }
                i28++;
                i29 = i30;
            }
            int length3 = bVarArr[0].f3299b.length;
            int length4 = bVarArr.length - 1;
            while (length4 >= 0 && bVarArr[length4].f3299b.length != length3) {
                length4--;
            }
            int i33 = length4 + 1;
            int i34 = length3 - a4.f3313a;
            int i35 = 0;
            int i36 = 0;
            while (i35 < i34) {
                int i37 = i36;
                int i38 = 0;
                while (i38 < i29) {
                    bVarArr[i38].f3299b[i35] = bArr[i37];
                    i38++;
                    i37++;
                }
                i35++;
                i36 = i37;
            }
            int i39 = i33;
            while (i39 < i29) {
                bVarArr[i39].f3299b[i34] = bArr[i36];
                i39++;
                i36++;
            }
            int length5 = bVarArr[0].f3299b.length;
            while (i34 < length5) {
                int i40 = i36;
                int i41 = 0;
                while (i41 < i29) {
                    bVarArr[i41].f3299b[i41 < i33 ? i34 : i34 + 1] = bArr[i40];
                    i41++;
                    i40++;
                }
                i34++;
                i36 = i40;
            }
            int i42 = 0;
            for (b bVar2 : bVarArr) {
                i42 += bVar2.f3298a;
            }
            byte[] bArr2 = new byte[i42];
            int length6 = bVarArr.length;
            int i43 = 0;
            int i44 = 0;
            while (i43 < length6) {
                b bVar3 = bVarArr[i43];
                byte[] bArr3 = bVar3.f3299b;
                int i45 = bVar3.f3298a;
                a(bArr3, i45);
                int i46 = i44;
                int i47 = 0;
                while (i47 < i45) {
                    bArr2[i46] = bArr3[i47];
                    i47++;
                    i46++;
                }
                i43++;
                i44 = i46;
            }
            return d.a(bArr2, b2, fVar, map);
        }
    }

    private com.google.a.c.e a(boolean[][] zArr) throws d, h {
        return a(b.a(zArr), (Map<com.google.a.e, ?>) null);
    }

    private void a(byte[] bArr, int i) throws d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f3303a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (com.google.a.c.b.e unused) {
            throw d.getChecksumInstance();
        }
    }

    private com.google.a.c.e b(boolean[][] zArr) throws d, h {
        return a(b.a(zArr), (Map<com.google.a.e, ?>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0015 A[Catch:{ d | h -> 0x006e }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c A[Catch:{ d | h -> 0x006e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.c.e a(com.google.a.c.b r8, java.util.Map<com.google.a.e, ?> r9) throws com.google.a.h, com.google.a.d {
        /*
            r7 = this;
            com.google.a.i.a.a r0 = new com.google.a.i.a.a
            r0.<init>(r8)
            r8 = 0
            com.google.a.c.e r1 = r7.a((com.google.a.i.a.a) r0, (java.util.Map<com.google.a.e, ?>) r9)     // Catch:{ h -> 0x000f, d -> 0x000b }
            return r1
        L_0x000b:
            r1 = move-exception
            r2 = r1
            r1 = r8
            goto L_0x0011
        L_0x000f:
            r1 = move-exception
            r2 = r8
        L_0x0011:
            com.google.a.i.a.g r3 = r0.f3297c     // Catch:{ d | h -> 0x006e }
            if (r3 == 0) goto L_0x0028
            com.google.a.i.a.c[] r3 = com.google.a.i.a.c.values()     // Catch:{ d | h -> 0x006e }
            com.google.a.i.a.g r4 = r0.f3297c     // Catch:{ d | h -> 0x006e }
            byte r4 = r4.f3306b     // Catch:{ d | h -> 0x006e }
            r3 = r3[r4]     // Catch:{ d | h -> 0x006e }
            com.google.a.c.b r4 = r0.f3295a     // Catch:{ d | h -> 0x006e }
            int r4 = r4.f3062b     // Catch:{ d | h -> 0x006e }
            com.google.a.c.b r5 = r0.f3295a     // Catch:{ d | h -> 0x006e }
            r3.unmaskBitMatrix(r5, r4)     // Catch:{ d | h -> 0x006e }
        L_0x0028:
            r0.f3296b = r8     // Catch:{ d | h -> 0x006e }
            r0.f3297c = r8     // Catch:{ d | h -> 0x006e }
            r8 = 1
            r0.d = r8     // Catch:{ d | h -> 0x006e }
            r0.b()     // Catch:{ d | h -> 0x006e }
            r0.a()     // Catch:{ d | h -> 0x006e }
            r8 = 0
        L_0x0036:
            com.google.a.c.b r3 = r0.f3295a     // Catch:{ d | h -> 0x006e }
            int r3 = r3.f3061a     // Catch:{ d | h -> 0x006e }
            if (r8 >= r3) goto L_0x0062
            int r3 = r8 + 1
            r4 = r3
        L_0x003f:
            com.google.a.c.b r5 = r0.f3295a     // Catch:{ d | h -> 0x006e }
            int r5 = r5.f3062b     // Catch:{ d | h -> 0x006e }
            if (r4 >= r5) goto L_0x0060
            com.google.a.c.b r5 = r0.f3295a     // Catch:{ d | h -> 0x006e }
            boolean r5 = r5.a((int) r8, (int) r4)     // Catch:{ d | h -> 0x006e }
            com.google.a.c.b r6 = r0.f3295a     // Catch:{ d | h -> 0x006e }
            boolean r6 = r6.a((int) r4, (int) r8)     // Catch:{ d | h -> 0x006e }
            if (r5 == r6) goto L_0x005d
            com.google.a.c.b r5 = r0.f3295a     // Catch:{ d | h -> 0x006e }
            r5.c(r4, r8)     // Catch:{ d | h -> 0x006e }
            com.google.a.c.b r5 = r0.f3295a     // Catch:{ d | h -> 0x006e }
            r5.c(r8, r4)     // Catch:{ d | h -> 0x006e }
        L_0x005d:
            int r4 = r4 + 1
            goto L_0x003f
        L_0x0060:
            r8 = r3
            goto L_0x0036
        L_0x0062:
            com.google.a.c.e r8 = r7.a((com.google.a.i.a.a) r0, (java.util.Map<com.google.a.e, ?>) r9)     // Catch:{ d | h -> 0x006e }
            com.google.a.i.a.i r9 = new com.google.a.i.a.i     // Catch:{ d | h -> 0x006e }
            r9.<init>()     // Catch:{ d | h -> 0x006e }
            r8.h = r9     // Catch:{ d | h -> 0x006e }
            return r8
        L_0x006e:
            if (r1 == 0) goto L_0x0071
            throw r1
        L_0x0071:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.i.a.e.a(com.google.a.c.b, java.util.Map):com.google.a.c.e");
    }
}

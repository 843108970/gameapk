package com.google.a.i.c;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3337a = 3;

    /* renamed from: b  reason: collision with root package name */
    private static final int f3338b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3339c = 40;
    private static final int d = 10;

    private d() {
    }

    private static int a(b bVar) {
        return a(bVar, true) + a(bVar, false);
    }

    static int a(b bVar, boolean z) {
        int i = z ? bVar.f3333c : bVar.f3332b;
        int i2 = z ? bVar.f3332b : bVar.f3333c;
        byte[][] bArr = bVar.f3331a;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3;
            int i6 = 0;
            byte b2 = -1;
            for (int i7 = 0; i7 < i2; i7++) {
                byte b3 = z ? bArr[i4][i7] : bArr[i7][i4];
                if (b3 == b2) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i5 += (i6 - 5) + 3;
                    }
                    i6 = 1;
                    b2 = b3;
                }
            }
            if (i6 >= 5) {
                i5 += (i6 - 5) + 3;
            }
            i3 = i5;
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        r3 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        r1 = r3 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r1 != 0) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r1 = r1 & 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L_0x003a;
                case 1: goto L_0x003b;
                case 2: goto L_0x0037;
                case 3: goto L_0x0033;
                case 4: goto L_0x002e;
                case 5: goto L_0x0026;
                case 6: goto L_0x001d;
                case 7: goto L_0x0014;
                default: goto L_0x0004;
            }
        L_0x0004:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Invalid mask pattern: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L_0x0014:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L_0x0024
        L_0x001d:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L_0x0024:
            r1 = r1 & r0
            goto L_0x003d
        L_0x0026:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L_0x003d
        L_0x002e:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L_0x003a
        L_0x0033:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L_0x003d
        L_0x0037:
            int r1 = r2 % 3
            goto L_0x003d
        L_0x003a:
            int r3 = r3 + r2
        L_0x003b:
            r1 = r3 & 1
        L_0x003d:
            if (r1 != 0) goto L_0x0040
            return r0
        L_0x0040:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.i.c.d.a(int, int, int):boolean");
    }

    static boolean a(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, bArr.length);
        for (int max = Math.max(i, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    static boolean a(byte[][] bArr, int i, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max][i] == 1) {
                return false;
            }
        }
        return true;
    }

    private static int b(b bVar) {
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
        return i4 * 3;
    }

    private static int c(b bVar) {
        byte[][] bArr = bVar.f3331a;
        int i = bVar.f3332b;
        int i2 = bVar.f3333c;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i4;
            for (int i6 = 0; i6 < i; i6++) {
                byte[] bArr2 = bArr[i3];
                int i7 = i6 + 6;
                if (i7 < i && bArr2[i6] == 1 && bArr2[i6 + 1] == 0 && bArr2[i6 + 2] == 1 && bArr2[i6 + 3] == 1 && bArr2[i6 + 4] == 1 && bArr2[i6 + 5] == 0 && bArr2[i7] == 1 && (a(bArr2, i6 - 4, i6) || a(bArr2, i6 + 7, i6 + 11))) {
                    i5++;
                }
                int i8 = i3 + 6;
                if (i8 < i2 && bArr[i3][i6] == 1 && bArr[i3 + 1][i6] == 0 && bArr[i3 + 2][i6] == 1 && bArr[i3 + 3][i6] == 1 && bArr[i3 + 4][i6] == 1 && bArr[i3 + 5][i6] == 0 && bArr[i8][i6] == 1 && (a(bArr, i6, i3 - 4, i3) || a(bArr, i6, i3 + 7, i3 + 11))) {
                    i5++;
                }
            }
            i3++;
            i4 = i5;
        }
        return i4 * 40;
    }

    private static int d(b bVar) {
        byte[][] bArr = bVar.f3331a;
        int i = bVar.f3332b;
        int i2 = bVar.f3333c;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            byte[] bArr2 = bArr[i3];
            int i5 = i4;
            for (int i6 = 0; i6 < i; i6++) {
                if (bArr2[i6] == 1) {
                    i5++;
                }
            }
            i3++;
            i4 = i5;
        }
        int i7 = bVar.f3333c * bVar.f3332b;
        return ((Math.abs((i4 << 1) - i7) * 10) / i7) * 10;
    }
}

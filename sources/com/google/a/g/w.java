package com.google.a.g;

import com.google.a.c.a;
import com.google.a.m;

final class w {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f3223a = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* renamed from: b  reason: collision with root package name */
    final int[] f3224b = new int[4];

    /* renamed from: c  reason: collision with root package name */
    final StringBuilder f3225c = new StringBuilder();

    w() {
    }

    private static int a(int i) throws m {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f3223a[i2]) {
                return i2;
            }
        }
        throw m.getNotFoundInstance();
    }

    private int a(a aVar, int[] iArr, StringBuilder sb) throws m {
        int[] iArr2 = this.f3224b;
        int i = 0;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = aVar.f3055b;
        int i3 = iArr[1];
        int i4 = 0;
        int i5 = 0;
        while (i4 < 5 && i3 < i2) {
            int a2 = y.a(aVar, iArr2, i3, y.f);
            sb.append((char) ((a2 % 10) + 48));
            int i6 = i3;
            for (int i7 : iArr2) {
                i6 += i7;
            }
            if (a2 >= 10) {
                i5 |= 1 << (4 - i4);
            }
            i3 = i4 != 4 ? aVar.d(aVar.c(i6)) : i6;
            i4++;
        }
        if (sb.length() != 5) {
            throw m.getNotFoundInstance();
        }
        for (int i8 = 0; i8 < 10; i8++) {
            if (i5 == f3223a[i8]) {
                String sb2 = sb.toString();
                int length = sb2.length();
                for (int i9 = length - 2; i9 >= 0; i9 -= 2) {
                    i += sb2.charAt(i9) - '0';
                }
                int i10 = i * 3;
                for (int i11 = length - 1; i11 >= 0; i11 -= 2) {
                    i10 += sb2.charAt(i11) - '0';
                }
                if ((i10 * 3) % 10 == i8) {
                    return i3;
                }
                throw m.getNotFoundInstance();
            }
        }
        throw m.getNotFoundInstance();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            i += charSequence.charAt(i2) - '0';
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            i3 += charSequence.charAt(i4) - '0';
        }
        return (i3 * 3) % 10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0164  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.a.r a(int r19, com.google.a.c.a r20, int[] r21) throws com.google.a.m {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            java.lang.StringBuilder r3 = r0.f3225c
            r4 = 0
            r3.setLength(r4)
            int[] r5 = r0.f3224b
            r5[r4] = r4
            r6 = 1
            r5[r6] = r4
            r7 = 2
            r5[r7] = r4
            r8 = 3
            r5[r8] = r4
            int r9 = r1.f3055b
            r10 = r21[r6]
            r11 = r10
            r10 = 0
            r12 = 0
        L_0x001e:
            r13 = 5
            r14 = 48
            r15 = 10
            if (r10 >= r13) goto L_0x0058
            if (r11 >= r9) goto L_0x0058
            int[][] r13 = com.google.a.g.y.f
            int r13 = com.google.a.g.y.a((com.google.a.c.a) r1, (int[]) r5, (int) r11, (int[][]) r13)
            int r16 = r13 % 10
            int r14 = r16 + 48
            char r14 = (char) r14
            r3.append(r14)
            int r14 = r5.length
            r7 = r11
            r11 = 0
        L_0x0038:
            if (r11 >= r14) goto L_0x0041
            r16 = r5[r11]
            int r7 = r7 + r16
            int r11 = r11 + 1
            goto L_0x0038
        L_0x0041:
            r11 = 4
            if (r13 < r15) goto L_0x0049
            int r13 = 4 - r10
            int r13 = r6 << r13
            r12 = r12 | r13
        L_0x0049:
            if (r10 == r11) goto L_0x0053
            int r7 = r1.c(r7)
            int r7 = r1.d(r7)
        L_0x0053:
            r11 = r7
            int r10 = r10 + 1
            r7 = 2
            goto L_0x001e
        L_0x0058:
            int r1 = r3.length()
            if (r1 == r13) goto L_0x0063
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0063:
            r1 = 0
        L_0x0064:
            if (r1 >= r15) goto L_0x016f
            int[] r5 = f3223a
            r5 = r5[r1]
            if (r12 != r5) goto L_0x0168
            java.lang.String r5 = r3.toString()
            int r7 = r5.length()
            int r9 = r7 + -2
            r10 = 0
        L_0x0077:
            if (r9 < 0) goto L_0x0082
            char r12 = r5.charAt(r9)
            int r12 = r12 - r14
            int r10 = r10 + r12
            int r9 = r9 + -2
            goto L_0x0077
        L_0x0082:
            int r10 = r10 * 3
            int r7 = r7 - r6
        L_0x0085:
            if (r7 < 0) goto L_0x0090
            char r9 = r5.charAt(r7)
            int r9 = r9 - r14
            int r10 = r10 + r9
            int r7 = r7 + -2
            goto L_0x0085
        L_0x0090:
            int r10 = r10 * 3
            int r10 = r10 % r15
            if (r10 == r1) goto L_0x009a
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x009a:
            java.lang.String r1 = r3.toString()
            int r3 = r1.length()
            r5 = 0
            if (r3 == r13) goto L_0x00a8
        L_0x00a5:
            r7 = r5
            goto L_0x013d
        L_0x00a8:
            char r3 = r1.charAt(r4)
            if (r3 == r14) goto L_0x00f3
            r7 = 53
            if (r3 == r7) goto L_0x00f0
            r7 = 57
            if (r3 == r7) goto L_0x00b9
        L_0x00b6:
            java.lang.String r3 = ""
            goto L_0x00f5
        L_0x00b9:
            r3 = -1
            int r7 = r1.hashCode()
            r8 = 54118329(0x339c7b9, float:5.4595884E-37)
            if (r7 == r8) goto L_0x00db
            switch(r7) {
                case 54395376: goto L_0x00d1;
                case 54395377: goto L_0x00c7;
                default: goto L_0x00c6;
            }
        L_0x00c6:
            goto L_0x00e4
        L_0x00c7:
            java.lang.String r7 = "99991"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x00e4
            r3 = 1
            goto L_0x00e4
        L_0x00d1:
            java.lang.String r7 = "99990"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x00e4
            r3 = 2
            goto L_0x00e4
        L_0x00db:
            java.lang.String r7 = "90000"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x00e4
            r3 = 0
        L_0x00e4:
            switch(r3) {
                case 0: goto L_0x00ee;
                case 1: goto L_0x00eb;
                case 2: goto L_0x00e8;
                default: goto L_0x00e7;
            }
        L_0x00e7:
            goto L_0x00b6
        L_0x00e8:
            java.lang.String r3 = "Used"
            goto L_0x012d
        L_0x00eb:
            java.lang.String r3 = "0.00"
            goto L_0x012d
        L_0x00ee:
            r3 = r5
            goto L_0x012d
        L_0x00f0:
            java.lang.String r3 = "$"
            goto L_0x00f5
        L_0x00f3:
            java.lang.String r3 = "£"
        L_0x00f5:
            java.lang.String r7 = r1.substring(r6)
            int r7 = java.lang.Integer.parseInt(r7)
            int r8 = r7 / 100
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r7 = r7 % 100
            if (r7 >= r15) goto L_0x0112
            java.lang.String r9 = "0"
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r7 = r9.concat(r7)
            goto L_0x0116
        L_0x0112:
            java.lang.String r7 = java.lang.String.valueOf(r7)
        L_0x0116:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r3)
            r9.append(r8)
            r3 = 46
            r9.append(r3)
            r9.append(r7)
            java.lang.String r3 = r9.toString()
        L_0x012d:
            if (r3 != 0) goto L_0x0131
            goto L_0x00a5
        L_0x0131:
            java.util.EnumMap r7 = new java.util.EnumMap
            java.lang.Class<com.google.a.s> r8 = com.google.a.s.class
            r7.<init>(r8)
            com.google.a.s r8 = com.google.a.s.SUGGESTED_PRICE
            r7.put(r8, r3)
        L_0x013d:
            com.google.a.r r3 = new com.google.a.r
            r9 = 2
            com.google.a.t[] r8 = new com.google.a.t[r9]
            com.google.a.t r9 = new com.google.a.t
            r10 = r21[r4]
            r2 = r21[r6]
            int r10 = r10 + r2
            float r2 = (float) r10
            r10 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r10
            r10 = r19
            float r10 = (float) r10
            r9.<init>(r2, r10)
            r8[r4] = r9
            com.google.a.t r2 = new com.google.a.t
            float r4 = (float) r11
            r2.<init>(r4, r10)
            r8[r6] = r2
            com.google.a.a r2 = com.google.a.a.UPC_EAN_EXTENSION
            r3.<init>(r1, r5, r8, r2)
            if (r7 == 0) goto L_0x0167
            r3.a((java.util.Map<com.google.a.s, java.lang.Object>) r7)
        L_0x0167:
            return r3
        L_0x0168:
            r10 = r19
            r9 = 2
            int r1 = r1 + 1
            goto L_0x0064
        L_0x016f:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.w.a(int, com.google.a.c.a, int[]):com.google.a.r");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r6.equals("90000") != false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<com.google.a.s, java.lang.Object> a(java.lang.String r6) {
        /*
            int r0 = r6.length()
            r1 = 0
            r2 = 5
            if (r0 == r2) goto L_0x0009
            return r1
        L_0x0009:
            r0 = 0
            char r2 = r6.charAt(r0)
            r3 = 48
            r4 = 1
            if (r2 == r3) goto L_0x0059
            r3 = 53
            if (r2 == r3) goto L_0x0056
            r3 = 57
            if (r2 == r3) goto L_0x001e
        L_0x001b:
            java.lang.String r0 = ""
            goto L_0x005b
        L_0x001e:
            r2 = -1
            int r3 = r6.hashCode()
            r5 = 54118329(0x339c7b9, float:5.4595884E-37)
            if (r3 == r5) goto L_0x0040
            switch(r3) {
                case 54395376: goto L_0x0036;
                case 54395377: goto L_0x002c;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x0049
        L_0x002c:
            java.lang.String r0 = "99991"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0049
            r0 = 1
            goto L_0x004a
        L_0x0036:
            java.lang.String r0 = "99990"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0049
            r0 = 2
            goto L_0x004a
        L_0x0040:
            java.lang.String r3 = "90000"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r0 = -1
        L_0x004a:
            switch(r0) {
                case 0: goto L_0x0054;
                case 1: goto L_0x0051;
                case 2: goto L_0x004e;
                default: goto L_0x004d;
            }
        L_0x004d:
            goto L_0x001b
        L_0x004e:
            java.lang.String r6 = "Used"
            goto L_0x0095
        L_0x0051:
            java.lang.String r6 = "0.00"
            goto L_0x0095
        L_0x0054:
            r6 = r1
            goto L_0x0095
        L_0x0056:
            java.lang.String r0 = "$"
            goto L_0x005b
        L_0x0059:
            java.lang.String r0 = "£"
        L_0x005b:
            java.lang.String r6 = r6.substring(r4)
            int r6 = java.lang.Integer.parseInt(r6)
            int r2 = r6 / 100
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r6 = r6 % 100
            r3 = 10
            if (r6 >= r3) goto L_0x007a
            java.lang.String r3 = "0"
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r6 = r3.concat(r6)
            goto L_0x007e
        L_0x007a:
            java.lang.String r6 = java.lang.String.valueOf(r6)
        L_0x007e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r2)
            r0 = 46
            r3.append(r0)
            r3.append(r6)
            java.lang.String r6 = r3.toString()
        L_0x0095:
            if (r6 != 0) goto L_0x0098
            return r1
        L_0x0098:
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.a.s> r1 = com.google.a.s.class
            r0.<init>(r1)
            com.google.a.s r1 = com.google.a.s.SUGGESTED_PRICE
            r0.put(r1, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.w.a(java.lang.String):java.util.Map");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r5.equals("90000") != false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r5) {
        /*
            r0 = 0
            char r1 = r5.charAt(r0)
            r2 = 48
            r3 = 1
            if (r1 == r2) goto L_0x0050
            r2 = 53
            if (r1 == r2) goto L_0x004d
            r2 = 57
            if (r1 == r2) goto L_0x0015
        L_0x0012:
            java.lang.String r0 = ""
            goto L_0x0052
        L_0x0015:
            r1 = -1
            int r2 = r5.hashCode()
            r4 = 54118329(0x339c7b9, float:5.4595884E-37)
            if (r2 == r4) goto L_0x0037
            switch(r2) {
                case 54395376: goto L_0x002d;
                case 54395377: goto L_0x0023;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x0040
        L_0x0023:
            java.lang.String r0 = "99991"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0040
            r0 = 1
            goto L_0x0041
        L_0x002d:
            java.lang.String r0 = "99990"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0040
            r0 = 2
            goto L_0x0041
        L_0x0037:
            java.lang.String r2 = "90000"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r0 = -1
        L_0x0041:
            switch(r0) {
                case 0: goto L_0x004b;
                case 1: goto L_0x0048;
                case 2: goto L_0x0045;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x0012
        L_0x0045:
            java.lang.String r5 = "Used"
            return r5
        L_0x0048:
            java.lang.String r5 = "0.00"
            return r5
        L_0x004b:
            r5 = 0
            return r5
        L_0x004d:
            java.lang.String r0 = "$"
            goto L_0x0052
        L_0x0050:
            java.lang.String r0 = "£"
        L_0x0052:
            java.lang.String r5 = r5.substring(r3)
            int r5 = java.lang.Integer.parseInt(r5)
            int r1 = r5 / 100
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r5 = r5 % 100
            r2 = 10
            if (r5 >= r2) goto L_0x0071
            java.lang.String r2 = "0"
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r5 = r2.concat(r5)
            goto L_0x0075
        L_0x0071:
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L_0x0075:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r1)
            r0 = 46
            r2.append(r0)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.w.b(java.lang.String):java.lang.String");
    }
}

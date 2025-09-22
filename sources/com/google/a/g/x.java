package com.google.a.g;

final class x {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3226a = {1, 1, 2};

    /* renamed from: b  reason: collision with root package name */
    private final v f3227b = new v();

    /* renamed from: c  reason: collision with root package name */
    private final w f3228c = new w();

    x() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0174 A[Catch:{ q -> 0x0183 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.r a(int r19, com.google.a.c.a r20, int r21) throws com.google.a.m {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            int[] r3 = f3226a
            r4 = 0
            r5 = r21
            int[] r3 = com.google.a.g.y.a((com.google.a.c.a) r2, (int) r5, (boolean) r4, (int[]) r3)
            com.google.a.g.w r5 = r0.f3228c     // Catch:{ q -> 0x0183 }
            java.lang.StringBuilder r6 = r5.f3225c     // Catch:{ q -> 0x0183 }
            r6.setLength(r4)     // Catch:{ q -> 0x0183 }
            int[] r5 = r5.f3224b     // Catch:{ q -> 0x0183 }
            r5[r4] = r4     // Catch:{ q -> 0x0183 }
            r7 = 1
            r5[r7] = r4     // Catch:{ q -> 0x0183 }
            r8 = 2
            r5[r8] = r4     // Catch:{ q -> 0x0183 }
            r9 = 3
            r5[r9] = r4     // Catch:{ q -> 0x0183 }
            int r10 = r2.f3055b     // Catch:{ q -> 0x0183 }
            r11 = r3[r7]     // Catch:{ q -> 0x0183 }
            r12 = r11
            r11 = 0
            r13 = 0
        L_0x002a:
            r14 = 5
            r15 = 48
            r8 = 10
            if (r11 >= r14) goto L_0x0066
            if (r12 >= r10) goto L_0x0066
            int[][] r14 = com.google.a.g.y.f     // Catch:{ q -> 0x0183 }
            int r14 = com.google.a.g.y.a((com.google.a.c.a) r2, (int[]) r5, (int) r12, (int[][]) r14)     // Catch:{ q -> 0x0183 }
            int r16 = r14 % 10
            int r15 = r16 + 48
            char r15 = (char) r15     // Catch:{ q -> 0x0183 }
            r6.append(r15)     // Catch:{ q -> 0x0183 }
            int r15 = r5.length     // Catch:{ q -> 0x0183 }
            r4 = r12
            r12 = 0
        L_0x0044:
            if (r12 >= r15) goto L_0x004d
            r16 = r5[r12]     // Catch:{ q -> 0x0183 }
            int r4 = r4 + r16
            int r12 = r12 + 1
            goto L_0x0044
        L_0x004d:
            r12 = 4
            if (r14 < r8) goto L_0x0056
            int r8 = 4 - r11
            int r8 = r7 << r8
            r8 = r8 | r13
            r13 = r8
        L_0x0056:
            if (r11 == r12) goto L_0x0060
            int r4 = r2.c(r4)     // Catch:{ q -> 0x0183 }
            int r4 = r2.d(r4)     // Catch:{ q -> 0x0183 }
        L_0x0060:
            r12 = r4
            int r11 = r11 + 1
            r4 = 0
            r8 = 2
            goto L_0x002a
        L_0x0066:
            int r4 = r6.length()     // Catch:{ q -> 0x0183 }
            if (r4 == r14) goto L_0x0071
            com.google.a.m r4 = com.google.a.m.getNotFoundInstance()     // Catch:{ q -> 0x0183 }
            throw r4     // Catch:{ q -> 0x0183 }
        L_0x0071:
            r4 = 0
        L_0x0072:
            if (r4 >= r8) goto L_0x017e
            int[] r5 = com.google.a.g.w.f3223a     // Catch:{ q -> 0x0183 }
            r5 = r5[r4]     // Catch:{ q -> 0x0183 }
            if (r13 != r5) goto L_0x0178
            java.lang.String r5 = r6.toString()     // Catch:{ q -> 0x0183 }
            int r10 = r5.length()     // Catch:{ q -> 0x0183 }
            int r11 = r10 + -2
            r13 = 0
        L_0x0085:
            if (r11 < 0) goto L_0x0092
            char r16 = r5.charAt(r11)     // Catch:{ q -> 0x0183 }
            int r16 = r16 + -48
            int r13 = r13 + r16
            int r11 = r11 + -2
            goto L_0x0085
        L_0x0092:
            int r13 = r13 * 3
            int r10 = r10 - r7
        L_0x0095:
            if (r10 < 0) goto L_0x00a0
            char r11 = r5.charAt(r10)     // Catch:{ q -> 0x0183 }
            int r11 = r11 - r15
            int r13 = r13 + r11
            int r10 = r10 + -2
            goto L_0x0095
        L_0x00a0:
            int r13 = r13 * 3
            int r13 = r13 % r8
            if (r13 == r4) goto L_0x00aa
            com.google.a.m r4 = com.google.a.m.getNotFoundInstance()     // Catch:{ q -> 0x0183 }
            throw r4     // Catch:{ q -> 0x0183 }
        L_0x00aa:
            java.lang.String r4 = r6.toString()     // Catch:{ q -> 0x0183 }
            int r5 = r4.length()     // Catch:{ q -> 0x0183 }
            r6 = 0
            if (r5 == r14) goto L_0x00b8
        L_0x00b5:
            r8 = r6
            goto L_0x014e
        L_0x00b8:
            r5 = 0
            char r9 = r4.charAt(r5)     // Catch:{ q -> 0x0183 }
            if (r9 == r15) goto L_0x0104
            r5 = 53
            if (r9 == r5) goto L_0x0101
            r5 = 57
            if (r9 == r5) goto L_0x00ca
        L_0x00c7:
            java.lang.String r5 = ""
            goto L_0x0106
        L_0x00ca:
            r5 = -1
            int r9 = r4.hashCode()     // Catch:{ q -> 0x0183 }
            r10 = 54118329(0x339c7b9, float:5.4595884E-37)
            if (r9 == r10) goto L_0x00ec
            switch(r9) {
                case 54395376: goto L_0x00e2;
                case 54395377: goto L_0x00d8;
                default: goto L_0x00d7;
            }     // Catch:{ q -> 0x0183 }
        L_0x00d7:
            goto L_0x00f5
        L_0x00d8:
            java.lang.String r9 = "99991"
            boolean r9 = r4.equals(r9)     // Catch:{ q -> 0x0183 }
            if (r9 == 0) goto L_0x00f5
            r5 = 1
            goto L_0x00f5
        L_0x00e2:
            java.lang.String r9 = "99990"
            boolean r9 = r4.equals(r9)     // Catch:{ q -> 0x0183 }
            if (r9 == 0) goto L_0x00f5
            r5 = 2
            goto L_0x00f5
        L_0x00ec:
            java.lang.String r9 = "90000"
            boolean r9 = r4.equals(r9)     // Catch:{ q -> 0x0183 }
            if (r9 == 0) goto L_0x00f5
            r5 = 0
        L_0x00f5:
            switch(r5) {
                case 0: goto L_0x00ff;
                case 1: goto L_0x00fc;
                case 2: goto L_0x00f9;
                default: goto L_0x00f8;
            }     // Catch:{ q -> 0x0183 }
        L_0x00f8:
            goto L_0x00c7
        L_0x00f9:
            java.lang.String r5 = "Used"
            goto L_0x013e
        L_0x00fc:
            java.lang.String r5 = "0.00"
            goto L_0x013e
        L_0x00ff:
            r5 = r6
            goto L_0x013e
        L_0x0101:
            java.lang.String r5 = "$"
            goto L_0x0106
        L_0x0104:
            java.lang.String r5 = "£"
        L_0x0106:
            java.lang.String r9 = r4.substring(r7)     // Catch:{ q -> 0x0183 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ q -> 0x0183 }
            int r10 = r9 / 100
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ q -> 0x0183 }
            int r9 = r9 % 100
            if (r9 >= r8) goto L_0x0123
            java.lang.String r8 = "0"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ q -> 0x0183 }
            java.lang.String r8 = r8.concat(r9)     // Catch:{ q -> 0x0183 }
            goto L_0x0127
        L_0x0123:
            java.lang.String r8 = java.lang.String.valueOf(r9)     // Catch:{ q -> 0x0183 }
        L_0x0127:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ q -> 0x0183 }
            r9.<init>()     // Catch:{ q -> 0x0183 }
            r9.append(r5)     // Catch:{ q -> 0x0183 }
            r9.append(r10)     // Catch:{ q -> 0x0183 }
            r5 = 46
            r9.append(r5)     // Catch:{ q -> 0x0183 }
            r9.append(r8)     // Catch:{ q -> 0x0183 }
            java.lang.String r5 = r9.toString()     // Catch:{ q -> 0x0183 }
        L_0x013e:
            if (r5 != 0) goto L_0x0142
            goto L_0x00b5
        L_0x0142:
            java.util.EnumMap r8 = new java.util.EnumMap     // Catch:{ q -> 0x0183 }
            java.lang.Class<com.google.a.s> r9 = com.google.a.s.class
            r8.<init>(r9)     // Catch:{ q -> 0x0183 }
            com.google.a.s r9 = com.google.a.s.SUGGESTED_PRICE     // Catch:{ q -> 0x0183 }
            r8.put(r9, r5)     // Catch:{ q -> 0x0183 }
        L_0x014e:
            com.google.a.r r5 = new com.google.a.r     // Catch:{ q -> 0x0183 }
            r10 = 2
            com.google.a.t[] r9 = new com.google.a.t[r10]     // Catch:{ q -> 0x0183 }
            com.google.a.t r10 = new com.google.a.t     // Catch:{ q -> 0x0183 }
            r11 = 0
            r13 = r3[r11]     // Catch:{ q -> 0x0183 }
            r14 = r3[r7]     // Catch:{ q -> 0x0183 }
            int r13 = r13 + r14
            float r13 = (float) r13     // Catch:{ q -> 0x0183 }
            r14 = 1073741824(0x40000000, float:2.0)
            float r13 = r13 / r14
            float r14 = (float) r1     // Catch:{ q -> 0x0183 }
            r10.<init>(r13, r14)     // Catch:{ q -> 0x0183 }
            r9[r11] = r10     // Catch:{ q -> 0x0183 }
            com.google.a.t r10 = new com.google.a.t     // Catch:{ q -> 0x0183 }
            float r11 = (float) r12     // Catch:{ q -> 0x0183 }
            r10.<init>(r11, r14)     // Catch:{ q -> 0x0183 }
            r9[r7] = r10     // Catch:{ q -> 0x0183 }
            com.google.a.a r7 = com.google.a.a.UPC_EAN_EXTENSION     // Catch:{ q -> 0x0183 }
            r5.<init>(r4, r6, r9, r7)     // Catch:{ q -> 0x0183 }
            if (r8 == 0) goto L_0x0177
            r5.a((java.util.Map<com.google.a.s, java.lang.Object>) r8)     // Catch:{ q -> 0x0183 }
        L_0x0177:
            return r5
        L_0x0178:
            r10 = 2
            r11 = 0
            int r4 = r4 + 1
            goto L_0x0072
        L_0x017e:
            com.google.a.m r4 = com.google.a.m.getNotFoundInstance()     // Catch:{ q -> 0x0183 }
            throw r4     // Catch:{ q -> 0x0183 }
        L_0x0183:
            com.google.a.g.v r4 = r0.f3227b
            com.google.a.r r1 = r4.a((int) r1, (com.google.a.c.a) r2, (int[]) r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.x.a(int, com.google.a.c.a, int):com.google.a.r");
    }
}

package com.google.a.b.a;

public final class l extends u {
    private static String a(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        String substring = str.substring(i + 1);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == ')') {
                return sb.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static String b(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == '(') {
                if (a(i2, substring) != null) {
                    break;
                }
                sb.append('(');
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x020b, code lost:
        r3 = r2;
        r2 = r21;
        r15 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x023c, code lost:
        r15 = r4.substring(3);
        r13 = r1;
        r3 = r2;
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0253, code lost:
        r2 = r21;
        r15 = r22;
        r3 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0252  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.a.b.a.k c(com.google.a.r r24) {
        /*
            r0 = r24
            com.google.a.a r1 = r0.e
            com.google.a.a r2 = com.google.a.a.RSS_EXPANDED
            r3 = 0
            if (r1 == r2) goto L_0x000a
            return r3
        L_0x000a:
            java.lang.String r5 = b((com.google.a.r) r24)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r6 = r3
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r18 = r17
            r2 = 0
        L_0x0024:
            int r4 = r5.length()
            if (r2 >= r4) goto L_0x025a
            java.lang.String r4 = a(r2, r5)
            if (r4 != 0) goto L_0x0031
            return r3
        L_0x0031:
            int r19 = r4.length()
            r20 = 2
            int r19 = r19 + 2
            int r2 = r2 + r19
            java.lang.String r1 = b(r2, r5)
            int r19 = r1.length()
            int r2 = r2 + r19
            r19 = -1
            int r3 = r4.hashCode()
            r21 = r2
            r2 = 1570(0x622, float:2.2E-42)
            r22 = r15
            r15 = 3
            if (r3 == r2) goto L_0x01f8
            r2 = 1572(0x624, float:2.203E-42)
            if (r3 == r2) goto L_0x01ee
            r2 = 1574(0x626, float:2.206E-42)
            if (r3 == r2) goto L_0x01e4
            switch(r3) {
                case 1536: goto L_0x01da;
                case 1537: goto L_0x01d0;
                default: goto L_0x005f;
            }
        L_0x005f:
            switch(r3) {
                case 1567: goto L_0x01c6;
                case 1568: goto L_0x01bc;
                default: goto L_0x0062;
            }
        L_0x0062:
            switch(r3) {
                case 1567966: goto L_0x01b2;
                case 1567967: goto L_0x01a7;
                case 1567968: goto L_0x019c;
                case 1567969: goto L_0x0190;
                case 1567970: goto L_0x0184;
                case 1567971: goto L_0x0178;
                case 1567972: goto L_0x016c;
                case 1567973: goto L_0x0160;
                case 1567974: goto L_0x0154;
                case 1567975: goto L_0x0148;
                default: goto L_0x0065;
            }
        L_0x0065:
            switch(r3) {
                case 1568927: goto L_0x013c;
                case 1568928: goto L_0x0130;
                case 1568929: goto L_0x0124;
                case 1568930: goto L_0x0118;
                case 1568931: goto L_0x010c;
                case 1568932: goto L_0x0100;
                case 1568933: goto L_0x00f4;
                case 1568934: goto L_0x00e8;
                case 1568935: goto L_0x00dc;
                case 1568936: goto L_0x00d0;
                default: goto L_0x0068;
            }
        L_0x0068:
            switch(r3) {
                case 1575716: goto L_0x00c4;
                case 1575717: goto L_0x00b8;
                case 1575718: goto L_0x00ac;
                case 1575719: goto L_0x00a0;
                default: goto L_0x006b;
            }
        L_0x006b:
            switch(r3) {
                case 1575747: goto L_0x0094;
                case 1575748: goto L_0x0088;
                case 1575749: goto L_0x007c;
                case 1575750: goto L_0x0070;
                default: goto L_0x006e;
            }
        L_0x006e:
            goto L_0x0202
        L_0x0070:
            java.lang.String r2 = "3933"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 34
            goto L_0x0203
        L_0x007c:
            java.lang.String r2 = "3932"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 33
            goto L_0x0203
        L_0x0088:
            java.lang.String r2 = "3931"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 32
            goto L_0x0203
        L_0x0094:
            java.lang.String r2 = "3930"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 31
            goto L_0x0203
        L_0x00a0:
            java.lang.String r2 = "3923"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 30
            goto L_0x0203
        L_0x00ac:
            java.lang.String r2 = "3922"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 29
            goto L_0x0203
        L_0x00b8:
            java.lang.String r2 = "3921"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 28
            goto L_0x0203
        L_0x00c4:
            java.lang.String r2 = "3920"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 27
            goto L_0x0203
        L_0x00d0:
            java.lang.String r2 = "3209"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 26
            goto L_0x0203
        L_0x00dc:
            java.lang.String r2 = "3208"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 25
            goto L_0x0203
        L_0x00e8:
            java.lang.String r2 = "3207"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 24
            goto L_0x0203
        L_0x00f4:
            java.lang.String r2 = "3206"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 23
            goto L_0x0203
        L_0x0100:
            java.lang.String r2 = "3205"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 22
            goto L_0x0203
        L_0x010c:
            java.lang.String r2 = "3204"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 21
            goto L_0x0203
        L_0x0118:
            java.lang.String r2 = "3203"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 20
            goto L_0x0203
        L_0x0124:
            java.lang.String r2 = "3202"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 19
            goto L_0x0203
        L_0x0130:
            java.lang.String r2 = "3201"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 18
            goto L_0x0203
        L_0x013c:
            java.lang.String r2 = "3200"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 17
            goto L_0x0203
        L_0x0148:
            java.lang.String r2 = "3109"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 16
            goto L_0x0203
        L_0x0154:
            java.lang.String r2 = "3108"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 15
            goto L_0x0203
        L_0x0160:
            java.lang.String r2 = "3107"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 14
            goto L_0x0203
        L_0x016c:
            java.lang.String r2 = "3106"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 13
            goto L_0x0203
        L_0x0178:
            java.lang.String r2 = "3105"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 12
            goto L_0x0203
        L_0x0184:
            java.lang.String r2 = "3104"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 11
            goto L_0x0203
        L_0x0190:
            java.lang.String r2 = "3103"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 10
            goto L_0x0203
        L_0x019c:
            java.lang.String r2 = "3102"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 9
            goto L_0x0203
        L_0x01a7:
            java.lang.String r2 = "3101"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 8
            goto L_0x0203
        L_0x01b2:
            java.lang.String r2 = "3100"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 7
            goto L_0x0203
        L_0x01bc:
            java.lang.String r2 = "11"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 3
            goto L_0x0203
        L_0x01c6:
            java.lang.String r2 = "10"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 2
            goto L_0x0203
        L_0x01d0:
            java.lang.String r2 = "01"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 1
            goto L_0x0203
        L_0x01da:
            java.lang.String r2 = "00"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 0
            goto L_0x0203
        L_0x01e4:
            java.lang.String r2 = "17"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 6
            goto L_0x0203
        L_0x01ee:
            java.lang.String r2 = "15"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 5
            goto L_0x0203
        L_0x01f8:
            java.lang.String r2 = "13"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 4
            goto L_0x0203
        L_0x0202:
            r2 = -1
        L_0x0203:
            switch(r2) {
                case 0: goto L_0x0252;
                case 1: goto L_0x0250;
                case 2: goto L_0x024e;
                case 3: goto L_0x024c;
                case 4: goto L_0x024a;
                case 5: goto L_0x0248;
                case 6: goto L_0x0246;
                case 7: goto L_0x0238;
                case 8: goto L_0x0238;
                case 9: goto L_0x0238;
                case 10: goto L_0x0238;
                case 11: goto L_0x0238;
                case 12: goto L_0x0238;
                case 13: goto L_0x0238;
                case 14: goto L_0x0238;
                case 15: goto L_0x0238;
                case 16: goto L_0x0238;
                case 17: goto L_0x0233;
                case 18: goto L_0x0233;
                case 19: goto L_0x0233;
                case 20: goto L_0x0233;
                case 21: goto L_0x0233;
                case 22: goto L_0x0233;
                case 23: goto L_0x0233;
                case 24: goto L_0x0233;
                case 25: goto L_0x0233;
                case 26: goto L_0x0233;
                case 27: goto L_0x022a;
                case 28: goto L_0x022a;
                case 29: goto L_0x022a;
                case 30: goto L_0x022a;
                case 31: goto L_0x0212;
                case 32: goto L_0x0212;
                case 33: goto L_0x0212;
                case 34: goto L_0x0212;
                default: goto L_0x0206;
            }
        L_0x0206:
            r2 = 0
            r3 = 0
            r0.put(r4, r1)
        L_0x020b:
            r3 = r2
            r2 = r21
            r15 = r22
            goto L_0x0024
        L_0x0212:
            int r2 = r1.length()
            r3 = 4
            if (r2 >= r3) goto L_0x021b
            r2 = 0
            return r2
        L_0x021b:
            r2 = 0
            java.lang.String r16 = r1.substring(r15)
            r3 = 0
            java.lang.String r18 = r1.substring(r3, r15)
            java.lang.String r17 = r4.substring(r15)
            goto L_0x020b
        L_0x022a:
            r2 = 0
            r3 = 0
            java.lang.String r17 = r4.substring(r15)
            r16 = r1
            goto L_0x020b
        L_0x0233:
            r2 = 0
            r3 = 0
            java.lang.String r14 = "LB"
            goto L_0x023c
        L_0x0238:
            r2 = 0
            r3 = 0
            java.lang.String r14 = "KG"
        L_0x023c:
            java.lang.String r15 = r4.substring(r15)
            r13 = r1
            r3 = r2
            r2 = r21
            goto L_0x0024
        L_0x0246:
            r12 = r1
            goto L_0x0253
        L_0x0248:
            r11 = r1
            goto L_0x0253
        L_0x024a:
            r10 = r1
            goto L_0x0253
        L_0x024c:
            r9 = r1
            goto L_0x0253
        L_0x024e:
            r8 = r1
            goto L_0x0253
        L_0x0250:
            r6 = r1
            goto L_0x0253
        L_0x0252:
            r7 = r1
        L_0x0253:
            r2 = r21
            r15 = r22
            r3 = 0
            goto L_0x0024
        L_0x025a:
            r22 = r15
            com.google.a.b.a.k r1 = new com.google.a.b.a.k
            r4 = r1
            r19 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.l.c(com.google.a.r):com.google.a.b.a.k");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x020b, code lost:
        r3 = r2;
        r2 = r21;
        r15 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x023c, code lost:
        r15 = r4.substring(3);
        r13 = r1;
        r3 = r2;
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0253, code lost:
        r2 = r21;
        r15 = r22;
        r3 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0252  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.a.b.a.q a(com.google.a.r r25) {
        /*
            r24 = this;
            r0 = r25
            com.google.a.a r1 = r0.e
            com.google.a.a r2 = com.google.a.a.RSS_EXPANDED
            r3 = 0
            if (r1 == r2) goto L_0x000a
            return r3
        L_0x000a:
            java.lang.String r5 = b((com.google.a.r) r25)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r6 = r3
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r18 = r17
            r2 = 0
        L_0x0024:
            int r4 = r5.length()
            if (r2 >= r4) goto L_0x025a
            java.lang.String r4 = a(r2, r5)
            if (r4 != 0) goto L_0x0031
            return r3
        L_0x0031:
            int r19 = r4.length()
            r20 = 2
            int r19 = r19 + 2
            int r2 = r2 + r19
            java.lang.String r1 = b(r2, r5)
            int r19 = r1.length()
            int r2 = r2 + r19
            r19 = -1
            int r3 = r4.hashCode()
            r21 = r2
            r2 = 1570(0x622, float:2.2E-42)
            r22 = r15
            r15 = 3
            if (r3 == r2) goto L_0x01f8
            r2 = 1572(0x624, float:2.203E-42)
            if (r3 == r2) goto L_0x01ee
            r2 = 1574(0x626, float:2.206E-42)
            if (r3 == r2) goto L_0x01e4
            switch(r3) {
                case 1536: goto L_0x01da;
                case 1537: goto L_0x01d0;
                default: goto L_0x005f;
            }
        L_0x005f:
            switch(r3) {
                case 1567: goto L_0x01c6;
                case 1568: goto L_0x01bc;
                default: goto L_0x0062;
            }
        L_0x0062:
            switch(r3) {
                case 1567966: goto L_0x01b2;
                case 1567967: goto L_0x01a7;
                case 1567968: goto L_0x019c;
                case 1567969: goto L_0x0190;
                case 1567970: goto L_0x0184;
                case 1567971: goto L_0x0178;
                case 1567972: goto L_0x016c;
                case 1567973: goto L_0x0160;
                case 1567974: goto L_0x0154;
                case 1567975: goto L_0x0148;
                default: goto L_0x0065;
            }
        L_0x0065:
            switch(r3) {
                case 1568927: goto L_0x013c;
                case 1568928: goto L_0x0130;
                case 1568929: goto L_0x0124;
                case 1568930: goto L_0x0118;
                case 1568931: goto L_0x010c;
                case 1568932: goto L_0x0100;
                case 1568933: goto L_0x00f4;
                case 1568934: goto L_0x00e8;
                case 1568935: goto L_0x00dc;
                case 1568936: goto L_0x00d0;
                default: goto L_0x0068;
            }
        L_0x0068:
            switch(r3) {
                case 1575716: goto L_0x00c4;
                case 1575717: goto L_0x00b8;
                case 1575718: goto L_0x00ac;
                case 1575719: goto L_0x00a0;
                default: goto L_0x006b;
            }
        L_0x006b:
            switch(r3) {
                case 1575747: goto L_0x0094;
                case 1575748: goto L_0x0088;
                case 1575749: goto L_0x007c;
                case 1575750: goto L_0x0070;
                default: goto L_0x006e;
            }
        L_0x006e:
            goto L_0x0202
        L_0x0070:
            java.lang.String r2 = "3933"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 34
            goto L_0x0203
        L_0x007c:
            java.lang.String r2 = "3932"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 33
            goto L_0x0203
        L_0x0088:
            java.lang.String r2 = "3931"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 32
            goto L_0x0203
        L_0x0094:
            java.lang.String r2 = "3930"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 31
            goto L_0x0203
        L_0x00a0:
            java.lang.String r2 = "3923"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 30
            goto L_0x0203
        L_0x00ac:
            java.lang.String r2 = "3922"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 29
            goto L_0x0203
        L_0x00b8:
            java.lang.String r2 = "3921"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 28
            goto L_0x0203
        L_0x00c4:
            java.lang.String r2 = "3920"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 27
            goto L_0x0203
        L_0x00d0:
            java.lang.String r2 = "3209"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 26
            goto L_0x0203
        L_0x00dc:
            java.lang.String r2 = "3208"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 25
            goto L_0x0203
        L_0x00e8:
            java.lang.String r2 = "3207"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 24
            goto L_0x0203
        L_0x00f4:
            java.lang.String r2 = "3206"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 23
            goto L_0x0203
        L_0x0100:
            java.lang.String r2 = "3205"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 22
            goto L_0x0203
        L_0x010c:
            java.lang.String r2 = "3204"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 21
            goto L_0x0203
        L_0x0118:
            java.lang.String r2 = "3203"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 20
            goto L_0x0203
        L_0x0124:
            java.lang.String r2 = "3202"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 19
            goto L_0x0203
        L_0x0130:
            java.lang.String r2 = "3201"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 18
            goto L_0x0203
        L_0x013c:
            java.lang.String r2 = "3200"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 17
            goto L_0x0203
        L_0x0148:
            java.lang.String r2 = "3109"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 16
            goto L_0x0203
        L_0x0154:
            java.lang.String r2 = "3108"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 15
            goto L_0x0203
        L_0x0160:
            java.lang.String r2 = "3107"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 14
            goto L_0x0203
        L_0x016c:
            java.lang.String r2 = "3106"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 13
            goto L_0x0203
        L_0x0178:
            java.lang.String r2 = "3105"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 12
            goto L_0x0203
        L_0x0184:
            java.lang.String r2 = "3104"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 11
            goto L_0x0203
        L_0x0190:
            java.lang.String r2 = "3103"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 10
            goto L_0x0203
        L_0x019c:
            java.lang.String r2 = "3102"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 9
            goto L_0x0203
        L_0x01a7:
            java.lang.String r2 = "3101"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 8
            goto L_0x0203
        L_0x01b2:
            java.lang.String r2 = "3100"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 7
            goto L_0x0203
        L_0x01bc:
            java.lang.String r2 = "11"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 3
            goto L_0x0203
        L_0x01c6:
            java.lang.String r2 = "10"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 2
            goto L_0x0203
        L_0x01d0:
            java.lang.String r2 = "01"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 1
            goto L_0x0203
        L_0x01da:
            java.lang.String r2 = "00"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 0
            goto L_0x0203
        L_0x01e4:
            java.lang.String r2 = "17"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 6
            goto L_0x0203
        L_0x01ee:
            java.lang.String r2 = "15"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 5
            goto L_0x0203
        L_0x01f8:
            java.lang.String r2 = "13"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0202
            r2 = 4
            goto L_0x0203
        L_0x0202:
            r2 = -1
        L_0x0203:
            switch(r2) {
                case 0: goto L_0x0252;
                case 1: goto L_0x0250;
                case 2: goto L_0x024e;
                case 3: goto L_0x024c;
                case 4: goto L_0x024a;
                case 5: goto L_0x0248;
                case 6: goto L_0x0246;
                case 7: goto L_0x0238;
                case 8: goto L_0x0238;
                case 9: goto L_0x0238;
                case 10: goto L_0x0238;
                case 11: goto L_0x0238;
                case 12: goto L_0x0238;
                case 13: goto L_0x0238;
                case 14: goto L_0x0238;
                case 15: goto L_0x0238;
                case 16: goto L_0x0238;
                case 17: goto L_0x0233;
                case 18: goto L_0x0233;
                case 19: goto L_0x0233;
                case 20: goto L_0x0233;
                case 21: goto L_0x0233;
                case 22: goto L_0x0233;
                case 23: goto L_0x0233;
                case 24: goto L_0x0233;
                case 25: goto L_0x0233;
                case 26: goto L_0x0233;
                case 27: goto L_0x022a;
                case 28: goto L_0x022a;
                case 29: goto L_0x022a;
                case 30: goto L_0x022a;
                case 31: goto L_0x0212;
                case 32: goto L_0x0212;
                case 33: goto L_0x0212;
                case 34: goto L_0x0212;
                default: goto L_0x0206;
            }
        L_0x0206:
            r2 = 0
            r3 = 0
            r0.put(r4, r1)
        L_0x020b:
            r3 = r2
            r2 = r21
            r15 = r22
            goto L_0x0024
        L_0x0212:
            int r2 = r1.length()
            r3 = 4
            if (r2 >= r3) goto L_0x021b
            r2 = 0
            return r2
        L_0x021b:
            r2 = 0
            java.lang.String r16 = r1.substring(r15)
            r3 = 0
            java.lang.String r18 = r1.substring(r3, r15)
            java.lang.String r17 = r4.substring(r15)
            goto L_0x020b
        L_0x022a:
            r2 = 0
            r3 = 0
            java.lang.String r17 = r4.substring(r15)
            r16 = r1
            goto L_0x020b
        L_0x0233:
            r2 = 0
            r3 = 0
            java.lang.String r14 = "LB"
            goto L_0x023c
        L_0x0238:
            r2 = 0
            r3 = 0
            java.lang.String r14 = "KG"
        L_0x023c:
            java.lang.String r15 = r4.substring(r15)
            r13 = r1
            r3 = r2
            r2 = r21
            goto L_0x0024
        L_0x0246:
            r12 = r1
            goto L_0x0253
        L_0x0248:
            r11 = r1
            goto L_0x0253
        L_0x024a:
            r10 = r1
            goto L_0x0253
        L_0x024c:
            r9 = r1
            goto L_0x0253
        L_0x024e:
            r8 = r1
            goto L_0x0253
        L_0x0250:
            r6 = r1
            goto L_0x0253
        L_0x0252:
            r7 = r1
        L_0x0253:
            r2 = r21
            r15 = r22
            r3 = 0
            goto L_0x0024
        L_0x025a:
            r22 = r15
            com.google.a.b.a.k r1 = new com.google.a.b.a.k
            r4 = r1
            r19 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.l.a(com.google.a.r):com.google.a.b.a.q");
    }
}

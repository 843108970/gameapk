package com.google.a.g;

import com.google.a.c.a;
import com.google.a.m;

public final class c extends r {

    /* renamed from: a  reason: collision with root package name */
    static final int[][] f3193a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* renamed from: b  reason: collision with root package name */
    private static final float f3194b = 0.25f;

    /* renamed from: c  reason: collision with root package name */
    private static final float f3195c = 0.7f;
    private static final int d = 98;
    private static final int e = 99;
    private static final int f = 100;
    private static final int g = 101;
    private static final int h = 102;
    private static final int i = 97;
    private static final int j = 96;
    private static final int k = 101;
    private static final int l = 100;
    private static final int m = 103;
    private static final int n = 104;
    private static final int o = 105;
    private static final int p = 106;

    private static int a(a aVar, int[] iArr, int i2) throws m {
        a(aVar, i2, iArr);
        float f2 = f3194b;
        int i3 = -1;
        for (int i4 = 0; i4 < f3193a.length; i4++) {
            float a2 = a(iArr, f3193a[i4], (float) f3195c);
            if (a2 < f2) {
                i3 = i4;
                f2 = a2;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw m.getNotFoundInstance();
    }

    private static int[] a(a aVar) throws m {
        int i2 = aVar.f3055b;
        int c2 = aVar.c(0);
        int[] iArr = new int[6];
        int i3 = c2;
        boolean z = false;
        int i4 = 0;
        while (c2 < i2) {
            if (aVar.a(c2) != z) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 == 5) {
                    float f2 = f3194b;
                    int i5 = -1;
                    for (int i6 = 103; i6 <= 105; i6++) {
                        float a2 = a(iArr, f3193a[i6], (float) f3195c);
                        if (a2 < f2) {
                            i5 = i6;
                            f2 = a2;
                        }
                    }
                    if (i5 < 0 || !aVar.a(Math.max(0, i3 - ((c2 - i3) / 2)), i3)) {
                        i3 += iArr[0] + iArr[1];
                        int i7 = i4 - 1;
                        System.arraycopy(iArr, 2, iArr, 0, i7);
                        iArr[i7] = 0;
                        iArr[i4] = 0;
                        i4--;
                    } else {
                        return new int[]{i3, c2, i5};
                    }
                } else {
                    i4++;
                }
                iArr[i4] = 1;
                z = !z;
            }
            c2++;
        }
        throw m.getNotFoundInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x018f, code lost:
        if (r14.length() == 0) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0193, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0194, code lost:
        r11 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0197, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0198, code lost:
        r11 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x019b, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x019c, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x019d, code lost:
        if (r8 == false) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01a1, code lost:
        if (r11 != 'e') goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01a3, code lost:
        r9 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01a6, code lost:
        r9 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01a8, code lost:
        r11 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01ac, code lost:
        r8 = r6;
        r9 = r13;
        r6 = 6;
        r13 = r2;
        r2 = r15;
        r15 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010d, code lost:
        if (r14.length() == 0) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x010f, code lost:
        r14.append("]C1");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0116, code lost:
        r14.append(29);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0122, code lost:
        if (r10 != false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0130, code lost:
        r14.append((char) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x013a, code lost:
        r6 = false;
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0150, code lost:
        if (r14.length() == 0) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0157, code lost:
        r6 = false;
        r10 = false;
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x015d, code lost:
        if (r10 != false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x015f, code lost:
        r6 = false;
        r10 = false;
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0163, code lost:
        r6 = false;
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0166, code lost:
        r6 = false;
        r11 = 'c';
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.r a(int r23, com.google.a.c.a r24, java.util.Map<com.google.a.e, ?> r25) throws com.google.a.m, com.google.a.h, com.google.a.d {
        /*
            r22 = this;
            r0 = r24
            r1 = r25
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            com.google.a.e r4 = com.google.a.e.ASSUME_GS1
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            int r4 = r0.f3055b
            int r5 = r0.c(r3)
            r6 = 6
            int[] r7 = new int[r6]
            r10 = r5
            r8 = 0
            r9 = 0
        L_0x001f:
            if (r5 >= r4) goto L_0x026c
            boolean r11 = r0.a((int) r5)
            if (r11 == r8) goto L_0x0031
            r11 = r7[r9]
            int r11 = r11 + r2
            r7[r9] = r11
            r11 = r23
            r12 = 0
            goto L_0x0266
        L_0x0031:
            r11 = 5
            if (r9 != r11) goto L_0x025b
            r11 = 1048576000(0x3e800000, float:0.25)
            r13 = -1
            r11 = 103(0x67, float:1.44E-43)
            r13 = 1048576000(0x3e800000, float:0.25)
            r14 = -1
        L_0x003c:
            r15 = 105(0x69, float:1.47E-43)
            if (r11 > r15) goto L_0x0054
            int[][] r15 = f3193a
            r15 = r15[r11]
            r12 = 1060320051(0x3f333333, float:0.7)
            float r12 = a((int[]) r7, (int[]) r15, (float) r12)
            int r15 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x0051
            r14 = r11
            r13 = r12
        L_0x0051:
            int r11 = r11 + 1
            goto L_0x003c
        L_0x0054:
            r11 = 2
            if (r14 < 0) goto L_0x0245
            int r12 = r5 - r10
            int r12 = r12 / r11
            int r12 = r10 - r12
            int r12 = java.lang.Math.max(r3, r12)
            boolean r12 = r0.a(r12, r10)
            if (r12 == 0) goto L_0x0245
            r4 = 3
            int[] r4 = new int[r4]
            r4[r3] = r10
            r4[r2] = r5
            r4[r11] = r14
            r5 = r4[r11]
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 20
            r7.<init>(r8)
            byte r9 = (byte) r5
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r7.add(r9)
            switch(r5) {
                case 103: goto L_0x008e;
                case 104: goto L_0x008b;
                case 105: goto L_0x0088;
                default: goto L_0x0083;
            }
        L_0x0083:
            com.google.a.h r0 = com.google.a.h.getFormatInstance()
            throw r0
        L_0x0088:
            r13 = 99
            goto L_0x0090
        L_0x008b:
            r13 = 100
            goto L_0x0090
        L_0x008e:
            r13 = 101(0x65, float:1.42E-43)
        L_0x0090:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r8)
            r8 = r4[r3]
            r15 = r4[r2]
            int[] r3 = new int[r6]
            r16 = r5
            r2 = r8
            r11 = r13
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r17 = 0
            r18 = 1
        L_0x00a9:
            if (r5 != 0) goto L_0x01b5
            int r2 = a((com.google.a.c.a) r0, (int[]) r3, (int) r15)
            byte r9 = (byte) r2
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r7.add(r9)
            r9 = 106(0x6a, float:1.49E-43)
            if (r2 == r9) goto L_0x00bd
            r18 = 1
        L_0x00bd:
            if (r2 == r9) goto L_0x00c5
            int r17 = r17 + 1
            int r19 = r17 * r2
            int r16 = r16 + r19
        L_0x00c5:
            r19 = r15
            r9 = 0
        L_0x00c8:
            if (r9 >= r6) goto L_0x00d1
            r20 = r3[r9]
            int r19 = r19 + r20
            int r9 = r9 + 1
            goto L_0x00c8
        L_0x00d1:
            switch(r2) {
                case 103: goto L_0x00db;
                case 104: goto L_0x00db;
                case 105: goto L_0x00db;
                default: goto L_0x00d4;
            }
        L_0x00d4:
            r9 = 29
            switch(r11) {
                case 99: goto L_0x016c;
                case 100: goto L_0x0128;
                case 101: goto L_0x00e0;
                default: goto L_0x00d9;
            }
        L_0x00d9:
            goto L_0x019c
        L_0x00db:
            com.google.a.h r0 = com.google.a.h.getFormatInstance()
            throw r0
        L_0x00e0:
            r6 = 64
            if (r2 >= r6) goto L_0x00ee
            if (r10 != r12) goto L_0x00e9
            int r6 = r2 + 32
            goto L_0x0130
        L_0x00e9:
            int r6 = r2 + 32
            int r6 = r6 + 128
            goto L_0x0130
        L_0x00ee:
            r6 = 96
            if (r2 >= r6) goto L_0x00fa
            if (r10 != r12) goto L_0x00f7
            int r6 = r2 + -64
            goto L_0x0130
        L_0x00f7:
            int r6 = r2 + 64
            goto L_0x0130
        L_0x00fa:
            r6 = 106(0x6a, float:1.49E-43)
            if (r2 == r6) goto L_0x0100
            r18 = 0
        L_0x0100:
            if (r2 == r6) goto L_0x019b
            switch(r2) {
                case 96: goto L_0x019c;
                case 97: goto L_0x019c;
                case 98: goto L_0x0125;
                case 99: goto L_0x0166;
                case 100: goto L_0x0197;
                case 101: goto L_0x011b;
                case 102: goto L_0x0107;
                default: goto L_0x0105;
            }
        L_0x0105:
            goto L_0x019c
        L_0x0107:
            if (r1 == 0) goto L_0x019c
            int r6 = r14.length()
            if (r6 != 0) goto L_0x0116
        L_0x010f:
            java.lang.String r6 = "]C1"
            r14.append(r6)
            goto L_0x019c
        L_0x0116:
            r14.append(r9)
            goto L_0x019c
        L_0x011b:
            if (r12 != 0) goto L_0x0120
            if (r10 == 0) goto L_0x0120
            goto L_0x0157
        L_0x0120:
            if (r12 == 0) goto L_0x0163
            if (r10 == 0) goto L_0x0163
            goto L_0x015f
        L_0x0125:
            r6 = 1
            goto L_0x0198
        L_0x0128:
            r6 = 96
            if (r2 >= r6) goto L_0x013e
            if (r10 != r12) goto L_0x0135
            int r6 = r2 + 32
        L_0x0130:
            char r6 = (char) r6
            r14.append(r6)
            goto L_0x013a
        L_0x0135:
            int r6 = r2 + 32
            int r6 = r6 + 128
            goto L_0x0130
        L_0x013a:
            r6 = 0
            r10 = 0
            goto L_0x019d
        L_0x013e:
            r6 = 106(0x6a, float:1.49E-43)
            if (r2 == r6) goto L_0x0144
            r18 = 0
        L_0x0144:
            if (r2 == r6) goto L_0x019b
            switch(r2) {
                case 96: goto L_0x019c;
                case 97: goto L_0x019c;
                case 98: goto L_0x016a;
                case 99: goto L_0x0166;
                case 100: goto L_0x0153;
                case 101: goto L_0x0193;
                case 102: goto L_0x014a;
                default: goto L_0x0149;
            }
        L_0x0149:
            goto L_0x019c
        L_0x014a:
            if (r1 == 0) goto L_0x019c
            int r6 = r14.length()
            if (r6 != 0) goto L_0x0116
            goto L_0x010f
        L_0x0153:
            if (r12 != 0) goto L_0x015b
            if (r10 == 0) goto L_0x015b
        L_0x0157:
            r6 = 0
            r10 = 0
            r12 = 1
            goto L_0x019d
        L_0x015b:
            if (r12 == 0) goto L_0x0163
            if (r10 == 0) goto L_0x0163
        L_0x015f:
            r6 = 0
            r10 = 0
            r12 = 0
            goto L_0x019d
        L_0x0163:
            r6 = 0
            r10 = 1
            goto L_0x019d
        L_0x0166:
            r6 = 0
            r11 = 99
            goto L_0x019d
        L_0x016a:
            r6 = 1
            goto L_0x0194
        L_0x016c:
            r6 = 100
            if (r2 >= r6) goto L_0x017d
            r9 = 10
            if (r2 >= r9) goto L_0x0179
            r9 = 48
            r14.append(r9)
        L_0x0179:
            r14.append(r2)
            goto L_0x019c
        L_0x017d:
            r6 = 106(0x6a, float:1.49E-43)
            if (r2 == r6) goto L_0x0183
            r18 = 0
        L_0x0183:
            if (r2 == r6) goto L_0x019b
            switch(r2) {
                case 100: goto L_0x0197;
                case 101: goto L_0x0193;
                case 102: goto L_0x0189;
                default: goto L_0x0188;
            }
        L_0x0188:
            goto L_0x019c
        L_0x0189:
            if (r1 == 0) goto L_0x019c
            int r6 = r14.length()
            if (r6 != 0) goto L_0x0116
            goto L_0x010f
        L_0x0193:
            r6 = 0
        L_0x0194:
            r11 = 101(0x65, float:1.42E-43)
            goto L_0x019d
        L_0x0197:
            r6 = 0
        L_0x0198:
            r11 = 100
            goto L_0x019d
        L_0x019b:
            r5 = 1
        L_0x019c:
            r6 = 0
        L_0x019d:
            if (r8 == 0) goto L_0x01aa
            r8 = 101(0x65, float:1.42E-43)
            if (r11 != r8) goto L_0x01a6
            r9 = 100
            goto L_0x01a8
        L_0x01a6:
            r9 = 101(0x65, float:1.42E-43)
        L_0x01a8:
            r11 = r9
            goto L_0x01ac
        L_0x01aa:
            r8 = 101(0x65, float:1.42E-43)
        L_0x01ac:
            r8 = r6
            r9 = r13
            r6 = 6
            r13 = r2
            r2 = r15
            r15 = r19
            goto L_0x00a9
        L_0x01b5:
            int r1 = r15 - r2
            int r3 = r0.d(r15)
            int r5 = r0.f3055b
            int r6 = r3 - r2
            r8 = 2
            int r6 = r6 / r8
            int r6 = r6 + r3
            int r5 = java.lang.Math.min(r5, r6)
            boolean r0 = r0.a(r3, r5)
            if (r0 != 0) goto L_0x01d1
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x01d1:
            int r17 = r17 * r9
            int r16 = r16 - r17
            r0 = 103(0x67, float:1.44E-43)
            int r0 = r16 % 103
            if (r0 == r9) goto L_0x01e0
            com.google.a.d r0 = com.google.a.d.getChecksumInstance()
            throw r0
        L_0x01e0:
            int r0 = r14.length()
            if (r0 != 0) goto L_0x01eb
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x01eb:
            if (r0 <= 0) goto L_0x01fc
            if (r18 == 0) goto L_0x01fc
            r3 = 99
            if (r11 != r3) goto L_0x01f9
            int r3 = r0 + -2
        L_0x01f5:
            r14.delete(r3, r0)
            goto L_0x01fc
        L_0x01f9:
            int r3 = r0 + -1
            goto L_0x01f5
        L_0x01fc:
            r0 = 1
            r3 = r4[r0]
            r0 = 0
            r4 = r4[r0]
            int r3 = r3 + r4
            float r0 = (float) r3
            r3 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r3
            float r2 = (float) r2
            float r1 = (float) r1
            float r1 = r1 / r3
            float r2 = r2 + r1
            int r1 = r7.size()
            byte[] r3 = new byte[r1]
            r4 = 0
        L_0x0212:
            if (r4 >= r1) goto L_0x0223
            java.lang.Object r5 = r7.get(r4)
            java.lang.Byte r5 = (java.lang.Byte) r5
            byte r5 = r5.byteValue()
            r3[r4] = r5
            int r4 = r4 + 1
            goto L_0x0212
        L_0x0223:
            com.google.a.r r1 = new com.google.a.r
            java.lang.String r4 = r14.toString()
            r5 = 2
            com.google.a.t[] r5 = new com.google.a.t[r5]
            com.google.a.t r6 = new com.google.a.t
            r11 = r23
            float r7 = (float) r11
            r6.<init>(r0, r7)
            r12 = 0
            r5[r12] = r6
            com.google.a.t r0 = new com.google.a.t
            r0.<init>(r2, r7)
            r2 = 1
            r5[r2] = r0
            com.google.a.a r0 = com.google.a.a.CODE_128
            r1.<init>(r4, r3, r5, r0)
            return r1
        L_0x0245:
            r11 = r23
            r12 = 0
            r3 = r7[r12]
            r6 = r7[r2]
            int r3 = r3 + r6
            int r10 = r10 + r3
            int r2 = r9 + -1
            r3 = 2
            java.lang.System.arraycopy(r7, r3, r7, r12, r2)
            r7[r2] = r12
            r7[r9] = r12
            int r9 = r9 + -1
            goto L_0x0260
        L_0x025b:
            r11 = r23
            r12 = 0
            int r9 = r9 + 1
        L_0x0260:
            r2 = 1
            r7[r9] = r2
            r3 = r8 ^ 1
            r8 = r3
        L_0x0266:
            int r5 = r5 + 1
            r3 = 0
            r6 = 6
            goto L_0x001f
        L_0x026c:
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.c.a(int, com.google.a.c.a, java.util.Map):com.google.a.r");
    }
}

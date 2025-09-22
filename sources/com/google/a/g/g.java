package com.google.a.g;

import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import com.cyjh.mobileanjian.ipc.share.proto.a;
import com.google.a.d;
import com.google.a.m;
import java.util.Arrays;

public final class g extends r {

    /* renamed from: a  reason: collision with root package name */
    static final String f3202a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";

    /* renamed from: b  reason: collision with root package name */
    static final int[] f3203b;

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f3204c = f3202a.toCharArray();
    private static final int d;
    private final StringBuilder e = new StringBuilder(20);
    private final int[] f = new int[6];

    static {
        int[] iArr = {a.aS, 328, 324, 322, 296, 292, 290, 336, a.aQ, 266, 424, 420, 418, UiMessage.CommandToUi.Command_Type.GET_TEXT_VALUE, UiMessage.CommandToUi.Command_Type.GET_VISIBLE_VALUE, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, UiMessage.CommandToUi.Command_Type.GET_TITLE_BACKCOLOR_VALUE, UiMessage.CommandToUi.Command_Type.GET_FW_VISIBLE_VALUE, 364, 358, UiMessage.CommandToUi.Command_Type.SET_FW_TEXT_COLOR_VALUE, 314, UiMessage.CommandToUi.Command_Type.SET_VISIBLE_VALUE, 468, 466, 458, 366, 374, 430, 294, 474, 470, UiMessage.CommandToUi.Command_Type.SET_TITLE_BACKCOLOR_VALUE, 350};
        f3203b = iArr;
        d = iArr[47];
    }

    private static char a(int i) throws m {
        for (int i2 = 0; i2 < f3203b.length; i2++) {
            if (f3203b[i2] == i) {
                return f3204c[i2];
            }
        }
        throw m.getNotFoundInstance();
    }

    private static int a(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int round = Math.round((((float) iArr[i4]) * 9.0f) / ((float) i));
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                int i5 = i3;
                for (int i6 = 0; i6 < round; i6++) {
                    i5 = (i5 << 1) | 1;
                }
                i3 = i5;
            } else {
                i3 <<= round;
            }
        }
        return i3;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.CharSequence r9) throws com.google.a.h {
        /*
            int r0 = r9.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = 0
        L_0x000b:
            if (r3 >= r0) goto L_0x009b
            char r4 = r9.charAt(r3)
            r5 = 97
            if (r4 < r5) goto L_0x0094
            r5 = 100
            if (r4 > r5) goto L_0x0094
            int r5 = r0 + -1
            if (r3 < r5) goto L_0x0022
            com.google.a.h r9 = com.google.a.h.getFormatInstance()
            throw r9
        L_0x0022:
            int r3 = r3 + 1
            char r5 = r9.charAt(r3)
            r6 = 79
            r7 = 90
            r8 = 65
            switch(r4) {
                case 97: goto L_0x0087;
                case 98: goto L_0x0051;
                case 99: goto L_0x0040;
                case 100: goto L_0x0034;
                default: goto L_0x0031;
            }
        L_0x0031:
            r4 = 0
            goto L_0x0094
        L_0x0034:
            if (r5 < r8) goto L_0x003b
            if (r5 > r7) goto L_0x003b
            int r5 = r5 + 32
            goto L_0x008d
        L_0x003b:
            com.google.a.h r9 = com.google.a.h.getFormatInstance()
            throw r9
        L_0x0040:
            if (r5 < r8) goto L_0x0047
            if (r5 > r6) goto L_0x0047
            int r5 = r5 + -32
            goto L_0x008d
        L_0x0047:
            if (r5 != r7) goto L_0x004c
            r4 = 58
            goto L_0x0094
        L_0x004c:
            com.google.a.h r9 = com.google.a.h.getFormatInstance()
            throw r9
        L_0x0051:
            if (r5 < r8) goto L_0x005a
            r4 = 69
            if (r5 > r4) goto L_0x005a
            int r5 = r5 + -38
            goto L_0x008d
        L_0x005a:
            r4 = 70
            if (r5 < r4) goto L_0x0065
            r4 = 74
            if (r5 > r4) goto L_0x0065
            int r5 = r5 + -11
            goto L_0x008d
        L_0x0065:
            r4 = 75
            if (r5 < r4) goto L_0x006e
            if (r5 > r6) goto L_0x006e
            int r5 = r5 + 16
            goto L_0x008d
        L_0x006e:
            r4 = 80
            if (r5 < r4) goto L_0x0079
            r4 = 83
            if (r5 > r4) goto L_0x0079
            int r5 = r5 + 43
            goto L_0x008d
        L_0x0079:
            r4 = 84
            if (r5 < r4) goto L_0x0082
            if (r5 > r7) goto L_0x0082
            r4 = 127(0x7f, float:1.78E-43)
            goto L_0x0094
        L_0x0082:
            com.google.a.h r9 = com.google.a.h.getFormatInstance()
            throw r9
        L_0x0087:
            if (r5 < r8) goto L_0x008f
            if (r5 > r7) goto L_0x008f
            int r5 = r5 + -64
        L_0x008d:
            char r4 = (char) r5
            goto L_0x0094
        L_0x008f:
            com.google.a.h r9 = com.google.a.h.getFormatInstance()
            throw r9
        L_0x0094:
            r1.append(r4)
            int r3 = r3 + 1
            goto L_0x000b
        L_0x009b:
            java.lang.String r9 = r1.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.g.a(java.lang.CharSequence):java.lang.String");
    }

    private static void a(CharSequence charSequence, int i, int i2) throws d {
        int i3 = 0;
        int i4 = 1;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            i3 += f3202a.indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i) != f3204c[i3 % 47]) {
            throw d.getChecksumInstance();
        }
    }

    private int[] a(com.google.a.c.a aVar) throws m {
        int i = aVar.f3055b;
        int c2 = aVar.c(0);
        Arrays.fill(this.f, 0);
        int[] iArr = this.f;
        int length = iArr.length;
        int i2 = c2;
        boolean z = false;
        int i3 = 0;
        while (c2 < i) {
            if (aVar.a(c2) != z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (a(iArr) == d) {
                    return new int[]{i2, c2};
                } else {
                    i2 += iArr[0] + iArr[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                z = !z;
            }
            c2++;
        }
        throw m.getNotFoundInstance();
    }

    private static void b(CharSequence charSequence) throws d {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.r a(int r17, com.google.a.c.a r18, java.util.Map<com.google.a.e, ?> r19) throws com.google.a.m, com.google.a.d, com.google.a.h {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            int r2 = r1.f3055b
            r3 = 0
            int r4 = r1.c(r3)
            int[] r5 = r0.f
            java.util.Arrays.fill(r5, r3)
            int[] r5 = r0.f
            int r6 = r5.length
            r9 = r4
            r7 = 0
            r8 = 0
        L_0x0016:
            if (r4 >= r2) goto L_0x01bd
            boolean r10 = r1.a((int) r4)
            r11 = 1
            if (r10 == r7) goto L_0x0028
            r10 = r5[r8]
            int r10 = r10 + r11
            r5[r8] = r10
            r10 = r17
            goto L_0x01b9
        L_0x0028:
            int r10 = r6 + -1
            if (r8 != r10) goto L_0x01b1
            int r10 = a((int[]) r5)
            int r12 = d
            r13 = 2
            if (r10 != r12) goto L_0x019d
            int[] r2 = new int[r13]
            r2[r3] = r9
            r2[r11] = r4
            r4 = r2[r11]
            int r4 = r1.c(r4)
            int r5 = r1.f3055b
            int[] r6 = r0.f
            java.util.Arrays.fill(r6, r3)
            java.lang.StringBuilder r7 = r0.e
            r7.setLength(r3)
        L_0x004d:
            a((com.google.a.c.a) r1, (int) r4, (int[]) r6)
            int r8 = a((int[]) r6)
            if (r8 >= 0) goto L_0x005b
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x005b:
            r9 = 0
        L_0x005c:
            int[] r10 = f3203b
            int r10 = r10.length
            if (r9 >= r10) goto L_0x0198
            int[] r10 = f3203b
            r10 = r10[r9]
            if (r10 != r8) goto L_0x0192
            char[] r8 = f3204c
            char r8 = r8[r9]
            r7.append(r8)
            int r9 = r6.length
            r12 = r4
            r10 = 0
        L_0x0071:
            if (r10 >= r9) goto L_0x0079
            r14 = r6[r10]
            int r12 = r12 + r14
            int r10 = r10 + 1
            goto L_0x0071
        L_0x0079:
            int r9 = r1.c(r12)
            r10 = 42
            if (r8 != r10) goto L_0x018d
            int r8 = r7.length()
            int r8 = r8 - r11
            r7.deleteCharAt(r8)
            int r8 = r6.length
            r10 = 0
            r12 = 0
        L_0x008c:
            if (r10 >= r8) goto L_0x0094
            r14 = r6[r10]
            int r12 = r12 + r14
            int r10 = r10 + 1
            goto L_0x008c
        L_0x0094:
            if (r9 == r5) goto L_0x0188
            boolean r1 = r1.a((int) r9)
            if (r1 != 0) goto L_0x009e
            goto L_0x0188
        L_0x009e:
            int r1 = r7.length()
            if (r1 >= r13) goto L_0x00a9
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x00a9:
            int r1 = r7.length()
            int r5 = r1 + -2
            r6 = 20
            a((java.lang.CharSequence) r7, (int) r5, (int) r6)
            int r1 = r1 - r11
            r5 = 15
            a((java.lang.CharSequence) r7, (int) r1, (int) r5)
            int r1 = r7.length()
            int r1 = r1 - r13
            r7.setLength(r1)
            int r1 = r7.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r1)
            r6 = 0
        L_0x00cc:
            if (r6 >= r1) goto L_0x015b
            char r8 = r7.charAt(r6)
            r9 = 97
            if (r8 < r9) goto L_0x0155
            r9 = 100
            if (r8 > r9) goto L_0x0155
            int r9 = r1 + -1
            if (r6 < r9) goto L_0x00e3
            com.google.a.h r1 = com.google.a.h.getFormatInstance()
            throw r1
        L_0x00e3:
            int r6 = r6 + 1
            char r9 = r7.charAt(r6)
            r10 = 79
            r14 = 90
            r15 = 65
            switch(r8) {
                case 97: goto L_0x0148;
                case 98: goto L_0x0112;
                case 99: goto L_0x0101;
                case 100: goto L_0x00f5;
                default: goto L_0x00f2;
            }
        L_0x00f2:
            r8 = 0
            goto L_0x0155
        L_0x00f5:
            if (r9 < r15) goto L_0x00fc
            if (r9 > r14) goto L_0x00fc
            int r9 = r9 + 32
            goto L_0x014e
        L_0x00fc:
            com.google.a.h r1 = com.google.a.h.getFormatInstance()
            throw r1
        L_0x0101:
            if (r9 < r15) goto L_0x0108
            if (r9 > r10) goto L_0x0108
            int r9 = r9 + -32
            goto L_0x014e
        L_0x0108:
            if (r9 != r14) goto L_0x010d
            r8 = 58
            goto L_0x0155
        L_0x010d:
            com.google.a.h r1 = com.google.a.h.getFormatInstance()
            throw r1
        L_0x0112:
            if (r9 < r15) goto L_0x011b
            r8 = 69
            if (r9 > r8) goto L_0x011b
            int r9 = r9 + -38
            goto L_0x014e
        L_0x011b:
            r8 = 70
            if (r9 < r8) goto L_0x0126
            r8 = 74
            if (r9 > r8) goto L_0x0126
            int r9 = r9 + -11
            goto L_0x014e
        L_0x0126:
            r8 = 75
            if (r9 < r8) goto L_0x012f
            if (r9 > r10) goto L_0x012f
            int r9 = r9 + 16
            goto L_0x014e
        L_0x012f:
            r8 = 80
            if (r9 < r8) goto L_0x013a
            r8 = 83
            if (r9 > r8) goto L_0x013a
            int r9 = r9 + 43
            goto L_0x014e
        L_0x013a:
            r8 = 84
            if (r9 < r8) goto L_0x0143
            if (r9 > r14) goto L_0x0143
            r8 = 127(0x7f, float:1.78E-43)
            goto L_0x0155
        L_0x0143:
            com.google.a.h r1 = com.google.a.h.getFormatInstance()
            throw r1
        L_0x0148:
            if (r9 < r15) goto L_0x0150
            if (r9 > r14) goto L_0x0150
            int r9 = r9 + -64
        L_0x014e:
            char r8 = (char) r9
            goto L_0x0155
        L_0x0150:
            com.google.a.h r1 = com.google.a.h.getFormatInstance()
            throw r1
        L_0x0155:
            r5.append(r8)
            int r6 = r6 + r11
            goto L_0x00cc
        L_0x015b:
            java.lang.String r1 = r5.toString()
            r5 = r2[r11]
            r2 = r2[r3]
            int r5 = r5 + r2
            float r2 = (float) r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r5
            float r4 = (float) r4
            float r6 = (float) r12
            float r6 = r6 / r5
            float r4 = r4 + r6
            com.google.a.r r5 = new com.google.a.r
            r6 = 0
            com.google.a.t[] r7 = new com.google.a.t[r13]
            com.google.a.t r8 = new com.google.a.t
            r10 = r17
            float r9 = (float) r10
            r8.<init>(r2, r9)
            r7[r3] = r8
            com.google.a.t r2 = new com.google.a.t
            r2.<init>(r4, r9)
            r7[r11] = r2
            com.google.a.a r2 = com.google.a.a.CODE_93
            r5.<init>(r1, r6, r7, r2)
            return r5
        L_0x0188:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x018d:
            r10 = r17
            r4 = r9
            goto L_0x004d
        L_0x0192:
            r10 = r17
            int r9 = r9 + 1
            goto L_0x005c
        L_0x0198:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x019d:
            r10 = r17
            r12 = r5[r3]
            r14 = r5[r11]
            int r12 = r12 + r14
            int r9 = r9 + r12
            int r12 = r8 + -1
            java.lang.System.arraycopy(r5, r13, r5, r3, r12)
            r5[r12] = r3
            r5[r8] = r3
            int r8 = r8 + -1
            goto L_0x01b5
        L_0x01b1:
            r10 = r17
            int r8 = r8 + 1
        L_0x01b5:
            r5[r8] = r11
            r7 = r7 ^ 1
        L_0x01b9:
            int r4 = r4 + 1
            goto L_0x0016
        L_0x01bd:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.g.a(int, com.google.a.c.a, java.util.Map):com.google.a.r");
    }
}

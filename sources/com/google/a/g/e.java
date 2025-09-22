package com.google.a.g;

import android.support.v7.widget.ActivityChooserView;
import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import com.cyjh.mobileanjian.ipc.share.proto.a;
import com.google.a.m;

public final class e extends r {

    /* renamed from: a  reason: collision with root package name */
    static final String f3199a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";

    /* renamed from: b  reason: collision with root package name */
    static final int[] f3200b = {52, 289, 97, 352, 49, UiMessage.CommandToUi.Command_Type.SET_TEXT_VALUE, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, a.aK, 67, 322, 19, a.aQ, 82, 7, a.aN, 70, 22, 385, 193, 448, 145, 400, UiMessage.CommandToUi.Command_Type.SET_TAB_VALUE, 133, 388, 196, 168, 162, 138, 42};

    /* renamed from: c  reason: collision with root package name */
    static final int f3201c = 148;
    private final boolean d;
    private final boolean e;
    private final StringBuilder f;
    private final int[] g;

    public e() {
        this(false);
    }

    public e(boolean z) {
        this(z, (byte) 0);
    }

    private e(boolean z, byte b2) {
        this.d = z;
        this.e = false;
        this.f = new StringBuilder(20);
        this.g = new int[9];
    }

    private static char a(int i) throws m {
        for (int i2 = 0; i2 < f3200b.length; i2++) {
            if (f3200b[i2] == i) {
                return f3199a.charAt(i2);
            }
        }
        if (i == f3201c) {
            return '*';
        }
        throw m.getNotFoundInstance();
    }

    private static int a(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if ((i10 << 1) >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            } else if (i4 <= 3) {
                return -1;
            } else {
                i = i2;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        r4 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.CharSequence r10) throws com.google.a.h {
        /*
            int r0 = r10.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = 0
        L_0x000b:
            if (r3 >= r0) goto L_0x00b6
            char r4 = r10.charAt(r3)
            r5 = 47
            r6 = 43
            if (r4 == r6) goto L_0x0021
            r7 = 36
            if (r4 == r7) goto L_0x0021
            r7 = 37
            if (r4 == r7) goto L_0x0021
            if (r4 != r5) goto L_0x00aa
        L_0x0021:
            int r3 = r3 + 1
            char r7 = r10.charAt(r3)
            r8 = 90
            r9 = 65
            if (r4 == r6) goto L_0x00a3
            r6 = 79
            if (r4 == r5) goto L_0x0092
            switch(r4) {
                case 36: goto L_0x0085;
                case 37: goto L_0x0037;
                default: goto L_0x0034;
            }
        L_0x0034:
            r4 = 0
            goto L_0x00aa
        L_0x0037:
            if (r7 < r9) goto L_0x0040
            r4 = 69
            if (r7 > r4) goto L_0x0040
            int r7 = r7 + -38
            goto L_0x008b
        L_0x0040:
            r4 = 70
            if (r7 < r4) goto L_0x004b
            r4 = 74
            if (r7 > r4) goto L_0x004b
            int r7 = r7 + -11
            goto L_0x008b
        L_0x004b:
            r4 = 75
            if (r7 < r4) goto L_0x0054
            if (r7 > r6) goto L_0x0054
            int r7 = r7 + 16
            goto L_0x008b
        L_0x0054:
            r4 = 80
            if (r7 < r4) goto L_0x005f
            r4 = 84
            if (r7 > r4) goto L_0x005f
            int r7 = r7 + 43
            goto L_0x008b
        L_0x005f:
            r4 = 85
            if (r7 != r4) goto L_0x0064
            goto L_0x0034
        L_0x0064:
            r4 = 86
            if (r7 != r4) goto L_0x006b
            r4 = 64
            goto L_0x00aa
        L_0x006b:
            r4 = 87
            if (r7 != r4) goto L_0x0072
            r4 = 96
            goto L_0x00aa
        L_0x0072:
            r4 = 88
            if (r7 == r4) goto L_0x0082
            r4 = 89
            if (r7 == r4) goto L_0x0082
            if (r7 != r8) goto L_0x007d
            goto L_0x0082
        L_0x007d:
            com.google.a.h r10 = com.google.a.h.getFormatInstance()
            throw r10
        L_0x0082:
            r4 = 127(0x7f, float:1.78E-43)
            goto L_0x00aa
        L_0x0085:
            if (r7 < r9) goto L_0x008d
            if (r7 > r8) goto L_0x008d
            int r7 = r7 + -64
        L_0x008b:
            char r4 = (char) r7
            goto L_0x00aa
        L_0x008d:
            com.google.a.h r10 = com.google.a.h.getFormatInstance()
            throw r10
        L_0x0092:
            if (r7 < r9) goto L_0x0099
            if (r7 > r6) goto L_0x0099
            int r7 = r7 + -32
            goto L_0x008b
        L_0x0099:
            if (r7 != r8) goto L_0x009e
            r4 = 58
            goto L_0x00aa
        L_0x009e:
            com.google.a.h r10 = com.google.a.h.getFormatInstance()
            throw r10
        L_0x00a3:
            if (r7 < r9) goto L_0x00b1
            if (r7 > r8) goto L_0x00b1
            int r7 = r7 + 32
            goto L_0x008b
        L_0x00aa:
            r1.append(r4)
            int r3 = r3 + 1
            goto L_0x000b
        L_0x00b1:
            com.google.a.h r10 = com.google.a.h.getFormatInstance()
            throw r10
        L_0x00b6:
            java.lang.String r10 = r1.toString()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.e.a(java.lang.CharSequence):java.lang.String");
    }

    private static int[] a(com.google.a.c.a aVar, int[] iArr) throws m {
        int i = aVar.f3055b;
        int c2 = aVar.c(0);
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
                } else if (a(iArr) != f3201c || !aVar.a(Math.max(0, i2 - ((c2 - i2) / 2)), i2)) {
                    i2 += iArr[0] + iArr[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i3--;
                } else {
                    return new int[]{i2, c2};
                }
                iArr[i3] = 1;
                z = !z;
            }
            c2++;
        }
        throw m.getNotFoundInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x012e, code lost:
        r2 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.r a(int r19, com.google.a.c.a r20, java.util.Map<com.google.a.e, ?> r21) throws com.google.a.m, com.google.a.d, com.google.a.h {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            int[] r2 = r0.g
            r3 = 0
            java.util.Arrays.fill(r2, r3)
            java.lang.StringBuilder r4 = r0.f
            r4.setLength(r3)
            int r5 = r1.f3055b
            int r6 = r1.c(r3)
            int r7 = r2.length
            r10 = r6
            r8 = 0
            r9 = 0
        L_0x0019:
            if (r6 >= r5) goto L_0x0210
            boolean r11 = r1.a((int) r6)
            r12 = 1
            if (r11 == r8) goto L_0x002b
            r11 = r2[r9]
            int r11 = r11 + r12
            r2[r9] = r11
            r11 = r19
            goto L_0x020c
        L_0x002b:
            int r11 = r7 + -1
            if (r9 != r11) goto L_0x0204
            int r11 = a((int[]) r2)
            r13 = 148(0x94, float:2.07E-43)
            r14 = 2
            if (r11 != r13) goto L_0x01ef
            int r11 = r6 - r10
            int r11 = r11 / r14
            int r11 = r10 - r11
            int r11 = java.lang.Math.max(r3, r11)
            boolean r11 = r1.a(r11, r10)
            if (r11 == 0) goto L_0x01ef
            int[] r5 = new int[r14]
            r5[r3] = r10
            r5[r12] = r6
            r6 = r5[r12]
            int r6 = r1.c(r6)
            int r7 = r1.f3055b
        L_0x0055:
            a((com.google.a.c.a) r1, (int) r6, (int[]) r2)
            int r8 = a((int[]) r2)
            if (r8 >= 0) goto L_0x0063
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0063:
            r9 = 0
        L_0x0064:
            int[] r10 = f3200b
            int r10 = r10.length
            r11 = 42
            if (r9 >= r10) goto L_0x007b
            int[] r10 = f3200b
            r10 = r10[r9]
            if (r10 != r8) goto L_0x0078
            java.lang.String r8 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%"
            char r8 = r8.charAt(r9)
            goto L_0x007f
        L_0x0078:
            int r9 = r9 + 1
            goto L_0x0064
        L_0x007b:
            if (r8 != r13) goto L_0x01ea
            r8 = 42
        L_0x007f:
            r4.append(r8)
            int r9 = r2.length
            r15 = r6
            r10 = 0
        L_0x0085:
            if (r10 >= r9) goto L_0x008e
            r16 = r2[r10]
            int r15 = r15 + r16
            int r10 = r10 + 1
            goto L_0x0085
        L_0x008e:
            int r9 = r1.c(r15)
            if (r8 != r11) goto L_0x01e5
            int r1 = r4.length()
            int r1 = r1 - r12
            r4.setLength(r1)
            int r1 = r2.length
            r8 = 0
            r10 = 0
        L_0x009f:
            if (r8 >= r1) goto L_0x00a7
            r11 = r2[r8]
            int r10 = r10 + r11
            int r8 = r8 + 1
            goto L_0x009f
        L_0x00a7:
            int r1 = r9 - r6
            int r1 = r1 - r10
            if (r9 == r7) goto L_0x00b4
            int r1 = r1 << r12
            if (r1 >= r10) goto L_0x00b4
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x00b4:
            boolean r1 = r0.d
            r2 = 43
            if (r1 == 0) goto L_0x00e8
            int r1 = r4.length()
            int r1 = r1 - r12
            r7 = 0
            r8 = 0
        L_0x00c1:
            if (r7 >= r1) goto L_0x00d3
            java.lang.String r9 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%"
            java.lang.StringBuilder r11 = r0.f
            char r11 = r11.charAt(r7)
            int r9 = r9.indexOf(r11)
            int r8 = r8 + r9
            int r7 = r7 + 1
            goto L_0x00c1
        L_0x00d3:
            char r7 = r4.charAt(r1)
            java.lang.String r9 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%"
            int r8 = r8 % r2
            char r8 = r9.charAt(r8)
            if (r7 == r8) goto L_0x00e5
            com.google.a.d r1 = com.google.a.d.getChecksumInstance()
            throw r1
        L_0x00e5:
            r4.setLength(r1)
        L_0x00e8:
            int r1 = r4.length()
            if (r1 != 0) goto L_0x00f3
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x00f3:
            boolean r1 = r0.e
            if (r1 == 0) goto L_0x01b7
            int r1 = r4.length()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r1)
            r8 = 0
        L_0x0101:
            if (r8 >= r1) goto L_0x01b2
            char r9 = r4.charAt(r8)
            r11 = 47
            if (r9 == r2) goto L_0x011b
            r13 = 36
            if (r9 == r13) goto L_0x011b
            r13 = 37
            if (r9 == r13) goto L_0x011b
            if (r9 != r11) goto L_0x0116
            goto L_0x011b
        L_0x0116:
            r7.append(r9)
            goto L_0x01a7
        L_0x011b:
            int r8 = r8 + 1
            char r13 = r4.charAt(r8)
            r15 = 90
            r14 = 65
            if (r9 == r2) goto L_0x019d
            r2 = 79
            if (r9 == r11) goto L_0x018c
            switch(r9) {
                case 36: goto L_0x017f;
                case 37: goto L_0x0131;
                default: goto L_0x012e;
            }
        L_0x012e:
            r2 = 0
            goto L_0x01a4
        L_0x0131:
            if (r13 < r14) goto L_0x013a
            r9 = 69
            if (r13 > r9) goto L_0x013a
            int r13 = r13 + -38
            goto L_0x0185
        L_0x013a:
            r9 = 70
            if (r13 < r9) goto L_0x0145
            r9 = 74
            if (r13 > r9) goto L_0x0145
            int r13 = r13 + -11
            goto L_0x0185
        L_0x0145:
            r9 = 75
            if (r13 < r9) goto L_0x014e
            if (r13 > r2) goto L_0x014e
            int r13 = r13 + 16
            goto L_0x0185
        L_0x014e:
            r2 = 80
            if (r13 < r2) goto L_0x0159
            r2 = 84
            if (r13 > r2) goto L_0x0159
            int r13 = r13 + 43
            goto L_0x0185
        L_0x0159:
            r2 = 85
            if (r13 != r2) goto L_0x015e
            goto L_0x012e
        L_0x015e:
            r2 = 86
            if (r13 != r2) goto L_0x0165
            r2 = 64
            goto L_0x01a4
        L_0x0165:
            r2 = 87
            if (r13 != r2) goto L_0x016c
            r2 = 96
            goto L_0x01a4
        L_0x016c:
            r2 = 88
            if (r13 == r2) goto L_0x017c
            r2 = 89
            if (r13 == r2) goto L_0x017c
            if (r13 != r15) goto L_0x0177
            goto L_0x017c
        L_0x0177:
            com.google.a.h r1 = com.google.a.h.getFormatInstance()
            throw r1
        L_0x017c:
            r2 = 127(0x7f, float:1.78E-43)
            goto L_0x01a4
        L_0x017f:
            if (r13 < r14) goto L_0x0187
            if (r13 > r15) goto L_0x0187
            int r13 = r13 + -64
        L_0x0185:
            char r2 = (char) r13
            goto L_0x01a4
        L_0x0187:
            com.google.a.h r1 = com.google.a.h.getFormatInstance()
            throw r1
        L_0x018c:
            if (r13 < r14) goto L_0x0193
            if (r13 > r2) goto L_0x0193
            int r13 = r13 + -32
            goto L_0x0185
        L_0x0193:
            if (r13 != r15) goto L_0x0198
            r2 = 58
            goto L_0x01a4
        L_0x0198:
            com.google.a.h r1 = com.google.a.h.getFormatInstance()
            throw r1
        L_0x019d:
            if (r13 < r14) goto L_0x01ad
            if (r13 > r15) goto L_0x01ad
            int r13 = r13 + 32
            goto L_0x0185
        L_0x01a4:
            r7.append(r2)
        L_0x01a7:
            int r8 = r8 + r12
            r2 = 43
            r14 = 2
            goto L_0x0101
        L_0x01ad:
            com.google.a.h r1 = com.google.a.h.getFormatInstance()
            throw r1
        L_0x01b2:
            java.lang.String r1 = r7.toString()
            goto L_0x01bb
        L_0x01b7:
            java.lang.String r1 = r4.toString()
        L_0x01bb:
            r2 = r5[r12]
            r4 = r5[r3]
            int r2 = r2 + r4
            float r2 = (float) r2
            r4 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r4
            float r5 = (float) r6
            float r6 = (float) r10
            float r6 = r6 / r4
            float r5 = r5 + r6
            com.google.a.r r4 = new com.google.a.r
            r6 = 0
            r7 = 2
            com.google.a.t[] r7 = new com.google.a.t[r7]
            com.google.a.t r8 = new com.google.a.t
            r11 = r19
            float r9 = (float) r11
            r8.<init>(r2, r9)
            r7[r3] = r8
            com.google.a.t r2 = new com.google.a.t
            r2.<init>(r5, r9)
            r7[r12] = r2
            com.google.a.a r2 = com.google.a.a.CODE_39
            r4.<init>(r1, r6, r7, r2)
            return r4
        L_0x01e5:
            r11 = r19
            r6 = r9
            goto L_0x0055
        L_0x01ea:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x01ef:
            r11 = r19
            r13 = r2[r3]
            r14 = r2[r12]
            int r13 = r13 + r14
            int r10 = r10 + r13
            int r13 = r9 + -1
            r14 = 2
            java.lang.System.arraycopy(r2, r14, r2, r3, r13)
            r2[r13] = r3
            r2[r9] = r3
            int r9 = r9 + -1
            goto L_0x0208
        L_0x0204:
            r11 = r19
            int r9 = r9 + 1
        L_0x0208:
            r2[r9] = r12
            r8 = r8 ^ 1
        L_0x020c:
            int r6 = r6 + 1
            goto L_0x0019
        L_0x0210:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.e.a(int, com.google.a.c.a, java.util.Map):com.google.a.r");
    }
}

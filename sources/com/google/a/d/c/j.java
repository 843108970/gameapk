package com.google.a.d.c;

import android.support.v7.widget.ActivityChooserView;
import com.cyjh.mobileanjian.ipc.share.proto.a;
import com.google.a.f;
import java.util.Arrays;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    static final char f3122a = 'æ';

    /* renamed from: b  reason: collision with root package name */
    static final char f3123b = 'ç';

    /* renamed from: c  reason: collision with root package name */
    static final char f3124c = 'ë';
    static final char d = 'î';
    static final char e = 'ï';
    static final char f = 'ð';
    static final char g = 'þ';
    static final char h = 'þ';
    static final int i = 0;
    static final int j = 1;
    static final int k = 2;
    static final int l = 3;
    static final int m = 4;
    static final int n = 5;
    private static final char o = '';
    private static final char p = 'ì';
    private static final char q = 'í';
    private static final String r = "[)>\u001e05\u001d";
    private static final String s = "[)>\u001e06\u001d";
    private static final String t = "\u001e\u0004";

    private j() {
    }

    private static char a(int i2) {
        int i3 = ((i2 * 149) % 253) + 1 + a.aG;
        if (i3 > 254) {
            i3 -= 254;
        }
        return (char) i3;
    }

    private static int a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        if (i2 < length) {
            loop0:
            while (true) {
                char charAt = charSequence.charAt(i2);
                while (true) {
                    if (!a(charAt) || i2 >= length) {
                        break loop0;
                    }
                    i3++;
                    i2++;
                    if (i2 < length) {
                    }
                }
            }
        }
        return i3;
    }

    static int a(CharSequence charSequence, int i2, int i3) {
        float[] fArr;
        CharSequence charSequence2 = charSequence;
        int i4 = i2;
        if (i4 >= charSequence.length()) {
            return i3;
        }
        if (i3 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            float[] fArr2 = {1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr2[i3] = 0.0f;
            fArr = fArr2;
        }
        int i5 = 0;
        while (true) {
            int i6 = i4 + i5;
            if (i6 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int a2 = a(fArr, iArr, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, bArr);
                int a3 = a(bArr);
                if (iArr[0] == a2) {
                    return 0;
                }
                if (a3 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (a3 == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (a3 != 1 || bArr[2] <= 0) {
                    return (a3 != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char charAt = charSequence2.charAt(i6);
            i5++;
            if (a(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (b(charAt)) {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (charAt == ' ' || (charAt >= '0' && charAt <= '9') || (charAt >= 'A' && charAt <= 'Z')) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (b(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (charAt == ' ' || (charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'z')) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (b(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (f(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (b(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (charAt >= ' ' && charAt <= '^') {
                fArr[4] = fArr[4] + 0.75f;
            } else if (b(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            fArr[5] = fArr[5] + 1.0f;
            if (i5 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                a(fArr, iArr2, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, bArr2);
                int a4 = a(bArr2);
                if (iArr2[0] < iArr2[5] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (a4 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (a4 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (a4 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        int i7 = i4 + i5 + 1;
                        while (i7 < charSequence.length()) {
                            char charAt2 = charSequence2.charAt(i7);
                            if (!g(charAt2)) {
                                if (!f(charAt2)) {
                                    break;
                                }
                                i7++;
                            } else {
                                return 3;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    private static int a(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 += bArr[i3];
        }
        return i2;
    }

    private static int a(float[] fArr, int[] iArr, int i2, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i3 = i2;
        for (int i4 = 0; i4 < 6; i4++) {
            iArr[i4] = (int) Math.ceil((double) fArr[i4]);
            int i5 = iArr[i4];
            if (i3 > i5) {
                Arrays.fill(bArr, (byte) 0);
                i3 = i5;
            }
            if (i3 == i5) {
                bArr[i4] = (byte) (bArr[i4] + 1);
            }
        }
        return i3;
    }

    private static String a(String str) {
        return a(str, l.FORCE_NONE, (f) null, (f) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r7, com.google.a.d.c.l r8, com.google.a.f r9, com.google.a.f r10) {
        /*
            r0 = 6
            com.google.a.d.c.g[] r0 = new com.google.a.d.c.g[r0]
            com.google.a.d.c.a r1 = new com.google.a.d.c.a
            r1.<init>()
            r2 = 0
            r0[r2] = r1
            com.google.a.d.c.c r1 = new com.google.a.d.c.c
            r1.<init>()
            r3 = 1
            r0[r3] = r1
            com.google.a.d.c.m r1 = new com.google.a.d.c.m
            r1.<init>()
            r4 = 2
            r0[r4] = r1
            com.google.a.d.c.n r1 = new com.google.a.d.c.n
            r1.<init>()
            r5 = 3
            r0[r5] = r1
            com.google.a.d.c.f r1 = new com.google.a.d.c.f
            r1.<init>()
            r5 = 4
            r0[r5] = r1
            com.google.a.d.c.b r1 = new com.google.a.d.c.b
            r1.<init>()
            r6 = 5
            r0[r6] = r1
            com.google.a.d.c.h r1 = new com.google.a.d.c.h
            r1.<init>(r7)
            r1.f3117b = r8
            r1.f3118c = r9
            r1.d = r10
            java.lang.String r8 = "[)>\u001e05\u001d"
            boolean r8 = r7.startsWith(r8)
            if (r8 == 0) goto L_0x005c
            java.lang.String r8 = "\u001e\u0004"
            boolean r8 = r7.endsWith(r8)
            if (r8 == 0) goto L_0x005c
            r7 = 236(0xec, float:3.31E-43)
        L_0x0050:
            r1.a((char) r7)
            r1.i = r4
            int r7 = r1.f
            int r7 = r7 + 7
            r1.f = r7
            goto L_0x006f
        L_0x005c:
            java.lang.String r8 = "[)>\u001e06\u001d"
            boolean r8 = r7.startsWith(r8)
            if (r8 == 0) goto L_0x006f
            java.lang.String r8 = "\u001e\u0004"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x006f
            r7 = 237(0xed, float:3.32E-43)
            goto L_0x0050
        L_0x006f:
            boolean r7 = r1.b()
            if (r7 == 0) goto L_0x0084
            r7 = r0[r2]
            r7.a(r1)
            int r7 = r1.g
            if (r7 < 0) goto L_0x006f
            int r2 = r1.g
            r7 = -1
            r1.g = r7
            goto L_0x006f
        L_0x0084:
            java.lang.StringBuilder r7 = r1.e
            int r7 = r7.length()
            r1.d()
            com.google.a.d.c.k r8 = r1.h
            int r8 = r8.f3126b
            r9 = 254(0xfe, float:3.56E-43)
            if (r7 >= r8) goto L_0x009e
            if (r2 == 0) goto L_0x009e
            if (r2 == r6) goto L_0x009e
            if (r2 == r5) goto L_0x009e
            r1.a((char) r9)
        L_0x009e:
            java.lang.StringBuilder r7 = r1.e
            int r10 = r7.length()
            r0 = 129(0x81, float:1.81E-43)
            if (r10 >= r8) goto L_0x00ab
            r7.append(r0)
        L_0x00ab:
            int r10 = r7.length()
            if (r10 >= r8) goto L_0x00c6
            int r10 = r7.length()
            int r10 = r10 + r3
            int r10 = r10 * 149
            int r10 = r10 % 253
            int r10 = r10 + r3
            int r10 = r10 + r0
            if (r10 > r9) goto L_0x00bf
            goto L_0x00c1
        L_0x00bf:
            int r10 = r10 + -254
        L_0x00c1:
            char r10 = (char) r10
            r7.append(r10)
            goto L_0x00ab
        L_0x00c6:
            java.lang.StringBuilder r7 = r1.e
            java.lang.String r7 = r7.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.c.j.a(java.lang.String, com.google.a.d.c.l, com.google.a.f, com.google.a.f):java.lang.String");
    }

    private static boolean a() {
        return false;
    }

    static boolean a(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    static boolean b(char c2) {
        return c2 >= 128 && c2 <= 255;
    }

    static void c(char c2) {
        String hexString = Integer.toHexString(c2);
        throw new IllegalArgumentException("Illegal character: " + c2 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    private static boolean d(char c2) {
        if (c2 == ' ') {
            return true;
        }
        if (c2 < '0' || c2 > '9') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean e(char c2) {
        if (c2 == ' ') {
            return true;
        }
        if (c2 < '0' || c2 > '9') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    private static boolean f(char c2) {
        if (g(c2) || c2 == ' ') {
            return true;
        }
        if (c2 < '0' || c2 > '9') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean g(char c2) {
        return c2 == 13 || c2 == '*' || c2 == '>';
    }

    private static boolean h(char c2) {
        return c2 >= ' ' && c2 <= '^';
    }
}

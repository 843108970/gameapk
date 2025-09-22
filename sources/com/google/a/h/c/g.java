package com.google.a.h.c;

import com.google.a.c.d;
import com.google.a.w;
import com.umeng.commonsdk.proguard.bg;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3286a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f3287b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3288c = 2;
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private static final int h = 900;
    private static final int i = 901;
    private static final int j = 902;
    private static final int k = 913;
    private static final int l = 924;
    private static final int m = 925;
    private static final int n = 926;
    private static final int o = 927;
    private static final byte[] p = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, bg.k, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] q = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, bg.k, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
    private static final byte[] r = new byte[128];
    private static final byte[] s = new byte[128];
    private static final Charset t = StandardCharsets.ISO_8859_1;

    static {
        Arrays.fill(r, (byte) -1);
        for (int i2 = 0; i2 < p.length; i2++) {
            byte b2 = p[i2];
            if (b2 > 0) {
                r[b2] = (byte) i2;
            }
        }
        Arrays.fill(s, (byte) -1);
        for (int i3 = 0; i3 < q.length; i3++) {
            byte b3 = q[i3];
            if (b3 > 0) {
                s[b3] = (byte) i3;
            }
        }
    }

    private g() {
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

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0098, code lost:
        if (r11 == ' ') goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009a, code lost:
        r3.append(26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009e, code lost:
        r11 = r11 - 'A';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a0, code lost:
        r10 = (char) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
        r3.append(27);
        r9 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b4, code lost:
        r3.append(28);
        r9 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c3, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c5, code lost:
        if (r8 < r1) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c7, code lost:
        r0 = r3.length();
        r1 = 0;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cd, code lost:
        if (r1 >= r0) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d1, code lost:
        if ((r1 % 2) == 0) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d3, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d5, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d6, code lost:
        if (r8 == false) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d8, code lost:
        r7 = (char) ((r7 * 30) + r3.charAt(r1));
        r2.append(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e4, code lost:
        r7 = r3.charAt(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e8, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ec, code lost:
        if ((r0 % 2) == 0) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ee, code lost:
        r2.append((char) ((r7 * 30) + 29));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f5, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00f9, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002d, code lost:
        r10 = (char) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
        r3.append(r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.CharSequence r17, int r18, int r19, java.lang.StringBuilder r20, int r21) {
        /*
            r0 = r17
            r1 = r19
            r2 = r20
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r4 = 2
            r6 = 0
            r9 = r21
            r8 = 0
        L_0x0010:
            int r10 = r18 + r8
            char r11 = r0.charAt(r10)
            r12 = 26
            r13 = 32
            r14 = 27
            r15 = 28
            r5 = 29
            switch(r9) {
                case 0: goto L_0x0092;
                case 1: goto L_0x006d;
                case 2: goto L_0x0033;
                default: goto L_0x0023;
            }
        L_0x0023:
            boolean r10 = e(r11)
            if (r10 == 0) goto L_0x00f6
            byte[] r10 = s
            byte r10 = r10[r11]
        L_0x002d:
            char r10 = (char) r10
        L_0x002e:
            r3.append(r10)
            goto L_0x00c3
        L_0x0033:
            boolean r12 = d(r11)
            if (r12 == 0) goto L_0x003e
            byte[] r10 = r
            byte r10 = r10[r11]
            goto L_0x002d
        L_0x003e:
            boolean r12 = b(r11)
            if (r12 == 0) goto L_0x0049
            r3.append(r15)
            goto L_0x00f9
        L_0x0049:
            boolean r12 = c(r11)
            if (r12 == 0) goto L_0x0050
            goto L_0x00a8
        L_0x0050:
            int r10 = r10 + 1
            if (r10 >= r1) goto L_0x0065
            char r10 = r0.charAt(r10)
            boolean r10 = e(r10)
            if (r10 == 0) goto L_0x0065
            r9 = 3
            r5 = 25
            r3.append(r5)
            goto L_0x0010
        L_0x0065:
            r3.append(r5)
            byte[] r10 = s
            byte r10 = r10[r11]
            goto L_0x002d
        L_0x006d:
            boolean r10 = c(r11)
            if (r10 == 0) goto L_0x0079
            if (r11 != r13) goto L_0x0076
            goto L_0x009a
        L_0x0076:
            int r11 = r11 + -97
            goto L_0x00a0
        L_0x0079:
            boolean r10 = b(r11)
            if (r10 == 0) goto L_0x0083
            r3.append(r14)
            goto L_0x009e
        L_0x0083:
            boolean r10 = d(r11)
            if (r10 == 0) goto L_0x008a
            goto L_0x00b4
        L_0x008a:
            r3.append(r5)
            byte[] r10 = s
            byte r10 = r10[r11]
            goto L_0x002d
        L_0x0092:
            boolean r10 = b(r11)
            if (r10 == 0) goto L_0x00a2
            if (r11 != r13) goto L_0x009e
        L_0x009a:
            r3.append(r12)
            goto L_0x00c3
        L_0x009e:
            int r11 = r11 + -65
        L_0x00a0:
            char r10 = (char) r11
            goto L_0x002e
        L_0x00a2:
            boolean r10 = c(r11)
            if (r10 == 0) goto L_0x00ae
        L_0x00a8:
            r3.append(r14)
            r9 = 1
            goto L_0x0010
        L_0x00ae:
            boolean r10 = d(r11)
            if (r10 == 0) goto L_0x00ba
        L_0x00b4:
            r3.append(r15)
            r9 = 2
            goto L_0x0010
        L_0x00ba:
            r3.append(r5)
            byte[] r10 = s
            byte r10 = r10[r11]
            goto L_0x002d
        L_0x00c3:
            int r8 = r8 + 1
            if (r8 < r1) goto L_0x0010
            int r0 = r3.length()
            r1 = 0
            r7 = 0
        L_0x00cd:
            if (r1 >= r0) goto L_0x00eb
            int r8 = r1 % 2
            if (r8 == 0) goto L_0x00d5
            r8 = 1
            goto L_0x00d6
        L_0x00d5:
            r8 = 0
        L_0x00d6:
            if (r8 == 0) goto L_0x00e4
            int r7 = r7 * 30
            char r8 = r3.charAt(r1)
            int r7 = r7 + r8
            char r7 = (char) r7
            r2.append(r7)
            goto L_0x00e8
        L_0x00e4:
            char r7 = r3.charAt(r1)
        L_0x00e8:
            int r1 = r1 + 1
            goto L_0x00cd
        L_0x00eb:
            int r0 = r0 % r4
            if (r0 == 0) goto L_0x00f5
            int r7 = r7 * 30
            int r7 = r7 + r5
            char r0 = (char) r7
            r2.append(r0)
        L_0x00f5:
            return r9
        L_0x00f6:
            r3.append(r5)
        L_0x00f9:
            r9 = 0
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.c.g.a(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.String r5, int r6, java.nio.charset.Charset r7) throws com.google.a.w {
        /*
            java.nio.charset.CharsetEncoder r7 = r7.newEncoder()
            int r0 = r5.length()
            r1 = r6
        L_0x0009:
            if (r1 >= r0) goto L_0x0057
            char r2 = r5.charAt(r1)
            r3 = 0
        L_0x0010:
            r4 = 13
            if (r3 >= r4) goto L_0x0025
            boolean r2 = a(r2)
            if (r2 == 0) goto L_0x0025
            int r3 = r3 + 1
            int r2 = r1 + r3
            if (r2 >= r0) goto L_0x0025
            char r2 = r5.charAt(r2)
            goto L_0x0010
        L_0x0025:
            if (r3 < r4) goto L_0x0029
            int r1 = r1 - r6
            return r1
        L_0x0029:
            char r2 = r5.charAt(r1)
            boolean r3 = r7.canEncode(r2)
            if (r3 != 0) goto L_0x0054
            com.google.a.w r5 = new com.google.a.w
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Non-encodable character detected: "
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r7 = " (Unicode: "
            r6.append(r7)
            r6.append(r2)
            r7 = 41
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0054:
            int r1 = r1 + 1
            goto L_0x0009
        L_0x0057:
            int r1 = r1 - r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.c.g.a(java.lang.String, int, java.nio.charset.Charset):int");
    }

    public static String a(String str, c cVar, Charset charset) throws w {
        int i2;
        d characterSetECIByName;
        char c2;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = t;
        } else if (!t.equals(charset) && (characterSetECIByName = d.getCharacterSetECIByName(charset.name())) != null) {
            int value = characterSetECIByName.getValue();
            if (value >= 0 && value < h) {
                sb.append(927);
            } else if (value < 810900) {
                sb.append(926);
                sb.append((char) ((value / h) - 1));
                value %= h;
            } else if (value < 811800) {
                sb.append(925);
                c2 = (char) (810900 - value);
                sb.append(c2);
            } else {
                throw new w("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(value)));
            }
            c2 = (char) value;
            sb.append(c2);
        }
        int length = str.length();
        switch (cVar) {
            case TEXT:
                a(str, 0, length, sb, 0);
                break;
            case BYTE:
                byte[] bytes = str.getBytes(charset);
                a(bytes, bytes.length, 1, sb);
                break;
            case NUMERIC:
                sb.append(902);
                a(str, 0, length, sb);
                break;
            default:
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    int i5 = 0;
                    while (i2 < length) {
                        int a2 = a((CharSequence) str, i2);
                        if (a2 >= 13) {
                            sb.append(902);
                            i4 = 2;
                            a(str, i2, a2, sb);
                            i3 = i2 + a2;
                        } else {
                            int b2 = b(str, i2);
                            if (b2 >= 5 || a2 == length) {
                                if (i4 != 0) {
                                    sb.append(900);
                                    i4 = 0;
                                    i5 = 0;
                                }
                                i5 = a(str, i2, b2, sb, i5);
                                i2 += b2;
                            } else {
                                int a3 = a(str, i2, charset);
                                if (a3 == 0) {
                                    a3 = 1;
                                }
                                int i6 = a3 + i2;
                                byte[] bytes2 = str.substring(i2, i6).getBytes(charset);
                                if (bytes2.length == 1 && i4 == 0) {
                                    a(bytes2, 1, 0, sb);
                                } else {
                                    a(bytes2, bytes2.length, i4, sb);
                                    i4 = 1;
                                    i5 = 0;
                                }
                                i2 = i6;
                            }
                        }
                    }
                    break;
                }
        }
        return sb.toString();
    }

    private static void a(int i2, StringBuilder sb) throws w {
        char c2;
        if (i2 >= 0 && i2 < h) {
            sb.append(927);
        } else if (i2 < 810900) {
            sb.append(926);
            sb.append((char) ((i2 / h) - 1));
            i2 %= h;
        } else if (i2 < 811800) {
            sb.append(925);
            c2 = (char) (810900 - i2);
            sb.append(c2);
        } else {
            throw new w("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i2)));
        }
        c2 = (char) i2;
        sb.append(c2);
    }

    private static void a(String str, int i2, int i3, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i3 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i4 = 0;
        while (i4 < i3) {
            sb2.setLength(0);
            int min = Math.min(44, i3 - i4);
            StringBuilder sb3 = new StringBuilder("1");
            int i5 = i2 + i4;
            sb3.append(str.substring(i5, i5 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i4 += min;
        }
    }

    private static void a(byte[] bArr, int i2, int i3, StringBuilder sb) {
        int i4;
        sb.append((i2 == 1 && i3 == 0) ? 913 : i2 % 6 == 0 ? (char) 924 : 901);
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = 0;
            while ((i2 + 0) - i4 >= 6) {
                long j2 = 0;
                int i5 = 0;
                while (i5 < 6) {
                    i5++;
                    j2 = (j2 << 8) + ((long) (bArr[i4 + i5] & 255));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) ((int) (j2 % 900));
                    j2 /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = 0;
        }
        while (i4 < i2 + 0) {
            sb.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    private static boolean a(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static int b(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = i2;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            boolean z = false;
            int i4 = i3;
            int i5 = 0;
            while (i5 < 13 && a(charAt) && i4 < length) {
                i5++;
                i4++;
                if (i4 < length) {
                    charAt = charSequence.charAt(i4);
                }
            }
            if (i5 >= 13) {
                return (i4 - i2) - i5;
            }
            if (i5 <= 0) {
                char charAt2 = charSequence.charAt(i4);
                if (charAt2 == 9 || charAt2 == 10 || charAt2 == 13 || (charAt2 >= ' ' && charAt2 <= '~')) {
                    z = true;
                }
                if (!z) {
                    i3 = i4;
                    break;
                }
                i3 = i4 + 1;
            } else {
                i3 = i4;
            }
        }
        return i3 - i2;
    }

    private static boolean b(char c2) {
        if (c2 != ' ') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean c(char c2) {
        if (c2 != ' ') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    private static boolean d(char c2) {
        return r[c2] != -1;
    }

    private static boolean e(char c2) {
        return s[c2] != -1;
    }

    private static boolean f(char c2) {
        if (c2 == 9 || c2 == 10 || c2 == 13) {
            return true;
        }
        return c2 >= ' ' && c2 <= '~';
    }
}

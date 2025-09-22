package com.google.a.b.a;

import com.cyjh.elfin.entity.MsgItem;
import com.google.a.r;
import java.util.regex.Pattern;

public final class ai extends u {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f3016a = Pattern.compile("[IOQ]");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f3017b = Pattern.compile("[A-Z0-9]{17}");

    private static int a(int i) {
        if (i > 0 && i <= 7) {
            return 9 - i;
        }
        if (i == 8) {
            return 10;
        }
        if (i == 9) {
            return 0;
        }
        if (i >= 10 && i <= 17) {
            return 19 - i;
        }
        throw new IllegalArgumentException();
    }

    private static boolean a(CharSequence charSequence) {
        char c2;
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (i4 < charSequence.length()) {
            int i6 = i4 + 1;
            if (i6 > 0 && i6 <= 7) {
                i = 9 - i6;
            } else if (i6 == 8) {
                i = 10;
            } else if (i6 == 9) {
                i = 0;
            } else if (i6 < 10 || i6 > 17) {
                throw new IllegalArgumentException();
            } else {
                i = 19 - i6;
            }
            char charAt = charSequence.charAt(i4);
            if (charAt >= 'A' && charAt <= 'I') {
                i3 = charAt - 'A';
            } else if (charAt >= 'J' && charAt <= 'R') {
                i3 = charAt - 'J';
            } else if (charAt >= 'S' && charAt <= 'Z') {
                i2 = (charAt - 'S') + 2;
                i5 += i * i2;
                i4 = i6;
            } else if (charAt < '0' || charAt > '9') {
                throw new IllegalArgumentException();
            } else {
                i2 = charAt - '0';
                i5 += i * i2;
                i4 = i6;
            }
            i2 = i3 + 1;
            i5 += i * i2;
            i4 = i6;
        }
        char charAt2 = charSequence.charAt(8);
        int i7 = i5 % 11;
        if (i7 < 10) {
            c2 = (char) (i7 + 48);
        } else if (i7 == 10) {
            c2 = 'X';
        } else {
            throw new IllegalArgumentException();
        }
        return charAt2 == c2;
    }

    private static char b(int i) {
        if (i < 10) {
            return (char) (i + 48);
        }
        if (i == 10) {
            return 'X';
        }
        throw new IllegalArgumentException();
    }

    private static int b(char c2) {
        if (c2 >= 'A' && c2 <= 'I') {
            return (c2 - 'A') + 1;
        }
        if (c2 >= 'J' && c2 <= 'R') {
            return (c2 - 'J') + 1;
        }
        if (c2 >= 'S' && c2 <= 'Z') {
            return (c2 - 'S') + 2;
        }
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        throw new IllegalArgumentException();
    }

    private static String b(CharSequence charSequence) {
        char charAt = charSequence.charAt(0);
        char charAt2 = charSequence.charAt(1);
        if (charAt != '9') {
            if (charAt != 'S') {
                if (charAt != 'Z') {
                    switch (charAt) {
                        case '1':
                        case '4':
                        case '5':
                            return "US";
                        case '2':
                            return "CA";
                        case '3':
                            if (charAt2 < 'A' || charAt2 > 'W') {
                                return null;
                            }
                            return "MX";
                        default:
                            switch (charAt) {
                                case 'J':
                                    if (charAt2 < 'A' || charAt2 > 'T') {
                                        return null;
                                    }
                                    return "JP";
                                case 'K':
                                    if (charAt2 < 'L' || charAt2 > 'R') {
                                        return null;
                                    }
                                    return "KO";
                                case 'L':
                                    return "CN";
                                case 'M':
                                    if (charAt2 < 'A' || charAt2 > 'E') {
                                        return null;
                                    }
                                    return "IN";
                                default:
                                    switch (charAt) {
                                        case 'V':
                                            if (charAt2 >= 'F' && charAt2 <= 'R') {
                                                return "FR";
                                            }
                                            if (charAt2 < 'S' || charAt2 > 'W') {
                                                return null;
                                            }
                                            return "ES";
                                        case 'W':
                                            return "DE";
                                        case 'X':
                                            if (charAt2 == '0') {
                                                return "RU";
                                            }
                                            if (charAt2 < '3' || charAt2 > '9') {
                                                return null;
                                            }
                                            return "RU";
                                        default:
                                            return null;
                                    }
                            }
                    }
                } else if (charAt2 < 'A' || charAt2 > 'R') {
                    return null;
                } else {
                    return "IT";
                }
            } else if (charAt2 >= 'A' && charAt2 <= 'M') {
                return "UK";
            } else {
                if (charAt2 < 'N' || charAt2 > 'T') {
                    return null;
                }
                return "DE";
            }
        } else if (charAt2 >= 'A' && charAt2 <= 'E') {
            return "BR";
        } else {
            if (charAt2 < '3' || charAt2 > '9') {
                return null;
            }
            return "BR";
        }
    }

    private static int c(char c2) {
        if (c2 >= 'E' && c2 <= 'H') {
            return (c2 - 'E') + 1984;
        }
        if (c2 >= 'J' && c2 <= 'N') {
            return (c2 - 'J') + 1988;
        }
        if (c2 == 'P') {
            return 1993;
        }
        if (c2 >= 'R' && c2 <= 'T') {
            return (c2 - 'R') + 1994;
        }
        if (c2 >= 'V' && c2 <= 'Y') {
            return (c2 - 'V') + 1997;
        }
        if (c2 >= '1' && c2 <= '9') {
            return (c2 - '1') + MsgItem.SCRIPT_NEED_START;
        }
        if (c2 >= 'A' && c2 <= 'D') {
            return (c2 - 'A') + 2010;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x013e, code lost:
        if (r4 <= 'T') goto L_0x00ea;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x015d A[Catch:{ IllegalArgumentException -> 0x01c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0164 A[Catch:{ IllegalArgumentException -> 0x01c6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.a.b.a.ah c(com.google.a.r r20) {
        /*
            r0 = r20
            com.google.a.a r1 = r0.e
            com.google.a.a r2 = com.google.a.a.CODE_39
            r3 = 0
            if (r1 == r2) goto L_0x000a
            return r3
        L_0x000a:
            java.lang.String r0 = r0.f3353a
            java.util.regex.Pattern r1 = f3016a
            java.util.regex.Matcher r0 = r1.matcher(r0)
            java.lang.String r1 = ""
            java.lang.String r0 = r0.replaceAll(r1)
            java.lang.String r5 = r0.trim()
            java.util.regex.Pattern r0 = f3017b
            java.util.regex.Matcher r0 = r0.matcher(r5)
            boolean r0 = r0.matches()
            if (r0 != 0) goto L_0x0029
            return r3
        L_0x0029:
            r1 = 0
            r2 = 0
        L_0x002b:
            int r4 = r5.length()     // Catch:{ IllegalArgumentException -> 0x01c8 }
            r6 = 8
            r7 = 48
            r8 = 83
            r9 = 74
            r10 = 57
            r11 = 10
            r12 = 9
            r13 = 1
            r14 = 82
            r15 = 65
            if (r1 >= r4) goto L_0x0096
            int r4 = r1 + 1
            if (r4 <= 0) goto L_0x004e
            r0 = 7
            if (r4 > r0) goto L_0x004e
            int r0 = 9 - r4
            goto L_0x005f
        L_0x004e:
            if (r4 != r6) goto L_0x0053
            r0 = 10
            goto L_0x005f
        L_0x0053:
            if (r4 != r12) goto L_0x0057
            r0 = 0
            goto L_0x005f
        L_0x0057:
            if (r4 < r11) goto L_0x0090
            r0 = 17
            if (r4 > r0) goto L_0x0090
            int r0 = 19 - r4
        L_0x005f:
            char r1 = r5.charAt(r1)     // Catch:{ IllegalArgumentException -> 0x01c8 }
            if (r1 < r15) goto L_0x006d
            r6 = 73
            if (r1 > r6) goto L_0x006d
            int r1 = r1 + -65
        L_0x006b:
            int r1 = r1 + r13
            goto L_0x0085
        L_0x006d:
            if (r1 < r9) goto L_0x0074
            if (r1 > r14) goto L_0x0074
            int r1 = r1 + -74
            goto L_0x006b
        L_0x0074:
            if (r1 < r8) goto L_0x007f
            r6 = 90
            if (r1 > r6) goto L_0x007f
            int r1 = r1 + -83
            int r1 = r1 + 2
            goto L_0x0085
        L_0x007f:
            if (r1 < r7) goto L_0x008a
            if (r1 > r10) goto L_0x008a
            int r1 = r1 + -48
        L_0x0085:
            int r0 = r0 * r1
            int r2 = r2 + r0
            r1 = r4
            goto L_0x002b
        L_0x008a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01c8 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x01c8 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x01c8 }
        L_0x0090:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01c8 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x01c8 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x01c8 }
        L_0x0096:
            char r0 = r5.charAt(r6)     // Catch:{ IllegalArgumentException -> 0x01c8 }
            int r2 = r2 % 11
            if (r2 >= r11) goto L_0x00a1
            int r2 = r2 + r7
            char r1 = (char) r2     // Catch:{ IllegalArgumentException -> 0x01c8 }
            goto L_0x00a5
        L_0x00a1:
            if (r2 != r11) goto L_0x01c0
            r1 = 88
        L_0x00a5:
            if (r0 != r1) goto L_0x00a9
            r0 = 1
            goto L_0x00aa
        L_0x00a9:
            r0 = 0
        L_0x00aa:
            if (r0 != 0) goto L_0x00ad
            return r3
        L_0x00ad:
            r0 = 3
            r1 = 0
            java.lang.String r2 = r5.substring(r1, r0)     // Catch:{ IllegalArgumentException -> 0x01c8 }
            com.google.a.b.a.ah r16 = new com.google.a.b.a.ah     // Catch:{ IllegalArgumentException -> 0x01c8 }
            java.lang.String r17 = r5.substring(r0, r12)     // Catch:{ IllegalArgumentException -> 0x01c8 }
            r4 = 17
            java.lang.String r18 = r5.substring(r12, r4)     // Catch:{ IllegalArgumentException -> 0x01c8 }
            char r1 = r2.charAt(r1)     // Catch:{ IllegalArgumentException -> 0x01c8 }
            char r4 = r2.charAt(r13)     // Catch:{ IllegalArgumentException -> 0x01c8 }
            r13 = 84
            r3 = 69
            if (r1 == r10) goto L_0x0141
            if (r1 == r8) goto L_0x0131
            r11 = 90
            if (r1 == r11) goto L_0x012a
            switch(r1) {
                case 49: goto L_0x0127;
                case 50: goto L_0x0124;
                case 51: goto L_0x011b;
                case 52: goto L_0x0127;
                case 53: goto L_0x0127;
                default: goto L_0x00d6;
            }
        L_0x00d6:
            switch(r1) {
                case 74: goto L_0x0114;
                case 75: goto L_0x010b;
                case 76: goto L_0x0108;
                case 77: goto L_0x0101;
                default: goto L_0x00d9;
            }
        L_0x00d9:
            switch(r1) {
                case 86: goto L_0x00ee;
                case 87: goto L_0x00ea;
                case 88: goto L_0x00de;
                default: goto L_0x00dc;
            }
        L_0x00dc:
            goto L_0x014e
        L_0x00de:
            if (r4 == r7) goto L_0x00e6
            r1 = 51
            if (r4 < r1) goto L_0x014e
            if (r4 > r10) goto L_0x014e
        L_0x00e6:
            java.lang.String r1 = "RU"
            goto L_0x014f
        L_0x00ea:
            java.lang.String r1 = "DE"
            goto L_0x014f
        L_0x00ee:
            r1 = 70
            if (r4 < r1) goto L_0x00f8
            if (r4 > r14) goto L_0x00f8
            java.lang.String r1 = "FR"
            goto L_0x014f
        L_0x00f8:
            if (r4 < r8) goto L_0x014e
            r1 = 87
            if (r4 > r1) goto L_0x014e
            java.lang.String r1 = "ES"
            goto L_0x014f
        L_0x0101:
            if (r4 < r15) goto L_0x014e
            if (r4 > r3) goto L_0x014e
            java.lang.String r1 = "IN"
            goto L_0x014f
        L_0x0108:
            java.lang.String r1 = "CN"
            goto L_0x014f
        L_0x010b:
            r1 = 76
            if (r4 < r1) goto L_0x014e
            if (r4 > r14) goto L_0x014e
            java.lang.String r1 = "KO"
            goto L_0x014f
        L_0x0114:
            if (r4 < r15) goto L_0x014e
            if (r4 > r13) goto L_0x014e
            java.lang.String r1 = "JP"
            goto L_0x014f
        L_0x011b:
            if (r4 < r15) goto L_0x014e
            r1 = 87
            if (r4 > r1) goto L_0x014e
            java.lang.String r1 = "MX"
            goto L_0x014f
        L_0x0124:
            java.lang.String r1 = "CA"
            goto L_0x014f
        L_0x0127:
            java.lang.String r1 = "US"
            goto L_0x014f
        L_0x012a:
            if (r4 < r15) goto L_0x014e
            if (r4 > r14) goto L_0x014e
            java.lang.String r1 = "IT"
            goto L_0x014f
        L_0x0131:
            if (r4 < r15) goto L_0x013a
            r1 = 77
            if (r4 > r1) goto L_0x013a
            java.lang.String r1 = "UK"
            goto L_0x014f
        L_0x013a:
            r1 = 78
            if (r4 < r1) goto L_0x014e
            if (r4 > r13) goto L_0x014e
            goto L_0x00ea
        L_0x0141:
            if (r4 < r15) goto L_0x0145
            if (r4 <= r3) goto L_0x014b
        L_0x0145:
            r1 = 51
            if (r4 < r1) goto L_0x014e
            if (r4 > r10) goto L_0x014e
        L_0x014b:
            java.lang.String r1 = "BR"
            goto L_0x014f
        L_0x014e:
            r1 = 0
        L_0x014f:
            java.lang.String r0 = r5.substring(r0, r6)     // Catch:{ IllegalArgumentException -> 0x01c6 }
            char r4 = r5.charAt(r12)     // Catch:{ IllegalArgumentException -> 0x01c6 }
            if (r4 < r3) goto L_0x0164
            r6 = 72
            if (r4 > r6) goto L_0x0164
            int r4 = r4 - r3
            int r4 = r4 + 1984
        L_0x0160:
            r11 = r4
            r3 = 10
            goto L_0x01a3
        L_0x0164:
            if (r4 < r9) goto L_0x016e
            r3 = 78
            if (r4 > r3) goto L_0x016e
            int r4 = r4 - r9
            int r4 = r4 + 1988
            goto L_0x0160
        L_0x016e:
            r3 = 80
            if (r4 != r3) goto L_0x0179
            r3 = 1993(0x7c9, float:2.793E-42)
            r3 = 10
            r11 = 1993(0x7c9, float:2.793E-42)
            goto L_0x01a3
        L_0x0179:
            if (r4 < r14) goto L_0x0181
            if (r4 > r13) goto L_0x0181
            int r4 = r4 - r14
            int r4 = r4 + 1994
            goto L_0x0160
        L_0x0181:
            r3 = 86
            if (r4 < r3) goto L_0x018e
            r3 = 89
            if (r4 > r3) goto L_0x018e
            int r4 = r4 + -86
            int r4 = r4 + 1997
            goto L_0x0160
        L_0x018e:
            r3 = 49
            if (r4 < r3) goto L_0x0199
            if (r4 > r10) goto L_0x0199
            int r4 = r4 + -49
            int r4 = r4 + 2001
            goto L_0x0160
        L_0x0199:
            if (r4 < r15) goto L_0x01ba
            r3 = 68
            if (r4 > r3) goto L_0x01ba
            int r4 = r4 - r15
            int r4 = r4 + 2010
            goto L_0x0160
        L_0x01a3:
            char r12 = r5.charAt(r3)     // Catch:{ IllegalArgumentException -> 0x01c6 }
            r3 = 11
            java.lang.String r13 = r5.substring(r3)     // Catch:{ IllegalArgumentException -> 0x01c6 }
            r4 = r16
            r6 = r2
            r7 = r17
            r8 = r18
            r9 = r1
            r10 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ IllegalArgumentException -> 0x01c6 }
            return r16
        L_0x01ba:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01c6 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x01c6 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x01c6 }
        L_0x01c0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01c6 }
            r0.<init>()     // Catch:{ IllegalArgumentException -> 0x01c6 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x01c6 }
        L_0x01c6:
            r0 = 0
            return r0
        L_0x01c8:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.ai.c(com.google.a.r):com.google.a.b.a.ah");
    }

    public final /* synthetic */ q a(r rVar) {
        return c(rVar);
    }
}

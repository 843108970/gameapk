package com.google.a.g;

import com.google.a.c.b;
import com.google.a.g;
import com.google.a.w;
import java.util.ArrayList;
import java.util.Map;

public final class d extends s {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3196a = 103;

    /* renamed from: b  reason: collision with root package name */
    private static final int f3197b = 104;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3198c = 105;
    private static final int d = 101;
    private static final int e = 100;
    private static final int f = 99;
    private static final int g = 106;
    private static final char h = 'ñ';
    private static final char i = 'ò';
    private static final char j = 'ó';
    private static final char k = 'ô';
    private static final int l = 102;
    private static final int m = 97;
    private static final int n = 96;
    private static final int o = 101;
    private static final int p = 100;

    private enum a {
        ;
        
        public static final int FNC_1$127b542f = 4;
        public static final int ONE_DIGIT$127b542f = 2;
        public static final int TWO_DIGITS$127b542f = 3;
        public static final int UNCODABLE$127b542f = 1;

        static {
            $VALUES$5c84c8f4 = new int[]{UNCODABLE$127b542f, ONE_DIGIT$127b542f, TWO_DIGITS$127b542f, FNC_1$127b542f};
        }

        public static int[] values$1af21075() {
            return (int[]) $VALUES$5c84c8f4.clone();
        }
    }

    private static int a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        if (i2 >= length) {
            return a.UNCODABLE$127b542f;
        }
        char charAt = charSequence.charAt(i2);
        if (charAt == 241) {
            return a.FNC_1$127b542f;
        }
        if (charAt < '0' || charAt > '9') {
            return a.UNCODABLE$127b542f;
        }
        int i3 = i2 + 1;
        if (i3 >= length) {
            return a.ONE_DIGIT$127b542f;
        }
        char charAt2 = charSequence.charAt(i3);
        return (charAt2 < '0' || charAt2 > '9') ? a.ONE_DIGIT$127b542f : a.TWO_DIGITS$127b542f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        r3 = r3.charAt(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.CharSequence r3, int r4, int r5) {
        /*
            int r0 = a(r3, r4)
            int r1 = com.google.a.g.d.a.ONE_DIGIT$127b542f
            r2 = 100
            if (r0 != r1) goto L_0x000b
            return r2
        L_0x000b:
            int r1 = com.google.a.g.d.a.UNCODABLE$127b542f
            if (r0 != r1) goto L_0x0027
            int r0 = r3.length()
            if (r4 >= r0) goto L_0x0026
            char r3 = r3.charAt(r4)
            r4 = 32
            r0 = 101(0x65, float:1.42E-43)
            if (r3 < r4) goto L_0x0025
            if (r5 != r0) goto L_0x0026
            r4 = 96
            if (r3 >= r4) goto L_0x0026
        L_0x0025:
            return r0
        L_0x0026:
            return r2
        L_0x0027:
            r1 = 99
            if (r5 != r1) goto L_0x002c
            return r1
        L_0x002c:
            if (r5 != r2) goto L_0x0066
            int r5 = com.google.a.g.d.a.FNC_1$127b542f
            if (r0 != r5) goto L_0x0033
            return r2
        L_0x0033:
            int r5 = r4 + 2
            int r5 = a(r3, r5)
            int r0 = com.google.a.g.d.a.UNCODABLE$127b542f
            if (r5 == r0) goto L_0x0065
            int r0 = com.google.a.g.d.a.ONE_DIGIT$127b542f
            if (r5 != r0) goto L_0x0042
            return r2
        L_0x0042:
            int r0 = com.google.a.g.d.a.FNC_1$127b542f
            if (r5 != r0) goto L_0x0052
            int r4 = r4 + 3
            int r3 = a(r3, r4)
            int r4 = com.google.a.g.d.a.TWO_DIGITS$127b542f
            if (r3 != r4) goto L_0x0051
            return r1
        L_0x0051:
            return r2
        L_0x0052:
            int r4 = r4 + 4
        L_0x0054:
            int r5 = a(r3, r4)
            int r0 = com.google.a.g.d.a.TWO_DIGITS$127b542f
            if (r5 != r0) goto L_0x005f
            int r4 = r4 + 2
            goto L_0x0054
        L_0x005f:
            int r3 = com.google.a.g.d.a.ONE_DIGIT$127b542f
            if (r5 != r3) goto L_0x0064
            return r2
        L_0x0064:
            return r1
        L_0x0065:
            return r2
        L_0x0066:
            int r5 = com.google.a.g.d.a.FNC_1$127b542f
            if (r0 != r5) goto L_0x0070
            int r4 = r4 + 1
            int r0 = a(r3, r4)
        L_0x0070:
            int r3 = com.google.a.g.d.a.TWO_DIGITS$127b542f
            if (r0 != r3) goto L_0x0075
            return r1
        L_0x0075:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.d.a(java.lang.CharSequence, int, int):int");
    }

    public final b a(String str, com.google.a.a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (aVar == com.google.a.a.CODE_128) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            switch (charAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (charAt <= 127) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                    }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (true) {
            int i8 = 103;
            if (i4 < length) {
                int a2 = a(str, i4, i5);
                if (a2 == i5) {
                    int i9 = 101;
                    switch (str.charAt(i4)) {
                        case 241:
                            i9 = 102;
                            break;
                        case 242:
                            i9 = 97;
                            break;
                        case 243:
                            i9 = 96;
                            break;
                        case 244:
                            if (i5 != 101) {
                                i9 = 100;
                                break;
                            }
                            break;
                        default:
                            switch (i5) {
                                case 100:
                                    i9 = str.charAt(i4) - ' ';
                                    break;
                                case 101:
                                    i9 = str.charAt(i4) - ' ';
                                    if (i9 < 0) {
                                        i9 += 96;
                                        break;
                                    }
                                    break;
                                default:
                                    i9 = Integer.parseInt(str.substring(i4, i4 + 2));
                                    i4++;
                                    break;
                            }
                    }
                    i4++;
                    i8 = i9;
                } else {
                    if (i5 == 0) {
                        switch (a2) {
                            case 100:
                                i8 = 104;
                                break;
                            case 101:
                                break;
                            default:
                                i8 = 105;
                                break;
                        }
                    } else {
                        i8 = a2;
                    }
                    i5 = a2;
                }
                arrayList.add(c.f3193a[i8]);
                i6 += i8 * i7;
                if (i4 != 0) {
                    i7++;
                }
            } else {
                arrayList.add(c.f3193a[i6 % 103]);
                arrayList.add(c.f3193a[106]);
                int i10 = 0;
                for (int[] iArr : arrayList) {
                    int i11 = i10;
                    for (int i12 : (int[]) r11.next()) {
                        i11 += i12;
                    }
                    i10 = i11;
                }
                boolean[] zArr = new boolean[i10];
                for (int[] a3 : arrayList) {
                    i2 += a(zArr, i2, a3, true);
                }
                return zArr;
            }
        }
    }
}

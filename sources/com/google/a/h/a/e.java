package com.google.a.h.a;

import com.google.a.h;
import com.google.a.h.c;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

final class e {
    private static final char[] A = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] B = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final BigInteger[] C;
    private static final int D = 2;

    /* renamed from: a  reason: collision with root package name */
    private static final int f3251a = 900;

    /* renamed from: b  reason: collision with root package name */
    private static final int f3252b = 901;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3253c = 902;
    private static final int d = 924;
    private static final int e = 925;
    private static final int f = 926;
    private static final int g = 927;
    private static final int h = 928;
    private static final int i = 923;
    private static final int j = 922;
    private static final int k = 913;
    private static final int l = 15;
    private static final int m = 0;
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 3;
    private static final int q = 4;
    private static final int r = 5;
    private static final int s = 6;
    private static final int t = 25;
    private static final int u = 27;
    private static final int v = 27;
    private static final int w = 28;
    private static final int x = 28;
    private static final int y = 29;
    private static final int z = 29;

    /* renamed from: com.google.a.h.a.e$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3254a = new int[a.values$a5b57b().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0031 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0029 */
        static {
            /*
                int[] r0 = com.google.a.h.a.e.a.values$a5b57b()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3254a = r0
                r0 = 1
                int[] r1 = f3254a     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = com.google.a.h.a.e.a.ALPHA$72b0c14b     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = r2 - r0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                int[] r1 = f3254a     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = com.google.a.h.a.e.a.LOWER$72b0c14b     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = r2 - r0
                r3 = 2
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r1 = f3254a     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = com.google.a.h.a.e.a.MIXED$72b0c14b     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2 - r0
                r3 = 3
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                int[] r1 = f3254a     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r2 = com.google.a.h.a.e.a.PUNCT$72b0c14b     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r2 = r2 - r0
                r3 = 4
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                int[] r1 = f3254a     // Catch:{ NoSuchFieldError -> 0x0031 }
                int r2 = com.google.a.h.a.e.a.ALPHA_SHIFT$72b0c14b     // Catch:{ NoSuchFieldError -> 0x0031 }
                int r2 = r2 - r0
                r3 = 5
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = f3254a     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r2 = com.google.a.h.a.e.a.PUNCT_SHIFT$72b0c14b     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r2 = r2 - r0
                r0 = 6
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.a.e.AnonymousClass1.<clinit>():void");
        }
    }

    private enum a {
        ;
        
        public static final int ALPHA$72b0c14b = 1;
        public static final int ALPHA_SHIFT$72b0c14b = 5;
        public static final int LOWER$72b0c14b = 2;
        public static final int MIXED$72b0c14b = 3;
        public static final int PUNCT$72b0c14b = 4;
        public static final int PUNCT_SHIFT$72b0c14b = 6;

        static {
            $VALUES$3f80ec3a = new int[]{ALPHA$72b0c14b, LOWER$72b0c14b, MIXED$72b0c14b, PUNCT$72b0c14b, ALPHA_SHIFT$72b0c14b, PUNCT_SHIFT$72b0c14b};
        }

        public static int[] values$a5b57b() {
            return (int[]) $VALUES$3f80ec3a.clone();
        }
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        C = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        C[1] = valueOf;
        for (int i2 = 2; i2 < C.length; i2++) {
            BigInteger[] bigIntegerArr2 = C;
            bigIntegerArr2[i2] = bigIntegerArr2[i2 - 1].multiply(valueOf);
        }
    }

    private e() {
    }

    private static int a(int i2, int[] iArr, Charset charset, int i3, StringBuilder sb) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long j2 = 900;
        if (i8 == f3252b) {
            int[] iArr2 = new int[6];
            int i9 = i3 + 1;
            int i10 = iArr[i3];
            boolean z2 = false;
            while (true) {
                i6 = 0;
                long j3 = 0;
                while (i5 < iArr[0] && !z2) {
                    int i11 = i6 + 1;
                    iArr2[i6] = i10;
                    long j4 = (j3 * 900) + ((long) i10);
                    int i12 = i5 + 1;
                    i10 = iArr[i5];
                    if (i10 != 928) {
                        switch (i10) {
                            case f3251a /*900*/:
                            case f3252b /*901*/:
                            case f3253c /*902*/:
                                break;
                            default:
                                switch (i10) {
                                    case j /*922*/:
                                    case i /*923*/:
                                    case d /*924*/:
                                        break;
                                    default:
                                        if (i11 % 5 != 0 || i11 <= 0) {
                                            i5 = i12;
                                            i6 = i11;
                                            j3 = j4;
                                            break;
                                        } else {
                                            for (int i13 = 0; i13 < 6; i13++) {
                                                byteArrayOutputStream.write((byte) ((int) (j4 >> ((5 - i13) * 8))));
                                            }
                                            i9 = i12;
                                        }
                                }
                                break;
                        }
                    }
                    i5 = i12 - 1;
                    i6 = i11;
                    j3 = j4;
                    z2 = true;
                }
            }
            if (i5 != iArr[0] || i10 >= f3251a) {
                i7 = i6;
            } else {
                i7 = i6 + 1;
                iArr2[i6] = i10;
            }
            for (int i14 = 0; i14 < i7; i14++) {
                byteArrayOutputStream.write((byte) iArr2[i14]);
            }
            i4 = i5;
        } else if (i8 != d) {
            i4 = i3;
        } else {
            i4 = i3;
            boolean z3 = false;
            int i15 = 0;
            long j5 = 0;
            while (i4 < iArr[0] && !z3) {
                int i16 = i4 + 1;
                int i17 = iArr[i4];
                if (i17 < f3251a) {
                    i15++;
                    i4 = i16;
                    j5 = (j5 * j2) + ((long) i17);
                } else {
                    if (i17 != 928) {
                        switch (i17) {
                            case f3251a /*900*/:
                            case f3252b /*901*/:
                            case f3253c /*902*/:
                                break;
                            default:
                                switch (i17) {
                                    case j /*922*/:
                                    case i /*923*/:
                                    case d /*924*/:
                                        break;
                                    default:
                                        i4 = i16;
                                        break;
                                }
                        }
                    }
                    i4 = i16 - 1;
                    z3 = true;
                }
                if (i15 % 5 == 0 && i15 > 0) {
                    for (int i18 = 0; i18 < 6; i18++) {
                        byteArrayOutputStream.write((byte) ((int) (j5 >> ((5 - i18) * 8))));
                    }
                    i15 = 0;
                    j5 = 0;
                }
                j2 = 900;
            }
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i4;
    }

    private static int a(int[] iArr, int i2, c cVar) throws h {
        if (i2 + 2 > iArr[0]) {
            throw h.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i3 = i2;
        int i4 = 0;
        while (i4 < 2) {
            iArr2[i4] = iArr[i3];
            i4++;
            i3++;
        }
        cVar.f3271a = Integer.parseInt(a(iArr2, 2));
        StringBuilder sb = new StringBuilder();
        int a2 = a(iArr, i3, sb);
        cVar.f3272b = sb.toString();
        int i5 = iArr[a2] == i ? a2 + 1 : -1;
        while (a2 < iArr[0]) {
            switch (iArr[a2]) {
                case j /*922*/:
                    a2++;
                    cVar.f3273c = true;
                    break;
                case i /*923*/:
                    int i6 = a2 + 1;
                    switch (iArr[i6]) {
                        case 0:
                            StringBuilder sb2 = new StringBuilder();
                            a2 = a(iArr, i6 + 1, sb2);
                            cVar.g = sb2.toString();
                            break;
                        case 1:
                            StringBuilder sb3 = new StringBuilder();
                            a2 = b(iArr, i6 + 1, sb3);
                            cVar.d = Integer.parseInt(sb3.toString());
                            break;
                        case 2:
                            StringBuilder sb4 = new StringBuilder();
                            a2 = b(iArr, i6 + 1, sb4);
                            cVar.i = Long.parseLong(sb4.toString());
                            break;
                        case 3:
                            StringBuilder sb5 = new StringBuilder();
                            a2 = a(iArr, i6 + 1, sb5);
                            cVar.e = sb5.toString();
                            break;
                        case 4:
                            StringBuilder sb6 = new StringBuilder();
                            a2 = a(iArr, i6 + 1, sb6);
                            cVar.f = sb6.toString();
                            break;
                        case 5:
                            StringBuilder sb7 = new StringBuilder();
                            a2 = b(iArr, i6 + 1, sb7);
                            cVar.h = Long.parseLong(sb7.toString());
                            break;
                        case 6:
                            StringBuilder sb8 = new StringBuilder();
                            a2 = b(iArr, i6 + 1, sb8);
                            cVar.j = Integer.parseInt(sb8.toString());
                            break;
                        default:
                            throw h.getFormatInstance();
                    }
                default:
                    throw h.getFormatInstance();
            }
        }
        if (i5 != -1) {
            int i7 = a2 - i5;
            if (cVar.f3273c) {
                i7--;
            }
            cVar.k = Arrays.copyOfRange(iArr, i5, i7 + i5);
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0086, code lost:
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008e, code lost:
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0094, code lost:
        if (r9 != f3251a) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ba, code lost:
        r5 = com.google.a.h.a.e.a.ALPHA$72b0c14b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00da, code lost:
        r9 = (char) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00db, code lost:
        r13 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e5, code lost:
        r7 = com.google.a.h.a.e.a.PUNCT_SHIFT$72b0c14b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e7, code lost:
        r13 = 0;
        r16 = r7;
        r7 = r5;
        r5 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ee, code lost:
        r5 = com.google.a.h.a.e.a.MIXED$72b0c14b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f1, code lost:
        r5 = com.google.a.h.a.e.a.LOWER$72b0c14b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f6, code lost:
        r2.append((char) r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00fa, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00fb, code lost:
        if (r13 == 0) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00fd, code lost:
        r2.append(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0100, code lost:
        r0 = r0 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(int[] r17, int r18, java.lang.StringBuilder r19) {
        /*
            r2 = r19
            r3 = 0
            r4 = r17[r3]
            int r4 = r4 - r18
            r5 = 1
            int r4 = r4 << r5
            int[] r4 = new int[r4]
            r6 = r17[r3]
            int r6 = r6 - r18
            int r6 = r6 << r5
            int[] r6 = new int[r6]
            r1 = r18
            r7 = 0
            r8 = 0
        L_0x0016:
            r9 = r17[r3]
            r10 = 913(0x391, float:1.28E-42)
            r11 = 900(0x384, float:1.261E-42)
            if (r1 >= r9) goto L_0x0056
            if (r7 != 0) goto L_0x0056
            int r9 = r1 + 1
            r1 = r17[r1]
            if (r1 >= r11) goto L_0x0034
            int r10 = r1 / 30
            r4[r8] = r10
            int r10 = r8 + 1
            int r1 = r1 % 30
            r4[r10] = r1
            int r8 = r8 + 2
        L_0x0032:
            r1 = r9
            goto L_0x0016
        L_0x0034:
            if (r1 == r10) goto L_0x004b
            r10 = 928(0x3a0, float:1.3E-42)
            if (r1 == r10) goto L_0x0047
            switch(r1) {
                case 900: goto L_0x0041;
                case 901: goto L_0x0047;
                case 902: goto L_0x0047;
                default: goto L_0x003d;
            }
        L_0x003d:
            switch(r1) {
                case 922: goto L_0x0047;
                case 923: goto L_0x0047;
                case 924: goto L_0x0047;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x0032
        L_0x0041:
            int r1 = r8 + 1
            r4[r8] = r11
            r8 = r1
            goto L_0x0032
        L_0x0047:
            int r1 = r9 + -1
            r7 = 1
            goto L_0x0016
        L_0x004b:
            r4[r8] = r10
            int r1 = r9 + 1
            r9 = r17[r9]
            r6[r8] = r9
            int r8 = r8 + 1
            goto L_0x0016
        L_0x0056:
            int r0 = com.google.a.h.a.e.a.ALPHA$72b0c14b
            int r5 = com.google.a.h.a.e.a.ALPHA$72b0c14b
            r7 = r5
            r5 = r0
            r0 = 0
        L_0x005d:
            if (r0 >= r8) goto L_0x0104
            r9 = r4[r0]
            int[] r12 = com.google.a.h.a.e.AnonymousClass1.f3254a
            int r13 = r5 + -1
            r12 = r12[r13]
            r13 = 32
            r14 = 26
            r15 = 29
            switch(r12) {
                case 1: goto L_0x00d6;
                case 2: goto L_0x00c3;
                case 3: goto L_0x00a9;
                case 4: goto L_0x0097;
                case 5: goto L_0x0089;
                case 6: goto L_0x0072;
                default: goto L_0x0070;
            }
        L_0x0070:
            goto L_0x00fa
        L_0x0072:
            if (r9 >= r15) goto L_0x0079
            char[] r5 = A
            char r5 = r5[r9]
            goto L_0x008e
        L_0x0079:
            if (r9 == r15) goto L_0x00ba
            if (r9 == r11) goto L_0x00ba
            if (r9 == r10) goto L_0x0080
            goto L_0x0086
        L_0x0080:
            r5 = r6[r0]
            char r5 = (char) r5
            r2.append(r5)
        L_0x0086:
            r5 = r7
            goto L_0x00fa
        L_0x0089:
            if (r9 >= r14) goto L_0x0092
            int r9 = r9 + 65
            char r5 = (char) r9
        L_0x008e:
            r13 = r5
        L_0x008f:
            r5 = r7
            goto L_0x00fb
        L_0x0092:
            if (r9 == r14) goto L_0x008f
            if (r9 == r11) goto L_0x00ba
            goto L_0x0086
        L_0x0097:
            if (r9 >= r15) goto L_0x009e
            char[] r12 = A
            char r9 = r12[r9]
            goto L_0x00db
        L_0x009e:
            if (r9 == r15) goto L_0x00ba
            if (r9 == r11) goto L_0x00ba
            if (r9 == r10) goto L_0x00a6
            goto L_0x00fa
        L_0x00a6:
            r9 = r6[r0]
            goto L_0x00f6
        L_0x00a9:
            r12 = 25
            if (r9 >= r12) goto L_0x00b2
            char[] r12 = B
            char r9 = r12[r9]
            goto L_0x00db
        L_0x00b2:
            if (r9 == r11) goto L_0x00ba
            if (r9 == r10) goto L_0x00c0
            switch(r9) {
                case 25: goto L_0x00bd;
                case 26: goto L_0x00fb;
                case 27: goto L_0x00f1;
                case 28: goto L_0x00ba;
                case 29: goto L_0x00e5;
                default: goto L_0x00b9;
            }
        L_0x00b9:
            goto L_0x00fa
        L_0x00ba:
            int r5 = com.google.a.h.a.e.a.ALPHA$72b0c14b
            goto L_0x00fa
        L_0x00bd:
            int r5 = com.google.a.h.a.e.a.PUNCT$72b0c14b
            goto L_0x00fa
        L_0x00c0:
            r9 = r6[r0]
            goto L_0x00f6
        L_0x00c3:
            if (r9 >= r14) goto L_0x00c8
            int r9 = r9 + 97
            goto L_0x00da
        L_0x00c8:
            if (r9 == r11) goto L_0x00ba
            if (r9 == r10) goto L_0x00d3
            switch(r9) {
                case 26: goto L_0x00fb;
                case 27: goto L_0x00d0;
                case 28: goto L_0x00ee;
                case 29: goto L_0x00e5;
                default: goto L_0x00cf;
            }
        L_0x00cf:
            goto L_0x00fa
        L_0x00d0:
            int r7 = com.google.a.h.a.e.a.ALPHA_SHIFT$72b0c14b
            goto L_0x00e7
        L_0x00d3:
            r9 = r6[r0]
            goto L_0x00f6
        L_0x00d6:
            if (r9 >= r14) goto L_0x00dd
            int r9 = r9 + 65
        L_0x00da:
            char r9 = (char) r9
        L_0x00db:
            r13 = r9
            goto L_0x00fb
        L_0x00dd:
            if (r9 == r11) goto L_0x00ba
            if (r9 == r10) goto L_0x00f4
            switch(r9) {
                case 26: goto L_0x00fb;
                case 27: goto L_0x00f1;
                case 28: goto L_0x00ee;
                case 29: goto L_0x00e5;
                default: goto L_0x00e4;
            }
        L_0x00e4:
            goto L_0x00fa
        L_0x00e5:
            int r7 = com.google.a.h.a.e.a.PUNCT_SHIFT$72b0c14b
        L_0x00e7:
            r13 = 0
            r16 = r7
            r7 = r5
            r5 = r16
            goto L_0x00fb
        L_0x00ee:
            int r5 = com.google.a.h.a.e.a.MIXED$72b0c14b
            goto L_0x00fa
        L_0x00f1:
            int r5 = com.google.a.h.a.e.a.LOWER$72b0c14b
            goto L_0x00fa
        L_0x00f4:
            r9 = r6[r0]
        L_0x00f6:
            char r9 = (char) r9
            r2.append(r9)
        L_0x00fa:
            r13 = 0
        L_0x00fb:
            if (r13 == 0) goto L_0x0100
            r2.append(r13)
        L_0x0100:
            int r0 = r0 + 1
            goto L_0x005d
        L_0x0104:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.a.e.a(int[], int, java.lang.StringBuilder):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        r2 = a(r2, r6, r1, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r2 = a(r6, r4, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.a.c.e a(int[] r6, java.lang.String r7) throws com.google.a.h {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = r6[r2]
            com.google.a.h.c r3 = new com.google.a.h.c
            r3.<init>()
            r4 = 2
        L_0x0012:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L_0x0068
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L_0x0053
            switch(r2) {
                case 900: goto L_0x0023;
                case 901: goto L_0x004e;
                case 902: goto L_0x0049;
                default: goto L_0x001e;
            }
        L_0x001e:
            switch(r2) {
                case 922: goto L_0x0044;
                case 923: goto L_0x0044;
                case 924: goto L_0x004e;
                case 925: goto L_0x0041;
                case 926: goto L_0x003e;
                case 927: goto L_0x002d;
                case 928: goto L_0x0028;
                default: goto L_0x0021;
            }
        L_0x0021:
            int r4 = r4 + -1
        L_0x0023:
            int r2 = a((int[]) r6, (int) r4, (java.lang.StringBuilder) r0)
            goto L_0x005b
        L_0x0028:
            int r2 = a((int[]) r6, (int) r4, (com.google.a.h.c) r3)
            goto L_0x005b
        L_0x002d:
            int r2 = r4 + 1
            r1 = r6[r4]
            com.google.a.c.d r1 = com.google.a.c.d.getCharacterSetECIByValue(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L_0x005b
        L_0x003e:
            int r2 = r4 + 2
            goto L_0x005b
        L_0x0041:
            int r2 = r4 + 1
            goto L_0x005b
        L_0x0044:
            com.google.a.h r6 = com.google.a.h.getFormatInstance()
            throw r6
        L_0x0049:
            int r2 = b(r6, r4, r0)
            goto L_0x005b
        L_0x004e:
            int r2 = a(r2, r6, r1, r4, r0)
            goto L_0x005b
        L_0x0053:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L_0x005b:
            int r4 = r6.length
            if (r2 >= r4) goto L_0x0063
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L_0x0012
        L_0x0063:
            com.google.a.h r6 = com.google.a.h.getFormatInstance()
            throw r6
        L_0x0068:
            int r6 = r0.length()
            if (r6 != 0) goto L_0x0073
            com.google.a.h r6 = com.google.a.h.getFormatInstance()
            throw r6
        L_0x0073:
            com.google.a.c.e r6 = new com.google.a.c.e
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.h = r3
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.a.e.a(int[], java.lang.String):com.google.a.c.e");
    }

    private static String a(int[] iArr, int i2) throws h {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigInteger = bigInteger.add(C[(i2 - i3) - 1].multiply(BigInteger.valueOf((long) iArr[i3])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw h.getFormatInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        r4 = r1;
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r4 != f3251a) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006d, code lost:
        r1 = com.google.a.h.a.e.a.ALPHA$72b0c14b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008d, code lost:
        r4 = (char) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0097, code lost:
        r3 = com.google.a.h.a.e.a.PUNCT_SHIFT$72b0c14b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0099, code lost:
        r4 = 0;
        r11 = r3;
        r3 = r1;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009e, code lost:
        r1 = com.google.a.h.a.e.a.MIXED$72b0c14b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a1, code lost:
        r1 = com.google.a.h.a.e.a.LOWER$72b0c14b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a4, code lost:
        r4 = ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a9, code lost:
        r15.append((char) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ad, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ae, code lost:
        if (r4 == 0) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b0, code lost:
        r15.append(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b3, code lost:
        r0 = r0 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(int[] r12, int[] r13, int r14, java.lang.StringBuilder r15) {
        /*
            int r0 = com.google.a.h.a.e.a.ALPHA$72b0c14b
            int r1 = com.google.a.h.a.e.a.ALPHA$72b0c14b
            r2 = 0
            r3 = r1
            r1 = r0
            r0 = 0
        L_0x0008:
            if (r0 >= r14) goto L_0x00b7
            r4 = r12[r0]
            int[] r5 = com.google.a.h.a.e.AnonymousClass1.f3254a
            int r6 = r1 + -1
            r5 = r5[r6]
            r6 = 32
            r7 = 26
            r8 = 29
            r9 = 913(0x391, float:1.28E-42)
            r10 = 900(0x384, float:1.261E-42)
            switch(r5) {
                case 1: goto L_0x0089;
                case 2: goto L_0x0076;
                case 3: goto L_0x005c;
                case 4: goto L_0x0049;
                case 5: goto L_0x0038;
                case 6: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x00ad
        L_0x0021:
            if (r4 >= r8) goto L_0x0028
            char[] r1 = A
            char r1 = r1[r4]
            goto L_0x003d
        L_0x0028:
            if (r4 == r8) goto L_0x006d
            if (r4 == r10) goto L_0x006d
            if (r4 == r9) goto L_0x002f
            goto L_0x0035
        L_0x002f:
            r1 = r13[r0]
            char r1 = (char) r1
            r15.append(r1)
        L_0x0035:
            r1 = r3
            goto L_0x00ad
        L_0x0038:
            if (r4 >= r7) goto L_0x0041
            int r4 = r4 + 65
            char r1 = (char) r4
        L_0x003d:
            r4 = r1
            r1 = r3
            goto L_0x00ae
        L_0x0041:
            if (r4 == r7) goto L_0x0046
            if (r4 == r10) goto L_0x006d
            goto L_0x0035
        L_0x0046:
            r1 = r3
            goto L_0x00a4
        L_0x0049:
            if (r4 >= r8) goto L_0x0051
            char[] r5 = A
            char r4 = r5[r4]
            goto L_0x00ae
        L_0x0051:
            if (r4 == r8) goto L_0x006d
            if (r4 == r10) goto L_0x006d
            if (r4 == r9) goto L_0x0059
            goto L_0x00ad
        L_0x0059:
            r4 = r13[r0]
            goto L_0x00a9
        L_0x005c:
            r5 = 25
            if (r4 >= r5) goto L_0x0065
            char[] r5 = B
            char r4 = r5[r4]
            goto L_0x00ae
        L_0x0065:
            if (r4 == r10) goto L_0x006d
            if (r4 == r9) goto L_0x0073
            switch(r4) {
                case 25: goto L_0x0070;
                case 26: goto L_0x00a4;
                case 27: goto L_0x00a1;
                case 28: goto L_0x006d;
                case 29: goto L_0x0097;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x00ad
        L_0x006d:
            int r1 = com.google.a.h.a.e.a.ALPHA$72b0c14b
            goto L_0x00ad
        L_0x0070:
            int r1 = com.google.a.h.a.e.a.PUNCT$72b0c14b
            goto L_0x00ad
        L_0x0073:
            r4 = r13[r0]
            goto L_0x00a9
        L_0x0076:
            if (r4 >= r7) goto L_0x007b
            int r4 = r4 + 97
            goto L_0x008d
        L_0x007b:
            if (r4 == r10) goto L_0x006d
            if (r4 == r9) goto L_0x0086
            switch(r4) {
                case 26: goto L_0x00a4;
                case 27: goto L_0x0083;
                case 28: goto L_0x009e;
                case 29: goto L_0x0097;
                default: goto L_0x0082;
            }
        L_0x0082:
            goto L_0x00ad
        L_0x0083:
            int r3 = com.google.a.h.a.e.a.ALPHA_SHIFT$72b0c14b
            goto L_0x0099
        L_0x0086:
            r4 = r13[r0]
            goto L_0x00a9
        L_0x0089:
            if (r4 >= r7) goto L_0x008f
            int r4 = r4 + 65
        L_0x008d:
            char r4 = (char) r4
            goto L_0x00ae
        L_0x008f:
            if (r4 == r10) goto L_0x006d
            if (r4 == r9) goto L_0x00a7
            switch(r4) {
                case 26: goto L_0x00a4;
                case 27: goto L_0x00a1;
                case 28: goto L_0x009e;
                case 29: goto L_0x0097;
                default: goto L_0x0096;
            }
        L_0x0096:
            goto L_0x00ad
        L_0x0097:
            int r3 = com.google.a.h.a.e.a.PUNCT_SHIFT$72b0c14b
        L_0x0099:
            r4 = 0
            r11 = r3
            r3 = r1
            r1 = r11
            goto L_0x00ae
        L_0x009e:
            int r1 = com.google.a.h.a.e.a.MIXED$72b0c14b
            goto L_0x00ad
        L_0x00a1:
            int r1 = com.google.a.h.a.e.a.LOWER$72b0c14b
            goto L_0x00ad
        L_0x00a4:
            r4 = 32
            goto L_0x00ae
        L_0x00a7:
            r4 = r13[r0]
        L_0x00a9:
            char r4 = (char) r4
            r15.append(r4)
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            if (r4 == 0) goto L_0x00b3
            r15.append(r4)
        L_0x00b3:
            int r0 = r0 + 1
            goto L_0x0008
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.a.e.a(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int b(int[] iArr, int i2, StringBuilder sb) throws h {
        int[] iArr2 = new int[15];
        boolean z2 = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z2) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i4 == iArr[0]) {
                z2 = true;
            }
            if (i5 < f3251a) {
                iArr2[i3] = i5;
                i3++;
            } else {
                if (i5 != 928) {
                    switch (i5) {
                        case f3251a /*900*/:
                        case f3252b /*901*/:
                            break;
                        default:
                            switch (i5) {
                                case j /*922*/:
                                case i /*923*/:
                                case d /*924*/:
                                    break;
                            }
                    }
                }
                i4--;
                z2 = true;
            }
            if ((i3 % 15 == 0 || i5 == f3253c || z2) && i3 > 0) {
                sb.append(a(iArr2, i3));
                i3 = 0;
            }
            i2 = i4;
        }
        return i2;
    }
}

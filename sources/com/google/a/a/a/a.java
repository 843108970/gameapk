package com.google.a.a.a;

import com.cyjh.common.d.b;
import com.cyjh.common.util.s;
import com.cyjh.elfin.e.c.o;
import com.cyjh.mobileanjian.ipc.utils.m;
import com.google.a.c.b.e;
import com.google.a.h;
import com.googlecode.tesseract.android.TessBaseAPI;
import com.hlzn.socketclient.f.c;
import com.umeng.commonsdk.proguard.v;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.slf4j.Marker;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f2976a = {"CTRL_PS", s.a.f1696a, "A", "B", "C", "D", "E", TessBaseAPI.f, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", TessBaseAPI.e, "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f2977b = {"CTRL_PS", s.a.f1696a, "a", b.d, c.f3449a, "d", "e", "f", "g", "h", v.am, "j", "k", "l", m.f2716a, "n", o.f1943a, v.ak, "q", "r", v.al, "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f2978c = {"CTRL_PS", s.a.f1696a, "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] d = {"", "\r", IOUtils.LINE_SEPARATOR_WINDOWS, ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", Marker.ANY_MARKER, Marker.ANY_NON_NULL_MARKER, ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] e = {"CTRL_PS", s.a.f1696a, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    private com.google.a.a.a f;

    /* renamed from: com.google.a.a.a.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2979a = new int[C0048a.values$17d9718f().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0029 */
        static {
            /*
                int[] r0 = com.google.a.a.a.a.C0048a.values$17d9718f()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2979a = r0
                r0 = 1
                int[] r1 = f2979a     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = com.google.a.a.a.a.C0048a.UPPER$2679db95     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = r2 - r0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                int[] r1 = f2979a     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = com.google.a.a.a.a.C0048a.LOWER$2679db95     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = r2 - r0
                r3 = 2
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r1 = f2979a     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = com.google.a.a.a.a.C0048a.MIXED$2679db95     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2 - r0
                r3 = 3
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                int[] r1 = f2979a     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r2 = com.google.a.a.a.a.C0048a.PUNCT$2679db95     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r2 = r2 - r0
                r3 = 4
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                int[] r1 = f2979a     // Catch:{ NoSuchFieldError -> 0x0031 }
                int r2 = com.google.a.a.a.a.C0048a.DIGIT$2679db95     // Catch:{ NoSuchFieldError -> 0x0031 }
                int r2 = r2 - r0
                r0 = 5
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.a.a.AnonymousClass1.<clinit>():void");
        }
    }

    /* renamed from: com.google.a.a.a.a$a  reason: collision with other inner class name */
    private enum C0048a {
        ;
        
        public static final int BINARY$2679db95 = 6;
        public static final int DIGIT$2679db95 = 4;
        public static final int LOWER$2679db95 = 2;
        public static final int MIXED$2679db95 = 3;
        public static final int PUNCT$2679db95 = 5;
        public static final int UPPER$2679db95 = 1;

        static {
            $VALUES$171a8b50 = new int[]{UPPER$2679db95, LOWER$2679db95, MIXED$2679db95, DIGIT$2679db95, PUNCT$2679db95, BINARY$2679db95};
        }

        public static int[] values$17d9718f() {
            return (int[]) $VALUES$171a8b50.clone();
        }
    }

    private static byte a(boolean[] zArr, int i) {
        int length = zArr.length - i;
        return (byte) (length >= 8 ? a(zArr, i, 8) : a(zArr, i, length) << (8 - length));
    }

    private static int a(char c2) {
        if (c2 == 'B') {
            return C0048a.BINARY$2679db95;
        }
        if (c2 == 'D') {
            return C0048a.DIGIT$2679db95;
        }
        if (c2 == 'P') {
            return C0048a.PUNCT$2679db95;
        }
        switch (c2) {
            case 'L':
                return C0048a.LOWER$2679db95;
            case 'M':
                return C0048a.MIXED$2679db95;
            default:
                return C0048a.UPPER$2679db95;
        }
    }

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    private static int a(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static String a(int i, int i2) {
        switch (AnonymousClass1.f2979a[i - 1]) {
            case 1:
                return f2976a[i2];
            case 2:
                return f2977b[i2];
            case 3:
                return f2978c[i2];
            case 4:
                return d[i2];
            case 5:
                return e[i2];
            default:
                throw new IllegalStateException("Bad table");
        }
    }

    private static String a(boolean[] zArr) {
        return b(zArr);
    }

    private boolean[] a(com.google.a.c.b bVar) {
        com.google.a.c.b bVar2 = bVar;
        boolean z = this.f.f2973a;
        int i = this.f.f2975c;
        int i2 = (z ? 11 : 14) + (i << 2);
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[(((z ? 88 : 112) + (i << 4)) * i)];
        int i3 = 2;
        if (z) {
            for (int i4 = 0; i4 < iArr.length; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            for (int i7 = 0; i7 < i5; i7++) {
                int i8 = (i7 / 15) + i7;
                iArr[(i5 - i7) - 1] = (i6 - i8) - 1;
                iArr[i5 + i7] = i8 + i6 + 1;
            }
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < i) {
            int i11 = ((i - i9) << i3) + (z ? 9 : 12);
            int i12 = i9 << 1;
            int i13 = (i2 - 1) - i12;
            int i14 = 0;
            while (i14 < i11) {
                int i15 = i14 << 1;
                int i16 = 0;
                while (i16 < i3) {
                    int i17 = i12 + i16;
                    int i18 = i12 + i14;
                    zArr[i10 + i15 + i16] = bVar2.a(iArr[i17], iArr[i18]);
                    int i19 = i13 - i16;
                    zArr[(i11 * 2) + i10 + i15 + i16] = bVar2.a(iArr[i18], iArr[i19]);
                    int i20 = i13 - i14;
                    zArr[(i11 * 4) + i10 + i15 + i16] = bVar2.a(iArr[i19], iArr[i20]);
                    zArr[(i11 * 6) + i10 + i15 + i16] = bVar2.a(iArr[i20], iArr[i17]);
                    i16++;
                    z = z;
                    i = i;
                    i3 = 2;
                }
                boolean z2 = z;
                int i21 = i;
                i14++;
                i3 = 2;
            }
            boolean z3 = z;
            int i22 = i;
            i10 += i11 << 3;
            i9++;
            i3 = 2;
        }
        return zArr;
    }

    private static String b(boolean[] zArr) {
        String str;
        int length = zArr.length;
        int i = C0048a.UPPER$2679db95;
        int i2 = C0048a.UPPER$2679db95;
        StringBuilder sb = new StringBuilder(20);
        int i3 = i;
        int i4 = 0;
        while (i4 < length) {
            if (i2 == C0048a.BINARY$2679db95) {
                if (length - i4 >= 5) {
                    int a2 = a(zArr, i4, 5);
                    int i5 = i4 + 5;
                    if (a2 == 0) {
                        if (length - i5 >= 11) {
                            a2 = a(zArr, i5, 11) + 31;
                            i5 += 11;
                        }
                    }
                    int i6 = i5;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= a2) {
                            i4 = i6;
                        } else if (length - i6 < 8) {
                            i4 = length;
                        } else {
                            sb.append((char) a(zArr, i6, 8));
                            i6 += 8;
                            i7++;
                        }
                    }
                }
                return sb.toString();
            }
            int i8 = i2 == C0048a.DIGIT$2679db95 ? 4 : 5;
            if (length - i4 < i8) {
                return sb.toString();
            }
            int a3 = a(zArr, i4, i8);
            i4 += i8;
            switch (AnonymousClass1.f2979a[i2 - 1]) {
                case 1:
                    str = f2976a[a3];
                    break;
                case 2:
                    str = f2977b[a3];
                    break;
                case 3:
                    str = f2978c[a3];
                    break;
                case 4:
                    str = d[a3];
                    break;
                case 5:
                    str = e[a3];
                    break;
                default:
                    throw new IllegalStateException("Bad table");
            }
            if (str.startsWith("CTRL_")) {
                char charAt = str.charAt(5);
                if (charAt == 'B') {
                    i3 = C0048a.BINARY$2679db95;
                } else if (charAt == 'D') {
                    i3 = C0048a.DIGIT$2679db95;
                } else if (charAt != 'P') {
                    switch (charAt) {
                        case 'L':
                            i3 = C0048a.LOWER$2679db95;
                            break;
                        case 'M':
                            i3 = C0048a.MIXED$2679db95;
                            break;
                        default:
                            i3 = C0048a.UPPER$2679db95;
                            break;
                    }
                } else {
                    i3 = C0048a.PUNCT$2679db95;
                }
                if (str.charAt(6) != 'L') {
                    int i9 = i3;
                    i3 = i2;
                    i2 = i9;
                }
            } else {
                sb.append(str);
            }
            i2 = i3;
        }
        return sb.toString();
    }

    private boolean[] c(boolean[] zArr) throws h {
        com.google.a.c.b.a aVar;
        int i = 8;
        if (this.f.f2975c <= 2) {
            i = 6;
            aVar = com.google.a.c.b.a.f3066c;
        } else if (this.f.f2975c <= 8) {
            aVar = com.google.a.c.b.a.g;
        } else if (this.f.f2975c <= 22) {
            i = 10;
            aVar = com.google.a.c.b.a.f3065b;
        } else {
            i = 12;
            aVar = com.google.a.c.b.a.f3064a;
        }
        int i2 = this.f.f2974b;
        int length = zArr.length / i;
        if (length < i2) {
            throw h.getFormatInstance();
        }
        int[] iArr = new int[length];
        int length2 = zArr.length % i;
        int i3 = 0;
        while (i3 < length) {
            iArr[i3] = a(zArr, length2, i);
            i3++;
            length2 += i;
        }
        try {
            new com.google.a.c.b.c(aVar).a(iArr, length - i2);
            int i4 = (1 << i) - 1;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = iArr[i6];
                if (i7 == 0 || i7 == i4) {
                    throw h.getFormatInstance();
                }
                if (i7 == 1 || i7 == i4 - 1) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[((i2 * i) - i5)];
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = iArr[i9];
                if (i10 == 1 || i10 == i4 - 1) {
                    Arrays.fill(zArr2, i8, (i8 + i) - 1, i10 > 1);
                    i8 += i - 1;
                } else {
                    int i11 = i - 1;
                    while (i11 >= 0) {
                        int i12 = i8 + 1;
                        zArr2[i8] = ((1 << i11) & i10) != 0;
                        i11--;
                        i8 = i12;
                    }
                }
            }
            return zArr2;
        } catch (e e2) {
            throw h.getFormatInstance(e2);
        }
    }

    private static byte[] d(boolean[] zArr) {
        byte[] bArr = new byte[((zArr.length + 7) / 8)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i << 3;
            int length = zArr.length - i2;
            bArr[i] = (byte) (length >= 8 ? a(zArr, i2, 8) : a(zArr, i2, length) << (8 - length));
        }
        return bArr;
    }

    public final com.google.a.c.e a(com.google.a.a.a aVar) throws h {
        com.google.a.a.a aVar2 = aVar;
        this.f = aVar2;
        com.google.a.c.b bVar = aVar2.d;
        boolean z = this.f.f2973a;
        int i = this.f.f2975c;
        int i2 = (z ? 11 : 14) + (i << 2);
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[(((z ? 88 : 112) + (i << 4)) * i)];
        int i3 = 2;
        if (z) {
            for (int i4 = 0; i4 < iArr.length; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            for (int i7 = 0; i7 < i5; i7++) {
                int i8 = (i7 / 15) + i7;
                iArr[(i5 - i7) - 1] = (i6 - i8) - 1;
                iArr[i5 + i7] = i8 + i6 + 1;
            }
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < i) {
            int i11 = ((i - i9) << i3) + (z ? 9 : 12);
            int i12 = i9 << 1;
            int i13 = (i2 - 1) - i12;
            int i14 = 0;
            while (i14 < i11) {
                int i15 = i14 << 1;
                int i16 = 0;
                while (i16 < i3) {
                    int i17 = i12 + i16;
                    int i18 = i12 + i14;
                    zArr[i10 + i15 + i16] = bVar.a(iArr[i17], iArr[i18]);
                    int i19 = i13 - i16;
                    zArr[(i11 * 2) + i10 + i15 + i16] = bVar.a(iArr[i18], iArr[i19]);
                    int i20 = i13 - i14;
                    zArr[(i11 * 4) + i10 + i15 + i16] = bVar.a(iArr[i19], iArr[i20]);
                    zArr[(i11 * 6) + i10 + i15 + i16] = bVar.a(iArr[i20], iArr[i17]);
                    i16++;
                    z = z;
                    i = i;
                    i2 = i2;
                    i3 = 2;
                }
                boolean z2 = z;
                int i21 = i;
                int i22 = i2;
                i14++;
                i3 = 2;
            }
            int i23 = i;
            int i24 = i2;
            i10 += i11 << 3;
            i9++;
            z = z;
            i3 = 2;
        }
        boolean[] c2 = c(zArr);
        byte[] bArr = new byte[((c2.length + 7) / 8)];
        for (int i25 = 0; i25 < bArr.length; i25++) {
            int i26 = i25 << 3;
            int length = c2.length - i26;
            bArr[i25] = (byte) (length >= 8 ? a(c2, i26, 8) : a(c2, i26, length) << (8 - length));
        }
        com.google.a.c.e eVar = new com.google.a.c.e(bArr, b(c2), (List<byte[]>) null, (String) null);
        eVar.f3076b = c2.length;
        return eVar;
    }
}

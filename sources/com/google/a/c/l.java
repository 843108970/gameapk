package com.google.a.c;

import com.google.a.e;
import com.umeng.commonsdk.proguard.bg;
import java.nio.charset.Charset;
import java.util.Map;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3086a = "SJIS";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3087b = "GB2312";

    /* renamed from: c  reason: collision with root package name */
    private static final String f3088c = Charset.defaultCharset().name();
    private static final String d = "EUC_JP";
    private static final String e = "UTF8";
    private static final String f = "ISO8859_1";
    private static final boolean g = (f3086a.equalsIgnoreCase(f3088c) || d.equalsIgnoreCase(f3088c));

    private l() {
    }

    public static String a(byte[] bArr, Map<e, ?> map) {
        byte[] bArr2 = bArr;
        Map<e, ?> map2 = map;
        if (map2 != null && map2.containsKey(e.CHARACTER_SET)) {
            return map2.get(e.CHARACTER_SET).toString();
        }
        int length = bArr2.length;
        int i = 0;
        boolean z = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i3 < length && (z2 || z3 || z4)) {
            byte b2 = bArr2[i3] & 255;
            if (z4) {
                if (i4 > 0) {
                    if ((b2 & 128) != 0) {
                        i4--;
                    }
                } else if ((b2 & 128) != 0) {
                    if ((b2 & 64) != 0) {
                        i4++;
                        if ((b2 & 32) == 0) {
                            i6++;
                        } else {
                            i4++;
                            if ((b2 & bg.n) == 0) {
                                i7++;
                            } else {
                                i4++;
                                if ((b2 & 8) == 0) {
                                    i8++;
                                }
                            }
                        }
                    }
                }
                z4 = false;
            }
            if (z2) {
                if (b2 > Byte.MAX_VALUE && b2 < 160) {
                    z2 = false;
                } else if (b2 > 159 && (b2 < 192 || b2 == 215 || b2 == 247)) {
                    i10++;
                }
            }
            if (z3) {
                if (i5 > 0) {
                    if (b2 >= 64 && b2 != Byte.MAX_VALUE && b2 <= 252) {
                        i5--;
                    }
                } else if (!(b2 == 128 || b2 == 160 || b2 > 239)) {
                    if (b2 > 160 && b2 < 224) {
                        i2++;
                        int i13 = i11 + 1;
                        if (i13 > i9) {
                            i9 = i13;
                            i11 = i9;
                        } else {
                            i11 = i13;
                        }
                    } else if (b2 > Byte.MAX_VALUE) {
                        i5++;
                        int i14 = i12 + 1;
                        if (i14 > i) {
                            i = i14;
                            i12 = i;
                        } else {
                            i12 = i14;
                        }
                        i11 = 0;
                    } else {
                        i11 = 0;
                    }
                    i12 = 0;
                }
                z3 = false;
            }
            i3++;
            bArr2 = bArr;
        }
        if (z4 && i4 > 0) {
            z4 = false;
        }
        boolean z5 = (!z3 || i5 <= 0) ? z3 : false;
        return (!z4 || (!z && (i6 + i7) + i8 <= 0)) ? (!z5 || (!g && i9 < 3 && i < 3)) ? (!z2 || !z5) ? z2 ? f : z5 ? f3086a : z4 ? e : f3088c : (!(i9 == 2 && i2 == 2) && i10 * 10 < length) ? f : f3086a : f3086a : e;
    }
}

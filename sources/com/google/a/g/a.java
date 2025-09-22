package com.google.a.g;

import android.support.v7.widget.ActivityChooserView;
import com.google.a.e;
import com.google.a.m;
import com.google.a.r;
import com.google.a.t;
import java.util.Arrays;
import java.util.Map;

public final class a extends r {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f3148a = e.toCharArray();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f3149b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: c  reason: collision with root package name */
    private static final float f3150c = 2.0f;
    private static final float d = 1.5f;
    private static final String e = "0123456789-$:/.+ABCD";
    private static final int f = 3;
    private static final char[] g = {'A', 'B', 'C', 'D'};
    private final StringBuilder h = new StringBuilder(20);
    private int[] i = new int[80];
    private int j = 0;

    private void a(int i2) throws m {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.h.length() - 1;
        int i3 = 0;
        int i4 = i2;
        int i5 = 0;
        while (true) {
            int i6 = f3149b[this.h.charAt(i5)];
            for (int i7 = 6; i7 >= 0; i7--) {
                int i8 = (i7 & 1) + ((i6 & 1) << 1);
                iArr[i8] = iArr[i8] + this.i[i4 + i7];
                iArr2[i8] = iArr2[i8] + 1;
                i6 >>= 1;
            }
            if (i5 >= length) {
                break;
            }
            i4 += 8;
            i5++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i9 = 0; i9 < 2; i9++) {
            fArr2[i9] = 0.0f;
            int i10 = i9 + 2;
            fArr2[i10] = ((((float) iArr[i9]) / ((float) iArr2[i9])) + (((float) iArr[i10]) / ((float) iArr2[i10]))) / f3150c;
            fArr[i9] = fArr2[i10];
            fArr[i10] = ((((float) iArr[i10]) * f3150c) + d) / ((float) iArr2[i10]);
        }
        loop3:
        while (true) {
            int i11 = f3149b[this.h.charAt(i3)];
            int i12 = 6;
            while (i12 >= 0) {
                int i13 = (i12 & 1) + ((i11 & 1) << 1);
                float f2 = (float) this.i[i2 + i12];
                if (f2 >= fArr2[i13] && f2 <= fArr[i13]) {
                    i11 >>= 1;
                    i12--;
                }
            }
            if (i3 < length) {
                i2 += 8;
                i3++;
            } else {
                return;
            }
        }
        throw m.getNotFoundInstance();
    }

    private void a(com.google.a.c.a aVar) throws m {
        this.j = 0;
        int d2 = aVar.d(0);
        int i2 = aVar.f3055b;
        if (d2 >= i2) {
            throw m.getNotFoundInstance();
        }
        boolean z = true;
        int i3 = 0;
        while (d2 < i2) {
            if (aVar.a(d2) != z) {
                i3++;
            } else {
                b(i3);
                z = !z;
                i3 = 1;
            }
            d2++;
        }
        b(i3);
    }

    static boolean a(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int b() throws m {
        for (int i2 = 1; i2 < this.j; i2 += 2) {
            int c2 = c(i2);
            if (c2 != -1 && a(g, f3148a[c2])) {
                int i3 = 0;
                for (int i4 = i2; i4 < i2 + 7; i4++) {
                    i3 += this.i[i4];
                }
                if (i2 == 1 || this.i[i2 - 1] >= i3 / 2) {
                    return i2;
                }
            }
        }
        throw m.getNotFoundInstance();
    }

    private void b(int i2) {
        this.i[this.j] = i2;
        this.j++;
        if (this.j >= this.i.length) {
            int[] iArr = new int[(this.j << 1)];
            System.arraycopy(this.i, 0, iArr, 0, this.j);
            this.i = iArr;
        }
    }

    private int c(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.j) {
            return -1;
        }
        int[] iArr = this.i;
        int i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i5 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i6 = 0;
        for (int i7 = i2; i7 < i3; i7 += 2) {
            int i8 = iArr[i7];
            if (i8 < i5) {
                i5 = i8;
            }
            if (i8 > i6) {
                i6 = i8;
            }
        }
        int i9 = (i5 + i6) / 2;
        int i10 = 0;
        for (int i11 = i2 + 1; i11 < i3; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i4) {
                i4 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        int i13 = (i4 + i10) / 2;
        int i14 = 128;
        int i15 = 0;
        for (int i16 = 0; i16 < 7; i16++) {
            i14 >>= 1;
            if (iArr[i2 + i16] > ((i16 & 1) == 0 ? i9 : i13)) {
                i15 |= i14;
            }
        }
        for (int i17 = 0; i17 < f3149b.length; i17++) {
            if (f3149b[i17] == i15) {
                return i17;
            }
        }
        return -1;
    }

    public final r a(int i2, com.google.a.c.a aVar, Map<e, ?> map) throws m {
        com.google.a.c.a aVar2 = aVar;
        Map<e, ?> map2 = map;
        Arrays.fill(this.i, 0);
        this.j = 0;
        int d2 = aVar2.d(0);
        int i3 = aVar2.f3055b;
        if (d2 >= i3) {
            throw m.getNotFoundInstance();
        }
        boolean z = true;
        int i4 = 0;
        while (d2 < i3) {
            if (aVar2.a(d2) != z) {
                i4++;
            } else {
                b(i4);
                z = !z;
                i4 = 1;
            }
            d2++;
        }
        b(i4);
        int i5 = 1;
        while (i5 < this.j) {
            int c2 = c(i5);
            if (c2 != -1 && a(g, f3148a[c2])) {
                int i6 = 0;
                for (int i7 = i5; i7 < i5 + 7; i7++) {
                    i6 += this.i[i7];
                }
                if (i5 == 1 || this.i[i5 - 1] >= i6 / 2) {
                    this.h.setLength(0);
                    int i8 = i5;
                    while (true) {
                        int c3 = c(i8);
                        if (c3 == -1) {
                            throw m.getNotFoundInstance();
                        }
                        this.h.append((char) c3);
                        i8 += 8;
                        if ((this.h.length() <= 1 || !a(g, f3148a[c3])) && i8 < this.j) {
                            int i9 = i2;
                        }
                    }
                    int i10 = i8 - 1;
                    int i11 = this.i[i10];
                    int i12 = 0;
                    for (int i13 = -8; i13 < -1; i13++) {
                        i12 += this.i[i8 + i13];
                    }
                    if (i8 >= this.j || i11 >= i12 / 2) {
                        int[] iArr = {0, 0, 0, 0};
                        int[] iArr2 = {0, 0, 0, 0};
                        int length = this.h.length() - 1;
                        int i14 = i5;
                        int i15 = 0;
                        while (true) {
                            int i16 = f3149b[this.h.charAt(i15)];
                            for (int i17 = 6; i17 >= 0; i17--) {
                                int i18 = (i17 & 1) + ((i16 & 1) << 1);
                                iArr[i18] = iArr[i18] + this.i[i14 + i17];
                                iArr2[i18] = iArr2[i18] + 1;
                                i16 >>= 1;
                            }
                            if (i15 >= length) {
                                break;
                            }
                            i14 += 8;
                            i15++;
                        }
                        float[] fArr = new float[4];
                        float[] fArr2 = new float[4];
                        int i19 = 0;
                        for (int i20 = 2; i19 < i20; i20 = 2) {
                            fArr2[i19] = 0.0f;
                            int i21 = i19 + 2;
                            fArr2[i21] = ((((float) iArr[i19]) / ((float) iArr2[i19])) + (((float) iArr[i21]) / ((float) iArr2[i21]))) / f3150c;
                            fArr[i19] = fArr2[i21];
                            fArr[i21] = ((((float) iArr[i21]) * f3150c) + d) / ((float) iArr2[i21]);
                            i19++;
                        }
                        int i22 = i5;
                        int i23 = 0;
                        loop8:
                        while (true) {
                            int i24 = f3149b[this.h.charAt(i23)];
                            int i25 = 6;
                            while (i25 >= 0) {
                                int i26 = (i25 & 1) + ((i24 & 1) << 1);
                                float f2 = (float) this.i[i22 + i25];
                                if (f2 >= fArr2[i26] && f2 <= fArr[i26]) {
                                    i24 >>= 1;
                                    i25--;
                                }
                            }
                            if (i23 < length) {
                                i22 += 8;
                                i23++;
                            } else {
                                for (int i27 = 0; i27 < this.h.length(); i27++) {
                                    this.h.setCharAt(i27, f3148a[this.h.charAt(i27)]);
                                }
                                if (!a(g, this.h.charAt(0))) {
                                    throw m.getNotFoundInstance();
                                }
                                if (!a(g, this.h.charAt(this.h.length() - 1))) {
                                    throw m.getNotFoundInstance();
                                } else if (this.h.length() <= 3) {
                                    throw m.getNotFoundInstance();
                                } else {
                                    if (map2 == null || !map2.containsKey(e.RETURN_CODABAR_START_END)) {
                                        this.h.deleteCharAt(this.h.length() - 1);
                                        this.h.deleteCharAt(0);
                                    }
                                    int i28 = 0;
                                    for (int i29 = 0; i29 < i5; i29++) {
                                        i28 += this.i[i29];
                                    }
                                    float f3 = (float) i28;
                                    while (i5 < i10) {
                                        i28 += this.i[i5];
                                        i5++;
                                    }
                                    float f4 = (float) i2;
                                    return new r(this.h.toString(), (byte[]) null, new t[]{new t(f3, f4), new t((float) i28, f4)}, com.google.a.a.CODABAR);
                                }
                            }
                        }
                        throw m.getNotFoundInstance();
                    }
                    throw m.getNotFoundInstance();
                }
            }
            int i30 = i2;
            i5 += 2;
        }
        throw m.getNotFoundInstance();
    }
}

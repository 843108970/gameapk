package com.google.a.g;

import com.google.a.c.a;
import com.google.a.d;
import com.google.a.e;
import com.google.a.h;
import com.google.a.m;
import com.google.a.q;
import com.google.a.r;
import com.google.a.s;
import com.google.a.t;
import com.google.a.u;
import java.util.Arrays;
import java.util.Map;

public abstract class y extends r {

    /* renamed from: a  reason: collision with root package name */
    private static final float f3229a = 0.48f;

    /* renamed from: b  reason: collision with root package name */
    static final int[] f3230b = {1, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f3231c = {1, 1, 1, 1, 1};
    static final int[] d = {1, 1, 1, 1, 1, 1};
    static final int[][] e = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[][] f = new int[20][];
    private static final float g = 0.7f;
    private final StringBuilder h = new StringBuilder(20);
    private final x i = new x();
    private final m j = new m();

    static {
        System.arraycopy(e, 0, f, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr = e[i2 - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr2[i3] = iArr[(iArr.length - i3) - 1];
            }
            f[i2] = iArr2;
        }
    }

    protected y() {
    }

    static int a(a aVar, int[] iArr, int i2, int[][] iArr2) throws m {
        a(aVar, i2, iArr);
        int length = iArr2.length;
        float f2 = f3229a;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float a2 = a(iArr, iArr2[i4], (float) g);
            if (a2 < f2) {
                i3 = i4;
                f2 = a2;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw m.getNotFoundInstance();
    }

    static boolean a(CharSequence charSequence) throws h {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = length - 1;
        return b(charSequence.subSequence(0, i2)) == Character.digit(charSequence.charAt(i2), 10);
    }

    static int[] a(a aVar) throws m {
        int[] iArr = new int[f3230b.length];
        int[] iArr2 = null;
        boolean z = false;
        int i2 = 0;
        while (!z) {
            Arrays.fill(iArr, 0, f3230b.length, 0);
            iArr2 = a(aVar, i2, false, f3230b, iArr);
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                z = aVar.a(i5, i3);
            }
            i2 = i4;
        }
        return iArr2;
    }

    static int[] a(a aVar, int i2, boolean z, int[] iArr) throws m {
        return a(aVar, i2, z, iArr, new int[iArr.length]);
    }

    private static int[] a(a aVar, int i2, boolean z, int[] iArr, int[] iArr2) throws m {
        int i3 = aVar.f3055b;
        int d2 = z ? aVar.d(i2) : aVar.c(i2);
        int length = iArr.length;
        int i4 = d2;
        int i5 = 0;
        while (d2 < i3) {
            boolean z2 = true;
            if (aVar.a(d2) != z) {
                iArr2[i5] = iArr2[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else if (a(iArr2, iArr, (float) g) < f3229a) {
                    return new int[]{i4, d2};
                } else {
                    i4 += iArr2[0] + iArr2[1];
                    int i6 = i5 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i5--;
                }
                iArr2[i5] = 1;
                if (z) {
                    z2 = false;
                }
                z = z2;
            }
            d2++;
        }
        throw m.getNotFoundInstance();
    }

    static int b(CharSequence charSequence) throws h {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            int charAt = charSequence.charAt(i3) - '0';
            if (charAt < 0 || charAt > 9) {
                throw h.getFormatInstance();
            }
            i2 += charAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 2; i5 >= 0; i5 -= 2) {
            int charAt2 = charSequence.charAt(i5) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw h.getFormatInstance();
            }
            i4 += charAt2;
        }
        return (1000 - i4) % 10;
    }

    /* access modifiers changed from: protected */
    public abstract int a(a aVar, int[] iArr, StringBuilder sb) throws m;

    public r a(int i2, a aVar, Map<e, ?> map) throws m, d, h {
        return a(i2, aVar, a(aVar), map);
    }

    public r a(int i2, a aVar, int[] iArr, Map<e, ?> map) throws m, d, h {
        int i3;
        boolean z;
        String str = null;
        u uVar = map == null ? null : (u) map.get(e.NEED_RESULT_POINT_CALLBACK);
        if (uVar != null) {
            new t(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i2);
        }
        StringBuilder sb = this.h;
        sb.setLength(0);
        int a2 = a(aVar, iArr, sb);
        if (uVar != null) {
            new t((float) a2, (float) i2);
        }
        int[] a3 = a(aVar, a2);
        if (uVar != null) {
            new t(((float) (a3[0] + a3[1])) / 2.0f, (float) i2);
        }
        int i4 = a3[1];
        int i5 = (i4 - a3[0]) + i4;
        if (i5 >= aVar.f3055b || !aVar.a(i4, i5)) {
            throw m.getNotFoundInstance();
        }
        String sb2 = sb.toString();
        if (sb2.length() < 8) {
            throw h.getFormatInstance();
        } else if (!a(sb2)) {
            throw d.getChecksumInstance();
        } else {
            com.google.a.a b2 = b();
            float f2 = (float) i2;
            r rVar = new r(sb2, (byte[]) null, new t[]{new t(((float) (iArr[1] + iArr[0])) / 2.0f, f2), new t(((float) (a3[1] + a3[0])) / 2.0f, f2)}, b2);
            try {
                r a4 = this.i.a(i2, aVar, a3[1]);
                rVar.a(s.UPC_EAN_EXTENSION, a4.f3353a);
                rVar.a(a4.f);
                t[] tVarArr = a4.d;
                t[] tVarArr2 = rVar.d;
                if (tVarArr2 == null) {
                    rVar.d = tVarArr;
                } else if (tVarArr != null && tVarArr.length > 0) {
                    t[] tVarArr3 = new t[(tVarArr2.length + tVarArr.length)];
                    System.arraycopy(tVarArr2, 0, tVarArr3, 0, tVarArr2.length);
                    System.arraycopy(tVarArr, 0, tVarArr3, tVarArr2.length, tVarArr.length);
                    rVar.d = tVarArr3;
                }
                i3 = a4.f3353a.length();
            } catch (q unused) {
                i3 = 0;
            }
            int[] iArr2 = map == null ? null : (int[]) map.get(e.ALLOWED_EAN_EXTENSIONS);
            if (iArr2 != null) {
                int length = iArr2.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        z = false;
                        break;
                    } else if (i3 == iArr2[i6]) {
                        z = true;
                        break;
                    } else {
                        i6++;
                    }
                }
                if (!z) {
                    throw m.getNotFoundInstance();
                }
            }
            if (b2 == com.google.a.a.EAN_13 || b2 == com.google.a.a.UPC_A) {
                m mVar = this.j;
                mVar.a();
                int parseInt = Integer.parseInt(sb2.substring(0, 3));
                int size = mVar.f3209a.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size) {
                        break;
                    }
                    int[] iArr3 = mVar.f3209a.get(i7);
                    int i8 = iArr3[0];
                    if (parseInt < i8) {
                        break;
                    }
                    if (iArr3.length != 1) {
                        i8 = iArr3[1];
                    }
                    if (parseInt <= i8) {
                        str = mVar.f3210b.get(i7);
                        break;
                    }
                    i7++;
                }
                if (str != null) {
                    rVar.a(s.POSSIBLE_COUNTRY, str);
                }
            }
            return rVar;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) throws h {
        return a((CharSequence) str);
    }

    /* access modifiers changed from: package-private */
    public int[] a(a aVar, int i2) throws m {
        return a(aVar, i2, false, f3230b);
    }

    /* access modifiers changed from: package-private */
    public abstract com.google.a.a b();
}

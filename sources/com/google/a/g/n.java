package com.google.a.g;

import com.google.a.c.a;
import com.google.a.e;
import com.google.a.h;
import com.google.a.m;
import com.google.a.r;
import com.google.a.t;
import java.util.Map;

public final class n extends r {

    /* renamed from: a  reason: collision with root package name */
    private static final float f3211a = 0.38f;

    /* renamed from: b  reason: collision with root package name */
    private static final float f3212b = 0.5f;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3213c = 3;
    private static final int d = 2;
    private static final int e = 1;
    private static final int[] f = {6, 8, 10, 12, 14};
    private static final int[] h = {1, 1, 1, 1};
    private static final int[][] i = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    private static final int[][] j = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private int g = -1;

    private static int a(int[] iArr) throws m {
        int length = j.length;
        float f2 = f3211a;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float a2 = a(iArr, j[i3], (float) f3212b);
            if (a2 < f2) {
                i2 = i3;
                f2 = a2;
            } else if (a2 == f2) {
                i2 = -1;
            }
        }
        if (i2 >= 0) {
            return i2 % 10;
        }
        throw m.getNotFoundInstance();
    }

    private void a(a aVar, int i2) throws m {
        int i3 = this.g * 10;
        if (i3 >= i2) {
            i3 = i2;
        }
        int i4 = i2 - 1;
        while (i3 > 0 && i4 >= 0 && !aVar.a(i4)) {
            i3--;
            i4--;
        }
        if (i3 != 0) {
            throw m.getNotFoundInstance();
        }
    }

    private static void a(a aVar, int i2, int i3, StringBuilder sb) throws m {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i2 < i3) {
            a(aVar, i2, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (a(iArr2) + 48));
            sb.append((char) (a(iArr3) + 48));
            for (int i6 = 0; i6 < 10; i6++) {
                i2 += iArr[i6];
            }
        }
    }

    private int[] a(a aVar) throws m {
        int[] c2 = c(aVar, b(aVar), h);
        this.g = (c2[1] - c2[0]) / 4;
        a(aVar, c2[0]);
        return c2;
    }

    private static int b(a aVar) throws m {
        int i2 = aVar.f3055b;
        int c2 = aVar.c(0);
        if (c2 != i2) {
            return c2;
        }
        throw m.getNotFoundInstance();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r3 = c(r7, r0, i[1]);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] c(com.google.a.c.a r7) throws com.google.a.m {
        /*
            r6 = this;
            r7.c()
            int r0 = b(r7)     // Catch:{ all -> 0x0031 }
            r1 = 1
            r2 = 0
            int[][] r3 = i     // Catch:{ m -> 0x0012 }
            r3 = r3[r2]     // Catch:{ m -> 0x0012 }
            int[] r3 = c(r7, r0, r3)     // Catch:{ m -> 0x0012 }
            goto L_0x001a
        L_0x0012:
            int[][] r3 = i     // Catch:{ all -> 0x0031 }
            r3 = r3[r1]     // Catch:{ all -> 0x0031 }
            int[] r3 = c(r7, r0, r3)     // Catch:{ all -> 0x0031 }
        L_0x001a:
            r0 = r3[r2]     // Catch:{ all -> 0x0031 }
            r6.a(r7, r0)     // Catch:{ all -> 0x0031 }
            r0 = r3[r2]     // Catch:{ all -> 0x0031 }
            int r4 = r7.f3055b     // Catch:{ all -> 0x0031 }
            r5 = r3[r1]     // Catch:{ all -> 0x0031 }
            int r4 = r4 - r5
            r3[r2] = r4     // Catch:{ all -> 0x0031 }
            int r2 = r7.f3055b     // Catch:{ all -> 0x0031 }
            int r2 = r2 - r0
            r3[r1] = r2     // Catch:{ all -> 0x0031 }
            r7.c()
            return r3
        L_0x0031:
            r0 = move-exception
            r7.c()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.n.c(com.google.a.c.a):int[]");
    }

    private static int[] c(a aVar, int i2, int[] iArr) throws m {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i3 = aVar.f3055b;
        int i4 = i2;
        boolean z = false;
        int i5 = 0;
        while (i2 < i3) {
            if (aVar.a(i2) != z) {
                iArr2[i5] = iArr2[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else if (a(iArr2, iArr, (float) f3212b) < f3211a) {
                    return new int[]{i4, i2};
                } else {
                    i4 += iArr2[0] + iArr2[1];
                    int i6 = i5 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i5--;
                }
                iArr2[i5] = 1;
                z = !z;
            }
            i2++;
        }
        throw m.getNotFoundInstance();
    }

    public final r a(int i2, a aVar, Map<e, ?> map) throws h, m {
        boolean z;
        int[] c2 = c(aVar, b(aVar), h);
        this.g = (c2[1] - c2[0]) / 4;
        a(aVar, c2[0]);
        int[] c3 = c(aVar);
        StringBuilder sb = new StringBuilder(20);
        a(aVar, c2[1], c3[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length2) {
                z = false;
                break;
            }
            int i5 = iArr[i3];
            if (length == i5) {
                z = true;
                break;
            }
            if (i5 > i4) {
                i4 = i5;
            }
            i3++;
        }
        if (!z && length > i4) {
            z = true;
        }
        if (!z) {
            throw h.getFormatInstance();
        }
        float f2 = (float) i2;
        return new r(sb2, (byte[]) null, new t[]{new t((float) c2[1], f2), new t((float) c3[0], f2)}, com.google.a.a.ITF);
    }
}

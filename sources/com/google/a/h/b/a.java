package com.google.a.h.b;

import com.google.a.c;
import com.google.a.c.b;
import com.google.a.m;
import com.google.a.t;
import java.util.Arrays;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3266a = {0, 4, 1, 5};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3267b = {6, 2, 7, 3};

    /* renamed from: c  reason: collision with root package name */
    private static final float f3268c = 0.42f;
    private static final float d = 0.8f;
    private static final int[] e = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] f = {7, 1, 1, 3, 1, 1, 1, 2, 1};
    private static final int g = 3;
    private static final int h = 5;
    private static final int i = 25;
    private static final int j = 5;
    private static final int k = 10;

    private a() {
    }

    private static float a(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i2;
        float f3 = f2 / ((float) i3);
        float f4 = d * f3;
        float f5 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            float f6 = ((float) iArr2[i5]) * f3;
            float f7 = (float) i6;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    public static b a(c cVar, boolean z) throws m {
        b c2 = cVar.c();
        List<t[]> a2 = a(z, c2);
        if (a2.isEmpty()) {
            c2 = c2.clone();
            int i2 = c2.f3061a;
            int i3 = c2.f3062b;
            com.google.a.c.a aVar = new com.google.a.c.a(i2);
            com.google.a.c.a aVar2 = new com.google.a.c.a(i2);
            for (int i4 = 0; i4 < (i3 + 1) / 2; i4++) {
                aVar = c2.a(i4, aVar);
                int i5 = (i3 - 1) - i4;
                aVar2 = c2.a(i5, aVar2);
                aVar.c();
                aVar2.c();
                c2.b(i4, aVar2);
                c2.b(i5, aVar);
            }
            a2 = a(z, c2);
        }
        return new b(c2, a2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0054, code lost:
        if (r12 == false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
        r1 = r7.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005e, code lost:
        if (r1.hasNext() == false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0060, code lost:
        r2 = (com.google.a.t[]) r1.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        if (r2[1] == null) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        r10 = (int) java.lang.Math.max((float) r10, r2[1].f3357b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0076, code lost:
        if (r2[3] == null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
        r10 = java.lang.Math.max(r10, (int) r2[3].f3357b);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.google.a.t[]> a(boolean r17, com.google.a.c.b r18) {
        /*
            r6 = r18
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8 = 1
            r9 = 0
            r10 = 0
        L_0x000a:
            r11 = 0
            r12 = 0
        L_0x000c:
            int r0 = r6.f3062b
            if (r10 >= r0) goto L_0x00a5
            int r13 = r6.f3062b
            int r14 = r6.f3061a
            r0 = 8
            com.google.a.t[] r15 = new com.google.a.t[r0]
            int[] r5 = e
            r0 = r6
            r1 = r13
            r2 = r14
            r3 = r10
            r4 = r11
            com.google.a.t[] r0 = a(r0, r1, r2, r3, r4, r5)
            int[] r1 = f3266a
            a((com.google.a.t[]) r15, (com.google.a.t[]) r0, (int[]) r1)
            r16 = 4
            r0 = r15[r16]
            if (r0 == 0) goto L_0x003b
            r0 = r15[r16]
            float r0 = r0.f3356a
            int r0 = (int) r0
            r1 = r15[r16]
            float r1 = r1.f3357b
            int r1 = (int) r1
            r4 = r0
            r3 = r1
            goto L_0x003d
        L_0x003b:
            r3 = r10
            r4 = r11
        L_0x003d:
            int[] r5 = f
            r0 = r6
            r1 = r13
            r2 = r14
            com.google.a.t[] r0 = a(r0, r1, r2, r3, r4, r5)
            int[] r1 = f3267b
            a((com.google.a.t[]) r15, (com.google.a.t[]) r0, (int[]) r1)
            r0 = r15[r9]
            if (r0 != 0) goto L_0x0086
            r0 = 3
            r1 = r15[r0]
            if (r1 != 0) goto L_0x0086
            if (r12 == 0) goto L_0x00a5
            java.util.Iterator r1 = r7.iterator()
        L_0x005a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0083
            java.lang.Object r2 = r1.next()
            com.google.a.t[] r2 = (com.google.a.t[]) r2
            r3 = r2[r8]
            if (r3 == 0) goto L_0x0074
            float r3 = (float) r10
            r4 = r2[r8]
            float r4 = r4.f3357b
            float r3 = java.lang.Math.max(r3, r4)
            int r10 = (int) r3
        L_0x0074:
            r3 = r2[r0]
            if (r3 == 0) goto L_0x005a
            r2 = r2[r0]
            float r2 = r2.f3357b
            int r2 = (int) r2
            int r2 = java.lang.Math.max(r10, r2)
            r10 = r2
            goto L_0x005a
        L_0x0083:
            int r10 = r10 + 5
            goto L_0x000a
        L_0x0086:
            r7.add(r15)
            if (r17 == 0) goto L_0x00a5
            r1 = 2
            r2 = r15[r1]
            if (r2 == 0) goto L_0x009d
            r2 = r15[r1]
            float r2 = r2.f3356a
            int r11 = (int) r2
            r1 = r15[r1]
        L_0x0097:
            float r1 = r1.f3357b
            int r10 = (int) r1
            r12 = 1
            goto L_0x000c
        L_0x009d:
            r1 = r15[r16]
            float r1 = r1.f3356a
            int r11 = (int) r1
            r1 = r15[r16]
            goto L_0x0097
        L_0x00a5:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.b.a.a(boolean, com.google.a.c.b):java.util.List");
    }

    private static void a(t[] tVarArr, t[] tVarArr2, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            tVarArr[iArr[i2]] = tVarArr2[i2];
        }
    }

    private static int[] a(b bVar, int i2, int i3, int i4, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i5 = 0;
        while (bVar.a(i2, i3) && i2 > 0) {
            int i6 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i2--;
            i5 = i6;
        }
        int length = iArr.length;
        int i7 = i2;
        int i8 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 < i4) {
                if (bVar.a(i2, i3) != z) {
                    iArr2[i8] = iArr2[i8] + 1;
                } else {
                    if (i8 != length - 1) {
                        i8++;
                    } else if (a(iArr2, iArr) < f3268c) {
                        return new int[]{i7, i2};
                    } else {
                        i7 += iArr2[0] + iArr2[1];
                        int i9 = i8 - 1;
                        System.arraycopy(iArr2, 2, iArr2, 0, i9);
                        iArr2[i9] = 0;
                        iArr2[i8] = 0;
                        i8--;
                    }
                    iArr2[i8] = 1;
                    if (z) {
                        z2 = false;
                    }
                    z = z2;
                }
                i2++;
            } else if (i8 != length - 1 || a(iArr2, iArr) >= f3268c) {
                return null;
            } else {
                return new int[]{i7, i2 - 1};
            }
        }
    }

    private static t[] a(b bVar, int i2, int i3) {
        int i4 = bVar.f3062b;
        int i5 = bVar.f3061a;
        t[] tVarArr = new t[8];
        a(tVarArr, a(bVar, i4, i5, i2, i3, e), f3266a);
        if (tVarArr[4] != null) {
            i3 = (int) tVarArr[4].f3356a;
            i2 = (int) tVarArr[4].f3357b;
        }
        a(tVarArr, a(bVar, i4, i5, i2, i3, f), f3267b);
        return tVarArr;
    }

    private static t[] a(b bVar, int i2, int i3, int i4, int i5, int[] iArr) {
        boolean z;
        int i6;
        int[] iArr2;
        int i7 = i2;
        t[] tVarArr = new t[4];
        int[] iArr3 = iArr;
        int[] iArr4 = new int[iArr3.length];
        int i8 = i4;
        while (true) {
            if (i8 >= i7) {
                z = false;
                break;
            }
            int[] a2 = a(bVar, i5, i8, i3, false, iArr3, iArr4);
            if (a2 != null) {
                while (true) {
                    iArr2 = a2;
                    if (i8 <= 0) {
                        break;
                    }
                    i8--;
                    a2 = a(bVar, i5, i8, i3, false, iArr3, iArr4);
                    if (a2 == null) {
                        i8++;
                        break;
                    }
                }
                float f2 = (float) i8;
                tVarArr[0] = new t((float) iArr2[0], f2);
                tVarArr[1] = new t((float) iArr2[1], f2);
                z = true;
            } else {
                i8 += 5;
            }
        }
        int i9 = i8 + 1;
        if (z) {
            int[] iArr5 = {(int) tVarArr[0].f3356a, (int) tVarArr[1].f3356a};
            int i10 = i9;
            int i11 = 0;
            while (true) {
                if (i10 >= i7) {
                    i6 = i11;
                    break;
                }
                i6 = i11;
                int[] a3 = a(bVar, iArr5[0], i10, i3, false, iArr3, iArr4);
                if (a3 == null || Math.abs(iArr5[0] - a3[0]) >= 5 || Math.abs(iArr5[1] - a3[1]) >= 5) {
                    if (i6 > 25) {
                        break;
                    }
                    i11 = i6 + 1;
                } else {
                    iArr5 = a3;
                    i11 = 0;
                }
                i10++;
            }
            i9 = i10 - (i6 + 1);
            float f3 = (float) i9;
            tVarArr[2] = new t((float) iArr5[0], f3);
            tVarArr[3] = new t((float) iArr5[1], f3);
        }
        if (i9 - i8 < 10) {
            Arrays.fill(tVarArr, (Object) null);
        }
        return tVarArr;
    }
}

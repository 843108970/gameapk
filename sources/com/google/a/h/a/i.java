package com.google.a.h.a;

import com.google.a.h.a;
import java.lang.reflect.Array;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final float[][] f3262a = ((float[][]) Array.newInstance(float.class, new int[]{a.h.length, 8}));

    static {
        int i;
        for (int i2 = 0; i2 < a.h.length; i2++) {
            int i3 = a.h[i2];
            int i4 = i3 & 1;
            int i5 = i3;
            int i6 = 0;
            while (i6 < 8) {
                float f = 0.0f;
                while (true) {
                    i = i5 & 1;
                    if (i != i4) {
                        break;
                    }
                    f += 1.0f;
                    i5 >>= 1;
                }
                f3262a[i2][(8 - i6) - 1] = f / 17.0f;
                i6++;
                i4 = i;
            }
        }
    }

    private i() {
    }

    static int a(int[] iArr) {
        float a2 = (float) com.google.a.c.a.a.a(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (((float) (iArr[i2] + i)) <= (a2 / 34.0f) + ((((float) i3) * a2) / 17.0f)) {
                i += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        long j = 0;
        int i4 = 0;
        while (i4 < 8) {
            long j2 = j;
            int i5 = 0;
            while (i5 < iArr2[i4]) {
                i5++;
                j2 = (j2 << 1) | ((long) (i4 % 2 == 0 ? 1 : 0));
            }
            i4++;
            j = j2;
        }
        int i6 = (int) j;
        int i7 = -1;
        if (a.a(i6) == -1) {
            i6 = -1;
        }
        if (i6 != -1) {
            return i6;
        }
        int a3 = com.google.a.c.a.a.a(iArr);
        float[] fArr = new float[8];
        if (a3 > 1) {
            for (int i8 = 0; i8 < 8; i8++) {
                fArr[i8] = ((float) iArr[i8]) / ((float) a3);
            }
        }
        float f = Float.MAX_VALUE;
        for (int i9 = 0; i9 < f3262a.length; i9++) {
            float[] fArr2 = f3262a[i9];
            float f2 = 0.0f;
            for (int i10 = 0; i10 < 8; i10++) {
                float f3 = fArr2[i10] - fArr[i10];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                i7 = a.h[i9];
                f = f2;
            }
        }
        return i7;
    }

    private static int[] b(int[] iArr) {
        float a2 = (float) com.google.a.c.a.a.a(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (((float) (iArr[i2] + i)) <= (a2 / 34.0f) + ((((float) i3) * a2) / 17.0f)) {
                i += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }

    private static int c(int[] iArr) {
        long j = 0;
        int i = 0;
        while (i < iArr.length) {
            long j2 = j;
            int i2 = 0;
            while (i2 < iArr[i]) {
                int i3 = 1;
                long j3 = j2 << 1;
                if (i % 2 != 0) {
                    i3 = 0;
                }
                i2++;
                j2 = j3 | ((long) i3);
            }
            i++;
            j = j2;
        }
        int i4 = (int) j;
        if (a.a(i4) == -1) {
            return -1;
        }
        return i4;
    }

    private static int d(int[] iArr) {
        long j = 0;
        int i = 0;
        while (i < iArr.length) {
            long j2 = j;
            int i2 = 0;
            while (i2 < iArr[i]) {
                int i3 = 1;
                long j3 = j2 << 1;
                if (i % 2 != 0) {
                    i3 = 0;
                }
                i2++;
                j2 = j3 | ((long) i3);
            }
            i++;
            j = j2;
        }
        return (int) j;
    }

    private static int e(int[] iArr) {
        int a2 = com.google.a.c.a.a.a(iArr);
        float[] fArr = new float[8];
        if (a2 > 1) {
            for (int i = 0; i < 8; i++) {
                fArr[i] = ((float) iArr[i]) / ((float) a2);
            }
        }
        int i2 = -1;
        float f = Float.MAX_VALUE;
        for (int i3 = 0; i3 < f3262a.length; i3++) {
            float[] fArr2 = f3262a[i3];
            float f2 = 0.0f;
            for (int i4 = 0; i4 < 8; i4++) {
                float f3 = fArr2[i4] - fArr[i4];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                i2 = a.h[i3];
                f = f2;
            }
        }
        return i2;
    }
}

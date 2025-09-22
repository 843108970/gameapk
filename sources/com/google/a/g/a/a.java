package com.google.a.g.a;

import android.support.v7.widget.ActivityChooserView;
import com.google.a.g.r;
import com.google.a.m;

public abstract class a extends r {
    private static final float g = 0.2f;
    private static final float h = 0.45f;
    private static final float i = 0.7916667f;
    private static final float j = 0.89285713f;

    /* renamed from: a  reason: collision with root package name */
    protected final int[] f3151a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    protected final int[] f3152b = new int[8];

    /* renamed from: c  reason: collision with root package name */
    protected final float[] f3153c = new float[4];
    protected final float[] d = new float[4];
    protected final int[] e = new int[(this.f3152b.length / 2)];
    protected final int[] f = new int[(this.f3152b.length / 2)];

    protected a() {
    }

    protected static int a(int[] iArr, int[][] iArr2) throws m {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (a(iArr, iArr2[i2], (float) h) < g) {
                return i2;
            }
        }
        throw m.getNotFoundInstance();
    }

    protected static void a(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i2 = 0;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] > f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] + 1;
    }

    protected static boolean a(int[] iArr) {
        int i2 = iArr[0] + iArr[1];
        float f2 = ((float) i2) / ((float) ((iArr[2] + i2) + iArr[3]));
        if (f2 >= i && f2 <= j) {
            int i3 = Integer.MIN_VALUE;
            int i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            for (int i5 : iArr) {
                if (i5 > i3) {
                    i3 = i5;
                }
                if (i5 < i4) {
                    i4 = i5;
                }
            }
            if (i3 < i4 * 10) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    private static int b(int[] iArr) {
        return com.google.a.c.a.a.a(iArr);
    }

    protected static void b(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i2 = 0;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] < f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] - 1;
    }

    private int[] b() {
        return this.f3151a;
    }

    private int[] c() {
        return this.f3152b;
    }

    private float[] d() {
        return this.f3153c;
    }

    private float[] e() {
        return this.d;
    }

    private int[] f() {
        return this.e;
    }

    private int[] g() {
        return this.f;
    }
}

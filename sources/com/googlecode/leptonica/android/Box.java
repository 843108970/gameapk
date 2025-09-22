package com.googlecode.leptonica.android;

import android.graphics.Rect;
import android.util.Log;

public class Box {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3364a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3365b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3366c = 2;
    public static final int d = 3;
    private static final String e = "Box";
    private final long f;
    private boolean g = false;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private Box(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0) {
            throw new IllegalArgumentException("All box dimensions must be non-negative");
        }
        long nativeCreate = nativeCreate(i, i2, i3, i4);
        if (nativeCreate == 0) {
            throw new OutOfMemoryError();
        }
        this.f = nativeCreate;
        this.g = false;
    }

    Box(long j) {
        this.f = j;
        this.g = false;
    }

    private boolean a(int[] iArr) {
        if (!this.g) {
            return nativeGetGeometry(this.f, iArr);
        }
        throw new IllegalStateException();
    }

    private int b() {
        if (!this.g) {
            return nativeGetX(this.f);
        }
        throw new IllegalStateException();
    }

    private int c() {
        if (!this.g) {
            return nativeGetY(this.f);
        }
        throw new IllegalStateException();
    }

    private int d() {
        if (!this.g) {
            return nativeGetWidth(this.f);
        }
        throw new IllegalStateException();
    }

    private int e() {
        if (!this.g) {
            return nativeGetHeight(this.f);
        }
        throw new IllegalStateException();
    }

    private Rect f() {
        int[] iArr = new int[4];
        if (this.g) {
            throw new IllegalStateException();
        }
        if (!nativeGetGeometry(this.f, iArr)) {
            iArr = null;
        }
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, iArr[2] + i, iArr[3] + i2);
    }

    private int[] g() {
        int[] iArr = new int[4];
        if (this.g) {
            throw new IllegalStateException();
        } else if (nativeGetGeometry(this.f, iArr)) {
            return iArr;
        } else {
            return null;
        }
    }

    private void h() {
        if (!this.g) {
            nativeDestroy(this.f);
            this.g = true;
        }
    }

    private static native long nativeCreate(int i, int i2, int i3, int i4);

    private static native void nativeDestroy(long j);

    private static native boolean nativeGetGeometry(long j, int[] iArr);

    private static native int nativeGetHeight(long j);

    private static native int nativeGetWidth(long j);

    private static native int nativeGetX(long j);

    private static native int nativeGetY(long j);

    public final long a() {
        if (!this.g) {
            return this.f;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (!this.g) {
                Log.w(e, "Box was not terminated using recycle()");
                if (!this.g) {
                    nativeDestroy(this.f);
                    this.g = true;
                }
            }
        } finally {
            super.finalize();
        }
    }
}

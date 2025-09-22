package com.googlecode.leptonica.android;

import android.graphics.Rect;

public class Pix {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3380a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3381b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3382c = 2;
    final long d;
    boolean e;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private Pix(int i, int i2, int i3) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Pix width and height must be > 0");
        } else if (i3 == 1 || i3 == 2 || i3 == 4 || i3 == 8 || i3 == 16 || i3 == 24 || i3 == 32) {
            this.d = nativeCreatePix(i, i2, i3);
            this.e = false;
        } else {
            throw new IllegalArgumentException("Depth must be one of 1, 2, 4, 8, 16, or 32");
        }
    }

    public Pix(long j) {
        this.d = j;
        this.e = false;
    }

    private int a(int i, int i2) {
        if (this.e) {
            throw new IllegalStateException();
        } else if (i < 0 || i >= c()) {
            throw new IllegalArgumentException("Supplied x coordinate exceeds image bounds");
        } else if (i2 >= 0 && i2 < d()) {
            return nativeGetPixel(this.d, i, i2);
        } else {
            throw new IllegalArgumentException("Supplied y coordinate exceeds image bounds");
        }
    }

    private static Pix a(byte[] bArr, int i, int i2, int i3) {
        long nativeCreateFromData = nativeCreateFromData(bArr, i, i2, i3);
        if (nativeCreateFromData != 0) {
            return new Pix(nativeCreateFromData);
        }
        throw new OutOfMemoryError();
    }

    private void a(int i, int i2, int i3) {
        if (this.e) {
            throw new IllegalStateException();
        } else if (i < 0 || i >= c()) {
            throw new IllegalArgumentException("Supplied x coordinate exceeds image bounds");
        } else if (i2 < 0 || i2 >= d()) {
            throw new IllegalArgumentException("Supplied y coordinate exceeds image bounds");
        } else {
            nativeSetPixel(this.d, i, i2, i3);
        }
    }

    private boolean a(int[] iArr) {
        if (!this.e) {
            return nativeGetDimensions(this.d, iArr);
        }
        throw new IllegalStateException();
    }

    private byte[] f() {
        if (this.e) {
            throw new IllegalStateException();
        }
        byte[] nativeGetData = nativeGetData(this.d);
        if (nativeGetData != null) {
            return nativeGetData;
        }
        throw new RuntimeException("native getData failed");
    }

    private int[] g() {
        if (this.e) {
            throw new IllegalStateException();
        }
        int[] iArr = new int[3];
        if (this.e) {
            throw new IllegalStateException();
        } else if (nativeGetDimensions(this.d, iArr)) {
            return iArr;
        } else {
            return null;
        }
    }

    private Pix h() {
        if (this.e) {
            throw new IllegalStateException();
        }
        long nativeClone = nativeClone(this.d);
        if (nativeClone != 0) {
            return new Pix(nativeClone);
        }
        throw new OutOfMemoryError();
    }

    private Pix i() {
        if (this.e) {
            throw new IllegalStateException();
        }
        long nativeCopy = nativeCopy(this.d);
        if (nativeCopy != 0) {
            return new Pix(nativeCopy);
        }
        throw new OutOfMemoryError();
    }

    private boolean j() {
        if (!this.e) {
            return nativeInvert(this.d);
        }
        throw new IllegalStateException();
    }

    private Rect k() {
        return new Rect(0, 0, c(), d());
    }

    private int l() {
        return nativeGetRefCount(this.d);
    }

    private static native long nativeClone(long j);

    private static native long nativeCopy(long j);

    private static native long nativeCreateFromData(byte[] bArr, int i, int i2, int i3);

    private static native long nativeCreatePix(int i, int i2, int i3);

    private static native void nativeDestroy(long j);

    private static native byte[] nativeGetData(long j);

    private static native int nativeGetDepth(long j);

    static native boolean nativeGetDimensions(long j, int[] iArr);

    private static native int nativeGetHeight(long j);

    private static native int nativeGetPixel(long j, int i, int i2);

    private static native int nativeGetRefCount(long j);

    private static native int nativeGetWidth(long j);

    private static native boolean nativeInvert(long j);

    private static native void nativeSetPixel(long j, int i, int i2, int i3);

    public final long a() {
        if (!this.e) {
            return this.d;
        }
        throw new IllegalStateException();
    }

    public final void b() {
        if (!this.e) {
            nativeDestroy(this.d);
            this.e = true;
        }
    }

    public final int c() {
        if (!this.e) {
            return nativeGetWidth(this.d);
        }
        throw new IllegalStateException();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        if (this.e) {
            throw new IllegalStateException();
        }
        long nativeClone = nativeClone(this.d);
        if (nativeClone != 0) {
            return new Pix(nativeClone);
        }
        throw new OutOfMemoryError();
    }

    public final int d() {
        if (!this.e) {
            return nativeGetHeight(this.d);
        }
        throw new IllegalStateException();
    }

    public final int e() {
        if (!this.e) {
            return nativeGetDepth(this.d);
        }
        throw new IllegalStateException();
    }
}

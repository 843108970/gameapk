package com.googlecode.leptonica.android;

import android.graphics.Rect;
import android.util.Log;

public class Boxa {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3367a = "Boxa";

    /* renamed from: b  reason: collision with root package name */
    private final long f3368b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3369c = false;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private Boxa(long j) {
        this.f3368b = j;
        this.f3369c = false;
    }

    private long a() {
        if (!this.f3369c) {
            return this.f3368b;
        }
        throw new IllegalStateException();
    }

    private Rect a(int i) {
        if (this.f3369c) {
            throw new IllegalStateException();
        }
        int[] iArr = new int[4];
        if (this.f3369c) {
            throw new IllegalStateException();
        }
        if (!nativeGetGeometry(this.f3368b, i, iArr)) {
            iArr = null;
        }
        int i2 = iArr[0];
        int i3 = iArr[1];
        return new Rect(i2, i3, iArr[2] + i2, iArr[3] + i3);
    }

    private boolean a(int i, int[] iArr) {
        if (!this.f3369c) {
            return nativeGetGeometry(this.f3368b, i, iArr);
        }
        throw new IllegalStateException();
    }

    private int b() {
        if (!this.f3369c) {
            return nativeGetCount(this.f3368b);
        }
        throw new IllegalStateException();
    }

    private int[] b(int i) {
        if (this.f3369c) {
            throw new IllegalStateException();
        }
        int[] iArr = new int[4];
        if (this.f3369c) {
            throw new IllegalStateException();
        } else if (nativeGetGeometry(this.f3368b, i, iArr)) {
            return iArr;
        } else {
            return null;
        }
    }

    private synchronized void c() {
        if (!this.f3369c) {
            nativeDestroy(this.f3368b);
            this.f3369c = true;
        }
    }

    private static native void nativeDestroy(long j);

    private static native int nativeGetCount(long j);

    private static native boolean nativeGetGeometry(long j, int i, int[] iArr);

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (!this.f3369c) {
                Log.w(f3367a, "Boxa was not terminated using recycle()");
                c();
            }
        } finally {
            super.finalize();
        }
    }
}

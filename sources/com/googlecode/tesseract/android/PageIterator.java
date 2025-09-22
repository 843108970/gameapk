package com.googlecode.tesseract.android;

import android.graphics.Rect;

public class PageIterator {

    /* renamed from: a  reason: collision with root package name */
    private final long f3400a;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
        System.loadLibrary("tess");
    }

    PageIterator(long j) {
        this.f3400a = j;
    }

    private void a() {
        nativeBegin(this.f3400a);
    }

    private boolean a(int i) {
        return nativeNext(this.f3400a, i);
    }

    private int[] b(int i) {
        return nativeBoundingBox(this.f3400a, i);
    }

    private Rect c(int i) {
        int[] nativeBoundingBox = nativeBoundingBox(this.f3400a, i);
        return new Rect(nativeBoundingBox[0], nativeBoundingBox[1], nativeBoundingBox[2], nativeBoundingBox[3]);
    }

    private static native void nativeBegin(long j);

    private static native int[] nativeBoundingBox(long j, int i);

    private static native boolean nativeNext(long j, int i);
}

package com.googlecode.leptonica.android;

public class Enhance {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3373a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final float f3374b = 0.3f;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private static Pix a(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        long nativeUnsharpMasking = nativeUnsharpMasking(pix.a(), 1, 0.3f);
        if (nativeUnsharpMasking != 0) {
            return new Pix(nativeUnsharpMasking);
        }
        throw new OutOfMemoryError();
    }

    private static Pix b(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        long nativeUnsharpMasking = nativeUnsharpMasking(pix.a(), 1, 0.3f);
        if (nativeUnsharpMasking != 0) {
            return new Pix(nativeUnsharpMasking);
        }
        throw new OutOfMemoryError();
    }

    private static native long nativeUnsharpMasking(long j, int i, float f);
}

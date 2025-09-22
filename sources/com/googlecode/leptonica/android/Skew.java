package com.googlecode.leptonica.android;

public class Skew {

    /* renamed from: a  reason: collision with root package name */
    public static final float f3394a = 30.0f;

    /* renamed from: b  reason: collision with root package name */
    public static final float f3395b = 5.0f;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3396c = 8;
    public static final int d = 4;
    public static final float e = 0.01f;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private static float a(Pix pix) {
        if (pix != null) {
            return nativeFindSkew(pix.a(), 30.0f, 5.0f, 8, 4, 0.01f);
        }
        throw new IllegalArgumentException("Source pix must be non-null");
    }

    private static float b(Pix pix) {
        if (pix != null) {
            return nativeFindSkew(pix.a(), 30.0f, 5.0f, 8, 4, 0.01f);
        }
        throw new IllegalArgumentException("Source pix must be non-null");
    }

    private static native float nativeFindSkew(long j, float f, float f2, int i, int i2, float f3);
}

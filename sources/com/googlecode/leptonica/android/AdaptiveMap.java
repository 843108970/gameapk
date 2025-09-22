package com.googlecode.leptonica.android;

public class AdaptiveMap {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3358a = 10;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3359b = 15;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3360c = 40;
    public static final int d = 2;
    public static final int e = 1;
    private static final int f = 16;
    private static final int g = 3;
    private static final int h = 200;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private static Pix a(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        long nativeBackgroundNormMorph = nativeBackgroundNormMorph(pix.a(), 16, 3, 200);
        if (nativeBackgroundNormMorph != 0) {
            return new Pix(nativeBackgroundNormMorph);
        }
        throw new RuntimeException("Failed to normalize image background");
    }

    private static Pix b(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        long nativeBackgroundNormMorph = nativeBackgroundNormMorph(pix.a(), 16, 3, 200);
        if (nativeBackgroundNormMorph != 0) {
            return new Pix(nativeBackgroundNormMorph);
        }
        throw new RuntimeException("Failed to normalize image background");
    }

    private static Pix c(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        long nativePixContrastNorm = nativePixContrastNorm(pix.a(), 10, 15, 40, 2, 1);
        if (nativePixContrastNorm != 0) {
            return new Pix(nativePixContrastNorm);
        }
        throw new RuntimeException("Failed to normalize image contrast");
    }

    private static Pix d(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        long nativePixContrastNorm = nativePixContrastNorm(pix.a(), 10, 15, 40, 2, 1);
        if (nativePixContrastNorm != 0) {
            return new Pix(nativePixContrastNorm);
        }
        throw new RuntimeException("Failed to normalize image contrast");
    }

    private static native long nativeBackgroundNormMorph(long j, int i, int i2, int i3);

    private static native long nativePixContrastNorm(long j, int i, int i2, int i3, int i4, int i5);
}

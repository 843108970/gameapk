package com.googlecode.leptonica.android;

public class Binarize {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3361a = 32;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3362b = 32;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3363c = 2;
    public static final int d = 2;
    public static final float e = 0.1f;
    public static final int f = 8;
    public static final float g = 0.35f;
    public static final int h = 1;
    public static final int i = 1;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private static Pix a(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (pix.e() != 8) {
            throw new IllegalArgumentException("Source pix depth must be 8bpp");
        } else {
            long nativeOtsuAdaptiveThreshold = nativeOtsuAdaptiveThreshold(pix.a(), 32, 32, 2, 2, 0.1f);
            if (nativeOtsuAdaptiveThreshold != 0) {
                return new Pix(nativeOtsuAdaptiveThreshold);
            }
            throw new RuntimeException("Failed to perform Otsu adaptive threshold on image");
        }
    }

    private static Pix b(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (pix.e() != 8) {
            throw new IllegalArgumentException("Source pix depth must be 8bpp");
        } else {
            long nativeOtsuAdaptiveThreshold = nativeOtsuAdaptiveThreshold(pix.a(), 32, 32, 2, 2, 0.1f);
            if (nativeOtsuAdaptiveThreshold != 0) {
                return new Pix(nativeOtsuAdaptiveThreshold);
            }
            throw new RuntimeException("Failed to perform Otsu adaptive threshold on image");
        }
    }

    private static Pix c(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (pix.e() != 8) {
            throw new IllegalArgumentException("Source pix depth must be 8bpp");
        } else {
            long nativeSauvolaBinarizeTiled = nativeSauvolaBinarizeTiled(pix.a(), 8, 0.35f, 1, 1);
            if (nativeSauvolaBinarizeTiled != 0) {
                return new Pix(nativeSauvolaBinarizeTiled);
            }
            throw new RuntimeException("Failed to perform Sauvola binarization on image");
        }
    }

    private static Pix d(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (pix.e() != 8) {
            throw new IllegalArgumentException("Source pix depth must be 8bpp");
        } else {
            long nativeSauvolaBinarizeTiled = nativeSauvolaBinarizeTiled(pix.a(), 8, 0.35f, 1, 1);
            if (nativeSauvolaBinarizeTiled != 0) {
                return new Pix(nativeSauvolaBinarizeTiled);
            }
            throw new RuntimeException("Failed to perform Sauvola binarization on image");
        }
    }

    private static native long nativeOtsuAdaptiveThreshold(long j, int i2, int i3, int i4, int i5, float f2);

    private static native long nativeSauvolaBinarizeTiled(long j, int i2, float f2, int i3, int i4);
}

package com.googlecode.leptonica.android;

public class MorphApp {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3377a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3378b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3379c = 7;
    public static final int d = 7;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private static Pix a(Pix pix) {
        return a(pix, 1);
    }

    private static Pix a(Pix pix, int i) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (pix.e() != 8) {
            throw new IllegalArgumentException("Source pix depth must be 8bpp");
        } else if (i < 0 || i > 1) {
            throw new IllegalArgumentException("Type must be L_TOPHAT_BLACK or L_TOPHAT_WHITE");
        } else {
            long nativePixFastTophat = nativePixFastTophat(pix.a(), 7, 7, i);
            if (nativePixFastTophat != 0) {
                return new Pix(nativePixFastTophat);
            }
            throw new RuntimeException("Failed to perform pixFastTophat on image");
        }
    }

    private static Pix a(Pix pix, int i, int i2, int i3) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (pix.e() != 8) {
            throw new IllegalArgumentException("Source pix depth must be 8bpp");
        } else if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("hsize or vsize < 1");
        } else if (i3 < 0 || i3 > 1) {
            throw new IllegalArgumentException("Type must be L_TOPHAT_BLACK or L_TOPHAT_WHITE");
        } else {
            long nativePixTophat = nativePixTophat(pix.a(), i, i2, i3);
            if (nativePixTophat != 0) {
                return new Pix(nativePixTophat);
            }
            throw new RuntimeException("Failed to perform Tophat on image");
        }
    }

    private static Pix b(Pix pix) {
        return a(pix, 0);
    }

    private static native long nativePixFastTophat(long j, int i, int i2, int i3);

    private static native long nativePixTophat(long j, int i, int i2, int i3);
}

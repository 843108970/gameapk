package com.googlecode.leptonica.android;

public class Rotate {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3389a = true;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private static Pix a(Pix pix, float f) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        long nativeRotate = nativeRotate(pix.a(), f, false, true);
        if (nativeRotate == 0) {
            return null;
        }
        return new Pix(nativeRotate);
    }

    private static Pix a(Pix pix, float f, boolean z) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        long nativeRotate = nativeRotate(pix.a(), f, z, true);
        if (nativeRotate == 0) {
            return null;
        }
        return new Pix(nativeRotate);
    }

    private static Pix a(Pix pix, int i) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (i < 0 || i > 3) {
            throw new IllegalArgumentException("quads not in {0,1,2,3}");
        } else {
            int nativeRotateOrth = nativeRotateOrth(pix.a(), i);
            if (nativeRotateOrth == 0) {
                return null;
            }
            return new Pix((long) nativeRotateOrth);
        }
    }

    private static Pix b(Pix pix, float f) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        long nativeRotate = nativeRotate(pix.a(), f, false, true);
        if (nativeRotate == 0) {
            return null;
        }
        return new Pix(nativeRotate);
    }

    private static native long nativeRotate(long j, float f, boolean z, boolean z2);

    private static native int nativeRotateOrth(long j, int i);
}

package com.googlecode.leptonica.android;

public class Convert {
    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    public static Pix a(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        long nativeConvertTo8 = nativeConvertTo8(pix.a());
        if (nativeConvertTo8 != 0) {
            return new Pix(nativeConvertTo8);
        }
        throw new RuntimeException("Failed to natively convert pix");
    }

    private static native long nativeConvertTo8(long j);
}

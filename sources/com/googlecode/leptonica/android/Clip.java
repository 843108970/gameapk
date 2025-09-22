package com.googlecode.leptonica.android;

public class Clip {
    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private static Pix a(Pix pix, Box box) {
        int nativeClipRectangle = nativeClipRectangle(pix.a(), box.a());
        if (nativeClipRectangle != 0) {
            return new Pix((long) nativeClipRectangle);
        }
        return null;
    }

    private static native int nativeClipRectangle(long j, long j2);
}

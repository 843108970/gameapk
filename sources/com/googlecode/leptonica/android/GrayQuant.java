package com.googlecode.leptonica.android;

public class GrayQuant {
    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private static Pix a(Pix pix, int i) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        int e = pix.e();
        if (e != 4 && e != 8) {
            throw new IllegalArgumentException("Source pix depth must be 4 or 8 bpp");
        } else if (e == 4 && i > 16) {
            throw new IllegalArgumentException("4 bpp thresh not in {0-16}");
        } else if (e != 8 || i <= 256) {
            long nativePixThresholdToBinary = nativePixThresholdToBinary(pix.a(), i);
            if (nativePixThresholdToBinary != 0) {
                return new Pix(nativePixThresholdToBinary);
            }
            throw new RuntimeException("Failed to perform binarization");
        } else {
            throw new IllegalArgumentException("8 bpp thresh not in {0-256}");
        }
    }

    private static native long nativePixThresholdToBinary(long j, int i);
}

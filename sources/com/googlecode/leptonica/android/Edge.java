package com.googlecode.leptonica.android;

public class Edge {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3370a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3371b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3372c = 2;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private static Pix a(Pix pix, int i) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (pix.e() != 8) {
            throw new IllegalArgumentException("Source pix depth must be 8bpp");
        } else if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Invalid orientation flag");
        } else {
            long nativePixSobelEdgeFilter = nativePixSobelEdgeFilter(pix.a(), i);
            if (nativePixSobelEdgeFilter != 0) {
                return new Pix(nativePixSobelEdgeFilter);
            }
            throw new RuntimeException("Failed to perform Sobel edge filter on image");
        }
    }

    private static native long nativePixSobelEdgeFilter(long j, int i);
}

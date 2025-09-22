package com.googlecode.tesseract.android;

public class TessPdfRenderer {

    /* renamed from: a  reason: collision with root package name */
    private final long f3414a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3415b = false;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
        System.loadLibrary("tess");
    }

    private TessPdfRenderer(TessBaseAPI tessBaseAPI, String str) {
        this.f3414a = nativeCreate(tessBaseAPI.f3404a, str);
    }

    private void b() {
        nativeRecycle(this.f3414a);
        this.f3415b = true;
    }

    private static native long nativeCreate(long j, String str);

    private static native void nativeRecycle(long j);

    public final long a() {
        if (!this.f3415b) {
            return this.f3414a;
        }
        throw new IllegalStateException();
    }
}

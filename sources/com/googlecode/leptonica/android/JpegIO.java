package com.googlecode.leptonica.android;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class JpegIO {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3375a = 85;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f3376b = false;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private static byte[] a(Pix pix) {
        return b(pix);
    }

    private static byte[] b(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap a2 = WriteFile.a(pix);
        a2.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
        a2.recycle();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e) {
            e.printStackTrace();
            return byteArray;
        }
    }

    private static native byte[] nativeCompressToJpeg(long j, int i, boolean z);
}

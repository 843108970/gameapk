package com.googlecode.leptonica.android;

import android.graphics.Bitmap;
import java.io.File;

public class WriteFile {
    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    private static int a(Pix pix, byte[] bArr) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        if (bArr.length >= pix.c() * pix.d()) {
            return nativeWriteBytes8(pix.a(), bArr);
        }
        throw new IllegalArgumentException("Data array must be large enough to hold image bytes");
    }

    public static Bitmap a(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (pix.e) {
            throw new IllegalStateException();
        } else {
            int[] iArr = new int[3];
            if (pix.e) {
                throw new IllegalStateException();
            }
            if (!Pix.nativeGetDimensions(pix.d, iArr)) {
                iArr = null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr[0], iArr[1], Bitmap.Config.ARGB_8888);
            if (nativeWriteBitmap(pix.a(), createBitmap)) {
                return createBitmap;
            }
            createBitmap.recycle();
            return null;
        }
    }

    private static boolean a(Pix pix, File file) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (file != null) {
            return nativeWriteImpliedFormat(pix.a(), file.getAbsolutePath());
        } else {
            throw new IllegalArgumentException("File must be non-null");
        }
    }

    private static byte[] b(Pix pix) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        }
        byte[] bArr = new byte[(pix.c() * pix.d())];
        if (pix.e() != 8) {
            Pix a2 = Convert.a(pix);
            a(a2, bArr);
            a2.b();
            return bArr;
        }
        a(pix, bArr);
        return bArr;
    }

    private static native boolean nativeWriteBitmap(long j, Bitmap bitmap);

    private static native int nativeWriteBytes8(long j, byte[] bArr);

    private static native boolean nativeWriteImpliedFormat(long j, String str);
}

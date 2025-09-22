package com.googlecode.leptonica.android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;

public class ReadFile {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3388a = "ReadFile";

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
    }

    public static Pix a(Bitmap bitmap) {
        String str;
        String str2;
        if (bitmap == null) {
            str = f3388a;
            str2 = "Bitmap must be non-null";
        } else if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            str = f3388a;
            str2 = "Bitmap config must be ARGB_8888";
        } else {
            long nativeReadBitmap = nativeReadBitmap(bitmap);
            if (nativeReadBitmap != 0) {
                return new Pix(nativeReadBitmap);
            }
            str = f3388a;
            str2 = "Failed to read pix from bitmap";
        }
        Log.e(str, str2);
        return null;
    }

    public static Pix a(File file) {
        if (file == null) {
            Log.e(f3388a, "File must be non-null");
            return null;
        } else if (!file.exists()) {
            Log.e(f3388a, "File does not exist");
            return null;
        } else if (!file.canRead()) {
            Log.e(f3388a, "Cannot read file");
            return null;
        } else {
            long nativeReadFile = nativeReadFile(file.getAbsolutePath());
            if (nativeReadFile != 0) {
                return new Pix(nativeReadFile);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            if (decodeFile == null) {
                Log.e(f3388a, "Cannot decode bitmap");
                return null;
            }
            Pix a2 = a(decodeFile);
            decodeFile.recycle();
            return a2;
        }
    }

    private static Pix a(byte[] bArr) {
        if (bArr == null) {
            Log.e(f3388a, "Image data byte array must be non-null");
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        Pix a2 = a(decodeByteArray);
        decodeByteArray.recycle();
        return a2;
    }

    private static Pix a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("Byte array must be non-null");
        } else if (i <= 0) {
            throw new IllegalArgumentException("Image width must be greater than 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("Image height must be greater than 0");
        } else if (bArr.length < i * i2) {
            throw new IllegalArgumentException("Array length does not match dimensions");
        } else {
            long nativeReadBytes8 = nativeReadBytes8(bArr, i, i2);
            if (nativeReadBytes8 != 0) {
                return new Pix(nativeReadBytes8);
            }
            throw new RuntimeException("Failed to read pix from memory");
        }
    }

    private static boolean a(Pix pix, byte[] bArr, int i, int i2) {
        if (pix == null) {
            throw new IllegalArgumentException("Source pix must be non-null");
        } else if (bArr == null) {
            throw new IllegalArgumentException("Byte array must be non-null");
        } else if (i <= 0) {
            throw new IllegalArgumentException("Image width must be greater than 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("Image height must be greater than 0");
        } else if (bArr.length < i * i2) {
            throw new IllegalArgumentException("Array length does not match dimensions");
        } else if (pix.c() != i) {
            throw new IllegalArgumentException("Source pix width does not match image width");
        } else if (pix.d() == i2) {
            return nativeReplaceBytes8(pix.a(), bArr, i, i2);
        } else {
            throw new IllegalArgumentException("Source pix height does not match image height");
        }
    }

    private static native long nativeReadBitmap(Bitmap bitmap);

    private static native long nativeReadBytes8(byte[] bArr, int i, int i2);

    private static native long nativeReadFile(String str);

    private static native long nativeReadMem(byte[] bArr, int i);

    private static native boolean nativeReplaceBytes8(long j, byte[] bArr, int i, int i2);
}

package com.lidroid.xutils.bitmap.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.lidroid.xutils.util.LogUtils;
import java.io.FileDescriptor;

public class BitmapDecoder {
    private static final Object lock = new Object();

    private BitmapDecoder() {
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        float f;
        float f2;
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i4 <= i && i3 <= i2) {
            return 1;
        }
        if (i4 > i3) {
            f = (float) i3;
            f2 = (float) i2;
        } else {
            f = (float) i4;
            f2 = (float) i;
        }
        int round = Math.round(f / f2);
        while (((float) (i4 * i3)) / ((float) (round * round)) > ((float) (i * i2 * 2))) {
            round++;
        }
        return round;
    }

    public static Bitmap decodeByteArray(byte[] bArr) {
        Bitmap decodeByteArray;
        synchronized (lock) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPurgeable = true;
            options.inInputShareable = true;
            try {
                decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            } catch (Throwable th) {
                LogUtils.e(th.getMessage(), th);
                return null;
            }
        }
        return decodeByteArray;
    }

    public static Bitmap decodeFile(String str) {
        Bitmap decodeFile;
        synchronized (lock) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPurgeable = true;
            options.inInputShareable = true;
            try {
                decodeFile = BitmapFactory.decodeFile(str, options);
            } catch (Throwable th) {
                LogUtils.e(th.getMessage(), th);
                return null;
            }
        }
        return decodeFile;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        Bitmap decodeFileDescriptor;
        synchronized (lock) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPurgeable = true;
            options.inInputShareable = true;
            try {
                decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, (Rect) null, options);
            } catch (Throwable th) {
                LogUtils.e(th.getMessage(), th);
                return null;
            }
        }
        return decodeFileDescriptor;
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        Bitmap decodeResource;
        synchronized (lock) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPurgeable = true;
            options.inInputShareable = true;
            try {
                decodeResource = BitmapFactory.decodeResource(resources, i, options);
            } catch (Throwable th) {
                LogUtils.e(th.getMessage(), th);
                return null;
            }
        }
        return decodeResource;
    }

    public static Bitmap decodeSampledBitmapFromByteArray(byte[] bArr, BitmapSize bitmapSize, Bitmap.Config config) {
        Bitmap decodeByteArray;
        synchronized (lock) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inPurgeable = true;
            options.inInputShareable = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = calculateInSampleSize(options, bitmapSize.getWidth(), bitmapSize.getHeight());
            options.inJustDecodeBounds = false;
            if (config != null) {
                options.inPreferredConfig = config;
            }
            try {
                decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            } catch (Throwable th) {
                LogUtils.e(th.getMessage(), th);
                return null;
            }
        }
        return decodeByteArray;
    }

    public static Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor fileDescriptor, BitmapSize bitmapSize, Bitmap.Config config) {
        Bitmap decodeFileDescriptor;
        synchronized (lock) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inPurgeable = true;
            options.inInputShareable = true;
            BitmapFactory.decodeFileDescriptor(fileDescriptor, (Rect) null, options);
            options.inSampleSize = calculateInSampleSize(options, bitmapSize.getWidth(), bitmapSize.getHeight());
            options.inJustDecodeBounds = false;
            if (config != null) {
                options.inPreferredConfig = config;
            }
            try {
                decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, (Rect) null, options);
            } catch (Throwable th) {
                LogUtils.e(th.getMessage(), th);
                return null;
            }
        }
        return decodeFileDescriptor;
    }

    public static Bitmap decodeSampledBitmapFromFile(String str, BitmapSize bitmapSize, Bitmap.Config config) {
        Bitmap decodeFile;
        synchronized (lock) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inPurgeable = true;
            options.inInputShareable = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = calculateInSampleSize(options, bitmapSize.getWidth(), bitmapSize.getHeight());
            options.inJustDecodeBounds = false;
            if (config != null) {
                options.inPreferredConfig = config;
            }
            try {
                decodeFile = BitmapFactory.decodeFile(str, options);
            } catch (Throwable th) {
                LogUtils.e(th.getMessage(), th);
                return null;
            }
        }
        return decodeFile;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i, BitmapSize bitmapSize, Bitmap.Config config) {
        Bitmap decodeResource;
        synchronized (lock) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inPurgeable = true;
            options.inInputShareable = true;
            BitmapFactory.decodeResource(resources, i, options);
            options.inSampleSize = calculateInSampleSize(options, bitmapSize.getWidth(), bitmapSize.getHeight());
            options.inJustDecodeBounds = false;
            if (config != null) {
                options.inPreferredConfig = config;
            }
            try {
                decodeResource = BitmapFactory.decodeResource(resources, i, options);
            } catch (Throwable th) {
                LogUtils.e(th.getMessage(), th);
                return null;
            }
        }
        return decodeResource;
    }
}

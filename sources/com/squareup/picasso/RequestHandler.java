package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

public abstract class RequestHandler {

    public static final class Result {
        private final Bitmap bitmap;
        private final int exifOrientation;
        private final Picasso.LoadedFrom loadedFrom;
        private final InputStream stream;

        public Result(Bitmap bitmap2, Picasso.LoadedFrom loadedFrom2) {
            this((Bitmap) Utils.checkNotNull(bitmap2, "bitmap == null"), (InputStream) null, loadedFrom2, 0);
        }

        Result(Bitmap bitmap2, InputStream inputStream, Picasso.LoadedFrom loadedFrom2, int i) {
            boolean z = false;
            if (!((inputStream != null ? true : z) ^ (bitmap2 != null))) {
                throw new AssertionError();
            }
            this.bitmap = bitmap2;
            this.stream = inputStream;
            this.loadedFrom = (Picasso.LoadedFrom) Utils.checkNotNull(loadedFrom2, "loadedFrom == null");
            this.exifOrientation = i;
        }

        public Result(InputStream inputStream, Picasso.LoadedFrom loadedFrom2) {
            this((Bitmap) null, (InputStream) Utils.checkNotNull(inputStream, "stream == null"), loadedFrom2, 0);
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        /* access modifiers changed from: package-private */
        public final int getExifOrientation() {
            return this.exifOrientation;
        }

        public final Picasso.LoadedFrom getLoadedFrom() {
            return this.loadedFrom;
        }

        public final InputStream getStream() {
            return this.stream;
        }
    }

    static void calculateInSampleSize(int i, int i2, int i3, int i4, BitmapFactory.Options options, Request request) {
        int i5;
        double d;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                d = (double) (((float) i3) / ((float) i));
            } else if (i == 0) {
                d = (double) (((float) i4) / ((float) i2));
            } else {
                int floor = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                int floor2 = (int) Math.floor((double) (((float) i3) / ((float) i)));
                i5 = request.centerInside ? Math.max(floor, floor2) : Math.min(floor, floor2);
            }
            i5 = (int) Math.floor(d);
        } else {
            i5 = 1;
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }

    static void calculateInSampleSize(int i, int i2, BitmapFactory.Options options, Request request) {
        calculateInSampleSize(i, i2, options.outWidth, options.outHeight, options, request);
    }

    static BitmapFactory.Options createBitmapOptions(Request request) {
        boolean hasSize = request.hasSize();
        boolean z = request.config != null;
        BitmapFactory.Options options = null;
        if (hasSize || z) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = hasSize;
            if (z) {
                options.inPreferredConfig = request.config;
            }
        }
        return options;
    }

    static boolean requiresInSampleSize(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    public abstract boolean canHandleRequest(Request request);

    /* access modifiers changed from: package-private */
    public int getRetryCount() {
        return 0;
    }

    public abstract Result load(Request request, int i) throws IOException;

    /* access modifiers changed from: package-private */
    public boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsReplay() {
        return false;
    }
}

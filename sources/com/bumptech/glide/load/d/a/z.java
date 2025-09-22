package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.util.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1336a = 6;

    /* renamed from: b  reason: collision with root package name */
    private static final String f1337b = "TransformationUtils";

    /* renamed from: c  reason: collision with root package name */
    private static final Paint f1338c = new Paint(6);
    private static final int d = 7;
    private static final Paint e = new Paint(7);
    private static final Paint f;
    private static final Set<String> g;
    private static final Lock h;

    private static final class a implements Lock {
        a() {
        }

        public final void lock() {
        }

        public final void lockInterruptibly() throws InterruptedException {
        }

        @NonNull
        public final Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        public final boolean tryLock() {
            return true;
        }

        public final boolean tryLock(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public final void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        g = hashSet;
        h = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new a();
        Paint paint = new Paint(7);
        f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private z() {
    }

    public static int a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @NonNull
    private static Bitmap.Config a(@NonNull Bitmap bitmap) {
        return (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16;
    }

    private static Bitmap a(@NonNull Bitmap bitmap, int i) {
        if (i != 0) {
            try {
                Matrix matrix = new Matrix();
                matrix.setRotate((float) i);
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e2) {
                if (Log.isLoggable(f1337b, 6)) {
                    Log.e(f1337b, "Exception when trying to orient image", e2);
                }
            }
        }
        return bitmap;
    }

    private static Bitmap a(@NonNull e eVar, @NonNull Bitmap bitmap) {
        Bitmap.Config a2 = a(bitmap);
        if (a2.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap a3 = eVar.a(bitmap.getWidth(), bitmap.getHeight(), a2);
        new Canvas(a3).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return a3;
    }

    public static Bitmap a(@NonNull e eVar, @NonNull Bitmap bitmap, int i) {
        if (!b(i)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
        matrix.postScale(-1.0f, 1.0f);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap a2 = eVar.a(Math.round(rectF.width()), Math.round(rectF.height()), b(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        a(bitmap, a2, matrix);
        return a2;
    }

    public static Bitmap a(@NonNull e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        float f2;
        float f3;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f4 = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            f3 = ((float) i2) / ((float) bitmap.getHeight());
            f2 = (((float) i) - (((float) bitmap.getWidth()) * f3)) * 0.5f;
        } else {
            f3 = ((float) i) / ((float) bitmap.getWidth());
            f4 = (((float) i2) - (((float) bitmap.getHeight()) * f3)) * 0.5f;
            f2 = 0.0f;
        }
        matrix.setScale(f3, f3);
        matrix.postTranslate((float) ((int) (f2 + 0.5f)), (float) ((int) (f4 + 0.5f)));
        Bitmap a2 = eVar.a(i, i2, b(bitmap));
        a(bitmap, a2);
        a(bitmap, a2, matrix);
        return a2;
    }

    public static Lock a() {
        return h;
    }

    @VisibleForTesting
    private static void a(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
        matrix.postScale(-1.0f, 1.0f);
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    private static void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        h.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f1338c);
            canvas.setBitmap((Bitmap) null);
        } finally {
            h.unlock();
        }
    }

    private static void a(Canvas canvas) {
        canvas.setBitmap((Bitmap) null);
    }

    @NonNull
    private static Bitmap.Config b(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    /* JADX INFO: finally extract failed */
    public static Bitmap b(@NonNull e eVar, @NonNull Bitmap bitmap, int i) {
        i.a(i > 0, "roundingRadius must be greater than 0.");
        Bitmap.Config a2 = a(bitmap);
        Bitmap a3 = a(eVar, bitmap);
        Bitmap a4 = eVar.a(a3.getWidth(), a3.getHeight(), a2);
        a4.setHasAlpha(true);
        BitmapShader bitmapShader = new BitmapShader(a3, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, (float) a4.getWidth(), (float) a4.getHeight());
        h.lock();
        try {
            Canvas canvas = new Canvas(a4);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            float f2 = (float) i;
            canvas.drawRoundRect(rectF, f2, f2, paint);
            canvas.setBitmap((Bitmap) null);
            h.unlock();
            if (!a3.equals(bitmap)) {
                eVar.a(a3);
            }
            return a4;
        } catch (Throwable th) {
            h.unlock();
            throw th;
        }
    }

    public static Bitmap b(@NonNull e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable(f1337b, 2)) {
                Log.v(f1337b, "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable(f1337b, 2)) {
                Log.v(f1337b, "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap a2 = eVar.a((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), b(bitmap));
        a(bitmap, a2);
        if (Log.isLoggable(f1337b, 2)) {
            Log.v(f1337b, "request: " + i + "x" + i2);
            Log.v(f1337b, "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v(f1337b, "toReuse: " + a2.getWidth() + "x" + a2.getHeight());
            StringBuilder sb = new StringBuilder("minPct:   ");
            sb.append(min);
            Log.v(f1337b, sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, a2, matrix);
        return a2;
    }

    public static boolean b(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    private static Bitmap c(@NonNull e eVar, @NonNull Bitmap bitmap, int i) {
        return b(eVar, bitmap, i);
    }

    public static Bitmap c(@NonNull e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            if (Log.isLoggable(f1337b, 2)) {
                Log.v(f1337b, "requested target size too big for input, fit centering instead");
            }
            return b(eVar, bitmap, i, i2);
        }
        if (Log.isLoggable(f1337b, 2)) {
            Log.v(f1337b, "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    /* JADX INFO: finally extract failed */
    public static Bitmap d(@NonNull e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        int min = Math.min(i, i2);
        float f2 = (float) min;
        float f3 = f2 / 2.0f;
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float max = Math.max(f2 / width, f2 / height);
        float f4 = width * max;
        float f5 = max * height;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f2 - f5) / 2.0f;
        RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
        Bitmap a2 = a(eVar, bitmap);
        Bitmap a3 = eVar.a(min, min, a(bitmap));
        a3.setHasAlpha(true);
        h.lock();
        try {
            Canvas canvas = new Canvas(a3);
            canvas.drawCircle(f3, f3, f3, e);
            canvas.drawBitmap(a2, (Rect) null, rectF, f);
            canvas.setBitmap((Bitmap) null);
            h.unlock();
            if (!a2.equals(bitmap)) {
                eVar.a(a2);
            }
            return a3;
        } catch (Throwable th) {
            h.unlock();
            throw th;
        }
    }
}

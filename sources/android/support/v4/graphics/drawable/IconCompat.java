package android.support.v4.graphics.drawable;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;

public class IconCompat {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final int TYPE_ADAPTIVE_BITMAP = 5;
    private static final int TYPE_BITMAP = 1;
    private static final int TYPE_DATA = 3;
    private static final int TYPE_RESOURCE = 2;
    private static final int TYPE_URI = 4;
    private int mInt1;
    private int mInt2;
    private Object mObj1;
    private final int mType;

    private IconCompat(int i) {
        this.mType = i;
    }

    @VisibleForTesting
    static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap bitmap, boolean z) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * DEFAULT_VIEW_PORT_SCALE);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = (float) min;
        float f2 = 0.5f * f;
        float f3 = ICON_DIAMETER_FACTOR * f2;
        if (z) {
            float f4 = BLUR_FACTOR * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * KEY_SHADOW_OFFSET_FACTOR, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("Bitmap must not be null.");
        }
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.mObj1 = bitmap;
        return iconCompat;
    }

    public static IconCompat createWithBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("Bitmap must not be null.");
        }
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.mObj1 = bitmap;
        return iconCompat;
    }

    public static IconCompat createWithContentUri(Uri uri) {
        if (uri != null) {
            return createWithContentUri(uri.toString());
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat createWithContentUri(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Uri must not be null.");
        }
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.mObj1 = str;
        return iconCompat;
    }

    public static IconCompat createWithData(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("Data must not be null.");
        }
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.mObj1 = bArr;
        iconCompat.mInt1 = i;
        iconCompat.mInt2 = i2;
        return iconCompat;
    }

    public static IconCompat createWithResource(Context context, @DrawableRes int i) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.mInt1 = i;
        iconCompat.mObj1 = context;
        return iconCompat;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public void addToShortcutIntent(@NonNull Intent intent) {
        addToShortcutIntent(intent, (Drawable) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0089  */
    @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToShortcutIntent(@android.support.annotation.NonNull android.content.Intent r6, @android.support.annotation.Nullable android.graphics.drawable.Drawable r7) {
        /*
            r5 = this;
            int r0 = r5.mType
            r1 = 5
            r2 = 1
            if (r0 == r1) goto L_0x007f
            switch(r0) {
                case 1: goto L_0x0070;
                case 2: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Icon type not supported for intent shortcuts"
            r6.<init>(r7)
            throw r6
        L_0x0011:
            if (r7 != 0) goto L_0x0023
            java.lang.String r7 = "android.intent.extra.shortcut.ICON_RESOURCE"
            java.lang.Object r0 = r5.mObj1
            android.content.Context r0 = (android.content.Context) r0
            int r1 = r5.mInt1
            android.content.Intent$ShortcutIconResource r0 = android.content.Intent.ShortcutIconResource.fromContext(r0, r1)
        L_0x001f:
            r6.putExtra(r7, r0)
            return
        L_0x0023:
            java.lang.Object r0 = r5.mObj1
            android.content.Context r0 = (android.content.Context) r0
            int r1 = r5.mInt1
            android.graphics.drawable.Drawable r1 = android.support.v4.content.ContextCompat.getDrawable(r0, r1)
            int r2 = r1.getIntrinsicWidth()
            if (r2 <= 0) goto L_0x0049
            int r2 = r1.getIntrinsicHeight()
            if (r2 > 0) goto L_0x003a
            goto L_0x0049
        L_0x003a:
            int r0 = r1.getIntrinsicWidth()
            int r2 = r1.getIntrinsicHeight()
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r2, r3)
            goto L_0x005b
        L_0x0049:
            java.lang.String r2 = "activity"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0
            int r0 = r0.getLauncherLargeIconSize()
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r0, r2)
        L_0x005b:
            int r2 = r0.getWidth()
            int r3 = r0.getHeight()
            r4 = 0
            r1.setBounds(r4, r4, r2, r3)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r0)
            r1.draw(r2)
            goto L_0x0087
        L_0x0070:
            java.lang.Object r0 = r5.mObj1
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r7 == 0) goto L_0x0087
            android.graphics.Bitmap$Config r1 = r0.getConfig()
            android.graphics.Bitmap r0 = r0.copy(r1, r2)
            goto L_0x0087
        L_0x007f:
            java.lang.Object r0 = r5.mObj1
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            android.graphics.Bitmap r0 = createLegacyIconFromAdaptiveIcon(r0, r2)
        L_0x0087:
            if (r7 == 0) goto L_0x00a0
            int r1 = r0.getWidth()
            int r2 = r0.getHeight()
            int r3 = r1 / 2
            int r4 = r2 / 2
            r7.setBounds(r3, r4, r1, r2)
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r0)
            r7.draw(r1)
        L_0x00a0:
            java.lang.String r7 = "android.intent.extra.shortcut.ICON"
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.IconCompat.addToShortcutIntent(android.content.Intent, android.graphics.drawable.Drawable):void");
    }

    @RequiresApi(23)
    public Icon toIcon() {
        switch (this.mType) {
            case 1:
                return Icon.createWithBitmap((Bitmap) this.mObj1);
            case 2:
                return Icon.createWithResource((Context) this.mObj1, this.mInt1);
            case 3:
                return Icon.createWithData((byte[]) this.mObj1, this.mInt1, this.mInt2);
            case 4:
                return Icon.createWithContentUri((String) this.mObj1);
            case 5:
                return Build.VERSION.SDK_INT >= 26 ? Icon.createWithAdaptiveBitmap((Bitmap) this.mObj1) : Icon.createWithBitmap(createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
            default:
                throw new IllegalArgumentException("Unknown type");
        }
    }
}

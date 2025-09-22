package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

final class PicassoDrawable extends BitmapDrawable {
    private static final Paint DEBUG_PAINT = new Paint();
    private static final float FADE_DURATION = 200.0f;
    int alpha = 255;
    boolean animating;
    private final boolean debugging;
    private final float density;
    private final Picasso.LoadedFrom loadedFrom;
    Drawable placeholder;
    long startTimeMillis;

    PicassoDrawable(Context context, Bitmap bitmap, Drawable drawable, Picasso.LoadedFrom loadedFrom2, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.debugging = z2;
        this.density = context.getResources().getDisplayMetrics().density;
        this.loadedFrom = loadedFrom2;
        if (loadedFrom2 != Picasso.LoadedFrom.MEMORY && !z) {
            this.placeholder = drawable;
            this.animating = true;
            this.startTimeMillis = SystemClock.uptimeMillis();
        }
    }

    private void drawDebugIndicator(Canvas canvas) {
        DEBUG_PAINT.setColor(-1);
        canvas.drawPath(getTrianglePath(new Point(0, 0), (int) (this.density * 16.0f)), DEBUG_PAINT);
        DEBUG_PAINT.setColor(this.loadedFrom.debugColor);
        canvas.drawPath(getTrianglePath(new Point(0, 0), (int) (this.density * 15.0f)), DEBUG_PAINT);
    }

    private static Path getTrianglePath(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo((float) point.x, (float) point.y);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        return path;
    }

    static void setBitmap(ImageView imageView, Context context, Bitmap bitmap, Picasso.LoadedFrom loadedFrom2, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new PicassoDrawable(context, bitmap, drawable, loadedFrom2, z, z2));
    }

    static void setPlaceholder(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r7) {
        /*
            r6 = this;
            boolean r0 = r6.animating
            if (r0 != 0) goto L_0x0008
        L_0x0004:
            super.draw(r7)
            goto L_0x0044
        L_0x0008:
            long r0 = android.os.SystemClock.uptimeMillis()
            long r2 = r6.startTimeMillis
            long r4 = r0 - r2
            float r0 = (float) r4
            r1 = 1128792064(0x43480000, float:200.0)
            float r0 = r0 / r1
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x0021
            r0 = 0
            r6.animating = r0
            r0 = 0
            r6.placeholder = r0
            goto L_0x0004
        L_0x0021:
            android.graphics.drawable.Drawable r1 = r6.placeholder
            if (r1 == 0) goto L_0x002a
            android.graphics.drawable.Drawable r1 = r6.placeholder
            r1.draw(r7)
        L_0x002a:
            int r1 = r6.alpha
            float r1 = (float) r1
            float r1 = r1 * r0
            int r0 = (int) r1
            super.setAlpha(r0)
            super.draw(r7)
            int r0 = r6.alpha
            super.setAlpha(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 10
            if (r0 > r1) goto L_0x0044
            r6.invalidateSelf()
        L_0x0044:
            boolean r0 = r6.debugging
            if (r0 == 0) goto L_0x004b
            r6.drawDebugIndicator(r7)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.PicassoDrawable.draw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        if (this.placeholder != null) {
            this.placeholder.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public final void setAlpha(int i) {
        this.alpha = i;
        if (this.placeholder != null) {
            this.placeholder.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.placeholder != null) {
            this.placeholder.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}

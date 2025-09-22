package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.a.f;
import com.bumptech.glide.load.b.u;
import java.util.concurrent.locks.Lock;

final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1317a = "DrawableToBitmap";

    /* renamed from: b  reason: collision with root package name */
    private static final e f1318b = new f() {
        public final void a(Bitmap bitmap) {
        }
    };

    private p() {
    }

    @Nullable
    static u<Bitmap> a(e eVar, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = b(eVar, current, i, i2);
            z = true;
        } else {
            bitmap = null;
        }
        if (!z) {
            eVar = f1318b;
        }
        return f.a(bitmap, eVar);
    }

    @Nullable
    private static Bitmap b(e eVar, Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(f1317a, 5)) {
                Log.w(f1317a, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i2 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i2 = drawable.getIntrinsicHeight();
            }
            Lock a2 = z.a();
            a2.lock();
            Bitmap a3 = eVar.a(i, i2, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(a3);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                canvas.setBitmap((Bitmap) null);
                return a3;
            } finally {
                a2.unlock();
            }
        } else {
            if (Log.isLoggable(f1317a, 5)) {
                Log.w(f1317a, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
    }
}

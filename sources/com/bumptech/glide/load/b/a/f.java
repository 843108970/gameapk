package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

public class f implements e {
    public final long a() {
        return 0;
    }

    @NonNull
    public final Bitmap a(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    public final void a(float f) {
    }

    public final void a(int i) {
    }

    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @NonNull
    public final Bitmap b(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    public final void b() {
    }
}

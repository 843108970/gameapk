package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;

interface l {
    @Nullable
    Bitmap a();

    @Nullable
    Bitmap a(int i, int i2, Bitmap.Config config);

    void a(Bitmap bitmap);

    String b(int i, int i2, Bitmap.Config config);

    String b(Bitmap bitmap);

    int c(Bitmap bitmap);
}

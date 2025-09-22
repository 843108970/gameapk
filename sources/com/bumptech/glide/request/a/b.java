package com.bumptech.glide.request.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

public final class b extends a<Bitmap> {
    public b(@NonNull g<Drawable> gVar) {
        super(gVar);
    }

    @NonNull
    private static Bitmap a(@NonNull Bitmap bitmap) {
        return bitmap;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final /* bridge */ /* synthetic */ Bitmap a(@NonNull Object obj) {
        return (Bitmap) obj;
    }
}

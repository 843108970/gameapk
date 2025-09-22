package com.bumptech.glide.load.d.c;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.u;

final class d extends b<Drawable> {
    private d(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    static u<Drawable> a(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new d(drawable);
        }
        return null;
    }

    @NonNull
    public final Class<Drawable> a() {
        return this.f1343a.getClass();
    }

    public final int c() {
        return Math.max(1, this.f1343a.getIntrinsicWidth() * this.f1343a.getIntrinsicHeight() * 4);
    }

    public final void d() {
    }
}

package com.bumptech.glide.load.d.c;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import java.io.IOException;

public final class f implements k<Drawable, Drawable> {
    @Nullable
    private static u<Drawable> a(@NonNull Drawable drawable) {
        return d.a(drawable);
    }

    private static boolean a() {
        return true;
    }

    @Nullable
    public final /* bridge */ /* synthetic */ u a(@NonNull Object obj, int i, int i2, @NonNull j jVar) throws IOException {
        return d.a((Drawable) obj);
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj, @NonNull j jVar) throws IOException {
        return true;
    }
}

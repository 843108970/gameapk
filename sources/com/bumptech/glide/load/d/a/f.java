package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.q;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.k;

public final class f implements q, u<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f1300a;

    /* renamed from: b  reason: collision with root package name */
    private final e f1301b;

    public f(@NonNull Bitmap bitmap, @NonNull e eVar) {
        this.f1300a = (Bitmap) i.a(bitmap, "Bitmap must not be null");
        this.f1301b = (e) i.a(eVar, "BitmapPool must not be null");
    }

    @Nullable
    public static f a(@Nullable Bitmap bitmap, @NonNull e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new f(bitmap, eVar);
    }

    @NonNull
    private Bitmap f() {
        return this.f1300a;
    }

    @NonNull
    public final Class<Bitmap> a() {
        return Bitmap.class;
    }

    @NonNull
    public final /* bridge */ /* synthetic */ Object b() {
        return this.f1300a;
    }

    public final int c() {
        return k.a(this.f1300a);
    }

    public final void d() {
        this.f1301b.a(this.f1300a);
    }

    public final void e() {
        this.f1300a.prepareToDraw();
    }
}

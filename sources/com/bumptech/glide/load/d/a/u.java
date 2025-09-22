package com.bumptech.glide.load.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.f;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.q;
import com.bumptech.glide.util.i;

public final class u implements q, com.bumptech.glide.load.b.u<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1324a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.b.u<Bitmap> f1325b;

    private u(@NonNull Resources resources, @NonNull com.bumptech.glide.load.b.u<Bitmap> uVar) {
        this.f1324a = (Resources) i.a(resources, "Argument must not be null");
        this.f1325b = (com.bumptech.glide.load.b.u) i.a(uVar, "Argument must not be null");
    }

    @Nullable
    public static com.bumptech.glide.load.b.u<BitmapDrawable> a(@NonNull Resources resources, @Nullable com.bumptech.glide.load.b.u<Bitmap> uVar) {
        if (uVar == null) {
            return null;
        }
        return new u(resources, uVar);
    }

    @Deprecated
    private static u a(Context context, Bitmap bitmap) {
        return (u) a(context.getResources(), (com.bumptech.glide.load.b.u<Bitmap>) f.a(bitmap, f.b(context).f948a));
    }

    @Deprecated
    private static u a(Resources resources, e eVar, Bitmap bitmap) {
        return (u) a(resources, (com.bumptech.glide.load.b.u<Bitmap>) f.a(bitmap, eVar));
    }

    @NonNull
    private BitmapDrawable f() {
        return new BitmapDrawable(this.f1324a, this.f1325b.b());
    }

    @NonNull
    public final Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    @NonNull
    public final /* synthetic */ Object b() {
        return new BitmapDrawable(this.f1324a, this.f1325b.b());
    }

    public final int c() {
        return this.f1325b.c();
    }

    public final void d() {
        this.f1325b.d();
    }

    public final void e() {
        if (this.f1325b instanceof q) {
            ((q) this.f1325b).e();
        }
    }
}

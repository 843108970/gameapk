package com.bumptech.glide.load.d.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.d.a.f;
import com.bumptech.glide.load.j;

public final class c implements e<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final e f1377a;

    /* renamed from: b  reason: collision with root package name */
    private final e<Bitmap, byte[]> f1378b;

    /* renamed from: c  reason: collision with root package name */
    private final e<com.bumptech.glide.load.d.e.c, byte[]> f1379c;

    public c(@NonNull e eVar, @NonNull e<Bitmap, byte[]> eVar2, @NonNull e<com.bumptech.glide.load.d.e.c, byte[]> eVar3) {
        this.f1377a = eVar;
        this.f1378b = eVar2;
        this.f1379c = eVar3;
    }

    @NonNull
    private static u<com.bumptech.glide.load.d.e.c> a(@NonNull u<Drawable> uVar) {
        return uVar;
    }

    @Nullable
    public final u<byte[]> a(@NonNull u<Drawable> uVar, @NonNull j jVar) {
        Drawable b2 = uVar.b();
        if (b2 instanceof BitmapDrawable) {
            return this.f1378b.a(f.a(((BitmapDrawable) b2).getBitmap(), this.f1377a), jVar);
        }
        if (b2 instanceof com.bumptech.glide.load.d.e.c) {
            return this.f1379c.a(uVar, jVar);
        }
        return null;
    }
}

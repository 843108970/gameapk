package com.bumptech.glide.load.d.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.j;
import com.bumptech.glide.util.i;

public final class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1376a;

    private b(@NonNull Context context) {
        this(context.getResources(), (byte) 0);
    }

    @Deprecated
    private b(@NonNull Resources resources) {
        this(resources, (byte) 0);
    }

    public b(@NonNull Resources resources, byte b2) {
        this.f1376a = (Resources) i.a(resources, "Argument must not be null");
    }

    @Nullable
    public final u<BitmapDrawable> a(@NonNull u<Bitmap> uVar, @NonNull j jVar) {
        return com.bumptech.glide.load.d.a.u.a(this.f1376a, uVar);
    }
}

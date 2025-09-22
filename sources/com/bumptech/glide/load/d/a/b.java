package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.l;
import java.io.File;

public final class b implements l<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final e f1293a;

    /* renamed from: b  reason: collision with root package name */
    private final l<Bitmap> f1294b;

    public b(e eVar, l<Bitmap> lVar) {
        this.f1293a = eVar;
        this.f1294b = lVar;
    }

    private boolean a(@NonNull u<BitmapDrawable> uVar, @NonNull File file, @NonNull j jVar) {
        return this.f1294b.a(new f(uVar.b().getBitmap(), this.f1293a), file, jVar);
    }

    @NonNull
    public final c a(@NonNull j jVar) {
        return this.f1294b.a(jVar);
    }

    public final /* synthetic */ boolean a(@NonNull Object obj, @NonNull File file, @NonNull j jVar) {
        return this.f1294b.a(new f(((BitmapDrawable) ((u) obj).b()).getBitmap(), this.f1293a), file, jVar);
    }
}

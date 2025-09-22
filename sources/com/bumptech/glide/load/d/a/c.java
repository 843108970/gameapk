package com.bumptech.glide.load.d.a;

import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.q;
import com.bumptech.glide.load.d.c.b;
import com.bumptech.glide.util.k;

public final class c extends b<BitmapDrawable> implements q {

    /* renamed from: b  reason: collision with root package name */
    private final e f1295b;

    private c(BitmapDrawable bitmapDrawable, e eVar) {
        super(bitmapDrawable);
        this.f1295b = eVar;
    }

    @NonNull
    public final Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    public final int c() {
        return k.a(((BitmapDrawable) this.f1343a).getBitmap());
    }

    public final void d() {
        this.f1295b.a(((BitmapDrawable) this.f1343a).getBitmap());
    }

    public final void e() {
        ((BitmapDrawable) this.f1343a).getBitmap().prepareToDraw();
    }
}

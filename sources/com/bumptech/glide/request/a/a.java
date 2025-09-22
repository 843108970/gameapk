package com.bumptech.glide.request.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.a.f;

public abstract class a<R> implements g<R> {

    /* renamed from: a  reason: collision with root package name */
    private final g<Drawable> f1438a;

    /* renamed from: com.bumptech.glide.request.a.a$a  reason: collision with other inner class name */
    private final class C0021a implements f<R> {

        /* renamed from: b  reason: collision with root package name */
        private final f<Drawable> f1440b;

        C0021a(f<Drawable> fVar) {
            this.f1440b = fVar;
        }

        public final boolean a(R r, f.a aVar) {
            return this.f1440b.a(new BitmapDrawable(aVar.getView().getResources(), a.this.a(r)), aVar);
        }
    }

    public a(g<Drawable> gVar) {
        this.f1438a = gVar;
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap a(R r);

    public final f<R> a(com.bumptech.glide.load.a aVar, boolean z) {
        return new C0021a(this.f1438a.a(aVar, z));
    }
}

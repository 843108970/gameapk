package com.bumptech.glide.request.a;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.request.a.k;

public final class h<R> implements g<R> {

    /* renamed from: a  reason: collision with root package name */
    private final k.a f1451a;

    /* renamed from: b  reason: collision with root package name */
    private f<R> f1452b;

    private static class a implements k.a {

        /* renamed from: a  reason: collision with root package name */
        private final Animation f1453a;

        a(Animation animation) {
            this.f1453a = animation;
        }

        public final Animation a(Context context) {
            return this.f1453a;
        }
    }

    private static class b implements k.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f1454a;

        b(int i) {
            this.f1454a = i;
        }

        public final Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f1454a);
        }
    }

    public h(int i) {
        this((k.a) new b(i));
    }

    private h(Animation animation) {
        this((k.a) new a(animation));
    }

    private h(k.a aVar) {
        this.f1451a = aVar;
    }

    public final f<R> a(com.bumptech.glide.load.a aVar, boolean z) {
        if (aVar == com.bumptech.glide.load.a.MEMORY_CACHE || !z) {
            return e.b();
        }
        if (this.f1452b == null) {
            this.f1452b = new k(this.f1451a);
        }
        return this.f1452b;
    }
}

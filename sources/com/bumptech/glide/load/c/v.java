package com.bumptech.glide.load.c;

import android.support.annotation.NonNull;
import com.bumptech.glide.l;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.j;

public final class v<Model> implements n<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final v<?> f1274a = new v<>();

    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final a<?> f1275a = new a<>();

        public static <T> a<T> b() {
            return f1275a;
        }

        @NonNull
        public final n<Model, Model> a(r rVar) {
            return v.a();
        }

        public final void a() {
        }
    }

    private static class b<Model> implements d<Model> {

        /* renamed from: a  reason: collision with root package name */
        private final Model f1276a;

        b(Model model) {
            this.f1276a = model;
        }

        @NonNull
        public final Class<Model> a() {
            return this.f1276a.getClass();
        }

        public final void a(@NonNull l lVar, @NonNull d.a<? super Model> aVar) {
            aVar.a(this.f1276a);
        }

        public final void b() {
        }

        public final void c() {
        }

        @NonNull
        public final com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static <T> v<T> a() {
        return f1274a;
    }

    public final n.a<Model> a(@NonNull Model model, int i, int i2, @NonNull j jVar) {
        return new n.a<>(new com.bumptech.glide.f.d(model), new b(model));
    }

    public final boolean a(@NonNull Model model) {
        return true;
    }
}

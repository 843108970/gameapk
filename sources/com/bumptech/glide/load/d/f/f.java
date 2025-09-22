package com.bumptech.glide.load.d.f;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?, ?>> f1380a = new ArrayList();

    private static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        final e<Z, R> f1381a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<Z> f1382b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<R> f1383c;

        a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.f1382b = cls;
            this.f1383c = cls2;
            this.f1381a = eVar;
        }

        public final boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f1382b.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f1383c);
        }
    }

    @NonNull
    public final synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.a();
        }
        for (a next : this.f1380a) {
            if (next.a(cls, cls2)) {
                return next.f1381a;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public final synchronized <Z, R> void a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        this.f1380a.add(new a(cls, cls2, eVar));
    }

    @NonNull
    public final synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> a2 : this.f1380a) {
            if (a2.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }
}

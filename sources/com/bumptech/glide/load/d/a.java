package com.bumptech.glide.load.d;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.util.i;

public class a<T> implements u<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f1284a;

    public a(@NonNull T t) {
        this.f1284a = i.a(t, "Argument must not be null");
    }

    @NonNull
    public final Class<T> a() {
        return this.f1284a.getClass();
    }

    @NonNull
    public final T b() {
        return this.f1284a;
    }

    public final int c() {
        return 1;
    }

    public final void d() {
    }
}

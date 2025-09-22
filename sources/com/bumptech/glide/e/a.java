package com.bumptech.glide.e;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.d;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C0010a<?>> f931a = new ArrayList();

    /* renamed from: com.bumptech.glide.e.a$a  reason: collision with other inner class name */
    private static final class C0010a<T> {

        /* renamed from: a  reason: collision with root package name */
        final Class<T> f932a;

        /* renamed from: b  reason: collision with root package name */
        final d<T> f933b;

        C0010a(@NonNull Class<T> cls, @NonNull d<T> dVar) {
            this.f932a = cls;
            this.f933b = dVar;
        }

        private boolean a(@NonNull Class<?> cls) {
            return this.f932a.isAssignableFrom(cls);
        }
    }

    @Nullable
    public final synchronized <T> d<T> a(@NonNull Class<T> cls) {
        for (C0010a next : this.f931a) {
            if (next.f932a.isAssignableFrom(cls)) {
                return next.f933b;
            }
        }
        return null;
    }

    public final synchronized <T> void a(@NonNull Class<T> cls, @NonNull d<T> dVar) {
        this.f931a.add(new C0010a(cls, dVar));
    }

    public final synchronized <T> void b(@NonNull Class<T> cls, @NonNull d<T> dVar) {
        this.f931a.add(0, new C0010a(cls, dVar));
    }
}

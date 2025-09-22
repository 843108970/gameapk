package com.bumptech.glide.e;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.l;
import java.util.ArrayList;
import java.util.List;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f945a = new ArrayList();

    private static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        final Class<T> f946a;

        /* renamed from: b  reason: collision with root package name */
        final l<T> f947b;

        a(@NonNull Class<T> cls, @NonNull l<T> lVar) {
            this.f946a = cls;
            this.f947b = lVar;
        }

        private boolean a(@NonNull Class<?> cls) {
            return this.f946a.isAssignableFrom(cls);
        }
    }

    @Nullable
    public final synchronized <Z> l<Z> a(@NonNull Class<Z> cls) {
        int size = this.f945a.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f945a.get(i);
            if (aVar.f946a.isAssignableFrom(cls)) {
                return aVar.f947b;
            }
        }
        return null;
    }

    public final synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull l<Z> lVar) {
        this.f945a.add(new a(cls, lVar));
    }

    public final synchronized <Z> void b(@NonNull Class<Z> cls, @NonNull l<Z> lVar) {
        this.f945a.add(0, new a(cls, lVar));
    }
}

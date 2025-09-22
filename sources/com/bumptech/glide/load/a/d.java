package com.bumptech.glide.load.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.l;

public interface d<T> {

    public interface a<T> {
        void a(@NonNull Exception exc);

        void a(@Nullable T t);
    }

    @NonNull
    Class<T> a();

    void a(@NonNull l lVar, @NonNull a<? super T> aVar);

    void b();

    void c();

    @NonNull
    com.bumptech.glide.load.a d();
}

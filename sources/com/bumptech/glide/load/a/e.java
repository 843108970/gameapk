package com.bumptech.glide.load.a;

import android.support.annotation.NonNull;
import java.io.IOException;

public interface e<T> {

    public interface a<T> {
        @NonNull
        e<T> a(@NonNull T t);

        @NonNull
        Class<T> a();
    }

    @NonNull
    T a() throws IOException;

    void b();
}

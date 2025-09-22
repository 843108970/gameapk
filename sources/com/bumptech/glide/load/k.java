package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.u;
import java.io.IOException;

public interface k<T, Z> {
    @Nullable
    u<Z> a(@NonNull T t, int i, int i2, @NonNull j jVar) throws IOException;

    boolean a(@NonNull T t, @NonNull j jVar) throws IOException;
}

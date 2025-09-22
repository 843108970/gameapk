package com.bumptech.glide.load.d.d;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import java.io.File;
import java.io.IOException;

public final class a implements k<File, File> {
    private static u<File> a(@NonNull File file) {
        return new b(file);
    }

    private static boolean a() {
        return true;
    }

    public final /* synthetic */ u a(@NonNull Object obj, int i, int i2, @NonNull j jVar) throws IOException {
        return new b((File) obj);
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj, @NonNull j jVar) throws IOException {
        return true;
    }
}

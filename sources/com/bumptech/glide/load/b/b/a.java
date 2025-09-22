package com.bumptech.glide.load.b.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.g;
import java.io.File;

public interface a {

    /* renamed from: com.bumptech.glide.load.b.b.a$a  reason: collision with other inner class name */
    public interface C0012a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f1054a = 262144000;

        /* renamed from: b  reason: collision with root package name */
        public static final String f1055b = "image_manager_disk_cache";

        @Nullable
        a a();
    }

    public interface b {
        boolean a(@NonNull File file);
    }

    @Nullable
    File a(g gVar);

    void a();

    void a(g gVar, b bVar);

    void b(g gVar);
}

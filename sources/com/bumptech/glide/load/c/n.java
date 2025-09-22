package com.bumptech.glide.load.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.j;
import com.bumptech.glide.util.i;
import java.util.Collections;
import java.util.List;

public interface n<Model, Data> {

    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final g f1246a;

        /* renamed from: b  reason: collision with root package name */
        public final List<g> f1247b;

        /* renamed from: c  reason: collision with root package name */
        public final d<Data> f1248c;

        public a(@NonNull g gVar, @NonNull d<Data> dVar) {
            this(gVar, Collections.emptyList(), dVar);
        }

        public a(@NonNull g gVar, @NonNull List<g> list, @NonNull d<Data> dVar) {
            this.f1246a = (g) i.a(gVar, "Argument must not be null");
            this.f1247b = (List) i.a(list, "Argument must not be null");
            this.f1248c = (d) i.a(dVar, "Argument must not be null");
        }
    }

    @Nullable
    a<Data> a(@NonNull Model model, int i, int i2, @NonNull j jVar);

    boolean a(@NonNull Model model);
}

package com.bumptech.glide.load.c.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.android.volley.d;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import java.io.InputStream;

public final class b implements n<g, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public static final i<Integer> f1194a = i.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(d.f471a));
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final m<g, g> f1195b;

    public static class a implements o<g, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final m<g, g> f1196a = new m<>(500);

        @NonNull
        public final n<g, InputStream> a(r rVar) {
            return new b(this.f1196a);
        }

        public final void a() {
        }
    }

    public b() {
        this((m<g, g>) null);
    }

    public b(@Nullable m<g, g> mVar) {
        this.f1195b = mVar;
    }

    private n.a<InputStream> a(@NonNull g gVar, @NonNull j jVar) {
        if (this.f1195b != null) {
            g a2 = this.f1195b.a(gVar, 0, 0);
            if (a2 == null) {
                this.f1195b.a(gVar, 0, 0, gVar);
            } else {
                gVar = a2;
            }
        }
        return new n.a<>(gVar, new com.bumptech.glide.load.a.j(gVar, ((Integer) jVar.a(f1194a)).intValue()));
    }

    private static boolean a() {
        return true;
    }

    public final /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        g gVar = (g) obj;
        if (this.f1195b != null) {
            g a2 = this.f1195b.a(gVar, 0, 0);
            if (a2 == null) {
                this.f1195b.a(gVar, 0, 0, gVar);
            } else {
                gVar = a2;
            }
        }
        return new n.a(gVar, new com.bumptech.glide.load.a.j(gVar, ((Integer) jVar.a(f1194a)).intValue()));
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj) {
        return true;
    }
}

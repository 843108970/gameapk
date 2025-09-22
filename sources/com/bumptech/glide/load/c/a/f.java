package com.bumptech.glide.load.c.a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.j;
import java.io.InputStream;
import java.net.URL;

public final class f implements n<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f1204a;

    public static class a implements o<URL, InputStream> {
        @NonNull
        public final n<URL, InputStream> a(r rVar) {
            return new f(rVar.b(g.class, InputStream.class));
        }

        public final void a() {
        }
    }

    public f(n<g, InputStream> nVar) {
        this.f1204a = nVar;
    }

    private n.a<InputStream> a(@NonNull URL url, int i, int i2, @NonNull j jVar) {
        return this.f1204a.a(new g(url), i, i2, jVar);
    }

    private static boolean a() {
        return true;
    }

    public final /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        return this.f1204a.a(new g((URL) obj), i, i2, jVar);
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj) {
        return true;
    }
}

package com.bumptech.glide.load.c.a;

import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.j;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class c implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f1198a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: b  reason: collision with root package name */
    private final n<g, InputStream> f1199b;

    public static class a implements o<Uri, InputStream> {
        @NonNull
        public final n<Uri, InputStream> a(r rVar) {
            return new c(rVar.b(g.class, InputStream.class));
        }

        public final void a() {
        }
    }

    public c(n<g, InputStream> nVar) {
        this.f1199b = nVar;
    }

    private n.a<InputStream> a(@NonNull Uri uri, int i, int i2, @NonNull j jVar) {
        return this.f1199b.a(new g(uri.toString()), i, i2, jVar);
    }

    private static boolean a(@NonNull Uri uri) {
        return f1198a.contains(uri.getScheme());
    }

    public final /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        return this.f1199b.a(new g(((Uri) obj).toString()), i, i2, jVar);
    }

    public final /* synthetic */ boolean a(@NonNull Object obj) {
        return f1198a.contains(((Uri) obj).getScheme());
    }
}

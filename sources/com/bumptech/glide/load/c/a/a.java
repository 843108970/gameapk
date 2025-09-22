package com.bumptech.glide.load.c.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.c.h;
import com.bumptech.glide.load.c.m;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.j;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class a<Model> implements n<Model, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f1191a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final m<Model, g> f1192b;

    private a(n<g, InputStream> nVar) {
        this(nVar, (byte) 0);
    }

    private a(n<g, InputStream> nVar, byte b2) {
        this.f1191a = nVar;
        this.f1192b = null;
    }

    private static List<com.bumptech.glide.load.g> a(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (String gVar : collection) {
            arrayList.add(new g(gVar));
        }
        return arrayList;
    }

    private static List<String> b() {
        return Collections.emptyList();
    }

    @Nullable
    private static h c() {
        return h.f1229b;
    }

    @Nullable
    public final n.a<InputStream> a(@NonNull Model model, int i, int i2, @NonNull j jVar) {
        g a2 = this.f1192b != null ? this.f1192b.a(model, i, i2) : null;
        if (a2 == null) {
            String a3 = a();
            if (TextUtils.isEmpty(a3)) {
                return null;
            }
            g gVar = new g(a3, h.f1229b);
            if (this.f1192b != null) {
                this.f1192b.a(model, i, i2, gVar);
            }
            a2 = gVar;
        }
        List emptyList = Collections.emptyList();
        n.a<InputStream> a4 = this.f1191a.a(a2, i, i2, jVar);
        return (a4 == null || emptyList.isEmpty()) ? a4 : new n.a<>(a4.f1246a, a(emptyList), a4.f1248c);
    }

    /* access modifiers changed from: protected */
    public abstract String a();
}

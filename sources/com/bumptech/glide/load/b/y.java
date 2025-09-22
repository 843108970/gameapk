package com.bumptech.glide.load.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.e;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.g;
import com.bumptech.glide.m;
import java.util.Collections;
import java.util.List;

final class y implements d.a<Object>, e, e.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1185a = "SourceGenerator";

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f1186b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a f1187c;
    private int d;
    private b e;
    private Object f;
    private volatile n.a<?> g;
    private c h;

    y(f<?> fVar, e.a aVar) {
        this.f1186b = fVar;
        this.f1187c = aVar;
    }

    /* JADX INFO: finally extract failed */
    private void b(Object obj) {
        long a2 = com.bumptech.glide.util.e.a();
        try {
            com.bumptech.glide.load.d<?> a3 = this.f1186b.f1124c.d.d.a(obj.getClass());
            if (a3 != null) {
                d dVar = new d(a3, obj, this.f1186b.i);
                this.h = new c(this.g.f1246a, this.f1186b.n);
                this.f1186b.a().a(this.h, dVar);
                if (Log.isLoggable(f1185a, 2)) {
                    Log.v(f1185a, "Finished encoding source to cache, key: " + this.h + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.bumptech.glide.util.e.a(a2));
                }
                this.g.f1248c.b();
                this.e = new b(Collections.singletonList(this.g.f1246a), this.f1186b, this);
                return;
            }
            throw new m.e(obj.getClass());
        } catch (Throwable th) {
            this.g.f1248c.b();
            throw th;
        }
    }

    private boolean d() {
        return this.d < this.f1186b.b().size();
    }

    public final void a(g gVar, Exception exc, d<?> dVar, a aVar) {
        this.f1187c.a(gVar, exc, dVar, this.g.f1248c.d());
    }

    public final void a(g gVar, Object obj, d<?> dVar, a aVar, g gVar2) {
        this.f1187c.a(gVar, obj, dVar, this.g.f1248c.d(), gVar);
    }

    public final void a(@NonNull Exception exc) {
        this.f1187c.a(this.h, exc, this.g.f1248c, this.g.f1248c.d());
    }

    public final void a(Object obj) {
        i iVar = this.f1186b.p;
        if (obj == null || !iVar.a(this.g.f1248c.d())) {
            this.f1187c.a(this.g.f1246a, obj, this.g.f1248c, this.g.f1248c.d(), this.h);
            return;
        }
        this.f = obj;
        this.f1187c.c();
    }

    /* JADX INFO: finally extract failed */
    public final boolean a() {
        if (this.f != null) {
            Object obj = this.f;
            this.f = null;
            long a2 = com.bumptech.glide.util.e.a();
            try {
                com.bumptech.glide.load.d<?> a3 = this.f1186b.f1124c.d.d.a(obj.getClass());
                if (a3 != null) {
                    d dVar = new d(a3, obj, this.f1186b.i);
                    this.h = new c(this.g.f1246a, this.f1186b.n);
                    this.f1186b.a().a(this.h, dVar);
                    if (Log.isLoggable(f1185a, 2)) {
                        Log.v(f1185a, "Finished encoding source to cache, key: " + this.h + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.bumptech.glide.util.e.a(a2));
                    }
                    this.g.f1248c.b();
                    this.e = new b(Collections.singletonList(this.g.f1246a), this.f1186b, this);
                } else {
                    throw new m.e(obj.getClass());
                }
            } catch (Throwable th) {
                this.g.f1248c.b();
                throw th;
            }
        }
        if (this.e != null && this.e.a()) {
            return true;
        }
        this.e = null;
        this.g = null;
        boolean z = false;
        while (!z) {
            if (!(this.d < this.f1186b.b().size())) {
                break;
            }
            List<n.a<?>> b2 = this.f1186b.b();
            int i = this.d;
            this.d = i + 1;
            this.g = b2.get(i);
            if (this.g != null && (this.f1186b.p.a(this.g.f1248c.d()) || this.f1186b.a((Class<?>) this.g.f1248c.a()))) {
                this.g.f1248c.a(this.f1186b.o, this);
                z = true;
            }
        }
        return z;
    }

    public final void b() {
        n.a<?> aVar = this.g;
        if (aVar != null) {
            aVar.f1248c.c();
        }
    }

    public final void c() {
        throw new UnsupportedOperationException();
    }
}

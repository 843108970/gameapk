package com.bumptech.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.b.h;
import com.bumptech.glide.load.b.b.i;
import com.bumptech.glide.load.b.b.l;
import com.bumptech.glide.load.b.c.a;
import com.bumptech.glide.load.b.j;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.manager.f;
import com.bumptech.glide.manager.k;
import java.util.Map;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    final Map<Class<?>, p<?, ?>> f956a = new ArrayMap();

    /* renamed from: b  reason: collision with root package name */
    j f957b;

    /* renamed from: c  reason: collision with root package name */
    e f958c;
    b d;
    public com.bumptech.glide.load.b.b.j e;
    a f;
    a g;
    public a.C0012a h;
    l i;
    d j;
    int k = 4;
    com.bumptech.glide.request.g l = new com.bumptech.glide.request.g();
    @Nullable
    k.a m;
    com.bumptech.glide.load.b.c.a n;
    boolean o;

    @NonNull
    private f a(@NonNull Context context) {
        if (this.f == null) {
            this.f = com.bumptech.glide.load.b.c.a.b();
        }
        if (this.g == null) {
            this.g = com.bumptech.glide.load.b.c.a.a();
        }
        if (this.n == null) {
            this.n = com.bumptech.glide.load.b.c.a.d();
        }
        if (this.i == null) {
            this.i = new l.a(context).a();
        }
        if (this.j == null) {
            this.j = new f();
        }
        if (this.f958c == null) {
            int i2 = this.i.f1078b;
            if (i2 > 0) {
                this.f958c = new com.bumptech.glide.load.b.a.k((long) i2);
            } else {
                this.f958c = new com.bumptech.glide.load.b.a.f();
            }
        }
        if (this.d == null) {
            this.d = new com.bumptech.glide.load.b.a.j(this.i.d);
        }
        if (this.e == null) {
            this.e = new i((long) this.i.f1079c);
        }
        if (this.h == null) {
            this.h = new h(context);
        }
        if (this.f957b == null) {
            this.f957b = new j(this.e, this.h, this.g, this.f, com.bumptech.glide.load.b.c.a.c(), com.bumptech.glide.load.b.c.a.d(), this.o);
        }
        return new f(context, this.f957b, this.e, this.f958c, this.d, new k(this.m), this.j, this.k, this.l.n(), this.f956a);
    }

    @NonNull
    private g a(int i2) {
        if (i2 < 2 || i2 > 6) {
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.k = i2;
        return this;
    }

    @NonNull
    private g a(@Nullable b bVar) {
        this.d = bVar;
        return this;
    }

    @NonNull
    private g a(@Nullable e eVar) {
        this.f958c = eVar;
        return this;
    }

    @NonNull
    private g a(@Nullable a.C0012a aVar) {
        this.h = aVar;
        return this;
    }

    @NonNull
    private g a(@Nullable com.bumptech.glide.load.b.b.j jVar) {
        this.e = jVar;
        return this;
    }

    @NonNull
    private g a(@NonNull l.a aVar) {
        this.i = aVar.a();
        return this;
    }

    @NonNull
    private g a(@Nullable l lVar) {
        this.i = lVar;
        return this;
    }

    @Deprecated
    private g a(@Nullable com.bumptech.glide.load.b.c.a aVar) {
        this.f = aVar;
        return this;
    }

    private g a(j jVar) {
        this.f957b = jVar;
        return this;
    }

    @NonNull
    private g a(@Nullable d dVar) {
        this.j = dVar;
        return this;
    }

    @NonNull
    private g a(@Nullable com.bumptech.glide.request.g gVar) {
        this.l = gVar;
        return this;
    }

    @NonNull
    private <T> g a(@NonNull Class<T> cls, @Nullable p<?, T> pVar) {
        this.f956a.put(cls, pVar);
        return this;
    }

    @NonNull
    private g a(boolean z) {
        this.o = z;
        return this;
    }

    private void a(@Nullable k.a aVar) {
        this.m = aVar;
    }

    @NonNull
    private g b(@Nullable com.bumptech.glide.load.b.c.a aVar) {
        this.f = aVar;
        return this;
    }

    @NonNull
    private g c(@Nullable com.bumptech.glide.load.b.c.a aVar) {
        this.g = aVar;
        return this;
    }

    @NonNull
    private g d(@Nullable com.bumptech.glide.load.b.c.a aVar) {
        this.n = aVar;
        return this;
    }
}

package com.bumptech.glide.load.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.Pools;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.j;
import com.bumptech.glide.m;
import com.bumptech.glide.util.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final c f1258a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final n<Object, Object> f1259b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final List<b<?, ?>> f1260c;
    private final c d;
    private final Set<b<?, ?>> e;
    private final Pools.Pool<List<Throwable>> f;

    private static class a implements n<Object, Object> {
        a() {
        }

        @Nullable
        public final n.a<Object> a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
            return null;
        }

        public final boolean a(@NonNull Object obj) {
            return false;
        }
    }

    private static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        final Class<Data> f1261a;

        /* renamed from: b  reason: collision with root package name */
        final o<? extends Model, ? extends Data> f1262b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<Model> f1263c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.f1263c = cls;
            this.f1261a = cls2;
            this.f1262b = oVar;
        }

        public final boolean a(@NonNull Class<?> cls) {
            return this.f1263c.isAssignableFrom(cls);
        }

        public final boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.f1261a.isAssignableFrom(cls2);
        }
    }

    static class c {
        c() {
        }

        @NonNull
        private static <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }
    }

    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f1258a);
    }

    @VisibleForTesting
    private r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.f1260c = new ArrayList();
        this.e = new HashSet();
        this.f = pool;
        this.d = cVar;
    }

    @NonNull
    private static <Model, Data> n<Model, Data> a() {
        return f1259b;
    }

    @NonNull
    private static <Model, Data> o<Model, Data> a(@NonNull b<?, ?> bVar) {
        return bVar.f1262b;
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z) {
        this.f1260c.add(z ? this.f1260c.size() : 0, new b(cls, cls2, oVar));
    }

    @NonNull
    private <Model, Data> n<Model, Data> b(@NonNull b<?, ?> bVar) {
        return (n) i.a(bVar.f1262b.a(this), "Argument must not be null");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final synchronized <Model> List<n<Model, ?>> a(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b next : this.f1260c) {
                if (!this.e.contains(next) && next.a(cls)) {
                    this.e.add(next);
                    arrayList.add(b((b<?, ?>) next));
                    this.e.remove(next);
                }
            }
        } catch (Throwable th) {
            this.e.clear();
            throw th;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final synchronized <Model, Data> List<o<? extends Model, ? extends Data>> a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.f1260c.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.a(cls, cls2)) {
                it.remove();
                arrayList.add(next.f1262b);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    @NonNull
    public final synchronized <Model, Data> n<Model, Data> b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b next : this.f1260c) {
                if (this.e.contains(next)) {
                    z = true;
                } else if (next.a(cls, cls2)) {
                    this.e.add(next);
                    arrayList.add(b((b<?, ?>) next));
                    this.e.remove(next);
                }
            }
            if (arrayList.size() > 1) {
                return new q(arrayList, this.f);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z) {
                return f1259b;
            } else {
                throw new m.c(cls, cls2);
            }
        } catch (Throwable th) {
            this.e.clear();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final synchronized List<Class<?>> b(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b next : this.f1260c) {
            if (!arrayList.contains(next.f1261a) && next.a(cls)) {
                arrayList.add(next.f1261a);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, false);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final synchronized <Model, Data> List<o<? extends Model, ? extends Data>> c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        List<o<? extends Model, ? extends Data>> a2;
        a2 = a(cls, cls2);
        a(cls, cls2, oVar);
        return a2;
    }
}

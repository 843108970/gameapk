package com.bumptech.glide.load.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final r f1249a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1250b;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map<Class<?>, C0018a<?>> f1251a = new HashMap();

        /* renamed from: com.bumptech.glide.load.c.p$a$a  reason: collision with other inner class name */
        private static class C0018a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<n<Model, ?>> f1252a;

            public C0018a(List<n<Model, ?>> list) {
                this.f1252a = list;
            }
        }

        a() {
        }

        @Nullable
        private <Model> List<n<Model, ?>> a(Class<Model> cls) {
            C0018a aVar = this.f1251a.get(cls);
            if (aVar == null) {
                return null;
            }
            return aVar.f1252a;
        }

        private <Model> void a(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f1251a.put(cls, new C0018a(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }

        public final void a() {
            this.f1251a.clear();
        }
    }

    public p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
    }

    private p(@NonNull r rVar) {
        this.f1250b = new a();
        this.f1249a = rVar;
    }

    @NonNull
    private <A> List<n<A, ?>> a(@NonNull A a2) {
        List<n<A, ?>> b2 = b(a2.getClass());
        int size = b2.size();
        List<n<A, ?>> emptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            n nVar = b2.get(i);
            if (nVar.a(a2)) {
                if (z) {
                    emptyList = new ArrayList<>(size - i);
                    z = false;
                }
                emptyList.add(nVar);
            }
        }
        return emptyList;
    }

    private synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        a(this.f1249a.a(cls, cls2));
        this.f1250b.a();
    }

    private static <Model, Data> void a(@NonNull List<o<? extends Model, ? extends Data>> list) {
        Iterator<o<? extends Model, ? extends Data>> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private synchronized <Model, Data> n<Model, Data> b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.f1249a.b(cls, cls2);
    }

    @NonNull
    private static <A> Class<A> b(@NonNull A a2) {
        return a2.getClass();
    }

    @NonNull
    public final synchronized List<Class<?>> a(@NonNull Class<?> cls) {
        return this.f1249a.b(cls);
    }

    public final synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f1249a.a(cls, cls2, oVar);
        this.f1250b.a();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Class<A>, java.lang.Object, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized <A> java.util.List<com.bumptech.glide.load.c.n<A, ?>> b(@android.support.annotation.NonNull java.lang.Class<A> r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.bumptech.glide.load.c.p$a r0 = r3.f1250b     // Catch:{ all -> 0x0044 }
            java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.c.p$a$a<?>> r0 = r0.f1251a     // Catch:{ all -> 0x0044 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0044 }
            com.bumptech.glide.load.c.p$a$a r0 = (com.bumptech.glide.load.c.p.a.C0018a) r0     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x000f
            r0 = 0
            goto L_0x0011
        L_0x000f:
            java.util.List<com.bumptech.glide.load.c.n<Model, ?>> r0 = r0.f1252a     // Catch:{ all -> 0x0044 }
        L_0x0011:
            if (r0 != 0) goto L_0x0042
            com.bumptech.glide.load.c.r r0 = r3.f1249a     // Catch:{ all -> 0x0044 }
            java.util.List r0 = r0.a(r4)     // Catch:{ all -> 0x0044 }
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)     // Catch:{ all -> 0x0044 }
            com.bumptech.glide.load.c.p$a r1 = r3.f1250b     // Catch:{ all -> 0x0044 }
            java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.c.p$a$a<?>> r1 = r1.f1251a     // Catch:{ all -> 0x0044 }
            com.bumptech.glide.load.c.p$a$a r2 = new com.bumptech.glide.load.c.p$a$a     // Catch:{ all -> 0x0044 }
            r2.<init>(r0)     // Catch:{ all -> 0x0044 }
            java.lang.Object r1 = r1.put(r4, r2)     // Catch:{ all -> 0x0044 }
            com.bumptech.glide.load.c.p$a$a r1 = (com.bumptech.glide.load.c.p.a.C0018a) r1     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x0042
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0044 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "Already cached loaders for model: "
            r1.<init>(r2)     // Catch:{ all -> 0x0044 }
            r1.append(r4)     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0044 }
            r0.<init>(r4)     // Catch:{ all -> 0x0044 }
            throw r0     // Catch:{ all -> 0x0044 }
        L_0x0042:
            monitor-exit(r3)
            return r0
        L_0x0044:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.c.p.b(java.lang.Class):java.util.List");
    }

    public final synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f1249a.b(cls, cls2, oVar);
        this.f1250b.a();
    }

    public final synchronized <Model, Data> void c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(this.f1249a.c(cls, cls2, oVar));
        this.f1250b.a();
    }
}

package com.bumptech.glide.util.a;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1477a = "FactoryPools";

    /* renamed from: b  reason: collision with root package name */
    private static final int f1478b = 20;

    /* renamed from: c  reason: collision with root package name */
    private static final d<Object> f1479c = new d<Object>() {
        public final void a(@NonNull Object obj) {
        }
    };

    /* renamed from: com.bumptech.glide.util.a.a$a  reason: collision with other inner class name */
    public interface C0023a<T> {
        T a();
    }

    private static final class b<T> implements Pools.Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final C0023a<T> f1480a;

        /* renamed from: b  reason: collision with root package name */
        private final d<T> f1481b;

        /* renamed from: c  reason: collision with root package name */
        private final Pools.Pool<T> f1482c;

        b(@NonNull Pools.Pool<T> pool, @NonNull C0023a<T> aVar, @NonNull d<T> dVar) {
            this.f1482c = pool;
            this.f1480a = aVar;
            this.f1481b = dVar;
        }

        public final T acquire() {
            T acquire = this.f1482c.acquire();
            if (acquire == null) {
                acquire = this.f1480a.a();
                if (Log.isLoggable(a.f1477a, 2)) {
                    Log.v(a.f1477a, "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof c) {
                ((c) acquire).g_().a(false);
            }
            return acquire;
        }

        public final boolean release(@NonNull T t) {
            if (t instanceof c) {
                ((c) t).g_().a(true);
            }
            this.f1481b.a(t);
            return this.f1482c.release(t);
        }
    }

    public interface c {
        @NonNull
        c g_();
    }

    public interface d<T> {
        void a(@NonNull T t);
    }

    private a() {
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> a() {
        return a(new Pools.SynchronizedPool(20), new C0023a<List<T>>() {
            @NonNull
            private static List<T> b() {
                return new ArrayList();
            }

            @NonNull
            public final /* synthetic */ Object a() {
                return new ArrayList();
            }
        }, new d<List<T>>() {
            private static void a(@NonNull List<T> list) {
                list.clear();
            }

            public final /* synthetic */ void a(@NonNull Object obj) {
                ((List) obj).clear();
            }
        });
    }

    @NonNull
    public static <T extends c> Pools.Pool<T> a(int i, @NonNull C0023a<T> aVar) {
        return a(new Pools.SynchronizedPool(i), aVar);
    }

    @NonNull
    private static <T extends c> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull C0023a<T> aVar) {
        return a(pool, aVar, f1479c);
    }

    @NonNull
    private static <T> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull C0023a<T> aVar, @NonNull d<T> dVar) {
        return new b(pool, aVar, dVar);
    }

    @NonNull
    public static <T extends c> Pools.Pool<T> a(@NonNull C0023a<T> aVar) {
        return a(new Pools.SimplePool(150), aVar);
    }

    @NonNull
    private static <T> Pools.Pool<List<T>> b() {
        return a(new Pools.SynchronizedPool(20), new C0023a<List<T>>() {
            @NonNull
            private static List<T> b() {
                return new ArrayList();
            }

            @NonNull
            public final /* synthetic */ Object a() {
                return new ArrayList();
            }
        }, new d<List<T>>() {
            private static void a(@NonNull List<T> list) {
                list.clear();
            }

            public final /* synthetic */ void a(@NonNull Object obj) {
                ((List) obj).clear();
            }
        });
    }

    @NonNull
    private static <T> d<T> c() {
        return f1479c;
    }
}

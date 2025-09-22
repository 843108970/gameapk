package com.bumptech.glide.load.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.l;
import com.bumptech.glide.load.b.a;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.b.j;
import com.bumptech.glide.load.b.g;
import com.bumptech.glide.load.b.o;
import com.bumptech.glide.load.m;
import com.bumptech.glide.util.a.a;
import com.bumptech.glide.util.e;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.k;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class j implements j.a, l, o.a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f1145a = Log.isLoggable(h, 2);
    private static final String h = "Engine";
    private static final int i = 150;

    /* renamed from: b  reason: collision with root package name */
    public final r f1146b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bumptech.glide.load.b.b.j f1147c;
    public final b d;
    public final c e;
    public final a f;
    public final a g;
    private final n j;
    private final x k;

    @VisibleForTesting
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final g.d f1148a;

        /* renamed from: b  reason: collision with root package name */
        public final Pools.Pool<g<?>> f1149b = com.bumptech.glide.util.a.a.a(new a.C0023a<g<?>>() {
            private g<?> b() {
                return new g<>(a.this.f1148a, a.this.f1149b);
            }

            public final /* synthetic */ Object a() {
                return new g(a.this.f1148a, a.this.f1149b);
            }
        });

        /* renamed from: c  reason: collision with root package name */
        public int f1150c;

        a(g.d dVar) {
            this.f1148a = dVar;
        }

        private <R> g<R> a(h hVar, Object obj, m mVar, com.bumptech.glide.load.g gVar, int i, int i2, Class<?> cls, Class<R> cls2, l lVar, i iVar, Map<Class<?>, m<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.j jVar, g.a<R> aVar) {
            h hVar2 = hVar;
            Object obj2 = obj;
            com.bumptech.glide.load.g gVar2 = gVar;
            int i3 = i;
            int i4 = i2;
            l lVar2 = lVar;
            i iVar2 = iVar;
            com.bumptech.glide.load.j jVar2 = jVar;
            g<R> gVar3 = (g) i.a(this.f1149b.acquire(), "Argument must not be null");
            int i5 = this.f1150c;
            this.f1150c = i5 + 1;
            f<R> fVar = gVar3.f1125a;
            g.d dVar = gVar3.f1126b;
            fVar.f1124c = hVar2;
            fVar.d = obj2;
            fVar.n = gVar2;
            fVar.e = i3;
            fVar.f = i4;
            fVar.p = iVar2;
            fVar.g = cls;
            fVar.h = dVar;
            fVar.k = cls2;
            fVar.o = lVar2;
            fVar.i = jVar2;
            fVar.j = map;
            fVar.q = z;
            fVar.r = z2;
            gVar3.e = hVar2;
            gVar3.f = gVar2;
            gVar3.g = lVar2;
            gVar3.h = mVar;
            gVar3.i = i3;
            gVar3.j = i4;
            gVar3.k = iVar2;
            gVar3.p = z3;
            gVar3.l = jVar2;
            gVar3.m = aVar;
            gVar3.n = i5;
            gVar3.o = g.f.INITIALIZE;
            gVar3.q = obj2;
            return gVar3;
        }
    }

    @VisibleForTesting
    static class b {

        /* renamed from: a  reason: collision with root package name */
        public final com.bumptech.glide.load.b.c.a f1152a;

        /* renamed from: b  reason: collision with root package name */
        public final com.bumptech.glide.load.b.c.a f1153b;

        /* renamed from: c  reason: collision with root package name */
        public final com.bumptech.glide.load.b.c.a f1154c;
        public final com.bumptech.glide.load.b.c.a d;
        final l e;
        public final Pools.Pool<k<?>> f = com.bumptech.glide.util.a.a.a(new a.C0023a<k<?>>() {
            private k<?> b() {
                return new k(b.this.f1152a, b.this.f1153b, b.this.f1154c, b.this.d, b.this.e, b.this.f);
            }

            public final /* synthetic */ Object a() {
                return new k(b.this.f1152a, b.this.f1153b, b.this.f1154c, b.this.d, b.this.e, b.this.f);
            }
        });

        b(com.bumptech.glide.load.b.c.a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, l lVar) {
            this.f1152a = aVar;
            this.f1153b = aVar2;
            this.f1154c = aVar3;
            this.d = aVar4;
            this.e = lVar;
        }

        private <R> k<R> a(com.bumptech.glide.load.g gVar, boolean z, boolean z2, boolean z3, boolean z4) {
            k<R> kVar = (k) i.a(this.f.acquire(), "Argument must not be null");
            kVar.e = gVar;
            kVar.f = z;
            kVar.g = z2;
            kVar.h = z3;
            kVar.i = z4;
            return kVar;
        }

        @VisibleForTesting
        private void a() {
            a(this.f1152a);
            a(this.f1153b);
            a(this.f1154c);
            a(this.d);
        }

        public static void a(ExecutorService executorService) {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                    if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                        throw new RuntimeException("Failed to shutdown");
                    }
                }
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private static class c implements g.d {

        /* renamed from: a  reason: collision with root package name */
        private final a.C0012a f1156a;

        /* renamed from: b  reason: collision with root package name */
        private volatile com.bumptech.glide.load.b.b.a f1157b;

        c(a.C0012a aVar) {
            this.f1156a = aVar;
        }

        public final com.bumptech.glide.load.b.b.a a() {
            if (this.f1157b == null) {
                synchronized (this) {
                    if (this.f1157b == null) {
                        this.f1157b = this.f1156a.a();
                    }
                    if (this.f1157b == null) {
                        this.f1157b = new com.bumptech.glide.load.b.b.b();
                    }
                }
            }
            return this.f1157b;
        }

        @VisibleForTesting
        public final synchronized void b() {
            if (this.f1157b != null) {
                this.f1157b.a();
            }
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final k<?> f1158a;

        /* renamed from: b  reason: collision with root package name */
        public final com.bumptech.glide.request.h f1159b;

        public d(com.bumptech.glide.request.h hVar, k<?> kVar) {
            this.f1159b = hVar;
            this.f1158a = kVar;
        }

        private void a() {
            k<?> kVar = this.f1158a;
            com.bumptech.glide.request.h hVar = this.f1159b;
            k.a();
            kVar.f1161b.a();
            if (kVar.l || kVar.m) {
                if (kVar.n == null) {
                    kVar.n = new ArrayList(2);
                }
                if (!kVar.n.contains(hVar)) {
                    kVar.n.add(hVar);
                    return;
                }
                return;
            }
            kVar.f1160a.remove(hVar);
            if (kVar.f1160a.isEmpty() && !kVar.m && !kVar.l && !kVar.q) {
                kVar.q = true;
                g<R> gVar = kVar.p;
                gVar.t = true;
                e eVar = gVar.s;
                if (eVar != null) {
                    eVar.b();
                }
                kVar.f1162c.a(kVar, kVar.e);
            }
        }
    }

    public j(com.bumptech.glide.load.b.b.j jVar, a.C0012a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, com.bumptech.glide.load.b.c.a aVar5, boolean z) {
        this(jVar, aVar, aVar2, aVar3, aVar4, aVar5, z, (byte) 0);
    }

    @VisibleForTesting
    private j(com.bumptech.glide.load.b.b.j jVar, a.C0012a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, com.bumptech.glide.load.b.c.a aVar5, boolean z, byte b2) {
        this.f1147c = jVar;
        this.e = new c(aVar);
        a aVar6 = new a(z);
        this.g = aVar6;
        aVar6.f1009c = this;
        this.j = new n();
        this.f1146b = new r();
        this.d = new b(aVar2, aVar3, aVar4, aVar5, this);
        this.f = new a(this.e);
        this.k = new x();
        jVar.a((j.a) this);
    }

    private <R> d a(h hVar, Object obj, com.bumptech.glide.load.g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, l lVar, i iVar, Map<Class<?>, m<?>> map, boolean z, boolean z2, com.bumptech.glide.load.j jVar, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.request.h hVar2) {
        o oVar;
        o oVar2;
        h hVar3 = hVar;
        Object obj2 = obj;
        com.bumptech.glide.load.g gVar2 = gVar;
        int i4 = i2;
        int i5 = i3;
        l lVar2 = lVar;
        i iVar2 = iVar;
        com.bumptech.glide.load.j jVar2 = jVar;
        boolean z7 = z3;
        boolean z8 = z6;
        com.bumptech.glide.request.h hVar4 = hVar2;
        k.a();
        m mVar = r2;
        long a2 = f1145a ? e.a() : 0;
        int i6 = i4;
        com.bumptech.glide.request.h hVar5 = hVar4;
        int i7 = i5;
        boolean z9 = z8;
        boolean z10 = z7;
        m mVar2 = new m(obj2, gVar2, i6, i7, map, cls, cls2, jVar);
        if (!z10) {
            oVar = null;
        } else {
            a aVar = this.g;
            a.b bVar = aVar.f1008b.get(mVar);
            if (bVar == null) {
                oVar = null;
            } else {
                oVar = (o) bVar.get();
                if (oVar == null) {
                    aVar.a(bVar);
                }
            }
            if (oVar != null) {
                oVar.e();
            }
        }
        if (oVar != null) {
            hVar5.a(oVar, com.bumptech.glide.load.a.MEMORY_CACHE);
            if (f1145a) {
                a("Loaded resource from active resources", a2, (com.bumptech.glide.load.g) mVar);
            }
            return null;
        }
        long j2 = a2;
        if (!z10) {
            oVar2 = null;
        } else {
            u<?> a3 = this.f1147c.a((com.bumptech.glide.load.g) mVar);
            oVar2 = a3 == null ? null : a3 instanceof o ? (o) a3 : new o(a3, true, true);
            if (oVar2 != null) {
                oVar2.e();
                this.g.a(mVar, oVar2);
            }
        }
        if (oVar2 != null) {
            hVar5.a(oVar2, com.bumptech.glide.load.a.MEMORY_CACHE);
            if (f1145a) {
                a("Loaded resource from cache", j2, (com.bumptech.glide.load.g) mVar);
            }
            return null;
        }
        k kVar = this.f1146b.a(z9).get(mVar);
        if (kVar != null) {
            kVar.a(hVar5);
            if (f1145a) {
                a("Added to existing load", j2, (com.bumptech.glide.load.g) mVar);
            }
            return new d(hVar5, kVar);
        }
        k kVar2 = (k) i.a(this.d.f.acquire(), "Argument must not be null");
        kVar2.e = mVar;
        kVar2.f = z10;
        kVar2.g = z4;
        kVar2.h = z5;
        kVar2.i = z9;
        a aVar2 = this.f;
        g<R> gVar3 = (g) i.a(aVar2.f1149b.acquire(), "Argument must not be null");
        int i8 = aVar2.f1150c;
        aVar2.f1150c = i8 + 1;
        f<R> fVar = gVar3.f1125a;
        g.d dVar = gVar3.f1126b;
        fVar.f1124c = hVar3;
        fVar.d = obj2;
        com.bumptech.glide.load.g gVar4 = gVar;
        fVar.n = gVar4;
        int i9 = i2;
        fVar.e = i9;
        boolean z11 = z9;
        int i10 = i3;
        fVar.f = i10;
        m mVar3 = mVar;
        i iVar3 = iVar;
        fVar.p = iVar3;
        long j3 = j2;
        fVar.g = cls;
        fVar.h = dVar;
        fVar.k = cls2;
        m mVar4 = mVar3;
        l lVar3 = lVar;
        fVar.o = lVar3;
        com.bumptech.glide.load.j jVar3 = jVar;
        fVar.i = jVar3;
        fVar.j = map;
        fVar.q = z;
        fVar.r = z2;
        gVar3.e = hVar3;
        gVar3.f = gVar4;
        gVar3.g = lVar3;
        gVar3.h = mVar4;
        gVar3.i = i9;
        gVar3.j = i10;
        gVar3.k = iVar3;
        gVar3.p = z11;
        gVar3.l = jVar3;
        gVar3.m = kVar2;
        gVar3.n = i8;
        gVar3.o = g.f.INITIALIZE;
        gVar3.q = obj2;
        this.f1146b.a(kVar2.i).put(mVar4, kVar2);
        com.bumptech.glide.request.h hVar6 = hVar2;
        kVar2.a(hVar6);
        kVar2.p = gVar3;
        g.C0015g a4 = gVar3.a(g.C0015g.INITIALIZE);
        (a4 == g.C0015g.RESOURCE_CACHE || a4 == g.C0015g.DATA_CACHE ? kVar2.d : kVar2.a()).execute(gVar3);
        if (f1145a) {
            a("Started new load", j3, (com.bumptech.glide.load.g) mVar4);
        }
        return new d(hVar6, kVar2);
    }

    private o<?> a(com.bumptech.glide.load.g gVar) {
        u<?> a2 = this.f1147c.a(gVar);
        if (a2 == null) {
            return null;
        }
        return a2 instanceof o ? (o) a2 : new o<>(a2, true, true);
    }

    @Nullable
    private o<?> a(com.bumptech.glide.load.g gVar, boolean z) {
        o<?> oVar = null;
        if (!z) {
            return null;
        }
        a aVar = this.g;
        a.b bVar = aVar.f1008b.get(gVar);
        if (bVar != null && (oVar = (o) bVar.get()) == null) {
            aVar.a(bVar);
        }
        if (oVar != null) {
            oVar.e();
        }
        return oVar;
    }

    private void a() {
        this.e.a().a();
    }

    public static void a(u<?> uVar) {
        k.a();
        if (uVar instanceof o) {
            ((o) uVar).f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public static void a(String str, long j2, com.bumptech.glide.load.g gVar) {
        Log.v(h, str + " in " + e.a(j2) + "ms, key: " + gVar);
    }

    private o<?> b(com.bumptech.glide.load.g gVar, boolean z) {
        o<?> oVar = null;
        if (!z) {
            return null;
        }
        u a2 = this.f1147c.a(gVar);
        if (a2 != null) {
            oVar = a2 instanceof o ? (o) a2 : new o<>(a2, true, true);
        }
        if (oVar != null) {
            oVar.e();
            this.g.a(gVar, oVar);
        }
        return oVar;
    }

    @VisibleForTesting
    private void b() {
        b bVar = this.d;
        b.a(bVar.f1152a);
        b.a(bVar.f1153b);
        b.a(bVar.f1154c);
        b.a(bVar.d);
        this.e.b();
        a aVar = this.g;
        aVar.f = true;
        if (aVar.e != null) {
            aVar.e.interrupt();
            try {
                aVar.e.join(TimeUnit.SECONDS.toMillis(5));
                if (aVar.e.isAlive()) {
                    throw new RuntimeException("Failed to join in time");
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final void a(k<?> kVar, com.bumptech.glide.load.g gVar) {
        k.a();
        this.f1146b.a(gVar, kVar);
    }

    public final void a(k<?> kVar, com.bumptech.glide.load.g gVar, o<?> oVar) {
        k.a();
        if (oVar != null) {
            oVar.a(gVar, this);
            if (oVar.f1164a) {
                this.g.a(gVar, oVar);
            }
        }
        this.f1146b.a(gVar, kVar);
    }

    public final void a(com.bumptech.glide.load.g gVar, o<?> oVar) {
        k.a();
        a.b remove = this.g.f1008b.remove(gVar);
        if (remove != null) {
            remove.a();
        }
        if (oVar.f1164a) {
            this.f1147c.a(gVar, oVar);
        } else {
            this.k.a(oVar);
        }
    }

    public final void b(@NonNull u<?> uVar) {
        k.a();
        this.k.a(uVar);
    }
}

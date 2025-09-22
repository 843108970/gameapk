package com.bumptech.glide.load.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.Pools;
import com.bumptech.glide.load.b.g;
import com.bumptech.glide.request.h;
import com.bumptech.glide.util.a.a;
import com.bumptech.glide.util.a.c;
import java.util.ArrayList;
import java.util.List;

public final class k<R> implements g.a<R>, a.c {
    private static final a r = new a();
    private static final Handler s = new Handler(Looper.getMainLooper(), new b());
    private static final int t = 1;
    private static final int u = 2;
    private static final int v = 3;
    private final com.bumptech.glide.load.b.c.a A;
    private p B;

    /* renamed from: a  reason: collision with root package name */
    public final List<h> f1160a;

    /* renamed from: b  reason: collision with root package name */
    public final c f1161b;

    /* renamed from: c  reason: collision with root package name */
    public final l f1162c;
    public final com.bumptech.glide.load.b.c.a d;
    public com.bumptech.glide.load.g e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    u<?> j;
    com.bumptech.glide.load.a k;
    public boolean l;
    public boolean m;
    public List<h> n;
    o<?> o;
    public g<R> p;
    public volatile boolean q;
    private final Pools.Pool<k<?>> w;
    private final a x;
    private final com.bumptech.glide.load.b.c.a y;
    private final com.bumptech.glide.load.b.c.a z;

    @VisibleForTesting
    static class a {
        a() {
        }

        private static <R> o<R> a(u<R> uVar, boolean z) {
            return new o<>(uVar, z, true);
        }
    }

    private static class b implements Handler.Callback {
        b() {
        }

        public final boolean handleMessage(Message message) {
            k kVar = (k) message.obj;
            switch (message.what) {
                case 1:
                    kVar.f1161b.a();
                    if (!kVar.q) {
                        if (!kVar.f1160a.isEmpty()) {
                            if (!kVar.l) {
                                kVar.o = new o<>(kVar.j, kVar.f, true);
                                kVar.l = true;
                                kVar.o.e();
                                kVar.f1162c.a(kVar, kVar.e, kVar.o);
                                int size = kVar.f1160a.size();
                                for (int i = 0; i < size; i++) {
                                    h hVar = kVar.f1160a.get(i);
                                    if (!kVar.b(hVar)) {
                                        kVar.o.e();
                                        hVar.a(kVar.o, kVar.k);
                                    }
                                }
                                kVar.o.f();
                                break;
                            } else {
                                throw new IllegalStateException("Already have resource");
                            }
                        } else {
                            throw new IllegalStateException("Received a resource without any callbacks to notify");
                        }
                    } else {
                        kVar.j.d();
                        break;
                    }
                case 2:
                    kVar.d();
                    return true;
                case 3:
                    kVar.f1161b.a();
                    if (kVar.q) {
                        kVar.f1162c.a(kVar, kVar.e);
                        break;
                    } else {
                        throw new IllegalStateException("Not cancelled");
                    }
                default:
                    throw new IllegalStateException("Unrecognized message: " + message.what);
            }
            kVar.c();
            return true;
        }
    }

    k(com.bumptech.glide.load.b.c.a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, l lVar, Pools.Pool<k<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, lVar, pool, r);
    }

    @VisibleForTesting
    private k(com.bumptech.glide.load.b.c.a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, l lVar, Pools.Pool<k<?>> pool, a aVar5) {
        this.f1160a = new ArrayList(2);
        this.f1161b = new c.b();
        this.d = aVar;
        this.y = aVar2;
        this.z = aVar3;
        this.A = aVar4;
        this.f1162c = lVar;
        this.w = pool;
        this.x = aVar5;
    }

    @VisibleForTesting
    private k<R> a(com.bumptech.glide.load.g gVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.e = gVar;
        this.f = z2;
        this.g = z3;
        this.h = z4;
        this.i = z5;
        return this;
    }

    private void b(g<R> gVar) {
        this.p = gVar;
        g.C0015g a2 = gVar.a(g.C0015g.INITIALIZE);
        (a2 == g.C0015g.RESOURCE_CACHE || a2 == g.C0015g.DATA_CACHE ? this.d : a()).execute(gVar);
    }

    private void c(h hVar) {
        com.bumptech.glide.util.k.a();
        this.f1161b.a();
        if (this.l || this.m) {
            if (this.n == null) {
                this.n = new ArrayList(2);
            }
            if (!this.n.contains(hVar)) {
                this.n.add(hVar);
                return;
            }
            return;
        }
        this.f1160a.remove(hVar);
        if (this.f1160a.isEmpty() && !this.m && !this.l && !this.q) {
            this.q = true;
            g<R> gVar = this.p;
            gVar.t = true;
            e eVar = gVar.s;
            if (eVar != null) {
                eVar.b();
            }
            this.f1162c.a(this, this.e);
        }
    }

    private void d(h hVar) {
        if (this.n == null) {
            this.n = new ArrayList(2);
        }
        if (!this.n.contains(hVar)) {
            this.n.add(hVar);
        }
    }

    private boolean e() {
        return this.i;
    }

    private void f() {
        if (!this.m && !this.l && !this.q) {
            this.q = true;
            g<R> gVar = this.p;
            gVar.t = true;
            e eVar = gVar.s;
            if (eVar != null) {
                eVar.b();
            }
            this.f1162c.a(this, this.e);
        }
    }

    private boolean g() {
        return this.q;
    }

    private void h() {
        this.f1161b.a();
        if (this.q) {
            this.j.d();
        } else if (this.f1160a.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else if (this.l) {
            throw new IllegalStateException("Already have resource");
        } else {
            this.o = new o<>(this.j, this.f, true);
            this.l = true;
            this.o.e();
            this.f1162c.a(this, this.e, this.o);
            int size = this.f1160a.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = this.f1160a.get(i2);
                if (!b(hVar)) {
                    this.o.e();
                    hVar.a(this.o, this.k);
                }
            }
            this.o.f();
        }
        c();
    }

    private void i() {
        this.f1161b.a();
        if (!this.q) {
            throw new IllegalStateException("Not cancelled");
        }
        this.f1162c.a(this, this.e);
        c();
    }

    public final com.bumptech.glide.load.b.c.a a() {
        return this.g ? this.z : this.h ? this.A : this.y;
    }

    public final void a(g<?> gVar) {
        a().execute(gVar);
    }

    public final void a(p pVar) {
        this.B = pVar;
        s.obtainMessage(2, this).sendToTarget();
    }

    public final void a(u<R> uVar, com.bumptech.glide.load.a aVar) {
        this.j = uVar;
        this.k = aVar;
        s.obtainMessage(1, this).sendToTarget();
    }

    public final void a(h hVar) {
        com.bumptech.glide.util.k.a();
        this.f1161b.a();
        if (this.l) {
            hVar.a(this.o, this.k);
        } else if (this.m) {
            hVar.a(this.B);
        } else {
            this.f1160a.add(hVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b(h hVar) {
        return this.n != null && this.n.contains(hVar);
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        com.bumptech.glide.util.k.a();
        this.f1160a.clear();
        this.e = null;
        this.o = null;
        this.j = null;
        if (this.n != null) {
            this.n.clear();
        }
        this.m = false;
        this.q = false;
        this.l = false;
        g<R> gVar = this.p;
        if (gVar.d.a(false)) {
            gVar.a();
        }
        this.p = null;
        this.B = null;
        this.k = null;
        this.w.release(this);
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        this.f1161b.a();
        if (this.q) {
            c();
        } else if (this.f1160a.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        } else if (this.m) {
            throw new IllegalStateException("Already failed once");
        } else {
            this.m = true;
            this.f1162c.a(this, this.e, (o<?>) null);
            for (h next : this.f1160a) {
                if (!b(next)) {
                    next.a(this.B);
                }
            }
            c();
        }
    }

    @NonNull
    public final c g_() {
        return this.f1161b;
    }
}

package com.bumptech.glide.load.b;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools;
import com.bumptech.glide.util.a.a;
import com.bumptech.glide.util.a.c;
import com.bumptech.glide.util.i;

final class t<Z> implements u<Z>, a.c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pools.Pool<t<?>> f1175a = a.a(20, new a.C0023a<t<?>>() {
        private static t<?> b() {
            return new t<>();
        }

        public final /* synthetic */ Object a() {
            return new t();
        }
    });

    /* renamed from: b  reason: collision with root package name */
    private final c f1176b = new c.b();

    /* renamed from: c  reason: collision with root package name */
    private u<Z> f1177c;
    private boolean d;
    private boolean e;

    t() {
    }

    @NonNull
    static <Z> t<Z> a(u<Z> uVar) {
        t<Z> tVar = (t) i.a(f1175a.acquire(), "Argument must not be null");
        tVar.e = false;
        tVar.d = true;
        tVar.f1177c = uVar;
        return tVar;
    }

    private void b(u<Z> uVar) {
        this.e = false;
        this.d = true;
        this.f1177c = uVar;
    }

    private void f() {
        this.f1177c = null;
        f1175a.release(this);
    }

    @NonNull
    public final Class<Z> a() {
        return this.f1177c.a();
    }

    @NonNull
    public final Z b() {
        return this.f1177c.b();
    }

    public final int c() {
        return this.f1177c.c();
    }

    public final synchronized void d() {
        this.f1176b.a();
        this.e = true;
        if (!this.d) {
            this.f1177c.d();
            this.f1177c = null;
            f1175a.release(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void e() {
        this.f1176b.a();
        if (!this.d) {
            throw new IllegalStateException("Already unlocked");
        }
        this.d = false;
        if (this.e) {
            d();
        }
    }

    @NonNull
    public final c g_() {
        return this.f1176b;
    }
}

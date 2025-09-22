package com.bumptech.glide.load.b;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.i;

public final class o<Z> implements u<Z> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f1164a;

    /* renamed from: b  reason: collision with root package name */
    final u<Z> f1165b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1166c;
    private a d;
    private g e;
    private int f;
    private boolean g;

    interface a {
        void a(g gVar, o<?> oVar);
    }

    public o(u<Z> uVar, boolean z, boolean z2) {
        this.f1165b = (u) i.a(uVar, "Argument must not be null");
        this.f1164a = z;
        this.f1166c = z2;
    }

    private u<Z> g() {
        return this.f1165b;
    }

    private boolean h() {
        return this.f1164a;
    }

    @NonNull
    public final Class<Z> a() {
        return this.f1165b.a();
    }

    /* access modifiers changed from: package-private */
    public final void a(g gVar, a aVar) {
        this.e = gVar;
        this.d = aVar;
    }

    @NonNull
    public final Z b() {
        return this.f1165b.b();
    }

    public final int c() {
        return this.f1165b.c();
    }

    public final void d() {
        if (this.f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (this.g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        } else {
            this.g = true;
            if (this.f1166c) {
                this.f1165b.d();
            }
        }
    }

    public final void e() {
        if (this.g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        } else {
            this.f++;
        }
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        if (this.f <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new IllegalThreadStateException("Must call release on the main thread");
        } else {
            int i = this.f - 1;
            this.f = i;
            if (i == 0) {
                this.d.a(this.e, this);
            }
        }
    }

    public final String toString() {
        return "EngineResource{isCacheable=" + this.f1164a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.f1165b + '}';
    }
}

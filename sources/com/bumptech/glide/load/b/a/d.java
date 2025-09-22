package com.bumptech.glide.load.b.a;

import com.bumptech.glide.load.b.a.m;
import com.bumptech.glide.util.k;
import java.util.Queue;

abstract class d<T extends m> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1021a = 20;

    /* renamed from: b  reason: collision with root package name */
    private final Queue<T> f1022b = k.a(20);

    d() {
    }

    /* access modifiers changed from: package-private */
    public abstract T a();

    public final void a(T t) {
        if (this.f1022b.size() < 20) {
            this.f1022b.offer(t);
        }
    }

    /* access modifiers changed from: package-private */
    public final T b() {
        T t = (m) this.f1022b.poll();
        return t == null ? a() : t;
    }
}

package com.bumptech.glide.request.a;

import com.bumptech.glide.load.a;
import com.bumptech.glide.request.a.j;

public final class i<R> implements g<R> {

    /* renamed from: a  reason: collision with root package name */
    private final j.a f1455a;

    /* renamed from: b  reason: collision with root package name */
    private j<R> f1456b;

    public i(j.a aVar) {
        this.f1455a = aVar;
    }

    public final f<R> a(a aVar, boolean z) {
        if (aVar == a.MEMORY_CACHE || !z) {
            return e.b();
        }
        if (this.f1456b == null) {
            this.f1456b = new j<>(this.f1455a);
        }
        return this.f1456b;
    }
}

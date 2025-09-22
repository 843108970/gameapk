package com.bumptech.glide.e;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.bumptech.glide.util.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayMap<h, List<Class<?>>> f938a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<h> f939b = new AtomicReference<>();

    private void a() {
        synchronized (this.f938a) {
            this.f938a.clear();
        }
    }

    private void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull List<Class<?>> list) {
        synchronized (this.f938a) {
            this.f938a.put(new h(cls, cls2), list);
        }
    }

    @Nullable
    public final List<Class<?>> a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        List<Class<?>> list;
        h andSet = this.f939b.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new h(cls, cls2);
        } else {
            andSet.a(cls, cls2, (Class<?>) null);
        }
        synchronized (this.f938a) {
            list = this.f938a.get(andSet);
        }
        this.f939b.set(andSet);
        return list;
    }
}

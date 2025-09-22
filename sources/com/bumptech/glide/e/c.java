package com.bumptech.glide.e;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pools;
import com.bumptech.glide.load.b.h;
import com.bumptech.glide.load.b.s;
import com.bumptech.glide.load.d.f.g;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final s<?, ?, ?> f935a = new s(Object.class, Object.class, Object.class, Collections.singletonList(new h(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), (Pools.Pool<List<Throwable>>) null)), (Pools.Pool<List<Throwable>>) null);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<com.bumptech.glide.util.h, s<?, ?, ?>> f936b = new ArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<com.bumptech.glide.util.h> f937c = new AtomicReference<>();

    private void a(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable s<?, ?, ?> sVar) {
        synchronized (this.f936b) {
            ArrayMap<com.bumptech.glide.util.h, s<?, ?, ?>> arrayMap = this.f936b;
            com.bumptech.glide.util.h hVar = new com.bumptech.glide.util.h(cls, cls2, cls3);
            if (sVar == null) {
                sVar = f935a;
            }
            arrayMap.put(hVar, sVar);
        }
    }

    public static boolean a(@Nullable s<?, ?, ?> sVar) {
        return f935a.equals(sVar);
    }

    private com.bumptech.glide.util.h b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        com.bumptech.glide.util.h andSet = this.f937c.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new com.bumptech.glide.util.h();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    @Nullable
    public final <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        s<Data, TResource, Transcode> sVar;
        com.bumptech.glide.util.h andSet = this.f937c.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new com.bumptech.glide.util.h();
        }
        andSet.a(cls, cls2, cls3);
        synchronized (this.f936b) {
            sVar = this.f936b.get(andSet);
        }
        this.f937c.set(andSet);
        return sVar;
    }
}

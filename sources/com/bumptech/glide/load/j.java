package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.bumptech.glide.load.i;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

public final class j implements g {

    /* renamed from: c  reason: collision with root package name */
    private final ArrayMap<i<?>, Object> f1392c = new CachedHashCodeArrayMap();

    private static <T> void a(@NonNull i<T> iVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        i.a<T> aVar = iVar.f1390b;
        if (iVar.d == null) {
            iVar.d = iVar.f1391c.getBytes(g.f1387b);
        }
        aVar.a(iVar.d, obj, messageDigest);
    }

    @NonNull
    public final <T> j a(@NonNull i<T> iVar, @NonNull T t) {
        this.f1392c.put(iVar, t);
        return this;
    }

    @Nullable
    public final <T> T a(@NonNull i<T> iVar) {
        return this.f1392c.containsKey(iVar) ? this.f1392c.get(iVar) : iVar.f1389a;
    }

    public final void a(@NonNull j jVar) {
        this.f1392c.putAll(jVar.f1392c);
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        for (int i = 0; i < this.f1392c.size(); i++) {
            i keyAt = this.f1392c.keyAt(i);
            Object valueAt = this.f1392c.valueAt(i);
            i.a<T> aVar = keyAt.f1390b;
            if (keyAt.d == null) {
                keyAt.d = keyAt.f1391c.getBytes(g.f1387b);
            }
            aVar.a(keyAt.d, valueAt, messageDigest);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f1392c.equals(((j) obj).f1392c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1392c.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.f1392c + '}';
    }
}

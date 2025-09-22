package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f1505a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f1506b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f1507c;

    public h() {
    }

    public h(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        a(cls, cls2, (Class<?>) null);
    }

    public h(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    private void a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        a(cls, cls2, (Class<?>) null);
    }

    public final void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f1505a = cls;
        this.f1506b = cls2;
        this.f1507c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f1505a.equals(hVar.f1505a) && this.f1506b.equals(hVar.f1506b) && k.a((Object) this.f1507c, (Object) hVar.f1507c);
    }

    public final int hashCode() {
        return (((this.f1505a.hashCode() * 31) + this.f1506b.hashCode()) * 31) + (this.f1507c != null ? this.f1507c.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f1505a + ", second=" + this.f1506b + '}';
    }
}

package com.bumptech.glide.load.b;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.j;
import com.bumptech.glide.util.i;
import java.security.MessageDigest;
import java.util.Map;

public final class m implements g {

    /* renamed from: c  reason: collision with root package name */
    private final Object f1163c;
    private final int d;
    private final int e;
    private final Class<?> f;
    private final Class<?> g;
    private final g h;
    private final Map<Class<?>, com.bumptech.glide.load.m<?>> i;
    private final j j;
    private int k;

    public m(Object obj, g gVar, int i2, int i3, Map<Class<?>, com.bumptech.glide.load.m<?>> map, Class<?> cls, Class<?> cls2, j jVar) {
        this.f1163c = i.a(obj, "Argument must not be null");
        this.h = (g) i.a(gVar, "Signature must not be null");
        this.d = i2;
        this.e = i3;
        this.i = (Map) i.a(map, "Argument must not be null");
        this.f = (Class) i.a(cls, "Resource class must not be null");
        this.g = (Class) i.a(cls2, "Transcode class must not be null");
        this.j = (j) i.a(jVar, "Argument must not be null");
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            return this.f1163c.equals(mVar.f1163c) && this.h.equals(mVar.h) && this.e == mVar.e && this.d == mVar.d && this.i.equals(mVar.i) && this.f.equals(mVar.f) && this.g.equals(mVar.g) && this.j.equals(mVar.j);
        }
    }

    public final int hashCode() {
        if (this.k == 0) {
            this.k = this.f1163c.hashCode();
            this.k = (this.k * 31) + this.h.hashCode();
            this.k = (this.k * 31) + this.d;
            this.k = (this.k * 31) + this.e;
            this.k = (this.k * 31) + this.i.hashCode();
            this.k = (this.k * 31) + this.f.hashCode();
            this.k = (this.k * 31) + this.g.hashCode();
            this.k = (this.k * 31) + this.j.hashCode();
        }
        return this.k;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f1163c + ", width=" + this.d + ", height=" + this.e + ", resourceClass=" + this.f + ", transcodeClass=" + this.g + ", signature=" + this.h + ", hashCode=" + this.k + ", transformations=" + this.i + ", options=" + this.j + '}';
    }
}

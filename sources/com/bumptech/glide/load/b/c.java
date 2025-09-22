package com.bumptech.glide.load.b;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.g;
import java.security.MessageDigest;

final class c implements g {

    /* renamed from: c  reason: collision with root package name */
    private final g f1089c;
    private final g d;

    c(g gVar, g gVar2) {
        this.f1089c = gVar;
        this.d = gVar2;
    }

    private g a() {
        return this.f1089c;
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        this.f1089c.a(messageDigest);
        this.d.a(messageDigest);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f1089c.equals(cVar.f1089c) && this.d.equals(cVar.d);
        }
    }

    public final int hashCode() {
        return (this.f1089c.hashCode() * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f1089c + ", signature=" + this.d + '}';
    }
}

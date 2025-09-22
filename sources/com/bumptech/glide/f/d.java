package com.bumptech.glide.f;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.i;
import java.security.MessageDigest;

public final class d implements g {

    /* renamed from: c  reason: collision with root package name */
    private final Object f955c;

    public d(@NonNull Object obj) {
        this.f955c = i.a(obj, "Argument must not be null");
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f955c.toString().getBytes(f1387b));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f955c.equals(((d) obj).f955c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f955c.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.f955c + '}';
    }
}

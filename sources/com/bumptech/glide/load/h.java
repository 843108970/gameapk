package com.bumptech.glide.load;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.u;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

public final class h<T> implements m<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Collection<? extends m<T>> f1388c;

    private h(@NonNull Collection<? extends m<T>> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f1388c = collection;
    }

    @SafeVarargs
    public h(@NonNull m<T>... mVarArr) {
        if (mVarArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f1388c = Arrays.asList(mVarArr);
    }

    @NonNull
    public final u<T> a(@NonNull Context context, @NonNull u<T> uVar, int i, int i2) {
        u<T> uVar2 = uVar;
        for (m a2 : this.f1388c) {
            u<T> a3 = a2.a(context, uVar2, i, i2);
            if (uVar2 != null && !uVar2.equals(uVar) && !uVar2.equals(a3)) {
                uVar2.d();
            }
            uVar2 = a3;
        }
        return uVar2;
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        for (m a2 : this.f1388c) {
            a2.a(messageDigest);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f1388c.equals(((h) obj).f1388c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1388c.hashCode();
    }
}

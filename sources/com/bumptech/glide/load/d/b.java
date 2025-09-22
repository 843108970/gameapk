package com.bumptech.glide.load.d;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.m;
import java.security.MessageDigest;

public final class b<T> implements m<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final m<?> f1339c = new b();

    private b() {
    }

    @NonNull
    public static <T> b<T> a() {
        return (b) f1339c;
    }

    @NonNull
    public final u<T> a(@NonNull Context context, @NonNull u<T> uVar, int i, int i2) {
        return uVar;
    }

    public final void a(@NonNull MessageDigest messageDigest) {
    }
}

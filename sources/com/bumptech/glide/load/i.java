package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.security.MessageDigest;

public final class i<T> {
    private static final a<Object> e = new a<Object>() {
        public final void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final T f1389a;

    /* renamed from: b  reason: collision with root package name */
    final a<T> f1390b;

    /* renamed from: c  reason: collision with root package name */
    final String f1391c;
    volatile byte[] d;

    public interface a<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    private i(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        this.f1391c = com.bumptech.glide.util.i.a(str);
        this.f1389a = t;
        this.f1390b = (a) com.bumptech.glide.util.i.a(aVar, "Argument must not be null");
    }

    @NonNull
    public static <T> i<T> a(@NonNull String str) {
        return new i<>(str, (Object) null, e);
    }

    @NonNull
    private static <T> i<T> a(@NonNull String str, @NonNull a<T> aVar) {
        return new i<>(str, (Object) null, aVar);
    }

    @NonNull
    public static <T> i<T> a(@NonNull String str, @NonNull T t) {
        return new i<>(str, t, e);
    }

    @NonNull
    public static <T> i<T> a(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        return new i<>(str, t, aVar);
    }

    @Nullable
    private T a() {
        return this.f1389a;
    }

    private void a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        a<T> aVar = this.f1390b;
        if (this.d == null) {
            this.d = this.f1391c.getBytes(g.f1387b);
        }
        aVar.a(this.d, t, messageDigest);
    }

    @NonNull
    private byte[] b() {
        if (this.d == null) {
            this.d = this.f1391c.getBytes(g.f1387b);
        }
        return this.d;
    }

    @NonNull
    private static <T> a<T> c() {
        return e;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f1391c.equals(((i) obj).f1391c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1391c.hashCode();
    }

    public final String toString() {
        return "Option{key='" + this.f1391c + '\'' + '}';
    }
}

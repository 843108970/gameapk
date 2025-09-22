package com.android.volley;

import com.android.volley.b;

public final class n<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f500a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f501b;

    /* renamed from: c  reason: collision with root package name */
    public final s f502c;
    public boolean d;

    public interface a {
        void a(s sVar);
    }

    public interface b<T> {
        void a(T t);
    }

    private n(s sVar) {
        this.d = false;
        this.f500a = null;
        this.f501b = null;
        this.f502c = sVar;
    }

    private n(T t, b.a aVar) {
        this.d = false;
        this.f500a = t;
        this.f501b = aVar;
        this.f502c = null;
    }

    public static <T> n<T> a(s sVar) {
        return new n<>(sVar);
    }

    public static <T> n<T> a(T t, b.a aVar) {
        return new n<>(t, aVar);
    }

    private boolean a() {
        return this.f502c == null;
    }
}

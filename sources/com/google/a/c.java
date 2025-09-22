package com.google.a;

import com.google.a.c.a;
import com.google.a.c.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final b f3052a;

    /* renamed from: b  reason: collision with root package name */
    private b f3053b;

    public c(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f3052a = bVar;
    }

    private a a(int i, a aVar) throws m {
        return this.f3052a.a(i, aVar);
    }

    private boolean d() {
        return this.f3052a.f3002a.b();
    }

    private boolean e() {
        return this.f3052a.f3002a.c();
    }

    private c f() {
        return new c(this.f3052a.a(this.f3052a.f3002a.e()));
    }

    private c g() {
        return new c(this.f3052a.a(this.f3052a.f3002a.f()));
    }

    public final int a() {
        return this.f3052a.f3002a.f3346a;
    }

    public final c a(int i, int i2, int i3, int i4) {
        return new c(this.f3052a.a(this.f3052a.f3002a.a(i, i2, i3, i4)));
    }

    public final int b() {
        return this.f3052a.f3002a.f3347b;
    }

    public final b c() throws m {
        if (this.f3053b == null) {
            this.f3053b = this.f3052a.a();
        }
        return this.f3053b;
    }

    public final String toString() {
        try {
            return c().toString();
        } catch (m unused) {
            return "";
        }
    }
}

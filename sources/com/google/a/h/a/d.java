package com.google.a.h.a;

final class d {
    private static final int f = -1;

    /* renamed from: a  reason: collision with root package name */
    final int f3248a;

    /* renamed from: b  reason: collision with root package name */
    final int f3249b;

    /* renamed from: c  reason: collision with root package name */
    final int f3250c;
    final int d;
    int e = -1;

    d(int i, int i2, int i3, int i4) {
        this.f3248a = i;
        this.f3249b = i2;
        this.f3250c = i3;
        this.d = i4;
    }

    private void b(int i) {
        this.e = i;
    }

    private int d() {
        return this.f3248a;
    }

    private int e() {
        return this.f3249b;
    }

    private int f() {
        return this.f3250c;
    }

    private int g() {
        return this.d;
    }

    private int h() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return a(this.e);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i) {
        return i != -1 && this.f3250c == (i % 3) * 3;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.e = ((this.d / 30) * 3) + (this.f3250c / 3);
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        return this.f3249b - this.f3248a;
    }

    public final String toString() {
        return this.e + "|" + this.d;
    }
}

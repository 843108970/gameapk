package com.google.a;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f3139a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3140b;

    private f(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.f3139a = i;
        this.f3140b = i2;
    }

    private int a() {
        return this.f3139a;
    }

    private int b() {
        return this.f3140b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.f3139a == fVar.f3139a && this.f3140b == fVar.f3140b;
        }
    }

    public final int hashCode() {
        return (this.f3139a * 32713) + this.f3140b;
    }

    public final String toString() {
        return this.f3139a + "x" + this.f3140b;
    }
}

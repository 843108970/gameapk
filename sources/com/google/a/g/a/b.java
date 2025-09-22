package com.google.a.g.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f3182a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3183b;

    public b(int i, int i2) {
        this.f3182a = i;
        this.f3183b = i2;
    }

    private int a() {
        return this.f3182a;
    }

    private int b() {
        return this.f3183b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3182a == bVar.f3182a && this.f3183b == bVar.f3183b;
    }

    public final int hashCode() {
        return this.f3182a ^ this.f3183b;
    }

    public final String toString() {
        return this.f3182a + "(" + this.f3183b + ')';
    }
}

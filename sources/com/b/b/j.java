package com.b.b;

public abstract class j implements x {

    /* renamed from: a  reason: collision with root package name */
    private final x f859a;

    public j(x xVar) {
        if (xVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f859a = xVar;
    }

    public final long a(f fVar, long j) {
        return this.f859a.a(fVar, j);
    }

    public final y a() {
        return this.f859a.a();
    }

    public void close() {
        this.f859a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f859a.toString() + ")";
    }
}

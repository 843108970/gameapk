package org.jdeferred.b;

import org.jdeferred.p;

public final class d extends b {
    private final int d;
    private final p e;
    private final Object f;

    public d(int i, int i2, int i3, int i4, p pVar, Object obj) {
        super(i, i2, i3);
        this.d = i4;
        this.e = pVar;
        this.f = obj;
    }

    private int a() {
        return this.d;
    }

    private p b() {
        return this.e;
    }

    private Object c() {
        return this.f;
    }

    public final String toString() {
        return "OneProgress [index=" + this.d + ", promise=" + this.e + ", progress=" + this.f + ", getDone()=" + this.f4406a + ", getFail()=" + this.f4407b + ", getTotal()=" + this.f4408c + "]";
    }
}

package com.b.a;

import com.b.b.i;

final class k {

    /* renamed from: a  reason: collision with root package name */
    final String f812a;

    /* renamed from: b  reason: collision with root package name */
    final String f813b;

    /* renamed from: c  reason: collision with root package name */
    final String f814c;
    final i d;

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f812a.equals(kVar.f812a) && this.f814c.equals(kVar.f814c) && this.d.equals(kVar.d);
    }

    public final int hashCode() {
        return ((((this.f812a.hashCode() + 527) * 31) + this.f814c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return this.f814c + this.d.b();
    }
}

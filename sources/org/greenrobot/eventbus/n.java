package org.greenrobot.eventbus;

final class n {

    /* renamed from: a  reason: collision with root package name */
    final Object f4334a;

    /* renamed from: b  reason: collision with root package name */
    final l f4335b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f4336c = true;

    n(Object obj, l lVar) {
        this.f4334a = obj;
        this.f4335b = lVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            return this.f4334a == nVar.f4334a && this.f4335b.equals(nVar.f4335b);
        }
    }

    public final int hashCode() {
        return this.f4334a.hashCode() + this.f4335b.f.hashCode();
    }
}

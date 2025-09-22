package org.a;

import org.a.b.b;

public abstract class p<T> extends b<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final b f4279a = new b("matchesSafely", 1);

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f4280b;

    protected p() {
        this(f4279a);
    }

    private p(Class<?> cls) {
        this.f4280b = cls;
    }

    private p(b bVar) {
        this.f4280b = bVar.a(getClass());
    }

    public final void a(Object obj, g gVar) {
        if (obj == null) {
            super.a(obj, gVar);
        } else if (!this.f4280b.isInstance(obj)) {
            gVar.a("was a ").a(obj.getClass().getName()).a(" (").a(obj).a(")");
        } else {
            b(obj, gVar);
        }
    }

    public final boolean a(Object obj) {
        return obj != null && this.f4280b.isInstance(obj) && b(obj);
    }

    public void b(T t, g gVar) {
        super.a(t, gVar);
    }

    public abstract boolean b(T t);
}

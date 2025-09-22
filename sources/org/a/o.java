package org.a;

import org.a.b.b;
import org.a.g;

public abstract class o<T> extends b<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final b f4277a = new b("matchesSafely", 2);

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f4278b;

    protected o() {
        this(f4277a);
    }

    private o(Class<?> cls) {
        this.f4278b = cls;
    }

    protected o(b bVar) {
        this.f4278b = bVar.a(getClass());
    }

    public final void a(Object obj, g gVar) {
        if (obj == null || !this.f4278b.isInstance(obj)) {
            super.a(obj, gVar);
        } else {
            b(obj, gVar);
        }
    }

    public final boolean a(Object obj) {
        return obj != null && this.f4278b.isInstance(obj) && b(obj, new g.a());
    }

    public abstract boolean b(T t, g gVar);
}

package org.a.a;

import org.a.b;
import org.a.i;
import org.a.k;

public final class g<T> extends b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f4251a;

    public g() {
        this("ANYTHING");
    }

    public g(String str) {
        this.f4251a = str;
    }

    @i
    private static k<Object> a(String str) {
        return new g(str);
    }

    @i
    private static k<Object> b() {
        return new g();
    }

    public final boolean a(Object obj) {
        return true;
    }

    public final void describeTo(org.a.g gVar) {
        gVar.a(this.f4251a);
    }
}

package org.junit.runner;

import org.junit.e.a.e;
import org.junit.e.a.h;
import org.junit.e.g;

public class a {
    private static a a() {
        return new a();
    }

    public k a(h hVar, Class<?> cls) throws Throwable {
        return hVar.a(cls);
    }

    public k a(final h hVar, Class<?>[] clsArr) throws e {
        return new g((h) new h() {
            public final k a(Class<?> cls) throws Throwable {
                return a.this.a(hVar, cls);
            }
        }, clsArr);
    }
}

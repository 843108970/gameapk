package org.junit.runner;

import java.util.Comparator;
import org.junit.b.c.a;
import org.junit.b.c.c;
import org.junit.b.d.b;
import org.junit.e.a.e;

public abstract class h {
    public static h a(Class<?> cls) {
        return new a(cls);
    }

    private static h a(Class<?> cls, String str) {
        return a(cls).a(org.junit.runner.a.a.b(c.createTestDescription(cls, str)));
    }

    private static h a(Class<?> cls, Throwable th) {
        return a((k) new b(cls, th));
    }

    private h a(Comparator<c> comparator) {
        return new c(this, comparator);
    }

    public static h a(a aVar, Class<?>... clsArr) {
        try {
            return a(aVar.a((org.junit.e.a.h) new org.junit.b.a.a(true), clsArr));
        } catch (e unused) {
            throw new RuntimeException("Bug in saff's brain: Suite constructor, called as above, should always complete");
        }
    }

    private h a(c cVar) {
        return a(org.junit.runner.a.a.b(cVar));
    }

    public static h a(final k kVar) {
        return new h() {
            public final k a() {
                return kVar;
            }
        };
    }

    private static h a(Class<?>... clsArr) {
        return a(JUnitCore.a(), clsArr);
    }

    private static h b(Class<?> cls) {
        return new a(cls, false);
    }

    public final h a(org.junit.runner.a.a aVar) {
        return new org.junit.b.c.b(this, aVar);
    }

    public abstract k a();
}

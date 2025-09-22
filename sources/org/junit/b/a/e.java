package org.junit.b.a;

import junit.b.j;
import org.junit.e.a.h;
import org.junit.runner.k;

public final class e extends h {
    private static boolean c(Class<?> cls) {
        return j.class.isAssignableFrom(cls);
    }

    public final k a(Class<?> cls) throws Throwable {
        if (j.class.isAssignableFrom(cls)) {
            return new org.junit.b.d.e(cls);
        }
        return null;
    }
}

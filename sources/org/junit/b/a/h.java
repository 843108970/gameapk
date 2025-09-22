package org.junit.b.a;

import junit.runner.a;
import org.junit.b.d.i;
import org.junit.runner.k;

public final class h extends org.junit.e.a.h {
    private static boolean c(Class<?> cls) {
        try {
            cls.getMethod(a.f4043a, new Class[0]);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public final k a(Class<?> cls) throws Throwable {
        if (c(cls)) {
            return new i(cls);
        }
        return null;
    }
}

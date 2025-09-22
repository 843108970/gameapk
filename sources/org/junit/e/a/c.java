package org.junit.e.a;

import java.lang.reflect.Modifier;
import java.util.List;
import org.junit.e.a.c;

public abstract class c<T extends c<T>> implements a {
    private boolean a(List<T> list) {
        for (T a2 : list) {
            if (a(a2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a(T t);

    public abstract String b();

    /* access modifiers changed from: protected */
    public abstract int c();

    public abstract Class<?> d();

    public abstract Class<?> e();

    public final boolean f() {
        return Modifier.isStatic(c());
    }

    public final boolean g() {
        return Modifier.isPublic(c());
    }
}

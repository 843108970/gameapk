package org.junit.b.b;

import java.lang.reflect.Method;
import org.a.b;
import org.junit.b.h;

@Deprecated
public abstract class d<T> extends b<T> {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f4464a;

    protected d() {
        for (Class cls = getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            for (Method method : h.a((Class<?>) cls)) {
                boolean z = true;
                if ((!method.getName().equals("matchesSafely") || method.getParameterTypes().length != 1 || method.isSynthetic()) ? false : z) {
                    this.f4464a = method.getParameterTypes()[0];
                    return;
                }
            }
        }
        throw new Error("Cannot determine correct type for matchesSafely() method.");
    }

    private d(Class<T> cls) {
        this.f4464a = cls;
    }

    private static Class<?> a(Class<?> cls) {
        while (true) {
            Class<? super Object> cls2 = cls;
            if (cls2 != Object.class) {
                for (Method method : h.a(cls2)) {
                    boolean z = true;
                    if (!method.getName().equals("matchesSafely") || method.getParameterTypes().length != 1 || method.isSynthetic()) {
                        z = false;
                    }
                    if (z) {
                        return method.getParameterTypes()[0];
                    }
                }
                cls2 = cls2.getSuperclass();
            } else {
                throw new Error("Cannot determine correct type for matchesSafely() method.");
            }
        }
    }

    private static boolean a(Method method) {
        return method.getName().equals("matchesSafely") && method.getParameterTypes().length == 1 && !method.isSynthetic();
    }

    public final boolean a(Object obj) {
        return obj != null && this.f4464a.isInstance(obj) && b();
    }

    public abstract boolean b();
}

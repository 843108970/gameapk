package org.a.b;

import java.lang.reflect.Method;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f4262a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4263b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4264c = 0;

    public b(String str, int i) {
        this.f4262a = str;
        this.f4263b = i;
    }

    private boolean a(Method method) {
        return method.getName().equals(this.f4262a) && method.getParameterTypes().length == this.f4263b && !method.isSynthetic();
    }

    private Class<?> b(Method method) {
        return method.getParameterTypes()[this.f4264c];
    }

    public final Class<?> a(Class<?> cls) {
        while (true) {
            Class<? super Object> cls2 = cls;
            if (cls2 != Object.class) {
                for (Method method : cls2.getDeclaredMethods()) {
                    if (method.getName().equals(this.f4262a) && method.getParameterTypes().length == this.f4263b && !method.isSynthetic()) {
                        return method.getParameterTypes()[this.f4264c];
                    }
                }
                cls2 = cls2.getSuperclass();
            } else {
                throw new Error("Cannot determine correct type for " + this.f4262a + "() method.");
            }
        }
    }
}

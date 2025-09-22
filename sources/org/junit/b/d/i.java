package org.junit.b.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.runner.a;

public class i extends e {
    public i(Class<?> cls) throws Throwable {
        super(a(cls));
    }

    private static junit.b.i a(Class<?> cls) throws Throwable {
        try {
            Method method = cls.getMethod(a.f4043a, new Class[0]);
            if (Modifier.isStatic(method.getModifiers())) {
                return (junit.b.i) method.invoke((Object) null, new Object[0]);
            }
            throw new Exception(cls.getName() + ".suite() must be static");
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}

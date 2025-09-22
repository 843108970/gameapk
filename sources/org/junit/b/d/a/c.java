package org.junit.b.d.a;

import java.lang.reflect.InvocationTargetException;

public abstract class c {
    public final Object a() throws Throwable {
        try {
            return b();
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    public abstract Object b() throws Throwable;
}

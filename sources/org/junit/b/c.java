package org.junit.b;

public final class c {
    public static Class<?> a(String str) throws ClassNotFoundException {
        return Class.forName(str, true, Thread.currentThread().getContextClassLoader());
    }
}

package com.b.a.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private static final Method f594a;

    /* renamed from: b  reason: collision with root package name */
    private IOException f595b;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
            method = null;
        }
        f594a = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.f595b = iOException;
    }

    public final IOException a() {
        return this.f595b;
    }

    public final void a(IOException iOException) {
        IOException iOException2 = this.f595b;
        if (f594a != null) {
            try {
                f594a.invoke(iOException, new Object[]{iOException2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        this.f595b = iOException;
    }
}

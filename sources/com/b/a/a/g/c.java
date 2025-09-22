package com.b.a.a.g;

import java.lang.reflect.Method;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Method f723a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f724b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f725c;

    private c(Method method, Method method2, Method method3) {
        this.f723a = method;
        this.f724b = method2;
        this.f725c = method3;
    }

    static c a() {
        Method method;
        Method method2;
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls.getMethod("get", new Class[0]);
            method = cls.getMethod("open", new Class[]{String.class});
            method2 = cls.getMethod("warnIfOpen", new Class[0]);
            method3 = method4;
        } catch (Exception unused) {
            method2 = null;
            method = null;
        }
        return new c(method3, method, method2);
    }

    /* access modifiers changed from: package-private */
    public final Object a(String str) {
        if (this.f723a != null) {
            try {
                Object invoke = this.f723a.invoke((Object) null, new Object[0]);
                this.f724b.invoke(invoke, new Object[]{str});
                return invoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            this.f725c.invoke(obj, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

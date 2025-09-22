package com.zbar.a.a;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3994a = "d";

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3995b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f3996c;

    static {
        Object obj;
        String str;
        String str2;
        Method a2;
        Object a3;
        Class<?> a4;
        Method a5;
        Class<?> a6 = a("android.os.ServiceManager");
        Method method = null;
        if (a6 == null || (a2 = a(a6, "getService", (Class<?>[]) new Class[]{String.class})) == null || (a3 = a(a2, (Object) null, "hardware")) == null || (a4 = a("android.os.IHardwareService$Stub")) == null || (a5 = a(a4, "asInterface", (Class<?>[]) new Class[]{IBinder.class})) == null) {
            obj = null;
        } else {
            obj = a(a5, (Object) null, a3);
        }
        f3995b = obj;
        if (obj != null) {
            method = a(obj.getClass(), "setFlashlightEnabled", (Class<?>[]) new Class[]{Boolean.TYPE});
        }
        f3996c = method;
        if (f3995b == null) {
            str = f3994a;
            str2 = "This device does supports control of a flashlight";
        } else {
            str = f3994a;
            str2 = "This device does not support control of a flashlight";
        }
        Log.v(str, str2);
    }

    private d() {
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e) {
            String str2 = f3994a;
            Log.w(str2, "Unexpected error while finding class " + str, e);
            return null;
        }
    }

    private static Object a(Method method, Object obj, Object... objArr) {
        String str;
        StringBuilder sb;
        String str2;
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            e = e;
            str = f3994a;
            sb = new StringBuilder("Unexpected error while invoking ");
            sb.append(method);
            str2 = sb.toString();
            Log.w(str, str2, e);
            return null;
        } catch (InvocationTargetException e2) {
            str = f3994a;
            str2 = "Unexpected error while invoking " + method;
            e = e2.getCause();
            Log.w(str, str2, e);
            return null;
        } catch (RuntimeException e3) {
            e = e3;
            str = f3994a;
            sb = new StringBuilder("Unexpected error while invoking ");
            sb.append(method);
            str2 = sb.toString();
            Log.w(str, str2, e);
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (RuntimeException e) {
            String str2 = f3994a;
            Log.w(str2, "Unexpected error while finding method " + str, e);
            return null;
        }
    }

    private static Method a(Object obj) {
        if (obj == null) {
            return null;
        }
        return a(obj.getClass(), "setFlashlightEnabled", (Class<?>[]) new Class[]{Boolean.TYPE});
    }

    public static void a() {
        a(true);
    }

    private static void a(boolean z) {
        if (f3995b != null) {
            a(f3996c, f3995b, Boolean.valueOf(z));
        }
    }

    public static void b() {
        a(false);
    }

    private static Object c() {
        Method a2;
        Object a3;
        Class<?> a4;
        Method a5;
        Class<?> a6 = a("android.os.ServiceManager");
        if (a6 == null || (a2 = a(a6, "getService", (Class<?>[]) new Class[]{String.class})) == null || (a3 = a(a2, (Object) null, "hardware")) == null || (a4 = a("android.os.IHardwareService$Stub")) == null || (a5 = a(a4, "asInterface", (Class<?>[]) new Class[]{IBinder.class})) == null) {
            return null;
        }
        return a(a5, (Object) null, a3);
    }
}

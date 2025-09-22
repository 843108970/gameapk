package com.goldcoast.sdk.c;

import java.lang.reflect.Method;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f2949a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f2950b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f2951c;
    private static Method d;
    private static Method e;
    private static Method f;
    private static Method g;

    static {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            f2949a = cls;
            Method declaredMethod = cls.getDeclaredMethod("get", new Class[]{String.class});
            f2950b = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = f2949a.getDeclaredMethod("get", new Class[]{String.class, String.class});
            f2951c = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = f2949a.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
            d = declaredMethod3;
            declaredMethod3.setAccessible(true);
            Method declaredMethod4 = f2949a.getDeclaredMethod("getLong", new Class[]{String.class, Long.TYPE});
            e = declaredMethod4;
            declaredMethod4.setAccessible(true);
            Method declaredMethod5 = f2949a.getDeclaredMethod("getBoolean", new Class[]{String.class, Boolean.TYPE});
            f = declaredMethod5;
            declaredMethod5.setAccessible(true);
            Method declaredMethod6 = f2949a.getDeclaredMethod("set", new Class[]{String.class, String.class});
            g = declaredMethod6;
            declaredMethod6.setAccessible(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String a(String str) {
        try {
            return (String) f2950b.invoke((Object) null, new Object[]{str});
        } catch (Exception unused) {
            return null;
        }
    }
}

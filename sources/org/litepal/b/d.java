package org.litepal.b;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.litepal.c.e;

final class d {
    private d() {
    }

    static Object a(Object obj, String str, Class<?> cls) throws IllegalArgumentException, IllegalAccessException {
        Class<? super Object> cls2;
        while (true) {
            cls2 = cls;
            if (cls2 != e.class && cls2 != Object.class) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    return declaredField.get(obj);
                } catch (NoSuchFieldException unused) {
                    cls2 = cls2.getSuperclass();
                }
            }
        }
        throw new e(e.noSuchFieldExceptioin(cls2.getSimpleName(), str));
    }

    static Object a(Object obj, String str, Object[] objArr, Class<?> cls, Class<?>[] clsArr) throws SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        if (clsArr == null) {
            try {
                clsArr = new Class[0];
            } catch (NoSuchMethodException e) {
                throw new e(e.noSuchMethodException(cls.getSimpleName(), str), e);
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }

    static void a(Object obj, String str, Object obj2, Class<?> cls) throws SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    static void b(Object obj, String str, Object obj2, Class<?> cls) throws SecurityException, IllegalArgumentException, IllegalAccessException {
        Class<? super Object> cls2;
        while (true) {
            cls2 = cls;
            if (cls2 != e.class && cls2 != Object.class) {
                try {
                    a(obj, str, obj2, cls2);
                    return;
                } catch (NoSuchFieldException unused) {
                    cls2 = cls2.getSuperclass();
                }
            }
        }
        throw new e(e.noSuchFieldExceptioin(cls2.getSimpleName(), str));
    }
}

package org.junit.b.d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.b;
import org.junit.b.h;
import org.junit.f;
import org.junit.g;
import org.junit.m;

@Deprecated
public final class j {

    /* renamed from: a  reason: collision with root package name */
    final Class<?> f4521a;

    public j(Class<?> cls) {
        this.f4521a = cls;
    }

    private static boolean a(Method method, Method method2) {
        if (!method2.getName().equals(method.getName()) || method2.getParameterTypes().length != method.getParameterTypes().length) {
            return false;
        }
        for (int i = 0; i < method2.getParameterTypes().length; i++) {
            if (!method2.getParameterTypes()[i].equals(method.getParameterTypes()[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Method method, List<Method> list) {
        boolean z;
        Iterator<Method> it = list.iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            Method next = it.next();
            if (next.getName().equals(method.getName()) && next.getParameterTypes().length == method.getParameterTypes().length) {
                int i = 0;
                while (true) {
                    if (i >= next.getParameterTypes().length) {
                        z = true;
                        continue;
                        break;
                    } else if (!next.getParameterTypes()[i].equals(method.getParameterTypes()[i])) {
                        continue;
                        break;
                    } else {
                        i++;
                    }
                }
            }
        } while (!z);
        return true;
    }

    private List<Method> b() {
        return a(m.class);
    }

    private static boolean b(Class<? extends Annotation> cls) {
        return cls.equals(f.class) || cls.equals(g.class);
    }

    private List<Method> c() {
        return a(g.class);
    }

    private static List<Class<?>> c(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            arrayList.add(cls2);
        }
        return arrayList;
    }

    private List<Method> d() {
        return a(b.class);
    }

    private Class<?> e() {
        return this.f4521a;
    }

    private String f() {
        return this.f4521a.getName();
    }

    public final Constructor<?> a() throws SecurityException, NoSuchMethodException {
        return this.f4521a.getConstructor(new Class[0]);
    }

    public final List<Method> a(Class<? extends Annotation> cls) {
        int i;
        ArrayList arrayList = new ArrayList();
        Iterator<Class<?>> it = c(this.f4521a).iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            Method[] a2 = h.a(it.next());
            int length = a2.length;
            while (i < length) {
                Method method = a2[i];
                if (method.getAnnotation(cls) != null && !a(method, (List<Method>) arrayList)) {
                    arrayList.add(method);
                }
                i++;
            }
        }
        if (cls.equals(f.class) || cls.equals(g.class)) {
            i = 1;
        }
        if (i != 0) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }
}

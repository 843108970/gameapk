package org.junit.e.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.b.d.b;
import org.junit.runner.k;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<?>> f4571a = new HashSet();

    private List<k> a(Class<?> cls, List<Class<?>> list) throws e {
        return a(cls, (Class<?>[]) (Class[]) list.toArray(new Class[0]));
    }

    private List<k> a(Class<?>[] clsArr) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> b2 : clsArr) {
            k b3 = b(b2);
            if (b3 != null) {
                arrayList.add(b3);
            }
        }
        return arrayList;
    }

    private Class<?> c(Class<?> cls) throws e {
        if (this.f4571a.add(cls)) {
            return cls;
        }
        throw new e(String.format("class '%s' (possibly indirectly) contains itself as a SuiteClass", new Object[]{cls.getName()}));
    }

    private void d(Class<?> cls) {
        this.f4571a.remove(cls);
    }

    public final List<k> a(Class<?> cls, Class<?>[] clsArr) throws e {
        if (!this.f4571a.add(cls)) {
            throw new e(String.format("class '%s' (possibly indirectly) contains itself as a SuiteClass", new Object[]{cls.getName()}));
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (Class<?> b2 : clsArr) {
                k b3 = b(b2);
                if (b3 != null) {
                    arrayList.add(b3);
                }
            }
            return arrayList;
        } finally {
            d(cls);
        }
    }

    public abstract k a(Class<?> cls) throws Throwable;

    public final k b(Class<?> cls) {
        try {
            return a(cls);
        } catch (Throwable th) {
            return new b(cls, th);
        }
    }
}

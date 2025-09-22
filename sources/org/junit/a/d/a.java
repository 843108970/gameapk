package org.junit.a.d;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.junit.e.a.h;
import org.junit.e.g;

public final class a extends g {
    private a(Class<?> cls, h hVar) throws Throwable {
        super(hVar, cls, a(cls.getClasses()));
    }

    private static Class<?>[] a(Class<?>[] clsArr) {
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class<?> cls : clsArr) {
            if (!Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add(cls);
            }
        }
        return (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }
}

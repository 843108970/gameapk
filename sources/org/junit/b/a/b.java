package org.junit.b.a;

import java.lang.reflect.Modifier;
import org.junit.e.a.e;
import org.junit.e.a.h;
import org.junit.runner.j;
import org.junit.runner.k;

public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4458a = "Custom runner class %s should have a public constructor with signature %s(Class testClass)";

    /* renamed from: b  reason: collision with root package name */
    private final h f4459b;

    public b(h hVar) {
        this.f4459b = hVar;
    }

    private k a(Class<? extends k> cls, Class<?> cls2) throws Exception {
        try {
            return (k) cls.getConstructor(new Class[]{Class.class}).newInstance(new Object[]{cls2});
        } catch (NoSuchMethodException unused) {
            try {
                return (k) cls.getConstructor(new Class[]{Class.class, h.class}).newInstance(new Object[]{cls2, this.f4459b});
            } catch (NoSuchMethodException unused2) {
                String simpleName = cls.getSimpleName();
                throw new e(String.format(f4458a, new Object[]{simpleName, simpleName}));
            }
        }
    }

    private static Class<?> c(Class<?> cls) {
        if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return null;
        }
        return cls.getEnclosingClass();
    }

    public final k a(Class<?> cls) throws Exception {
        for (Class<?> cls2 = cls; cls2 != null; cls2 = (!cls2.isMemberClass() || Modifier.isStatic(cls2.getModifiers())) ? null : cls2.getEnclosingClass()) {
            j jVar = (j) cls2.getAnnotation(j.class);
            if (jVar != null) {
                return a(jVar.a(), cls);
            }
        }
        return null;
    }
}

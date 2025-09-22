package org.junit.f;

import java.util.concurrent.ConcurrentHashMap;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap<f, a> f4593a = new ConcurrentHashMap<>();

    public static a a(f fVar) {
        a aVar = f4593a.get(fVar);
        if (aVar != null) {
            return aVar;
        }
        Class<? extends a> a2 = fVar.a();
        if (a2 == null) {
            throw new IllegalArgumentException("Can't create validator, value is null in annotation " + fVar.getClass().getName());
        }
        try {
            f4593a.putIfAbsent(fVar, (a) a2.newInstance());
            return f4593a.get(fVar);
        } catch (Exception e) {
            throw new RuntimeException("Exception received when creating AnnotationValidator class " + a2.getName(), e);
        }
    }
}

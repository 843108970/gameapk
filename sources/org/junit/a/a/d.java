package org.junit.a.a;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.b;
import org.junit.f;
import org.junit.f.a;
import org.junit.g;

public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<Class<? extends Annotation>> f4113a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Class[]{g.class, b.class, f.class, org.junit.a.class})));

    private static void a(List<Exception> list, Class<?> cls) {
        list.add(new Exception(String.format("@%s can not be combined with @Category", new Object[]{cls.getSimpleName()})));
    }

    public final List<Exception> a(org.junit.e.a.d dVar) {
        ArrayList arrayList = new ArrayList();
        for (Annotation annotation : dVar.f4120a.getAnnotations()) {
            for (Class next : f4113a) {
                if (annotation.annotationType().isAssignableFrom(next)) {
                    arrayList.add(new Exception(String.format("@%s can not be combined with @Category", new Object[]{next.getSimpleName()})));
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}

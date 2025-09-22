package org.junit.f;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import org.junit.e.a.k;

public final class d implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Exception> f4596a = Collections.emptyList();

    public final List<Exception> a(k kVar) {
        if (Modifier.isPublic(kVar.f4122b.getModifiers())) {
            return f4596a;
        }
        return Collections.singletonList(new Exception("The class " + kVar.b() + " is not public."));
    }
}

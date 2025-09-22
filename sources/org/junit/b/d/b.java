package org.junit.b.d;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.e.a.e;
import org.junit.runner.b.a;
import org.junit.runner.c;
import org.junit.runner.k;

public final class b extends k {

    /* renamed from: a  reason: collision with root package name */
    private final List<Throwable> f4477a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f4478b;

    public b(Class<?> cls, Throwable th) {
        if (cls == null) {
            throw new NullPointerException("Test class cannot be null");
        }
        this.f4478b = cls;
        this.f4477a = a(th);
    }

    private static List<Throwable> a(Throwable th) {
        while (th instanceof InvocationTargetException) {
            th = th.getCause();
        }
        if (th instanceof e) {
            return ((e) th).getCauses();
        }
        if (th instanceof d) {
            return ((d) th).getCauses();
        }
        return Arrays.asList(new Throwable[]{th});
    }

    private c a() {
        return c.createTestDescription(this.f4478b, "initializationError");
    }

    private void a(Throwable th, org.junit.runner.b.c cVar) {
        c a2 = a();
        cVar.a(a2);
        cVar.a(new a(a2, th));
        cVar.c(a2);
    }

    public final void a(org.junit.runner.b.c cVar) {
        for (Throwable aVar : this.f4477a) {
            c a2 = a();
            cVar.a(a2);
            cVar.a(new a(a2, aVar));
            cVar.c(a2);
        }
    }

    public final c b() {
        c createSuiteDescription = c.createSuiteDescription(this.f4478b);
        Iterator<Throwable> it = this.f4477a.iterator();
        while (it.hasNext()) {
            it.next();
            createSuiteDescription.addChild(a());
        }
        return createSuiteDescription;
    }
}

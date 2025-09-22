package org.junit.a.b;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import junit.b.i;
import junit.b.n;
import org.junit.b.d.e;
import org.junit.e.g;
import org.junit.runner.JUnitCore;
import org.junit.runner.a.a;
import org.junit.runner.c;
import org.junit.runner.h;
import org.junit.runner.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4427a = "malformed JUnit 3 test class: ";

    /* renamed from: b  reason: collision with root package name */
    private final c f4428b;

    private b(File file) {
        this.f4428b = c.forFolder(file);
    }

    private static b a(File file) {
        return new b(file);
    }

    @Deprecated
    private static b a(String str) {
        return new b(new File(str));
    }

    private h a(List<c> list) {
        k kVar;
        h a2;
        final ArrayList arrayList = new ArrayList();
        for (c next : list) {
            if (next.toString().equals("TestSuite with 0 tests")) {
                kVar = g.a();
            } else if (next.toString().startsWith(f4427a)) {
                kVar = new e((i) new n(b(next)));
            } else {
                Class<?> testClass = next.getTestClass();
                if (testClass == null) {
                    throw new RuntimeException("Can't build a runner from description [" + next + "]");
                }
                String methodName = next.getMethodName();
                if (methodName == null) {
                    a2 = h.a(testClass);
                } else {
                    a2 = h.a(testClass).a(a.b(c.createTestDescription(testClass, methodName)));
                }
                kVar = a2.a();
            }
            arrayList.add(kVar);
        }
        return new h() {
            public final k a() {
                try {
                    return new g(r0) {
                    };
                } catch (org.junit.e.a.e e) {
                    return new org.junit.b.d.b((Class<?>) null, e);
                }
            }
        };
    }

    private org.junit.runner.i a(Class<?> cls) {
        h a2 = h.a(cls);
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.a(this.f4428b.listener());
        return jUnitCore.a(b(a2).a());
    }

    private org.junit.runner.i a(h hVar) {
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.a(this.f4428b.listener());
        return jUnitCore.a(b(hVar).a());
    }

    private org.junit.runner.i a(h hVar, JUnitCore jUnitCore) {
        jUnitCore.a(this.f4428b.listener());
        return jUnitCore.a(b(hVar).a());
    }

    private static k a(c cVar) {
        h a2;
        if (cVar.toString().equals("TestSuite with 0 tests")) {
            return g.a();
        }
        if (cVar.toString().startsWith(f4427a)) {
            return new e((i) new n(b(cVar)));
        }
        Class<?> testClass = cVar.getTestClass();
        if (testClass == null) {
            throw new RuntimeException("Can't build a runner from description [" + cVar + "]");
        }
        String methodName = cVar.getMethodName();
        if (methodName == null) {
            a2 = h.a(testClass);
        } else {
            a2 = h.a(testClass).a(a.b(c.createTestDescription(testClass, methodName)));
        }
        return a2.a();
    }

    private void a(c cVar, c cVar2, List<c> list) {
        if (!cVar2.getChildren().isEmpty()) {
            Iterator<c> it = cVar2.getChildren().iterator();
            while (it.hasNext()) {
                a(cVar2, it.next(), list);
            }
        } else if (cVar2.toString().equals("warning(junit.framework.TestSuite$1)")) {
            list.add(c.createSuiteDescription(f4427a + cVar, new Annotation[0]));
        } else {
            list.add(cVar2);
        }
    }

    private static Class<?> b(c cVar) {
        try {
            return Class.forName(cVar.toString().replace(f4427a, ""));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private h b(h hVar) {
        k kVar;
        h a2;
        if (hVar instanceof org.junit.b.c.c) {
            return hVar;
        }
        List<c> d = d(hVar);
        Collections.sort(d, this.f4428b.testComparator());
        final ArrayList arrayList = new ArrayList();
        for (c next : d) {
            if (next.toString().equals("TestSuite with 0 tests")) {
                kVar = g.a();
            } else if (next.toString().startsWith(f4427a)) {
                kVar = new e((i) new n(b(next)));
            } else {
                Class<?> testClass = next.getTestClass();
                if (testClass == null) {
                    throw new RuntimeException("Can't build a runner from description [" + next + "]");
                }
                String methodName = next.getMethodName();
                if (methodName == null) {
                    a2 = h.a(testClass);
                } else {
                    a2 = h.a(testClass).a(a.b(c.createTestDescription(testClass, methodName)));
                }
                kVar = a2.a();
            }
            arrayList.add(kVar);
        }
        return new h() {
            public final k a() {
                try {
                    return new g(arrayList) {
                    };
                } catch (org.junit.e.a.e e) {
                    return new org.junit.b.d.b((Class<?>) null, e);
                }
            }
        };
    }

    private List<c> c(h hVar) {
        return d(b(hVar));
    }

    private List<c> d(h hVar) {
        ArrayList arrayList = new ArrayList();
        a((c) null, hVar.a().b(), arrayList);
        return arrayList;
    }
}

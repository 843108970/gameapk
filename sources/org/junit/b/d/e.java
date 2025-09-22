package org.junit.b.d;

import java.lang.annotation.Annotation;
import junit.b.i;
import junit.b.j;
import junit.b.l;
import junit.b.m;
import junit.b.n;
import org.junit.runner.a.b;
import org.junit.runner.a.d;
import org.junit.runner.b.c;
import org.junit.runner.k;

public class e extends k implements b, d {

    /* renamed from: a  reason: collision with root package name */
    private volatile i f4504a;

    private static final class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final c f4505a;

        private a(c cVar) {
            this.f4505a = cVar;
        }

        /* synthetic */ a(c cVar, byte b2) {
            this(cVar);
        }

        private static org.junit.runner.c c(i iVar) {
            if (iVar instanceof org.junit.runner.b) {
                return ((org.junit.runner.b) iVar).b();
            }
            return org.junit.runner.c.createTestDescription(iVar.getClass(), iVar instanceof j ? ((j) iVar).f4032a : iVar.toString());
        }

        private static Class<? extends i> d(i iVar) {
            return iVar.getClass();
        }

        private static String e(i iVar) {
            return iVar instanceof j ? ((j) iVar).f4032a : iVar.toString();
        }

        public final void a(i iVar) {
            this.f4505a.c(c(iVar));
        }

        public final void a(i iVar, Throwable th) {
            this.f4505a.a(new org.junit.runner.b.a(c(iVar), th));
        }

        public final void a(i iVar, junit.b.b bVar) {
            a(iVar, (Throwable) bVar);
        }

        public final void b(i iVar) {
            this.f4505a.a(c(iVar));
        }
    }

    public e(Class<?> cls) {
        this((i) new n((Class<?>) cls.asSubclass(j.class)));
    }

    public e(i iVar) {
        this.f4504a = iVar;
    }

    private static String a(n nVar) {
        String str;
        int a2 = nVar.a();
        if (a2 == 0) {
            str = "";
        } else {
            str = String.format(" [example: %s]", new Object[]{nVar.a(0)});
        }
        return String.format("TestSuite with %s tests%s", new Object[]{Integer.valueOf(a2), str});
    }

    private i a() {
        return this.f4504a;
    }

    private static org.junit.runner.c a(i iVar) {
        String str;
        String str2;
        while (!(iVar instanceof j)) {
            if (iVar instanceof n) {
                n nVar = (n) iVar;
                if (nVar.f4040a == null) {
                    int a2 = nVar.a();
                    if (a2 == 0) {
                        str2 = "";
                    } else {
                        str2 = String.format(" [example: %s]", new Object[]{nVar.a(0)});
                    }
                    str = String.format("TestSuite with %s tests%s", new Object[]{Integer.valueOf(a2), str2});
                } else {
                    str = nVar.f4040a;
                }
                org.junit.runner.c createSuiteDescription = org.junit.runner.c.createSuiteDescription(str, new Annotation[0]);
                int size = nVar.f4041b.size();
                for (int i = 0; i < size; i++) {
                    createSuiteDescription.addChild(a(nVar.a(i)));
                }
                return createSuiteDescription;
            } else if (iVar instanceof org.junit.runner.b) {
                return ((org.junit.runner.b) iVar).b();
            } else {
                if (!(iVar instanceof junit.a.c)) {
                    return org.junit.runner.c.createSuiteDescription(iVar.getClass());
                }
                iVar = ((junit.a.c) iVar).b();
            }
        }
        j jVar = (j) iVar;
        return org.junit.runner.c.createTestDescription(jVar.getClass(), jVar.f4032a, a(jVar));
    }

    private static Annotation[] a(j jVar) {
        try {
            return jVar.getClass().getMethod(jVar.f4032a, new Class[0]).getDeclaredAnnotations();
        } catch (NoSuchMethodException | SecurityException unused) {
            return new Annotation[0];
        }
    }

    private static l b(c cVar) {
        return new a(cVar, (byte) 0);
    }

    private void b(i iVar) {
        this.f4504a = iVar;
    }

    public final void a(org.junit.runner.a.a aVar) throws org.junit.runner.a.c {
        if (this.f4504a instanceof b) {
            ((b) this.f4504a).a(aVar);
        } else if (this.f4504a instanceof n) {
            n nVar = (n) this.f4504a;
            n nVar2 = new n(nVar.f4040a);
            int size = nVar.f4041b.size();
            for (int i = 0; i < size; i++) {
                i a2 = nVar.a(i);
                if (aVar.a(a(a2))) {
                    nVar2.a(a2);
                }
            }
            this.f4504a = nVar2;
            if (nVar2.f4041b.size() == 0) {
                throw new org.junit.runner.a.c();
            }
        }
    }

    public final void a(org.junit.runner.a.e eVar) {
        if (this.f4504a instanceof d) {
            ((d) this.f4504a).a(eVar);
        }
    }

    public final void a(c cVar) {
        m mVar = new m();
        mVar.a((l) new a(cVar, (byte) 0));
        this.f4504a.a(mVar);
    }

    public final org.junit.runner.c b() {
        return a(this.f4504a);
    }
}

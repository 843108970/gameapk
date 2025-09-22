package org.junit.e;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.junit.b.d.c.a;
import org.junit.d.h;
import org.junit.d.l;
import org.junit.e.a.d;
import org.junit.e.a.e;
import org.junit.e.a.j;
import org.junit.f;
import org.junit.k;
import org.junit.m;
import org.junit.runner.c;

public class b extends f<d> {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<d, c> f4572a = new ConcurrentHashMap<>();

    public b(Class<?> cls) throws e {
        super(cls);
    }

    private static Class<? extends Throwable> a(m mVar) {
        if (mVar == null || mVar.a() == m.a.class) {
            return null;
        }
        return mVar.a();
    }

    private j a(Object obj, j jVar) {
        List<d> b2 = this.f4583c.b((Class<? extends Annotation>) f.class);
        return b2.isEmpty() ? jVar : new org.junit.b.d.c.f(jVar, b2, obj);
    }

    private j a(d dVar, Object obj, j jVar) {
        List<l> b2 = this.f4583c.b(obj, org.junit.l.class, l.class);
        b2.addAll(this.f4583c.a(obj, (Class<? extends Annotation>) org.junit.l.class, l.class));
        List<org.junit.d.f> b3 = this.f4583c.b(obj, org.junit.l.class, org.junit.d.f.class);
        b3.addAll(this.f4583c.a(obj, (Class<? extends Annotation>) org.junit.l.class, org.junit.d.f.class));
        for (org.junit.d.f next : b3) {
            if (!b2.contains(next)) {
                jVar = next.a(jVar, dVar);
            }
        }
        return b2.isEmpty() ? jVar : new h(jVar, b2, b(dVar));
    }

    private j a(d dVar, List<l> list, Object obj, j jVar) {
        List<org.junit.d.f> b2 = this.f4583c.b(obj, org.junit.l.class, org.junit.d.f.class);
        b2.addAll(this.f4583c.a(obj, (Class<? extends Annotation>) org.junit.l.class, org.junit.d.f.class));
        for (org.junit.d.f next : b2) {
            if (!list.contains(next)) {
                jVar = next.a(jVar, dVar);
            }
        }
        return jVar;
    }

    private j a(d dVar, List<l> list, j jVar) {
        return list.isEmpty() ? jVar : new h(jVar, list, b(dVar));
    }

    private static j a(d dVar, j jVar) {
        m mVar = (m) dVar.a(m.class);
        return a(mVar) != null ? new a(jVar, a(mVar)) : jVar;
    }

    private void a(d dVar, org.junit.runner.b.c cVar) {
        c d = b(dVar);
        if (c(dVar)) {
            cVar.b(d);
            return;
        }
        j a2 = a(dVar);
        org.junit.b.d.a.a aVar = new org.junit.b.d.a.a(cVar, d);
        aVar.f4475a.a(aVar.f4476b);
        try {
            a2.a();
        } catch (org.junit.b.b e) {
            aVar.a(e);
        } catch (Throwable th) {
            aVar.a(th);
        } finally {
            aVar.a();
        }
    }

    private j b(Object obj, j jVar) {
        List<d> b2 = this.f4583c.b((Class<? extends Annotation>) org.junit.a.class);
        return b2.isEmpty() ? jVar : new org.junit.b.d.c.e(jVar, b2, obj);
    }

    @Deprecated
    private static j b(d dVar, j jVar) {
        m mVar = (m) dVar.a(m.class);
        long b2 = mVar == null ? 0 : mVar.b();
        return b2 <= 0 ? jVar : org.junit.b.d.c.c.b().a(b2, TimeUnit.MILLISECONDS).a(jVar);
    }

    private static boolean b(m mVar) {
        return a(mVar) != null;
    }

    private static long c(m mVar) {
        if (mVar == null) {
            return 0;
        }
        return mVar.b();
    }

    private List<org.junit.d.f> c(Object obj) {
        List<org.junit.d.f> b2 = this.f4583c.b(obj, org.junit.l.class, org.junit.d.f.class);
        b2.addAll(this.f4583c.a(obj, (Class<? extends Annotation>) org.junit.l.class, org.junit.d.f.class));
        return b2;
    }

    private static boolean c(d dVar) {
        return dVar.a(k.class) != null;
    }

    private List<org.junit.d.f> d(Object obj) {
        List<org.junit.d.f> b2 = this.f4583c.b(obj, org.junit.l.class, org.junit.d.f.class);
        b2.addAll(this.f4583c.a(obj, (Class<? extends Annotation>) org.junit.l.class, org.junit.d.f.class));
        return b2;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public c b(d dVar) {
        c cVar = this.f4572a.get(dVar);
        if (cVar != null) {
            return cVar;
        }
        c createTestDescription = c.createTestDescription(this.f4583c.f4122b, b(dVar), dVar.f4120a.getAnnotations());
        this.f4572a.putIfAbsent(dVar, createTestDescription);
        return createTestDescription;
    }

    private List<l> e(Object obj) {
        List<l> b2 = this.f4583c.b(obj, org.junit.l.class, l.class);
        b2.addAll(this.f4583c.a(obj, (Class<? extends Annotation>) org.junit.l.class, l.class));
        return b2;
    }

    private void g(List<Throwable> list) {
        if (this.f4583c.d()) {
            list.add(new Exception("The inner class " + this.f4583c.b() + " is not static."));
        }
    }

    private boolean g() {
        return this.f4583c.f4122b.getConstructors().length == 1;
    }

    @Deprecated
    private void h(List<Throwable> list) {
        a((Class<? extends Annotation>) org.junit.a.class, false, list);
        a((Class<? extends Annotation>) f.class, false, list);
        c(list);
        if (a().size() == 0) {
            list.add(new Exception("No runnable methods"));
        }
    }

    private void i(List<Throwable> list) {
        org.junit.b.d.b.a.d.a(this.f4583c, list);
    }

    public List<d> a() {
        return this.f4583c.b((Class<? extends Annotation>) m.class);
    }

    public j a(d dVar) {
        try {
            Object a2 = new org.junit.b.d.a.c() {
                /* access modifiers changed from: protected */
                public final Object b() throws Throwable {
                    return b.this.c();
                }
            }.a();
            org.junit.b.d.c.f a3 = a(dVar, a2);
            m mVar = (m) dVar.a(m.class);
            if (a(mVar) != null) {
                a3 = new a(a3, a(mVar));
            }
            m mVar2 = (m) dVar.a(m.class);
            long b2 = mVar2 == null ? 0 : mVar2.b();
            if (b2 > 0) {
                a3 = org.junit.b.d.c.c.b().a(b2, TimeUnit.MILLISECONDS).a(a3);
            }
            List<d> b3 = this.f4583c.b((Class<? extends Annotation>) f.class);
            if (!b3.isEmpty()) {
                a3 = new org.junit.b.d.c.f(a3, b3, a2);
            }
            List<d> b4 = this.f4583c.b((Class<? extends Annotation>) org.junit.a.class);
            if (!b4.isEmpty()) {
                a3 = new org.junit.b.d.c.e(a3, b4, a2);
            }
            List<l> b5 = this.f4583c.b(a2, org.junit.l.class, l.class);
            b5.addAll(this.f4583c.a(a2, (Class<? extends Annotation>) org.junit.l.class, l.class));
            List<org.junit.d.f> b6 = this.f4583c.b(a2, org.junit.l.class, org.junit.d.f.class);
            b6.addAll(this.f4583c.a(a2, (Class<? extends Annotation>) org.junit.l.class, org.junit.d.f.class));
            for (org.junit.d.f next : b6) {
                if (!b5.contains(next)) {
                    a3 = next.a(a3, dVar);
                }
            }
            return b5.isEmpty() ? a3 : new h(a3, b5, b(dVar));
        } catch (Throwable th) {
            return new org.junit.b.d.c.b(th);
        }
    }

    /* access modifiers changed from: protected */
    public j a(d dVar, Object obj) {
        return new org.junit.b.d.c.d(dVar, obj);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(Object obj, org.junit.runner.b.c cVar) {
        d dVar = (d) obj;
        c d = b(dVar);
        if (c(dVar)) {
            cVar.b(d);
            return;
        }
        j a2 = a(dVar);
        org.junit.b.d.a.a aVar = new org.junit.b.d.a.a(cVar, d);
        aVar.f4475a.a(aVar.f4476b);
        try {
            a2.a();
        } catch (org.junit.b.b e) {
            aVar.a(e);
        } catch (Throwable th) {
            aVar.a(th);
        } finally {
            aVar.a();
        }
    }

    public void a(List<Throwable> list) {
        super.a(list);
        if (this.f4583c.d()) {
            list.add(new Exception("The inner class " + this.f4583c.b() + " is not static."));
        }
        b(list);
        a((Class<? extends Annotation>) org.junit.a.class, false, list);
        a((Class<? extends Annotation>) f.class, false, list);
        c(list);
        if (a().size() == 0) {
            list.add(new Exception("No runnable methods"));
        }
        f(list);
        org.junit.b.d.b.a.d.a(this.f4583c, list);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean a(Object obj) {
        return c((d) obj);
    }

    public String b(d dVar) {
        return dVar.f4120a.getName();
    }

    public void b(List<Throwable> list) {
        d(list);
        e(list);
    }

    public Object c() throws Exception {
        return this.f4583c.c().newInstance(new Object[0]);
    }

    public void c(List<Throwable> list) {
        a((Class<? extends Annotation>) m.class, false, list);
    }

    /* access modifiers changed from: protected */
    public final List<d> d() {
        return a();
    }

    /* access modifiers changed from: protected */
    public final void d(List<Throwable> list) {
        if (!g()) {
            list.add(new Exception("Test class should have exactly one public constructor"));
        }
    }

    /* access modifiers changed from: protected */
    public final void e(List<Throwable> list) {
        if (!this.f4583c.d() && g() && this.f4583c.c().getParameterTypes().length != 0) {
            list.add(new Exception("Test class should have exactly one public zero-argument constructor"));
        }
    }

    public void f(List<Throwable> list) {
        org.junit.b.d.b.a.f4480b.a(this.f4583c, list);
    }
}

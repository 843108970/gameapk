package org.junit.e;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.b.d.a.a;
import org.junit.d.l;
import org.junit.e.a.i;
import org.junit.e.a.j;
import org.junit.f.c;
import org.junit.f.e;
import org.junit.g;
import org.junit.h;
import org.junit.runner.a.b;
import org.junit.runner.a.d;
import org.junit.runner.k;

public abstract class f<T> extends k implements b, d {

    /* renamed from: a  reason: collision with root package name */
    private static final List<e> f4581a = Arrays.asList(new e[]{new c(), new org.junit.f.d()});

    /* renamed from: b  reason: collision with root package name */
    private final Object f4582b = new Object();

    /* renamed from: c  reason: collision with root package name */
    protected final org.junit.e.a.k f4583c;
    public volatile i d = new i() {
        public final void a() {
        }

        public final void a(Runnable runnable) {
            runnable.run();
        }
    };
    private volatile Collection<T> e = null;

    protected f(Class<?> cls) throws org.junit.e.a.e {
        this.f4583c = new org.junit.e.a.k(cls);
        ArrayList arrayList = new ArrayList();
        a((List<Throwable>) arrayList);
        if (!arrayList.isEmpty()) {
            throw new org.junit.e.a.e((List<Throwable>) arrayList);
        }
    }

    private j a(j jVar) {
        List<org.junit.e.a.d> b2 = this.f4583c.b((Class<? extends Annotation>) g.class);
        return b2.isEmpty() ? jVar : new org.junit.b.d.c.f(jVar, b2, (Object) null);
    }

    private static org.junit.e.a.k a(Class<?> cls) {
        return new org.junit.e.a.k(cls);
    }

    private void a(i iVar) {
        this.d = iVar;
    }

    private static void a(j jVar, org.junit.runner.c cVar, org.junit.runner.b.c cVar2) {
        a aVar = new a(cVar2, cVar);
        aVar.f4475a.a(aVar.f4476b);
        try {
            jVar.a();
        } catch (org.junit.b.b e2) {
            aVar.a(e2);
        } catch (Throwable th) {
            aVar.a(th);
        } finally {
            aVar.a();
        }
    }

    static /* synthetic */ void a(f fVar, final org.junit.runner.b.c cVar) {
        i iVar = fVar.d;
        try {
            for (final Object next : fVar.i()) {
                iVar.a(new Runnable() {
                    public final void run() {
                        f.this.a(r2, r5);
                    }
                });
            }
        } finally {
            iVar.a();
        }
    }

    private boolean a() {
        for (Object a2 : i()) {
            if (!a(a2)) {
                return false;
            }
        }
        return true;
    }

    private boolean a(org.junit.runner.a.a aVar, T t) {
        return aVar.a(b(t));
    }

    private Comparator<? super T> b(final org.junit.runner.a.e eVar) {
        return new Comparator<T>() {
            public final int compare(T t, T t2) {
                return r4.compare(f.this.b(t), f.this.b(t2));
            }
        };
    }

    private j b(j jVar) {
        List<org.junit.e.a.d> b2 = this.f4583c.b((Class<? extends Annotation>) org.junit.b.class);
        return b2.isEmpty() ? jVar : new org.junit.b.d.c.e(jVar, b2, (Object) null);
    }

    private void b(List<Throwable> list) {
        if (this.f4583c.f4122b != null) {
            for (e a2 : f4581a) {
                list.addAll(a2.a(this.f4583c));
            }
        }
    }

    private List<l> c() {
        List<l> b2 = this.f4583c.b((Object) null, h.class, l.class);
        b2.addAll(this.f4583c.a((Object) null, (Class<? extends Annotation>) h.class, l.class));
        return b2;
    }

    private j c(j jVar) {
        List<l> b2 = this.f4583c.b((Object) null, h.class, l.class);
        b2.addAll(this.f4583c.a((Object) null, (Class<? extends Annotation>) h.class, l.class));
        return b2.isEmpty() ? jVar : new org.junit.d.h(jVar, b2, b());
    }

    private void c(List<Throwable> list) {
        org.junit.b.d.b.a.f4479a.a(this.f4583c, list);
        org.junit.b.d.b.a.f4481c.a(this.f4583c, list);
    }

    private void d(final org.junit.runner.b.c cVar) {
        i iVar = this.d;
        try {
            for (final Object next : i()) {
                iVar.a(new Runnable() {
                    public final void run() {
                        f.this.a(next, cVar);
                    }
                });
            }
        } finally {
            iVar.a();
        }
    }

    private org.junit.e.a.k g() {
        return this.f4583c;
    }

    private void h() throws org.junit.e.a.e {
        ArrayList arrayList = new ArrayList();
        a((List<Throwable>) arrayList);
        if (!arrayList.isEmpty()) {
            throw new org.junit.e.a.e((List<Throwable>) arrayList);
        }
    }

    private Collection<T> i() {
        if (this.e == null) {
            synchronized (this.f4582b) {
                if (this.e == null) {
                    this.e = Collections.unmodifiableCollection(d());
                }
            }
        }
        return this.e;
    }

    /* access modifiers changed from: protected */
    public final void a(Class<? extends Annotation> cls, boolean z, List<Throwable> list) {
        for (org.junit.e.a.d a2 : this.f4583c.b(cls)) {
            a2.a(z, list);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t, org.junit.runner.b.c cVar);

    public void a(List<Throwable> list) {
        a((Class<? extends Annotation>) g.class, true, list);
        a((Class<? extends Annotation>) org.junit.b.class, true, list);
        org.junit.b.d.b.a.f4479a.a(this.f4583c, list);
        org.junit.b.d.b.a.f4481c.a(this.f4583c, list);
        if (this.f4583c.f4122b != null) {
            for (e a2 : f4581a) {
                list.addAll(a2.a(this.f4583c));
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|(2:8|9)|10|11|24|21|4) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0010, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(org.junit.runner.a.a r6) throws org.junit.runner.a.c {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f4582b
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0042 }
            java.util.Collection r2 = r5.i()     // Catch:{ all -> 0x0042 }
            r1.<init>(r2)     // Catch:{ all -> 0x0042 }
            java.util.Iterator r2 = r1.iterator()     // Catch:{ all -> 0x0042 }
        L_0x0010:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0042 }
            if (r3 == 0) goto L_0x002c
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0042 }
            org.junit.runner.c r4 = r5.b(r3)     // Catch:{ all -> 0x0042 }
            boolean r4 = r6.a((org.junit.runner.c) r4)     // Catch:{ all -> 0x0042 }
            if (r4 == 0) goto L_0x0028
            r6.a((java.lang.Object) r3)     // Catch:{ c -> 0x0028 }
            goto L_0x0010
        L_0x0028:
            r2.remove()     // Catch:{ all -> 0x0042 }
            goto L_0x0010
        L_0x002c:
            java.util.Collection r6 = java.util.Collections.unmodifiableCollection(r1)     // Catch:{ all -> 0x0042 }
            r5.e = r6     // Catch:{ all -> 0x0042 }
            java.util.Collection<T> r6 = r5.e     // Catch:{ all -> 0x0042 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0042 }
            if (r6 == 0) goto L_0x0040
            org.junit.runner.a.c r6 = new org.junit.runner.a.c     // Catch:{ all -> 0x0042 }
            r6.<init>()     // Catch:{ all -> 0x0042 }
            throw r6     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            return
        L_0x0042:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.e.f.a(org.junit.runner.a.a):void");
    }

    public final void a(final org.junit.runner.a.e eVar) {
        synchronized (this.f4582b) {
            for (Object a2 : i()) {
                eVar.a(a2);
            }
            ArrayList arrayList = new ArrayList(i());
            Collections.sort(arrayList, new Comparator<T>() {
                public final int compare(T t, T t2) {
                    return eVar.compare(f.this.b(t), f.this.b(t2));
                }
            });
            this.e = Collections.unmodifiableCollection(arrayList);
        }
    }

    public final void a(org.junit.runner.b.c cVar) {
        a aVar = new a(cVar, b());
        try {
            b(cVar).a();
        } catch (org.junit.b.b e2) {
            aVar.a(e2);
        } catch (org.junit.runner.b.d e3) {
            throw e3;
        } catch (Throwable th) {
            aVar.a(th);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(T t) {
        return false;
    }

    public j b(org.junit.runner.b.c cVar) {
        boolean z;
        org.junit.b.d.c.e c2 = c(cVar);
        Iterator it = i().iterator();
        while (true) {
            if (it.hasNext()) {
                if (!a(it.next())) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            return c2;
        }
        List<org.junit.e.a.d> b2 = this.f4583c.b((Class<? extends Annotation>) g.class);
        if (!b2.isEmpty()) {
            c2 = new org.junit.b.d.c.f(c2, b2, (Object) null);
        }
        List<org.junit.e.a.d> b3 = this.f4583c.b((Class<? extends Annotation>) org.junit.b.class);
        if (!b3.isEmpty()) {
            c2 = new org.junit.b.d.c.e(c2, b3, (Object) null);
        }
        List<l> b4 = this.f4583c.b((Object) null, h.class, l.class);
        b4.addAll(this.f4583c.a((Object) null, (Class<? extends Annotation>) h.class, l.class));
        return b4.isEmpty() ? c2 : new org.junit.d.h(c2, b4, b());
    }

    public final org.junit.runner.c b() {
        org.junit.runner.c createSuiteDescription = org.junit.runner.c.createSuiteDescription(e(), f());
        for (Object b2 : i()) {
            createSuiteDescription.addChild(b(b2));
        }
        return createSuiteDescription;
    }

    /* access modifiers changed from: protected */
    public abstract org.junit.runner.c b(T t);

    /* access modifiers changed from: protected */
    public final j c(final org.junit.runner.b.c cVar) {
        return new j() {
            public final void a() {
                f.a(f.this, cVar);
            }
        };
    }

    /* access modifiers changed from: protected */
    public abstract List<T> d();

    public String e() {
        return this.f4583c.b();
    }

    public Annotation[] f() {
        return this.f4583c.a();
    }
}

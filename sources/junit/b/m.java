package junit.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    protected List<k> f4035a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    protected List<k> f4036b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    protected List<l> f4037c = new ArrayList();
    protected int d = 0;
    private boolean e = false;

    private synchronized void a(i iVar, b bVar) {
        this.f4035a.add(new k(iVar, bVar));
        for (l a2 : h()) {
            a2.a(iVar, bVar);
        }
    }

    private void a(final j jVar) {
        b((i) jVar);
        a((i) jVar, (h) new h() {
            public final void a() throws Throwable {
                jVar.b();
            }
        });
        a((i) jVar);
    }

    private synchronized void b(l lVar) {
        this.f4037c.remove(lVar);
    }

    private synchronized List<l> h() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f4037c);
        return arrayList;
    }

    private synchronized void i() {
        this.e = true;
    }

    public final synchronized int a() {
        return this.f4036b.size();
    }

    public final void a(i iVar) {
        for (l a2 : h()) {
            a2.a(iVar);
        }
    }

    public final synchronized void a(i iVar, Throwable th) {
        this.f4036b.add(new k(iVar, th));
        for (l a2 : h()) {
            a2.a(iVar, th);
        }
    }

    public final void a(i iVar, h hVar) {
        try {
            hVar.a();
        } catch (b e2) {
            a(iVar, e2);
        } catch (ThreadDeath e3) {
            throw e3;
        } catch (Throwable th) {
            a(iVar, th);
        }
    }

    public final synchronized void a(l lVar) {
        this.f4037c.add(lVar);
    }

    public final synchronized Enumeration<k> b() {
        return Collections.enumeration(this.f4036b);
    }

    public final void b(i iVar) {
        int a2 = iVar.a();
        synchronized (this) {
            this.d += a2;
        }
        for (l b2 : h()) {
            b2.b(iVar);
        }
    }

    public final synchronized int c() {
        return this.f4035a.size();
    }

    public final synchronized Enumeration<k> d() {
        return Collections.enumeration(this.f4035a);
    }

    public final synchronized int e() {
        return this.d;
    }

    public final synchronized boolean f() {
        return this.e;
    }

    public final synchronized boolean g() {
        return c() == 0 && a() == 0;
    }
}

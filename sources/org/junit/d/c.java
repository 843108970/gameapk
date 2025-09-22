package org.junit.d;

import org.a.a.o;
import org.a.k;
import org.a.l;
import org.a.m;
import org.a.n;
import org.junit.b.b.b;
import org.junit.e.a.j;

public final class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final d f4534a = new d();

    /* renamed from: b  reason: collision with root package name */
    private String f4535b = "Expected test to throw %s";

    private class a extends j {

        /* renamed from: b  reason: collision with root package name */
        private final j f4537b;

        public a(j jVar) {
            this.f4537b = jVar;
        }

        public final void a() throws Throwable {
            try {
                this.f4537b.a();
                if (c.this.d()) {
                    c.b(c.this);
                }
            } catch (Throwable th) {
                c.a(c.this, th);
            }
        }
    }

    private c() {
    }

    private static c a() {
        return new c();
    }

    private c a(String str) {
        this.f4535b = str;
        return this;
    }

    private void a(Class<? extends Throwable> cls) {
        a((k<?>) org.a.a.j.a(cls));
    }

    private void a(Throwable th) throws Throwable {
        if (d()) {
            l.a("", th, this.f4534a.a());
            return;
        }
        throw th;
    }

    private void a(k<?> kVar) {
        this.f4534a.f4538a.add(kVar);
    }

    static /* synthetic */ void a(c cVar, Throwable th) throws Throwable {
        if (cVar.d()) {
            l.a("", th, cVar.f4534a.a());
            return;
        }
        throw th;
    }

    @Deprecated
    private c b() {
        return this;
    }

    private void b(String str) {
        a((k<?>) org.junit.b.b.c.a(o.b(str)));
    }

    private void b(k<String> kVar) {
        a((k<?>) org.junit.b.b.c.a(kVar));
    }

    static /* synthetic */ void b(c cVar) throws AssertionError {
        String b2 = n.b((m) cVar.f4534a.a());
        org.junit.c.a(String.format(cVar.f4535b, new Object[]{b2}));
    }

    @Deprecated
    private c c() {
        return this;
    }

    private void c(k<? extends Throwable> kVar) {
        a((k<?>) b.a(kVar));
    }

    /* access modifiers changed from: private */
    public boolean d() {
        return !this.f4534a.f4538a.isEmpty();
    }

    private void e() throws AssertionError {
        String b2 = n.b((m) this.f4534a.a());
        org.junit.c.a(String.format(this.f4535b, new Object[]{b2}));
    }

    private String f() {
        String b2 = n.b((m) this.f4534a.a());
        return String.format(this.f4535b, new Object[]{b2});
    }

    public final j a(j jVar, org.junit.runner.c cVar) {
        return new a(jVar);
    }
}

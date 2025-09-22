package org.junit.b.d.a;

import org.junit.b.b;
import org.junit.e.a.f;
import org.junit.runner.b.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final c f4475a;

    /* renamed from: b  reason: collision with root package name */
    public final org.junit.runner.c f4476b;

    public a(c cVar, org.junit.runner.c cVar2) {
        this.f4475a = cVar;
        this.f4476b = cVar2;
    }

    private void a(f fVar) {
        for (Throwable a2 : fVar.getFailures()) {
            a(a2);
        }
    }

    private void b() {
        this.f4475a.a(this.f4476b);
    }

    private void c() {
        this.f4475a.b(this.f4476b);
    }

    public final void a() {
        this.f4475a.c(this.f4476b);
    }

    public final void a(Throwable th) {
        if (th instanceof f) {
            for (Throwable a2 : ((f) th).getFailures()) {
                a(a2);
            }
            return;
        }
        this.f4475a.a(new org.junit.runner.b.a(this.f4476b, th));
    }

    public final void a(b bVar) {
        new c.a(new org.junit.runner.b.a(this.f4476b, bVar)) {
            /* access modifiers changed from: protected */
            public final void a(b bVar) throws Exception {
                bVar.b(r2);
            }
        }.a();
    }
}

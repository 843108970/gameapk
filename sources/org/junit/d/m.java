package org.junit.d;

import java.util.ArrayList;
import java.util.List;
import org.junit.b.b;
import org.junit.e;
import org.junit.e.a.f;
import org.junit.e.a.j;
import org.junit.runner.c;

public abstract class m implements l {
    private void a(List<Throwable> list) {
        try {
            b();
        } catch (Throwable th) {
            list.add(th);
        }
    }

    private void a(b bVar, List<Throwable> list) {
        try {
            if (bVar instanceof e) {
                d();
            }
        } catch (Throwable th) {
            list.add(th);
        }
    }

    static /* synthetic */ void a(m mVar, List list) {
        try {
            mVar.b();
        } catch (Throwable th) {
            list.add(th);
        }
    }

    static /* synthetic */ void a(m mVar, b bVar, List list) {
        try {
            if (bVar instanceof e) {
                mVar.d();
            }
        } catch (Throwable th) {
            list.add(th);
        }
    }

    static /* synthetic */ void a(m mVar, c cVar, List list) {
        try {
            mVar.a(cVar);
        } catch (Throwable th) {
            list.add(th);
        }
    }

    private void a(c cVar, List<Throwable> list) {
        try {
            a(cVar);
        } catch (Throwable th) {
            list.add(th);
        }
    }

    private void b(List<Throwable> list) {
        try {
            c();
        } catch (Throwable th) {
            list.add(th);
        }
    }

    static /* synthetic */ void b(m mVar, List list) {
        try {
            mVar.c();
        } catch (Throwable th) {
            list.add(th);
        }
    }

    private void c(List<Throwable> list) {
        try {
            a();
        } catch (Throwable th) {
            list.add(th);
        }
    }

    static /* synthetic */ void c(m mVar, List list) {
        try {
            mVar.a();
        } catch (Throwable th) {
            list.add(th);
        }
    }

    @Deprecated
    private static void e() {
    }

    public final j a(final j jVar, final c cVar) {
        return new j() {
            public final void a() throws Throwable {
                ArrayList arrayList = new ArrayList();
                m.a(m.this, cVar, (List) arrayList);
                try {
                    jVar.a();
                    m.a(m.this, (List) arrayList);
                } catch (b e) {
                    arrayList.add(e);
                    m.a(m.this, e, (List) arrayList);
                } catch (Throwable th) {
                    m.c(m.this, arrayList);
                    throw th;
                }
                m.c(m.this, arrayList);
                f.assertEmpty(arrayList);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public void a(c cVar) {
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* access modifiers changed from: protected */
    public void d() {
    }
}

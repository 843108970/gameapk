package org.junit.runner.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.runner.b.b;
import org.junit.runner.i;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f4612a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f4613b = false;

    private abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f4628a;

        a(c cVar) {
            this(cVar.f4612a);
        }

        a(List<b> list) {
            this.f4628a = list;
        }

        public final void a() {
            int size = this.f4628a.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (b next : this.f4628a) {
                try {
                    a(next);
                    arrayList.add(next);
                } catch (Exception e) {
                    arrayList2.add(new a(org.junit.runner.c.TEST_MECHANISM, e));
                }
            }
            c.this.a(arrayList, arrayList2);
        }

        /* access modifiers changed from: protected */
        public abstract void a(b bVar) throws Exception;
    }

    private void a() {
        this.f4613b = true;
    }

    private void a(final i iVar) {
        new a() {
            /* access modifiers changed from: protected */
            public final void a(b bVar) throws Exception {
                bVar.a(iVar);
            }
        }.a();
    }

    private void b(final a aVar) {
        new a() {
            /* access modifiers changed from: protected */
            public final void a(b bVar) throws Exception {
                bVar.b(aVar);
            }
        }.a();
    }

    private void c(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Cannot remove a null listener");
        }
        this.f4612a.remove(b(bVar));
    }

    private void d(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Cannot add a null listener");
        }
        this.f4612a.add(0, b(bVar));
    }

    private void d(final org.junit.runner.c cVar) {
        new a() {
            /* access modifiers changed from: protected */
            public final void a(b bVar) throws Exception {
                bVar.d(cVar);
            }
        }.a();
    }

    /* access modifiers changed from: package-private */
    public final void a(List<b> list, final List<a> list2) {
        if (!list2.isEmpty()) {
            new a(list) {
                /* access modifiers changed from: protected */
                public final void a(b bVar) throws Exception {
                    for (a a2 : list2) {
                        bVar.a(a2);
                    }
                }
            }.a();
        }
    }

    public final void a(a aVar) {
        a(this.f4612a, Arrays.asList(new a[]{aVar}));
    }

    public final void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Cannot add a null listener");
        }
        this.f4612a.add(b(bVar));
    }

    public final void a(final org.junit.runner.c cVar) throws d {
        if (this.f4613b) {
            throw new d();
        }
        new a() {
            /* access modifiers changed from: protected */
            public final void a(b bVar) throws Exception {
                bVar.b(cVar);
            }
        }.a();
    }

    public final b b(b bVar) {
        return bVar.getClass().isAnnotationPresent(b.a.class) ? bVar : new e(bVar, this);
    }

    public final void b(final org.junit.runner.c cVar) {
        new a() {
            /* access modifiers changed from: protected */
            public final void a(b bVar) throws Exception {
                bVar.c(cVar);
            }
        }.a();
    }

    public final void c(final org.junit.runner.c cVar) {
        new a() {
            /* access modifiers changed from: protected */
            public final void a(b bVar) throws Exception {
                bVar.a(cVar);
            }
        }.a();
    }
}

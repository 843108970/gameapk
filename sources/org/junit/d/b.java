package org.junit.d;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.a.k;
import org.a.l;
import org.junit.e.a.f;

public final class b extends p {

    /* renamed from: a  reason: collision with root package name */
    private List<Throwable> f4530a = new ArrayList();

    private <T> T a(Callable<T> callable) {
        try {
            return callable.call();
        } catch (Throwable th) {
            this.f4530a.add(th);
            return null;
        }
    }

    private <T> void a(final T t, final k<T> kVar) {
        a(new Callable<Object>("") {
            public final Object call() throws Exception {
                l.a(r2, r3, r4);
                return r3;
            }
        });
    }

    private <T> void a(final String str, final T t, final k<T> kVar) {
        a(new Callable<Object>() {
            public final Object call() throws Exception {
                l.a(str, t, kVar);
                return t;
            }
        });
    }

    private void a(Throwable th) {
        this.f4530a.add(th);
    }

    /* access modifiers changed from: protected */
    public final void a() throws Throwable {
        f.assertEmpty(this.f4530a);
    }
}

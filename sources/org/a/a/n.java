package org.a.a;

import com.cyjh.common.util.s;
import org.a.b;
import org.a.g;
import org.a.k;

abstract class n<T> extends b<T> {

    /* renamed from: a  reason: collision with root package name */
    final Iterable<k<? super T>> f4258a;

    public n(Iterable<k<? super T>> iterable) {
        this.f4258a = iterable;
    }

    private boolean b(Object obj) {
        for (k<? super T> a2 : this.f4258a) {
            if (a2.a(obj)) {
                return true;
            }
        }
        return false;
    }

    public void a(g gVar, String str) {
        gVar.b("(", s.a.f1696a + str + s.a.f1696a, ")", this.f4258a);
    }

    public abstract boolean a(Object obj);

    public abstract void describeTo(g gVar);
}

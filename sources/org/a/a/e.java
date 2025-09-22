package org.a.a;

import org.a.g;
import org.a.i;
import org.a.k;
import org.a.m;
import org.a.o;

public final class e<T> extends o<Iterable<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final k<? super T> f4249a;

    private e(k<? super T> kVar) {
        this.f4249a = kVar;
    }

    @i
    public static <U> k<Iterable<U>> a(k<U> kVar) {
        return new e(kVar);
    }

    private boolean a(Iterable<T> iterable, g gVar) {
        for (T next : iterable) {
            if (!this.f4249a.a(next)) {
                gVar.a("an item ");
                this.f4249a.a(next, gVar);
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ boolean b(Object obj, g gVar) {
        for (Object next : (Iterable) obj) {
            if (!this.f4249a.a(next)) {
                gVar.a("an item ");
                this.f4249a.a(next, gVar);
                return false;
            }
        }
        return true;
    }

    public final void describeTo(g gVar) {
        gVar.a("every item is ").a((m) this.f4249a);
    }
}

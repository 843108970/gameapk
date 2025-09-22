package org.a.a;

import java.util.ArrayList;
import org.a.g;
import org.a.i;
import org.a.k;
import org.a.m;
import org.a.o;

public final class h<T> extends o<Iterable<? super T>> {

    /* renamed from: a  reason: collision with root package name */
    private final k<? super T> f4252a;

    private h(k<? super T> kVar) {
        this.f4252a = kVar;
    }

    @i
    public static <T> k<Iterable<? super T>> a(k<? super T> kVar) {
        return new h(kVar);
    }

    @i
    public static <T> k<Iterable<T>> a(T... tArr) {
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T b2 : tArr) {
            arrayList.add(b(b2));
        }
        return a.a(arrayList);
    }

    @i
    public static <T> k<Iterable<T>> a(k<? super T>... kVarArr) {
        ArrayList arrayList = new ArrayList(kVarArr.length);
        for (k<? super T> hVar : kVarArr) {
            arrayList.add(new h(hVar));
        }
        return a.a(arrayList);
    }

    private boolean a(Iterable<? super T> iterable, g gVar) {
        boolean z = false;
        for (Object next : iterable) {
            if (this.f4252a.a(next)) {
                return true;
            }
            if (z) {
                gVar.a(", ");
            }
            this.f4252a.a(next, gVar);
            z = true;
        }
        return false;
    }

    @i
    public static <T> k<Iterable<? super T>> b(T t) {
        return new h(i.b(t));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ boolean b(Object obj, g gVar) {
        boolean z = false;
        for (Object next : (Iterable) obj) {
            if (this.f4252a.a(next)) {
                return true;
            }
            if (z) {
                gVar.a(", ");
            }
            this.f4252a.a(next, gVar);
            z = true;
        }
        return false;
    }

    public final void describeTo(g gVar) {
        gVar.a("a collection containing ").a((m) this.f4252a);
    }
}

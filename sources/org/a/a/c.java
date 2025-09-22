package org.a.a;

import java.util.ArrayList;
import org.a.g;
import org.a.i;
import org.a.k;
import org.a.m;
import org.a.o;

public final class c<T> extends o<T> {

    /* renamed from: a  reason: collision with root package name */
    private final k<? super T> f4243a;

    public static final class a<X> {

        /* renamed from: a  reason: collision with root package name */
        private final k<? super X> f4244a;

        public a(k<? super X> kVar) {
            this.f4244a = kVar;
        }

        private c<X> a(k<? super X> kVar) {
            return new c<>(new a(new c(this.f4244a).a(kVar)));
        }
    }

    public static final class b<X> {

        /* renamed from: a  reason: collision with root package name */
        private final k<? super X> f4245a;

        public b(k<? super X> kVar) {
            this.f4245a = kVar;
        }

        private c<X> a(k<? super X> kVar) {
            return new c<>(new b(new c(this.f4245a).a(kVar)));
        }
    }

    public c(k<? super T> kVar) {
        this.f4243a = kVar;
    }

    @i
    public static <LHS> a<LHS> b(k<? super LHS> kVar) {
        return new a<>(kVar);
    }

    @i
    public static <LHS> b<LHS> c(k<? super LHS> kVar) {
        return new b<>(kVar);
    }

    private c<T> d(k<? super T> kVar) {
        return new c<>(new a(a(kVar)));
    }

    private c<T> e(k<? super T> kVar) {
        return new c<>(new b(a(kVar)));
    }

    /* access modifiers changed from: package-private */
    public final ArrayList<k<? super T>> a(k<? super T> kVar) {
        ArrayList<k<? super T>> arrayList = new ArrayList<>();
        arrayList.add(this.f4243a);
        arrayList.add(kVar);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public final boolean b(T t, g gVar) {
        if (this.f4243a.a(t)) {
            return true;
        }
        this.f4243a.a(t, gVar);
        return false;
    }

    public final void describeTo(g gVar) {
        gVar.a((m) this.f4243a);
    }
}

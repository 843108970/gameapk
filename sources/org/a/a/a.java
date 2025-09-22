package org.a.a;

import com.cyjh.common.util.s;
import java.util.ArrayList;
import java.util.Arrays;
import org.a.g;
import org.a.h;
import org.a.i;
import org.a.k;
import org.a.m;

public final class a<T> extends h<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Iterable<k<? super T>> f4242a;

    public a(Iterable<k<? super T>> iterable) {
        this.f4242a = iterable;
    }

    @i
    public static <T> k<T> a(Iterable<k<? super T>> iterable) {
        return new a(iterable);
    }

    @i
    private static <T> k<T> a(k<? super T> kVar, k<? super T> kVar2) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(kVar);
        arrayList.add(kVar2);
        return a(arrayList);
    }

    @i
    private static <T> k<T> a(k<? super T> kVar, k<? super T> kVar2, k<? super T> kVar3) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(kVar);
        arrayList.add(kVar2);
        arrayList.add(kVar3);
        return a(arrayList);
    }

    @i
    private static <T> k<T> a(k<? super T> kVar, k<? super T> kVar2, k<? super T> kVar3, k<? super T> kVar4) {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(kVar);
        arrayList.add(kVar2);
        arrayList.add(kVar3);
        arrayList.add(kVar4);
        return a(arrayList);
    }

    @i
    private static <T> k<T> a(k<? super T> kVar, k<? super T> kVar2, k<? super T> kVar3, k<? super T> kVar4, k<? super T> kVar5) {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(kVar);
        arrayList.add(kVar2);
        arrayList.add(kVar3);
        arrayList.add(kVar4);
        arrayList.add(kVar5);
        return a(arrayList);
    }

    @i
    private static <T> k<T> a(k<? super T> kVar, k<? super T> kVar2, k<? super T> kVar3, k<? super T> kVar4, k<? super T> kVar5, k<? super T> kVar6) {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(kVar);
        arrayList.add(kVar2);
        arrayList.add(kVar3);
        arrayList.add(kVar4);
        arrayList.add(kVar5);
        arrayList.add(kVar6);
        return a(arrayList);
    }

    @i
    private static <T> k<T> a(k<? super T>... kVarArr) {
        return a(Arrays.asList(kVarArr));
    }

    public final boolean b(Object obj, g gVar) {
        for (k next : this.f4242a) {
            if (!next.a(obj)) {
                gVar.a((m) next).a(s.a.f1696a);
                next.a(obj, gVar);
                return false;
            }
        }
        return true;
    }

    public final void describeTo(g gVar) {
        gVar.b("(", " and ", ")", this.f4242a);
    }
}

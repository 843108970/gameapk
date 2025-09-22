package org.a.a;

import java.util.ArrayList;
import java.util.Arrays;
import org.a.g;
import org.a.i;
import org.a.k;

public final class b<T> extends n<T> {
    public b(Iterable<k<? super T>> iterable) {
        super(iterable);
    }

    @i
    public static <T> b<T> a(Iterable<k<? super T>> iterable) {
        return new b<>(iterable);
    }

    @i
    private static <T> b<T> a(k<T> kVar, k<? super T> kVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(kVar);
        arrayList.add(kVar2);
        return a(arrayList);
    }

    @i
    private static <T> b<T> a(k<T> kVar, k<? super T> kVar2, k<? super T> kVar3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(kVar);
        arrayList.add(kVar2);
        arrayList.add(kVar3);
        return a(arrayList);
    }

    @i
    private static <T> b<T> a(k<T> kVar, k<? super T> kVar2, k<? super T> kVar3, k<? super T> kVar4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(kVar);
        arrayList.add(kVar2);
        arrayList.add(kVar3);
        arrayList.add(kVar4);
        return a(arrayList);
    }

    @i
    private static <T> b<T> a(k<T> kVar, k<? super T> kVar2, k<? super T> kVar3, k<? super T> kVar4, k<? super T> kVar5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(kVar);
        arrayList.add(kVar2);
        arrayList.add(kVar3);
        arrayList.add(kVar4);
        arrayList.add(kVar5);
        return a(arrayList);
    }

    @i
    private static <T> b<T> a(k<T> kVar, k<? super T> kVar2, k<? super T> kVar3, k<? super T> kVar4, k<? super T> kVar5, k<? super T> kVar6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(kVar);
        arrayList.add(kVar2);
        arrayList.add(kVar3);
        arrayList.add(kVar4);
        arrayList.add(kVar5);
        arrayList.add(kVar6);
        return a(arrayList);
    }

    @i
    private static <T> b<T> a(k<? super T>... kVarArr) {
        return a(Arrays.asList(kVarArr));
    }

    public final /* bridge */ /* synthetic */ void a(g gVar, String str) {
        super.a(gVar, str);
    }

    public final boolean a(Object obj) {
        for (k<? super T> a2 : this.f4258a) {
            if (a2.a(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void describeTo(g gVar) {
        super.a(gVar, "or");
    }
}

package com.google.a.h.a;

import com.google.a.h.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final Map<Integer, Integer> f3244a = new HashMap();

    b() {
    }

    private Integer b(int i) {
        return this.f3244a.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        Integer num = this.f3244a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.f3244a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    /* access modifiers changed from: package-private */
    public final int[] a() {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (Map.Entry next : this.f3244a.entrySet()) {
            if (((Integer) next.getValue()).intValue() > i) {
                i = ((Integer) next.getValue()).intValue();
                arrayList.clear();
            } else if (((Integer) next.getValue()).intValue() != i) {
            }
            arrayList.add(next.getKey());
        }
        return a.a((Collection<Integer>) arrayList);
    }
}

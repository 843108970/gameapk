package com.google.a.g;

import com.google.a.a;
import com.google.a.e;
import com.google.a.g.a.a.d;
import com.google.a.m;
import com.google.a.q;
import com.google.a.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class p extends r {

    /* renamed from: a  reason: collision with root package name */
    private final r[] f3217a;

    public p(Map<e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(a.EAN_13) || collection.contains(a.UPC_A) || collection.contains(a.EAN_8) || collection.contains(a.UPC_E)) {
                arrayList.add(new q(map));
            }
            if (collection.contains(a.CODE_39)) {
                arrayList.add(new e(z));
            }
            if (collection.contains(a.CODE_93)) {
                arrayList.add(new g());
            }
            if (collection.contains(a.CODE_128)) {
                arrayList.add(new c());
            }
            if (collection.contains(a.ITF)) {
                arrayList.add(new n());
            }
            if (collection.contains(a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(a.RSS_14)) {
                arrayList.add(new com.google.a.g.a.e());
            }
            if (collection.contains(a.RSS_EXPANDED)) {
                arrayList.add(new d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new q(map));
            arrayList.add(new e());
            arrayList.add(new a());
            arrayList.add(new g());
            arrayList.add(new c());
            arrayList.add(new n());
            arrayList.add(new com.google.a.g.a.e());
            arrayList.add(new d());
        }
        this.f3217a = (r[]) arrayList.toArray(new r[arrayList.size()]);
    }

    public final r a(int i, com.google.a.c.a aVar, Map<e, ?> map) throws m {
        r[] rVarArr = this.f3217a;
        int i2 = 0;
        while (i2 < rVarArr.length) {
            try {
                return rVarArr[i2].a(i, aVar, map);
            } catch (q unused) {
                i2++;
            }
        }
        throw m.getNotFoundInstance();
    }

    public final void a() {
        for (r a2 : this.f3217a) {
            a2.a();
        }
    }
}

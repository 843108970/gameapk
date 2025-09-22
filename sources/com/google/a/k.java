package com.google.a;

import com.google.a.a.b;
import com.google.a.g.p;
import com.google.a.i.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class k implements p {

    /* renamed from: a  reason: collision with root package name */
    private Map<e, ?> f3348a;

    /* renamed from: b  reason: collision with root package name */
    private p[] f3349b;

    private void a(Map<e, ?> map) {
        this.f3348a = map;
        boolean z = false;
        boolean z2 = map != null && map.containsKey(e.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(a.UPC_A) || collection.contains(a.UPC_E) || collection.contains(a.EAN_13) || collection.contains(a.EAN_8) || collection.contains(a.CODABAR) || collection.contains(a.CODE_39) || collection.contains(a.CODE_93) || collection.contains(a.CODE_128) || collection.contains(a.ITF) || collection.contains(a.RSS_14) || collection.contains(a.RSS_EXPANDED)) {
                z = true;
            }
            if (z && !z2) {
                arrayList.add(new p(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new com.google.a.d.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new com.google.a.h.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new com.google.a.e.a());
            }
            if (z && z2) {
                arrayList.add(new p(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new p(map));
            }
            arrayList.add(new a());
            arrayList.add(new com.google.a.d.a());
            arrayList.add(new b());
            arrayList.add(new com.google.a.h.b());
            arrayList.add(new com.google.a.e.a());
            if (z2) {
                arrayList.add(new p(map));
            }
        }
        this.f3349b = (p[]) arrayList.toArray(new p[arrayList.size()]);
    }

    private r b(c cVar) throws m {
        if (this.f3349b == null) {
            a((Map<e, ?>) null);
        }
        return c(cVar);
    }

    private r c(c cVar) throws m {
        if (this.f3349b != null) {
            p[] pVarArr = this.f3349b;
            int length = pVarArr.length;
            int i = 0;
            while (i < length) {
                try {
                    return pVarArr[i].a(cVar, this.f3348a);
                } catch (q unused) {
                    i++;
                }
            }
        }
        throw m.getNotFoundInstance();
    }

    public final r a(c cVar) throws m {
        a((Map<e, ?>) null);
        return c(cVar);
    }

    public final r a(c cVar, Map<e, ?> map) throws m {
        a(map);
        return c(cVar);
    }

    public final void a() {
        if (this.f3349b != null) {
            for (p a2 : this.f3349b) {
                a2.a();
            }
        }
    }
}

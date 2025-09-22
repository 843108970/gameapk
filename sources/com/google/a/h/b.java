package com.google.a.h;

import android.support.v7.widget.ActivityChooserView;
import com.google.a.c.e;
import com.google.a.d;
import com.google.a.f.c;
import com.google.a.h;
import com.google.a.h.a.j;
import com.google.a.h.b.a;
import com.google.a.m;
import com.google.a.p;
import com.google.a.r;
import com.google.a.s;
import com.google.a.t;
import java.util.ArrayList;
import java.util.Map;

public final class b implements c, p {
    private static int a(t tVar, t tVar2) {
        if (tVar == null || tVar2 == null) {
            return 0;
        }
        return (int) Math.abs(tVar.f3356a - tVar2.f3356a);
    }

    private static int a(t[] tVarArr) {
        return Math.max(Math.max(a(tVarArr[0], tVarArr[4]), (a(tVarArr[6], tVarArr[2]) * 17) / 18), Math.max(a(tVarArr[1], tVarArr[5]), (a(tVarArr[7], tVarArr[3]) * 17) / 18));
    }

    private static r[] a(com.google.a.c cVar, boolean z) throws m, h, d {
        ArrayList arrayList = new ArrayList();
        com.google.a.h.b.b a2 = a.a(cVar, z);
        for (t[] next : a2.f3270b) {
            e a3 = j.a(a2.f3269a, next[4], next[5], next[6], next[7], Math.min(Math.min(b(next[0], next[4]), (b(next[6], next[2]) * 17) / 18), Math.min(b(next[1], next[5]), (b(next[7], next[3]) * 17) / 18)), Math.max(Math.max(a(next[0], next[4]), (a(next[6], next[2]) * 17) / 18), Math.max(a(next[1], next[5]), (a(next[7], next[3]) * 17) / 18)));
            r rVar = new r(a3.f3077c, a3.f3075a, next, com.google.a.a.PDF_417);
            rVar.a(s.ERROR_CORRECTION_LEVEL, a3.e);
            c cVar2 = (c) a3.h;
            if (cVar2 != null) {
                rVar.a(s.PDF417_EXTRA_METADATA, cVar2);
            }
            arrayList.add(rVar);
        }
        return (r[]) arrayList.toArray(new r[arrayList.size()]);
    }

    private static int b(t tVar, t tVar2) {
        return (tVar == null || tVar2 == null) ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) Math.abs(tVar.f3356a - tVar2.f3356a);
    }

    private static int b(t[] tVarArr) {
        return Math.min(Math.min(b(tVarArr[0], tVarArr[4]), (b(tVarArr[6], tVarArr[2]) * 17) / 18), Math.min(b(tVarArr[1], tVarArr[5]), (b(tVarArr[7], tVarArr[3]) * 17) / 18));
    }

    public final r a(com.google.a.c cVar) throws m, h, d {
        return a(cVar, (Map<com.google.a.e, ?>) null);
    }

    public final r a(com.google.a.c cVar, Map<com.google.a.e, ?> map) throws m, h, d {
        r[] a2 = a(cVar, false);
        if (a2 != null && a2.length != 0 && a2[0] != null) {
            return a2[0];
        }
        throw m.getNotFoundInstance();
    }

    public final void a() {
    }

    public final r[] a_(com.google.a.c cVar) throws m {
        return b(cVar);
    }

    public final r[] b(com.google.a.c cVar) throws m {
        try {
            return a(cVar, true);
        } catch (d | h unused) {
            throw m.getNotFoundInstance();
        }
    }
}

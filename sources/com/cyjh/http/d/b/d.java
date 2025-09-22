package com.cyjh.http.d.b;

import com.android.volley.i;
import com.android.volley.k;
import com.android.volley.l;
import com.android.volley.n;
import com.android.volley.toolbox.h;
import com.cyjh.http.d.a.a;
import java.util.Map;

public final class d extends l<Object> {
    private static final int n = 50000;
    private a m;
    private n.b<Object> o;
    private Map<String, String> p;

    private d(int i, String str, Map<String, String> map, n.b<Object> bVar, n.a aVar) {
        super(i, str, aVar);
        this.o = bVar;
        this.p = map;
        this.j = new com.android.volley.d(n, 0, 1.0f);
        this.g = false;
    }

    public d(String str, n.b<Object> bVar, n.a aVar, a aVar2) {
        this(0, str, (Map<String, String>) null, bVar, aVar);
        this.m = aVar2;
    }

    public d(String str, Map<String, String> map, n.b<Object> bVar, n.a aVar, a aVar2) {
        this(1, str, map, bVar, aVar);
        this.m = aVar2;
    }

    /* access modifiers changed from: protected */
    public final n<Object> a(i iVar) {
        try {
            String str = new String(iVar.f484b, "UTF-8");
            if (this.m != null) {
                return n.a(this.m.a(str), h.a(iVar));
            }
            return null;
        } catch (Exception e) {
            return n.a(new k((Throwable) e));
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Object obj) {
        if (this.o != null) {
            this.o.a(obj);
        }
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> e() throws com.android.volley.a {
        return this.p;
    }

    public final l.b h() {
        return l.b.HIGH;
    }
}

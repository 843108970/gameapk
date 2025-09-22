package com.b.a.a.e;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.b.a.a.a;
import com.b.a.a.b.g;
import com.b.a.a.c.c;
import com.b.a.a.c.j;
import com.b.a.a.c.l;
import com.b.a.aa;
import com.b.a.ab;
import com.b.a.ai;
import com.b.a.al;
import com.b.a.ao;
import com.b.a.as;
import com.b.a.at;
import com.b.a.au;
import com.b.b.i;
import com.b.b.n;
import com.b.b.w;
import com.b.b.x;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class h implements c {

    /* renamed from: b  reason: collision with root package name */
    private static final i f680b = i.a("connection");

    /* renamed from: c  reason: collision with root package name */
    private static final i f681c = i.a("host");
    private static final i d = i.a("keep-alive");
    private static final i e = i.a("proxy-connection");
    private static final i f = i.a("transfer-encoding");
    private static final i g = i.a("te");
    private static final i h = i.a("encoding");
    private static final i i = i.a("upgrade");
    private static final List<i> j = com.b.a.a.c.a((T[]) new i[]{f680b, f681c, d, e, g, f, h, i, c.f668c, c.d, c.e, c.f});
    private static final List<i> k = com.b.a.a.c.a((T[]) new i[]{f680b, f681c, d, e, g, f, h, i});

    /* renamed from: a  reason: collision with root package name */
    final g f682a;
    private final ai l;
    private final j m;
    private ab n;

    public h(ai aiVar, g gVar, j jVar) {
        this.l = aiVar;
        this.f682a = gVar;
        this.m = jVar;
    }

    public final at a(boolean z) {
        List<c> c2 = this.n.c();
        ab abVar = new ab();
        int size = c2.size();
        ab abVar2 = abVar;
        l lVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = c2.get(i2);
            if (cVar != null) {
                i iVar = cVar.g;
                String a2 = cVar.h.a();
                if (iVar.equals(c.f667b)) {
                    lVar = l.a("HTTP/1.1 " + a2);
                } else if (!k.contains(iVar)) {
                    a.f566a.a(abVar2, iVar.a(), a2);
                }
            } else if (lVar != null && lVar.f621b == 100) {
                abVar2 = new ab();
                lVar = null;
            }
        }
        if (lVar == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        at a3 = new at().a(al.HTTP_2).a(lVar.f621b).a(lVar.f622c).a(abVar2.a());
        if (!z || a.f566a.a(a3) != 100) {
            return a3;
        }
        return null;
    }

    public final au a(as asVar) {
        return new com.b.a.a.c.i(asVar.d(), n.a((x) new i(this, this.n.d())));
    }

    public final w a(ao aoVar, long j2) {
        return this.n.e();
    }

    public final void a() {
        this.m.p.b();
    }

    public final void a(ao aoVar) {
        if (this.n == null) {
            boolean z = aoVar.d() != null;
            aa c2 = aoVar.c();
            ArrayList arrayList = new ArrayList(c2.a() + 4);
            arrayList.add(new c(c.f668c, aoVar.b()));
            arrayList.add(new c(c.d, j.a(aoVar.a())));
            String a2 = aoVar.a(HttpHeaders.HOST);
            if (a2 != null) {
                arrayList.add(new c(c.f, a2));
            }
            arrayList.add(new c(c.e, aoVar.a().b()));
            int a3 = c2.a();
            for (int i2 = 0; i2 < a3; i2++) {
                i a4 = i.a(c2.a(i2).toLowerCase(Locale.US));
                if (!j.contains(a4)) {
                    arrayList.add(new c(a4, c2.b(i2)));
                }
            }
            this.n = this.m.a((List<c>) arrayList, z);
            this.n.f.a((long) this.l.b(), TimeUnit.MILLISECONDS);
            this.n.g.a((long) this.l.c(), TimeUnit.MILLISECONDS);
        }
    }

    public final void b() {
        this.n.e().close();
    }
}

package com.b.a.a.d;

import com.b.a.a.b.g;
import com.b.a.a.c.c;
import com.b.a.a.c.f;
import com.b.a.a.c.i;
import com.b.a.a.c.j;
import com.b.a.a.c.l;
import com.b.a.aa;
import com.b.a.ab;
import com.b.a.ac;
import com.b.a.ai;
import com.b.a.ao;
import com.b.a.as;
import com.b.a.at;
import com.b.a.au;
import com.b.b.h;
import com.b.b.k;
import com.b.b.n;
import com.b.b.w;
import com.b.b.x;
import com.b.b.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import org.apache.commons.io.IOUtils;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    final ai f625a;

    /* renamed from: b  reason: collision with root package name */
    final g f626b;

    /* renamed from: c  reason: collision with root package name */
    final h f627c;
    final com.b.b.g d;
    int e = 0;

    public a(ai aiVar, g gVar, h hVar, com.b.b.g gVar2) {
        this.f625a = aiVar;
        this.f626b = gVar;
        this.f627c = hVar;
        this.d = gVar2;
    }

    static void a(k kVar) {
        y a2 = kVar.a();
        kVar.a(y.f884b);
        a2.e_();
        a2.d_();
    }

    public final at a(boolean z) {
        if (this.e == 1 || this.e == 3) {
            try {
                l a2 = l.a(this.f627c.m());
                at a3 = new at().a(a2.f620a).a(a2.f621b).a(a2.f622c).a(c());
                if (z && a2.f621b == 100) {
                    return null;
                }
                this.e = 4;
                return a3;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f626b);
                iOException.initCause(e2);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.e);
        }
    }

    public final au a(as asVar) {
        x xVar;
        if (!f.b(asVar)) {
            xVar = a(0);
        } else if ("chunked".equalsIgnoreCase(asVar.a("Transfer-Encoding"))) {
            ac a2 = asVar.a().a();
            if (this.e != 4) {
                throw new IllegalStateException("state: " + this.e);
            }
            this.e = 5;
            xVar = new d(this, a2);
        } else {
            long a3 = f.a(asVar);
            if (a3 != -1) {
                xVar = a(a3);
            } else if (this.e != 4) {
                throw new IllegalStateException("state: " + this.e);
            } else if (this.f626b == null) {
                throw new IllegalStateException("streamAllocation == null");
            } else {
                this.e = 5;
                this.f626b.d();
                xVar = new g(this);
            }
        }
        return new i(asVar.d(), n.a(xVar));
    }

    public final w a(ao aoVar, long j) {
        if ("chunked".equalsIgnoreCase(aoVar.a("Transfer-Encoding"))) {
            if (this.e != 1) {
                throw new IllegalStateException("state: " + this.e);
            }
            this.e = 2;
            return new c(this);
        } else if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        } else if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        } else {
            this.e = 2;
            return new e(this, j);
        }
    }

    public final x a(long j) {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 5;
        return new f(this, j);
    }

    public final void a() {
        this.d.flush();
    }

    public final void a(aa aaVar, String str) {
        if (this.e != 0) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.d.b(str).b(IOUtils.LINE_SEPARATOR_WINDOWS);
        int a2 = aaVar.a();
        for (int i = 0; i < a2; i++) {
            this.d.b(aaVar.a(i)).b(": ").b(aaVar.b(i)).b(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        this.d.b(IOUtils.LINE_SEPARATOR_WINDOWS);
        this.e = 1;
    }

    public final void a(ao aoVar) {
        Proxy.Type type = this.f626b.b().a().b().type();
        StringBuilder sb = new StringBuilder();
        sb.append(aoVar.b());
        sb.append(' ');
        if (!aoVar.g() && type == Proxy.Type.HTTP) {
            sb.append(aoVar.a());
        } else {
            sb.append(j.a(aoVar.a()));
        }
        sb.append(" HTTP/1.1");
        a(aoVar.c(), sb.toString());
    }

    public final void b() {
        this.d.flush();
    }

    public final aa c() {
        ab abVar = new ab();
        while (true) {
            String m = this.f627c.m();
            if (m.length() == 0) {
                return abVar.a();
            }
            com.b.a.a.a.f566a.a(abVar, m);
        }
    }
}

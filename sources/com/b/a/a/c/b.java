package com.b.a.a.c;

import com.b.a.a.b.g;
import com.b.a.a.c;
import com.b.a.af;
import com.b.a.ag;
import com.b.a.ao;
import com.b.a.as;
import com.b.a.at;
import com.b.b.n;
import java.net.ProtocolException;

public final class b implements af {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f607a;

    public b(boolean z) {
        this.f607a = z;
    }

    public final as a(ag agVar) {
        h hVar = (h) agVar;
        c c2 = hVar.c();
        g b2 = hVar.b();
        ao a2 = agVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        c2.a(a2);
        at atVar = null;
        if (g.b(a2.b()) && a2.d() != null) {
            if ("100-continue".equalsIgnoreCase(a2.a("Expect"))) {
                c2.a();
                atVar = c2.a(true);
            }
            if (atVar == null) {
                com.b.b.g a3 = n.a(c2.a(a2, a2.d().b()));
                a2.d().a(a3);
                a3.close();
            }
        }
        c2.b();
        if (atVar == null) {
            atVar = c2.a(false);
        }
        as a4 = atVar.a(a2).a(b2.b().c()).a(currentTimeMillis).b(System.currentTimeMillis()).a();
        int b3 = a4.b();
        as a5 = ((!this.f607a || b3 != 101) ? a4.f().a(c2.a(a4)) : a4.f().a(c.f605c)).a();
        if ("close".equalsIgnoreCase(a5.a().a("Connection")) || "close".equalsIgnoreCase(a5.a("Connection"))) {
            b2.d();
        }
        if ((b3 != 204 && b3 != 205) || a5.e().b() <= 0) {
            return a5;
        }
        throw new ProtocolException("HTTP " + b3 + " had non-zero Content-Length: " + a5.e().b());
    }
}

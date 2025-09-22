package b.a.d;

import b.a.c.c;
import b.a.c.g;
import b.ac;
import b.ae;
import b.w;
import c.d;
import c.p;
import java.io.IOException;
import java.net.ProtocolException;

public final class b implements w {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f74a;

    public b(boolean z) {
        this.f74a = z;
    }

    public final ae intercept(w.a aVar) throws IOException {
        ae aeVar;
        g gVar = (g) aVar;
        c cVar = gVar.f83b;
        g gVar2 = gVar.f82a;
        c cVar2 = gVar.f84c;
        ac acVar = gVar.d;
        long currentTimeMillis = System.currentTimeMillis();
        cVar.a(acVar);
        ae.a aVar2 = null;
        if (f.c(acVar.f248b) && acVar.d != null) {
            if ("100-continue".equalsIgnoreCase(acVar.a("Expect"))) {
                cVar.a();
                aVar2 = cVar.a(true);
            }
            if (aVar2 == null) {
                d a2 = p.a(cVar.a(acVar, acVar.d.contentLength()));
                acVar.d.writeTo(a2);
                a2.close();
            } else if (!cVar2.e()) {
                gVar2.d();
            }
        }
        cVar.b();
        if (aVar2 == null) {
            aVar2 = cVar.a(false);
        }
        aVar2.f263a = acVar;
        aVar2.e = gVar2.b().d;
        aVar2.k = currentTimeMillis;
        aVar2.l = System.currentTimeMillis();
        ae a3 = aVar2.a();
        int i = a3.f262c;
        if (!this.f74a || i != 101) {
            ae.a e = a3.e();
            e.g = cVar.a(a3);
            aeVar = e.a();
        } else {
            ae.a e2 = a3.e();
            e2.g = b.a.c.f53c;
            aeVar = e2.a();
        }
        if ("close".equalsIgnoreCase(aeVar.f260a.a("Connection")) || "close".equalsIgnoreCase(aeVar.a("Connection"))) {
            gVar2.d();
        }
        if ((i != 204 && i != 205) || aeVar.g.contentLength() <= 0) {
            return aeVar;
        }
        throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + aeVar.g.contentLength());
    }
}

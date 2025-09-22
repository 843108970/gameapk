package com.b.a;

import com.b.a.a.a;
import com.b.a.a.b.c;
import com.b.a.a.b.d;
import com.b.a.a.b.g;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

final class aj extends a {
    aj() {
    }

    public final int a(at atVar) {
        return atVar.f789c;
    }

    public final c a(n nVar, a aVar, g gVar) {
        return nVar.a(aVar, gVar);
    }

    public final d a(n nVar) {
        return nVar.f819a;
    }

    public final void a(ab abVar, String str) {
        int indexOf = str.indexOf(":", 1);
        if (indexOf != -1) {
            abVar.b(str.substring(0, indexOf), str.substring(indexOf + 1));
        } else if (str.startsWith(":")) {
            abVar.b("", str.substring(1));
        } else {
            abVar.b("", str);
        }
    }

    public final void a(ab abVar, String str, String str2) {
        abVar.b(str, str2);
    }

    public final void a(p pVar, SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites = pVar.f != null ? (String[]) com.b.a.a.c.a(String.class, (T[]) pVar.f, (T[]) sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
        String[] enabledProtocols = pVar.g != null ? (String[]) com.b.a.a.c.a(String.class, (T[]) pVar.g, (T[]) sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
        if (z && com.b.a.a.c.a((T[]) sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV") != -1) {
            enabledCipherSuites = com.b.a.a.c.a(enabledCipherSuites, "TLS_FALLBACK_SCSV");
        }
        p b2 = new q(pVar).a(enabledCipherSuites).b(enabledProtocols).b();
        if (b2.g != null) {
            sSLSocket.setEnabledProtocols(b2.g);
        }
        if (b2.f != null) {
            sSLSocket.setEnabledCipherSuites(b2.f);
        }
    }

    public final boolean a(n nVar, c cVar) {
        return nVar.b(cVar);
    }

    public final Socket b(n nVar, a aVar, g gVar) {
        return nVar.b(aVar, gVar);
    }

    public final void b(n nVar, c cVar) {
        nVar.a(cVar);
    }
}

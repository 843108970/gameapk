package com.b.a.a.a;

import com.android.volley.toolbox.g;
import com.b.a.a.c;
import com.b.a.a.c.f;
import com.b.a.a.c.i;
import com.b.a.aa;
import com.b.a.ab;
import com.b.a.af;
import com.b.a.ag;
import com.b.a.al;
import com.b.a.ao;
import com.b.a.as;
import com.b.a.at;
import com.b.a.au;
import com.b.b.n;
import com.b.b.w;
import com.b.b.x;
import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import com.github.kevinsawicki.http.HttpRequest;
import java.io.Closeable;

public final class a implements af {

    /* renamed from: a  reason: collision with root package name */
    final i f567a;

    public a(i iVar) {
        this.f567a = iVar;
    }

    private static as a(as asVar) {
        return (asVar == null || asVar.e() == null) ? asVar : asVar.f().a((au) null).a();
    }

    private static boolean a(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !HttpRequest.HEADER_PROXY_AUTHORIZATION.equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    public final as a(ag agVar) {
        w a2;
        at b2;
        c cVar = null;
        as a3 = this.f567a != null ? this.f567a.a() : null;
        d a4 = new e(System.currentTimeMillis(), agVar.a(), a3).a();
        ao aoVar = a4.f571a;
        as asVar = a4.f572b;
        if (a3 != null && asVar == null) {
            c.a((Closeable) a3.e());
        }
        if (aoVar == null && asVar == null) {
            b2 = new at().a(agVar.a()).a(al.HTTP_1_1).a((int) UiMessage.CommandToUi.Command_Type.SET_FULLSCREEN_VALUE).a("Unsatisfiable Request (only-if-cached)").a(c.f605c).a(-1).b(System.currentTimeMillis());
        } else if (aoVar == null) {
            b2 = asVar.f().b(a(asVar));
        } else {
            try {
                as a5 = agVar.a(aoVar);
                if (a5 == null && a3 != null) {
                }
                if (asVar != null) {
                    if (a5.b() == 304) {
                        at f = asVar.f();
                        aa d = asVar.d();
                        aa d2 = a5.d();
                        ab abVar = new ab();
                        int a6 = d.a();
                        for (int i = 0; i < a6; i++) {
                            String a7 = d.a(i);
                            String b3 = d.b(i);
                            if ((!"Warning".equalsIgnoreCase(a7) || !b3.startsWith("1")) && (!a(a7) || d2.a(a7) == null)) {
                                com.b.a.a.a.f566a.a(abVar, a7, b3);
                            }
                        }
                        int a8 = d2.a();
                        for (int i2 = 0; i2 < a8; i2++) {
                            String a9 = d2.a(i2);
                            if (!"Content-Length".equalsIgnoreCase(a9) && a(a9)) {
                                com.b.a.a.a.f566a.a(abVar, a9, d2.b(i2));
                            }
                        }
                        as a10 = f.a(abVar.a()).a(a5.h()).b(a5.i()).b(a(asVar)).a(a(a5)).a();
                        a5.e().close();
                        return a10;
                    }
                    c.a((Closeable) asVar.e());
                }
                as a11 = a5.f().b(a(asVar)).a(a(a5)).a();
                if (!f.b(a11)) {
                    return a11;
                }
                ao a12 = a5.a();
                i iVar = this.f567a;
                if (iVar != null) {
                    if (!d.a(a11, a12)) {
                        String b4 = a12.b();
                        if (!b4.equals("POST") && !b4.equals(g.a.f536a) && !b4.equals(HttpRequest.METHOD_PUT) && !b4.equals(HttpRequest.METHOD_DELETE)) {
                            b4.equals("MOVE");
                        }
                    } else {
                        cVar = iVar.b();
                    }
                }
                if (cVar == null || (a2 = cVar.a()) == null) {
                    return a11;
                }
                return a11.f().a((au) new i(a11.d(), n.a((x) new b(this, a11.e().c(), cVar, n.a(a2))))).a();
            } finally {
                if (a3 != null) {
                    c.a((Closeable) a3.e());
                }
            }
        }
        return b2.a();
    }
}

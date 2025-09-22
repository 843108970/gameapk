package com.b.a.a.c;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.b.a.a.c;
import com.b.a.aa;
import com.b.a.af;
import com.b.a.ag;
import com.b.a.ah;
import com.b.a.ao;
import com.b.a.ap;
import com.b.a.aq;
import com.b.a.as;
import com.b.a.at;
import com.b.a.au;
import com.b.a.r;
import com.b.a.s;
import com.b.b.l;
import com.b.b.n;
import com.b.b.x;
import com.github.kevinsawicki.http.HttpRequest;
import java.util.List;

public final class a implements af {

    /* renamed from: a  reason: collision with root package name */
    private final s f606a;

    public a(s sVar) {
        this.f606a = sVar;
    }

    public final as a(ag agVar) {
        boolean z;
        String str;
        ao a2 = agVar.a();
        ap e = a2.e();
        aq d = a2.d();
        if (d != null) {
            ah a3 = d.a();
            if (a3 != null) {
                e.a("Content-Type", a3.toString());
            }
            long b2 = d.b();
            if (b2 != -1) {
                e.a("Content-Length", Long.toString(b2));
                str = "Transfer-Encoding";
            } else {
                e.a("Transfer-Encoding", "chunked");
                str = "Content-Length";
            }
            e.b(str);
        }
        if (a2.a(HttpHeaders.HOST) == null) {
            e.a(HttpHeaders.HOST, c.a(a2.a(), false));
        }
        if (a2.a("Connection") == null) {
            e.a("Connection", "Keep-Alive");
        }
        if (a2.a(HttpRequest.HEADER_ACCEPT_ENCODING) == null && a2.a(HttpHeaders.RANGE) == null) {
            e.a(HttpRequest.HEADER_ACCEPT_ENCODING, HttpRequest.ENCODING_GZIP);
            z = true;
        } else {
            z = false;
        }
        List<r> b3 = this.f606a.b();
        if (!b3.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = b3.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append("; ");
                }
                r rVar = b3.get(i);
                sb.append(rVar.a());
                sb.append('=');
                sb.append(rVar.b());
            }
            e.a("Cookie", sb.toString());
        }
        if (a2.a("User-Agent") == null) {
            e.a("User-Agent", "okhttp/3.6.0");
        }
        as a4 = agVar.a(e.a());
        f.a(this.f606a, a2.a(), a4.d());
        at a5 = a4.f().a(a2);
        if (z && HttpRequest.ENCODING_GZIP.equalsIgnoreCase(a4.a("Content-Encoding")) && f.b(a4)) {
            l lVar = new l(a4.e().c());
            aa a6 = a4.d().b().a("Content-Encoding").a("Content-Length").a();
            a5.a(a6);
            a5.a((au) new i(a6, n.a((x) lVar)));
        }
        return a5.a();
    }
}

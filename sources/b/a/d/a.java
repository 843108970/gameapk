package b.a.d;

import b.a.c;
import b.ac;
import b.ad;
import b.ae;
import b.m;
import b.n;
import b.u;
import b.w;
import b.x;
import c.l;
import c.p;
import c.y;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.github.kevinsawicki.http.HttpRequest;
import java.io.IOException;
import java.util.List;

public final class a implements w {

    /* renamed from: a  reason: collision with root package name */
    private final n f73a;

    public a(n nVar) {
        this.f73a = nVar;
    }

    private static String a(List<m> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            m mVar = list.get(i);
            sb.append(mVar.f330a);
            sb.append('=');
            sb.append(mVar.f331b);
        }
        return sb.toString();
    }

    public final ae intercept(w.a aVar) throws IOException {
        boolean z;
        String str;
        ac a2 = aVar.a();
        ac.a c2 = a2.c();
        ad adVar = a2.d;
        if (adVar != null) {
            x contentType = adVar.contentType();
            if (contentType != null) {
                c2.a("Content-Type", contentType.toString());
            }
            long contentLength = adVar.contentLength();
            if (contentLength != -1) {
                c2.a("Content-Length", Long.toString(contentLength));
                str = "Transfer-Encoding";
            } else {
                c2.a("Transfer-Encoding", "chunked");
                str = "Content-Length";
            }
            c2.b(str);
        }
        if (a2.a(HttpHeaders.HOST) == null) {
            c2.a(HttpHeaders.HOST, c.a(a2.f247a, false));
        }
        if (a2.a("Connection") == null) {
            c2.a("Connection", "Keep-Alive");
        }
        if (a2.a(HttpRequest.HEADER_ACCEPT_ENCODING) == null && a2.a(HttpHeaders.RANGE) == null) {
            c2.a(HttpRequest.HEADER_ACCEPT_ENCODING, HttpRequest.ENCODING_GZIP);
            z = true;
        } else {
            z = false;
        }
        List<m> b2 = this.f73a.b();
        if (!b2.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = b2.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append("; ");
                }
                m mVar = b2.get(i);
                sb.append(mVar.f330a);
                sb.append('=');
                sb.append(mVar.f331b);
            }
            c2.a("Cookie", sb.toString());
        }
        if (a2.a("User-Agent") == null) {
            c2.a("User-Agent", "okhttp/3.8.0");
        }
        ae a3 = aVar.a(c2.d());
        e.a(this.f73a, a2.f247a, a3.f);
        ae.a e = a3.e();
        e.f263a = a2;
        if (z && HttpRequest.ENCODING_GZIP.equalsIgnoreCase(a3.a("Content-Encoding")) && e.d(a3)) {
            l lVar = new l(a3.g.source());
            u a4 = a3.f.b().b("Content-Encoding").b("Content-Length").a();
            e.a(a4);
            e.g = new h(a4, p.a((y) lVar));
        }
        return e.a();
    }
}

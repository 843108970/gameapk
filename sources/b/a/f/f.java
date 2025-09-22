package b.a.f;

import b.a.c.g;
import b.a.d.c;
import b.a.d.h;
import b.a.d.k;
import b.aa;
import b.ac;
import b.ae;
import b.af;
import b.u;
import b.z;
import c.i;
import c.p;
import c.x;
import c.y;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class f implements c {

    /* renamed from: c  reason: collision with root package name */
    private static final c.f f119c = c.f.encodeUtf8("connection");
    private static final c.f d = c.f.encodeUtf8("host");
    private static final c.f e = c.f.encodeUtf8("keep-alive");
    private static final c.f f = c.f.encodeUtf8("proxy-connection");
    private static final c.f g = c.f.encodeUtf8("transfer-encoding");
    private static final c.f h = c.f.encodeUtf8("te");
    private static final c.f i = c.f.encodeUtf8("encoding");
    private static final c.f j = c.f.encodeUtf8("upgrade");
    private static final List<c.f> k = b.a.c.a((T[]) new c.f[]{f119c, d, e, f, h, g, i, j, c.f106c, c.d, c.e, c.f});
    private static final List<c.f> l = b.a.c.a((T[]) new c.f[]{f119c, d, e, f, h, g, i, j});

    /* renamed from: b  reason: collision with root package name */
    final g f120b;
    private final z m;
    private final g n;
    private i o;

    class a extends i {
        a(y yVar) {
            super(yVar);
        }

        public final void close() throws IOException {
            f.this.f120b.a(false, (c) f.this);
            super.close();
        }
    }

    public f(z zVar, g gVar, g gVar2) {
        this.m = zVar;
        this.f120b = gVar;
        this.n = gVar2;
    }

    private static ae.a a(List<c> list) throws IOException {
        u.a aVar = new u.a();
        int size = list.size();
        u.a aVar2 = aVar;
        k kVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = list.get(i2);
            if (cVar != null) {
                c.f fVar = cVar.g;
                String utf8 = cVar.h.utf8();
                if (fVar.equals(c.f105b)) {
                    kVar = k.a("HTTP/1.1 " + utf8);
                } else if (!l.contains(fVar)) {
                    b.a.a.f11a.a(aVar2, fVar.utf8(), utf8);
                }
            } else if (kVar != null && kVar.e == 100) {
                aVar2 = new u.a();
                kVar = null;
            }
        }
        if (kVar == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        ae.a aVar3 = new ae.a();
        aVar3.f264b = aa.HTTP_2;
        aVar3.f265c = kVar.e;
        aVar3.d = kVar.f;
        return aVar3.a(aVar2.a());
    }

    private static List<c> b(ac acVar) {
        u uVar = acVar.f249c;
        ArrayList arrayList = new ArrayList((uVar.f350a.length / 2) + 4);
        arrayList.add(new c(c.f106c, acVar.f248b));
        arrayList.add(new c(c.d, b.a.d.i.a(acVar.f247a)));
        String a2 = acVar.a(HttpHeaders.HOST);
        if (a2 != null) {
            arrayList.add(new c(c.f, a2));
        }
        arrayList.add(new c(c.e, acVar.f247a.k));
        int length = uVar.f350a.length / 2;
        for (int i2 = 0; i2 < length; i2++) {
            c.f encodeUtf8 = c.f.encodeUtf8(uVar.a(i2).toLowerCase(Locale.US));
            if (!k.contains(encodeUtf8)) {
                arrayList.add(new c(encodeUtf8, uVar.b(i2)));
            }
        }
        return arrayList;
    }

    public final ae.a a(boolean z) throws IOException {
        List<c> c2 = this.o.c();
        u.a aVar = new u.a();
        int size = c2.size();
        u.a aVar2 = aVar;
        k kVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = c2.get(i2);
            if (cVar != null) {
                c.f fVar = cVar.g;
                String utf8 = cVar.h.utf8();
                if (fVar.equals(c.f105b)) {
                    kVar = k.a("HTTP/1.1 " + utf8);
                } else if (!l.contains(fVar)) {
                    b.a.a.f11a.a(aVar2, fVar.utf8(), utf8);
                }
            } else if (kVar != null && kVar.e == 100) {
                aVar2 = new u.a();
                kVar = null;
            }
        }
        if (kVar == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        ae.a aVar3 = new ae.a();
        aVar3.f264b = aa.HTTP_2;
        aVar3.f265c = kVar.e;
        aVar3.d = kVar.f;
        ae.a a2 = aVar3.a(aVar2.a());
        if (!z || b.a.a.f11a.a(a2) != 100) {
            return a2;
        }
        return null;
    }

    public final af a(ae aeVar) throws IOException {
        return new h(aeVar.f, p.a((y) new a(this.o.g)));
    }

    public final x a(ac acVar, long j2) {
        return this.o.d();
    }

    public final void a() throws IOException {
        this.n.q.b();
    }

    public final void a(ac acVar) throws IOException {
        if (this.o == null) {
            boolean z = acVar.d != null;
            u uVar = acVar.f249c;
            ArrayList arrayList = new ArrayList((uVar.f350a.length / 2) + 4);
            arrayList.add(new c(c.f106c, acVar.f248b));
            arrayList.add(new c(c.d, b.a.d.i.a(acVar.f247a)));
            String a2 = acVar.a(HttpHeaders.HOST);
            if (a2 != null) {
                arrayList.add(new c(c.f, a2));
            }
            arrayList.add(new c(c.e, acVar.f247a.k));
            int length = uVar.f350a.length / 2;
            for (int i2 = 0; i2 < length; i2++) {
                c.f encodeUtf8 = c.f.encodeUtf8(uVar.a(i2).toLowerCase(Locale.US));
                if (!k.contains(encodeUtf8)) {
                    arrayList.add(new c(encodeUtf8, uVar.b(i2)));
                }
            }
            this.o = this.n.a(0, (List<c>) arrayList, z);
            this.o.i.a((long) this.m.A, TimeUnit.MILLISECONDS);
            this.o.j.a((long) this.m.B, TimeUnit.MILLISECONDS);
        }
    }

    public final void b() throws IOException {
        this.o.d().close();
    }

    public final void c() {
        if (this.o != null) {
            this.o.b(b.CANCEL);
        }
    }
}

package b.a.d;

import b.af;
import b.u;
import b.x;
import c.e;

public final class h extends af {

    /* renamed from: a  reason: collision with root package name */
    private final u f85a;

    /* renamed from: b  reason: collision with root package name */
    private final e f86b;

    public h(u uVar, e eVar) {
        this.f85a = uVar;
        this.f86b = eVar;
    }

    public final long contentLength() {
        return e.a(this.f85a);
    }

    public final x contentType() {
        String a2 = this.f85a.a("Content-Type");
        if (a2 != null) {
            return x.a(a2);
        }
        return null;
    }

    public final e source() {
        return this.f86b;
    }
}

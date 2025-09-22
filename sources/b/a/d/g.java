package b.a.d;

import b.a.c.c;
import b.ac;
import b.ae;
import b.j;
import b.w;
import java.io.IOException;
import java.util.List;

public final class g implements w.a {

    /* renamed from: a  reason: collision with root package name */
    public final b.a.c.g f82a;

    /* renamed from: b  reason: collision with root package name */
    final c f83b;

    /* renamed from: c  reason: collision with root package name */
    final c f84c;
    public final ac d;
    private final List<w> e;
    private final int f;
    private int g;

    public g(List<w> list, b.a.c.g gVar, c cVar, c cVar2, int i, ac acVar) {
        this.e = list;
        this.f84c = cVar2;
        this.f82a = gVar;
        this.f83b = cVar;
        this.f = i;
        this.d = acVar;
    }

    private b.a.c.g c() {
        return this.f82a;
    }

    private c d() {
        return this.f83b;
    }

    public final ac a() {
        return this.d;
    }

    public final ae a(ac acVar) throws IOException {
        return a(acVar, this.f82a, this.f83b, this.f84c);
    }

    public final ae a(ac acVar, b.a.c.g gVar, c cVar, c cVar2) throws IOException {
        if (this.f >= this.e.size()) {
            throw new AssertionError();
        }
        this.g++;
        if (this.f83b != null && !this.f84c.a(acVar.f247a)) {
            throw new IllegalStateException("network interceptor " + this.e.get(this.f - 1) + " must retain the same host and port");
        } else if (this.f83b == null || this.g <= 1) {
            g gVar2 = new g(this.e, gVar, cVar, cVar2, this.f + 1, acVar);
            w wVar = this.e.get(this.f);
            ae intercept = wVar.intercept(gVar2);
            if (cVar != null && this.f + 1 < this.e.size() && gVar2.g != 1) {
                throw new IllegalStateException("network interceptor " + wVar + " must call proceed() exactly once");
            } else if (intercept != null) {
                return intercept;
            } else {
                throw new NullPointerException("interceptor " + wVar + " returned null");
            }
        } else {
            throw new IllegalStateException("network interceptor " + this.e.get(this.f - 1) + " must call proceed() exactly once");
        }
    }

    public final j b() {
        return this.f84c;
    }
}

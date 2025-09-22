package com.b.a.a.c;

import com.b.a.a.b.g;
import com.b.a.ac;
import com.b.a.af;
import com.b.a.ag;
import com.b.a.ao;
import com.b.a.as;
import com.b.a.m;
import java.util.List;

public final class h implements ag {

    /* renamed from: a  reason: collision with root package name */
    private final List<af> f612a;

    /* renamed from: b  reason: collision with root package name */
    private final g f613b;

    /* renamed from: c  reason: collision with root package name */
    private final c f614c;
    private final m d;
    private final int e;
    private final ao f;
    private int g;

    public h(List<af> list, g gVar, c cVar, m mVar, int i, ao aoVar) {
        this.f612a = list;
        this.d = mVar;
        this.f613b = gVar;
        this.f614c = cVar;
        this.e = i;
        this.f = aoVar;
    }

    public final ao a() {
        return this.f;
    }

    public final as a(ao aoVar) {
        return a(aoVar, this.f613b, this.f614c, this.d);
    }

    public final as a(ao aoVar, g gVar, c cVar, m mVar) {
        if (this.e >= this.f612a.size()) {
            throw new AssertionError();
        }
        this.g++;
        if (this.f614c != null) {
            ac a2 = aoVar.a();
            if (!(a2.f().equals(this.d.a().a().a().f()) && a2.g() == this.d.a().a().a().g())) {
                throw new IllegalStateException("network interceptor " + this.f612a.get(this.e - 1) + " must retain the same host and port");
            }
        }
        if (this.f614c == null || this.g <= 1) {
            h hVar = new h(this.f612a, gVar, cVar, mVar, this.e + 1, aoVar);
            af afVar = this.f612a.get(this.e);
            as a3 = afVar.a(hVar);
            if (cVar != null && this.e + 1 < this.f612a.size() && hVar.g != 1) {
                throw new IllegalStateException("network interceptor " + afVar + " must call proceed() exactly once");
            } else if (a3 != null) {
                return a3;
            } else {
                throw new NullPointerException("interceptor " + afVar + " returned null");
            }
        } else {
            throw new IllegalStateException("network interceptor " + this.f612a.get(this.e - 1) + " must call proceed() exactly once");
        }
    }

    public final g b() {
        return this.f613b;
    }

    public final c c() {
        return this.f614c;
    }
}

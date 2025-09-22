package org.jdeferred.a;

import org.jdeferred.g;
import org.jdeferred.h;
import org.jdeferred.j;
import org.jdeferred.k;
import org.jdeferred.m;
import org.jdeferred.n;
import org.jdeferred.p;

public final class f<D, F, P, D_OUT, F_OUT, P_OUT> extends d<D_OUT, F_OUT, P_OUT> implements p<D_OUT, F_OUT, P_OUT> {

    /* renamed from: a  reason: collision with root package name */
    protected static final a f4372a = new a();
    protected static final b j = new b();
    protected static final c k = new c();
    /* access modifiers changed from: private */
    public final h<D, D_OUT> l;
    /* access modifiers changed from: private */
    public final k<F, F_OUT> m;
    /* access modifiers changed from: private */
    public final n<P, P_OUT> n;

    public static final class a<D> implements h<D, D> {
        public final D a(D d) {
            return d;
        }
    }

    public static final class b<F> implements k<F, F> {
        public final F a(F f) {
            return f;
        }
    }

    public static final class c<P> implements n<P, P> {
        public final P a(P p) {
            return p;
        }
    }

    public f(p<D, F, P> pVar, h<D, D_OUT> hVar, k<F, F_OUT> kVar, n<P, P_OUT> nVar) {
        this.l = hVar == null ? f4372a : hVar;
        this.m = kVar == null ? j : kVar;
        this.n = nVar == null ? k : nVar;
        pVar.b(new g<D>() {
            public final void a(D d) {
                f.this.a(f.this.l.a(d));
            }
        }).a(new j<F>() {
            public final void a(F f) {
                f.this.b(f.this.m.a(f));
            }
        }).a(new m<P>() {
            public final void a(P p) {
                f.this.c(f.this.n.a(p));
            }
        });
    }
}

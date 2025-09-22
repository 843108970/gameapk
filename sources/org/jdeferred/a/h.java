package org.jdeferred.a;

import org.jdeferred.g;
import org.jdeferred.i;
import org.jdeferred.j;
import org.jdeferred.l;
import org.jdeferred.m;
import org.jdeferred.o;
import org.jdeferred.p;

public final class h<D, F, P, D_OUT, F_OUT, P_OUT> extends d<D_OUT, F_OUT, P_OUT> implements p<D_OUT, F_OUT, P_OUT> {
    public h(p<D, F, P> pVar, final i<D, D_OUT, F_OUT, P_OUT> iVar, final l<F, D_OUT, F_OUT, P_OUT> lVar, final o<P, D_OUT, F_OUT, P_OUT> oVar) {
        pVar.b(new g<D>() {
            public final void a(D d) {
                if (iVar != null) {
                    h.this.a(iVar.a());
                } else {
                    h.this.a(d);
                }
            }
        }).a(new j<F>() {
            public final void a(F f) {
                if (lVar != null) {
                    h.this.a(lVar.a());
                } else {
                    h.this.b(f);
                }
            }
        }).a(new m<P>() {
            public final void a(P p) {
                if (oVar != null) {
                    h.this.a(oVar.a());
                } else {
                    h.this.c(p);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public final p<D_OUT, F_OUT, P_OUT> a(p<D_OUT, F_OUT, P_OUT> pVar) {
        pVar.b(new g<D_OUT>() {
            public final void a(D_OUT d_out) {
                h.this.a(d_out);
            }
        }).a(new j<F_OUT>() {
            public final void a(F_OUT f_out) {
                h.this.b(f_out);
            }
        }).a(new m<P_OUT>() {
            public final void a(P_OUT p_out) {
                h.this.c(p_out);
            }
        });
        return pVar;
    }
}

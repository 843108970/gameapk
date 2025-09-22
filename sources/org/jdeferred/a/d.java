package org.jdeferred.a;

import org.jdeferred.b;
import org.jdeferred.p;

public class d<D, F, P> extends b<D, F, P> implements b<D, F, P> {
    public final b<D, F, P> a(D d) {
        synchronized (this) {
            if (!c()) {
                throw new IllegalStateException("Deferred object already finished, cannot resolve again");
            }
            this.f4367c = p.a.RESOLVED$173726b0;
            this.h = d;
            try {
                d(d);
            } finally {
                a(this.f4367c, d, null);
            }
        }
        return this;
    }

    public final p<D, F, P> a() {
        return this;
    }

    public final b<D, F, P> b(F f) {
        synchronized (this) {
            if (!c()) {
                throw new IllegalStateException("Deferred object already finished, cannot reject again");
            }
            this.f4367c = p.a.REJECTED$173726b0;
            this.i = f;
            try {
                e(f);
            } finally {
                a(this.f4367c, null, f);
            }
        }
        return this;
    }

    public final b<D, F, P> c(P p) {
        synchronized (this) {
            if (!c()) {
                throw new IllegalStateException("Deferred object already finished, cannot notify progress");
            }
            f(p);
        }
        return this;
    }
}

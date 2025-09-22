package org.jdeferred.android;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.jdeferred.a.d;
import org.jdeferred.g;
import org.jdeferred.j;
import org.jdeferred.m;
import org.jdeferred.p;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class c<D, F, P> extends d<D, F, P> {
    private static final b j = new b();
    private static final int k = 1;
    private static final int l = 2;
    private static final int m = 3;
    private static final int n = 4;

    /* renamed from: a  reason: collision with root package name */
    protected final Logger f4386a;
    private final int o;

    private static class a<Callback, D, F, P> {

        /* renamed from: a  reason: collision with root package name */
        final org.jdeferred.b f4390a;

        /* renamed from: b  reason: collision with root package name */
        final Callback f4391b;

        /* renamed from: c  reason: collision with root package name */
        final D f4392c;
        final F d;
        final P e;
        final int f;

        a(org.jdeferred.b bVar, Callback callback, int i, D d2, F f2, P p) {
            this.f4390a = bVar;
            this.f4391b = callback;
            this.f = i;
            this.f4392c = d2;
            this.d = f2;
            this.e = p;
        }
    }

    private static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    ((g) aVar.f4391b).a(aVar.f4392c);
                    return;
                case 2:
                    ((m) aVar.f4391b).a(aVar.e);
                    return;
                case 3:
                    ((j) aVar.f4391b).a(aVar.d);
                    return;
                default:
                    return;
            }
        }
    }

    public c(p<D, F, P> pVar) {
        this(pVar, e.UI$7dcf2b73);
    }

    public c(p<D, F, P> pVar, int i) {
        this.f4386a = LoggerFactory.getLogger(c.class);
        this.o = i;
        pVar.b(new g<D>() {
            public final void a(D d) {
                c.this.a(d);
            }
        }).a(new m<P>() {
            public final void a(P p) {
                c.this.c(p);
            }
        }).a(new j<F>() {
            public final void a(F f) {
                c.this.b(f);
            }
        });
    }

    private <Callback> void a(int i, Callback callback, int i2, D d, F f, P p) {
        j.obtainMessage(i, new a(this, callback, i2, d, f, p)).sendToTarget();
    }

    private int g(Object obj) {
        int a2 = obj instanceof f ? ((f) obj).a() : 0;
        return a2 == 0 ? this.o : a2;
    }

    /* access modifiers changed from: protected */
    public final void a(org.jdeferred.a<D, F> aVar, int i, D d, F f) {
        if (g(aVar) == e.UI$7dcf2b73) {
            a(4, aVar, i, d, f, (Object) null);
        } else {
            super.a(aVar, i, d, f);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(g<D> gVar, D d) {
        if (g(gVar) == e.UI$7dcf2b73) {
            a(1, gVar, p.a.RESOLVED$173726b0, d, (Object) null, (Object) null);
            return;
        }
        super.a(gVar, d);
    }

    /* access modifiers changed from: protected */
    public final void a(j<F> jVar, F f) {
        if (g(jVar) == e.UI$7dcf2b73) {
            a(3, jVar, p.a.REJECTED$173726b0, (Object) null, f, (Object) null);
            return;
        }
        super.a(jVar, f);
    }

    /* access modifiers changed from: protected */
    public final void a(m<P> mVar, P p) {
        if (g(mVar) == e.UI$7dcf2b73) {
            a(2, mVar, p.a.PENDING$173726b0, (Object) null, (Object) null, p);
            return;
        }
        super.a(mVar, p);
    }
}

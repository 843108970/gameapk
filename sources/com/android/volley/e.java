package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class e implements o {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f474a;

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final l f478b;

        /* renamed from: c  reason: collision with root package name */
        private final n f479c;
        private final Runnable d;

        public a(l lVar, n nVar, Runnable runnable) {
            this.f478b = lVar;
            this.f479c = nVar;
            this.d = runnable;
        }

        public final void run() {
            if (this.f478b.a()) {
                this.f478b.b("canceled-at-delivery");
                return;
            }
            if (this.f479c.f502c == null) {
                this.f478b.a(this.f479c.f500a);
            } else {
                l lVar = this.f478b;
                s sVar = this.f479c.f502c;
                if (lVar.d != null) {
                    lVar.d.a(sVar);
                }
            }
            if (this.f479c.d) {
                this.f478b.a("intermediate-response");
            } else {
                this.f478b.b("done");
            }
            if (this.d != null) {
                this.d.run();
            }
        }
    }

    public e(final Handler handler) {
        this.f474a = new Executor() {
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    private e(Executor executor) {
        this.f474a = executor;
    }

    public final void a(l<?> lVar, n<?> nVar) {
        a(lVar, nVar, (Runnable) null);
    }

    public final void a(l<?> lVar, n<?> nVar, Runnable runnable) {
        lVar.i = true;
        lVar.a("post-response");
        this.f474a.execute(new a(lVar, nVar, runnable));
    }

    public final void a(l<?> lVar, s sVar) {
        lVar.a("post-error");
        this.f474a.execute(new a(lVar, n.a(sVar), (Runnable) null));
    }
}

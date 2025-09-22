package b;

import android.support.v4.app.NotificationCompat;
import b.a.b;
import b.a.c.g;
import b.a.d.c;
import b.a.d.j;
import b.a.h.e;
import b.r;
import java.io.IOException;
import java.util.ArrayList;

final class ab implements e {

    /* renamed from: a  reason: collision with root package name */
    final z f242a;

    /* renamed from: b  reason: collision with root package name */
    final j f243b;

    /* renamed from: c  reason: collision with root package name */
    final r f244c;
    final ac d;
    final boolean e;
    private boolean f;

    final class a extends b {

        /* renamed from: c  reason: collision with root package name */
        private final f f246c;

        a(f fVar) {
            super("OkHttp %s", ab.this.g());
            this.f246c = fVar;
        }

        private ac c() {
            return ab.this.d;
        }

        private ab d() {
            return ab.this;
        }

        /* access modifiers changed from: package-private */
        public final String a() {
            return ab.this.d.f247a.l;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0037 A[SYNTHETIC, Splitter:B:15:0x0037] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x007f A[Catch:{ all -> 0x0030 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b() {
            /*
                r7 = this;
                r0 = 1
                r1 = 0
                b.ab r2 = b.ab.this     // Catch:{ IOException -> 0x0032 }
                b.ae r2 = r2.h()     // Catch:{ IOException -> 0x0032 }
                b.ab r3 = b.ab.this     // Catch:{ IOException -> 0x0032 }
                b.a.d.j r3 = r3.f243b     // Catch:{ IOException -> 0x0032 }
                boolean r3 = r3.f89c     // Catch:{ IOException -> 0x0032 }
                if (r3 == 0) goto L_0x001f
                b.f r1 = r7.f246c     // Catch:{ IOException -> 0x001d }
                java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x001d }
                java.lang.String r3 = "Canceled"
                r2.<init>(r3)     // Catch:{ IOException -> 0x001d }
                r1.a(r2)     // Catch:{ IOException -> 0x001d }
                goto L_0x0026
            L_0x001d:
                r1 = move-exception
                goto L_0x0035
            L_0x001f:
                b.f r1 = r7.f246c     // Catch:{ IOException -> 0x001d }
                b.ab r3 = b.ab.this     // Catch:{ IOException -> 0x001d }
                r1.a(r3, r2)     // Catch:{ IOException -> 0x001d }
            L_0x0026:
                b.ab r0 = b.ab.this
                b.z r0 = r0.f242a
                b.p r0 = r0.f372c
                r0.b((b.ab.a) r7)
                return
            L_0x0030:
                r0 = move-exception
                goto L_0x0085
            L_0x0032:
                r0 = move-exception
                r1 = r0
                r0 = 0
            L_0x0035:
                if (r0 == 0) goto L_0x007f
                b.a.h.e r0 = b.a.h.e.b()     // Catch:{ all -> 0x0030 }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
                java.lang.String r4 = "Callback failure for "
                r3.<init>(r4)     // Catch:{ all -> 0x0030 }
                b.ab r4 = b.ab.this     // Catch:{ all -> 0x0030 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
                r5.<init>()     // Catch:{ all -> 0x0030 }
                b.a.d.j r6 = r4.f243b     // Catch:{ all -> 0x0030 }
                boolean r6 = r6.f89c     // Catch:{ all -> 0x0030 }
                if (r6 == 0) goto L_0x0053
                java.lang.String r6 = "canceled "
                goto L_0x0055
            L_0x0053:
                java.lang.String r6 = ""
            L_0x0055:
                r5.append(r6)     // Catch:{ all -> 0x0030 }
                boolean r6 = r4.e     // Catch:{ all -> 0x0030 }
                if (r6 == 0) goto L_0x005f
                java.lang.String r6 = "web socket"
                goto L_0x0061
            L_0x005f:
                java.lang.String r6 = "call"
            L_0x0061:
                r5.append(r6)     // Catch:{ all -> 0x0030 }
                java.lang.String r6 = " to "
                r5.append(r6)     // Catch:{ all -> 0x0030 }
                java.lang.String r4 = r4.g()     // Catch:{ all -> 0x0030 }
                r5.append(r4)     // Catch:{ all -> 0x0030 }
                java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0030 }
                r3.append(r4)     // Catch:{ all -> 0x0030 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0030 }
                r0.a((int) r2, (java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0030 }
                goto L_0x0026
            L_0x007f:
                b.f r0 = r7.f246c     // Catch:{ all -> 0x0030 }
                r0.a(r1)     // Catch:{ all -> 0x0030 }
                goto L_0x0026
            L_0x0085:
                b.ab r1 = b.ab.this
                b.z r1 = r1.f242a
                b.p r1 = r1.f372c
                r1.b((b.ab.a) r7)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: b.ab.a.b():void");
        }
    }

    ab(z zVar, ac acVar, boolean z) {
        r.a aVar = zVar.i;
        this.f242a = zVar;
        this.d = acVar;
        this.e = z;
        this.f243b = new j(zVar, z);
        this.f244c = aVar.a();
    }

    private void i() {
        this.f243b.f88b = e.b().a("response.body().close()");
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public ab f() {
        return new ab(this.f242a, this.d, this.e);
    }

    private g k() {
        return this.f243b.f87a;
    }

    private String l() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f243b.f89c ? "canceled " : "");
        sb.append(this.e ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(g());
        return sb.toString();
    }

    public final ac a() {
        return this.d;
    }

    public final void a(f fVar) {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        i();
        this.f242a.f372c.a(new a(fVar));
    }

    public final ae b() throws IOException {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        i();
        try {
            this.f242a.f372c.a(this);
            ae h = h();
            if (h != null) {
                return h;
            }
            throw new IOException("Canceled");
        } finally {
            this.f242a.f372c.b(this);
        }
    }

    public final void c() {
        c cVar;
        b.a.c.c cVar2;
        j jVar = this.f243b;
        jVar.f89c = true;
        g gVar = jVar.f87a;
        if (gVar != null) {
            synchronized (gVar.f71c) {
                gVar.f = true;
                cVar = gVar.g;
                cVar2 = gVar.e;
            }
            if (cVar != null) {
                cVar.c();
            } else if (cVar2 != null) {
                b.a.c.a(cVar2.f61b);
            }
        }
    }

    public final synchronized boolean d() {
        return this.f;
    }

    public final boolean e() {
        return this.f243b.f89c;
    }

    /* access modifiers changed from: package-private */
    public final String g() {
        return this.d.f247a.h();
    }

    /* access modifiers changed from: package-private */
    public final ae h() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f242a.g);
        arrayList.add(this.f243b);
        arrayList.add(new b.a.d.a(this.f242a.k));
        z zVar = this.f242a;
        arrayList.add(new b.a.a.a(zVar.l != null ? zVar.l.f280a : zVar.m));
        arrayList.add(new b.a.c.a(this.f242a));
        if (!this.e) {
            arrayList.addAll(this.f242a.h);
        }
        arrayList.add(new b.a.d.b(this.e));
        return new b.a.d.g(arrayList, (g) null, (c) null, (b.a.c.c) null, 0, this.d).a(this.d);
    }
}

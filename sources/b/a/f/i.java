package b.a.f;

import c.e;
import c.x;
import c.y;
import c.z;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public final class i {
    static final /* synthetic */ boolean l = true;

    /* renamed from: a  reason: collision with root package name */
    long f155a = 0;

    /* renamed from: b  reason: collision with root package name */
    long f156b;

    /* renamed from: c  reason: collision with root package name */
    final int f157c;
    final g d;
    List<c> e;
    boolean f;
    final b g;
    final a h;
    final c i = new c();
    final c j = new c();
    b k = null;
    private final List<c> m;

    final class a implements x {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f158c = true;
        private static final long e = 16384;

        /* renamed from: a  reason: collision with root package name */
        boolean f159a;

        /* renamed from: b  reason: collision with root package name */
        boolean f160b;
        private final c.c f = new c.c();

        static {
            Class<i> cls = i.class;
        }

        a() {
        }

        /* JADX INFO: finally extract failed */
        private void a(boolean z) throws IOException {
            long min;
            synchronized (i.this) {
                i.this.j.j_();
                while (i.this.f156b <= 0 && !this.f160b && !this.f159a && i.this.k == null) {
                    try {
                        i.this.h();
                    } catch (Throwable th) {
                        i.this.j.b();
                        throw th;
                    }
                }
                i.this.j.b();
                i.this.g();
                min = Math.min(i.this.f156b, this.f.f387c);
                i.this.f156b -= min;
            }
            i.this.j.j_();
            try {
                i.this.d.a(i.this.f157c, z && min == this.f.f387c, this.f, min);
            } finally {
                i.this.j.b();
            }
        }

        public final void a(c.c cVar, long j) throws IOException {
            if (f158c || !Thread.holdsLock(i.this)) {
                this.f.a(cVar, j);
                while (this.f.f387c >= 16384) {
                    a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r8.d.h.f160b != false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
            if (r8.f.f387c <= 0) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
            if (r8.f.f387c <= 0) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
            a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003b, code lost:
            r8.d.d.a(r8.d.f157c, true, (c.c) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
            r2 = r8.d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r8.f159a = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004f, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0050, code lost:
            r8.d.d.q.b();
            r8.d.f();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void close() throws java.io.IOException {
            /*
                r8 = this;
                boolean r0 = f158c
                if (r0 != 0) goto L_0x0012
                b.a.f.i r0 = b.a.f.i.this
                boolean r0 = java.lang.Thread.holdsLock(r0)
                if (r0 == 0) goto L_0x0012
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x0012:
                b.a.f.i r0 = b.a.f.i.this
                monitor-enter(r0)
                boolean r1 = r8.f159a     // Catch:{ all -> 0x0062 }
                if (r1 == 0) goto L_0x001b
                monitor-exit(r0)     // Catch:{ all -> 0x0062 }
                return
            L_0x001b:
                monitor-exit(r0)     // Catch:{ all -> 0x0062 }
                b.a.f.i r0 = b.a.f.i.this
                b.a.f.i$a r0 = r0.h
                boolean r0 = r0.f160b
                r1 = 1
                if (r0 != 0) goto L_0x004a
                c.c r0 = r8.f
                long r2 = r0.f387c
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003b
            L_0x002f:
                c.c r0 = r8.f
                long r2 = r0.f387c
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x004a
                r8.a(r1)
                goto L_0x002f
            L_0x003b:
                b.a.f.i r0 = b.a.f.i.this
                b.a.f.g r2 = r0.d
                b.a.f.i r0 = b.a.f.i.this
                int r3 = r0.f157c
                r4 = 1
                r5 = 0
                r6 = 0
                r2.a((int) r3, (boolean) r4, (c.c) r5, (long) r6)
            L_0x004a:
                b.a.f.i r2 = b.a.f.i.this
                monitor-enter(r2)
                r8.f159a = r1     // Catch:{ all -> 0x005f }
                monitor-exit(r2)     // Catch:{ all -> 0x005f }
                b.a.f.i r0 = b.a.f.i.this
                b.a.f.g r0 = r0.d
                b.a.f.j r0 = r0.q
                r0.b()
                b.a.f.i r0 = b.a.f.i.this
                r0.f()
                return
            L_0x005f:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x005f }
                throw r0
            L_0x0062:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0062 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.f.i.a.close():void");
        }

        public final void flush() throws IOException {
            if (f158c || !Thread.holdsLock(i.this)) {
                synchronized (i.this) {
                    i.this.g();
                }
                while (this.f.f387c > 0) {
                    a(false);
                    i.this.d.q.b();
                }
                return;
            }
            throw new AssertionError();
        }

        public final z timeout() {
            return i.this.j;
        }
    }

    private final class b implements y {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f161c = true;

        /* renamed from: a  reason: collision with root package name */
        boolean f162a;

        /* renamed from: b  reason: collision with root package name */
        boolean f163b;
        private final c.c e = new c.c();
        private final c.c f = new c.c();
        private final long g;

        static {
            Class<i> cls = i.class;
        }

        b(long j) {
            this.g = j;
        }

        private void a() throws IOException {
            i.this.i.j_();
            while (this.f.f387c == 0 && !this.f163b && !this.f162a && i.this.k == null) {
                try {
                    i.this.h();
                } finally {
                    i.this.i.b();
                }
            }
        }

        private void b() throws IOException {
            if (this.f162a) {
                throw new IOException("stream closed");
            } else if (i.this.k != null) {
                throw new o(i.this.k);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (f161c || !Thread.holdsLock(i.this)) {
                while (j > 0) {
                    synchronized (i.this) {
                        z = this.f163b;
                        z2 = false;
                        z3 = j + this.f.f387c > this.g;
                    }
                    if (z3) {
                        eVar.h(j);
                        i.this.b(b.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        eVar.h(j);
                        return;
                    } else {
                        long read = eVar.read(this.e, j);
                        if (read == -1) {
                            throw new EOFException();
                        }
                        long j2 = j - read;
                        synchronized (i.this) {
                            if (this.f.f387c == 0) {
                                z2 = true;
                            }
                            this.f.a((y) this.e);
                            if (z2) {
                                i.this.notifyAll();
                            }
                        }
                        j = j2;
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public final void close() throws IOException {
            synchronized (i.this) {
                this.f162a = true;
                this.f.w();
                i.this.notifyAll();
            }
            i.this.f();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
            r10 = r7.d.d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x008c, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r7.d.d.k += r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ad, code lost:
            if (r7.d.d.k < ((long) (r7.d.d.m.b() / 2))) goto L_0x00c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00af, code lost:
            r7.d.d.a(0, r7.d.d.k);
            r7.d.d.k = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c3, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c4, code lost:
            return r8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final long read(c.c r8, long r9) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 0
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 >= 0) goto L_0x001a
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "byteCount < 0: "
                r0.<init>(r1)
                r0.append(r9)
                java.lang.String r9 = r0.toString()
                r8.<init>(r9)
                throw r8
            L_0x001a:
                b.a.f.i r2 = b.a.f.i.this
                monitor-enter(r2)
                r7.a()     // Catch:{ all -> 0x00c8 }
                boolean r3 = r7.f162a     // Catch:{ all -> 0x00c8 }
                if (r3 == 0) goto L_0x002c
                java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x00c8 }
                java.lang.String r9 = "stream closed"
                r8.<init>(r9)     // Catch:{ all -> 0x00c8 }
                throw r8     // Catch:{ all -> 0x00c8 }
            L_0x002c:
                b.a.f.i r3 = b.a.f.i.this     // Catch:{ all -> 0x00c8 }
                b.a.f.b r3 = r3.k     // Catch:{ all -> 0x00c8 }
                if (r3 == 0) goto L_0x003c
                b.a.f.o r8 = new b.a.f.o     // Catch:{ all -> 0x00c8 }
                b.a.f.i r9 = b.a.f.i.this     // Catch:{ all -> 0x00c8 }
                b.a.f.b r9 = r9.k     // Catch:{ all -> 0x00c8 }
                r8.<init>(r9)     // Catch:{ all -> 0x00c8 }
                throw r8     // Catch:{ all -> 0x00c8 }
            L_0x003c:
                c.c r3 = r7.f     // Catch:{ all -> 0x00c8 }
                long r3 = r3.f387c     // Catch:{ all -> 0x00c8 }
                int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r5 != 0) goto L_0x0048
                r8 = -1
                monitor-exit(r2)     // Catch:{ all -> 0x00c8 }
                return r8
            L_0x0048:
                c.c r3 = r7.f     // Catch:{ all -> 0x00c8 }
                c.c r4 = r7.f     // Catch:{ all -> 0x00c8 }
                long r4 = r4.f387c     // Catch:{ all -> 0x00c8 }
                long r9 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x00c8 }
                long r8 = r3.read(r8, r9)     // Catch:{ all -> 0x00c8 }
                b.a.f.i r10 = b.a.f.i.this     // Catch:{ all -> 0x00c8 }
                long r3 = r10.f155a     // Catch:{ all -> 0x00c8 }
                r5 = 0
                long r5 = r3 + r8
                r10.f155a = r5     // Catch:{ all -> 0x00c8 }
                b.a.f.i r10 = b.a.f.i.this     // Catch:{ all -> 0x00c8 }
                long r3 = r10.f155a     // Catch:{ all -> 0x00c8 }
                b.a.f.i r10 = b.a.f.i.this     // Catch:{ all -> 0x00c8 }
                b.a.f.g r10 = r10.d     // Catch:{ all -> 0x00c8 }
                b.a.f.n r10 = r10.m     // Catch:{ all -> 0x00c8 }
                int r10 = r10.b()     // Catch:{ all -> 0x00c8 }
                int r10 = r10 / 2
                long r5 = (long) r10     // Catch:{ all -> 0x00c8 }
                int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r10 < 0) goto L_0x0087
                b.a.f.i r10 = b.a.f.i.this     // Catch:{ all -> 0x00c8 }
                b.a.f.g r10 = r10.d     // Catch:{ all -> 0x00c8 }
                b.a.f.i r3 = b.a.f.i.this     // Catch:{ all -> 0x00c8 }
                int r3 = r3.f157c     // Catch:{ all -> 0x00c8 }
                b.a.f.i r4 = b.a.f.i.this     // Catch:{ all -> 0x00c8 }
                long r4 = r4.f155a     // Catch:{ all -> 0x00c8 }
                r10.a((int) r3, (long) r4)     // Catch:{ all -> 0x00c8 }
                b.a.f.i r10 = b.a.f.i.this     // Catch:{ all -> 0x00c8 }
                r10.f155a = r0     // Catch:{ all -> 0x00c8 }
            L_0x0087:
                monitor-exit(r2)     // Catch:{ all -> 0x00c8 }
                b.a.f.i r10 = b.a.f.i.this
                b.a.f.g r10 = r10.d
                monitor-enter(r10)
                b.a.f.i r2 = b.a.f.i.this     // Catch:{ all -> 0x00c5 }
                b.a.f.g r2 = r2.d     // Catch:{ all -> 0x00c5 }
                long r3 = r2.k     // Catch:{ all -> 0x00c5 }
                r5 = 0
                long r5 = r3 + r8
                r2.k = r5     // Catch:{ all -> 0x00c5 }
                b.a.f.i r2 = b.a.f.i.this     // Catch:{ all -> 0x00c5 }
                b.a.f.g r2 = r2.d     // Catch:{ all -> 0x00c5 }
                long r2 = r2.k     // Catch:{ all -> 0x00c5 }
                b.a.f.i r4 = b.a.f.i.this     // Catch:{ all -> 0x00c5 }
                b.a.f.g r4 = r4.d     // Catch:{ all -> 0x00c5 }
                b.a.f.n r4 = r4.m     // Catch:{ all -> 0x00c5 }
                int r4 = r4.b()     // Catch:{ all -> 0x00c5 }
                int r4 = r4 / 2
                long r4 = (long) r4     // Catch:{ all -> 0x00c5 }
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 < 0) goto L_0x00c3
                b.a.f.i r2 = b.a.f.i.this     // Catch:{ all -> 0x00c5 }
                b.a.f.g r2 = r2.d     // Catch:{ all -> 0x00c5 }
                r3 = 0
                b.a.f.i r4 = b.a.f.i.this     // Catch:{ all -> 0x00c5 }
                b.a.f.g r4 = r4.d     // Catch:{ all -> 0x00c5 }
                long r4 = r4.k     // Catch:{ all -> 0x00c5 }
                r2.a((int) r3, (long) r4)     // Catch:{ all -> 0x00c5 }
                b.a.f.i r2 = b.a.f.i.this     // Catch:{ all -> 0x00c5 }
                b.a.f.g r2 = r2.d     // Catch:{ all -> 0x00c5 }
                r2.k = r0     // Catch:{ all -> 0x00c5 }
            L_0x00c3:
                monitor-exit(r10)     // Catch:{ all -> 0x00c5 }
                return r8
            L_0x00c5:
                r8 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00c5 }
                throw r8
            L_0x00c8:
                r8 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00c8 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.f.i.b.read(c.c, long):long");
        }

        public final z timeout() {
            return i.this.i;
        }
    }

    class c extends c.a {
        c() {
        }

        /* access modifiers changed from: protected */
        public final IOException a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        public final void a() {
            i.this.b(b.CANCEL);
        }

        public final void b() throws IOException {
            if (k_()) {
                throw a((IOException) null);
            }
        }
    }

    i(int i2, g gVar, boolean z, boolean z2, List<c> list) {
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.f157c = i2;
            this.d = gVar;
            this.f156b = (long) gVar.n.b();
            this.g = new b((long) gVar.m.b());
            this.h = new a();
            this.g.f163b = z2;
            this.h.f160b = z;
            this.m = list;
        }
    }

    private void a(e eVar, int i2) throws IOException {
        if (l || !Thread.holdsLock(this)) {
            this.g.a(eVar, (long) i2);
            return;
        }
        throw new AssertionError();
    }

    private void a(List<c> list) {
        boolean z;
        if (l || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = true;
                this.f = true;
                if (this.e == null) {
                    this.e = list;
                    z = a();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.e);
                    arrayList.add((Object) null);
                    arrayList.addAll(list);
                    this.e = arrayList;
                }
            }
            if (!z) {
                this.d.b(this.f157c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private void a(List<c> list, boolean z) throws IOException {
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (list == null) {
            throw new NullPointerException("responseHeaders == null");
        } else {
            boolean z2 = false;
            synchronized (this) {
                this.f = true;
                if (!z) {
                    this.h.f160b = true;
                    z2 = true;
                }
            }
            g gVar = this.d;
            gVar.q.b(z2, this.f157c, list);
            if (z2) {
                this.d.q.b();
            }
        }
    }

    private boolean d(b bVar) {
        if (l || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.k != null) {
                    return false;
                }
                if (this.g.f163b && this.h.f160b) {
                    return false;
                }
                this.k = bVar;
                notifyAll();
                this.d.b(this.f157c);
                return true;
            }
        }
        throw new AssertionError();
    }

    private int i() {
        return this.f157c;
    }

    private g j() {
        return this.d;
    }

    private List<c> k() {
        return this.m;
    }

    private synchronized b l() {
        return this.k;
    }

    private z m() {
        return this.i;
    }

    private z n() {
        return this.j;
    }

    private y o() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2) {
        this.f156b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    public final void a(b bVar) throws IOException {
        if (d(bVar)) {
            this.d.b(this.f157c, bVar);
        }
    }

    public final synchronized boolean a() {
        if (this.k != null) {
            return false;
        }
        return (!this.g.f163b && !this.g.f162a) || (!this.h.f160b && !this.h.f159a) || !this.f;
    }

    public final void b(b bVar) {
        if (d(bVar)) {
            this.d.a(this.f157c, bVar);
        }
    }

    public final boolean b() {
        return this.d.f123b == ((this.f157c & 1) == 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        r2.i.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<b.a.f.c> c() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.b()     // Catch:{ all -> 0x003d }
            if (r0 != 0) goto L_0x000f
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x003d }
            java.lang.String r1 = "servers cannot read response headers"
            r0.<init>(r1)     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x000f:
            b.a.f.i$c r0 = r2.i     // Catch:{ all -> 0x003d }
            r0.j_()     // Catch:{ all -> 0x003d }
        L_0x0014:
            java.util.List<b.a.f.c> r0 = r2.e     // Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x0020
            b.a.f.b r0 = r2.k     // Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x0020
            r2.h()     // Catch:{ all -> 0x0036 }
            goto L_0x0014
        L_0x0020:
            b.a.f.i$c r0 = r2.i     // Catch:{ all -> 0x003d }
            r0.b()     // Catch:{ all -> 0x003d }
            java.util.List<b.a.f.c> r0 = r2.e     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x002e
            r1 = 0
            r2.e = r1     // Catch:{ all -> 0x003d }
            monitor-exit(r2)
            return r0
        L_0x002e:
            b.a.f.o r0 = new b.a.f.o     // Catch:{ all -> 0x003d }
            b.a.f.b r1 = r2.k     // Catch:{ all -> 0x003d }
            r0.<init>(r1)     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x0036:
            r0 = move-exception
            b.a.f.i$c r1 = r2.i     // Catch:{ all -> 0x003d }
            r1.b()     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x003d:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.f.i.c():java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void c(b bVar) {
        if (this.k == null) {
            this.k = bVar;
            notifyAll();
        }
    }

    public final x d() {
        synchronized (this) {
            if (!this.f && !b()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        boolean a2;
        if (l || !Thread.holdsLock(this)) {
            synchronized (this) {
                this.g.f163b = true;
                a2 = a();
                notifyAll();
            }
            if (!a2) {
                this.d.b(this.f157c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public final void f() throws IOException {
        boolean z;
        boolean a2;
        if (l || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.g.f163b && this.g.f162a && (this.h.f160b || this.h.f159a);
                a2 = a();
            }
            if (z) {
                a(b.CANCEL);
            } else if (!a2) {
                this.d.b(this.f157c);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public final void g() throws IOException {
        if (this.h.f159a) {
            throw new IOException("stream closed");
        } else if (this.h.f160b) {
            throw new IOException("stream finished");
        } else if (this.k != null) {
            throw new o(this.k);
        }
    }

    /* access modifiers changed from: package-private */
    public final void h() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }
}

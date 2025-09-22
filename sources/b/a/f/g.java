package b.a.f;

import android.support.v7.widget.ActivityChooserView;
import b.a.f.h;
import b.aa;
import c.d;
import c.e;
import c.f;
import c.p;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class g implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final ExecutorService f122a = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), b.a.c.a("OkHttp Http2Connection", true));
    static final /* synthetic */ boolean t = true;
    private static final int w = 16777216;

    /* renamed from: b  reason: collision with root package name */
    final boolean f123b;

    /* renamed from: c  reason: collision with root package name */
    final b f124c;
    final Map<Integer, i> d = new LinkedHashMap();
    final String e;
    int f;
    int g;
    boolean h;
    final ExecutorService i;
    final m j;
    long k = 0;
    long l;
    public n m = new n();
    final n n = new n();
    boolean o = false;
    final Socket p;
    public final j q;
    public final c r;
    final Set<Integer> s = new LinkedHashSet();
    private Map<Integer, l> u;
    private int v;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Socket f139a;

        /* renamed from: b  reason: collision with root package name */
        String f140b;

        /* renamed from: c  reason: collision with root package name */
        e f141c;
        d d;
        public b e = b.m;
        m f = m.f177a;
        boolean g = true;

        private a a(b bVar) {
            this.e = bVar;
            return this;
        }

        private a a(m mVar) {
            this.f = mVar;
            return this;
        }

        private a a(Socket socket) throws IOException {
            return a(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), p.a(p.b(socket)), p.a(p.a(socket)));
        }

        private g a() throws IOException {
            return new g(this);
        }

        public final a a(Socket socket, String str, e eVar, d dVar) {
            this.f139a = socket;
            this.f140b = str;
            this.f141c = eVar;
            this.d = dVar;
            return this;
        }
    }

    public static abstract class b {
        public static final b m = new b() {
            public final void a(i iVar) throws IOException {
                iVar.a(b.REFUSED_STREAM);
            }
        };

        public void a(g gVar) {
        }

        public abstract void a(i iVar) throws IOException;
    }

    class c extends b.a.b implements h.b {

        /* renamed from: a  reason: collision with root package name */
        final h f142a;

        c(h hVar) {
            super("OkHttp %s", g.this.e);
            this.f142a = hVar;
        }

        private void b(final n nVar) {
            g.f122a.execute(new b.a.b("OkHttp %s ACK Settings", new Object[]{g.this.e}) {
                public final void b() {
                    try {
                        g.this.q.a(r14);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        public final void a() {
        }

        public final void a(int i, long j) {
            if (i == 0) {
                synchronized (g.this) {
                    g.this.l += j;
                    g.this.notifyAll();
                }
                return;
            }
            i a2 = g.this.a(i);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }

        public final void a(int i, b bVar) {
            if (g.d(i)) {
                g gVar = g.this;
                gVar.i.execute(new b.a.b("OkHttp %s Push Reset[%s]", new Object[]{gVar.e, Integer.valueOf(i)}, i, bVar) {
                    public final void b() {
                        g.this.j.c();
                        synchronized (g.this) {
                            g.this.s.remove(Integer.valueOf(r5));
                        }
                    }
                });
                return;
            }
            i b2 = g.this.b(i);
            if (b2 != null) {
                b2.c(bVar);
            }
        }

        public final void a(int i, f fVar) {
            i[] iVarArr;
            fVar.size();
            synchronized (g.this) {
                iVarArr = (i[]) g.this.d.values().toArray(new i[g.this.d.size()]);
                g.this.h = true;
            }
            for (i iVar : iVarArr) {
                if (iVar.f157c > i && iVar.b()) {
                    iVar.c(b.REFUSED_STREAM);
                    g.this.b(iVar.f157c);
                }
            }
        }

        public final void a(int i, List<c> list) {
            g gVar = g.this;
            synchronized (gVar) {
                if (gVar.s.contains(Integer.valueOf(i))) {
                    gVar.a(i, b.PROTOCOL_ERROR);
                    return;
                }
                gVar.s.add(Integer.valueOf(i));
                gVar.i.execute(new b.a.b("OkHttp %s Push Request[%s]", new Object[]{gVar.e, Integer.valueOf(i)}, i, list) {
                    public final void b() {
                        g.this.j.a();
                        try {
                            g.this.q.a(r5, b.CANCEL);
                            synchronized (g.this) {
                                g.this.s.remove(Integer.valueOf(r5));
                            }
                        } catch (IOException unused) {
                        }
                    }
                });
            }
        }

        /* JADX WARNING: type inference failed for: r14v18, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(final b.a.f.n r14) {
            /*
                r13 = this;
                b.a.f.g r0 = b.a.f.g.this
                monitor-enter(r0)
                b.a.f.g r1 = b.a.f.g.this     // Catch:{ all -> 0x00a5 }
                b.a.f.n r1 = r1.n     // Catch:{ all -> 0x00a5 }
                int r1 = r1.b()     // Catch:{ all -> 0x00a5 }
                b.a.f.g r2 = b.a.f.g.this     // Catch:{ all -> 0x00a5 }
                b.a.f.n r2 = r2.n     // Catch:{ all -> 0x00a5 }
                r2.a((b.a.f.n) r14)     // Catch:{ all -> 0x00a5 }
                java.util.concurrent.ExecutorService r2 = b.a.f.g.f122a     // Catch:{ all -> 0x00a5 }
                b.a.f.g$c$3 r3 = new b.a.f.g$c$3     // Catch:{ all -> 0x00a5 }
                java.lang.String r4 = "OkHttp %s ACK Settings"
                r5 = 1
                java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x00a5 }
                b.a.f.g r7 = b.a.f.g.this     // Catch:{ all -> 0x00a5 }
                java.lang.String r7 = r7.e     // Catch:{ all -> 0x00a5 }
                r8 = 0
                r6[r8] = r7     // Catch:{ all -> 0x00a5 }
                r3.<init>(r4, r6, r14)     // Catch:{ all -> 0x00a5 }
                r2.execute(r3)     // Catch:{ all -> 0x00a5 }
                b.a.f.g r14 = b.a.f.g.this     // Catch:{ all -> 0x00a5 }
                b.a.f.n r14 = r14.n     // Catch:{ all -> 0x00a5 }
                int r14 = r14.b()     // Catch:{ all -> 0x00a5 }
                r2 = -1
                r3 = 0
                r6 = 0
                if (r14 == r2) goto L_0x0078
                if (r14 == r1) goto L_0x0078
                int r14 = r14 - r1
                long r1 = (long) r14     // Catch:{ all -> 0x00a5 }
                b.a.f.g r14 = b.a.f.g.this     // Catch:{ all -> 0x00a5 }
                boolean r14 = r14.o     // Catch:{ all -> 0x00a5 }
                if (r14 != 0) goto L_0x0054
                b.a.f.g r14 = b.a.f.g.this     // Catch:{ all -> 0x00a5 }
                long r9 = r14.l     // Catch:{ all -> 0x00a5 }
                r7 = 0
                long r11 = r9 + r1
                r14.l = r11     // Catch:{ all -> 0x00a5 }
                int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r7 <= 0) goto L_0x0050
                r14.notifyAll()     // Catch:{ all -> 0x00a5 }
            L_0x0050:
                b.a.f.g r14 = b.a.f.g.this     // Catch:{ all -> 0x00a5 }
                r14.o = r5     // Catch:{ all -> 0x00a5 }
            L_0x0054:
                b.a.f.g r14 = b.a.f.g.this     // Catch:{ all -> 0x00a5 }
                java.util.Map<java.lang.Integer, b.a.f.i> r14 = r14.d     // Catch:{ all -> 0x00a5 }
                boolean r14 = r14.isEmpty()     // Catch:{ all -> 0x00a5 }
                if (r14 != 0) goto L_0x0079
                b.a.f.g r14 = b.a.f.g.this     // Catch:{ all -> 0x00a5 }
                java.util.Map<java.lang.Integer, b.a.f.i> r14 = r14.d     // Catch:{ all -> 0x00a5 }
                java.util.Collection r14 = r14.values()     // Catch:{ all -> 0x00a5 }
                b.a.f.g r6 = b.a.f.g.this     // Catch:{ all -> 0x00a5 }
                java.util.Map<java.lang.Integer, b.a.f.i> r6 = r6.d     // Catch:{ all -> 0x00a5 }
                int r6 = r6.size()     // Catch:{ all -> 0x00a5 }
                b.a.f.i[] r6 = new b.a.f.i[r6]     // Catch:{ all -> 0x00a5 }
                java.lang.Object[] r14 = r14.toArray(r6)     // Catch:{ all -> 0x00a5 }
                r6 = r14
                b.a.f.i[] r6 = (b.a.f.i[]) r6     // Catch:{ all -> 0x00a5 }
                goto L_0x0079
            L_0x0078:
                r1 = r3
            L_0x0079:
                java.util.concurrent.ExecutorService r14 = b.a.f.g.f122a     // Catch:{ all -> 0x00a5 }
                b.a.f.g$c$2 r7 = new b.a.f.g$c$2     // Catch:{ all -> 0x00a5 }
                java.lang.String r9 = "OkHttp %s settings"
                java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00a5 }
                b.a.f.g r10 = b.a.f.g.this     // Catch:{ all -> 0x00a5 }
                java.lang.String r10 = r10.e     // Catch:{ all -> 0x00a5 }
                r5[r8] = r10     // Catch:{ all -> 0x00a5 }
                r7.<init>(r9, r5)     // Catch:{ all -> 0x00a5 }
                r14.execute(r7)     // Catch:{ all -> 0x00a5 }
                monitor-exit(r0)     // Catch:{ all -> 0x00a5 }
                if (r6 == 0) goto L_0x00a4
                int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r14 == 0) goto L_0x00a4
                int r14 = r6.length
            L_0x0095:
                if (r8 >= r14) goto L_0x00a4
                r0 = r6[r8]
                monitor-enter(r0)
                r0.a((long) r1)     // Catch:{ all -> 0x00a1 }
                monitor-exit(r0)     // Catch:{ all -> 0x00a1 }
                int r8 = r8 + 1
                goto L_0x0095
            L_0x00a1:
                r14 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00a1 }
                throw r14
            L_0x00a4:
                return
            L_0x00a5:
                r14 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00a5 }
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.f.g.c.a(b.a.f.n):void");
        }

        public final void a(boolean z, int i, int i2) {
            if (z) {
                l c2 = g.this.c(i);
                if (c2 == null) {
                    return;
                }
                if (c2.f176c != -1 || c2.f175b == -1) {
                    throw new IllegalStateException();
                }
                c2.f176c = System.nanoTime();
                c2.f174a.countDown();
                return;
            }
            g gVar = g.this;
            g.f122a.execute(new b.a.b("OkHttp %s ping %08x%08x", new Object[]{gVar.e, Integer.valueOf(i), Integer.valueOf(i2)}, i, i2) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f129a = true;
                final /* synthetic */ l e;

                {
                    this.e = null;
                }

                public final void b() {
                    try {
                        g.this.a(this.f129a, r5, r6, this.e);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        public final void a(boolean z, int i, e eVar, int i2) throws IOException {
            if (g.d(i)) {
                g gVar = g.this;
                c.c cVar = new c.c();
                long j = (long) i2;
                eVar.a(j);
                eVar.read(cVar, j);
                if (cVar.f387c != j) {
                    throw new IOException(cVar.f387c + " != " + i2);
                }
                gVar.i.execute(new b.a.b("OkHttp %s Push Data[%s]", new Object[]{gVar.e, Integer.valueOf(i)}, i, cVar, i2, z) {
                    public final void b() {
                        try {
                            g.this.j.a(r5, r6);
                            g.this.q.a(r4, b.CANCEL);
                            synchronized (g.this) {
                                g.this.s.remove(Integer.valueOf(r4));
                            }
                        } catch (IOException unused) {
                        }
                    }
                });
                return;
            }
            i a2 = g.this.a(i);
            if (a2 == null) {
                g.this.a(i, b.PROTOCOL_ERROR);
                eVar.h((long) i2);
            } else if (i.l || !Thread.holdsLock(a2)) {
                a2.g.a(eVar, (long) i2);
                if (z) {
                    a2.e();
                }
            } else {
                throw new AssertionError();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
            if (b.a.f.i.l != false) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x008e, code lost:
            if (java.lang.Thread.holdsLock(r4) == false) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
            throw new java.lang.AssertionError();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0096, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            r4.f = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x009b, code lost:
            if (r4.e != null) goto L_0x00a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x009d, code lost:
            r4.e = r15;
            r2 = r4.a();
            r4.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a7, code lost:
            r14 = new java.util.ArrayList();
            r14.addAll(r4.e);
            r14.add((java.lang.Object) null);
            r14.addAll(r15);
            r4.e = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ba, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bb, code lost:
            if (r2 != false) goto L_0x00c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bd, code lost:
            r4.d.b(r4.f157c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c4, code lost:
            if (r13 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c6, code lost:
            r4.e();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(boolean r13, int r14, java.util.List<b.a.f.c> r15) {
            /*
                r12 = this;
                boolean r0 = b.a.f.g.d(r14)
                r1 = 0
                r2 = 1
                r3 = 2
                if (r0 == 0) goto L_0x0028
                b.a.f.g r5 = b.a.f.g.this
                java.util.concurrent.ExecutorService r0 = r5.i
                b.a.f.g$5 r11 = new b.a.f.g$5
                java.lang.String r6 = "OkHttp %s Push Headers[%s]"
                java.lang.Object[] r7 = new java.lang.Object[r3]
                java.lang.String r3 = r5.e
                r7[r1] = r3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
                r7[r2] = r1
                r4 = r11
                r8 = r14
                r9 = r15
                r10 = r13
                r4.<init>(r6, r7, r8, r9, r10)
                r0.execute(r11)
                return
            L_0x0028:
                b.a.f.g r0 = b.a.f.g.this
                monitor-enter(r0)
                b.a.f.g r4 = b.a.f.g.this     // Catch:{ all -> 0x00cd }
                boolean r4 = r4.h     // Catch:{ all -> 0x00cd }
                if (r4 == 0) goto L_0x0033
                monitor-exit(r0)     // Catch:{ all -> 0x00cd }
                return
            L_0x0033:
                b.a.f.g r4 = b.a.f.g.this     // Catch:{ all -> 0x00cd }
                b.a.f.i r4 = r4.a((int) r14)     // Catch:{ all -> 0x00cd }
                if (r4 != 0) goto L_0x0085
                b.a.f.g r4 = b.a.f.g.this     // Catch:{ all -> 0x00cd }
                int r4 = r4.f     // Catch:{ all -> 0x00cd }
                if (r14 > r4) goto L_0x0043
                monitor-exit(r0)     // Catch:{ all -> 0x00cd }
                return
            L_0x0043:
                int r4 = r14 % 2
                b.a.f.g r5 = b.a.f.g.this     // Catch:{ all -> 0x00cd }
                int r5 = r5.g     // Catch:{ all -> 0x00cd }
                int r5 = r5 % r3
                if (r4 != r5) goto L_0x004e
                monitor-exit(r0)     // Catch:{ all -> 0x00cd }
                return
            L_0x004e:
                b.a.f.i r10 = new b.a.f.i     // Catch:{ all -> 0x00cd }
                b.a.f.g r6 = b.a.f.g.this     // Catch:{ all -> 0x00cd }
                r7 = 0
                r4 = r10
                r5 = r14
                r8 = r13
                r9 = r15
                r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00cd }
                b.a.f.g r13 = b.a.f.g.this     // Catch:{ all -> 0x00cd }
                r13.f = r14     // Catch:{ all -> 0x00cd }
                b.a.f.g r13 = b.a.f.g.this     // Catch:{ all -> 0x00cd }
                java.util.Map<java.lang.Integer, b.a.f.i> r13 = r13.d     // Catch:{ all -> 0x00cd }
                java.lang.Integer r15 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x00cd }
                r13.put(r15, r10)     // Catch:{ all -> 0x00cd }
                java.util.concurrent.ExecutorService r13 = b.a.f.g.f122a     // Catch:{ all -> 0x00cd }
                b.a.f.g$c$1 r15 = new b.a.f.g$c$1     // Catch:{ all -> 0x00cd }
                java.lang.String r4 = "OkHttp %s stream %d"
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x00cd }
                b.a.f.g r5 = b.a.f.g.this     // Catch:{ all -> 0x00cd }
                java.lang.String r5 = r5.e     // Catch:{ all -> 0x00cd }
                r3[r1] = r5     // Catch:{ all -> 0x00cd }
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x00cd }
                r3[r2] = r14     // Catch:{ all -> 0x00cd }
                r15.<init>(r4, r3, r10)     // Catch:{ all -> 0x00cd }
                r13.execute(r15)     // Catch:{ all -> 0x00cd }
                monitor-exit(r0)     // Catch:{ all -> 0x00cd }
                return
            L_0x0085:
                monitor-exit(r0)     // Catch:{ all -> 0x00cd }
                boolean r14 = b.a.f.i.l
                if (r14 != 0) goto L_0x0096
                boolean r14 = java.lang.Thread.holdsLock(r4)
                if (r14 == 0) goto L_0x0096
                java.lang.AssertionError r13 = new java.lang.AssertionError
                r13.<init>()
                throw r13
            L_0x0096:
                monitor-enter(r4)
                r4.f = r2     // Catch:{ all -> 0x00ca }
                java.util.List<b.a.f.c> r14 = r4.e     // Catch:{ all -> 0x00ca }
                if (r14 != 0) goto L_0x00a7
                r4.e = r15     // Catch:{ all -> 0x00ca }
                boolean r2 = r4.a()     // Catch:{ all -> 0x00ca }
                r4.notifyAll()     // Catch:{ all -> 0x00ca }
                goto L_0x00ba
            L_0x00a7:
                java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00ca }
                r14.<init>()     // Catch:{ all -> 0x00ca }
                java.util.List<b.a.f.c> r0 = r4.e     // Catch:{ all -> 0x00ca }
                r14.addAll(r0)     // Catch:{ all -> 0x00ca }
                r0 = 0
                r14.add(r0)     // Catch:{ all -> 0x00ca }
                r14.addAll(r15)     // Catch:{ all -> 0x00ca }
                r4.e = r14     // Catch:{ all -> 0x00ca }
            L_0x00ba:
                monitor-exit(r4)     // Catch:{ all -> 0x00ca }
                if (r2 != 0) goto L_0x00c4
                b.a.f.g r14 = r4.d
                int r15 = r4.f157c
                r14.b(r15)
            L_0x00c4:
                if (r13 == 0) goto L_0x00c9
                r4.e()
            L_0x00c9:
                return
            L_0x00ca:
                r13 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x00ca }
                throw r13
            L_0x00cd:
                r13 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00cd }
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.f.g.c.a(boolean, int, java.util.List):void");
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0077 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b() {
            /*
                r10 = this;
                b.a.f.b r0 = b.a.f.b.INTERNAL_ERROR
                b.a.f.b r1 = b.a.f.b.INTERNAL_ERROR
                b.a.f.h r2 = r10.f142a     // Catch:{ IOException -> 0x0077 }
                boolean r3 = r2.f151c     // Catch:{ IOException -> 0x0077 }
                r4 = 1
                r5 = 0
                if (r3 == 0) goto L_0x001b
                boolean r2 = r2.a((boolean) r4, (b.a.f.h.b) r10)     // Catch:{ IOException -> 0x0077 }
                if (r2 != 0) goto L_0x005c
                java.lang.String r2 = "Required SETTINGS preface not received"
                java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0077 }
                java.io.IOException r2 = b.a.f.e.b(r2, r3)     // Catch:{ IOException -> 0x0077 }
                throw r2     // Catch:{ IOException -> 0x0077 }
            L_0x001b:
                c.e r2 = r2.f150b     // Catch:{ IOException -> 0x0077 }
                c.f r3 = b.a.f.e.f116a     // Catch:{ IOException -> 0x0077 }
                int r3 = r3.size()     // Catch:{ IOException -> 0x0077 }
                long r6 = (long) r3     // Catch:{ IOException -> 0x0077 }
                c.f r2 = r2.d((long) r6)     // Catch:{ IOException -> 0x0077 }
                java.util.logging.Logger r3 = b.a.f.h.f149a     // Catch:{ IOException -> 0x0077 }
                java.util.logging.Level r6 = java.util.logging.Level.FINE     // Catch:{ IOException -> 0x0077 }
                boolean r3 = r3.isLoggable(r6)     // Catch:{ IOException -> 0x0077 }
                if (r3 == 0) goto L_0x0045
                java.util.logging.Logger r3 = b.a.f.h.f149a     // Catch:{ IOException -> 0x0077 }
                java.lang.String r6 = "<< CONNECTION %s"
                java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0077 }
                java.lang.String r8 = r2.hex()     // Catch:{ IOException -> 0x0077 }
                r7[r5] = r8     // Catch:{ IOException -> 0x0077 }
                java.lang.String r6 = b.a.c.a((java.lang.String) r6, (java.lang.Object[]) r7)     // Catch:{ IOException -> 0x0077 }
                r3.fine(r6)     // Catch:{ IOException -> 0x0077 }
            L_0x0045:
                c.f r3 = b.a.f.e.f116a     // Catch:{ IOException -> 0x0077 }
                boolean r3 = r3.equals(r2)     // Catch:{ IOException -> 0x0077 }
                if (r3 != 0) goto L_0x005c
                java.lang.String r3 = "Expected a connection header but was %s"
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0077 }
                java.lang.String r2 = r2.utf8()     // Catch:{ IOException -> 0x0077 }
                r4[r5] = r2     // Catch:{ IOException -> 0x0077 }
                java.io.IOException r2 = b.a.f.e.b(r3, r4)     // Catch:{ IOException -> 0x0077 }
                throw r2     // Catch:{ IOException -> 0x0077 }
            L_0x005c:
                b.a.f.h r2 = r10.f142a     // Catch:{ IOException -> 0x0077 }
                boolean r2 = r2.a((boolean) r5, (b.a.f.h.b) r10)     // Catch:{ IOException -> 0x0077 }
                if (r2 != 0) goto L_0x005c
                b.a.f.b r2 = b.a.f.b.NO_ERROR     // Catch:{ IOException -> 0x0077 }
                b.a.f.b r0 = b.a.f.b.CANCEL     // Catch:{ IOException -> 0x0073 }
                b.a.f.g r1 = b.a.f.g.this     // Catch:{ IOException -> 0x006d }
            L_0x006a:
                r1.a((b.a.f.b) r2, (b.a.f.b) r0)     // Catch:{ IOException -> 0x006d }
            L_0x006d:
                b.a.f.h r0 = r10.f142a
                b.a.c.a((java.io.Closeable) r0)
                return
            L_0x0073:
                r0 = r2
                goto L_0x0077
            L_0x0075:
                r2 = move-exception
                goto L_0x0082
            L_0x0077:
                b.a.f.b r2 = b.a.f.b.PROTOCOL_ERROR     // Catch:{ all -> 0x0075 }
                b.a.f.b r0 = b.a.f.b.PROTOCOL_ERROR     // Catch:{ all -> 0x007e }
                b.a.f.g r1 = b.a.f.g.this     // Catch:{ IOException -> 0x006d }
                goto L_0x006a
            L_0x007e:
                r0 = move-exception
                r9 = r2
                r2 = r0
                r0 = r9
            L_0x0082:
                b.a.f.g r3 = b.a.f.g.this     // Catch:{ IOException -> 0x0087 }
                r3.a((b.a.f.b) r0, (b.a.f.b) r1)     // Catch:{ IOException -> 0x0087 }
            L_0x0087:
                b.a.f.h r0 = r10.f142a
                b.a.c.a((java.io.Closeable) r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.f.g.c.b():void");
        }

        public final void c() {
        }

        public final void d() {
        }
    }

    public g(a aVar) {
        this.j = aVar.f;
        this.f123b = aVar.g;
        this.f124c = aVar.e;
        int i2 = 2;
        this.g = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.g += 2;
        }
        this.v = aVar.g ? 1 : i2;
        if (aVar.g) {
            this.m.a(7, 16777216);
        }
        this.e = aVar.f140b;
        this.i = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), b.a.c.a(b.a.c.a("OkHttp %s Push Observer", this.e), true));
        this.n.a(7, 65535);
        this.n.a(5, 16384);
        this.l = (long) this.n.b();
        this.p = aVar.f139a;
        this.q = new j(aVar.d, this.f123b);
        this.r = new c(new h(aVar.f141c, this.f123b));
    }

    private i a(List<c> list, boolean z) throws IOException {
        return a(0, list, z);
    }

    private void a(int i2, int i3) {
        final int i4 = i2;
        final int i5 = i3;
        f122a.execute(new b.a.b("OkHttp %s ping %08x%08x", new Object[]{this.e, Integer.valueOf(i2), Integer.valueOf(i3)}) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f129a = true;
            final /* synthetic */ l e;

            {
                this.e = null;
            }

            public final void b() {
                try {
                    g.this.a(this.f129a, i4, i5, this.e);
                } catch (IOException unused) {
                }
            }
        });
    }

    private void a(int i2, e eVar, int i3, boolean z) throws IOException {
        final c.c cVar = new c.c();
        long j2 = (long) i3;
        eVar.a(j2);
        eVar.read(cVar, j2);
        if (cVar.f387c != j2) {
            throw new IOException(cVar.f387c + " != " + i3);
        }
        final int i4 = i2;
        final int i5 = i3;
        final boolean z2 = z;
        this.i.execute(new b.a.b("OkHttp %s Push Data[%s]", new Object[]{this.e, Integer.valueOf(i2)}) {
            public final void b() {
                try {
                    g.this.j.a(cVar, i5);
                    g.this.q.a(i4, b.CANCEL);
                    synchronized (g.this) {
                        g.this.s.remove(Integer.valueOf(i4));
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    private void a(int i2, List<c> list) {
        synchronized (this) {
            if (this.s.contains(Integer.valueOf(i2))) {
                a(i2, b.PROTOCOL_ERROR);
                return;
            }
            this.s.add(Integer.valueOf(i2));
            final int i3 = i2;
            final List<c> list2 = list;
            this.i.execute(new b.a.b("OkHttp %s Push Request[%s]", new Object[]{this.e, Integer.valueOf(i2)}) {
                public final void b() {
                    g.this.j.a();
                    try {
                        g.this.q.a(i3, b.CANCEL);
                        synchronized (g.this) {
                            g.this.s.remove(Integer.valueOf(i3));
                        }
                    } catch (IOException unused) {
                    }
                }
            });
        }
    }

    private void a(int i2, boolean z, List<c> list) throws IOException {
        this.q.b(z, i2, list);
    }

    private void a(long j2) {
        this.l += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    private void a(b bVar) throws IOException {
        synchronized (this.q) {
            synchronized (this) {
                if (!this.h) {
                    this.h = true;
                    int i2 = this.f;
                    this.q.a(i2, bVar, b.a.c.f51a);
                }
            }
        }
    }

    private void a(n nVar) throws IOException {
        synchronized (this.q) {
            synchronized (this) {
                if (this.h) {
                    throw new a();
                }
                this.m.a(nVar);
                this.q.b(nVar);
            }
        }
    }

    private i b(int i2, List<c> list, boolean z) throws IOException {
        if (!this.f123b) {
            return a(i2, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    private static aa c() {
        return aa.HTTP_2;
    }

    private void c(int i2, b bVar) {
        final int i3 = i2;
        final b bVar2 = bVar;
        this.i.execute(new b.a.b("OkHttp %s Push Reset[%s]", new Object[]{this.e, Integer.valueOf(i2)}) {
            public final void b() {
                g.this.j.c();
                synchronized (g.this) {
                    g.this.s.remove(Integer.valueOf(i3));
                }
            }
        });
    }

    private void c(int i2, List<c> list, boolean z) {
        final int i3 = i2;
        final List<c> list2 = list;
        final boolean z2 = z;
        this.i.execute(new b.a.b("OkHttp %s Push Headers[%s]", new Object[]{this.e, Integer.valueOf(i2)}) {
            public final void b() {
                g.this.j.b();
                try {
                    g.this.q.a(i3, b.CANCEL);
                    synchronized (g.this) {
                        g.this.s.remove(Integer.valueOf(i3));
                    }
                } catch (IOException unused) {
                }
            }
        });
    }

    private synchronized int d() {
        return this.d.size();
    }

    static boolean d(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    private l e() throws IOException {
        int i2;
        l lVar = new l();
        synchronized (this) {
            if (this.h) {
                throw new a();
            }
            i2 = this.v;
            this.v += 2;
            if (this.u == null) {
                this.u = new LinkedHashMap();
            }
            this.u.put(Integer.valueOf(i2), lVar);
        }
        a(false, i2, 1330343787, lVar);
        return lVar;
    }

    private void f() throws IOException {
        this.q.b();
    }

    private void g() throws IOException {
        this.q.a();
        this.q.b(this.m);
        int b2 = this.m.b();
        if (b2 != 65535) {
            this.q.a(0, (long) (b2 - 65535));
        }
        new Thread(this.r).start();
    }

    private void h() throws IOException {
        this.q.a();
        this.q.b(this.m);
        int b2 = this.m.b();
        if (b2 != 65535) {
            this.q.a(0, (long) (b2 - 65535));
        }
        new Thread(this.r).start();
    }

    public final synchronized int a() {
        n nVar = this.n;
        if ((nVar.i & 16) == 0) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        return nVar.j[4];
    }

    /* access modifiers changed from: package-private */
    public final synchronized i a(int i2) {
        return this.d.get(Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final b.a.f.i a(int r11, java.util.List<b.a.f.c> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            b.a.f.j r7 = r10.q
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x006c }
            boolean r0 = r10.h     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0010
            b.a.f.a r11 = new b.a.f.a     // Catch:{ all -> 0x0069 }
            r11.<init>()     // Catch:{ all -> 0x0069 }
            throw r11     // Catch:{ all -> 0x0069 }
        L_0x0010:
            int r8 = r10.g     // Catch:{ all -> 0x0069 }
            int r0 = r10.g     // Catch:{ all -> 0x0069 }
            int r0 = r0 + 2
            r10.g = r0     // Catch:{ all -> 0x0069 }
            b.a.f.i r9 = new b.a.f.i     // Catch:{ all -> 0x0069 }
            r4 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0069 }
            if (r13 == 0) goto L_0x0036
            long r0 = r10.l     // Catch:{ all -> 0x0069 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0036
            long r0 = r9.f156b     // Catch:{ all -> 0x0069 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r13 = 0
            goto L_0x0037
        L_0x0036:
            r13 = 1
        L_0x0037:
            boolean r0 = r9.a()     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0046
            java.util.Map<java.lang.Integer, b.a.f.i> r0 = r10.d     // Catch:{ all -> 0x0069 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0069 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0069 }
        L_0x0046:
            monitor-exit(r10)     // Catch:{ all -> 0x0069 }
            if (r11 != 0) goto L_0x004f
            b.a.f.j r11 = r10.q     // Catch:{ all -> 0x006c }
            r11.a((boolean) r6, (int) r8, (java.util.List<b.a.f.c>) r12)     // Catch:{ all -> 0x006c }
            goto L_0x0060
        L_0x004f:
            boolean r0 = r10.f123b     // Catch:{ all -> 0x006c }
            if (r0 == 0) goto L_0x005b
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x006c }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x006c }
            throw r11     // Catch:{ all -> 0x006c }
        L_0x005b:
            b.a.f.j r0 = r10.q     // Catch:{ all -> 0x006c }
            r0.a((int) r11, (int) r8, (java.util.List<b.a.f.c>) r12)     // Catch:{ all -> 0x006c }
        L_0x0060:
            monitor-exit(r7)     // Catch:{ all -> 0x006c }
            if (r13 == 0) goto L_0x0068
            b.a.f.j r11 = r10.q
            r11.b()
        L_0x0068:
            return r9
        L_0x0069:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0069 }
            throw r11     // Catch:{ all -> 0x006c }
        L_0x006c:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x006c }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.f.g.a(int, java.util.List, boolean):b.a.f.i");
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, long j2) {
        final int i3 = i2;
        final long j3 = j2;
        f122a.execute(new b.a.b("OkHttp Window Update %s stream %d", new Object[]{this.e, Integer.valueOf(i2)}) {
            public final void b() {
                try {
                    g.this.q.a(i3, j3);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, b bVar) {
        final int i3 = i2;
        final b bVar2 = bVar;
        f122a.execute(new b.a.b("OkHttp %s stream %d", new Object[]{this.e, Integer.valueOf(i2)}) {
            public final void b() {
                try {
                    g.this.b(i3, bVar2);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = java.lang.Math.min((int) java.lang.Math.min(r14, r10.l), r10.q.f166a);
        r6 = (long) r2;
        r10.l -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r11, boolean r12, c.c r13, long r14) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto L_0x000d
            b.a.f.j r14 = r10.q
            r14.a((boolean) r12, (int) r11, (c.c) r13, (int) r3)
            return
        L_0x000d:
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0064
            monitor-enter(r10)
        L_0x0012:
            long r4 = r10.l     // Catch:{ InterruptedException -> 0x005c }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, b.a.f.i> r2 = r10.d     // Catch:{ InterruptedException -> 0x005c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)     // Catch:{ InterruptedException -> 0x005c }
            boolean r2 = r2.containsKey(r4)     // Catch:{ InterruptedException -> 0x005c }
            if (r2 != 0) goto L_0x002c
            java.io.IOException r11 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005c }
            java.lang.String r12 = "stream closed"
            r11.<init>(r12)     // Catch:{ InterruptedException -> 0x005c }
            throw r11     // Catch:{ InterruptedException -> 0x005c }
        L_0x002c:
            r10.wait()     // Catch:{ InterruptedException -> 0x005c }
            goto L_0x0012
        L_0x0030:
            long r4 = r10.l     // Catch:{ all -> 0x005a }
            long r4 = java.lang.Math.min(r14, r4)     // Catch:{ all -> 0x005a }
            int r2 = (int) r4     // Catch:{ all -> 0x005a }
            b.a.f.j r4 = r10.q     // Catch:{ all -> 0x005a }
            int r4 = r4.f166a     // Catch:{ all -> 0x005a }
            int r2 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x005a }
            long r4 = r10.l     // Catch:{ all -> 0x005a }
            long r6 = (long) r2     // Catch:{ all -> 0x005a }
            long r8 = r4 - r6
            r10.l = r8     // Catch:{ all -> 0x005a }
            monitor-exit(r10)     // Catch:{ all -> 0x005a }
            r4 = 0
            long r4 = r14 - r6
            b.a.f.j r14 = r10.q
            if (r12 == 0) goto L_0x0054
            int r15 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r15 != 0) goto L_0x0054
            r15 = 1
            goto L_0x0055
        L_0x0054:
            r15 = 0
        L_0x0055:
            r14.a((boolean) r15, (int) r11, (c.c) r13, (int) r2)
            r14 = r4
            goto L_0x000d
        L_0x005a:
            r11 = move-exception
            goto L_0x0062
        L_0x005c:
            java.io.InterruptedIOException r11 = new java.io.InterruptedIOException     // Catch:{ all -> 0x005a }
            r11.<init>()     // Catch:{ all -> 0x005a }
            throw r11     // Catch:{ all -> 0x005a }
        L_0x0062:
            monitor-exit(r10)     // Catch:{ all -> 0x005a }
            throw r11
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.f.g.a(int, boolean, c.c, long):void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    final void a(b.a.f.b r10, b.a.f.b r11) throws java.io.IOException {
        /*
            r9 = this;
            boolean r0 = t
            if (r0 != 0) goto L_0x0010
            boolean r0 = java.lang.Thread.holdsLock(r9)
            if (r0 == 0) goto L_0x0010
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        L_0x0010:
            r0 = 0
            b.a.f.j r1 = r9.q     // Catch:{ IOException -> 0x0032 }
            monitor-enter(r1)     // Catch:{ IOException -> 0x0032 }
            monitor-enter(r9)     // Catch:{ all -> 0x002f }
            boolean r2 = r9.h     // Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x001c
            monitor-exit(r9)     // Catch:{ all -> 0x002c }
        L_0x001a:
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
            goto L_0x002a
        L_0x001c:
            r2 = 1
            r9.h = r2     // Catch:{ all -> 0x002c }
            int r2 = r9.f     // Catch:{ all -> 0x002c }
            monitor-exit(r9)     // Catch:{ all -> 0x002c }
            b.a.f.j r3 = r9.q     // Catch:{ all -> 0x002f }
            byte[] r4 = b.a.c.f51a     // Catch:{ all -> 0x002f }
            r3.a((int) r2, (b.a.f.b) r10, (byte[]) r4)     // Catch:{ all -> 0x002f }
            goto L_0x001a
        L_0x002a:
            r10 = r0
            goto L_0x0033
        L_0x002c:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x002c }
            throw r10     // Catch:{ all -> 0x002f }
        L_0x002f:
            r10 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
            throw r10     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            r10 = move-exception
        L_0x0033:
            monitor-enter(r9)
            java.util.Map<java.lang.Integer, b.a.f.i> r1 = r9.d     // Catch:{ all -> 0x00ca }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00ca }
            if (r1 != 0) goto L_0x0056
            java.util.Map<java.lang.Integer, b.a.f.i> r1 = r9.d     // Catch:{ all -> 0x00ca }
            java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x00ca }
            java.util.Map<java.lang.Integer, b.a.f.i> r2 = r9.d     // Catch:{ all -> 0x00ca }
            int r2 = r2.size()     // Catch:{ all -> 0x00ca }
            b.a.f.i[] r2 = new b.a.f.i[r2]     // Catch:{ all -> 0x00ca }
            java.lang.Object[] r1 = r1.toArray(r2)     // Catch:{ all -> 0x00ca }
            b.a.f.i[] r1 = (b.a.f.i[]) r1     // Catch:{ all -> 0x00ca }
            java.util.Map<java.lang.Integer, b.a.f.i> r2 = r9.d     // Catch:{ all -> 0x00ca }
            r2.clear()     // Catch:{ all -> 0x00ca }
            goto L_0x0057
        L_0x0056:
            r1 = r0
        L_0x0057:
            java.util.Map<java.lang.Integer, b.a.f.l> r2 = r9.u     // Catch:{ all -> 0x00ca }
            if (r2 == 0) goto L_0x0072
            java.util.Map<java.lang.Integer, b.a.f.l> r2 = r9.u     // Catch:{ all -> 0x00ca }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x00ca }
            java.util.Map<java.lang.Integer, b.a.f.l> r3 = r9.u     // Catch:{ all -> 0x00ca }
            int r3 = r3.size()     // Catch:{ all -> 0x00ca }
            b.a.f.l[] r3 = new b.a.f.l[r3]     // Catch:{ all -> 0x00ca }
            java.lang.Object[] r2 = r2.toArray(r3)     // Catch:{ all -> 0x00ca }
            b.a.f.l[] r2 = (b.a.f.l[]) r2     // Catch:{ all -> 0x00ca }
            r9.u = r0     // Catch:{ all -> 0x00ca }
            r0 = r2
        L_0x0072:
            monitor-exit(r9)     // Catch:{ all -> 0x00ca }
            r2 = 0
            if (r1 == 0) goto L_0x0089
            int r3 = r1.length
            r4 = r10
            r10 = 0
        L_0x0079:
            if (r10 >= r3) goto L_0x0088
            r5 = r1[r10]
            r5.a((b.a.f.b) r11)     // Catch:{ IOException -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r5 = move-exception
            if (r4 == 0) goto L_0x0085
            r4 = r5
        L_0x0085:
            int r10 = r10 + 1
            goto L_0x0079
        L_0x0088:
            r10 = r4
        L_0x0089:
            if (r0 == 0) goto L_0x00b5
            int r11 = r0.length
        L_0x008c:
            if (r2 >= r11) goto L_0x00b5
            r1 = r0[r2]
            long r3 = r1.f176c
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x00af
            long r3 = r1.f175b
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x009f
            goto L_0x00af
        L_0x009f:
            long r3 = r1.f175b
            r5 = 1
            long r7 = r3 - r5
            r1.f176c = r7
            java.util.concurrent.CountDownLatch r1 = r1.f174a
            r1.countDown()
            int r2 = r2 + 1
            goto L_0x008c
        L_0x00af:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r10.<init>()
            throw r10
        L_0x00b5:
            b.a.f.j r11 = r9.q     // Catch:{ IOException -> 0x00bb }
            r11.close()     // Catch:{ IOException -> 0x00bb }
            goto L_0x00bf
        L_0x00bb:
            r11 = move-exception
            if (r10 != 0) goto L_0x00bf
            r10 = r11
        L_0x00bf:
            java.net.Socket r11 = r9.p     // Catch:{ IOException -> 0x00c5 }
            r11.close()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00c6
        L_0x00c5:
            r10 = move-exception
        L_0x00c6:
            if (r10 == 0) goto L_0x00c9
            throw r10
        L_0x00c9:
            return
        L_0x00ca:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00ca }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.f.g.a(b.a.f.b, b.a.f.b):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z, int i2, int i3, l lVar) throws IOException {
        synchronized (this.q) {
            if (lVar != null) {
                try {
                    if (lVar.f175b != -1) {
                        throw new IllegalStateException();
                    }
                    lVar.f175b = System.nanoTime();
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.q.a(z, i2, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized i b(int i2) {
        i remove;
        remove = this.d.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2, b bVar) throws IOException {
        this.q.a(i2, bVar);
    }

    public final synchronized boolean b() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public final synchronized l c(int i2) {
        if (this.u == null) {
            return null;
        }
        return this.u.remove(Integer.valueOf(i2));
    }

    public final void close() throws IOException {
        a(b.NO_ERROR, b.CANCEL);
    }
}

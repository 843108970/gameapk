package b.a.b;

import c.c;
import c.f;
import c.y;
import c.z;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

final class b {

    /* renamed from: a  reason: collision with root package name */
    static final f f45a = f.encodeUtf8("OkHttp cache v1\n");

    /* renamed from: b  reason: collision with root package name */
    static final f f46b = f.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int l = 1;
    private static final int m = 2;
    private static final long n = 32;

    /* renamed from: c  reason: collision with root package name */
    RandomAccessFile f47c;
    Thread d;
    y e;
    final c f = new c();
    long g;
    boolean h;
    final c i = new c();
    final long j;
    int k;
    private final f o;

    class a implements y {

        /* renamed from: b  reason: collision with root package name */
        private final z f49b = new z();

        /* renamed from: c  reason: collision with root package name */
        private a f50c = new a(b.this.f47c.getChannel());
        private long d;

        a() {
        }

        public final void close() throws IOException {
            if (this.f50c != null) {
                RandomAccessFile randomAccessFile = null;
                this.f50c = null;
                synchronized (b.this) {
                    b bVar = b.this;
                    bVar.k--;
                    if (b.this.k == 0) {
                        RandomAccessFile randomAccessFile2 = b.this.f47c;
                        b.this.f47c = null;
                        randomAccessFile = randomAccessFile2;
                    }
                }
                if (randomAccessFile != null) {
                    b.a.c.a((Closeable) randomAccessFile);
                }
            }
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
            r14 = r7 - r1.f48a.i.f387c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
            if (r1.d >= r14) goto L_0x012e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
            r6 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
            r2 = java.lang.Math.min(r2, r7 - r1.d);
            r1.f48a.i.a(r23, r1.d - r14, r2);
            r1.d += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x0151, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final long read(c.c r23, long r24) throws java.io.IOException {
            /*
                r22 = this;
                r1 = r22
                r2 = r24
                b.a.b.a r4 = r1.f50c
                if (r4 != 0) goto L_0x0010
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.String r3 = "closed"
                r2.<init>(r3)
                throw r2
            L_0x0010:
                b.a.b.b r4 = b.a.b.b.this
                monitor-enter(r4)
            L_0x0013:
                long r5 = r1.d     // Catch:{ all -> 0x0152 }
                b.a.b.b r7 = b.a.b.b.this     // Catch:{ all -> 0x0152 }
                long r7 = r7.g     // Catch:{ all -> 0x0152 }
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                r5 = 2
                r10 = -1
                if (r9 != 0) goto L_0x0041
                b.a.b.b r6 = b.a.b.b.this     // Catch:{ all -> 0x0152 }
                boolean r6 = r6.h     // Catch:{ all -> 0x0152 }
                if (r6 == 0) goto L_0x0028
                monitor-exit(r4)     // Catch:{ all -> 0x0152 }
                return r10
            L_0x0028:
                b.a.b.b r6 = b.a.b.b.this     // Catch:{ all -> 0x0152 }
                java.lang.Thread r6 = r6.d     // Catch:{ all -> 0x0152 }
                if (r6 == 0) goto L_0x0036
                c.z r5 = r1.f49b     // Catch:{ all -> 0x0152 }
                b.a.b.b r6 = b.a.b.b.this     // Catch:{ all -> 0x0152 }
                r5.a((java.lang.Object) r6)     // Catch:{ all -> 0x0152 }
                goto L_0x0013
            L_0x0036:
                b.a.b.b r6 = b.a.b.b.this     // Catch:{ all -> 0x0152 }
                java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0152 }
                r6.d = r9     // Catch:{ all -> 0x0152 }
                r6 = 1
                monitor-exit(r4)     // Catch:{ all -> 0x0152 }
                goto L_0x0052
            L_0x0041:
                b.a.b.b r6 = b.a.b.b.this     // Catch:{ all -> 0x0152 }
                c.c r6 = r6.i     // Catch:{ all -> 0x0152 }
                long r12 = r6.f387c     // Catch:{ all -> 0x0152 }
                r6 = 0
                long r14 = r7 - r12
                long r12 = r1.d     // Catch:{ all -> 0x0152 }
                int r6 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r6 >= 0) goto L_0x012e
                monitor-exit(r4)     // Catch:{ all -> 0x0152 }
                r6 = 2
            L_0x0052:
                r12 = 32
                if (r6 != r5) goto L_0x0072
                long r4 = r1.d
                long r9 = r7 - r4
                long r8 = java.lang.Math.min(r2, r9)
                b.a.b.a r2 = r1.f50c
                long r3 = r1.d
                long r5 = r3 + r12
                r3 = r5
                r5 = r23
                r6 = r8
                r2.b(r3, r5, r6)
                long r2 = r1.d
                long r4 = r2 + r8
                r1.d = r4
                return r8
            L_0x0072:
                r4 = 0
                b.a.b.b r5 = b.a.b.b.this     // Catch:{ all -> 0x011a }
                c.y r5 = r5.e     // Catch:{ all -> 0x011a }
                b.a.b.b r6 = b.a.b.b.this     // Catch:{ all -> 0x011a }
                c.c r6 = r6.f     // Catch:{ all -> 0x011a }
                b.a.b.b r9 = b.a.b.b.this     // Catch:{ all -> 0x011a }
                long r14 = r9.j     // Catch:{ all -> 0x011a }
                long r5 = r5.read(r6, r14)     // Catch:{ all -> 0x011a }
                int r9 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r9 != 0) goto L_0x009e
                b.a.b.b r2 = b.a.b.b.this     // Catch:{ all -> 0x011a }
                r2.a((long) r7)     // Catch:{ all -> 0x011a }
                b.a.b.b r2 = b.a.b.b.this
                monitor-enter(r2)
                b.a.b.b r3 = b.a.b.b.this     // Catch:{ all -> 0x009a }
                r3.d = r4     // Catch:{ all -> 0x009a }
                b.a.b.b r3 = b.a.b.b.this     // Catch:{ all -> 0x009a }
                r3.notifyAll()     // Catch:{ all -> 0x009a }
                monitor-exit(r2)     // Catch:{ all -> 0x009a }
                return r10
            L_0x009a:
                r0 = move-exception
                r3 = r0
                monitor-exit(r2)     // Catch:{ all -> 0x009a }
                throw r3
            L_0x009e:
                long r2 = java.lang.Math.min(r5, r2)     // Catch:{ all -> 0x011a }
                b.a.b.b r9 = b.a.b.b.this     // Catch:{ all -> 0x011a }
                c.c r14 = r9.f     // Catch:{ all -> 0x011a }
                r16 = 0
                r15 = r23
                r18 = r2
                r14.a((c.c) r15, (long) r16, (long) r18)     // Catch:{ all -> 0x011a }
                long r9 = r1.d     // Catch:{ all -> 0x011a }
                r11 = 0
                long r14 = r9 + r2
                r1.d = r14     // Catch:{ all -> 0x011a }
                b.a.b.a r9 = r1.f50c     // Catch:{ all -> 0x011a }
                r10 = 0
                long r17 = r7 + r12
                b.a.b.b r7 = b.a.b.b.this     // Catch:{ all -> 0x011a }
                c.c r7 = r7.f     // Catch:{ all -> 0x011a }
                c.c r19 = r7.clone()     // Catch:{ all -> 0x011a }
                r16 = r9
                r20 = r5
                r16.a(r17, r19, r20)     // Catch:{ all -> 0x011a }
                b.a.b.b r7 = b.a.b.b.this     // Catch:{ all -> 0x011a }
                monitor-enter(r7)     // Catch:{ all -> 0x011a }
                b.a.b.b r8 = b.a.b.b.this     // Catch:{ all -> 0x0116 }
                c.c r8 = r8.i     // Catch:{ all -> 0x0116 }
                b.a.b.b r9 = b.a.b.b.this     // Catch:{ all -> 0x0116 }
                c.c r9 = r9.f     // Catch:{ all -> 0x0116 }
                r8.a((c.c) r9, (long) r5)     // Catch:{ all -> 0x0116 }
                b.a.b.b r8 = b.a.b.b.this     // Catch:{ all -> 0x0116 }
                c.c r8 = r8.i     // Catch:{ all -> 0x0116 }
                long r8 = r8.f387c     // Catch:{ all -> 0x0116 }
                b.a.b.b r10 = b.a.b.b.this     // Catch:{ all -> 0x0116 }
                long r10 = r10.j     // Catch:{ all -> 0x0116 }
                int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r12 <= 0) goto L_0x00fa
                b.a.b.b r8 = b.a.b.b.this     // Catch:{ all -> 0x0116 }
                c.c r8 = r8.i     // Catch:{ all -> 0x0116 }
                b.a.b.b r9 = b.a.b.b.this     // Catch:{ all -> 0x0116 }
                c.c r9 = r9.i     // Catch:{ all -> 0x0116 }
                long r9 = r9.f387c     // Catch:{ all -> 0x0116 }
                b.a.b.b r11 = b.a.b.b.this     // Catch:{ all -> 0x0116 }
                long r11 = r11.j     // Catch:{ all -> 0x0116 }
                r13 = 0
                long r13 = r9 - r11
                r8.h((long) r13)     // Catch:{ all -> 0x0116 }
            L_0x00fa:
                b.a.b.b r8 = b.a.b.b.this     // Catch:{ all -> 0x0116 }
                long r9 = r8.g     // Catch:{ all -> 0x0116 }
                r11 = 0
                long r11 = r9 + r5
                r8.g = r11     // Catch:{ all -> 0x0116 }
                monitor-exit(r7)     // Catch:{ all -> 0x0116 }
                b.a.b.b r5 = b.a.b.b.this
                monitor-enter(r5)
                b.a.b.b r6 = b.a.b.b.this     // Catch:{ all -> 0x0112 }
                r6.d = r4     // Catch:{ all -> 0x0112 }
                b.a.b.b r4 = b.a.b.b.this     // Catch:{ all -> 0x0112 }
                r4.notifyAll()     // Catch:{ all -> 0x0112 }
                monitor-exit(r5)     // Catch:{ all -> 0x0112 }
                return r2
            L_0x0112:
                r0 = move-exception
                r2 = r0
                monitor-exit(r5)     // Catch:{ all -> 0x0112 }
                throw r2
            L_0x0116:
                r0 = move-exception
                r2 = r0
                monitor-exit(r7)     // Catch:{ all -> 0x0116 }
                throw r2     // Catch:{ all -> 0x011a }
            L_0x011a:
                r0 = move-exception
                r2 = r0
                b.a.b.b r3 = b.a.b.b.this
                monitor-enter(r3)
                b.a.b.b r5 = b.a.b.b.this     // Catch:{ all -> 0x012a }
                r5.d = r4     // Catch:{ all -> 0x012a }
                b.a.b.b r4 = b.a.b.b.this     // Catch:{ all -> 0x012a }
                r4.notifyAll()     // Catch:{ all -> 0x012a }
                monitor-exit(r3)     // Catch:{ all -> 0x012a }
                throw r2
            L_0x012a:
                r0 = move-exception
                r2 = r0
                monitor-exit(r3)     // Catch:{ all -> 0x012a }
                throw r2
            L_0x012e:
                long r5 = r1.d     // Catch:{ all -> 0x0152 }
                r9 = 0
                long r9 = r7 - r5
                long r2 = java.lang.Math.min(r2, r9)     // Catch:{ all -> 0x0152 }
                b.a.b.b r5 = b.a.b.b.this     // Catch:{ all -> 0x0152 }
                c.c r5 = r5.i     // Catch:{ all -> 0x0152 }
                long r6 = r1.d     // Catch:{ all -> 0x0152 }
                r8 = 0
                long r18 = r6 - r14
                r16 = r5
                r17 = r23
                r20 = r2
                r16.a((c.c) r17, (long) r18, (long) r20)     // Catch:{ all -> 0x0152 }
                long r5 = r1.d     // Catch:{ all -> 0x0152 }
                r7 = 0
                long r7 = r5 + r2
                r1.d = r7     // Catch:{ all -> 0x0152 }
                monitor-exit(r4)     // Catch:{ all -> 0x0152 }
                return r2
            L_0x0152:
                r0 = move-exception
                r2 = r0
                monitor-exit(r4)     // Catch:{ all -> 0x0152 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.b.b.a.read(c.c, long):long");
        }

        public final z timeout() {
            return this.f49b;
        }
    }

    private b(RandomAccessFile randomAccessFile, y yVar, long j2, f fVar, long j3) {
        this.f47c = randomAccessFile;
        this.e = yVar;
        this.h = yVar == null;
        this.g = j2;
        this.o = fVar;
        this.j = j3;
    }

    private static b a(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        a aVar = new a(randomAccessFile.getChannel());
        c cVar = new c();
        aVar.b(0, cVar, 32);
        if (!cVar.d((long) f45a.size()).equals(f45a)) {
            throw new IOException("unreadable cache file");
        }
        long j2 = cVar.j();
        long j3 = cVar.j();
        c cVar2 = new c();
        aVar.b(j2 + 32, cVar2, j3);
        return new b(randomAccessFile, (y) null, j2, cVar2.p(), 0);
    }

    private static b a(File file, y yVar, f fVar, long j2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        b bVar = new b(randomAccessFile, yVar, 0, fVar, j2);
        randomAccessFile.setLength(0);
        bVar.a(f46b, -1, -1);
        return bVar;
    }

    private void a(f fVar, long j2, long j3) throws IOException {
        c cVar = new c();
        cVar.e(fVar);
        cVar.p(j2);
        cVar.p(j3);
        if (cVar.f387c != 32) {
            throw new IllegalArgumentException();
        }
        new a(this.f47c.getChannel()).a(0, cVar, 32);
    }

    private boolean a() {
        return this.f47c == null;
    }

    private f b() {
        return this.o;
    }

    private void b(long j2) throws IOException {
        c cVar = new c();
        cVar.e(this.o);
        new a(this.f47c.getChannel()).a(j2 + 32, cVar, (long) this.o.size());
    }

    private y c() {
        synchronized (this) {
            if (this.f47c == null) {
                return null;
            }
            this.k++;
            return new a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2) throws IOException {
        c cVar = new c();
        cVar.e(this.o);
        new a(this.f47c.getChannel()).a(j2 + 32, cVar, (long) this.o.size());
        this.f47c.getChannel().force(false);
        a(f45a, j2, (long) this.o.size());
        this.f47c.getChannel().force(false);
        synchronized (this) {
            this.h = true;
        }
        b.a.c.a((Closeable) this.e);
        this.e = null;
    }
}

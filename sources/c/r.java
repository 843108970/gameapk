package c;

import java.io.IOException;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    final long f415a;

    /* renamed from: b  reason: collision with root package name */
    final c f416b = new c();

    /* renamed from: c  reason: collision with root package name */
    boolean f417c;
    boolean d;
    private final x e = new a();
    private final y f = new b();

    final class a implements x {

        /* renamed from: a  reason: collision with root package name */
        final z f418a = new z();

        a() {
        }

        public final void a(c cVar, long j) throws IOException {
            synchronized (r.this.f416b) {
                if (r.this.f417c) {
                    throw new IllegalStateException("closed");
                }
                while (j > 0) {
                    if (r.this.d) {
                        throw new IOException("source is closed");
                    }
                    long j2 = r.this.f415a - r.this.f416b.f387c;
                    if (j2 == 0) {
                        this.f418a.a((Object) r.this.f416b);
                    } else {
                        long min = Math.min(j2, j);
                        r.this.f416b.a(cVar, min);
                        r.this.f416b.notifyAll();
                        j -= min;
                    }
                }
            }
        }

        public final void close() throws IOException {
            synchronized (r.this.f416b) {
                if (!r.this.f417c) {
                    if (!r.this.d || r.this.f416b.f387c <= 0) {
                        r.this.f417c = true;
                        r.this.f416b.notifyAll();
                        return;
                    }
                    throw new IOException("source is closed");
                }
            }
        }

        public final void flush() throws IOException {
            synchronized (r.this.f416b) {
                if (r.this.f417c) {
                    throw new IllegalStateException("closed");
                } else if (r.this.d && r.this.f416b.f387c > 0) {
                    throw new IOException("source is closed");
                }
            }
        }

        public final z timeout() {
            return this.f418a;
        }
    }

    final class b implements y {

        /* renamed from: a  reason: collision with root package name */
        final z f420a = new z();

        b() {
        }

        public final void close() throws IOException {
            synchronized (r.this.f416b) {
                r.this.d = true;
                r.this.f416b.notifyAll();
            }
        }

        public final long read(c cVar, long j) throws IOException {
            synchronized (r.this.f416b) {
                if (r.this.d) {
                    throw new IllegalStateException("closed");
                }
                while (r.this.f416b.f387c == 0) {
                    if (r.this.f417c) {
                        return -1;
                    }
                    this.f420a.a((Object) r.this.f416b);
                }
                long read = r.this.f416b.read(cVar, j);
                r.this.f416b.notifyAll();
                return read;
            }
        }

        public final z timeout() {
            return this.f420a;
        }
    }

    private r(long j) {
        if (j < 1) {
            throw new IllegalArgumentException("maxBufferSize < 1: " + j);
        }
        this.f415a = j;
    }

    private y a() {
        return this.f;
    }

    private x b() {
        return this.e;
    }
}

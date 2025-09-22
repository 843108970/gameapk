package b.a.k;

import android.support.v4.media.session.PlaybackStateCompat;
import c.c;
import c.f;
import c.x;
import c.z;
import java.io.IOException;
import java.util.Random;

final class d {
    static final /* synthetic */ boolean j = true;

    /* renamed from: a  reason: collision with root package name */
    final boolean f236a;

    /* renamed from: b  reason: collision with root package name */
    final Random f237b;

    /* renamed from: c  reason: collision with root package name */
    final c.d f238c;
    boolean d;
    final c e = new c();
    final a f = new a();
    boolean g;
    final byte[] h;
    final byte[] i;

    final class a implements x {

        /* renamed from: a  reason: collision with root package name */
        int f239a;

        /* renamed from: b  reason: collision with root package name */
        long f240b;

        /* renamed from: c  reason: collision with root package name */
        boolean f241c;
        boolean d;

        a() {
        }

        public final void a(c cVar, long j) throws IOException {
            if (this.d) {
                throw new IOException("closed");
            }
            d.this.e.a(cVar, j);
            boolean z = this.f241c && this.f240b != -1 && d.this.e.f387c > this.f240b - PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            long f = d.this.e.f();
            if (f > 0 && !z) {
                synchronized (d.this) {
                    d.this.a(this.f239a, f, this.f241c, false);
                }
                this.f241c = false;
            }
        }

        public final void close() throws IOException {
            if (this.d) {
                throw new IOException("closed");
            }
            synchronized (d.this) {
                d.this.a(this.f239a, d.this.e.f387c, this.f241c, true);
            }
            this.d = true;
            d.this.g = false;
        }

        public final void flush() throws IOException {
            if (this.d) {
                throw new IOException("closed");
            }
            synchronized (d.this) {
                d.this.a(this.f239a, d.this.e.f387c, this.f241c, false);
            }
            this.f241c = false;
        }

        public final z timeout() {
            return d.this.f238c.timeout();
        }
    }

    d(boolean z, c.d dVar, Random random) {
        if (dVar == null) {
            throw new NullPointerException("sink == null");
        } else if (random == null) {
            throw new NullPointerException("random == null");
        } else {
            this.f236a = z;
            this.f238c = dVar;
            this.f237b = random;
            byte[] bArr = null;
            this.h = z ? new byte[4] : null;
            this.i = z ? new byte[8192] : bArr;
        }
    }

    private x a(int i2, long j2) {
        if (this.g) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.g = true;
        this.f.f239a = i2;
        this.f.f240b = j2;
        this.f.f241c = true;
        this.f.d = false;
        return this.f;
    }

    private void a(f fVar) throws IOException {
        synchronized (this) {
            a(9, fVar);
        }
    }

    private void b(int i2, f fVar) throws IOException {
        f fVar2 = f.EMPTY;
        if (!(i2 == 0 && fVar == null)) {
            if (i2 != 0) {
                b.b(i2);
            }
            c cVar = new c();
            cVar.k(i2);
            if (fVar != null) {
                cVar.e(fVar);
            }
            fVar2 = cVar.p();
        }
        synchronized (this) {
            try {
                a(8, fVar2);
                this.d = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void b(f fVar) throws IOException {
        synchronized (this) {
            a(10, fVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, long j2, boolean z, boolean z2) throws IOException {
        if (!j && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.d) {
            throw new IOException("closed");
        } else {
            if (!z) {
                i2 = 0;
            }
            if (z2) {
                i2 |= 128;
            }
            this.f238c.l(i2);
            int i3 = this.f236a ? 128 : 0;
            if (j2 <= 125) {
                this.f238c.l(i3 | ((int) j2));
            } else if (j2 <= 65535) {
                this.f238c.l(i3 | 126);
                this.f238c.k((int) j2);
            } else {
                this.f238c.l(i3 | 127);
                this.f238c.p(j2);
            }
            if (this.f236a) {
                this.f237b.nextBytes(this.h);
                this.f238c.d(this.h);
                long j3 = 0;
                while (j3 < j2) {
                    int a2 = this.e.a(this.i, 0, (int) Math.min(j2, (long) this.i.length));
                    if (a2 == -1) {
                        throw new AssertionError();
                    }
                    long j4 = (long) a2;
                    b.a(this.i, j4, this.h, j3);
                    this.f238c.c(this.i, 0, a2);
                    j3 += j4;
                }
            } else {
                this.f238c.a(this.e, j2);
            }
            this.f238c.c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, f fVar) throws IOException {
        if (!j && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.d) {
            throw new IOException("closed");
        } else {
            int size = fVar.size();
            if (((long) size) > 125) {
                throw new IllegalArgumentException("Payload size must be less than or equal to 125");
            }
            this.f238c.l(i2 | 128);
            if (this.f236a) {
                this.f238c.l(size | 128);
                this.f237b.nextBytes(this.h);
                this.f238c.d(this.h);
                byte[] byteArray = fVar.toByteArray();
                b.a(byteArray, (long) byteArray.length, this.h, 0);
                this.f238c.d(byteArray);
            } else {
                this.f238c.l(size);
                this.f238c.e(fVar);
            }
            this.f238c.flush();
        }
    }
}

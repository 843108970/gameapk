package c;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

final class s implements d {

    /* renamed from: a  reason: collision with root package name */
    public final c f422a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final x f423b;

    /* renamed from: c  reason: collision with root package name */
    boolean f424c;

    s(x xVar) {
        if (xVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f423b = xVar;
    }

    public final long a(y yVar) throws IOException {
        if (yVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = yVar.read(this.f422a, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            y();
            j += read;
        }
    }

    public final c a() {
        return this.f422a;
    }

    public final d a(y yVar, long j) throws IOException {
        while (j > 0) {
            long read = yVar.read(this.f422a, j);
            if (read == -1) {
                throw new EOFException();
            }
            y();
            j -= read;
        }
        return this;
    }

    public final void a(c cVar, long j) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.a(cVar, j);
        y();
    }

    public final d b(String str) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.b(str);
        return y();
    }

    public final d b(String str, int i, int i2) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.b(str, i, i2);
        return y();
    }

    public final d b(String str, int i, int i2, Charset charset) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.b(str, i, i2, charset);
        return y();
    }

    public final d b(String str, Charset charset) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.b(str, charset);
        return y();
    }

    public final OutputStream b() {
        return new OutputStream() {
            public final void close() throws IOException {
                s.this.close();
            }

            public final void flush() throws IOException {
                if (!s.this.f424c) {
                    s.this.flush();
                }
            }

            public final String toString() {
                return s.this + ".outputStream()";
            }

            public final void write(int i) throws IOException {
                if (s.this.f424c) {
                    throw new IOException("closed");
                }
                s.this.f422a.l((int) (byte) i);
                s.this.y();
            }

            public final void write(byte[] bArr, int i, int i2) throws IOException {
                if (s.this.f424c) {
                    throw new IOException("closed");
                }
                s.this.f422a.c(bArr, i, i2);
                s.this.y();
            }
        };
    }

    public final d c() throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        long j = this.f422a.f387c;
        if (j > 0) {
            this.f423b.a(this.f422a, j);
        }
        return this;
    }

    public final d c(byte[] bArr, int i, int i2) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.c(bArr, i, i2);
        return y();
    }

    public final void close() throws IOException {
        if (!this.f424c) {
            Throwable th = null;
            try {
                if (this.f422a.f387c > 0) {
                    this.f423b.a(this.f422a, this.f422a.f387c);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f423b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f424c = true;
            if (th != null) {
                ab.a(th);
            }
        }
    }

    public final d d(byte[] bArr) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.d(bArr);
        return y();
    }

    public final d e(f fVar) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.e(fVar);
        return y();
    }

    public final void flush() throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        if (this.f422a.f387c > 0) {
            this.f423b.a(this.f422a, this.f422a.f387c);
        }
        this.f423b.flush();
    }

    public final d h(int i) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.h(i);
        return y();
    }

    public final d i(int i) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.i(i);
        return y();
    }

    public final d j(int i) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.j(i);
        return y();
    }

    public final d k(int i) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.k(i);
        return y();
    }

    public final d l(int i) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.l(i);
        return y();
    }

    public final d m(int i) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.m(i);
        return y();
    }

    public final d m(long j) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.m(j);
        return y();
    }

    public final d n(long j) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.n(j);
        return y();
    }

    public final d o(long j) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.o(j);
        return y();
    }

    public final d p(long j) throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        this.f422a.p(j);
        return y();
    }

    public final z timeout() {
        return this.f423b.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f423b + ")";
    }

    public final d y() throws IOException {
        if (this.f424c) {
            throw new IllegalStateException("closed");
        }
        long f = this.f422a.f();
        if (f > 0) {
            this.f423b.a(this.f422a, f);
        }
        return this;
    }
}

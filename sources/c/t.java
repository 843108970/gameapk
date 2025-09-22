package c;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

final class t implements e {

    /* renamed from: a  reason: collision with root package name */
    public final c f426a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final y f427b;

    /* renamed from: c  reason: collision with root package name */
    boolean f428c;

    t(y yVar) {
        if (yVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f427b = yVar;
    }

    public final int a(q qVar) throws IOException {
        if (this.f428c) {
            throw new IllegalStateException("closed");
        }
        do {
            int b2 = this.f426a.b(qVar);
            if (b2 == -1) {
                return -1;
            }
            long size = (long) qVar.f414a[b2].size();
            if (size <= this.f426a.f387c) {
                this.f426a.h(size);
                return b2;
            }
        } while (this.f427b.read(this.f426a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    public final int a(byte[] bArr) throws IOException {
        return a(bArr, 0, bArr.length);
    }

    public final int a(byte[] bArr, int i, int i2) throws IOException {
        long j = (long) i2;
        ab.a((long) bArr.length, (long) i, j);
        if (this.f426a.f387c == 0 && this.f427b.read(this.f426a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f426a.a(bArr, i, (int) Math.min(j, this.f426a.f387c));
    }

    public final long a(byte b2) throws IOException {
        return a(b2, 0, Long.MAX_VALUE);
    }

    public final long a(byte b2, long j) throws IOException {
        return a(b2, j, Long.MAX_VALUE);
    }

    public final long a(byte b2, long j, long j2) throws IOException {
        if (this.f428c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long a2 = this.f426a.a(b2, j, j2);
                if (a2 != -1) {
                    return a2;
                }
                long j3 = this.f426a.f387c;
                if (j3 >= j2 || this.f427b.read(this.f426a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                j = Math.max(j, j3);
            }
            return -1;
        }
    }

    public final long a(f fVar, long j) throws IOException {
        if (this.f428c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long a2 = this.f426a.a(fVar, j);
            if (a2 != -1) {
                return a2;
            }
            long j2 = this.f426a.f387c;
            if (this.f427b.read(this.f426a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            j = Math.max(j, (j2 - ((long) fVar.size())) + 1);
        }
    }

    public final long a(x xVar) throws IOException {
        if (xVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.f427b.read(this.f426a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            long f = this.f426a.f();
            if (f > 0) {
                xVar.a(this.f426a, f);
                j += f;
            }
        }
        if (this.f426a.f387c <= 0) {
            return j;
        }
        long j2 = j + this.f426a.f387c;
        xVar.a(this.f426a, this.f426a.f387c);
        return j2;
    }

    public final c a() {
        return this.f426a;
    }

    public final String a(long j, Charset charset) throws IOException {
        a(j);
        if (charset != null) {
            return this.f426a.a(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public final String a(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f426a.a(this.f427b);
        return this.f426a.a(charset);
    }

    public final void a(long j) throws IOException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    public final boolean a(f fVar, int i) throws IOException {
        if (this.f428c) {
            throw new IllegalStateException("closed");
        } else if (i < 0 || fVar.size() - 0 < i) {
            return false;
        } else {
            for (int i2 = 0; i2 < i; i2++) {
                long j = ((long) i2) + 0;
                if (!b(j + 1) || this.f426a.c(j) != fVar.getByte(i2 + 0)) {
                    return false;
                }
            }
            return true;
        }
    }

    public final long b(f fVar) throws IOException {
        return a(fVar, 0);
    }

    public final long b(f fVar, long j) throws IOException {
        if (this.f428c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long b2 = this.f426a.b(fVar, j);
            if (b2 != -1) {
                return b2;
            }
            long j2 = this.f426a.f387c;
            if (this.f427b.read(this.f426a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            j = Math.max(j, j2);
        }
    }

    public final void b(c cVar, long j) throws IOException {
        try {
            a(j);
            this.f426a.b(cVar, j);
        } catch (EOFException e) {
            cVar.a((y) this.f426a);
            throw e;
        }
    }

    public final void b(byte[] bArr) throws IOException {
        try {
            a((long) bArr.length);
            this.f426a.b(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.f426a.f387c > 0) {
                int a2 = this.f426a.a(bArr, i, (int) this.f426a.f387c);
                if (a2 == -1) {
                    throw new AssertionError();
                }
                i += a2;
            }
            throw e;
        }
    }

    public final boolean b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f428c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f426a.f387c < j) {
                if (this.f427b.read(this.f426a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public final long c(f fVar) throws IOException {
        return b(fVar, 0);
    }

    public final void close() throws IOException {
        if (!this.f428c) {
            this.f428c = true;
            this.f427b.close();
            this.f426a.w();
        }
    }

    public final f d(long j) throws IOException {
        a(j);
        return this.f426a.d(j);
    }

    public final boolean d() throws IOException {
        if (!this.f428c) {
            return this.f426a.d() && this.f427b.read(this.f426a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public final boolean d(f fVar) throws IOException {
        return a(fVar, fVar.size());
    }

    public final InputStream e() {
        return new InputStream() {
            public final int available() throws IOException {
                if (!t.this.f428c) {
                    return (int) Math.min(t.this.f426a.f387c, 2147483647L);
                }
                throw new IOException("closed");
            }

            public final void close() throws IOException {
                t.this.close();
            }

            public final int read() throws IOException {
                if (t.this.f428c) {
                    throw new IOException("closed");
                } else if (t.this.f426a.f387c == 0 && t.this.f427b.read(t.this.f426a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                } else {
                    return t.this.f426a.g() & 255;
                }
            }

            public final int read(byte[] bArr, int i, int i2) throws IOException {
                if (t.this.f428c) {
                    throw new IOException("closed");
                }
                ab.a((long) bArr.length, (long) i, (long) i2);
                if (t.this.f426a.f387c == 0 && t.this.f427b.read(t.this.f426a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return t.this.f426a.a(bArr, i, i2);
            }

            public final String toString() {
                return t.this + ".inputStream()";
            }
        };
    }

    public final String e(long j) throws IOException {
        a(j);
        return this.f426a.e(j);
    }

    public final byte g() throws IOException {
        a(1);
        return this.f426a.g();
    }

    public final byte[] g(long j) throws IOException {
        a(j);
        return this.f426a.g(j);
    }

    public final short h() throws IOException {
        a(2);
        return this.f426a.h();
    }

    public final void h(long j) throws IOException {
        if (this.f428c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f426a.f387c == 0 && this.f427b.read(this.f426a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f426a.f387c);
            this.f426a.h(min);
            j -= min;
        }
    }

    public final int i() throws IOException {
        a(4);
        return this.f426a.i();
    }

    public final long j() throws IOException {
        a(8);
        return this.f426a.j();
    }

    public final short k() throws IOException {
        a(2);
        return ab.a(this.f426a.h());
    }

    public final int l() throws IOException {
        a(4);
        return ab.a(this.f426a.i());
    }

    public final long m() throws IOException {
        a(8);
        return ab.a(this.f426a.j());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long n() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.a((long) r0)
            r0 = 0
            r1 = 0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.b((long) r3)
            if (r3 == 0) goto L_0x003f
            c.c r3 = r6.f426a
            long r4 = (long) r1
            byte r3 = r3.c((long) r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0026
        L_0x001f:
            if (r1 != 0) goto L_0x0028
            r4 = 45
            if (r3 == r4) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r2
            goto L_0x0007
        L_0x0028:
            if (r1 != 0) goto L_0x003f
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was %#x"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r4[r0] = r3
            java.lang.String r0 = java.lang.String.format(r2, r4)
            r1.<init>(r0)
            throw r1
        L_0x003f:
            c.c r0 = r6.f426a
            long r0 = r0.n()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.n():long");
    }

    public final long o() throws IOException {
        a(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b((long) i2)) {
                break;
            }
            byte c2 = this.f426a.c((long) i);
            if ((c2 >= 48 && c2 <= 57) || ((c2 >= 97 && c2 <= 102) || (c2 >= 65 && c2 <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(c2)}));
            }
        }
        return this.f426a.o();
    }

    public final f p() throws IOException {
        this.f426a.a(this.f427b);
        return this.f426a.p();
    }

    public final String q() throws IOException {
        this.f426a.a(this.f427b);
        return this.f426a.q();
    }

    @Nullable
    public final String r() throws IOException {
        long a2 = a((byte) 10);
        if (a2 != -1) {
            return this.f426a.f(a2);
        }
        if (this.f426a.f387c != 0) {
            return e(this.f426a.f387c);
        }
        return null;
    }

    public final long read(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f428c) {
            throw new IllegalStateException("closed");
        } else if (this.f426a.f387c == 0 && this.f427b.read(this.f426a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        } else {
            return this.f426a.read(cVar, Math.min(j, this.f426a.f387c));
        }
    }

    public final String s() throws IOException {
        return t();
    }

    public final String t() throws IOException {
        long a2 = a((byte) 10, 0, Long.MAX_VALUE);
        if (a2 != -1) {
            return this.f426a.f(a2);
        }
        c cVar = new c();
        this.f426a.a(cVar, 0, Math.min(32, this.f426a.f387c));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f426a.f387c, Long.MAX_VALUE) + " content=" + cVar.p().hex() + 8230);
    }

    public final z timeout() {
        return this.f427b.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f427b + ")";
    }

    public final int u() throws IOException {
        long j;
        a(1);
        byte c2 = this.f426a.c(0);
        if ((c2 & 224) == 192) {
            j = 2;
        } else if ((c2 & 240) == 224) {
            j = 3;
        } else {
            if ((c2 & 248) == 240) {
                j = 4;
            }
            return this.f426a.u();
        }
        a(j);
        return this.f426a.u();
    }

    public final byte[] v() throws IOException {
        this.f426a.a(this.f427b);
        return this.f426a.v();
    }
}

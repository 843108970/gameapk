package com.b.b;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.nio.charset.Charset;

final class s implements h {

    /* renamed from: a  reason: collision with root package name */
    public final f f876a = new f();

    /* renamed from: b  reason: collision with root package name */
    public final x f877b;

    /* renamed from: c  reason: collision with root package name */
    boolean f878c;

    s(x xVar) {
        if (xVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f877b = xVar;
    }

    private boolean b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f878c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.f876a.f855b < j) {
                if (this.f877b.a(this.f876a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public final long a(byte b2) {
        if (this.f878c) {
            throw new IllegalStateException("closed");
        }
        long j = 0;
        while (true) {
            long a2 = this.f876a.a(b2, j);
            if (a2 != -1) {
                return a2;
            }
            long j2 = this.f876a.f855b;
            if (this.f877b.a(this.f876a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            j = Math.max(j, j2);
        }
    }

    public final long a(f fVar, long j) {
        if (fVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f878c) {
            throw new IllegalStateException("closed");
        } else if (this.f876a.f855b == 0 && this.f877b.a(this.f876a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        } else {
            return this.f876a.a(fVar, Math.min(j, this.f876a.f855b));
        }
    }

    public final y a() {
        return this.f877b.a();
    }

    public final String a(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f876a.a(this.f877b);
        return this.f876a.a(charset);
    }

    public final void a(long j) {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    public final boolean b(i iVar) {
        int g = iVar.g();
        if (this.f878c) {
            throw new IllegalStateException("closed");
        } else if (g < 0 || iVar.g() - 0 < g) {
            return false;
        } else {
            for (int i = 0; i < g; i++) {
                long j = ((long) i) + 0;
                if (!b(j + 1) || this.f876a.b(j) != iVar.a(i + 0)) {
                    return false;
                }
            }
            return true;
        }
    }

    public final f c() {
        return this.f876a;
    }

    public final i c(long j) {
        a(j);
        return this.f876a.c(j);
    }

    public final void close() {
        if (!this.f878c) {
            this.f878c = true;
            this.f877b.close();
            this.f876a.o();
        }
    }

    public final boolean d() {
        if (!this.f878c) {
            return this.f876a.d() && this.f877b.a(this.f876a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public final byte e() {
        a(1);
        return this.f876a.e();
    }

    public final byte[] e(long j) {
        a(j);
        return this.f876a.e(j);
    }

    public final short f() {
        a(2);
        return this.f876a.f();
    }

    public final void f(long j) {
        if (this.f878c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.f876a.f855b == 0 && this.f877b.a(this.f876a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f876a.f855b);
            this.f876a.f(min);
            j -= min;
        }
    }

    public final int g() {
        a(4);
        return this.f876a.g();
    }

    public final short h() {
        a(2);
        return aa.a(this.f876a.f());
    }

    public final int i() {
        a(4);
        return aa.a(this.f876a.g());
    }

    public final long j() {
        a(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b((long) i2)) {
                break;
            }
            byte b2 = this.f876a.b((long) i);
            if ((b2 >= 48 && b2 <= 57) || ((b2 >= 97 && b2 <= 102) || (b2 >= 65 && b2 <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b2)}));
            }
        }
        return this.f876a.j();
    }

    public final String m() {
        long a2 = a((byte) 10);
        if (a2 != -1) {
            return this.f876a.d(a2);
        }
        f fVar = new f();
        this.f876a.a(fVar, 0, Math.min(32, this.f876a.f855b));
        throw new EOFException("\\n not found: size=" + this.f876a.f855b + " content=" + fVar.k().e() + "…");
    }

    public final String toString() {
        return "buffer(" + this.f877b + ")";
    }
}

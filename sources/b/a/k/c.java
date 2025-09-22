package b.a.k;

import c.e;
import c.f;
import com.umeng.commonsdk.proguard.bg;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

final class c {

    /* renamed from: a  reason: collision with root package name */
    final boolean f233a;

    /* renamed from: b  reason: collision with root package name */
    final e f234b;

    /* renamed from: c  reason: collision with root package name */
    final a f235c;
    boolean d;
    int e;
    long f;
    long g;
    boolean h;
    boolean i;
    boolean j;
    final byte[] k = new byte[4];
    final byte[] l = new byte[8192];

    public interface a {
        void a(int i, String str);

        void b(f fVar);

        void f() throws IOException;

        void g() throws IOException;

        void h();
    }

    c(boolean z, e eVar, a aVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        } else if (aVar == null) {
            throw new NullPointerException("frameCallback == null");
        } else {
            this.f233a = z;
            this.f234b = eVar;
            this.f235c = aVar;
        }
    }

    private void a(c.c cVar) throws IOException {
        long j2;
        while (!this.d) {
            if (this.g == this.f) {
                if (!this.h) {
                    e();
                    if (this.e != 0) {
                        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.e));
                    } else if (this.h && this.f == 0) {
                        return;
                    }
                } else {
                    return;
                }
            }
            long j3 = this.f - this.g;
            if (this.j) {
                j2 = (long) this.f234b.a(this.l, 0, (int) Math.min(j3, (long) this.l.length));
                if (j2 == -1) {
                    throw new EOFException();
                }
                b.a(this.l, j2, this.k, this.g);
                cVar.c(this.l, 0, (int) j2);
            } else {
                j2 = this.f234b.read(cVar, j3);
                if (j2 == -1) {
                    throw new EOFException();
                }
            }
            this.g += j2;
        }
        throw new IOException("closed");
    }

    /* JADX INFO: finally extract failed */
    private void b() throws IOException {
        if (this.d) {
            throw new IOException("closed");
        }
        long l_ = this.f234b.timeout().l_();
        this.f234b.timeout().d();
        try {
            byte g2 = this.f234b.g() & 255;
            this.f234b.timeout().a(l_, TimeUnit.NANOSECONDS);
            this.e = g2 & bg.m;
            boolean z = false;
            this.h = (g2 & 128) != 0;
            this.i = (g2 & 8) != 0;
            if (!this.i || this.h) {
                boolean z2 = (g2 & 64) != 0;
                boolean z3 = (g2 & 32) != 0;
                boolean z4 = (g2 & bg.n) != 0;
                if (z2 || z3 || z4) {
                    throw new ProtocolException("Reserved flags are unsupported.");
                }
                byte g3 = this.f234b.g() & 255;
                if ((g3 & 128) != 0) {
                    z = true;
                }
                this.j = z;
                if (this.j == this.f233a) {
                    throw new ProtocolException(this.f233a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                }
                this.f = (long) (g3 & Byte.MAX_VALUE);
                if (this.f == 126) {
                    this.f = ((long) this.f234b.h()) & 65535;
                } else if (this.f == 127) {
                    this.f = this.f234b.j();
                    if (this.f < 0) {
                        throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f) + " > 0x7FFFFFFFFFFFFFFF");
                    }
                }
                this.g = 0;
                if (this.i && this.f > 125) {
                    throw new ProtocolException("Control frame must be less than 125B.");
                } else if (this.j) {
                    this.f234b.b(this.k);
                }
            } else {
                throw new ProtocolException("Control frames must be final.");
            }
        } catch (Throwable th) {
            this.f234b.timeout().a(l_, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void c() throws IOException {
        c.c cVar = new c.c();
        if (this.g < this.f) {
            if (this.f233a) {
                this.f234b.b(cVar, this.f);
            } else {
                while (this.g < this.f) {
                    int a2 = this.f234b.a(this.l, 0, (int) Math.min(this.f - this.g, (long) this.l.length));
                    if (a2 == -1) {
                        throw new EOFException();
                    }
                    long j2 = (long) a2;
                    b.a(this.l, j2, this.k, this.g);
                    cVar.c(this.l, 0, a2);
                    this.g += j2;
                }
            }
        }
        switch (this.e) {
            case 8:
                short s = 1005;
                String str = "";
                long j3 = cVar.f387c;
                if (j3 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j3 != 0) {
                    s = cVar.h();
                    str = cVar.q();
                    String a3 = b.a((int) s);
                    if (a3 != null) {
                        throw new ProtocolException(a3);
                    }
                }
                this.f235c.a(s, str);
                this.d = true;
                return;
            case 9:
                this.f235c.b(cVar.p());
                return;
            case 10:
                a aVar = this.f235c;
                cVar.p();
                aVar.h();
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.e));
        }
    }

    private void d() throws IOException {
        int i2 = this.e;
        if (i2 == 1 || i2 == 2) {
            c.c cVar = new c.c();
            a(cVar);
            if (i2 == 1) {
                cVar.q();
            } else {
                cVar.p();
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i2));
        }
    }

    private void e() throws IOException {
        while (!this.d) {
            b();
            if (this.i) {
                c();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() throws IOException {
        b();
        if (this.i) {
            c();
            return;
        }
        int i2 = this.e;
        if (i2 == 1 || i2 == 2) {
            c.c cVar = new c.c();
            a(cVar);
            if (i2 == 1) {
                cVar.q();
            } else {
                cVar.p();
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i2));
        }
    }
}

package c;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class k implements x {

    /* renamed from: a  reason: collision with root package name */
    private final d f395a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f396b;

    /* renamed from: c  reason: collision with root package name */
    private final g f397c;
    private boolean d;
    private final CRC32 e = new CRC32();

    private k(x xVar) {
        if (xVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f396b = new Deflater(-1, true);
        this.f395a = p.a(xVar);
        this.f397c = new g(this.f395a, this.f396b);
        c a2 = this.f395a.a();
        a2.k(8075);
        a2.l(8);
        a2.l(0);
        a2.i(0);
        a2.l(0);
        a2.l(0);
    }

    private Deflater a() {
        return this.f396b;
    }

    private void b() {
        c a2 = this.f395a.a();
        a2.k(8075);
        a2.l(8);
        a2.l(0);
        a2.i(0);
        a2.l(0);
        a2.l(0);
    }

    private void b(c cVar, long j) {
        u uVar = cVar.f386b;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (uVar.e - uVar.d));
            this.e.update(uVar.f432c, uVar.d, min);
            uVar = uVar.h;
            j -= (long) min;
        }
    }

    private void c() throws IOException {
        this.f395a.h((int) this.e.getValue());
        this.f395a.h((int) this.f396b.getBytesRead());
    }

    public final void a(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j != 0) {
            b(cVar, j);
            this.f397c.a(cVar, j);
        }
    }

    public final void close() throws IOException {
        if (!this.d) {
            Throwable th = null;
            try {
                this.f397c.a();
                this.f395a.h((int) this.e.getValue());
                this.f395a.h((int) this.f396b.getBytesRead());
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f396b.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.f395a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.d = true;
            if (th != null) {
                ab.a(th);
            }
        }
    }

    public final void flush() throws IOException {
        this.f397c.flush();
    }

    public final z timeout() {
        return this.f395a.timeout();
    }
}

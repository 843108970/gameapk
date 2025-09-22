package c;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class g implements x {

    /* renamed from: a  reason: collision with root package name */
    private final d f390a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f391b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f392c;

    g(d dVar, Deflater deflater) {
        if (dVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f390a = dVar;
            this.f391b = deflater;
        }
    }

    private g(x xVar, Deflater deflater) {
        this(p.a(xVar), deflater);
    }

    @IgnoreJRERequirement
    private void a(boolean z) throws IOException {
        u g;
        c a2 = this.f390a.a();
        while (true) {
            g = a2.g(1);
            int deflate = z ? this.f391b.deflate(g.f432c, g.e, 8192 - g.e, 2) : this.f391b.deflate(g.f432c, g.e, 8192 - g.e);
            if (deflate > 0) {
                g.e += deflate;
                a2.f387c += (long) deflate;
                this.f390a.y();
            } else if (this.f391b.needsInput()) {
                break;
            }
        }
        if (g.d == g.e) {
            a2.f386b = g.a();
            v.a(g);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() throws IOException {
        this.f391b.finish();
        a(false);
    }

    public final void a(c cVar, long j) throws IOException {
        ab.a(cVar.f387c, 0, j);
        while (j > 0) {
            u uVar = cVar.f386b;
            int min = (int) Math.min(j, (long) (uVar.e - uVar.d));
            this.f391b.setInput(uVar.f432c, uVar.d, min);
            a(false);
            long j2 = (long) min;
            cVar.f387c -= j2;
            uVar.d += min;
            if (uVar.d == uVar.e) {
                cVar.f386b = uVar.a();
                v.a(uVar);
            }
            j -= j2;
        }
    }

    public final void close() throws IOException {
        if (!this.f392c) {
            Throwable th = null;
            try {
                a();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f391b.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.f390a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.f392c = true;
            if (th != null) {
                ab.a(th);
            }
        }
    }

    public final void flush() throws IOException {
        a(true);
        this.f390a.flush();
    }

    public final z timeout() {
        return this.f390a.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f390a + ")";
    }
}

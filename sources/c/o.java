package c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class o implements y {

    /* renamed from: a  reason: collision with root package name */
    private final e f405a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f406b;

    /* renamed from: c  reason: collision with root package name */
    private int f407c;
    private boolean d;

    o(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f405a = eVar;
            this.f406b = inflater;
        }
    }

    private o(y yVar, Inflater inflater) {
        this(p.a(yVar), inflater);
    }

    private boolean a() throws IOException {
        if (!this.f406b.needsInput()) {
            return false;
        }
        b();
        if (this.f406b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f405a.d()) {
            return true;
        } else {
            u uVar = this.f405a.a().f386b;
            this.f407c = uVar.e - uVar.d;
            this.f406b.setInput(uVar.f432c, uVar.d, this.f407c);
            return false;
        }
    }

    private void b() throws IOException {
        if (this.f407c != 0) {
            int remaining = this.f407c - this.f406b.getRemaining();
            this.f407c -= remaining;
            this.f405a.h((long) remaining);
        }
    }

    public final void close() throws IOException {
        if (!this.d) {
            this.f406b.end();
            this.d = true;
            this.f405a.close();
        }
    }

    public final long read(c cVar, long j) throws IOException {
        boolean z;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            do {
                z = false;
                if (this.f406b.needsInput()) {
                    b();
                    if (this.f406b.getRemaining() != 0) {
                        throw new IllegalStateException("?");
                    } else if (this.f405a.d()) {
                        z = true;
                    } else {
                        u uVar = this.f405a.a().f386b;
                        this.f407c = uVar.e - uVar.d;
                        this.f406b.setInput(uVar.f432c, uVar.d, this.f407c);
                    }
                }
                try {
                    u g = cVar.g(1);
                    int inflate = this.f406b.inflate(g.f432c, g.e, 8192 - g.e);
                    if (inflate > 0) {
                        g.e += inflate;
                        long j2 = (long) inflate;
                        cVar.f387c += j2;
                        return j2;
                    }
                    if (!this.f406b.finished()) {
                        if (this.f406b.needsDictionary()) {
                        }
                    }
                    b();
                    if (g.d != g.e) {
                        return -1;
                    }
                    cVar.f386b = g.a();
                    v.a(g);
                    return -1;
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            } while (!z);
            throw new EOFException("source exhausted prematurely");
        }
    }

    public final z timeout() {
        return this.f405a.timeout();
    }
}

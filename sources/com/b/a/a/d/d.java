package com.b.a.a.d;

import com.b.a.a.c;
import com.b.a.ac;
import com.b.b.f;
import com.b.b.x;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

final class d extends b {
    final /* synthetic */ a d;
    private final ac e;
    private long f = -1;
    private boolean g = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    d(a aVar, ac acVar) {
        super(aVar, (byte) 0);
        this.d = aVar;
        this.e = acVar;
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f629b) {
            throw new IllegalStateException("closed");
        } else if (!this.g) {
            return -1;
        } else {
            if (this.f == 0 || this.f == -1) {
                if (this.f != -1) {
                    this.d.f627c.m();
                }
                try {
                    this.f = this.d.f627c.j();
                    String trim = this.d.f627c.m().trim();
                    if (this.f < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                        throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f + trim + "\"");
                    }
                    if (this.f == 0) {
                        this.g = false;
                        com.b.a.a.c.f.a(this.d.f625a.f(), this.e, this.d.c());
                        a(true);
                    }
                    if (!this.g) {
                        return -1;
                    }
                } catch (NumberFormatException e2) {
                    throw new ProtocolException(e2.getMessage());
                }
            }
            long a2 = this.d.f627c.a(fVar, Math.min(j, this.f));
            if (a2 == -1) {
                a(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.f -= a2;
            return a2;
        }
    }

    public final void close() {
        if (!this.f629b) {
            if (this.g && !c.a((x) this, TimeUnit.MILLISECONDS)) {
                a(false);
            }
            this.f629b = true;
        }
    }
}

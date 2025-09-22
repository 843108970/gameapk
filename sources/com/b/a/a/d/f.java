package com.b.a.a.d;

import com.b.a.a.c;
import com.b.b.x;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

final class f extends b {
    final /* synthetic */ a d;
    private long e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(a aVar, long j) {
        super(aVar, (byte) 0);
        this.d = aVar;
        this.e = j;
        if (this.e == 0) {
            a(true);
        }
    }

    public final long a(com.b.b.f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f629b) {
            throw new IllegalStateException("closed");
        } else if (this.e == 0) {
            return -1;
        } else {
            long a2 = this.d.f627c.a(fVar, Math.min(this.e, j));
            if (a2 == -1) {
                a(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.e -= a2;
            if (this.e == 0) {
                a(true);
            }
            return a2;
        }
    }

    public final void close() {
        if (!this.f629b) {
            if (this.e != 0 && !c.a((x) this, TimeUnit.MILLISECONDS)) {
                a(false);
            }
            this.f629b = true;
        }
    }
}

package com.b.a.a.d;

import com.b.b.f;

final class g extends b {
    final /* synthetic */ a d;
    private boolean e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    g(a aVar) {
        super(aVar, (byte) 0);
        this.d = aVar;
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f629b) {
            throw new IllegalStateException("closed");
        } else if (this.e) {
            return -1;
        } else {
            long a2 = this.d.f627c.a(fVar, j);
            if (a2 != -1) {
                return a2;
            }
            this.e = true;
            a(true);
            return -1;
        }
    }

    public final void close() {
        if (!this.f629b) {
            if (!this.e) {
                a(false);
            }
            this.f629b = true;
        }
    }
}

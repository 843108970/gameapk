package com.b.a.a.d;

import com.b.a.a.c;
import com.b.b.f;
import com.b.b.k;
import com.b.b.w;
import com.b.b.y;
import java.net.ProtocolException;

final class e implements w {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f634a;

    /* renamed from: b  reason: collision with root package name */
    private final k f635b = new k(this.f634a.d.a());

    /* renamed from: c  reason: collision with root package name */
    private boolean f636c;
    private long d;

    e(a aVar, long j) {
        this.f634a = aVar;
        this.d = j;
    }

    public final y a() {
        return this.f635b;
    }

    public final void a_(f fVar, long j) {
        if (this.f636c) {
            throw new IllegalStateException("closed");
        }
        c.a(fVar.b(), j);
        if (j > this.d) {
            throw new ProtocolException("expected " + this.d + " bytes but received " + j);
        }
        this.f634a.d.a_(fVar, j);
        this.d -= j;
    }

    public final void close() {
        if (!this.f636c) {
            this.f636c = true;
            if (this.d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.a(this.f635b);
            this.f634a.e = 3;
        }
    }

    public final void flush() {
        if (!this.f636c) {
            this.f634a.d.flush();
        }
    }
}

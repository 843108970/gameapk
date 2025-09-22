package com.b.b;

import java.io.IOException;

final class c implements x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f849a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f850b;

    c(a aVar, x xVar) {
        this.f850b = aVar;
        this.f849a = xVar;
    }

    public final long a(f fVar, long j) {
        this.f850b.c();
        try {
            long a2 = this.f849a.a(fVar, j);
            this.f850b.a(true);
            return a2;
        } catch (IOException e) {
            throw this.f850b.b(e);
        } catch (Throwable th) {
            this.f850b.a(false);
            throw th;
        }
    }

    public final y a() {
        return this.f850b;
    }

    public final void close() {
        try {
            this.f849a.close();
            this.f850b.a(true);
        } catch (IOException e) {
            throw this.f850b.b(e);
        } catch (Throwable th) {
            this.f850b.a(false);
            throw th;
        }
    }

    public final String toString() {
        return "AsyncTimeout.source(" + this.f849a + ")";
    }
}

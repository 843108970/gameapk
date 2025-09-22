package com.b.b;

import java.io.OutputStream;

final class o implements w {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f868a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ OutputStream f869b;

    o(y yVar, OutputStream outputStream) {
        this.f868a = yVar;
        this.f869b = outputStream;
    }

    public final y a() {
        return this.f868a;
    }

    public final void a_(f fVar, long j) {
        aa.a(fVar.f855b, 0, j);
        while (j > 0) {
            this.f868a.f_();
            t tVar = fVar.f854a;
            int min = (int) Math.min(j, (long) (tVar.f881c - tVar.f880b));
            this.f869b.write(tVar.f879a, tVar.f880b, min);
            tVar.f880b += min;
            long j2 = (long) min;
            long j3 = j - j2;
            fVar.f855b -= j2;
            if (tVar.f880b == tVar.f881c) {
                fVar.f854a = tVar.a();
                u.a(tVar);
            }
            j = j3;
        }
    }

    public final void close() {
        this.f869b.close();
    }

    public final void flush() {
        this.f869b.flush();
    }

    public final String toString() {
        return "sink(" + this.f869b + ")";
    }
}

package com.b.a.a.a;

import com.b.a.a.c;
import com.b.b.f;
import com.b.b.g;
import com.b.b.h;
import com.b.b.x;
import com.b.b.y;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

final class b implements x {

    /* renamed from: a  reason: collision with root package name */
    boolean f568a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h f569b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ c f570c;
    final /* synthetic */ g d;
    final /* synthetic */ a e;

    b(a aVar, h hVar, c cVar, g gVar) {
        this.e = aVar;
        this.f569b = hVar;
        this.f570c = cVar;
        this.d = gVar;
    }

    public final long a(f fVar, long j) {
        try {
            long a2 = this.f569b.a(fVar, j);
            if (a2 == -1) {
                if (!this.f568a) {
                    this.f568a = true;
                    this.d.close();
                }
                return -1;
            }
            fVar.a(this.d.c(), fVar.b() - a2, a2);
            this.d.p();
            return a2;
        } catch (IOException e2) {
            if (!this.f568a) {
                this.f568a = true;
            }
            throw e2;
        }
    }

    public final y a() {
        return this.f569b.a();
    }

    public final void close() {
        if (!this.f568a && !c.a((x) this, TimeUnit.MILLISECONDS)) {
            this.f568a = true;
        }
        this.f569b.close();
    }
}

package com.b.a.a.e;

import com.b.a.a.b;
import java.io.IOException;

final class l extends b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f689a;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f690c;
    final /* synthetic */ j d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    l(j jVar, String str, Object[] objArr, int i, long j) {
        super(str, objArr);
        this.d = jVar;
        this.f689a = i;
        this.f690c = j;
    }

    public final void b() {
        try {
            this.d.p.a(this.f689a, this.f690c);
        } catch (IOException unused) {
        }
    }
}

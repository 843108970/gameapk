package com.b.a.a.e;

import com.b.a.a.b;

final class q extends b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f699a;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ b f700c;
    final /* synthetic */ j d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q(j jVar, String str, Object[] objArr, int i, b bVar) {
        super(str, objArr);
        this.d = jVar;
        this.f699a = i;
        this.f700c = bVar;
    }

    public final void b() {
        this.d.i.c();
        synchronized (this.d) {
            this.d.r.remove(Integer.valueOf(this.f699a));
        }
    }
}

package com.b.a.a.e;

import com.b.a.a.b;
import java.io.IOException;
import java.util.List;

final class n extends b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f693a;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ List f694c;
    final /* synthetic */ j d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    n(j jVar, String str, Object[] objArr, int i, List list) {
        super(str, objArr);
        this.d = jVar;
        this.f693a = i;
        this.f694c = list;
    }

    public final void b() {
        this.d.i.a();
        try {
            this.d.p.a(this.f693a, b.CANCEL);
            synchronized (this.d) {
                this.d.r.remove(Integer.valueOf(this.f693a));
            }
        } catch (IOException unused) {
        }
    }
}

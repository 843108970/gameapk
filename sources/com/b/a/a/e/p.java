package com.b.a.a.e;

import com.b.a.a.b;
import com.b.b.f;
import java.io.IOException;

final class p extends b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f697a;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f f698c;
    final /* synthetic */ int d;
    final /* synthetic */ boolean e;
    final /* synthetic */ j f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p(j jVar, String str, Object[] objArr, int i, f fVar, int i2, boolean z) {
        super(str, objArr);
        this.f = jVar;
        this.f697a = i;
        this.f698c = fVar;
        this.d = i2;
        this.e = z;
    }

    public final void b() {
        try {
            this.f.i.a(this.f698c, this.d);
            this.f.p.a(this.f697a, b.CANCEL);
            synchronized (this.f) {
                this.f.r.remove(Integer.valueOf(this.f697a));
            }
        } catch (IOException unused) {
        }
    }
}

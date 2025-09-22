package com.b.a.a.e;

import com.b.a.a.b;
import java.io.IOException;

final class x extends b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al f709a;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ u f710c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    x(u uVar, String str, Object[] objArr, al alVar) {
        super(str, objArr);
        this.f710c = uVar;
        this.f709a = alVar;
    }

    public final void b() {
        try {
            this.f710c.f705c.p.a(this.f709a);
        } catch (IOException unused) {
        }
    }
}

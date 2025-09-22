package com.b.a.a.e;

import com.b.a.a.b;
import java.io.IOException;

final class k extends b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f687a;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ b f688c;
    final /* synthetic */ j d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k(j jVar, String str, Object[] objArr, int i, b bVar) {
        super(str, objArr);
        this.d = jVar;
        this.f687a = i;
        this.f688c = bVar;
    }

    public final void b() {
        try {
            this.d.b(this.f687a, this.f688c);
        } catch (IOException unused) {
        }
    }
}

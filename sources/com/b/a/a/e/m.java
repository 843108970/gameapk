package com.b.a.a.e;

import com.b.a.a.b;
import java.io.IOException;

final class m extends b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f691a = true;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f692c;
    final /* synthetic */ int d;
    final /* synthetic */ ai e;
    final /* synthetic */ j f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m(j jVar, String str, Object[] objArr, int i, int i2) {
        super(str, objArr);
        this.f = jVar;
        this.f692c = i;
        this.d = i2;
        this.e = null;
    }

    public final void b() {
        try {
            j jVar = this.f;
            boolean z = this.f691a;
            int i = this.f692c;
            int i2 = this.d;
            ai aiVar = this.e;
            synchronized (jVar.p) {
                if (aiVar != null) {
                    aiVar.a();
                }
                jVar.p.a(z, i, i2);
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            throw th;
        }
    }
}

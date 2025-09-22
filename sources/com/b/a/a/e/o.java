package com.b.a.a.e;

import com.b.a.a.b;
import java.io.IOException;
import java.util.List;

final class o extends b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f695a;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ List f696c;
    final /* synthetic */ boolean d;
    final /* synthetic */ j e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    o(j jVar, String str, Object[] objArr, int i, List list, boolean z) {
        super(str, objArr);
        this.e = jVar;
        this.f695a = i;
        this.f696c = list;
        this.d = z;
    }

    public final void b() {
        this.e.i.b();
        try {
            this.e.p.a(this.f695a, b.CANCEL);
            synchronized (this.e) {
                this.e.r.remove(Integer.valueOf(this.f695a));
            }
        } catch (IOException unused) {
        }
    }
}

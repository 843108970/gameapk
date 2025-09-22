package com.b.a.a.e;

import com.b.a.a.b;
import com.b.a.a.g.h;
import java.io.IOException;

final class v extends b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f706a;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ u f707c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    v(u uVar, String str, Object[] objArr, ab abVar) {
        super(str, objArr);
        this.f707c = uVar;
        this.f706a = abVar;
    }

    public final void b() {
        try {
            this.f707c.f705c.f686c.a(this.f706a);
        } catch (IOException e) {
            h b2 = h.b();
            b2.a(4, "Http2Connection.Listener failure for " + this.f707c.f705c.e, (Throwable) e);
            try {
                this.f706a.a(b.PROTOCOL_ERROR);
            } catch (IOException unused) {
            }
        }
    }
}

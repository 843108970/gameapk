package com.b.a.a.e;

import com.b.b.a;
import java.io.IOException;
import java.net.SocketTimeoutException;

final class ae extends a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f646a;

    ae(ab abVar) {
        this.f646a = abVar;
    }

    /* access modifiers changed from: protected */
    public final IOException a(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        this.f646a.b(b.CANCEL);
    }

    public final void b() {
        if (a_()) {
            throw a((IOException) null);
        }
    }
}

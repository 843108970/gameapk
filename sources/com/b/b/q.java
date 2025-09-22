package com.b.b;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

final class q extends a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Socket f872a;

    q(Socket socket) {
        this.f872a = socket;
    }

    /* access modifiers changed from: protected */
    public final IOException a(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.AssertionError} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Exception} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r5 = this;
            java.net.Socket r0 = r5.f872a     // Catch:{ Exception -> 0x0026, AssertionError -> 0x0006 }
            r0.close()     // Catch:{ Exception -> 0x0026, AssertionError -> 0x0006 }
            return
        L_0x0006:
            r0 = move-exception
            boolean r1 = com.b.b.n.a((java.lang.AssertionError) r0)
            if (r1 == 0) goto L_0x0025
            java.util.logging.Logger r1 = com.b.b.n.f867a
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to close timed out socket "
            r3.<init>(r4)
        L_0x0018:
            java.net.Socket r4 = r5.f872a
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.log(r2, r3, r0)
            return
        L_0x0025:
            throw r0
        L_0x0026:
            r0 = move-exception
            java.util.logging.Logger r1 = com.b.b.n.f867a
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to close timed out socket "
            r3.<init>(r4)
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.b.q.a():void");
    }
}

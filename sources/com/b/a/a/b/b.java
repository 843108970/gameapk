package com.b.a.a.b;

import com.b.a.a.a;
import com.b.a.p;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<p> f587a;

    /* renamed from: b  reason: collision with root package name */
    private int f588b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f589c;
    private boolean d;

    public b(List<p> list) {
        this.f587a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.f588b; i < this.f587a.size(); i++) {
            if (this.f587a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public final p a(SSLSocket sSLSocket) {
        p pVar;
        int i = this.f588b;
        int size = this.f587a.size();
        while (true) {
            if (i >= size) {
                pVar = null;
                break;
            }
            pVar = this.f587a.get(i);
            if (pVar.a(sSLSocket)) {
                this.f588b = i + 1;
                break;
            }
            i++;
        }
        if (pVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.f587a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.f589c = b(sSLSocket);
        a.f566a.a(pVar, sSLSocket, this.d);
        return pVar;
    }

    public final boolean a(IOException iOException) {
        this.d = true;
        if (!this.f589c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((!z || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return z || (iOException instanceof SSLProtocolException);
        }
        return false;
    }
}

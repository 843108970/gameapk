package b.a.c;

import b.a.a;
import b.l;
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
    final List<l> f57a;

    /* renamed from: b  reason: collision with root package name */
    int f58b = 0;

    /* renamed from: c  reason: collision with root package name */
    boolean f59c;
    boolean d;

    public b(List<l> list) {
        this.f57a = list;
    }

    private boolean a(IOException iOException) {
        this.d = true;
        if (!this.f59c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((!z || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return z || (iOException instanceof SSLProtocolException);
        }
        return false;
    }

    private l b(SSLSocket sSLSocket) throws IOException {
        l lVar;
        int i = this.f58b;
        int size = this.f57a.size();
        while (true) {
            if (i >= size) {
                lVar = null;
                break;
            }
            lVar = this.f57a.get(i);
            if (lVar.a(sSLSocket)) {
                this.f58b = i + 1;
                break;
            }
            i++;
        }
        if (lVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.f57a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.f59c = a(sSLSocket);
        a.f11a.a(lVar, sSLSocket, this.d);
        return lVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(SSLSocket sSLSocket) {
        for (int i = this.f58b; i < this.f57a.size(); i++) {
            if (this.f57a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}

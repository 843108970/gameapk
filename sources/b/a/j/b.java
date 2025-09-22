package b.a.j;

import b.a.h.e;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

public abstract class b {
    private static b a(X509TrustManager x509TrustManager) {
        return e.b().a(x509TrustManager);
    }

    private static b a(X509Certificate... x509CertificateArr) {
        return new a(e.a(x509CertificateArr));
    }

    public abstract List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}

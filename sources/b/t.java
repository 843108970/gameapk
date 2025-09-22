package b;

import b.a.c;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    final ah f347a;

    /* renamed from: b  reason: collision with root package name */
    public final i f348b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f349c;
    final List<Certificate> d;

    t(ah ahVar, i iVar, List<Certificate> list, List<Certificate> list2) {
        this.f347a = ahVar;
        this.f348b = iVar;
        this.f349c = list;
        this.d = list2;
    }

    private ah a() {
        return this.f347a;
    }

    private static t a(ah ahVar, i iVar, List<Certificate> list, List<Certificate> list2) {
        if (ahVar == null) {
            throw new NullPointerException("tlsVersion == null");
        } else if (iVar != null) {
            return new t(ahVar, iVar, c.a(list), c.a(list2));
        } else {
            throw new NullPointerException("cipherSuite == null");
        }
    }

    public static t a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        i a2 = i.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        ah forJavaName = ah.forJavaName(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        List a3 = certificateArr != null ? c.a((T[]) certificateArr) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new t(forJavaName, a2, a3, localCertificates != null ? c.a((T[]) localCertificates) : Collections.emptyList());
    }

    private i b() {
        return this.f348b;
    }

    private List<Certificate> c() {
        return this.f349c;
    }

    @Nullable
    private Principal d() {
        if (!this.f349c.isEmpty()) {
            return ((X509Certificate) this.f349c.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    private List<Certificate> e() {
        return this.d;
    }

    @Nullable
    private Principal f() {
        if (!this.d.isEmpty()) {
            return ((X509Certificate) this.d.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f347a.equals(tVar.f347a) && this.f348b.equals(tVar.f348b) && this.f349c.equals(tVar.f349c) && this.d.equals(tVar.d);
    }

    public final int hashCode() {
        return ((((((this.f347a.hashCode() + 527) * 31) + this.f348b.hashCode()) * 31) + this.f349c.hashCode()) * 31) + this.d.hashCode();
    }
}

package b.a.j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public abstract class e {

    static final class a extends e {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f212a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f213b;

        a(X509TrustManager x509TrustManager, Method method) {
            this.f213b = method;
            this.f212a = x509TrustManager;
        }

        public final X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f213b.invoke(this.f212a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f212a.equals(aVar.f212a) && this.f213b.equals(aVar.f213b);
        }

        public final int hashCode() {
            return this.f212a.hashCode() + (this.f213b.hashCode() * 31);
        }
    }

    static final class b extends e {

        /* renamed from: a  reason: collision with root package name */
        private final Map<X500Principal, Set<X509Certificate>> f214a = new LinkedHashMap();

        b(X509Certificate... x509CertificateArr) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                Set set = this.f214a.get(subjectX500Principal);
                if (set == null) {
                    set = new LinkedHashSet(1);
                    this.f214a.put(subjectX500Principal, set);
                }
                set.add(x509Certificate);
            }
        }

        public final X509Certificate a(X509Certificate x509Certificate) {
            Set<X509Certificate> set = this.f214a.get(x509Certificate.getIssuerX500Principal());
            if (set == null) {
                return null;
            }
            for (X509Certificate x509Certificate2 : set) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof b) && ((b) obj).f214a.equals(this.f214a);
        }

        public final int hashCode() {
            return this.f214a.hashCode();
        }
    }

    public static e a(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new a(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return a(x509TrustManager.getAcceptedIssuers());
        }
    }

    public static e a(X509Certificate... x509CertificateArr) {
        return new b(x509CertificateArr);
    }

    public abstract X509Certificate a(X509Certificate x509Certificate);
}

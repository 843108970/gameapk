package mobi.oneway.export.d;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

class d {
    d() {
    }

    public static SSLSocketFactory a() {
        TrustManager[] trustManagerArr = {new X509TrustManager() {
            public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public final X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }};
        try {
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
            return new c(instance.getSocketFactory());
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static HostnameVerifier b() {
        return new HostnameVerifier() {
            public final boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        };
    }
}

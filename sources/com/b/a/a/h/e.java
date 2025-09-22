package com.b.a.a.h;

import java.lang.reflect.Method;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public abstract class e {
    public static e a(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new f(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return new g(x509TrustManager.getAcceptedIssuers());
        }
    }

    public abstract X509Certificate a(X509Certificate x509Certificate);
}

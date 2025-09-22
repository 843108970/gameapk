package com.b.a.a.h;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class f extends e {

    /* renamed from: a  reason: collision with root package name */
    private final X509TrustManager f744a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f745b;

    f(X509TrustManager x509TrustManager, Method method) {
        this.f745b = method;
        this.f744a = x509TrustManager;
    }

    public final X509Certificate a(X509Certificate x509Certificate) {
        try {
            TrustAnchor trustAnchor = (TrustAnchor) this.f745b.invoke(this.f744a, new Object[]{x509Certificate});
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
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f744a.equals(fVar.f744a) && this.f745b.equals(fVar.f745b);
    }

    public final int hashCode() {
        return this.f744a.hashCode() + (this.f745b.hashCode() * 31);
    }
}

package com.b.a.a.g;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

final class b extends com.b.a.a.h.b {

    /* renamed from: a  reason: collision with root package name */
    private final Object f721a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f722b;

    b(Object obj, Method method) {
        this.f721a = obj;
        this.f722b = method;
    }

    public final List<Certificate> a(List<Certificate> list, String str) {
        try {
            return (List) this.f722b.invoke(this.f721a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
        } catch (InvocationTargetException e) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(e);
            throw sSLPeerUnverifiedException;
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    public final boolean equals(Object obj) {
        return obj instanceof b;
    }

    public final int hashCode() {
        return 0;
    }
}

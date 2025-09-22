package com.b.a;

import com.b.a.a.c;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    private final ax f841a;

    /* renamed from: b  reason: collision with root package name */
    private final l f842b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Certificate> f843c;
    private final List<Certificate> d;

    private z(ax axVar, l lVar, List<Certificate> list, List<Certificate> list2) {
        this.f841a = axVar;
        this.f842b = lVar;
        this.f843c = list;
        this.d = list2;
    }

    public static z a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        l a2 = l.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        ax a3 = ax.a(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        List a4 = certificateArr != null ? c.a((T[]) certificateArr) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new z(a3, a2, a4, localCertificates != null ? c.a((T[]) localCertificates) : Collections.emptyList());
    }

    public final l a() {
        return this.f842b;
    }

    public final List<Certificate> b() {
        return this.f843c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return c.a((Object) this.f842b, (Object) zVar.f842b) && this.f842b.equals(zVar.f842b) && this.f843c.equals(zVar.f843c) && this.d.equals(zVar.d);
    }

    public final int hashCode() {
        return (((((((this.f841a != null ? this.f841a.hashCode() : 0) + 527) * 31) + this.f842b.hashCode()) * 31) + this.f843c.hashCode()) * 31) + this.d.hashCode();
    }
}

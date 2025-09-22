package com.b.a;

import com.b.a.a.c;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final ac f563a;

    /* renamed from: b  reason: collision with root package name */
    final v f564b;

    /* renamed from: c  reason: collision with root package name */
    final SocketFactory f565c;
    final b d;
    final List<al> e;
    final List<p> f;
    final ProxySelector g;
    final Proxy h;
    final SSLSocketFactory i;
    final HostnameVerifier j;
    final i k;

    public a(String str, int i2, v vVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, i iVar, b bVar, Proxy proxy, List<al> list, List<p> list2, ProxySelector proxySelector) {
        String str2;
        ad adVar = new ad();
        String str3 = sSLSocketFactory != null ? "https" : "http";
        if (str3.equalsIgnoreCase("http")) {
            str2 = "http";
        } else if (str3.equalsIgnoreCase("https")) {
            str2 = "https";
        } else {
            throw new IllegalArgumentException("unexpected scheme: " + str3);
        }
        adVar.f752a = str2;
        ad a2 = adVar.a(str);
        if (i2 <= 0 || i2 > 65535) {
            throw new IllegalArgumentException("unexpected port: " + i2);
        }
        a2.e = i2;
        this.f563a = a2.b();
        if (vVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.f564b = vVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f565c = socketFactory;
        if (bVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.d = bVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.e = c.a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f = c.a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = iVar;
    }

    public final ac a() {
        return this.f563a;
    }

    public final v b() {
        return this.f564b;
    }

    public final SocketFactory c() {
        return this.f565c;
    }

    public final b d() {
        return this.d;
    }

    public final List<al> e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f563a.equals(aVar.f563a) && this.f564b.equals(aVar.f564b) && this.d.equals(aVar.d) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && c.a((Object) this.h, (Object) aVar.h) && c.a((Object) this.i, (Object) aVar.i) && c.a((Object) this.j, (Object) aVar.j) && c.a((Object) this.k, (Object) aVar.k);
        }
    }

    public final List<p> f() {
        return this.f;
    }

    public final ProxySelector g() {
        return this.g;
    }

    public final Proxy h() {
        return this.h;
    }

    public final int hashCode() {
        int i2 = 0;
        int hashCode = (((((((((((((((((this.f563a.hashCode() + 527) * 31) + this.f564b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + (this.h != null ? this.h.hashCode() : 0)) * 31) + (this.i != null ? this.i.hashCode() : 0)) * 31) + (this.j != null ? this.j.hashCode() : 0)) * 31;
        if (this.k != null) {
            i2 = this.k.hashCode();
        }
        return hashCode + i2;
    }

    public final SSLSocketFactory i() {
        return this.i;
    }

    public final HostnameVerifier j() {
        return this.j;
    }

    public final i k() {
        return this.k;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Address{");
        sb.append(this.f563a.f750b);
        sb.append(":");
        sb.append(this.f563a.f751c);
        if (this.h != null) {
            sb.append(", proxy=");
            obj = this.h;
        } else {
            sb.append(", proxySelector=");
            obj = this.g;
        }
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}

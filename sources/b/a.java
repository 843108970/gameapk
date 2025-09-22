package b;

import b.a.c;
import b.v;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final v f8a;

    /* renamed from: b  reason: collision with root package name */
    public final q f9b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f10c;
    public final b d;
    public final List<aa> e;
    public final List<l> f;
    public final ProxySelector g;
    @Nullable
    public final Proxy h;
    @Nullable
    public final SSLSocketFactory i;
    @Nullable
    public final HostnameVerifier j;
    @Nullable
    public final g k;

    public a(String str, int i2, q qVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable g gVar, b bVar, @Nullable Proxy proxy, List<aa> list, List<l> list2, ProxySelector proxySelector) {
        String str2;
        v.a aVar = new v.a();
        String str3 = sSLSocketFactory != null ? "https" : "http";
        if (str3.equalsIgnoreCase("http")) {
            str2 = "http";
        } else if (str3.equalsIgnoreCase("https")) {
            str2 = "https";
        } else {
            throw new IllegalArgumentException("unexpected scheme: " + str3);
        }
        aVar.f356a = str2;
        if (str == null) {
            throw new NullPointerException("host == null");
        }
        String a2 = v.a.a(str, 0, str.length());
        if (a2 == null) {
            throw new IllegalArgumentException("unexpected host: " + str);
        }
        aVar.d = a2;
        if (i2 <= 0 || i2 > 65535) {
            throw new IllegalArgumentException("unexpected port: " + i2);
        }
        aVar.e = i2;
        this.f8a = aVar.b();
        if (qVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.f9b = qVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f10c = socketFactory;
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
        this.k = gVar;
    }

    private v a() {
        return this.f8a;
    }

    private q b() {
        return this.f9b;
    }

    private SocketFactory c() {
        return this.f10c;
    }

    private b d() {
        return this.d;
    }

    private List<aa> e() {
        return this.e;
    }

    private List<l> f() {
        return this.f;
    }

    private ProxySelector g() {
        return this.g;
    }

    @Nullable
    private Proxy h() {
        return this.h;
    }

    @Nullable
    private SSLSocketFactory i() {
        return this.i;
    }

    @Nullable
    private HostnameVerifier j() {
        return this.j;
    }

    @Nullable
    private g k() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(a aVar) {
        return this.f9b.equals(aVar.f9b) && this.d.equals(aVar.d) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && c.a((Object) this.h, (Object) aVar.h) && c.a((Object) this.i, (Object) aVar.i) && c.a((Object) this.j, (Object) aVar.j) && c.a((Object) this.k, (Object) aVar.k) && this.f8a.m == aVar.f8a.m;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8a.equals(aVar.f8a) && a(aVar);
    }

    public final int hashCode() {
        int i2 = 0;
        int hashCode = (((((((((((((((((this.f8a.hashCode() + 527) * 31) + this.f9b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + (this.h != null ? this.h.hashCode() : 0)) * 31) + (this.i != null ? this.i.hashCode() : 0)) * 31) + (this.j != null ? this.j.hashCode() : 0)) * 31;
        if (this.k != null) {
            i2 = this.k.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Address{");
        sb.append(this.f8a.l);
        sb.append(":");
        sb.append(this.f8a.m);
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

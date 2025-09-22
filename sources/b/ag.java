package b;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

public final class ag {

    /* renamed from: a  reason: collision with root package name */
    public final a f272a;

    /* renamed from: b  reason: collision with root package name */
    public final Proxy f273b;

    /* renamed from: c  reason: collision with root package name */
    public final InetSocketAddress f274c;

    public ag(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.f272a = aVar;
            this.f273b = proxy;
            this.f274c = inetSocketAddress;
        }
    }

    private a a() {
        return this.f272a;
    }

    private Proxy b() {
        return this.f273b;
    }

    private InetSocketAddress c() {
        return this.f274c;
    }

    private boolean d() {
        return this.f272a.i != null && this.f273b.type() == Proxy.Type.HTTP;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ag)) {
            return false;
        }
        ag agVar = (ag) obj;
        return agVar.f272a.equals(this.f272a) && agVar.f273b.equals(this.f273b) && agVar.f274c.equals(this.f274c);
    }

    public final int hashCode() {
        return ((((this.f272a.hashCode() + 527) * 31) + this.f273b.hashCode()) * 31) + this.f274c.hashCode();
    }

    public final String toString() {
        return "Route{" + this.f274c + "}";
    }
}

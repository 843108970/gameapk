package com.b.a;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class aw {

    /* renamed from: a  reason: collision with root package name */
    final a f793a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f794b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f795c;

    public aw(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.f793a = aVar;
            this.f794b = proxy;
            this.f795c = inetSocketAddress;
        }
    }

    public final a a() {
        return this.f793a;
    }

    public final Proxy b() {
        return this.f794b;
    }

    public final InetSocketAddress c() {
        return this.f795c;
    }

    public final boolean d() {
        return this.f793a.i != null && this.f794b.type() == Proxy.Type.HTTP;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof aw) {
            aw awVar = (aw) obj;
            return this.f793a.equals(awVar.f793a) && this.f794b.equals(awVar.f794b) && this.f795c.equals(awVar.f795c);
        }
    }

    public final int hashCode() {
        return ((((this.f793a.hashCode() + 527) * 31) + this.f794b.hashCode()) * 31) + this.f795c.hashCode();
    }

    public final String toString() {
        return "Route{" + this.f795c + "}";
    }
}

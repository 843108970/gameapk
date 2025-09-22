package com.b.a.a.b;

import com.b.a.a;
import com.b.a.a.c;
import com.b.a.ac;
import com.b.a.aw;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final a f596a;

    /* renamed from: b  reason: collision with root package name */
    private final d f597b;

    /* renamed from: c  reason: collision with root package name */
    private Proxy f598c;
    private InetSocketAddress d;
    private List<Proxy> e = Collections.emptyList();
    private int f;
    private List<InetSocketAddress> g = Collections.emptyList();
    private int h;
    private final List<aw> i = new ArrayList();

    public f(a aVar, d dVar) {
        List<Proxy> list;
        this.f596a = aVar;
        this.f597b = dVar;
        ac a2 = aVar.a();
        Proxy h2 = aVar.h();
        if (h2 != null) {
            list = Collections.singletonList(h2);
        } else {
            List<Proxy> select = this.f596a.g().select(a2.a());
            if (select == null || select.isEmpty()) {
                list = c.a((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = c.a(select);
            }
        }
        this.e = list;
        this.f = 0;
    }

    private void a(Proxy proxy) {
        String str;
        int i2;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f596a.a().f();
            i2 = this.f596a.a().g();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            InetAddress address2 = inetSocketAddress.getAddress();
            str = address2 == null ? inetSocketAddress.getHostName() : address2.getHostAddress();
            i2 = inetSocketAddress.getPort();
        }
        if (i2 <= 0 || i2 > 65535) {
            throw new SocketException("No route to " + str + ":" + i2 + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(str, i2));
        } else {
            List<InetAddress> a2 = this.f596a.b().a(str);
            int size = a2.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.g.add(new InetSocketAddress(a2.get(i3), i2));
            }
        }
        this.h = 0;
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private boolean d() {
        return this.h < this.g.size();
    }

    private boolean e() {
        return !this.i.isEmpty();
    }

    public final void a(aw awVar, IOException iOException) {
        if (!(awVar.b().type() == Proxy.Type.DIRECT || this.f596a.g() == null)) {
            this.f596a.g().connectFailed(this.f596a.a().a(), awVar.b().address(), iOException);
        }
        this.f597b.a(awVar);
    }

    public final boolean a() {
        return d() || c() || e();
    }

    public final aw b() {
        while (true) {
            if (!d()) {
                if (!c()) {
                    if (e()) {
                        return this.i.remove(0);
                    }
                    throw new NoSuchElementException();
                } else if (!c()) {
                    throw new SocketException("No route to " + this.f596a.a().f() + "; exhausted proxy configurations: " + this.e);
                } else {
                    List<Proxy> list = this.e;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    Proxy proxy = list.get(i2);
                    a(proxy);
                    this.f598c = proxy;
                }
            }
            if (!d()) {
                throw new SocketException("No route to " + this.f596a.a().f() + "; exhausted inet socket addresses: " + this.g);
            }
            List<InetSocketAddress> list2 = this.g;
            int i3 = this.h;
            this.h = i3 + 1;
            this.d = list2.get(i3);
            aw awVar = new aw(this.f596a, this.f598c, this.d);
            if (!this.f597b.c(awVar)) {
                return awVar;
            }
            this.i.add(awVar);
        }
    }
}

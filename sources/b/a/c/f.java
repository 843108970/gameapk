package b.a.c;

import b.a;
import b.a.c;
import b.ag;
import b.v;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    final a f66a;

    /* renamed from: b  reason: collision with root package name */
    final d f67b;

    /* renamed from: c  reason: collision with root package name */
    private Proxy f68c;
    private InetSocketAddress d;
    private List<Proxy> e = Collections.emptyList();
    private int f;
    private List<InetSocketAddress> g = Collections.emptyList();
    private int h;
    private final List<ag> i = new ArrayList();

    public f(a aVar, d dVar) {
        List<Proxy> list;
        this.f66a = aVar;
        this.f67b = dVar;
        v vVar = aVar.f8a;
        Proxy proxy = aVar.h;
        if (proxy != null) {
            list = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f66a.g.select(vVar.a());
            if (select == null || select.isEmpty()) {
                list = c.a((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = c.a(select);
            }
        }
        this.e = list;
        this.f = 0;
    }

    private static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void a(ag agVar, IOException iOException) {
        if (!(agVar.f273b.type() == Proxy.Type.DIRECT || this.f66a.g == null)) {
            this.f66a.g.connectFailed(this.f66a.f8a.a(), agVar.f273b.address(), iOException);
        }
        this.f67b.a(agVar);
    }

    private void a(v vVar, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            list = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f66a.g.select(vVar.a());
            if (select == null || select.isEmpty()) {
                list = c.a((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = c.a(select);
            }
        }
        this.e = list;
        this.f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String str;
        int i2;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f66a.f8a.l;
            i2 = this.f66a.f8a.m;
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
            List<InetAddress> a2 = this.f66a.f9b.a(str);
            if (a2.isEmpty()) {
                throw new UnknownHostException(this.f66a.f9b + " returned no addresses for " + str);
            }
            int size = a2.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.g.add(new InetSocketAddress(a2.get(i3), i2));
            }
        }
        this.h = 0;
    }

    private boolean e() {
        return c() || b() || d();
    }

    private Proxy f() throws IOException {
        if (!b()) {
            throw new SocketException("No route to " + this.f66a.f8a.l + "; exhausted proxy configurations: " + this.e);
        }
        List<Proxy> list = this.e;
        int i2 = this.f;
        this.f = i2 + 1;
        Proxy proxy = list.get(i2);
        a(proxy);
        return proxy;
    }

    private InetSocketAddress g() throws IOException {
        if (!c()) {
            throw new SocketException("No route to " + this.f66a.f8a.l + "; exhausted inet socket addresses: " + this.g);
        }
        List<InetSocketAddress> list = this.g;
        int i2 = this.h;
        this.h = i2 + 1;
        return list.get(i2);
    }

    private ag h() {
        return this.i.remove(0);
    }

    public final ag a() throws IOException {
        while (true) {
            if (!c()) {
                if (!b()) {
                    if (d()) {
                        return this.i.remove(0);
                    }
                    throw new NoSuchElementException();
                } else if (!b()) {
                    throw new SocketException("No route to " + this.f66a.f8a.l + "; exhausted proxy configurations: " + this.e);
                } else {
                    List<Proxy> list = this.e;
                    int i2 = this.f;
                    this.f = i2 + 1;
                    Proxy proxy = list.get(i2);
                    a(proxy);
                    this.f68c = proxy;
                }
            }
            if (!c()) {
                throw new SocketException("No route to " + this.f66a.f8a.l + "; exhausted inet socket addresses: " + this.g);
            }
            List<InetSocketAddress> list2 = this.g;
            int i3 = this.h;
            this.h = i3 + 1;
            this.d = list2.get(i3);
            ag agVar = new ag(this.f66a, this.f68c, this.d);
            if (!this.f67b.c(agVar)) {
                return agVar;
            }
            this.i.add(agVar);
        }
    }

    public final boolean b() {
        return this.f < this.e.size();
    }

    public final boolean c() {
        return this.h < this.g.size();
    }

    public final boolean d() {
        return !this.i.isEmpty();
    }
}

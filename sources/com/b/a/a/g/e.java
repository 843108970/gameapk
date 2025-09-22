package com.b.a.a.g;

import com.b.a.al;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

final class e extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Method f728a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f729b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f730c;
    private final Class<?> d;
    private final Class<?> e;

    private e(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f728a = method;
        this.f729b = method2;
        this.f730c = method3;
        this.d = cls;
        this.e = cls2;
    }

    public static h a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            return new e(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    public final String a(SSLSocket sSLSocket) {
        try {
            f fVar = (f) Proxy.getInvocationHandler(this.f729b.invoke((Object) null, new Object[]{sSLSocket}));
            if (!fVar.f731a && fVar.f732b == null) {
                h.b().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (fVar.f731a) {
                return null;
            } else {
                return fVar.f732b;
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    public final void a(SSLSocket sSLSocket, String str, List<al> list) {
        List<String> a2 = a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.d, this.e}, new f(a2));
            this.f728a.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void b(SSLSocket sSLSocket) {
        try {
            this.f730c.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }
}

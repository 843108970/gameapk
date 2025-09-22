package b.a.h;

import b.aa;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

final class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private final Method f191a;

    /* renamed from: b  reason: collision with root package name */
    private final Method f192b;
    private final Method f;
    private final Class<?> g;
    private final Class<?> h;

    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        boolean f193a;

        /* renamed from: b  reason: collision with root package name */
        String f194b;

        /* renamed from: c  reason: collision with root package name */
        private final List<String> f195c;

        a(List<String> list) {
            this.f195c = list;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = b.a.c.f52b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f193a = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f195c;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            obj2 = this.f195c.get(0);
                            break;
                        } else if (this.f195c.contains(list.get(i))) {
                            obj2 = list.get(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                    String str = (String) obj2;
                    this.f194b = str;
                    return str;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f194b = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    private c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f191a = method;
        this.f192b = method2;
        this.f = method3;
        this.g = cls;
        this.h = cls2;
    }

    public static e a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            return new c(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    public final String a(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f192b.invoke((Object) null, new Object[]{sSLSocket}));
            if (!aVar.f193a && aVar.f194b == null) {
                e.f200c.a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (aVar.f193a) {
                return null;
            } else {
                return aVar.f194b;
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    public final void a(SSLSocket sSLSocket, String str, List<aa> list) {
        List<String> a2 = a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.g, this.h}, new a(a2));
            this.f191a.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError(e);
        }
    }

    public final void b(SSLSocket sSLSocket) {
        try {
            this.f.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }
}

package b.a.h;

import android.util.Log;
import b.a.c;
import b.aa;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private static final int f182a = 4000;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f183b;
    private final d<Socket> f;
    private final d<Socket> g;
    private final d<Socket> h;
    private final d<Socket> i;
    private final b j = b.a();

    /* renamed from: b.a.h.a$a  reason: collision with other inner class name */
    static final class C0001a extends b.a.j.b {

        /* renamed from: a  reason: collision with root package name */
        private final Object f184a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f185b;

        C0001a(Object obj, Method method) {
            this.f184a = obj;
            this.f185b = method;
        }

        public final List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f185b.invoke(this.f184a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public final boolean equals(Object obj) {
            return obj instanceof C0001a;
        }

        public final int hashCode() {
            return 0;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Method f186a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f187b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f188c;

        private b(Method method, Method method2, Method method3) {
            this.f186a = method;
            this.f187b = method2;
            this.f188c = method3;
        }

        static b a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new b(method3, method, method2);
        }

        /* access modifiers changed from: package-private */
        public final Object a(String str) {
            if (this.f186a != null) {
                try {
                    Object invoke = this.f186a.invoke((Object) null, new Object[0]);
                    this.f187b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f188c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    private a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.f183b = cls;
        this.f = dVar;
        this.g = dVar2;
        this.h = dVar3;
        this.i = dVar4;
    }

    public static e a() {
        Class<?> cls;
        d dVar;
        d dVar2;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls2 = cls;
        d dVar3 = new d((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        d dVar4 = new d((Class<?>) null, "setHostname", String.class);
        try {
            Class.forName("android.net.Network");
            dVar2 = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            try {
                dVar = new d((Class<?>) null, "setAlpnProtocols", byte[].class);
            } catch (ClassNotFoundException unused3) {
                dVar = null;
                return new a(cls2, dVar3, dVar4, dVar2, dVar);
            }
        } catch (ClassNotFoundException unused4) {
            dVar2 = null;
            dVar = null;
            return new a(cls2, dVar3, dVar4, dVar2, dVar);
        }
        return new a(cls2, dVar3, dVar4, dVar2, dVar);
    }

    public final b.a.j.b a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0001a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    public final Object a(String str) {
        return this.j.a(str);
    }

    public final String a(SSLSocket sSLSocket) {
        byte[] bArr;
        if (this.h == null || !this.h.a(sSLSocket) || (bArr = (byte[]) this.h.b(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, c.e);
    }

    public final X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        Object a2 = a((Object) sSLSocketFactory, this.f183b, "sslParameters");
        if (a2 == null) {
            try {
                a2 = a((Object) sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.a(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) a((Object) a2, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) a((Object) a2, X509TrustManager.class, "trustManager");
    }

    public final void a(int i2, String str, Throwable th) {
        int min;
        int i3 = 5;
        if (i2 != 5) {
            i3 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i4 = 0;
        int length = str.length();
        while (i4 < length) {
            int indexOf = str.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + 4000);
                Log.println(i3, "OkHttp", str.substring(i4, min));
                if (min >= indexOf) {
                    break;
                }
                i4 = min;
            }
            i4 = min + 1;
        }
    }

    public final void a(String str, Object obj) {
        if (!this.j.a(obj)) {
            a(5, str, (Throwable) null);
        }
    }

    public final void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (AssertionError e) {
            if (c.a(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public final void a(SSLSocket sSLSocket, String str, List<aa> list) {
        if (str != null) {
            this.f.a(sSLSocket, true);
            this.g.a(sSLSocket, str);
        }
        if (this.i != null && this.i.a(sSLSocket)) {
            Object[] objArr = new Object[1];
            c.c cVar = new c.c();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                aa aaVar = list.get(i2);
                if (aaVar != aa.HTTP_1_0) {
                    cVar.l(aaVar.toString().length());
                    cVar.b(aaVar.toString());
                }
            }
            objArr[0] = cVar.v();
            this.i.b(sSLSocket, objArr);
        }
    }

    public final boolean b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(invoke, new Object[]{str})).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            throw new AssertionError();
        }
    }
}

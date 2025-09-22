package com.b.a.a.g;

import android.util.Log;
import com.b.a.a.c;
import com.b.a.a.h.b;
import com.b.a.al;
import com.b.b.f;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f718a;

    /* renamed from: b  reason: collision with root package name */
    private final g<Socket> f719b;

    /* renamed from: c  reason: collision with root package name */
    private final g<Socket> f720c;
    private final g<Socket> d;
    private final g<Socket> e;
    private final c f = c.a();

    private a(Class<?> cls, g<Socket> gVar, g<Socket> gVar2, g<Socket> gVar3, g<Socket> gVar4) {
        this.f718a = cls;
        this.f719b = gVar;
        this.f720c = gVar2;
        this.d = gVar3;
        this.e = gVar4;
    }

    public static h a() {
        Class<?> cls;
        g gVar;
        g gVar2;
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
        g gVar3 = new g((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        g gVar4 = new g((Class<?>) null, "setHostname", String.class);
        try {
            Class.forName("android.net.Network");
            gVar2 = new g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            try {
                gVar = new g((Class<?>) null, "setAlpnProtocols", byte[].class);
            } catch (ClassNotFoundException unused3) {
                gVar = null;
                return new a(cls2, gVar3, gVar4, gVar2, gVar);
            }
        } catch (ClassNotFoundException unused4) {
            gVar2 = null;
            gVar = null;
            return new a(cls2, gVar3, gVar4, gVar2, gVar);
        }
        return new a(cls2, gVar3, gVar4, gVar2, gVar);
    }

    public final b a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new b(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    public final Object a(String str) {
        return this.f.a(str);
    }

    public final String a(SSLSocket sSLSocket) {
        byte[] bArr;
        if (this.d == null || !this.d.a(sSLSocket) || (bArr = (byte[]) this.d.b(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, c.e);
    }

    public final void a(int i, String str, Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + com.cyjh.elfin.d.b.f1863c);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    public final void a(String str, Object obj) {
        if (!this.f.a(obj)) {
            a(5, str, (Throwable) null);
        }
    }

    public final void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e2) {
            if (c.a(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e3);
            throw iOException;
        }
    }

    public final void a(SSLSocket sSLSocket, String str, List<al> list) {
        if (str != null) {
            this.f719b.a(sSLSocket, true);
            this.f720c.a(sSLSocket, str);
        }
        if (this.e != null && this.e.a(sSLSocket)) {
            Object[] objArr = new Object[1];
            f fVar = new f();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                al alVar = list.get(i);
                if (alVar != al.HTTP_1_0) {
                    fVar.h(alVar.toString().length());
                    fVar.b(alVar.toString());
                }
            }
            objArr[0] = fVar.n();
            this.e.b(sSLSocket, objArr);
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

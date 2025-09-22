package b.a.h;

import b.a.j.a;
import b.a.j.b;
import b.aa;
import b.z;
import c.c;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f199a = Logger.getLogger(z.class.getName());

    /* renamed from: c  reason: collision with root package name */
    static final e f200c;
    public static final int d = 4;
    public static final int e = 5;

    static {
        e a2 = a.a();
        if (a2 == null && (a2 = b.a()) == null && (a2 = c.a()) == null) {
            a2 = new e();
        }
        f200c = a2;
    }

    private static e a() {
        e a2 = a.a();
        if (a2 != null) {
            return a2;
        }
        b a3 = b.a();
        if (a3 != null) {
            return a3;
        }
        e a4 = c.a();
        return a4 != null ? a4 : new e();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK, PHI: r4 
      PHI: (r4v1 java.lang.Object) = (r4v0 java.lang.Object), (r4v2 java.lang.Object) binds: [B:0:0x0000, B:20:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> T a(java.lang.Object r4, java.lang.Class<T> r5, java.lang.String r6) {
        /*
        L_0x0000:
            java.lang.Class r0 = r4.getClass()
        L_0x0004:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            r2 = 0
            if (r0 == r1) goto L_0x002f
            java.lang.reflect.Field r1 = r0.getDeclaredField(r6)     // Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
            r3 = 1
            r1.setAccessible(r3)     // Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
            if (r1 == 0) goto L_0x0023
            boolean r3 = r5.isInstance(r1)     // Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
            if (r3 != 0) goto L_0x001e
            return r2
        L_0x001e:
            java.lang.Object r1 = r5.cast(r1)     // Catch:{ NoSuchFieldException -> 0x002a, IllegalAccessException -> 0x0024 }
            return r1
        L_0x0023:
            return r2
        L_0x0024:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L_0x002a:
            java.lang.Class r0 = r0.getSuperclass()
            goto L_0x0004
        L_0x002f:
            java.lang.String r0 = "delegate"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x0042
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r1 = "delegate"
            java.lang.Object r4 = a((java.lang.Object) r4, r0, (java.lang.String) r1)
            if (r4 == 0) goto L_0x0042
            goto L_0x0000
        L_0x0042:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.h.e.a(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object");
    }

    public static List<String> a(List<aa> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            aa aaVar = list.get(i);
            if (aaVar != aa.HTTP_1_0) {
                arrayList.add(aaVar.toString());
            }
        }
        return arrayList;
    }

    public static e b() {
        return f200c;
    }

    private static byte[] b(List<aa> list) {
        c cVar = new c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            aa aaVar = list.get(i);
            if (aaVar != aa.HTTP_1_0) {
                cVar.l(aaVar.toString().length());
                cVar.b(aaVar.toString());
            }
        }
        return cVar.v();
    }

    public static String c() {
        return "OkHttp";
    }

    public b a(X509TrustManager x509TrustManager) {
        return new a(b.a.j.e.a(x509TrustManager));
    }

    public Object a(String str) {
        if (f199a.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        try {
            Object a2 = a((Object) sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), com.umeng.analytics.pro.b.M);
            if (a2 == null) {
                return null;
            }
            return (X509TrustManager) a((Object) a2, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public void a(int i, String str, Throwable th) {
        f199a.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(SSLSocket sSLSocket, String str, List<aa> list) {
    }

    public void b(SSLSocket sSLSocket) {
    }

    public boolean b(String str) {
        return true;
    }
}

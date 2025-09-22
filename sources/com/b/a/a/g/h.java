package com.b.a.a.g;

import com.b.a.a.h.a;
import com.b.a.a.h.b;
import com.b.a.a.h.e;
import com.b.a.ai;
import com.b.a.al;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final h f737a;

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f738b = Logger.getLogger(ai.class.getName());

    static {
        h a2 = a.a();
        if (a2 == null && (a2 = d.a()) == null && (a2 = e.a()) == null) {
            a2 = new h();
        }
        f737a = a2;
    }

    public static List<String> a(List<al> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            al alVar = list.get(i);
            if (alVar != al.HTTP_1_0) {
                arrayList.add(alVar.toString());
            }
        }
        return arrayList;
    }

    public static h b() {
        return f737a;
    }

    public b a(X509TrustManager x509TrustManager) {
        return new a(e.a(x509TrustManager));
    }

    public Object a(String str) {
        if (f738b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public void a(int i, String str, Throwable th) {
        f738b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public void a(SSLSocket sSLSocket, String str, List<al> list) {
    }

    public void b(SSLSocket sSLSocket) {
    }

    public boolean b(String str) {
        return true;
    }
}

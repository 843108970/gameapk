package b.a.d;

import b.ac;
import b.v;
import java.net.Proxy;

public final class i {
    private i() {
    }

    private static String a(ac acVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(acVar.f248b);
        sb.append(' ');
        if (!acVar.f247a.b() && type == Proxy.Type.HTTP) {
            sb.append(acVar.f247a);
        } else {
            sb.append(a(acVar.f247a));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static String a(v vVar) {
        String e = vVar.e();
        String g = vVar.g();
        if (g == null) {
            return e;
        }
        return e + '?' + g;
    }

    private static boolean b(ac acVar, Proxy.Type type) {
        return !acVar.f247a.b() && type == Proxy.Type.HTTP;
    }
}

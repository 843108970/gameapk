package b.a.d;

import com.android.volley.toolbox.g;
import com.github.kevinsawicki.http.HttpRequest;

public final class f {
    private f() {
    }

    public static boolean a(String str) {
        return str.equals("POST") || str.equals(g.a.f536a) || str.equals(HttpRequest.METHOD_PUT) || str.equals(HttpRequest.METHOD_DELETE) || str.equals("MOVE");
    }

    public static boolean b(String str) {
        return str.equals("POST") || str.equals(HttpRequest.METHOD_PUT) || str.equals(g.a.f536a) || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean c(String str) {
        return b(str) || str.equals(HttpRequest.METHOD_OPTIONS) || str.equals(HttpRequest.METHOD_DELETE) || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    private static boolean d(String str) {
        return str.equals("PROPFIND");
    }

    private static boolean e(String str) {
        return !str.equals("PROPFIND");
    }
}

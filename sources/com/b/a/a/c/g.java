package com.b.a.a.c;

import com.android.volley.toolbox.g;
import com.github.kevinsawicki.http.HttpRequest;

public final class g {
    public static boolean a(String str) {
        return str.equals("POST") || str.equals(HttpRequest.METHOD_PUT) || str.equals(g.a.f536a) || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean b(String str) {
        return a(str) || str.equals(HttpRequest.METHOD_OPTIONS) || str.equals(HttpRequest.METHOD_DELETE) || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }
}

package com.android.volley.toolbox;

import com.android.volley.b;
import com.android.volley.i;
import com.github.kevinsawicki.http.HttpRequest;
import com.lidroid.xutils.util.CharsetUtils;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public final class h {
    private static long a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException unused) {
            return 0;
        }
    }

    public static b.a a(i iVar) {
        boolean z;
        long j;
        boolean z2;
        long j2;
        long j3;
        long j4;
        i iVar2 = iVar;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = iVar2.f485c;
        String str = map.get("Date");
        long a2 = str != null ? a(str) : 0;
        String str2 = map.get("Cache-Control");
        if (str2 != null) {
            String[] split = str2.split(",");
            j2 = 0;
            z2 = false;
            j = 0;
            for (String trim : split) {
                String trim2 = trim.trim();
                if (!trim2.equals("no-cache") && !trim2.equals("no-store")) {
                    if (trim2.startsWith("max-age=")) {
                        try {
                            j2 = Long.parseLong(trim2.substring(8));
                        } catch (Exception unused) {
                        }
                    } else {
                        if (trim2.startsWith("stale-while-revalidate=")) {
                            j = Long.parseLong(trim2.substring(23));
                        } else if (!trim2.equals("must-revalidate") && !trim2.equals("proxy-revalidate")) {
                        }
                    }
                }
                z2 = true;
            }
            z = true;
        } else {
            j2 = 0;
            z2 = false;
            j = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long a3 = str3 != null ? a(str3) : 0;
        String str4 = map.get("Last-Modified");
        long a4 = str4 != null ? a(str4) : 0;
        String str5 = map.get("ETag");
        if (z) {
            long j5 = currentTimeMillis + (j2 * 1000);
            j4 = z2 ? j5 : j5 + (j * 1000);
            j3 = j5;
        } else if (a2 <= 0 || a3 < a2) {
            j4 = 0;
            j3 = 0;
        } else {
            j3 = currentTimeMillis + (a3 - a2);
            j4 = j3;
        }
        b.a aVar = new b.a();
        aVar.f463a = iVar2.f484b;
        aVar.f464b = str5;
        aVar.f = j3;
        aVar.e = j4;
        aVar.f465c = a2;
        aVar.d = a4;
        aVar.g = map;
        return aVar;
    }

    public static String a(Map<String, String> map) {
        return a(map, CharsetUtils.DEFAULT_ENCODING_CHARSET);
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals(HttpRequest.PARAM_CHARSET)) {
                    return split2[1];
                }
            }
        }
        return str;
    }
}

package com.b.a.a.e;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.b.b.i;
import com.github.kevinsawicki.http.HttpRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

final class d {

    /* renamed from: a  reason: collision with root package name */
    static final c[] f669a = {new c(c.f, ""), new c(c.f668c, (String) HttpRequest.METHOD_GET), new c(c.f668c, "POST"), new c(c.d, "/"), new c(c.d, "/index.html"), new c(c.e, "http"), new c(c.e, "https"), new c(c.f667b, "200"), new c(c.f667b, "204"), new c(c.f667b, "206"), new c(c.f667b, "304"), new c(c.f667b, "400"), new c(c.f667b, "404"), new c(c.f667b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c((String) RequestParameters.SUBRESOURCE_LOCATION, ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c((String) RequestParameters.SUBRESOURCE_REFERER, ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};

    /* renamed from: b  reason: collision with root package name */
    static final Map<i, Integer> f670b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f669a.length);
        for (int i = 0; i < f669a.length; i++) {
            if (!linkedHashMap.containsKey(f669a[i].g)) {
                linkedHashMap.put(f669a[i].g, Integer.valueOf(i));
            }
        }
        f670b = Collections.unmodifiableMap(linkedHashMap);
    }

    static i a(i iVar) {
        int g = iVar.g();
        int i = 0;
        while (i < g) {
            byte a2 = iVar.a(i);
            if (a2 < 65 || a2 > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + iVar.a());
            }
        }
        return iVar;
    }
}

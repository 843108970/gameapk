package com.google.a.b.a;

import com.cyjh.common.util.s;
import com.google.a.r;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ad extends u {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f3008a = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f3009b = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    static boolean a(String str) {
        if (str.contains(s.a.f1696a)) {
            return false;
        }
        Matcher matcher = f3008a.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = f3009b.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    private static ac c(r rVar) {
        String b2 = b(rVar);
        if (b2.startsWith("URL:") || b2.startsWith("URI:")) {
            return new ac(b2.substring(4).trim(), (String) null);
        }
        String trim = b2.trim();
        if (a(trim)) {
            return new ac(trim, (String) null);
        }
        return null;
    }

    public final /* synthetic */ q a(r rVar) {
        String b2 = b(rVar);
        if (b2.startsWith("URL:") || b2.startsWith("URI:")) {
            return new ac(b2.substring(4).trim(), (String) null);
        }
        String trim = b2.trim();
        if (a(trim)) {
            return new ac(trim, (String) null);
        }
        return null;
    }
}

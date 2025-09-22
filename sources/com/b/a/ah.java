package com.b.a;

import com.github.kevinsawicki.http.HttpRequest;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ah {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f758a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f759b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c  reason: collision with root package name */
    private final String f760c;
    private final String d;
    private final String e;
    private final String f;

    private ah(String str, String str2, String str3, String str4) {
        this.f760c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public static ah a(String str) {
        Matcher matcher = f758a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f759b.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase(HttpRequest.PARAM_CHARSET)) {
                String group2 = matcher2.group(2);
                if (group2 == null) {
                    group2 = matcher2.group(3);
                } else if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                    group2 = group2.substring(1, group2.length() - 1);
                }
                if (str2 == null || group2.equalsIgnoreCase(str2)) {
                    str2 = group2;
                } else {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
        }
        return new ah(str, lowerCase, lowerCase2, str2);
    }

    public final Charset a(Charset charset) {
        return this.f != null ? Charset.forName(this.f) : charset;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ah) && ((ah) obj).f760c.equals(this.f760c);
    }

    public final int hashCode() {
        return this.f760c.hashCode();
    }

    public final String toString() {
        return this.f760c;
    }
}

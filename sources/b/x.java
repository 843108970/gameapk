package b;

import com.github.kevinsawicki.http.HttpRequest;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class x {

    /* renamed from: b  reason: collision with root package name */
    private static final String f359b = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";

    /* renamed from: c  reason: collision with root package name */
    private static final String f360c = "\"([^\"]*)\"";
    private static final Pattern d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a  reason: collision with root package name */
    final String f361a;
    private final String f;
    private final String g;
    @Nullable
    private final String h;

    private x(String str, String str2, String str3, @Nullable String str4) {
        this.f = str;
        this.f361a = str2;
        this.g = str3;
        this.h = str4;
    }

    @Nullable
    public static x a(String str) {
        Matcher matcher = d.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = e.matcher(str);
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
                if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = group2;
            }
        }
        return new x(str, lowerCase, lowerCase2, str2);
    }

    private String a() {
        return this.f361a;
    }

    private String b() {
        return this.g;
    }

    @Nullable
    private Charset c() {
        return a((Charset) null);
    }

    @Nullable
    public final Charset a(@Nullable Charset charset) {
        try {
            if (this.h != null) {
                return Charset.forName(this.h);
            }
        } catch (IllegalArgumentException unused) {
        }
        return charset;
    }

    public final boolean equals(@Nullable Object obj) {
        return (obj instanceof x) && ((x) obj).f.equals(this.f);
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    public final String toString() {
        return this.f;
    }
}

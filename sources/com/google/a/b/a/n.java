package com.google.a.b.a;

import com.google.a.r;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class n extends u {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f3038a = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    private static m c(r rVar) {
        Matcher matcher = f3038a.matcher(b(rVar));
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(4);
        try {
            double parseDouble = Double.parseDouble(matcher.group(1));
            if (parseDouble > 90.0d || parseDouble < -90.0d) {
                return null;
            }
            double parseDouble2 = Double.parseDouble(matcher.group(2));
            if (parseDouble2 > 180.0d || parseDouble2 < -180.0d) {
                return null;
            }
            double d = 0.0d;
            if (matcher.group(3) != null) {
                double parseDouble3 = Double.parseDouble(matcher.group(3));
                if (parseDouble3 < 0.0d) {
                    return null;
                }
                d = parseDouble3;
            }
            return new m(parseDouble, parseDouble2, d, group);
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    public final /* synthetic */ q a(r rVar) {
        return c(rVar);
    }
}

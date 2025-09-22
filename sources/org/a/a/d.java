package org.a.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.a.b;
import org.a.g;
import org.a.i;
import org.a.k;

public final class d<T> extends b<T> {
    private static final Pattern d = Pattern.compile("%([0-9]+)");

    /* renamed from: a  reason: collision with root package name */
    private final String f4246a;

    /* renamed from: b  reason: collision with root package name */
    private final k<T> f4247b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f4248c;

    private d(String str, k<T> kVar, Object[] objArr) {
        this.f4246a = str;
        this.f4247b = kVar;
        this.f4248c = (Object[]) objArr.clone();
    }

    @i
    public static <T> k<T> a(String str, k<T> kVar, Object... objArr) {
        return new d(str, kVar, objArr);
    }

    public final void a(Object obj, g gVar) {
        this.f4247b.a(obj, gVar);
    }

    public final boolean a(Object obj) {
        return this.f4247b.a(obj);
    }

    public final void describeTo(g gVar) {
        Matcher matcher = d.matcher(this.f4246a);
        int i = 0;
        while (matcher.find()) {
            gVar.a(this.f4246a.substring(i, matcher.start()));
            gVar.a(this.f4248c[Integer.parseInt(matcher.group(1))]);
            i = matcher.end();
        }
        if (i < this.f4246a.length()) {
            gVar.a(this.f4246a.substring(i));
        }
    }
}

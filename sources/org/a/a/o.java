package org.a.a;

import org.a.i;
import org.a.k;

public final class o extends r {
    private o(String str) {
        super(str);
    }

    @i
    public static k<String> b(String str) {
        return new o(str);
    }

    /* access modifiers changed from: protected */
    public final boolean a(String str) {
        return str.indexOf(this.f4259a) >= 0;
    }

    /* access modifiers changed from: protected */
    public final String b() {
        return "containing";
    }
}

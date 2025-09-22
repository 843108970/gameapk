package org.a;

import java.io.IOException;

public final class n extends a {

    /* renamed from: b  reason: collision with root package name */
    private final Appendable f4276b;

    public n() {
        this(new StringBuilder());
    }

    private n(Appendable appendable) {
        this.f4276b = appendable;
    }

    public static String b(m mVar) {
        return new n().a(mVar).toString();
    }

    public static String c(m mVar) {
        return b(mVar);
    }

    /* access modifiers changed from: protected */
    public final void a(char c2) {
        try {
            this.f4276b.append(c2);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        try {
            this.f4276b.append(str);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }

    public final String toString() {
        return this.f4276b.toString();
    }
}

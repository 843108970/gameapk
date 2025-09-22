package org.apache.commons.mail.a;

import org.apache.commons.mail.DataSourceResolver;

public abstract class a implements DataSourceResolver {

    /* renamed from: a  reason: collision with root package name */
    final boolean f4281a;

    public a() {
        this.f4281a = false;
    }

    public a(boolean z) {
        this.f4281a = z;
    }

    private boolean a() {
        return this.f4281a;
    }

    protected static boolean a(String str) {
        return str.startsWith("http://") || str.startsWith("https://");
    }

    private static boolean b(String str) {
        return str.startsWith("cid:");
    }

    private static boolean c(String str) {
        return str.startsWith("file:/");
    }
}

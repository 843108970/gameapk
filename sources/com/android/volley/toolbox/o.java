package com.android.volley.toolbox;

import com.android.volley.i;
import com.android.volley.l;
import com.android.volley.n;
import com.android.volley.t;
import java.io.UnsupportedEncodingException;

public abstract class o<T> extends l<T> {
    protected static final String m = "utf-8";
    private static final String n = String.format("application/json; charset=%s", new Object[]{"utf-8"});
    private final n.b<T> o;
    private final String p;

    public o(int i, String str, String str2, n.b<T> bVar, n.a aVar) {
        super(i, str, aVar);
        this.o = bVar;
        this.p = str2;
    }

    private o(String str, String str2, n.b<T> bVar, n.a aVar) {
        this(-1, str, str2, bVar, aVar);
    }

    /* access modifiers changed from: protected */
    public abstract n<T> a(i iVar);

    /* access modifiers changed from: protected */
    public final void a(T t) {
        this.o.a(t);
    }

    public final String c() {
        return n;
    }

    public final byte[] d() {
        return g();
    }

    public final String f() {
        return n;
    }

    public final byte[] g() {
        try {
            if (this.p == null) {
                return null;
            }
            return this.p.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            t.d("Unsupported Encoding while trying to get the bytes of %s using %s", this.p, "utf-8");
            return null;
        }
    }
}

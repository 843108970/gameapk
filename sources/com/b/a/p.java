package com.b.a;

import com.b.a.a.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final p f822a;

    /* renamed from: b  reason: collision with root package name */
    public static final p f823b = new q(f822a).a(ax.TLS_1_0).a().b();

    /* renamed from: c  reason: collision with root package name */
    public static final p f824c = new q(false).b();
    private static final l[] h = {l.aW, l.ba, l.aX, l.bb, l.bh, l.bg, l.ax, l.aH, l.ay, l.aI, l.af, l.ag, l.D, l.H, l.h};
    final boolean d;
    final boolean e;
    final String[] f;
    final String[] g;

    static {
        q qVar = new q(true);
        l[] lVarArr = h;
        if (!qVar.f825a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        String[] strArr = new String[lVarArr.length];
        for (int i = 0; i < lVarArr.length; i++) {
            strArr[i] = lVarArr[i].bi;
        }
        f822a = qVar.a(strArr).a(ax.TLS_1_3, ax.TLS_1_2, ax.TLS_1_1, ax.TLS_1_0).a().b();
    }

    p(q qVar) {
        this.d = qVar.f825a;
        this.f = qVar.f826b;
        this.g = qVar.f827c;
        this.e = qVar.d;
    }

    private static boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String a2 : strArr) {
            if (c.a((T[]) strArr2, a2) != -1) {
                return true;
            }
        }
        return false;
    }

    private List<ax> b() {
        if (this.g == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.g.length);
        for (String a2 : this.g) {
            arrayList.add(ax.a(a2));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final boolean a() {
        return this.e;
    }

    public final boolean a(SSLSocket sSLSocket) {
        if (!this.d) {
            return false;
        }
        if (this.g == null || a(this.g, sSLSocket.getEnabledProtocols())) {
            return this.f == null || a(this.f, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        p pVar = (p) obj;
        if (this.d != pVar.d) {
            return false;
        }
        return !this.d || (Arrays.equals(this.f, pVar.f) && Arrays.equals(this.g, pVar.g) && this.e == pVar.e);
    }

    public final int hashCode() {
        if (this.d) {
            return ((((Arrays.hashCode(this.f) + 527) * 31) + Arrays.hashCode(this.g)) * 31) + (this.e ^ true ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        String str;
        List list;
        if (!this.d) {
            return "ConnectionSpec()";
        }
        if (this.f != null) {
            if (this.f == null) {
                list = null;
            } else {
                ArrayList arrayList = new ArrayList(this.f.length);
                for (String a2 : this.f) {
                    arrayList.add(l.a(a2));
                }
                list = Collections.unmodifiableList(arrayList);
            }
            str = list.toString();
        } else {
            str = "[all enabled]";
        }
        return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + (this.g != null ? b().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.e + ")";
    }
}

package b;

import b.a.c;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f323a;

    /* renamed from: b  reason: collision with root package name */
    public static final l f324b = new a(f323a).a(ah.TLS_1_0).a().b();

    /* renamed from: c  reason: collision with root package name */
    public static final l f325c = new a(false).b();
    private static final i[] h = {i.aX, i.bb, i.aY, i.bc, i.bi, i.bh, i.ay, i.aI, i.az, i.aJ, i.ag, i.ah, i.E, i.I, i.i};
    final boolean d;
    public final boolean e;
    @Nullable
    final String[] f;
    @Nullable
    final String[] g;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f326a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        String[] f327b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        String[] f328c;
        boolean d;

        public a(l lVar) {
            this.f326a = lVar.d;
            this.f327b = lVar.f;
            this.f328c = lVar.g;
            this.d = lVar.e;
        }

        a(boolean z) {
            this.f326a = z;
        }

        private a a(i... iVarArr) {
            if (!this.f326a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[iVarArr.length];
            for (int i = 0; i < iVarArr.length; i++) {
                strArr[i] = iVarArr[i].bj;
            }
            return a(strArr);
        }

        private a c() {
            if (!this.f326a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            this.f327b = null;
            return this;
        }

        private a d() {
            if (!this.f326a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            this.f328c = null;
            return this;
        }

        public final a a() {
            if (!this.f326a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.d = true;
            return this;
        }

        public final a a(ah... ahVarArr) {
            if (!this.f326a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[ahVarArr.length];
            for (int i = 0; i < ahVarArr.length; i++) {
                strArr[i] = ahVarArr[i].javaName;
            }
            return b(strArr);
        }

        public final a a(String... strArr) {
            if (!this.f326a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            } else {
                this.f327b = (String[]) strArr.clone();
                return this;
            }
        }

        public final a b(String... strArr) {
            if (!this.f326a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            } else {
                this.f328c = (String[]) strArr.clone();
                return this;
            }
        }

        public final l b() {
            return new l(this);
        }
    }

    static {
        a aVar = new a(true);
        i[] iVarArr = h;
        if (!aVar.f326a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        String[] strArr = new String[iVarArr.length];
        for (int i = 0; i < iVarArr.length; i++) {
            strArr[i] = iVarArr[i].bj;
        }
        f323a = aVar.a(strArr).a(ah.TLS_1_3, ah.TLS_1_2, ah.TLS_1_1, ah.TLS_1_0).a().b();
    }

    l(a aVar) {
        this.d = aVar.f326a;
        this.f = aVar.f327b;
        this.g = aVar.f328c;
        this.e = aVar.d;
    }

    private void a(SSLSocket sSLSocket, boolean z) {
        String[] a2 = this.f != null ? c.a((Comparator<? super String>) i.f316a, sSLSocket.getEnabledCipherSuites(), this.f) : sSLSocket.getEnabledCipherSuites();
        String[] a3 = this.g != null ? c.a((Comparator<? super String>) c.g, sSLSocket.getEnabledProtocols(), this.g) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a4 = c.a(i.f316a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a4 != -1) {
            a2 = c.a(a2, supportedCipherSuites[a4]);
        }
        l b2 = new a(this).a(a2).b(a3).b();
        if (b2.g != null) {
            sSLSocket.setEnabledProtocols(b2.g);
        }
        if (b2.f != null) {
            sSLSocket.setEnabledCipherSuites(b2.f);
        }
    }

    private boolean a() {
        return this.d;
    }

    private l b(SSLSocket sSLSocket, boolean z) {
        String[] a2 = this.f != null ? c.a((Comparator<? super String>) i.f316a, sSLSocket.getEnabledCipherSuites(), this.f) : sSLSocket.getEnabledCipherSuites();
        String[] a3 = this.g != null ? c.a((Comparator<? super String>) c.g, sSLSocket.getEnabledProtocols(), this.g) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a4 = c.a(i.f316a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a4 != -1) {
            a2 = c.a(a2, supportedCipherSuites[a4]);
        }
        return new a(this).a(a2).b(a3).b();
    }

    @Nullable
    private List<i> b() {
        if (this.f != null) {
            return i.a(this.f);
        }
        return null;
    }

    @Nullable
    private List<ah> c() {
        if (this.g != null) {
            return ah.forJavaNames(this.g);
        }
        return null;
    }

    private boolean d() {
        return this.e;
    }

    public final boolean a(SSLSocket sSLSocket) {
        if (!this.d) {
            return false;
        }
        if (this.g == null || c.b(c.g, this.g, sSLSocket.getEnabledProtocols())) {
            return this.f == null || c.b(i.f316a, this.f, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        l lVar = (l) obj;
        if (this.d != lVar.d) {
            return false;
        }
        return !this.d || (Arrays.equals(this.f, lVar.f) && Arrays.equals(this.g, lVar.g) && this.e == lVar.e);
    }

    public final int hashCode() {
        if (this.d) {
            return ((((Arrays.hashCode(this.f) + 527) * 31) + Arrays.hashCode(this.g)) * 31) + (this.e ^ true ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        String str;
        String str2;
        if (!this.d) {
            return "ConnectionSpec()";
        }
        List<ah> list = null;
        if (this.f != null) {
            str = (this.f != null ? i.a(this.f) : null).toString();
        } else {
            str = "[all enabled]";
        }
        if (this.g != null) {
            if (this.g != null) {
                list = ah.forJavaNames(this.g);
            }
            str2 = list.toString();
        } else {
            str2 = "[all enabled]";
        }
        return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.e + ")";
    }
}

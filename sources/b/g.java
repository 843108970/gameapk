package b;

import b.a.c;
import c.f;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f307a = new g(new LinkedHashSet(new a().f310a), (b.a.j.b) null);

    /* renamed from: b  reason: collision with root package name */
    final Set<b> f308b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    final b.a.j.b f309c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<b> f310a = new ArrayList();

        private a a(String str, String... strArr) {
            if (str == null) {
                throw new NullPointerException("pattern == null");
            }
            for (String bVar : strArr) {
                this.f310a.add(new b(str, bVar));
            }
            return this;
        }

        private g a() {
            return new g(new LinkedHashSet(this.f310a), (b.a.j.b) null);
        }
    }

    static final class b {
        private static final String e = "*.";

        /* renamed from: a  reason: collision with root package name */
        final String f311a;

        /* renamed from: b  reason: collision with root package name */
        final String f312b;

        /* renamed from: c  reason: collision with root package name */
        final String f313c;
        final f d;

        b(String str, String str2) {
            StringBuilder sb;
            int i;
            this.f311a = str;
            if (str.startsWith(e)) {
                sb = new StringBuilder("http://");
                str = str.substring(2);
            } else {
                sb = new StringBuilder("http://");
            }
            sb.append(str);
            this.f312b = v.d(sb.toString()).l;
            if (str2.startsWith("sha1/")) {
                this.f313c = "sha1/";
                i = 5;
            } else if (str2.startsWith("sha256/")) {
                this.f313c = "sha256/";
                i = 7;
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            this.d = f.decodeBase64(str2.substring(i));
            if (this.d == null) {
                throw new IllegalArgumentException("pins must be base64: " + str2);
            }
        }

        private boolean a(String str) {
            if (!this.f311a.startsWith(e)) {
                return str.equals(this.f312b);
            }
            return str.regionMatches(false, str.indexOf(46) + 1, this.f312b, 0, this.f312b.length());
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f311a.equals(bVar.f311a) && this.f313c.equals(bVar.f313c) && this.d.equals(bVar.d);
        }

        public final int hashCode() {
            return ((((this.f311a.hashCode() + 527) * 31) + this.f313c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return this.f313c + this.d.base64();
        }
    }

    g(Set<b> set, @Nullable b.a.j.b bVar) {
        this.f308b = set;
        this.f309c = bVar;
    }

    private g a(b.a.j.b bVar) {
        return c.a((Object) this.f309c, (Object) bVar) ? this : new g(this.f308b, bVar);
    }

    private static f a(X509Certificate x509Certificate) {
        return f.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    public static String a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + b((X509Certificate) certificate).base64();
    }

    private List<b> a(String str) {
        boolean z;
        List<b> emptyList = Collections.emptyList();
        for (b next : this.f308b) {
            if (next.f311a.startsWith("*.")) {
                z = str.regionMatches(false, str.indexOf(46) + 1, next.f312b, 0, next.f312b.length());
            } else {
                z = str.equals(next.f312b);
            }
            if (z) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    private void a(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        a(str, (List<Certificate>) Arrays.asList(certificateArr));
    }

    private static f b(X509Certificate x509Certificate) {
        return f.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public final void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        boolean z;
        List emptyList = Collections.emptyList();
        for (b next : this.f308b) {
            if (next.f311a.startsWith("*.")) {
                z = str.regionMatches(false, str.indexOf(46) + 1, next.f312b, 0, next.f312b.length());
            } else {
                z = str.equals(next.f312b);
            }
            if (z) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(next);
            }
        }
        if (!emptyList.isEmpty()) {
            if (this.f309c != null) {
                list = this.f309c.a(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = emptyList.size();
                f fVar = null;
                f fVar2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar = (b) emptyList.get(i2);
                    if (bVar.f313c.equals("sha256/")) {
                        if (fVar == null) {
                            fVar = b(x509Certificate);
                        }
                        if (bVar.d.equals(fVar)) {
                            return;
                        }
                    } else if (bVar.f313c.equals("sha1/")) {
                        if (fVar2 == null) {
                            fVar2 = f.of(x509Certificate.getPublicKey().getEncoded()).sha1();
                        }
                        if (bVar.d.equals(fVar2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb.append("\n    ");
                sb.append(a((Certificate) x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = emptyList.size();
            for (int i4 = 0; i4 < size4; i4++) {
                sb.append("\n    ");
                sb.append((b) emptyList.get(i4));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return c.a((Object) this.f309c, (Object) gVar.f309c) && this.f308b.equals(gVar.f308b);
    }

    public final int hashCode() {
        return ((this.f309c != null ? this.f309c.hashCode() : 0) * 31) + this.f308b.hashCode();
    }
}

package com.b.a;

import com.b.a.a.c;
import com.b.a.a.h.b;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f808a = new j().a();

    /* renamed from: b  reason: collision with root package name */
    private final Set<k> f809b;

    /* renamed from: c  reason: collision with root package name */
    private final b f810c;

    i(Set<k> set, b bVar) {
        this.f809b = set;
        this.f810c = bVar;
    }

    private static com.b.b.i a(X509Certificate x509Certificate) {
        return com.b.b.i.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    public static String a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + a((X509Certificate) certificate).b();
    }

    /* access modifiers changed from: package-private */
    public final i a(b bVar) {
        return c.a((Object) this.f810c, (Object) bVar) ? this : new i(this.f809b, bVar);
    }

    public final void a(String str, List<Certificate> list) {
        boolean z;
        List emptyList = Collections.emptyList();
        for (k next : this.f809b) {
            if (next.f812a.startsWith("*.")) {
                z = str.regionMatches(false, str.indexOf(46) + 1, next.f813b, 0, next.f813b.length());
            } else {
                z = str.equals(next.f813b);
            }
            if (z) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(next);
            }
        }
        if (!emptyList.isEmpty()) {
            if (this.f810c != null) {
                list = this.f810c.a(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = emptyList.size();
                com.b.b.i iVar = null;
                com.b.b.i iVar2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    k kVar = (k) emptyList.get(i2);
                    if (kVar.f814c.equals("sha256/")) {
                        if (iVar == null) {
                            iVar = a(x509Certificate);
                        }
                        if (kVar.d.equals(iVar)) {
                            return;
                        }
                    } else if (kVar.f814c.equals("sha1/")) {
                        if (iVar2 == null) {
                            iVar2 = com.b.b.i.a(x509Certificate.getPublicKey().getEncoded()).c();
                        }
                        if (kVar.d.equals(iVar2)) {
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
                sb.append((k) emptyList.get(i4));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return c.a((Object) this.f810c, (Object) iVar.f810c) && this.f809b.equals(iVar.f809b);
    }

    public final int hashCode() {
        return ((this.f810c != null ? this.f810c.hashCode() : 0) * 31) + this.f809b.hashCode();
    }
}

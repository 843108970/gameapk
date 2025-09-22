package com.b.a;

import com.b.a.a.a;
import com.b.a.a.a.i;
import com.b.a.a.c;
import com.b.a.a.g.h;
import com.b.a.a.h.b;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class ai implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    static final List<al> f761a = c.a((T[]) new al[]{al.HTTP_2, al.HTTP_1_1});

    /* renamed from: b  reason: collision with root package name */
    static final List<p> f762b = c.a((T[]) new p[]{p.f822a, p.f823b, p.f824c});
    final int A;
    final int B;

    /* renamed from: c  reason: collision with root package name */
    final u f763c;
    final Proxy d;
    final List<al> e;
    final List<p> f;
    final List<af> g;
    final List<af> h;
    final ProxySelector i;
    final s j;
    final d k;
    final i l;
    final SocketFactory m;
    final SSLSocketFactory n;
    final b o;
    final HostnameVerifier p;
    final i q;
    final b r;
    final b s;
    final n t;
    final v u;
    final boolean v;
    final boolean w;
    final boolean x;
    final int y;
    final int z;

    static {
        a.f566a = new aj();
    }

    public ai() {
        this(new ak());
    }

    private ai(ak akVar) {
        boolean z2;
        b bVar;
        this.f763c = akVar.f764a;
        this.d = akVar.f765b;
        this.e = akVar.f766c;
        this.f = akVar.d;
        this.g = c.a(akVar.e);
        this.h = c.a(akVar.f);
        this.i = akVar.g;
        this.j = akVar.h;
        this.k = akVar.i;
        this.l = akVar.j;
        this.m = akVar.k;
        Iterator<p> it = this.f.iterator();
        loop0:
        while (true) {
            z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                p next = it.next();
                if (z2 || next.d) {
                    z2 = true;
                }
            }
        }
        if (akVar.l != null || !z2) {
            this.n = akVar.l;
            bVar = akVar.m;
        } else {
            X509TrustManager t2 = t();
            this.n = a(t2);
            bVar = h.b().a(t2);
        }
        this.o = bVar;
        this.p = akVar.n;
        this.q = akVar.o.a(this.o);
        this.r = akVar.p;
        this.s = akVar.q;
        this.t = akVar.r;
        this.u = akVar.s;
        this.v = akVar.t;
        this.w = akVar.u;
        this.x = akVar.v;
        this.y = akVar.w;
        this.z = akVar.x;
        this.A = akVar.y;
        this.B = akVar.z;
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return instance.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    private static X509TrustManager t() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1) {
                if (trustManagers[0] instanceof X509TrustManager) {
                    return (X509TrustManager) trustManagers[0];
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    public final int a() {
        return this.y;
    }

    public final g a(ao aoVar) {
        return new am(this, aoVar, false);
    }

    public final int b() {
        return this.z;
    }

    public final int c() {
        return this.A;
    }

    public final Proxy d() {
        return this.d;
    }

    public final ProxySelector e() {
        return this.i;
    }

    public final s f() {
        return this.j;
    }

    public final v g() {
        return this.u;
    }

    public final SocketFactory h() {
        return this.m;
    }

    public final SSLSocketFactory i() {
        return this.n;
    }

    public final HostnameVerifier j() {
        return this.p;
    }

    public final i k() {
        return this.q;
    }

    public final b l() {
        return this.s;
    }

    public final b m() {
        return this.r;
    }

    public final n n() {
        return this.t;
    }

    public final boolean o() {
        return this.v;
    }

    public final boolean p() {
        return this.w;
    }

    public final boolean q() {
        return this.x;
    }

    public final List<al> r() {
        return this.e;
    }

    public final List<p> s() {
        return this.f;
    }
}

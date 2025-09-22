package com.b.a.a.a;

import com.b.a.a.f.a;
import com.b.b.g;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class f implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    static final Pattern f576a = Pattern.compile("[a-z0-9_-]{1,120}");
    static final /* synthetic */ boolean j = true;

    /* renamed from: b  reason: collision with root package name */
    final a f577b;

    /* renamed from: c  reason: collision with root package name */
    final int f578c;
    g d;
    final LinkedHashMap<String, h> e;
    int f;
    boolean g;
    boolean h;
    boolean i;
    private long k;
    private long l;
    private final Executor m;
    private final Runnable n;

    private boolean a() {
        return this.f >= 2000 && this.f >= this.e.size();
    }

    private boolean a(h hVar) {
        if (hVar.f != null) {
            g gVar = hVar.f;
            if (gVar.f579a.f == gVar) {
                for (int i2 = 0; i2 < gVar.f580b.f578c; i2++) {
                    try {
                        gVar.f580b.f577b.a(gVar.f579a.d[i2]);
                    } catch (IOException unused) {
                    }
                }
                gVar.f579a.f = null;
            }
        }
        for (int i3 = 0; i3 < this.f578c; i3++) {
            this.f577b.a(hVar.f584c[i3]);
            this.l -= hVar.f583b[i3];
            hVar.f583b[i3] = 0;
        }
        this.f++;
        this.d.b("REMOVE").h(32).b(hVar.f582a).h(10);
        this.e.remove(hVar.f582a);
        if (a()) {
            this.m.execute(this.n);
        }
        return true;
    }

    private synchronized boolean b() {
        return this.h;
    }

    private synchronized void c() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void d() {
        while (this.l > this.k) {
            a(this.e.values().iterator().next());
        }
        this.i = false;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(g gVar) {
        g gVar2;
        h hVar = gVar.f579a;
        if (hVar.f != gVar) {
            throw new IllegalStateException();
        }
        for (int i2 = 0; i2 < this.f578c; i2++) {
            this.f577b.a(hVar.d[i2]);
        }
        this.f++;
        hVar.f = null;
        if (false || hVar.e) {
            hVar.e = true;
            this.d.b("CLEAN").h(32);
            this.d.b(hVar.f582a);
            hVar.a(this.d);
            gVar2 = this.d;
        } else {
            this.e.remove(hVar.f582a);
            this.d.b("REMOVE").h(32);
            this.d.b(hVar.f582a);
            gVar2 = this.d;
        }
        gVar2.h(10);
        this.d.flush();
        if (this.l > this.k || a()) {
            this.m.execute(this.n);
        }
    }

    public final synchronized void close() {
        if (this.g) {
            if (!this.h) {
                for (h hVar : (h[]) this.e.values().toArray(new h[this.e.size()])) {
                    if (hVar.f != null) {
                        hVar.f.a();
                    }
                }
                d();
                this.d.close();
                this.d = null;
                this.h = true;
                return;
            }
        }
        this.h = true;
    }

    public final synchronized void flush() {
        if (this.g) {
            c();
            d();
            this.d.flush();
        }
    }
}

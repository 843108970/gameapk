package com.b.a.a.a;

import com.b.a.a.a;
import com.b.a.a.c.d;
import com.b.a.a.c.f;
import com.b.a.aa;
import com.b.a.ab;
import com.b.a.ao;
import com.b.a.as;
import com.b.a.at;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    final long f573a;

    /* renamed from: b  reason: collision with root package name */
    final ao f574b;

    /* renamed from: c  reason: collision with root package name */
    final as f575c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l = -1;

    public e(long j2, ao aoVar, as asVar) {
        this.f573a = j2;
        this.f574b = aoVar;
        this.f575c = asVar;
        if (asVar != null) {
            this.i = asVar.h();
            this.j = asVar.i();
            aa d2 = asVar.d();
            int a2 = d2.a();
            for (int i2 = 0; i2 < a2; i2++) {
                String a3 = d2.a(i2);
                String b2 = d2.b(i2);
                if ("Date".equalsIgnoreCase(a3)) {
                    this.d = d.a(b2);
                    this.e = b2;
                } else if ("Expires".equalsIgnoreCase(a3)) {
                    this.h = d.a(b2);
                } else if ("Last-Modified".equalsIgnoreCase(a3)) {
                    this.f = d.a(b2);
                    this.g = b2;
                } else if ("ETag".equalsIgnoreCase(a3)) {
                    this.k = b2;
                } else if ("Age".equalsIgnoreCase(a3)) {
                    this.l = f.b(b2, -1);
                }
            }
        }
    }

    public final d a() {
        d dVar;
        long j2;
        d dVar2;
        String str;
        String str2;
        if (this.f575c == null) {
            dVar = new d(this.f574b, (as) null);
        } else if (this.f574b.g() && this.f575c.c() == null) {
            dVar = new d(this.f574b, (as) null);
        } else if (!d.a(this.f575c, this.f574b)) {
            dVar = new d(this.f574b, (as) null);
        } else {
            com.b.a.e f2 = this.f574b.f();
            if (!f2.a()) {
                ao aoVar = this.f574b;
                if (!((aoVar.a("If-Modified-Since") == null && aoVar.a("If-None-Match") == null) ? false : true)) {
                    long j3 = 0;
                    long max = this.d != null ? Math.max(0, this.j - this.d.getTime()) : 0;
                    if (this.l != -1) {
                        max = Math.max(max, TimeUnit.SECONDS.toMillis((long) this.l));
                    }
                    long j4 = max + (this.j - this.i) + (this.f573a - this.j);
                    com.b.a.e g2 = this.f575c.g();
                    if (g2.c() != -1) {
                        j2 = TimeUnit.SECONDS.toMillis((long) g2.c());
                    } else {
                        if (this.h != null) {
                            long time = this.h.getTime() - (this.d != null ? this.d.getTime() : this.j);
                            if (time > 0) {
                                j2 = time;
                            }
                        } else if (this.f != null && this.f575c.a().a().k() == null) {
                            long time2 = (this.d != null ? this.d.getTime() : this.i) - this.f.getTime();
                            if (time2 > 0) {
                                j2 = time2 / 10;
                            }
                        }
                        j2 = 0;
                    }
                    if (f2.c() != -1) {
                        j2 = Math.min(j2, TimeUnit.SECONDS.toMillis((long) f2.c()));
                    }
                    long millis = f2.h() != -1 ? TimeUnit.SECONDS.toMillis((long) f2.h()) : 0;
                    com.b.a.e g3 = this.f575c.g();
                    if (!g3.f() && f2.g() != -1) {
                        j3 = TimeUnit.SECONDS.toMillis((long) f2.g());
                    }
                    if (!g3.a()) {
                        long j5 = j4 + millis;
                        if (j5 < j2 + j3) {
                            at f3 = this.f575c.f();
                            if (j5 >= j2) {
                                f3.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (j4 > 86400000) {
                                if (this.f575c.g().c() == -1 && this.h == null) {
                                    f3.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                }
                            }
                            dVar2 = new d((ao) null, f3.a());
                            dVar = dVar2;
                        }
                    }
                    if (this.k != null) {
                        str2 = "If-None-Match";
                        str = this.k;
                    } else if (this.f != null) {
                        str2 = "If-Modified-Since";
                        str = this.g;
                    } else if (this.d != null) {
                        str2 = "If-Modified-Since";
                        str = this.e;
                    } else {
                        dVar = new d(this.f574b, (as) null);
                    }
                    ab b2 = this.f574b.c().b();
                    a.f566a.a(b2, str2, str);
                    dVar2 = new d(this.f574b.e().a(b2.a()).a(), this.f575c);
                    dVar = dVar2;
                }
            }
            dVar = new d(this.f574b, (as) null);
        }
        return (dVar.f571a == null || !this.f574b.f().i()) ? dVar : new d((ao) null, (as) null);
    }
}

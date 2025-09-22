package b.a.a;

import b.a.d.d;
import b.a.d.e;
import b.ac;
import b.ae;
import b.u;
import b.v;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class c {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final ac f16a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final ae f17b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f18a;

        /* renamed from: b  reason: collision with root package name */
        final ac f19b;

        /* renamed from: c  reason: collision with root package name */
        final ae f20c;
        Date d;
        String e;
        Date f;
        String g;
        Date h;
        long i;
        long j;
        String k;
        int l = -1;

        public a(long j2, ac acVar, ae aeVar) {
            this.f18a = j2;
            this.f19b = acVar;
            this.f20c = aeVar;
            if (aeVar != null) {
                this.i = aeVar.k;
                this.j = aeVar.l;
                u uVar = aeVar.f;
                int length = uVar.f350a.length / 2;
                for (int i2 = 0; i2 < length; i2++) {
                    String a2 = uVar.a(i2);
                    String b2 = uVar.b(i2);
                    if ("Date".equalsIgnoreCase(a2)) {
                        this.d = d.a(b2);
                        this.e = b2;
                    } else if ("Expires".equalsIgnoreCase(a2)) {
                        this.h = d.a(b2);
                    } else if ("Last-Modified".equalsIgnoreCase(a2)) {
                        this.f = d.a(b2);
                        this.g = b2;
                    } else if ("ETag".equalsIgnoreCase(a2)) {
                        this.k = b2;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.l = e.b(b2, -1);
                    }
                }
            }
        }

        private c a() {
            c cVar;
            long j2;
            c cVar2;
            String str;
            String str2;
            String str3;
            if (this.f20c == null) {
                cVar = new c(this.f19b, (ae) null);
            } else if (this.f19b.f247a.b() && this.f20c.e == null) {
                cVar = new c(this.f19b, (ae) null);
            } else if (!c.a(this.f20c, this.f19b)) {
                cVar = new c(this.f19b, (ae) null);
            } else {
                b.d d2 = this.f19b.d();
                if (!d2.f303c) {
                    ac acVar = this.f19b;
                    if (!((acVar.a("If-Modified-Since") == null && acVar.a("If-None-Match") == null) ? false : true)) {
                        long j3 = 0;
                        long max = this.d != null ? Math.max(0, this.j - this.d.getTime()) : 0;
                        if (this.l != -1) {
                            max = Math.max(max, TimeUnit.SECONDS.toMillis((long) this.l));
                        }
                        long j4 = max + (this.j - this.i) + (this.f18a - this.j);
                        b.d f2 = this.f20c.f();
                        if (f2.e != -1) {
                            j2 = TimeUnit.SECONDS.toMillis((long) f2.e);
                        } else {
                            if (this.h != null) {
                                long time = this.h.getTime() - (this.d != null ? this.d.getTime() : this.j);
                                if (time > 0) {
                                    j2 = time;
                                }
                            } else if (this.f != null) {
                                v vVar = this.f20c.f260a.f247a;
                                if (vVar.n == null) {
                                    str3 = null;
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    v.b(sb, vVar.n);
                                    str3 = sb.toString();
                                }
                                if (str3 == null) {
                                    long time2 = (this.d != null ? this.d.getTime() : this.i) - this.f.getTime();
                                    if (time2 > 0) {
                                        j2 = time2 / 10;
                                    }
                                }
                            }
                            j2 = 0;
                        }
                        if (d2.e != -1) {
                            j2 = Math.min(j2, TimeUnit.SECONDS.toMillis((long) d2.e));
                        }
                        long millis = d2.j != -1 ? TimeUnit.SECONDS.toMillis((long) d2.j) : 0;
                        b.d f3 = this.f20c.f();
                        if (!f3.h && d2.i != -1) {
                            j3 = TimeUnit.SECONDS.toMillis((long) d2.i);
                        }
                        if (!f3.f303c) {
                            long j5 = j4 + millis;
                            if (j5 < j2 + j3) {
                                ae.a e2 = this.f20c.e();
                                if (j5 >= j2) {
                                    e2.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                                }
                                if (j4 > 86400000) {
                                    if (this.f20c.f().e == -1 && this.h == null) {
                                        e2.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                    }
                                }
                                cVar2 = new c((ac) null, e2.a());
                                cVar = cVar2;
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
                            cVar = new c(this.f19b, (ae) null);
                        }
                        u.a b2 = this.f19b.f249c.b();
                        b.a.a.f11a.a(b2, str2, str);
                        cVar2 = new c(this.f19b.c().a(b2.a()).d(), this.f20c);
                        cVar = cVar2;
                    }
                }
                cVar = new c(this.f19b, (ae) null);
            }
            return (cVar.f16a == null || !this.f19b.d().k) ? cVar : new c((ac) null, (ae) null);
        }

        private static boolean a(ac acVar) {
            return (acVar.a("If-Modified-Since") == null && acVar.a("If-None-Match") == null) ? false : true;
        }

        private c b() {
            long j2;
            String str;
            String str2;
            String str3;
            if (this.f20c == null) {
                return new c(this.f19b, (ae) null);
            }
            if (this.f19b.f247a.b() && this.f20c.e == null) {
                return new c(this.f19b, (ae) null);
            }
            if (!c.a(this.f20c, this.f19b)) {
                return new c(this.f19b, (ae) null);
            }
            b.d d2 = this.f19b.d();
            if (!d2.f303c) {
                ac acVar = this.f19b;
                if (!((acVar.a("If-Modified-Since") == null && acVar.a("If-None-Match") == null) ? false : true)) {
                    long j3 = 0;
                    long max = this.d != null ? Math.max(0, this.j - this.d.getTime()) : 0;
                    if (this.l != -1) {
                        max = Math.max(max, TimeUnit.SECONDS.toMillis((long) this.l));
                    }
                    long j4 = max + (this.j - this.i) + (this.f18a - this.j);
                    b.d f2 = this.f20c.f();
                    if (f2.e != -1) {
                        j2 = TimeUnit.SECONDS.toMillis((long) f2.e);
                    } else {
                        if (this.h != null) {
                            long time = this.h.getTime() - (this.d != null ? this.d.getTime() : this.j);
                            if (time > 0) {
                                j2 = time;
                            }
                        } else if (this.f != null) {
                            v vVar = this.f20c.f260a.f247a;
                            if (vVar.n == null) {
                                str3 = null;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                v.b(sb, vVar.n);
                                str3 = sb.toString();
                            }
                            if (str3 == null) {
                                long time2 = (this.d != null ? this.d.getTime() : this.i) - this.f.getTime();
                                if (time2 > 0) {
                                    j2 = time2 / 10;
                                }
                            }
                        }
                        j2 = 0;
                    }
                    if (d2.e != -1) {
                        j2 = Math.min(j2, TimeUnit.SECONDS.toMillis((long) d2.e));
                    }
                    long millis = d2.j != -1 ? TimeUnit.SECONDS.toMillis((long) d2.j) : 0;
                    b.d f3 = this.f20c.f();
                    if (!f3.h && d2.i != -1) {
                        j3 = TimeUnit.SECONDS.toMillis((long) d2.i);
                    }
                    if (!f3.f303c) {
                        long j5 = j4 + millis;
                        if (j5 < j2 + j3) {
                            ae.a e2 = this.f20c.e();
                            if (j5 >= j2) {
                                e2.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (j4 > 86400000) {
                                if (this.f20c.f().e == -1 && this.h == null) {
                                    e2.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                }
                            }
                            return new c((ac) null, e2.a());
                        }
                    }
                    if (this.k != null) {
                        str2 = "If-None-Match";
                        str = this.k;
                    } else if (this.f != null) {
                        str2 = "If-Modified-Since";
                        str = this.g;
                    } else if (this.d == null) {
                        return new c(this.f19b, (ae) null);
                    } else {
                        str2 = "If-Modified-Since";
                        str = this.e;
                    }
                    u.a b2 = this.f19b.f249c.b();
                    b.a.a.f11a.a(b2, str2, str);
                    return new c(this.f19b.c().a(b2.a()).d(), this.f20c);
                }
            }
            return new c(this.f19b, (ae) null);
        }

        private long c() {
            String str;
            b.d f2 = this.f20c.f();
            if (f2.e != -1) {
                return TimeUnit.SECONDS.toMillis((long) f2.e);
            }
            if (this.h != null) {
                long time = this.h.getTime() - (this.d != null ? this.d.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0;
            }
            if (this.f != null) {
                v vVar = this.f20c.f260a.f247a;
                if (vVar.n == null) {
                    str = null;
                } else {
                    StringBuilder sb = new StringBuilder();
                    v.b(sb, vVar.n);
                    str = sb.toString();
                }
                if (str == null) {
                    long time2 = (this.d != null ? this.d.getTime() : this.i) - this.f.getTime();
                    if (time2 > 0) {
                        return time2 / 10;
                    }
                }
            }
            return 0;
        }

        private long d() {
            long j2 = 0;
            if (this.d != null) {
                j2 = Math.max(0, this.j - this.d.getTime());
            }
            if (this.l != -1) {
                j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) this.l));
            }
            long j3 = this.j - this.i;
            return j2 + j3 + (this.f18a - this.j);
        }

        private boolean e() {
            return this.f20c.f().e == -1 && this.h == null;
        }
    }

    c(ac acVar, ae aeVar) {
        this.f16a = acVar;
        this.f17b = aeVar;
    }

    public static boolean a(ae aeVar, ac acVar) {
        switch (aeVar.f262c) {
            case 200:
            case SET_BOTTON_VALUE:
            case SET_RADIO_GROUP_VALUE:
            case 300:
            case SET_ENABLED_VALUE:
            case 308:
            case GET_TEXT_VALUE:
            case GET_BACKCOLOR_VALUE:
            case GET_FW_VISIBLE_VALUE:
            case 414:
            case SET_WINDOW_GRAVITY_VALUE:
                break;
            case SET_VISIBLE_VALUE:
            case 307:
                if (aeVar.a("Expires") == null && aeVar.f().e == -1 && !aeVar.f().g && !aeVar.f().f) {
                    return false;
                }
            default:
                return false;
        }
        return !aeVar.f().d && !acVar.d().d;
    }
}

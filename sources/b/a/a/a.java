package b.a.a;

import b.a.c;
import b.a.d.h;
import b.ae;
import b.u;
import b.w;
import c.d;
import c.e;
import c.p;
import c.x;
import c.y;
import c.z;
import com.github.kevinsawicki.http.HttpRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class a implements w {

    /* renamed from: a  reason: collision with root package name */
    final f f12a;

    public a(f fVar) {
        this.f12a = fVar;
    }

    private ae a(final b bVar, ae aeVar) throws IOException {
        x b2;
        if (bVar == null || (b2 = bVar.b()) == null) {
            return aeVar;
        }
        final e source = aeVar.g.source();
        final d a2 = p.a(b2);
        AnonymousClass1 r2 = new y() {

            /* renamed from: a  reason: collision with root package name */
            boolean f13a;

            public final void close() throws IOException {
                if (!this.f13a && !c.a((y) this, TimeUnit.MILLISECONDS)) {
                    this.f13a = true;
                    r3.a();
                }
                r5.close();
            }

            public final long read(c.c cVar, long j) throws IOException {
                try {
                    long read = r5.read(cVar, j);
                    if (read == -1) {
                        if (!this.f13a) {
                            this.f13a = true;
                            r4.close();
                        }
                        return -1;
                    }
                    cVar.a(r4.a(), cVar.f387c - read, read);
                    r4.y();
                    return read;
                } catch (IOException e2) {
                    if (!this.f13a) {
                        this.f13a = true;
                        r3.a();
                    }
                    throw e2;
                }
            }

            public final z timeout() {
                return r5.timeout();
            }
        };
        ae.a e = aeVar.e();
        e.g = new h(aeVar.f, p.a((y) r2));
        return e.a();
    }

    private static ae a(ae aeVar) {
        if (aeVar == null || aeVar.g == null) {
            return aeVar;
        }
        ae.a e = aeVar.e();
        e.g = null;
        return e.a();
    }

    private static u a(u uVar, u uVar2) {
        u.a aVar = new u.a();
        int length = uVar.f350a.length / 2;
        for (int i = 0; i < length; i++) {
            String a2 = uVar.a(i);
            String b2 = uVar.b(i);
            if ((!"Warning".equalsIgnoreCase(a2) || !b2.startsWith("1")) && (!a(a2) || uVar2.a(a2) == null)) {
                b.a.a.f11a.a(aVar, a2, b2);
            }
        }
        int length2 = uVar2.f350a.length / 2;
        for (int i2 = 0; i2 < length2; i2++) {
            String a3 = uVar2.a(i2);
            if (!"Content-Length".equalsIgnoreCase(a3) && a(a3)) {
                b.a.a.f11a.a(aVar, a3, uVar2.b(i2));
            }
        }
        return aVar.a();
    }

    private static boolean a(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !HttpRequest.HEADER_PROXY_AUTHORIZATION.equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [b.ac, b.ae] */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r5v23 */
    /* JADX WARNING: type inference failed for: r5v24 */
    /* JADX WARNING: type inference failed for: r5v28 */
    /* JADX WARNING: type inference failed for: r5v56 */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x022c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x026b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final b.ae intercept(b.w.a r25) throws java.io.IOException {
        /*
            r24 = this;
            r1 = r24
            b.a.a.f r2 = r1.f12a
            r3 = 0
            if (r2 == 0) goto L_0x0012
            b.a.a.f r2 = r1.f12a
            b.ac r4 = r25.a()
            b.ae r2 = r2.a((b.ac) r4)
            goto L_0x0013
        L_0x0012:
            r2 = r3
        L_0x0013:
            long r4 = java.lang.System.currentTimeMillis()
            b.a.a.c$a r6 = new b.a.a.c$a
            b.ac r7 = r25.a()
            r6.<init>(r4, r7, r2)
            b.ae r4 = r6.f20c
            if (r4 != 0) goto L_0x002e
            b.a.a.c r4 = new b.a.a.c
            b.ac r5 = r6.f19b
            r4.<init>(r5, r3)
        L_0x002b:
            r5 = r3
            goto L_0x0201
        L_0x002e:
            b.ac r4 = r6.f19b
            b.v r4 = r4.f247a
            boolean r4 = r4.b()
            if (r4 == 0) goto L_0x0046
            b.ae r4 = r6.f20c
            b.t r4 = r4.e
            if (r4 != 0) goto L_0x0046
            b.a.a.c r4 = new b.a.a.c
            b.ac r5 = r6.f19b
            r4.<init>(r5, r3)
            goto L_0x002b
        L_0x0046:
            b.ae r4 = r6.f20c
            b.ac r5 = r6.f19b
            boolean r4 = b.a.a.c.a(r4, r5)
            if (r4 != 0) goto L_0x0058
            b.a.a.c r4 = new b.a.a.c
            b.ac r5 = r6.f19b
            r4.<init>(r5, r3)
            goto L_0x002b
        L_0x0058:
            b.ac r4 = r6.f19b
            b.d r4 = r4.d()
            boolean r5 = r4.f303c
            if (r5 != 0) goto L_0x01f9
            b.ac r5 = r6.f19b
            java.lang.String r7 = "If-Modified-Since"
            java.lang.String r7 = r5.a(r7)
            if (r7 != 0) goto L_0x0077
            java.lang.String r7 = "If-None-Match"
            java.lang.String r5 = r5.a(r7)
            if (r5 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r5 = 0
            goto L_0x0078
        L_0x0077:
            r5 = 1
        L_0x0078:
            if (r5 == 0) goto L_0x007c
            goto L_0x01f9
        L_0x007c:
            java.util.Date r5 = r6.d
            r10 = 0
            if (r5 == 0) goto L_0x0091
            long r12 = r6.j
            java.util.Date r5 = r6.d
            long r14 = r5.getTime()
            long r8 = r12 - r14
            long r7 = java.lang.Math.max(r10, r8)
            goto L_0x0092
        L_0x0091:
            r7 = r10
        L_0x0092:
            int r5 = r6.l
            r9 = -1
            if (r5 == r9) goto L_0x00a4
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            int r12 = r6.l
            long r12 = (long) r12
            long r12 = r5.toMillis(r12)
            long r7 = java.lang.Math.max(r7, r12)
        L_0x00a4:
            long r12 = r6.j
            long r14 = r6.i
            long r17 = r12 - r14
            long r12 = r6.f18a
            long r14 = r6.j
            long r19 = r12 - r14
            long r12 = r7 + r17
            long r7 = r12 + r19
            b.ae r5 = r6.f20c
            b.d r5 = r5.f()
            int r12 = r5.e
            if (r12 == r9) goto L_0x00c8
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.SECONDS
            int r5 = r5.e
            long r13 = (long) r5
            long r12 = r12.toMillis(r13)
            goto L_0x0127
        L_0x00c8:
            java.util.Date r5 = r6.h
            if (r5 == 0) goto L_0x00e8
            java.util.Date r5 = r6.d
            if (r5 == 0) goto L_0x00d7
            java.util.Date r5 = r6.d
            long r12 = r5.getTime()
            goto L_0x00d9
        L_0x00d7:
            long r12 = r6.j
        L_0x00d9:
            java.util.Date r5 = r6.h
            long r14 = r5.getTime()
            long r17 = r14 - r12
            int r5 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x0126
            r12 = r17
            goto L_0x0127
        L_0x00e8:
            java.util.Date r5 = r6.f
            if (r5 == 0) goto L_0x0126
            b.ae r5 = r6.f20c
            b.ac r5 = r5.f260a
            b.v r5 = r5.f247a
            java.util.List<java.lang.String> r12 = r5.n
            if (r12 != 0) goto L_0x00f8
            r5 = r3
            goto L_0x0106
        L_0x00f8:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.util.List<java.lang.String> r5 = r5.n
            b.v.b(r12, r5)
            java.lang.String r5 = r12.toString()
        L_0x0106:
            if (r5 != 0) goto L_0x0126
            java.util.Date r5 = r6.d
            if (r5 == 0) goto L_0x0113
            java.util.Date r5 = r6.d
            long r12 = r5.getTime()
            goto L_0x0115
        L_0x0113:
            long r12 = r6.i
        L_0x0115:
            java.util.Date r5 = r6.f
            long r14 = r5.getTime()
            long r17 = r12 - r14
            int r5 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x0126
            r12 = 10
            long r12 = r17 / r12
            goto L_0x0127
        L_0x0126:
            r12 = r10
        L_0x0127:
            int r5 = r4.e
            if (r5 == r9) goto L_0x0138
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            int r14 = r4.e
            long r14 = (long) r14
            long r14 = r5.toMillis(r14)
            long r12 = java.lang.Math.min(r12, r14)
        L_0x0138:
            int r5 = r4.j
            if (r5 == r9) goto L_0x0146
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            int r14 = r4.j
            long r14 = (long) r14
            long r14 = r5.toMillis(r14)
            goto L_0x0147
        L_0x0146:
            r14 = r10
        L_0x0147:
            b.ae r5 = r6.f20c
            b.d r5 = r5.f()
            boolean r10 = r5.h
            if (r10 != 0) goto L_0x0161
            int r10 = r4.i
            if (r10 == r9) goto L_0x0161
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.SECONDS
            int r4 = r4.i
            long r3 = (long) r4
            long r10 = r10.toMillis(r3)
            r21 = r10
            goto L_0x0163
        L_0x0161:
            r21 = 0
        L_0x0163:
            boolean r3 = r5.f303c
            if (r3 != 0) goto L_0x01ae
            long r3 = r7 + r14
            long r10 = r12 + r21
            int r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x01ae
            b.ae r5 = r6.f20c
            b.ae$a r5 = r5.e()
            int r10 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r10 < 0) goto L_0x0180
            java.lang.String r3 = "Warning"
            java.lang.String r4 = "110 HttpURLConnection \"Response is stale\""
            r5.a((java.lang.String) r3, (java.lang.String) r4)
        L_0x0180:
            r3 = 86400000(0x5265c00, double:4.2687272E-316)
            int r10 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r10 <= 0) goto L_0x01a3
            b.ae r3 = r6.f20c
            b.d r3 = r3.f()
            int r3 = r3.e
            if (r3 != r9) goto L_0x0198
            java.util.Date r3 = r6.h
            if (r3 != 0) goto L_0x0198
            r16 = 1
            goto L_0x019a
        L_0x0198:
            r16 = 0
        L_0x019a:
            if (r16 == 0) goto L_0x01a3
            java.lang.String r3 = "Warning"
            java.lang.String r4 = "113 HttpURLConnection \"Heuristic expiration\""
            r5.a((java.lang.String) r3, (java.lang.String) r4)
        L_0x01a3:
            b.a.a.c r4 = new b.a.a.c
            b.ae r3 = r5.a()
            r5 = 0
            r4.<init>(r5, r3)
            goto L_0x0201
        L_0x01ae:
            java.lang.String r3 = r6.k
            if (r3 == 0) goto L_0x01b7
            java.lang.String r3 = "If-None-Match"
            java.lang.String r4 = r6.k
            goto L_0x01c8
        L_0x01b7:
            java.util.Date r3 = r6.f
            if (r3 == 0) goto L_0x01c0
            java.lang.String r3 = "If-Modified-Since"
            java.lang.String r4 = r6.g
            goto L_0x01c8
        L_0x01c0:
            java.util.Date r3 = r6.d
            if (r3 == 0) goto L_0x01f0
            java.lang.String r3 = "If-Modified-Since"
            java.lang.String r4 = r6.e
        L_0x01c8:
            b.ac r5 = r6.f19b
            b.u r5 = r5.f249c
            b.u$a r5 = r5.b()
            b.a.a r7 = b.a.a.f11a
            r7.a((b.u.a) r5, (java.lang.String) r3, (java.lang.String) r4)
            b.ac r3 = r6.f19b
            b.ac$a r3 = r3.c()
            b.u r4 = r5.a()
            b.ac$a r3 = r3.a((b.u) r4)
            b.ac r3 = r3.d()
            b.a.a.c r4 = new b.a.a.c
            b.ae r5 = r6.f20c
            r4.<init>(r3, r5)
            r5 = 0
            goto L_0x0201
        L_0x01f0:
            b.a.a.c r4 = new b.a.a.c
            b.ac r3 = r6.f19b
            r5 = 0
            r4.<init>(r3, r5)
            goto L_0x0201
        L_0x01f9:
            r5 = r3
            b.a.a.c r4 = new b.a.a.c
            b.ac r3 = r6.f19b
            r4.<init>(r3, r5)
        L_0x0201:
            b.ac r3 = r4.f16a
            if (r3 == 0) goto L_0x0214
            b.ac r3 = r6.f19b
            b.d r3 = r3.d()
            boolean r3 = r3.k
            if (r3 == 0) goto L_0x0214
            b.a.a.c r4 = new b.a.a.c
            r4.<init>(r5, r5)
        L_0x0214:
            b.ac r3 = r4.f16a
            b.ae r5 = r4.f17b
            b.a.a.f r6 = r1.f12a
            if (r6 == 0) goto L_0x0221
            b.a.a.f r6 = r1.f12a
            r6.a((b.a.a.c) r4)
        L_0x0221:
            if (r2 == 0) goto L_0x022a
            if (r5 != 0) goto L_0x022a
            b.af r4 = r2.g
            b.a.c.a((java.io.Closeable) r4)
        L_0x022a:
            if (r3 != 0) goto L_0x0258
            if (r5 != 0) goto L_0x0258
            b.ae$a r2 = new b.ae$a
            r2.<init>()
            b.ac r3 = r25.a()
            r2.f263a = r3
            b.aa r3 = b.aa.HTTP_1_1
            r2.f264b = r3
            r3 = 504(0x1f8, float:7.06E-43)
            r2.f265c = r3
            java.lang.String r3 = "Unsatisfiable Request (only-if-cached)"
            r2.d = r3
            b.af r3 = b.a.c.f53c
            r2.g = r3
            r3 = -1
            r2.k = r3
            long r3 = java.lang.System.currentTimeMillis()
            r2.l = r3
            b.ae r2 = r2.a()
            return r2
        L_0x0258:
            if (r3 != 0) goto L_0x026b
            b.ae$a r2 = r5.e()
            b.ae r3 = a((b.ae) r5)
            b.ae$a r2 = r2.b((b.ae) r3)
            b.ae r2 = r2.a()
            return r2
        L_0x026b:
            r4 = r25
            b.ae r4 = r4.a(r3)     // Catch:{ all -> 0x032e }
            if (r4 != 0) goto L_0x027a
            if (r2 == 0) goto L_0x027a
            b.af r2 = r2.g
            b.a.c.a((java.io.Closeable) r2)
        L_0x027a:
            if (r5 == 0) goto L_0x02c3
            int r2 = r4.f262c
            r6 = 304(0x130, float:4.26E-43)
            if (r2 != r6) goto L_0x02be
            b.ae$a r2 = r5.e()
            b.u r3 = r5.f
            b.u r6 = r4.f
            b.u r3 = a((b.u) r3, (b.u) r6)
            b.ae$a r2 = r2.a((b.u) r3)
            long r6 = r4.k
            r2.k = r6
            long r6 = r4.l
            r2.l = r6
            b.ae r3 = a((b.ae) r5)
            b.ae$a r2 = r2.b((b.ae) r3)
            b.ae r3 = a((b.ae) r4)
            b.ae$a r2 = r2.a((b.ae) r3)
            b.ae r2 = r2.a()
            b.af r3 = r4.g
            r3.close()
            b.a.a.f r3 = r1.f12a
            r3.a()
            b.a.a.f r3 = r1.f12a
            r3.a(r5, r2)
            return r2
        L_0x02be:
            b.af r2 = r5.g
            b.a.c.a((java.io.Closeable) r2)
        L_0x02c3:
            b.ae$a r2 = r4.e()
            b.ae r5 = a((b.ae) r5)
            b.ae$a r2 = r2.b((b.ae) r5)
            b.ae r4 = a((b.ae) r4)
            b.ae$a r2 = r2.a((b.ae) r4)
            b.ae r2 = r2.a()
            b.a.a.f r4 = r1.f12a
            if (r4 == 0) goto L_0x032d
            boolean r4 = b.a.d.e.d(r2)
            if (r4 == 0) goto L_0x0320
            boolean r4 = b.a.a.c.a(r2, r3)
            if (r4 == 0) goto L_0x0320
            b.a.a.f r3 = r1.f12a
            b.a.a.b r3 = r3.a((b.ae) r2)
            if (r3 != 0) goto L_0x02f4
            return r2
        L_0x02f4:
            c.x r4 = r3.b()
            if (r4 != 0) goto L_0x02fb
            return r2
        L_0x02fb:
            b.af r5 = r2.g
            c.e r5 = r5.source()
            c.d r4 = c.p.a((c.x) r4)
            b.a.a.a$1 r6 = new b.a.a.a$1
            r6.<init>(r5, r3, r4)
            b.ae$a r3 = r2.e()
            b.a.d.h r4 = new b.a.d.h
            b.u r2 = r2.f
            c.e r5 = c.p.a((c.y) r6)
            r4.<init>(r2, r5)
            r3.g = r4
            b.ae r2 = r3.a()
            return r2
        L_0x0320:
            java.lang.String r4 = r3.f248b
            boolean r4 = b.a.d.f.a(r4)
            if (r4 == 0) goto L_0x032d
            b.a.a.f r4 = r1.f12a     // Catch:{ IOException -> 0x032d }
            r4.b(r3)     // Catch:{ IOException -> 0x032d }
        L_0x032d:
            return r2
        L_0x032e:
            r0 = move-exception
            if (r2 == 0) goto L_0x0336
            b.af r2 = r2.g
            b.a.c.a((java.io.Closeable) r2)
        L_0x0336:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.a.intercept(b.w$a):b.ae");
    }
}

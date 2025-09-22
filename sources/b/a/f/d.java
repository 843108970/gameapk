package b.a.f;

import android.support.v7.widget.ActivityChooserView;
import b.a.f.k;
import c.c;
import c.e;
import c.f;
import c.p;
import c.y;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.github.kevinsawicki.http.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class d {

    /* renamed from: a  reason: collision with root package name */
    static final c[] f107a = {new c(c.f, ""), new c(c.f106c, (String) HttpRequest.METHOD_GET), new c(c.f106c, "POST"), new c(c.d, "/"), new c(c.d, "/index.html"), new c(c.e, "http"), new c(c.e, "https"), new c(c.f105b, "200"), new c(c.f105b, "204"), new c(c.f105b, "206"), new c(c.f105b, "304"), new c(c.f105b, "400"), new c(c.f105b, "404"), new c(c.f105b, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c((String) RequestParameters.SUBRESOURCE_LOCATION, ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c((String) RequestParameters.SUBRESOURCE_REFERER, ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};

    /* renamed from: b  reason: collision with root package name */
    static final Map<f, Integer> f108b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f109c = 15;
    private static final int d = 31;
    private static final int e = 63;
    private static final int f = 127;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<c> f110a;

        /* renamed from: b  reason: collision with root package name */
        final e f111b;

        /* renamed from: c  reason: collision with root package name */
        final int f112c;
        int d;
        c[] e;
        int f;
        int g;
        int h;

        a(y yVar) {
            this(yVar, (byte) 0);
        }

        private a(y yVar, byte b2) {
            this.f110a = new ArrayList();
            this.e = new c[8];
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
            this.f112c = 4096;
            this.d = 4096;
            this.f111b = p.a(yVar);
        }

        private int c() {
            return this.d;
        }

        static boolean c(int i) {
            return i >= 0 && i <= d.f107a.length - 1;
        }

        private int d(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.e.length;
                while (true) {
                    length--;
                    if (length < this.f || i <= 0) {
                        System.arraycopy(this.e, this.f + 1, this.e, this.f + 1 + i2, this.g);
                        this.f += i2;
                    } else {
                        i -= this.e[length].i;
                        this.h -= this.e[length].i;
                        this.g--;
                        i2++;
                    }
                }
                System.arraycopy(this.e, this.f + 1, this.e, this.f + 1 + i2, this.g);
                this.f += i2;
            }
            return i2;
        }

        private void d() {
            Arrays.fill(this.e, (Object) null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        private void e() throws IOException {
            c cVar;
            List<c> list;
            c cVar2;
            while (!this.f111b.d()) {
                byte g2 = this.f111b.g() & 255;
                if (g2 == 128) {
                    throw new IOException("index == 0");
                } else if ((g2 & 128) == 128) {
                    int a2 = a(g2, d.f) - 1;
                    if (c(a2)) {
                        this.f110a.add(d.f107a[a2]);
                    } else {
                        int a3 = a(a2 - d.f107a.length);
                        if (a3 < 0 || a3 > this.e.length - 1) {
                            throw new IOException("Header index too large " + (a2 + 1));
                        }
                        this.f110a.add(this.e[a3]);
                    }
                } else {
                    if (g2 == 64) {
                        cVar2 = new c(d.a(b()), b());
                    } else if ((g2 & 64) == 64) {
                        cVar2 = new c(b(a(g2, 63) - 1), b());
                    } else if ((g2 & 32) == 32) {
                        this.d = a(g2, 31);
                        if (this.d < 0 || this.d > this.f112c) {
                            throw new IOException("Invalid dynamic table size update " + this.d);
                        }
                        a();
                    } else {
                        if (g2 == 16 || g2 == 0) {
                            f a4 = d.a(b());
                            f b2 = b();
                            list = this.f110a;
                            cVar = new c(a4, b2);
                        } else {
                            f b3 = b(a(g2, 15) - 1);
                            f b4 = b();
                            list = this.f110a;
                            cVar = new c(b3, b4);
                        }
                        list.add(cVar);
                    }
                    a(cVar2);
                }
            }
        }

        private void e(int i) throws IOException {
            if (c(i)) {
                this.f110a.add(d.f107a[i]);
                return;
            }
            int a2 = a(i - d.f107a.length);
            if (a2 < 0 || a2 > this.e.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.f110a.add(this.e[a2]);
        }

        private List<c> f() {
            ArrayList arrayList = new ArrayList(this.f110a);
            this.f110a.clear();
            return arrayList;
        }

        private void f(int i) throws IOException {
            this.f110a.add(new c(b(i), b()));
        }

        private void g() throws IOException {
            this.f110a.add(new c(d.a(b()), b()));
        }

        private void g(int i) throws IOException {
            a(new c(b(i), b()));
        }

        private void h() throws IOException {
            a(new c(d.a(b()), b()));
        }

        private int i() throws IOException {
            return this.f111b.g() & 255;
        }

        /* access modifiers changed from: package-private */
        public final int a(int i) {
            return this.f + 1 + i;
        }

        /* access modifiers changed from: package-private */
        public final int a(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = i();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & d.f) << i4;
                i4 += 7;
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (this.d >= this.h) {
                return;
            }
            if (this.d == 0) {
                d();
            } else {
                d(this.h - this.d);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(c cVar) {
            this.f110a.add(cVar);
            int i = cVar.i;
            if (i > this.d) {
                d();
                return;
            }
            d((this.h + i) - this.d);
            if (this.g + 1 > this.e.length) {
                c[] cVarArr = new c[(this.e.length * 2)];
                System.arraycopy(this.e, 0, cVarArr, this.e.length, this.e.length);
                this.f = this.e.length - 1;
                this.e = cVarArr;
            }
            int i2 = this.f;
            this.f = i2 - 1;
            this.e[i2] = cVar;
            this.g++;
            this.h += i;
        }

        /* access modifiers changed from: package-private */
        public final f b() throws IOException {
            int i = i();
            boolean z = (i & 128) == 128;
            int a2 = a(i, d.f);
            if (!z) {
                return this.f111b.d((long) a2);
            }
            k a3 = k.a();
            byte[] g2 = this.f111b.g((long) a2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            k.a aVar = a3.f170a;
            byte b2 = 0;
            int i2 = 0;
            for (byte b3 : g2) {
                b2 = (b2 << 8) | (b3 & 255);
                i2 += 8;
                while (i2 >= 8) {
                    aVar = aVar.f171a[(b2 >>> (i2 - 8)) & 255];
                    if (aVar.f171a == null) {
                        byteArrayOutputStream.write(aVar.f172b);
                        i2 -= aVar.f173c;
                        aVar = a3.f170a;
                    } else {
                        i2 -= 8;
                    }
                }
            }
            while (i2 > 0) {
                k.a aVar2 = aVar.f171a[(b2 << (8 - i2)) & 255];
                if (aVar2.f171a != null || aVar2.f173c > i2) {
                    break;
                }
                byteArrayOutputStream.write(aVar2.f172b);
                i2 -= aVar2.f173c;
                aVar = a3.f170a;
            }
            return f.of(byteArrayOutputStream.toByteArray());
        }

        /* access modifiers changed from: package-private */
        public final f b(int i) {
            return (c(i) ? d.f107a[i] : this.e[a(i - d.f107a.length)]).g;
        }
    }

    static final class b {
        private static final int g = 4096;
        private static final int h = 16384;

        /* renamed from: a  reason: collision with root package name */
        int f113a;

        /* renamed from: b  reason: collision with root package name */
        int f114b;

        /* renamed from: c  reason: collision with root package name */
        c[] f115c;
        int d;
        int e;
        int f;
        private final c i;
        private final boolean j;
        private int k;
        private boolean l;

        b(c cVar) {
            this(cVar, (byte) 0);
        }

        private b(c cVar, byte b2) {
            this.k = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.f115c = new c[8];
            this.d = this.f115c.length - 1;
            this.e = 0;
            this.f = 0;
            this.f113a = 4096;
            this.f114b = 4096;
            this.j = true;
            this.i = cVar;
        }

        private void a() {
            Arrays.fill(this.f115c, (Object) null);
            this.d = this.f115c.length - 1;
            this.e = 0;
            this.f = 0;
        }

        private void a(int i2, int i3, int i4) {
            int i5;
            c cVar;
            if (i2 < i3) {
                cVar = this.i;
                i5 = i2 | i4;
            } else {
                this.i.l(i4 | i3);
                i5 = i2 - i3;
                while (i5 >= 128) {
                    this.i.l(128 | (i5 & d.f));
                    i5 >>>= 7;
                }
                cVar = this.i;
            }
            cVar.l(i5);
        }

        private void a(c cVar) {
            int i2 = cVar.i;
            if (i2 > this.f114b) {
                a();
                return;
            }
            b((this.f + i2) - this.f114b);
            if (this.e + 1 > this.f115c.length) {
                c[] cVarArr = new c[(this.f115c.length * 2)];
                System.arraycopy(this.f115c, 0, cVarArr, this.f115c.length, this.f115c.length);
                this.d = this.f115c.length - 1;
                this.f115c = cVarArr;
            }
            int i3 = this.d;
            this.d = i3 - 1;
            this.f115c[i3] = cVar;
            this.e++;
            this.f += i2;
        }

        private void a(f fVar) throws IOException {
            int size;
            int i2;
            if (this.j) {
                k.a();
                if (k.a(fVar) < fVar.size()) {
                    c cVar = new c();
                    k.a();
                    k.a(fVar, cVar);
                    fVar = cVar.p();
                    size = fVar.size();
                    i2 = 128;
                    a(size, d.f, i2);
                    this.i.e(fVar);
                }
            }
            size = fVar.size();
            i2 = 0;
            a(size, d.f, i2);
            this.i.e(fVar);
        }

        private int b(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f115c.length;
                while (true) {
                    length--;
                    if (length < this.d || i2 <= 0) {
                        System.arraycopy(this.f115c, this.d + 1, this.f115c, this.d + 1 + i3, this.e);
                        Arrays.fill(this.f115c, this.d + 1, this.d + 1 + i3, (Object) null);
                        this.d += i3;
                    } else {
                        i2 -= this.f115c[length].i;
                        this.f -= this.f115c[length].i;
                        this.e--;
                        i3++;
                    }
                }
                System.arraycopy(this.f115c, this.d + 1, this.f115c, this.d + 1 + i3, this.e);
                Arrays.fill(this.f115c, this.d + 1, this.d + 1 + i3, (Object) null);
                this.d += i3;
            }
            return i3;
        }

        private void b() {
            if (this.f114b >= this.f) {
                return;
            }
            if (this.f114b == 0) {
                a();
            } else {
                b(this.f - this.f114b);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            this.f113a = i2;
            int min = Math.min(i2, 16384);
            if (this.f114b != min) {
                if (min < this.f114b) {
                    this.k = Math.min(this.k, min);
                }
                this.l = true;
                this.f114b = min;
                if (this.f114b >= this.f) {
                    return;
                }
                if (this.f114b == 0) {
                    a();
                } else {
                    b(this.f - this.f114b);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(List<c> list) throws IOException {
            int i2;
            int i3;
            if (this.l) {
                if (this.k < this.f114b) {
                    a(this.k, 31, 32);
                }
                this.l = false;
                this.k = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                a(this.f114b, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                c cVar = list.get(i4);
                f asciiLowercase = cVar.g.toAsciiLowercase();
                f fVar = cVar.h;
                Integer num = d.f108b.get(asciiLowercase);
                if (num != null) {
                    i3 = num.intValue() + 1;
                    if (i3 > 1 && i3 < 8) {
                        if (b.a.c.a((Object) d.f107a[i3 - 1].h, (Object) fVar)) {
                            i2 = i3;
                        } else if (b.a.c.a((Object) d.f107a[i3].h, (Object) fVar)) {
                            i2 = i3;
                            i3++;
                        }
                    }
                    i2 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                if (i3 == -1) {
                    int i5 = this.d + 1;
                    int length = this.f115c.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (b.a.c.a((Object) this.f115c[i5].g, (Object) asciiLowercase)) {
                            if (b.a.c.a((Object) this.f115c[i5].h, (Object) fVar)) {
                                i3 = d.f107a.length + (i5 - this.d);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.d) + d.f107a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i3 != -1) {
                    a(i3, d.f, 128);
                } else {
                    if (i2 == -1) {
                        this.i.l(64);
                        a(asciiLowercase);
                    } else if (!asciiLowercase.startsWith(c.f104a) || c.f.equals(asciiLowercase)) {
                        a(i2, 63, 64);
                    } else {
                        a(i2, 15, 0);
                        a(fVar);
                    }
                    a(fVar);
                    a(cVar);
                }
            }
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f107a.length);
        for (int i = 0; i < f107a.length; i++) {
            if (!linkedHashMap.containsKey(f107a[i].g)) {
                linkedHashMap.put(f107a[i].g, Integer.valueOf(i));
            }
        }
        f108b = Collections.unmodifiableMap(linkedHashMap);
    }

    private d() {
    }

    static f a(f fVar) throws IOException {
        int size = fVar.size();
        int i = 0;
        while (i < size) {
            byte b2 = fVar.getByte(i);
            if (b2 < 65 || b2 > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.utf8());
            }
        }
        return fVar;
    }

    private static Map<f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f107a.length);
        for (int i = 0; i < f107a.length; i++) {
            if (!linkedHashMap.containsKey(f107a[i].g)) {
                linkedHashMap.put(f107a[i].g, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }
}

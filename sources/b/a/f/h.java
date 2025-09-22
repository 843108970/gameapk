package b.a.f;

import android.support.v7.widget.ActivityChooserView;
import b.a.f.d;
import c.c;
import c.e;
import c.f;
import c.y;
import c.z;
import com.umeng.commonsdk.proguard.bg;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class h implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f149a = Logger.getLogger(e.class.getName());

    /* renamed from: b  reason: collision with root package name */
    final e f150b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f151c;
    final d.a d = new d.a(this.e);
    private final a e = new a(this.f150b);

    static final class a implements y {

        /* renamed from: a  reason: collision with root package name */
        int f152a;

        /* renamed from: b  reason: collision with root package name */
        byte f153b;

        /* renamed from: c  reason: collision with root package name */
        int f154c;
        int d;
        short e;
        private final e f;

        a(e eVar) {
            this.f = eVar;
        }

        private void a() throws IOException {
            int i = this.f154c;
            int a2 = h.a(this.f);
            this.d = a2;
            this.f152a = a2;
            byte g = (byte) (this.f.g() & 255);
            this.f153b = (byte) (this.f.g() & 255);
            if (h.f149a.isLoggable(Level.FINE)) {
                h.f149a.fine(e.a(true, this.f154c, this.f152a, g, this.f153b));
            }
            this.f154c = this.f.i() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (g != 9) {
                throw e.b("%s != TYPE_CONTINUATION", Byte.valueOf(g));
            } else if (this.f154c != i) {
                throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public final void close() throws IOException {
        }

        public final long read(c cVar, long j) throws IOException {
            while (this.d == 0) {
                this.f.h((long) this.e);
                this.e = 0;
                if ((this.f153b & 4) != 0) {
                    return -1;
                }
                int i = this.f154c;
                int a2 = h.a(this.f);
                this.d = a2;
                this.f152a = a2;
                byte g = (byte) (this.f.g() & 255);
                this.f153b = (byte) (this.f.g() & 255);
                if (h.f149a.isLoggable(Level.FINE)) {
                    h.f149a.fine(e.a(true, this.f154c, this.f152a, g, this.f153b));
                }
                this.f154c = this.f.i() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                if (g != 9) {
                    throw e.b("%s != TYPE_CONTINUATION", Byte.valueOf(g));
                } else if (this.f154c != i) {
                    throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
                }
            }
            long read = this.f.read(cVar, Math.min(j, (long) this.d));
            if (read == -1) {
                return -1;
            }
            this.d = (int) (((long) this.d) - read);
            return read;
        }

        public final z timeout() {
            return this.f.timeout();
        }
    }

    interface b {
        void a();

        void a(int i, long j);

        void a(int i, b bVar);

        void a(int i, f fVar);

        void a(int i, List<c> list) throws IOException;

        void a(n nVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, e eVar, int i2) throws IOException;

        void a(boolean z, int i, List<c> list);

        void c();

        void d();
    }

    h(e eVar, boolean z) {
        this.f150b = eVar;
        this.f151c = z;
    }

    private static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    static int a(e eVar) throws IOException {
        return (eVar.g() & 255) | ((eVar.g() & 255) << bg.n) | ((eVar.g() & 255) << 8);
    }

    private List<c> a(int i, short s, byte b2, int i2) throws IOException {
        List<c> list;
        c cVar;
        c cVar2;
        a aVar = this.e;
        this.e.d = i;
        aVar.f152a = i;
        this.e.e = s;
        this.e.f153b = b2;
        this.e.f154c = i2;
        d.a aVar2 = this.d;
        while (!aVar2.f111b.d()) {
            byte g = aVar2.f111b.g() & 255;
            if (g == 128) {
                throw new IOException("index == 0");
            } else if ((g & 128) == 128) {
                int a2 = aVar2.a(g, 127) - 1;
                if (d.a.c(a2)) {
                    aVar2.f110a.add(d.f107a[a2]);
                } else {
                    int a3 = aVar2.a(a2 - d.f107a.length);
                    if (a3 < 0 || a3 > aVar2.e.length - 1) {
                        throw new IOException("Header index too large " + (a2 + 1));
                    }
                    aVar2.f110a.add(aVar2.e[a3]);
                }
            } else {
                if (g == 64) {
                    cVar2 = new c(d.a(aVar2.b()), aVar2.b());
                } else if ((g & 64) == 64) {
                    cVar2 = new c(aVar2.b(aVar2.a(g, 63) - 1), aVar2.b());
                } else if ((g & 32) == 32) {
                    aVar2.d = aVar2.a(g, 31);
                    if (aVar2.d < 0 || aVar2.d > aVar2.f112c) {
                        throw new IOException("Invalid dynamic table size update " + aVar2.d);
                    }
                    aVar2.a();
                } else {
                    if (g == 16 || g == 0) {
                        f a4 = d.a(aVar2.b());
                        f b3 = aVar2.b();
                        list = aVar2.f110a;
                        cVar = new c(a4, b3);
                    } else {
                        f b4 = aVar2.b(aVar2.a(g, 15) - 1);
                        f b5 = aVar2.b();
                        list = aVar2.f110a;
                        cVar = new c(b4, b5);
                    }
                    list.add(cVar);
                }
                aVar2.a(cVar2);
            }
        }
        d.a aVar3 = this.d;
        ArrayList arrayList = new ArrayList(aVar3.f110a);
        aVar3.f110a.clear();
        return arrayList;
    }

    private void a() throws IOException {
        this.f150b.i();
        this.f150b.g();
    }

    private void a(int i, int i2) throws IOException {
        if (i != 5) {
            throw e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 == 0) {
            throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        } else {
            a();
        }
    }

    private void a(b bVar) throws IOException {
        if (!this.f151c) {
            f d2 = this.f150b.d((long) e.f116a.size());
            if (f149a.isLoggable(Level.FINE)) {
                f149a.fine(b.a.c.a("<< CONNECTION %s", d2.hex()));
            }
            if (!e.f116a.equals(d2)) {
                throw e.b("Expected a connection header but was %s", d2.utf8());
            }
        } else if (!a(true, bVar)) {
            throw e.b("Required SETTINGS preface not received", new Object[0]);
        }
    }

    private void a(b bVar, int i, byte b2, int i2) throws IOException {
        short s = 0;
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 8) != 0) {
            s = (short) (this.f150b.g() & 255);
        }
        if ((b2 & 32) != 0) {
            a();
            i -= 5;
        }
        bVar.a(z, i2, a(a(i, b2, s), s, b2, i2));
    }

    private void a(b bVar, int i, int i2) throws IOException {
        if (i != 4) {
            throw e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 == 0) {
            throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        } else {
            int i3 = this.f150b.i();
            b fromHttp2 = b.fromHttp2(i3);
            if (fromHttp2 == null) {
                throw e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i3));
            } else {
                bVar.a(i2, fromHttp2);
            }
        }
    }

    private void b(b bVar, int i, byte b2, int i2) throws IOException {
        short s = 0;
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = true;
        boolean z2 = (b2 & 1) != 0;
        if ((b2 & 32) == 0) {
            z = false;
        }
        if (z) {
            throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        if ((b2 & 8) != 0) {
            s = (short) (this.f150b.g() & 255);
        }
        bVar.a(z2, i2, this.f150b, a(i, b2, s));
        this.f150b.h((long) s);
    }

    private void b(b bVar, int i, int i2) throws IOException {
        if (i < 8) {
            throw e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 != 0) {
            throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        } else {
            int i3 = this.f150b.i();
            int i4 = this.f150b.i();
            int i5 = i - 8;
            if (b.fromHttp2(i4) == null) {
                throw e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i4));
            }
            f fVar = f.EMPTY;
            if (i5 > 0) {
                fVar = this.f150b.d((long) i5);
            }
            bVar.a(i3, fVar);
        }
    }

    private void c(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b2 & 1) != 0) {
            if (i != 0) {
                throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
        } else if (i % 6 != 0) {
            throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        } else {
            n nVar = new n();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short h = this.f150b.h();
                int i4 = this.f150b.i();
                switch (h) {
                    case 2:
                        if (!(i4 == 0 || i4 == 1)) {
                            throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                    case 3:
                        h = 4;
                        break;
                    case 4:
                        h = 7;
                        if (i4 >= 0) {
                            break;
                        } else {
                            throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    case 5:
                        if (i4 >= 16384 && i4 <= 16777215) {
                            break;
                        } else {
                            throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i4));
                        }
                        break;
                }
                nVar.a(h, i4);
            }
            bVar.a(nVar);
        }
    }

    private void c(b bVar, int i, int i2) throws IOException {
        if (i != 4) {
            throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long i3 = ((long) this.f150b.i()) & 2147483647L;
        if (i3 == 0) {
            throw e.b("windowSizeIncrement was 0", Long.valueOf(i3));
        } else {
            bVar.a(i2, i3);
        }
    }

    private void d(b bVar, int i, byte b2, int i2) throws IOException {
        short s = 0;
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        if ((b2 & 8) != 0) {
            s = (short) (this.f150b.g() & 255);
        }
        bVar.a(this.f150b.i() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, a(a(i - 4, b2, s), s, b2, i2));
    }

    private void e(b bVar, int i, byte b2, int i2) throws IOException {
        boolean z = false;
        if (i != 8) {
            throw e.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 != 0) {
            throw e.b("TYPE_PING streamId != 0", new Object[0]);
        } else {
            int i3 = this.f150b.i();
            int i4 = this.f150b.i();
            if ((b2 & 1) != 0) {
                z = true;
            }
            bVar.a(z, i3, i4);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(boolean r12, b.a.f.h.b r13) throws java.io.IOException {
        /*
            r11 = this;
            r0 = 0
            c.e r1 = r11.f150b     // Catch:{ IOException -> 0x02a4 }
            r2 = 9
            r1.a((long) r2)     // Catch:{ IOException -> 0x02a4 }
            c.e r1 = r11.f150b
            int r1 = a((c.e) r1)
            r2 = 1
            if (r1 < 0) goto L_0x0295
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r1 <= r3) goto L_0x0017
            goto L_0x0295
        L_0x0017:
            c.e r4 = r11.f150b
            byte r4 = r4.g()
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r5 = 4
            if (r12 == 0) goto L_0x0034
            if (r4 == r5) goto L_0x0034
            java.lang.String r12 = "Expected a SETTINGS frame but was %s"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Byte r1 = java.lang.Byte.valueOf(r4)
            r13[r0] = r1
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x0034:
            c.e r12 = r11.f150b
            byte r12 = r12.g()
            r12 = r12 & 255(0xff, float:3.57E-43)
            byte r12 = (byte) r12
            c.e r6 = r11.f150b
            int r6 = r6.i()
            r7 = 2147483647(0x7fffffff, float:NaN)
            r6 = r6 & r7
            java.util.logging.Logger r8 = f149a
            java.util.logging.Level r9 = java.util.logging.Level.FINE
            boolean r8 = r8.isLoggable(r9)
            if (r8 == 0) goto L_0x005a
            java.util.logging.Logger r8 = f149a
            java.lang.String r9 = b.a.f.e.a(r2, r6, r1, r4, r12)
            r8.fine(r9)
        L_0x005a:
            r8 = 8
            switch(r4) {
                case 0: goto L_0x0255;
                case 1: goto L_0x0221;
                case 2: goto L_0x0200;
                case 3: goto L_0x01c5;
                case 4: goto L_0x0146;
                case 5: goto L_0x0119;
                case 6: goto L_0x00e9;
                case 7: goto L_0x009c;
                case 8: goto L_0x0066;
                default: goto L_0x005f;
            }
        L_0x005f:
            c.e r12 = r11.f150b
            long r0 = (long) r1
        L_0x0062:
            r12.h(r0)
            return r2
        L_0x0066:
            if (r1 == r5) goto L_0x0077
            java.lang.String r12 = "TYPE_WINDOW_UPDATE length !=4: %s"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13[r0] = r1
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x0077:
            c.e r12 = r11.f150b
            int r12 = r12.i()
            long r3 = (long) r12
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r9 = r3 & r7
            r3 = 0
            int r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r12 != 0) goto L_0x0098
            java.lang.String r12 = "windowSizeIncrement was 0"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Long r1 = java.lang.Long.valueOf(r9)
            r13[r0] = r1
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x0098:
            r13.a((int) r6, (long) r9)
            return r2
        L_0x009c:
            if (r1 >= r8) goto L_0x00ad
            java.lang.String r12 = "TYPE_GOAWAY length < 8: %s"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13[r0] = r1
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x00ad:
            if (r6 == 0) goto L_0x00b8
            java.lang.String r12 = "TYPE_GOAWAY streamId != 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x00b8:
            c.e r12 = r11.f150b
            int r12 = r12.i()
            c.e r3 = r11.f150b
            int r3 = r3.i()
            int r1 = r1 - r8
            b.a.f.b r4 = b.a.f.b.fromHttp2(r3)
            if (r4 != 0) goto L_0x00da
            java.lang.String r12 = "TYPE_GOAWAY unexpected error code: %d"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r13[r0] = r1
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x00da:
            c.f r0 = c.f.EMPTY
            if (r1 <= 0) goto L_0x00e5
            c.e r0 = r11.f150b
            long r3 = (long) r1
            c.f r0 = r0.d((long) r3)
        L_0x00e5:
            r13.a((int) r12, (c.f) r0)
            return r2
        L_0x00e9:
            if (r1 == r8) goto L_0x00fa
            java.lang.String r12 = "TYPE_PING length != 8: %s"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13[r0] = r1
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x00fa:
            if (r6 == 0) goto L_0x0105
            java.lang.String r12 = "TYPE_PING streamId != 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x0105:
            c.e r1 = r11.f150b
            int r1 = r1.i()
            c.e r3 = r11.f150b
            int r3 = r3.i()
            r12 = r12 & r2
            if (r12 == 0) goto L_0x0115
            r0 = 1
        L_0x0115:
            r13.a((boolean) r0, (int) r1, (int) r3)
            return r2
        L_0x0119:
            if (r6 != 0) goto L_0x0124
            java.lang.String r12 = "PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x0124:
            r3 = r12 & 8
            if (r3 == 0) goto L_0x0131
            c.e r0 = r11.f150b
            byte r0 = r0.g()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x0131:
            c.e r3 = r11.f150b
            int r3 = r3.i()
            r3 = r3 & r7
            int r1 = r1 + -4
            int r1 = a((int) r1, (byte) r12, (short) r0)
            java.util.List r12 = r11.a((int) r1, (short) r0, (byte) r12, (int) r6)
            r13.a((int) r3, (java.util.List<b.a.f.c>) r12)
            return r2
        L_0x0146:
            if (r6 == 0) goto L_0x0151
            java.lang.String r12 = "TYPE_SETTINGS streamId != 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x0151:
            r12 = r12 & r2
            if (r12 == 0) goto L_0x015f
            if (r1 == 0) goto L_0x0294
            java.lang.String r12 = "FRAME_SIZE_ERROR ack frame should be empty!"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x015f:
            int r12 = r1 % 6
            if (r12 == 0) goto L_0x0172
            java.lang.String r12 = "TYPE_SETTINGS length %% 6 != 0: %s"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13[r0] = r1
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x0172:
            b.a.f.n r12 = new b.a.f.n
            r12.<init>()
            r4 = 0
        L_0x0178:
            if (r4 >= r1) goto L_0x01c1
            c.e r6 = r11.f150b
            short r6 = r6.h()
            c.e r7 = r11.f150b
            int r7 = r7.i()
            switch(r6) {
                case 1: goto L_0x01bb;
                case 2: goto L_0x01ae;
                case 3: goto L_0x01ac;
                case 4: goto L_0x01a0;
                case 5: goto L_0x018a;
                default: goto L_0x0189;
            }
        L_0x0189:
            goto L_0x01bb
        L_0x018a:
            if (r7 < r3) goto L_0x0191
            r8 = 16777215(0xffffff, float:2.3509886E-38)
            if (r7 <= r8) goto L_0x01bb
        L_0x0191:
            java.lang.String r12 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r13[r0] = r1
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x01a0:
            r6 = 7
            if (r7 >= 0) goto L_0x01bb
            java.lang.String r12 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x01ac:
            r6 = 4
            goto L_0x01bb
        L_0x01ae:
            if (r7 == 0) goto L_0x01bb
            if (r7 == r2) goto L_0x01bb
            java.lang.String r12 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x01bb:
            r12.a(r6, r7)
            int r4 = r4 + 6
            goto L_0x0178
        L_0x01c1:
            r13.a(r12)
            return r2
        L_0x01c5:
            if (r1 == r5) goto L_0x01d6
            java.lang.String r12 = "TYPE_RST_STREAM length: %d != 4"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13[r0] = r1
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x01d6:
            if (r6 != 0) goto L_0x01e1
            java.lang.String r12 = "TYPE_RST_STREAM streamId == 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x01e1:
            c.e r12 = r11.f150b
            int r12 = r12.i()
            b.a.f.b r1 = b.a.f.b.fromHttp2(r12)
            if (r1 != 0) goto L_0x01fc
            java.lang.String r13 = "TYPE_RST_STREAM unexpected error code: %d"
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r1[r0] = r12
            java.io.IOException r12 = b.a.f.e.b(r13, r1)
            throw r12
        L_0x01fc:
            r13.a((int) r6, (b.a.f.b) r1)
            return r2
        L_0x0200:
            r12 = 5
            if (r1 == r12) goto L_0x0212
            java.lang.String r12 = "TYPE_PRIORITY length: %d != 5"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13[r0] = r1
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x0212:
            if (r6 != 0) goto L_0x021d
            java.lang.String r12 = "TYPE_PRIORITY streamId == 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x021d:
            r11.a()
            return r2
        L_0x0221:
            if (r6 != 0) goto L_0x022c
            java.lang.String r12 = "PROTOCOL_ERROR: TYPE_HEADERS streamId == 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x022c:
            r3 = r12 & 1
            if (r3 == 0) goto L_0x0232
            r3 = 1
            goto L_0x0233
        L_0x0232:
            r3 = 0
        L_0x0233:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x0240
            c.e r0 = r11.f150b
            byte r0 = r0.g()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x0240:
            r4 = r12 & 32
            if (r4 == 0) goto L_0x0249
            r11.a()
            int r1 = r1 + -5
        L_0x0249:
            int r1 = a((int) r1, (byte) r12, (short) r0)
            java.util.List r12 = r11.a((int) r1, (short) r0, (byte) r12, (int) r6)
            r13.a((boolean) r3, (int) r6, (java.util.List<b.a.f.c>) r12)
            return r2
        L_0x0255:
            if (r6 != 0) goto L_0x0260
            java.lang.String r12 = "PROTOCOL_ERROR: TYPE_DATA streamId == 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x0260:
            r3 = r12 & 1
            if (r3 == 0) goto L_0x0266
            r3 = 1
            goto L_0x0267
        L_0x0266:
            r3 = 0
        L_0x0267:
            r4 = r12 & 32
            if (r4 == 0) goto L_0x026d
            r4 = 1
            goto L_0x026e
        L_0x026d:
            r4 = 0
        L_0x026e:
            if (r4 == 0) goto L_0x0279
            java.lang.String r12 = "PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x0279:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x0286
            c.e r0 = r11.f150b
            byte r0 = r0.g()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x0286:
            int r12 = a((int) r1, (byte) r12, (short) r0)
            c.e r1 = r11.f150b
            r13.a(r3, r6, r1, r12)
            c.e r12 = r11.f150b
            long r0 = (long) r0
            goto L_0x0062
        L_0x0294:
            return r2
        L_0x0295:
            java.lang.String r12 = "FRAME_SIZE_ERROR: %s"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13[r0] = r1
            java.io.IOException r12 = b.a.f.e.b(r12, r13)
            throw r12
        L_0x02a4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.f.h.a(boolean, b.a.f.h$b):boolean");
    }

    public final void close() throws IOException {
        this.f150b.close();
    }
}

package com.b.a.a.e;

import com.b.a.a.c;
import com.b.b.h;
import com.b.b.i;
import com.umeng.commonsdk.proguard.bg;
import java.io.Closeable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class y implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f711a = Logger.getLogger(g.class.getName());

    /* renamed from: b  reason: collision with root package name */
    final e f712b = new e(this.d);

    /* renamed from: c  reason: collision with root package name */
    private final h f713c;
    private final z d = new z(this.f713c);
    private final boolean e;

    public y(h hVar, boolean z) {
        this.f713c = hVar;
        this.e = z;
    }

    private static int a(int i, byte b2, short s) {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw g.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    static int a(h hVar) {
        return (hVar.e() & 255) | ((hVar.e() & 255) << bg.n) | ((hVar.e() & 255) << 8);
    }

    private List<c> a(int i, short s, byte b2, int i2) {
        z zVar = this.d;
        this.d.d = i;
        zVar.f714a = i;
        this.d.e = s;
        this.d.f715b = b2;
        this.d.f716c = i2;
        this.f712b.a();
        return this.f712b.b();
    }

    private void a() {
        this.f713c.g();
        this.f713c.e();
    }

    public final void a(aa aaVar) {
        if (!this.e) {
            i c2 = this.f713c.c((long) g.f677a.g());
            if (f711a.isLoggable(Level.FINE)) {
                f711a.fine(c.a("<< CONNECTION %s", c2.e()));
            }
            if (!g.f677a.equals(c2)) {
                throw g.b("Expected a connection header but was %s", c2.a());
            }
        } else if (!a(true, aaVar)) {
            throw g.b("Required SETTINGS preface not received", new Object[0]);
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
    public final boolean a(boolean r12, com.b.a.a.e.aa r13) {
        /*
            r11 = this;
            r0 = 0
            com.b.b.h r1 = r11.f713c     // Catch:{ IOException -> 0x0299 }
            r2 = 9
            r1.a((long) r2)     // Catch:{ IOException -> 0x0299 }
            com.b.b.h r1 = r11.f713c
            int r1 = a((com.b.b.h) r1)
            r2 = 1
            if (r1 < 0) goto L_0x028a
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r1 <= r3) goto L_0x0017
            goto L_0x028a
        L_0x0017:
            com.b.b.h r4 = r11.f713c
            byte r4 = r4.e()
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r5 = 4
            if (r12 == 0) goto L_0x0034
            if (r4 == r5) goto L_0x0034
            java.lang.String r12 = "Expected a SETTINGS frame but was %s"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Byte r1 = java.lang.Byte.valueOf(r4)
            r13[r0] = r1
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x0034:
            com.b.b.h r12 = r11.f713c
            byte r12 = r12.e()
            r12 = r12 & 255(0xff, float:3.57E-43)
            byte r12 = (byte) r12
            com.b.b.h r6 = r11.f713c
            int r6 = r6.g()
            r7 = 2147483647(0x7fffffff, float:NaN)
            r6 = r6 & r7
            java.util.logging.Logger r8 = f711a
            java.util.logging.Level r9 = java.util.logging.Level.FINE
            boolean r8 = r8.isLoggable(r9)
            if (r8 == 0) goto L_0x005a
            java.util.logging.Logger r8 = f711a
            java.lang.String r9 = com.b.a.a.e.g.a(r2, r6, r1, r4, r12)
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
            com.b.b.h r12 = r11.f713c
            long r0 = (long) r1
        L_0x0062:
            r12.f(r0)
            return r2
        L_0x0066:
            if (r1 == r5) goto L_0x0077
            java.lang.String r12 = "TYPE_WINDOW_UPDATE length !=4: %s"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13[r0] = r1
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x0077:
            com.b.b.h r12 = r11.f713c
            int r12 = r12.g()
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
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
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
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x00ad:
            if (r6 == 0) goto L_0x00b8
            java.lang.String r12 = "TYPE_GOAWAY streamId != 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x00b8:
            com.b.b.h r12 = r11.f713c
            int r12 = r12.g()
            com.b.b.h r3 = r11.f713c
            int r3 = r3.g()
            int r1 = r1 - r8
            com.b.a.a.e.b r4 = com.b.a.a.e.b.a(r3)
            if (r4 != 0) goto L_0x00da
            java.lang.String r12 = "TYPE_GOAWAY unexpected error code: %d"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r13[r0] = r1
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x00da:
            com.b.b.i r0 = com.b.b.i.f857b
            if (r1 <= 0) goto L_0x00e5
            com.b.b.h r0 = r11.f713c
            long r3 = (long) r1
            com.b.b.i r0 = r0.c(r3)
        L_0x00e5:
            r13.a((int) r12, (com.b.b.i) r0)
            return r2
        L_0x00e9:
            if (r1 == r8) goto L_0x00fa
            java.lang.String r12 = "TYPE_PING length != 8: %s"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13[r0] = r1
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x00fa:
            if (r6 == 0) goto L_0x0105
            java.lang.String r12 = "TYPE_PING streamId != 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x0105:
            com.b.b.h r1 = r11.f713c
            int r1 = r1.g()
            com.b.b.h r3 = r11.f713c
            int r3 = r3.g()
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
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x0124:
            r3 = r12 & 8
            if (r3 == 0) goto L_0x0131
            com.b.b.h r0 = r11.f713c
            byte r0 = r0.e()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x0131:
            com.b.b.h r3 = r11.f713c
            int r3 = r3.g()
            r3 = r3 & r7
            int r1 = r1 + -4
            int r1 = a(r1, r12, r0)
            java.util.List r12 = r11.a(r1, r0, r12, r6)
            r13.a((int) r3, (java.util.List<com.b.a.a.e.c>) r12)
            return r2
        L_0x0146:
            if (r6 == 0) goto L_0x0151
            java.lang.String r12 = "TYPE_SETTINGS streamId != 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x0151:
            r12 = r12 & r2
            if (r12 == 0) goto L_0x015f
            if (r1 == 0) goto L_0x0289
            java.lang.String r12 = "FRAME_SIZE_ERROR ack frame should be empty!"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x015f:
            int r12 = r1 % 6
            if (r12 == 0) goto L_0x0172
            java.lang.String r12 = "TYPE_SETTINGS length %% 6 != 0: %s"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13[r0] = r1
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x0172:
            com.b.a.a.e.al r12 = new com.b.a.a.e.al
            r12.<init>()
            r4 = 0
        L_0x0178:
            if (r4 >= r1) goto L_0x01c1
            com.b.b.h r6 = r11.f713c
            short r6 = r6.f()
            com.b.b.h r7 = r11.f713c
            int r7 = r7.g()
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
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x01a0:
            r6 = 7
            if (r7 >= 0) goto L_0x01bb
            java.lang.String r12 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x01ac:
            r6 = 4
            goto L_0x01bb
        L_0x01ae:
            if (r7 == 0) goto L_0x01bb
            if (r7 == r2) goto L_0x01bb
            java.lang.String r12 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
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
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x01d6:
            if (r6 != 0) goto L_0x01e1
            java.lang.String r12 = "TYPE_RST_STREAM streamId == 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x01e1:
            com.b.b.h r12 = r11.f713c
            int r12 = r12.g()
            com.b.a.a.e.b r1 = com.b.a.a.e.b.a(r12)
            if (r1 != 0) goto L_0x01fc
            java.lang.String r13 = "TYPE_RST_STREAM unexpected error code: %d"
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r1[r0] = r12
            java.io.IOException r12 = com.b.a.a.e.g.b(r13, r1)
            throw r12
        L_0x01fc:
            r13.a((int) r6, (com.b.a.a.e.b) r1)
            return r2
        L_0x0200:
            r12 = 5
            if (r1 == r12) goto L_0x0212
            java.lang.String r12 = "TYPE_PRIORITY length: %d != 5"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13[r0] = r1
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x0212:
            if (r6 != 0) goto L_0x021d
            java.lang.String r12 = "TYPE_PRIORITY streamId == 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x021d:
            r11.a()
            return r2
        L_0x0221:
            if (r6 != 0) goto L_0x022c
            java.lang.String r12 = "PROTOCOL_ERROR: TYPE_HEADERS streamId == 0"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
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
            com.b.b.h r0 = r11.f713c
            byte r0 = r0.e()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x0240:
            r4 = r12 & 32
            if (r4 == 0) goto L_0x0249
            r11.a()
            int r1 = r1 + -5
        L_0x0249:
            int r1 = a(r1, r12, r0)
            java.util.List r12 = r11.a(r1, r0, r12, r6)
            r13.a((boolean) r3, (int) r6, (java.util.List<com.b.a.a.e.c>) r12)
            return r2
        L_0x0255:
            r3 = r12 & 1
            if (r3 == 0) goto L_0x025b
            r3 = 1
            goto L_0x025c
        L_0x025b:
            r3 = 0
        L_0x025c:
            r4 = r12 & 32
            if (r4 == 0) goto L_0x0262
            r4 = 1
            goto L_0x0263
        L_0x0262:
            r4 = 0
        L_0x0263:
            if (r4 == 0) goto L_0x026e
            java.lang.String r12 = "PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA"
            java.lang.Object[] r13 = new java.lang.Object[r0]
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x026e:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x027b
            com.b.b.h r0 = r11.f713c
            byte r0 = r0.e()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x027b:
            int r12 = a(r1, r12, r0)
            com.b.b.h r1 = r11.f713c
            r13.a(r3, r6, r1, r12)
            com.b.b.h r12 = r11.f713c
            long r0 = (long) r0
            goto L_0x0062
        L_0x0289:
            return r2
        L_0x028a:
            java.lang.String r12 = "FRAME_SIZE_ERROR: %s"
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13[r0] = r1
            java.io.IOException r12 = com.b.a.a.e.g.b(r12, r13)
            throw r12
        L_0x0299:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.e.y.a(boolean, com.b.a.a.e.aa):boolean");
    }

    public final void close() {
        this.f713c.close();
    }
}

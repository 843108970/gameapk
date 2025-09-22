package com.google.a.g.a.a.a;

import android.support.v7.widget.helper.ItemTouchHelper;
import com.google.a.c.a;
import com.google.a.g.a.a.a.m;
import com.google.a.h;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    private final a f3173a;

    /* renamed from: b  reason: collision with root package name */
    private final m f3174b = new m();

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f3175c = new StringBuilder();

    s(a aVar) {
        this.f3173a = aVar;
    }

    public static int a(a aVar, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (aVar.a(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private o a() throws h {
        l lVar;
        boolean z;
        m mVar;
        int i;
        n nVar;
        char c2;
        int a2;
        int a3;
        do {
            int i2 = this.f3174b.f3160a;
            boolean z2 = false;
            if (this.f3174b.f3161b == m.a.ALPHA$1376b33b) {
                while (true) {
                    int i3 = this.f3174b.f3160a;
                    if (i3 + 5 <= this.f3173a.f3055b && (((a2 = a(i3, 5)) >= 5 && a2 < 16) || (i3 + 6 <= this.f3173a.f3055b && (a3 = a(i3, 6)) >= 16 && a3 < 63))) {
                        int i4 = this.f3174b.f3160a;
                        int a4 = a(i4, 5);
                        if (a4 == 15) {
                            nVar = new n(i4 + 5, '$');
                        } else if (a4 < 5 || a4 >= 15) {
                            int a5 = a(i4, 6);
                            if (a5 < 32 || a5 >= 58) {
                                switch (a5) {
                                    case 58:
                                        c2 = '*';
                                        break;
                                    case 59:
                                        c2 = ',';
                                        break;
                                    case 60:
                                        c2 = '-';
                                        break;
                                    case 61:
                                        c2 = FilenameUtils.EXTENSION_SEPARATOR;
                                        break;
                                    case 62:
                                        c2 = IOUtils.DIR_SEPARATOR_UNIX;
                                        break;
                                    default:
                                        throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(a5)));
                                }
                                nVar = new n(i4 + 6, c2);
                            } else {
                                nVar = new n(i4 + 6, (char) (a5 + 33));
                            }
                        } else {
                            nVar = new n(i4 + 5, (char) ((a4 + 48) - 5));
                        }
                        this.f3174b.f3160a = nVar.d;
                        if (nVar.a()) {
                            lVar = new l(new o(this.f3174b.f3160a, this.f3175c.toString()), true);
                        } else {
                            this.f3175c.append(nVar.f3163a);
                        }
                    } else {
                        if (h(this.f3174b.f3160a)) {
                            this.f3174b.a(3);
                            mVar = this.f3174b;
                            i = m.a.NUMERIC$1376b33b;
                        } else {
                            if (g(this.f3174b.f3160a)) {
                                if (this.f3174b.f3160a + 5 < this.f3173a.f3055b) {
                                    this.f3174b.a(5);
                                } else {
                                    this.f3174b.f3160a = this.f3173a.f3055b;
                                }
                                mVar = this.f3174b;
                                i = m.a.ISO_IEC_646$1376b33b;
                            }
                            lVar = new l();
                        }
                        mVar.f3161b = i;
                        lVar = new l();
                    }
                }
            } else {
                lVar = this.f3174b.f3161b == m.a.ISO_IEC_646$1376b33b ? c() : b();
            }
            z = lVar.f3159b;
            if (i2 != this.f3174b.f3160a) {
                z2 = true;
            }
            if (z2 || z) {
            }
            return lVar.f3158a;
        } while (!z);
        return lVar.f3158a;
    }

    private boolean a(int i) {
        if (i + 7 > this.f3173a.f3055b) {
            return i + 4 <= this.f3173a.f3055b;
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            if (i2 >= i3) {
                return this.f3173a.a(i3);
            }
            if (this.f3173a.a(i2)) {
                return true;
            }
            i2++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.a.g.a.a.a.l b() throws com.google.a.h {
        /*
            r7 = this;
        L_0x0000:
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r0 = r0.f3160a
            int r1 = r0 + 7
            com.google.a.c.a r2 = r7.f3173a
            int r2 = r2.f3055b
            r3 = 0
            r4 = 1
            if (r1 <= r2) goto L_0x001a
            int r0 = r0 + 4
            com.google.a.c.a r1 = r7.f3173a
            int r1 = r1.f3055b
            if (r0 > r1) goto L_0x0018
        L_0x0016:
            r0 = 1
            goto L_0x0031
        L_0x0018:
            r0 = 0
            goto L_0x0031
        L_0x001a:
            r1 = r0
        L_0x001b:
            int r2 = r0 + 3
            if (r1 >= r2) goto L_0x002b
            com.google.a.c.a r2 = r7.f3173a
            boolean r2 = r2.a((int) r1)
            if (r2 == 0) goto L_0x0028
            goto L_0x0016
        L_0x0028:
            int r1 = r1 + 1
            goto L_0x001b
        L_0x002b:
            com.google.a.c.a r0 = r7.f3173a
            boolean r0 = r0.a((int) r2)
        L_0x0031:
            r1 = 4
            if (r0 == 0) goto L_0x00d6
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r0 = r0.f3160a
            int r2 = r0 + 7
            com.google.a.c.a r5 = r7.f3173a
            int r5 = r5.f3055b
            r6 = 10
            if (r2 <= r5) goto L_0x005f
            int r0 = r7.a((int) r0, (int) r1)
            if (r0 != 0) goto L_0x0052
            com.google.a.g.a.a.a.p r0 = new com.google.a.g.a.a.a.p
            com.google.a.c.a r1 = r7.f3173a
            int r1 = r1.f3055b
            r0.<init>(r1, r6, r6)
            goto L_0x0070
        L_0x0052:
            com.google.a.g.a.a.a.p r1 = new com.google.a.g.a.a.a.p
            com.google.a.c.a r2 = r7.f3173a
            int r2 = r2.f3055b
            int r0 = r0 + -1
            r1.<init>(r2, r0, r6)
            r0 = r1
            goto L_0x0070
        L_0x005f:
            r1 = 7
            int r0 = r7.a((int) r0, (int) r1)
            int r0 = r0 + -8
            int r1 = r0 / 11
            int r0 = r0 % 11
            com.google.a.g.a.a.a.p r5 = new com.google.a.g.a.a.a.p
            r5.<init>(r2, r1, r0)
            r0 = r5
        L_0x0070:
            com.google.a.g.a.a.a.m r1 = r7.f3174b
            int r2 = r0.d
            r1.f3160a = r2
            int r1 = r0.f3168a
            if (r1 != r6) goto L_0x007b
            r3 = 1
        L_0x007b:
            if (r3 == 0) goto L_0x00ab
            boolean r1 = r0.a()
            if (r1 == 0) goto L_0x0093
            com.google.a.g.a.a.a.o r0 = new com.google.a.g.a.a.a.o
            com.google.a.g.a.a.a.m r1 = r7.f3174b
            int r1 = r1.f3160a
            java.lang.StringBuilder r2 = r7.f3175c
            java.lang.String r2 = r2.toString()
            r0.<init>(r1, r2)
            goto L_0x00a5
        L_0x0093:
            com.google.a.g.a.a.a.o r1 = new com.google.a.g.a.a.a.o
            com.google.a.g.a.a.a.m r2 = r7.f3174b
            int r2 = r2.f3160a
            java.lang.StringBuilder r3 = r7.f3175c
            java.lang.String r3 = r3.toString()
            int r0 = r0.f3169b
            r1.<init>(r2, r3, r0)
            r0 = r1
        L_0x00a5:
            com.google.a.g.a.a.a.l r1 = new com.google.a.g.a.a.a.l
            r1.<init>(r0, r4)
            return r1
        L_0x00ab:
            java.lang.StringBuilder r1 = r7.f3175c
            int r2 = r0.f3168a
            r1.append(r2)
            boolean r1 = r0.a()
            if (r1 == 0) goto L_0x00cd
            com.google.a.g.a.a.a.o r0 = new com.google.a.g.a.a.a.o
            com.google.a.g.a.a.a.m r1 = r7.f3174b
            int r1 = r1.f3160a
            java.lang.StringBuilder r2 = r7.f3175c
            java.lang.String r2 = r2.toString()
            r0.<init>(r1, r2)
            com.google.a.g.a.a.a.l r1 = new com.google.a.g.a.a.a.l
            r1.<init>(r0, r4)
            return r1
        L_0x00cd:
            java.lang.StringBuilder r1 = r7.f3175c
            int r0 = r0.f3169b
            r1.append(r0)
            goto L_0x0000
        L_0x00d6:
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r0 = r0.f3160a
            int r2 = r0 + 1
            com.google.a.c.a r5 = r7.f3173a
            int r5 = r5.f3055b
            if (r2 <= r5) goto L_0x00e3
            goto L_0x00fb
        L_0x00e3:
            r2 = 0
        L_0x00e4:
            if (r2 >= r1) goto L_0x00fa
            int r5 = r2 + r0
            com.google.a.c.a r6 = r7.f3173a
            int r6 = r6.f3055b
            if (r5 >= r6) goto L_0x00fa
            com.google.a.c.a r6 = r7.f3173a
            boolean r5 = r6.a((int) r5)
            if (r5 == 0) goto L_0x00f7
            goto L_0x00fb
        L_0x00f7:
            int r2 = r2 + 1
            goto L_0x00e4
        L_0x00fa:
            r3 = 1
        L_0x00fb:
            if (r3 == 0) goto L_0x0108
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r2 = com.google.a.g.a.a.a.m.a.ALPHA$1376b33b
            r0.f3161b = r2
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            r0.a(r1)
        L_0x0108:
            com.google.a.g.a.a.a.l r0 = new com.google.a.g.a.a.a.l
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.a.a.a.s.b():com.google.a.g.a.a.a.l");
    }

    private p b(int i) throws h {
        int i2 = i + 7;
        if (i2 > this.f3173a.f3055b) {
            int a2 = a(i, 4);
            return a2 == 0 ? new p(this.f3173a.f3055b, 10, 10) : new p(this.f3173a.f3055b, a2 - 1, 10);
        }
        int a3 = a(i, 7) - 8;
        return new p(i2, a3 / 11, a3 % 11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        r0 = a(r0, 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        r1 = a(r0, 5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        r1 = a(r0, 7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.a.g.a.a.a.l c() throws com.google.a.h {
        /*
            r9 = this;
        L_0x0000:
            com.google.a.g.a.a.a.m r0 = r9.f3174b
            int r0 = r0.f3160a
            int r1 = r0 + 5
            com.google.a.c.a r2 = r9.f3173a
            int r2 = r2.f3055b
            r3 = 116(0x74, float:1.63E-43)
            r4 = 64
            r5 = 8
            r6 = 1
            r7 = 7
            r8 = 5
            if (r1 > r2) goto L_0x0047
            int r1 = r9.a((int) r0, (int) r8)
            if (r1 < r8) goto L_0x0021
            r2 = 16
            if (r1 >= r2) goto L_0x0021
        L_0x001f:
            r0 = 1
            goto L_0x0048
        L_0x0021:
            int r1 = r0 + 7
            com.google.a.c.a r2 = r9.f3173a
            int r2 = r2.f3055b
            if (r1 > r2) goto L_0x0047
            int r1 = r9.a((int) r0, (int) r7)
            if (r1 < r4) goto L_0x0032
            if (r1 >= r3) goto L_0x0032
            goto L_0x001f
        L_0x0032:
            int r1 = r0 + 8
            com.google.a.c.a r2 = r9.f3173a
            int r2 = r2.f3055b
            if (r1 > r2) goto L_0x0047
            int r0 = r9.a((int) r0, (int) r5)
            r1 = 232(0xe8, float:3.25E-43)
            if (r0 < r1) goto L_0x0047
            r1 = 253(0xfd, float:3.55E-43)
            if (r0 >= r1) goto L_0x0047
            goto L_0x001f
        L_0x0047:
            r0 = 0
        L_0x0048:
            if (r0 == 0) goto L_0x0113
            com.google.a.g.a.a.a.m r0 = r9.f3174b
            int r0 = r0.f3160a
            int r1 = r9.a((int) r0, (int) r8)
            r2 = 15
            if (r1 != r2) goto L_0x0062
            com.google.a.g.a.a.a.n r1 = new com.google.a.g.a.a.a.n
            int r0 = r0 + 5
            r2 = 36
            r1.<init>(r0, r2)
            r2 = r1
            goto L_0x00e9
        L_0x0062:
            if (r1 < r8) goto L_0x0073
            if (r1 >= r2) goto L_0x0073
            com.google.a.g.a.a.a.n r2 = new com.google.a.g.a.a.a.n
            int r0 = r0 + 5
            int r1 = r1 + 48
            int r1 = r1 - r8
            char r1 = (char) r1
            r2.<init>(r0, r1)
            goto L_0x00e9
        L_0x0073:
            int r1 = r9.a((int) r0, (int) r7)
            r2 = 90
            if (r1 < r4) goto L_0x0089
            if (r1 >= r2) goto L_0x0089
            com.google.a.g.a.a.a.n r2 = new com.google.a.g.a.a.a.n
            int r0 = r0 + 7
            int r1 = r1 + 1
            char r1 = (char) r1
            r2.<init>(r0, r1)
            goto L_0x00e9
        L_0x0089:
            if (r1 < r2) goto L_0x0098
            if (r1 >= r3) goto L_0x0098
            com.google.a.g.a.a.a.n r2 = new com.google.a.g.a.a.a.n
            int r0 = r0 + 7
            int r1 = r1 + 7
            char r1 = (char) r1
            r2.<init>(r0, r1)
            goto L_0x00e9
        L_0x0098:
            int r1 = r9.a((int) r0, (int) r5)
            switch(r1) {
                case 232: goto L_0x00e0;
                case 233: goto L_0x00dd;
                case 234: goto L_0x00da;
                case 235: goto L_0x00d7;
                case 236: goto L_0x00d4;
                case 237: goto L_0x00d1;
                case 238: goto L_0x00ce;
                case 239: goto L_0x00cb;
                case 240: goto L_0x00c8;
                case 241: goto L_0x00c5;
                case 242: goto L_0x00c2;
                case 243: goto L_0x00bf;
                case 244: goto L_0x00bc;
                case 245: goto L_0x00b9;
                case 246: goto L_0x00b6;
                case 247: goto L_0x00b3;
                case 248: goto L_0x00b0;
                case 249: goto L_0x00ad;
                case 250: goto L_0x00aa;
                case 251: goto L_0x00a7;
                case 252: goto L_0x00a4;
                default: goto L_0x009f;
            }
        L_0x009f:
            com.google.a.h r0 = com.google.a.h.getFormatInstance()
            throw r0
        L_0x00a4:
            r1 = 32
            goto L_0x00e2
        L_0x00a7:
            r1 = 95
            goto L_0x00e2
        L_0x00aa:
            r1 = 63
            goto L_0x00e2
        L_0x00ad:
            r1 = 62
            goto L_0x00e2
        L_0x00b0:
            r1 = 61
            goto L_0x00e2
        L_0x00b3:
            r1 = 60
            goto L_0x00e2
        L_0x00b6:
            r1 = 59
            goto L_0x00e2
        L_0x00b9:
            r1 = 58
            goto L_0x00e2
        L_0x00bc:
            r1 = 47
            goto L_0x00e2
        L_0x00bf:
            r1 = 46
            goto L_0x00e2
        L_0x00c2:
            r1 = 45
            goto L_0x00e2
        L_0x00c5:
            r1 = 44
            goto L_0x00e2
        L_0x00c8:
            r1 = 43
            goto L_0x00e2
        L_0x00cb:
            r1 = 42
            goto L_0x00e2
        L_0x00ce:
            r1 = 41
            goto L_0x00e2
        L_0x00d1:
            r1 = 40
            goto L_0x00e2
        L_0x00d4:
            r1 = 39
            goto L_0x00e2
        L_0x00d7:
            r1 = 38
            goto L_0x00e2
        L_0x00da:
            r1 = 37
            goto L_0x00e2
        L_0x00dd:
            r1 = 34
            goto L_0x00e2
        L_0x00e0:
            r1 = 33
        L_0x00e2:
            com.google.a.g.a.a.a.n r2 = new com.google.a.g.a.a.a.n
            int r0 = r0 + 8
            r2.<init>(r0, r1)
        L_0x00e9:
            com.google.a.g.a.a.a.m r0 = r9.f3174b
            int r1 = r2.d
            r0.f3160a = r1
            boolean r0 = r2.a()
            if (r0 == 0) goto L_0x010a
            com.google.a.g.a.a.a.o r0 = new com.google.a.g.a.a.a.o
            com.google.a.g.a.a.a.m r1 = r9.f3174b
            int r1 = r1.f3160a
            java.lang.StringBuilder r2 = r9.f3175c
            java.lang.String r2 = r2.toString()
            r0.<init>(r1, r2)
            com.google.a.g.a.a.a.l r1 = new com.google.a.g.a.a.a.l
            r1.<init>(r0, r6)
            return r1
        L_0x010a:
            java.lang.StringBuilder r0 = r9.f3175c
            char r1 = r2.f3163a
            r0.append(r1)
            goto L_0x0000
        L_0x0113:
            com.google.a.g.a.a.a.m r0 = r9.f3174b
            int r0 = r0.f3160a
            boolean r0 = r9.h(r0)
            if (r0 == 0) goto L_0x012a
            com.google.a.g.a.a.a.m r0 = r9.f3174b
            r1 = 3
            r0.a(r1)
            com.google.a.g.a.a.a.m r0 = r9.f3174b
            int r1 = com.google.a.g.a.a.a.m.a.NUMERIC$1376b33b
        L_0x0127:
            r0.f3161b = r1
            goto L_0x0152
        L_0x012a:
            com.google.a.g.a.a.a.m r0 = r9.f3174b
            int r0 = r0.f3160a
            boolean r0 = r9.g(r0)
            if (r0 == 0) goto L_0x0152
            com.google.a.g.a.a.a.m r0 = r9.f3174b
            int r0 = r0.f3160a
            int r0 = r0 + r8
            com.google.a.c.a r1 = r9.f3173a
            int r1 = r1.f3055b
            if (r0 >= r1) goto L_0x0145
            com.google.a.g.a.a.a.m r0 = r9.f3174b
            r0.a(r8)
            goto L_0x014d
        L_0x0145:
            com.google.a.g.a.a.a.m r0 = r9.f3174b
            com.google.a.c.a r1 = r9.f3173a
            int r1 = r1.f3055b
            r0.f3160a = r1
        L_0x014d:
            com.google.a.g.a.a.a.m r0 = r9.f3174b
            int r1 = com.google.a.g.a.a.a.m.a.ALPHA$1376b33b
            goto L_0x0127
        L_0x0152:
            com.google.a.g.a.a.a.l r0 = new com.google.a.g.a.a.a.l
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.a.a.a.s.c():com.google.a.g.a.a.a.l");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        r5 = a(r5, 8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(int r5) {
        /*
            r4 = this;
            int r0 = r5 + 5
            com.google.a.c.a r1 = r4.f3173a
            int r1 = r1.f3055b
            r2 = 0
            if (r0 <= r1) goto L_0x000a
            return r2
        L_0x000a:
            r0 = 5
            int r1 = r4.a((int) r5, (int) r0)
            r3 = 1
            if (r1 < r0) goto L_0x0017
            r0 = 16
            if (r1 >= r0) goto L_0x0017
            return r3
        L_0x0017:
            int r0 = r5 + 7
            com.google.a.c.a r1 = r4.f3173a
            int r1 = r1.f3055b
            if (r0 <= r1) goto L_0x0020
            return r2
        L_0x0020:
            r0 = 7
            int r0 = r4.a((int) r5, (int) r0)
            r1 = 64
            if (r0 < r1) goto L_0x002e
            r1 = 116(0x74, float:1.63E-43)
            if (r0 >= r1) goto L_0x002e
            return r3
        L_0x002e:
            int r0 = r5 + 8
            com.google.a.c.a r1 = r4.f3173a
            int r1 = r1.f3055b
            if (r0 <= r1) goto L_0x0037
            return r2
        L_0x0037:
            r0 = 8
            int r5 = r4.a((int) r5, (int) r0)
            r0 = 232(0xe8, float:3.25E-43)
            if (r5 < r0) goto L_0x0046
            r0 = 253(0xfd, float:3.55E-43)
            if (r5 >= r0) goto L_0x0046
            return r3
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.a.a.a.s.c(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r1 = a(r0, 5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r0 = a(r0, 6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.a.g.a.a.a.l d() {
        /*
            r7 = this;
        L_0x0000:
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r0 = r0.f3160a
            int r1 = r0 + 5
            com.google.a.c.a r2 = r7.f3173a
            int r2 = r2.f3055b
            r3 = 1
            r4 = 6
            r5 = 5
            if (r1 > r2) goto L_0x002e
            int r1 = r7.a((int) r0, (int) r5)
            r2 = 16
            if (r1 < r5) goto L_0x001b
            if (r1 >= r2) goto L_0x001b
        L_0x0019:
            r0 = 1
            goto L_0x002f
        L_0x001b:
            int r1 = r0 + 6
            com.google.a.c.a r6 = r7.f3173a
            int r6 = r6.f3055b
            if (r1 > r6) goto L_0x002e
            int r0 = r7.a((int) r0, (int) r4)
            if (r0 < r2) goto L_0x002e
            r1 = 63
            if (r0 >= r1) goto L_0x002e
            goto L_0x0019
        L_0x002e:
            r0 = 0
        L_0x002f:
            if (r0 == 0) goto L_0x00c1
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r0 = r0.f3160a
            int r1 = r7.a((int) r0, (int) r5)
            r2 = 15
            if (r1 != r2) goto L_0x0048
            com.google.a.g.a.a.a.n r1 = new com.google.a.g.a.a.a.n
            int r0 = r0 + 5
            r2 = 36
            r1.<init>(r0, r2)
            r2 = r1
            goto L_0x0097
        L_0x0048:
            if (r1 < r5) goto L_0x0058
            if (r1 >= r2) goto L_0x0058
            com.google.a.g.a.a.a.n r2 = new com.google.a.g.a.a.a.n
            int r0 = r0 + 5
            int r1 = r1 + 48
            int r1 = r1 - r5
            char r1 = (char) r1
            r2.<init>(r0, r1)
            goto L_0x0097
        L_0x0058:
            int r1 = r7.a((int) r0, (int) r4)
            r2 = 32
            if (r1 < r2) goto L_0x006f
            r2 = 58
            if (r1 >= r2) goto L_0x006f
            com.google.a.g.a.a.a.n r2 = new com.google.a.g.a.a.a.n
            int r0 = r0 + 6
            int r1 = r1 + 33
            char r1 = (char) r1
            r2.<init>(r0, r1)
            goto L_0x0097
        L_0x006f:
            switch(r1) {
                case 58: goto L_0x008e;
                case 59: goto L_0x008b;
                case 60: goto L_0x0088;
                case 61: goto L_0x0085;
                case 62: goto L_0x0082;
                default: goto L_0x0072;
            }
        L_0x0072:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "Decoding invalid alphanumeric value: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L_0x0082:
            r1 = 47
            goto L_0x0090
        L_0x0085:
            r1 = 46
            goto L_0x0090
        L_0x0088:
            r1 = 45
            goto L_0x0090
        L_0x008b:
            r1 = 44
            goto L_0x0090
        L_0x008e:
            r1 = 42
        L_0x0090:
            com.google.a.g.a.a.a.n r2 = new com.google.a.g.a.a.a.n
            int r0 = r0 + 6
            r2.<init>(r0, r1)
        L_0x0097:
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r1 = r2.d
            r0.f3160a = r1
            boolean r0 = r2.a()
            if (r0 == 0) goto L_0x00b8
            com.google.a.g.a.a.a.o r0 = new com.google.a.g.a.a.a.o
            com.google.a.g.a.a.a.m r1 = r7.f3174b
            int r1 = r1.f3160a
            java.lang.StringBuilder r2 = r7.f3175c
            java.lang.String r2 = r2.toString()
            r0.<init>(r1, r2)
            com.google.a.g.a.a.a.l r1 = new com.google.a.g.a.a.a.l
            r1.<init>(r0, r3)
            return r1
        L_0x00b8:
            java.lang.StringBuilder r0 = r7.f3175c
            char r1 = r2.f3163a
            r0.append(r1)
            goto L_0x0000
        L_0x00c1:
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r0 = r0.f3160a
            boolean r0 = r7.h(r0)
            if (r0 == 0) goto L_0x00d8
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            r1 = 3
            r0.a(r1)
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r1 = com.google.a.g.a.a.a.m.a.NUMERIC$1376b33b
        L_0x00d5:
            r0.f3161b = r1
            goto L_0x0100
        L_0x00d8:
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r0 = r0.f3160a
            boolean r0 = r7.g(r0)
            if (r0 == 0) goto L_0x0100
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r0 = r0.f3160a
            int r0 = r0 + r5
            com.google.a.c.a r1 = r7.f3173a
            int r1 = r1.f3055b
            if (r0 >= r1) goto L_0x00f3
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            r0.a(r5)
            goto L_0x00fb
        L_0x00f3:
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            com.google.a.c.a r1 = r7.f3173a
            int r1 = r1.f3055b
            r0.f3160a = r1
        L_0x00fb:
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r1 = com.google.a.g.a.a.a.m.a.ISO_IEC_646$1376b33b
            goto L_0x00d5
        L_0x0100:
            com.google.a.g.a.a.a.l r0 = new com.google.a.g.a.a.a.l
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.a.a.a.s.d():com.google.a.g.a.a.a.l");
    }

    private n d(int i) throws h {
        char c2;
        int a2 = a(i, 5);
        if (a2 == 15) {
            return new n(i + 5, '$');
        }
        if (a2 >= 5 && a2 < 15) {
            return new n(i + 5, (char) ((a2 + 48) - 5));
        }
        int a3 = a(i, 7);
        if (a3 >= 64 && a3 < 90) {
            return new n(i + 7, (char) (a3 + 1));
        }
        if (a3 >= 90 && a3 < 116) {
            return new n(i + 7, (char) (a3 + 7));
        }
        switch (a(i, 8)) {
            case 232:
                c2 = '!';
                break;
            case 233:
                c2 = '\"';
                break;
            case 234:
                c2 = '%';
                break;
            case 235:
                c2 = '&';
                break;
            case 236:
                c2 = '\'';
                break;
            case 237:
                c2 = '(';
                break;
            case 238:
                c2 = ')';
                break;
            case 239:
                c2 = '*';
                break;
            case 240:
                c2 = '+';
                break;
            case 241:
                c2 = ',';
                break;
            case 242:
                c2 = '-';
                break;
            case 243:
                c2 = FilenameUtils.EXTENSION_SEPARATOR;
                break;
            case 244:
                c2 = IOUtils.DIR_SEPARATOR_UNIX;
                break;
            case 245:
                c2 = ':';
                break;
            case 246:
                c2 = ';';
                break;
            case mobi.oneway.export.a.e /*247*/:
                c2 = '<';
                break;
            case 248:
                c2 = '=';
                break;
            case 249:
                c2 = '>';
                break;
            case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION:
                c2 = '?';
                break;
            case 251:
                c2 = '_';
                break;
            case 252:
                c2 = ' ';
                break;
            default:
                throw h.getFormatInstance();
        }
        return new n(i + 8, c2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r6 = a(r6, 6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int r6) {
        /*
            r5 = this;
            int r0 = r6 + 5
            com.google.a.c.a r1 = r5.f3173a
            int r1 = r1.f3055b
            r2 = 0
            if (r0 <= r1) goto L_0x000a
            return r2
        L_0x000a:
            r0 = 5
            int r1 = r5.a((int) r6, (int) r0)
            r3 = 1
            r4 = 16
            if (r1 < r0) goto L_0x0017
            if (r1 >= r4) goto L_0x0017
            return r3
        L_0x0017:
            int r0 = r6 + 6
            com.google.a.c.a r1 = r5.f3173a
            int r1 = r1.f3055b
            if (r0 <= r1) goto L_0x0020
            return r2
        L_0x0020:
            r0 = 6
            int r6 = r5.a((int) r6, (int) r0)
            if (r6 < r4) goto L_0x002c
            r0 = 63
            if (r6 >= r0) goto L_0x002c
            return r3
        L_0x002c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.a.a.a.s.e(int):boolean");
    }

    private n f(int i) {
        char c2;
        int a2 = a(i, 5);
        if (a2 == 15) {
            return new n(i + 5, '$');
        }
        if (a2 >= 5 && a2 < 15) {
            return new n(i + 5, (char) ((a2 + 48) - 5));
        }
        int a3 = a(i, 6);
        if (a3 >= 32 && a3 < 58) {
            return new n(i + 6, (char) (a3 + 33));
        }
        switch (a3) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = FilenameUtils.EXTENSION_SEPARATOR;
                break;
            case 62:
                c2 = IOUtils.DIR_SEPARATOR_UNIX;
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(a3)));
        }
        return new n(i + 6, c2);
    }

    private boolean g(int i) {
        int i2;
        if (i + 1 > this.f3173a.f3055b) {
            return false;
        }
        int i3 = 0;
        while (i3 < 5 && (i2 = i3 + i) < this.f3173a.f3055b) {
            if (i3 == 2) {
                if (!this.f3173a.a(i + 2)) {
                    return false;
                }
            } else if (this.f3173a.a(i2)) {
                return false;
            }
            i3++;
        }
        return true;
    }

    private boolean h(int i) {
        int i2 = i + 3;
        if (i2 > this.f3173a.f3055b) {
            return false;
        }
        while (i < i2) {
            if (this.f3173a.a(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean i(int i) {
        int i2;
        if (i + 1 > this.f3173a.f3055b) {
            return false;
        }
        int i3 = 0;
        while (i3 < 4 && (i2 = i3 + i) < this.f3173a.f3055b) {
            if (this.f3173a.a(i2)) {
                return false;
            }
            i3++;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int a(int i, int i2) {
        return a(this.f3173a, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0169  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.g.a.a.a.o a(int r8, java.lang.String r9) throws com.google.a.h {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = r7.f3175c
            r1 = 0
            r0.setLength(r1)
            if (r9 == 0) goto L_0x000d
            java.lang.StringBuilder r0 = r7.f3175c
            r0.append(r9)
        L_0x000d:
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            r9.f3160a = r8
        L_0x0011:
            com.google.a.g.a.a.a.m r8 = r7.f3174b
            int r8 = r8.f3160a
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            int r9 = r9.f3161b
            int r0 = com.google.a.g.a.a.a.m.a.ALPHA$1376b33b
            r2 = 1
            if (r9 != r0) goto L_0x0020
            r9 = 1
            goto L_0x0021
        L_0x0020:
            r9 = 0
        L_0x0021:
            if (r9 == 0) goto L_0x0128
        L_0x0023:
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            int r9 = r9.f3160a
            int r0 = r9 + 5
            com.google.a.c.a r3 = r7.f3173a
            int r3 = r3.f3055b
            r4 = 6
            r5 = 5
            if (r0 > r3) goto L_0x0050
            int r0 = r7.a((int) r9, (int) r5)
            r3 = 16
            if (r0 < r5) goto L_0x003d
            if (r0 >= r3) goto L_0x003d
        L_0x003b:
            r9 = 1
            goto L_0x0051
        L_0x003d:
            int r0 = r9 + 6
            com.google.a.c.a r6 = r7.f3173a
            int r6 = r6.f3055b
            if (r0 > r6) goto L_0x0050
            int r9 = r7.a((int) r9, (int) r4)
            if (r9 < r3) goto L_0x0050
            r0 = 63
            if (r9 >= r0) goto L_0x0050
            goto L_0x003b
        L_0x0050:
            r9 = 0
        L_0x0051:
            if (r9 == 0) goto L_0x00e3
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            int r9 = r9.f3160a
            int r0 = r7.a((int) r9, (int) r5)
            r3 = 15
            if (r0 != r3) goto L_0x006a
            com.google.a.g.a.a.a.n r0 = new com.google.a.g.a.a.a.n
            int r9 = r9 + 5
            r3 = 36
            r0.<init>(r9, r3)
            r3 = r0
            goto L_0x00b9
        L_0x006a:
            if (r0 < r5) goto L_0x007a
            if (r0 >= r3) goto L_0x007a
            com.google.a.g.a.a.a.n r3 = new com.google.a.g.a.a.a.n
            int r9 = r9 + 5
            int r0 = r0 + 48
            int r0 = r0 - r5
            char r0 = (char) r0
            r3.<init>(r9, r0)
            goto L_0x00b9
        L_0x007a:
            int r0 = r7.a((int) r9, (int) r4)
            r3 = 32
            if (r0 < r3) goto L_0x0091
            r3 = 58
            if (r0 >= r3) goto L_0x0091
            com.google.a.g.a.a.a.n r3 = new com.google.a.g.a.a.a.n
            int r9 = r9 + 6
            int r0 = r0 + 33
            char r0 = (char) r0
            r3.<init>(r9, r0)
            goto L_0x00b9
        L_0x0091:
            switch(r0) {
                case 58: goto L_0x00b0;
                case 59: goto L_0x00ad;
                case 60: goto L_0x00aa;
                case 61: goto L_0x00a7;
                case 62: goto L_0x00a4;
                default: goto L_0x0094;
            }
        L_0x0094:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Decoding invalid alphanumeric value: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r9 = r9.concat(r0)
            r8.<init>(r9)
            throw r8
        L_0x00a4:
            r0 = 47
            goto L_0x00b2
        L_0x00a7:
            r0 = 46
            goto L_0x00b2
        L_0x00aa:
            r0 = 45
            goto L_0x00b2
        L_0x00ad:
            r0 = 44
            goto L_0x00b2
        L_0x00b0:
            r0 = 42
        L_0x00b2:
            com.google.a.g.a.a.a.n r3 = new com.google.a.g.a.a.a.n
            int r9 = r9 + 6
            r3.<init>(r9, r0)
        L_0x00b9:
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            int r0 = r3.d
            r9.f3160a = r0
            boolean r9 = r3.a()
            if (r9 == 0) goto L_0x00da
            com.google.a.g.a.a.a.o r9 = new com.google.a.g.a.a.a.o
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r0 = r0.f3160a
            java.lang.StringBuilder r3 = r7.f3175c
            java.lang.String r3 = r3.toString()
            r9.<init>(r0, r3)
            com.google.a.g.a.a.a.l r0 = new com.google.a.g.a.a.a.l
            r0.<init>(r9, r2)
            goto L_0x0139
        L_0x00da:
            java.lang.StringBuilder r9 = r7.f3175c
            char r0 = r3.f3163a
            r9.append(r0)
            goto L_0x0023
        L_0x00e3:
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            int r9 = r9.f3160a
            boolean r9 = r7.h(r9)
            if (r9 == 0) goto L_0x00fa
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            r0 = 3
            r9.a(r0)
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            int r0 = com.google.a.g.a.a.a.m.a.NUMERIC$1376b33b
        L_0x00f7:
            r9.f3161b = r0
            goto L_0x0122
        L_0x00fa:
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            int r9 = r9.f3160a
            boolean r9 = r7.g(r9)
            if (r9 == 0) goto L_0x0122
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            int r9 = r9.f3160a
            int r9 = r9 + r5
            com.google.a.c.a r0 = r7.f3173a
            int r0 = r0.f3055b
            if (r9 >= r0) goto L_0x0115
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            r9.a(r5)
            goto L_0x011d
        L_0x0115:
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            com.google.a.c.a r0 = r7.f3173a
            int r0 = r0.f3055b
            r9.f3160a = r0
        L_0x011d:
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            int r0 = com.google.a.g.a.a.a.m.a.ISO_IEC_646$1376b33b
            goto L_0x00f7
        L_0x0122:
            com.google.a.g.a.a.a.l r0 = new com.google.a.g.a.a.a.l
            r0.<init>()
            goto L_0x0139
        L_0x0128:
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            int r9 = r9.f3161b
            int r0 = com.google.a.g.a.a.a.m.a.ISO_IEC_646$1376b33b
            if (r9 != r0) goto L_0x0132
            r9 = 1
            goto L_0x0133
        L_0x0132:
            r9 = 0
        L_0x0133:
            if (r9 == 0) goto L_0x013c
            com.google.a.g.a.a.a.l r0 = r7.c()
        L_0x0139:
            boolean r9 = r0.f3159b
            goto L_0x0141
        L_0x013c:
            com.google.a.g.a.a.a.l r0 = r7.b()
            goto L_0x0139
        L_0x0141:
            com.google.a.g.a.a.a.m r3 = r7.f3174b
            int r3 = r3.f3160a
            if (r8 == r3) goto L_0x0148
            goto L_0x0149
        L_0x0148:
            r2 = 0
        L_0x0149:
            if (r2 != 0) goto L_0x014d
            if (r9 == 0) goto L_0x014f
        L_0x014d:
            if (r9 == 0) goto L_0x0011
        L_0x014f:
            com.google.a.g.a.a.a.o r8 = r0.f3158a
            if (r8 == 0) goto L_0x0169
            boolean r9 = r8.f3166c
            if (r9 == 0) goto L_0x0169
            com.google.a.g.a.a.a.o r9 = new com.google.a.g.a.a.a.o
            com.google.a.g.a.a.a.m r0 = r7.f3174b
            int r0 = r0.f3160a
            java.lang.StringBuilder r1 = r7.f3175c
            java.lang.String r1 = r1.toString()
            int r8 = r8.f3165b
            r9.<init>(r0, r1, r8)
            return r9
        L_0x0169:
            com.google.a.g.a.a.a.o r8 = new com.google.a.g.a.a.a.o
            com.google.a.g.a.a.a.m r9 = r7.f3174b
            int r9 = r9.f3160a
            java.lang.StringBuilder r0 = r7.f3175c
            java.lang.String r0 = r0.toString()
            r8.<init>(r9, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.a.a.a.s.a(int, java.lang.String):com.google.a.g.a.a.a.o");
    }

    /* access modifiers changed from: package-private */
    public final String a(StringBuilder sb, int i) throws com.google.a.m, h {
        String str = null;
        while (true) {
            o a2 = a(i, str);
            String a3 = r.a(a2.f3164a);
            if (a3 != null) {
                sb.append(a3);
            }
            String valueOf = a2.f3166c ? String.valueOf(a2.f3165b) : null;
            if (i == a2.d) {
                return sb.toString();
            }
            i = a2.d;
            str = valueOf;
        }
    }
}

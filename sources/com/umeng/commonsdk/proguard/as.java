package com.umeng.commonsdk.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class as extends az {

    /* renamed from: a  reason: collision with root package name */
    protected static final int f3711a = -65536;

    /* renamed from: b  reason: collision with root package name */
    protected static final int f3712b = -2147418112;
    private static final be h = new be();

    /* renamed from: c  reason: collision with root package name */
    protected boolean f3713c;
    protected boolean d;
    protected int e;
    protected boolean f;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    public static class a implements bb {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f3714a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f3715b;

        /* renamed from: c  reason: collision with root package name */
        protected int f3716c;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f3714a = false;
            this.f3715b = true;
            this.f3714a = z;
            this.f3715b = z2;
            this.f3716c = i;
        }

        public az a(bn bnVar) {
            as asVar = new as(bnVar, this.f3714a, this.f3715b);
            if (this.f3716c != 0) {
                asVar.c(this.f3716c);
            }
            return asVar;
        }
    }

    public as(bn bnVar) {
        this(bnVar, false, true);
    }

    public as(bn bnVar, boolean z, boolean z2) {
        super(bnVar);
        this.f3713c = false;
        this.d = true;
        this.f = false;
        this.i = new byte[1];
        this.j = new byte[2];
        this.k = new byte[4];
        this.l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.f3713c = z;
        this.d = z2;
    }

    private int a(byte[] bArr, int i2, int i3) throws ag {
        d(i3);
        return this.g.d(bArr, i2, i3);
    }

    public ByteBuffer A() throws ag {
        int w = w();
        d(w);
        if (this.g.h() >= w) {
            ByteBuffer wrap = ByteBuffer.wrap(this.g.f(), this.g.g(), w);
            this.g.a(w);
            return wrap;
        }
        byte[] bArr = new byte[w];
        this.g.d(bArr, 0, w);
        return ByteBuffer.wrap(bArr);
    }

    public void a() {
    }

    public void a(byte b2) throws ag {
        this.i[0] = b2;
        this.g.b(this.i, 0, 1);
    }

    public void a(double d2) throws ag {
        a(Double.doubleToLongBits(d2));
    }

    public void a(int i2) throws ag {
        this.k[0] = (byte) ((i2 >> 24) & 255);
        this.k[1] = (byte) ((i2 >> 16) & 255);
        this.k[2] = (byte) ((i2 >> 8) & 255);
        this.k[3] = (byte) (i2 & 255);
        this.g.b(this.k, 0, 4);
    }

    public void a(long j2) throws ag {
        this.l[0] = (byte) ((int) ((j2 >> 56) & 255));
        this.l[1] = (byte) ((int) ((j2 >> 48) & 255));
        this.l[2] = (byte) ((int) ((j2 >> 40) & 255));
        this.l[3] = (byte) ((int) ((j2 >> 32) & 255));
        this.l[4] = (byte) ((int) ((j2 >> 24) & 255));
        this.l[5] = (byte) ((int) ((j2 >> 16) & 255));
        this.l[6] = (byte) ((int) ((j2 >> 8) & 255));
        this.l[7] = (byte) ((int) (j2 & 255));
        this.g.b(this.l, 0, 8);
    }

    public void a(au auVar) throws ag {
        a(auVar.f3725b);
        a(auVar.f3726c);
    }

    public void a(av avVar) throws ag {
        a(avVar.f3727a);
        a(avVar.f3728b);
    }

    public void a(aw awVar) throws ag {
        a(awVar.f3729a);
        a(awVar.f3730b);
        a(awVar.f3731c);
    }

    public void a(ax axVar) throws ag {
        if (this.d) {
            a((int) f3712b | axVar.f3733b);
            a(axVar.f3732a);
        } else {
            a(axVar.f3732a);
            a(axVar.f3733b);
        }
        a(axVar.f3734c);
    }

    public void a(bd bdVar) throws ag {
        a(bdVar.f3745a);
        a(bdVar.f3746b);
    }

    public void a(be beVar) {
    }

    public void a(String str) throws ag {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new ag("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void a(ByteBuffer byteBuffer) throws ag {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    public void a(short s) throws ag {
        this.j[0] = (byte) ((s >> 8) & 255);
        this.j[1] = (byte) (s & 255);
        this.g.b(this.j, 0, 2);
    }

    public void a(boolean z) throws ag {
        a(z ? (byte) 1 : 0);
    }

    public String b(int i2) throws ag {
        try {
            d(i2);
            byte[] bArr = new byte[i2];
            this.g.d(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new ag("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void b() {
    }

    public void c() {
    }

    public void c(int i2) {
        this.e = i2;
        this.f = true;
    }

    public void d() throws ag {
        a((byte) 0);
    }

    /* access modifiers changed from: protected */
    public void d(int i2) throws ag {
        if (i2 < 0) {
            throw new ba("Negative length: " + i2);
        } else if (this.f) {
            this.e -= i2;
            if (this.e < 0) {
                throw new ba("Message length exceeded: " + i2);
            }
        }
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public ax h() throws ag {
        int w = w();
        if (w < 0) {
            if ((-65536 & w) == f3712b) {
                return new ax(z(), (byte) (w & 255), w());
            }
            throw new ba(4, "Bad version in readMessageBegin");
        } else if (!this.f3713c) {
            return new ax(b(w), u(), w());
        } else {
            throw new ba(4, "Missing version in readMessageBegin, old client?");
        }
    }

    public void i() {
    }

    public be j() {
        return h;
    }

    public void k() {
    }

    public au l() throws ag {
        byte u = u();
        return new au("", u, u == 0 ? 0 : v());
    }

    public void m() {
    }

    public aw n() throws ag {
        return new aw(u(), u(), w());
    }

    public void o() {
    }

    public av p() throws ag {
        return new av(u(), w());
    }

    public void q() {
    }

    public bd r() throws ag {
        return new bd(u(), w());
    }

    public void s() {
    }

    public boolean t() throws ag {
        return u() == 1;
    }

    public byte u() throws ag {
        if (this.g.h() > 0) {
            byte b2 = this.g.f()[this.g.g()];
            this.g.a(1);
            return b2;
        }
        a(this.m, 0, 1);
        return this.m[0];
    }

    public short v() throws ag {
        byte[] bArr = this.n;
        int i2 = 0;
        if (this.g.h() >= 2) {
            bArr = this.g.f();
            i2 = this.g.g();
            this.g.a(2);
        } else {
            a(this.n, 0, 2);
        }
        return (short) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    public int w() throws ag {
        byte[] bArr = this.o;
        int i2 = 0;
        if (this.g.h() >= 4) {
            bArr = this.g.f();
            i2 = this.g.g();
            this.g.a(4);
        } else {
            a(this.o, 0, 4);
        }
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << bg.n) | ((bArr[i2 + 2] & 255) << 8);
    }

    public long x() throws ag {
        byte[] bArr = this.p;
        int i2 = 0;
        if (this.g.h() >= 8) {
            bArr = this.g.f();
            i2 = this.g.g();
            this.g.a(8);
        } else {
            a(this.p, 0, 8);
        }
        return (((long) (bArr[i2] & 255)) << 56) | (((long) (bArr[i2 + 1] & 255)) << 48) | (((long) (bArr[i2 + 2] & 255)) << 40) | (((long) (bArr[i2 + 3] & 255)) << 32) | (((long) (bArr[i2 + 4] & 255)) << 24) | (((long) (bArr[i2 + 5] & 255)) << 16) | (((long) (bArr[i2 + 6] & 255)) << 8) | ((long) (bArr[i2 + 7] & 255));
    }

    public double y() throws ag {
        return Double.longBitsToDouble(x());
    }

    public String z() throws ag {
        int w = w();
        if (this.g.h() < w) {
            return b(w);
        }
        try {
            String str = new String(this.g.f(), this.g.g(), w, "UTF-8");
            this.g.a(w);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new ag("JVM DOES NOT SUPPORT UTF-8");
        }
    }
}

package com.umeng.commonsdk.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class at extends az {
    private static final be d = new be("");
    private static final au e = new au("", (byte) 0, 0);
    private static final byte[] f;
    private static final byte h = -126;
    private static final byte i = 1;
    private static final byte j = 31;
    private static final byte k = -32;
    private static final int l = 5;

    /* renamed from: a  reason: collision with root package name */
    byte[] f3717a;

    /* renamed from: b  reason: collision with root package name */
    byte[] f3718b;

    /* renamed from: c  reason: collision with root package name */
    byte[] f3719c;
    private y m;
    private short n;
    private au o;
    private Boolean p;
    private final long q;
    private byte[] r;

    public static class a implements bb {

        /* renamed from: a  reason: collision with root package name */
        private final long f3720a;

        public a() {
            this.f3720a = -1;
        }

        public a(int i) {
            this.f3720a = (long) i;
        }

        public az a(bn bnVar) {
            return new at(bnVar, this.f3720a);
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final byte f3721a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final byte f3722b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final byte f3723c = 3;
        public static final byte d = 4;
        public static final byte e = 5;
        public static final byte f = 6;
        public static final byte g = 7;
        public static final byte h = 8;
        public static final byte i = 9;
        public static final byte j = 10;
        public static final byte k = 11;
        public static final byte l = 12;

        private b() {
        }
    }

    static {
        byte[] bArr = new byte[16];
        f = bArr;
        bArr[0] = 0;
        f[2] = 1;
        f[3] = 3;
        f[6] = 4;
        f[8] = 5;
        f[10] = 6;
        f[4] = 7;
        f[11] = 8;
        f[15] = 9;
        f[14] = 10;
        f[13] = 11;
        f[12] = 12;
    }

    public at(bn bnVar) {
        this(bnVar, -1);
    }

    public at(bn bnVar, long j2) {
        super(bnVar);
        this.m = new y(15);
        this.n = 0;
        this.o = null;
        this.p = null;
        this.f3717a = new byte[5];
        this.f3718b = new byte[10];
        this.r = new byte[1];
        this.f3719c = new byte[1];
        this.q = j2;
    }

    private int E() throws ag {
        int i2 = 0;
        if (this.g.h() >= 5) {
            byte[] f2 = this.g.f();
            int g = this.g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = f2[g + i2];
                i3 |= (b2 & Byte.MAX_VALUE) << i4;
                if ((b2 & 128) == 128) {
                    i4 += 7;
                    i2++;
                } else {
                    this.g.a(i2 + 1);
                    return i3;
                }
            }
        } else {
            int i5 = 0;
            while (true) {
                byte u = u();
                i2 |= (u & Byte.MAX_VALUE) << i5;
                if ((u & 128) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() throws ag {
        int i2 = 0;
        long j2 = 0;
        if (this.g.h() >= 10) {
            byte[] f2 = this.g.f();
            int g = this.g.g();
            int i3 = 0;
            while (true) {
                byte b2 = f2[g + i2];
                long j3 = j2 | (((long) (b2 & Byte.MAX_VALUE)) << i3);
                if ((b2 & 128) == 128) {
                    i3 += 7;
                    i2++;
                    j2 = j3;
                } else {
                    this.g.a(i2 + 1);
                    return j3;
                }
            }
        } else {
            while (true) {
                byte u = u();
                long j4 = j2 | (((long) (u & Byte.MAX_VALUE)) << i2);
                if ((u & 128) != 128) {
                    return j4;
                }
                i2 += 7;
                j2 = j4;
            }
        }
    }

    private long a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (((long) bArr[0]) & 255);
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) ((int) (j2 & 255));
        bArr[i2 + 1] = (byte) ((int) ((j2 >> 8) & 255));
        bArr[i2 + 2] = (byte) ((int) ((j2 >> 16) & 255));
        bArr[i2 + 3] = (byte) ((int) ((j2 >> 24) & 255));
        bArr[i2 + 4] = (byte) ((int) ((j2 >> 32) & 255));
        bArr[i2 + 5] = (byte) ((int) ((j2 >> 40) & 255));
        bArr[i2 + 6] = (byte) ((int) ((j2 >> 48) & 255));
        bArr[i2 + 7] = (byte) ((int) ((j2 >> 56) & 255));
    }

    private void a(au auVar, byte b2) throws ag {
        if (b2 == -1) {
            b2 = e(auVar.f3725b);
        }
        if (auVar.f3726c <= this.n || auVar.f3726c - this.n > 15) {
            b(b2);
            a(auVar.f3726c);
        } else {
            d((int) b2 | ((auVar.f3726c - this.n) << 4));
        }
        this.n = auVar.f3726c;
    }

    private void a(byte[] bArr, int i2, int i3) throws ag {
        b(i3);
        this.g.b(bArr, i2, i3);
    }

    private void b(byte b2) throws ag {
        this.r[0] = b2;
        this.g.b(this.r);
    }

    private void b(int i2) throws ag {
        int i3 = 0;
        while ((i2 & -128) != 0) {
            this.f3717a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        this.f3717a[i3] = (byte) i2;
        this.g.b(this.f3717a, 0, i3 + 1);
    }

    private void b(long j2) throws ag {
        int i2 = 0;
        while ((j2 & -128) != 0) {
            this.f3718b[i2] = (byte) ((int) ((j2 & 127) | 128));
            j2 >>>= 7;
            i2++;
        }
        this.f3718b[i2] = (byte) ((int) j2);
        this.g.b(this.f3718b, 0, i2 + 1);
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 << 1) ^ (j2 >> 63);
    }

    private boolean c(byte b2) {
        byte b3 = b2 & bg.m;
        return b3 == 1 || b3 == 2;
    }

    private byte d(byte b2) throws ba {
        byte b3 = (byte) (b2 & bg.m);
        switch (b3) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 6;
            case 5:
                return 8;
            case 6:
                return 10;
            case 7:
                return 4;
            case 8:
                return 11;
            case 9:
                return bg.m;
            case 10:
                return bg.l;
            case 11:
                return bg.k;
            case 12:
                return 12;
            default:
                throw new ba("don't know what type: " + b3);
        }
    }

    private long d(long j2) {
        return (j2 >>> 1) ^ (-(j2 & 1));
    }

    private void d(int i2) throws ag {
        b((byte) i2);
    }

    private byte e(byte b2) {
        return f[b2];
    }

    private byte[] e(int i2) throws ag {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws ba {
        if (i2 < 0) {
            throw new ba("Negative length: " + i2);
        } else if (this.q != -1 && ((long) i2) > this.q) {
            throw new ba("Length exceeded max allowed: " + i2);
        }
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public ByteBuffer A() throws ag {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    public void B() {
        this.m.c();
        this.n = 0;
    }

    public void a() throws ag {
    }

    public void a(byte b2) throws ag {
        b(b2);
    }

    /* access modifiers changed from: protected */
    public void a(byte b2, int i2) throws ag {
        if (i2 <= 14) {
            d((int) e(b2) | (i2 << 4));
            return;
        }
        d((int) e(b2) | 240);
        b(i2);
    }

    public void a(double d2) throws ag {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.g.b(bArr);
    }

    public void a(int i2) throws ag {
        b(c(i2));
    }

    public void a(long j2) throws ag {
        b(c(j2));
    }

    public void a(au auVar) throws ag {
        if (auVar.f3725b == 2) {
            this.o = auVar;
        } else {
            a(auVar, (byte) -1);
        }
    }

    public void a(av avVar) throws ag {
        a(avVar.f3727a, avVar.f3728b);
    }

    public void a(aw awVar) throws ag {
        byte e2;
        if (awVar.f3731c == 0) {
            e2 = 0;
        } else {
            b(awVar.f3731c);
            e2 = e(awVar.f3730b) | (e(awVar.f3729a) << 4);
        }
        d((int) e2);
    }

    public void a(ax axVar) throws ag {
        b((byte) h);
        d(((axVar.f3733b << 5) & -32) | 1);
        b(axVar.f3734c);
        a(axVar.f3732a);
    }

    public void a(bd bdVar) throws ag {
        a(bdVar.f3745a, bdVar.f3746b);
    }

    public void a(be beVar) throws ag {
        this.m.a(this.n);
        this.n = 0;
    }

    public void a(String str) throws ag {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new ag("UTF-8 not supported!");
        }
    }

    public void a(ByteBuffer byteBuffer) throws ag {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    public void a(short s) throws ag {
        b(c((int) s));
    }

    public void a(boolean z) throws ag {
        byte b2 = 2;
        if (this.o != null) {
            au auVar = this.o;
            if (z) {
                b2 = 1;
            }
            a(auVar, b2);
            this.o = null;
            return;
        }
        if (z) {
            b2 = 1;
        }
        b(b2);
    }

    public void b() throws ag {
        this.n = this.m.a();
    }

    public void c() throws ag {
    }

    public void d() throws ag {
        b((byte) 0);
    }

    public void e() throws ag {
    }

    public void f() throws ag {
    }

    public void g() throws ag {
    }

    public ax h() throws ag {
        byte u = u();
        if (u != -126) {
            throw new ba("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u));
        }
        byte u2 = u();
        byte b2 = (byte) (u2 & j);
        if (b2 != 1) {
            throw new ba("Expected version 1 but got " + b2);
        }
        int E = E();
        return new ax(z(), (byte) ((u2 >> 5) & 3), E);
    }

    public void i() throws ag {
    }

    public be j() throws ag {
        this.m.a(this.n);
        this.n = 0;
        return d;
    }

    public void k() throws ag {
        this.n = this.m.a();
    }

    public au l() throws ag {
        byte u = u();
        if (u == 0) {
            return e;
        }
        short s = (short) ((u & 240) >> 4);
        short v = s == 0 ? v() : (short) (this.n + s);
        byte b2 = (byte) (u & bg.m);
        au auVar = new au("", d(b2), v);
        if (c(u)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = auVar.f3726c;
        return auVar;
    }

    public void m() throws ag {
    }

    public aw n() throws ag {
        int E = E();
        byte u = E == 0 ? 0 : u();
        return new aw(d((byte) (u >> 4)), d((byte) (u & bg.m)), E);
    }

    public void o() throws ag {
    }

    public av p() throws ag {
        byte u = u();
        int i2 = (u >> 4) & 15;
        if (i2 == 15) {
            i2 = E();
        }
        return new av(d(u), i2);
    }

    public void q() throws ag {
    }

    public bd r() throws ag {
        return new bd(p());
    }

    public void s() throws ag {
    }

    public boolean t() throws ag {
        if (this.p == null) {
            return u() == 1;
        }
        boolean booleanValue = this.p.booleanValue();
        this.p = null;
        return booleanValue;
    }

    public byte u() throws ag {
        if (this.g.h() > 0) {
            byte b2 = this.g.f()[this.g.g()];
            this.g.a(1);
            return b2;
        }
        this.g.d(this.f3719c, 0, 1);
        return this.f3719c[0];
    }

    public short v() throws ag {
        return (short) g(E());
    }

    public int w() throws ag {
        return g(E());
    }

    public long x() throws ag {
        return d(F());
    }

    public double y() throws ag {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    public String z() throws ag {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.g.h() < E) {
                return new String(e(E), "UTF-8");
            }
            String str = new String(this.g.f(), this.g.g(), E, "UTF-8");
            this.g.a(E);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new ag("UTF-8 not supported!");
        }
    }
}

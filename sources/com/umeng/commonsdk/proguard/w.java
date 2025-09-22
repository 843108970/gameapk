package com.umeng.commonsdk.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.grandcentrix.tray.provider.ContentProviderStorage;

public class w implements aa<w, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final Map<e, am> k;
    private static final long l = 420342210744516016L;
    /* access modifiers changed from: private */
    public static final be m = new be("UMEnvelope");
    /* access modifiers changed from: private */
    public static final au n = new au(ContentProviderStorage.VERSION, (byte) 11, 1);
    /* access modifiers changed from: private */
    public static final au o = new au("address", (byte) 11, 2);
    /* access modifiers changed from: private */
    public static final au p = new au("signature", (byte) 11, 3);
    /* access modifiers changed from: private */
    public static final au q = new au("serial_num", (byte) 8, 4);
    /* access modifiers changed from: private */
    public static final au r = new au("ts_secs", (byte) 8, 5);
    /* access modifiers changed from: private */
    public static final au s = new au("length", (byte) 8, 6);
    /* access modifiers changed from: private */
    public static final au t = new au("entity", (byte) 11, 7);
    /* access modifiers changed from: private */
    public static final au u = new au("guid", (byte) 11, 8);
    /* access modifiers changed from: private */
    public static final au v = new au("checksum", (byte) 11, 9);
    /* access modifiers changed from: private */
    public static final au w = new au("codex", (byte) 8, 10);
    private static final Map<Class<? extends bh>, bi> x;
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;

    /* renamed from: a  reason: collision with root package name */
    public String f3830a;

    /* renamed from: b  reason: collision with root package name */
    public String f3831b;

    /* renamed from: c  reason: collision with root package name */
    public String f3832c;
    public int d;
    public int e;
    public int f;
    public ByteBuffer g;
    public String h;
    public String i;
    public int j;

    private static class a extends bj<w> {
        private a() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(com.umeng.commonsdk.proguard.az r6, com.umeng.commonsdk.proguard.w r7) throws com.umeng.commonsdk.proguard.ag {
            /*
                r5 = this;
                r6.j()
            L_0x0003:
                com.umeng.commonsdk.proguard.au r0 = r6.l()
                byte r1 = r0.f3725b
                if (r1 == 0) goto L_0x00ae
                short r1 = r0.f3726c
                r2 = 8
                r3 = 11
                r4 = 1
                switch(r1) {
                    case 1: goto L_0x009c;
                    case 2: goto L_0x008e;
                    case 3: goto L_0x0080;
                    case 4: goto L_0x0072;
                    case 5: goto L_0x0064;
                    case 6: goto L_0x0056;
                    case 7: goto L_0x0048;
                    case 8: goto L_0x003a;
                    case 9: goto L_0x002b;
                    case 10: goto L_0x001c;
                    default: goto L_0x0015;
                }
            L_0x0015:
                byte r0 = r0.f3725b
                com.umeng.commonsdk.proguard.bc.a((com.umeng.commonsdk.proguard.az) r6, (byte) r0)
                goto L_0x00a9
            L_0x001c:
                byte r1 = r0.f3725b
                if (r1 != r2) goto L_0x0015
                int r0 = r6.w()
                r7.j = r0
                r7.j(r4)
                goto L_0x00a9
            L_0x002b:
                byte r1 = r0.f3725b
                if (r1 != r3) goto L_0x0015
                java.lang.String r0 = r6.z()
                r7.i = r0
                r7.i(r4)
                goto L_0x00a9
            L_0x003a:
                byte r1 = r0.f3725b
                if (r1 != r3) goto L_0x0015
                java.lang.String r0 = r6.z()
                r7.h = r0
                r7.h(r4)
                goto L_0x00a9
            L_0x0048:
                byte r1 = r0.f3725b
                if (r1 != r3) goto L_0x0015
                java.nio.ByteBuffer r0 = r6.A()
                r7.g = r0
                r7.g(r4)
                goto L_0x00a9
            L_0x0056:
                byte r1 = r0.f3725b
                if (r1 != r2) goto L_0x0015
                int r0 = r6.w()
                r7.f = r0
                r7.f(r4)
                goto L_0x00a9
            L_0x0064:
                byte r1 = r0.f3725b
                if (r1 != r2) goto L_0x0015
                int r0 = r6.w()
                r7.e = r0
                r7.e((boolean) r4)
                goto L_0x00a9
            L_0x0072:
                byte r1 = r0.f3725b
                if (r1 != r2) goto L_0x0015
                int r0 = r6.w()
                r7.d = r0
                r7.d((boolean) r4)
                goto L_0x00a9
            L_0x0080:
                byte r1 = r0.f3725b
                if (r1 != r3) goto L_0x0015
                java.lang.String r0 = r6.z()
                r7.f3832c = r0
                r7.c((boolean) r4)
                goto L_0x00a9
            L_0x008e:
                byte r1 = r0.f3725b
                if (r1 != r3) goto L_0x0015
                java.lang.String r0 = r6.z()
                r7.f3831b = r0
                r7.b((boolean) r4)
                goto L_0x00a9
            L_0x009c:
                byte r1 = r0.f3725b
                if (r1 != r3) goto L_0x0015
                java.lang.String r0 = r6.z()
                r7.f3830a = r0
                r7.a((boolean) r4)
            L_0x00a9:
                r6.m()
                goto L_0x0003
            L_0x00ae:
                r6.k()
                boolean r6 = r7.m()
                if (r6 != 0) goto L_0x00cf
                com.umeng.commonsdk.proguard.ba r6 = new com.umeng.commonsdk.proguard.ba
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r0 = "Required field 'serial_num' was not found in serialized data! Struct: "
                r7.<init>(r0)
                java.lang.String r0 = r5.toString()
                r7.append(r0)
                java.lang.String r7 = r7.toString()
                r6.<init>((java.lang.String) r7)
                throw r6
            L_0x00cf:
                boolean r6 = r7.p()
                if (r6 != 0) goto L_0x00ed
                com.umeng.commonsdk.proguard.ba r6 = new com.umeng.commonsdk.proguard.ba
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r0 = "Required field 'ts_secs' was not found in serialized data! Struct: "
                r7.<init>(r0)
                java.lang.String r0 = r5.toString()
                r7.append(r0)
                java.lang.String r7 = r7.toString()
                r6.<init>((java.lang.String) r7)
                throw r6
            L_0x00ed:
                boolean r6 = r7.s()
                if (r6 != 0) goto L_0x010b
                com.umeng.commonsdk.proguard.ba r6 = new com.umeng.commonsdk.proguard.ba
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r0 = "Required field 'length' was not found in serialized data! Struct: "
                r7.<init>(r0)
                java.lang.String r0 = r5.toString()
                r7.append(r0)
                java.lang.String r7 = r7.toString()
                r6.<init>((java.lang.String) r7)
                throw r6
            L_0x010b:
                r7.G()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.w.a.b(com.umeng.commonsdk.proguard.az, com.umeng.commonsdk.proguard.w):void");
        }

        /* renamed from: b */
        public void a(az azVar, w wVar) throws ag {
            wVar.G();
            azVar.a(w.m);
            if (wVar.f3830a != null) {
                azVar.a(w.n);
                azVar.a(wVar.f3830a);
                azVar.c();
            }
            if (wVar.f3831b != null) {
                azVar.a(w.o);
                azVar.a(wVar.f3831b);
                azVar.c();
            }
            if (wVar.f3832c != null) {
                azVar.a(w.p);
                azVar.a(wVar.f3832c);
                azVar.c();
            }
            azVar.a(w.q);
            azVar.a(wVar.d);
            azVar.c();
            azVar.a(w.r);
            azVar.a(wVar.e);
            azVar.c();
            azVar.a(w.s);
            azVar.a(wVar.f);
            azVar.c();
            if (wVar.g != null) {
                azVar.a(w.t);
                azVar.a(wVar.g);
                azVar.c();
            }
            if (wVar.h != null) {
                azVar.a(w.u);
                azVar.a(wVar.h);
                azVar.c();
            }
            if (wVar.i != null) {
                azVar.a(w.v);
                azVar.a(wVar.i);
                azVar.c();
            }
            if (wVar.F()) {
                azVar.a(w.w);
                azVar.a(wVar.j);
                azVar.c();
            }
            azVar.d();
            azVar.b();
        }
    }

    private static class b implements bi {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    private static class c extends bk<w> {
        private c() {
        }

        public void a(az azVar, w wVar) throws ag {
            bf bfVar = (bf) azVar;
            bfVar.a(wVar.f3830a);
            bfVar.a(wVar.f3831b);
            bfVar.a(wVar.f3832c);
            bfVar.a(wVar.d);
            bfVar.a(wVar.e);
            bfVar.a(wVar.f);
            bfVar.a(wVar.g);
            bfVar.a(wVar.h);
            bfVar.a(wVar.i);
            BitSet bitSet = new BitSet();
            if (wVar.F()) {
                bitSet.set(0);
            }
            bfVar.a(bitSet, 1);
            if (wVar.F()) {
                bfVar.a(wVar.j);
            }
        }

        public void b(az azVar, w wVar) throws ag {
            bf bfVar = (bf) azVar;
            wVar.f3830a = bfVar.z();
            wVar.a(true);
            wVar.f3831b = bfVar.z();
            wVar.b(true);
            wVar.f3832c = bfVar.z();
            wVar.c(true);
            wVar.d = bfVar.w();
            wVar.d(true);
            wVar.e = bfVar.w();
            wVar.e(true);
            wVar.f = bfVar.w();
            wVar.f(true);
            wVar.g = bfVar.A();
            wVar.g(true);
            wVar.h = bfVar.z();
            wVar.h(true);
            wVar.i = bfVar.z();
            wVar.i(true);
            if (bfVar.b(1).get(0)) {
                wVar.j = bfVar.w();
                wVar.j(true);
            }
        }
    }

    private static class d implements bi {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    public enum e implements ah {
        VERSION(1, ContentProviderStorage.VERSION),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");
        
        private static final Map<String, e> k = null;
        private final short l;
        private final String m;

        static {
            k = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                k.put(eVar.b(), eVar);
            }
        }

        private e(short s, String str) {
            this.l = s;
            this.m = str;
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
        }

        public static e a(String str) {
            return k.get(str);
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public final short a() {
            return this.l;
        }

        public final String b() {
            return this.m;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        x = hashMap;
        hashMap.put(bj.class, new b());
        x.put(bk.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.VERSION, new am(ContentProviderStorage.VERSION, (byte) 1, new an((byte) 11)));
        enumMap.put(e.ADDRESS, new am("address", (byte) 1, new an((byte) 11)));
        enumMap.put(e.SIGNATURE, new am("signature", (byte) 1, new an((byte) 11)));
        enumMap.put(e.SERIAL_NUM, new am("serial_num", (byte) 1, new an((byte) 8)));
        enumMap.put(e.TS_SECS, new am("ts_secs", (byte) 1, new an((byte) 8)));
        enumMap.put(e.LENGTH, new am("length", (byte) 1, new an((byte) 8)));
        enumMap.put(e.ENTITY, new am("entity", (byte) 1, new an((byte) 11, true)));
        enumMap.put(e.GUID, new am("guid", (byte) 1, new an((byte) 11)));
        enumMap.put(e.CHECKSUM, new am("checksum", (byte) 1, new an((byte) 11)));
        enumMap.put(e.CODEX, new am("codex", (byte) 2, new an((byte) 8)));
        k = Collections.unmodifiableMap(enumMap);
        am.a(w.class, k);
    }

    public w() {
        this.C = 0;
        this.D = new e[]{e.CODEX};
    }

    public w(w wVar) {
        this.C = 0;
        this.D = new e[]{e.CODEX};
        this.C = wVar.C;
        if (wVar.d()) {
            this.f3830a = wVar.f3830a;
        }
        if (wVar.g()) {
            this.f3831b = wVar.f3831b;
        }
        if (wVar.j()) {
            this.f3832c = wVar.f3832c;
        }
        this.d = wVar.d;
        this.e = wVar.e;
        this.f = wVar.f;
        if (wVar.w()) {
            this.g = ab.d(wVar.g);
        }
        if (wVar.z()) {
            this.h = wVar.h;
        }
        if (wVar.C()) {
            this.i = wVar.i;
        }
        this.j = wVar.j;
    }

    public w(String str, String str2, String str3, int i2, int i3, int i4, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f3830a = str;
        this.f3831b = str2;
        this.f3832c = str3;
        this.d = i2;
        d(true);
        this.e = i3;
        e(true);
        this.f = i4;
        f(true);
        this.g = byteBuffer;
        this.h = str4;
        this.i = str5;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.C = 0;
            read(new at(new bl((InputStream) objectInputStream)));
        } catch (ag e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new at(new bl((OutputStream) objectOutputStream)));
        } catch (ag e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public String A() {
        return this.i;
    }

    public void B() {
        this.i = null;
    }

    public boolean C() {
        return this.i != null;
    }

    public int D() {
        return this.j;
    }

    public void E() {
        this.C = x.b(this.C, 3);
    }

    public boolean F() {
        return x.a(this.C, 3);
    }

    public void G() throws ag {
        if (this.f3830a == null) {
            throw new ba("Required field 'version' was not present! Struct: " + toString());
        } else if (this.f3831b == null) {
            throw new ba("Required field 'address' was not present! Struct: " + toString());
        } else if (this.f3832c == null) {
            throw new ba("Required field 'signature' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new ba("Required field 'entity' was not present! Struct: " + toString());
        } else if (this.h == null) {
            throw new ba("Required field 'guid' was not present! Struct: " + toString());
        } else if (this.i == null) {
            throw new ba("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    public w deepCopy() {
        return new w(this);
    }

    public w a(int i2) {
        this.d = i2;
        d(true);
        return this;
    }

    public w a(String str) {
        this.f3830a = str;
        return this;
    }

    public w a(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
        return this;
    }

    public w a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public void a(boolean z2) {
        if (!z2) {
            this.f3830a = null;
        }
    }

    public w b(int i2) {
        this.e = i2;
        e(true);
        return this;
    }

    public w b(String str) {
        this.f3831b = str;
        return this;
    }

    public String b() {
        return this.f3830a;
    }

    public void b(boolean z2) {
        if (!z2) {
            this.f3831b = null;
        }
    }

    public w c(int i2) {
        this.f = i2;
        f(true);
        return this;
    }

    public w c(String str) {
        this.f3832c = str;
        return this;
    }

    public void c() {
        this.f3830a = null;
    }

    public void c(boolean z2) {
        if (!z2) {
            this.f3832c = null;
        }
    }

    public void clear() {
        this.f3830a = null;
        this.f3831b = null;
        this.f3832c = null;
        d(false);
        this.d = 0;
        e(false);
        this.e = 0;
        f(false);
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public w d(int i2) {
        this.j = i2;
        j(true);
        return this;
    }

    public w d(String str) {
        this.h = str;
        return this;
    }

    public void d(boolean z2) {
        this.C = x.a(this.C, 0, z2);
    }

    public boolean d() {
        return this.f3830a != null;
    }

    /* renamed from: e */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public w e(String str) {
        this.i = str;
        return this;
    }

    public String e() {
        return this.f3831b;
    }

    public void e(boolean z2) {
        this.C = x.a(this.C, 1, z2);
    }

    public void f() {
        this.f3831b = null;
    }

    public void f(boolean z2) {
        this.C = x.a(this.C, 2, z2);
    }

    public void g(boolean z2) {
        if (!z2) {
            this.g = null;
        }
    }

    public boolean g() {
        return this.f3831b != null;
    }

    public String h() {
        return this.f3832c;
    }

    public void h(boolean z2) {
        if (!z2) {
            this.h = null;
        }
    }

    public void i() {
        this.f3832c = null;
    }

    public void i(boolean z2) {
        if (!z2) {
            this.i = null;
        }
    }

    public void j(boolean z2) {
        this.C = x.a(this.C, 3, z2);
    }

    public boolean j() {
        return this.f3832c != null;
    }

    public int k() {
        return this.d;
    }

    public void l() {
        this.C = x.b(this.C, 0);
    }

    public boolean m() {
        return x.a(this.C, 0);
    }

    public int n() {
        return this.e;
    }

    public void o() {
        this.C = x.b(this.C, 1);
    }

    public boolean p() {
        return x.a(this.C, 1);
    }

    public int q() {
        return this.f;
    }

    public void r() {
        this.C = x.b(this.C, 2);
    }

    public void read(az azVar) throws ag {
        x.get(azVar.D()).b().b(azVar, this);
    }

    public boolean s() {
        return x.a(this.C, 2);
    }

    public byte[] t() {
        a(ab.c(this.g));
        if (this.g == null) {
            return null;
        }
        return this.g.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        sb.append(this.f3830a == null ? "null" : this.f3830a);
        sb.append(", ");
        sb.append("address:");
        sb.append(this.f3831b == null ? "null" : this.f3831b);
        sb.append(", ");
        sb.append("signature:");
        sb.append(this.f3832c == null ? "null" : this.f3832c);
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f);
        sb.append(", ");
        sb.append("entity:");
        if (this.g == null) {
            sb.append("null");
        } else {
            ab.a(this.g, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        sb.append(this.h == null ? "null" : this.h);
        sb.append(", ");
        sb.append("checksum:");
        sb.append(this.i == null ? "null" : this.i);
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.g;
    }

    public void v() {
        this.g = null;
    }

    public boolean w() {
        return this.g != null;
    }

    public void write(az azVar) throws ag {
        x.get(azVar.D()).b().a(azVar, this);
    }

    public String x() {
        return this.h;
    }

    public void y() {
        this.h = null;
    }

    public boolean z() {
        return this.h != null;
    }
}

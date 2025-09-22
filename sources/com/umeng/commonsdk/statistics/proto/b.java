package com.umeng.commonsdk.statistics.proto;

import com.umeng.commonsdk.proguard.aa;
import com.umeng.commonsdk.proguard.ag;
import com.umeng.commonsdk.proguard.ah;
import com.umeng.commonsdk.proguard.am;
import com.umeng.commonsdk.proguard.an;
import com.umeng.commonsdk.proguard.at;
import com.umeng.commonsdk.proguard.au;
import com.umeng.commonsdk.proguard.az;
import com.umeng.commonsdk.proguard.ba;
import com.umeng.commonsdk.proguard.be;
import com.umeng.commonsdk.proguard.bf;
import com.umeng.commonsdk.proguard.bh;
import com.umeng.commonsdk.proguard.bi;
import com.umeng.commonsdk.proguard.bj;
import com.umeng.commonsdk.proguard.bk;
import com.umeng.commonsdk.proguard.bl;
import com.umeng.commonsdk.proguard.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.grandcentrix.tray.provider.ContentProviderStorage;

public class b implements aa<b, e>, Serializable, Cloneable {
    public static final Map<e, am> d;
    private static final long e = -6496538196005191531L;
    /* access modifiers changed from: private */
    public static final be f = new be("IdSnapshot");
    /* access modifiers changed from: private */
    public static final au g = new au("identity", (byte) 11, 1);
    /* access modifiers changed from: private */
    public static final au h = new au("ts", (byte) 10, 2);
    /* access modifiers changed from: private */
    public static final au i = new au(ContentProviderStorage.VERSION, (byte) 8, 3);
    private static final Map<Class<? extends bh>, bi> j;
    private static final int k = 0;
    private static final int l = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f3961a;

    /* renamed from: b  reason: collision with root package name */
    public long f3962b;

    /* renamed from: c  reason: collision with root package name */
    public int f3963c;
    private byte m;

    private static class a extends bj<b> {
        private a() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(com.umeng.commonsdk.proguard.az r5, com.umeng.commonsdk.statistics.proto.b r6) throws com.umeng.commonsdk.proguard.ag {
            /*
                r4 = this;
                r5.j()
            L_0x0003:
                com.umeng.commonsdk.proguard.au r0 = r5.l()
                byte r1 = r0.f3725b
                if (r1 == 0) goto L_0x004a
                short r1 = r0.f3726c
                r2 = 1
                switch(r1) {
                    case 1: goto L_0x0037;
                    case 2: goto L_0x0027;
                    case 3: goto L_0x0017;
                    default: goto L_0x0011;
                }
            L_0x0011:
                byte r0 = r0.f3725b
                com.umeng.commonsdk.proguard.bc.a((com.umeng.commonsdk.proguard.az) r5, (byte) r0)
                goto L_0x0046
            L_0x0017:
                byte r1 = r0.f3725b
                r3 = 8
                if (r1 != r3) goto L_0x0011
                int r0 = r5.w()
                r6.f3963c = r0
                r6.c(r2)
                goto L_0x0046
            L_0x0027:
                byte r1 = r0.f3725b
                r3 = 10
                if (r1 != r3) goto L_0x0011
                long r0 = r5.x()
                r6.f3962b = r0
                r6.b((boolean) r2)
                goto L_0x0046
            L_0x0037:
                byte r1 = r0.f3725b
                r3 = 11
                if (r1 != r3) goto L_0x0011
                java.lang.String r0 = r5.z()
                r6.f3961a = r0
                r6.a((boolean) r2)
            L_0x0046:
                r5.m()
                goto L_0x0003
            L_0x004a:
                r5.k()
                boolean r5 = r6.g()
                if (r5 != 0) goto L_0x006b
                com.umeng.commonsdk.proguard.ba r5 = new com.umeng.commonsdk.proguard.ba
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r0 = "Required field 'ts' was not found in serialized data! Struct: "
                r6.<init>(r0)
                java.lang.String r0 = r4.toString()
                r6.append(r0)
                java.lang.String r6 = r6.toString()
                r5.<init>((java.lang.String) r6)
                throw r5
            L_0x006b:
                boolean r5 = r6.j()
                if (r5 != 0) goto L_0x0089
                com.umeng.commonsdk.proguard.ba r5 = new com.umeng.commonsdk.proguard.ba
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r0 = "Required field 'version' was not found in serialized data! Struct: "
                r6.<init>(r0)
                java.lang.String r0 = r4.toString()
                r6.append(r0)
                java.lang.String r6 = r6.toString()
                r5.<init>((java.lang.String) r6)
                throw r5
            L_0x0089:
                r6.k()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.proto.b.a.b(com.umeng.commonsdk.proguard.az, com.umeng.commonsdk.statistics.proto.b):void");
        }

        /* renamed from: b */
        public void a(az azVar, b bVar) throws ag {
            bVar.k();
            azVar.a(b.f);
            if (bVar.f3961a != null) {
                azVar.a(b.g);
                azVar.a(bVar.f3961a);
                azVar.c();
            }
            azVar.a(b.h);
            azVar.a(bVar.f3962b);
            azVar.c();
            azVar.a(b.i);
            azVar.a(bVar.f3963c);
            azVar.c();
            azVar.d();
            azVar.b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b  reason: collision with other inner class name */
    private static class C0059b implements bi {
        private C0059b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    private static class c extends bk<b> {
        private c() {
        }

        public void a(az azVar, b bVar) throws ag {
            bf bfVar = (bf) azVar;
            bfVar.a(bVar.f3961a);
            bfVar.a(bVar.f3962b);
            bfVar.a(bVar.f3963c);
        }

        public void b(az azVar, b bVar) throws ag {
            bf bfVar = (bf) azVar;
            bVar.f3961a = bfVar.z();
            bVar.a(true);
            bVar.f3962b = bfVar.x();
            bVar.b(true);
            bVar.f3963c = bfVar.w();
            bVar.c(true);
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
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, ContentProviderStorage.VERSION);
        
        private static final Map<String, e> d = null;
        private final short e;
        private final String f;

        static {
            d = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        private e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return IDENTITY;
                case 2:
                    return TS;
                case 3:
                    return VERSION;
                default:
                    return null;
            }
        }

        public static e a(String str) {
            return d.get(str);
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public final short a() {
            return this.e;
        }

        public final String b() {
            return this.f;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(bj.class, new C0059b());
        j.put(bk.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.IDENTITY, new am("identity", (byte) 1, new an((byte) 11)));
        enumMap.put(e.TS, new am("ts", (byte) 1, new an((byte) 10)));
        enumMap.put(e.VERSION, new am(ContentProviderStorage.VERSION, (byte) 1, new an((byte) 8)));
        d = Collections.unmodifiableMap(enumMap);
        am.a(b.class, d);
    }

    public b() {
        this.m = 0;
    }

    public b(b bVar) {
        this.m = 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.f3961a = bVar.f3961a;
        }
        this.f3962b = bVar.f3962b;
        this.f3963c = bVar.f3963c;
    }

    public b(String str, long j2, int i2) {
        this();
        this.f3961a = str;
        this.f3962b = j2;
        b(true);
        this.f3963c = i2;
        c(true);
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.m = 0;
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

    /* renamed from: a */
    public b deepCopy() {
        return new b(this);
    }

    public b a(int i2) {
        this.f3963c = i2;
        c(true);
        return this;
    }

    public b a(long j2) {
        this.f3962b = j2;
        b(true);
        return this;
    }

    public b a(String str) {
        this.f3961a = str;
        return this;
    }

    public void a(boolean z) {
        if (!z) {
            this.f3961a = null;
        }
    }

    /* renamed from: b */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public String b() {
        return this.f3961a;
    }

    public void b(boolean z) {
        this.m = x.a(this.m, 0, z);
    }

    public void c() {
        this.f3961a = null;
    }

    public void c(boolean z) {
        this.m = x.a(this.m, 1, z);
    }

    public void clear() {
        this.f3961a = null;
        b(false);
        this.f3962b = 0;
        c(false);
        this.f3963c = 0;
    }

    public boolean d() {
        return this.f3961a != null;
    }

    public long e() {
        return this.f3962b;
    }

    public void f() {
        this.m = x.b(this.m, 0);
    }

    public boolean g() {
        return x.a(this.m, 0);
    }

    public int h() {
        return this.f3963c;
    }

    public void i() {
        this.m = x.b(this.m, 1);
    }

    public boolean j() {
        return x.a(this.m, 1);
    }

    public void k() throws ag {
        if (this.f3961a == null) {
            throw new ba("Required field 'identity' was not present! Struct: " + toString());
        }
    }

    public void read(az azVar) throws ag {
        j.get(azVar.D()).b().b(azVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        sb.append(this.f3961a == null ? "null" : this.f3961a);
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f3962b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f3963c);
        sb.append(")");
        return sb.toString();
    }

    public void write(az azVar) throws ag {
        j.get(azVar.D()).b().a(azVar, this);
    }
}

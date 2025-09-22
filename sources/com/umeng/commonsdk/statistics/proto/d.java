package com.umeng.commonsdk.statistics.proto;

import com.umeng.commonsdk.proguard.aa;
import com.umeng.commonsdk.proguard.ag;
import com.umeng.commonsdk.proguard.ah;
import com.umeng.commonsdk.proguard.am;
import com.umeng.commonsdk.proguard.an;
import com.umeng.commonsdk.proguard.ap;
import com.umeng.commonsdk.proguard.ar;
import com.umeng.commonsdk.proguard.at;
import com.umeng.commonsdk.proguard.au;
import com.umeng.commonsdk.proguard.aw;
import com.umeng.commonsdk.proguard.az;
import com.umeng.commonsdk.proguard.ba;
import com.umeng.commonsdk.proguard.be;
import com.umeng.commonsdk.proguard.bf;
import com.umeng.commonsdk.proguard.bg;
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

public class d implements aa<d, e>, Serializable, Cloneable {
    public static final Map<e, am> d;
    private static final long e = 2846460275012375038L;
    /* access modifiers changed from: private */
    public static final be f = new be("Imprint");
    /* access modifiers changed from: private */
    public static final au g = new au("property", bg.k, 1);
    /* access modifiers changed from: private */
    public static final au h = new au(ContentProviderStorage.VERSION, (byte) 8, 2);
    /* access modifiers changed from: private */
    public static final au i = new au("checksum", (byte) 11, 3);
    private static final Map<Class<? extends bh>, bi> j;
    private static final int k = 0;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, e> f3973a;

    /* renamed from: b  reason: collision with root package name */
    public int f3974b;

    /* renamed from: c  reason: collision with root package name */
    public String f3975c;
    private byte l;

    private static class a extends bj<d> {
        private a() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(com.umeng.commonsdk.proguard.az r7, com.umeng.commonsdk.statistics.proto.d r8) throws com.umeng.commonsdk.proguard.ag {
            /*
                r6 = this;
                r7.j()
            L_0x0003:
                com.umeng.commonsdk.proguard.au r0 = r7.l()
                byte r1 = r0.f3725b
                if (r1 == 0) goto L_0x006f
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
                com.umeng.commonsdk.proguard.bc.a((com.umeng.commonsdk.proguard.az) r7, (byte) r0)
                goto L_0x006b
            L_0x0017:
                byte r1 = r0.f3725b
                r3 = 11
                if (r1 != r3) goto L_0x0011
                java.lang.String r0 = r7.z()
                r8.f3975c = r0
                r8.c(r2)
                goto L_0x006b
            L_0x0027:
                byte r1 = r0.f3725b
                r3 = 8
                if (r1 != r3) goto L_0x0011
                int r0 = r7.w()
                r8.f3974b = r0
                r8.b((boolean) r2)
                goto L_0x006b
            L_0x0037:
                byte r1 = r0.f3725b
                r3 = 13
                if (r1 != r3) goto L_0x0011
                com.umeng.commonsdk.proguard.aw r0 = r7.n()
                java.util.HashMap r1 = new java.util.HashMap
                int r3 = r0.f3731c
                int r3 = r3 * 2
                r1.<init>(r3)
                r8.f3973a = r1
                r1 = 0
            L_0x004d:
                int r3 = r0.f3731c
                if (r1 >= r3) goto L_0x0065
                java.lang.String r3 = r7.z()
                com.umeng.commonsdk.statistics.proto.e r4 = new com.umeng.commonsdk.statistics.proto.e
                r4.<init>()
                r4.read(r7)
                java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.e> r5 = r8.f3973a
                r5.put(r3, r4)
                int r1 = r1 + 1
                goto L_0x004d
            L_0x0065:
                r7.o()
                r8.a((boolean) r2)
            L_0x006b:
                r7.m()
                goto L_0x0003
            L_0x006f:
                r7.k()
                boolean r7 = r8.h()
                if (r7 != 0) goto L_0x0090
                com.umeng.commonsdk.proguard.ba r7 = new com.umeng.commonsdk.proguard.ba
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r0 = "Required field 'version' was not found in serialized data! Struct: "
                r8.<init>(r0)
                java.lang.String r0 = r6.toString()
                r8.append(r0)
                java.lang.String r8 = r8.toString()
                r7.<init>((java.lang.String) r8)
                throw r7
            L_0x0090:
                r8.l()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.proto.d.a.b(com.umeng.commonsdk.proguard.az, com.umeng.commonsdk.statistics.proto.d):void");
        }

        /* renamed from: b */
        public void a(az azVar, d dVar) throws ag {
            dVar.l();
            azVar.a(d.f);
            if (dVar.f3973a != null) {
                azVar.a(d.g);
                azVar.a(new aw((byte) 11, (byte) 12, dVar.f3973a.size()));
                for (Map.Entry next : dVar.f3973a.entrySet()) {
                    azVar.a((String) next.getKey());
                    ((e) next.getValue()).write(azVar);
                }
                azVar.e();
                azVar.c();
            }
            azVar.a(d.h);
            azVar.a(dVar.f3974b);
            azVar.c();
            if (dVar.f3975c != null) {
                azVar.a(d.i);
                azVar.a(dVar.f3975c);
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

    private static class c extends bk<d> {
        private c() {
        }

        public void a(az azVar, d dVar) throws ag {
            bf bfVar = (bf) azVar;
            bfVar.a(dVar.f3973a.size());
            for (Map.Entry next : dVar.f3973a.entrySet()) {
                bfVar.a((String) next.getKey());
                ((e) next.getValue()).write(bfVar);
            }
            bfVar.a(dVar.f3974b);
            bfVar.a(dVar.f3975c);
        }

        public void b(az azVar, d dVar) throws ag {
            bf bfVar = (bf) azVar;
            aw awVar = new aw((byte) 11, (byte) 12, bfVar.w());
            dVar.f3973a = new HashMap(awVar.f3731c * 2);
            for (int i = 0; i < awVar.f3731c; i++) {
                String z = bfVar.z();
                e eVar = new e();
                eVar.read(bfVar);
                dVar.f3973a.put(z, eVar);
            }
            dVar.a(true);
            dVar.f3974b = bfVar.w();
            dVar.b(true);
            dVar.f3975c = bfVar.z();
            dVar.c(true);
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d  reason: collision with other inner class name */
    private static class C0061d implements bi {
        private C0061d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    public enum e implements ah {
        PROPERTY(1, "property"),
        VERSION(2, ContentProviderStorage.VERSION),
        CHECKSUM(3, "checksum");
        
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
                    return PROPERTY;
                case 2:
                    return VERSION;
                case 3:
                    return CHECKSUM;
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
        hashMap.put(bj.class, new b());
        j.put(bk.class, new C0061d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.PROPERTY, new am("property", (byte) 1, new ap(bg.k, new an((byte) 11), new ar((byte) 12, e.class))));
        enumMap.put(e.VERSION, new am(ContentProviderStorage.VERSION, (byte) 1, new an((byte) 8)));
        enumMap.put(e.CHECKSUM, new am("checksum", (byte) 1, new an((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        am.a(d.class, d);
    }

    public d() {
        this.l = 0;
    }

    public d(d dVar) {
        this.l = 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : dVar.f3973a.entrySet()) {
                hashMap.put((String) next.getKey(), new e((e) next.getValue()));
            }
            this.f3973a = hashMap;
        }
        this.f3974b = dVar.f3974b;
        if (dVar.k()) {
            this.f3975c = dVar.f3975c;
        }
    }

    public d(Map<String, e> map, int i2, String str) {
        this();
        this.f3973a = map;
        this.f3974b = i2;
        b(true);
        this.f3975c = str;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.l = 0;
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
    public d deepCopy() {
        return new d(this);
    }

    public d a(int i2) {
        this.f3974b = i2;
        b(true);
        return this;
    }

    public d a(String str) {
        this.f3975c = str;
        return this;
    }

    public d a(Map<String, e> map) {
        this.f3973a = map;
        return this;
    }

    public void a(String str, e eVar) {
        if (this.f3973a == null) {
            this.f3973a = new HashMap();
        }
        this.f3973a.put(str, eVar);
    }

    public void a(boolean z) {
        if (!z) {
            this.f3973a = null;
        }
    }

    public int b() {
        if (this.f3973a == null) {
            return 0;
        }
        return this.f3973a.size();
    }

    /* renamed from: b */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public void b(boolean z) {
        this.l = x.a(this.l, 0, z);
    }

    public Map<String, e> c() {
        return this.f3973a;
    }

    public void c(boolean z) {
        if (!z) {
            this.f3975c = null;
        }
    }

    public void clear() {
        this.f3973a = null;
        b(false);
        this.f3974b = 0;
        this.f3975c = null;
    }

    public void d() {
        this.f3973a = null;
    }

    public boolean e() {
        return this.f3973a != null;
    }

    public int f() {
        return this.f3974b;
    }

    public void g() {
        this.l = x.b(this.l, 0);
    }

    public boolean h() {
        return x.a(this.l, 0);
    }

    public String i() {
        return this.f3975c;
    }

    public void j() {
        this.f3975c = null;
    }

    public boolean k() {
        return this.f3975c != null;
    }

    public void l() throws ag {
        if (this.f3973a == null) {
            throw new ba("Required field 'property' was not present! Struct: " + toString());
        } else if (this.f3975c == null) {
            throw new ba("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    public void read(az azVar) throws ag {
        j.get(azVar.D()).b().b(azVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        if (this.f3973a == null) {
            sb.append("null");
        } else {
            sb.append(this.f3973a);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f3974b);
        sb.append(", ");
        sb.append("checksum:");
        sb.append(this.f3975c == null ? "null" : this.f3975c);
        sb.append(")");
        return sb.toString();
    }

    public void write(az azVar) throws ag {
        j.get(azVar.D()).b().a(azVar, this);
    }
}

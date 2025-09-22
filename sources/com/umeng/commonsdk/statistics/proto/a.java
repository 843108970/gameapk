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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class a implements aa<a, e>, Serializable, Cloneable {
    public static final Map<e, am> e;
    private static final long f = 9132678615281394583L;
    /* access modifiers changed from: private */
    public static final be g = new be("IdJournal");
    /* access modifiers changed from: private */
    public static final au h = new au("domain", (byte) 11, 1);
    /* access modifiers changed from: private */
    public static final au i = new au("old_id", (byte) 11, 2);
    /* access modifiers changed from: private */
    public static final au j = new au("new_id", (byte) 11, 3);
    /* access modifiers changed from: private */
    public static final au k = new au("ts", (byte) 10, 4);
    private static final Map<Class<? extends bh>, bi> l;
    private static final int m = 0;

    /* renamed from: a  reason: collision with root package name */
    public String f3955a;

    /* renamed from: b  reason: collision with root package name */
    public String f3956b;

    /* renamed from: c  reason: collision with root package name */
    public String f3957c;
    public long d;
    private byte n;
    private e[] o;

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a  reason: collision with other inner class name */
    private static class C0058a extends bj<a> {
        private C0058a() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(com.umeng.commonsdk.proguard.az r5, com.umeng.commonsdk.statistics.proto.a r6) throws com.umeng.commonsdk.proguard.ag {
            /*
                r4 = this;
                r5.j()
            L_0x0003:
                com.umeng.commonsdk.proguard.au r0 = r5.l()
                byte r1 = r0.f3725b
                if (r1 == 0) goto L_0x0056
                short r1 = r0.f3726c
                r2 = 11
                r3 = 1
                switch(r1) {
                    case 1: goto L_0x0045;
                    case 2: goto L_0x0037;
                    case 3: goto L_0x0029;
                    case 4: goto L_0x0019;
                    default: goto L_0x0013;
                }
            L_0x0013:
                byte r0 = r0.f3725b
                com.umeng.commonsdk.proguard.bc.a((com.umeng.commonsdk.proguard.az) r5, (byte) r0)
                goto L_0x0052
            L_0x0019:
                byte r1 = r0.f3725b
                r2 = 10
                if (r1 != r2) goto L_0x0013
                long r0 = r5.x()
                r6.d = r0
                r6.d(r3)
                goto L_0x0052
            L_0x0029:
                byte r1 = r0.f3725b
                if (r1 != r2) goto L_0x0013
                java.lang.String r0 = r5.z()
                r6.f3957c = r0
                r6.c((boolean) r3)
                goto L_0x0052
            L_0x0037:
                byte r1 = r0.f3725b
                if (r1 != r2) goto L_0x0013
                java.lang.String r0 = r5.z()
                r6.f3956b = r0
                r6.b((boolean) r3)
                goto L_0x0052
            L_0x0045:
                byte r1 = r0.f3725b
                if (r1 != r2) goto L_0x0013
                java.lang.String r0 = r5.z()
                r6.f3955a = r0
                r6.a((boolean) r3)
            L_0x0052:
                r5.m()
                goto L_0x0003
            L_0x0056:
                r5.k()
                boolean r5 = r6.m()
                if (r5 != 0) goto L_0x0077
                com.umeng.commonsdk.proguard.ba r5 = new com.umeng.commonsdk.proguard.ba
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r0 = "Required field 'ts' was not found in serialized data! Struct: "
                r6.<init>(r0)
                java.lang.String r0 = r4.toString()
                r6.append(r0)
                java.lang.String r6 = r6.toString()
                r5.<init>((java.lang.String) r6)
                throw r5
            L_0x0077:
                r6.n()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.proto.a.C0058a.b(com.umeng.commonsdk.proguard.az, com.umeng.commonsdk.statistics.proto.a):void");
        }

        /* renamed from: b */
        public void a(az azVar, a aVar) throws ag {
            aVar.n();
            azVar.a(a.g);
            if (aVar.f3955a != null) {
                azVar.a(a.h);
                azVar.a(aVar.f3955a);
                azVar.c();
            }
            if (aVar.f3956b != null && aVar.g()) {
                azVar.a(a.i);
                azVar.a(aVar.f3956b);
                azVar.c();
            }
            if (aVar.f3957c != null) {
                azVar.a(a.j);
                azVar.a(aVar.f3957c);
                azVar.c();
            }
            azVar.a(a.k);
            azVar.a(aVar.d);
            azVar.c();
            azVar.d();
            azVar.b();
        }
    }

    private static class b implements bi {
        private b() {
        }

        /* renamed from: a */
        public C0058a b() {
            return new C0058a();
        }
    }

    private static class c extends bk<a> {
        private c() {
        }

        public void a(az azVar, a aVar) throws ag {
            bf bfVar = (bf) azVar;
            bfVar.a(aVar.f3955a);
            bfVar.a(aVar.f3957c);
            bfVar.a(aVar.d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            bfVar.a(bitSet, 1);
            if (aVar.g()) {
                bfVar.a(aVar.f3956b);
            }
        }

        public void b(az azVar, a aVar) throws ag {
            bf bfVar = (bf) azVar;
            aVar.f3955a = bfVar.z();
            aVar.a(true);
            aVar.f3957c = bfVar.z();
            aVar.c(true);
            aVar.d = bfVar.x();
            aVar.d(true);
            if (bfVar.b(1).get(0)) {
                aVar.f3956b = bfVar.z();
                aVar.b(true);
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
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");
        
        private static final Map<String, e> e = null;
        private final short f;
        private final String g;

        static {
            e = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                e.put(eVar.b(), eVar);
            }
        }

        private e(short s, String str) {
            this.f = s;
            this.g = str;
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return DOMAIN;
                case 2:
                    return OLD_ID;
                case 3:
                    return NEW_ID;
                case 4:
                    return TS;
                default:
                    return null;
            }
        }

        public static e a(String str) {
            return e.get(str);
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public final short a() {
            return this.f;
        }

        public final String b() {
            return this.g;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        l = hashMap;
        hashMap.put(bj.class, new b());
        l.put(bk.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.DOMAIN, new am("domain", (byte) 1, new an((byte) 11)));
        enumMap.put(e.OLD_ID, new am("old_id", (byte) 2, new an((byte) 11)));
        enumMap.put(e.NEW_ID, new am("new_id", (byte) 1, new an((byte) 11)));
        enumMap.put(e.TS, new am("ts", (byte) 1, new an((byte) 10)));
        e = Collections.unmodifiableMap(enumMap);
        am.a(a.class, e);
    }

    public a() {
        this.n = 0;
        this.o = new e[]{e.OLD_ID};
    }

    public a(a aVar) {
        this.n = 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.f3955a = aVar.f3955a;
        }
        if (aVar.g()) {
            this.f3956b = aVar.f3956b;
        }
        if (aVar.j()) {
            this.f3957c = aVar.f3957c;
        }
        this.d = aVar.d;
    }

    public a(String str, String str2, long j2) {
        this();
        this.f3955a = str;
        this.f3957c = str2;
        this.d = j2;
        d(true);
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.n = 0;
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
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    /* renamed from: a */
    public a deepCopy() {
        return new a(this);
    }

    public a a(long j2) {
        this.d = j2;
        d(true);
        return this;
    }

    public a a(String str) {
        this.f3955a = str;
        return this;
    }

    public void a(boolean z) {
        if (!z) {
            this.f3955a = null;
        }
    }

    public a b(String str) {
        this.f3956b = str;
        return this;
    }

    public String b() {
        return this.f3955a;
    }

    public void b(boolean z) {
        if (!z) {
            this.f3956b = null;
        }
    }

    public a c(String str) {
        this.f3957c = str;
        return this;
    }

    public void c() {
        this.f3955a = null;
    }

    public void c(boolean z) {
        if (!z) {
            this.f3957c = null;
        }
    }

    public void clear() {
        this.f3955a = null;
        this.f3956b = null;
        this.f3957c = null;
        d(false);
        this.d = 0;
    }

    public void d(boolean z) {
        this.n = x.a(this.n, 0, z);
    }

    public boolean d() {
        return this.f3955a != null;
    }

    public String e() {
        return this.f3956b;
    }

    public void f() {
        this.f3956b = null;
    }

    public boolean g() {
        return this.f3956b != null;
    }

    public String h() {
        return this.f3957c;
    }

    public void i() {
        this.f3957c = null;
    }

    public boolean j() {
        return this.f3957c != null;
    }

    public long k() {
        return this.d;
    }

    public void l() {
        this.n = x.b(this.n, 0);
    }

    public boolean m() {
        return x.a(this.n, 0);
    }

    public void n() throws ag {
        if (this.f3955a == null) {
            throw new ba("Required field 'domain' was not present! Struct: " + toString());
        } else if (this.f3957c == null) {
            throw new ba("Required field 'new_id' was not present! Struct: " + toString());
        }
    }

    public void read(az azVar) throws ag {
        l.get(azVar.D()).b().b(azVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        sb.append(this.f3955a == null ? "null" : this.f3955a);
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            sb.append(this.f3956b == null ? "null" : this.f3956b);
        }
        sb.append(", ");
        sb.append("new_id:");
        sb.append(this.f3957c == null ? "null" : this.f3957c);
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.d);
        sb.append(")");
        return sb.toString();
    }

    public void write(az azVar) throws ag {
        l.get(azVar.D()).b().a(azVar, this);
    }
}

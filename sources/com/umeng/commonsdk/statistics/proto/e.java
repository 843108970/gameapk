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

public class e implements aa<e, C0062e>, Serializable, Cloneable {
    public static final Map<C0062e, am> d;
    private static final long e = 7501688097813630241L;
    /* access modifiers changed from: private */
    public static final be f = new be("ImprintValue");
    /* access modifiers changed from: private */
    public static final au g = new au("value", (byte) 11, 1);
    /* access modifiers changed from: private */
    public static final au h = new au("ts", (byte) 10, 2);
    /* access modifiers changed from: private */
    public static final au i = new au("guid", (byte) 11, 3);
    private static final Map<Class<? extends bh>, bi> j;
    private static final int k = 0;

    /* renamed from: a  reason: collision with root package name */
    public String f3979a;

    /* renamed from: b  reason: collision with root package name */
    public long f3980b;

    /* renamed from: c  reason: collision with root package name */
    public String f3981c;
    private byte l;
    private C0062e[] m;

    private static class a extends bj<e> {
        private a() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(com.umeng.commonsdk.proguard.az r5, com.umeng.commonsdk.statistics.proto.e r6) throws com.umeng.commonsdk.proguard.ag {
            /*
                r4 = this;
                r5.j()
            L_0x0003:
                com.umeng.commonsdk.proguard.au r0 = r5.l()
                byte r1 = r0.f3725b
                if (r1 == 0) goto L_0x0048
                short r1 = r0.f3726c
                r2 = 11
                r3 = 1
                switch(r1) {
                    case 1: goto L_0x0037;
                    case 2: goto L_0x0027;
                    case 3: goto L_0x0019;
                    default: goto L_0x0013;
                }
            L_0x0013:
                byte r0 = r0.f3725b
                com.umeng.commonsdk.proguard.bc.a((com.umeng.commonsdk.proguard.az) r5, (byte) r0)
                goto L_0x0044
            L_0x0019:
                byte r1 = r0.f3725b
                if (r1 != r2) goto L_0x0013
                java.lang.String r0 = r5.z()
                r6.f3981c = r0
                r6.c(r3)
                goto L_0x0044
            L_0x0027:
                byte r1 = r0.f3725b
                r2 = 10
                if (r1 != r2) goto L_0x0013
                long r0 = r5.x()
                r6.f3980b = r0
                r6.b((boolean) r3)
                goto L_0x0044
            L_0x0037:
                byte r1 = r0.f3725b
                if (r1 != r2) goto L_0x0013
                java.lang.String r0 = r5.z()
                r6.f3979a = r0
                r6.a((boolean) r3)
            L_0x0044:
                r5.m()
                goto L_0x0003
            L_0x0048:
                r5.k()
                boolean r5 = r6.g()
                if (r5 != 0) goto L_0x0069
                com.umeng.commonsdk.proguard.ba r5 = new com.umeng.commonsdk.proguard.ba
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r0 = "Required field 'ts' was not found in serialized data! Struct: "
                r6.<init>(r0)
                java.lang.String r0 = r4.toString()
                r6.append(r0)
                java.lang.String r6 = r6.toString()
                r5.<init>((java.lang.String) r6)
                throw r5
            L_0x0069:
                r6.k()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.proto.e.a.b(com.umeng.commonsdk.proguard.az, com.umeng.commonsdk.statistics.proto.e):void");
        }

        /* renamed from: b */
        public void a(az azVar, e eVar) throws ag {
            eVar.k();
            azVar.a(e.f);
            if (eVar.f3979a != null && eVar.d()) {
                azVar.a(e.g);
                azVar.a(eVar.f3979a);
                azVar.c();
            }
            azVar.a(e.h);
            azVar.a(eVar.f3980b);
            azVar.c();
            if (eVar.f3981c != null) {
                azVar.a(e.i);
                azVar.a(eVar.f3981c);
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

    private static class c extends bk<e> {
        private c() {
        }

        public void a(az azVar, e eVar) throws ag {
            bf bfVar = (bf) azVar;
            bfVar.a(eVar.f3980b);
            bfVar.a(eVar.f3981c);
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            bfVar.a(bitSet, 1);
            if (eVar.d()) {
                bfVar.a(eVar.f3979a);
            }
        }

        public void b(az azVar, e eVar) throws ag {
            bf bfVar = (bf) azVar;
            eVar.f3980b = bfVar.x();
            eVar.b(true);
            eVar.f3981c = bfVar.z();
            eVar.c(true);
            if (bfVar.b(1).get(0)) {
                eVar.f3979a = bfVar.z();
                eVar.a(true);
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

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e  reason: collision with other inner class name */
    public enum C0062e implements ah {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");
        
        private static final Map<String, C0062e> d = null;
        private final short e;
        private final String f;

        static {
            d = new HashMap();
            Iterator it = EnumSet.allOf(C0062e.class).iterator();
            while (it.hasNext()) {
                C0062e eVar = (C0062e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        private C0062e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static C0062e a(int i) {
            switch (i) {
                case 1:
                    return VALUE;
                case 2:
                    return TS;
                case 3:
                    return GUID;
                default:
                    return null;
            }
        }

        public static C0062e a(String str) {
            return d.get(str);
        }

        public static C0062e b(int i) {
            C0062e a2 = a(i);
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
        j.put(bk.class, new d());
        EnumMap enumMap = new EnumMap(C0062e.class);
        enumMap.put(C0062e.VALUE, new am("value", (byte) 2, new an((byte) 11)));
        enumMap.put(C0062e.TS, new am("ts", (byte) 1, new an((byte) 10)));
        enumMap.put(C0062e.GUID, new am("guid", (byte) 1, new an((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        am.a(e.class, d);
    }

    public e() {
        this.l = 0;
        this.m = new C0062e[]{C0062e.VALUE};
    }

    public e(long j2, String str) {
        this();
        this.f3980b = j2;
        b(true);
        this.f3981c = str;
    }

    public e(e eVar) {
        this.l = 0;
        this.m = new C0062e[]{C0062e.VALUE};
        this.l = eVar.l;
        if (eVar.d()) {
            this.f3979a = eVar.f3979a;
        }
        this.f3980b = eVar.f3980b;
        if (eVar.j()) {
            this.f3981c = eVar.f3981c;
        }
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
    public C0062e fieldForId(int i2) {
        return C0062e.a(i2);
    }

    /* renamed from: a */
    public e deepCopy() {
        return new e(this);
    }

    public e a(long j2) {
        this.f3980b = j2;
        b(true);
        return this;
    }

    public e a(String str) {
        this.f3979a = str;
        return this;
    }

    public void a(boolean z) {
        if (!z) {
            this.f3979a = null;
        }
    }

    public e b(String str) {
        this.f3981c = str;
        return this;
    }

    public String b() {
        return this.f3979a;
    }

    public void b(boolean z) {
        this.l = x.a(this.l, 0, z);
    }

    public void c() {
        this.f3979a = null;
    }

    public void c(boolean z) {
        if (!z) {
            this.f3981c = null;
        }
    }

    public void clear() {
        this.f3979a = null;
        b(false);
        this.f3980b = 0;
        this.f3981c = null;
    }

    public boolean d() {
        return this.f3979a != null;
    }

    public long e() {
        return this.f3980b;
    }

    public void f() {
        this.l = x.b(this.l, 0);
    }

    public boolean g() {
        return x.a(this.l, 0);
    }

    public String h() {
        return this.f3981c;
    }

    public void i() {
        this.f3981c = null;
    }

    public boolean j() {
        return this.f3981c != null;
    }

    public void k() throws ag {
        if (this.f3981c == null) {
            throw new ba("Required field 'guid' was not present! Struct: " + toString());
        }
    }

    public void read(az azVar) throws ag {
        j.get(azVar.D()).b().b(azVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            sb.append(this.f3979a == null ? "null" : this.f3979a);
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f3980b);
        sb.append(", ");
        sb.append("guid:");
        sb.append(this.f3981c == null ? "null" : this.f3981c);
        sb.append(")");
        return sb.toString();
    }

    public void write(az azVar) throws ag {
        j.get(azVar.D()).b().a(azVar, this);
    }
}

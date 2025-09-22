package com.umeng.commonsdk.statistics.proto;

import com.umeng.commonsdk.proguard.aa;
import com.umeng.commonsdk.proguard.ag;
import com.umeng.commonsdk.proguard.ah;
import com.umeng.commonsdk.proguard.am;
import com.umeng.commonsdk.proguard.an;
import com.umeng.commonsdk.proguard.ao;
import com.umeng.commonsdk.proguard.ap;
import com.umeng.commonsdk.proguard.ar;
import com.umeng.commonsdk.proguard.at;
import com.umeng.commonsdk.proguard.au;
import com.umeng.commonsdk.proguard.av;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c implements aa<c, e>, Serializable, Cloneable {
    public static final Map<e, am> d;
    private static final long e = -5764118265293965743L;
    /* access modifiers changed from: private */
    public static final be f = new be("IdTracking");
    /* access modifiers changed from: private */
    public static final au g = new au("snapshots", bg.k, 1);
    /* access modifiers changed from: private */
    public static final au h = new au("journals", bg.m, 2);
    /* access modifiers changed from: private */
    public static final au i = new au("checksum", (byte) 11, 3);
    private static final Map<Class<? extends bh>, bi> j;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, b> f3967a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f3968b;

    /* renamed from: c  reason: collision with root package name */
    public String f3969c;
    private e[] k;

    private static class a extends bj<c> {
        private a() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(com.umeng.commonsdk.proguard.az r7, com.umeng.commonsdk.statistics.proto.c r8) throws com.umeng.commonsdk.proguard.ag {
            /*
                r6 = this;
                r7.j()
            L_0x0003:
                com.umeng.commonsdk.proguard.au r0 = r7.l()
                byte r1 = r0.f3725b
                if (r1 == 0) goto L_0x008f
                short r1 = r0.f3726c
                r2 = 0
                r3 = 1
                switch(r1) {
                    case 1: goto L_0x0057;
                    case 2: goto L_0x0029;
                    case 3: goto L_0x0019;
                    default: goto L_0x0012;
                }
            L_0x0012:
                byte r0 = r0.f3725b
                com.umeng.commonsdk.proguard.bc.a((com.umeng.commonsdk.proguard.az) r7, (byte) r0)
                goto L_0x008a
            L_0x0019:
                byte r1 = r0.f3725b
                r2 = 11
                if (r1 != r2) goto L_0x0012
                java.lang.String r0 = r7.z()
                r8.f3969c = r0
                r8.c(r3)
                goto L_0x008a
            L_0x0029:
                byte r1 = r0.f3725b
                r4 = 15
                if (r1 != r4) goto L_0x0012
                com.umeng.commonsdk.proguard.av r0 = r7.p()
                java.util.ArrayList r1 = new java.util.ArrayList
                int r4 = r0.f3728b
                r1.<init>(r4)
                r8.f3968b = r1
            L_0x003c:
                int r1 = r0.f3728b
                if (r2 >= r1) goto L_0x0050
                com.umeng.commonsdk.statistics.proto.a r1 = new com.umeng.commonsdk.statistics.proto.a
                r1.<init>()
                r1.read(r7)
                java.util.List<com.umeng.commonsdk.statistics.proto.a> r4 = r8.f3968b
                r4.add(r1)
                int r2 = r2 + 1
                goto L_0x003c
            L_0x0050:
                r7.q()
                r8.b(r3)
                goto L_0x008a
            L_0x0057:
                byte r1 = r0.f3725b
                r4 = 13
                if (r1 != r4) goto L_0x0012
                com.umeng.commonsdk.proguard.aw r0 = r7.n()
                java.util.HashMap r1 = new java.util.HashMap
                int r4 = r0.f3731c
                int r4 = r4 * 2
                r1.<init>(r4)
                r8.f3967a = r1
            L_0x006c:
                int r1 = r0.f3731c
                if (r2 >= r1) goto L_0x0084
                java.lang.String r1 = r7.z()
                com.umeng.commonsdk.statistics.proto.b r4 = new com.umeng.commonsdk.statistics.proto.b
                r4.<init>()
                r4.read(r7)
                java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.b> r5 = r8.f3967a
                r5.put(r1, r4)
                int r2 = r2 + 1
                goto L_0x006c
            L_0x0084:
                r7.o()
                r8.a((boolean) r3)
            L_0x008a:
                r7.m()
                goto L_0x0003
            L_0x008f:
                r7.k()
                r8.n()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.proto.c.a.b(com.umeng.commonsdk.proguard.az, com.umeng.commonsdk.statistics.proto.c):void");
        }

        /* renamed from: b */
        public void a(az azVar, c cVar) throws ag {
            cVar.n();
            azVar.a(c.f);
            if (cVar.f3967a != null) {
                azVar.a(c.g);
                azVar.a(new aw((byte) 11, (byte) 12, cVar.f3967a.size()));
                for (Map.Entry next : cVar.f3967a.entrySet()) {
                    azVar.a((String) next.getKey());
                    ((b) next.getValue()).write(azVar);
                }
                azVar.e();
                azVar.c();
            }
            if (cVar.f3968b != null && cVar.j()) {
                azVar.a(c.h);
                azVar.a(new av((byte) 12, cVar.f3968b.size()));
                for (a write : cVar.f3968b) {
                    write.write(azVar);
                }
                azVar.f();
                azVar.c();
            }
            if (cVar.f3969c != null && cVar.m()) {
                azVar.a(c.i);
                azVar.a(cVar.f3969c);
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

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c  reason: collision with other inner class name */
    private static class C0060c extends bk<c> {
        private C0060c() {
        }

        public void a(az azVar, c cVar) throws ag {
            bf bfVar = (bf) azVar;
            bfVar.a(cVar.f3967a.size());
            for (Map.Entry next : cVar.f3967a.entrySet()) {
                bfVar.a((String) next.getKey());
                ((b) next.getValue()).write(bfVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            bfVar.a(bitSet, 2);
            if (cVar.j()) {
                bfVar.a(cVar.f3968b.size());
                for (a write : cVar.f3968b) {
                    write.write(bfVar);
                }
            }
            if (cVar.m()) {
                bfVar.a(cVar.f3969c);
            }
        }

        public void b(az azVar, c cVar) throws ag {
            bf bfVar = (bf) azVar;
            aw awVar = new aw((byte) 11, (byte) 12, bfVar.w());
            cVar.f3967a = new HashMap(awVar.f3731c * 2);
            for (int i = 0; i < awVar.f3731c; i++) {
                String z = bfVar.z();
                b bVar = new b();
                bVar.read(bfVar);
                cVar.f3967a.put(z, bVar);
            }
            cVar.a(true);
            BitSet b2 = bfVar.b(2);
            if (b2.get(0)) {
                av avVar = new av((byte) 12, bfVar.w());
                cVar.f3968b = new ArrayList(avVar.f3728b);
                for (int i2 = 0; i2 < avVar.f3728b; i2++) {
                    a aVar = new a();
                    aVar.read(bfVar);
                    cVar.f3968b.add(aVar);
                }
                cVar.b(true);
            }
            if (b2.get(1)) {
                cVar.f3969c = bfVar.z();
                cVar.c(true);
            }
        }
    }

    private static class d implements bi {
        private d() {
        }

        /* renamed from: a */
        public C0060c b() {
            return new C0060c();
        }
    }

    public enum e implements ah {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
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
                    return SNAPSHOTS;
                case 2:
                    return JOURNALS;
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
        j.put(bk.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.SNAPSHOTS, new am("snapshots", (byte) 1, new ap(bg.k, new an((byte) 11), new ar((byte) 12, b.class))));
        enumMap.put(e.JOURNALS, new am("journals", (byte) 2, new ao(bg.m, new ar((byte) 12, a.class))));
        enumMap.put(e.CHECKSUM, new am("checksum", (byte) 2, new an((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        am.a(c.class, d);
    }

    public c() {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    public c(c cVar) {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : cVar.f3967a.entrySet()) {
                hashMap.put((String) next.getKey(), new b((b) next.getValue()));
            }
            this.f3967a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            for (a aVar : cVar.f3968b) {
                arrayList.add(new a(aVar));
            }
            this.f3968b = arrayList;
        }
        if (cVar.m()) {
            this.f3969c = cVar.f3969c;
        }
    }

    public c(Map<String, b> map) {
        this();
        this.f3967a = map;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
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
    public c deepCopy() {
        return new c(this);
    }

    public c a(String str) {
        this.f3969c = str;
        return this;
    }

    public c a(List<a> list) {
        this.f3968b = list;
        return this;
    }

    public c a(Map<String, b> map) {
        this.f3967a = map;
        return this;
    }

    public void a(a aVar) {
        if (this.f3968b == null) {
            this.f3968b = new ArrayList();
        }
        this.f3968b.add(aVar);
    }

    public void a(String str, b bVar) {
        if (this.f3967a == null) {
            this.f3967a = new HashMap();
        }
        this.f3967a.put(str, bVar);
    }

    public void a(boolean z) {
        if (!z) {
            this.f3967a = null;
        }
    }

    public int b() {
        if (this.f3967a == null) {
            return 0;
        }
        return this.f3967a.size();
    }

    public void b(boolean z) {
        if (!z) {
            this.f3968b = null;
        }
    }

    public Map<String, b> c() {
        return this.f3967a;
    }

    public void c(boolean z) {
        if (!z) {
            this.f3969c = null;
        }
    }

    public void clear() {
        this.f3967a = null;
        this.f3968b = null;
        this.f3969c = null;
    }

    public void d() {
        this.f3967a = null;
    }

    public boolean e() {
        return this.f3967a != null;
    }

    public int f() {
        if (this.f3968b == null) {
            return 0;
        }
        return this.f3968b.size();
    }

    public Iterator<a> g() {
        if (this.f3968b == null) {
            return null;
        }
        return this.f3968b.iterator();
    }

    public List<a> h() {
        return this.f3968b;
    }

    public void i() {
        this.f3968b = null;
    }

    public boolean j() {
        return this.f3968b != null;
    }

    public String k() {
        return this.f3969c;
    }

    public void l() {
        this.f3969c = null;
    }

    public boolean m() {
        return this.f3969c != null;
    }

    public void n() throws ag {
        if (this.f3967a == null) {
            throw new ba("Required field 'snapshots' was not present! Struct: " + toString());
        }
    }

    public void read(az azVar) throws ag {
        j.get(azVar.D()).b().b(azVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        if (this.f3967a == null) {
            sb.append("null");
        } else {
            sb.append(this.f3967a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            if (this.f3968b == null) {
                sb.append("null");
            } else {
                sb.append(this.f3968b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            sb.append(this.f3969c == null ? "null" : this.f3969c);
        }
        sb.append(")");
        return sb.toString();
    }

    public void write(az azVar) throws ag {
        j.get(azVar.D()).b().a(azVar, this);
    }
}

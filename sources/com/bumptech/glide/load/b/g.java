package com.bumptech.glide.load.b;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.l;
import com.bumptech.glide.load.b.e;
import com.bumptech.glide.load.b.h;
import com.bumptech.glide.load.d.a.o;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.m;
import com.bumptech.glide.util.a.a;
import com.bumptech.glide.util.a.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g<R> implements e.a, a.c, Comparable<g<?>>, Runnable {
    private static final String u = "DecodeJob";
    private Thread A;
    private com.bumptech.glide.load.g B;
    private Object C;
    private com.bumptech.glide.load.a D;
    private com.bumptech.glide.load.a.d<?> E;
    private volatile boolean F;

    /* renamed from: a  reason: collision with root package name */
    public final f<R> f1125a = new f<>();

    /* renamed from: b  reason: collision with root package name */
    public final d f1126b;

    /* renamed from: c  reason: collision with root package name */
    final c<?> f1127c = new c<>();
    final e d = new e();
    public h e;
    public com.bumptech.glide.load.g f;
    public l g;
    public m h;
    public int i;
    public int j;
    public i k;
    public j l;
    public a<R> m;
    public int n;
    public f o;
    public boolean p;
    public Object q;
    com.bumptech.glide.load.g r;
    public volatile e s;
    public volatile boolean t;
    private final List<Throwable> v = new ArrayList();
    private final com.bumptech.glide.util.a.c w = new c.b();
    private final Pools.Pool<g<?>> x;
    private C0015g y;
    private long z;

    interface a<R> {
        void a(g<?> gVar);

        void a(p pVar);

        void a(u<R> uVar, com.bumptech.glide.load.a aVar);
    }

    private final class b<Z> implements h.a<Z> {

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.load.a f1132b;

        b(com.bumptech.glide.load.a aVar) {
            this.f1132b = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: com.bumptech.glide.load.b.c} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v23, resolved type: com.bumptech.glide.load.b.w} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: com.bumptech.glide.load.b.w} */
        /* JADX WARNING: type inference failed for: r14v8, types: [com.bumptech.glide.load.g] */
        /* JADX WARNING: Multi-variable type inference failed */
        @android.support.annotation.NonNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.bumptech.glide.load.b.u<Z> a(@android.support.annotation.NonNull com.bumptech.glide.load.b.u<Z> r14) {
            /*
                r13 = this;
                com.bumptech.glide.load.b.g r0 = com.bumptech.glide.load.b.g.this
                com.bumptech.glide.load.a r1 = r13.f1132b
                java.lang.Object r2 = r14.b()
                java.lang.Class r10 = r2.getClass()
                com.bumptech.glide.load.a r2 = com.bumptech.glide.load.a.RESOURCE_DISK_CACHE
                r3 = 0
                if (r1 == r2) goto L_0x0024
                com.bumptech.glide.load.b.f<R> r2 = r0.f1125a
                com.bumptech.glide.load.m r2 = r2.c(r10)
                com.bumptech.glide.h r4 = r0.e
                int r5 = r0.i
                int r6 = r0.j
                com.bumptech.glide.load.b.u r4 = r2.a(r4, r14, r5, r6)
                r9 = r2
                r2 = r4
                goto L_0x0026
            L_0x0024:
                r2 = r14
                r9 = r3
            L_0x0026:
                boolean r4 = r14.equals(r2)
                if (r4 != 0) goto L_0x002f
                r14.d()
            L_0x002f:
                com.bumptech.glide.load.b.f<R> r14 = r0.f1125a
                com.bumptech.glide.h r14 = r14.f1124c
                com.bumptech.glide.m r14 = r14.d
                com.bumptech.glide.e.f r14 = r14.e
                java.lang.Class r4 = r2.a()
                com.bumptech.glide.load.l r14 = r14.a(r4)
                r4 = 0
                r5 = 1
                if (r14 == 0) goto L_0x0045
                r14 = 1
                goto L_0x0046
            L_0x0045:
                r14 = 0
            L_0x0046:
                if (r14 == 0) goto L_0x006b
                com.bumptech.glide.load.b.f<R> r14 = r0.f1125a
                com.bumptech.glide.h r14 = r14.f1124c
                com.bumptech.glide.m r14 = r14.d
                com.bumptech.glide.e.f r14 = r14.e
                java.lang.Class r3 = r2.a()
                com.bumptech.glide.load.l r3 = r14.a(r3)
                if (r3 == 0) goto L_0x0061
                com.bumptech.glide.load.j r14 = r0.l
                com.bumptech.glide.load.c r14 = r3.a(r14)
                goto L_0x006d
            L_0x0061:
                com.bumptech.glide.m$d r14 = new com.bumptech.glide.m$d
                java.lang.Class r0 = r2.a()
                r14.<init>(r0)
                throw r14
            L_0x006b:
                com.bumptech.glide.load.c r14 = com.bumptech.glide.load.c.NONE
            L_0x006d:
                r12 = r3
                com.bumptech.glide.load.b.f<R> r3 = r0.f1125a
                com.bumptech.glide.load.g r6 = r0.r
                java.util.List r3 = r3.b()
                int r7 = r3.size()
                r8 = 0
            L_0x007b:
                if (r8 >= r7) goto L_0x0090
                java.lang.Object r11 = r3.get(r8)
                com.bumptech.glide.load.c.n$a r11 = (com.bumptech.glide.load.c.n.a) r11
                com.bumptech.glide.load.g r11 = r11.f1246a
                boolean r11 = r11.equals(r6)
                if (r11 == 0) goto L_0x008d
                r4 = 1
                goto L_0x0090
            L_0x008d:
                int r8 = r8 + 1
                goto L_0x007b
            L_0x0090:
                r3 = r4 ^ 1
                com.bumptech.glide.load.b.i r4 = r0.k
                boolean r1 = r4.a(r3, r1, r14)
                if (r1 == 0) goto L_0x00f5
                if (r12 != 0) goto L_0x00aa
                com.bumptech.glide.m$d r14 = new com.bumptech.glide.m$d
                java.lang.Object r0 = r2.b()
                java.lang.Class r0 = r0.getClass()
                r14.<init>(r0)
                throw r14
            L_0x00aa:
                int[] r1 = com.bumptech.glide.load.b.g.AnonymousClass1.f1130c
                int r3 = r14.ordinal()
                r1 = r1[r3]
                switch(r1) {
                    case 1: goto L_0x00e0;
                    case 2: goto L_0x00c9;
                    default: goto L_0x00b5;
                }
            L_0x00b5:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Unknown strategy: "
                r1.<init>(r2)
                r1.append(r14)
                java.lang.String r14 = r1.toString()
                r0.<init>(r14)
                throw r0
            L_0x00c9:
                com.bumptech.glide.load.b.w r14 = new com.bumptech.glide.load.b.w
                com.bumptech.glide.load.b.f<R> r1 = r0.f1125a
                com.bumptech.glide.h r1 = r1.f1124c
                com.bumptech.glide.load.b.a.b r4 = r1.f961c
                com.bumptech.glide.load.g r5 = r0.r
                com.bumptech.glide.load.g r6 = r0.f
                int r7 = r0.i
                int r8 = r0.j
                com.bumptech.glide.load.j r11 = r0.l
                r3 = r14
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                goto L_0x00e9
            L_0x00e0:
                com.bumptech.glide.load.b.c r14 = new com.bumptech.glide.load.b.c
                com.bumptech.glide.load.g r1 = r0.r
                com.bumptech.glide.load.g r3 = r0.f
                r14.<init>(r1, r3)
            L_0x00e9:
                com.bumptech.glide.load.b.t r2 = com.bumptech.glide.load.b.t.a(r2)
                com.bumptech.glide.load.b.g$c<?> r0 = r0.f1127c
                r0.f1133a = r14
                r0.f1134b = r12
                r0.f1135c = r2
            L_0x00f5:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.g.b.a(com.bumptech.glide.load.b.u):com.bumptech.glide.load.b.u");
        }
    }

    private static class c<Z> {

        /* renamed from: a  reason: collision with root package name */
        com.bumptech.glide.load.g f1133a;

        /* renamed from: b  reason: collision with root package name */
        com.bumptech.glide.load.l<Z> f1134b;

        /* renamed from: c  reason: collision with root package name */
        t<Z> f1135c;

        c() {
        }

        private void a(d dVar, j jVar) {
            try {
                dVar.a().a(this.f1133a, new d(this.f1134b, this.f1135c, jVar));
            } finally {
                this.f1135c.e();
            }
        }

        private <X> void a(com.bumptech.glide.load.g gVar, com.bumptech.glide.load.l<X> lVar, t<X> tVar) {
            this.f1133a = gVar;
            this.f1134b = lVar;
            this.f1135c = tVar;
        }

        private void b() {
            this.f1133a = null;
            this.f1134b = null;
            this.f1135c = null;
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return this.f1135c != null;
        }
    }

    interface d {
        com.bumptech.glide.load.b.b.a a();
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1136a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1137b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1138c;

        e() {
        }

        private boolean b(boolean z) {
            return (this.f1138c || z || this.f1137b) && this.f1136a;
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean a() {
            this.f1137b = true;
            return b(false);
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean a(boolean z) {
            this.f1136a = true;
            return b(z);
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean b() {
            this.f1138c = true;
            return b(false);
        }

        /* access modifiers changed from: package-private */
        public final synchronized void c() {
            this.f1137b = false;
            this.f1136a = false;
            this.f1138c = false;
        }
    }

    private enum f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* renamed from: com.bumptech.glide.load.b.g$g  reason: collision with other inner class name */
    private enum C0015g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    g(d dVar, Pools.Pool<g<?>> pool) {
        this.f1126b = dVar;
        this.x = pool;
    }

    private int a(@NonNull g<?> gVar) {
        int ordinal = this.g.ordinal() - gVar.g.ordinal();
        return ordinal == 0 ? this.n - gVar.n : ordinal;
    }

    private g<R> a(com.bumptech.glide.h hVar, Object obj, m mVar, com.bumptech.glide.load.g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, l lVar, i iVar, Map<Class<?>, m<?>> map, boolean z2, boolean z3, boolean z4, j jVar, a<R> aVar, int i4) {
        com.bumptech.glide.h hVar2 = hVar;
        Object obj2 = obj;
        com.bumptech.glide.load.g gVar2 = gVar;
        int i5 = i2;
        int i6 = i3;
        l lVar2 = lVar;
        i iVar2 = iVar;
        j jVar2 = jVar;
        f<R> fVar = this.f1125a;
        d dVar = this.f1126b;
        fVar.f1124c = hVar2;
        fVar.d = obj2;
        fVar.n = gVar2;
        fVar.e = i5;
        fVar.f = i6;
        fVar.p = iVar2;
        fVar.g = cls;
        fVar.h = dVar;
        fVar.k = cls2;
        fVar.o = lVar2;
        fVar.i = jVar2;
        fVar.j = map;
        fVar.q = z2;
        fVar.r = z3;
        this.e = hVar2;
        this.f = gVar2;
        this.g = lVar2;
        this.h = mVar;
        this.i = i5;
        this.j = i6;
        this.k = iVar2;
        this.p = z4;
        this.l = jVar2;
        this.m = aVar;
        this.n = i4;
        this.o = f.INITIALIZE;
        this.q = obj2;
        return this;
    }

    private <Data> u<R> a(com.bumptech.glide.load.a.d<?> dVar, Data data, com.bumptech.glide.load.a aVar) throws p {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long a2 = com.bumptech.glide.util.e.a();
            u<R> a3 = a(data, aVar, this.f1125a.b(data.getClass()));
            if (Log.isLoggable(u, 2)) {
                a("Decoded result " + a3, a2, (String) null);
            }
            return a3;
        } finally {
            dVar.b();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: com.bumptech.glide.load.b.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: com.bumptech.glide.load.b.w} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.bumptech.glide.load.b.w} */
    /* JADX WARNING: type inference failed for: r12v4, types: [com.bumptech.glide.load.g] */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <Z> com.bumptech.glide.load.b.u<Z> a(com.bumptech.glide.load.a r12, @android.support.annotation.NonNull com.bumptech.glide.load.b.u<Z> r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r13.b()
            java.lang.Class r8 = r0.getClass()
            com.bumptech.glide.load.a r0 = com.bumptech.glide.load.a.RESOURCE_DISK_CACHE
            r1 = 0
            if (r12 == r0) goto L_0x0020
            com.bumptech.glide.load.b.f<R> r0 = r11.f1125a
            com.bumptech.glide.load.m r0 = r0.c(r8)
            com.bumptech.glide.h r2 = r11.e
            int r3 = r11.i
            int r4 = r11.j
            com.bumptech.glide.load.b.u r2 = r0.a(r2, r13, r3, r4)
            r7 = r0
            r0 = r2
            goto L_0x0022
        L_0x0020:
            r0 = r13
            r7 = r1
        L_0x0022:
            boolean r2 = r13.equals(r0)
            if (r2 != 0) goto L_0x002b
            r13.d()
        L_0x002b:
            com.bumptech.glide.load.b.f<R> r13 = r11.f1125a
            com.bumptech.glide.h r13 = r13.f1124c
            com.bumptech.glide.m r13 = r13.d
            com.bumptech.glide.e.f r13 = r13.e
            java.lang.Class r2 = r0.a()
            com.bumptech.glide.load.l r13 = r13.a(r2)
            r2 = 0
            r3 = 1
            if (r13 == 0) goto L_0x0041
            r13 = 1
            goto L_0x0042
        L_0x0041:
            r13 = 0
        L_0x0042:
            if (r13 == 0) goto L_0x0067
            com.bumptech.glide.load.b.f<R> r13 = r11.f1125a
            com.bumptech.glide.h r13 = r13.f1124c
            com.bumptech.glide.m r13 = r13.d
            com.bumptech.glide.e.f r13 = r13.e
            java.lang.Class r1 = r0.a()
            com.bumptech.glide.load.l r1 = r13.a(r1)
            if (r1 == 0) goto L_0x005d
            com.bumptech.glide.load.j r13 = r11.l
            com.bumptech.glide.load.c r13 = r1.a(r13)
            goto L_0x0069
        L_0x005d:
            com.bumptech.glide.m$d r12 = new com.bumptech.glide.m$d
            java.lang.Class r13 = r0.a()
            r12.<init>(r13)
            throw r12
        L_0x0067:
            com.bumptech.glide.load.c r13 = com.bumptech.glide.load.c.NONE
        L_0x0069:
            r10 = r1
            com.bumptech.glide.load.b.f<R> r1 = r11.f1125a
            com.bumptech.glide.load.g r4 = r11.r
            java.util.List r1 = r1.b()
            int r5 = r1.size()
            r6 = 0
        L_0x0077:
            if (r6 >= r5) goto L_0x008c
            java.lang.Object r9 = r1.get(r6)
            com.bumptech.glide.load.c.n$a r9 = (com.bumptech.glide.load.c.n.a) r9
            com.bumptech.glide.load.g r9 = r9.f1246a
            boolean r9 = r9.equals(r4)
            if (r9 == 0) goto L_0x0089
            r2 = 1
            goto L_0x008c
        L_0x0089:
            int r6 = r6 + 1
            goto L_0x0077
        L_0x008c:
            r1 = r2 ^ 1
            com.bumptech.glide.load.b.i r2 = r11.k
            boolean r12 = r2.a(r1, r12, r13)
            if (r12 == 0) goto L_0x00f1
            if (r10 != 0) goto L_0x00a6
            com.bumptech.glide.m$d r12 = new com.bumptech.glide.m$d
            java.lang.Object r13 = r0.b()
            java.lang.Class r13 = r13.getClass()
            r12.<init>(r13)
            throw r12
        L_0x00a6:
            int[] r12 = com.bumptech.glide.load.b.g.AnonymousClass1.f1130c
            int r1 = r13.ordinal()
            r12 = r12[r1]
            switch(r12) {
                case 1: goto L_0x00dc;
                case 2: goto L_0x00c5;
                default: goto L_0x00b1;
            }
        L_0x00b1:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown strategy: "
            r0.<init>(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r12.<init>(r13)
            throw r12
        L_0x00c5:
            com.bumptech.glide.load.b.w r12 = new com.bumptech.glide.load.b.w
            com.bumptech.glide.load.b.f<R> r13 = r11.f1125a
            com.bumptech.glide.h r13 = r13.f1124c
            com.bumptech.glide.load.b.a.b r2 = r13.f961c
            com.bumptech.glide.load.g r3 = r11.r
            com.bumptech.glide.load.g r4 = r11.f
            int r5 = r11.i
            int r6 = r11.j
            com.bumptech.glide.load.j r9 = r11.l
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x00e5
        L_0x00dc:
            com.bumptech.glide.load.b.c r12 = new com.bumptech.glide.load.b.c
            com.bumptech.glide.load.g r13 = r11.r
            com.bumptech.glide.load.g r1 = r11.f
            r12.<init>(r13, r1)
        L_0x00e5:
            com.bumptech.glide.load.b.t r0 = com.bumptech.glide.load.b.t.a(r0)
            com.bumptech.glide.load.b.g$c<?> r13 = r11.f1127c
            r13.f1133a = r12
            r13.f1134b = r10
            r13.f1135c = r0
        L_0x00f1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.g.a(com.bumptech.glide.load.a, com.bumptech.glide.load.b.u):com.bumptech.glide.load.b.u");
    }

    private <Data> u<R> a(Data data, com.bumptech.glide.load.a aVar) throws p {
        return a(data, aVar, this.f1125a.b(data.getClass()));
    }

    private <Data, ResourceType> u<R> a(Data data, com.bumptech.glide.load.a aVar, s<Data, ResourceType, R> sVar) throws p {
        j jVar = this.l;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z2 = aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || this.f1125a.r;
            Boolean bool = (Boolean) jVar.a(o.e);
            if (bool == null || (bool.booleanValue() && !z2)) {
                jVar = new j();
                jVar.a(this.l);
                jVar.a(o.e, Boolean.valueOf(z2));
            }
        }
        j jVar2 = jVar;
        com.bumptech.glide.load.a.e a2 = this.e.d.f.a(data);
        try {
            return sVar.a(a2, jVar2, this.i, this.j, new b(aVar));
        } finally {
            a2.b();
        }
    }

    @NonNull
    private j a(com.bumptech.glide.load.a aVar) {
        j jVar = this.l;
        if (Build.VERSION.SDK_INT < 26) {
            return jVar;
        }
        boolean z2 = aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || this.f1125a.r;
        Boolean bool = (Boolean) jVar.a(o.e);
        if (bool != null && (!bool.booleanValue() || z2)) {
            return jVar;
        }
        j jVar2 = new j();
        jVar2.a(this.l);
        jVar2.a(o.e, Boolean.valueOf(z2));
        return jVar2;
    }

    private void a(u<R> uVar, com.bumptech.glide.load.a aVar) {
        m();
        this.m.a(uVar, aVar);
    }

    private void a(String str, long j2) {
        a(str, j2, (String) null);
    }

    private void a(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.util.e.a(j2));
        sb.append(", load key: ");
        sb.append(this.h);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v(u, sb.toString());
    }

    private void a(boolean z2) {
        if (this.d.a(z2)) {
            a();
        }
    }

    private void b(u<R> uVar, com.bumptech.glide.load.a aVar) {
        c<?> cVar;
        if (uVar instanceof q) {
            ((q) uVar).e();
        }
        t<R> tVar = null;
        t<R> tVar2 = uVar;
        if (this.f1127c.a()) {
            t<R> a2 = t.a(uVar);
            tVar = a2;
            tVar2 = a2;
        }
        m();
        this.m.a(tVar2, aVar);
        this.y = C0015g.ENCODE;
        try {
            if (this.f1127c.a()) {
                cVar = this.f1127c;
                this.f1126b.a().a(cVar.f1133a, new d(cVar.f1134b, cVar.f1135c, this.l));
                cVar.f1135c.e();
            }
            if (tVar != null) {
                tVar.e();
            }
            if (this.d.a()) {
                a();
            }
        } catch (Throwable th) {
            if (tVar != null) {
                tVar.e();
            }
            throw th;
        }
    }

    private boolean d() {
        C0015g a2 = a(C0015g.INITIALIZE);
        return a2 == C0015g.RESOURCE_CACHE || a2 == C0015g.DATA_CACHE;
    }

    private void e() {
        if (this.d.a()) {
            a();
        }
    }

    private void f() {
        if (this.d.b()) {
            a();
        }
    }

    private int g() {
        return this.g.ordinal();
    }

    private void h() {
        this.t = true;
        e eVar = this.s;
        if (eVar != null) {
            eVar.b();
        }
    }

    private void i() {
        switch (this.o) {
            case INITIALIZE:
                this.y = a(C0015g.INITIALIZE);
                this.s = j();
                k();
                return;
            case SWITCH_TO_SOURCE_SERVICE:
                k();
                return;
            case DECODE_DATA:
                n();
                return;
            default:
                throw new IllegalStateException("Unrecognized run reason: " + this.o);
        }
    }

    private e j() {
        switch (this.y) {
            case RESOURCE_CACHE:
                return new v(this.f1125a, this);
            case DATA_CACHE:
                return new b(this.f1125a, this);
            case SOURCE:
                return new y(this.f1125a, this);
            case FINISHED:
                return null;
            default:
                throw new IllegalStateException("Unrecognized stage: " + this.y);
        }
    }

    private void k() {
        this.A = Thread.currentThread();
        this.z = com.bumptech.glide.util.e.a();
        boolean z2 = false;
        while (!this.t && this.s != null && !(z2 = this.s.a())) {
            this.y = a(this.y);
            this.s = j();
            if (this.y == C0015g.SOURCE) {
                c();
                return;
            }
        }
        if ((this.y == C0015g.FINISHED || this.t) && !z2) {
            l();
        }
    }

    private void l() {
        m();
        this.m.a(new p("Failed to load resource", (List<Throwable>) new ArrayList(this.v)));
        if (this.d.b()) {
            a();
        }
    }

    private void m() {
        this.w.a();
        if (this.F) {
            throw new IllegalStateException("Already notified");
        }
        this.F = true;
    }

    private void n() {
        u<R> uVar;
        t tVar;
        t<R> tVar2;
        c<?> cVar;
        if (Log.isLoggable(u, 2)) {
            a("Retrieved data", this.z, "data: " + this.C + ", cache key: " + this.r + ", fetcher: " + this.E);
        }
        try {
            uVar = a(this.E, this.C, this.D);
        } catch (p e2) {
            e2.setLoggingDetails(this.B, this.D);
            this.v.add(e2);
            uVar = null;
        }
        if (uVar != null) {
            com.bumptech.glide.load.a aVar = this.D;
            if (uVar instanceof q) {
                ((q) uVar).e();
            }
            if (this.f1127c.a()) {
                tVar2 = t.a(uVar);
                tVar = tVar2;
            } else {
                t<R> tVar3 = uVar;
                tVar = null;
                tVar2 = tVar3;
            }
            m();
            this.m.a(tVar2, aVar);
            this.y = C0015g.ENCODE;
            try {
                if (this.f1127c.a()) {
                    cVar = this.f1127c;
                    this.f1126b.a().a(cVar.f1133a, new d(cVar.f1134b, cVar.f1135c, this.l));
                    cVar.f1135c.e();
                }
                if (tVar != null) {
                    tVar.e();
                }
                if (this.d.a()) {
                    a();
                }
            } catch (Throwable th) {
                if (tVar != null) {
                    tVar.e();
                }
                throw th;
            }
        } else {
            k();
        }
    }

    public final C0015g a(C0015g gVar) {
        while (true) {
            switch (gVar) {
                case RESOURCE_CACHE:
                    if (!this.k.b()) {
                        gVar = C0015g.DATA_CACHE;
                        break;
                    } else {
                        return C0015g.DATA_CACHE;
                    }
                case DATA_CACHE:
                    return this.p ? C0015g.FINISHED : C0015g.SOURCE;
                case SOURCE:
                case FINISHED:
                    return C0015g.FINISHED;
                case INITIALIZE:
                    if (!this.k.a()) {
                        gVar = C0015g.RESOURCE_CACHE;
                        break;
                    } else {
                        return C0015g.RESOURCE_CACHE;
                    }
                default:
                    throw new IllegalArgumentException("Unrecognized stage: " + gVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.d.c();
        c<?> cVar = this.f1127c;
        cVar.f1133a = null;
        cVar.f1134b = null;
        cVar.f1135c = null;
        f<R> fVar = this.f1125a;
        fVar.f1124c = null;
        fVar.d = null;
        fVar.n = null;
        fVar.g = null;
        fVar.k = null;
        fVar.i = null;
        fVar.o = null;
        fVar.j = null;
        fVar.p = null;
        fVar.f1122a.clear();
        fVar.l = false;
        fVar.f1123b.clear();
        fVar.m = false;
        this.F = false;
        this.e = null;
        this.f = null;
        this.l = null;
        this.g = null;
        this.h = null;
        this.m = null;
        this.y = null;
        this.s = null;
        this.A = null;
        this.r = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.z = 0;
        this.t = false;
        this.q = null;
        this.v.clear();
        this.x.release(this);
    }

    public final void a(com.bumptech.glide.load.g gVar, Exception exc, com.bumptech.glide.load.a.d<?> dVar, com.bumptech.glide.load.a aVar) {
        dVar.b();
        p pVar = new p("Fetching data failed", (Throwable) exc);
        pVar.setLoggingDetails(gVar, aVar, dVar.a());
        this.v.add(pVar);
        if (Thread.currentThread() != this.A) {
            this.o = f.SWITCH_TO_SOURCE_SERVICE;
            this.m.a((g<?>) this);
            return;
        }
        k();
    }

    public final void a(com.bumptech.glide.load.g gVar, Object obj, com.bumptech.glide.load.a.d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.g gVar2) {
        this.r = gVar;
        this.C = obj;
        this.E = dVar;
        this.D = aVar;
        this.B = gVar2;
        if (Thread.currentThread() != this.A) {
            this.o = f.DECODE_DATA;
            this.m.a((g<?>) this);
            return;
        }
        n();
    }

    public final void c() {
        this.o = f.SWITCH_TO_SOURCE_SERVICE;
        this.m.a((g<?>) this);
    }

    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        g gVar = (g) obj;
        int ordinal = this.g.ordinal() - gVar.g.ordinal();
        return ordinal == 0 ? this.n - gVar.n : ordinal;
    }

    @NonNull
    public final com.bumptech.glide.util.a.c g_() {
        return this.w;
    }

    public final void run() {
        com.bumptech.glide.load.a.d<?> dVar = this.E;
        try {
            if (this.t) {
                l();
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
            }
            switch (this.o) {
                case INITIALIZE:
                    this.y = a(C0015g.INITIALIZE);
                    this.s = j();
                    break;
                case SWITCH_TO_SOURCE_SERVICE:
                    break;
                case DECODE_DATA:
                    n();
                    break;
                default:
                    throw new IllegalStateException("Unrecognized run reason: " + this.o);
            }
            k();
            if (dVar != null) {
                dVar.b();
            }
        } catch (Throwable th) {
            if (dVar != null) {
                dVar.b();
            }
            throw th;
        }
    }
}

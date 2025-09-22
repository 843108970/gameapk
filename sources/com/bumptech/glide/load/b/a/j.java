package com.bumptech.glide.load.b.a;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.util.i;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class j implements b {
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    static final int f1030b = 8;

    /* renamed from: c  reason: collision with root package name */
    private static final int f1031c = 4194304;
    private static final int d = 2;
    private final h<a, Object> e;
    private final b f;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> g;
    private final Map<Class<?>, a<?>> h;
    private final int i;
    private int j;

    private static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f1032a;

        /* renamed from: b  reason: collision with root package name */
        Class<?> f1033b;

        /* renamed from: c  reason: collision with root package name */
        private final b f1034c;

        a(b bVar) {
            this.f1034c = bVar;
        }

        private void a(int i, Class<?> cls) {
            this.f1032a = i;
            this.f1033b = cls;
        }

        public final void a() {
            this.f1034c.a(this);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f1032a == aVar.f1032a && this.f1033b == aVar.f1033b;
            }
        }

        public final int hashCode() {
            return (this.f1032a * 31) + (this.f1033b != null ? this.f1033b.hashCode() : 0);
        }

        public final String toString() {
            return "Key{size=" + this.f1032a + "array=" + this.f1033b + '}';
        }
    }

    private static final class b extends d<a> {
        b() {
        }

        private a c() {
            return new a(this);
        }

        /* access modifiers changed from: package-private */
        public final a a(int i, Class<?> cls) {
            a aVar = (a) b();
            aVar.f1032a = i;
            aVar.f1033b = cls;
            return aVar;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ m a() {
            return new a(this);
        }
    }

    @VisibleForTesting
    public j() {
        this.e = new h<>();
        this.f = new b();
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = 4194304;
    }

    public j(int i2) {
        this.e = new h<>();
        this.f = new b();
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = i2;
    }

    @Nullable
    private <T> T a(a aVar) {
        return this.e.a(aVar);
    }

    private <T> T a(a aVar, Class<T> cls) {
        a<T> c2 = c(cls);
        T a2 = this.e.a(aVar);
        if (a2 != null) {
            this.j -= c2.a(a2) * c2.b();
            b(c2.a(a2), cls);
        }
        if (a2 != null) {
            return a2;
        }
        if (Log.isLoggable(c2.a(), 2)) {
            Log.v(c2.a(), "Allocated " + aVar.f1032a + " bytes");
        }
        return c2.a(aVar.f1032a);
    }

    private boolean a(int i2, Integer num) {
        if (num != null) {
            if ((this.j == 0 || this.i / this.j >= 2) || num.intValue() <= i2 * 8) {
                return true;
            }
        }
        return false;
    }

    private NavigableMap<Integer, Integer> b(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.g.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.g.put(cls, treeMap);
        return treeMap;
    }

    private void b(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> b2 = b(cls);
        Integer num = (Integer) b2.get(Integer.valueOf(i2));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
        } else if (num.intValue() == 1) {
            b2.remove(Integer.valueOf(i2));
        } else {
            b2.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
        }
    }

    private boolean b() {
        return this.j == 0 || this.i / this.j >= 2;
    }

    private boolean b(int i2) {
        return i2 <= this.i / 2;
    }

    private <T> a<T> c(Class<T> cls) {
        a<T> aVar;
        a<T> aVar2 = this.h.get(cls);
        if (aVar2 != null) {
            return aVar2;
        }
        if (cls.equals(int[].class)) {
            aVar = new i();
        } else if (cls.equals(byte[].class)) {
            aVar = new g();
        } else {
            throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
        }
        this.h.put(cls, aVar);
        return aVar;
    }

    private <T> a<T> c(T t) {
        return c(t.getClass());
    }

    private void c() {
        c(this.i);
    }

    private void c(int i2) {
        while (this.j > i2) {
            Object a2 = this.e.a();
            i.a(a2, "Argument must not be null");
            a<?> c2 = c(a2.getClass());
            this.j -= c2.a(a2) * c2.b();
            b(c2.a(a2), a2.getClass());
            if (Log.isLoggable(c2.a(), 2)) {
                Log.v(c2.a(), "evicted: " + c2.a(a2));
            }
        }
    }

    private int d() {
        int i2 = 0;
        for (Class next : this.g.keySet()) {
            for (Integer num : this.g.get(next).keySet()) {
                i2 += num.intValue() * ((Integer) this.g.get(next).get(num)).intValue() * c(next).b();
            }
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized <T> T a(int r6, java.lang.Class<T> r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.NavigableMap r0 = r5.b((java.lang.Class<?>) r7)     // Catch:{ all -> 0x0048 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0048 }
            java.lang.Object r0 = r0.ceilingKey(r1)     // Catch:{ all -> 0x0048 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0048 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002e
            int r3 = r5.j     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0022
            int r3 = r5.i     // Catch:{ all -> 0x0048 }
            int r4 = r5.j     // Catch:{ all -> 0x0048 }
            int r3 = r3 / r4
            r4 = 2
            if (r3 < r4) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r3 = 0
            goto L_0x0023
        L_0x0022:
            r3 = 1
        L_0x0023:
            if (r3 != 0) goto L_0x002f
            int r3 = r0.intValue()     // Catch:{ all -> 0x0048 }
            int r4 = r6 * 8
            if (r3 > r4) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            if (r1 == 0) goto L_0x003c
            com.bumptech.glide.load.b.a.j$b r6 = r5.f     // Catch:{ all -> 0x0048 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0048 }
            com.bumptech.glide.load.b.a.j$a r6 = r6.a(r0, r7)     // Catch:{ all -> 0x0048 }
            goto L_0x0042
        L_0x003c:
            com.bumptech.glide.load.b.a.j$b r0 = r5.f     // Catch:{ all -> 0x0048 }
            com.bumptech.glide.load.b.a.j$a r6 = r0.a(r6, r7)     // Catch:{ all -> 0x0048 }
        L_0x0042:
            java.lang.Object r6 = r5.a((com.bumptech.glide.load.b.a.j.a) r6, r7)     // Catch:{ all -> 0x0048 }
            monitor-exit(r5)
            return r6
        L_0x0048:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.a.j.a(int, java.lang.Class):java.lang.Object");
    }

    public final synchronized <T> T a(Class<T> cls) {
        return a(this.f.a(8, cls), cls);
    }

    public final synchronized void a() {
        c(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            r0 = 40
            if (r2 < r0) goto L_0x000c
            r1.a()     // Catch:{ all -> 0x000a }
            monitor-exit(r1)
            return
        L_0x000a:
            r2 = move-exception
            goto L_0x001d
        L_0x000c:
            r0 = 20
            if (r2 >= r0) goto L_0x0014
            r0 = 15
            if (r2 != r0) goto L_0x001b
        L_0x0014:
            int r2 = r1.i     // Catch:{ all -> 0x000a }
            int r2 = r2 / 2
            r1.c((int) r2)     // Catch:{ all -> 0x000a }
        L_0x001b:
            monitor-exit(r1)
            return
        L_0x001d:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.a.j.a(int):void");
    }

    @Deprecated
    public final <T> void a(T t) {
        b(t);
    }

    public final synchronized <T> void b(T t) {
        Class<?> cls = t.getClass();
        a<?> c2 = c(cls);
        int a2 = c2.a(t);
        int b2 = c2.b() * a2;
        int i2 = 1;
        if (b2 <= this.i / 2) {
            a a3 = this.f.a(a2, cls);
            this.e.a(a3, t);
            NavigableMap<Integer, Integer> b3 = b(cls);
            Integer num = (Integer) b3.get(Integer.valueOf(a3.f1032a));
            Integer valueOf = Integer.valueOf(a3.f1032a);
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            b3.put(valueOf, Integer.valueOf(i2));
            this.j += b2;
            c(this.i);
        }
    }
}

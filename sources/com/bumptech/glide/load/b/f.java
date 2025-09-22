package com.bumptech.glide.load.b;

import com.bumptech.glide.h;
import com.bumptech.glide.l;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.g;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.m;
import com.bumptech.glide.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    final List<n.a<?>> f1122a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    final List<g> f1123b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public h f1124c;
    public Object d;
    public int e;
    public int f;
    public Class<?> g;
    public g.d h;
    public j i;
    public Map<Class<?>, m<?>> j;
    public Class<Transcode> k;
    boolean l;
    boolean m;
    public com.bumptech.glide.load.g n;
    public l o;
    public i p;
    public boolean q;
    public boolean r;

    f() {
    }

    private <X> d<X> a(X x) throws m.e {
        d<X> a2 = this.f1124c.d.d.a(x.getClass());
        if (a2 != null) {
            return a2;
        }
        throw new m.e(x.getClass());
    }

    private <R> void a(h hVar, Object obj, com.bumptech.glide.load.g gVar, int i2, int i3, i iVar, Class<?> cls, Class<R> cls2, l lVar, j jVar, Map<Class<?>, com.bumptech.glide.load.m<?>> map, boolean z, boolean z2, g.d dVar) {
        this.f1124c = hVar;
        this.d = obj;
        this.n = gVar;
        this.e = i2;
        this.f = i3;
        this.p = iVar;
        this.g = cls;
        this.h = dVar;
        this.k = cls2;
        this.o = lVar;
        this.i = jVar;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    private boolean a(u<?> uVar) {
        return this.f1124c.d.e.a(uVar.a()) != null;
    }

    private boolean a(com.bumptech.glide.load.g gVar) {
        List<n.a<?>> b2 = b();
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (b2.get(i2).f1246a.equals(gVar)) {
                return true;
            }
        }
        return false;
    }

    private <Z> com.bumptech.glide.load.l<Z> b(u<Z> uVar) {
        com.bumptech.glide.load.l<Z> a2 = this.f1124c.d.e.a(uVar.a());
        if (a2 != null) {
            return a2;
        }
        throw new m.d(uVar.a());
    }

    private void d() {
        this.f1124c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f1122a.clear();
        this.l = false;
        this.f1123b.clear();
        this.m = false;
    }

    private i e() {
        return this.p;
    }

    private l f() {
        return this.o;
    }

    private j g() {
        return this.i;
    }

    private com.bumptech.glide.load.g h() {
        return this.n;
    }

    private int i() {
        return this.e;
    }

    private int j() {
        return this.f;
    }

    private b k() {
        return this.f1124c.f961c;
    }

    private Class<?> l() {
        return this.k;
    }

    private Class<?> m() {
        return this.d.getClass();
    }

    private List<Class<?>> n() {
        return this.f1124c.d.b(this.d.getClass(), this.g, this.k);
    }

    private boolean o() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public final a a() {
        return this.h.a();
    }

    /* access modifiers changed from: package-private */
    public final List<n<File, ?>> a(File file) throws m.c {
        return this.f1124c.d.a(file);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Class<?> cls) {
        return b(cls) != null;
    }

    /* access modifiers changed from: package-private */
    public final <Data> s<Data, ?, Transcode> b(Class<Data> cls) {
        return this.f1124c.d.a(cls, this.g, this.k);
    }

    /* access modifiers changed from: package-private */
    public final List<n.a<?>> b() {
        if (!this.l) {
            this.l = true;
            this.f1122a.clear();
            List a2 = this.f1124c.d.a(this.d);
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a a3 = ((n) a2.get(i2)).a(this.d, this.e, this.f, this.i);
                if (a3 != null) {
                    this.f1122a.add(a3);
                }
            }
        }
        return this.f1122a;
    }

    /* access modifiers changed from: package-private */
    public final <Z> com.bumptech.glide.load.m<Z> c(Class<Z> cls) {
        com.bumptech.glide.load.m<Z> mVar = this.j.get(cls);
        if (mVar == null) {
            Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.m<?>>> it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    mVar = (com.bumptech.glide.load.m) next.getValue();
                    break;
                }
            }
        }
        if (mVar != null) {
            return mVar;
        }
        if (!this.j.isEmpty() || !this.q) {
            return com.bumptech.glide.load.d.b.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* access modifiers changed from: package-private */
    public final List<com.bumptech.glide.load.g> c() {
        if (!this.m) {
            this.m = true;
            this.f1123b.clear();
            List<n.a<?>> b2 = b();
            int size = b2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a aVar = b2.get(i2);
                if (!this.f1123b.contains(aVar.f1246a)) {
                    this.f1123b.add(aVar.f1246a);
                }
                for (int i3 = 0; i3 < aVar.f1247b.size(); i3++) {
                    if (!this.f1123b.contains(aVar.f1247b.get(i3))) {
                        this.f1123b.add(aVar.f1247b.get(i3));
                    }
                }
            }
        }
        return this.f1123b;
    }
}

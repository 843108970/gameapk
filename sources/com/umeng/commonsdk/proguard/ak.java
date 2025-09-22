package com.umeng.commonsdk.proguard;

import com.cyjh.common.util.s;
import com.umeng.commonsdk.proguard.ah;
import com.umeng.commonsdk.proguard.ak;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ak<T extends ak<?, ?>, F extends ah> implements aa<T, F> {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends bh>, bi> f3696c;

    /* renamed from: a  reason: collision with root package name */
    protected Object f3697a;

    /* renamed from: b  reason: collision with root package name */
    protected F f3698b;

    private static class a extends bj<ak> {
        private a() {
        }

        /* renamed from: a */
        public void b(az azVar, ak akVar) throws ag {
            akVar.f3698b = null;
            akVar.f3697a = null;
            azVar.j();
            au l = azVar.l();
            akVar.f3697a = akVar.a(azVar, l);
            if (akVar.f3697a != null) {
                akVar.f3698b = akVar.a(l.f3726c);
            }
            azVar.m();
            azVar.l();
            azVar.k();
        }

        /* renamed from: b */
        public void a(az azVar, ak akVar) throws ag {
            if (akVar.a() == null || akVar.b() == null) {
                throw new ba("Cannot write a TUnion with no set value!");
            }
            azVar.a(akVar.d());
            azVar.a(akVar.c(akVar.f3698b));
            akVar.a(azVar);
            azVar.c();
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

    private static class c extends bk<ak> {
        private c() {
        }

        /* renamed from: a */
        public void b(az azVar, ak akVar) throws ag {
            akVar.f3698b = null;
            akVar.f3697a = null;
            short v = azVar.v();
            akVar.f3697a = akVar.a(azVar, v);
            if (akVar.f3697a != null) {
                akVar.f3698b = akVar.a(v);
            }
        }

        /* renamed from: b */
        public void a(az azVar, ak akVar) throws ag {
            if (akVar.a() == null || akVar.b() == null) {
                throw new ba("Cannot write a TUnion with no set value!");
            }
            azVar.a(akVar.f3698b.a());
            akVar.b(azVar);
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

    static {
        HashMap hashMap = new HashMap();
        f3696c = hashMap;
        hashMap.put(bj.class, new b());
        f3696c.put(bk.class, new d());
    }

    protected ak() {
        this.f3698b = null;
        this.f3697a = null;
    }

    protected ak(F f, Object obj) {
        a(f, obj);
    }

    protected ak(ak<T, F> akVar) {
        if (!akVar.getClass().equals(getClass())) {
            throw new ClassCastException();
        }
        this.f3698b = akVar.f3698b;
        this.f3697a = a(akVar.f3697a);
    }

    private static Object a(Object obj) {
        return obj instanceof aa ? ((aa) obj).deepCopy() : obj instanceof ByteBuffer ? ab.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) (Map) obj) : obj;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object a2 : list) {
            arrayList.add(a(a2));
        }
        return arrayList;
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(a(next.getKey()), a(next.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object a2 : set) {
            hashSet.add(a(a2));
        }
        return hashSet;
    }

    public F a() {
        return this.f3698b;
    }

    /* access modifiers changed from: protected */
    public abstract F a(short s);

    public Object a(int i) {
        return a(a((short) i));
    }

    public Object a(F f) {
        if (f == this.f3698b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.f3698b);
    }

    /* access modifiers changed from: protected */
    public abstract Object a(az azVar, au auVar) throws ag;

    /* access modifiers changed from: protected */
    public abstract Object a(az azVar, short s) throws ag;

    public void a(int i, Object obj) {
        a(a((short) i), obj);
    }

    public void a(F f, Object obj) {
        b(f, obj);
        this.f3698b = f;
        this.f3697a = obj;
    }

    /* access modifiers changed from: protected */
    public abstract void a(az azVar) throws ag;

    public Object b() {
        return this.f3697a;
    }

    /* access modifiers changed from: protected */
    public abstract void b(F f, Object obj) throws ClassCastException;

    /* access modifiers changed from: protected */
    public abstract void b(az azVar) throws ag;

    public boolean b(int i) {
        return b(a((short) i));
    }

    public boolean b(F f) {
        return this.f3698b == f;
    }

    /* access modifiers changed from: protected */
    public abstract au c(F f);

    public boolean c() {
        return this.f3698b != null;
    }

    public final void clear() {
        this.f3698b = null;
        this.f3697a = null;
    }

    /* access modifiers changed from: protected */
    public abstract be d();

    public void read(az azVar) throws ag {
        f3696c.get(azVar.D()).b().b(azVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(s.a.f1696a);
        if (a() != null) {
            Object b2 = b();
            sb.append(c(a()).f3724a);
            sb.append(":");
            if (b2 instanceof ByteBuffer) {
                ab.a((ByteBuffer) b2, sb);
            } else {
                sb.append(b2.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    public void write(az azVar) throws ag {
        f3696c.get(azVar.D()).b().a(azVar, this);
    }
}

package org.junit.a.e.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.a.e.d;
import org.junit.a.e.e;
import org.junit.a.e.f;
import org.junit.a.e.g;
import org.junit.e.a.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final List<g> f4441a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d> f4442b;

    /* renamed from: c  reason: collision with root package name */
    public final k f4443c;

    public b(List<g> list, List<d> list2, k kVar) {
        this.f4442b = list2;
        this.f4441a = list;
        this.f4443c = kVar;
    }

    private static List<g> a(d dVar) {
        Class<?> cls = dVar.f4117a;
        return cls.isEnum() ? new d(cls).a(dVar) : (cls.equals(Boolean.class) || cls.equals(Boolean.TYPE)) ? new c().a(dVar) : Collections.emptyList();
    }

    private static b a(Method method, k kVar) {
        List<d> a2 = d.a(kVar.c());
        a2.addAll(d.a(method));
        return new b(new ArrayList(), a2, kVar);
    }

    private b a(g gVar) {
        ArrayList arrayList = new ArrayList(this.f4441a);
        arrayList.add(gVar);
        return new b(arrayList, this.f4442b.subList(1, this.f4442b.size()), this.f4443c);
    }

    private e a(Class<? extends e> cls) throws Exception {
        Object newInstance;
        Constructor[] constructors = cls.getConstructors();
        int length = constructors.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                newInstance = cls.newInstance();
                break;
            }
            Constructor constructor = constructors[i];
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(k.class)) {
                newInstance = constructor.newInstance(new Object[]{this.f4443c});
                break;
            }
            i++;
        }
        return (e) newInstance;
    }

    private e b(d dVar) throws Exception {
        f fVar = (f) dVar.b(f.class);
        if (fVar == null) {
            return new a(this.f4443c);
        }
        Class<? extends e> a2 = fVar.a();
        Constructor[] constructors = a2.getConstructors();
        int length = constructors.length;
        int i = 0;
        while (i < length) {
            Constructor constructor = constructors[i];
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length != 1 || !parameterTypes[0].equals(k.class)) {
                i++;
            } else {
                return (e) constructor.newInstance(new Object[]{this.f4443c});
            }
        }
        return (e) a2.newInstance();
    }

    private boolean b() {
        return this.f4442b.size() == 0;
    }

    private d c() {
        return this.f4442b.get(0);
    }

    private List<g> d() throws Throwable {
        e eVar;
        Object newInstance;
        d dVar = this.f4442b.get(0);
        f fVar = (f) dVar.b(f.class);
        if (fVar != null) {
            Class<? extends e> a2 = fVar.a();
            Constructor[] constructors = a2.getConstructors();
            int length = constructors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    newInstance = a2.newInstance();
                    break;
                }
                Constructor constructor = constructors[i];
                Class[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].equals(k.class)) {
                    newInstance = constructor.newInstance(new Object[]{this.f4443c});
                    break;
                }
                i++;
            }
            eVar = (e) newInstance;
        } else {
            eVar = new a(this.f4443c);
        }
        List<g> a3 = eVar.a(dVar);
        if (a3.size() != 0) {
            return a3;
        }
        Class<?> cls = dVar.f4117a;
        return cls.isEnum() ? new d(cls).a(dVar) : (cls.equals(Boolean.class) || cls.equals(Boolean.TYPE)) ? new c().a(dVar) : Collections.emptyList();
    }

    private Object[] e() throws g.a {
        return a(0, a());
    }

    private Object[] f() throws g.a {
        return a(a(), this.f4441a.size());
    }

    private Object[] g() throws g.a {
        return a(0, this.f4441a.size());
    }

    private Object[] h() throws g.a {
        Object[] objArr = new Object[this.f4441a.size()];
        for (int i = 0; i < objArr.length; i++) {
            objArr[i] = this.f4441a.get(i).b();
        }
        return objArr;
    }

    public final int a() {
        return d.a(this.f4443c.c()).size();
    }

    public final Object[] a(int i, int i2) throws g.a {
        Object[] objArr = new Object[(i2 - i)];
        for (int i3 = i; i3 < i2; i3++) {
            objArr[i3 - i] = this.f4441a.get(i3).a();
        }
        return objArr;
    }
}

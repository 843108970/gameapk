package org.junit.a.e;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.a.e.a.c;
import org.junit.a.e.a.e;
import org.junit.e.a.d;
import org.junit.e.a.g;
import org.junit.e.a.j;
import org.junit.e.a.k;
import org.junit.e.b;

public final class h extends b {

    public static class a extends j {

        /* renamed from: a  reason: collision with root package name */
        int f4447a = 0;

        /* renamed from: b  reason: collision with root package name */
        final d f4448b;

        /* renamed from: c  reason: collision with root package name */
        List<org.junit.b.b> f4449c = new ArrayList();
        private final k d;

        public a(d dVar, k kVar) {
            this.f4448b = dVar;
            this.d = kVar;
        }

        private static /* synthetic */ j a(a aVar, final d dVar, final org.junit.a.e.a.b bVar, final Object obj) {
            return new j() {
                public final void a() throws Throwable {
                    org.junit.a.e.a.b bVar = r3;
                    Object[] a2 = bVar.a(bVar.a(), bVar.f4441a.size());
                    if (!a.a(a.this)) {
                        org.junit.d.a(a2);
                    }
                    r2.a(r4, a2);
                }
            };
        }

        private j a(final d dVar, final org.junit.a.e.a.b bVar, final Object obj) {
            return new j() {
                public final void a() throws Throwable {
                    org.junit.a.e.a.b bVar = bVar;
                    Object[] a2 = bVar.a(bVar.a(), bVar.f4441a.size());
                    if (!a.a(a.this)) {
                        org.junit.d.a(a2);
                    }
                    dVar.a(obj, a2);
                }
            };
        }

        private void a(Throwable th, Object... objArr) throws Throwable {
            if (objArr.length == 0) {
                throw th;
            }
            throw new e(th, this.f4448b.f4120a.getName(), objArr);
        }

        private void a(final org.junit.a.e.a.b bVar) throws Throwable {
            e eVar;
            Object newInstance;
            if (!(bVar.f4442b.size() == 0)) {
                d dVar = bVar.f4442b.get(0);
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
                            newInstance = constructor.newInstance(new Object[]{bVar.f4443c});
                            break;
                        }
                        i++;
                    }
                    eVar = (e) newInstance;
                } else {
                    eVar = new org.junit.a.e.a.a(bVar.f4443c);
                }
                List<g> a3 = eVar.a(dVar);
                if (a3.size() == 0) {
                    Class<?> cls = dVar.f4117a;
                    a3 = cls.isEnum() ? new org.junit.a.e.a.d(cls).a(dVar) : (cls.equals(Boolean.class) || cls.equals(Boolean.TYPE)) ? new c().a(dVar) : Collections.emptyList();
                }
                for (g add : a3) {
                    ArrayList arrayList = new ArrayList(bVar.f4441a);
                    arrayList.add(add);
                    a(new org.junit.a.e.a.b(arrayList, bVar.f4442b.subList(1, bVar.f4442b.size()), bVar.f4443c));
                }
                return;
            }
            new b(this.d.f4122b) {
                public final j a(d dVar) {
                    final j a2 = super.a(dVar);
                    return new j() {
                        public final void a() throws Throwable {
                            try {
                                a2.a();
                                a.this.f4447a++;
                            } catch (org.junit.b.b e) {
                                a.this.f4449c.add(e);
                            } catch (Throwable th) {
                                a aVar = a.this;
                                org.junit.a.e.a.b bVar = r3;
                                a.a(a.this);
                                Object[] objArr = new Object[bVar.f4441a.size()];
                                for (int i = 0; i < objArr.length; i++) {
                                    objArr[i] = bVar.f4441a.get(i).b();
                                }
                                if (objArr.length == 0) {
                                    throw th;
                                }
                                throw new e(th, aVar.f4448b.f4120a.getName(), objArr);
                            }
                        }
                    };
                }

                /* access modifiers changed from: protected */
                public final j a(d dVar, Object obj) {
                    return new j(r3, dVar, obj) {
                        public final void a() throws Throwable {
                            org.junit.a.e.a.b bVar = bVar;
                            Object[] a2 = bVar.a(bVar.a(), bVar.f4441a.size());
                            if (!a.a(a.this)) {
                                org.junit.d.a(a2);
                            }
                            dVar.a(obj, a2);
                        }
                    };
                }

                /* access modifiers changed from: protected */
                public final void a(List<Throwable> list) {
                }

                public final Object c() throws Exception {
                    org.junit.a.e.a.b bVar = r3;
                    Object[] a2 = bVar.a(0, bVar.a());
                    if (!a.a(a.this)) {
                        org.junit.d.a(a2);
                    }
                    return this.f4583c.c().newInstance(a2);
                }
            }.a(this.f4448b).a();
        }

        private void a(org.junit.b.b bVar) {
            this.f4449c.add(bVar);
        }

        static /* synthetic */ boolean a(a aVar) {
            i iVar = (i) aVar.f4448b.f4120a.getAnnotation(i.class);
            if (iVar == null) {
                return false;
            }
            return iVar.a();
        }

        private k b() {
            return this.d;
        }

        private void b(org.junit.a.e.a.b bVar) throws Throwable {
            e eVar;
            Object newInstance;
            d dVar = bVar.f4442b.get(0);
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
                        newInstance = constructor.newInstance(new Object[]{bVar.f4443c});
                        break;
                    }
                    i++;
                }
                eVar = (e) newInstance;
            } else {
                eVar = new org.junit.a.e.a.a(bVar.f4443c);
            }
            List<g> a3 = eVar.a(dVar);
            if (a3.size() == 0) {
                Class<?> cls = dVar.f4117a;
                a3 = cls.isEnum() ? new org.junit.a.e.a.d(cls).a(dVar) : (cls.equals(Boolean.class) || cls.equals(Boolean.TYPE)) ? new c().a(dVar) : Collections.emptyList();
            }
            for (g add : a3) {
                ArrayList arrayList = new ArrayList(bVar.f4441a);
                arrayList.add(add);
                a(new org.junit.a.e.a.b(arrayList, bVar.f4442b.subList(1, bVar.f4442b.size()), bVar.f4443c));
            }
        }

        private void c(final org.junit.a.e.a.b bVar) throws Throwable {
            new b(this.d.f4122b) {
                public final j a(d dVar) {
                    final j a2 = super.a(dVar);
                    return new j() {
                        public final void a() throws Throwable {
                            try {
                                a2.a();
                                a.this.f4447a++;
                            } catch (org.junit.b.b e) {
                                a.this.f4449c.add(e);
                            } catch (Throwable th) {
                                a aVar = a.this;
                                org.junit.a.e.a.b bVar = bVar;
                                a.a(a.this);
                                Object[] objArr = new Object[bVar.f4441a.size()];
                                for (int i = 0; i < objArr.length; i++) {
                                    objArr[i] = bVar.f4441a.get(i).b();
                                }
                                if (objArr.length == 0) {
                                    throw th;
                                }
                                throw new e(th, aVar.f4448b.f4120a.getName(), objArr);
                            }
                        }
                    };
                }

                /* access modifiers changed from: protected */
                public final j a(d dVar, Object obj) {
                    return new j(bVar, dVar, obj) {
                        public final void a() throws Throwable {
                            org.junit.a.e.a.b bVar = bVar;
                            Object[] a2 = bVar.a(bVar.a(), bVar.f4441a.size());
                            if (!a.a(a.this)) {
                                org.junit.d.a(a2);
                            }
                            dVar.a(obj, a2);
                        }
                    };
                }

                /* access modifiers changed from: protected */
                public final void a(List<Throwable> list) {
                }

                public final Object c() throws Exception {
                    org.junit.a.e.a.b bVar = bVar;
                    Object[] a2 = bVar.a(0, bVar.a());
                    if (!a.a(a.this)) {
                        org.junit.d.a(a2);
                    }
                    return this.f4583c.c().newInstance(a2);
                }
            }.a(this.f4448b).a();
        }

        private boolean c() {
            i iVar = (i) this.f4448b.f4120a.getAnnotation(i.class);
            if (iVar == null) {
                return false;
            }
            return iVar.a();
        }

        private void d() {
            this.f4447a++;
        }

        public final void a() throws Throwable {
            Method method = this.f4448b.f4120a;
            k kVar = this.d;
            List<d> a2 = d.a(kVar.c());
            a2.addAll(d.a(method));
            a(new org.junit.a.e.a.b(new ArrayList(), a2, kVar));
            boolean z = this.f4448b.a(i.class) != null;
            if (this.f4447a == 0 && z) {
                org.junit.c.a("Never found parameters that satisfied method assumptions.  Violated assumptions: " + this.f4449c);
            }
        }
    }

    private h(Class<?> cls) throws org.junit.e.a.e {
        super(cls);
    }

    private static void a(Class<? extends e> cls, List<Throwable> list) {
        Constructor[] constructors = cls.getConstructors();
        if (constructors.length != 1) {
            list.add(new Error("ParameterSupplier " + cls.getName() + " must have only one constructor (either empty or taking only a TestClass)"));
            return;
        }
        Class[] parameterTypes = constructors[0].getParameterTypes();
        if (parameterTypes.length != 0 && !parameterTypes[0].equals(k.class)) {
            list.add(new Error("ParameterSupplier " + cls.getName() + " constructor must take either nothing or a single TestClass instance"));
        }
    }

    private void g(List<Throwable> list) {
        for (Field field : this.f4583c.f4122b.getDeclaredFields()) {
            if (field.getAnnotation(a.class) != null || field.getAnnotation(b.class) != null) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be static"));
                }
                if (!Modifier.isPublic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be public"));
                }
            }
        }
    }

    private void h(List<Throwable> list) {
        for (Method method : this.f4583c.f4122b.getDeclaredMethods()) {
            if (method.getAnnotation(a.class) != null || method.getAnnotation(b.class) != null) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be static"));
                }
                if (!Modifier.isPublic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be public"));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final List<d> a() {
        ArrayList arrayList = new ArrayList(super.a());
        List<d> b2 = this.f4583c.b((Class<? extends Annotation>) i.class);
        arrayList.removeAll(b2);
        arrayList.addAll(b2);
        return arrayList;
    }

    public final j a(d dVar) {
        return new a(dVar, this.f4583c);
    }

    /* access modifiers changed from: protected */
    public final void a(List<Throwable> list) {
        super.a(list);
        for (Field field : this.f4583c.f4122b.getDeclaredFields()) {
            if (field.getAnnotation(a.class) != null || field.getAnnotation(b.class) != null) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be static"));
                }
                if (!Modifier.isPublic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be public"));
                }
            }
        }
        h(list);
    }

    /* access modifiers changed from: protected */
    public final void b(List<Throwable> list) {
        d(list);
    }

    /* access modifiers changed from: protected */
    public final void c(List<Throwable> list) {
        Error error;
        for (d next : a()) {
            if (next.a(i.class) != null) {
                next.b(false, list);
                g gVar = new g(next.f4120a);
                for (Type a2 : gVar.f4570a.getGenericParameterTypes()) {
                    gVar.a(a2, list);
                }
            } else {
                next.a(false, list);
            }
            Iterator<d> it = d.a(next.f4120a).iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next().b(f.class);
                if (fVar != null) {
                    Class<? extends e> a3 = fVar.a();
                    Constructor[] constructors = a3.getConstructors();
                    if (constructors.length != 1) {
                        error = new Error("ParameterSupplier " + a3.getName() + " must have only one constructor (either empty or taking only a TestClass)");
                    } else {
                        Class[] parameterTypes = constructors[0].getParameterTypes();
                        if (parameterTypes.length != 0 && !parameterTypes[0].equals(k.class)) {
                            error = new Error("ParameterSupplier " + a3.getName() + " constructor must take either nothing or a single TestClass instance");
                        }
                    }
                    list.add(error);
                }
            }
        }
    }
}

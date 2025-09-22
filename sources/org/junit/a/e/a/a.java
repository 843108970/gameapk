package org.junit.a.e.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.a.e.b;
import org.junit.a.e.e;
import org.junit.a.e.g;
import org.junit.e.a.d;
import org.junit.e.a.k;

public class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final k f4114a;

    /* renamed from: org.junit.a.e.a.a$a  reason: collision with other inner class name */
    static class C0065a extends g {

        /* renamed from: a  reason: collision with root package name */
        private final d f4115a;

        private C0065a(d dVar) {
            this.f4115a = dVar;
        }

        /* synthetic */ C0065a(d dVar, byte b2) {
            this(dVar);
        }

        public final Object a() throws g.a {
            boolean z = false;
            try {
                return this.f4115a.a((Object) null, new Object[0]);
            } catch (IllegalArgumentException unused) {
                throw new RuntimeException("unexpected: argument length is checked");
            } catch (IllegalAccessException unused2) {
                throw new RuntimeException("unexpected: getMethods returned an inaccessible method");
            } catch (Throwable th) {
                org.junit.a.e.a aVar = (org.junit.a.e.a) this.f4115a.a(org.junit.a.e.a.class);
                if (aVar == null || !a.b((Class<?>[]) aVar.b(), (Object) th)) {
                    z = true;
                }
                org.junit.d.a(z);
                throw new g.a(th);
            }
        }

        public final String b() throws g.a {
            return this.f4115a.f4120a.getName();
        }
    }

    public a(k kVar) {
        this.f4114a = kVar;
    }

    private static Object a(Field field) {
        try {
            return field.get((Object) null);
        } catch (IllegalArgumentException unused) {
            throw new RuntimeException("unexpected: field from getClass doesn't exist on object");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("unexpected: getFields returned an inaccessible field");
        }
    }

    private static void a(Class<?> cls, org.junit.a.e.d dVar, String str, List<g> list, Object obj) {
        if (cls.isArray()) {
            for (int i = 0; i < Array.getLength(obj); i++) {
                Object obj2 = Array.get(obj, i);
                if (dVar.a(obj2)) {
                    list.add(g.a(str + "[" + i + "]", obj2));
                }
            }
        } else if (Iterable.class.isAssignableFrom(cls)) {
            a(dVar, str, list, (Iterable<?>) (Iterable) obj);
        }
    }

    private static void a(org.junit.a.e.d dVar, String str, List<g> list, Iterable<?> iterable) {
        int i = 0;
        for (Object next : iterable) {
            if (dVar.a((Object) next)) {
                list.add(g.a(str + "[" + i + "]", next));
            }
            i++;
        }
    }

    private static void a(org.junit.a.e.d dVar, String str, List<g> list, Object obj) {
        for (int i = 0; i < Array.getLength(obj); i++) {
            Object obj2 = Array.get(obj, i);
            if (dVar.a(obj2)) {
                list.add(g.a(str + "[" + i + "]", obj2));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        if ((r3.isAssignableFrom(r7.f4117a) || org.junit.a.e.d.a(r3, r7.f4117a) || r7.a(r3)) == false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.junit.a.e.d r7, java.util.List<org.junit.a.e.g> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            java.util.Collection r0 = r6.b(r7)
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0071
            java.lang.Object r1 = r0.next()
            org.junit.e.a.d r1 = (org.junit.e.a.d) r1
            java.lang.reflect.Method r2 = r1.f4120a
            java.lang.Class r2 = r2.getReturnType()
            boolean r3 = r2.isArray()
            r4 = 0
            if (r3 == 0) goto L_0x0041
            java.lang.Class r3 = r2.getComponentType()
            java.lang.Class<?> r5 = r7.f4117a
            boolean r5 = r3.isAssignableFrom(r5)
            if (r5 != 0) goto L_0x003e
            java.lang.Class<?> r5 = r7.f4117a
            boolean r5 = org.junit.a.e.d.a((java.lang.Class<?>) r3, (java.lang.Class<?>) r5)
            if (r5 != 0) goto L_0x003e
            boolean r3 = r7.a((java.lang.Class<?>) r3)
            if (r3 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r3 = 0
            goto L_0x003f
        L_0x003e:
            r3 = 1
        L_0x003f:
            if (r3 != 0) goto L_0x0049
        L_0x0041:
            java.lang.Class<java.lang.Iterable> r3 = java.lang.Iterable.class
            boolean r3 = r3.isAssignableFrom(r2)
            if (r3 == 0) goto L_0x0008
        L_0x0049:
            java.lang.reflect.Method r3 = r1.f4120a     // Catch:{ Throwable -> 0x005a }
            java.lang.String r3 = r3.getName()     // Catch:{ Throwable -> 0x005a }
            r5 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Throwable -> 0x005a }
            java.lang.Object r4 = r1.a((java.lang.Object) r5, (java.lang.Object[]) r4)     // Catch:{ Throwable -> 0x005a }
            a(r2, r7, r3, r8, r4)     // Catch:{ Throwable -> 0x005a }
            goto L_0x0008
        L_0x005a:
            r7 = move-exception
            java.lang.Class<org.junit.a.e.b> r8 = org.junit.a.e.b.class
            java.lang.annotation.Annotation r8 = r1.a(r8)
            org.junit.a.e.b r8 = (org.junit.a.e.b) r8
            if (r8 == 0) goto L_0x0070
            java.lang.Class[] r8 = r8.b()
            boolean r8 = b((java.lang.Class<?>[]) r8, (java.lang.Object) r7)
            if (r8 == 0) goto L_0x0070
            return
        L_0x0070:
            throw r7
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.a.e.a.a.a(org.junit.a.e.d, java.util.List):void");
    }

    private void b(org.junit.a.e.d dVar, List<g> list) {
        for (d next : e(dVar)) {
            if (dVar.a(next.f4120a.getReturnType())) {
                list.add(new C0065a(next, (byte) 0));
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(Class<?>[] clsArr, Object obj) {
        for (Class<?> isAssignableFrom : clsArr) {
            if (isAssignableFrom.isAssignableFrom(obj.getClass())) {
                return true;
            }
        }
        return false;
    }

    private void c(org.junit.a.e.d dVar, List<g> list) {
        for (Field next : d(dVar)) {
            a(next.getType(), dVar, next.getName(), list, a(next));
        }
    }

    private void d(org.junit.a.e.d dVar, List<g> list) {
        for (Field next : c(dVar)) {
            Object a2 = a(next);
            if (dVar.a(a2)) {
                list.add(g.a(next.getName(), a2));
            }
        }
    }

    public final List<g> a(org.junit.a.e.d dVar) throws Throwable {
        ArrayList arrayList = new ArrayList();
        d(dVar, arrayList);
        c(dVar, arrayList);
        b(dVar, (List<g>) arrayList);
        a(dVar, (List<g>) arrayList);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Collection<d> b(org.junit.a.e.d dVar) {
        return this.f4114a.b((Class<? extends Annotation>) b.class);
    }

    /* access modifiers changed from: protected */
    public Collection<Field> c(org.junit.a.e.d dVar) {
        List<org.junit.e.a.b> c2 = this.f4114a.c(org.junit.a.e.a.class);
        ArrayList arrayList = new ArrayList();
        for (org.junit.e.a.b bVar : c2) {
            arrayList.add(bVar.f4119a);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Collection<Field> d(org.junit.a.e.d dVar) {
        List<org.junit.e.a.b> c2 = this.f4114a.c(b.class);
        ArrayList arrayList = new ArrayList();
        for (org.junit.e.a.b bVar : c2) {
            arrayList.add(bVar.f4119a);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Collection<d> e(org.junit.a.e.d dVar) {
        return this.f4114a.b((Class<? extends Annotation>) org.junit.a.e.a.class);
    }
}

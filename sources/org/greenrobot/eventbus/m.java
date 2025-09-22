package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.a.c;
import org.greenrobot.eventbus.a.d;

final class m {

    /* renamed from: a  reason: collision with root package name */
    static final Map<Class<?>, List<l>> f4328a = new ConcurrentHashMap();
    private static final int d = 64;
    private static final int e = 4096;
    private static final int f = 5192;
    private static final int h = 4;
    private static final a[] i = new a[4];

    /* renamed from: b  reason: collision with root package name */
    List<d> f4329b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f4330c;
    private final boolean g;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final List<l> f4331a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final Map<Class, Object> f4332b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        final Map<String, Class> f4333c = new HashMap();
        final StringBuilder d = new StringBuilder(128);
        Class<?> e;
        Class<?> f;
        boolean g;
        c h;

        a() {
        }

        private void b() {
            this.f4331a.clear();
            this.f4332b.clear();
            this.f4333c.clear();
            this.d.setLength(0);
            this.e = null;
            this.f = null;
            this.g = false;
            this.h = null;
        }

        private boolean b(Method method, Class<?> cls) {
            this.d.setLength(0);
            this.d.append(method.getName());
            StringBuilder sb = this.d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f4333c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f4333c.put(sb2, put);
            return false;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (!this.g) {
                this.f = this.f.getSuperclass();
                String name = this.f.getName();
                if (!name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("android.")) {
                    return;
                }
            }
            this.f = null;
        }

        /* access modifiers changed from: package-private */
        public final void a(Class<?> cls) {
            this.f = cls;
            this.e = cls;
            this.g = false;
            this.h = null;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(Method method, Class<?> cls) {
            Object put = this.f4332b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (!b((Method) put, cls)) {
                    throw new IllegalStateException();
                }
                this.f4332b.put(cls, this);
            }
            return b(method, cls);
        }
    }

    m(List<d> list, boolean z, boolean z2) {
        this.f4329b = list;
        this.g = z;
        this.f4330c = z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        if (r0.f == r1.a()) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<org.greenrobot.eventbus.l> a(java.lang.Class<?> r8) {
        /*
            r7 = this;
            java.util.Map<java.lang.Class<?>, java.util.List<org.greenrobot.eventbus.l>> r0 = f4328a
            java.lang.Object r0 = r0.get(r8)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x000b
            return r0
        L_0x000b:
            boolean r0 = r7.f4330c
            if (r0 == 0) goto L_0x0027
            org.greenrobot.eventbus.m$a r0 = a()
            r0.a(r8)
        L_0x0016:
            java.lang.Class<?> r1 = r0.f
            if (r1 == 0) goto L_0x0021
            r7.b((org.greenrobot.eventbus.m.a) r0)
            r0.a()
            goto L_0x0016
        L_0x0021:
            java.util.List r0 = a((org.greenrobot.eventbus.m.a) r0)
            goto L_0x0097
        L_0x0027:
            org.greenrobot.eventbus.m$a r0 = a()
            r0.a(r8)
        L_0x002e:
            java.lang.Class<?> r1 = r0.f
            if (r1 == 0) goto L_0x0021
            org.greenrobot.eventbus.a.c r1 = r0.h
            if (r1 == 0) goto L_0x004d
            org.greenrobot.eventbus.a.c r1 = r0.h
            org.greenrobot.eventbus.a.c r1 = r1.b()
            if (r1 == 0) goto L_0x004d
            org.greenrobot.eventbus.a.c r1 = r0.h
            org.greenrobot.eventbus.a.c r1 = r1.b()
            java.lang.Class<?> r2 = r0.f
            java.lang.Class r3 = r1.a()
            if (r2 != r3) goto L_0x004d
            goto L_0x006c
        L_0x004d:
            java.util.List<org.greenrobot.eventbus.a.d> r1 = r7.f4329b
            if (r1 == 0) goto L_0x006b
            java.util.List<org.greenrobot.eventbus.a.d> r1 = r7.f4329b
            java.util.Iterator r1 = r1.iterator()
        L_0x0057:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x006b
            java.lang.Object r2 = r1.next()
            org.greenrobot.eventbus.a.d r2 = (org.greenrobot.eventbus.a.d) r2
            org.greenrobot.eventbus.a.c r2 = r2.a()
            if (r2 == 0) goto L_0x0057
            r1 = r2
            goto L_0x006c
        L_0x006b:
            r1 = 0
        L_0x006c:
            r0.h = r1
            org.greenrobot.eventbus.a.c r1 = r0.h
            if (r1 == 0) goto L_0x0090
            org.greenrobot.eventbus.a.c r1 = r0.h
            org.greenrobot.eventbus.l[] r1 = r1.d()
            int r2 = r1.length
            r3 = 0
        L_0x007a:
            if (r3 >= r2) goto L_0x0093
            r4 = r1[r3]
            java.lang.reflect.Method r5 = r4.f4325a
            java.lang.Class<?> r6 = r4.f4327c
            boolean r5 = r0.a(r5, r6)
            if (r5 == 0) goto L_0x008d
            java.util.List<org.greenrobot.eventbus.l> r5 = r0.f4331a
            r5.add(r4)
        L_0x008d:
            int r3 = r3 + 1
            goto L_0x007a
        L_0x0090:
            r7.b((org.greenrobot.eventbus.m.a) r0)
        L_0x0093:
            r0.a()
            goto L_0x002e
        L_0x0097:
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x00b6
            org.greenrobot.eventbus.e r0 = new org.greenrobot.eventbus.e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Subscriber "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r8 = " and its super classes have no public methods with the @Subscribe annotation"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>((java.lang.String) r8)
            throw r0
        L_0x00b6:
            java.util.Map<java.lang.Class<?>, java.util.List<org.greenrobot.eventbus.l>> r1 = f4328a
            r1.put(r8, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.m.a(java.lang.Class):java.util.List");
    }

    static List<l> a(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f4331a);
        aVar.f4331a.clear();
        aVar.f4332b.clear();
        aVar.f4333c.clear();
        int i2 = 0;
        aVar.d.setLength(0);
        aVar.e = null;
        aVar.f = null;
        aVar.g = false;
        aVar.h = null;
        synchronized (i) {
            while (true) {
                if (i2 >= 4) {
                    break;
                }
                try {
                    if (i[i2] == null) {
                        i[i2] = aVar;
                        break;
                    }
                    i2++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    static a a() {
        synchronized (i) {
            int i2 = 0;
            while (i2 < 4) {
                try {
                    a aVar = i[i2];
                    if (aVar != null) {
                        i[i2] = null;
                        return aVar;
                    }
                    i2++;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            return new a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        if (r0.f == r7.a()) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<org.greenrobot.eventbus.l> b(java.lang.Class<?> r7) {
        /*
            r6 = this;
            org.greenrobot.eventbus.m$a r0 = a()
            r0.a(r7)
        L_0x0007:
            java.lang.Class<?> r7 = r0.f
            if (r7 == 0) goto L_0x0070
            org.greenrobot.eventbus.a.c r7 = r0.h
            if (r7 == 0) goto L_0x0026
            org.greenrobot.eventbus.a.c r7 = r0.h
            org.greenrobot.eventbus.a.c r7 = r7.b()
            if (r7 == 0) goto L_0x0026
            org.greenrobot.eventbus.a.c r7 = r0.h
            org.greenrobot.eventbus.a.c r7 = r7.b()
            java.lang.Class<?> r1 = r0.f
            java.lang.Class r2 = r7.a()
            if (r1 != r2) goto L_0x0026
            goto L_0x0045
        L_0x0026:
            java.util.List<org.greenrobot.eventbus.a.d> r7 = r6.f4329b
            if (r7 == 0) goto L_0x0044
            java.util.List<org.greenrobot.eventbus.a.d> r7 = r6.f4329b
            java.util.Iterator r7 = r7.iterator()
        L_0x0030:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r7.next()
            org.greenrobot.eventbus.a.d r1 = (org.greenrobot.eventbus.a.d) r1
            org.greenrobot.eventbus.a.c r1 = r1.a()
            if (r1 == 0) goto L_0x0030
            r7 = r1
            goto L_0x0045
        L_0x0044:
            r7 = 0
        L_0x0045:
            r0.h = r7
            org.greenrobot.eventbus.a.c r7 = r0.h
            if (r7 == 0) goto L_0x0069
            org.greenrobot.eventbus.a.c r7 = r0.h
            org.greenrobot.eventbus.l[] r7 = r7.d()
            int r1 = r7.length
            r2 = 0
        L_0x0053:
            if (r2 >= r1) goto L_0x006c
            r3 = r7[r2]
            java.lang.reflect.Method r4 = r3.f4325a
            java.lang.Class<?> r5 = r3.f4327c
            boolean r4 = r0.a(r4, r5)
            if (r4 == 0) goto L_0x0066
            java.util.List<org.greenrobot.eventbus.l> r4 = r0.f4331a
            r4.add(r3)
        L_0x0066:
            int r2 = r2 + 1
            goto L_0x0053
        L_0x0069:
            r6.b((org.greenrobot.eventbus.m.a) r0)
        L_0x006c:
            r0.a()
            goto L_0x0007
        L_0x0070:
            java.util.List r7 = a((org.greenrobot.eventbus.m.a) r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.m.b(java.lang.Class):java.util.List");
    }

    static void b() {
        f4328a.clear();
    }

    private List<l> c(Class<?> cls) {
        a a2 = a();
        a2.a(cls);
        while (a2.f != null) {
            b(a2);
            a2.a();
        }
        return a(a2);
    }

    private c c(a aVar) {
        if (!(aVar.h == null || aVar.h.b() == null)) {
            c b2 = aVar.h.b();
            if (aVar.f == b2.a()) {
                return b2;
            }
        }
        if (this.f4329b == null) {
            return null;
        }
        for (d a2 : this.f4329b) {
            c a3 = a2.a();
            if (a3 != null) {
                return a3;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar) {
        Method[] methodArr;
        try {
            methodArr = aVar.f.getDeclaredMethods();
        } catch (Throwable unused) {
            methodArr = aVar.f.getMethods();
            aVar.g = true;
        }
        for (Method method : methodArr) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & f) == 0) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    j jVar = (j) method.getAnnotation(j.class);
                    if (jVar != null) {
                        Class cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f4331a.add(new l(method, cls, jVar.a(), jVar.c(), jVar.b()));
                        }
                    }
                } else if (this.g && method.isAnnotationPresent(j.class)) {
                    throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.g && method.isAnnotationPresent(j.class)) {
                throw new e((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }
}

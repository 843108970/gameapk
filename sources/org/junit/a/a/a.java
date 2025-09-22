package org.junit.a.a;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.e.a.e;
import org.junit.e.g;

public final class a extends g {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        Class<?>[] a() default {};

        boolean b() default true;
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        Class<?>[] a() default {};

        boolean b() default true;
    }

    /* renamed from: org.junit.a.a.a$a  reason: collision with other inner class name */
    public static class C0068a extends org.junit.runner.a.a {

        /* renamed from: b  reason: collision with root package name */
        private final Set<Class<?>> f4425b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<Class<?>> f4426c;
        private final boolean d;
        private final boolean e;

        protected C0068a(boolean z, Set<Class<?>> set, boolean z2, Set<Class<?>> set2) {
            this.d = z;
            this.e = z2;
            this.f4425b = a(set);
            this.f4426c = a(set2);
        }

        private static Set<Class<?>> a(Set<Class<?>> set) {
            HashSet hashSet = new HashSet();
            if (set != null) {
                hashSet.addAll(set);
            }
            hashSet.remove((Object) null);
            return hashSet;
        }

        private static C0068a a(Class<?> cls) {
            return a((Class<?>[]) new Class[]{cls});
        }

        public static C0068a a(boolean z, Set<Class<?>> set, boolean z2, Set<Class<?>> set2) {
            return new C0068a(z, set, z2, set2);
        }

        private static C0068a a(Class<?>... clsArr) {
            if (!e(clsArr)) {
                return a(true, a.b(clsArr), true, (Set<Class<?>>) null);
            }
            throw new NullPointerException("has null category");
        }

        private static boolean a(Set<Class<?>> set, Set<Class<?>> set2) {
            for (Class<?> a2 : set2) {
                if (a.a(set, a2)) {
                    return true;
                }
            }
            return false;
        }

        private static C0068a b(Class<?> cls) {
            return c((Class<?>[]) new Class[]{cls});
        }

        private static C0068a b(Class<?>... clsArr) {
            return a(clsArr);
        }

        private static boolean b(Set<Class<?>> set, Set<Class<?>> set2) {
            for (Class<?> a2 : set2) {
                if (!a.a(set, a2)) {
                    return false;
                }
            }
            return true;
        }

        private static C0068a c(Class<?>... clsArr) {
            if (!e(clsArr)) {
                return a(true, (Set<Class<?>>) null, true, a.b(clsArr));
            }
            throw new NullPointerException("has null category");
        }

        private boolean c(org.junit.runner.c cVar) {
            HashSet hashSet = new HashSet();
            Collections.addAll(hashSet, f(cVar));
            Class<?> testClass = cVar.getTestClass();
            Collections.addAll(hashSet, f(testClass == null ? null : org.junit.runner.c.createSuiteDescription(testClass)));
            if (hashSet.isEmpty()) {
                return this.f4425b.isEmpty();
            }
            if (!this.f4426c.isEmpty()) {
                if (this.e) {
                    if (a(hashSet, this.f4426c)) {
                        return false;
                    }
                } else if (b(hashSet, this.f4426c)) {
                    return false;
                }
            }
            if (this.f4425b.isEmpty()) {
                return true;
            }
            return this.d ? a(hashSet, this.f4425b) : b(hashSet, this.f4425b);
        }

        private static Set<Class<?>> d(org.junit.runner.c cVar) {
            HashSet hashSet = new HashSet();
            Collections.addAll(hashSet, f(cVar));
            Class<?> testClass = cVar.getTestClass();
            Collections.addAll(hashSet, f(testClass == null ? null : org.junit.runner.c.createSuiteDescription(testClass)));
            return hashSet;
        }

        private static C0068a d(Class<?>... clsArr) {
            return c(clsArr);
        }

        private static org.junit.runner.c e(org.junit.runner.c cVar) {
            Class<?> testClass = cVar.getTestClass();
            if (testClass == null) {
                return null;
            }
            return org.junit.runner.c.createSuiteDescription(testClass);
        }

        private static boolean e(Class<?>... clsArr) {
            if (clsArr == null) {
                return false;
            }
            for (Class<?> cls : clsArr) {
                if (cls == null) {
                    return true;
                }
            }
            return false;
        }

        private static Class<?>[] f(org.junit.runner.c cVar) {
            if (cVar == null) {
                return new Class[0];
            }
            b bVar = (b) cVar.getAnnotation(b.class);
            return bVar == null ? new Class[0] : bVar.a();
        }

        public String a() {
            return toString();
        }

        public final boolean a(org.junit.runner.c cVar) {
            HashSet hashSet = new HashSet();
            Collections.addAll(hashSet, f(cVar));
            Class<?> testClass = cVar.getTestClass();
            Collections.addAll(hashSet, f(testClass == null ? null : org.junit.runner.c.createSuiteDescription(testClass)));
            if (hashSet.isEmpty() ? this.f4425b.isEmpty() : (this.f4426c.isEmpty() || (!this.e ? !b(hashSet, this.f4426c) : !a(hashSet, this.f4426c))) ? this.f4425b.isEmpty() ? true : this.d ? a(hashSet, this.f4425b) : b(hashSet, this.f4425b) : false) {
                return true;
            }
            Iterator<org.junit.runner.c> it = cVar.getChildren().iterator();
            while (it.hasNext()) {
                if (a(it.next())) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("categories ");
            sb.append(this.f4425b.isEmpty() ? "[all]" : this.f4425b);
            if (!this.f4426c.isEmpty()) {
                sb.append(" - ");
                sb.append(this.f4426c);
            }
            return sb.toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b A[Catch:{ c -> 0x0062 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private a(java.lang.Class<?> r6, org.junit.e.a.h r7) throws org.junit.e.a.e {
        /*
            r5 = this;
            r5.<init>((java.lang.Class<?>) r6, (org.junit.e.a.h) r7)
            java.lang.Class<org.junit.a.a.a$c> r7 = org.junit.a.a.a.c.class
            java.lang.annotation.Annotation r7 = r6.getAnnotation(r7)     // Catch:{ c -> 0x0062 }
            org.junit.a.a.a$c r7 = (org.junit.a.a.a.c) r7     // Catch:{ c -> 0x0062 }
            r0 = 0
            if (r7 != 0) goto L_0x0010
            r7 = r0
            goto L_0x0014
        L_0x0010:
            java.lang.Class[] r7 = r7.a()     // Catch:{ c -> 0x0062 }
        L_0x0014:
            java.util.Set r7 = b((java.lang.Class<?>[]) r7)     // Catch:{ c -> 0x0062 }
            java.lang.Class<org.junit.a.a.a$b> r1 = org.junit.a.a.a.b.class
            java.lang.annotation.Annotation r1 = r6.getAnnotation(r1)     // Catch:{ c -> 0x0062 }
            org.junit.a.a.a$b r1 = (org.junit.a.a.a.b) r1     // Catch:{ c -> 0x0062 }
            if (r1 != 0) goto L_0x0023
            goto L_0x0027
        L_0x0023:
            java.lang.Class[] r0 = r1.a()     // Catch:{ c -> 0x0062 }
        L_0x0027:
            java.util.Set r0 = b((java.lang.Class<?>[]) r0)     // Catch:{ c -> 0x0062 }
            java.lang.Class<org.junit.a.a.a$c> r1 = org.junit.a.a.a.c.class
            java.lang.annotation.Annotation r1 = r6.getAnnotation(r1)     // Catch:{ c -> 0x0062 }
            org.junit.a.a.a$c r1 = (org.junit.a.a.a.c) r1     // Catch:{ c -> 0x0062 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0040
            boolean r1 = r1.b()     // Catch:{ c -> 0x0062 }
            if (r1 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r1 = 0
            goto L_0x0041
        L_0x0040:
            r1 = 1
        L_0x0041:
            java.lang.Class<org.junit.a.a.a$b> r4 = org.junit.a.a.a.b.class
            java.lang.annotation.Annotation r6 = r6.getAnnotation(r4)     // Catch:{ c -> 0x0062 }
            org.junit.a.a.a$b r6 = (org.junit.a.a.a.b) r6     // Catch:{ c -> 0x0062 }
            if (r6 == 0) goto L_0x0053
            boolean r6 = r6.b()     // Catch:{ c -> 0x0062 }
            if (r6 == 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r2 = 0
        L_0x0053:
            org.junit.a.a.a$a r6 = org.junit.a.a.a.C0068a.a(r1, r7, r2, r0)     // Catch:{ c -> 0x0062 }
            r5.a((org.junit.runner.a.a) r6)     // Catch:{ c -> 0x0062 }
            org.junit.runner.c r6 = r5.b()
            a((org.junit.runner.c) r6)
            return
        L_0x0062:
            r6 = move-exception
            org.junit.e.a.e r7 = new org.junit.e.a.e
            r7.<init>((java.lang.Throwable) r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.a.a.a.<init>(java.lang.Class, org.junit.e.a.h):void");
    }

    private static Set<Class<?>> a(Class<?> cls) {
        c cVar = (c) cls.getAnnotation(c.class);
        return b((Class<?>[]) cVar == null ? null : cVar.a());
    }

    private static void a(org.junit.runner.c cVar) throws e {
        boolean z;
        Iterator<org.junit.runner.c> it = cVar.getChildren().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().getTestClass() == null) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        if (!z) {
            b(cVar);
        }
        Iterator<org.junit.runner.c> it2 = cVar.getChildren().iterator();
        while (it2.hasNext()) {
            a(it2.next());
        }
    }

    static /* synthetic */ boolean a(Set set, Class cls) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom((Class) it.next())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static Set<Class<?>> b(Class<?>... clsArr) {
        HashSet hashSet = new HashSet();
        if (clsArr != null) {
            Collections.addAll(hashSet, clsArr);
        }
        return hashSet;
    }

    private static void b(org.junit.runner.c cVar) throws e {
        Iterator<org.junit.runner.c> it = cVar.getChildren().iterator();
        while (it.hasNext()) {
            org.junit.runner.c next = it.next();
            if (next.getAnnotation(b.class) != null) {
                throw new e("Category annotations on Parameterized classes are not supported on individual methods.");
            }
            b(next);
        }
    }

    private static boolean b(Class<?> cls) {
        c cVar = (c) cls.getAnnotation(c.class);
        return cVar == null || cVar.b();
    }

    private static boolean b(Set<Class<?>> set, Class<?> cls) {
        for (Class<?> isAssignableFrom : set) {
            if (cls.isAssignableFrom(isAssignableFrom)) {
                return true;
            }
        }
        return false;
    }

    private static Set<Class<?>> c(Class<?> cls) {
        b bVar = (b) cls.getAnnotation(b.class);
        return b((Class<?>[]) bVar == null ? null : bVar.a());
    }

    private static boolean c(org.junit.runner.c cVar) {
        Iterator<org.junit.runner.c> it = cVar.getChildren().iterator();
        while (it.hasNext()) {
            if (it.next().getTestClass() == null) {
                return false;
            }
        }
        return true;
    }

    private static boolean d(Class<?> cls) {
        b bVar = (b) cls.getAnnotation(b.class);
        return bVar == null || bVar.b();
    }
}

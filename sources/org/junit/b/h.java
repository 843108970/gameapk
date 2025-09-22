package org.junit.b;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.j;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<Method> f4525a = new Comparator<Method>() {
        private static int a(Method method, Method method2) {
            int hashCode = method.getName().hashCode();
            int hashCode2 = method2.getName().hashCode();
            return hashCode != hashCode2 ? hashCode < hashCode2 ? -1 : 1 : h.f4526b.compare(method, method2);
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            Method method = (Method) obj;
            Method method2 = (Method) obj2;
            int hashCode = method.getName().hashCode();
            int hashCode2 = method2.getName().hashCode();
            return hashCode != hashCode2 ? hashCode < hashCode2 ? -1 : 1 : h.f4526b.compare(method, method2);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final Comparator<Method> f4526b = new Comparator<Method>() {
        private static int a(Method method, Method method2) {
            int compareTo = method.getName().compareTo(method2.getName());
            return compareTo != 0 ? compareTo : method.toString().compareTo(method2.toString());
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            Method method = (Method) obj;
            Method method2 = (Method) obj2;
            int compareTo = method.getName().compareTo(method2.getName());
            return compareTo != 0 ? compareTo : method.toString().compareTo(method2.toString());
        }
    };

    private h() {
    }

    private static Comparator<Method> a(j jVar) {
        return jVar == null ? f4525a : jVar.a().getComparator();
    }

    public static Method[] a(Class<?> cls) {
        j jVar = (j) cls.getAnnotation(j.class);
        Comparator<Method> comparator = jVar == null ? f4525a : jVar.a().getComparator();
        Method[] declaredMethods = cls.getDeclaredMethods();
        if (comparator != null) {
            Arrays.sort(declaredMethods, comparator);
        }
        return declaredMethods;
    }
}

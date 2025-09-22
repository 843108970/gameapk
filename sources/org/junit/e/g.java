package org.junit.e;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import org.junit.e.a.e;
import org.junit.e.a.h;
import org.junit.runner.c;
import org.junit.runner.k;

public class g extends f<k> {

    /* renamed from: a  reason: collision with root package name */
    private final List<k> f4592a;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
        Class<?>[] a();
    }

    protected g(Class<?> cls, List<k> list) throws e {
        super(cls);
        this.f4592a = Collections.unmodifiableList(list);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g(java.lang.Class<?> r4, org.junit.e.a.h r5) throws org.junit.e.a.e {
        /*
            r3 = this;
            java.lang.Class<org.junit.e.g$a> r0 = org.junit.e.g.a.class
            java.lang.annotation.Annotation r0 = r4.getAnnotation(r0)
            org.junit.e.g$a r0 = (org.junit.e.g.a) r0
            if (r0 != 0) goto L_0x0020
            org.junit.e.a.e r5 = new org.junit.e.a.e
            java.lang.String r0 = "class '%s' must have a SuiteClasses annotation"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            java.lang.String r4 = r4.getName()
            r1[r2] = r4
            java.lang.String r4 = java.lang.String.format(r0, r1)
            r5.<init>((java.lang.String) r4)
            throw r5
        L_0x0020:
            java.lang.Class[] r0 = r0.a()
            r3.<init>(r5, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.e.g.<init>(java.lang.Class, org.junit.e.a.h):void");
    }

    protected g(h hVar, Class<?> cls, Class<?>[] clsArr) throws e {
        this(cls, hVar.a(cls, clsArr));
    }

    public g(h hVar, Class<?>[] clsArr) throws e {
        this((Class<?>) null, hVar.a((Class<?>) null, clsArr));
    }

    private g(Class<?>[] clsArr) throws e {
        this(new org.junit.b.a.a(true), (Class<?>) null, clsArr);
    }

    private static c a(k kVar) {
        return kVar.b();
    }

    public static k a() {
        try {
            return new g(new Class[0]);
        } catch (e unused) {
            throw new RuntimeException("This shouldn't be possible");
        }
    }

    private static void a(k kVar, org.junit.runner.b.c cVar) {
        kVar.a(cVar);
    }

    private static Class<?>[] a(Class<?> cls) throws e {
        a aVar = (a) cls.getAnnotation(a.class);
        if (aVar != null) {
            return aVar.a();
        }
        throw new e(String.format("class '%s' must have a SuiteClasses annotation", new Object[]{cls.getName()}));
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void a(Object obj, org.junit.runner.b.c cVar) {
        ((k) obj).a(cVar);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ c b(Object obj) {
        return ((k) obj).b();
    }

    /* access modifiers changed from: protected */
    public List<k> d() {
        return this.f4592a;
    }
}

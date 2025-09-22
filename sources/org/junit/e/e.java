package org.junit.e;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.e.b.d;
import org.junit.runner.k;

public final class e extends g {

    /* renamed from: a  reason: collision with root package name */
    private static final org.junit.e.b.c f4579a = new org.junit.e.b.b();

    /* renamed from: b  reason: collision with root package name */
    private static final List<k> f4580b = Collections.emptyList();
    private final List<k> e;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
        int a() default 0;
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        String a() default "{index}";
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        Class<? extends org.junit.e.b.c> a() default org.junit.e.b.b.class;
    }

    private e(Class<?> cls) throws Throwable {
        super(cls, f4580b);
        Iterable iterable;
        c cVar = (c) cls.getAnnotation(c.class);
        org.junit.e.b.c cVar2 = cVar == null ? f4579a : (org.junit.e.b.c) cVar.a().newInstance();
        b bVar = (b) g().a(b.class);
        Object a2 = g().a((Object) null, new Object[0]);
        if (a2 instanceof Iterable) {
            iterable = (Iterable) a2;
        } else if (a2 instanceof Object[]) {
            iterable = Arrays.asList((Object[]) a2);
        } else {
            throw h();
        }
        this.e = Collections.unmodifiableList(a((Iterable<Object>) iterable, bVar.a(), cVar2));
    }

    private List<d> a(Iterable<Object> iterable, String str) throws Exception {
        Object[] objArr;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (next instanceof Object[]) {
                objArr = (Object[]) next;
            } else {
                objArr = new Object[]{next};
            }
            org.junit.e.a.k kVar = this.f4583c;
            String format = MessageFormat.format(str.replaceAll("\\{index\\}", Integer.toString(i)), objArr);
            arrayList.add(new d("[" + format + "]", kVar, Arrays.asList(objArr)));
            i = i2;
        }
        return arrayList;
    }

    private List<k> a(Iterable<Object> iterable, String str, org.junit.e.b.c cVar) throws org.junit.e.a.e, Exception {
        Object[] objArr;
        try {
            ArrayList<d> arrayList = new ArrayList<>();
            int i = 0;
            for (Object next : iterable) {
                int i2 = i + 1;
                if (next instanceof Object[]) {
                    objArr = (Object[]) next;
                } else {
                    objArr = new Object[]{next};
                }
                org.junit.e.a.k kVar = this.f4583c;
                String format = MessageFormat.format(str.replaceAll("\\{index\\}", Integer.toString(i)), objArr);
                arrayList.add(new d("[" + format + "]", kVar, Arrays.asList(objArr)));
                i = i2;
            }
            ArrayList arrayList2 = new ArrayList();
            for (d a2 : arrayList) {
                arrayList2.add(cVar.a(a2));
            }
            return arrayList2;
        } catch (ClassCastException unused) {
            throw h();
        }
    }

    private static org.junit.e.b.c a(Class<?> cls) throws InstantiationException, IllegalAccessException {
        c cVar = (c) cls.getAnnotation(c.class);
        return cVar == null ? f4579a : (org.junit.e.b.c) cVar.a().newInstance();
    }

    private d a(String str, int i, Object obj) {
        Object[] objArr;
        if (obj instanceof Object[]) {
            objArr = (Object[]) obj;
        } else {
            objArr = new Object[]{obj};
        }
        org.junit.e.a.k kVar = this.f4583c;
        String format = MessageFormat.format(str.replaceAll("\\{index\\}", Integer.toString(i)), objArr);
        return new d("[" + format + "]", kVar, Arrays.asList(objArr));
    }

    private static d a(org.junit.e.a.k kVar, String str, int i, Object[] objArr) {
        String format = MessageFormat.format(str.replaceAll("\\{index\\}", Integer.toString(i)), objArr);
        return new d("[" + format + "]", kVar, Arrays.asList(objArr));
    }

    private Iterable<Object> c() throws Throwable {
        Object a2 = g().a((Object) null, new Object[0]);
        if (a2 instanceof Iterable) {
            return (Iterable) a2;
        }
        if (a2 instanceof Object[]) {
            return Arrays.asList((Object[]) a2);
        }
        throw h();
    }

    private org.junit.e.a.d g() throws Exception {
        for (org.junit.e.a.d next : this.f4583c.b((Class<? extends Annotation>) b.class)) {
            if (next.f() && next.g()) {
                return next;
            }
        }
        throw new Exception("No public static parameters method on class " + this.f4583c.b());
    }

    private Exception h() throws Exception {
        return new Exception(MessageFormat.format("{0}.{1}() must return an Iterable of arrays.", new Object[]{this.f4583c.b(), g().f4120a.getName()}));
    }

    /* access modifiers changed from: protected */
    public final List<k> d() {
        return this.e;
    }
}

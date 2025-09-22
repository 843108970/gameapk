package org.junit.e.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.e.a.d;
import org.junit.e.a.e;
import org.junit.e.a.j;
import org.junit.e.b;
import org.junit.e.e;
import org.junit.runner.b.c;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f4574a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4575b;

    public a(d dVar) throws e {
        super(dVar.f4577b.f4122b);
        this.f4574a = dVar.f4578c.toArray(new Object[dVar.f4578c.size()]);
        this.f4575b = dVar.f4576a;
    }

    private Object g() throws Exception {
        return this.f4583c.c().newInstance(this.f4574a);
    }

    private Object h() throws Exception {
        List<org.junit.e.a.b> i = i();
        if (i.size() != this.f4574a.length) {
            throw new Exception("Wrong number of parameters and @Parameter fields. @Parameter fields counted: " + i.size() + ", available parameters: " + this.f4574a.length + ".");
        }
        Object newInstance = this.f4583c.f4122b.newInstance();
        for (org.junit.e.a.b bVar : i) {
            Field field = bVar.f4119a;
            int a2 = ((e.a) field.getAnnotation(e.a.class)).a();
            try {
                field.set(newInstance, this.f4574a[a2]);
            } catch (IllegalArgumentException e) {
                throw new Exception(this.f4583c.b() + ": Trying to set " + field.getName() + " with the value " + this.f4574a[a2] + " that is not the right type (" + this.f4574a[a2].getClass().getSimpleName() + " instead of " + field.getType().getSimpleName() + ").", e);
            }
        }
        return newInstance;
    }

    private List<org.junit.e.a.b> i() {
        return this.f4583c.c(e.a.class);
    }

    private boolean j() {
        return !i().isEmpty();
    }

    /* access modifiers changed from: protected */
    public final String b(d dVar) {
        return dVar.f4120a.getName() + this.f4575b;
    }

    /* access modifiers changed from: protected */
    public final j b(c cVar) {
        return c(cVar);
    }

    /* access modifiers changed from: protected */
    public final void b(List<Throwable> list) {
        d(list);
        if (j()) {
            e(list);
        }
    }

    public final Object c() throws Exception {
        return j() ? h() : this.f4583c.c().newInstance(this.f4574a);
    }

    /* access modifiers changed from: protected */
    public final String e() {
        return this.f4575b;
    }

    /* access modifiers changed from: protected */
    public final void f(List<Throwable> list) {
        super.f(list);
        if (j()) {
            List<org.junit.e.a.b> i = i();
            int[] iArr = new int[i.size()];
            for (org.junit.e.a.b bVar : i) {
                int a2 = ((e.a) bVar.f4119a.getAnnotation(e.a.class)).a();
                if (a2 < 0 || a2 > i.size() - 1) {
                    list.add(new Exception("Invalid @Parameter value: " + a2 + ". @Parameter fields counted: " + i.size() + ". Please use an index between 0 and " + (i.size() - 1) + "."));
                } else {
                    iArr[a2] = iArr[a2] + 1;
                }
            }
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    list.add(new Exception("@Parameter(" + i2 + ") is never used."));
                } else if (i3 > 1) {
                    list.add(new Exception("@Parameter(" + i2 + ") is used more than once (" + i3 + ")."));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Annotation[] f() {
        return new Annotation[0];
    }
}

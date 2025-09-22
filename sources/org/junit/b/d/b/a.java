package org.junit.b.d.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.e.a.k;
import org.junit.l;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f4479a = a().a((j) new b((byte) 0)).a((j) new g((byte) 0)).a((j) new f((byte) 0)).a((j) new d((byte) 0)).a();

    /* renamed from: b  reason: collision with root package name */
    public static final a f4480b = b().a((j) new e((byte) 0)).a((j) new f((byte) 0)).a((j) new c((byte) 0)).a();

    /* renamed from: c  reason: collision with root package name */
    public static final a f4481c;
    public static final a d;
    private final Class<? extends Annotation> e;
    private final boolean f;
    private final List<j> g;

    /* renamed from: org.junit.b.d.b.a$a  reason: collision with other inner class name */
    private static class C0069a {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public final Class<? extends Annotation> f4482a;
        /* access modifiers changed from: package-private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f4483b;
        /* access modifiers changed from: package-private */

        /* renamed from: c  reason: collision with root package name */
        public final List<j> f4484c;

        private C0069a(Class<? extends Annotation> cls) {
            this.f4482a = cls;
            this.f4483b = false;
            this.f4484c = new ArrayList();
        }

        /* synthetic */ C0069a(Class cls, byte b2) {
            this(cls);
        }

        private C0069a b() {
            this.f4483b = true;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final C0069a a(j jVar) {
            this.f4484c.add(jVar);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final a a() {
            return new a(this);
        }
    }

    private static final class b implements j {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        private static boolean a(org.junit.e.a.c<?> cVar) {
            return Modifier.isPublic(cVar.e().getModifiers());
        }

        public final void a(org.junit.e.a.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!Modifier.isPublic(cVar.e().getModifiers())) {
                list.add(new b(cVar, cls, "must be declared in a public class."));
            }
        }
    }

    private static final class c implements j {
        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        public final void a(org.junit.e.a.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!a.b(cVar)) {
                list.add(new b(cVar, cls, "must implement MethodRule or TestRule."));
            }
        }
    }

    private static final class d implements j {
        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        public final void a(org.junit.e.a.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!a.e(cVar)) {
                list.add(new b(cVar, cls, "must implement TestRule."));
            }
        }
    }

    private static final class e implements j {
        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }

        public final void a(org.junit.e.a.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            boolean a2 = a.f(cVar);
            boolean z = cVar.a(org.junit.h.class) != null;
            if (!cVar.f()) {
                return;
            }
            if (a2 || !z) {
                list.add(new b(cVar, cls, a.f(cVar) ? "must not be static." : "must not be static or it must be annotated with @ClassRule."));
            }
        }
    }

    private static final class f implements j {
        private f() {
        }

        /* synthetic */ f(byte b2) {
            this();
        }

        public final void a(org.junit.e.a.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!cVar.g()) {
                list.add(new b(cVar, cls, "must be public."));
            }
        }
    }

    private static final class g implements j {
        private g() {
        }

        /* synthetic */ g(byte b2) {
            this();
        }

        public final void a(org.junit.e.a.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!cVar.f()) {
                list.add(new b(cVar, cls, "must be static."));
            }
        }
    }

    private static final class h implements j {
        private h() {
        }

        /* synthetic */ h(byte b2) {
            this();
        }

        public final void a(org.junit.e.a.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!a.b(cVar)) {
                list.add(new b(cVar, cls, "must return an implementation of MethodRule or TestRule."));
            }
        }
    }

    private static final class i implements j {
        private i() {
        }

        /* synthetic */ i(byte b2) {
            this();
        }

        public final void a(org.junit.e.a.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!a.e(cVar)) {
                list.add(new b(cVar, cls, "must return an implementation of TestRule."));
            }
        }
    }

    interface j {
        void a(org.junit.e.a.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list);
    }

    static {
        C0069a a2 = a();
        a2.f4483b = true;
        f4481c = a2.a((j) new b((byte) 0)).a((j) new g((byte) 0)).a((j) new f((byte) 0)).a((j) new i((byte) 0)).a();
        C0069a b2 = b();
        b2.f4483b = true;
        d = b2.a((j) new e((byte) 0)).a((j) new f((byte) 0)).a((j) new h((byte) 0)).a();
    }

    a(C0069a aVar) {
        this.e = aVar.f4482a;
        this.f = aVar.f4483b;
        this.g = aVar.f4484c;
    }

    private static C0069a a() {
        return new C0069a(org.junit.h.class, (byte) 0);
    }

    private void a(org.junit.e.a.c<?> cVar, List<Throwable> list) {
        for (j a2 : this.g) {
            a2.a(cVar, this.e, list);
        }
    }

    private static C0069a b() {
        return new C0069a(l.class, (byte) 0);
    }

    static /* synthetic */ boolean b(org.junit.e.a.c cVar) {
        return f(cVar) || e(cVar);
    }

    private static boolean d(org.junit.e.a.c<?> cVar) {
        return f(cVar) || e(cVar);
    }

    /* access modifiers changed from: private */
    public static boolean e(org.junit.e.a.c<?> cVar) {
        return org.junit.d.l.class.isAssignableFrom(cVar.d());
    }

    /* access modifiers changed from: private */
    public static boolean f(org.junit.e.a.c<?> cVar) {
        return org.junit.d.f.class.isAssignableFrom(cVar.d());
    }

    public final void a(k kVar, List<Throwable> list) {
        for (org.junit.e.a.c cVar : this.f ? kVar.b((Class<? extends Annotation>) this.e) : kVar.c(this.e)) {
            for (j a2 : this.g) {
                a2.a(cVar, this.e, list);
            }
        }
    }
}

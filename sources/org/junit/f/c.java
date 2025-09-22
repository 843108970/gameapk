package org.junit.f;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.e.a.k;

public final class c implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final List<a<?>> f4594a = Arrays.asList(new a[]{new b((byte) 0), new d((byte) 0), new C0070c((byte) 0)});

    private static abstract class a<T extends org.junit.e.a.a> {

        /* renamed from: a  reason: collision with root package name */
        private static final b f4595a = new b();

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        private List<Exception> a(T t) {
            ArrayList arrayList = new ArrayList();
            for (Annotation annotationType : t.a()) {
                f fVar = (f) annotationType.annotationType().getAnnotation(f.class);
                if (fVar != null) {
                    arrayList.addAll(a(b.a(fVar), t));
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public abstract Iterable<T> a(k kVar);

        /* access modifiers changed from: package-private */
        public abstract List<Exception> a(a aVar, T t);

        public final List<Exception> b(k kVar) {
            ArrayList arrayList = new ArrayList();
            for (org.junit.e.a.a a2 : a(kVar)) {
                arrayList.addAll(a(a2));
            }
            return arrayList;
        }
    }

    private static class b extends a<k> {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        private static List<Exception> a() {
            return a.a();
        }

        /* access modifiers changed from: package-private */
        public final Iterable<k> a(k kVar) {
            return Collections.singletonList(kVar);
        }

        /* access modifiers changed from: package-private */
        public final /* bridge */ /* synthetic */ List a(a aVar, org.junit.e.a.a aVar2) {
            return a.a();
        }
    }

    /* renamed from: org.junit.f.c$c  reason: collision with other inner class name */
    private static class C0070c extends a<org.junit.e.a.b> {
        private C0070c() {
            super((byte) 0);
        }

        /* synthetic */ C0070c(byte b2) {
            this();
        }

        private static List<Exception> a() {
            return a.b();
        }

        /* access modifiers changed from: package-private */
        public final Iterable<org.junit.e.a.b> a(k kVar) {
            return k.a(kVar.d);
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ List a(a aVar, org.junit.e.a.a aVar2) {
            return a.b();
        }
    }

    private static class d extends a<org.junit.e.a.d> {
        private d() {
            super((byte) 0);
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        private static List<Exception> a(a aVar, org.junit.e.a.d dVar) {
            return aVar.a(dVar);
        }

        /* access modifiers changed from: package-private */
        public final Iterable<org.junit.e.a.d> a(k kVar) {
            List<T> a2 = k.a(kVar.f4123c);
            Collections.sort(a2, k.f4121a);
            return a2;
        }

        /* access modifiers changed from: package-private */
        public final /* bridge */ /* synthetic */ List a(a aVar, org.junit.e.a.a aVar2) {
            return aVar.a((org.junit.e.a.d) aVar2);
        }
    }

    public final List<Exception> a(k kVar) {
        ArrayList arrayList = new ArrayList();
        for (a<?> b2 : f4594a) {
            arrayList.addAll(b2.b(kVar));
        }
        return arrayList;
    }
}

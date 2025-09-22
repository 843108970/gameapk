package com.bumptech.glide.load.b.a;

import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f1024a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f1025b = new HashMap();

    private static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f1026a;

        /* renamed from: b  reason: collision with root package name */
        List<V> f1027b;

        /* renamed from: c  reason: collision with root package name */
        a<K, V> f1028c;
        a<K, V> d;

        a() {
            this((Object) null);
        }

        a(K k) {
            this.d = this;
            this.f1028c = this;
            this.f1026a = k;
        }

        private void a(V v) {
            if (this.f1027b == null) {
                this.f1027b = new ArrayList();
            }
            this.f1027b.add(v);
        }

        @Nullable
        public final V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f1027b.remove(b2 - 1);
            }
            return null;
        }

        public final int b() {
            if (this.f1027b != null) {
                return this.f1027b.size();
            }
            return 0;
        }
    }

    h() {
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        aVar.d = this.f1024a;
        aVar.f1028c = this.f1024a.f1028c;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        aVar.d = this.f1024a.d;
        aVar.f1028c = this.f1024a;
        c(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.f1028c.d = aVar;
        aVar.d.f1028c = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.d.f1028c = aVar.f1028c;
        aVar.f1028c.d = aVar.d;
    }

    @Nullable
    public final V a() {
        a<K, V> aVar = this.f1024a;
        while (true) {
            aVar = aVar.d;
            if (aVar.equals(this.f1024a)) {
                return null;
            }
            V a2 = aVar.a();
            if (a2 != null) {
                return a2;
            }
            d(aVar);
            this.f1025b.remove(aVar.f1026a);
            ((m) aVar.f1026a).a();
        }
    }

    @Nullable
    public final V a(K k) {
        a aVar = this.f1025b.get(k);
        if (aVar == null) {
            aVar = new a(k);
            this.f1025b.put(k, aVar);
        } else {
            k.a();
        }
        d(aVar);
        aVar.d = this.f1024a;
        aVar.f1028c = this.f1024a.f1028c;
        c(aVar);
        return aVar.a();
    }

    public final void a(K k, V v) {
        a aVar = this.f1025b.get(k);
        if (aVar == null) {
            aVar = new a(k);
            d(aVar);
            aVar.d = this.f1024a.d;
            aVar.f1028c = this.f1024a;
            c(aVar);
            this.f1025b.put(k, aVar);
        } else {
            k.a();
        }
        if (aVar.f1027b == null) {
            aVar.f1027b = new ArrayList();
        }
        aVar.f1027b.add(v);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a<K, V> aVar = this.f1024a.f1028c; !aVar.equals(this.f1024a); aVar = aVar.f1028c) {
            z = true;
            sb.append('{');
            sb.append(aVar.f1026a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}

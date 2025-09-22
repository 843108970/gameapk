package com.bumptech.glide.load.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools;
import com.bumptech.glide.l;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.p;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.j;
import com.bumptech.glide.util.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n<Model, Data>> f1253a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f1254b;

    static class a<Data> implements d<Data>, d.a<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final List<d<Data>> f1255a;

        /* renamed from: b  reason: collision with root package name */
        private final Pools.Pool<List<Throwable>> f1256b;

        /* renamed from: c  reason: collision with root package name */
        private int f1257c = 0;
        private l d;
        private d.a<? super Data> e;
        @Nullable
        private List<Throwable> f;

        a(@NonNull List<d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f1256b = pool;
            i.a(list);
            this.f1255a = list;
        }

        private void e() {
            if (this.f1257c < this.f1255a.size() - 1) {
                this.f1257c++;
                a(this.d, this.e);
                return;
            }
            i.a(this.f, "Argument must not be null");
            this.e.a((Exception) new p("Fetch failed", (List<Throwable>) new ArrayList(this.f)));
        }

        @NonNull
        public final Class<Data> a() {
            return this.f1255a.get(0).a();
        }

        public final void a(@NonNull l lVar, @NonNull d.a<? super Data> aVar) {
            this.d = lVar;
            this.e = aVar;
            this.f = this.f1256b.acquire();
            this.f1255a.get(this.f1257c).a(lVar, this);
        }

        public final void a(@NonNull Exception exc) {
            ((List) i.a(this.f, "Argument must not be null")).add(exc);
            e();
        }

        public final void a(@Nullable Data data) {
            if (data != null) {
                this.e.a(data);
            } else {
                e();
            }
        }

        public final void b() {
            if (this.f != null) {
                this.f1256b.release(this.f);
            }
            this.f = null;
            for (d<Data> b2 : this.f1255a) {
                b2.b();
            }
        }

        public final void c() {
            for (d<Data> c2 : this.f1255a) {
                c2.c();
            }
        }

        @NonNull
        public final com.bumptech.glide.load.a d() {
            return this.f1255a.get(0).d();
        }
    }

    q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f1253a = list;
        this.f1254b = pool;
    }

    public final n.a<Data> a(@NonNull Model model, int i, int i2, @NonNull j jVar) {
        n.a a2;
        int size = this.f1253a.size();
        ArrayList arrayList = new ArrayList(size);
        g gVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = this.f1253a.get(i3);
            if (nVar.a(model) && (a2 = nVar.a(model, i, i2, jVar)) != null) {
                gVar = a2.f1246a;
                arrayList.add(a2.f1248c);
            }
        }
        if (arrayList.isEmpty() || gVar == null) {
            return null;
        }
        return new n.a<>(gVar, new a(arrayList, this.f1254b));
    }

    public final boolean a(@NonNull Model model) {
        for (n<Model, Data> a2 : this.f1253a) {
            if (a2.a(model)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f1253a.toArray()) + '}';
    }
}

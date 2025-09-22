package com.bumptech.glide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools;
import com.bumptech.glide.e.f;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.b.h;
import com.bumptech.glide.load.b.s;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.p;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1393a = "Gif";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1394b = "Bitmap";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1395c = "BitmapDrawable";
    private static final String g = "legacy_prepend_all";
    private static final String h = "legacy_append";
    public final com.bumptech.glide.e.a d = new com.bumptech.glide.e.a();
    public final f e = new f();
    public final com.bumptech.glide.load.a.f f = new com.bumptech.glide.load.a.f();
    private final p i = new p(this.o);
    private final com.bumptech.glide.e.e j = new com.bumptech.glide.e.e();
    private final com.bumptech.glide.load.d.f.f k = new com.bumptech.glide.load.d.f.f();
    private final com.bumptech.glide.e.b l = new com.bumptech.glide.e.b();
    private final com.bumptech.glide.e.d m = new com.bumptech.glide.e.d();
    private final com.bumptech.glide.e.c n = new com.bumptech.glide.e.c();
    private final Pools.Pool<List<Throwable>> o = com.bumptech.glide.util.a.a.a();

    public static class a extends RuntimeException {
        public a(@NonNull String str) {
            super(str);
        }
    }

    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    public static class c extends a {
        public c(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        public c(@NonNull Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }
    }

    public static class d extends a {
        public d(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class e extends a {
        public e(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public m() {
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{f1393a, f1394b, f1395c}));
        arrayList.add(0, g);
        arrayList.add(h);
        this.j.a((List<String>) arrayList);
    }

    @NonNull
    private m a(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, g);
        arrayList.add(h);
        this.j.a((List<String>) arrayList);
        return this;
    }

    private boolean a(@NonNull u<?> uVar) {
        return this.e.a(uVar.a()) != null;
    }

    @NonNull
    private <X> com.bumptech.glide.load.d<X> b(@NonNull X x) throws e {
        com.bumptech.glide.load.d<X> a2 = this.d.a(x.getClass());
        if (a2 != null) {
            return a2;
        }
        throw new e(x.getClass());
    }

    @NonNull
    private <X> l<X> b(@NonNull u<X> uVar) throws d {
        l<X> a2 = this.e.a(uVar.a());
        if (a2 != null) {
            return a2;
        }
        throw new d(uVar.a());
    }

    @Deprecated
    @NonNull
    private <Data> m b(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.d<Data> dVar) {
        return a(cls, dVar);
    }

    @Deprecated
    @NonNull
    private <TResource> m b(@NonNull Class<TResource> cls, @NonNull l<TResource> lVar) {
        return a(cls, lVar);
    }

    @NonNull
    private <Model, Data> m b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.i.b(cls, cls2, oVar);
        return this;
    }

    @NonNull
    private <Data, TResource> m b(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull k<Data, TResource> kVar) {
        this.j.b(g, kVar, cls, cls2);
        return this;
    }

    @NonNull
    private <Data, TResource> m b(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull k<Data, TResource> kVar) {
        this.j.b(str, kVar, cls, cls2);
        return this;
    }

    @NonNull
    private <X> com.bumptech.glide.load.a.e<X> c(@NonNull X x) {
        return this.f.a(x);
    }

    @NonNull
    private <Data> m c(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.d<Data> dVar) {
        this.d.b(cls, dVar);
        return this;
    }

    @NonNull
    private <TResource> m c(@NonNull Class<TResource> cls, @NonNull l<TResource> lVar) {
        this.e.b(cls, lVar);
        return this;
    }

    @NonNull
    private <Model, Data> m c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.i.c(cls, cls2, oVar);
        return this;
    }

    @NonNull
    private <Data, TResource, Transcode> List<h<Data, TResource, Transcode>> c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class next : this.j.b(cls, cls2)) {
            for (Class next2 : this.k.b(next, cls3)) {
                arrayList.add(new h(cls, next, next2, this.j.a(cls, next), this.k.a(next, next2), this.o));
            }
        }
        return arrayList;
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public final <Data, TResource, Transcode> s<Data, TResource, Transcode> a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        Class<Data> cls4 = cls;
        Class<TResource> cls5 = cls2;
        Class<Transcode> cls6 = cls3;
        s<Data, TResource, Transcode> a2 = this.n.a(cls4, cls5, cls6);
        if (com.bumptech.glide.e.c.a(a2)) {
            return null;
        }
        if (a2 != null) {
            return a2;
        }
        ArrayList arrayList = new ArrayList();
        for (Class next : this.j.b(cls4, cls5)) {
            for (Iterator<Class<R>> it = this.k.b(next, cls6).iterator(); it.hasNext(); it = it) {
                Class next2 = it.next();
                h hVar = r2;
                h hVar2 = new h(cls4, next, next2, this.j.a(cls4, next), this.k.a(next, next2), this.o);
                arrayList.add(hVar);
            }
        }
        s<Data, TResource, Transcode> sVar = arrayList.isEmpty() ? null : new s<>(cls4, cls5, cls6, arrayList, this.o);
        com.bumptech.glide.e.c cVar = this.n;
        synchronized (cVar.f936b) {
            try {
                cVar.f936b.put(new com.bumptech.glide.util.h(cls4, cls5, cls6), sVar != null ? sVar : com.bumptech.glide.e.c.f935a);
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    @NonNull
    public final m a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.l.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public final m a(@NonNull e.a<?> aVar) {
        this.f.a(aVar);
        return this;
    }

    @NonNull
    public final <Data> m a(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.d<Data> dVar) {
        this.d.a(cls, dVar);
        return this;
    }

    @NonNull
    public final <TResource> m a(@NonNull Class<TResource> cls, @NonNull l<TResource> lVar) {
        this.e.a(cls, lVar);
        return this;
    }

    @NonNull
    public final <Model, Data> m a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.i.a(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public final <TResource, Transcode> m a(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull com.bumptech.glide.load.d.f.e<TResource, Transcode> eVar) {
        this.k.a(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public final <Data, TResource> m a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull k<Data, TResource> kVar) {
        a(h, cls, cls2, kVar);
        return this;
    }

    @NonNull
    public final <Data, TResource> m a(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull k<Data, TResource> kVar) {
        this.j.a(str, kVar, cls, cls2);
        return this;
    }

    @NonNull
    public final List<ImageHeaderParser> a() {
        List<ImageHeaderParser> a2 = this.l.a();
        if (!a2.isEmpty()) {
            return a2;
        }
        throw new b();
    }

    @NonNull
    public final <Model> List<n<Model, ?>> a(@NonNull Model model) {
        List<n<A, ?>> b2 = this.i.b(model.getClass());
        int size = b2.size();
        List<n<Model, ?>> emptyList = Collections.emptyList();
        boolean z = true;
        for (int i2 = 0; i2 < size; i2++) {
            n nVar = b2.get(i2);
            if (nVar.a(model)) {
                if (z) {
                    emptyList = new ArrayList<>(size - i2);
                    z = false;
                }
                emptyList.add(nVar);
            }
        }
        if (!emptyList.isEmpty()) {
            return emptyList;
        }
        throw new c(model);
    }

    @NonNull
    public final <Model, TResource, Transcode> List<Class<?>> b(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> a2 = this.m.a(cls, cls2);
        if (a2 != null) {
            return a2;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<?> b2 : this.i.a((Class<?>) cls)) {
            for (Class next : this.j.b(b2, cls2)) {
                if (!this.k.b(next, cls3).isEmpty() && !arrayList.contains(next)) {
                    arrayList.add(next);
                }
            }
        }
        com.bumptech.glide.e.d dVar = this.m;
        List unmodifiableList = Collections.unmodifiableList(arrayList);
        synchronized (dVar.f938a) {
            dVar.f938a.put(new com.bumptech.glide.util.h(cls, cls2), unmodifiableList);
        }
        return arrayList;
    }
}

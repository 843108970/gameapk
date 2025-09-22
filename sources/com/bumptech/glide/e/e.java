package com.bumptech.glide.e;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f940a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f941b = new HashMap();

    private static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final Class<R> f942a;

        /* renamed from: b  reason: collision with root package name */
        final k<T, R> f943b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<T> f944c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, k<T, R> kVar) {
            this.f944c = cls;
            this.f942a = cls2;
            this.f943b = kVar;
        }

        public final boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f944c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f942a);
        }
    }

    @NonNull
    private synchronized List<a<?, ?>> a(@NonNull String str) {
        List<a<?, ?>> list;
        if (!this.f940a.contains(str)) {
            this.f940a.add(str);
        }
        list = this.f941b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f941b.put(str, list);
        }
        return list;
    }

    @NonNull
    public final synchronized <T, R> List<k<T, R>> a(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f940a) {
            List<a> list = this.f941b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f943b);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized <T, R> void a(@NonNull String str, @NonNull k<T, R> kVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        a(str).add(new a(cls, cls2, kVar));
    }

    public final synchronized void a(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.f940a);
        this.f940a.clear();
        this.f940a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f940a.add(str);
            }
        }
    }

    @NonNull
    public final synchronized <T, R> List<Class<R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f940a) {
            List<a> list = this.f941b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f942a)) {
                        arrayList.add(aVar.f942a);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized <T, R> void b(@NonNull String str, @NonNull k<T, R> kVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        a(str).add(0, new a(cls, cls2, kVar));
    }
}

package com.bumptech.glide.load.a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.util.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class f {

    /* renamed from: b  reason: collision with root package name */
    private static final e.a<?> f989b = new e.a<Object>() {
        @NonNull
        public final e<Object> a(@NonNull Object obj) {
            return new a(obj);
        }

        @NonNull
        public final Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f990a = new HashMap();

    private static final class a implements e<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f991a;

        a(@NonNull Object obj) {
            this.f991a = obj;
        }

        @NonNull
        public final Object a() {
            return this.f991a;
        }

        public final void b() {
        }
    }

    @NonNull
    public final synchronized <T> e<T> a(@NonNull T t) {
        e.a<?> aVar;
        i.a(t, "Argument must not be null");
        aVar = this.f990a.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f990a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f989b;
        }
        return aVar.a(t);
    }

    public final synchronized void a(@NonNull e.a<?> aVar) {
        this.f990a.put(aVar.a(), aVar);
    }
}

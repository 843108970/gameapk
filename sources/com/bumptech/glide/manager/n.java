package com.bumptech.glide.manager;

import android.support.annotation.NonNull;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.k;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class n implements i {

    /* renamed from: a  reason: collision with root package name */
    public final Set<Target<?>> f1419a = Collections.newSetFromMap(new WeakHashMap());

    @NonNull
    private List<Target<?>> a() {
        return k.a(this.f1419a);
    }

    private void a(@NonNull Target<?> target) {
        this.f1419a.add(target);
    }

    private void b() {
        this.f1419a.clear();
    }

    private void b(@NonNull Target<?> target) {
        this.f1419a.remove(target);
    }

    public final void onDestroy() {
        for (T onDestroy : k.a(this.f1419a)) {
            onDestroy.onDestroy();
        }
    }

    public final void onStart() {
        for (T onStart : k.a(this.f1419a)) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        for (T onStop : k.a(this.f1419a)) {
            onStop.onStop();
        }
    }
}

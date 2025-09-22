package com.bumptech.glide.manager;

import android.support.annotation.NonNull;
import com.bumptech.glide.util.k;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

final class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i> f1404a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f1405b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1406c;

    a() {
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f1405b = true;
        for (T onStart : k.a(this.f1404a)) {
            onStart.onStart();
        }
    }

    public final void a(@NonNull i iVar) {
        this.f1404a.add(iVar);
        if (this.f1406c) {
            iVar.onDestroy();
        } else if (this.f1405b) {
            iVar.onStart();
        } else {
            iVar.onStop();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f1405b = false;
        for (T onStop : k.a(this.f1404a)) {
            onStop.onStop();
        }
    }

    public final void b(@NonNull i iVar) {
        this.f1404a.remove(iVar);
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f1406c = true;
        for (T onDestroy : k.a(this.f1404a)) {
            onDestroy.onDestroy();
        }
    }
}

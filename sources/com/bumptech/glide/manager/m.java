package com.bumptech.glide.manager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.request.c;
import com.bumptech.glide.util.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class m {
    private static final String d = "RequestTracker";

    /* renamed from: a  reason: collision with root package name */
    public final Set<c> f1416a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    public final List<c> f1417b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f1418c;

    private void a(@NonNull c cVar) {
        this.f1416a.add(cVar);
        if (!this.f1418c) {
            cVar.a();
            return;
        }
        cVar.b();
        if (Log.isLoggable(d, 2)) {
            Log.v(d, "Paused, delaying request");
        }
        this.f1417b.add(cVar);
    }

    private boolean a() {
        return this.f1418c;
    }

    private void b() {
        this.f1418c = true;
        for (T t : k.a(this.f1416a)) {
            if (t.c()) {
                t.b();
                this.f1417b.add(t);
            }
        }
    }

    @VisibleForTesting
    private void b(c cVar) {
        this.f1416a.add(cVar);
    }

    private void c() {
        this.f1418c = true;
        for (T t : k.a(this.f1416a)) {
            if (t.c() || t.d()) {
                t.b();
                this.f1417b.add(t);
            }
        }
    }

    private boolean c(@Nullable c cVar) {
        return a(cVar, true);
    }

    private void d() {
        this.f1418c = false;
        for (T t : k.a(this.f1416a)) {
            if (!t.d() && !t.c()) {
                t.a();
            }
        }
        this.f1417b.clear();
    }

    private void e() {
        for (T a2 : k.a(this.f1416a)) {
            a(a2, false);
        }
        this.f1417b.clear();
    }

    private void f() {
        for (T t : k.a(this.f1416a)) {
            if (!t.d() && !t.f()) {
                t.b();
                if (!this.f1418c) {
                    t.a();
                } else {
                    this.f1417b.add(t);
                }
            }
        }
    }

    public final boolean a(@Nullable c cVar, boolean z) {
        boolean z2 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = this.f1416a.remove(cVar);
        if (!this.f1417b.remove(cVar) && !remove) {
            z2 = false;
        }
        if (z2) {
            cVar.b();
            if (z) {
                cVar.h();
            }
        }
        return z2;
    }

    public final String toString() {
        return super.toString() + "{numRequests=" + this.f1416a.size() + ", isPaused=" + this.f1418c + "}";
    }
}

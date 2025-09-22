package org.greenrobot.eventbus.util;

import android.content.res.Resources;
import android.util.Log;
import org.greenrobot.eventbus.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final Resources f4356a;

    /* renamed from: b  reason: collision with root package name */
    final int f4357b;

    /* renamed from: c  reason: collision with root package name */
    final int f4358c;
    final d d;
    c e;
    boolean f = true;
    String g;
    int h;
    Class<?> i;

    private b(Resources resources, int i2, int i3) {
        this.f4356a = resources;
        this.f4357b = i2;
        this.f4358c = i3;
        this.d = new d();
    }

    private int a(Throwable th) {
        Integer a2 = this.d.a(th);
        if (a2 != null) {
            return a2.intValue();
        }
        String str = c.f4301a;
        Log.d(str, "No specific message ressource ID found for " + th);
        return this.f4358c;
    }

    private b a(Class<? extends Throwable> cls, int i2) {
        this.d.f4360a.put(cls, Integer.valueOf(i2));
        return this;
    }

    private void a(int i2) {
        this.h = i2;
    }

    private void a(Class<?> cls) {
        this.i = cls;
    }

    private void a(String str) {
        this.g = str;
    }

    private void a(c cVar) {
        this.e = cVar;
    }

    private void b() {
        this.f = false;
    }

    /* access modifiers changed from: package-private */
    public final c a() {
        return this.e != null ? this.e : c.a();
    }
}

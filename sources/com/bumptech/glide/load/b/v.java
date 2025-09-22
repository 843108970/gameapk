package com.bumptech.glide.load.b;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.e;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.g;
import java.io.File;
import java.util.List;

final class v implements d.a<Object>, e {

    /* renamed from: a  reason: collision with root package name */
    private final e.a f1178a;

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f1179b;

    /* renamed from: c  reason: collision with root package name */
    private int f1180c;
    private int d = -1;
    private g e;
    private List<n<File, ?>> f;
    private int g;
    private volatile n.a<?> h;
    private File i;
    private w j;

    v(f<?> fVar, e.a aVar) {
        this.f1179b = fVar;
        this.f1178a = aVar;
    }

    private boolean c() {
        return this.g < this.f.size();
    }

    public final void a(@NonNull Exception exc) {
        this.f1178a.a(this.j, exc, this.h.f1248c, a.RESOURCE_DISK_CACHE);
    }

    public final void a(Object obj) {
        this.f1178a.a(this.e, obj, this.h.f1248c, a.RESOURCE_DISK_CACHE, this.j);
    }

    public final boolean a() {
        List<g> c2 = this.f1179b.c();
        boolean z = false;
        if (c2.isEmpty()) {
            return false;
        }
        f<?> fVar = this.f1179b;
        List<Class<?>> b2 = fVar.f1124c.d.b(fVar.d.getClass(), fVar.g, fVar.k);
        if (b2.isEmpty() && File.class.equals(this.f1179b.k)) {
            return false;
        }
        while (true) {
            if (this.f == null || !c()) {
                this.d++;
                if (this.d >= b2.size()) {
                    this.f1180c++;
                    if (this.f1180c >= c2.size()) {
                        return false;
                    }
                    this.d = 0;
                }
                g gVar = c2.get(this.f1180c);
                Class cls = b2.get(this.d);
                this.j = new w(this.f1179b.f1124c.f961c, gVar, this.f1179b.n, this.f1179b.e, this.f1179b.f, this.f1179b.c(cls), cls, this.f1179b.i);
                this.i = this.f1179b.a().a(this.j);
                if (this.i != null) {
                    this.e = gVar;
                    this.f = this.f1179b.a(this.i);
                    this.g = 0;
                }
            } else {
                this.h = null;
                while (!z && c()) {
                    List<n<File, ?>> list = this.f;
                    int i2 = this.g;
                    this.g = i2 + 1;
                    this.h = list.get(i2).a(this.i, this.f1179b.e, this.f1179b.f, this.f1179b.i);
                    if (this.h != null && this.f1179b.a((Class<?>) this.h.f1248c.a())) {
                        this.h.f1248c.a(this.f1179b.o, this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    public final void b() {
        n.a<?> aVar = this.h;
        if (aVar != null) {
            aVar.f1248c.c();
        }
    }
}

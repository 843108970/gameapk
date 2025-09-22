package com.bumptech.glide.load.b;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.e;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.g;
import java.io.File;
import java.util.List;

final class b implements d.a<Object>, e {

    /* renamed from: a  reason: collision with root package name */
    private final List<g> f1051a;

    /* renamed from: b  reason: collision with root package name */
    private final f<?> f1052b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a f1053c;
    private int d;
    private g e;
    private List<n<File, ?>> f;
    private int g;
    private volatile n.a<?> h;
    private File i;

    b(f<?> fVar, e.a aVar) {
        this(fVar.c(), fVar, aVar);
    }

    b(List<g> list, f<?> fVar, e.a aVar) {
        this.d = -1;
        this.f1051a = list;
        this.f1052b = fVar;
        this.f1053c = aVar;
    }

    private boolean c() {
        return this.g < this.f.size();
    }

    public final void a(@NonNull Exception exc) {
        this.f1053c.a(this.e, exc, this.h.f1248c, a.DATA_DISK_CACHE);
    }

    public final void a(Object obj) {
        this.f1053c.a(this.e, obj, this.h.f1248c, a.DATA_DISK_CACHE, this.e);
    }

    public final boolean a() {
        while (true) {
            boolean z = false;
            if (this.f == null || !c()) {
                this.d++;
                if (this.d >= this.f1051a.size()) {
                    return false;
                }
                g gVar = this.f1051a.get(this.d);
                this.i = this.f1052b.a().a(new c(gVar, this.f1052b.n));
                if (this.i != null) {
                    this.e = gVar;
                    this.f = this.f1052b.a(this.i);
                    this.g = 0;
                }
            } else {
                this.h = null;
                while (!z && c()) {
                    List<n<File, ?>> list = this.f;
                    int i2 = this.g;
                    this.g = i2 + 1;
                    this.h = list.get(i2).a(this.i, this.f1052b.e, this.f1052b.f, this.f1052b.i);
                    if (this.h != null && this.f1052b.a((Class<?>) this.h.f1248c.a())) {
                        this.h.f1248c.a(this.f1052b.o, this);
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

package com.bumptech.glide.load.d.e;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.q;
import com.bumptech.glide.load.d.c.b;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.k;

public final class e extends b<c> implements q {
    public e(c cVar) {
        super(cVar);
    }

    @NonNull
    public final Class<c> a() {
        return c.class;
    }

    public final int c() {
        g gVar = ((c) this.f1343a).f1355c.f1356a;
        return gVar.f1359a.m() + k.a(gVar.b().getWidth(), gVar.b().getHeight(), gVar.b().getConfig());
    }

    public final void d() {
        ((c) this.f1343a).stop();
        c cVar = (c) this.f1343a;
        cVar.d = true;
        g gVar = cVar.f1355c.f1356a;
        gVar.f1360b.clear();
        gVar.d();
        gVar.d = false;
        if (gVar.f != null) {
            gVar.f1361c.a((Target<?>) gVar.f);
            gVar.f = null;
        }
        if (gVar.h != null) {
            gVar.f1361c.a((Target<?>) gVar.h);
            gVar.h = null;
        }
        if (gVar.k != null) {
            gVar.f1361c.a((Target<?>) gVar.k);
            gVar.k = null;
        }
        gVar.f1359a.o();
        gVar.g = true;
    }

    public final void e() {
        ((c) this.f1343a).a().prepareToDraw();
    }
}

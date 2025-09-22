package com.bumptech.glide.load.d.e;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.c.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.d.a.f;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import java.io.IOException;

public final class h implements k<b, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final e f1368a;

    public h(e eVar) {
        this.f1368a = eVar;
    }

    private u<Bitmap> a(@NonNull b bVar) {
        return f.a(bVar.n(), this.f1368a);
    }

    private static boolean a() {
        return true;
    }

    public final /* synthetic */ u a(@NonNull Object obj, int i, int i2, @NonNull j jVar) throws IOException {
        return f.a(((b) obj).n(), this.f1368a);
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj, @NonNull j jVar) throws IOException {
        return true;
    }
}

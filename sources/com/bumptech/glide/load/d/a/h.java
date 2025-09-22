package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.p;
import com.bumptech.glide.request.a.b;
import com.bumptech.glide.request.a.c;
import com.bumptech.glide.request.a.g;

public final class h extends p<h, Bitmap> {
    @NonNull
    private static h a(int i) {
        return new h().b(new c.a(i));
    }

    @NonNull
    private static h a(@NonNull c.a aVar) {
        return new h().b(aVar);
    }

    @NonNull
    private static h a(@NonNull c cVar) {
        return new h().d(cVar);
    }

    @NonNull
    private static h b() {
        return new h().b(new c.a());
    }

    @NonNull
    private h b(int i) {
        return b(new c.a(i));
    }

    @NonNull
    private h b(@NonNull c.a aVar) {
        return d(aVar.a());
    }

    @NonNull
    private h b(@NonNull c cVar) {
        return d(cVar);
    }

    @NonNull
    private static h b(@NonNull g<Drawable> gVar) {
        return new h().d(gVar);
    }

    @NonNull
    private h c() {
        return b(new c.a());
    }

    @NonNull
    private static h c(@NonNull g<Bitmap> gVar) {
        return (h) new h().a(gVar);
    }

    @NonNull
    private h d(@NonNull g<Drawable> gVar) {
        return (h) a(new b(gVar));
    }
}

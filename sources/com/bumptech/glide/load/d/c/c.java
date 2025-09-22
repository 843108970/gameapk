package com.bumptech.glide.load.d.c;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.p;
import com.bumptech.glide.request.a.c;
import com.bumptech.glide.request.a.g;

public final class c extends p<c, Drawable> {
    @NonNull
    private static c a(int i) {
        return new c().b(new c.a(i));
    }

    @NonNull
    private static c a(@NonNull c.a aVar) {
        return new c().b(aVar);
    }

    @NonNull
    private static c a(@NonNull com.bumptech.glide.request.a.c cVar) {
        return new c().b(cVar);
    }

    @NonNull
    private static c b() {
        return new c().b(new c.a());
    }

    @NonNull
    private c b(int i) {
        return b(new c.a(i));
    }

    @NonNull
    private c b(@NonNull c.a aVar) {
        return b(aVar.a());
    }

    @NonNull
    private c b(@NonNull com.bumptech.glide.request.a.c cVar) {
        return (c) a(cVar);
    }

    @NonNull
    private static c b(@NonNull g<Drawable> gVar) {
        return (c) new c().a(gVar);
    }

    @NonNull
    private c c() {
        return b(new c.a());
    }
}

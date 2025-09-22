package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.a.a.b;
import com.bumptech.glide.load.a.a.c;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.j;
import java.io.InputStream;

public final class d implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1200a;

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1201a;

        public a(Context context) {
            this.f1201a = context;
        }

        @NonNull
        public final n<Uri, InputStream> a(r rVar) {
            return new d(this.f1201a);
        }

        public final void a() {
        }
    }

    public d(Context context) {
        this.f1200a = context.getApplicationContext();
    }

    private n.a<InputStream> a(@NonNull Uri uri, int i, int i2) {
        if (!b.a(i, i2)) {
            return null;
        }
        com.bumptech.glide.f.d dVar = new com.bumptech.glide.f.d(uri);
        Context context = this.f1200a;
        return new n.a<>(dVar, c.a(context, uri, new c.a(context.getContentResolver())));
    }

    private static boolean a(@NonNull Uri uri) {
        return b.a(uri) && !b.b(uri);
    }

    public final /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        Uri uri = (Uri) obj;
        if (!b.a(i, i2)) {
            return null;
        }
        com.bumptech.glide.f.d dVar = new com.bumptech.glide.f.d(uri);
        Context context = this.f1200a;
        return new n.a(dVar, c.a(context, uri, new c.a(context.getContentResolver())));
    }

    public final /* synthetic */ boolean a(@NonNull Object obj) {
        Uri uri = (Uri) obj;
        return b.a(uri) && !b.b(uri);
    }
}

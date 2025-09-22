package com.bumptech.glide.load.c.a;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.f.d;
import com.bumptech.glide.load.a.a.b;
import com.bumptech.glide.load.a.a.c;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.c.r;
import com.bumptech.glide.load.d.a.ac;
import com.bumptech.glide.load.j;
import java.io.InputStream;

public final class e implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1202a;

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1203a;

        public a(Context context) {
            this.f1203a = context;
        }

        @NonNull
        public final n<Uri, InputStream> a(r rVar) {
            return new e(this.f1203a);
        }

        public final void a() {
        }
    }

    public e(Context context) {
        this.f1202a = context.getApplicationContext();
    }

    @Nullable
    private n.a<InputStream> a(@NonNull Uri uri, int i, int i2, @NonNull j jVar) {
        if (!b.a(i, i2)) {
            return null;
        }
        Long l = (Long) jVar.a(ac.f1290c);
        if (!(l != null && l.longValue() == -1)) {
            return null;
        }
        d dVar = new d(uri);
        Context context = this.f1202a;
        return new n.a<>(dVar, c.a(context, uri, new c.b(context.getContentResolver())));
    }

    private static boolean a(@NonNull Uri uri) {
        return b.a(uri) && b.b(uri);
    }

    private static boolean a(j jVar) {
        Long l = (Long) jVar.a(ac.f1290c);
        return l != null && l.longValue() == -1;
    }

    @Nullable
    public final /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        Uri uri = (Uri) obj;
        if (!b.a(i, i2)) {
            return null;
        }
        Long l = (Long) jVar.a(ac.f1290c);
        if (!(l != null && l.longValue() == -1)) {
            return null;
        }
        d dVar = new d(uri);
        Context context = this.f1202a;
        return new n.a(dVar, c.a(context, uri, new c.b(context.getContentResolver())));
    }

    public final /* synthetic */ boolean a(@NonNull Object obj) {
        Uri uri = (Uri) obj;
        return b.a(uri) && b.b(uri);
    }
}

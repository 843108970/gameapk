package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.d.c.e;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import java.io.IOException;

public final class w implements k<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final e f1329a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.e f1330b;

    public w(e eVar, com.bumptech.glide.load.b.a.e eVar2) {
        this.f1329a = eVar;
        this.f1330b = eVar2;
    }

    @Nullable
    private u<Bitmap> a(@NonNull Uri uri, int i, int i2) {
        u<Drawable> a2 = this.f1329a.a(uri);
        if (a2 == null) {
            return null;
        }
        return p.a(this.f1330b, a2.b(), i, i2);
    }

    private static boolean a(@NonNull Uri uri) {
        return "android.resource".equals(uri.getScheme());
    }

    @Nullable
    public final /* synthetic */ u a(@NonNull Object obj, int i, int i2, @NonNull j jVar) throws IOException {
        u<Drawable> a2 = this.f1329a.a((Uri) obj);
        if (a2 == null) {
            return null;
        }
        return p.a(this.f1330b, a2.b(), i, i2);
    }

    public final /* synthetic */ boolean a(@NonNull Object obj, @NonNull j jVar) throws IOException {
        return "android.resource".equals(((Uri) obj).getScheme());
    }
}

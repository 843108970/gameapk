package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import java.io.IOException;

public final class aa implements k<Bitmap, Bitmap> {

    private static final class a implements u<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final Bitmap f1287a;

        a(@NonNull Bitmap bitmap) {
            this.f1287a = bitmap;
        }

        @NonNull
        private Bitmap e() {
            return this.f1287a;
        }

        @NonNull
        public final Class<Bitmap> a() {
            return Bitmap.class;
        }

        @NonNull
        public final /* bridge */ /* synthetic */ Object b() {
            return this.f1287a;
        }

        public final int c() {
            return com.bumptech.glide.util.k.a(this.f1287a);
        }

        public final void d() {
        }
    }

    private static u<Bitmap> a(@NonNull Bitmap bitmap) {
        return new a(bitmap);
    }

    private static boolean a() {
        return true;
    }

    public final /* synthetic */ u a(@NonNull Object obj, int i, int i2, @NonNull j jVar) throws IOException {
        return new a((Bitmap) obj);
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj, @NonNull j jVar) throws IOException {
        return true;
    }
}

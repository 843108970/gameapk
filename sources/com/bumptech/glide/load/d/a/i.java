package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import com.bumptech.glide.util.a;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class i implements k<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final o f1302a;

    public i(o oVar) {
        this.f1302a = oVar;
    }

    private u<Bitmap> a(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull j jVar) throws IOException {
        return this.f1302a.a(a.b(byteBuffer), i, i2, jVar, o.f);
    }

    private static boolean a() {
        return o.b();
    }

    public final /* synthetic */ u a(@NonNull Object obj, int i, int i2, @NonNull j jVar) throws IOException {
        return this.f1302a.a(a.b((ByteBuffer) obj), i, i2, jVar, o.f);
    }

    public final /* synthetic */ boolean a(@NonNull Object obj, @NonNull j jVar) throws IOException {
        return o.b();
    }
}

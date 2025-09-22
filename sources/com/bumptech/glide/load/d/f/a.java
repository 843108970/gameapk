package com.bumptech.glide.load.d.f;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.d.b.b;
import com.bumptech.glide.load.j;
import java.io.ByteArrayOutputStream;

public final class a implements e<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap.CompressFormat f1374a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1375b;

    public a() {
        this(Bitmap.CompressFormat.JPEG);
    }

    private a(@NonNull Bitmap.CompressFormat compressFormat) {
        this.f1374a = compressFormat;
        this.f1375b = 100;
    }

    @Nullable
    public final u<byte[]> a(@NonNull u<Bitmap> uVar, @NonNull j jVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        uVar.b().compress(this.f1374a, this.f1375b, byteArrayOutputStream);
        uVar.d();
        return new b(byteArrayOutputStream.toByteArray());
    }
}

package com.bumptech.glide.load.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import com.bumptech.glide.util.i;
import java.io.IOException;

public final class a<DataType> implements k<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final k<DataType, Bitmap> f1285a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f1286b;

    private a(Context context, k<DataType, Bitmap> kVar) {
        this(context.getResources(), kVar, (byte) 0);
    }

    @Deprecated
    private a(Resources resources, k<DataType, Bitmap> kVar) {
        this(resources, kVar, (byte) 0);
    }

    public a(@NonNull Resources resources, @NonNull k<DataType, Bitmap> kVar, byte b2) {
        this.f1286b = (Resources) i.a(resources, "Argument must not be null");
        this.f1285a = (k) i.a(kVar, "Argument must not be null");
    }

    public final u<BitmapDrawable> a(@NonNull DataType datatype, int i, int i2, @NonNull j jVar) throws IOException {
        return u.a(this.f1286b, this.f1285a.a(datatype, i, i2, jVar));
    }

    public final boolean a(@NonNull DataType datatype, @NonNull j jVar) throws IOException {
        return this.f1285a.a(datatype, jVar);
    }
}

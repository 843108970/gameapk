package com.bumptech.glide.load.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.f;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.m;
import com.bumptech.glide.util.k;

public abstract class g implements m<Bitmap> {
    /* access modifiers changed from: protected */
    public abstract Bitmap a(@NonNull e eVar, @NonNull Bitmap bitmap, int i, int i2);

    @NonNull
    public final u<Bitmap> a(@NonNull Context context, @NonNull u<Bitmap> uVar, int i, int i2) {
        if (!k.a(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        e eVar = f.b(context).f948a;
        Bitmap b2 = uVar.b();
        if (i == Integer.MIN_VALUE) {
            i = b2.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = b2.getHeight();
        }
        Bitmap a2 = a(eVar, b2, i, i2);
        return b2.equals(a2) ? uVar : f.a(a2, eVar);
    }
}

package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.a.e;
import java.security.MessageDigest;

public final class k extends g {

    /* renamed from: c  reason: collision with root package name */
    private static final String f1304c = "com.bumptech.glide.load.resource.bitmap.CenterInside";
    private static final byte[] d = f1304c.getBytes(f1387b);

    /* access modifiers changed from: protected */
    public final Bitmap a(@NonNull e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        return z.c(eVar, bitmap, i, i2);
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(d);
    }

    public final boolean equals(Object obj) {
        return obj instanceof k;
    }

    public final int hashCode() {
        return f1304c.hashCode();
    }
}

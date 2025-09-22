package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.a.e;
import java.security.MessageDigest;

public final class l extends g {

    /* renamed from: c  reason: collision with root package name */
    private static final int f1305c = 1;
    private static final String d = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";
    private static final byte[] e = d.getBytes(f1387b);

    /* access modifiers changed from: protected */
    public final Bitmap a(@NonNull e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        return z.d(eVar, bitmap, i, i2);
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(e);
    }

    public final boolean equals(Object obj) {
        return obj instanceof l;
    }

    public final int hashCode() {
        return d.hashCode();
    }
}

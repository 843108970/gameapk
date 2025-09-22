package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.util.i;
import com.bumptech.glide.util.k;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class x extends g {

    /* renamed from: c  reason: collision with root package name */
    private static final String f1331c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";
    private static final byte[] d = f1331c.getBytes(f1387b);
    private final int e;

    private x(int i) {
        i.a(i > 0, "roundingRadius must be greater than 0.");
        this.e = i;
    }

    /* access modifiers changed from: protected */
    public final Bitmap a(@NonNull e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        return z.b(eVar, bitmap, this.e);
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(d);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.e).array());
    }

    public final boolean equals(Object obj) {
        return (obj instanceof x) && this.e == ((x) obj).e;
    }

    public final int hashCode() {
        return k.b(f1331c.hashCode(), k.b(this.e));
    }
}

package com.bumptech.glide.load.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.m;
import com.bumptech.glide.util.i;
import java.security.MessageDigest;

@Deprecated
public final class d implements m<BitmapDrawable> {

    /* renamed from: c  reason: collision with root package name */
    private final m<Drawable> f1296c;

    private d(m<Bitmap> mVar) {
        this.f1296c = (m) i.a(new q(mVar, false), "Argument must not be null");
    }

    private static u<BitmapDrawable> a(u<Drawable> uVar) {
        if (uVar.b() instanceof BitmapDrawable) {
            return uVar;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + uVar.b());
    }

    private static u<Drawable> b(u<BitmapDrawable> uVar) {
        return uVar;
    }

    @NonNull
    public final u<BitmapDrawable> a(@NonNull Context context, @NonNull u<BitmapDrawable> uVar, int i, int i2) {
        u<T> a2 = this.f1296c.a(context, uVar, i, i2);
        if (a2.b() instanceof BitmapDrawable) {
            return a2;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + a2.b());
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        this.f1296c.a(messageDigest);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f1296c.equals(((d) obj).f1296c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1296c.hashCode();
    }
}

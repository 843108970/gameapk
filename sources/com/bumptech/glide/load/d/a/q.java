package com.bumptech.glide.load.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.f;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.m;
import java.security.MessageDigest;

public final class q implements m<Drawable> {

    /* renamed from: c  reason: collision with root package name */
    private final m<Bitmap> f1319c;
    private final boolean d;

    public q(m<Bitmap> mVar, boolean z) {
        this.f1319c = mVar;
        this.d = z;
    }

    private static u<Drawable> a(Context context, u<Bitmap> uVar) {
        return u.a(context.getResources(), uVar);
    }

    private m<BitmapDrawable> a() {
        return this;
    }

    @NonNull
    public final u<Drawable> a(@NonNull Context context, @NonNull u<Drawable> uVar, int i, int i2) {
        e eVar = f.b(context).f948a;
        Drawable b2 = uVar.b();
        u<Bitmap> a2 = p.a(eVar, b2, i, i2);
        if (a2 != null) {
            u<Bitmap> a3 = this.f1319c.a(context, a2, i, i2);
            if (!a3.equals(a2)) {
                return u.a(context.getResources(), a3);
            }
            a3.d();
            return uVar;
        } else if (!this.d) {
            return uVar;
        } else {
            throw new IllegalArgumentException("Unable to convert " + b2 + " to a Bitmap");
        }
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        this.f1319c.a(messageDigest);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof q) {
            return this.f1319c.equals(((q) obj).f1319c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1319c.hashCode();
    }
}

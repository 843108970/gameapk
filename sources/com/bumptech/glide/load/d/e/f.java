package com.bumptech.glide.load.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.m;
import java.security.MessageDigest;

public final class f implements m<c> {

    /* renamed from: c  reason: collision with root package name */
    private final m<Bitmap> f1358c;

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.m<android.graphics.Bitmap>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(com.bumptech.glide.load.m<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "Argument must not be null"
            java.lang.Object r2 = com.bumptech.glide.util.i.a(r2, (java.lang.String) r0)
            com.bumptech.glide.load.m r2 = (com.bumptech.glide.load.m) r2
            r1.f1358c = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.e.f.<init>(com.bumptech.glide.load.m):void");
    }

    @NonNull
    public final u<c> a(@NonNull Context context, @NonNull u<c> uVar, int i, int i2) {
        c b2 = uVar.b();
        com.bumptech.glide.load.d.a.f fVar = new com.bumptech.glide.load.d.a.f(b2.a(), com.bumptech.glide.f.b(context).f948a);
        u<Bitmap> a2 = this.f1358c.a(context, fVar, i, i2);
        if (!fVar.equals(a2)) {
            fVar.d();
        }
        m<Bitmap> mVar = this.f1358c;
        b2.f1355c.f1356a.a(mVar, a2.b());
        return uVar;
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        this.f1358c.a(messageDigest);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f1358c.equals(((f) obj).f1358c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1358c.hashCode();
    }
}

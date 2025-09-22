package com.bumptech.glide.load.b;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.m;
import com.bumptech.glide.util.f;
import com.bumptech.glide.util.k;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class w implements g {

    /* renamed from: c  reason: collision with root package name */
    private static final f<Class<?>, byte[]> f1181c = new f<>(50);
    private final b d;
    private final g e;
    private final g f;
    private final int g;
    private final int h;
    private final Class<?> i;
    private final j j;
    private final m<?> k;

    w(b bVar, g gVar, g gVar2, int i2, int i3, m<?> mVar, Class<?> cls, j jVar) {
        this.d = bVar;
        this.e = gVar;
        this.f = gVar2;
        this.g = i2;
        this.h = i3;
        this.k = mVar;
        this.i = cls;
        this.j = jVar;
    }

    private byte[] a() {
        byte[] b2 = f1181c.b(this.i);
        if (b2 != null) {
            return b2;
        }
        byte[] bytes = this.i.getName().getBytes(f1387b);
        f1181c.b(this.i, bytes);
        return bytes;
    }

    public final void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.d.a(byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.g).putInt(this.h).array();
        this.f.a(messageDigest);
        this.e.a(messageDigest);
        messageDigest.update(bArr);
        if (this.k != null) {
            this.k.a(messageDigest);
        }
        this.j.a(messageDigest);
        byte[] b2 = f1181c.b(this.i);
        if (b2 == null) {
            b2 = this.i.getName().getBytes(f1387b);
            f1181c.b(this.i, b2);
        }
        messageDigest.update(b2);
        this.d.b(bArr);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof w) {
            w wVar = (w) obj;
            return this.h == wVar.h && this.g == wVar.g && k.a((Object) this.k, (Object) wVar.k) && this.i.equals(wVar.i) && this.e.equals(wVar.e) && this.f.equals(wVar.f) && this.j.equals(wVar.j);
        }
    }

    public final int hashCode() {
        int hashCode = (((((this.e.hashCode() * 31) + this.f.hashCode()) * 31) + this.g) * 31) + this.h;
        if (this.k != null) {
            hashCode = (hashCode * 31) + this.k.hashCode();
        }
        return (((hashCode * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.e + ", signature=" + this.f + ", width=" + this.g + ", height=" + this.h + ", decodedResourceClass=" + this.i + ", transformation='" + this.k + '\'' + ", options=" + this.j + '}';
    }
}

package com.bumptech.glide.load.d.b;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.util.i;

public final class b implements u<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f1341a;

    public b(byte[] bArr) {
        this.f1341a = (byte[]) i.a(bArr, "Argument must not be null");
    }

    @NonNull
    private byte[] e() {
        return this.f1341a;
    }

    @NonNull
    public final Class<byte[]> a() {
        return byte[].class;
    }

    @NonNull
    public final /* bridge */ /* synthetic */ Object b() {
        return this.f1341a;
    }

    public final int c() {
        return this.f1341a.length;
    }

    public final void d() {
    }
}

package com.bumptech.glide.load.d.e;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.c.b;
import com.bumptech.glide.load.b.a.e;

public final class b implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final e f1351a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.b f1352b;

    private b(e eVar) {
        this(eVar, (com.bumptech.glide.load.b.a.b) null);
    }

    public b(e eVar, @Nullable com.bumptech.glide.load.b.a.b bVar) {
        this.f1351a = eVar;
        this.f1352b = bVar;
    }

    @NonNull
    public final Bitmap a(int i, int i2, @NonNull Bitmap.Config config) {
        return this.f1351a.b(i, i2, config);
    }

    public final void a(@NonNull Bitmap bitmap) {
        this.f1351a.a(bitmap);
    }

    public final void a(@NonNull byte[] bArr) {
        if (this.f1352b != null) {
            this.f1352b.b(bArr);
        }
    }

    public final void a(@NonNull int[] iArr) {
        if (this.f1352b != null) {
            this.f1352b.b(iArr);
        }
    }

    @NonNull
    public final byte[] a(int i) {
        return this.f1352b == null ? new byte[i] : (byte[]) this.f1352b.a(i, byte[].class);
    }

    @NonNull
    public final int[] b(int i) {
        return this.f1352b == null ? new int[i] : (int[]) this.f1352b.a(i, int[].class);
    }
}

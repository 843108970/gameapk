package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.bumptech.glide.i;
import com.bumptech.glide.request.a.f;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.Arrays;

public final class l<T> implements i.b<T>, SizeReadyCallback {

    /* renamed from: a  reason: collision with root package name */
    private int[] f1512a;

    /* renamed from: b  reason: collision with root package name */
    private a f1513b;

    private static final class a extends ViewTarget<View, Object> {
        a(@NonNull View view, @NonNull SizeReadyCallback sizeReadyCallback) {
            super(view);
            getSize(sizeReadyCallback);
        }

        public final void onResourceReady(@NonNull Object obj, @Nullable f<? super Object> fVar) {
        }
    }

    public l() {
    }

    private l(@NonNull View view) {
        this.f1513b = new a(view, this);
    }

    private void a(@NonNull View view) {
        if (this.f1512a == null && this.f1513b == null) {
            this.f1513b = new a(view, this);
        }
    }

    @Nullable
    public final int[] a() {
        if (this.f1512a == null) {
            return null;
        }
        return Arrays.copyOf(this.f1512a, this.f1512a.length);
    }

    public final void onSizeReady(int i, int i2) {
        this.f1512a = new int[]{i, i2};
        this.f1513b = null;
    }
}

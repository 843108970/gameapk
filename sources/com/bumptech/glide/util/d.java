package com.bumptech.glide.util;

import android.support.annotation.Nullable;
import com.bumptech.glide.i;

public final class d<T> implements i.b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f1497a;

    private d(int i, int i2) {
        this.f1497a = new int[]{i, i2};
    }

    @Nullable
    public final int[] a() {
        return this.f1497a;
    }
}

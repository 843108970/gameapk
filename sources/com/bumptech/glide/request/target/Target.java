package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.manager.i;
import com.bumptech.glide.request.a.f;
import com.bumptech.glide.request.c;

public interface Target<R> extends i {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    @Nullable
    c getRequest();

    void getSize(@NonNull SizeReadyCallback sizeReadyCallback);

    void onLoadCleared(@Nullable Drawable drawable);

    void onLoadFailed(@Nullable Drawable drawable);

    void onLoadStarted(@Nullable Drawable drawable);

    void onResourceReady(@NonNull R r, @Nullable f<? super R> fVar);

    void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback);

    void setRequest(@Nullable c cVar);
}

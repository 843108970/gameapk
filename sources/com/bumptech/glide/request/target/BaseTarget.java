package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import com.bumptech.glide.request.c;

@Deprecated
public abstract class BaseTarget<Z> implements Target<Z> {
    private c request;

    @Nullable
    public c getRequest() {
        return this.request;
    }

    public void onDestroy() {
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    public void onLoadFailed(@Nullable Drawable drawable) {
    }

    public void onLoadStarted(@Nullable Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void setRequest(@Nullable c cVar) {
        this.request = cVar;
    }
}

package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.request.a.f;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements f.a {
    @Nullable
    private Animatable animatable;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Deprecated
    public ImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    private void maybeUpdateAnimatable(@Nullable Z z) {
        if (z instanceof Animatable) {
            this.animatable = (Animatable) z;
            this.animatable.start();
            return;
        }
        this.animatable = null;
    }

    private void setResourceInternal(@Nullable Z z) {
        setResource(z);
        maybeUpdateAnimatable(z);
    }

    @Nullable
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        if (this.animatable != null) {
            this.animatable.stop();
        }
        setResourceInternal((Object) null);
        setDrawable(drawable);
    }

    public void onLoadFailed(@Nullable Drawable drawable) {
        super.onLoadFailed(drawable);
        setResourceInternal((Object) null);
        setDrawable(drawable);
    }

    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        setResourceInternal((Object) null);
        setDrawable(drawable);
    }

    public void onResourceReady(@NonNull Z z, @Nullable f<? super Z> fVar) {
        if (fVar == null || !fVar.a(z, this)) {
            setResourceInternal(z);
        } else {
            maybeUpdateAnimatable(z);
        }
    }

    public void onStart() {
        if (this.animatable != null) {
            this.animatable.start();
        }
    }

    public void onStop() {
        if (this.animatable != null) {
            this.animatable.stop();
        }
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public abstract void setResource(@Nullable Z z);
}

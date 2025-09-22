package com.lidroid.xutils.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.lidroid.xutils.bitmap.core.BitmapSize;
import com.lidroid.xutils.bitmap.factory.BitmapFactory;
import com.lidroid.xutils.task.Priority;

public class BitmapDisplayConfig {
    private Animation animation;
    private boolean autoRotation = false;
    private Bitmap.Config bitmapConfig = Bitmap.Config.RGB_565;
    private BitmapFactory bitmapFactory;
    private BitmapSize bitmapMaxSize;
    private Drawable loadFailedDrawable;
    private Drawable loadingDrawable;
    private Priority priority;
    private boolean showOriginal = false;

    public BitmapDisplayConfig cloneNew() {
        BitmapDisplayConfig bitmapDisplayConfig = new BitmapDisplayConfig();
        bitmapDisplayConfig.bitmapMaxSize = this.bitmapMaxSize;
        bitmapDisplayConfig.animation = this.animation;
        bitmapDisplayConfig.loadingDrawable = this.loadingDrawable;
        bitmapDisplayConfig.loadFailedDrawable = this.loadFailedDrawable;
        bitmapDisplayConfig.autoRotation = this.autoRotation;
        bitmapDisplayConfig.showOriginal = this.showOriginal;
        bitmapDisplayConfig.bitmapConfig = this.bitmapConfig;
        bitmapDisplayConfig.bitmapFactory = this.bitmapFactory;
        bitmapDisplayConfig.priority = this.priority;
        return bitmapDisplayConfig;
    }

    public Animation getAnimation() {
        return this.animation;
    }

    public Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public BitmapFactory getBitmapFactory() {
        return this.bitmapFactory;
    }

    public BitmapSize getBitmapMaxSize() {
        return this.bitmapMaxSize == null ? BitmapSize.ZERO : this.bitmapMaxSize;
    }

    public Drawable getLoadFailedDrawable() {
        return this.loadFailedDrawable;
    }

    public Drawable getLoadingDrawable() {
        return this.loadingDrawable;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public boolean isAutoRotation() {
        return this.autoRotation;
    }

    public boolean isShowOriginal() {
        return this.showOriginal;
    }

    public void setAnimation(Animation animation2) {
        this.animation = animation2;
    }

    public void setAutoRotation(boolean z) {
        this.autoRotation = z;
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.bitmapConfig = config;
    }

    public void setBitmapFactory(BitmapFactory bitmapFactory2) {
        this.bitmapFactory = bitmapFactory2;
    }

    public void setBitmapMaxSize(BitmapSize bitmapSize) {
        this.bitmapMaxSize = bitmapSize;
    }

    public void setLoadFailedDrawable(Drawable drawable) {
        this.loadFailedDrawable = drawable;
    }

    public void setLoadingDrawable(Drawable drawable) {
        this.loadingDrawable = drawable;
    }

    public void setPriority(Priority priority2) {
        this.priority = priority2;
    }

    public void setShowOriginal(boolean z) {
        this.showOriginal = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(String.valueOf(isShowOriginal() ? "" : this.bitmapMaxSize.toString()));
        sb.append(this.bitmapFactory == null ? "" : this.bitmapFactory.getClass().getName());
        return sb.toString();
    }
}

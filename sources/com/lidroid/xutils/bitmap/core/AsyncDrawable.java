package com.lidroid.xutils.bitmap.core;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.lidroid.xutils.BitmapUtils;
import java.lang.ref.WeakReference;

public class AsyncDrawable<T extends View> extends Drawable {
    private final Drawable baseDrawable;
    private final WeakReference<BitmapUtils.BitmapLoadTask<T>> bitmapLoadTaskReference;

    public AsyncDrawable(Drawable drawable, BitmapUtils.BitmapLoadTask<T> bitmapLoadTask) {
        if (bitmapLoadTask == null) {
            throw new IllegalArgumentException("bitmapWorkerTask may not be null");
        }
        this.baseDrawable = drawable;
        this.bitmapLoadTaskReference = new WeakReference<>(bitmapLoadTask);
    }

    public void clearColorFilter() {
        if (this.baseDrawable != null) {
            this.baseDrawable.clearColorFilter();
        }
    }

    public void draw(Canvas canvas) {
        if (this.baseDrawable != null) {
            this.baseDrawable.draw(canvas);
        }
    }

    public BitmapUtils.BitmapLoadTask<T> getBitmapWorkerTask() {
        return (BitmapUtils.BitmapLoadTask) this.bitmapLoadTaskReference.get();
    }

    public int getChangingConfigurations() {
        if (this.baseDrawable == null) {
            return 0;
        }
        return this.baseDrawable.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.baseDrawable == null) {
            return null;
        }
        return this.baseDrawable.getConstantState();
    }

    public Drawable getCurrent() {
        if (this.baseDrawable == null) {
            return null;
        }
        return this.baseDrawable.getCurrent();
    }

    public int getIntrinsicHeight() {
        if (this.baseDrawable == null) {
            return 0;
        }
        return this.baseDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        if (this.baseDrawable == null) {
            return 0;
        }
        return this.baseDrawable.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        if (this.baseDrawable == null) {
            return 0;
        }
        return this.baseDrawable.getMinimumHeight();
    }

    public int getMinimumWidth() {
        if (this.baseDrawable == null) {
            return 0;
        }
        return this.baseDrawable.getMinimumWidth();
    }

    public int getOpacity() {
        if (this.baseDrawable == null) {
            return 127;
        }
        return this.baseDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.baseDrawable != null && this.baseDrawable.getPadding(rect);
    }

    public int[] getState() {
        if (this.baseDrawable == null) {
            return null;
        }
        return this.baseDrawable.getState();
    }

    public Region getTransparentRegion() {
        if (this.baseDrawable == null) {
            return null;
        }
        return this.baseDrawable.getTransparentRegion();
    }

    public void invalidateSelf() {
        if (this.baseDrawable != null) {
            this.baseDrawable.invalidateSelf();
        }
    }

    public boolean isStateful() {
        return this.baseDrawable != null && this.baseDrawable.isStateful();
    }

    public Drawable mutate() {
        if (this.baseDrawable == null) {
            return null;
        }
        return this.baseDrawable.mutate();
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.baseDrawable != null) {
            this.baseDrawable.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setAlpha(i);
        }
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setBounds(i, i2, i3, i4);
        }
    }

    public void setBounds(Rect rect) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setChangingConfigurations(i);
        }
    }

    public void setColorFilter(int i, PorterDuff.Mode mode) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setColorFilter(i, mode);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setColorFilter(colorFilter);
        }
    }

    public void setDither(boolean z) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setDither(z);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setFilterBitmap(z);
        }
    }

    public boolean setState(int[] iArr) {
        return this.baseDrawable != null && this.baseDrawable.setState(iArr);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.baseDrawable != null && this.baseDrawable.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.baseDrawable != null) {
            this.baseDrawable.unscheduleSelf(runnable);
        }
    }
}

package com.cyjh.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.cyjh.common.R;

public abstract class ProcessButton extends FlatButton {

    /* renamed from: a  reason: collision with root package name */
    private int f1822a;

    /* renamed from: b  reason: collision with root package name */
    private int f1823b;

    /* renamed from: c  reason: collision with root package name */
    private int f1824c;
    private GradientDrawable d;
    private GradientDrawable e;
    private GradientDrawable f;
    private CharSequence g;
    private CharSequence h;
    private CharSequence i;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            private static SavedState a(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }

            private static SavedState[] a(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f1825a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1825a = parcel.readInt();
        }

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1825a);
        }
    }

    public ProcessButton(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public ProcessButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ProcessButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a() {
        if (getErrorText() != null) {
            setText(getErrorText());
        }
        setBackgroundCompat(getErrorDrawable());
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray a2;
        this.f1824c = 0;
        this.f1823b = 100;
        this.d = (GradientDrawable) a(R.drawable.rect_progress).mutate();
        this.d.setCornerRadius(getCornerRadius());
        this.e = (GradientDrawable) a(R.drawable.rect_complete).mutate();
        this.e.setCornerRadius(getCornerRadius());
        this.f = (GradientDrawable) a(R.drawable.rect_error).mutate();
        this.f.setCornerRadius(getCornerRadius());
        if (attributeSet != null && (a2 = a(context, attributeSet, R.styleable.ProcessButton)) != null) {
            try {
                this.g = a2.getString(R.styleable.ProcessButton_pb_textProgress);
                this.h = a2.getString(R.styleable.ProcessButton_pb_textComplete);
                this.i = a2.getString(R.styleable.ProcessButton_pb_textError);
                this.d.setColor(a2.getColor(R.styleable.ProcessButton_pb_colorProgress, c(R.color.purple_progress)));
                this.e.setColor(a2.getColor(R.styleable.ProcessButton_pb_colorComplete, c(R.color.green_complete)));
                this.f.setColor(a2.getColor(R.styleable.ProcessButton_pb_colorError, c(R.color.red_error)));
            } finally {
                a2.recycle();
            }
        }
    }

    private void b() {
        if (getLoadingText() != null) {
            setText(getLoadingText());
        }
        setBackgroundCompat(getNormalDrawable());
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray a2 = a(context, attributeSet, R.styleable.ProcessButton);
        if (a2 != null) {
            try {
                this.g = a2.getString(R.styleable.ProcessButton_pb_textProgress);
                this.h = a2.getString(R.styleable.ProcessButton_pb_textComplete);
                this.i = a2.getString(R.styleable.ProcessButton_pb_textError);
                this.d.setColor(a2.getColor(R.styleable.ProcessButton_pb_colorProgress, c(R.color.purple_progress)));
                this.e.setColor(a2.getColor(R.styleable.ProcessButton_pb_colorComplete, c(R.color.green_complete)));
                this.f.setColor(a2.getColor(R.styleable.ProcessButton_pb_colorError, c(R.color.red_error)));
            } finally {
                a2.recycle();
            }
        }
    }

    private void c() {
        if (getCompleteText() != null) {
            setText(getCompleteText());
        }
        setBackgroundCompat(getCompleteDrawable());
    }

    private void d() {
        if (getNormalText() != null) {
            setText(getNormalText());
        }
        setBackgroundCompat(getNormalDrawable());
    }

    public abstract void a(Canvas canvas);

    public GradientDrawable getCompleteDrawable() {
        return this.e;
    }

    public CharSequence getCompleteText() {
        return this.h;
    }

    public GradientDrawable getErrorDrawable() {
        return this.f;
    }

    public CharSequence getErrorText() {
        return this.i;
    }

    public CharSequence getLoadingText() {
        return this.g;
    }

    public int getMaxProgress() {
        return this.f1823b;
    }

    public int getMinProgress() {
        return this.f1824c;
    }

    public int getProgress() {
        return this.f1822a;
    }

    public GradientDrawable getProgressDrawable() {
        return this.d;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f1822a > this.f1824c && this.f1822a < this.f1823b) {
            a(canvas);
        }
        super.onDraw(canvas);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f1822a = savedState.f1825a;
            super.onRestoreInstanceState(savedState.getSuperState());
            setProgress(this.f1822a);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int unused = savedState.f1825a = this.f1822a;
        return savedState;
    }

    public void setCompleteDrawable(GradientDrawable gradientDrawable) {
        this.e = gradientDrawable;
    }

    public void setCompleteText(CharSequence charSequence) {
        this.h = charSequence;
    }

    public void setErrorDrawable(GradientDrawable gradientDrawable) {
        this.f = gradientDrawable;
    }

    public void setErrorText(CharSequence charSequence) {
        this.i = charSequence;
    }

    public void setLoadingText(CharSequence charSequence) {
        this.g = charSequence;
    }

    public void setProgress(int i2) {
        CharSequence loadingText;
        Drawable errorDrawable;
        this.f1822a = i2;
        if (this.f1822a == this.f1824c) {
            if (getNormalText() != null) {
                loadingText = getNormalText();
            }
            errorDrawable = getNormalDrawable();
            setBackgroundCompat(errorDrawable);
            invalidate();
        }
        if (this.f1822a == this.f1823b) {
            if (getCompleteText() != null) {
                setText(getCompleteText());
            }
            errorDrawable = getCompleteDrawable();
        } else if (this.f1822a < this.f1824c) {
            if (getErrorText() != null) {
                setText(getErrorText());
            }
            errorDrawable = getErrorDrawable();
        } else {
            if (getLoadingText() != null) {
                loadingText = getLoadingText();
            }
            errorDrawable = getNormalDrawable();
        }
        setBackgroundCompat(errorDrawable);
        invalidate();
        setText(loadingText);
        errorDrawable = getNormalDrawable();
        setBackgroundCompat(errorDrawable);
        invalidate();
    }

    public void setProgressDrawable(GradientDrawable gradientDrawable) {
        this.d = gradientDrawable;
    }
}

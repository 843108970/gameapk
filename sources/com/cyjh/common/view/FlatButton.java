package com.cyjh.common.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;
import com.cyjh.common.R;

public class FlatButton extends Button {

    /* renamed from: a  reason: collision with root package name */
    private StateListDrawable f1804a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f1805b;

    /* renamed from: c  reason: collision with root package name */
    private float f1806c;

    public FlatButton(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public FlatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public FlatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    protected static TypedArray a(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private LayerDrawable a(TypedArray typedArray) {
        LayerDrawable layerDrawable = (LayerDrawable) a(R.drawable.rect_normal).mutate();
        GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable.getDrawable(0).mutate();
        gradientDrawable.setCornerRadius(getCornerRadius());
        gradientDrawable.setColor(typedArray.getColor(R.styleable.FlatButton_pb_colorPressed, c(R.color.blue_pressed)));
        GradientDrawable gradientDrawable2 = (GradientDrawable) layerDrawable.getDrawable(1).mutate();
        gradientDrawable2.setCornerRadius(getCornerRadius());
        gradientDrawable2.setColor(typedArray.getColor(R.styleable.FlatButton_pb_colorNormal, c(R.color.blue_normal)));
        return layerDrawable;
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray a2;
        this.f1804a = new StateListDrawable();
        if (!(attributeSet == null || (a2 = a(context, attributeSet, R.styleable.FlatButton)) == null)) {
            try {
                this.f1806c = a2.getDimension(R.styleable.FlatButton_pb_cornerRadius, b(R.dimen.corner_radius));
                this.f1804a.addState(new int[]{16842919}, b(a2));
                this.f1804a.addState(new int[]{16842908}, b(a2));
                this.f1804a.addState(new int[]{16842913}, b(a2));
                LayerDrawable layerDrawable = (LayerDrawable) a(R.drawable.rect_normal).mutate();
                GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable.getDrawable(0).mutate();
                gradientDrawable.setCornerRadius(getCornerRadius());
                gradientDrawable.setColor(a2.getColor(R.styleable.FlatButton_pb_colorPressed, c(R.color.blue_pressed)));
                GradientDrawable gradientDrawable2 = (GradientDrawable) layerDrawable.getDrawable(1).mutate();
                gradientDrawable2.setCornerRadius(getCornerRadius());
                gradientDrawable2.setColor(a2.getColor(R.styleable.FlatButton_pb_colorNormal, c(R.color.blue_normal)));
                this.f1804a.addState(new int[0], layerDrawable);
            } finally {
                a2.recycle();
            }
        }
        this.f1805b = getText().toString();
        setBackgroundCompat(this.f1804a);
    }

    private Drawable b(TypedArray typedArray) {
        GradientDrawable gradientDrawable = (GradientDrawable) a(R.drawable.rect_pressed).mutate();
        gradientDrawable.setCornerRadius(getCornerRadius());
        gradientDrawable.setColor(typedArray.getColor(R.styleable.FlatButton_pb_colorPressed, c(R.color.blue_pressed)));
        return gradientDrawable;
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray a2 = a(context, attributeSet, R.styleable.FlatButton);
        if (a2 != null) {
            try {
                this.f1806c = a2.getDimension(R.styleable.FlatButton_pb_cornerRadius, b(R.dimen.corner_radius));
                this.f1804a.addState(new int[]{16842919}, b(a2));
                this.f1804a.addState(new int[]{16842908}, b(a2));
                this.f1804a.addState(new int[]{16842913}, b(a2));
                LayerDrawable layerDrawable = (LayerDrawable) a(R.drawable.rect_normal).mutate();
                GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable.getDrawable(0).mutate();
                gradientDrawable.setCornerRadius(getCornerRadius());
                gradientDrawable.setColor(a2.getColor(R.styleable.FlatButton_pb_colorPressed, c(R.color.blue_pressed)));
                GradientDrawable gradientDrawable2 = (GradientDrawable) layerDrawable.getDrawable(1).mutate();
                gradientDrawable2.setCornerRadius(getCornerRadius());
                gradientDrawable2.setColor(a2.getColor(R.styleable.FlatButton_pb_colorNormal, c(R.color.blue_normal)));
                this.f1804a.addState(new int[0], layerDrawable);
            } finally {
                a2.recycle();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Drawable a(int i) {
        return getResources().getDrawable(i);
    }

    /* access modifiers changed from: protected */
    public final float b(int i) {
        return getResources().getDimension(i);
    }

    /* access modifiers changed from: protected */
    public final int c(int i) {
        return getResources().getColor(i);
    }

    public float getCornerRadius() {
        return this.f1806c;
    }

    public StateListDrawable getNormalDrawable() {
        return this.f1804a;
    }

    public CharSequence getNormalText() {
        return this.f1805b;
    }

    @SuppressLint({"NewApi"})
    public void setBackgroundCompat(Drawable drawable) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}

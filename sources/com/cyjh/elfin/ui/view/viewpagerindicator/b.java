package com.cyjh.elfin.ui.view.viewpagerindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.ywfzjbcy.R;

final class b extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2346a = {16843049, 16843561, 16843562};

    /* renamed from: b  reason: collision with root package name */
    private static final int f2347b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f2348c = 1;
    private static final int d = 2;
    private Drawable e;
    private int f;
    private int g;
    private int h;
    private int i;

    public b(Context context) {
        super(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f2346a, R.attr.vpiTabPageIndicatorStyle, 0);
        setDividerDrawable(obtainStyledAttributes.getDrawable(0));
        this.i = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.h = obtainStyledAttributes.getInteger(1, 0);
        obtainStyledAttributes.recycle();
    }

    private void a(Canvas canvas) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (!(childAt == null || childAt.getVisibility() == 8 || !a(i2))) {
                a(canvas, childAt.getTop() - ((LinearLayout.LayoutParams) childAt.getLayoutParams()).topMargin);
            }
        }
        if (a(childCount)) {
            View childAt2 = getChildAt(childCount - 1);
            a(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.g : childAt2.getBottom());
        }
    }

    private void a(Canvas canvas, int i2) {
        this.e.setBounds(getPaddingLeft() + this.i, i2, (getWidth() - getPaddingRight()) - this.i, this.g + i2);
        this.e.draw(canvas);
    }

    private boolean a(int i2) {
        if (!(i2 == 0 || i2 == getChildCount() || (this.h & 2) == 0)) {
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                if (getChildAt(i3).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    private void b(Canvas canvas) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (!(childAt == null || childAt.getVisibility() == 8 || !a(i2))) {
                b(canvas, childAt.getLeft() - ((LinearLayout.LayoutParams) childAt.getLayoutParams()).leftMargin);
            }
        }
        if (a(childCount)) {
            View childAt2 = getChildAt(childCount - 1);
            b(canvas, childAt2 == null ? (getWidth() - getPaddingRight()) - this.f : childAt2.getRight());
        }
    }

    private void b(Canvas canvas, int i2) {
        this.e.setBounds(i2, getPaddingTop() + this.i, this.f + i2, (getHeight() - getPaddingBottom()) - this.i);
        this.e.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public final void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        int indexOfChild = indexOfChild(view);
        int orientation = getOrientation();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (a(indexOfChild)) {
            if (orientation == 1) {
                layoutParams.topMargin = this.g;
            } else {
                layoutParams.leftMargin = this.f;
            }
        }
        int childCount = getChildCount();
        if (indexOfChild == childCount - 1 && a(childCount)) {
            if (orientation == 1) {
                layoutParams.bottomMargin = this.g;
            } else {
                layoutParams.rightMargin = this.f;
            }
        }
        super.measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        if (this.e != null) {
            int i2 = 0;
            if (getOrientation() == 1) {
                int childCount = getChildCount();
                while (i2 < childCount) {
                    View childAt = getChildAt(i2);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !a(i2))) {
                        a(canvas, childAt.getTop() - ((LinearLayout.LayoutParams) childAt.getLayoutParams()).topMargin);
                    }
                    i2++;
                }
                if (a(childCount)) {
                    View childAt2 = getChildAt(childCount - 1);
                    a(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.g : childAt2.getBottom());
                }
            } else {
                int childCount2 = getChildCount();
                while (i2 < childCount2) {
                    View childAt3 = getChildAt(i2);
                    if (!(childAt3 == null || childAt3.getVisibility() == 8 || !a(i2))) {
                        b(canvas, childAt3.getLeft() - ((LinearLayout.LayoutParams) childAt3.getLayoutParams()).leftMargin);
                    }
                    i2++;
                }
                if (a(childCount2)) {
                    View childAt4 = getChildAt(childCount2 - 1);
                    b(canvas, childAt4 == null ? (getWidth() - getPaddingRight()) - this.f : childAt4.getRight());
                }
            }
        }
        super.onDraw(canvas);
    }

    public final void setDividerDrawable(Drawable drawable) {
        if (drawable != this.e) {
            this.e = drawable;
            boolean z = false;
            if (drawable != null) {
                this.f = drawable.getIntrinsicWidth();
                this.g = drawable.getIntrinsicHeight();
            } else {
                this.f = 0;
                this.g = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }
}

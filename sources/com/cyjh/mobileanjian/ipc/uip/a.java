package com.cyjh.mobileanjian.ipc.uip;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.annotation.AnimatorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.cyjh.mqsdk.R;

public final class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int f2685a = 8;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ViewPager f2686b;

    /* renamed from: c  reason: collision with root package name */
    private int f2687c = -1;
    private int d = -1;
    private int e = -1;
    private int f = R.animator.no_animator;
    private int g = 0;
    /* access modifiers changed from: private */
    public int h = R.drawable.ci_blue_point;
    /* access modifiers changed from: private */
    public int i = R.drawable.ci_gray_point;
    /* access modifiers changed from: private */
    public Animator j;
    /* access modifiers changed from: private */
    public Animator k;
    private Animator l;
    private Animator m;
    /* access modifiers changed from: private */
    public int n = -1;
    private final ViewPager.OnPageChangeListener o = new ViewPager.OnPageChangeListener() {
        public final void onPageScrollStateChanged(int i) {
        }

        public final void onPageScrolled(int i, float f, int i2) {
        }

        public final void onPageSelected(int i) {
            View childAt;
            if (a.this.f2686b.getAdapter() != null && a.this.f2686b.getAdapter().getCount() > 0) {
                if (a.this.k.isRunning()) {
                    a.this.k.end();
                    a.this.k.cancel();
                }
                if (a.this.j.isRunning()) {
                    a.this.j.end();
                    a.this.j.cancel();
                }
                if (a.this.n >= 0 && (childAt = a.this.getChildAt(a.this.n)) != null) {
                    childAt.setBackgroundResource(a.this.i);
                    a.this.k.setTarget(childAt);
                    a.this.k.start();
                }
                View childAt2 = a.this.getChildAt(i);
                if (childAt2 != null) {
                    childAt2.setBackgroundResource(a.this.h);
                    a.this.j.setTarget(childAt2);
                    a.this.j.start();
                }
                int unused = a.this.n = i;
            }
        }
    };
    private DataSetObserver p = new DataSetObserver() {
        public final void onChanged() {
            int count;
            a aVar;
            int i;
            super.onChanged();
            if (a.this.f2686b != null && (count = a.this.f2686b.getAdapter().getCount()) != a.this.getChildCount()) {
                if (a.this.n < count) {
                    aVar = a.this;
                    i = a.this.f2686b.getCurrentItem();
                } else {
                    aVar = a.this;
                    i = -1;
                }
                int unused = aVar.n = i;
                a.this.a();
            }
        }
    };

    /* renamed from: com.cyjh.mobileanjian.ipc.uip.a$a  reason: collision with other inner class name */
    private class C0043a implements Interpolator {
        private C0043a() {
        }

        /* synthetic */ C0043a(a aVar, byte b2) {
            this();
        }

        public final float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }

    public a(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    private a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    @TargetApi(21)
    private a(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public void a() {
        int i2;
        Animator animator;
        removeAllViews();
        int count = this.f2686b.getAdapter().getCount();
        if (count > 0) {
            int currentItem = this.f2686b.getCurrentItem();
            int orientation = getOrientation();
            for (int i3 = 0; i3 < count; i3++) {
                if (currentItem == i3) {
                    i2 = this.h;
                    animator = this.l;
                } else {
                    i2 = this.i;
                    animator = this.m;
                }
                a(orientation, i2, animator);
            }
        }
    }

    private void a(int i2, int i3, int i4) {
        int i5 = R.animator.scale_with_alpha;
        int i6 = R.drawable.white_radius;
        int i7 = R.drawable.white_radius;
        this.d = i2;
        this.e = i3;
        this.f2687c = i4;
        this.f = i5;
        this.g = 0;
        this.h = i6;
        this.i = i7;
        a(getContext());
    }

    private void a(int i2, int i3, int i4, @AnimatorRes int i5, @DrawableRes int i6, @DrawableRes int i7) {
        this.d = i2;
        this.e = i3;
        this.f2687c = i4;
        this.f = i5;
        this.g = 0;
        this.h = i6;
        this.i = i7;
        a(getContext());
    }

    private void a(int i2, @DrawableRes int i3, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i3);
        addView(view, this.d, this.e);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (i2 == 0) {
            layoutParams.leftMargin = this.f2687c;
            layoutParams.rightMargin = this.f2687c;
        } else {
            layoutParams.topMargin = this.f2687c;
            layoutParams.bottomMargin = this.f2687c;
        }
        view.setLayoutParams(layoutParams);
        animator.setTarget(view);
        animator.start();
    }

    private void a(Context context) {
        this.d = this.d < 0 ? a(8.0f) : this.d;
        this.e = this.e < 0 ? a(8.0f) : this.e;
        this.f2687c = this.f2687c < 0 ? a(8.0f) : this.f2687c;
        this.f = this.f == 0 ? R.animator.scale_with_alpha : this.f;
        this.j = b(context);
        this.l = b(context);
        this.l.setDuration(0);
        this.k = c(context);
        this.m = c(context);
        this.m.setDuration(0);
        this.h = this.h == 0 ? R.drawable.white_radius : this.h;
        this.i = this.i == 0 ? this.h : this.i;
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleIndicator);
            this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_width, -1);
            this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_height, -1);
            this.f2687c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_margin, -1);
            this.f = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_animator, R.animator.scale_with_alpha);
            int i2 = 0;
            this.g = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_animator_reverse, 0);
            this.h = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_drawable, R.drawable.white_radius);
            this.i = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_drawable_unselected, this.h);
            if (obtainStyledAttributes.getInt(R.styleable.CircleIndicator_ci_orientation, -1) == 1) {
                i2 = 1;
            }
            setOrientation(i2);
            int i3 = obtainStyledAttributes.getInt(R.styleable.CircleIndicator_ci_gravity, -1);
            if (i3 < 0) {
                i3 = 17;
            }
            setGravity(i3);
            obtainStyledAttributes.recycle();
        }
        a(context);
    }

    private Animator b(Context context) {
        return AnimatorInflater.loadAnimator(context, this.f);
    }

    private void b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleIndicator);
            this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_width, -1);
            this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_height, -1);
            this.f2687c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_margin, -1);
            this.f = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_animator, R.animator.scale_with_alpha);
            int i2 = 0;
            this.g = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_animator_reverse, 0);
            this.h = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_drawable, R.drawable.white_radius);
            this.i = obtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_drawable_unselected, this.h);
            if (obtainStyledAttributes.getInt(R.styleable.CircleIndicator_ci_orientation, -1) == 1) {
                i2 = 1;
            }
            setOrientation(i2);
            int i3 = obtainStyledAttributes.getInt(R.styleable.CircleIndicator_ci_gravity, -1);
            if (i3 < 0) {
                i3 = 17;
            }
            setGravity(i3);
            obtainStyledAttributes.recycle();
        }
    }

    private Animator c(Context context) {
        if (this.g != 0) {
            return AnimatorInflater.loadAnimator(context, this.g);
        }
        Animator loadAnimator = AnimatorInflater.loadAnimator(context, this.f);
        loadAnimator.setInterpolator(new C0043a(this, (byte) 0));
        return loadAnimator;
    }

    public final int a(float f2) {
        return (int) ((f2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final DataSetObserver getDataSetObserver() {
        return this.p;
    }

    @Deprecated
    public final void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.f2686b == null) {
            throw new NullPointerException("can not find Viewpager , setViewPager first");
        }
        this.f2686b.removeOnPageChangeListener(onPageChangeListener);
        this.f2686b.addOnPageChangeListener(onPageChangeListener);
    }

    public final void setViewPager(ViewPager viewPager) {
        this.f2686b = viewPager;
        if (this.f2686b != null && this.f2686b.getAdapter() != null) {
            this.n = -1;
            a();
            this.f2686b.removeOnPageChangeListener(this.o);
            this.f2686b.addOnPageChangeListener(this.o);
            this.o.onPageSelected(this.f2686b.getCurrentItem());
        }
    }
}

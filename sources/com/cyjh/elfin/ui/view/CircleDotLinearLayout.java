package com.cyjh.elfin.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class CircleDotLinearLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private static final int f2309b = 6;

    /* renamed from: c  reason: collision with root package name */
    private static final int f2310c = 0;
    private static final String d = "#3c7ac5";
    private static final String e = "#bababa";
    private static final float f = 8.0f;
    private static final int g = 100;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<ImageView> f2311a = new ArrayList();
    /* access modifiers changed from: private */
    public GradientDrawable h;
    /* access modifiers changed from: private */
    public GradientDrawable i;
    private a j;
    /* access modifiers changed from: private */
    public Handler k = new Handler();
    /* access modifiers changed from: private */
    public int l;

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(CircleDotLinearLayout circleDotLinearLayout, byte b2) {
            this();
        }

        private void a() {
            CircleDotLinearLayout.this.k.removeCallbacks(this);
            CircleDotLinearLayout.this.k.postDelayed(this, 100);
        }

        public final void run() {
            ImageView imageView;
            GradientDrawable f;
            CircleDotLinearLayout.b(CircleDotLinearLayout.this);
            for (int i = 0; i < CircleDotLinearLayout.this.f2311a.size(); i++) {
                if (i == CircleDotLinearLayout.this.l % CircleDotLinearLayout.this.f2311a.size()) {
                    imageView = (ImageView) CircleDotLinearLayout.this.f2311a.get(i);
                    f = CircleDotLinearLayout.this.h;
                } else {
                    imageView = (ImageView) CircleDotLinearLayout.this.f2311a.get(i);
                    f = CircleDotLinearLayout.this.i;
                }
                imageView.setImageDrawable(f);
            }
            CircleDotLinearLayout.this.k.removeCallbacks(this);
            CircleDotLinearLayout.this.k.postDelayed(this, 100);
        }
    }

    public CircleDotLinearLayout(Context context) {
        super(context);
        a();
    }

    public CircleDotLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CircleDotLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        removeAllViews();
        this.f2311a.clear();
        for (int i2 = 0; i2 < 6; i2++) {
            ImageView imageView = new ImageView(getContext());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setCornerRadius((float) com.cyjh.common.util.a.e(getContext()));
            gradientDrawable.setSize(com.cyjh.common.util.a.e(getContext()), com.cyjh.common.util.a.e(getContext()));
            if (i2 == 0) {
                gradientDrawable.setColor(Color.parseColor(d));
                this.h = gradientDrawable;
            } else {
                gradientDrawable.setColor(Color.parseColor(e));
                if (i2 == 5) {
                    this.i = gradientDrawable;
                }
            }
            imageView.setImageDrawable(gradientDrawable);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.cyjh.common.util.a.e(getContext()), 0);
            addView(imageView, layoutParams);
            this.f2311a.add(imageView);
        }
        this.j = new a(this, (byte) 0);
        a aVar = this.j;
        CircleDotLinearLayout.this.k.removeCallbacks(aVar);
        CircleDotLinearLayout.this.k.postDelayed(aVar, 100);
    }

    static /* synthetic */ int b(CircleDotLinearLayout circleDotLinearLayout) {
        int i2 = circleDotLinearLayout.l;
        circleDotLinearLayout.l = i2 + 1;
        return i2;
    }

    private void b() {
        removeAllViews();
        this.f2311a.clear();
        for (int i2 = 0; i2 < 6; i2++) {
            ImageView imageView = new ImageView(getContext());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setCornerRadius((float) com.cyjh.common.util.a.e(getContext()));
            gradientDrawable.setSize(com.cyjh.common.util.a.e(getContext()), com.cyjh.common.util.a.e(getContext()));
            if (i2 == 0) {
                gradientDrawable.setColor(Color.parseColor(d));
                this.h = gradientDrawable;
            } else {
                gradientDrawable.setColor(Color.parseColor(e));
                if (i2 == 5) {
                    this.i = gradientDrawable;
                }
            }
            imageView.setImageDrawable(gradientDrawable);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, com.cyjh.common.util.a.e(getContext()), 0);
            addView(imageView, layoutParams);
            this.f2311a.add(imageView);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k.removeCallbacksAndMessages((Object) null);
    }
}

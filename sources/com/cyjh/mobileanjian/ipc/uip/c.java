package com.cyjh.mobileanjian.ipc.uip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import com.cyjh.mqsdk.R;
import java.util.ArrayList;
import java.util.List;

public final class c extends LinearLayout implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f2695a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private static final int h = 32;

    /* renamed from: b  reason: collision with root package name */
    RadioGroup f2696b;

    /* renamed from: c  reason: collision with root package name */
    List<ScrollView> f2697c;
    int d;
    LinearLayout e;
    ScrollView f;
    int g;
    private FrameLayout i;
    private int j;

    public c(Context context) {
        this(context, (byte) 0);
    }

    private c(Context context, byte b2) {
        this(context, 0);
    }

    private c(Context context, char c2) {
        super(context, (AttributeSet) null, 0);
        this.g = 0;
        this.d = (int) TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setOrientation(0);
        LinearLayout linearLayout = new LinearLayout(context);
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(0, -1);
        layoutParams.weight = 7.5f;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(1);
        ScrollView scrollView = new ScrollView(context);
        this.f2696b = new RadioGroup(context);
        this.f2696b.setOrientation(1);
        this.f2696b.setPadding(this.d, 0, 0, -this.d);
        scrollView.addView(this.f2696b);
        linearLayout.addView(scrollView);
        addView(linearLayout);
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics()), -1));
        view.setBackgroundColor(-16777216);
        addView(view);
        this.i = new FrameLayout(context);
        TableLayout.LayoutParams layoutParams2 = new TableLayout.LayoutParams(0, -1);
        layoutParams2.weight = 2.5f;
        this.i.setLayoutParams(layoutParams2);
        this.i.setPadding(this.d, 0, this.d, 0);
        addView(this.i);
        this.f2697c = new ArrayList(32);
        this.f2696b.setOnCheckedChangeListener(this);
    }

    private void a() {
        this.f2697c.add(this.f);
        this.g++;
    }

    private void a(String str) {
        RadioButton radioButton = new RadioButton(getContext());
        radioButton.setId(f2695a[this.g]);
        radioButton.setPadding(0, 0, 0, this.d);
        radioButton.setButtonDrawable(new BitmapDrawable((Bitmap) null));
        radioButton.setTextColor(getResources().getColorStateList(R.color.selector_tab));
        radioButton.setText(str);
        radioButton.setLines(1);
        radioButton.setEllipsize(TextUtils.TruncateAt.END);
        this.f2696b.addView(radioButton);
        this.f = new ScrollView(getContext());
        this.f.setDescendantFocusability(131072);
        this.f.setFocusable(true);
        this.f.setFocusableInTouchMode(true);
        this.f.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                view.requestFocusFromTouch();
                return false;
            }
        });
        this.f.setTag(str);
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.e = linearLayout;
        this.f.addView(this.e);
    }

    private LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return linearLayout;
    }

    public final void a(View view) {
        this.e.addView(view);
    }

    public final void a(List<ScrollView> list) {
        this.f2697c = list;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setId(f2695a[i2]);
            radioButton.setPadding(0, 0, 0, this.d);
            radioButton.setButtonDrawable(new BitmapDrawable((Bitmap) null));
            radioButton.setTextColor(getResources().getColorStateList(R.color.selector_tab));
            radioButton.setText((String) list.get(i2).getTag());
            radioButton.setLines(1);
            radioButton.setEllipsize(TextUtils.TruncateAt.END);
            this.f2696b.addView(radioButton);
        }
    }

    public final int getCurrentItem() {
        return this.j;
    }

    public final List<ScrollView> getScrollViewList() {
        return this.f2697c;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
        setSelectTab(i2);
    }

    public final void setSelectTab(int i2) {
        if (this.f2697c.size() != 0) {
            if (i2 < 0 || i2 >= 32) {
                i2 = 0;
            }
            this.j = i2;
            this.f2696b.check(i2);
            this.i.removeAllViews();
            this.i.addView(this.f2697c.get(i2));
        }
    }
}

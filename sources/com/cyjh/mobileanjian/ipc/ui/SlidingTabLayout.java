package com.cyjh.mobileanjian.ipc.ui;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyjh.mqsdk.R;

public class SlidingTabLayout extends HorizontalScrollView {

    /* renamed from: b  reason: collision with root package name */
    private static final int f2592b = 24;

    /* renamed from: c  reason: collision with root package name */
    private static final int f2593c = 4;
    private static final int d = 12;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f2594a;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private SparseArray<String> i;
    /* access modifiers changed from: private */
    public ViewPager.OnPageChangeListener j;
    /* access modifiers changed from: private */
    public final d k;

    private class a implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private int f2596b;

        private a() {
        }

        /* synthetic */ a(SlidingTabLayout slidingTabLayout, byte b2) {
            this();
        }

        public final void onPageScrollStateChanged(int i) {
            this.f2596b = i;
            if (SlidingTabLayout.this.j != null) {
                SlidingTabLayout.this.j.onPageScrollStateChanged(i);
            }
        }

        public final void onPageScrolled(int i, float f, int i2) {
            int childCount = SlidingTabLayout.this.k.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.k.a(i, f);
                View childAt = SlidingTabLayout.this.k.getChildAt(i);
                SlidingTabLayout.this.b(i, childAt != null ? (int) (((float) childAt.getWidth()) * f) : 0);
                if (SlidingTabLayout.this.j != null) {
                    SlidingTabLayout.this.j.onPageScrolled(i, f, i2);
                }
            }
        }

        public final void onPageSelected(int i) {
            if (this.f2596b == 0) {
                SlidingTabLayout.this.k.a(i, 0.0f);
                SlidingTabLayout.this.b(i, 0);
            }
            int i2 = 0;
            while (i2 < SlidingTabLayout.this.k.getChildCount()) {
                SlidingTabLayout.this.k.getChildAt(i2).setSelected(i == i2);
                i2++;
            }
            if (SlidingTabLayout.this.j != null) {
                SlidingTabLayout.this.j.onPageSelected(i);
            }
        }
    }

    private class b implements View.OnClickListener {
        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, byte b2) {
            this();
        }

        public final void onClick(View view) {
            for (int i = 0; i < SlidingTabLayout.this.k.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.k.getChildAt(i)) {
                    SlidingTabLayout.this.f2594a.setCurrentItem(i);
                    return;
                }
            }
        }
    }

    public interface c {
        int a(int i);
    }

    public SlidingTabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.i = new SparseArray<>();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.e = (int) (getResources().getDisplayMetrics().density * 24.0f);
        this.k = new d(context);
        addView(this.k, -1, -2);
    }

    private TextView a(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(2, 12.0f);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(16843534, typedValue, true);
        textView.setBackgroundResource(typedValue.resourceId);
        textView.setAllCaps(true);
        int i2 = (int) (getResources().getDisplayMetrics().density * 4.0f);
        textView.setPadding(i2, i2, i2, i2);
        textView.setSingleLine(true);
        return textView;
    }

    private void a() {
        TextView textView;
        View view;
        PagerAdapter adapter = this.f2594a.getAdapter();
        b bVar = new b(this, (byte) 0);
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            if (this.f != 0) {
                view = LayoutInflater.from(getContext()).inflate(this.f, this.k, false);
                textView = (TextView) view.findViewById(this.g);
            } else {
                view = null;
                textView = null;
            }
            if (view == null) {
                TextView textView2 = new TextView(getContext());
                textView2.setGravity(17);
                textView2.setTextSize(2, 12.0f);
                textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                TypedValue typedValue = new TypedValue();
                getContext().getTheme().resolveAttribute(16843534, typedValue, true);
                textView2.setBackgroundResource(typedValue.resourceId);
                textView2.setAllCaps(true);
                int i3 = (int) (getResources().getDisplayMetrics().density * 4.0f);
                textView2.setPadding(i3, i3, i3, i3);
                textView2.setSingleLine(true);
                view = textView2;
            }
            if (textView == null && TextView.class.isInstance(view)) {
                textView = (TextView) view;
            }
            if (this.h) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            }
            textView.setTextColor(getResources().getColorStateList(R.color.selector_tab));
            textView.setTextSize(2, 14.0f);
            textView.setText(adapter.getPageTitle(i2));
            textView.setAllCaps(false);
            view.setOnClickListener(bVar);
            String str = this.i.get(i2, (Object) null);
            if (str != null) {
                view.setContentDescription(str);
            }
            this.k.addView(view);
            if (i2 == this.f2594a.getCurrentItem()) {
                view.setSelected(true);
            }
        }
    }

    private void a(int i2, int i3) {
        this.f = i2;
        this.g = i3;
    }

    private void a(int i2, String str) {
        this.i.put(i2, str);
    }

    private void a(LinearLayout linearLayout, String str) {
        l lVar = (l) this.f2594a.getAdapter();
        lVar.f2664a.add(linearLayout);
        lVar.f2665b.add(str);
        lVar.notifyDataSetChanged();
        this.f2594a.setAdapter(lVar);
        setViewPager(this.f2594a);
    }

    /* access modifiers changed from: private */
    public void b(int i2, int i3) {
        View childAt;
        int childCount = this.k.getChildCount();
        if (childCount != 0 && i2 >= 0 && i2 < childCount && (childAt = this.k.getChildAt(i2)) != null) {
            int left = childAt.getLeft() + i3;
            if (i2 > 0 || i3 > 0) {
                left -= this.e;
            }
            scrollTo(left, 0);
        }
    }

    public ViewPager getViewPager() {
        return this.f2594a;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2594a != null) {
            b(this.f2594a.getCurrentItem(), 0);
        }
    }

    public void setCustomTabColorizer(c cVar) {
        d dVar = this.k;
        dVar.f2611a = cVar;
        dVar.invalidate();
    }

    public void setDistributeEvenly(boolean z) {
        this.h = z;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.j = onPageChangeListener;
    }

    public void setSelectedIndicatorColors(int... iArr) {
        d dVar = this.k;
        dVar.f2611a = null;
        dVar.f2612b.f2613a = iArr;
        dVar.invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        TextView textView;
        View view;
        this.k.removeAllViews();
        this.f2594a = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, (byte) 0));
            PagerAdapter adapter = this.f2594a.getAdapter();
            b bVar = new b(this, (byte) 0);
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                if (this.f != 0) {
                    view = LayoutInflater.from(getContext()).inflate(this.f, this.k, false);
                    textView = (TextView) view.findViewById(this.g);
                } else {
                    view = null;
                    textView = null;
                }
                if (view == null) {
                    TextView textView2 = new TextView(getContext());
                    textView2.setGravity(17);
                    textView2.setTextSize(2, 12.0f);
                    textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    TypedValue typedValue = new TypedValue();
                    getContext().getTheme().resolveAttribute(16843534, typedValue, true);
                    textView2.setBackgroundResource(typedValue.resourceId);
                    textView2.setAllCaps(true);
                    int i3 = (int) (getResources().getDisplayMetrics().density * 4.0f);
                    textView2.setPadding(i3, i3, i3, i3);
                    textView2.setSingleLine(true);
                    view = textView2;
                }
                if (textView == null && TextView.class.isInstance(view)) {
                    textView = (TextView) view;
                }
                if (this.h) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                }
                textView.setTextColor(getResources().getColorStateList(R.color.selector_tab));
                textView.setTextSize(2, 14.0f);
                textView.setText(adapter.getPageTitle(i2));
                textView.setAllCaps(false);
                view.setOnClickListener(bVar);
                String str = this.i.get(i2, (Object) null);
                if (str != null) {
                    view.setContentDescription(str);
                }
                this.k.addView(view);
                if (i2 == this.f2594a.getCurrentItem()) {
                    view.setSelected(true);
                }
            }
        }
    }
}

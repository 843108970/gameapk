package com.cyjh.elfin.ui.view.viewpagerindicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ywfzjbcy.R;
import mobi.oneway.export.d.e;

public class TabPageIndicator extends HorizontalScrollView implements PageIndicator {

    /* renamed from: a  reason: collision with root package name */
    private static final CharSequence f2338a = "";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Runnable f2339b;

    /* renamed from: c  reason: collision with root package name */
    private final View.OnClickListener f2340c;
    private final b d;
    /* access modifiers changed from: private */
    public ViewPager e;
    private ViewPager.OnPageChangeListener f;
    /* access modifiers changed from: private */
    public int g;
    private int h;
    /* access modifiers changed from: private */
    public a i;

    public interface a {
        void a();
    }

    private class b extends TextView {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public int f2344a;

        public b(Context context) {
            super(context, (AttributeSet) null, R.attr.vpiTabPageIndicatorStyle);
        }

        private int a() {
            return this.f2344a;
        }

        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (TabPageIndicator.this.g > 0 && getMeasuredWidth() > TabPageIndicator.this.g) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(TabPageIndicator.this.g, e.e), i2);
            }
        }
    }

    public TabPageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2340c = new View.OnClickListener() {
            public final void onClick(View view) {
                int currentItem = TabPageIndicator.this.e.getCurrentItem();
                int i = ((b) view).f2344a;
                TabPageIndicator.this.e.setCurrentItem(i);
                if (currentItem == i && TabPageIndicator.this.i != null) {
                    a unused = TabPageIndicator.this.i;
                }
            }
        };
        setHorizontalScrollBarEnabled(false);
        this.d = new b(context);
        addView(this.d, new ViewGroup.LayoutParams(-2, -1));
    }

    private void a(int i2) {
        final View childAt = this.d.getChildAt(i2);
        if (this.f2339b != null) {
            removeCallbacks(this.f2339b);
        }
        this.f2339b = new Runnable() {
            public final void run() {
                TabPageIndicator.this.smoothScrollTo(r3.getLeft() - ((TabPageIndicator.this.getWidth() - r3.getWidth()) / 2), 0);
                Runnable unused = TabPageIndicator.this.f2339b = null;
            }
        };
        post(this.f2339b);
    }

    private void a(int i2, CharSequence charSequence, int i3) {
        b bVar = new b(getContext());
        int unused = bVar.f2344a = i2;
        bVar.setFocusable(true);
        bVar.setOnClickListener(this.f2340c);
        bVar.setText(charSequence);
        if (i3 != 0) {
            bVar.setCompoundDrawablesWithIntrinsicBounds(i3, 0, 0, 0);
        }
        this.d.addView(bVar, new LinearLayout.LayoutParams(0, -1, 1.0f));
    }

    public final void a() {
        this.d.removeAllViews();
        PagerAdapter adapter = this.e.getAdapter();
        a aVar = adapter instanceof a ? (a) adapter : null;
        int count = adapter.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            CharSequence pageTitle = adapter.getPageTitle(i2);
            if (pageTitle == null) {
                pageTitle = f2338a;
            }
            int a2 = aVar != null ? aVar.a() : 0;
            b bVar = new b(getContext());
            int unused = bVar.f2344a = i2;
            bVar.setFocusable(true);
            bVar.setOnClickListener(this.f2340c);
            bVar.setText(pageTitle);
            if (a2 != 0) {
                bVar.setCompoundDrawablesWithIntrinsicBounds(a2, 0, 0, 0);
            }
            this.d.addView(bVar, new LinearLayout.LayoutParams(0, -1, 1.0f));
        }
        if (this.h > count) {
            this.h = count - 1;
        }
        setCurrentItem(this.h);
        requestLayout();
    }

    public final void a(ViewPager viewPager, int i2) {
        setViewPager(viewPager);
        setCurrentItem(i2);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2339b != null) {
            post(this.f2339b);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2339b != null) {
            removeCallbacks(this.f2339b);
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i4 = -1;
        } else if (childCount > 2) {
            i4 = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
        } else {
            this.g = View.MeasureSpec.getSize(i2) / 2;
            int measuredWidth = getMeasuredWidth();
            super.onMeasure(i2, i3);
            int measuredWidth2 = getMeasuredWidth();
            if (z && measuredWidth != measuredWidth2) {
                setCurrentItem(this.h);
                return;
            }
        }
        this.g = i4;
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i2, i3);
        int measuredWidth22 = getMeasuredWidth();
        if (z) {
        }
    }

    public void onPageScrollStateChanged(int i2) {
        if (this.f != null) {
            this.f.onPageScrollStateChanged(i2);
        }
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        if (this.f != null) {
            this.f.onPageScrolled(i2, f2, i3);
        }
    }

    public void onPageSelected(int i2) {
        setCurrentItem(i2);
        if (this.f != null) {
            this.f.onPageSelected(i2);
        }
    }

    public void setCurrentItem(int i2) {
        if (this.e == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.h = i2;
        this.e.setCurrentItem(i2);
        int childCount = this.d.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.d.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                final View childAt2 = this.d.getChildAt(i2);
                if (this.f2339b != null) {
                    removeCallbacks(this.f2339b);
                }
                this.f2339b = new Runnable() {
                    public final void run() {
                        TabPageIndicator.this.smoothScrollTo(childAt2.getLeft() - ((TabPageIndicator.this.getWidth() - childAt2.getWidth()) / 2), 0);
                        Runnable unused = TabPageIndicator.this.f2339b = null;
                    }
                };
                post(this.f2339b);
            }
            i3++;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f = onPageChangeListener;
    }

    public void setOnTabReselectedListener(a aVar) {
        this.i = aVar;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.e != viewPager) {
            if (this.e != null) {
                this.e.setOnPageChangeListener((ViewPager.OnPageChangeListener) null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.e = viewPager;
            viewPager.setOnPageChangeListener(this);
            a();
        }
    }
}

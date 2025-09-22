package com.cyjh.elfin.ui.view.viewpagerindicator;

import android.support.v4.view.ViewPager;

public interface PageIndicator extends ViewPager.OnPageChangeListener {
    void a();

    void a(ViewPager viewPager, int i);

    void setCurrentItem(int i);

    void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener);

    void setViewPager(ViewPager viewPager);
}

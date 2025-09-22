package com.cyjh.mobileanjian.ipc.uip;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import java.util.List;

public final class f extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<ScrollView> f2701a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f2702b;

    public f(List<ScrollView> list, List<String> list2) {
        this.f2701a = list;
        this.f2702b = list2;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.f2701a.get(i));
    }

    public final int getCount() {
        return this.f2701a.size();
    }

    public final CharSequence getPageTitle(int i) {
        return this.f2702b.get(i);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.f2701a.get(i);
        viewGroup.addView(view);
        return view;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}

package com.cyjh.mobileanjian.ipc.ui;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.List;

public final class l extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    List<LinearLayout> f2664a;

    /* renamed from: b  reason: collision with root package name */
    List<String> f2665b;

    public l(List<LinearLayout> list, List<String> list2) {
        this.f2664a = list;
        this.f2665b = list2;
    }

    private View a(int i) {
        return this.f2664a.get(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0007 A[LOOP:0: B:1:0x0007->B:4:0x0017, LOOP_START, PHI: r1 
      PHI: (r1v1 android.view.View) = (r1v0 android.view.View), (r1v5 android.view.View) binds: [B:0:0x0000, B:4:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View a(java.lang.String r4) {
        /*
            r3 = this;
            java.util.List<android.widget.LinearLayout> r0 = r3.f2664a
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0007:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0019
            java.lang.Object r1 = r0.next()
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            android.view.View r1 = r1.findViewWithTag(r4)
            if (r1 == 0) goto L_0x0007
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.ui.l.a(java.lang.String):android.view.View");
    }

    private void a(LinearLayout linearLayout, String str) {
        this.f2664a.add(linearLayout);
        this.f2665b.add(str);
        notifyDataSetChanged();
    }

    private void a(String str, String str2, int i, int i2) {
        for (LinearLayout next : this.f2664a) {
            if (next.getTag().equals(str2)) {
                next.addView(g.a(next.getContext()).c(str, i, i2));
            }
        }
    }

    public final void a(View view, String str, String str2) {
        for (LinearLayout next : this.f2664a) {
            if (next.getTag().equals(str)) {
                ((LinearLayout) next.findViewWithTag(str2)).addView(view);
            }
        }
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.f2664a.get(i));
    }

    public final int getCount() {
        return this.f2664a.size();
    }

    public final CharSequence getPageTitle(int i) {
        return this.f2665b.get(i);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.f2664a.get(i);
        viewGroup.addView(view);
        return view;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}

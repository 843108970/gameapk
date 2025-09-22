package com.cyjh.elfin.ui.view.customview.loadwidget.swiperefresh;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.AbsListView;

public abstract class ReHeadDefaultSwipeRefreshLayout<T> extends ReDefaultSwipeRefreshLayout {
    public ReHeadDefaultSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean canChildScrollUp() {
        if (Build.VERSION.SDK_INT >= 14) {
            return ViewCompat.canScrollVertically(this.f2335a, -1);
        }
        if (!(this.f2335a instanceof AbsListView)) {
            return this.f2335a.getScrollY() > 0;
        }
        BaseListView baseListView = this.f2335a;
        return baseListView.getChildCount() > 0 && (baseListView.getFirstVisiblePosition() > 0 || baseListView.getChildAt(0).getTop() < baseListView.getPaddingTop());
    }
}

package com.cyjh.elfin.ui.view.customview.loadwidget.swiperefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.ywfzjbcy.R;

public class FindSwipeRefreshLayout extends ReHeadDefaultSwipeRefreshLayout {
    public FindSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void f() {
        setColorSchemeResources(R.color.blue);
        this.f2335a = (BaseListView) findViewById(R.id.comm_refresh_lv);
        this.f2335a.addFooterView(new FootView(getContext()), (Object) null, false);
    }
}

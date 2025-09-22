package com.cyjh.elfin.ui.view.customview.loadwidget.swiperefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.cyjh.elfin.ui.view.customview.a.c;
import com.cyjh.elfin.ui.view.customview.a.e;

public abstract class BaseFootView extends LinearLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    protected c f2328a;

    public BaseFootView(Context context) {
        super(context);
    }

    public BaseFootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCallBack(c cVar) {
        this.f2328a = cVar;
    }
}

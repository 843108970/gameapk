package com.cyjh.elfin.ui.view.customview.loadwidget.swiperefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.cyjh.elfin.ui.view.customview.a.c;
import com.cyjh.elfin.ui.view.customview.a.e;
import com.cyjh.elfin.ui.view.customview.a.f;

public class BaseListView extends ListView implements AbsListView.OnScrollListener, e {

    /* renamed from: b  reason: collision with root package name */
    static int f2329b = 5;

    /* renamed from: a  reason: collision with root package name */
    int f2330a = 10;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2331c = false;
    private int d = f.NON$476dec0e;
    private BaseFootView e;
    private c f;
    private int g;
    private int h;
    private int i;
    private a j;

    public interface a {
        void a();

        void b();
    }

    public BaseListView(Context context) {
        super(context);
        setOnScrollListener(this);
    }

    public BaseListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnScrollListener(this);
    }

    public BaseListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setOnScrollListener(this);
    }

    private void a(int i2, int i3) {
        this.f2330a = i2;
        f2329b = i3;
        setScrollLoad(true);
    }

    private void a(View view) {
        addFooterView(view, (Object) null, false);
    }

    private void b(View view) {
        if (this.e != null) {
            BaseFootView baseFootView = this.e;
            this.e = null;
            removeFooterView(baseFootView);
        }
        addFooterView(view, (Object) null, false);
    }

    private void f() {
        setOnScrollListener(this);
    }

    private boolean g() {
        if (this.e == null) {
            return false;
        }
        BaseFootView baseFootView = this.e;
        this.e = null;
        return removeFooterView(baseFootView);
    }

    private void h() {
        if (this.i != 0) {
            if ((this.h - this.g < f2329b) && this.f != null && this.d != f.LOADING$476dec0e) {
                this.d = f.LOADING$476dec0e;
            }
        }
    }

    private void i() {
        if (this.f != null && this.d != f.LOADING$476dec0e) {
            this.d = f.LOADING$476dec0e;
        }
    }

    private boolean j() {
        return this.f2331c;
    }

    public final void a() {
        this.d = f.FAILED$476dec0e;
        if (this.e != null) {
            this.e.a();
        }
    }

    public void addFooterView(View view, Object obj, boolean z) {
        if ((view instanceof BaseFootView) && this.e == null) {
            this.e = (BaseFootView) view;
            this.e.setCallBack(this.f);
        }
        super.addFooterView(view, obj, z);
    }

    public final void b() {
        this.d = f.NON$476dec0e;
        if (this.e != null) {
            this.e.b();
        }
    }

    public final void c() {
        this.d = f.COMPLETE$476dec0e;
        if (this.e != null) {
            this.e.c();
        }
    }

    public final void d() {
        this.d = f.EMPTY$476dec0e;
        if (this.e != null) {
            this.e.d();
        }
    }

    public final void e() {
        this.d = f.NON$476dec0e;
        if (this.e != null) {
            this.e.e();
        }
    }

    public BaseFootView getFootView() {
        return this.e;
    }

    public int getPageSize() {
        return this.f2330a;
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        if (this.f2331c) {
            this.g = i2 + i3;
            this.h = i4;
            if (this.i != 0) {
                if ((this.h - this.g < f2329b) && this.f != null && this.d != f.LOADING$476dec0e) {
                    this.d = f.LOADING$476dec0e;
                }
            }
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        this.i = i2;
    }

    public boolean removeFooterView(View view) {
        if (this.e == view) {
            this.e = null;
        }
        return super.removeFooterView(view);
    }

    public void setIListViewCallBack(c cVar) {
        this.f = cVar;
        this.e.setCallBack(this.f);
    }

    public void setScrollLoad(boolean z) {
        this.f2331c = z;
    }

    public void setmListViewScrollListener(a aVar) {
        this.j = aVar;
    }
}

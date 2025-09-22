package com.cyjh.elfin.ui.view.customview.loadwidget.swiperefresh;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.cyjh.elfin.ui.view.customview.a.c;
import com.cyjh.elfin.ui.view.customview.a.e;

public abstract class ReDefaultSwipeRefreshLayout extends SwipeRefreshLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    protected BaseListView f2335a;

    /* renamed from: b  reason: collision with root package name */
    private int f2336b;

    /* renamed from: c  reason: collision with root package name */
    private float f2337c;
    private a d;

    public interface a {
        void a();
    }

    public ReDefaultSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(int i, int i2) {
        BaseListView baseListView = this.f2335a;
        baseListView.f2330a = i;
        BaseListView.f2329b = i2;
        baseListView.setScrollLoad(true);
    }

    private void a(View view) {
        this.f2335a.addHeaderView(view);
    }

    private void a(c cVar, SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        if (cVar != null) {
            this.f2335a.setIListViewCallBack(cVar);
        }
        if (onRefreshListener != null) {
            setOnRefreshListener(onRefreshListener);
        }
    }

    public final void a() {
        setRefreshing(false);
        this.f2335a.a();
    }

    public final void b() {
        setRefreshing(false);
        this.f2335a.b();
    }

    public final void c() {
        setRefreshing(false);
        this.f2335a.c();
    }

    public final void d() {
        setRefreshing(false);
        this.f2335a.d();
    }

    public final void e() {
        setRefreshing(false);
        this.f2335a.e();
    }

    public abstract void f();

    public BaseListView getListView() {
        return this.f2335a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f2337c = motionEvent.getX();
            a aVar = this.d;
        } else if (action == 2 && Math.abs(motionEvent.getX() - this.f2337c) > ((float) (this.f2336b + 60))) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        this.f2335a.setAdapter(baseAdapter);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener != null) {
            this.f2335a.setOnItemClickListener(onItemClickListener);
        }
    }

    public void setTouchCallBackListener(a aVar) {
        this.d = aVar;
    }
}

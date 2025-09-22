package com.cyjh.elfin.ui.view.customview.loadwidget.swiperefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyjh.elfin.ui.view.customview.a.c;
import com.ywfzjbcy.R;

public class FootView extends BaseFootView {

    /* renamed from: b  reason: collision with root package name */
    protected TextView f2332b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnClickListener f2333c = new View.OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == FootView.this.f2332b.getId() && FootView.this.f2328a != null) {
                FootView.this.f2332b.setText("加载中...");
                c cVar = FootView.this.f2328a;
            }
        }
    };

    public FootView(Context context) {
        super(context);
        f();
    }

    public FootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }

    private void f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        View layout = getLayout();
        layoutParams.gravity = 17;
        addView(layout, layoutParams);
        this.f2332b = (TextView) findViewById(R.id.load_empty_tv);
        this.f2332b.setOnClickListener(this.f2333c);
    }

    private static void g() {
    }

    public final void a() {
        this.f2332b.setVisibility(0);
        this.f2332b.setText("点击加载更多");
    }

    public final void b() {
        this.f2332b.setText("加载中...");
    }

    public final void c() {
        this.f2332b.setVisibility(8);
    }

    public final void d() {
        this.f2332b.setVisibility(8);
    }

    public final void e() {
        this.f2332b.setVisibility(0);
    }

    public View getLayout() {
        return LayoutInflater.from(getContext()).inflate(R.layout.foot_view, (ViewGroup) null);
    }
}

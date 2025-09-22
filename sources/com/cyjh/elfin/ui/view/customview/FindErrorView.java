package com.cyjh.elfin.ui.view.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ywfzjbcy.R;

public class FindErrorView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    protected Context f2313a;

    /* renamed from: b  reason: collision with root package name */
    protected ImageView f2314b;

    /* renamed from: c  reason: collision with root package name */
    protected TextView f2315c;
    protected TextView d;

    public FindErrorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FindErrorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FindErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2313a = context;
        ((LayoutInflater) this.f2313a.getSystemService("layout_inflater")).inflate(R.layout.view_error_layout, this);
        this.f2314b = (ImageView) findViewById(R.id.vel_error_img);
        this.f2315c = (TextView) findViewById(R.id.vel_error_tips);
        this.d = (TextView) findViewById(R.id.vel_error_btn);
    }

    private void a() {
        ((LayoutInflater) this.f2313a.getSystemService("layout_inflater")).inflate(R.layout.view_error_layout, this);
        this.f2314b = (ImageView) findViewById(R.id.vel_error_img);
        this.f2315c = (TextView) findViewById(R.id.vel_error_tips);
        this.d = (TextView) findViewById(R.id.vel_error_btn);
    }

    public void setErrorImg(int i) {
        this.f2314b.setImageResource(i);
    }

    public void setErrorTips(int i) {
        this.f2315c.setText(i);
    }
}

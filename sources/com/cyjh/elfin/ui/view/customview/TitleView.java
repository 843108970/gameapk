package com.cyjh.elfin.ui.view.customview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ywfzjbcy.R;

public class TitleView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f2316a;

    /* renamed from: b  reason: collision with root package name */
    private Context f2317b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f2318c;
    private ImageView d;
    /* access modifiers changed from: private */
    public a e;
    /* access modifiers changed from: private */
    public b f;
    /* access modifiers changed from: private */
    public c g;
    private TextView h;

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();
    }

    private class d implements View.OnClickListener {
        private d() {
        }

        /* synthetic */ d(TitleView titleView, byte b2) {
            this();
        }

        public final void onClick(View view) {
            if (TitleView.this.g != null) {
                TitleView.this.g.a();
            }
        }
    }

    private class e implements View.OnClickListener {
        private e() {
        }

        /* synthetic */ e(TitleView titleView, byte b2) {
            this();
        }

        public final void onClick(View view) {
            if (TitleView.this.e != null) {
                TitleView.this.e.a();
            }
        }
    }

    private class f implements View.OnClickListener {
        private f() {
        }

        /* synthetic */ f(TitleView titleView, byte b2) {
            this();
        }

        public final void onClick(View view) {
            if (TitleView.this.f != null) {
                TitleView.this.f.a();
            }
        }
    }

    public TitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2317b = context;
        setBackgroundColor(Color.rgb(60, 122, 197));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f2316a = new TextView(this.f2317b);
        this.f2316a.setTextColor(-1);
        this.f2316a.setTextSize(18.0f);
        this.f2316a.setGravity(16);
        this.f2316a.setSingleLine();
        addView(this.f2316a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.f2318c = new ImageView(this.f2317b);
        layoutParams2.addRule(15);
        layoutParams2.addRule(9);
        layoutParams2.setMargins(20, 10, 0, 10);
        this.f2318c.setImageResource(R.drawable.ic_setting);
        this.f2318c.setOnClickListener(new e(this, (byte) 0));
        addView(this.f2318c, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(0, 10, 20, 10);
        this.d = new ImageView(this.f2317b);
        this.d.setImageResource(R.drawable.ic_setting);
        this.d.setOnClickListener(new f(this, (byte) 0));
        addView(this.d, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        layoutParams4.setMargins(0, 10, 20, 10);
        this.h = new TextView(this.f2317b);
        this.h.setVisibility(8);
        this.h.setOnClickListener(new d(this, (byte) 0));
        this.h.setSingleLine();
        this.h.setTextSize(16.0f);
        this.h.setTextColor(-1);
        addView(this.h, layoutParams4);
    }

    private void a() {
        setBackgroundColor(Color.rgb(60, 122, 197));
    }

    private void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f2316a = new TextView(this.f2317b);
        this.f2316a.setTextColor(-1);
        this.f2316a.setTextSize(18.0f);
        this.f2316a.setGravity(16);
        this.f2316a.setSingleLine();
        addView(this.f2316a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.f2318c = new ImageView(this.f2317b);
        layoutParams2.addRule(15);
        layoutParams2.addRule(9);
        layoutParams2.setMargins(20, 10, 0, 10);
        this.f2318c.setImageResource(R.drawable.ic_setting);
        this.f2318c.setOnClickListener(new e(this, (byte) 0));
        addView(this.f2318c, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(0, 10, 20, 10);
        this.d = new ImageView(this.f2317b);
        this.d.setImageResource(R.drawable.ic_setting);
        this.d.setOnClickListener(new f(this, (byte) 0));
        addView(this.d, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        layoutParams4.setMargins(0, 10, 20, 10);
        this.h = new TextView(this.f2317b);
        this.h.setVisibility(8);
        this.h.setOnClickListener(new d(this, (byte) 0));
        this.h.setSingleLine();
        this.h.setTextSize(16.0f);
        this.h.setTextColor(-1);
        addView(this.h, layoutParams4);
    }

    public void setOnLeftImageViewListener(a aVar) {
        this.e = aVar;
    }

    public void setOnRightImageViewListener(b bVar) {
        this.f = bVar;
    }

    public void setOnRightTextViewListener(c cVar) {
        this.g = cVar;
    }

    public void setRightImage(int i) {
        this.d.setImageResource(i);
    }

    public void setRightTvText(int i) {
        this.h.setText(i);
    }

    public void setRightTvText(String str) {
        this.h.setText(str);
    }

    public void setTitleSize(int i) {
        this.f2316a.setTextSize((float) i);
    }

    public void setTitleText(int i) {
        this.f2316a.setText(i);
    }

    public void setTitleText(String str) {
        this.f2316a.setText(str);
    }

    public void setVisibilityLeftImage(int i) {
        this.f2318c.setVisibility(i);
    }

    public void setVisibilityRightImage(int i) {
        this.d.setVisibility(i);
    }

    public void setVisibilityTvRight(int i) {
        this.h.setVisibility(i);
    }

    public void setleftImage(int i) {
        this.f2318c.setImageResource(i);
    }
}

package com.cyjh.elfin.floatingwindowprocess.floatview;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyjh.common.util.a;
import com.ywfzjbcy.R;

public class DeleteFloatView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    WindowManager.LayoutParams f2038a;

    /* renamed from: b  reason: collision with root package name */
    TextView f2039b = ((TextView) findViewById(R.id.deletefloatview_textview_delete));

    /* renamed from: c  reason: collision with root package name */
    ImageView f2040c = ((ImageView) findViewById(R.id.deletefloatview_imageview_delete));
    LinearLayout d = ((LinearLayout) findViewById(R.id.deletefloatview_linearlayout));

    public DeleteFloatView(Context context) {
        super(context);
        WindowManager.LayoutParams layoutParams;
        int i;
        LayoutInflater.from(getContext()).inflate(R.layout.delete_floatview, this);
        setVisibility(8);
        this.f2038a = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.f2038a;
            i = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.f2038a;
            i = 2002;
        } else {
            layoutParams = this.f2038a;
            i = 2005;
        }
        layoutParams.type = i;
        this.f2038a.format = 1;
        this.f2038a.flags = 40;
        this.f2038a.gravity = 8388659;
        this.f2038a.x = (a.a(getContext()).x - this.d.getLayoutParams().width) / 2;
        this.f2038a.y = a.a(getContext()).y;
        this.f2038a.width = this.d.getLayoutParams().width;
        this.f2038a.height = this.d.getLayoutParams().height;
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.delete_floatview, this);
        this.f2039b = (TextView) findViewById(R.id.deletefloatview_textview_delete);
        this.f2040c = (ImageView) findViewById(R.id.deletefloatview_imageview_delete);
        this.d = (LinearLayout) findViewById(R.id.deletefloatview_linearlayout);
        setVisibility(8);
    }

    private void c() {
        WindowManager.LayoutParams layoutParams;
        int i;
        this.f2038a = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.f2038a;
            i = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.f2038a;
            i = 2002;
        } else {
            layoutParams = this.f2038a;
            i = 2005;
        }
        layoutParams.type = i;
        this.f2038a.format = 1;
        this.f2038a.flags = 40;
        this.f2038a.gravity = 8388659;
        this.f2038a.x = (a.a(getContext()).x - this.d.getLayoutParams().width) / 2;
        this.f2038a.y = a.a(getContext()).y;
        this.f2038a.width = this.d.getLayoutParams().width;
        this.f2038a.height = this.d.getLayoutParams().height;
    }

    private int d() {
        return this.d.getLayoutParams().width;
    }

    private void e() {
        this.f2040c.setImageResource(R.drawable.delete_floatview_in);
        this.f2039b.setTextColor(getResources().getColor(R.color.green));
    }

    private void f() {
        this.f2038a.x = (a.a(getContext()).x - this.d.getLayoutParams().width) / 2;
        this.f2038a.y = a.a(getContext()).y;
        ((WindowManager) getContext().getSystemService("window")).updateViewLayout(this, this.f2038a);
    }

    public final void a() {
        this.f2040c.setImageResource(R.drawable.delete_floatview_out);
        this.f2039b.setTextColor(getResources().getColor(17170443));
    }

    public WindowManager.LayoutParams getLayoutParams() {
        return this.f2038a;
    }
}

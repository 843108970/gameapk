package com.cyjh.mobileanjian.ipc.ui;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyjh.mqsdk.R;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2598a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2599b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2600c = 2;
    public static final int d = 3;
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    /* access modifiers changed from: package-private */
    public a i;
    private WindowManager j;
    private WindowManager.LayoutParams k = new WindowManager.LayoutParams();
    private View l;
    private int m;
    private int n;
    private LinearLayout o;
    private LinearLayout p;
    private Button q;
    private Button r;
    private Button s;

    public interface a {
        void a(int i);
    }

    public b(Context context, String str, final int i2, a aVar) {
        WindowManager.LayoutParams layoutParams;
        int i3;
        this.i = aVar;
        this.j = (WindowManager) context.getSystemService("window");
        this.l = LayoutInflater.from(context).inflate(R.layout.dialog_alert, (ViewGroup) null);
        ((TextView) this.l.findViewById(R.id.prompt)).setText(str);
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.k;
            i3 = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.k;
            i3 = 2002;
        } else {
            layoutParams = this.k;
            i3 = 2005;
        }
        layoutParams.type = i3;
        this.k.format = 1;
        this.k.gravity = 16;
        this.k.x = 0;
        this.k.y = 0;
        this.k.alpha = 1.0f;
        this.k.width = -1;
        this.k.height = -1;
        switch (i2) {
            case 1:
                this.l.findViewById(R.id.single_ok_button).setVisibility(8);
                this.l.findViewById(R.id.layout_type3).setVisibility(8);
                this.q = (Button) this.l.findViewById(R.id.positive_button);
                this.r = (Button) this.l.findViewById(R.id.negative_button);
                break;
            case 2:
                this.l.findViewById(R.id.single_ok_button).setVisibility(8);
                this.l.findViewById(R.id.layout_type3).setVisibility(8);
                this.q = (Button) this.l.findViewById(R.id.positive_button);
                this.r = (Button) this.l.findViewById(R.id.negative_button);
                this.q.setText(R.string.dialog_yes_button);
                this.r.setText(R.string.dialog_no_button);
                break;
            case 3:
                this.l.findViewById(R.id.single_ok_button).setVisibility(8);
                this.l.findViewById(R.id.layout_type2).setVisibility(8);
                this.q = (Button) this.l.findViewById(R.id.yes_button);
                this.r = (Button) this.l.findViewById(R.id.no_button);
                this.s = (Button) this.l.findViewById(R.id.cancel_button);
                break;
            default:
                this.l.findViewById(R.id.layout_type2).setVisibility(8);
                this.l.findViewById(R.id.layout_type3).setVisibility(8);
                this.q = (Button) this.l.findViewById(R.id.single_ok_button);
                break;
        }
        if (this.q != null) {
            this.q.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (b.this.i != null) {
                        b.this.i.a((i2 == 0 || i2 == 1) ? 0 : 2);
                    }
                    b.this.j.removeView(b.this.l);
                }
            });
        }
        if (this.r != null) {
            this.r.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (b.this.i != null) {
                        a aVar = b.this.i;
                        int i = 1;
                        if (i2 != 1) {
                            i = 3;
                        }
                        aVar.a(i);
                    }
                    b.this.j.removeView(b.this.l);
                }
            });
        }
        if (this.s != null) {
            this.s.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (b.this.i != null) {
                        b.this.i.a(1);
                    }
                    b.this.j.removeView(b.this.l);
                }
            });
        }
    }

    private void b() {
        this.j.removeView(this.l);
    }

    private void c() {
        WindowManager.LayoutParams layoutParams;
        int i2;
        this.k = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.k;
            i2 = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.k;
            i2 = 2002;
        } else {
            layoutParams = this.k;
            i2 = 2005;
        }
        layoutParams.type = i2;
        this.k.format = 1;
        this.k.gravity = 16;
        this.k.x = 0;
        this.k.y = 0;
        this.k.alpha = 1.0f;
        this.k.width = -1;
        this.k.height = -1;
    }

    public final void a() {
        this.j.addView(this.l, this.k);
    }
}

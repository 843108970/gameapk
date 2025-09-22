package com.cyjh.mobileanjian.ipc.ui;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import com.cyjh.mqsdk.R;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    View f2606a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public EditText f2607b = ((EditText) this.f2606a.findViewById(R.id.et_input));
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public a f2608c;
    WindowManager d;
    private WindowManager.LayoutParams e;

    public interface a {
        void a(String str);
    }

    public c(Context context, String str, a aVar) {
        WindowManager.LayoutParams layoutParams;
        int i;
        this.f2608c = aVar;
        this.f2606a = LayoutInflater.from(context).inflate(R.layout.dialog_input, (ViewGroup) null);
        ((TextView) this.f2606a.findViewById(R.id.prompt)).setText(str);
        this.f2606a.findViewById(R.id.single_ok_button).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (c.this.f2608c != null) {
                    c.this.f2608c.a(c.this.f2607b.getText().toString());
                }
                c cVar = c.this;
                cVar.d.removeView(cVar.f2606a);
            }
        });
        this.d = (WindowManager) context.getSystemService("window");
        this.e = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.e;
            i = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.e;
            i = 2002;
        } else {
            layoutParams = this.e;
            i = 2005;
        }
        layoutParams.type = i;
        this.e.format = 1;
        this.e.gravity = 17;
        this.e.x = 0;
        this.e.y = 0;
        this.e.alpha = 1.0f;
        this.e.width = -1;
        this.e.height = -1;
    }

    private void b() {
        this.d.removeView(this.f2606a);
    }

    private void c() {
        WindowManager.LayoutParams layoutParams;
        int i;
        this.e = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.e;
            i = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.e;
            i = 2002;
        } else {
            layoutParams = this.e;
            i = 2005;
        }
        layoutParams.type = i;
        this.e.format = 1;
        this.e.gravity = 17;
        this.e.x = 0;
        this.e.y = 0;
        this.e.alpha = 1.0f;
        this.e.width = -1;
        this.e.height = -1;
    }

    public final void a() {
        this.d.addView(this.f2606a, this.e);
    }
}

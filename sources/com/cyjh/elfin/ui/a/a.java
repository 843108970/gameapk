package com.cyjh.elfin.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.cyjh.elfin.base.AppContext;
import com.ywfzjbcy.R;

public class a extends Dialog implements com.cyjh.elfin.a.a {

    /* renamed from: a  reason: collision with root package name */
    private float f2105a = 0.8f;

    /* renamed from: b  reason: collision with root package name */
    private float f2106b = 0.8f;
    protected AppContext d;

    public a(Context context) {
        super(context, R.style.Theme_Dialog);
        this.d = (AppContext) context.getApplicationContext();
    }

    private void a() {
        a(0.5f);
    }

    private void b() {
        Point a2 = com.cyjh.common.util.a.a(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (((float) a2.x) * this.f2105a);
        attributes.height = (int) (((float) a2.y) * this.f2106b);
        getWindow().setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public final void a(float f) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = f;
        window.setAttributes(attributes);
        window.addFlags(2);
    }

    /* access modifiers changed from: protected */
    public final void a(float f, float f2) {
        this.f2105a = f;
        this.f2106b = f2;
        Point a2 = com.cyjh.common.util.a.a(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (((float) a2.x) * this.f2105a);
        attributes.height = (int) (((float) a2.y) * this.f2106b);
        getWindow().setAttributes(attributes);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(0.5f);
    }
}

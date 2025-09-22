package com.cyjh.common.d;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.cyjh.common.util.e;

public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    protected Context f1632a;

    /* renamed from: b  reason: collision with root package name */
    float f1633b = 0.8f;

    /* renamed from: c  reason: collision with root package name */
    float f1634c = 0.8f;

    public a(Context context, int i) {
        super(context, i);
        this.f1632a = context;
    }

    private void a() {
        a(0.5f);
    }

    private void b() {
        Point c2 = e.c(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (((float) c2.x) * this.f1633b);
        attributes.height = (int) (((float) c2.y) * this.f1634c);
        getWindow().setAttributes(attributes);
    }

    private void c() {
        this.f1633b = 0.8f;
        this.f1634c = 0.6f;
        Point c2 = e.c(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (((float) c2.x) * this.f1633b);
        attributes.height = (int) (((float) c2.y) * this.f1634c);
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
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(0.5f);
    }
}

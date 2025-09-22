package com.cyjh.feedback.lib.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2394a = "BaseDialog";

    /* renamed from: b  reason: collision with root package name */
    public Context f2395b;

    /* renamed from: c  reason: collision with root package name */
    private float f2396c = 0.8f;
    private float d = 0.8f;

    public a(Context context, int i) {
        super(context, i);
        this.f2395b = context;
    }

    private void a() {
        Display defaultDisplay = ((WindowManager) this.f2395b.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (((float) point.x) * this.f2396c);
        attributes.height = (int) (((float) point.y) * this.d);
        getWindow().setAttributes(attributes);
    }

    public final void a(float f) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = f;
        window.setAttributes(attributes);
        window.addFlags(2);
    }

    public final void a(float f, float f2) {
        this.f2396c = f;
        this.d = f2;
        Display defaultDisplay = ((WindowManager) this.f2395b.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (((float) point.x) * this.f2396c);
        attributes.height = (int) (((float) point.y) * this.d);
        getWindow().setAttributes(attributes);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}

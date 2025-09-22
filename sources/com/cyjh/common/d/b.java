package com.cyjh.common.d;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.cyjh.common.R;
import com.cyjh.common.util.e;
import com.cyjh.common.view.SlLoadingView;

public class b extends a implements View.OnClickListener {
    public static final String d = "b";
    private static final int f = 19;
    private static final int g = 24;
    public Context e;
    private SlLoadingView h;

    public b(Context context) {
        super(context, R.style.Theme_Dialog);
        Window window;
        int i;
        this.e = context;
        if (Build.VERSION.SDK_INT >= 26) {
            window = getWindow();
            i = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            if (getWindow() != null) {
                getWindow().setType(2002);
                return;
            }
            return;
        } else if (getWindow() != null) {
            window = getWindow();
            i = 2005;
        } else {
            return;
        }
        window.setType(i);
    }

    private void a() {
        this.h = (SlLoadingView) findViewById(R.id.slLoadingView);
        setCancelable(false);
    }

    public void dismiss() {
        super.dismiss();
    }

    public void onClick(View view) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_library_ui_loading);
        a(0.2f);
        this.f1633b = 0.8f;
        this.f1634c = 0.6f;
        Point c2 = e.c(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (((float) c2.x) * this.f1633b);
        attributes.height = (int) (((float) c2.y) * this.f1634c);
        getWindow().setAttributes(attributes);
        this.h = (SlLoadingView) findViewById(R.id.slLoadingView);
        setCancelable(false);
    }
}

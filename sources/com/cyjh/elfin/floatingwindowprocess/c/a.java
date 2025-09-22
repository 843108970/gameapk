package com.cyjh.elfin.floatingwindowprocess.c;

import android.content.Context;
import android.view.WindowManager;
import com.cyjh.common.util.ab;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.floatingwindowprocess.floatview.DeleteFloatView;
import com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f2004c = "FloatViewManager";
    private static final a e = new a();

    /* renamed from: a  reason: collision with root package name */
    public ElfinFloatView f2005a;

    /* renamed from: b  reason: collision with root package name */
    public Context f2006b;
    private WindowManager d;

    public static a a() {
        return e;
    }

    private void a(Context context) {
        this.f2006b = context;
    }

    private ElfinFloatView c() {
        return this.f2005a;
    }

    private void d() {
        this.d = (WindowManager) AppContext.a().getSystemService("window");
        DeleteFloatView deleteFloatView = new DeleteFloatView(this.f2006b);
        this.f2005a = new ElfinFloatView(this.f2006b, deleteFloatView);
        this.d.addView(deleteFloatView, deleteFloatView.getLayoutParams());
        this.d.addView(this.f2005a, this.f2005a.getLayoutParams());
        if (2 == AppContext.a().getResources().getConfiguration().orientation) {
            this.f2005a.c();
        }
    }

    private void e() {
        if (this.f2005a != null && !ab.a().b(com.cyjh.elfin.a.a.A, (Boolean) true)) {
            this.f2005a.setVisibility(8);
        }
    }

    private void f() {
        if (this.f2005a != null) {
            if (this.f2005a.getVisibility() == 0) {
                this.f2005a.setVisibility(8);
            }
            this.f2005a = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0047, code lost:
        if (2 == com.cyjh.elfin.base.AppContext.a().getResources().getConfiguration().orientation) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r3 = this;
            com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r0 = r3.f2005a
            if (r0 != 0) goto L_0x0049
            com.cyjh.elfin.base.AppContext r0 = com.cyjh.elfin.base.AppContext.a()
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            r3.d = r0
            com.cyjh.elfin.floatingwindowprocess.floatview.DeleteFloatView r0 = new com.cyjh.elfin.floatingwindowprocess.floatview.DeleteFloatView
            android.content.Context r1 = r3.f2006b
            r0.<init>(r1)
            com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r1 = new com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView
            android.content.Context r2 = r3.f2006b
            r1.<init>(r2, r0)
            r3.f2005a = r1
            android.view.WindowManager r1 = r3.d
            android.view.WindowManager$LayoutParams r2 = r0.getLayoutParams()
            r1.addView(r0, r2)
            android.view.WindowManager r0 = r3.d
            com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r1 = r3.f2005a
            com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r2 = r3.f2005a
            android.view.WindowManager$LayoutParams r2 = r2.getLayoutParams()
            r0.addView(r1, r2)
            r0 = 2
            com.cyjh.elfin.base.AppContext r1 = com.cyjh.elfin.base.AppContext.a()
            android.content.res.Resources r1 = r1.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.orientation
            if (r0 != r1) goto L_0x004e
        L_0x0049:
            com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r0 = r3.f2005a
            r0.c()
        L_0x004e:
            com.cyjh.common.util.ab r0 = com.cyjh.common.util.ab.a()
            java.lang.String r1 = "com.cyjh.elfin.ui.activity.SettingActivity.swtFloatviewCtrl"
            r2 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r0 = r0.b((java.lang.String) r1, (java.lang.Boolean) r2)
            if (r0 == 0) goto L_0x0066
            com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r0 = r3.f2005a
            r1 = 0
        L_0x0062:
            r0.setVisibility(r1)
            return
        L_0x0066:
            com.cyjh.elfin.floatingwindowprocess.floatview.ElfinFloatView r0 = r3.f2005a
            r1 = 8
            goto L_0x0062
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.floatingwindowprocess.c.a.b():void");
    }
}

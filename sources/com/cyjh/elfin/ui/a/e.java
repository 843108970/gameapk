package com.cyjh.elfin.ui.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import com.ywfzjbcy.R;

public final class e extends a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final int f2113b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2114c = 101;
    public static final String e = "first_open_float_permission";

    /* renamed from: a  reason: collision with root package name */
    a f2115a;
    private Button f;

    public interface a {
        void a(int i);
    }

    private e(Context context) {
        super(context);
    }

    public e(Context context, a aVar) {
        super(context);
        this.f2115a = aVar;
    }

    private void a() {
        this.f = (Button) findViewById(R.id.dialog_miuiguide_button_open);
        this.f.setOnClickListener(this);
    }

    private void a(a aVar) {
        this.f2115a = aVar;
    }

    private void b() {
        Point a2 = com.cyjh.common.util.a.a(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (((double) a2.x) * 0.8d);
        attributes.height = -2;
        getWindow().setAttributes(attributes);
    }

    private void c() {
        setOnDismissListener(new f(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 0
            r4 = 26
            if (r2 < r4) goto L_0x0027
        L_0x0010:
            java.lang.String r2 = "android.settings.action.MANAGE_OVERLAY_PERMISSION"
        L_0x0012:
            r1.setAction(r2)
            java.lang.String r2 = "package"
            android.content.Context r4 = r6.getContext()
            java.lang.String r4 = r4.getPackageName()
            android.net.Uri r2 = android.net.Uri.fromParts(r2, r4, r3)
            r1.setData(r2)
            goto L_0x0058
        L_0x0027:
            r4 = 23
            if (r2 < r4) goto L_0x002c
            goto L_0x0010
        L_0x002c:
            r4 = 9
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            if (r2 < r4) goto L_0x0038
            r1.addFlags(r5)
            java.lang.String r2 = "android.settings.action.MANAGE_WRITE_SETTINGS"
            goto L_0x0012
        L_0x0038:
            r3 = 8
            if (r2 > r3) goto L_0x0058
            r1.addFlags(r5)
            java.lang.String r2 = "android.intent.action.VIEW"
            r1.setAction(r2)
            java.lang.String r2 = "com.android.settings"
            java.lang.String r3 = "com.android.settings.InstalledAppDetails"
            r1.setClassName(r2, r3)
            java.lang.String r2 = "com.android.settings.ApplicationPkgName"
            android.content.Context r3 = r6.getContext()
            java.lang.String r3 = r3.getPackageName()
            r1.putExtra(r2, r3)
        L_0x0058:
            r0.startActivity(r1)
            com.cyjh.elfin.ui.a.e$a r0 = r6.f2115a
            if (r0 == 0) goto L_0x0066
            com.cyjh.elfin.ui.a.e$a r0 = r6.f2115a
            r1 = 100
            r0.a(r1)
        L_0x0066:
            com.cyjh.common.util.ab r0 = com.cyjh.common.util.ab.a()
            java.lang.String r1 = "first_open_float_permission"
            r2 = 0
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.a((java.lang.String) r1, (java.lang.Boolean) r2)
            r6.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.ui.a.e.d():void");
    }

    private Intent e() {
        String str;
        Intent intent = new Intent();
        int i = Build.VERSION.SDK_INT;
        if (i >= 26 || i >= 23) {
            str = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
        } else if (i >= 9) {
            intent.addFlags(268435456);
            str = "android.settings.action.MANAGE_WRITE_SETTINGS";
        } else {
            if (i <= 8) {
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                intent.putExtra("com.android.settings.ApplicationPkgName", getContext().getPackageName());
            }
            return intent;
        }
        intent.setAction(str);
        intent.setData(Uri.fromParts("package", getContext().getPackageName(), (String) null));
        return intent;
    }

    private /* synthetic */ void f() {
        if (this.f2115a != null) {
            this.f2115a.a(101);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r6) {
        /*
            r5 = this;
            int r6 = r6.getId()
            r0 = 2131755338(0x7f10014a, float:1.9141552E38)
            if (r6 == r0) goto L_0x000a
            return
        L_0x000a:
            android.content.Context r6 = r5.getContext()
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            r3 = 0
            if (r1 < r2) goto L_0x0031
        L_0x001a:
            java.lang.String r1 = "android.settings.action.MANAGE_OVERLAY_PERMISSION"
        L_0x001c:
            r0.setAction(r1)
            java.lang.String r1 = "package"
            android.content.Context r2 = r5.getContext()
            java.lang.String r2 = r2.getPackageName()
            android.net.Uri r1 = android.net.Uri.fromParts(r1, r2, r3)
            r0.setData(r1)
            goto L_0x0062
        L_0x0031:
            r2 = 23
            if (r1 < r2) goto L_0x0036
            goto L_0x001a
        L_0x0036:
            r2 = 9
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            if (r1 < r2) goto L_0x0042
            r0.addFlags(r4)
            java.lang.String r1 = "android.settings.action.MANAGE_WRITE_SETTINGS"
            goto L_0x001c
        L_0x0042:
            r2 = 8
            if (r1 > r2) goto L_0x0062
            r0.addFlags(r4)
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.setAction(r1)
            java.lang.String r1 = "com.android.settings"
            java.lang.String r2 = "com.android.settings.InstalledAppDetails"
            r0.setClassName(r1, r2)
            java.lang.String r1 = "com.android.settings.ApplicationPkgName"
            android.content.Context r2 = r5.getContext()
            java.lang.String r2 = r2.getPackageName()
            r0.putExtra(r1, r2)
        L_0x0062:
            r6.startActivity(r0)
            com.cyjh.elfin.ui.a.e$a r6 = r5.f2115a
            if (r6 == 0) goto L_0x0070
            com.cyjh.elfin.ui.a.e$a r6 = r5.f2115a
            r0 = 100
            r6.a(r0)
        L_0x0070:
            com.cyjh.common.util.ab r6 = com.cyjh.common.util.ab.a()
            java.lang.String r0 = "first_open_float_permission"
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r6.a((java.lang.String) r0, (java.lang.Boolean) r1)
            r5.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.ui.a.e.onClick(android.view.View):void");
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_miuifloatview);
        this.f = (Button) findViewById(R.id.dialog_miuiguide_button_open);
        this.f.setOnClickListener(this);
        Point a2 = com.cyjh.common.util.a.a(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (((double) a2.x) * 0.8d);
        attributes.height = -2;
        getWindow().setAttributes(attributes);
        setOnDismissListener(new f(this));
    }
}

package com.cyjh.mobileanjian.ipc.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.WindowManager;
import android.widget.Toast;
import com.cyjh.elfin.a.b;
import com.cyjh.mqsdk.R;
import java.util.Timer;
import java.util.TimerTask;

public class ExToast {
    public static final int LENGTH_LONG = 3500;
    public static final int LENGTH_SHORT = 2000;
    private static final int g = 51;

    /* renamed from: a  reason: collision with root package name */
    private WindowManager f2725a;

    /* renamed from: b  reason: collision with root package name */
    private WindowManager.LayoutParams f2726b;

    /* renamed from: c  reason: collision with root package name */
    private Timer f2727c;
    private Toast d;
    private boolean e;
    private int f;
    private int h;
    private int i = -1;
    private int j = -1;
    private CharSequence k;
    private int l = 2000;
    private a m = new a(this, (byte) 0);

    private class a extends TimerTask {
        private a() {
        }

        /* synthetic */ a(ExToast exToast, byte b2) {
            this();
        }

        public final void run() {
            ExToast.this.hide();
        }
    }

    public ExToast(Context context) {
        WindowManager.LayoutParams layoutParams;
        int i2;
        this.f2725a = (WindowManager) context.getSystemService("window");
        this.d = Toast.makeText(context, "", 0);
        this.f2727c = new Timer();
        this.f2726b = new WindowManager.LayoutParams();
        this.f2726b.height = -2;
        this.f2726b.width = -2;
        this.f2726b.format = -3;
        this.f2726b.windowAnimations = 16973828;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.f2726b;
            i2 = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.f2726b;
            i2 = 2002;
        } else {
            layoutParams = this.f2726b;
            i2 = 2005;
        }
        layoutParams.type = i2;
        this.f2726b.flags = 152;
        int identifier = Resources.getSystem().getIdentifier("config_toastDefaultGravity", "Integer", b.f1842b);
        this.f = identifier == 0 ? 81 : context.getResources().getInteger(identifier);
        int identifier2 = Resources.getSystem().getIdentifier("toast_y_offset", "dimen", b.f1842b);
        this.h = context.getResources().getDimensionPixelSize(identifier2 == 0 ? R.dimen.toast_y_offset : identifier2);
        this.f2726b.setTitle("Toast");
    }

    private void a(int i2, CharSequence charSequence, int i3, int i4, boolean z) {
        this.f2726b.gravity = i2;
        if (i2 == this.f) {
            this.f2726b.x = 0;
            this.f2726b.y = this.h;
        } else {
            this.f2726b.x = i3;
            this.f2726b.y = i4;
        }
        setText(charSequence);
        if (!this.e) {
            this.f2725a.addView(this.d.getView(), this.f2726b);
        } else if (z) {
            this.f2725a.updateViewLayout(this.d.getView(), this.f2726b);
        }
    }

    private void a(Context context) {
        WindowManager.LayoutParams layoutParams;
        int i2;
        this.f2726b = new WindowManager.LayoutParams();
        this.f2726b.height = -2;
        this.f2726b.width = -2;
        this.f2726b.format = -3;
        this.f2726b.windowAnimations = 16973828;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.f2726b;
            i2 = 2038;
        } else if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
            layoutParams = this.f2726b;
            i2 = 2002;
        } else {
            layoutParams = this.f2726b;
            i2 = 2005;
        }
        layoutParams.type = i2;
        this.f2726b.flags = 152;
        int identifier = Resources.getSystem().getIdentifier("config_toastDefaultGravity", "Integer", b.f1842b);
        this.f = identifier == 0 ? 81 : context.getResources().getInteger(identifier);
        int identifier2 = Resources.getSystem().getIdentifier("toast_y_offset", "dimen", b.f1842b);
        Resources resources = context.getResources();
        if (identifier2 == 0) {
            identifier2 = R.dimen.toast_y_offset;
        }
        this.h = resources.getDimensionPixelSize(identifier2);
        this.f2726b.setTitle("Toast");
    }

    public static ExToast makeText(Context context, int i2, int i3) {
        return makeText(context, (CharSequence) context.getString(i2), i3);
    }

    public static ExToast makeText(Context context, CharSequence charSequence, int i2) {
        ExToast exToast = new ExToast(context);
        exToast.setText(charSequence);
        exToast.setDuration(i2);
        return exToast;
    }

    public void hide() {
        synchronized (this.d) {
            this.m.cancel();
            if (this.d.getView().getParent() != null) {
                this.f2725a.removeView(this.d.getView());
            }
            this.e = false;
        }
    }

    public void setDuration(int i2) {
        this.l = i2;
    }

    public void setText(CharSequence charSequence) {
        this.k = charSequence;
        this.d.setText(charSequence);
    }

    public void show() {
        a(this.f, this.k, 0, 0, true);
        this.m = new a(this, (byte) 0);
        this.f2727c.schedule(this.m, 2000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0021 A[Catch:{ all -> 0x000c }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b A[Catch:{ all -> 0x000c }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004f A[ADDED_TO_REGION, Catch:{ all -> 0x000c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void show(java.lang.CharSequence r12, int r13, int r14, int r15) {
        /*
            r11 = this;
            android.widget.Toast r0 = r11.d
            monitor-enter(r0)
            r1 = 0
            r2 = 1
            if (r13 >= 0) goto L_0x000e
            int r3 = r11.i     // Catch:{ all -> 0x000c }
            if (r3 < 0) goto L_0x001c
            goto L_0x000e
        L_0x000c:
            r12 = move-exception
            goto L_0x005f
        L_0x000e:
            if (r14 >= 0) goto L_0x0014
            int r3 = r11.j     // Catch:{ all -> 0x000c }
            if (r3 < 0) goto L_0x001c
        L_0x0014:
            int r3 = r11.i     // Catch:{ all -> 0x000c }
            if (r13 != r3) goto L_0x001e
            int r3 = r11.j     // Catch:{ all -> 0x000c }
            if (r14 != r3) goto L_0x001e
        L_0x001c:
            r3 = 1
            goto L_0x001f
        L_0x001e:
            r3 = 0
        L_0x001f:
            if (r13 < 0) goto L_0x0029
            if (r14 >= 0) goto L_0x0024
            goto L_0x0029
        L_0x0024:
            r4 = 51
            r6 = 51
            goto L_0x002c
        L_0x0029:
            int r4 = r11.f     // Catch:{ all -> 0x000c }
            r6 = r4
        L_0x002c:
            r11.i = r13     // Catch:{ all -> 0x000c }
            r11.j = r14     // Catch:{ all -> 0x000c }
            com.cyjh.mobileanjian.ipc.view.ExToast$a r4 = r11.m     // Catch:{ all -> 0x000c }
            r4.cancel()     // Catch:{ all -> 0x000c }
            r10 = r3 ^ 1
            r5 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r5.a(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x000c }
            r11.e = r2     // Catch:{ all -> 0x000c }
            com.cyjh.mobileanjian.ipc.view.ExToast$a r12 = new com.cyjh.mobileanjian.ipc.view.ExToast$a     // Catch:{ all -> 0x000c }
            r12.<init>(r11, r1)     // Catch:{ all -> 0x000c }
            r11.m = r12     // Catch:{ all -> 0x000c }
            r12 = 2000(0x7d0, float:2.803E-42)
            if (r15 >= 0) goto L_0x004f
            r15 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0055
        L_0x004f:
            if (r15 < 0) goto L_0x0055
            if (r15 >= r12) goto L_0x0055
            r15 = 2000(0x7d0, float:2.803E-42)
        L_0x0055:
            java.util.Timer r12 = r11.f2727c     // Catch:{ all -> 0x000c }
            com.cyjh.mobileanjian.ipc.view.ExToast$a r13 = r11.m     // Catch:{ all -> 0x000c }
            long r14 = (long) r15     // Catch:{ all -> 0x000c }
            r12.schedule(r13, r14)     // Catch:{ all -> 0x000c }
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return
        L_0x005f:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.view.ExToast.show(java.lang.CharSequence, int, int, int):void");
    }
}

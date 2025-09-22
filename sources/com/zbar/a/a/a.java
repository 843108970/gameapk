package com.zbar.a.a;

import android.hardware.Camera;
import android.os.Handler;

public final class a implements Camera.AutoFocusCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3985a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static final long f3986b = 1500;

    /* renamed from: c  reason: collision with root package name */
    private Handler f3987c;
    private int d;

    a() {
    }

    public final void a(Handler handler, int i) {
        this.f3987c = handler;
        this.d = i;
    }

    public final void onAutoFocus(boolean z, Camera camera) {
        if (this.f3987c != null) {
            this.f3987c.sendMessageDelayed(this.f3987c.obtainMessage(this.d, Boolean.valueOf(z)), f3986b);
            this.f3987c = null;
        }
    }
}

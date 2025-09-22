package com.zbar.a.a;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;

public final class e implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3997a = "e";

    /* renamed from: b  reason: collision with root package name */
    private final b f3998b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3999c;
    private Handler d;
    private int e;

    e(b bVar, boolean z) {
        this.f3998b = bVar;
        this.f3999c = z;
    }

    public final void a(Handler handler, int i) {
        this.d = handler;
        this.e = i;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        Point point = this.f3998b.d;
        if (!this.f3999c) {
            camera.setPreviewCallback((Camera.PreviewCallback) null);
        }
        if (this.d != null) {
            this.d.obtainMessage(this.e, point.x, point.y, bArr).sendToTarget();
            this.d = null;
        }
    }
}

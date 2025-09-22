package com.cyjh.elfin.sweepcode;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ag;
import com.cyjh.elfin.base.AppContext;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b implements Camera.PreviewCallback {
    private static final String g = "CameraInterface";
    private static b h;

    /* renamed from: a  reason: collision with root package name */
    public Camera f2092a;

    /* renamed from: b  reason: collision with root package name */
    public Camera.Parameters f2093b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f2094c = false;
    /* access modifiers changed from: package-private */
    public Handler d = new Handler();
    public Camera.PreviewCallback e;
    Camera.AutoFocusCallback f = new Camera.AutoFocusCallback() {
        public final void onAutoFocus(boolean z, Camera camera) {
            b.this.d.postDelayed(b.this.i, 1000);
        }
    };
    /* access modifiers changed from: private */
    public Runnable i = new Runnable() {
        public final void run() {
            if (b.this.f2094c) {
                b.this.f2092a.autoFocus(b.this.f);
            }
        }
    };

    public interface a {
        void a();
    }

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (h == null) {
                h = new b();
            }
            bVar = h;
        }
        return bVar;
    }

    private void a(Camera.PreviewCallback previewCallback) {
        this.e = previewCallback;
    }

    private void a(SurfaceHolder surfaceHolder) {
        int i2;
        int i3;
        Camera.Size size;
        if (this.f2094c) {
            this.f2092a.stopPreview();
        } else if (this.f2092a != null) {
            try {
                this.f2093b = this.f2092a.getParameters();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f2093b == null) {
                ag.b((Context) AppContext.a(), "请检查相机是否可用或权限是否被禁用");
                return;
            }
            this.f2093b.setPictureFormat(256);
            a.a();
            a.b(this.f2093b);
            a.a();
            a.a(this.f2093b);
            int b2 = c.b(AppContext.a());
            int a2 = c.a(AppContext.a());
            List<Camera.Size> supportedPreviewSizes = this.f2093b.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null) {
                try {
                    if (!supportedPreviewSizes.isEmpty()) {
                        int i4 = 0;
                        if (supportedPreviewSizes.size() == 1) {
                            size = supportedPreviewSizes.get(0);
                            i4 = size.width;
                        } else {
                            if (supportedPreviewSizes.size() > 1) {
                                float f2 = (((float) b2) * 1.0f) / ((float) a2);
                                Collections.sort(supportedPreviewSizes, a.a().f2090a);
                                Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
                                int i5 = 0;
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    Camera.Size next = it.next();
                                    Log.i("yanzi", "ratioPreview:" + (((float) next.width) / ((float) next.height)));
                                    Log.i("yanzi", "PreviewSize:w = " + next.width + "h = " + next.height);
                                    if (next.height >= a2 && a.a(next, f2)) {
                                        Log.i("yanzi", "ratioPreview2:" + f2 + "   minH:" + a2);
                                        Log.i("yanzi", "PreviewSize:w = " + next.width + "h = " + next.height);
                                        break;
                                    }
                                    i5++;
                                }
                                if (i5 != supportedPreviewSizes.size()) {
                                    i4 = i5;
                                }
                                Camera.Size size2 = supportedPreviewSizes.get(i4);
                                int i6 = size2.width;
                                int i7 = size2.height;
                                Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        i3 = i7;
                                        break;
                                    }
                                    Camera.Size next2 = it2.next();
                                    if (next2.width >= b2 && next2.height >= a2) {
                                        int i8 = next2.width;
                                        i3 = next2.height;
                                        i6 = i8;
                                        break;
                                    }
                                }
                                if (i4 != 0) {
                                    if (i3 != 0) {
                                        i2 = i3;
                                    }
                                }
                                size = supportedPreviewSizes.get(supportedPreviewSizes.size() - 1);
                                i4 = size.width;
                            } else {
                                i2 = 0;
                            }
                            ad.c(g, "PreviewWidth:" + i4);
                            ad.c(g, "PreviewHeight:" + i2);
                            this.f2093b.setPreviewSize(i4, i2);
                            this.f2092a.setDisplayOrientation(90);
                            this.f2092a.setParameters(this.f2093b);
                            this.f2092a.setPreviewDisplay(surfaceHolder);
                            this.f2092a.setPreviewCallback(this);
                            this.f2092a.startPreview();
                            this.f2092a.autoFocus(this.f);
                            this.f2094c = true;
                            this.f2093b = this.f2092a.getParameters();
                        }
                        i2 = size.height;
                        ad.c(g, "PreviewWidth:" + i4);
                        ad.c(g, "PreviewHeight:" + i2);
                        this.f2093b.setPreviewSize(i4, i2);
                        this.f2092a.setDisplayOrientation(90);
                        this.f2092a.setParameters(this.f2093b);
                        try {
                            this.f2092a.setPreviewDisplay(surfaceHolder);
                            this.f2092a.setPreviewCallback(this);
                            this.f2092a.startPreview();
                            this.f2092a.autoFocus(this.f);
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        this.f2094c = true;
                        this.f2093b = this.f2092a.getParameters();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    private void b() {
        this.f2092a = Camera.open();
    }

    private void c() {
        try {
            this.f2092a = Camera.open();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d() {
        if (this.f2092a != null) {
            this.f2092a.stopPreview();
        }
    }

    private void e() {
        Log.e("zzz", "openLight1");
        if (this.f2092a != null) {
            Log.e("zzz", "openLight2");
            this.f2093b = this.f2092a.getParameters();
            this.f2093b.setFlashMode("torch");
            this.f2092a.setParameters(this.f2093b);
        }
    }

    private void f() {
        if (this.f2092a != null) {
            this.f2093b = this.f2092a.getParameters();
            this.f2093b.setFlashMode("off");
            this.f2092a.setParameters(this.f2093b);
        }
    }

    private void g() {
        try {
            if (this.f2092a != null) {
                this.f2092a.setPreviewCallback((Camera.PreviewCallback) null);
                this.f2092a.stopPreview();
                this.f2094c = false;
                this.f2092a.release();
                this.f2092a = null;
                this.d.removeCallbacks((Runnable) null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.e != null) {
            this.e.onPreviewFrame(bArr, camera);
        }
    }
}

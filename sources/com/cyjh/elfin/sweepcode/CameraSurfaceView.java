package com.cyjh.elfin.sweepcode;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ag;
import com.cyjh.elfin.base.AppContext;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    Context f2086a;

    /* renamed from: b  reason: collision with root package name */
    SurfaceHolder f2087b;

    public CameraSurfaceView(Context context) {
        super(context);
        this.f2086a = context;
        a();
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2086a = context;
        a();
    }

    private void a() {
        this.f2087b = getHolder();
        this.f2087b.setFormat(-2);
        this.f2087b.setType(3);
        this.f2087b.addCallback(this);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        int i4;
        int i5;
        Camera.Size size;
        if (this.f2087b.getSurface() != null) {
            try {
                b a2 = b.a();
                if (a2.f2092a != null) {
                    a2.f2092a.stopPreview();
                }
            } catch (Exception unused) {
            }
            b a3 = b.a();
            if (a3.f2094c) {
                a3.f2092a.stopPreview();
            } else if (a3.f2092a != null) {
                try {
                    a3.f2093b = a3.f2092a.getParameters();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (a3.f2093b == null) {
                    ag.b((Context) AppContext.a(), "请检查相机是否可用或权限是否被禁用");
                    return;
                }
                a3.f2093b.setPictureFormat(256);
                a.a();
                a.b(a3.f2093b);
                a.a();
                a.a(a3.f2093b);
                int b2 = c.b(AppContext.a());
                int a4 = c.a(AppContext.a());
                List<Camera.Size> supportedPreviewSizes = a3.f2093b.getSupportedPreviewSizes();
                if (supportedPreviewSizes != null) {
                    try {
                        if (!supportedPreviewSizes.isEmpty()) {
                            int i6 = 0;
                            if (supportedPreviewSizes.size() == 1) {
                                size = supportedPreviewSizes.get(0);
                                i6 = size.width;
                            } else {
                                if (supportedPreviewSizes.size() > 1) {
                                    float f = (((float) b2) * 1.0f) / ((float) a4);
                                    Collections.sort(supportedPreviewSizes, a.a().f2090a);
                                    Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
                                    int i7 = 0;
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Camera.Size next = it.next();
                                        Log.i("yanzi", "ratioPreview:" + (((float) next.width) / ((float) next.height)));
                                        Log.i("yanzi", "PreviewSize:w = " + next.width + "h = " + next.height);
                                        if (next.height >= a4 && a.a(next, f)) {
                                            Log.i("yanzi", "ratioPreview2:" + f + "   minH:" + a4);
                                            Log.i("yanzi", "PreviewSize:w = " + next.width + "h = " + next.height);
                                            break;
                                        }
                                        i7++;
                                    }
                                    if (i7 != supportedPreviewSizes.size()) {
                                        i6 = i7;
                                    }
                                    Camera.Size size2 = supportedPreviewSizes.get(i6);
                                    int i8 = size2.width;
                                    int i9 = size2.height;
                                    Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            i5 = i9;
                                            break;
                                        }
                                        Camera.Size next2 = it2.next();
                                        if (next2.width >= b2 && next2.height >= a4) {
                                            int i10 = next2.width;
                                            i5 = next2.height;
                                            i8 = i10;
                                            break;
                                        }
                                    }
                                    if (i6 != 0) {
                                        if (i5 != 0) {
                                            i4 = i5;
                                        }
                                    }
                                    size = supportedPreviewSizes.get(supportedPreviewSizes.size() - 1);
                                    i6 = size.width;
                                } else {
                                    i4 = 0;
                                }
                                ad.c("CameraInterface", "PreviewWidth:" + i6);
                                ad.c("CameraInterface", "PreviewHeight:" + i4);
                                a3.f2093b.setPreviewSize(i6, i4);
                                a3.f2092a.setDisplayOrientation(90);
                                a3.f2092a.setParameters(a3.f2093b);
                                a3.f2092a.setPreviewDisplay(surfaceHolder);
                                a3.f2092a.setPreviewCallback(a3);
                                a3.f2092a.startPreview();
                                a3.f2092a.autoFocus(a3.f);
                                a3.f2094c = true;
                                a3.f2093b = a3.f2092a.getParameters();
                            }
                            i4 = size.height;
                            ad.c("CameraInterface", "PreviewWidth:" + i6);
                            ad.c("CameraInterface", "PreviewHeight:" + i4);
                            a3.f2093b.setPreviewSize(i6, i4);
                            a3.f2092a.setDisplayOrientation(90);
                            a3.f2092a.setParameters(a3.f2093b);
                            try {
                                a3.f2092a.setPreviewDisplay(surfaceHolder);
                                a3.f2092a.setPreviewCallback(a3);
                                a3.f2092a.startPreview();
                                a3.f2092a.autoFocus(a3.f);
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            a3.f2094c = true;
                            a3.f2093b = a3.f2092a.getParameters();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            b.a().f2092a = Camera.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        b a2 = b.a();
        try {
            if (a2.f2092a != null) {
                a2.f2092a.setPreviewCallback((Camera.PreviewCallback) null);
                a2.f2092a.stopPreview();
                a2.f2094c = false;
                a2.f2092a.release();
                a2.f2092a = null;
                a2.d.removeCallbacks((Runnable) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.cyjh.mobileanjian.screencap;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.WindowManager;
import com.cyjh.mq.d.f;
import java.nio.ByteBuffer;

@TargetApi(21)
public final class ScreenShoterV3 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2741a = "ScreenShoterV3";

    /* renamed from: b  reason: collision with root package name */
    private Context f2742b;

    /* renamed from: c  reason: collision with root package name */
    private MediaProjection f2743c;
    private Object d;
    private HandlerThread e;
    private Handler f;
    private Intent g;
    /* access modifiers changed from: private */
    public ImageReader h;
    private VirtualDisplay i;
    /* access modifiers changed from: private */
    public ScreenShotImage j;
    /* access modifiers changed from: private */
    public Bitmap k;
    private int l;
    private int m;
    private int n;
    private int o;
    /* access modifiers changed from: private */
    public boolean p;
    private boolean q;
    /* access modifiers changed from: private */
    public volatile boolean r;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final ScreenShoterV3 f2745a = new ScreenShoterV3((byte) 0);

        private a() {
        }
    }

    private ScreenShoterV3() {
        this.d = new Object();
        this.p = false;
        this.q = false;
        this.r = false;
    }

    /* synthetic */ ScreenShoterV3(byte b2) {
        this();
    }

    private Bitmap a(int i2, int i3) throws IllegalStateException {
        Image acquireLatestImage = this.h.acquireLatestImage();
        if (acquireLatestImage == null) {
            return this.k;
        }
        Bitmap a2 = a(acquireLatestImage, i2, i3);
        this.k = a2;
        return a2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(android.media.Image r8, int r9, int r10) {
        /*
            int r0 = r8.getWidth()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            int r1 = r8.getHeight()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            android.media.Image$Plane[] r2 = r8.getPlanes()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r3 = 0
            r4 = r2[r3]     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            java.nio.ByteBuffer r4 = r4.getBuffer()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r5 = r2[r3]     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            int r5 = r5.getPixelStride()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r2 = r2[r3]     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            int r2 = r2.getRowStride()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            int r6 = r5 * r0
            int r2 = r2 - r6
            int r2 = r2 / r5
            int r2 = r2 + r0
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r2, r1, r5)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r2.copyPixelsFromBuffer(r4)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            if (r0 <= r1) goto L_0x007f
            if (r2 == 0) goto L_0x007f
            android.graphics.Matrix r0 = new android.graphics.Matrix     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r0.<init>()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r1 = 1119092736(0x42b40000, float:90.0)
            int r4 = r2.getWidth()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r5 = 2
            int r4 = r4 / r5
            float r4 = (float) r4     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            int r6 = r2.getHeight()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            int r6 = r6 / r5
            float r6 = (float) r6     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r0.setRotate(r1, r4, r6)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            int r1 = r2.getHeight()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            float r1 = (float) r1     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r4 = 9
            float[] r4 = new float[r4]     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r0.getValues(r4)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r5 = r4[r5]     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r6 = 5
            r4 = r4[r6]     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            float r1 = r1 - r5
            r5 = 0
            float r5 = r5 - r4
            r0.postTranslate(r1, r5)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            int r1 = r2.getHeight()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            int r4 = r2.getWidth()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1, r4, r5)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            android.graphics.Paint r4 = new android.graphics.Paint     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r4.<init>()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            android.graphics.Canvas r5 = new android.graphics.Canvas     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r5.drawBitmap(r2, r0, r4)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r2.recycle()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r7 = r1
            goto L_0x0080
        L_0x007f:
            r7 = r2
        L_0x0080:
            if (r9 != 0) goto L_0x0087
            if (r10 == 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            r9 = r7
            goto L_0x00bc
        L_0x0087:
            int r9 = r7.getWidth()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            int r0 = r7.getHeight()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            java.lang.String r1 = "ScreenShoterV3"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            java.lang.String r4 = "load bitmap info return  1 width="
            r2.<init>(r4)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r2.append(r9)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            java.lang.String r4 = " height = "
            r2.append(r4)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r2.append(r0)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            android.util.Log.e(r1, r2)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r1 = 0
            int r3 = r9 + 0
            int r9 = r10 * 2
            int r4 = r0 - r9
            r5 = 0
            r6 = 0
            r0 = r7
            r2 = r10
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r7.recycle()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
        L_0x00bc:
            int r10 = r9.getWidth()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            int r0 = r9.getHeight()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            java.lang.String r1 = "ScreenShoterV3"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            java.lang.String r3 = "load bitmap info return  2 width="
            r2.<init>(r3)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r2.append(r10)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            java.lang.String r10 = " height = "
            r2.append(r10)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            r2.append(r0)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            java.lang.String r10 = r2.toString()     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            android.util.Log.e(r1, r10)     // Catch:{ Exception -> 0x00ec, all -> 0x00e5 }
            if (r8 == 0) goto L_0x00e4
            r8.close()
        L_0x00e4:
            return r9
        L_0x00e5:
            r9 = move-exception
            if (r8 == 0) goto L_0x00eb
            r8.close()
        L_0x00eb:
            throw r9
        L_0x00ec:
            if (r8 == 0) goto L_0x00f1
            r8.close()
        L_0x00f1:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.screencap.ScreenShoterV3.a(android.media.Image, int, int):android.graphics.Bitmap");
    }

    private ScreenShotImage a() throws IllegalStateException {
        Image acquireLatestImage = this.h.acquireLatestImage();
        if (acquireLatestImage == null) {
            return this.j;
        }
        ScreenShotImage b2 = b(acquireLatestImage);
        this.j = b2;
        return b2;
    }

    /* access modifiers changed from: private */
    public ScreenShotImage b(Image image) {
        try {
            ScreenShotImage screenShotImage = new ScreenShotImage();
            int width = image.getWidth();
            int height = image.getHeight();
            Image.Plane[] planes = image.getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            int rowStride = planes[0].getRowStride();
            int pixelStride = planes[0].getPixelStride();
            byte[] bArr = new byte[buffer.capacity()];
            buffer.get(bArr);
            screenShotImage.width = width;
            screenShotImage.height = height;
            screenShotImage.rotation = this.o;
            screenShotImage.rowStride = rowStride;
            screenShotImage.pixelStride = pixelStride;
            screenShotImage.data = bArr;
            if (image != null) {
                image.close();
            }
            return screenShotImage;
        } catch (Exception unused) {
            if (image == null) {
                return null;
            }
            image.close();
            return null;
        } catch (Throwable th) {
            if (image != null) {
                image.close();
            }
            throw th;
        }
    }

    private synchronized void b() {
        recycler();
        updateScreenSize();
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) this.f2742b.getSystemService("media_projection");
        if (this.f2743c == null && mediaProjectionManager != null) {
            this.f2743c = mediaProjectionManager.getMediaProjection(-1, this.g);
        }
        this.e = new HandlerThread("imageReaderHandler");
        this.e.start();
        this.f = new Handler(this.e.getLooper());
        f.a a2 = f.a("getprop phone.id");
        this.h = (a2.f2783b == null || a2.f2783b.length() <= 0) ? ImageReader.newInstance(this.l, this.m, 1, 3) : ImageReader.newInstance(this.l, this.m, 2, 3);
        this.i = this.f2743c.createVirtualDisplay("screen-mirror", this.l, this.m, this.n, 16, this.h.getSurface(), (VirtualDisplay.Callback) null, (Handler) null);
        this.p = true;
        if (this.h != null) {
            this.h.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
                public final void onImageAvailable(ImageReader imageReader) {
                    if (ScreenShoterV3.this.p) {
                        Image acquireLatestImage = ScreenShoterV3.this.h.acquireLatestImage();
                        if (acquireLatestImage != null) {
                            ScreenShotImage unused = ScreenShoterV3.this.j = ScreenShoterV3.this.b(acquireLatestImage);
                            Bitmap unused2 = ScreenShoterV3.this.k = ScreenShoterV3.a(acquireLatestImage, 0, 0);
                            boolean unused3 = ScreenShoterV3.this.r = true;
                            boolean unused4 = ScreenShoterV3.this.p = false;
                            if (ScreenShoterV3.this.h != null) {
                                ScreenShoterV3.this.h.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
                                return;
                            }
                            return;
                        }
                        boolean unused5 = ScreenShoterV3.this.r = false;
                    }
                }
            }, this.f);
        }
    }

    private boolean c() {
        return this.r;
    }

    public static synchronized ScreenShoterV3 getInstance() {
        ScreenShoterV3 a2;
        synchronized (ScreenShoterV3.class) {
            a2 = a.f2745a;
        }
        return a2;
    }

    public final void init(Context context, Intent intent) {
        if (!this.q) {
            this.q = true;
            this.f2742b = context.getApplicationContext();
            this.g = intent;
            this.n = Resources.getSystem().getDisplayMetrics().densityDpi;
        }
    }

    public final void init(Context context, Intent intent, MediaProjection mediaProjection) {
        if (!this.q) {
            this.q = true;
            this.f2742b = context.getApplicationContext();
            this.g = intent;
            this.n = Resources.getSystem().getDisplayMetrics().densityDpi;
            this.f2743c = mediaProjection;
        }
    }

    public final boolean isInited() {
        return this.q;
    }

    public final ScreenShotImage obtainScreenShotImage() {
        ScreenShotImage a2;
        if (this.r) {
            try {
                return a();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
        synchronized (this.d) {
            b();
            int i2 = 0;
            while (!this.r && (i2 = i2 + 1) < 50) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
            a2 = a();
        }
        return a2;
    }

    public final Bitmap obtainScreenShotImageReturnBitmap(int i2, int i3) {
        Bitmap a2;
        if (this.r) {
            try {
                return a(i2, i3);
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
        synchronized (this.d) {
            b();
            int i4 = 0;
            while (!this.r && (i4 = i4 + 1) < 50) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
            a2 = a(i2, i3);
        }
        return a2;
    }

    public final void recycler() {
        this.r = false;
        this.p = false;
        this.m = 0;
        this.l = 0;
        this.o = 0;
        synchronized (this.d) {
            if (this.e != null) {
                this.e.quit();
                this.e = null;
            }
            if (this.f != null) {
                this.f.removeCallbacksAndMessages((Object) null);
                this.f = null;
            }
            if (this.f2743c != null) {
                this.f2743c.stop();
                this.f2743c = null;
            }
            if (this.i != null) {
                this.i.release();
                this.i = null;
            }
            if (this.h != null) {
                this.h.close();
                this.h = null;
            }
        }
    }

    public final void updateScreenSize() {
        WindowManager windowManager;
        if (this.q) {
            int i2 = 0;
            this.r = false;
            int[] a2 = a.a(this.f2742b);
            int i3 = a2[0];
            int i4 = a2[1];
            Context context = this.f2742b;
            if (!(context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null)) {
                i2 = windowManager.getDefaultDisplay().getRotation();
            }
            this.o = i2;
            if (this.l != i3 || this.m != i4) {
                this.l = i3;
                this.m = i4;
            }
        }
    }
}

package com.zbar.a.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.cyjh.elfin.a.b;
import com.ywfzjbcy.R;
import java.io.IOException;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    static final int f3991a;
    private static c j;

    /* renamed from: b  reason: collision with root package name */
    public final b f3992b;

    /* renamed from: c  reason: collision with root package name */
    public Camera f3993c;
    public boolean d;
    public boolean e;
    public final boolean f;
    public final e g;
    public final a h;
    public Camera.Parameters i;

    static {
        int i2;
        try {
            i2 = Build.VERSION.SDK_INT;
        } catch (NumberFormatException unused) {
            i2 = b.ak;
        }
        f3991a = i2;
    }

    private c(Context context) {
        this.f3992b = new b(context);
        this.f = f3991a > 3;
        this.g = new e(this.f3992b, this.f);
        this.h = new a();
    }

    public static c a() {
        return j;
    }

    public static void a(Context context) {
        if (j == null) {
            j = new c(context);
        }
    }

    private void a(SurfaceHolder surfaceHolder) throws IOException {
        if (this.f3993c == null) {
            this.f3993c = Camera.open();
            if (this.f3993c == null) {
                throw new IOException();
            }
            this.f3993c.setPreviewDisplay(surfaceHolder);
            if (!this.d) {
                this.d = true;
                b bVar = this.f3992b;
                Camera.Parameters parameters = this.f3993c.getParameters();
                bVar.e = parameters.getPreviewFormat();
                bVar.f = parameters.get("preview-format");
                Display defaultDisplay = ((WindowManager) bVar.f3989b.getSystemService("window")).getDefaultDisplay();
                bVar.f3990c = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
                Point point = new Point();
                point.x = bVar.f3990c.x;
                point.y = bVar.f3990c.y;
                if (bVar.f3990c.x < bVar.f3990c.y) {
                    point.x = bVar.f3990c.y;
                    point.y = bVar.f3990c.x;
                }
                String str = parameters.get("preview-size-values");
                if (str == null) {
                    str = parameters.get("preview-size-value");
                }
                Point point2 = null;
                if (str != null) {
                    point2 = b.a((CharSequence) str, point);
                }
                if (point2 == null) {
                    point2 = new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
                }
                bVar.d = point2;
            }
            b bVar2 = this.f3992b;
            Camera camera = this.f3993c;
            Camera.Parameters parameters2 = camera.getParameters();
            parameters2.setPreviewSize(bVar2.d.x, bVar2.d.y);
            if (!Build.MODEL.contains("Behold II") || f3991a != 3) {
                parameters2.set("flash-value", 2);
            } else {
                parameters2.set("flash-value", 1);
            }
            parameters2.set("flash-mode", "off");
            String str2 = parameters2.get("zoom-supported");
            if (str2 == null || Boolean.parseBoolean(str2)) {
                String str3 = parameters2.get("max-zoom");
                int i2 = 27;
                if (str3 != null) {
                    try {
                        int parseDouble = (int) (Double.parseDouble(str3) * 10.0d);
                        if (27 > parseDouble) {
                            i2 = parseDouble;
                        }
                    } catch (NumberFormatException unused) {
                        String str4 = b.f3988a;
                        Log.w(str4, "Bad max-zoom: " + str3);
                    }
                }
                String str5 = parameters2.get("taking-picture-zoom-max");
                if (str5 != null) {
                    try {
                        int parseInt = Integer.parseInt(str5);
                        if (i2 > parseInt) {
                            i2 = parseInt;
                        }
                    } catch (NumberFormatException unused2) {
                        String str6 = b.f3988a;
                        Log.w(str6, "Bad taking-picture-zoom-max: " + str5);
                    }
                }
                String str7 = parameters2.get("mot-zoom-values");
                if (str7 != null) {
                    i2 = b.a((CharSequence) str7, i2);
                }
                String str8 = parameters2.get("mot-zoom-step");
                if (str8 != null) {
                    try {
                        int parseDouble2 = (int) (Double.parseDouble(str8.trim()) * 10.0d);
                        if (parseDouble2 > 1) {
                            i2 -= i2 % parseDouble2;
                        }
                    } catch (NumberFormatException unused3) {
                    }
                }
                if (!(str3 == null && str7 == null)) {
                    parameters2.set("zoom", String.valueOf(((double) i2) / 10.0d));
                }
                if (str5 != null) {
                    parameters2.set("taking-picture-zoom", i2);
                }
            }
            camera.setDisplayOrientation(90);
            camera.setParameters(parameters2);
            d.a();
        }
    }

    private Point b() {
        return this.f3992b.d;
    }

    private void c() {
        if (this.f3993c != null) {
            d.b();
            this.f3993c.release();
            this.f3993c = null;
        }
    }

    private void d() {
        if (this.f3993c != null && !this.e) {
            this.f3993c.startPreview();
            this.e = true;
        }
    }

    private void e() {
        if (this.f3993c != null && this.e) {
            if (!this.f) {
                this.f3993c.setPreviewCallback((Camera.PreviewCallback) null);
            }
            this.f3993c.stopPreview();
            this.g.a((Handler) null, 0);
            this.h.a((Handler) null, 0);
            this.e = false;
        }
    }

    private void f() {
        Log.e("zzz", "openLight1");
        if (this.f3993c != null) {
            Log.e("zzz", "openLight2");
            this.i = this.f3993c.getParameters();
            this.i.setFlashMode("torch");
            this.f3993c.setParameters(this.i);
        }
    }

    private void g() {
        if (this.f3993c != null) {
            this.i = this.f3993c.getParameters();
            this.i.setFlashMode("off");
            this.f3993c.setParameters(this.i);
        }
    }

    public final void a(Handler handler) {
        if (this.f3993c != null && this.e) {
            this.g.a(handler, R.id.decode);
            if (this.f) {
                this.f3993c.setOneShotPreviewCallback(this.g);
            } else {
                this.f3993c.setPreviewCallback(this.g);
            }
        }
    }

    public final void b(Handler handler) {
        if (this.f3993c != null && this.e) {
            this.h.a(handler, R.id.auto_focus);
            this.f3993c.autoFocus(this.h);
        }
    }
}

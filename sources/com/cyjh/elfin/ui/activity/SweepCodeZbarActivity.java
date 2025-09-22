package com.cyjh.elfin.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ag;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.sweepcode.CameraSurfaceView;
import com.cyjh.elfin.sweepcode.b;
import com.cyjh.elfin.sweepcode.c;
import com.cyjh.elfin.sweepcode.d;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.ywfzjbcy.R;
import java.io.PrintStream;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;

public class SweepCodeZbarActivity extends BaseActivity implements d.a {

    /* renamed from: b  reason: collision with root package name */
    public static final String f2195b = "SWEEP_RESULT_BACK";

    /* renamed from: c  reason: collision with root package name */
    public static final int f2196c = 99;
    public static final int d = 100;
    private static final int i = 17;
    private static final int j = 18;
    d e;
    public boolean f = false;
    Camera.PreviewCallback g = new Camera.PreviewCallback() {
        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            SweepCodeZbarActivity sweepCodeZbarActivity = SweepCodeZbarActivity.this;
            RelativeLayout a2 = SweepCodeZbarActivity.this.l;
            if (!sweepCodeZbarActivity.f && sweepCodeZbarActivity.e != null) {
                sweepCodeZbarActivity.f = true;
                d dVar = sweepCodeZbarActivity.e;
                try {
                    if (dVar.f2098b == null || !dVar.f2098b.f2102a) {
                        Camera.Size previewSize = camera.getParameters().getPreviewSize();
                        Image image = new Image(previewSize.width, previewSize.height, "Y800");
                        int a3 = c.a(AppContext.a());
                        c.b(AppContext.a());
                        float f = (float) ((((double) a3) * 1.0d) / ((double) previewSize.height));
                        image.setData(bArr);
                        image.setCrop((int) (((float) a2.getTop()) / f), (int) (((float) a2.getLeft()) / f), (int) (((float) a2.getBottom()) / f), (int) (((float) a2.getRight()) / f));
                        dVar.f2098b = new d.b(image, sweepCodeZbarActivity);
                        dVar.f2098b.start();
                        return;
                    }
                    throw new Exception();
                } catch (Exception unused) {
                    if (sweepCodeZbarActivity != null) {
                        sweepCodeZbarActivity.a();
                    }
                }
            }
        }
    };
    boolean h = true;
    private RelativeLayout k = null;
    /* access modifiers changed from: private */
    public RelativeLayout l = null;
    private ImageView m;
    private FrameLayout n = null;
    private final Handler o = new Handler() {
        public final void handleMessage(Message message) {
            if (message.what == 17) {
                try {
                    SweepCodeZbarActivity.a(SweepCodeZbarActivity.this, (String) message.obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    SweepCodeZbarActivity.this.f = false;
                }
            }
        }
    };

    private class a implements TitleView.a {
        private a() {
        }

        /* synthetic */ a(SweepCodeZbarActivity sweepCodeZbarActivity, byte b2) {
            this();
        }

        public final void a() {
            SweepCodeZbarActivity.this.finish();
        }
    }

    static /* synthetic */ void a(SweepCodeZbarActivity sweepCodeZbarActivity, String str) {
        PrintStream printStream = System.out;
        printStream.println("result:" + str);
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra("SWEEP_RESULT_BACK", str);
            sweepCodeZbarActivity.setResult(-1, intent);
            sweepCodeZbarActivity.finish();
            return;
        }
        ag.b((Context) sweepCodeZbarActivity, (int) R.string.sweep_error_tips);
    }

    private void a(byte[] bArr, Camera camera, View view) {
        if (!this.f && this.e != null) {
            this.f = true;
            d dVar = this.e;
            try {
                if (dVar.f2098b == null || !dVar.f2098b.f2102a) {
                    Camera.Size previewSize = camera.getParameters().getPreviewSize();
                    Image image = new Image(previewSize.width, previewSize.height, "Y800");
                    int a2 = c.a(AppContext.a());
                    c.b(AppContext.a());
                    float f2 = (float) ((((double) a2) * 1.0d) / ((double) previewSize.height));
                    image.setData(bArr);
                    image.setCrop((int) (((float) view.getTop()) / f2), (int) (((float) view.getLeft()) / f2), (int) (((float) view.getBottom()) / f2), (int) (((float) view.getRight()) / f2));
                    dVar.f2098b = new d.b(image, this);
                    dVar.f2098b.start();
                    return;
                }
                throw new Exception();
            } catch (Exception unused) {
                if (this != null) {
                    a();
                }
            }
        }
    }

    private void b() {
        this.e = new d();
        d dVar = this.e;
        dVar.f2097a = new ImageScanner();
        dVar.f2097a.setConfig(0, 256, 3);
        dVar.f2097a.setConfig(0, 257, 3);
    }

    private void b(String str) {
        PrintStream printStream = System.out;
        printStream.println("result:" + str);
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra("SWEEP_RESULT_BACK", str);
            setResult(-1, intent);
            finish();
            return;
        }
        ag.b((Context) this, (int) R.string.sweep_error_tips);
    }

    private void c() {
        TitleView titleView = (TitleView) findViewById(R.id.id_title);
        titleView.setTitleText(getString(R.string.sweep_code_register_code));
        titleView.setVisibilityRightImage(4);
        titleView.setleftImage(R.drawable.ic_back);
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
    }

    private void d() {
        this.n = (FrameLayout) findViewById(R.id.capture_preview);
        this.k = (RelativeLayout) findViewById(R.id.capture_containter);
        this.l = (RelativeLayout) findViewById(R.id.capture_crop_layout);
        int i2 = getResources().getDisplayMetrics().widthPixels;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
        int i3 = (i2 * 2) / 3;
        layoutParams.width = i3;
        layoutParams.height = i3;
        this.l.setLayoutParams(layoutParams);
        this.m = (ImageView) findViewById(R.id.capture_scan_line);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 0.0f, 2, 0.9f);
        translateAnimation.setDuration(1500);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.m.setAnimation(translateAnimation);
        ((LinearLayout) findViewById(R.id.linear_open_light)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SweepCodeZbarActivity sweepCodeZbarActivity = SweepCodeZbarActivity.this;
                if (sweepCodeZbarActivity.h) {
                    sweepCodeZbarActivity.h = false;
                    b a2 = b.a();
                    Log.e("zzz", "openLight1");
                    if (a2.f2092a != null) {
                        Log.e("zzz", "openLight2");
                        a2.f2093b = a2.f2092a.getParameters();
                        a2.f2093b.setFlashMode("torch");
                        a2.f2092a.setParameters(a2.f2093b);
                        return;
                    }
                    return;
                }
                sweepCodeZbarActivity.h = true;
                b a3 = b.a();
                if (a3.f2092a != null) {
                    a3.f2093b = a3.f2092a.getParameters();
                    a3.f2093b.setFlashMode("off");
                    a3.f2092a.setParameters(a3.f2093b);
                }
            }
        });
    }

    private void e() {
        if (this.h) {
            this.h = false;
            b a2 = b.a();
            Log.e("zzz", "openLight1");
            if (a2.f2092a != null) {
                Log.e("zzz", "openLight2");
                a2.f2093b = a2.f2092a.getParameters();
                a2.f2093b.setFlashMode("torch");
                a2.f2092a.setParameters(a2.f2093b);
                return;
            }
            return;
        }
        this.h = true;
        b a3 = b.a();
        if (a3.f2092a != null) {
            a3.f2093b = a3.f2092a.getParameters();
            a3.f2093b.setFlashMode("off");
            a3.f2092a.setParameters(a3.f2093b);
        }
    }

    private void f() {
        this.e = new d();
        d dVar = this.e;
        dVar.f2097a = new ImageScanner();
        dVar.f2097a.setConfig(0, 256, 3);
        dVar.f2097a.setConfig(0, 257, 3);
    }

    private void g() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 99);
    }

    private void h() {
        this.n.addView(new CameraSurfaceView(this));
        b.a().e = this.g;
    }

    public final void a() {
        this.f = false;
    }

    public final void a(String str) {
        Message obtainMessage = this.o.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 17;
        this.o.sendMessage(obtainMessage);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sweep_code_zbar);
        TitleView titleView = (TitleView) findViewById(R.id.id_title);
        titleView.setTitleText(getString(R.string.sweep_code_register_code));
        titleView.setVisibilityRightImage(4);
        titleView.setleftImage(R.drawable.ic_back);
        boolean z = false;
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
        this.n = (FrameLayout) findViewById(R.id.capture_preview);
        this.k = (RelativeLayout) findViewById(R.id.capture_containter);
        this.l = (RelativeLayout) findViewById(R.id.capture_crop_layout);
        int i2 = getResources().getDisplayMetrics().widthPixels;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
        int i3 = (i2 * 2) / 3;
        layoutParams.width = i3;
        layoutParams.height = i3;
        this.l.setLayoutParams(layoutParams);
        this.m = (ImageView) findViewById(R.id.capture_scan_line);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 0.0f, 2, 0.9f);
        translateAnimation.setDuration(1500);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.m.setAnimation(translateAnimation);
        ((LinearLayout) findViewById(R.id.linear_open_light)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SweepCodeZbarActivity sweepCodeZbarActivity = SweepCodeZbarActivity.this;
                if (sweepCodeZbarActivity.h) {
                    sweepCodeZbarActivity.h = false;
                    b a2 = b.a();
                    Log.e("zzz", "openLight1");
                    if (a2.f2092a != null) {
                        Log.e("zzz", "openLight2");
                        a2.f2093b = a2.f2092a.getParameters();
                        a2.f2093b.setFlashMode("torch");
                        a2.f2092a.setParameters(a2.f2093b);
                        return;
                    }
                    return;
                }
                sweepCodeZbarActivity.h = true;
                b a3 = b.a();
                if (a3.f2092a != null) {
                    a3.f2093b = a3.f2092a.getParameters();
                    a3.f2093b.setFlashMode("off");
                    a3.f2092a.setParameters(a3.f2093b);
                }
            }
        });
        this.e = new d();
        d dVar = this.e;
        dVar.f2097a = new ImageScanner();
        dVar.f2097a.setConfig(0, 256, 3);
        dVar.f2097a.setConfig(0, 257, 3);
        if (ActivityCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
            z = true;
        }
        if (!z) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 99);
        } else {
            h();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.o.removeCallbacksAndMessages((Object) null);
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        ad.c("TAG", "onRequestPermissionsResult --> permissions[0]=" + strArr[0] + ",grantResults[0]=" + iArr[0]);
        if (i2 == 99) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                finish();
            } else {
                h();
            }
        }
    }
}

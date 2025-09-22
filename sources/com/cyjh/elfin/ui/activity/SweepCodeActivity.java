package com.cyjh.elfin.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.cyjh.common.base.activity.BaseActivity;
import com.cyjh.common.util.ag;
import com.cyjh.elfin.ui.view.customview.TitleView;
import com.umeng.analytics.MobclickAgent;
import com.ywfzjbcy.R;
import com.zbar.a.a.b;
import com.zbar.a.a.c;
import com.zbar.a.a.d;
import com.zbar.a.b.a;
import com.zbar.a.b.e;
import java.io.IOException;

public class SweepCodeActivity extends BaseActivity implements SurfaceHolder.Callback {

    /* renamed from: b  reason: collision with root package name */
    public static final String f2190b = "SWEEP_RESULT_BACK";
    private static final float o = 0.5f;
    private static final long s = 200;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f2191c;
    public com.zbar.a.b.a d;
    public e e;
    public boolean f = false;
    public boolean g;
    public boolean h;
    public MediaPlayer i;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    boolean n = true;
    private RelativeLayout p = null;
    private RelativeLayout q = null;
    private boolean r;
    private final MediaPlayer.OnCompletionListener t = new MediaPlayer.OnCompletionListener() {
        public final void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };

    private class a implements TitleView.a {
        private a() {
        }

        /* synthetic */ a(SweepCodeActivity sweepCodeActivity, byte b2) {
            this();
        }

        public final void a() {
            SweepCodeActivity.this.finish();
        }
    }

    private void a(int i2) {
        this.j = i2;
    }

    private void a(SurfaceHolder surfaceHolder) {
        try {
            c a2 = c.a();
            if (a2.f3993c == null) {
                a2.f3993c = Camera.open();
                if (a2.f3993c == null) {
                    throw new IOException();
                }
                a2.f3993c.setPreviewDisplay(surfaceHolder);
                if (!a2.d) {
                    a2.d = true;
                    b bVar = a2.f3992b;
                    Camera.Parameters parameters = a2.f3993c.getParameters();
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
                    bVar.d = b.a(parameters, point);
                }
                b bVar2 = a2.f3992b;
                Camera camera = a2.f3993c;
                Camera.Parameters parameters2 = camera.getParameters();
                parameters2.setPreviewSize(bVar2.d.x, bVar2.d.y);
                b.a(parameters2);
                b.b(parameters2);
                camera.setDisplayOrientation(90);
                camera.setParameters(parameters2);
                d.a();
            }
            Point point2 = c.a().f3992b.d;
            int i2 = point2.y;
            int i3 = point2.x;
            int left = (this.q.getLeft() * i2) / this.p.getWidth();
            int top = (this.q.getTop() * i3) / this.p.getHeight();
            int width = (this.q.getWidth() * i2) / this.p.getWidth();
            this.j = left;
            this.k = top;
            this.l = width;
            this.m = (this.q.getHeight() * i3) / this.p.getHeight();
            this.f = true;
            if (this.d == null) {
                this.d = new com.zbar.a.b.a(this);
            }
        } catch (IOException | RuntimeException unused) {
        }
    }

    private void a(String str) {
        this.e.a();
        if (this.g && this.i != null) {
            this.i.start();
        }
        if (this.h) {
            ((Vibrator) getSystemService("vibrator")).vibrate(s);
        }
        b();
        this.f2191c.clearAnimation();
        if (str != null) {
            Intent intent = new Intent();
            intent.putExtra("SWEEP_RESULT_BACK", str);
            setResult(-1, intent);
            finish();
            return;
        }
        ag.b((Context) this, (int) R.string.sweep_error_tips);
    }

    private void b(int i2) {
        this.k = i2;
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(this, "Scan failed!", 0).show();
        }
    }

    private void c(int i2) {
        this.l = i2;
    }

    private boolean c() {
        return this.f;
    }

    private void d() {
        this.f = true;
    }

    private void d(int i2) {
        this.m = i2;
    }

    private int e() {
        return this.j;
    }

    private int f() {
        return this.k;
    }

    private int g() {
        return this.l;
    }

    private int h() {
        return this.m;
    }

    private void i() {
        TitleView titleView = (TitleView) findViewById(R.id.id_title);
        titleView.setTitleText(getString(R.string.sweep_code_register_code));
        titleView.setVisibilityRightImage(4);
        titleView.setleftImage(R.drawable.ic_back);
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
    }

    private void j() {
        c.a((Context) this);
        this.r = false;
        this.e = new e(this);
        this.p = (RelativeLayout) findViewById(R.id.capture_containter);
        this.q = (RelativeLayout) findViewById(R.id.capture_crop_layout);
        int i2 = getResources().getDisplayMetrics().widthPixels;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
        int i3 = (i2 * 2) / 3;
        layoutParams.width = i3;
        layoutParams.height = i3;
        this.q.setLayoutParams(layoutParams);
        this.f2191c = (ImageView) findViewById(R.id.capture_scan_line);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 0.0f, 2, 0.9f);
        translateAnimation.setDuration(1500);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.f2191c.setAnimation(translateAnimation);
        ((LinearLayout) findViewById(R.id.linear_open_light)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SweepCodeActivity sweepCodeActivity = SweepCodeActivity.this;
                if (sweepCodeActivity.n) {
                    sweepCodeActivity.n = false;
                    c a2 = c.a();
                    Log.e("zzz", "openLight1");
                    if (a2.f3993c != null) {
                        Log.e("zzz", "openLight2");
                        a2.i = a2.f3993c.getParameters();
                        a2.i.setFlashMode("torch");
                        a2.f3993c.setParameters(a2.i);
                        return;
                    }
                    return;
                }
                sweepCodeActivity.n = true;
                c a3 = c.a();
                if (a3.f3993c != null) {
                    a3.i = a3.f3993c.getParameters();
                    a3.i.setFlashMode("off");
                    a3.f3993c.setParameters(a3.i);
                }
            }
        });
    }

    private void k() {
        if (this.n) {
            this.n = false;
            c a2 = c.a();
            Log.e("zzz", "openLight1");
            if (a2.f3993c != null) {
                Log.e("zzz", "openLight2");
                a2.i = a2.f3993c.getParameters();
                a2.i.setFlashMode("torch");
                a2.f3993c.setParameters(a2.i);
                return;
            }
            return;
        }
        this.n = true;
        c a3 = c.a();
        if (a3.f3993c != null) {
            a3.i = a3.f3993c.getParameters();
            a3.i.setFlashMode("off");
            a3.f3993c.setParameters(a3.i);
        }
    }

    private void l() {
        if (this.g && this.i != null) {
            this.i.start();
        }
        if (this.h) {
            ((Vibrator) getSystemService("vibrator")).vibrate(s);
        }
    }

    private void m() {
        if (this.g && this.i == null) {
            setVolumeControlStream(3);
            this.i = new MediaPlayer();
            this.i.setAudioStreamType(3);
            this.i.setOnCompletionListener(this.t);
            AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(R.raw.beep);
            try {
                this.i.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.i.setVolume(o, o);
                this.i.prepare();
            } catch (IOException unused) {
                this.i = null;
            }
        }
    }

    private Handler n() {
        return this.d;
    }

    public final void b() {
        if (this.d != null) {
            com.zbar.a.b.a aVar = this.d;
            aVar.f4002c = a.C0063a.DONE$65384932;
            c a2 = c.a();
            if (a2.f3993c != null && a2.e) {
                if (!a2.f) {
                    a2.f3993c.setPreviewCallback((Camera.PreviewCallback) null);
                }
                a2.f3993c.stopPreview();
                a2.g.a((Handler) null, 0);
                a2.h.a((Handler) null, 0);
                a2.e = false;
            }
            aVar.removeMessages(R.id.decode_succeeded);
            aVar.removeMessages(R.id.decode_failed);
            aVar.removeMessages(R.id.decode);
            aVar.removeMessages(R.id.auto_focus);
            this.d = null;
        }
        c a3 = c.a();
        if (a3.f3993c != null) {
            d.b();
            a3.f3993c.release();
            a3.f3993c = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sweep_code);
        if (ActivityCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 0);
            return;
        }
        TitleView titleView = (TitleView) findViewById(R.id.id_title);
        titleView.setTitleText(getString(R.string.sweep_code_register_code));
        titleView.setVisibilityRightImage(4);
        titleView.setleftImage(R.drawable.ic_back);
        titleView.setOnLeftImageViewListener(new a(this, (byte) 0));
        c.a((Context) this);
        this.r = false;
        this.e = new e(this);
        this.p = (RelativeLayout) findViewById(R.id.capture_containter);
        this.q = (RelativeLayout) findViewById(R.id.capture_crop_layout);
        int i2 = getResources().getDisplayMetrics().widthPixels;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
        int i3 = (i2 * 2) / 3;
        layoutParams.width = i3;
        layoutParams.height = i3;
        this.q.setLayoutParams(layoutParams);
        this.f2191c = (ImageView) findViewById(R.id.capture_scan_line);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 0.0f, 2, 0.9f);
        translateAnimation.setDuration(1500);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.f2191c.setAnimation(translateAnimation);
        ((LinearLayout) findViewById(R.id.linear_open_light)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SweepCodeActivity sweepCodeActivity = SweepCodeActivity.this;
                if (sweepCodeActivity.n) {
                    sweepCodeActivity.n = false;
                    c a2 = c.a();
                    Log.e("zzz", "openLight1");
                    if (a2.f3993c != null) {
                        Log.e("zzz", "openLight2");
                        a2.i = a2.f3993c.getParameters();
                        a2.i.setFlashMode("torch");
                        a2.f3993c.setParameters(a2.i);
                        return;
                    }
                    return;
                }
                sweepCodeActivity.n = true;
                c a3 = c.a();
                if (a3.f3993c != null) {
                    a3.i = a3.f3993c.getParameters();
                    a3.i.setFlashMode("off");
                    a3.f3993c.setParameters(a3.i);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        e eVar = this.e;
        eVar.b();
        eVar.f4009a.shutdown();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
        b();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
        SurfaceHolder holder = ((SurfaceView) findViewById(R.id.capture_preview)).getHolder();
        if (this.r) {
            a(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.g = true;
        if (((AudioManager) getSystemService("audio")).getRingerMode() != 2) {
            this.g = false;
        }
        if (this.g && this.i == null) {
            setVolumeControlStream(3);
            this.i = new MediaPlayer();
            this.i.setAudioStreamType(3);
            this.i.setOnCompletionListener(this.t);
            AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(R.raw.beep);
            try {
                this.i.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.i.setVolume(o, o);
                this.i.prepare();
            } catch (IOException unused) {
                this.i = null;
            }
        }
        this.h = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!this.r) {
            this.r = true;
            a(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.r = false;
    }
}

package com.zbar.a.b;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import com.cyjh.common.util.ag;
import com.cyjh.elfin.ui.activity.SweepCodeActivity;
import com.ywfzjbcy.R;
import com.zbar.a.a.c;

public final class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    c f4000a = null;

    /* renamed from: b  reason: collision with root package name */
    SweepCodeActivity f4001b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f4002c;

    /* renamed from: com.zbar.a.b.a$a  reason: collision with other inner class name */
    private enum C0063a {
        ;
        
        public static final int DONE$65384932 = 3;
        public static final int PREVIEW$65384932 = 1;
        public static final int SUCCESS$65384932 = 2;

        static {
            $VALUES$4ec8d709 = new int[]{PREVIEW$65384932, SUCCESS$65384932, DONE$65384932};
        }

        public static int[] values$63e95f78() {
            return (int[]) $VALUES$4ec8d709.clone();
        }
    }

    public a(SweepCodeActivity sweepCodeActivity) {
        this.f4001b = sweepCodeActivity;
        this.f4000a = new c(sweepCodeActivity);
        this.f4000a.start();
        this.f4002c = C0063a.SUCCESS$65384932;
        c a2 = c.a();
        if (a2.f3993c != null && !a2.e) {
            a2.f3993c.startPreview();
            a2.e = true;
        }
        b();
    }

    private void a() {
        this.f4002c = C0063a.DONE$65384932;
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
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
        removeMessages(R.id.decode);
        removeMessages(R.id.auto_focus);
    }

    private void b() {
        if (this.f4002c == C0063a.SUCCESS$65384932) {
            this.f4002c = C0063a.PREVIEW$65384932;
            c.a().a(this.f4000a.a());
            c.a().b(this);
        }
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case R.id.auto_focus /*2131755012*/:
                if (this.f4002c == C0063a.PREVIEW$65384932) {
                    c.a().b(this);
                    return;
                }
                return;
            case R.id.decode_failed /*2131755014*/:
                break;
            case R.id.decode_succeeded /*2131755015*/:
                this.f4002c = C0063a.SUCCESS$65384932;
                SweepCodeActivity sweepCodeActivity = this.f4001b;
                String str = (String) message.obj;
                sweepCodeActivity.e.a();
                if (sweepCodeActivity.g && sweepCodeActivity.i != null) {
                    sweepCodeActivity.i.start();
                }
                if (sweepCodeActivity.h) {
                    ((Vibrator) sweepCodeActivity.getSystemService("vibrator")).vibrate(200);
                }
                sweepCodeActivity.b();
                sweepCodeActivity.f2191c.clearAnimation();
                if (str == null) {
                    ag.b((Context) sweepCodeActivity, (int) R.string.sweep_error_tips);
                    break;
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("SWEEP_RESULT_BACK", str);
                    sweepCodeActivity.setResult(-1, intent);
                    sweepCodeActivity.finish();
                    break;
                }
            case R.id.restart_preview /*2131755029*/:
                b();
                return;
            default:
                return;
        }
        this.f4002c = C0063a.PREVIEW$65384932;
        c.a().a(this.f4000a.a());
    }
}

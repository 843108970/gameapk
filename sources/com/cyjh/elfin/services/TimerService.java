package com.cyjh.elfin.services;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.cyjh.common.util.x;
import com.cyjh.elfin.ui.activity.SplashActivity;

public class TimerService extends BaseService {

    /* renamed from: c  reason: collision with root package name */
    private static final int f2076c = 5;
    private static final int d = 200;
    private static final int e = 272;

    /* renamed from: b  reason: collision with root package name */
    private a f2077b;
    /* access modifiers changed from: private */
    public Handler f = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message.what == 272) {
                Intent intent = new Intent(TimerService.this, SplashActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("sIsBooted", true);
                TimerService.this.startActivity(intent);
            }
        }
    };

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f2080b = 0;

        a() {
        }

        private void a() {
            Log.e("zzz", "onStart ");
            TimerService.this.f.removeCallbacks(this);
            TimerService.this.f.postDelayed(this, 200);
        }

        static /* synthetic */ void a(a aVar) {
            Log.e("zzz", "onStart ");
            TimerService.this.f.removeCallbacks(aVar);
            TimerService.this.f.postDelayed(aVar, 200);
        }

        public final void run() {
            Log.e("zzz", "run ");
            if (x.a(TimerService.this)) {
                this.f2080b++;
                Log.e("zzz", "TimerService--run--" + this.f2080b);
                if (this.f2080b <= 5) {
                    TimerService.this.f.removeCallbacks(this);
                    TimerService.this.f.postDelayed(this, 200);
                    return;
                }
                TimerService.this.f.removeCallbacks(this);
                TimerService.this.f.obtainMessage(272).sendToTarget();
                return;
            }
            Log.e("zzz", "run 2");
            TimerService.this.f.removeCallbacks(this);
            TimerService.this.f.postDelayed(this, 200);
        }
    }

    public void onDestroy() {
        if (this.f2077b != null) {
            this.f.removeCallbacks(this.f2077b);
            this.f2077b = null;
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log.e("zzz", "onStartCommand ");
        this.f2077b = new a();
        a.a(this.f2077b);
        return super.onStartCommand(intent, i, i2);
    }
}

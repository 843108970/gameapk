package com.cyjh.elfin.services;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.cyjh.common.base.service.BaseService;
import com.cyjh.common.util.ab;
import com.cyjh.elfin.a.a;
import com.cyjh.elfin.floatingwindowprocess.d.b;
import com.cyjh.elfin.ui.activity.SplashActivity;
import com.ywfzjbcy.R;

public class PhoneStateService extends BaseService {

    /* renamed from: b  reason: collision with root package name */
    private static PhoneStateService f2072b;

    /* renamed from: a  reason: collision with root package name */
    private PhoneStateReceiver f2073a;

    /* renamed from: c  reason: collision with root package name */
    private final String f2074c = "android.intent.action.PHONE_STATE";

    public class PhoneStateReceiver extends BroadcastReceiver {
        public PhoneStateReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.e("TAG", ">>>>>>>>>电话广播监听已进来");
            Log.e("TAG", ">>>>>>action>>>>" + action);
            if (!"android.intent.action.NEW_OUTGOING_CALL".equals(action) && "android.intent.action.PHONE_STATE".equals(action)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                Log.e("TAG", "tm.getCallState()>>>>" + telephonyManager.getCallState());
                switch (telephonyManager.getCallState()) {
                    case 1:
                        Log.e("TAG", "继续选项>>>" + ab.a().b(a.x, (Boolean) true));
                        if (ab.a().b(a.x, (Boolean) true)) {
                            Log.e("TAG", "停止脚本>>>>>");
                            b.j();
                            b.d();
                            return;
                        }
                        return;
                    case 2:
                        if (ab.a().b(a.x, (Boolean) true)) {
                            b.j();
                            b.d();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void a() {
        Intent intent = new Intent(this, SplashActivity.class);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 134217728);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentIntent(activity);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(false);
        builder.setContentTitle(getString(R.string.app_name));
        builder.setContentText(getString(R.string.app_name) + getString(R.string.notification_content));
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("umeng");
        }
        startForeground(getResources().getInteger(R.integer.notification_id), builder.build());
    }

    public void onCreate() {
        super.onCreate();
        this.f2073a = new PhoneStateReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        registerReceiver(this.f2073a, intentFilter);
    }

    public void onDestroy() {
        unregisterReceiver(this.f2073a);
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}

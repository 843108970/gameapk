package com.cyjh.elfin.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.cyjh.common.util.ab;
import com.cyjh.elfin.a.a;
import com.cyjh.elfin.services.TimerService;

public class BootBroadcast extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1860a = "android.intent.action.BOOT_COMPLETED";

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.e("zzz", "BootBroadcast:开机启动广播" + action);
        if (f1860a.equals(action)) {
            boolean b2 = ab.a().b(a.D, (Boolean) false);
            Log.e("zzz", "BootBroadcast:开机启动广播" + b2);
            if (b2) {
                context.startService(new Intent(context, TimerService.class));
            }
        }
    }
}

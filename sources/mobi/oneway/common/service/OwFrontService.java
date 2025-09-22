package mobi.oneway.common.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class OwFrontService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4051a = 110;

    /* renamed from: b  reason: collision with root package name */
    private static final String f4052b = "DaemonService";

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Log.d(f4052b, "DaemonService---->onCreate被调用，启动前台service");
        if (Build.VERSION.SDK_INT > 18 && Build.VERSION.SDK_INT < 25) {
            Notification.Builder builder = new Notification.Builder(this);
            builder.setSmallIcon(17301651);
            builder.setContentTitle(getPackageName());
            builder.setContentText(getPackageName());
            startForeground(110, builder.build());
        } else if (Build.VERSION.SDK_INT < 18) {
            startForeground(110, new Notification());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT > 18 && Build.VERSION.SDK_INT < 25) {
            ((NotificationManager) getSystemService("notification")).cancel(110);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }
}

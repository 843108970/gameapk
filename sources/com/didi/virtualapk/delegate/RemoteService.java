package com.didi.virtualapk.delegate;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.didi.virtualapk.PluginManager;
import java.io.File;

public class RemoteService extends LocalService {
    private static final String TAG = "VA.RemoteService";

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        Intent intent2 = (Intent) intent.getParcelableExtra(LocalService.EXTRA_TARGET);
        if (intent2 != null) {
            String stringExtra = intent.getStringExtra(LocalService.EXTRA_PLUGIN_LOCATION);
            if (PluginManager.getInstance(this).getLoadedPlugin(intent2.getComponent()) == null && stringExtra != null) {
                try {
                    PluginManager.getInstance(this).loadPlugin(new File(stringExtra));
                } catch (Exception e) {
                    Log.w(TAG, e);
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}

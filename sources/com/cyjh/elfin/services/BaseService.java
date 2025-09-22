package com.cyjh.elfin.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.cyjh.elfin.a.a;
import com.cyjh.elfin.base.AppContext;

public class BaseService extends Service implements a {

    /* renamed from: a  reason: collision with root package name */
    protected AppContext f2068a;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.f2068a = (AppContext) getApplicationContext();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}

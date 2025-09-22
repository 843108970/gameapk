package com.king.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public final class a extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static b f3526a;

    /* renamed from: b  reason: collision with root package name */
    private f f3527b;

    public static b a() {
        return f3526a;
    }

    public final IBinder onBind(Intent intent) {
        return this.f3527b;
    }
}

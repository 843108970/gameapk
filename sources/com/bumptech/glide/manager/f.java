package com.bumptech.glide.manager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import com.bumptech.glide.manager.c;

public final class f implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1411a = "ConnectivityMonitor";

    /* renamed from: b  reason: collision with root package name */
    private static final String f1412b = "android.permission.ACCESS_NETWORK_STATE";

    @NonNull
    public final c a(@NonNull Context context, @NonNull c.a aVar) {
        boolean z = ContextCompat.checkSelfPermission(context, f1412b) == 0;
        if (Log.isLoggable(f1411a, 3)) {
            Log.d(f1411a, z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new e(context, aVar) : new j();
    }
}

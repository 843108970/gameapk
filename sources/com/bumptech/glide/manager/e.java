package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.util.i;

final class e implements c {

    /* renamed from: c  reason: collision with root package name */
    private static final String f1407c = "ConnectivityMonitor";

    /* renamed from: a  reason: collision with root package name */
    final c.a f1408a;

    /* renamed from: b  reason: collision with root package name */
    boolean f1409b;
    private final Context d;
    private boolean e;
    private final BroadcastReceiver f = new BroadcastReceiver() {
        public final void onReceive(@NonNull Context context, Intent intent) {
            boolean z = e.this.f1409b;
            e.this.f1409b = e.a(context);
            if (z != e.this.f1409b) {
                if (Log.isLoggable(e.f1407c, 3)) {
                    Log.d(e.f1407c, "connectivity changed, isConnected: " + e.this.f1409b);
                }
                e.this.f1408a.a(e.this.f1409b);
            }
        }
    };

    e(@NonNull Context context, @NonNull c.a aVar) {
        this.d = context.getApplicationContext();
        this.f1408a = aVar;
    }

    private void a() {
        if (!this.e) {
            this.f1409b = a(this.d);
            try {
                this.d.registerReceiver(this.f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.e = true;
            } catch (SecurityException e2) {
                if (Log.isLoggable(f1407c, 5)) {
                    Log.w(f1407c, "Failed to register", e2);
                }
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    static boolean a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) i.a((ConnectivityManager) context.getSystemService("connectivity"), "Argument must not be null")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (Log.isLoggable(f1407c, 5)) {
                Log.w(f1407c, "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }

    private void b() {
        if (this.e) {
            this.d.unregisterReceiver(this.f);
            this.e = false;
        }
    }

    public final void onDestroy() {
    }

    public final void onStart() {
        if (!this.e) {
            this.f1409b = a(this.d);
            try {
                this.d.registerReceiver(this.f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.e = true;
            } catch (SecurityException e2) {
                if (Log.isLoggable(f1407c, 5)) {
                    Log.w(f1407c, "Failed to register", e2);
                }
            }
        }
    }

    public final void onStop() {
        if (this.e) {
            this.d.unregisterReceiver(this.f);
            this.e = false;
        }
    }
}

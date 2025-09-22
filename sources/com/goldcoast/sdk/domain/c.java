package com.goldcoast.sdk.domain;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;

final class c extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EntryPoint f2958a;

    c(EntryPoint entryPoint) {
        this.f2958a = entryPoint;
    }

    public final void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo = this.f2958a.v.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            this.f2958a.f();
        }
    }
}

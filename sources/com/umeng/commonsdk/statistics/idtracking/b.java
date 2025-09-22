package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3896a = "android_id";

    /* renamed from: b  reason: collision with root package name */
    private Context f3897b;

    public b(Context context) {
        super("android_id");
        this.f3897b = context;
    }

    public String f() {
        return DeviceConfig.getAndroidId(this.f3897b);
    }
}

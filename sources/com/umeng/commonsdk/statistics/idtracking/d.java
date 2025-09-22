package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3900a = "idmd5";

    /* renamed from: b  reason: collision with root package name */
    private Context f3901b;

    public d(Context context) {
        super("idmd5");
        this.f3901b = context;
    }

    public String f() {
        return DeviceConfig.getDeviceIdUmengMD5(this.f3901b);
    }
}

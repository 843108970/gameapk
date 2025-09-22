package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3907a = "imei";

    /* renamed from: b  reason: collision with root package name */
    private Context f3908b;

    public f(Context context) {
        super(f3907a);
        this.f3908b = context;
    }

    public String f() {
        return DeviceConfig.getImei(this.f3908b);
    }
}

package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

public class h extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3913a = "mac";

    /* renamed from: b  reason: collision with root package name */
    private Context f3914b;

    public h(Context context) {
        super(f3913a);
        this.f3914b = context;
    }

    public String f() {
        try {
            return DeviceConfig.getMac(this.f3914b);
        } catch (Exception e) {
            if (b.f) {
                e.printStackTrace();
            }
            e.a(this.f3914b, e);
            return null;
        }
    }
}

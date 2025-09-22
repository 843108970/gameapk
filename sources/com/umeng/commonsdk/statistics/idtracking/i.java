package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.proguard.v;

public class i extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3915a = "newumid";

    /* renamed from: b  reason: collision with root package name */
    private Context f3916b;

    public i(Context context) {
        super(f3915a);
        this.f3916b = context;
    }

    public String f() {
        return UMEnvelopeBuild.imprintProperty(this.f3916b, v.e, (String) null);
    }
}

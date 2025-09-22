package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.a;

public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3898a = "idfa";

    /* renamed from: b  reason: collision with root package name */
    private Context f3899b;

    public c(Context context) {
        super(f3898a);
        this.f3899b = context;
    }

    public String f() {
        String a2 = a.a(this.f3899b);
        return a2 == null ? "" : a2;
    }
}

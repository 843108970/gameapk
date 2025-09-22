package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.proguard.q;

public class o extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3927a = "umtt3";

    /* renamed from: b  reason: collision with root package name */
    private Context f3928b;

    public o(Context context) {
        super(f3927a);
        this.f3928b = context;
    }

    public String f() {
        return new q(this.f3928b).e();
    }
}

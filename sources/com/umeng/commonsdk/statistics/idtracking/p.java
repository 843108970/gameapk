package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.proguard.q;

public class p extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3929a = "umtt2";

    /* renamed from: b  reason: collision with root package name */
    private Context f3930b;

    public p(Context context) {
        super(f3929a);
        this.f3930b = context;
    }

    public String f() {
        return new q(this.f3930b).d();
    }
}

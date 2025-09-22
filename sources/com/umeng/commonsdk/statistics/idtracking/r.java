package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

public class r extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3933a = "uopdta";

    /* renamed from: b  reason: collision with root package name */
    private static final String f3934b = "uop";

    /* renamed from: c  reason: collision with root package name */
    private Context f3935c;

    public r(Context context) {
        super(f3934b);
        this.f3935c = context;
    }

    public String f() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.f3935c);
        return sharedPreferences != null ? sharedPreferences.getString(f3933a, "") : "";
    }
}

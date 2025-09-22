package com.cyjh.common.util;

import android.content.Context;
import android.content.res.Resources;
import com.cyjh.common.R;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1677a = 1440;

    /* renamed from: b  reason: collision with root package name */
    public static final int f1678b = 60;

    public static String a(Context context, long j) {
        Resources resources = context.getResources();
        resources.getString(R.string.optionfragment_duetime_day);
        if (j >= 1440) {
            return String.format(resources.getString(R.string.optionfragment_duetime_day), new Object[]{Long.valueOf(j / 1440), Long.valueOf((j % 1440) / 60), Long.valueOf(j % 60)});
        } else if (j > 60 && j < 1440) {
            return String.format(resources.getString(R.string.optionfragment_duetime_hour), new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
        } else if (j > 60 || j <= 0) {
            return j <= 0 ? resources.getString(R.string.optionfragment_duetime_no) : "";
        } else {
            return String.format(resources.getString(R.string.optionfragment_duetime_minute), new Object[]{Long.valueOf(j)});
        }
    }
}

package com.cyjh.common.util.toast;

import android.provider.Settings;
import android.support.annotation.RequiresApi;

public final class i {
    @RequiresApi(api = 23)
    private static boolean a() {
        return Settings.canDrawOverlays(q.a());
    }
}

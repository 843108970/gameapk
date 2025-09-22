package com.cyjh.b;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

public final class c {
    private static void a() {
        MobclickAgent.openActivityDurationTrack(false);
    }

    private static void a(Context context) {
        MobclickAgent.onResume(context);
    }

    private static void a(Context context, String str, String str2) {
        UMConfigure.init(context, str, str2, 1, (String) null);
        MobclickAgent.openActivityDurationTrack(false);
    }

    private static void a(String str) {
        MobclickAgent.onPageStart(str);
    }

    private static void b(Context context) {
        MobclickAgent.onPause(context);
    }

    private static void b(String str) {
        MobclickAgent.onPageEnd(str);
    }

    private static void c(Context context) {
        MobclickAgent.onKillProcess(context);
    }
}

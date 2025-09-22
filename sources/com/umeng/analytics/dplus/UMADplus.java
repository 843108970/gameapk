package com.umeng.analytics.dplus;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.statistics.common.MLog;
import java.util.List;
import java.util.Map;

public class UMADplus {
    public static void clearSuperProperties(Context context) {
        if (!AnalyticsConfig.FLAG_DPLUS) {
            MLog.e("UMADplus class is Dplus API, can't be use in no-Dplus scenario.");
        } else {
            MobclickAgent.getAgent().e(context);
        }
    }

    public static String getSuperProperties(Context context) {
        if (AnalyticsConfig.FLAG_DPLUS) {
            return MobclickAgent.getAgent().d(context);
        }
        MLog.e("UMADplus class is Dplus API, can't be use in no-Dplus scenario.");
        return null;
    }

    public static Object getSuperProperty(Context context, String str) {
        if (AnalyticsConfig.FLAG_DPLUS) {
            return MobclickAgent.getAgent().d(context, str);
        }
        MLog.e("UMADplus class is Dplus API, can't be use in no-Dplus scenario.");
        return null;
    }

    public static void registerSuperProperty(Context context, String str, Object obj) {
        if (!AnalyticsConfig.FLAG_DPLUS) {
            MLog.e("UMADplus class is Dplus API, can't be use in no-Dplus scenario.");
        } else {
            MobclickAgent.getAgent().a(context, str, obj);
        }
    }

    public static void setFirstLaunchEvent(Context context, List<String> list) {
        if (!AnalyticsConfig.FLAG_DPLUS) {
            MLog.e("UMADplus class is Dplus API, can't be use in no-Dplus scenario.");
        } else {
            MobclickAgent.getAgent().a(context, list);
        }
    }

    public static void track(Context context, String str) {
        if (!AnalyticsConfig.FLAG_DPLUS) {
            MLog.e("UMADplus class is Dplus API, can't be use in no-Dplus scenario.");
        } else {
            MobclickAgent.getAgent().a(context, str, (Map<String, Object>) null);
        }
    }

    public static void track(Context context, String str, Map<String, Object> map) {
        if (!AnalyticsConfig.FLAG_DPLUS) {
            MLog.e("UMADplus class is Dplus API, can't be use in no-Dplus scenario.");
            return;
        }
        if (map == null || map.size() <= 0) {
            MLog.e("the map is null!");
        }
        MobclickAgent.getAgent().a(context, str, map);
    }

    public static void unregisterSuperProperty(Context context, String str) {
        if (!AnalyticsConfig.FLAG_DPLUS) {
            MLog.e("UMADplus class is Dplus API, can't be use in no-Dplus scenario.");
        } else {
            MobclickAgent.getAgent().c(context, str);
        }
    }
}

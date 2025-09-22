package com.alibaba.sdk.android.oss.common.utils;

import android.os.Build;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSLog;

public class VersionInfoUtils {
    private static String userAgent;

    private static String getSystemInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(System.getProperty("os.name"));
        sb.append("/Android " + Build.VERSION.RELEASE);
        sb.append("/");
        sb.append(Build.MODEL + ";" + Build.ID);
        sb.append(")");
        String sb2 = sb.toString();
        OSSLog.logDebug("user agent : " + sb2);
        return OSSUtils.isEmptyString(sb2) ? System.getProperty("http.agent").replaceAll("[^\\p{ASCII}]", "?") : sb2;
    }

    public static String getUserAgent(String str) {
        if (OSSUtils.isEmptyString(userAgent)) {
            userAgent = "aliyun-sdk-android/" + getVersion() + getSystemInfo();
        }
        if (OSSUtils.isEmptyString(str)) {
            return userAgent;
        }
        return userAgent + "/" + str;
    }

    public static String getVersion() {
        return OSSConstants.SDK_VERSION;
    }
}

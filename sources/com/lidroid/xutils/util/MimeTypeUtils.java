package com.lidroid.xutils.util;

import android.webkit.MimeTypeMap;
import com.alibaba.sdk.android.oss.common.OSSConstants;

public class MimeTypeUtils {
    private MimeTypeUtils() {
    }

    public static String getMimeType(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1));
    }
}

package com.iflytek.collector.device;

import android.content.Context;
import org.json.JSONObject;

public interface IDeviceInfo {
    JSONObject getHeader(Context context);

    JSONObject getHeart(Context context);

    String getVersion();
}

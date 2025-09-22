package com.iflytek.voiceads.dex;

import android.content.Context;
import com.iflytek.collector.a.a.b;
import com.iflytek.voiceads.config.SDKLogger;
import dalvik.system.PathClassLoader;

public class DexLoader {
    public static void initIFLYADModule(Context context) {
        SDKLogger.d("initIFLYADModule");
        if (context == null) {
            SDKLogger.d("context is null");
            return;
        }
        try {
            a.f3511a = a.a(context);
            SDKLogger.d("loadDex success");
        } catch (Exception e) {
            SDKLogger.e("loadDex error:" + e.getMessage());
            a.f3511a = a.b(context);
        }
        try {
            Object a2 = a.a((Object) (PathClassLoader) context.getClassLoader());
            a.a(a2, a2.getClass(), "dexElements", a.a(a.b(a2), a.b(a.a((Object) a.f3511a))));
            SDKLogger.e("dex inject success");
        } catch (Exception e2) {
            SDKLogger.e("dex inject error:" + e2.getMessage());
        }
        if (!SDKLogger.dev) {
            b a3 = b.a(context);
            a3.a("5c075f2e17");
            a3.b(a.c(context));
        }
    }
}

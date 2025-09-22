package com.iflytek.voiceads.dex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.didi.virtualapk.internal.Constants;
import com.iflytek.voiceads.config.SDKLogger;
import com.iflytek.voiceads.config.Version;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static DexClassLoader f3511a;

    public static DexClassLoader a(Context context) {
        String str = Version.getVersion().split("_")[0];
        String a2 = c.a(context, str);
        SDKLogger.d("sdkVersion=" + str + ";localVersion=" + a2);
        return b(context, a2);
    }

    public static Class<?> a(Context context, String str) throws ClassNotFoundException {
        SDKLogger.d("loadAdClass");
        try {
            if (f3511a == null) {
                f3511a = a(context);
            }
            return f3511a.loadClass(str);
        } catch (Exception unused) {
            if (f3511a == null) {
                f3511a = b(context);
            }
            return f3511a.loadClass(str);
        }
    }

    public static Object a(Object obj) throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return a(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }

    public static Object a(Object obj, Class<?> cls, String str) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object a(Object obj, Object obj2) {
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2) + length;
        Object newInstance = Array.newInstance(componentType, length2);
        int i = 0;
        while (i < length2) {
            Array.set(newInstance, i, i < length ? Array.get(obj, i) : Array.get(obj2, i - length));
            i++;
        }
        return newInstance;
    }

    public static void a(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static DexClassLoader b(Context context) {
        String str = Version.getVersion().split("_")[0];
        String b2 = c.b(context, str);
        SDKLogger.d("sdkVersion=" + str + ";rawVersion=" + b2);
        return b(context, b2);
    }

    private static DexClassLoader b(Context context, String str) {
        return new DexClassLoader(context.getFilesDir().getAbsolutePath() + File.separator + str, context.getDir(Constants.OPTIMIZE_DIR, 0).getAbsolutePath(), (String) null, context.getClassLoader());
    }

    public static Object b(Object obj) throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        return a(obj, obj.getClass(), "dexElements");
    }

    public static String c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                String obj = applicationInfo.metaData.get("IFLYTEK_APPKEY_AD").toString();
                if (!TextUtils.isEmpty(obj)) {
                    return obj.trim();
                }
            }
        } catch (Exception e) {
            SDKLogger.e("getAppId:" + e.getMessage());
        }
        return "";
    }
}

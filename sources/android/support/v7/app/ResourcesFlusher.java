package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

class ResourcesFlusher {
    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    ResourcesFlusher() {
    }

    static boolean flush(@NonNull Resources resources) {
        if (Build.VERSION.SDK_INT >= 24) {
            return flushNougats(resources);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return flushMarshmallows(resources);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return flushLollipops(resources);
        }
        return false;
    }

    @RequiresApi(21)
    private static boolean flushLollipops(@NonNull Resources resources) {
        Map map;
        if (!sDrawableCacheFieldFetched) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
            }
            sDrawableCacheFieldFetched = true;
        }
        if (sDrawableCacheField == null) {
            return false;
        }
        try {
            map = (Map) sDrawableCacheField.get(resources);
        } catch (IllegalAccessException e2) {
            Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e2);
            map = null;
        }
        if (map == null) {
            return false;
        }
        map.clear();
        return true;
    }

    @RequiresApi(23)
    private static boolean flushMarshmallows(@NonNull Resources resources) {
        Object obj;
        if (!sDrawableCacheFieldFetched) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
            }
            sDrawableCacheFieldFetched = true;
        }
        if (sDrawableCacheField != null) {
            try {
                obj = sDrawableCacheField.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e2);
            }
            return obj == null && obj != null && flushThemedResourcesCache(obj);
        }
        obj = null;
        if (obj == null) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0072 A[RETURN] */
    @android.support.annotation.RequiresApi(24)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean flushNougats(@android.support.annotation.NonNull android.content.res.Resources r6) {
        /*
            boolean r0 = sResourcesImplFieldFetched
            r1 = 1
            if (r0 != 0) goto L_0x001d
            java.lang.Class<android.content.res.Resources> r0 = android.content.res.Resources.class
            java.lang.String r2 = "mResourcesImpl"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0013 }
            sResourcesImplField = r0     // Catch:{ NoSuchFieldException -> 0x0013 }
            r0.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x0013 }
            goto L_0x001b
        L_0x0013:
            r0 = move-exception
            java.lang.String r2 = "ResourcesFlusher"
            java.lang.String r3 = "Could not retrieve Resources#mResourcesImpl field"
            android.util.Log.e(r2, r3, r0)
        L_0x001b:
            sResourcesImplFieldFetched = r1
        L_0x001d:
            java.lang.reflect.Field r0 = sResourcesImplField
            r2 = 0
            if (r0 != 0) goto L_0x0023
            return r2
        L_0x0023:
            r0 = 0
            java.lang.reflect.Field r3 = sResourcesImplField     // Catch:{ IllegalAccessException -> 0x002b }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ IllegalAccessException -> 0x002b }
            goto L_0x0034
        L_0x002b:
            r6 = move-exception
            java.lang.String r3 = "ResourcesFlusher"
            java.lang.String r4 = "Could not retrieve value from Resources#mResourcesImpl"
            android.util.Log.e(r3, r4, r6)
            r6 = r0
        L_0x0034:
            if (r6 != 0) goto L_0x0037
            return r2
        L_0x0037:
            boolean r3 = sDrawableCacheFieldFetched
            if (r3 != 0) goto L_0x0055
            java.lang.Class r3 = r6.getClass()     // Catch:{ NoSuchFieldException -> 0x004b }
            java.lang.String r4 = "mDrawableCache"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ NoSuchFieldException -> 0x004b }
            sDrawableCacheField = r3     // Catch:{ NoSuchFieldException -> 0x004b }
            r3.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x004b }
            goto L_0x0053
        L_0x004b:
            r3 = move-exception
            java.lang.String r4 = "ResourcesFlusher"
            java.lang.String r5 = "Could not retrieve ResourcesImpl#mDrawableCache field"
            android.util.Log.e(r4, r5, r3)
        L_0x0053:
            sDrawableCacheFieldFetched = r1
        L_0x0055:
            java.lang.reflect.Field r3 = sDrawableCacheField
            if (r3 == 0) goto L_0x0068
            java.lang.reflect.Field r3 = sDrawableCacheField     // Catch:{ IllegalAccessException -> 0x0060 }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ IllegalAccessException -> 0x0060 }
            goto L_0x0069
        L_0x0060:
            r6 = move-exception
            java.lang.String r3 = "ResourcesFlusher"
            java.lang.String r4 = "Could not retrieve value from ResourcesImpl#mDrawableCache"
            android.util.Log.e(r3, r4, r6)
        L_0x0068:
            r6 = r0
        L_0x0069:
            if (r6 == 0) goto L_0x0072
            boolean r6 = flushThemedResourcesCache(r6)
            if (r6 == 0) goto L_0x0072
            return r1
        L_0x0072:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ResourcesFlusher.flushNougats(android.content.res.Resources):boolean");
    }

    @RequiresApi(16)
    private static boolean flushThemedResourcesCache(@NonNull Object obj) {
        LongSparseArray longSparseArray;
        if (!sThemedResourceCacheClazzFetched) {
            try {
                sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "Could not find ThemedResourceCache class", e);
            }
            sThemedResourceCacheClazzFetched = true;
        }
        if (sThemedResourceCacheClazz == null) {
            return false;
        }
        if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
            try {
                Field declaredField = sThemedResourceCacheClazz.getDeclaredField("mUnthemedEntries");
                sThemedResourceCache_mUnthemedEntriesField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(TAG, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        }
        if (sThemedResourceCache_mUnthemedEntriesField == null) {
            return false;
        }
        try {
            longSparseArray = (LongSparseArray) sThemedResourceCache_mUnthemedEntriesField.get(obj);
        } catch (IllegalAccessException e3) {
            Log.e(TAG, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            longSparseArray = null;
        }
        if (longSparseArray == null) {
            return false;
        }
        longSparseArray.clear();
        return true;
    }
}

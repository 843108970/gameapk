package com.didi.virtualapk.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityThread;
import android.app.LoadedApk;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.ResourcesImpl;
import android.content.res.ResourcesKey;
import android.os.Build;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.Log;
import com.didi.virtualapk.PluginManager;
import com.didi.virtualapk.utils.Reflector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class ResourcesManager {
    public static final String TAG = "VA.LoadedPlugin";
    /* access modifiers changed from: private */
    public static Configuration mDefaultConfiguration;

    private static final class AdaptationResourcesCompat {
        private AdaptationResourcesCompat() {
        }

        /* access modifiers changed from: private */
        public static Resources createResources(Resources resources, AssetManager assetManager) throws Exception {
            try {
                return (Resources) Reflector.with(resources).constructor(AssetManager.class, DisplayMetrics.class, Configuration.class).newInstance(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            } catch (Exception unused) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }
    }

    private static final class MiUiResourcesCompat {
        private MiUiResourcesCompat() {
        }

        /* access modifiers changed from: private */
        public static Resources createResources(Resources resources, AssetManager assetManager) throws Exception {
            return (Resources) Reflector.on("android.content.res.MiuiResources").constructor(AssetManager.class, DisplayMetrics.class, Configuration.class).newInstance(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        }
    }

    private static final class NubiaResourcesCompat {
        private NubiaResourcesCompat() {
        }

        /* access modifiers changed from: private */
        public static Resources createResources(Resources resources, AssetManager assetManager) throws Exception {
            return (Resources) Reflector.on("android.content.res.NubiaResources").constructor(AssetManager.class, DisplayMetrics.class, Configuration.class).newInstance(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        }
    }

    private static final class ResourcesManagerCompatForN {
        private ResourcesManagerCompatForN() {
        }

        @TargetApi(19)
        public static void resolveResourcesImplMap(Map<ResourcesKey, WeakReference<ResourcesImpl>> map, Map<ResourcesKey, WeakReference<ResourcesImpl>> map2, String str, String str2) throws Exception {
            for (Map.Entry next : map.entrySet()) {
                ResourcesKey resourcesKey = (ResourcesKey) next.getKey();
                if (Objects.equals(resourcesKey.mResDir, str)) {
                    map2.put(new ResourcesKey(resourcesKey.mResDir, ResourcesManager.append(resourcesKey.mSplitResDirs, str2), resourcesKey.mOverlayDirs, resourcesKey.mLibDirs, resourcesKey.mDisplayId, resourcesKey.mOverrideConfiguration, resourcesKey.mCompatInfo), next.getValue());
                } else {
                    map2.put(resourcesKey, next.getValue());
                }
            }
        }
    }

    private static final class ResourcesManagerCompatForP {
        private ResourcesManagerCompatForP() {
        }

        @TargetApi(17)
        public static void resolveResourcesImplMap(Map<ResourcesKey, WeakReference<ResourcesImpl>> map, Map<ResourcesKey, WeakReference<ResourcesImpl>> map2, Context context, LoadedApk loadedApk) throws Exception {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            if (ResourcesManager.mDefaultConfiguration == null) {
                Configuration unused = ResourcesManager.mDefaultConfiguration = new Configuration();
            }
            hashMap.put(context.createConfigurationContext(ResourcesManager.mDefaultConfiguration).getResources().getImpl(), context);
            for (WeakReference<Activity> weakReference : PluginManager.getInstance(context).getInstrumentation().getActivities()) {
                Activity activity = (Activity) weakReference.get();
                if (activity != null) {
                    hashMap.put(activity.createConfigurationContext(activity.getResources().getConfiguration()).getResources().getImpl(), activity);
                }
            }
            for (Map.Entry next : map.entrySet()) {
                ResourcesImpl resourcesImpl = (ResourcesImpl) ((WeakReference) next.getValue()).get();
                if (resourcesImpl != null) {
                    hashMap2.put(resourcesImpl, next.getKey());
                }
                map2.put(next.getKey(), next.getValue());
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                ResourcesImpl impl = ((Context) entry.getValue()).getResources().getImpl();
                map2.put((ResourcesKey) hashMap2.get(entry.getKey()), new WeakReference(impl));
                map2.remove(hashMap2.get(impl));
            }
        }
    }

    private static final class VivoResourcesCompat {
        private VivoResourcesCompat() {
        }

        /* access modifiers changed from: private */
        public static Resources createResources(Context context, Resources resources, AssetManager assetManager) throws Exception {
            Reflector on = Reflector.on("android.content.res.VivoResources");
            Resources resources2 = (Resources) on.constructor(AssetManager.class, DisplayMetrics.class, Configuration.class).newInstance(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            on.method("init", String.class).callByCaller(resources2, context.getPackageName());
            on.field("mThemeValues");
            on.set(resources2, on.get(resources));
            return resources2;
        }
    }

    ResourcesManager() {
    }

    /* access modifiers changed from: private */
    public static String[] append(String[] strArr, String str) {
        if (contains(strArr, str)) {
            return strArr;
        }
        int length = (strArr != null ? strArr.length : 0) + 1;
        String[] strArr2 = new String[length];
        if (strArr != null) {
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        }
        strArr2[length - 1] = str;
        return strArr2;
    }

    @TargetApi(19)
    private static boolean contains(String[] strArr, String str) {
        if (strArr == null) {
            return false;
        }
        for (String equals : strArr) {
            if (Objects.equals(equals, str)) {
                return true;
            }
        }
        return false;
    }

    public static synchronized Resources createResources(Context context, String str, File file) throws Exception {
        synchronized (ResourcesManager.class) {
            if (Build.VERSION.SDK_INT >= 24) {
                Resources createResourcesForN = createResourcesForN(context, str, file);
                return createResourcesForN;
            }
            Resources createResourcesSimple = createResourcesSimple(context, file.getAbsolutePath());
            hookResources(context, createResourcesSimple);
            return createResourcesSimple;
        }
    }

    @TargetApi(24)
    private static Resources createResourcesForN(Context context, String str, File file) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        String absolutePath = file.getAbsolutePath();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String str2 = applicationInfo.publicSourceDir;
        applicationInfo.splitSourceDirs = append(applicationInfo.splitSourceDirs, absolutePath);
        LoadedApk loadedApk = (LoadedApk) Reflector.with(context).field("mPackageInfo").get();
        Reflector field = Reflector.with(loadedApk).field("mSplitResDirs");
        field.set(append((String[]) field.get(), absolutePath));
        android.app.ResourcesManager instance = android.app.ResourcesManager.getInstance();
        ArrayMap arrayMap = (ArrayMap) Reflector.with(instance).field("mResourceImpls").get();
        synchronized (instance) {
            HashMap hashMap = new HashMap();
            if (Build.VERSION.SDK_INT < 28) {
                if (Build.VERSION.SDK_INT != 27 || Build.VERSION.PREVIEW_SDK_INT == 0) {
                    ResourcesManagerCompatForN.resolveResourcesImplMap(arrayMap, hashMap, str2, absolutePath);
                    arrayMap.clear();
                    arrayMap.putAll(hashMap);
                }
            }
            ResourcesManagerCompatForP.resolveResourcesImplMap(arrayMap, hashMap, context, loadedApk);
            arrayMap.clear();
            arrayMap.putAll(hashMap);
        }
        android.app.ResourcesManager instance2 = android.app.ResourcesManager.getInstance();
        instance2.appendLibAssetForMainAssetPath(str2, str + ".vastub");
        Resources resources = context.getResources();
        for (LoadedPlugin updateResources : PluginManager.getInstance(context).getAllLoadedPlugins()) {
            updateResources.updateResources(resources);
        }
        Log.d("VA.LoadedPlugin", "createResourcesForN cost time: +" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return resources;
    }

    private static Resources createResourcesSimple(Context context, String str) throws Exception {
        AssetManager assetManager;
        Resources resources = context.getResources();
        Reflector method = Reflector.on((Class<?>) AssetManager.class).method("addAssetPath", String.class);
        if (Build.VERSION.SDK_INT < 21) {
            assetManager = AssetManager.class.newInstance();
            method.bind(assetManager);
            if (((Integer) method.call(context.getApplicationInfo().sourceDir)).intValue() == 0) {
                throw new RuntimeException("createResources failed, can't addAssetPath for " + context.getApplicationInfo().sourceDir);
            }
        } else {
            assetManager = resources.getAssets();
            method.bind(assetManager);
        }
        if (((Integer) method.call(str)).intValue() == 0) {
            throw new RuntimeException("createResources failed, can't addAssetPath for " + str);
        }
        List<LoadedPlugin> allLoadedPlugins = PluginManager.getInstance(context).getAllLoadedPlugins();
        for (LoadedPlugin next : allLoadedPlugins) {
            if (((Integer) method.call(next.getLocation())).intValue() == 0) {
                throw new RuntimeException("createResources failed, can't addAssetPath for " + next.getLocation());
            }
        }
        Resources access$000 = isMiUi(resources) ? MiUiResourcesCompat.createResources(resources, assetManager) : isVivo(resources) ? VivoResourcesCompat.createResources(context, resources, assetManager) : isNubia(resources) ? NubiaResourcesCompat.createResources(resources, assetManager) : isNotRawResources(resources) ? AdaptationResourcesCompat.createResources(resources, assetManager) : new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        for (LoadedPlugin updateResources : allLoadedPlugins) {
            updateResources.updateResources(access$000);
        }
        return access$000;
    }

    public static void hookResources(Context context, Resources resources) {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                Reflector with = Reflector.with(context);
                with.field("mResources").set(resources);
                Reflector.with(with.field("mPackageInfo").get()).field("mResources").set(resources);
                Map map = (Map) Reflector.with(Build.VERSION.SDK_INT >= 19 ? android.app.ResourcesManager.getInstance() : Reflector.with(ActivityThread.currentActivityThread()).field("mResourcesManager").get()).field("mActiveResources").get();
                map.put(map.keySet().iterator().next(), new WeakReference(resources));
            } catch (Exception e) {
                Log.w("VA.LoadedPlugin", e);
            }
        }
    }

    private static boolean isMiUi(Resources resources) {
        return resources.getClass().getName().equals("android.content.res.MiuiResources");
    }

    private static boolean isNotRawResources(Resources resources) {
        return !resources.getClass().getName().equals("android.content.res.Resources");
    }

    private static boolean isNubia(Resources resources) {
        return resources.getClass().getName().equals("android.content.res.NubiaResources");
    }

    private static boolean isVivo(Resources resources) {
        return resources.getClass().getName().equals("android.content.res.VivoResources");
    }
}

package com.didi.virtualapk.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ChangedPackages;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageParser;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.VersionedPackage;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.IntentCompat;
import com.didi.virtualapk.PluginManager;
import com.didi.virtualapk.internal.utils.DexUtil;
import com.didi.virtualapk.internal.utils.PackageParserCompat;
import com.didi.virtualapk.internal.utils.PluginUtil;
import com.didi.virtualapk.utils.Reflector;
import com.didi.virtualapk.utils.RunUtil;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoadedPlugin {
    public static final String TAG = "VA.LoadedPlugin";
    protected Map<ComponentName, ActivityInfo> mActivityInfos;
    protected Application mApplication;
    protected ClassLoader mClassLoader;
    protected Context mHostContext;
    protected Map<ComponentName, InstrumentationInfo> mInstrumentationInfos;
    protected final String mLocation;
    protected final File mNativeLibDir;
    protected final PackageParser.Package mPackage;
    protected final PackageInfo mPackageInfo = new PackageInfo();
    protected PluginPackageManager mPackageManager;
    protected Context mPluginContext;
    protected PluginManager mPluginManager;
    protected Map<ComponentName, ProviderInfo> mProviderInfos;
    protected Map<String, ProviderInfo> mProviders;
    protected Map<ComponentName, ActivityInfo> mReceiverInfos;
    protected Resources mResources;
    protected Map<ComponentName, ServiceInfo> mServiceInfos;

    protected class PluginPackageManager extends PackageManager {
        protected PackageManager mHostPackageManager = LoadedPlugin.this.mHostContext.getPackageManager();

        protected PluginPackageManager() {
        }

        public void addPackageToPreferred(String str) {
            this.mHostPackageManager.addPackageToPreferred(str);
        }

        public boolean addPermission(PermissionInfo permissionInfo) {
            return this.mHostPackageManager.addPermission(permissionInfo);
        }

        public boolean addPermissionAsync(PermissionInfo permissionInfo) {
            return this.mHostPackageManager.addPermissionAsync(permissionInfo);
        }

        public void addPreferredActivity(IntentFilter intentFilter, int i, ComponentName[] componentNameArr, ComponentName componentName) {
            this.mHostPackageManager.addPreferredActivity(intentFilter, i, componentNameArr, componentName);
        }

        @TargetApi(26)
        public boolean canRequestPackageInstalls() {
            return this.mHostPackageManager.canRequestPackageInstalls();
        }

        public String[] canonicalToCurrentPackageNames(String[] strArr) {
            return this.mHostPackageManager.canonicalToCurrentPackageNames(strArr);
        }

        public int checkPermission(String str, String str2) {
            return this.mHostPackageManager.checkPermission(str, str2);
        }

        public int checkSignatures(int i, int i2) {
            return this.mHostPackageManager.checkSignatures(i, i2);
        }

        public int checkSignatures(String str, String str2) {
            return this.mHostPackageManager.checkSignatures(str, str2);
        }

        @TargetApi(26)
        public void clearInstantAppCookie() {
            this.mHostPackageManager.clearInstantAppCookie();
        }

        public void clearPackagePreferredActivities(String str) {
            this.mHostPackageManager.clearPackagePreferredActivities(str);
        }

        public String[] currentToCanonicalPackageNames(String[] strArr) {
            return this.mHostPackageManager.currentToCanonicalPackageNames(strArr);
        }

        @TargetApi(17)
        public void extendVerificationTimeout(int i, int i2, long j) {
            this.mHostPackageManager.extendVerificationTimeout(i, i2, j);
        }

        @TargetApi(20)
        public Drawable getActivityBanner(ComponentName componentName) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(componentName);
            return loadedPlugin != null ? loadedPlugin.mResources.getDrawable(loadedPlugin.mActivityInfos.get(componentName).banner) : this.mHostPackageManager.getActivityBanner(componentName);
        }

        @TargetApi(20)
        public Drawable getActivityBanner(Intent intent) throws PackageManager.NameNotFoundException {
            ResolveInfo resolveActivity = LoadedPlugin.this.mPluginManager.resolveActivity(intent);
            return resolveActivity != null ? LoadedPlugin.this.mPluginManager.getLoadedPlugin(resolveActivity.resolvePackageName).mResources.getDrawable(resolveActivity.activityInfo.banner) : this.mHostPackageManager.getActivityBanner(intent);
        }

        public Drawable getActivityIcon(ComponentName componentName) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(componentName);
            return loadedPlugin != null ? loadedPlugin.mResources.getDrawable(loadedPlugin.mActivityInfos.get(componentName).icon) : this.mHostPackageManager.getActivityIcon(componentName);
        }

        public Drawable getActivityIcon(Intent intent) throws PackageManager.NameNotFoundException {
            ResolveInfo resolveActivity = LoadedPlugin.this.mPluginManager.resolveActivity(intent);
            return resolveActivity != null ? LoadedPlugin.this.mPluginManager.getLoadedPlugin(resolveActivity.resolvePackageName).mResources.getDrawable(resolveActivity.activityInfo.icon) : this.mHostPackageManager.getActivityIcon(intent);
        }

        public ActivityInfo getActivityInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(componentName);
            return loadedPlugin != null ? loadedPlugin.mActivityInfos.get(componentName) : this.mHostPackageManager.getActivityInfo(componentName, i);
        }

        public Drawable getActivityLogo(ComponentName componentName) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(componentName);
            return loadedPlugin != null ? loadedPlugin.mResources.getDrawable(loadedPlugin.mActivityInfos.get(componentName).logo) : this.mHostPackageManager.getActivityLogo(componentName);
        }

        public Drawable getActivityLogo(Intent intent) throws PackageManager.NameNotFoundException {
            ResolveInfo resolveActivity = LoadedPlugin.this.mPluginManager.resolveActivity(intent);
            return resolveActivity != null ? LoadedPlugin.this.mPluginManager.getLoadedPlugin(resolveActivity.resolvePackageName).mResources.getDrawable(resolveActivity.activityInfo.logo) : this.mHostPackageManager.getActivityLogo(intent);
        }

        public List<PermissionGroupInfo> getAllPermissionGroups(int i) {
            return this.mHostPackageManager.getAllPermissionGroups(i);
        }

        @TargetApi(20)
        public Drawable getApplicationBanner(ApplicationInfo applicationInfo) {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(applicationInfo.packageName);
            return loadedPlugin != null ? loadedPlugin.mResources.getDrawable(applicationInfo.banner) : this.mHostPackageManager.getApplicationBanner(applicationInfo);
        }

        @TargetApi(20)
        public Drawable getApplicationBanner(String str) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(str);
            return loadedPlugin != null ? loadedPlugin.mResources.getDrawable(loadedPlugin.mPackage.applicationInfo.banner) : this.mHostPackageManager.getApplicationBanner(str);
        }

        public int getApplicationEnabledSetting(String str) {
            return this.mHostPackageManager.getApplicationEnabledSetting(str);
        }

        public Drawable getApplicationIcon(ApplicationInfo applicationInfo) {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(applicationInfo.packageName);
            return loadedPlugin != null ? loadedPlugin.mResources.getDrawable(applicationInfo.icon) : this.mHostPackageManager.getApplicationIcon(applicationInfo);
        }

        public Drawable getApplicationIcon(String str) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(str);
            return loadedPlugin != null ? loadedPlugin.mResources.getDrawable(loadedPlugin.mPackage.applicationInfo.icon) : this.mHostPackageManager.getApplicationIcon(str);
        }

        public ApplicationInfo getApplicationInfo(String str, int i) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(str);
            return loadedPlugin != null ? loadedPlugin.getApplicationInfo() : this.mHostPackageManager.getApplicationInfo(str, i);
        }

        public CharSequence getApplicationLabel(ApplicationInfo applicationInfo) {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(applicationInfo.packageName);
            if (loadedPlugin != null) {
                try {
                    return loadedPlugin.mResources.getText(applicationInfo.labelRes);
                } catch (Resources.NotFoundException unused) {
                }
            }
            return this.mHostPackageManager.getApplicationLabel(applicationInfo);
        }

        public Drawable getApplicationLogo(ApplicationInfo applicationInfo) {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(applicationInfo.packageName);
            if (loadedPlugin == null) {
                return this.mHostPackageManager.getApplicationLogo(applicationInfo);
            }
            return loadedPlugin.mResources.getDrawable(applicationInfo.logo != 0 ? applicationInfo.logo : 17301651);
        }

        public Drawable getApplicationLogo(String str) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(str);
            if (loadedPlugin == null) {
                return this.mHostPackageManager.getApplicationLogo(str);
            }
            return loadedPlugin.mResources.getDrawable(loadedPlugin.mPackage.applicationInfo.logo != 0 ? loadedPlugin.mPackage.applicationInfo.logo : 17301651);
        }

        @Nullable
        @TargetApi(26)
        public ChangedPackages getChangedPackages(int i) {
            return this.mHostPackageManager.getChangedPackages(i);
        }

        public int getComponentEnabledSetting(ComponentName componentName) {
            return this.mHostPackageManager.getComponentEnabledSetting(componentName);
        }

        public Drawable getDefaultActivityIcon() {
            return this.mHostPackageManager.getDefaultActivityIcon();
        }

        public Drawable getDrawable(String str, int i, ApplicationInfo applicationInfo) {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(str);
            return loadedPlugin != null ? loadedPlugin.mResources.getDrawable(i) : this.mHostPackageManager.getDrawable(str, i, applicationInfo);
        }

        public List<ApplicationInfo> getInstalledApplications(int i) {
            return this.mHostPackageManager.getInstalledApplications(i);
        }

        public List<PackageInfo> getInstalledPackages(int i) {
            return this.mHostPackageManager.getInstalledPackages(i);
        }

        public String getInstallerPackageName(String str) {
            return LoadedPlugin.this.mPluginManager.getLoadedPlugin(str) != null ? LoadedPlugin.this.mHostContext.getPackageName() : this.mHostPackageManager.getInstallerPackageName(str);
        }

        @TargetApi(26)
        @NonNull
        public byte[] getInstantAppCookie() {
            return this.mHostPackageManager.getInstantAppCookie();
        }

        @TargetApi(26)
        public int getInstantAppCookieMaxBytes() {
            return this.mHostPackageManager.getInstantAppCookieMaxBytes();
        }

        public InstrumentationInfo getInstrumentationInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(componentName);
            return loadedPlugin != null ? loadedPlugin.mInstrumentationInfos.get(componentName) : this.mHostPackageManager.getInstrumentationInfo(componentName, i);
        }

        public Intent getLaunchIntentForPackage(@NonNull String str) {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(str);
            return loadedPlugin != null ? loadedPlugin.getLaunchIntent() : this.mHostPackageManager.getLaunchIntentForPackage(str);
        }

        @TargetApi(21)
        public Intent getLeanbackLaunchIntentForPackage(@NonNull String str) {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(str);
            return loadedPlugin != null ? loadedPlugin.getLeanbackLaunchIntent() : this.mHostPackageManager.getLeanbackLaunchIntentForPackage(str);
        }

        public String getNameForUid(int i) {
            return this.mHostPackageManager.getNameForUid(i);
        }

        public int[] getPackageGids(@NonNull String str) throws PackageManager.NameNotFoundException {
            return this.mHostPackageManager.getPackageGids(str);
        }

        @TargetApi(24)
        public int[] getPackageGids(String str, int i) throws PackageManager.NameNotFoundException {
            return this.mHostPackageManager.getPackageGids(str, i);
        }

        @TargetApi(26)
        public PackageInfo getPackageInfo(VersionedPackage versionedPackage, int i) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(versionedPackage.getPackageName());
            return loadedPlugin != null ? loadedPlugin.mPackageInfo : this.mHostPackageManager.getPackageInfo(versionedPackage, i);
        }

        public PackageInfo getPackageInfo(String str, int i) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(str);
            return loadedPlugin != null ? loadedPlugin.mPackageInfo : this.mHostPackageManager.getPackageInfo(str, i);
        }

        @TargetApi(21)
        @NonNull
        public PackageInstaller getPackageInstaller() {
            return this.mHostPackageManager.getPackageInstaller();
        }

        @TargetApi(24)
        public int getPackageUid(String str, int i) throws PackageManager.NameNotFoundException {
            return this.mHostPackageManager.getPackageUid(str, i);
        }

        public String[] getPackagesForUid(int i) {
            return this.mHostPackageManager.getPackagesForUid(i);
        }

        @TargetApi(18)
        public List<PackageInfo> getPackagesHoldingPermissions(String[] strArr, int i) {
            return this.mHostPackageManager.getPackagesHoldingPermissions(strArr, i);
        }

        public PermissionGroupInfo getPermissionGroupInfo(String str, int i) throws PackageManager.NameNotFoundException {
            return this.mHostPackageManager.getPermissionGroupInfo(str, i);
        }

        public PermissionInfo getPermissionInfo(String str, int i) throws PackageManager.NameNotFoundException {
            return this.mHostPackageManager.getPermissionInfo(str, i);
        }

        public int getPreferredActivities(@NonNull List<IntentFilter> list, @NonNull List<ComponentName> list2, String str) {
            return this.mHostPackageManager.getPreferredActivities(list, list2, str);
        }

        public List<PackageInfo> getPreferredPackages(int i) {
            return this.mHostPackageManager.getPreferredPackages(i);
        }

        public ProviderInfo getProviderInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(componentName);
            return loadedPlugin != null ? loadedPlugin.mProviderInfos.get(componentName) : this.mHostPackageManager.getProviderInfo(componentName, i);
        }

        public ActivityInfo getReceiverInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(componentName);
            return loadedPlugin != null ? loadedPlugin.mReceiverInfos.get(componentName) : this.mHostPackageManager.getReceiverInfo(componentName, i);
        }

        public Resources getResourcesForActivity(ComponentName componentName) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(componentName);
            return loadedPlugin != null ? loadedPlugin.mResources : this.mHostPackageManager.getResourcesForActivity(componentName);
        }

        public Resources getResourcesForApplication(ApplicationInfo applicationInfo) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(applicationInfo.packageName);
            return loadedPlugin != null ? loadedPlugin.mResources : this.mHostPackageManager.getResourcesForApplication(applicationInfo);
        }

        public Resources getResourcesForApplication(String str) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(str);
            return loadedPlugin != null ? loadedPlugin.mResources : this.mHostPackageManager.getResourcesForApplication(str);
        }

        public ServiceInfo getServiceInfo(ComponentName componentName, int i) throws PackageManager.NameNotFoundException {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(componentName);
            return loadedPlugin != null ? loadedPlugin.mServiceInfos.get(componentName) : this.mHostPackageManager.getServiceInfo(componentName, i);
        }

        @TargetApi(26)
        @NonNull
        public List<SharedLibraryInfo> getSharedLibraries(int i) {
            return this.mHostPackageManager.getSharedLibraries(i);
        }

        public FeatureInfo[] getSystemAvailableFeatures() {
            return this.mHostPackageManager.getSystemAvailableFeatures();
        }

        public String[] getSystemSharedLibraryNames() {
            return this.mHostPackageManager.getSystemSharedLibraryNames();
        }

        public CharSequence getText(String str, int i, ApplicationInfo applicationInfo) {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(str);
            return loadedPlugin != null ? loadedPlugin.mResources.getText(i) : this.mHostPackageManager.getText(str, i, applicationInfo);
        }

        @TargetApi(17)
        public Drawable getUserBadgeForDensity(UserHandle userHandle, int i) {
            try {
                return (Drawable) Reflector.with(this.mHostPackageManager).method("getUserBadgeForDensity", UserHandle.class, Integer.TYPE).call(userHandle, Integer.valueOf(i));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @TargetApi(21)
        public Drawable getUserBadgedDrawableForDensity(Drawable drawable, UserHandle userHandle, Rect rect, int i) {
            return this.mHostPackageManager.getUserBadgedDrawableForDensity(drawable, userHandle, rect, i);
        }

        @TargetApi(21)
        public Drawable getUserBadgedIcon(Drawable drawable, UserHandle userHandle) {
            return this.mHostPackageManager.getUserBadgedIcon(drawable, userHandle);
        }

        @TargetApi(21)
        public CharSequence getUserBadgedLabel(CharSequence charSequence, UserHandle userHandle) {
            return this.mHostPackageManager.getUserBadgedLabel(charSequence, userHandle);
        }

        public XmlResourceParser getXml(String str, int i, ApplicationInfo applicationInfo) {
            LoadedPlugin loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(str);
            return loadedPlugin != null ? loadedPlugin.mResources.getXml(i) : this.mHostPackageManager.getXml(str, i, applicationInfo);
        }

        public boolean hasSystemFeature(String str) {
            return this.mHostPackageManager.hasSystemFeature(str);
        }

        @TargetApi(24)
        public boolean hasSystemFeature(String str, int i) {
            return this.mHostPackageManager.hasSystemFeature(str, i);
        }

        @TargetApi(26)
        public boolean isInstantApp() {
            return this.mHostPackageManager.isInstantApp();
        }

        @TargetApi(26)
        public boolean isInstantApp(String str) {
            return this.mHostPackageManager.isInstantApp(str);
        }

        @TargetApi(23)
        public boolean isPermissionRevokedByPolicy(@NonNull String str, @NonNull String str2) {
            return this.mHostPackageManager.isPermissionRevokedByPolicy(str, str2);
        }

        public boolean isSafeMode() {
            return this.mHostPackageManager.isSafeMode();
        }

        public Drawable loadItemIcon(PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo) {
            if (packageItemInfo == null) {
                return null;
            }
            return packageItemInfo.loadIcon(this.mHostPackageManager);
        }

        public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i) {
            LoadedPlugin loadedPlugin;
            ActivityInfo receiverInfo;
            ComponentName component = intent.getComponent();
            if (component == null && intent.getSelector() != null) {
                intent = intent.getSelector();
                component = intent.getComponent();
            }
            if (component == null || (loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(component)) == null || (receiverInfo = loadedPlugin.getReceiverInfo(component)) == null) {
                ArrayList arrayList = new ArrayList();
                List<ResolveInfo> queryBroadcastReceivers = LoadedPlugin.this.mPluginManager.queryBroadcastReceivers(intent, i);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    arrayList.addAll(queryBroadcastReceivers);
                }
                List<ResolveInfo> queryBroadcastReceivers2 = this.mHostPackageManager.queryBroadcastReceivers(intent, i);
                if (queryBroadcastReceivers2 != null && queryBroadcastReceivers2.size() > 0) {
                    arrayList.addAll(queryBroadcastReceivers2);
                }
                return arrayList;
            }
            ResolveInfo resolveInfo = new ResolveInfo();
            resolveInfo.activityInfo = receiverInfo;
            return Arrays.asList(new ResolveInfo[]{resolveInfo});
        }

        public List<ProviderInfo> queryContentProviders(String str, int i, int i2) {
            return this.mHostPackageManager.queryContentProviders(str, i, i2);
        }

        public List<InstrumentationInfo> queryInstrumentation(String str, int i) {
            return this.mHostPackageManager.queryInstrumentation(str, i);
        }

        public List<ResolveInfo> queryIntentActivities(Intent intent, int i) {
            LoadedPlugin loadedPlugin;
            ActivityInfo activityInfo;
            ComponentName component = intent.getComponent();
            if (component == null && intent.getSelector() != null) {
                intent = intent.getSelector();
                component = intent.getComponent();
            }
            if (component == null || (loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(component)) == null || (activityInfo = loadedPlugin.getActivityInfo(component)) == null) {
                ArrayList arrayList = new ArrayList();
                List<ResolveInfo> queryIntentActivities = LoadedPlugin.this.mPluginManager.queryIntentActivities(intent, i);
                if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                    arrayList.addAll(queryIntentActivities);
                }
                List<ResolveInfo> queryIntentActivities2 = this.mHostPackageManager.queryIntentActivities(intent, i);
                if (queryIntentActivities2 != null && queryIntentActivities2.size() > 0) {
                    arrayList.addAll(queryIntentActivities2);
                }
                return arrayList;
            }
            ResolveInfo resolveInfo = new ResolveInfo();
            resolveInfo.activityInfo = activityInfo;
            return Arrays.asList(new ResolveInfo[]{resolveInfo});
        }

        public List<ResolveInfo> queryIntentActivityOptions(ComponentName componentName, Intent[] intentArr, Intent intent, int i) {
            return this.mHostPackageManager.queryIntentActivityOptions(componentName, intentArr, intent, i);
        }

        @TargetApi(19)
        public List<ResolveInfo> queryIntentContentProviders(Intent intent, int i) {
            return this.mHostPackageManager.queryIntentContentProviders(intent, i);
        }

        public List<ResolveInfo> queryIntentServices(Intent intent, int i) {
            LoadedPlugin loadedPlugin;
            ServiceInfo serviceInfo;
            ComponentName component = intent.getComponent();
            if (component == null && intent.getSelector() != null) {
                intent = intent.getSelector();
                component = intent.getComponent();
            }
            if (component == null || (loadedPlugin = LoadedPlugin.this.mPluginManager.getLoadedPlugin(component)) == null || (serviceInfo = loadedPlugin.getServiceInfo(component)) == null) {
                ArrayList arrayList = new ArrayList();
                List<ResolveInfo> queryIntentServices = LoadedPlugin.this.mPluginManager.queryIntentServices(intent, i);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    arrayList.addAll(queryIntentServices);
                }
                List<ResolveInfo> queryIntentServices2 = this.mHostPackageManager.queryIntentServices(intent, i);
                if (queryIntentServices2 != null && queryIntentServices2.size() > 0) {
                    arrayList.addAll(queryIntentServices2);
                }
                return arrayList;
            }
            ResolveInfo resolveInfo = new ResolveInfo();
            resolveInfo.serviceInfo = serviceInfo;
            return Arrays.asList(new ResolveInfo[]{resolveInfo});
        }

        public List<PermissionInfo> queryPermissionsByGroup(String str, int i) throws PackageManager.NameNotFoundException {
            return this.mHostPackageManager.queryPermissionsByGroup(str, i);
        }

        public void removePackageFromPreferred(String str) {
            this.mHostPackageManager.removePackageFromPreferred(str);
        }

        public void removePermission(String str) {
            this.mHostPackageManager.removePermission(str);
        }

        public ResolveInfo resolveActivity(Intent intent, int i) {
            ResolveInfo resolveActivity = LoadedPlugin.this.mPluginManager.resolveActivity(intent, i);
            return resolveActivity != null ? resolveActivity : this.mHostPackageManager.resolveActivity(intent, i);
        }

        public ProviderInfo resolveContentProvider(String str, int i) {
            ProviderInfo resolveContentProvider = LoadedPlugin.this.mPluginManager.resolveContentProvider(str, i);
            return resolveContentProvider != null ? resolveContentProvider : this.mHostPackageManager.resolveContentProvider(str, i);
        }

        public ResolveInfo resolveService(Intent intent, int i) {
            ResolveInfo resolveService = LoadedPlugin.this.mPluginManager.resolveService(intent, i);
            return resolveService != null ? resolveService : this.mHostPackageManager.resolveService(intent, i);
        }

        @TargetApi(26)
        public void setApplicationCategoryHint(@NonNull String str, int i) {
            this.mHostPackageManager.setApplicationCategoryHint(str, i);
        }

        public void setApplicationEnabledSetting(String str, int i, int i2) {
            this.mHostPackageManager.setApplicationEnabledSetting(str, i, i2);
        }

        public void setComponentEnabledSetting(ComponentName componentName, int i, int i2) {
            this.mHostPackageManager.setComponentEnabledSetting(componentName, i, i2);
        }

        public void setInstallerPackageName(String str, String str2) {
            if (LoadedPlugin.this.mPluginManager.getLoadedPlugin(str) == null) {
                this.mHostPackageManager.setInstallerPackageName(str, str2);
            }
        }

        @TargetApi(26)
        public void updateInstantAppCookie(@Nullable byte[] bArr) {
            this.mHostPackageManager.updateInstantAppCookie(bArr);
        }

        public void verifyPendingInstall(int i, int i2) {
            this.mHostPackageManager.verifyPendingInstall(i, i2);
        }
    }

    public LoadedPlugin(PluginManager pluginManager, Context context, File file) throws Exception {
        this.mPluginManager = pluginManager;
        this.mHostContext = context;
        this.mLocation = file.getAbsolutePath();
        this.mPackage = PackageParserCompat.parsePackage(context, file, 4);
        this.mPackage.applicationInfo.metaData = this.mPackage.mAppMetaData;
        this.mPackageInfo.applicationInfo = this.mPackage.applicationInfo;
        this.mPackageInfo.applicationInfo.sourceDir = file.getAbsolutePath();
        if (Build.VERSION.SDK_INT >= 28 || (Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT != 0)) {
            try {
                this.mPackageInfo.signatures = this.mPackage.mSigningDetails.signatures;
            } catch (Throwable unused) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
                this.mPackageInfo.signatures = packageInfo.signatures;
            }
        } else {
            this.mPackageInfo.signatures = this.mPackage.mSignatures;
        }
        this.mPackageInfo.packageName = this.mPackage.packageName;
        if (pluginManager.getLoadedPlugin(this.mPackageInfo.packageName) != null) {
            throw new RuntimeException("plugin has already been loaded : " + this.mPackageInfo.packageName);
        }
        this.mPackageInfo.versionCode = this.mPackage.mVersionCode;
        this.mPackageInfo.versionName = this.mPackage.mVersionName;
        this.mPackageInfo.permissions = new PermissionInfo[0];
        this.mPackageManager = createPluginPackageManager();
        this.mPluginContext = createPluginContext((Context) null);
        this.mNativeLibDir = getDir(context, Constants.NATIVE_DIR);
        this.mPackage.applicationInfo.nativeLibraryDir = this.mNativeLibDir.getAbsolutePath();
        this.mResources = createResources(context, getPackageName(), file);
        this.mClassLoader = createClassLoader(context, file, this.mNativeLibDir, context.getClassLoader());
        tryToCopyNativeLib(file);
        HashMap hashMap = new HashMap();
        Iterator it = this.mPackage.instrumentation.iterator();
        while (it.hasNext()) {
            PackageParser.Instrumentation instrumentation = (PackageParser.Instrumentation) it.next();
            hashMap.put(instrumentation.getComponentName(), instrumentation.info);
        }
        this.mInstrumentationInfos = Collections.unmodifiableMap(hashMap);
        this.mPackageInfo.instrumentation = (InstrumentationInfo[]) hashMap.values().toArray(new InstrumentationInfo[hashMap.size()]);
        HashMap hashMap2 = new HashMap();
        Iterator it2 = this.mPackage.activities.iterator();
        while (it2.hasNext()) {
            PackageParser.Activity activity = (PackageParser.Activity) it2.next();
            activity.info.metaData = activity.metaData;
            hashMap2.put(activity.getComponentName(), activity.info);
        }
        this.mActivityInfos = Collections.unmodifiableMap(hashMap2);
        this.mPackageInfo.activities = (ActivityInfo[]) hashMap2.values().toArray(new ActivityInfo[hashMap2.size()]);
        HashMap hashMap3 = new HashMap();
        Iterator it3 = this.mPackage.services.iterator();
        while (it3.hasNext()) {
            PackageParser.Service service = (PackageParser.Service) it3.next();
            hashMap3.put(service.getComponentName(), service.info);
        }
        this.mServiceInfos = Collections.unmodifiableMap(hashMap3);
        this.mPackageInfo.services = (ServiceInfo[]) hashMap3.values().toArray(new ServiceInfo[hashMap3.size()]);
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        Iterator it4 = this.mPackage.providers.iterator();
        while (it4.hasNext()) {
            PackageParser.Provider provider = (PackageParser.Provider) it4.next();
            hashMap4.put(provider.info.authority, provider.info);
            hashMap5.put(provider.getComponentName(), provider.info);
        }
        this.mProviders = Collections.unmodifiableMap(hashMap4);
        this.mProviderInfos = Collections.unmodifiableMap(hashMap5);
        this.mPackageInfo.providers = (ProviderInfo[]) hashMap5.values().toArray(new ProviderInfo[hashMap5.size()]);
        HashMap hashMap6 = new HashMap();
        Iterator it5 = this.mPackage.receivers.iterator();
        while (it5.hasNext()) {
            PackageParser.Activity activity2 = (PackageParser.Activity) it5.next();
            hashMap6.put(activity2.getComponentName(), activity2.info);
            BroadcastReceiver cast = BroadcastReceiver.class.cast(getClassLoader().loadClass(activity2.getComponentName().getClassName()).newInstance());
            Iterator it6 = activity2.intents.iterator();
            while (it6.hasNext()) {
                this.mHostContext.registerReceiver(cast, (PackageParser.ActivityIntentInfo) it6.next());
            }
        }
        this.mReceiverInfos = Collections.unmodifiableMap(hashMap6);
        this.mPackageInfo.receivers = (ActivityInfo[]) hashMap6.values().toArray(new ActivityInfo[hashMap6.size()]);
        invokeApplication();
    }

    /* access modifiers changed from: protected */
    public ResolveInfo chooseBestActivity(Intent intent, String str, int i, List<ResolveInfo> list) {
        return list.get(0);
    }

    /* access modifiers changed from: protected */
    public AssetManager createAssetManager(Context context, File file) throws Exception {
        AssetManager newInstance = AssetManager.class.newInstance();
        Reflector.with(newInstance).method("addAssetPath", String.class).call(file.getAbsolutePath());
        return newInstance;
    }

    /* access modifiers changed from: protected */
    public ClassLoader createClassLoader(Context context, File file, File file2, ClassLoader classLoader) throws Exception {
        DexUtil.insertDex(new DexClassLoader(file.getAbsolutePath(), getDir(context, Constants.OPTIMIZE_DIR).getAbsolutePath(), file2.getAbsolutePath(), classLoader), classLoader, file2);
        return classLoader;
    }

    public PluginContext createPluginContext(Context context) {
        return context == null ? new PluginContext(this) : new PluginContext(this, context);
    }

    /* access modifiers changed from: protected */
    public PluginPackageManager createPluginPackageManager() {
        return new PluginPackageManager();
    }

    /* access modifiers changed from: protected */
    public Resources createResources(Context context, String str, File file) throws Exception {
        return ResourcesManager.createResources(context, str, file);
    }

    public ActivityInfo getActivityInfo(ComponentName componentName) {
        return this.mActivityInfos.get(componentName);
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public ApplicationInfo getApplicationInfo() {
        return this.mPackage.applicationInfo;
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public ClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public String getCodePath() {
        return this.mPackage.applicationInfo.sourceDir;
    }

    /* access modifiers changed from: protected */
    public File getDir(Context context, String str) {
        return context.getDir(str, 0);
    }

    public Context getHostContext() {
        return this.mHostContext;
    }

    public Intent getLaunchIntent() {
        ContentResolver contentResolver = this.mPluginContext.getContentResolver();
        Intent addCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
        Iterator it = this.mPackage.activities.iterator();
        while (it.hasNext()) {
            PackageParser.Activity activity = (PackageParser.Activity) it.next();
            Iterator it2 = activity.intents.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((PackageParser.ActivityIntentInfo) it2.next()).match(contentResolver, addCategory, false, "VA.LoadedPlugin") > 0) {
                        return Intent.makeMainActivity(activity.getComponentName());
                    }
                }
            }
        }
        return null;
    }

    public Intent getLeanbackLaunchIntent() {
        ContentResolver contentResolver = this.mPluginContext.getContentResolver();
        Intent addCategory = new Intent("android.intent.action.MAIN").addCategory(IntentCompat.CATEGORY_LEANBACK_LAUNCHER);
        Iterator it = this.mPackage.activities.iterator();
        while (it.hasNext()) {
            PackageParser.Activity activity = (PackageParser.Activity) it.next();
            Iterator it2 = activity.intents.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((PackageParser.ActivityIntentInfo) it2.next()).match(contentResolver, addCategory, false, "VA.LoadedPlugin") > 0) {
                        Intent intent = new Intent("android.intent.action.MAIN");
                        intent.setComponent(activity.getComponentName());
                        intent.addCategory(IntentCompat.CATEGORY_LEANBACK_LAUNCHER);
                        return intent;
                    }
                }
            }
        }
        return null;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public PackageInfo getPackageInfo() {
        return this.mPackageInfo;
    }

    public PackageManager getPackageManager() {
        return this.mPackageManager;
    }

    public String getPackageName() {
        return this.mPackage.packageName;
    }

    public String getPackageResourcePath() {
        int myUid = Process.myUid();
        ApplicationInfo applicationInfo = this.mPackage.applicationInfo;
        return applicationInfo.uid == myUid ? applicationInfo.sourceDir : applicationInfo.publicSourceDir;
    }

    public Context getPluginContext() {
        return this.mPluginContext;
    }

    public PluginManager getPluginManager() {
        return this.mPluginManager;
    }

    public ProviderInfo getProviderInfo(ComponentName componentName) {
        return this.mProviderInfos.get(componentName);
    }

    public ActivityInfo getReceiverInfo(ComponentName componentName) {
        return this.mReceiverInfos.get(componentName);
    }

    public Resources getResources() {
        return this.mResources;
    }

    public ServiceInfo getServiceInfo(ComponentName componentName) {
        return this.mServiceInfos.get(componentName);
    }

    public Resources.Theme getTheme() {
        Resources.Theme newTheme = this.mResources.newTheme();
        newTheme.applyStyle(PluginUtil.selectDefaultTheme(this.mPackage.applicationInfo.theme, Build.VERSION.SDK_INT), false);
        return newTheme;
    }

    public void invokeApplication() throws Exception {
        final Exception[] excArr = new Exception[1];
        RunUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (LoadedPlugin.this.mApplication == null) {
                    try {
                        LoadedPlugin.this.mApplication = LoadedPlugin.this.makeApplication(false, LoadedPlugin.this.mPluginManager.getInstrumentation());
                    } catch (Exception e) {
                        excArr[0] = e;
                    }
                }
            }
        }, true);
        if (excArr[0] != null) {
            throw excArr[0];
        }
    }

    /* access modifiers changed from: protected */
    public Application makeApplication(boolean z, Instrumentation instrumentation) throws Exception {
        if (this.mApplication != null) {
            return this.mApplication;
        }
        String str = this.mPackage.applicationInfo.className;
        if (z || str == null) {
            str = "android.app.Application";
        }
        this.mApplication = instrumentation.newApplication(this.mClassLoader, str, getPluginContext());
        this.mApplication.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacksProxy());
        instrumentation.callApplicationOnCreate(this.mApplication);
        return this.mApplication;
    }

    /* access modifiers changed from: protected */
    public boolean match(PackageParser.Component component, ComponentName componentName) {
        ComponentName componentName2 = component.getComponentName();
        if (componentName2 == componentName) {
            return true;
        }
        if (componentName2 == null || componentName == null || !componentName2.getClassName().equals(componentName.getClassName())) {
            return false;
        }
        return componentName2.getPackageName().equals(componentName.getPackageName()) || this.mHostContext.getPackageName().equals(componentName.getPackageName());
    }

    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i) {
        ResolveInfo resolveInfo;
        ComponentName component = intent.getComponent();
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = this.mPluginContext.getContentResolver();
        Iterator it = this.mPackage.receivers.iterator();
        while (it.hasNext()) {
            PackageParser.Activity activity = (PackageParser.Activity) it.next();
            if (activity.getComponentName().equals(component)) {
                resolveInfo = new ResolveInfo();
            } else if (component == null) {
                Iterator it2 = activity.intents.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((PackageParser.ActivityIntentInfo) it2.next()).match(contentResolver, intent, true, "VA.LoadedPlugin") >= 0) {
                            resolveInfo = new ResolveInfo();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            resolveInfo.activityInfo = activity.info;
            arrayList.add(resolveInfo);
        }
        return arrayList;
    }

    public List<ResolveInfo> queryIntentActivities(Intent intent, int i) {
        ResolveInfo resolveInfo;
        ComponentName component = intent.getComponent();
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = this.mPluginContext.getContentResolver();
        Iterator it = this.mPackage.activities.iterator();
        while (it.hasNext()) {
            PackageParser.Activity activity = (PackageParser.Activity) it.next();
            if (match(activity, component)) {
                resolveInfo = new ResolveInfo();
            } else if (component == null) {
                Iterator it2 = activity.intents.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((PackageParser.ActivityIntentInfo) it2.next()).match(contentResolver, intent, true, "VA.LoadedPlugin") >= 0) {
                            resolveInfo = new ResolveInfo();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            resolveInfo.activityInfo = activity.info;
            arrayList.add(resolveInfo);
        }
        return arrayList;
    }

    public List<ResolveInfo> queryIntentServices(Intent intent, int i) {
        ResolveInfo resolveInfo;
        ComponentName component = intent.getComponent();
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = this.mPluginContext.getContentResolver();
        Iterator it = this.mPackage.services.iterator();
        while (it.hasNext()) {
            PackageParser.Service service = (PackageParser.Service) it.next();
            if (match(service, component)) {
                resolveInfo = new ResolveInfo();
            } else if (component == null) {
                Iterator it2 = service.intents.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((PackageParser.ServiceIntentInfo) it2.next()).match(contentResolver, intent, true, "VA.LoadedPlugin") >= 0) {
                            resolveInfo = new ResolveInfo();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            resolveInfo.serviceInfo = service.info;
            arrayList.add(resolveInfo);
        }
        return arrayList;
    }

    public ResolveInfo resolveActivity(Intent intent, int i) {
        List<ResolveInfo> queryIntentActivities = queryIntentActivities(intent, i);
        if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
            return null;
        }
        return chooseBestActivity(intent, intent.resolveTypeIfNeeded(this.mPluginContext.getContentResolver()), i, queryIntentActivities);
    }

    public ProviderInfo resolveContentProvider(String str, int i) {
        return this.mProviders.get(str);
    }

    public ResolveInfo resolveService(Intent intent, int i) {
        List<ResolveInfo> queryIntentServices = queryIntentServices(intent, i);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        return chooseBestActivity(intent, intent.resolveTypeIfNeeded(this.mPluginContext.getContentResolver()), i, queryIntentServices);
    }

    public void setTheme(int i) {
        Reflector.QuietReflector.with(this.mResources).field("mThemeResId").set((Object) Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public void tryToCopyNativeLib(File file) throws Exception {
        PluginUtil.copyNativeLib(file, this.mHostContext, this.mPackageInfo, this.mNativeLibDir);
    }

    public void updateResources(Resources resources) {
        this.mResources = resources;
    }
}

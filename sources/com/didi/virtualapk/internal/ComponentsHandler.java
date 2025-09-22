package com.didi.virtualapk.internal;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.IBinder;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.didi.virtualapk.PluginManager;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentsHandler {
    public static final String TAG = "VA.PluginManager";
    private ArrayMap<IBinder, Intent> mBoundServices = new ArrayMap<>();
    private Context mContext;
    private PluginManager mPluginManager;
    private ArrayMap<Service, AtomicInteger> mServiceCounters = new ArrayMap<>();
    private ArrayMap<ComponentName, Service> mServices = new ArrayMap<>();
    private StubActivityInfo mStubActivityInfo = new StubActivityInfo();

    public ComponentsHandler(PluginManager pluginManager) {
        this.mPluginManager = pluginManager;
        this.mContext = pluginManager.getHostContext();
    }

    private void dispatchStubActivity(Intent intent) {
        ComponentName component = intent.getComponent();
        String className = intent.getComponent().getClassName();
        LoadedPlugin loadedPlugin = this.mPluginManager.getLoadedPlugin(intent);
        ActivityInfo activityInfo = loadedPlugin.getActivityInfo(component);
        if (activityInfo == null) {
            throw new RuntimeException("can not find " + component);
        }
        int i = activityInfo.launchMode;
        Resources.Theme newTheme = loadedPlugin.getResources().newTheme();
        newTheme.applyStyle(activityInfo.theme, true);
        String stubActivity = this.mStubActivityInfo.getStubActivity(className, i, newTheme);
        Log.i("VA.PluginManager", String.format("dispatchStubActivity,[%s -> %s]", new Object[]{className, stubActivity}));
        intent.setClassName(this.mContext, stubActivity);
    }

    public Intent forgetIServiceConnection(IBinder iBinder) {
        Intent remove;
        synchronized (this.mBoundServices) {
            remove = this.mBoundServices.remove(iBinder);
        }
        return remove;
    }

    public Service forgetService(ComponentName componentName) {
        Service remove;
        synchronized (this.mServices) {
            remove = this.mServices.remove(componentName);
            this.mServiceCounters.remove(remove);
        }
        return remove;
    }

    public Service getService(ComponentName componentName) {
        return this.mServices.get(componentName);
    }

    public AtomicInteger getServiceCounter(Service service) {
        return this.mServiceCounters.get(service);
    }

    public boolean isServiceAvailable(ComponentName componentName) {
        return this.mServices.containsKey(componentName);
    }

    public void markIntentIfNeeded(Intent intent) {
        if (intent.getComponent() != null) {
            String packageName = intent.getComponent().getPackageName();
            String className = intent.getComponent().getClassName();
            if (!packageName.equals(this.mContext.getPackageName()) && this.mPluginManager.getLoadedPlugin(packageName) != null) {
                Set<String> categories = intent.getCategories();
                if (categories != null) {
                    intent.putStringArrayListExtra(Constants.KEY_CATEGORY, new ArrayList(categories));
                    categories.clear();
                }
                intent.addCategory(Constants.CATEGORY_PREFIX_TARGET_PACKAGE + packageName);
                intent.addCategory(Constants.CATEGORY_PREFIX_TARGET_ACTIVITY + className);
                dispatchStubActivity(intent);
            }
        }
    }

    public void remberIServiceConnection(IBinder iBinder, Intent intent) {
        synchronized (this.mBoundServices) {
            this.mBoundServices.put(iBinder, intent);
        }
    }

    public void rememberService(ComponentName componentName, Service service) {
        synchronized (this.mServices) {
            this.mServices.put(componentName, service);
            this.mServiceCounters.put(service, new AtomicInteger(0));
        }
    }

    public Intent transformIntentToExplicitAsNeeded(Intent intent) {
        ResolveInfo resolveActivity;
        ComponentName component = intent.getComponent();
        if (!((component != null && !component.getPackageName().equals(this.mContext.getPackageName())) || (resolveActivity = this.mPluginManager.resolveActivity(intent)) == null || resolveActivity.activityInfo == null)) {
            intent.setComponent(new ComponentName(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.name));
        }
        return intent;
    }
}

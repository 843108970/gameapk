package com.didi.virtualapk;

import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.app.Application;
import android.app.IActivityManager;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.IContentProvider;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Singleton;
import com.didi.virtualapk.delegate.ActivityManagerProxy;
import com.didi.virtualapk.delegate.IContentProviderProxy;
import com.didi.virtualapk.delegate.RemoteContentProvider;
import com.didi.virtualapk.internal.ComponentsHandler;
import com.didi.virtualapk.internal.LoadedPlugin;
import com.didi.virtualapk.internal.VAInstrumentation;
import com.didi.virtualapk.internal.utils.PluginUtil;
import com.didi.virtualapk.utils.Reflector;
import com.didi.virtualapk.utils.RunUtil;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PluginManager {
    public static final String TAG = "VA.PluginManager";
    private static volatile PluginManager sInstance;
    protected IActivityManager mActivityManager;
    protected final Application mApplication;
    protected final List<Callback> mCallbacks = new ArrayList();
    protected ComponentsHandler mComponentsHandler;
    protected final Context mContext;
    protected IContentProvider mIContentProvider;
    protected VAInstrumentation mInstrumentation;
    protected final Map<String, LoadedPlugin> mPlugins = new ConcurrentHashMap();

    public interface Callback {
        void onAddedLoadedPlugin(LoadedPlugin loadedPlugin);
    }

    protected PluginManager(Context context) {
        if (context instanceof Application) {
            this.mApplication = (Application) context;
        } else {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                this.mContext = context;
                this.mApplication = ActivityThread.currentApplication();
                this.mComponentsHandler = createComponentsHandler();
                hookCurrentProcess();
            }
            this.mApplication = (Application) applicationContext;
        }
        this.mContext = this.mApplication.getBaseContext();
        this.mComponentsHandler = createComponentsHandler();
        hookCurrentProcess();
    }

    private static PluginManager createInstance(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return new PluginManager(context);
            }
            String string = bundle.getString("VA_FACTORY");
            if (string == null) {
                return new PluginManager(context);
            }
            PluginManager pluginManager = (PluginManager) Reflector.on(string).method("create", Context.class).call(context);
            if (pluginManager != null) {
                Log.d("VA.PluginManager", "Created a instance of " + pluginManager.getClass());
                return pluginManager;
            }
            return new PluginManager(context);
        } catch (Exception e) {
            Log.w("VA.PluginManager", "Created the instance error!", e);
        }
    }

    public static PluginManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (PluginManager.class) {
                if (sInstance == null) {
                    sInstance = createInstance(context);
                }
            }
        }
        return sInstance;
    }

    public void addCallback(Callback callback) {
        if (callback != null) {
            synchronized (this.mCallbacks) {
                if (this.mCallbacks.contains(callback)) {
                    throw new RuntimeException("Already added " + callback + "!");
                }
                this.mCallbacks.add(callback);
            }
        }
    }

    /* access modifiers changed from: protected */
    public ActivityManagerProxy createActivityManagerProxy(IActivityManager iActivityManager) throws Exception {
        return new ActivityManagerProxy(this, iActivityManager);
    }

    /* access modifiers changed from: protected */
    public ComponentsHandler createComponentsHandler() {
        return new ComponentsHandler(this);
    }

    /* access modifiers changed from: protected */
    public VAInstrumentation createInstrumentation(Instrumentation instrumentation) throws Exception {
        return new VAInstrumentation(this, instrumentation);
    }

    /* access modifiers changed from: protected */
    public LoadedPlugin createLoadedPlugin(File file) throws Exception {
        return new LoadedPlugin(this, this.mContext, file);
    }

    /* access modifiers changed from: protected */
    public void doInWorkThread() {
    }

    public IActivityManager getActivityManager() {
        return this.mActivityManager;
    }

    public List<LoadedPlugin> getAllLoadedPlugins() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mPlugins.values());
        return arrayList;
    }

    public ComponentsHandler getComponentsHandler() {
        return this.mComponentsHandler;
    }

    public Application getHostApplication() {
        return this.mApplication;
    }

    public Context getHostContext() {
        return this.mContext;
    }

    public synchronized IContentProvider getIContentProvider() {
        if (this.mIContentProvider == null) {
            hookIContentProviderAsNeeded();
        }
        return this.mIContentProvider;
    }

    public VAInstrumentation getInstrumentation() {
        return this.mInstrumentation;
    }

    public LoadedPlugin getLoadedPlugin(ComponentName componentName) {
        if (componentName == null) {
            return null;
        }
        return getLoadedPlugin(componentName.getPackageName());
    }

    public LoadedPlugin getLoadedPlugin(Intent intent) {
        return getLoadedPlugin(PluginUtil.getComponent(intent));
    }

    public LoadedPlugin getLoadedPlugin(String str) {
        return this.mPlugins.get(str);
    }

    /* access modifiers changed from: protected */
    public void hookCurrentProcess() {
        hookInstrumentationAndHandler();
        hookSystemServices();
        hookDataBindingUtil();
    }

    /* access modifiers changed from: protected */
    public void hookDataBindingUtil() {
        Reflector.QuietReflector field = Reflector.QuietReflector.on("android.databinding.DataBindingUtil").field("sMapper");
        if (field.get() != null) {
            try {
                Callback callback = (Callback) Reflector.on("android.databinding.DataBinderMapperProxy").constructor(new Class[0]).newInstance(new Object[0]);
                field.set((Object) callback);
                addCallback(callback);
                Log.d("VA.PluginManager", "hookDataBindingUtil succeed : " + callback);
            } catch (Reflector.ReflectedException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void hookIContentProviderAsNeeded() {
        Field field = null;
        this.mContext.getContentResolver().call(Uri.parse(RemoteContentProvider.getUri(this.mContext)), "wakeup", (String) null, (Bundle) null);
        try {
            for (Map.Entry entry : ((Map) Reflector.with(ActivityThread.currentActivityThread()).field("mProviderMap").get()).entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (!(key instanceof String)) {
                    if (field == null) {
                        field = key.getClass().getDeclaredField("authority");
                        field.setAccessible(true);
                    }
                    key = field.get(key);
                }
                if (((String) key).equals(RemoteContentProvider.getAuthority(this.mContext))) {
                    Field declaredField = value.getClass().getDeclaredField("mProvider");
                    declaredField.setAccessible(true);
                    this.mIContentProvider = IContentProviderProxy.newInstance(this.mContext, (IContentProvider) declaredField.get(value));
                    Log.d("VA.PluginManager", "hookIContentProvider succeed : " + this.mIContentProvider);
                    return;
                }
            }
        } catch (Exception e) {
            Log.w("VA.PluginManager", e);
        }
    }

    /* access modifiers changed from: protected */
    public void hookInstrumentationAndHandler() {
        try {
            ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
            VAInstrumentation createInstrumentation = createInstrumentation(currentActivityThread.getInstrumentation());
            Reflector.with(currentActivityThread).field("mInstrumentation").set(createInstrumentation);
            Reflector.with((Handler) Reflector.with(currentActivityThread).method("getHandler", new Class[0]).call(new Object[0])).field("mCallback").set(createInstrumentation);
            this.mInstrumentation = createInstrumentation;
            Log.d("VA.PluginManager", "hookInstrumentationAndHandler succeed : " + this.mInstrumentation);
        } catch (Exception e) {
            Log.w("VA.PluginManager", e);
        }
    }

    /* access modifiers changed from: protected */
    public void hookSystemServices() {
        try {
            Singleton singleton = (Singleton) (Build.VERSION.SDK_INT >= 26 ? Reflector.on((Class<?>) ActivityManager.class).field("IActivityManagerSingleton").get() : Reflector.on((Class<?>) ActivityManagerNative.class).field("gDefault").get());
            IActivityManager iActivityManager = (IActivityManager) Proxy.newProxyInstance(this.mContext.getClassLoader(), new Class[]{IActivityManager.class}, createActivityManagerProxy((IActivityManager) singleton.get()));
            Reflector.with(singleton).field("mInstance").set(iActivityManager);
            if (singleton.get() == iActivityManager) {
                this.mActivityManager = iActivityManager;
                Log.d("VA.PluginManager", "hookSystemServices succeed : " + this.mActivityManager);
            }
        } catch (Exception e) {
            Log.w("VA.PluginManager", e);
        }
    }

    public void init() {
        RunUtil.getThreadPool().execute(new Runnable() {
            public void run() {
                PluginManager.this.doInWorkThread();
            }
        });
    }

    public void loadPlugin(File file) throws Exception {
        if (file == null) {
            throw new IllegalArgumentException("error : apk is null.");
        }
        if (!file.exists()) {
            new FileInputStream(file).close();
        }
        LoadedPlugin createLoadedPlugin = createLoadedPlugin(file);
        if (createLoadedPlugin == null) {
            throw new RuntimeException("Can't load plugin which is invalid: " + file.getAbsolutePath());
        }
        this.mPlugins.put(createLoadedPlugin.getPackageName(), createLoadedPlugin);
        synchronized (this.mCallbacks) {
            for (int i = 0; i < this.mCallbacks.size(); i++) {
                this.mCallbacks.get(i).onAddedLoadedPlugin(createLoadedPlugin);
            }
        }
    }

    @Deprecated
    public List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i) {
        ArrayList arrayList = new ArrayList();
        for (LoadedPlugin queryBroadcastReceivers : this.mPlugins.values()) {
            List<ResolveInfo> queryBroadcastReceivers2 = queryBroadcastReceivers.queryBroadcastReceivers(intent, i);
            if (queryBroadcastReceivers2 != null && queryBroadcastReceivers2.size() > 0) {
                arrayList.addAll(queryBroadcastReceivers2);
            }
        }
        return arrayList;
    }

    @Deprecated
    public List<ResolveInfo> queryIntentActivities(Intent intent, int i) {
        ArrayList arrayList = new ArrayList();
        for (LoadedPlugin queryIntentActivities : this.mPlugins.values()) {
            List<ResolveInfo> queryIntentActivities2 = queryIntentActivities.queryIntentActivities(intent, i);
            if (queryIntentActivities2 != null && queryIntentActivities2.size() > 0) {
                arrayList.addAll(queryIntentActivities2);
            }
        }
        return arrayList;
    }

    @Deprecated
    public List<ResolveInfo> queryIntentServices(Intent intent, int i) {
        ArrayList arrayList = new ArrayList();
        for (LoadedPlugin queryIntentServices : this.mPlugins.values()) {
            List<ResolveInfo> queryIntentServices2 = queryIntentServices.queryIntentServices(intent, i);
            if (queryIntentServices2 != null && queryIntentServices2.size() > 0) {
                arrayList.addAll(queryIntentServices2);
            }
        }
        return arrayList;
    }

    public void removeCallback(Callback callback) {
        synchronized (this.mCallbacks) {
            this.mCallbacks.remove(callback);
        }
    }

    public ResolveInfo resolveActivity(Intent intent) {
        return resolveActivity(intent, 0);
    }

    public ResolveInfo resolveActivity(Intent intent, int i) {
        for (LoadedPlugin resolveActivity : this.mPlugins.values()) {
            ResolveInfo resolveActivity2 = resolveActivity.resolveActivity(intent, i);
            if (resolveActivity2 != null) {
                return resolveActivity2;
            }
        }
        return null;
    }

    public ProviderInfo resolveContentProvider(String str, int i) {
        for (LoadedPlugin resolveContentProvider : this.mPlugins.values()) {
            ProviderInfo resolveContentProvider2 = resolveContentProvider.resolveContentProvider(str, i);
            if (resolveContentProvider2 != null) {
                return resolveContentProvider2;
            }
        }
        return null;
    }

    public ResolveInfo resolveService(Intent intent, int i) {
        for (LoadedPlugin resolveService : this.mPlugins.values()) {
            ResolveInfo resolveService2 = resolveService.resolveService(intent, i);
            if (resolveService2 != null) {
                return resolveService2;
            }
        }
        return null;
    }
}

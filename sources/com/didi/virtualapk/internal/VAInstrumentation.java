package com.didi.virtualapk.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Instrumentation;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PersistableBundle;
import android.util.Log;
import com.didi.virtualapk.PluginManager;
import com.didi.virtualapk.delegate.StubActivity;
import com.didi.virtualapk.internal.utils.PluginUtil;
import com.didi.virtualapk.utils.Reflector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class VAInstrumentation extends Instrumentation implements Handler.Callback {
    public static final int LAUNCH_ACTIVITY = 100;
    public static final String TAG = "VA.VAInstrumentation";
    protected final ArrayList<WeakReference<Activity>> mActivities = new ArrayList<>();
    protected Instrumentation mBase;
    protected PluginManager mPluginManager;

    public VAInstrumentation(PluginManager pluginManager, Instrumentation instrumentation) {
        this.mPluginManager = pluginManager;
        this.mBase = instrumentation;
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        injectActivity(activity);
        this.mBase.callActivityOnCreate(activity, bundle);
    }

    @TargetApi(21)
    public void callActivityOnCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        injectActivity(activity);
        this.mBase.callActivityOnCreate(activity, bundle, persistableBundle);
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i) {
        injectIntent(intent);
        return this.mBase.execStartActivity(context, iBinder, iBinder2, activity, intent, i);
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i, Bundle bundle) {
        injectIntent(intent);
        return this.mBase.execStartActivity(context, iBinder, iBinder2, activity, intent, i, bundle);
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Fragment fragment, Intent intent, int i, Bundle bundle) {
        injectIntent(intent);
        return this.mBase.execStartActivity(context, iBinder, iBinder2, fragment, intent, i, bundle);
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, String str, Intent intent, int i, Bundle bundle) {
        injectIntent(intent);
        return this.mBase.execStartActivity(context, iBinder, iBinder2, str, intent, i, bundle);
    }

    /* access modifiers changed from: package-private */
    public List<WeakReference<Activity>> getActivities() {
        ArrayList arrayList;
        synchronized (this.mActivities) {
            arrayList = new ArrayList(this.mActivities);
        }
        return arrayList;
    }

    public ComponentName getComponentName() {
        return this.mBase.getComponentName();
    }

    public Context getContext() {
        return this.mBase.getContext();
    }

    public Context getTargetContext() {
        return this.mBase.getTargetContext();
    }

    public boolean handleMessage(Message message) {
        int theme;
        if (message.what != 100) {
            return false;
        }
        try {
            Reflector with = Reflector.with(message.obj);
            Intent intent = (Intent) with.field("intent").get();
            ActivityInfo activityInfo = (ActivityInfo) with.field("activityInfo").get();
            if (!PluginUtil.isIntentFromPlugin(intent) || (theme = PluginUtil.getTheme(this.mPluginManager.getHostContext(), intent)) == 0) {
                return false;
            }
            Log.i(TAG, "resolve theme, current theme:" + activityInfo.theme + "  after :0x" + Integer.toHexString(theme));
            activityInfo.theme = theme;
            return false;
        } catch (Exception e) {
            Log.w(TAG, e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void injectActivity(Activity activity) {
        Intent intent = activity.getIntent();
        if (PluginUtil.isIntentFromPlugin(intent)) {
            Context baseContext = activity.getBaseContext();
            try {
                LoadedPlugin loadedPlugin = this.mPluginManager.getLoadedPlugin(intent);
                Reflector.with(baseContext).field("mResources").set(loadedPlugin.getResources());
                Reflector with = Reflector.with(activity);
                with.field("mBase").set(loadedPlugin.createPluginContext(activity.getBaseContext()));
                with.field("mApplication").set(loadedPlugin.getApplication());
                ActivityInfo activityInfo = loadedPlugin.getActivityInfo(PluginUtil.getComponent(intent));
                if (activityInfo.screenOrientation != -1) {
                    activity.setRequestedOrientation(activityInfo.screenOrientation);
                }
                ComponentName component = PluginUtil.getComponent(intent);
                Intent intent2 = new Intent(intent);
                intent2.setClassName(component.getPackageName(), component.getClassName());
                intent2.setExtrasClassLoader(activity.getClassLoader());
                activity.setIntent(intent2);
            } catch (Exception e) {
                Log.w(TAG, e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void injectIntent(Intent intent) {
        this.mPluginManager.getComponentsHandler().transformIntentToExplicitAsNeeded(intent);
        if (intent.getComponent() != null) {
            Log.i(TAG, String.format("execStartActivity[%s : %s]", new Object[]{intent.getComponent().getPackageName(), intent.getComponent().getClassName()}));
            this.mPluginManager.getComponentsHandler().markIntentIfNeeded(intent);
        }
    }

    /* access modifiers changed from: protected */
    public Activity newActivity(Activity activity) {
        synchronized (this.mActivities) {
            for (int size = this.mActivities.size() - 1; size >= 0; size--) {
                if (this.mActivities.get(size).get() == null) {
                    this.mActivities.remove(size);
                }
            }
            this.mActivities.add(new WeakReference(activity));
        }
        return activity;
    }

    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Activity newActivity;
        boolean z = false;
        try {
            classLoader.loadClass(str);
            Log.i(TAG, String.format("newActivity[%s]", new Object[]{str}));
        } catch (ClassNotFoundException unused) {
            ComponentName component = PluginUtil.getComponent(intent);
            if (component != null) {
                String className = component.getClassName();
                Log.i(TAG, String.format("newActivity[%s : %s/%s]", new Object[]{str, component.getPackageName(), className}));
                LoadedPlugin loadedPlugin = this.mPluginManager.getLoadedPlugin(component);
                if (loadedPlugin != null) {
                    newActivity = this.mBase.newActivity(loadedPlugin.getClassLoader(), className, intent);
                    newActivity.setIntent(intent);
                    Reflector.QuietReflector.with(newActivity).field("mResources").set((Object) loadedPlugin.getResources());
                } else if ((2 & this.mPluginManager.getHostContext().getApplicationInfo().flags) != 0) {
                    z = true;
                }
            }
        } catch (Throwable unused2) {
        }
        newActivity = this.mBase.newActivity(classLoader, str, intent);
        return newActivity(newActivity);
        if (z) {
            throw new ActivityNotFoundException("error intent: " + intent.toURI());
        }
        Log.i(TAG, "Not found. starting the stub activity: " + StubActivity.class);
        newActivity = this.mBase.newActivity(classLoader, StubActivity.class.getName(), intent);
        return newActivity(newActivity);
    }

    public Application newApplication(ClassLoader classLoader, String str, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return this.mBase.newApplication(classLoader, str, context);
    }
}

package com.didi.virtualapk.delegate;

import android.app.IActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.didi.virtualapk.PluginManager;
import com.didi.virtualapk.internal.utils.PluginUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ActivityManagerProxy implements InvocationHandler {
    public static final int INTENT_SENDER_ACTIVITY = 2;
    public static final int INTENT_SENDER_ACTIVITY_RESULT = 3;
    public static final int INTENT_SENDER_BROADCAST = 1;
    public static final int INTENT_SENDER_SERVICE = 4;
    private static final String TAG = "VA.IActivityManagerProxy";
    private IActivityManager mActivityManager;
    private PluginManager mPluginManager;

    public ActivityManagerProxy(PluginManager pluginManager, IActivityManager iActivityManager) {
        this.mPluginManager = pluginManager;
        this.mActivityManager = iActivityManager;
    }

    /* access modifiers changed from: protected */
    public Object bindService(Object obj, Method method, Object[] objArr) throws Throwable {
        Intent intent = objArr[2];
        ResolveInfo resolveService = this.mPluginManager.resolveService(intent, 0);
        if (resolveService == null || resolveService.serviceInfo == null) {
            return method.invoke(this.mActivityManager, objArr);
        }
        Bundle bundle = new Bundle();
        PluginUtil.putBinder(bundle, "sc", objArr[4]);
        startDelegateServiceForTarget(intent, resolveService.serviceInfo, bundle, 3);
        this.mPluginManager.getComponentsHandler().remberIServiceConnection(objArr[4], intent);
        return 1;
    }

    /* access modifiers changed from: protected */
    public void getIntentSender(Method method, Object[] objArr) {
        ResolveInfo resolveService;
        objArr[1] = this.mPluginManager.getHostContext().getPackageName();
        Intent intent = objArr[5][0];
        int intValue = objArr[0].intValue();
        if (intValue == 2) {
            this.mPluginManager.getComponentsHandler().transformIntentToExplicitAsNeeded(intent);
            this.mPluginManager.getComponentsHandler().markIntentIfNeeded(intent);
        } else if (intValue == 4 && (resolveService = this.mPluginManager.resolveService(intent, 0)) != null && resolveService.serviceInfo != null) {
            objArr[5][0] = wrapperTargetIntent(intent, resolveService.serviceInfo, (Bundle) null, 1);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r3, java.lang.reflect.Method r4, java.lang.Object[] r5) throws java.lang.Throwable {
        /*
            r2 = this;
            java.lang.String r0 = "startService"
            java.lang.String r1 = r4.getName()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x001b
            java.lang.Object r3 = r2.startService(r3, r4, r5)     // Catch:{ Throwable -> 0x0011 }
            return r3
        L_0x0011:
            r3 = move-exception
            java.lang.String r0 = "VA.IActivityManagerProxy"
            java.lang.String r1 = "Start service error"
        L_0x0016:
            android.util.Log.e(r0, r1, r3)
            goto L_0x0091
        L_0x001b:
            java.lang.String r0 = "stopService"
            java.lang.String r1 = r4.getName()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0032
            java.lang.Object r3 = r2.stopService(r3, r4, r5)     // Catch:{ Throwable -> 0x002c }
            return r3
        L_0x002c:
            r3 = move-exception
            java.lang.String r0 = "VA.IActivityManagerProxy"
            java.lang.String r1 = "Stop Service error"
            goto L_0x0016
        L_0x0032:
            java.lang.String r0 = "stopServiceToken"
            java.lang.String r1 = r4.getName()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0049
            java.lang.Object r3 = r2.stopServiceToken(r3, r4, r5)     // Catch:{ Throwable -> 0x0043 }
            return r3
        L_0x0043:
            r3 = move-exception
            java.lang.String r0 = "VA.IActivityManagerProxy"
            java.lang.String r1 = "Stop service token error"
            goto L_0x0016
        L_0x0049:
            java.lang.String r0 = "bindService"
            java.lang.String r1 = r4.getName()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0061
            java.lang.Object r3 = r2.bindService(r3, r4, r5)     // Catch:{ Throwable -> 0x005a }
            return r3
        L_0x005a:
            r3 = move-exception
            java.lang.String r0 = "VA.IActivityManagerProxy"
            android.util.Log.w(r0, r3)
            goto L_0x0091
        L_0x0061:
            java.lang.String r0 = "unbindService"
            java.lang.String r1 = r4.getName()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0072
            java.lang.Object r3 = r2.unbindService(r3, r4, r5)     // Catch:{ Throwable -> 0x005a }
            return r3
        L_0x0072:
            java.lang.String r3 = "getIntentSender"
            java.lang.String r0 = r4.getName()
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0082
            r2.getIntentSender(r4, r5)     // Catch:{  }
            goto L_0x0091
        L_0x0082:
            java.lang.String r3 = "overridePendingTransition"
            java.lang.String r0 = r4.getName()
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0091
            r2.overridePendingTransition(r4, r5)     // Catch:{  }
        L_0x0091:
            android.app.IActivityManager r3 = r2.mActivityManager     // Catch:{ Throwable -> 0x0098 }
            java.lang.Object r3 = r4.invoke(r3, r5)     // Catch:{ Throwable -> 0x0098 }
            return r3
        L_0x0098:
            r3 = move-exception
            java.lang.Throwable r4 = r3.getCause()
            if (r4 == 0) goto L_0x00b1
            boolean r5 = r4 instanceof android.os.DeadObjectException
            if (r5 == 0) goto L_0x00b1
            java.lang.String r5 = "activity"
            android.os.IBinder r5 = android.os.ServiceManager.getService(r5)
            if (r5 == 0) goto L_0x00b1
            android.app.IActivityManager r5 = android.app.ActivityManagerNative.asInterface(r5)
            r2.mActivityManager = r5
        L_0x00b1:
            r5 = r3
        L_0x00b2:
            boolean r0 = r5 instanceof android.os.RemoteException
            if (r0 == 0) goto L_0x00b7
            throw r5
        L_0x00b7:
            java.lang.Throwable r5 = r5.getCause()
            if (r5 != 0) goto L_0x00b2
            if (r4 == 0) goto L_0x00c0
            r3 = r4
        L_0x00c0:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.virtualapk.delegate.ActivityManagerProxy.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public void overridePendingTransition(Method method, Object[] objArr) {
        objArr[1] = this.mPluginManager.getHostContext().getPackageName();
    }

    /* access modifiers changed from: protected */
    public ComponentName startDelegateServiceForTarget(Intent intent, ServiceInfo serviceInfo, Bundle bundle, int i) {
        return this.mPluginManager.getHostContext().startService(wrapperTargetIntent(intent, serviceInfo, bundle, i));
    }

    /* access modifiers changed from: protected */
    public Object startService(Object obj, Method method, Object[] objArr) throws Throwable {
        Intent intent = objArr[1];
        ResolveInfo resolveService = this.mPluginManager.resolveService(intent, 0);
        return (resolveService == null || resolveService.serviceInfo == null) ? method.invoke(this.mActivityManager, objArr) : startDelegateServiceForTarget(intent, resolveService.serviceInfo, (Bundle) null, 1);
    }

    /* access modifiers changed from: protected */
    public Object stopService(Object obj, Method method, Object[] objArr) throws Throwable {
        Intent intent = objArr[1];
        ResolveInfo resolveService = this.mPluginManager.resolveService(intent, 0);
        if (resolveService == null || resolveService.serviceInfo == null) {
            return method.invoke(this.mActivityManager, objArr);
        }
        startDelegateServiceForTarget(intent, resolveService.serviceInfo, (Bundle) null, 2);
        return 1;
    }

    /* access modifiers changed from: protected */
    public Object stopServiceToken(Object obj, Method method, Object[] objArr) throws Throwable {
        Intent component = new Intent().setComponent(objArr[0]);
        ResolveInfo resolveService = this.mPluginManager.resolveService(component, 0);
        if (resolveService == null || resolveService.serviceInfo == null) {
            return method.invoke(this.mActivityManager, objArr);
        }
        startDelegateServiceForTarget(component, resolveService.serviceInfo, (Bundle) null, 2);
        return true;
    }

    /* access modifiers changed from: protected */
    public Object unbindService(Object obj, Method method, Object[] objArr) throws Throwable {
        Intent forgetIServiceConnection = this.mPluginManager.getComponentsHandler().forgetIServiceConnection(objArr[0]);
        if (forgetIServiceConnection == null) {
            return method.invoke(this.mActivityManager, objArr);
        }
        startDelegateServiceForTarget(forgetIServiceConnection, this.mPluginManager.resolveService(forgetIServiceConnection, 0).serviceInfo, (Bundle) null, 4);
        return true;
    }

    /* access modifiers changed from: protected */
    public Intent wrapperTargetIntent(Intent intent, ServiceInfo serviceInfo, Bundle bundle, int i) {
        intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
        String location = this.mPluginManager.getLoadedPlugin(intent.getComponent()).getLocation();
        Class cls = PluginUtil.isLocalService(serviceInfo) ? LocalService.class : RemoteService.class;
        Intent intent2 = new Intent();
        intent2.setClass(this.mPluginManager.getHostContext(), cls);
        intent2.putExtra(LocalService.EXTRA_TARGET, intent);
        intent2.putExtra(LocalService.EXTRA_COMMAND, i);
        intent2.putExtra(LocalService.EXTRA_PLUGIN_LOCATION, location);
        if (bundle != null) {
            intent2.putExtras(bundle);
        }
        return intent2;
    }
}

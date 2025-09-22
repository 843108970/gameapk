package com.didi.virtualapk.delegate;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.didi.virtualapk.PluginManager;

public class LocalService extends Service {
    public static final String EXTRA_COMMAND = "command";
    public static final int EXTRA_COMMAND_BIND_SERVICE = 3;
    public static final int EXTRA_COMMAND_START_SERVICE = 1;
    public static final int EXTRA_COMMAND_STOP_SERVICE = 2;
    public static final int EXTRA_COMMAND_UNBIND_SERVICE = 4;
    public static final String EXTRA_PLUGIN_LOCATION = "plugin_location";
    public static final String EXTRA_TARGET = "target";
    private static final String TAG = "VA.LocalService";
    private PluginManager mPluginManager;

    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    public void onCreate() {
        super.onCreate();
        this.mPluginManager = PluginManager.getInstance(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v13, resolved type: android.app.Service} */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01b9, code lost:
        r4.append(r7);
        r4.append(" not found");
        android.util.Log.i(r2, r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01c8, code lost:
        return 1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0155 A[Catch:{ Exception -> 0x0179 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0159 A[Catch:{ Exception -> 0x0179 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r22, int r23, int r24) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r3 = 1
            if (r2 == 0) goto L_0x0270
            java.lang.String r4 = "target"
            boolean r4 = r2.hasExtra(r4)
            if (r4 == 0) goto L_0x0270
            java.lang.String r4 = "command"
            boolean r4 = r2.hasExtra(r4)
            if (r4 != 0) goto L_0x0018
            return r3
        L_0x0018:
            java.lang.String r4 = "target"
            android.os.Parcelable r4 = r2.getParcelableExtra(r4)
            android.content.Intent r4 = (android.content.Intent) r4
            java.lang.String r5 = "command"
            r6 = 0
            int r5 = r2.getIntExtra(r5, r6)
            if (r4 == 0) goto L_0x0270
            if (r5 > 0) goto L_0x002c
            return r3
        L_0x002c:
            android.content.ComponentName r7 = r4.getComponent()
            com.didi.virtualapk.PluginManager r8 = r1.mPluginManager
            com.didi.virtualapk.internal.LoadedPlugin r8 = r8.getLoadedPlugin((android.content.ComponentName) r7)
            if (r8 != 0) goto L_0x0050
            java.lang.String r2 = "VA.LocalService"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Error target: "
            r5.<init>(r6)
            java.lang.String r4 = r4.toURI()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            android.util.Log.w(r2, r4)
            return r3
        L_0x0050:
            java.lang.ClassLoader r9 = r8.getClassLoader()
            r4.setExtrasClassLoader(r9)
            r12 = 6
            switch(r5) {
                case 1: goto L_0x01c9;
                case 2: goto L_0x0181;
                case 3: goto L_0x009a;
                case 4: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            return r3
        L_0x005c:
            com.didi.virtualapk.PluginManager r2 = r1.mPluginManager
            com.didi.virtualapk.internal.ComponentsHandler r2 = r2.getComponentsHandler()
            android.app.Service r2 = r2.forgetService(r7)
            if (r2 == 0) goto L_0x0091
            r2.onUnbind(r4)     // Catch:{ Exception -> 0x006f }
            r2.onDestroy()     // Catch:{ Exception -> 0x006f }
            return r3
        L_0x006f:
            r0 = move-exception
            r4 = r0
            java.lang.String r5 = "VA.LocalService"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Unable to unbind service "
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r2 = ": "
            r6.append(r2)
            java.lang.String r2 = r4.toString()
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            android.util.Log.e(r5, r2)
            return r3
        L_0x0091:
            java.lang.String r2 = "VA.LocalService"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L_0x01b9
        L_0x009a:
            android.app.ActivityThread r5 = android.app.ActivityThread.currentActivityThread()
            android.app.ActivityThread$ApplicationThread r14 = r5.getApplicationThread()
            com.didi.virtualapk.PluginManager r15 = r1.mPluginManager
            com.didi.virtualapk.internal.ComponentsHandler r15 = r15.getComponentsHandler()
            boolean r15 = r15.isServiceAvailable(r7)
            if (r15 == 0) goto L_0x00bb
            com.didi.virtualapk.PluginManager r5 = r1.mPluginManager
            com.didi.virtualapk.internal.ComponentsHandler r5 = r5.getComponentsHandler()
            android.app.Service r5 = r5.getService(r7)
            r15 = r5
            goto L_0x013d
        L_0x00bb:
            java.lang.ClassLoader r15 = r8.getClassLoader()     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r9 = r7.getClassName()     // Catch:{ Throwable -> 0x0135 }
            java.lang.Class r9 = r15.loadClass(r9)     // Catch:{ Throwable -> 0x0135 }
            java.lang.Object r9 = r9.newInstance()     // Catch:{ Throwable -> 0x0135 }
            r15 = r9
            android.app.Service r15 = (android.app.Service) r15     // Catch:{ Throwable -> 0x0135 }
            android.app.Application r9 = r8.getApplication()     // Catch:{ Throwable -> 0x0132 }
            android.os.IBinder r14 = r14.asBinder()     // Catch:{ Throwable -> 0x0132 }
            java.lang.Class r10 = r15.getClass()     // Catch:{ Throwable -> 0x0132 }
            java.lang.String r11 = "attach"
            java.lang.Class[] r13 = new java.lang.Class[r12]     // Catch:{ Throwable -> 0x0132 }
            java.lang.Class<android.content.Context> r16 = android.content.Context.class
            r13[r6] = r16     // Catch:{ Throwable -> 0x0132 }
            java.lang.Class<android.app.ActivityThread> r16 = android.app.ActivityThread.class
            r13[r3] = r16     // Catch:{ Throwable -> 0x0132 }
            java.lang.Class<java.lang.String> r16 = java.lang.String.class
            r20 = 2
            r13[r20] = r16     // Catch:{ Throwable -> 0x0132 }
            java.lang.Class<android.os.IBinder> r16 = android.os.IBinder.class
            r19 = 3
            r13[r19] = r16     // Catch:{ Throwable -> 0x0132 }
            java.lang.Class<android.app.Application> r16 = android.app.Application.class
            r18 = 4
            r13[r18] = r16     // Catch:{ Throwable -> 0x0132 }
            java.lang.Class<java.lang.Object> r16 = java.lang.Object.class
            r17 = 5
            r13[r17] = r16     // Catch:{ Throwable -> 0x0132 }
            java.lang.reflect.Method r10 = r10.getMethod(r11, r13)     // Catch:{ Throwable -> 0x0132 }
            com.didi.virtualapk.PluginManager r11 = r1.mPluginManager     // Catch:{ Throwable -> 0x0132 }
            android.app.IActivityManager r11 = r11.getActivityManager()     // Catch:{ Throwable -> 0x0132 }
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ Throwable -> 0x0132 }
            android.content.Context r8 = r8.getPluginContext()     // Catch:{ Throwable -> 0x0132 }
            r12[r6] = r8     // Catch:{ Throwable -> 0x0132 }
            r12[r3] = r5     // Catch:{ Throwable -> 0x0132 }
            java.lang.String r5 = r7.getClassName()     // Catch:{ Throwable -> 0x0132 }
            r8 = 2
            r12[r8] = r5     // Catch:{ Throwable -> 0x0132 }
            r5 = 3
            r12[r5] = r14     // Catch:{ Throwable -> 0x0132 }
            r5 = 4
            r12[r5] = r9     // Catch:{ Throwable -> 0x0132 }
            r5 = 5
            r12[r5] = r11     // Catch:{ Throwable -> 0x0132 }
            r10.invoke(r15, r12)     // Catch:{ Throwable -> 0x0132 }
            r15.onCreate()     // Catch:{ Throwable -> 0x0132 }
            com.didi.virtualapk.PluginManager r5 = r1.mPluginManager     // Catch:{ Throwable -> 0x0132 }
            com.didi.virtualapk.internal.ComponentsHandler r5 = r5.getComponentsHandler()     // Catch:{ Throwable -> 0x0132 }
            r5.rememberService(r7, r15)     // Catch:{ Throwable -> 0x0132 }
            goto L_0x013d
        L_0x0132:
            r0 = move-exception
            r5 = r0
            goto L_0x0138
        L_0x0135:
            r0 = move-exception
            r5 = r0
            r15 = 0
        L_0x0138:
            java.lang.String r8 = "VA.LocalService"
            android.util.Log.w(r8, r5)
        L_0x013d:
            android.os.IBinder r4 = r15.onBind(r4)     // Catch:{ Exception -> 0x0179 }
            android.os.Bundle r2 = r22.getExtras()     // Catch:{ Exception -> 0x0179 }
            java.lang.String r5 = "sc"
            android.os.IBinder r2 = com.didi.virtualapk.internal.utils.PluginUtil.getBinder(r2, r5)     // Catch:{ Exception -> 0x0179 }
            android.app.IServiceConnection r2 = android.app.IServiceConnection.Stub.asInterface(r2)     // Catch:{ Exception -> 0x0179 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0179 }
            r8 = 26
            if (r5 < r8) goto L_0x0159
            r2.connected(r7, r4, r6)     // Catch:{ Exception -> 0x0179 }
            return r3
        L_0x0159:
            com.didi.virtualapk.utils.Reflector$QuietReflector r2 = com.didi.virtualapk.utils.Reflector.QuietReflector.with(r2)     // Catch:{ Exception -> 0x0179 }
            java.lang.String r5 = "connected"
            r8 = 2
            java.lang.Class[] r9 = new java.lang.Class[r8]     // Catch:{ Exception -> 0x0179 }
            java.lang.Class<android.content.ComponentName> r8 = android.content.ComponentName.class
            r9[r6] = r8     // Catch:{ Exception -> 0x0179 }
            java.lang.Class<android.os.IBinder> r8 = android.os.IBinder.class
            r9[r3] = r8     // Catch:{ Exception -> 0x0179 }
            com.didi.virtualapk.utils.Reflector$QuietReflector r2 = r2.method((java.lang.String) r5, (java.lang.Class<?>[]) r9)     // Catch:{ Exception -> 0x0179 }
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0179 }
            r5[r6] = r7     // Catch:{ Exception -> 0x0179 }
            r5[r3] = r4     // Catch:{ Exception -> 0x0179 }
            r2.call(r5)     // Catch:{ Exception -> 0x0179 }
            return r3
        L_0x0179:
            r0 = move-exception
            r2 = r0
            java.lang.String r4 = "VA.LocalService"
            android.util.Log.w(r4, r2)
            return r3
        L_0x0181:
            com.didi.virtualapk.PluginManager r2 = r1.mPluginManager
            com.didi.virtualapk.internal.ComponentsHandler r2 = r2.getComponentsHandler()
            android.app.Service r2 = r2.forgetService(r7)
            if (r2 == 0) goto L_0x01b2
            r2.onDestroy()     // Catch:{ Exception -> 0x0191 }
            return r3
        L_0x0191:
            r0 = move-exception
            java.lang.String r4 = "VA.LocalService"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Unable to stop service "
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = ": "
            r5.append(r2)
            java.lang.String r2 = r0.toString()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            android.util.Log.e(r4, r2)
            return r3
        L_0x01b2:
            java.lang.String r2 = "VA.LocalService"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L_0x01b9:
            r4.append(r7)
            java.lang.String r5 = " not found"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.i(r2, r4)
            return r3
        L_0x01c9:
            android.app.ActivityThread r2 = android.app.ActivityThread.currentActivityThread()
            android.app.ActivityThread$ApplicationThread r5 = r2.getApplicationThread()
            com.didi.virtualapk.PluginManager r9 = r1.mPluginManager
            com.didi.virtualapk.internal.ComponentsHandler r9 = r9.getComponentsHandler()
            boolean r9 = r9.isServiceAvailable(r7)
            if (r9 == 0) goto L_0x01e8
            com.didi.virtualapk.PluginManager r2 = r1.mPluginManager
            com.didi.virtualapk.internal.ComponentsHandler r2 = r2.getComponentsHandler()
            android.app.Service r2 = r2.getService(r7)
            goto L_0x025e
        L_0x01e8:
            java.lang.ClassLoader r9 = r8.getClassLoader()     // Catch:{ Throwable -> 0x0270 }
            java.lang.String r10 = r7.getClassName()     // Catch:{ Throwable -> 0x0270 }
            java.lang.Class r9 = r9.loadClass(r10)     // Catch:{ Throwable -> 0x0270 }
            java.lang.Object r9 = r9.newInstance()     // Catch:{ Throwable -> 0x0270 }
            android.app.Service r9 = (android.app.Service) r9     // Catch:{ Throwable -> 0x0270 }
            android.app.Application r10 = r8.getApplication()     // Catch:{ Throwable -> 0x0270 }
            android.os.IBinder r5 = r5.asBinder()     // Catch:{ Throwable -> 0x0270 }
            java.lang.Class r11 = r9.getClass()     // Catch:{ Throwable -> 0x0270 }
            java.lang.String r13 = "attach"
            java.lang.Class[] r14 = new java.lang.Class[r12]     // Catch:{ Throwable -> 0x0270 }
            java.lang.Class<android.content.Context> r15 = android.content.Context.class
            r14[r6] = r15     // Catch:{ Throwable -> 0x0270 }
            java.lang.Class<android.app.ActivityThread> r15 = android.app.ActivityThread.class
            r14[r3] = r15     // Catch:{ Throwable -> 0x0270 }
            java.lang.Class<java.lang.String> r15 = java.lang.String.class
            r16 = 2
            r14[r16] = r15     // Catch:{ Throwable -> 0x0270 }
            java.lang.Class<android.os.IBinder> r15 = android.os.IBinder.class
            r16 = 3
            r14[r16] = r15     // Catch:{ Throwable -> 0x0270 }
            java.lang.Class<android.app.Application> r15 = android.app.Application.class
            r16 = 4
            r14[r16] = r15     // Catch:{ Throwable -> 0x0270 }
            java.lang.Class<java.lang.Object> r15 = java.lang.Object.class
            r16 = 5
            r14[r16] = r15     // Catch:{ Throwable -> 0x0270 }
            java.lang.reflect.Method r11 = r11.getMethod(r13, r14)     // Catch:{ Throwable -> 0x0270 }
            com.didi.virtualapk.PluginManager r13 = r1.mPluginManager     // Catch:{ Throwable -> 0x0270 }
            android.app.IActivityManager r13 = r13.getActivityManager()     // Catch:{ Throwable -> 0x0270 }
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ Throwable -> 0x0270 }
            android.content.Context r8 = r8.getPluginContext()     // Catch:{ Throwable -> 0x0270 }
            r12[r6] = r8     // Catch:{ Throwable -> 0x0270 }
            r12[r3] = r2     // Catch:{ Throwable -> 0x0270 }
            java.lang.String r2 = r7.getClassName()     // Catch:{ Throwable -> 0x0270 }
            r8 = 2
            r12[r8] = r2     // Catch:{ Throwable -> 0x0270 }
            r2 = 3
            r12[r2] = r5     // Catch:{ Throwable -> 0x0270 }
            r2 = 4
            r12[r2] = r10     // Catch:{ Throwable -> 0x0270 }
            r2 = 5
            r12[r2] = r13     // Catch:{ Throwable -> 0x0270 }
            r11.invoke(r9, r12)     // Catch:{ Throwable -> 0x0270 }
            r9.onCreate()     // Catch:{ Throwable -> 0x0270 }
            com.didi.virtualapk.PluginManager r2 = r1.mPluginManager     // Catch:{ Throwable -> 0x0270 }
            com.didi.virtualapk.internal.ComponentsHandler r2 = r2.getComponentsHandler()     // Catch:{ Throwable -> 0x0270 }
            r2.rememberService(r7, r9)     // Catch:{ Throwable -> 0x0270 }
            r2 = r9
        L_0x025e:
            com.didi.virtualapk.PluginManager r5 = r1.mPluginManager
            com.didi.virtualapk.internal.ComponentsHandler r5 = r5.getComponentsHandler()
            java.util.concurrent.atomic.AtomicInteger r5 = r5.getServiceCounter(r2)
            int r5 = r5.getAndIncrement()
            r2.onStartCommand(r4, r6, r5)
            return r3
        L_0x0270:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.virtualapk.delegate.LocalService.onStartCommand(android.content.Intent, int, int):int");
    }
}

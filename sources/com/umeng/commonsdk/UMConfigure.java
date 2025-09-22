package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cyjh.elfin.e.c.o;
import com.umeng.commonsdk.amap.b;
import com.umeng.commonsdk.proguard.v;
import com.umeng.commonsdk.stateless.UMSLEnvelopeBuild;
import com.umeng.commonsdk.statistics.a;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final String KEY_FILE_NAME_LOG = "LOG";
    private static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static final String TAG = "UMConfigure";
    private static boolean debugLog = false;
    private static b readUMAmapTimer;
    private static b writeUMAmapTimer;

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            if (!debugLog) {
                return null;
            }
            Log.e(TAG, "getClass e is " + e.toString());
            return null;
        }
    }

    private static Object getDecInstanceObject(Class<?> cls) {
        Constructor<?> constructor;
        String str;
        StringBuilder sb;
        String illegalArgumentException;
        if (cls != null) {
            try {
                constructor = cls.getDeclaredConstructor(new Class[0]);
            } catch (NoSuchMethodException e) {
                if (debugLog) {
                    Log.e(TAG, "getDecInstanceObject e is " + e.toString());
                }
                constructor = null;
            }
            if (constructor != null) {
                constructor.setAccessible(true);
                try {
                    return constructor.newInstance(new Object[0]);
                } catch (IllegalArgumentException e2) {
                    if (debugLog) {
                        str = TAG;
                        sb = new StringBuilder("getDecInstanceObject e is ");
                        illegalArgumentException = e2.toString();
                        sb.append(illegalArgumentException);
                        Log.e(str, sb.toString());
                    }
                } catch (InstantiationException e3) {
                    if (debugLog) {
                        str = TAG;
                        sb = new StringBuilder("getDecInstanceObject e is ");
                        illegalArgumentException = e3.toString();
                        sb.append(illegalArgumentException);
                        Log.e(str, sb.toString());
                    }
                } catch (IllegalAccessException e4) {
                    if (debugLog) {
                        str = TAG;
                        sb = new StringBuilder("getDecInstanceObject e is ");
                        illegalArgumentException = e4.toString();
                        sb.append(illegalArgumentException);
                        Log.e(str, sb.toString());
                    }
                } catch (InvocationTargetException e5) {
                    if (debugLog) {
                        str = TAG;
                        sb = new StringBuilder("getDecInstanceObject e is ");
                        illegalArgumentException = e5.toString();
                        sb.append(illegalArgumentException);
                        Log.e(str, sb.toString());
                    }
                }
            } else if (debugLog) {
                Log.e(TAG, "getDecInstanceObject constructor is  null");
            }
        }
        return null;
    }

    private static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        String str2;
        String str3;
        Method method = null;
        if (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e) {
                if (debugLog) {
                    Log.e(TAG, "getDecMethod e is " + e.toString());
                }
            }
            if (method != null) {
                method.setAccessible(true);
                return method;
            }
            if (debugLog) {
                str2 = TAG;
                str3 = "getDecMethod met is null";
            }
            return method;
        }
        if (debugLog) {
            str2 = TAG;
            str3 = "getDecMethod className is null";
        }
        return method;
        Log.e(str2, str3);
        return method;
    }

    private Object getInstanceObject(Class<?> cls) {
        String str;
        StringBuilder sb;
        String instantiationException;
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (InstantiationException e) {
                if (!debugLog) {
                    return null;
                }
                str = TAG;
                sb = new StringBuilder("getInstanceObject e is ");
                instantiationException = e.toString();
                sb.append(instantiationException);
                Log.e(str, sb.toString());
                return null;
            } catch (IllegalAccessException e2) {
                if (!debugLog) {
                    return null;
                }
                str = TAG;
                sb = new StringBuilder("getInstanceObject e is ");
                instantiationException = e2.toString();
                sb.append(instantiationException);
                Log.e(str, sb.toString());
                return null;
            }
        } else if (!debugLog) {
            return null;
        } else {
            Log.e(TAG, "getInstanceObject cla is null");
            return null;
        }
    }

    public static String getUMIDString(Context context) {
        if (context != null) {
            return UMUtils.getUMId(context.getApplicationContext());
        }
        return null;
    }

    public static void init(Context context, int i, String str) {
        init(context, (String) null, (String) null, i, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01fa, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01fd, code lost:
        if (debugLog != false) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01ff, code lost:
        android.util.Log.e(TAG, "push secret e is " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0233, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0236, code lost:
        if (debugLog != false) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0238, code lost:
        android.util.Log.e(TAG, "crash e is " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x026c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x026f, code lost:
        if (debugLog != false) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0271, code lost:
        android.util.Log.e(TAG, "crash e is " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0287, code lost:
        if (debugLog != false) goto L_0x0289;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0289, code lost:
        android.util.Log.e(TAG, "init e is " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x029f, code lost:
        if (debugLog != false) goto L_0x02a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02a1, code lost:
        android.util.Log.e(TAG, "init e is " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008f, code lost:
        if (debugLog != false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0091, code lost:
        android.util.Log.e(TAG, "e is " + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00dd, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e0, code lost:
        if (debugLog != false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e2, code lost:
        android.util.Log.e(TAG, "e is " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0122, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0125, code lost:
        if (debugLog != false) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0127, code lost:
        android.util.Log.e(TAG, "e is " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:1:0x0002, B:109:0x0214] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:1:0x0002, B:121:0x024d] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:1:0x0002, B:23:0x0055] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:1:0x0002, B:39:0x00a6] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:1:0x0002, B:55:0x00f7] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:1:0x0002, B:93:0x01c0] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x000e A[Catch:{ Exception -> 0x0011, Throwable -> 0x000e }, ExcHandler: Throwable (r7v8 'th' java.lang.Throwable A[CUSTOM_DECLARE, Catch:{ Exception -> 0x0011, Throwable -> 0x000e }]), Splitter:B:1:0x0002] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0011 A[Catch:{ Exception -> 0x0011, Throwable -> 0x000e }, ExcHandler: Exception (r7v6 'e' java.lang.Exception A[CUSTOM_DECLARE, Catch:{ Exception -> 0x0011, Throwable -> 0x000e }]), Splitter:B:1:0x0002] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void init(android.content.Context r7, java.lang.String r8, java.lang.String r9, int r10, java.lang.String r11) {
        /*
            if (r7 != 0) goto L_0x0014
            boolean r7 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r7 == 0) goto L_0x000d
            java.lang.String r7 = "UMConfigure"
            java.lang.String r8 = "context is null !!!"
            android.util.Log.e(r7, r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x000d:
            return
        L_0x000e:
            r7 = move-exception
            goto L_0x0285
        L_0x0011:
            r7 = move-exception
            goto L_0x029d
        L_0x0014:
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r0 == 0) goto L_0x0022
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppkeyByXML(r7)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x0022:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r0 == 0) goto L_0x002c
            java.lang.String r9 = com.umeng.commonsdk.utils.UMUtils.getChannelByXML(r7)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x002c:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r0 == 0) goto L_0x0034
            java.lang.String r9 = "Unknown"
        L_0x0034:
            com.umeng.commonsdk.utils.UMUtils.setChannel(r7, r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            boolean r0 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = "UMConfigure"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r2 = "channel is "
            r1.<init>(r2)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            r1.append(r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            android.util.Log.i(r0, r1)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x004e:
            saveSDKComponent()     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            r0 = 0
            r1 = 1
            java.lang.String r2 = "com.umeng.message.PushAgent"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            if (r2 == 0) goto L_0x00a4
            java.lang.String r3 = "getInstance"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r4[r0] = r5     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            java.lang.reflect.Method r3 = r2.getDeclaredMethod(r3, r4)     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            if (r3 == 0) goto L_0x00a4
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            r4[r0] = r7     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            java.lang.Object r3 = r3.invoke(r2, r4)     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            if (r3 == 0) goto L_0x00a4
            java.lang.String r4 = "setAppkey"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r0] = r6     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            if (r2 == 0) goto L_0x00a4
            r2.setAccessible(r1)     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            r4[r0] = r8     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            r2.invoke(r3, r4)     // Catch:{ Exception -> 0x008c, Throwable -> 0x000e }
            goto L_0x00a4
        L_0x008c:
            r2 = move-exception
            boolean r3 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r3 == 0) goto L_0x00a4
            java.lang.String r3 = "UMConfigure"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r5 = "e is "
            r4.<init>(r5)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            r4.append(r2)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            android.util.Log.e(r3, r2)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x00a4:
            java.lang.String r2 = "com.umeng.message.PushAgent"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            if (r2 == 0) goto L_0x00f5
            java.lang.String r3 = "getInstance"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r4[r0] = r5     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            java.lang.reflect.Method r3 = r2.getDeclaredMethod(r3, r4)     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            if (r3 == 0) goto L_0x00f5
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            r4[r0] = r7     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            java.lang.Object r3 = r3.invoke(r2, r4)     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            if (r3 == 0) goto L_0x00f5
            java.lang.String r4 = "setMessageChannel"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r0] = r6     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            if (r2 == 0) goto L_0x00f5
            r2.setAccessible(r1)     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            r4[r0] = r9     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            r2.invoke(r3, r4)     // Catch:{ Exception -> 0x00dd, Throwable -> 0x000e }
            goto L_0x00f5
        L_0x00dd:
            r9 = move-exception
            boolean r2 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r2 == 0) goto L_0x00f5
            java.lang.String r2 = "UMConfigure"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r4 = "e is "
            r3.<init>(r4)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            r3.append(r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r9 = r3.toString()     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            android.util.Log.e(r2, r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x00f5:
            java.lang.String r9 = "com.umeng.socialize.UMShareAPI"
            java.lang.Class r9 = getClass(r9)     // Catch:{ Throwable -> 0x0122, Exception -> 0x0011 }
            java.lang.String r2 = "APPKEY"
            setFile((java.lang.Class<?>) r9, (java.lang.String) r2, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0122, Exception -> 0x0011 }
            if (r9 == 0) goto L_0x013a
            java.lang.String r2 = "init"
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Throwable -> 0x0122, Exception -> 0x0011 }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r4[r0] = r5     // Catch:{ Throwable -> 0x0122, Exception -> 0x0011 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r1] = r5     // Catch:{ Throwable -> 0x0122, Exception -> 0x0011 }
            java.lang.reflect.Method r2 = r9.getDeclaredMethod(r2, r4)     // Catch:{ Throwable -> 0x0122, Exception -> 0x0011 }
            if (r2 == 0) goto L_0x013a
            r2.setAccessible(r1)     // Catch:{ Throwable -> 0x0122, Exception -> 0x0011 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Throwable -> 0x0122, Exception -> 0x0011 }
            r3[r0] = r7     // Catch:{ Throwable -> 0x0122, Exception -> 0x0011 }
            r3[r1] = r8     // Catch:{ Throwable -> 0x0122, Exception -> 0x0011 }
            r2.invoke(r9, r3)     // Catch:{ Throwable -> 0x0122, Exception -> 0x0011 }
            goto L_0x013a
        L_0x0122:
            r9 = move-exception
            boolean r2 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r2 == 0) goto L_0x013a
            java.lang.String r2 = "UMConfigure"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r4 = "e is "
            r3.<init>(r4)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            r3.append(r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r9 = r3.toString()     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            android.util.Log.e(r2, r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x013a:
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r9 == 0) goto L_0x014c
            boolean r7 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r7 == 0) goto L_0x014b
            java.lang.String r7 = "UMConfigure"
            java.lang.String r8 = "appkey is null !!!"
            android.util.Log.e(r7, r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x014b:
            return
        L_0x014c:
            com.umeng.commonsdk.utils.UMUtils.setAppkey(r7, r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r9 = com.umeng.commonsdk.utils.UMUtils.getLastAppkey(r7)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r2 != 0) goto L_0x0173
            boolean r2 = r8.equals(r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r2 != 0) goto L_0x0173
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r2 != 0) goto L_0x0170
            boolean r2 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r2 == 0) goto L_0x0170
            java.lang.String r2 = "UMConfigure"
            java.lang.String r3 = "appkey is change !!!"
            android.util.Log.i(r2, r3)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x0170:
            com.umeng.commonsdk.utils.UMUtils.setLastAppkey(r7, r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x0173:
            boolean r2 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r2 == 0) goto L_0x0192
            java.lang.String r2 = "UMConfigure"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r4 = "current appkey is "
            r3.<init>(r4)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            r3.append(r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r8 = ", last appkey is "
            r3.append(r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            r3.append(r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r8 = r3.toString()     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            android.util.Log.i(r2, r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x0192:
            com.umeng.commonsdk.statistics.b.a(r10)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            boolean r8 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r8 == 0) goto L_0x01a7
            boolean r8 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r8 == 0) goto L_0x0212
            java.lang.String r8 = "UMConfigure"
            java.lang.String r9 = "push secret 非法 ！！！"
            android.util.Log.e(r8, r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            goto L_0x0212
        L_0x01a7:
            boolean r8 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r8 == 0) goto L_0x01be
            java.lang.String r8 = "UMConfigure"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r10 = "push secret is "
            r9.<init>(r10)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            r9.append(r11)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            android.util.Log.i(r8, r9)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x01be:
            java.lang.String r8 = "com.umeng.message.PushAgent"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            if (r8 == 0) goto L_0x0212
            java.lang.String r9 = "getInstance"
            java.lang.Class[] r10 = new java.lang.Class[r1]     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r10[r0] = r2     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            java.lang.reflect.Method r9 = r8.getDeclaredMethod(r9, r10)     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            if (r9 == 0) goto L_0x0212
            r9.setAccessible(r1)     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            r10[r0] = r7     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            java.lang.Object r9 = r9.invoke(r8, r10)     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            if (r9 == 0) goto L_0x0212
            java.lang.String r10 = "setSecret"
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r0] = r3     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r10, r2)     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            if (r8 == 0) goto L_0x0212
            r8.setAccessible(r1)     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            r10[r0] = r11     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            r8.invoke(r9, r10)     // Catch:{ Throwable -> 0x01fa, Exception -> 0x0011 }
            goto L_0x0212
        L_0x01fa:
            r8 = move-exception
            boolean r9 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r9 == 0) goto L_0x0212
            java.lang.String r9 = "UMConfigure"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r11 = "push secret e is "
            r10.<init>(r11)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            r10.append(r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r8 = r10.toString()     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            android.util.Log.e(r9, r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x0212:
            java.lang.String r8 = "com.umeng.error.UMError"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ Throwable -> 0x0233, Exception -> 0x0011 }
            if (r8 == 0) goto L_0x024b
            java.lang.String r9 = "init"
            java.lang.Class[] r10 = new java.lang.Class[r1]     // Catch:{ Throwable -> 0x0233, Exception -> 0x0011 }
            java.lang.Class<android.content.Context> r11 = android.content.Context.class
            r10[r0] = r11     // Catch:{ Throwable -> 0x0233, Exception -> 0x0011 }
            java.lang.reflect.Method r9 = r8.getDeclaredMethod(r9, r10)     // Catch:{ Throwable -> 0x0233, Exception -> 0x0011 }
            if (r9 == 0) goto L_0x024b
            r9.setAccessible(r1)     // Catch:{ Throwable -> 0x0233, Exception -> 0x0011 }
            java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0233, Exception -> 0x0011 }
            r10[r0] = r7     // Catch:{ Throwable -> 0x0233, Exception -> 0x0011 }
            r9.invoke(r8, r10)     // Catch:{ Throwable -> 0x0233, Exception -> 0x0011 }
            goto L_0x024b
        L_0x0233:
            r8 = move-exception
            boolean r9 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r9 == 0) goto L_0x024b
            java.lang.String r9 = "UMConfigure"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r11 = "crash e is "
            r10.<init>(r11)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            r10.append(r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r8 = r10.toString()     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            android.util.Log.e(r9, r8)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x024b:
            java.lang.String r8 = "com.umeng.commonsdk.UMConfigureImpl"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ Throwable -> 0x026c, Exception -> 0x0011 }
            if (r8 == 0) goto L_0x026b
            java.lang.String r9 = "init"
            java.lang.Class[] r10 = new java.lang.Class[r1]     // Catch:{ Throwable -> 0x026c, Exception -> 0x0011 }
            java.lang.Class<android.content.Context> r11 = android.content.Context.class
            r10[r0] = r11     // Catch:{ Throwable -> 0x026c, Exception -> 0x0011 }
            java.lang.reflect.Method r9 = r8.getDeclaredMethod(r9, r10)     // Catch:{ Throwable -> 0x026c, Exception -> 0x0011 }
            if (r9 == 0) goto L_0x026b
            r9.setAccessible(r1)     // Catch:{ Throwable -> 0x026c, Exception -> 0x0011 }
            java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x026c, Exception -> 0x0011 }
            r10[r0] = r7     // Catch:{ Throwable -> 0x026c, Exception -> 0x0011 }
            r9.invoke(r8, r10)     // Catch:{ Throwable -> 0x026c, Exception -> 0x0011 }
        L_0x026b:
            return
        L_0x026c:
            r7 = move-exception
            boolean r8 = debugLog     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            if (r8 == 0) goto L_0x0284
            java.lang.String r8 = "UMConfigure"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r10 = "crash e is "
            r9.<init>(r10)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            r9.append(r7)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
            android.util.Log.e(r8, r7)     // Catch:{ Exception -> 0x0011, Throwable -> 0x000e }
        L_0x0284:
            return
        L_0x0285:
            boolean r8 = debugLog
            if (r8 == 0) goto L_0x029c
            java.lang.String r8 = "UMConfigure"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "init e is "
            r9.<init>(r10)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            android.util.Log.e(r8, r7)
        L_0x029c:
            return
        L_0x029d:
            boolean r8 = debugLog
            if (r8 == 0) goto L_0x02b4
            java.lang.String r8 = "UMConfigure"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "init e is "
            r9.<init>(r10)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            android.util.Log.e(r8, r7)
        L_0x02b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.UMConfigure.init(android.content.Context, java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    private static void invoke(Method method, Object obj, Object[] objArr) {
        if (method != null && obj != null) {
            try {
                method.invoke(obj, objArr);
            } catch (IllegalArgumentException e) {
                if (debugLog) {
                    Log.e(TAG, "invoke e is " + e.toString());
                }
            } catch (IllegalAccessException e2) {
                if (debugLog) {
                    Log.e(TAG, "invoke e is " + e2.toString());
                }
            } catch (InvocationTargetException e3) {
                if (debugLog) {
                    Log.e(TAG, "invoke e is " + e3.toString());
                }
            }
        }
    }

    private static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke((Object) null, objArr);
            } catch (IllegalArgumentException e) {
                if (debugLog) {
                    Log.e(TAG, "invoke e is " + e.toString());
                }
            } catch (IllegalAccessException e2) {
                if (debugLog) {
                    Log.e(TAG, "invoke e is " + e2.toString());
                }
            } catch (InvocationTargetException e3) {
                if (debugLog) {
                    Log.e(TAG, "invoke e is " + e3.toString());
                }
            }
        }
    }

    private static void saveSDKComponent() {
        StringBuffer stringBuffer = new StringBuffer();
        if (getClass("com.umeng.analytics.MobclickAgent") != null) {
            stringBuffer.append("a");
        }
        if (getClass("com.umeng.message.PushAgent") != null) {
            stringBuffer.append(v.ak);
        }
        if (getClass("com.umeng.socialize.UMShareAPI") != null) {
            stringBuffer.append(v.al);
        }
        if (getClass("com.umeng.error.UMError") != null) {
            stringBuffer.append("e");
        }
        if (getClass("com.umeng.commonsdk.UMConfigureImpl") != null) {
            stringBuffer.append(v.am);
        }
        if (getClass("com.umeng.commonsdk.amap.UMAmapConfig") != null) {
            stringBuffer.append(o.f1943a);
        }
        if (!TextUtils.isEmpty(stringBuffer)) {
            c.f3869a = stringBuffer.toString();
            UMSLEnvelopeBuild.module = stringBuffer.toString();
        }
    }

    private static void setCheckDevice(boolean z) {
        com.umeng.commonsdk.statistics.b.d = z;
    }

    public static void setEncryptEnabled(boolean z) {
        c.a(z);
        UMSLEnvelopeBuild.setEncryptEnabled(z);
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                Field field = cls.getField(str);
                field.set(str, str2);
                if (debugLog) {
                    Log.i(TAG, "setFile value is " + field.get(str).toString());
                }
            } catch (Exception e) {
                if (debugLog) {
                    Log.e(TAG, "setFile e is " + e.toString());
                }
            }
        }
    }

    private static void setFile(Class<?> cls, String str, boolean z) {
        if (cls != null) {
            try {
                Field field = cls.getField(str);
                field.set(str, Boolean.valueOf(z));
                if (debugLog) {
                    Log.i(TAG, "setFile value is " + field.get(str).toString());
                }
            } catch (Exception e) {
                if (debugLog) {
                    Log.e(TAG, "setFile e is " + e.toString());
                }
            }
        }
    }

    private static void setLatencyWindow(long j) {
        a.f3864a = ((int) j) * 1000;
    }

    public static void setLogEnabled(boolean z) {
        try {
            debugLog = z;
            if (z) {
                Log.i(TAG, "common sdk version is 1.3.2");
            }
            MLog.DEBUG = z;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            Object decInstanceObject = getDecInstanceObject(cls);
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new Class[]{Boolean.TYPE}), decInstanceObject, new Object[]{Boolean.valueOf(z)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z);
        } catch (Exception e) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + e);
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + th);
            }
        }
    }
}

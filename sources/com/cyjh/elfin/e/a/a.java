package com.cyjh.elfin.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.WindowManager;
import com.cyjh.elfin.ui.a.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1867a = "FloatWindowManager";

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f1868b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1869c = true;
    private WindowManager d = null;
    private WindowManager.LayoutParams e = null;
    /* access modifiers changed from: private */
    public c f;

    /* renamed from: com.cyjh.elfin.e.a.a$a  reason: collision with other inner class name */
    private interface C0025a {
        void a();
    }

    private static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static a a() {
        if (f1868b == null) {
            synchronized (a.class) {
                if (f1868b == null) {
                    f1868b = new a();
                }
            }
        }
        return f1868b;
    }

    private void a(Context context, final C0025a aVar) {
        if (this.f != null && this.f.isShowing()) {
            this.f.dismiss();
        }
        this.f = new c(context);
        this.f.f2109a = new c.a() {
            public final void a() {
                r3.a();
                a.this.f.dismiss();
            }
        };
        this.f.show();
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            if (g.c()) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return d.a(context);
                }
                return true;
            } else if (g.d()) {
                return g(context);
            } else {
                if (g.b()) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        return b.a(context);
                    }
                    return true;
                } else if (g.e()) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        return f.a(context);
                    }
                    return true;
                } else if (g.f()) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        return e.a(context);
                    }
                    return true;
                }
            }
        }
        return j(context);
    }

    private void b(Context context, final C0025a aVar) {
        if (this.f != null && this.f.isShowing()) {
            this.f.dismiss();
        }
        this.f = new c(context);
        this.f.f2109a = new c.a() {
            public final void a() {
                aVar.a();
                a.this.f.dismiss();
            }
        };
        this.f.show();
    }

    public static void c(Context context) throws NoSuchFieldException, IllegalAccessException {
        Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get((Object) null).toString());
        intent.setFlags(268435456);
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivity(intent);
    }

    private void d(Context context) {
        if (!a(context)) {
            b(context);
        }
    }

    private static boolean e(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return b.a(context);
        }
        return true;
    }

    private static boolean f(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return d.a(context);
        }
        return true;
    }

    private static boolean g(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return c.a(context);
        }
        return true;
    }

    private static boolean h(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return f.a(context);
        }
        return true;
    }

    private static boolean i(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return e.a(context);
        }
        return true;
    }

    private static boolean j(Context context) {
        Boolean bool;
        if (g.d()) {
            return g(context);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                bool = (Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            } catch (Exception e2) {
                Log.e(f1867a, Log.getStackTraceString(e2));
            }
            return bool.booleanValue();
        }
        bool = true;
        return bool.booleanValue();
    }

    private void k(final Context context) {
        a(context, (C0025a) new C0025a() {
            public final void a() {
                Context context = r3;
                Intent intent = new Intent();
                intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
                intent.setFlags(268435456);
                if (f.a(intent, context)) {
                    context.startActivity(intent);
                    return;
                }
                intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
                if (f.a(intent, context)) {
                    context.startActivity(intent);
                } else {
                    Log.e("QikuUtils", "can't open permission page with particular name, please use \"adb shell dumpsys activity\" command and tell me the name of the float window permission page");
                }
            }
        });
    }

    private void l(final Context context) {
        a(context, (C0025a) new C0025a() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.SecurityException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.content.ActivityNotFoundException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.SecurityException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.SecurityException} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a() {
                /*
                    r8 = this;
                    android.content.Context r0 = r3
                    r1 = 268435456(0x10000000, float:2.5243549E-29)
                    android.content.Intent r2 = new android.content.Intent     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                    r2.<init>()     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                    r2.setFlags(r1)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                    android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                    java.lang.String r4 = "com.huawei.systemmanager"
                    java.lang.String r5 = "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"
                    r3.<init>(r4, r5)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                    r2.setComponent(r3)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                    double r3 = com.cyjh.elfin.e.a.g.a()     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                    r5 = 4614162998222441677(0x4008cccccccccccd, double:3.1)
                    int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r7 != 0) goto L_0x0029
                    r0.startActivity(r2)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                    return
                L_0x0029:
                    android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                    java.lang.String r4 = "com.huawei.systemmanager"
                    java.lang.String r5 = "com.huawei.notificationmanager.ui.NotificationManagmentActivity"
                    r3.<init>(r4, r5)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                    r2.setComponent(r3)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                    r0.startActivity(r2)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                    return
                L_0x0039:
                    r1 = move-exception
                    java.lang.String r2 = "进入设置页面失败，请手动设置"
                    r3 = 1
                    android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r3)
                    r0.show()
                    java.lang.String r0 = "HuaweiUtils"
                    java.lang.String r1 = android.util.Log.getStackTraceString(r1)
                L_0x004a:
                    android.util.Log.e(r0, r1)
                    return
                L_0x004e:
                    r2 = move-exception
                    android.content.Intent r3 = new android.content.Intent
                    r3.<init>()
                    r3.setFlags(r1)
                    android.content.ComponentName r1 = new android.content.ComponentName
                    java.lang.String r4 = "com.Android.settings"
                    java.lang.String r5 = "com.android.settings.permission.TabItem"
                    r1.<init>(r4, r5)
                    r3.setComponent(r1)
                    r0.startActivity(r3)
                    r2.printStackTrace()
                L_0x0069:
                    java.lang.String r0 = "HuaweiUtils"
                    java.lang.String r1 = android.util.Log.getStackTraceString(r2)
                    goto L_0x004a
                L_0x0070:
                    r2 = move-exception
                    android.content.Intent r3 = new android.content.Intent
                    r3.<init>()
                    r3.setFlags(r1)
                    android.content.ComponentName r1 = new android.content.ComponentName
                    java.lang.String r4 = "com.huawei.systemmanager"
                    java.lang.String r5 = "com.huawei.permissionmanager.ui.MainActivity"
                    r1.<init>(r4, r5)
                    r3.setComponent(r1)
                    r0.startActivity(r3)
                    goto L_0x0069
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.e.a.a.AnonymousClass2.a():void");
            }
        });
    }

    private void m(final Context context) {
        a(context, (C0025a) new C0025a() {
            public final void a() {
                Context context = context;
                try {
                    Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                    intent.putExtra("packageName", context.getPackageName());
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                } catch (Exception e) {
                    try {
                        Log.e("MeizuUtils", "获取悬浮窗权限, 打开AppSecActivity失败, " + Log.getStackTraceString(e));
                        a.c(context);
                    } catch (Exception e2) {
                        Log.e("MeizuUtils", "获取悬浮窗权限失败, 通用获取方法失败, " + Log.getStackTraceString(e2));
                    }
                }
            }
        });
    }

    private void n(final Context context) {
        a(context, (C0025a) new C0025a() {
            public final void a() {
                String str;
                String str2;
                Context context = r3;
                int a2 = d.a();
                if (a2 == 5) {
                    String packageName = context.getPackageName();
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", packageName, (String) null));
                    intent.setFlags(268435456);
                    if (d.a(intent, context)) {
                        context.startActivity(intent);
                        return;
                    } else {
                        str = "MiuiUtils";
                        str2 = "intent is not available!";
                    }
                } else {
                    if (a2 == 6) {
                        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                        intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                        intent2.putExtra("extra_pkgname", context.getPackageName());
                        intent2.setFlags(268435456);
                        if (d.a(intent2, context)) {
                            context.startActivity(intent2);
                            return;
                        }
                    } else if (a2 == 7) {
                        Intent intent3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                        intent3.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                        intent3.putExtra("extra_pkgname", context.getPackageName());
                        intent3.setFlags(268435456);
                        if (d.a(intent3, context)) {
                            context.startActivity(intent3);
                            return;
                        }
                    } else if (a2 == 8) {
                        Intent intent4 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                        intent4.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                        intent4.putExtra("extra_pkgname", context.getPackageName());
                        intent4.setFlags(268435456);
                        if (d.a(intent4, context)) {
                            context.startActivity(intent4);
                            return;
                        }
                        Intent intent5 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                        intent5.setPackage("com.miui.securitycenter");
                        intent5.putExtra("extra_pkgname", context.getPackageName());
                        intent5.setFlags(268435456);
                        if (d.a(intent5, context)) {
                            context.startActivity(intent5);
                            return;
                        }
                    } else {
                        str = "MiuiUtils";
                        str2 = "this is a special MIUI rom version, its version code " + a2;
                    }
                    str = "MiuiUtils";
                    str2 = "Intent is not available!";
                }
                Log.e(str, str2);
            }
        });
    }

    private void o(final Context context) {
        a(context, (C0025a) new C0025a() {
            public final void a() {
                Context context = r3;
                try {
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
                    context.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void p(final Context context) {
        if (g.d()) {
            m(context);
        } else if (Build.VERSION.SDK_INT >= 23) {
            a(context, (C0025a) new C0025a() {
                public final void a() {
                    try {
                        a.c(r3);
                    } catch (Exception e) {
                        Log.e(a.f1867a, Log.getStackTraceString(e));
                    }
                }
            });
        }
    }

    public final void b(final Context context) {
        C0025a r0;
        if (Build.VERSION.SDK_INT < 23) {
            if (g.c()) {
                r0 = new C0025a() {
                    public final void a() {
                        String str;
                        String str2;
                        Context context = context;
                        int a2 = d.a();
                        if (a2 == 5) {
                            String packageName = context.getPackageName();
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", packageName, (String) null));
                            intent.setFlags(268435456);
                            if (d.a(intent, context)) {
                                context.startActivity(intent);
                                return;
                            } else {
                                str = "MiuiUtils";
                                str2 = "intent is not available!";
                            }
                        } else {
                            if (a2 == 6) {
                                Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                                intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                                intent2.putExtra("extra_pkgname", context.getPackageName());
                                intent2.setFlags(268435456);
                                if (d.a(intent2, context)) {
                                    context.startActivity(intent2);
                                    return;
                                }
                            } else if (a2 == 7) {
                                Intent intent3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                                intent3.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                                intent3.putExtra("extra_pkgname", context.getPackageName());
                                intent3.setFlags(268435456);
                                if (d.a(intent3, context)) {
                                    context.startActivity(intent3);
                                    return;
                                }
                            } else if (a2 == 8) {
                                Intent intent4 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                                intent4.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                                intent4.putExtra("extra_pkgname", context.getPackageName());
                                intent4.setFlags(268435456);
                                if (d.a(intent4, context)) {
                                    context.startActivity(intent4);
                                    return;
                                }
                                Intent intent5 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                                intent5.setPackage("com.miui.securitycenter");
                                intent5.putExtra("extra_pkgname", context.getPackageName());
                                intent5.setFlags(268435456);
                                if (d.a(intent5, context)) {
                                    context.startActivity(intent5);
                                    return;
                                }
                            } else {
                                str = "MiuiUtils";
                                str2 = "this is a special MIUI rom version, its version code " + a2;
                            }
                            str = "MiuiUtils";
                            str2 = "Intent is not available!";
                        }
                        Log.e(str, str2);
                    }
                };
            } else if (g.d()) {
                m(context);
                return;
            } else if (g.b()) {
                r0 = new C0025a() {
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void a() {
                        /*
                            r8 = this;
                            android.content.Context r0 = r3
                            r1 = 268435456(0x10000000, float:2.5243549E-29)
                            android.content.Intent r2 = new android.content.Intent     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                            r2.<init>()     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                            r2.setFlags(r1)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                            android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                            java.lang.String r4 = "com.huawei.systemmanager"
                            java.lang.String r5 = "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"
                            r3.<init>(r4, r5)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                            r2.setComponent(r3)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                            double r3 = com.cyjh.elfin.e.a.g.a()     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                            r5 = 4614162998222441677(0x4008cccccccccccd, double:3.1)
                            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                            if (r7 != 0) goto L_0x0029
                            r0.startActivity(r2)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                            return
                        L_0x0029:
                            android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                            java.lang.String r4 = "com.huawei.systemmanager"
                            java.lang.String r5 = "com.huawei.notificationmanager.ui.NotificationManagmentActivity"
                            r3.<init>(r4, r5)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                            r2.setComponent(r3)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                            r0.startActivity(r2)     // Catch:{ SecurityException -> 0x0070, ActivityNotFoundException -> 0x004e, Exception -> 0x0039 }
                            return
                        L_0x0039:
                            r1 = move-exception
                            java.lang.String r2 = "进入设置页面失败，请手动设置"
                            r3 = 1
                            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r3)
                            r0.show()
                            java.lang.String r0 = "HuaweiUtils"
                            java.lang.String r1 = android.util.Log.getStackTraceString(r1)
                        L_0x004a:
                            android.util.Log.e(r0, r1)
                            return
                        L_0x004e:
                            r2 = move-exception
                            android.content.Intent r3 = new android.content.Intent
                            r3.<init>()
                            r3.setFlags(r1)
                            android.content.ComponentName r1 = new android.content.ComponentName
                            java.lang.String r4 = "com.Android.settings"
                            java.lang.String r5 = "com.android.settings.permission.TabItem"
                            r1.<init>(r4, r5)
                            r3.setComponent(r1)
                            r0.startActivity(r3)
                            r2.printStackTrace()
                        L_0x0069:
                            java.lang.String r0 = "HuaweiUtils"
                            java.lang.String r1 = android.util.Log.getStackTraceString(r2)
                            goto L_0x004a
                        L_0x0070:
                            r2 = move-exception
                            android.content.Intent r3 = new android.content.Intent
                            r3.<init>()
                            r3.setFlags(r1)
                            android.content.ComponentName r1 = new android.content.ComponentName
                            java.lang.String r4 = "com.huawei.systemmanager"
                            java.lang.String r5 = "com.huawei.permissionmanager.ui.MainActivity"
                            r1.<init>(r4, r5)
                            r3.setComponent(r1)
                            r0.startActivity(r3)
                            goto L_0x0069
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.e.a.a.AnonymousClass2.a():void");
                    }
                };
            } else if (g.e()) {
                r0 = new C0025a() {
                    public final void a() {
                        Context context = context;
                        Intent intent = new Intent();
                        intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
                        intent.setFlags(268435456);
                        if (f.a(intent, context)) {
                            context.startActivity(intent);
                            return;
                        }
                        intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
                        if (f.a(intent, context)) {
                            context.startActivity(intent);
                        } else {
                            Log.e("QikuUtils", "can't open permission page with particular name, please use \"adb shell dumpsys activity\" command and tell me the name of the float window permission page");
                        }
                    }
                };
            } else if (g.f()) {
                r0 = new C0025a() {
                    public final void a() {
                        Context context = context;
                        try {
                            Intent intent = new Intent();
                            intent.setFlags(268435456);
                            intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
                            context.startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
            } else {
                return;
            }
            a(context, r0);
        } else if (g.d()) {
            m(context);
        } else if (Build.VERSION.SDK_INT >= 23) {
            a(context, (C0025a) new C0025a() {
                public final void a() {
                    try {
                        a.c(context);
                    } catch (Exception e) {
                        Log.e(a.f1867a, Log.getStackTraceString(e));
                    }
                }
            });
        }
    }
}

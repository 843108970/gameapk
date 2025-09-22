package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import com.android.volley.b;
import com.android.volley.f;
import com.android.volley.m;
import java.io.File;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final String f562a = "volley";

    public static m a(Context context) {
        String str;
        File file = new File(context.getCacheDir(), f562a);
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            str = packageName + "/" + packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "volley/0";
        }
        m mVar = new m((b) new f(file, (byte) 0), (f) new c(Build.VERSION.SDK_INT >= 9 ? new j() : new g(AndroidHttpClient.newInstance(str))), (byte) 0);
        mVar.a();
        return mVar;
    }

    private static m b(Context context) {
        return a(context);
    }
}

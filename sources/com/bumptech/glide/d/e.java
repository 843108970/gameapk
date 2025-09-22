package com.bumptech.glide.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f928a = "ManifestParser";

    /* renamed from: b  reason: collision with root package name */
    private static final String f929b = "GlideModule";

    /* renamed from: c  reason: collision with root package name */
    private final Context f930c;

    public e(Context context) {
        this.f930c = context;
    }

    private static c a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            c cVar = null;
            try {
                cVar = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                a(cls, e);
            }
            if (cVar instanceof c) {
                return cVar;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + cVar);
        } catch (ClassNotFoundException e2) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e2);
        }
    }

    private static void a(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public final List<c> a() {
        if (Log.isLoggable(f928a, 3)) {
            Log.d(f928a, "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f930c.getPackageManager().getApplicationInfo(this.f930c.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable(f928a, 3)) {
                    Log.d(f928a, "Got null app info metadata");
                }
                return arrayList;
            }
            if (Log.isLoggable(f928a, 2)) {
                Log.v(f928a, "Got app info metadata: " + applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if (f929b.equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(a(str));
                    if (Log.isLoggable(f928a, 3)) {
                        Log.d(f928a, "Loaded Glide module: " + str);
                    }
                }
            }
            if (Log.isLoggable(f928a, 3)) {
                Log.d(f928a, "Finished loading Glide modules");
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }
}

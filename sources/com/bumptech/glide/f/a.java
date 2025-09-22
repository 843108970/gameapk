package com.bumptech.glide.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.load.g;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f951a = "AppVersionSignature";

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentMap<String, g> f952b = new ConcurrentHashMap();

    private a() {
    }

    @NonNull
    public static g a(@NonNull Context context) {
        String packageName = context.getPackageName();
        g gVar = (g) f952b.get(packageName);
        if (gVar != null) {
            return gVar;
        }
        PackageInfo c2 = c(context);
        d dVar = new d(c2 != null ? String.valueOf(c2.versionCode) : UUID.randomUUID().toString());
        g putIfAbsent = f952b.putIfAbsent(packageName, dVar);
        return putIfAbsent == null ? dVar : putIfAbsent;
    }

    @NonNull
    private static String a(@Nullable PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    @VisibleForTesting
    private static void a() {
        f952b.clear();
    }

    @NonNull
    private static g b(@NonNull Context context) {
        PackageInfo c2 = c(context);
        return new d(c2 != null ? String.valueOf(c2.versionCode) : UUID.randomUUID().toString());
    }

    @Nullable
    private static PackageInfo c(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(f951a, "Cannot resolve info for" + context.getPackageName(), e);
            return null;
        }
    }
}

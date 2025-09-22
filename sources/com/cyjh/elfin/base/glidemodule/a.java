package com.cyjh.elfin.base.glidemodule;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.bumptech.glide.f;
import com.bumptech.glide.g;
import java.io.File;

public final class a {
    private a() {
    }

    @NonNull
    private static d a(@NonNull Activity activity) {
        return (d) f.a(activity);
    }

    @Deprecated
    @NonNull
    private static d a(@NonNull Fragment fragment) {
        return (d) f.a(fragment);
    }

    @NonNull
    private static d a(@NonNull android.support.v4.app.Fragment fragment) {
        return (d) f.a(fragment);
    }

    @NonNull
    private static d a(@NonNull FragmentActivity fragmentActivity) {
        return (d) f.a(fragmentActivity);
    }

    @NonNull
    private static d a(@NonNull View view) {
        return (d) f.a(view);
    }

    @Nullable
    private static File a(@NonNull Context context) {
        return f.a(context);
    }

    @Nullable
    private static File a(@NonNull Context context, @NonNull String str) {
        return f.a(context, str);
    }

    @VisibleForTesting
    @SuppressLint({"VisibleForTests"})
    private static void a() {
        f.a();
    }

    @VisibleForTesting
    @SuppressLint({"VisibleForTests"})
    private static void a(@NonNull Context context, @NonNull g gVar) {
        f.a(context, gVar);
    }

    @VisibleForTesting
    @SuppressLint({"VisibleForTests"})
    @Deprecated
    private static void a(f fVar) {
        f.a(fVar);
    }

    @NonNull
    private static f b(@NonNull Context context) {
        return f.b(context);
    }

    @NonNull
    private static d c(@NonNull Context context) {
        return (d) f.c(context);
    }
}

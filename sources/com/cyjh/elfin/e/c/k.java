package com.cyjh.elfin.e.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.core.a.b;
import com.cyjh.common.a.a;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.floatingwindowprocess.service.FloatingWindowService;
import com.cyjh.elfin.services.BootService;
import com.cyjh.elfin.ui.activity.BindRegisterCodeActivity;
import com.cyjh.elfin.ui.activity.ElfinFreeActivity;
import com.cyjh.elfin.ui.activity.H5LinkJumpPageActivity;
import com.cyjh.elfin.ui.activity.SweepCodeZbarActivity;
import com.cyjh.elfin.ui.activity.UnbindRegistrationCodeActivity;
import com.elfin.ad.activity.FullScreenTwoAdActivity;

public final class k {
    public static void a(int i) {
        AppContext a2 = AppContext.a();
        Intent intent = new Intent(a2, FloatingWindowService.class);
        intent.putExtra(b.g, i);
        if (Build.VERSION.SDK_INT >= 26) {
            a2.startForegroundService(intent);
        } else {
            a2.startService(intent);
        }
    }

    private static void a(long j) {
        AppContext a2 = AppContext.a();
        Intent intent = new Intent(a2, FloatingWindowService.class);
        intent.putExtra(b.g, 202);
        intent.putExtra("tokenKey", j);
        if (Build.VERSION.SDK_INT >= 26) {
            a2.startForegroundService(intent);
        } else {
            a2.startService(intent);
        }
    }

    private static void a(Context context) {
        Intent intent = new Intent(context, ElfinFreeActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private static void a(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    private static void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, H5LinkJumpPageActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(H5LinkJumpPageActivity.class.getCanonicalName(), str);
        intent.putExtra(H5LinkJumpPageActivity.class.getSimpleName(), str2);
        context.startActivity(intent);
    }

    public static void a(String str) {
        AppContext a2 = AppContext.a();
        Intent intent = new Intent(a2, FloatingWindowService.class);
        intent.putExtra(b.g, 2);
        Bundle bundle = new Bundle();
        bundle.putInt(FloatingWindowService.k, 1);
        bundle.putString(FloatingWindowService.l, str);
        intent.putExtra(FloatingWindowService.i, bundle);
        if (Build.VERSION.SDK_INT >= 26) {
            a2.startForegroundService(intent);
        } else {
            a2.startService(intent);
        }
    }

    private static void a(String str, String[] strArr) {
        AppContext a2 = AppContext.a();
        Intent intent = new Intent(a2, FloatingWindowService.class);
        intent.putExtra(b.g, 2);
        Bundle bundle = new Bundle();
        bundle.putInt(FloatingWindowService.k, 0);
        bundle.putString(FloatingWindowService.o, a.h());
        bundle.putString(FloatingWindowService.j, str);
        bundle.putStringArray(FloatingWindowService.p, strArr);
        intent.putExtra(FloatingWindowService.i, bundle);
        if (Build.VERSION.SDK_INT >= 26) {
            a2.startForegroundService(intent);
        } else {
            a2.startService(intent);
        }
    }

    private static void b(Context context) {
        Intent intent = new Intent(context, FullScreenTwoAdActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private static void b(Context context, String str) {
        Intent intent = new Intent(context, BindRegisterCodeActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(BindRegisterCodeActivity.class.getCanonicalName(), str);
        context.startActivity(intent);
    }

    private static void c(Context context) {
        context.startService(new Intent(context, FloatingWindowService.class));
    }

    private static void c(Context context, String str) {
        Intent intent = new Intent(context, UnbindRegistrationCodeActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(UnbindRegistrationCodeActivity.class.getCanonicalName(), str);
        context.startActivity(intent);
    }

    private static void d(Context context) {
        context.startService(new Intent(AppContext.a(), BootService.class));
    }

    private static Intent e(Context context) {
        return new Intent(context, SweepCodeZbarActivity.class);
    }
}

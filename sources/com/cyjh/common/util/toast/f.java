package com.cyjh.common.util.toast;

import android.content.Intent;
import android.net.Uri;

public final class f {
    private f() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static Intent a(Intent intent, boolean z) {
        return z ? intent.addFlags(268435456) : intent;
    }

    private static Intent a(String str) {
        String a2 = a.a(str);
        if (s.b(a2)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClassName(str, a2);
        return intent.addFlags(268435456);
    }

    private static Intent a(String str, boolean z) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + str));
        return z ? intent.addFlags(268435456) : intent;
    }

    private static boolean a(Intent intent) {
        return q.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}

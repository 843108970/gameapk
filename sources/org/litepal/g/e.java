package org.litepal.g;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.litepal.LitePalApplication;
import org.litepal.g.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4846a = "litepal_version";

    /* renamed from: b  reason: collision with root package name */
    private static final String f4847b = "litepal_prefs";

    public static void a(String str) {
        String str2;
        SharedPreferences.Editor edit = LitePalApplication.a().getSharedPreferences(f4847b, 0).edit();
        if (TextUtils.isEmpty(str)) {
            str2 = f4846a;
        } else {
            if (str.endsWith(b.a.f4831a)) {
                str = str.replace(b.a.f4831a, "");
            }
            str2 = "litepal_version_" + str;
        }
        edit.remove(str2);
        edit.apply();
    }

    private static void a(String str, int i) {
        String str2;
        SharedPreferences.Editor edit = LitePalApplication.a().getSharedPreferences(f4847b, 0).edit();
        if (TextUtils.isEmpty(str)) {
            str2 = f4846a;
        } else {
            if (str.endsWith(b.a.f4831a)) {
                str = str.replace(b.a.f4831a, "");
            }
            str2 = "litepal_version_" + str;
        }
        edit.putInt(str2, i);
        edit.apply();
    }

    private static int b(String str) {
        String str2;
        SharedPreferences sharedPreferences = LitePalApplication.a().getSharedPreferences(f4847b, 0);
        if (TextUtils.isEmpty(str)) {
            str2 = f4846a;
        } else {
            if (str.endsWith(b.a.f4831a)) {
                str = str.replace(b.a.f4831a, "");
            }
            str2 = "litepal_version_" + str;
        }
        return sharedPreferences.getInt(str2, 0);
    }
}

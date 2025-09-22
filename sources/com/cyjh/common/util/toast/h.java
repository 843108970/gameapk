package com.cyjh.common.util.toast;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1720a = "KEY_LOCALE";

    /* renamed from: b  reason: collision with root package name */
    private static final String f1721b = "VALUE_FOLLOW_SYSTEM";

    private h() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static Locale a(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Locale a(java.lang.String r8) {
        /*
            char[] r0 = r8.toCharArray()
            int r1 = r0.length
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0008:
            r5 = 1
            if (r3 >= r1) goto L_0x0018
            char r6 = r0[r3]
            r7 = 36
            if (r6 != r7) goto L_0x0015
            if (r4 > 0) goto L_0x001c
            int r4 = r4 + 1
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x0018:
            if (r4 != r5) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            r1 = 0
            if (r0 != 0) goto L_0x0021
            return r1
        L_0x0021:
            java.lang.String r0 = "$"
            int r0 = r8.indexOf(r0)     // Catch:{ Exception -> 0x0036 }
            java.util.Locale r3 = new java.util.Locale     // Catch:{ Exception -> 0x0036 }
            java.lang.String r2 = r8.substring(r2, r0)     // Catch:{ Exception -> 0x0036 }
            int r0 = r0 + r5
            java.lang.String r8 = r8.substring(r0)     // Catch:{ Exception -> 0x0036 }
            r3.<init>(r2, r8)     // Catch:{ Exception -> 0x0036 }
            return r3
        L_0x0036:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.util.toast.h.a(java.lang.String):java.util.Locale");
    }

    private static void a(Activity activity) {
        Locale locale;
        String string = k.a("Utils").f1723a.getString(f1720a, "");
        if (!TextUtils.isEmpty(string)) {
            if (f1721b.equals(string)) {
                Configuration configuration = Resources.getSystem().getConfiguration();
                locale = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
            } else {
                Locale a2 = a(string);
                if (a2 == null) {
                    Log.e("LanguageUtils", "The string of " + string + " is not in the correct format.");
                    k.a("Utils").f1723a.edit().remove(f1720a).apply();
                }
                locale = a2;
            }
            if (locale != null) {
                a((Context) activity, locale);
                a((Context) q.a(), locale);
            }
        }
    }

    static void a(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    private static void a(Configuration configuration, Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
    }

    private static Locale b(String str) {
        Locale a2 = a(str);
        if (a2 == null) {
            Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
            k.a("Utils").f1723a.edit().remove(f1720a).apply();
        }
        return a2;
    }

    private static boolean c(String str) {
        int i = 0;
        for (char c2 : str.toCharArray()) {
            if (c2 == '$') {
                if (i > 0) {
                    return false;
                }
                i++;
            }
        }
        return i == 1;
    }
}

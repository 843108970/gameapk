package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.cyjh.common.util.s;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.proguard.v;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f3944a;

    /* renamed from: b  reason: collision with root package name */
    private String f3945b;

    /* renamed from: c  reason: collision with root package name */
    private String f3946c;

    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a  reason: collision with other inner class name */
    private static class C0057a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f3947a = new a();

        private C0057a() {
        }
    }

    private a() {
        this.f3945b = null;
        this.f3946c = null;
    }

    public static a a(Context context) {
        if (f3944a == null && context != null) {
            f3944a = context.getApplicationContext();
        }
        return C0057a.f3947a;
    }

    private void c(String str) {
        try {
            String replaceAll = str.replaceAll("&=", s.a.f1696a).replaceAll("&&", s.a.f1696a).replaceAll("==", "/");
            this.f3945b = replaceAll + "/Android/" + Build.DISPLAY + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE + s.a.f1696a + HelperUtils.getUmengMD5(UMUtils.getAppkey(f3944a));
        } catch (Throwable th) {
            e.a(f3944a, th);
        }
    }

    private void d(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split("&=");
                StringBuilder sb = new StringBuilder();
                sb.append(v.ar);
                for (String str3 : split) {
                    if (!TextUtils.isEmpty(str3)) {
                        String substring = str3.substring(0, 2);
                        if (substring.endsWith("=")) {
                            substring = substring.replace("=", "");
                        }
                        sb.append(substring);
                    }
                }
                this.f3946c = sb.toString();
            }
        } catch (Throwable th) {
            e.a(f3944a, th);
        }
    }

    public String a() {
        return this.f3946c;
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith("a");
        }
        return false;
    }

    public String b() {
        return this.f3945b;
    }

    public void b(String str) {
        String substring = str.substring(0, str.indexOf(95));
        d(substring);
        c(substring);
    }
}

package com.cyjh.elfin.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.l;
import com.cyjh.common.util.r;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.entity.ParamsWrap;
import com.cyjh.http.bean.response.RegCodeStatusInfo;
import com.cyjh.http.e.a;
import com.ywfzjbcy.R;

public class c {
    public static boolean d = true;
    private static final String e = "PayModelManager";
    private static c f;

    /* renamed from: a  reason: collision with root package name */
    public String f1864a;

    /* renamed from: b  reason: collision with root package name */
    public long f1865b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f1866c = -1;
    private int g;
    private boolean h = false;

    private static SpannableString a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        int indexOf = str.indexOf(str2);
        int length = (str2.length() + indexOf) - 2;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), indexOf, length, 17);
        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#2964AA")), indexOf, length, 17);
        if (TextUtils.isEmpty(str3)) {
            return spannableString;
        }
        int indexOf2 = str.indexOf(str3);
        int length2 = (str3.length() + indexOf2) - 2;
        spannableString.setSpan(new StyleSpan(1), indexOf2, length2, 17);
        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#2964AA")), indexOf2, length2, 17);
        if (TextUtils.isEmpty(str4)) {
            return spannableString;
        }
        int indexOf3 = str.indexOf(str4);
        int length3 = (str4.length() + indexOf3) - 1;
        spannableString.setSpan(new StyleSpan(1), indexOf3, length3, 17);
        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#2964AA")), indexOf3, length3, 17);
        return spannableString;
    }

    public static c a() {
        if (f == null) {
            synchronized (c.class) {
                if (f == null) {
                    c cVar = new c();
                    f = cVar;
                    return cVar;
                }
            }
        }
        return f;
    }

    private void a(int i) {
        this.g = i;
    }

    private void a(long j) {
        this.f1865b = j;
    }

    private void a(String str) {
        this.f1864a = str;
    }

    private static String b(long j) {
        return l.a(AppContext.a(), j);
    }

    private long d() {
        return this.f1865b;
    }

    private String e() {
        SpannableString spannableString;
        if (!TextUtils.isEmpty(this.f1864a) && this.f1865b != -1) {
            long currentTimeMillis = (this.f1865b - (System.currentTimeMillis() / 1000)) / 60;
            return currentTimeMillis > 0 ? l.a(AppContext.a(), currentTimeMillis) : "";
        } else if (ParamsWrap.getParamsWrap().onceTryMinute <= 0) {
            this.f1866c = 3;
            return AppContext.a().getString(R.string.optionfragment_duetime_no);
        } else {
            this.f1866c = 1;
            String format = String.format(AppContext.a().getString(R.string.optionfragment_unpaid), new Object[]{Integer.valueOf(ParamsWrap.getParamsWrap().onceTryMinute)});
            String str = ParamsWrap.getParamsWrap().onceTryMinute + "分钟";
            if (TextUtils.isEmpty(str)) {
                spannableString = null;
            } else {
                int indexOf = format.indexOf(str);
                int length = (str.length() + indexOf) - 2;
                SpannableString spannableString2 = new SpannableString(format);
                spannableString2.setSpan(new StyleSpan(1), indexOf, length, 17);
                spannableString2.setSpan(new BackgroundColorSpan(Color.parseColor("#2964AA")), indexOf, length, 17);
                if (!TextUtils.isEmpty("")) {
                    int indexOf2 = format.indexOf("");
                    int length2 = ("".length() + indexOf2) - 2;
                    spannableString2.setSpan(new StyleSpan(1), indexOf2, length2, 17);
                    spannableString2.setSpan(new BackgroundColorSpan(Color.parseColor("#2964AA")), indexOf2, length2, 17);
                    if (!TextUtils.isEmpty("")) {
                        int indexOf3 = format.indexOf("");
                        int length3 = ("".length() + indexOf3) - 1;
                        spannableString2.setSpan(new StyleSpan(1), indexOf3, length3, 17);
                        spannableString2.setSpan(new BackgroundColorSpan(Color.parseColor("#2964AA")), indexOf3, length3, 17);
                    }
                }
                spannableString = spannableString2;
            }
            return spannableString.toString();
        }
    }

    @SuppressLint({"StringFormatMatches"})
    private String f() {
        SpannableString spannableString;
        if (ParamsWrap.getParamsWrap().onceTryMinute <= 0) {
            this.f1866c = 3;
            return AppContext.a().getString(R.string.optionfragment_duetime_no);
        }
        this.f1866c = 1;
        String format = String.format(AppContext.a().getString(R.string.optionfragment_unpaid), new Object[]{Integer.valueOf(ParamsWrap.getParamsWrap().onceTryMinute)});
        String str = ParamsWrap.getParamsWrap().onceTryMinute + "分钟";
        if (TextUtils.isEmpty(str)) {
            spannableString = null;
        } else {
            int indexOf = format.indexOf(str);
            int length = (str.length() + indexOf) - 2;
            SpannableString spannableString2 = new SpannableString(format);
            spannableString2.setSpan(new StyleSpan(1), indexOf, length, 17);
            spannableString2.setSpan(new BackgroundColorSpan(Color.parseColor("#2964AA")), indexOf, length, 17);
            if (!TextUtils.isEmpty("")) {
                int indexOf2 = format.indexOf("");
                int length2 = ("".length() + indexOf2) - 2;
                spannableString2.setSpan(new StyleSpan(1), indexOf2, length2, 17);
                spannableString2.setSpan(new BackgroundColorSpan(Color.parseColor("#2964AA")), indexOf2, length2, 17);
                if (!TextUtils.isEmpty("")) {
                    int indexOf3 = format.indexOf("");
                    int length3 = ("".length() + indexOf3) - 1;
                    spannableString2.setSpan(new StyleSpan(1), indexOf3, length3, 17);
                    spannableString2.setSpan(new BackgroundColorSpan(Color.parseColor("#2964AA")), indexOf3, length3, 17);
                }
            }
            spannableString = spannableString2;
        }
        return spannableString.toString();
    }

    private String g() {
        long currentTimeMillis = (this.f1865b - (System.currentTimeMillis() / 1000)) / 60;
        return currentTimeMillis > 0 ? l.a(AppContext.a(), currentTimeMillis) : "";
    }

    private int h() {
        return this.g;
    }

    private void i() {
        if (d) {
            long currentTimeMillis = (this.f1865b - (System.currentTimeMillis() / 1000)) / 60;
            if (currentTimeMillis > 0) {
                AppContext a2 = AppContext.a();
                ag.b((Context) a2, "注册码" + l.a(AppContext.a(), currentTimeMillis));
            }
        }
    }

    private void j() {
        this.f1866c = 0;
    }

    public final String b() {
        if (!TextUtils.isEmpty(this.f1864a)) {
            return this.f1864a;
        }
        if (this.h) {
            return "";
        }
        c();
        return TextUtils.isEmpty(this.f1864a) ? "" : this.f1864a;
    }

    public final void c() {
        String a2 = a.a(com.cyjh.common.b.a.ax + com.cyjh.common.a.a.c(), (Context) AppContext.a());
        String a3 = a.a(com.cyjh.common.b.a.ay + com.cyjh.common.a.a.c(), (Context) AppContext.a());
        if (TextUtils.isEmpty(a3)) {
            this.f1864a = a2;
            return;
        }
        RegCodeStatusInfo regCodeStatusInfo = (RegCodeStatusInfo) r.a(a3, RegCodeStatusInfo.class);
        if (regCodeStatusInfo != null) {
            this.f1864a = regCodeStatusInfo.regCode;
        }
    }
}

package com.b.a.a.c;

import android.support.v7.widget.ActivityChooserView;
import com.b.a.aa;
import com.b.a.ac;
import com.b.a.as;
import com.b.a.r;
import com.b.a.s;
import java.util.regex.Pattern;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f611a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static int a(String str, int i) {
        while (i < str.length() && ((r0 = str.charAt(i)) == ' ' || r0 == 9)) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static long a(aa aaVar) {
        return a(aaVar.a("Content-Length"));
    }

    public static long a(as asVar) {
        return a(asVar.d());
    }

    private static long a(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static void a(s sVar, ac acVar, aa aaVar) {
        if (sVar != s.f831a && !r.a(acVar, aaVar).isEmpty()) {
            sVar.a();
        }
    }

    public static int b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static boolean b(as asVar) {
        if (asVar.a().b().equals("HEAD")) {
            return false;
        }
        int b2 = asVar.b();
        return (((b2 >= 100 && b2 < 200) || b2 == 204 || b2 == 304) && a(asVar.d()) == -1 && !"chunked".equalsIgnoreCase(asVar.a("Transfer-Encoding"))) ? false : true;
    }
}

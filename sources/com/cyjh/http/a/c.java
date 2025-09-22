package com.cyjh.http.a;

import android.content.Context;
import android.text.TextUtils;
import com.cyjh.common.util.ad;
import com.cyjh.http.bean.response.PhoneConfig;
import com.cyjh.http.e.a;
import java.util.Iterator;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f2461a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f2462b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static int f2463c = 1;
    public static int d = 0;
    private static String f = "c";
    private static c g;
    public int e;

    private c() {
    }

    public static c a() {
        if (g == null) {
            synchronized (c.class) {
                if (g == null) {
                    g = new c();
                }
            }
        }
        return g;
    }

    private static boolean a(Context context, int i, String[] strArr) {
        boolean z;
        ad.c(f, "getRecognitionResult --> mode=" + i);
        if (strArr != null) {
            boolean z2 = true;
            boolean z3 = false;
            z = false;
            for (String str : strArr) {
                boolean a2 = a.a(context, str);
                ad.c(f, "getRecognitionResult --> packageName=" + str + ",isInstall=" + a2);
                if (i == f2461a) {
                    z2 &= a2;
                    z = z2;
                } else if (i == f2462b) {
                    z3 |= a2;
                    z = z3;
                }
                if (!z2 || z3) {
                    break;
                }
            }
        } else {
            z = false;
        }
        ad.c(f, "getRecognitionResult --> result=" + z);
        return z;
    }

    private static String[] a(String str) {
        String str2 = f;
        ad.c(str2, "getPackageArr --> packageNames=" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains(",")) {
            return str.split(",");
        }
        return new String[]{str};
    }

    private int b() {
        return this.e;
    }

    public final PhoneConfig a(Context context, List<PhoneConfig> list) {
        String[] strArr;
        Iterator<PhoneConfig> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PhoneConfig next = it.next();
            int judgeMode = next.getJudgeMode();
            String str = next.getPackage();
            ad.c(f, "getPackageArr --> packageNames=" + str);
            if (TextUtils.isEmpty(str)) {
                strArr = null;
            } else if (str.contains(",")) {
                strArr = str.split(",");
            } else {
                strArr = new String[]{str};
            }
            boolean a2 = a(context, judgeMode, strArr);
            ad.c(f, "init --> recognitionResult=" + a2);
            if (a2) {
                this.e = next.getCloudPhoneType();
                if (next.getActive() == d) {
                    return next;
                }
            }
        }
        return null;
    }
}

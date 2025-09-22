package org.litepal.g;

import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Locale;
import org.litepal.LitePalApplication;
import org.litepal.c.e;
import org.litepal.g.b;

public final class a {
    private a() {
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        String str2 = org.litepal.e.a.a().f4731c;
        return b.a.d.equals(str2) ? str : b.a.f4832b.equals(str2) ? str.toUpperCase(Locale.US) : str.toLowerCase(Locale.US);
    }

    public static void a(String... strArr) {
        int length;
        if (strArr != null && (length = strArr.length) > 0) {
            int i = 0;
            String str = strArr[0];
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty("?")) {
                while (true) {
                    int indexOf = str.indexOf("?");
                    if (indexOf == -1) {
                        break;
                    }
                    i++;
                    str = str.substring(indexOf + "?".length());
                }
            }
            if (length != i + 1) {
                throw new e(e.UPDATE_CONDITIONS_EXCEPTION);
            }
        }
    }

    public static boolean a() {
        try {
            String[] list = LitePalApplication.a().getAssets().list("");
            if (list != null && list.length > 0) {
                for (String equalsIgnoreCase : list) {
                    if (b.a.e.equalsIgnoreCase(equalsIgnoreCase)) {
                        return true;
                    }
                }
            }
        } catch (IOException unused) {
        }
        return false;
    }

    public static boolean a(String str, String str2) {
        try {
            for (Method name : Class.forName(str).getMethods()) {
                if (str2.equals(name.getName())) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean a(Collection<String> collection, String str) {
        if (collection == null) {
            return false;
        }
        if (str == null) {
            return collection.contains((Object) null);
        }
        for (String equalsIgnoreCase : collection) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    private static int b(String str, String str2) {
        int i = 0;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            while (true) {
                int indexOf = str.indexOf(str2);
                if (indexOf == -1) {
                    break;
                }
                i++;
                str = str.substring(indexOf + str2.length());
            }
        }
        return i;
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.substring(0, 1).toUpperCase(Locale.US) + str.substring(1);
        } else if (str == null) {
            return null;
        } else {
            return "";
        }
    }

    public static boolean c(String str) {
        return "java.lang.String".equals(str) || "java.lang.Integer".equals(str) || "java.lang.Float".equals(str) || "java.lang.Double".equals(str) || "java.lang.Long".equals(str) || "java.lang.Short".equals(str) || "java.lang.Boolean".equals(str) || "java.lang.Character".equals(str);
    }

    private static boolean d(String str) {
        return "boolean".equals(str) || "java.lang.Boolean".equals(str) || "float".equals(str) || "java.lang.Float".equals(str) || "double".equals(str) || "java.lang.Double".equals(str) || "int".equals(str) || "java.lang.Integer".equals(str) || "long".equals(str) || "java.lang.Long".equals(str) || "short".equals(str) || "java.lang.Short".equals(str) || "char".equals(str) || "java.lang.Character".equals(str) || "[B".equals(str) || "[Ljava.lang.Byte;".equals(str) || "java.lang.String".equals(str) || "java.util.Date".equals(str);
    }
}

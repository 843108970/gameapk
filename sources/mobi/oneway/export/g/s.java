package mobi.oneway.export.g;

import android.text.TextUtils;
import com.cyjh.common.util.s;
import com.cyjh.http.e.a;
import com.umeng.commonsdk.amap.UMAmapConfig;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class s {
    public static String a(int i) {
        String str;
        Object[] objArr;
        if (i > 1048576) {
            str = "%.1fM";
            objArr = new Object[]{Float.valueOf((float) ((((double) i) * 1.0d) / 1048576.0d))};
        } else {
            str = "%.1fK";
            objArr = new Object[]{Float.valueOf((float) ((((double) i) * 1.0d) / 1024.0d))};
        }
        return b(str, objArr);
    }

    public static String a(long j) {
        if (j > UMAmapConfig.AMAP_CACHE_WRITE_TIME) {
            return b("%.1f 万", Double.valueOf(((double) j) / 10000.0d));
        }
        return String.valueOf(j) + s.a.f1696a;
    }

    public static String a(InputStream inputStream) {
        return a(inputStream, (String) null);
    }

    public static String a(InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        InputStreamReader b2 = t.b(inputStream, str);
        char[] cArr = new char[4096];
        while (true) {
            int read = b2.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    public static String a(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return str;
        }
        String[] split = str.split("\\.");
        return split[split.length - 1];
    }

    public static String a(String str, int i) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("[\\r\\n]+");
        if (i >= split.length) {
            return null;
        }
        return split[i];
    }

    public static String a(String str, String str2, String str3, Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        for (int i = 0; i < objArr.length - 1; i++) {
            sb.append(objArr[i]);
            if (str3 != null) {
                sb.append(str3);
            }
        }
        sb.append(objArr[objArr.length - 1]);
        if (str2 != null) {
            sb.append(str2);
        }
        return sb.toString();
    }

    public static String a(String str, List list) {
        if (list == null) {
            return null;
        }
        Object[] objArr = new Object[list.size()];
        list.toArray(objArr);
        return a(str, objArr);
    }

    public static String a(String str, Object... objArr) {
        return a((String) null, (String) null, str, objArr);
    }

    public static String a(Date date) {
        return new SimpleDateFormat(a.f2523b, Locale.getDefault()).format(date);
    }

    public static String a(Object... objArr) {
        return a((String) null, (String) null, (String) null, objArr);
    }

    public static boolean a(String str, String str2) {
        return str != null && str.equals(str2);
    }

    public static boolean a(String str, String... strArr) {
        if (str == null) {
            return false;
        }
        for (String equals : strArr) {
            if (!str.equals(equals)) {
                return false;
            }
        }
        return true;
    }

    public static String b(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    public static String b(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(date);
    }

    public static boolean b(String str, String... strArr) {
        if (str == null || strArr.length == 0) {
            return false;
        }
        for (String equals : strArr) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(String str, String... strArr) {
        if (str == null || strArr == null) {
            return false;
        }
        for (String contains : strArr) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}

package org.litepal.b;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.List;
import java.util.Locale;
import org.litepal.g.a;
import org.litepal.g.c;

public final class i extends b {
    public i(SQLiteDatabase sQLiteDatabase) {
        this.e = sQLiteDatabase;
    }

    public final double a(String str, String str2, String[] strArr) {
        a.a(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = c.e(strArr[0]);
        }
        return ((Double) a(str, new String[]{"avg(" + str2 + ")"}, strArr, Double.TYPE)).doubleValue();
    }

    public final int a(String str, String[] strArr) {
        a.a(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = c.e(strArr[0]);
        }
        return ((Integer) a(str, new String[]{"count(1)"}, strArr, Integer.TYPE)).intValue();
    }

    public final <T> T a(Class<T> cls, long j, boolean z) {
        Class<T> cls2 = cls;
        List<T> a2 = a(cls2, (String[]) null, "id = ?", new String[]{String.valueOf(j)}, (String) null, (String) null, a(cls.getName(), z));
        if (a2.size() > 0) {
            return a2.get(0);
        }
        return null;
    }

    public final <T> T a(Class<T> cls, boolean z) {
        List<T> a2 = a(cls, (String[]) null, (String) null, (String[]) null, "id", "1", a(cls.getName(), z));
        if (a2.size() > 0) {
            return a2.get(0);
        }
        return null;
    }

    public final <T> T a(String str, String str2, String[] strArr, Class<T> cls) {
        a.a(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = c.e(strArr[0]);
        }
        return a(str, new String[]{"max(" + str2 + ")"}, strArr, cls);
    }

    public final <T> List<T> a(Class<T> cls, boolean z, long... jArr) {
        int i = 0;
        new Object[1][0] = jArr;
        StringBuilder sb = new StringBuilder();
        int length = jArr.length;
        boolean z2 = false;
        while (i < length) {
            long j = jArr[i];
            if (z2) {
                sb.append(" or ");
            }
            sb.append("id = ");
            sb.append(j);
            i++;
            z2 = true;
        }
        return a(cls, (String[]) null, a.a(sb.toString()), (String[]) null, "id", (String) null, a(cls.getName(), z));
    }

    public final <T> List<T> a(Class<T> cls, String[] strArr, String[] strArr2, String str, String str2, boolean z) {
        String str3;
        a.a(strArr2);
        int i = 0;
        if (strArr2 != null && strArr2.length > 0) {
            strArr2[0] = c.e(strArr2[0]);
        }
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.trim().toLowerCase(Locale.US);
            if (lowerCase.contains(",")) {
                String[] split = lowerCase.split(",");
                StringBuilder sb = new StringBuilder();
                int length = split.length;
                boolean z2 = false;
                while (i < length) {
                    String str4 = split[i];
                    if (z2) {
                        sb.append(",");
                    }
                    sb.append(c.f(str4));
                    i++;
                    z2 = true;
                }
                str3 = sb.toString();
            } else {
                str3 = c.f(lowerCase);
            }
        } else {
            str3 = null;
        }
        return a(cls, strArr, a(strArr2), b(strArr2), str3, str2, a(cls.getName(), z));
    }

    public final <T> T b(Class<T> cls, boolean z) {
        List<T> a2 = a(cls, (String[]) null, (String) null, (String[]) null, "id desc", "1", a(cls.getName(), z));
        if (a2.size() > 0) {
            return a2.get(0);
        }
        return null;
    }

    public final <T> T b(String str, String str2, String[] strArr, Class<T> cls) {
        a.a(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = c.e(strArr[0]);
        }
        return a(str, new String[]{"min(" + str2 + ")"}, strArr, cls);
    }

    public final <T> T c(String str, String str2, String[] strArr, Class<T> cls) {
        a.a(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = c.e(strArr[0]);
        }
        return a(str, new String[]{"sum(" + str2 + ")"}, strArr, cls);
    }
}

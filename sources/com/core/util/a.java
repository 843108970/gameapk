package com.core.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.core.util.share.c;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public final class a {
    public static int a(Context context, String str, String str2) {
        return c.a(context, str).getInt(str2, 0);
    }

    private static SharedPreferences a(Context context, String str) {
        return c.a(context, str);
    }

    private static <T> List<T> a(String str) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str.getBytes(), 0)));
            List<T> list = (List) objectInputStream.readObject();
            objectInputStream.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void a(Context context, String str, String str2, int i) {
        c.a(context, str).edit().putInt(str2, i).commit();
    }

    private static void a(Context context, String str, String str2, String str3) {
        c.a(context, str).edit().putString(str2, str3).commit();
    }

    private static void a(Context context, String str, String str2, boolean z) {
        c.a(context, str).edit().putBoolean(str2, z).commit();
    }

    private static String b(Context context, String str, String str2, String str3) {
        return c.a(context, str).getString(str2, str3);
    }

    private static boolean b(Context context, String str, String str2, boolean z) {
        return c.a(context, str).getBoolean(str2, z);
    }
}

package com.cyjh.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1692a = "yyyy-MM-dd HH:mm:ss";

    private static Gson a() {
        return new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    public static Object a(String str, Class cls) {
        try {
            return new Gson().fromJson(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(Object obj) {
        try {
            return new Gson().toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <T> List<T> a(String str) {
        return (List) new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create().fromJson(str, new TypeToken<List<T>>() {
        }.getType());
    }

    private static Object b(Object obj) {
        try {
            return new Gson().toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <T> Object b(String str) {
        try {
            return new Gson().fromJson(str, new TypeToken<List<T>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.cyjh.mobileanjian.ipc.utils;

import java.util.HashMap;
import java.util.List;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Class> f2723a = new HashMap<String, Class>() {
        {
            put("boolean", Boolean.TYPE);
            put("int", Integer.TYPE);
            put("long", Long.TYPE);
            put("String", String.class);
        }
    };

    private static Object a(Class cls, String str) {
        String str2 = null;
        try {
            switch (n.j.f2714b.get(cls).intValue()) {
                case 1:
                    return Boolean.valueOf(Boolean.parseBoolean(str));
                case 2:
                    return Character.valueOf(str.length() > 0 ? str.charAt(0) : ' ');
                case 3:
                    Byte.parseByte(str);
                    break;
                case 4:
                    return Integer.valueOf(Integer.parseInt(str));
                case 5:
                    return Long.valueOf(Long.parseLong(str));
                case 6:
                    return Float.valueOf(Float.parseFloat(str));
                case 7:
                    Double.parseDouble(str);
                    break;
                case 9:
                    if (str == null) {
                        str = "";
                    }
                    str2 = str;
                    break;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return str2;
    }

    private static Object a(String str, String str2) {
        switch (n.j.f2713a.get(str).intValue()) {
            case 1:
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            case 2:
                if (str2.length() > 0) {
                    return Character.valueOf(str2.charAt(0));
                }
                break;
            case 3:
                Byte.parseByte(str2);
                break;
            case 4:
                return Integer.valueOf(Integer.parseInt(str2));
            case 5:
                return Long.valueOf(Long.parseLong(str2));
            case 6:
                return Float.valueOf(Float.parseFloat(str2));
            case 7:
                Double.parseDouble(str2);
                break;
            case 9:
                return str2;
        }
        return null;
    }

    public static Object[] a(List<String> list, List<String> list2) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int size = list.size();
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            Object a2 = a(list.get(i), list2.get(i));
            objArr[i] = a2;
            if (a2 == null) {
                return null;
            }
        }
        return objArr;
    }

    private static Object[] a(Class[] clsArr, String[] strArr) {
        if (clsArr == null || clsArr.length == 0) {
            return null;
        }
        Object[] objArr = new Object[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            Object a2 = a(clsArr[i], strArr[i]);
            objArr[i] = a2;
            if (a2 == null) {
                return null;
            }
        }
        return objArr;
    }

    private static Object[] a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        Object[] objArr = new Object[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            Object a2 = a(strArr[i], strArr2[i]);
            objArr[i] = a2;
            if (a2 == null) {
                return null;
            }
        }
        return objArr;
    }
}

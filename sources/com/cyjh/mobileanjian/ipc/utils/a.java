package com.cyjh.mobileanjian.ipc.utils;

public final class a {
    public static boolean a(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean b(Object[] objArr) {
        for (Object obj : objArr) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }
}

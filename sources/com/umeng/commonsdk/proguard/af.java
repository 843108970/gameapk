package com.umeng.commonsdk.proguard;

import java.lang.reflect.InvocationTargetException;

public class af {
    public static ae a(Class<? extends ae> cls, int i) {
        try {
            return (ae) cls.getMethod("findByValue", new Class[]{Integer.TYPE}).invoke((Object) null, new Object[]{Integer.valueOf(i)});
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}

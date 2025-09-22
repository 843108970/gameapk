package com.king.sdk.a;

import android.content.Intent;
import android.os.IBinder;
import java.lang.reflect.Method;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Method f3528a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f3529b;

    static {
        try {
            Method declaredMethod = Intent.class.getDeclaredMethod("getIBinderExtra", new Class[]{String.class});
            f3528a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = Intent.class.getDeclaredMethod("putExtra", new Class[]{String.class, IBinder.class});
            f3529b = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    public static IBinder a(Intent intent, String str) {
        try {
            return (IBinder) f3528a.invoke(intent, new Object[]{str});
        } catch (Exception unused) {
            return null;
        }
    }
}

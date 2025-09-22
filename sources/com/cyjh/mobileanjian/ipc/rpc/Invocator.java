package com.cyjh.mobileanjian.ipc.rpc;

import com.cyjh.mobileanjian.ipc.utils.n;
import com.cyjh.mobileanjian.ipc.utils.q;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Invocator {
    public static final String TAG = "Invocator";

    public static int invoke(String str, String str2, String str3, List<String> list, List<String> list2) {
        StringBuilder sb = new StringBuilder("want method: ");
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        sb.append(".");
        sb.append(str3);
        new StringBuilder("types: ").append(list);
        new StringBuilder("value: ").append(list2);
        if (list == null && list2 != null) {
            return 6;
        }
        if (list != null && list2 == null) {
            return 6;
        }
        if (list != null && list2 != null && list.size() != list2.size()) {
            return 6;
        }
        Class[] clsArr = null;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    clsArr = new Class[list.size()];
                    for (int i = 0; i < clsArr.length; i++) {
                        clsArr[i] = n.j.a(list.get(i));
                    }
                }
            } catch (ClassNotFoundException unused) {
                return 1;
            } catch (NoSuchMethodException unused2) {
                return 2;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return 3;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return 4;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return 5;
            }
        }
        Class<?> cls = Class.forName(str + "." + str2);
        Method declaredMethod = cls.getDeclaredMethod(str3, clsArr);
        new StringBuilder("Get method: ").append(declaredMethod);
        Object[] a2 = q.a(list, list2);
        if (clsArr != null && a2 == null) {
            return 7;
        }
        declaredMethod.invoke(cls, a2);
        return 0;
    }

    public static Object invoke(String str, String str2, String str3, List<String> list, List<String> list2, int i) {
        Class[] clsArr;
        Object[] a2;
        StringBuilder sb = new StringBuilder("want method: ");
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        sb.append(".");
        sb.append(str3);
        new StringBuilder("types: ").append(list);
        new StringBuilder("value: ").append(list2);
        if ((list == null && list2 != null) || ((list != null && list2 == null) || (list != null && list2 != null && list.size() != list2.size()))) {
            return null;
        }
        if (list != null) {
            try {
                if (list.size() > 0) {
                    clsArr = new Class[list.size()];
                    for (int i2 = 0; i2 < clsArr.length; i2++) {
                        clsArr[i2] = n.j.a(list.get(i2));
                    }
                    Class<?> cls = Class.forName(str + "." + str2);
                    Method declaredMethod = cls.getDeclaredMethod(str3, clsArr);
                    new StringBuilder("Get method: ").append(declaredMethod);
                    a2 = q.a(list, list2);
                    if (clsArr == null && a2 == null) {
                        return null;
                    }
                    Object invoke = declaredMethod.invoke(cls, a2);
                    new StringBuilder("result: ").append(invoke);
                    return invoke;
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        clsArr = null;
        Class<?> cls2 = Class.forName(str + "." + str2);
        Method declaredMethod2 = cls2.getDeclaredMethod(str3, clsArr);
        new StringBuilder("Get method: ").append(declaredMethod2);
        a2 = q.a(list, list2);
        if (clsArr == null) {
        }
        Object invoke2 = declaredMethod2.invoke(cls2, a2);
        new StringBuilder("result: ").append(invoke2);
        return invoke2;
    }

    public static boolean isListEmpty(List list) {
        return list == null || list.size() == 0;
    }
}

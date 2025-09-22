package com.cyjh.mobileanjian.rpc;

import com.cyjh.mobileanjian.ipc.rpc.Invocator;
import com.cyjh.mobileanjian.ipc.utils.a;
import com.cyjh.mobileanjian.ipc.utils.l;
import com.cyjh.mobileanjian.ipc.utils.p;
import java.util.ArrayList;
import java.util.List;

public class Rpc {
    public static boolean AsynCall(String str, String str2, String str3, String[] strArr, String[] strArr2) {
        if (p.a(str) || p.a(str2) || p.a(str3) || checkArgs(strArr, strArr2) == -1) {
            return false;
        }
        new StringBuilder("retObj = ").append(Invocator.invoke(str, str2, str3, arrayToList(strArr), arrayToList(strArr2), 0));
        StringBuilder sb = new StringBuilder("已经调用了AsynCall ");
        sb.append(str);
        sb.append(".");
        sb.append(str3);
        return true;
    }

    public static int SimpleCallReturnInt(String str, String str2, String str3) {
        return ((Integer) SynCall(str, str2, str3, (String[]) null, (String[]) null, "int")).intValue();
    }

    public static String SimpleCallReturnString(String str, String str2, String str3) {
        return (String) SynCall(str, str2, str3, (String[]) null, (String[]) null, "String");
    }

    public static boolean SimpleCallStringParam(boolean z, String str, String str2, String str3, String str4) {
        if (z) {
            return SynCall(str, str2, str3, new String[]{"String"}, new String[]{str4});
        }
        return AsynCall(str, str2, str3, new String[]{"String"}, new String[]{str4});
    }

    public static boolean SimpleCallStringStringParam(boolean z, String str, String str2, String str3, String str4, String str5) {
        if (z) {
            return SynCall(str, str2, str3, new String[]{"String", "String"}, new String[]{str4, str5});
        }
        return AsynCall(str, str2, str3, new String[]{"String", "String"}, new String[]{str4, str5});
    }

    public static String SimpleCallStringStringParamReturnString(String str, String str2, String str3, String str4, String str5) {
        String[] strArr;
        String[] strArr2;
        if (str4 == null) {
            return "Use SimpleCallReturnString instead.";
        }
        if (str5 == null) {
            strArr2 = new String[]{String.class.getSimpleName()};
            strArr = new String[]{str4};
        } else {
            strArr = new String[]{str4, str5};
            strArr2 = new String[]{String.class.getSimpleName(), String.class.getSimpleName()};
        }
        return (String) SynCall(str, str2, str3, strArr2, strArr, "String");
    }

    public static Object SynCall(String str, String str2, String str3, String[] strArr, String[] strArr2, String str4) {
        List<String> list;
        List<String> list2;
        if (p.a(str) || p.a(str2) || p.a(str3)) {
            return false;
        }
        int checkArgs = checkArgs(strArr, strArr2);
        if (checkArgs == -1) {
            return false;
        }
        if (l.a(str4) == null) {
            return false;
        }
        if (checkArgs == 0) {
            List<String> arrayToList = arrayToList(strArr);
            list = arrayToList(strArr2);
            list2 = arrayToList;
        } else {
            list2 = null;
            list = null;
        }
        Object invoke = Invocator.invoke(str, str2, str3, list2, list, 0);
        new StringBuilder("retObj = ").append(invoke);
        try {
            switch (l.a(str4)) {
                case BOOLEAN:
                    return (Boolean) invoke;
                case INT:
                    return (Integer) invoke;
                case LONG:
                    return (Long) invoke;
                case FLOAT:
                    return (Float) invoke;
                case DOUBLE:
                    return (Double) invoke;
                case STRING:
                    return invoke == null ? "" : (String) invoke;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    public static boolean SynCall(String str, String str2, String str3, String[] strArr, String[] strArr2) {
        SynCall(str, str2, str3, strArr, strArr2, "void");
        return true;
    }

    private static List<String> arrayToList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String add : strArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private static int checkArgs(String[] strArr, String[] strArr2) {
        if (!a.a(strArr) || !a.a(strArr2)) {
            return (a.a(strArr) || a.a(strArr2) || a.b(strArr) || a.b(strArr2) || strArr.length != strArr2.length) ? -1 : 0;
        }
        return 1;
    }
}

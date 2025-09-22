package com.google.a.b.a;

import com.google.a.r;
import java.util.ArrayList;

public final class e extends a {
    private static String[] a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    private static String b(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + ' ' + str2;
    }

    private static d c(r rVar) {
        String b2 = b(rVar);
        String[] strArr = null;
        if (!b2.startsWith("BIZCARD:")) {
            return null;
        }
        String a2 = a("N:", b2, true);
        String a3 = a("X:", b2, true);
        if (a2 == null) {
            a2 = a3;
        } else if (a3 != null) {
            a2 = a2 + ' ' + a3;
        }
        String a4 = a("T:", b2, true);
        String a5 = a("C:", b2, true);
        String[] a6 = a("A:", b2);
        String a7 = a("B:", b2, true);
        String a8 = a("M:", b2, true);
        String a9 = a("F:", b2, true);
        String a10 = a("E:", b2, true);
        String[] b3 = b(a2);
        ArrayList arrayList = new ArrayList(3);
        if (a7 != null) {
            arrayList.add(a7);
        }
        if (a8 != null) {
            arrayList.add(a8);
        }
        if (a9 != null) {
            arrayList.add(a9);
        }
        int size = arrayList.size();
        if (size != 0) {
            strArr = (String[]) arrayList.toArray(new String[size]);
        }
        return new d(b3, (String[]) null, (String) null, strArr, (String[]) null, b(a10), (String[]) null, (String) null, (String) null, a6, (String[]) null, a5, (String) null, a4, (String[]) null, (String[]) null);
    }

    public final /* synthetic */ q a(r rVar) {
        String b2 = b(rVar);
        String[] strArr = null;
        if (!b2.startsWith("BIZCARD:")) {
            return null;
        }
        String a2 = a("N:", b2, true);
        String a3 = a("X:", b2, true);
        if (a2 == null) {
            a2 = a3;
        } else if (a3 != null) {
            a2 = a2 + ' ' + a3;
        }
        String a4 = a("T:", b2, true);
        String a5 = a("C:", b2, true);
        String[] a6 = a("A:", b2);
        String a7 = a("B:", b2, true);
        String a8 = a("M:", b2, true);
        String a9 = a("F:", b2, true);
        String a10 = a("E:", b2, true);
        String[] b3 = b(a2);
        ArrayList arrayList = new ArrayList(3);
        if (a7 != null) {
            arrayList.add(a7);
        }
        if (a8 != null) {
            arrayList.add(a8);
        }
        if (a9 != null) {
            arrayList.add(a9);
        }
        int size = arrayList.size();
        if (size != 0) {
            strArr = (String[]) arrayList.toArray(new String[size]);
        }
        return new d(b3, (String[]) null, (String) null, strArr, (String[]) null, b(a10), (String[]) null, (String) null, (String) null, a6, (String[]) null, a5, (String) null, a4, (String[]) null, (String[]) null);
    }
}

package com.google.a.b.a;

import com.google.a.r;
import java.util.ArrayList;
import org.apache.commons.io.IOUtils;

public final class b extends u {
    private static String[] a(String str, String str2) {
        ArrayList arrayList = null;
        for (int i = 1; i <= 3; i++) {
            String b2 = b(str + i + ':', str2, 13, true);
            if (b2 == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(3);
            }
            arrayList.add(b2);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static d c(r rVar) {
        String b2 = b(rVar);
        String[] strArr = null;
        if (!b2.contains("MEMORY") || !b2.contains(IOUtils.LINE_SEPARATOR_WINDOWS)) {
            return null;
        }
        String b3 = b("NAME1:", b2, 13, true);
        String b4 = b("NAME2:", b2, 13, true);
        String[] a2 = a("TEL", b2);
        String[] a3 = a("MAIL", b2);
        String b5 = b("MEMORY:", b2, 13, false);
        String b6 = b("ADD:", b2, 13, true);
        if (b6 != null) {
            strArr = new String[]{b6};
        }
        return new d(b(b3), (String[]) null, b4, a2, (String[]) null, a3, (String[]) null, (String) null, b5, strArr, (String[]) null, (String) null, (String) null, (String) null, (String[]) null, (String[]) null);
    }

    public final /* synthetic */ q a(r rVar) {
        String b2 = b(rVar);
        String[] strArr = null;
        if (!b2.contains("MEMORY") || !b2.contains(IOUtils.LINE_SEPARATOR_WINDOWS)) {
            return null;
        }
        String b3 = b("NAME1:", b2, 13, true);
        String b4 = b("NAME2:", b2, 13, true);
        String[] a2 = a("TEL", b2);
        String[] a3 = a("MAIL", b2);
        String b5 = b("MEMORY:", b2, 13, false);
        String b6 = b("ADD:", b2, 13, true);
        if (b6 != null) {
            strArr = new String[]{b6};
        }
        return new d(b(b3), (String[]) null, b4, a2, (String[]) null, a3, (String[]) null, (String) null, b5, strArr, (String[]) null, (String) null, (String) null, (String) null, (String[]) null, (String[]) null);
    }
}

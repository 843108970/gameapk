package com.google.a.b.a;

import com.google.a.r;

public final class c extends a {
    private static String a(String str) {
        int indexOf = str.indexOf(44);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1) + ' ' + str.substring(0, indexOf);
    }

    private static d c(r rVar) {
        String[] a2;
        String b2 = b(rVar);
        if (!b2.startsWith("MECARD:") || (a2 = a("N:", b2)) == null) {
            return null;
        }
        String str = a2[0];
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            str = str.substring(indexOf + 1) + ' ' + str.substring(0, indexOf);
        }
        String a3 = a("SOUND:", b2, true);
        String[] a4 = a("TEL:", b2);
        String[] a5 = a("EMAIL:", b2);
        String a6 = a("NOTE:", b2, false);
        String[] a7 = a("ADR:", b2);
        String a8 = a("BDAY:", b2, true);
        return new d(b(str), (String[]) null, a3, a4, (String[]) null, a5, (String[]) null, (String) null, a6, a7, (String[]) null, a("ORG:", b2, true), !a((CharSequence) a8, 8) ? null : a8, (String) null, a("URL:", b2), (String[]) null);
    }

    public final /* synthetic */ q a(r rVar) {
        String[] a2;
        String b2 = b(rVar);
        if (!b2.startsWith("MECARD:") || (a2 = a("N:", b2)) == null) {
            return null;
        }
        String str = a2[0];
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            str = str.substring(indexOf + 1) + ' ' + str.substring(0, indexOf);
        }
        String a3 = a("SOUND:", b2, true);
        String[] a4 = a("TEL:", b2);
        String[] a5 = a("EMAIL:", b2);
        String a6 = a("NOTE:", b2, false);
        String[] a7 = a("ADR:", b2);
        String a8 = a("BDAY:", b2, true);
        return new d(b(str), (String[]) null, a3, a4, (String[]) null, a5, (String[]) null, (String) null, a6, a7, (String[]) null, a("ORG:", b2, true), !a((CharSequence) a8, 8) ? null : a8, (String) null, a("URL:", b2), (String[]) null);
    }
}

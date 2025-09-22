package com.google.a.b.a;

import com.google.a.r;

public final class y extends u {
    private static h c(r rVar) {
        String str;
        String str2;
        String b2 = b(rVar);
        if (!b2.startsWith("smtp:") && !b2.startsWith("SMTP:")) {
            return null;
        }
        String substring = b2.substring(5);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            String substring2 = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
            int indexOf2 = substring2.indexOf(58);
            if (indexOf2 >= 0) {
                String substring3 = substring2.substring(indexOf2 + 1);
                str2 = substring2.substring(0, indexOf2);
                str = substring3;
            } else {
                str = null;
                str2 = substring2;
            }
        } else {
            str2 = null;
            str = null;
        }
        return new h(new String[]{substring}, (String[]) null, (String[]) null, str2, str);
    }

    public final /* synthetic */ q a(r rVar) {
        String str;
        String str2;
        String b2 = b(rVar);
        if (!b2.startsWith("smtp:") && !b2.startsWith("SMTP:")) {
            return null;
        }
        String substring = b2.substring(5);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            String substring2 = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
            int indexOf2 = substring2.indexOf(58);
            if (indexOf2 >= 0) {
                String substring3 = substring2.substring(indexOf2 + 1);
                str2 = substring2.substring(0, indexOf2);
                str = substring3;
            } else {
                str = null;
                str2 = substring2;
            }
        } else {
            str2 = null;
            str = null;
        }
        return new h(new String[]{substring}, (String[]) null, (String[]) null, str2, str);
    }
}

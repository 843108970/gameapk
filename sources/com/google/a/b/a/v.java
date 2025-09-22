package com.google.a.b.a;

import com.google.a.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class v extends u {
    private static void a(Collection<String> collection, Collection<String> collection2, String str) {
        int indexOf = str.indexOf(59);
        String str2 = null;
        if (indexOf < 0) {
            collection.add(str);
            collection2.add((Object) null);
            return;
        }
        collection.add(str.substring(0, indexOf));
        String substring = str.substring(indexOf + 1);
        if (substring.startsWith("via=")) {
            str2 = substring.substring(4);
        }
        collection2.add(str2);
    }

    private static w c(r rVar) {
        String str;
        String b2 = b(rVar);
        String str2 = null;
        if (!b2.startsWith("sms:") && !b2.startsWith("SMS:") && !b2.startsWith("mms:") && !b2.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> c2 = c(b2);
        boolean z = false;
        if (c2 == null || c2.isEmpty()) {
            str = null;
        } else {
            str2 = c2.get("subject");
            str = c2.get("body");
            z = true;
        }
        int indexOf = b2.indexOf(63, 4);
        String substring = (indexOf < 0 || !z) ? b2.substring(4) : b2.substring(4, indexOf);
        int i = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int i2 = i + 1;
            int indexOf2 = substring.indexOf(44, i2);
            if (indexOf2 > i) {
                a(arrayList, arrayList2, substring.substring(i2, indexOf2));
                i = indexOf2;
            } else {
                a(arrayList, arrayList2, substring.substring(i2));
                return new w((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
        }
    }

    public final /* synthetic */ q a(r rVar) {
        String str;
        String b2 = b(rVar);
        String str2 = null;
        if (!b2.startsWith("sms:") && !b2.startsWith("SMS:") && !b2.startsWith("mms:") && !b2.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> c2 = c(b2);
        boolean z = false;
        if (c2 == null || c2.isEmpty()) {
            str = null;
        } else {
            str2 = c2.get("subject");
            str = c2.get("body");
            z = true;
        }
        int indexOf = b2.indexOf(63, 4);
        String substring = (indexOf < 0 || !z) ? b2.substring(4) : b2.substring(4, indexOf);
        int i = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int i2 = i + 1;
            int indexOf2 = substring.indexOf(44, i2);
            if (indexOf2 > i) {
                a(arrayList, arrayList2, substring.substring(i2, indexOf2));
                i = indexOf2;
            } else {
                a(arrayList, arrayList2, substring.substring(i2));
                return new w((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
        }
    }
}

package com.google.a.b.a;

import com.google.a.r;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class u {

    /* renamed from: a  reason: collision with root package name */
    private static final u[] f3043a = {new f(), new c(), new j(), new b(), new af(), new e(), new ag(), new i(), new y(), new aa(), new v(), new x(), new n(), new ak(), new ae(), new ad(), new p(), new t(), new l(), new ai()};

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f3044b = Pattern.compile("\\d+");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f3045c = Pattern.compile("&");
    private static final Pattern d = Pattern.compile("=");
    private static final String e = "﻿";

    protected static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    private static String a(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, indexOf);
        boolean z = false;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (z || charAt != '\\') {
                sb.append(charAt);
                z = false;
            } else {
                z = true;
            }
            indexOf++;
        }
        return sb.toString();
    }

    private static void a(CharSequence charSequence, Map<String, String> map) {
        String[] split = d.split(charSequence, 2);
        if (split.length == 2) {
            try {
                map.put(split[0], d(split[1]));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    private static void a(String str, StringBuilder sb) {
        if (str != null) {
            sb.append(10);
            sb.append(str);
        }
    }

    private static void a(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String append : strArr) {
                sb.append(10);
                sb.append(append);
            }
        }
    }

    protected static boolean a(CharSequence charSequence, int i) {
        return charSequence != null && i > 0 && i == charSequence.length() && f3044b.matcher(charSequence).matches();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0006, code lost:
        r4 = r4 + r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static boolean a(java.lang.CharSequence r2, int r3, int r4) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x001f
            if (r4 > 0) goto L_0x0006
            return r0
        L_0x0006:
            int r4 = r4 + r3
            int r1 = r2.length()
            if (r1 < r4) goto L_0x001f
            java.util.regex.Pattern r1 = f3044b
            java.lang.CharSequence r2 = r2.subSequence(r3, r4)
            java.util.regex.Matcher r2 = r1.matcher(r2)
            boolean r2 = r2.matches()
            if (r2 == 0) goto L_0x001f
            r2 = 1
            return r2
        L_0x001f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.u.a(java.lang.CharSequence, int, int):boolean");
    }

    static String[] a(String str, String str2, char c2, boolean z) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i = 0;
        while (i < length) {
            int indexOf = str2.indexOf(str, i);
            if (indexOf < 0) {
                break;
            }
            int length2 = indexOf + str.length();
            boolean z2 = true;
            ArrayList arrayList2 = arrayList;
            int i2 = length2;
            while (z2) {
                int indexOf2 = str2.indexOf(c2, i2);
                if (indexOf2 < 0) {
                    i2 = str2.length();
                } else {
                    int i3 = indexOf2 - 1;
                    int i4 = 0;
                    while (i3 >= 0 && str2.charAt(i3) == '\\') {
                        i4++;
                        i3--;
                    }
                    if (i4 % 2 != 0) {
                        i2 = indexOf2 + 1;
                    } else {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList(3);
                        }
                        String a2 = a(str2.substring(length2, indexOf2));
                        if (z) {
                            a2 = a2.trim();
                        }
                        if (!a2.isEmpty()) {
                            arrayList2.add(a2);
                        }
                        i2 = indexOf2 + 1;
                    }
                }
                z2 = false;
            }
            i = i2;
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static int b(CharSequence charSequence, int i) {
        int i2 = i - 1;
        int i3 = 0;
        while (i2 >= 0 && charSequence.charAt(i2) == '\\') {
            i3++;
            i2--;
        }
        return i3;
    }

    protected static String b(r rVar) {
        String str = rVar.f3353a;
        return str.startsWith(e) ? str.substring(1) : str;
    }

    static String b(String str, String str2, char c2, boolean z) {
        String[] a2 = a(str, str2, c2, z);
        if (a2 == null) {
            return null;
        }
        return a2[0];
    }

    protected static String[] b(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    private static q c(r rVar) {
        for (u a2 : f3043a) {
            q a3 = a2.a(rVar);
            if (a3 != null) {
                return a3;
            }
        }
        return new ab(rVar.f3353a);
    }

    static Map<String, String> c(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return null;
        }
        HashMap hashMap = new HashMap(3);
        for (String split : f3045c.split(str.substring(indexOf + 1))) {
            String[] split2 = d.split(split, 2);
            if (split2.length == 2) {
                try {
                    hashMap.put(split2[0], d(split2[1]));
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return hashMap;
    }

    static String d(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public abstract q a(r rVar);
}

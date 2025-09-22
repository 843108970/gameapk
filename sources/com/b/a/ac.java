package com.b.a;

import com.b.a.a.c;
import com.b.b.f;
import com.umeng.commonsdk.proguard.bg;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.slf4j.Marker;

public final class ac {
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    final String f749a;

    /* renamed from: b  reason: collision with root package name */
    final String f750b;

    /* renamed from: c  reason: collision with root package name */
    final int f751c;
    private final String e;
    private final String f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    ac(ad adVar) {
        this.f749a = adVar.f752a;
        this.e = a(adVar.f753b, false);
        this.f = a(adVar.f754c, false);
        this.f750b = adVar.d;
        this.f751c = adVar.a();
        this.g = a(adVar.f, false);
        String str = null;
        this.h = adVar.g != null ? a(adVar.g, true) : null;
        this.i = adVar.h != null ? a(adVar.h, false) : str;
        this.j = adVar.toString();
    }

    static int a(char c2) {
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

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String str3 = str;
        int i4 = i3;
        String str4 = str2;
        int i5 = i2;
        while (i5 < i4) {
            int codePointAt = str3.codePointAt(i5);
            int i6 = 43;
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str4.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !a(str3, i5, i4)))) || (codePointAt == 43 && z3)))) {
                f fVar = new f();
                fVar.a(str3, i2, i5);
                f fVar2 = null;
                while (i5 < i4) {
                    int codePointAt2 = str3.codePointAt(i5);
                    if (!z || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                        if (codePointAt2 != i6 || !z3) {
                            if (codePointAt2 >= 32 && codePointAt2 != 127 && (codePointAt2 < 128 || !z4)) {
                                if (str4.indexOf(codePointAt2) == -1 && (codePointAt2 != 37 || (z && (!z2 || a(str3, i5, i4))))) {
                                    fVar.a(codePointAt2);
                                    i5 += Character.charCount(codePointAt2);
                                    i6 = 43;
                                }
                            }
                            if (fVar2 == null) {
                                fVar2 = new f();
                            }
                            fVar2.a(codePointAt2);
                            while (!fVar2.d()) {
                                byte e2 = fVar2.e() & 255;
                                fVar.h(37);
                                fVar.h((int) d[(e2 >> 4) & 15]);
                                fVar.h((int) d[e2 & bg.m]);
                            }
                            i5 += Character.charCount(codePointAt2);
                            i6 = 43;
                        } else {
                            fVar.b(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                        }
                    }
                    i5 += Character.charCount(codePointAt2);
                    i6 = 43;
                }
                return fVar.l();
            }
            i5 += Character.charCount(codePointAt);
        }
        int i7 = i2;
        return str.substring(i2, i3);
    }

    static String a(String str, int i2, int i3, boolean z) {
        int i4;
        int i5 = i2;
        while (i5 < i3) {
            char charAt = str.charAt(i5);
            if (charAt == '%' || (charAt == '+' && z)) {
                f fVar = new f();
                fVar.a(str, i2, i5);
                while (i5 < i3) {
                    int codePointAt = str.codePointAt(i5);
                    if (codePointAt == 37 && (i4 = i5 + 2) < i3) {
                        int a2 = a(str.charAt(i5 + 1));
                        int a3 = a(str.charAt(i4));
                        if (!(a2 == -1 || a3 == -1)) {
                            fVar.h((a2 << 4) + a3);
                            i5 = i4;
                            i5 += Character.charCount(codePointAt);
                        }
                    } else if (codePointAt == 43 && z) {
                        fVar.h(32);
                        i5 += Character.charCount(codePointAt);
                    }
                    fVar.a(codePointAt);
                    i5 += Character.charCount(codePointAt);
                }
                return fVar.l();
            }
            i5++;
        }
        return str.substring(i2, i3);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    private static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private static List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(list.get(i2));
        }
    }

    private static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && a(str.charAt(i2 + 1)) != -1 && a(str.charAt(i4)) != -1;
    }

    static List<String> b(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static ac e(String str) {
        ad adVar = new ad();
        if (adVar.a((ac) null, str) == ae.f755a) {
            return adVar.b();
        }
        return null;
    }

    public final URI a() {
        ad adVar = new ad();
        adVar.f752a = this.f749a;
        adVar.f753b = d();
        adVar.f754c = e();
        adVar.d = this.f750b;
        adVar.e = this.f751c != a(this.f749a) ? this.f751c : -1;
        adVar.f.clear();
        adVar.f.addAll(i());
        adVar.b(j());
        adVar.h = this.i == null ? null : this.j.substring(this.j.indexOf(35) + 1);
        int size = adVar.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            adVar.f.set(i2, a(adVar.f.get(i2), "[]", true, true, false, true));
        }
        if (adVar.g != null) {
            int size2 = adVar.g.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String str = adVar.g.get(i3);
                if (str != null) {
                    adVar.g.set(i3, a(str, "\\^`{|}", true, true, true, true));
                }
            }
        }
        if (adVar.h != null) {
            adVar.h = a(adVar.h, " \"#<>\\^`{|}", true, true, false, false);
        }
        String adVar2 = adVar.toString();
        try {
            return new URI(adVar2);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(adVar2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final String b() {
        return this.f749a;
    }

    public final ac c(String str) {
        ad d2 = d(str);
        if (d2 != null) {
            return d2.b();
        }
        return null;
    }

    public final boolean c() {
        return this.f749a.equals("https");
    }

    public final ad d(String str) {
        ad adVar = new ad();
        if (adVar.a(this, str) == ae.f755a) {
            return adVar;
        }
        return null;
    }

    public final String d() {
        if (this.e.isEmpty()) {
            return "";
        }
        int length = this.f749a.length() + 3;
        return this.j.substring(length, c.a(this.j, length, this.j.length(), ":@"));
    }

    public final String e() {
        if (this.f.isEmpty()) {
            return "";
        }
        int indexOf = this.j.indexOf(64);
        return this.j.substring(this.j.indexOf(58, this.f749a.length() + 3) + 1, indexOf);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ac) && ((ac) obj).j.equals(this.j);
    }

    public final String f() {
        return this.f750b;
    }

    public final int g() {
        return this.f751c;
    }

    public final String h() {
        int indexOf = this.j.indexOf(47, this.f749a.length() + 3);
        return this.j.substring(indexOf, c.a(this.j, indexOf, this.j.length(), "?#"));
    }

    public final int hashCode() {
        return this.j.hashCode();
    }

    public final List<String> i() {
        int indexOf = this.j.indexOf(47, this.f749a.length() + 3);
        int a2 = c.a(this.j, indexOf, this.j.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = c.a(this.j, i2, a2, (char) IOUtils.DIR_SEPARATOR_UNIX);
            arrayList.add(this.j.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public final String j() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        return this.j.substring(indexOf, c.a(this.j, indexOf + 1, this.j.length(), '#'));
    }

    public final String k() {
        if (this.h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.h);
        return sb.toString();
    }

    public final String toString() {
        return this.j;
    }
}

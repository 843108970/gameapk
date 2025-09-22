package com.google.a.b.a;

import com.google.a.r;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class af extends u {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f3010a = Pattern.compile("BEGIN:VCARD", 2);

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f3011b = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f3012c = Pattern.compile("\r\n[ \t]");
    private static final Pattern d = Pattern.compile("\\\\[nN]");
    private static final Pattern e = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern f = Pattern.compile("=");
    private static final Pattern g = Pattern.compile(";");
    private static final Pattern h = Pattern.compile("(?<!\\\\);+");
    private static final Pattern i = Pattern.compile(",");
    private static final Pattern j = Pattern.compile("[;,]");

    private static String a(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < length) {
            char charAt2 = charSequence.charAt(i2);
            if (!(charAt2 == 10 || charAt2 == 13)) {
                if (charAt2 != '=') {
                    a(byteArrayOutputStream, str, sb);
                    sb.append(charAt2);
                } else if (!(i2 >= length - 2 || (charAt = charSequence.charAt(i2 + 1)) == 13 || charAt == 10)) {
                    i2 += 2;
                    char charAt3 = charSequence.charAt(i2);
                    int a2 = a(charAt);
                    int a3 = a(charAt3);
                    if (a2 >= 0 && a3 >= 0) {
                        byteArrayOutputStream.write((a2 << 4) + a3);
                    }
                }
            }
            i2++;
        }
        a(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static String a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0170  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<java.util.List<java.lang.String>> a(java.lang.CharSequence r17, java.lang.String r18, boolean r19, boolean r20) {
        /*
            r0 = r18
            int r1 = r18.length()
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0009:
            if (r4 >= r1) goto L_0x017e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "(?:^|\n)"
            r6.<init>(r7)
            r7 = r17
            r6.append(r7)
            java.lang.String r8 = "(?:;([^:]*))?:"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r8 = 2
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6, r8)
            java.util.regex.Matcher r6 = r6.matcher(r0)
            if (r4 <= 0) goto L_0x002d
            int r4 = r4 + -1
        L_0x002d:
            boolean r4 = r6.find(r4)
            if (r4 == 0) goto L_0x017e
            int r4 = r6.end(r3)
            r9 = 1
            java.lang.String r6 = r6.group(r9)
            if (r6 == 0) goto L_0x0092
            java.util.regex.Pattern r10 = g
            java.lang.String[] r6 = r10.split(r6)
            int r10 = r6.length
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x004a:
            if (r11 >= r10) goto L_0x0090
            r2 = r6[r11]
            if (r12 != 0) goto L_0x0055
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>(r9)
        L_0x0055:
            r12.add(r2)
            java.util.regex.Pattern r3 = f
            java.lang.String[] r2 = r3.split(r2, r8)
            int r3 = r2.length
            if (r3 <= r9) goto L_0x008b
            r3 = 0
            r8 = r2[r3]
            r2 = r2[r9]
            java.lang.String r3 = "ENCODING"
            boolean r3 = r3.equalsIgnoreCase(r8)
            if (r3 == 0) goto L_0x0078
            java.lang.String r3 = "QUOTED-PRINTABLE"
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 == 0) goto L_0x0078
            r13 = 1
            goto L_0x008b
        L_0x0078:
            java.lang.String r3 = "CHARSET"
            boolean r3 = r3.equalsIgnoreCase(r8)
            if (r3 == 0) goto L_0x0082
            r14 = r2
            goto L_0x008b
        L_0x0082:
            java.lang.String r3 = "VALUE"
            boolean r3 = r3.equalsIgnoreCase(r8)
            if (r3 == 0) goto L_0x008b
            r15 = r2
        L_0x008b:
            int r11 = r11 + 1
            r3 = 0
            r8 = 2
            goto L_0x004a
        L_0x0090:
            r2 = r15
            goto L_0x0096
        L_0x0092:
            r2 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x0096:
            r3 = r4
        L_0x0097:
            r6 = 10
            int r3 = r0.indexOf(r6, r3)
            if (r3 < 0) goto L_0x00da
            int r6 = r18.length()
            int r6 = r6 - r9
            if (r3 >= r6) goto L_0x00bb
            int r6 = r3 + 1
            char r8 = r0.charAt(r6)
            r10 = 32
            if (r8 == r10) goto L_0x00b8
            char r6 = r0.charAt(r6)
            r8 = 9
            if (r6 != r8) goto L_0x00bb
        L_0x00b8:
            int r3 = r3 + 2
            goto L_0x0097
        L_0x00bb:
            if (r13 == 0) goto L_0x00da
            r6 = 61
            if (r3 <= 0) goto L_0x00cc
            int r8 = r3 + -1
            char r8 = r0.charAt(r8)
            if (r8 == r6) goto L_0x00ca
            goto L_0x00cc
        L_0x00ca:
            r8 = 2
            goto L_0x00d7
        L_0x00cc:
            r8 = 2
            if (r3 < r8) goto L_0x00da
            int r10 = r3 + -2
            char r10 = r0.charAt(r10)
            if (r10 != r6) goto L_0x00da
        L_0x00d7:
            int r3 = r3 + 1
            goto L_0x0097
        L_0x00da:
            if (r3 >= 0) goto L_0x00e0
            r4 = r1
        L_0x00dd:
            r3 = 0
            goto L_0x0009
        L_0x00e0:
            if (r3 <= r4) goto L_0x0178
            if (r5 != 0) goto L_0x00e9
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r9)
        L_0x00e9:
            if (r3 <= 0) goto L_0x00f7
            int r6 = r3 + -1
            char r6 = r0.charAt(r6)
            r8 = 13
            if (r6 != r8) goto L_0x00f7
            int r3 = r3 + -1
        L_0x00f7:
            java.lang.String r4 = r0.substring(r4, r3)
            if (r19 == 0) goto L_0x0101
            java.lang.String r4 = r4.trim()
        L_0x0101:
            if (r13 == 0) goto L_0x011a
            java.lang.String r4 = a(r4, r14)
            if (r20 == 0) goto L_0x0150
            java.util.regex.Pattern r8 = h
            java.util.regex.Matcher r4 = r8.matcher(r4)
            java.lang.String r8 = "\n"
            java.lang.String r4 = r4.replaceAll(r8)
            java.lang.String r4 = r4.trim()
            goto L_0x0150
        L_0x011a:
            if (r20 == 0) goto L_0x012c
            java.util.regex.Pattern r8 = h
            java.util.regex.Matcher r4 = r8.matcher(r4)
            java.lang.String r8 = "\n"
            java.lang.String r4 = r4.replaceAll(r8)
            java.lang.String r4 = r4.trim()
        L_0x012c:
            java.util.regex.Pattern r8 = f3012c
            java.util.regex.Matcher r4 = r8.matcher(r4)
            java.lang.String r8 = ""
            java.lang.String r4 = r4.replaceAll(r8)
            java.util.regex.Pattern r8 = d
            java.util.regex.Matcher r4 = r8.matcher(r4)
            java.lang.String r8 = "\n"
            java.lang.String r4 = r4.replaceAll(r8)
            java.util.regex.Pattern r8 = e
            java.util.regex.Matcher r4 = r8.matcher(r4)
            java.lang.String r8 = "$1"
            java.lang.String r4 = r4.replaceAll(r8)
        L_0x0150:
            java.lang.String r8 = "uri"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0161
            java.net.URI r2 = java.net.URI.create(r4)     // Catch:{ IllegalArgumentException -> 0x0161 }
            java.lang.String r2 = r2.getSchemeSpecificPart()     // Catch:{ IllegalArgumentException -> 0x0161 }
            goto L_0x0162
        L_0x0161:
            r2 = r4
        L_0x0162:
            if (r12 != 0) goto L_0x0170
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r9)
            r4.add(r2)
            r5.add(r4)
            goto L_0x0178
        L_0x0170:
            r4 = 0
            r12.add(r4, r2)
            r5.add(r12)
            goto L_0x0179
        L_0x0178:
            r4 = 0
        L_0x0179:
            int r2 = r3 + 1
            r4 = r2
            goto L_0x00dd
        L_0x017e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.af.a(java.lang.CharSequence, java.lang.String, boolean, boolean):java.util.List");
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    private static void a(Iterable<List<String>> iterable) {
        int indexOf;
        if (iterable != null) {
            for (List next : iterable) {
                String str = (String) next.get(0);
                String[] strArr = new String[5];
                int i2 = 0;
                int i3 = 0;
                while (i2 < 4 && (indexOf = str.indexOf(59, i3)) >= 0) {
                    strArr[i2] = str.substring(i3, indexOf);
                    i2++;
                    i3 = indexOf + 1;
                }
                strArr[i2] = str.substring(i3);
                StringBuilder sb = new StringBuilder(100);
                a(strArr, 3, sb);
                a(strArr, 1, sb);
                a(strArr, 2, sb);
                a(strArr, 0, sb);
                a(strArr, 4, sb);
                next.set(0, sb.toString().trim());
            }
        }
    }

    private static void a(String[] strArr, int i2, StringBuilder sb) {
        if (strArr[i2] != null && !strArr[i2].isEmpty()) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(strArr[i2]);
        }
    }

    private static boolean a(CharSequence charSequence) {
        return charSequence == null || f3011b.matcher(charSequence).matches();
    }

    private static String[] a(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = (String) list.get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    static List<String> b(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> a2 = a(charSequence, str, z, z2);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        return a2.get(0);
    }

    private static String[] b(Collection<List<String>> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List next : collection) {
            String str2 = (String) next.get(0);
            if (str2 != null && !str2.isEmpty()) {
                int i2 = 1;
                while (true) {
                    if (i2 >= next.size()) {
                        str = null;
                        break;
                    }
                    String str3 = (String) next.get(i2);
                    int indexOf = str3.indexOf(61);
                    if (indexOf < 0) {
                        str = str3;
                        break;
                    } else if ("TYPE".equalsIgnoreCase(str3.substring(0, indexOf))) {
                        str = str3.substring(indexOf + 1);
                        break;
                    } else {
                        i2++;
                    }
                }
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static d c(r rVar) {
        int indexOf;
        String b2 = b(rVar);
        Matcher matcher = f3010a.matcher(b2);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> a2 = a("FN", b2, true, false);
        if (a2 == null && (a2 = a("N", b2, true, false)) != null) {
            for (List list : a2) {
                String str = (String) list.get(0);
                String[] strArr = new String[5];
                int i2 = 0;
                int i3 = 0;
                while (i2 < 4 && (indexOf = str.indexOf(59, i3)) >= 0) {
                    strArr[i2] = str.substring(i3, indexOf);
                    i2++;
                    i3 = indexOf + 1;
                }
                strArr[i2] = str.substring(i3);
                StringBuilder sb = new StringBuilder(100);
                a(strArr, 3, sb);
                a(strArr, 1, sb);
                a(strArr, 2, sb);
                a(strArr, 0, sb);
                a(strArr, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
        List<String> b3 = b("NICKNAME", b2, true, false);
        String[] split = b3 == null ? null : i.split(b3.get(0));
        List<List<String>> a3 = a("TEL", b2, true, false);
        List<List<String>> a4 = a("EMAIL", b2, true, false);
        List<String> b4 = b("NOTE", b2, false, false);
        List<List<String>> a5 = a("ADR", b2, true, true);
        List<String> b5 = b("ORG", b2, true, true);
        List<String> b6 = b("BDAY", b2, true, false);
        if (b6 != null) {
            CharSequence charSequence = b6.get(0);
            if (!(charSequence == null || f3011b.matcher(charSequence).matches())) {
                b6 = null;
            }
        }
        List<String> b7 = b("TITLE", b2, true, false);
        List<List<String>> a6 = a("URL", b2, true, false);
        List<String> b8 = b("IMPP", b2, true, false);
        List<String> b9 = b("GEO", b2, true, false);
        String[] split2 = b9 == null ? null : j.split(b9.get(0));
        return new d(a((Collection<List<String>>) a2), split, (String) null, a((Collection<List<String>>) a3), b(a3), a((Collection<List<String>>) a4), b(a4), a(b8), a(b4), a((Collection<List<String>>) a5), b(a5), a(b5), a(b6), a(b7), a((Collection<List<String>>) a6), (split2 == null || split2.length == 2) ? split2 : null);
    }

    public final /* synthetic */ q a(r rVar) {
        int indexOf;
        String b2 = b(rVar);
        Matcher matcher = f3010a.matcher(b2);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> a2 = a("FN", b2, true, false);
        if (a2 == null && (a2 = a("N", b2, true, false)) != null) {
            for (List list : a2) {
                String str = (String) list.get(0);
                String[] strArr = new String[5];
                int i2 = 0;
                int i3 = 0;
                while (i2 < 4 && (indexOf = str.indexOf(59, i3)) >= 0) {
                    strArr[i2] = str.substring(i3, indexOf);
                    i2++;
                    i3 = indexOf + 1;
                }
                strArr[i2] = str.substring(i3);
                StringBuilder sb = new StringBuilder(100);
                a(strArr, 3, sb);
                a(strArr, 1, sb);
                a(strArr, 2, sb);
                a(strArr, 0, sb);
                a(strArr, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
        List<String> b3 = b("NICKNAME", b2, true, false);
        String[] split = b3 == null ? null : i.split(b3.get(0));
        List<List<String>> a3 = a("TEL", b2, true, false);
        List<List<String>> a4 = a("EMAIL", b2, true, false);
        List<String> b4 = b("NOTE", b2, false, false);
        List<List<String>> a5 = a("ADR", b2, true, true);
        List<String> b5 = b("ORG", b2, true, true);
        List<String> b6 = b("BDAY", b2, true, false);
        if (b6 != null) {
            CharSequence charSequence = b6.get(0);
            if (!(charSequence == null || f3011b.matcher(charSequence).matches())) {
                b6 = null;
            }
        }
        List<String> b7 = b("TITLE", b2, true, false);
        List<List<String>> a6 = a("URL", b2, true, false);
        List<String> b8 = b("IMPP", b2, true, false);
        List<String> b9 = b("GEO", b2, true, false);
        String[] split2 = b9 == null ? null : j.split(b9.get(0));
        return new d(a((Collection<List<String>>) a2), split, (String) null, a((Collection<List<String>>) a3), b(a3), a((Collection<List<String>>) a4), b(a4), a(b8), a(b4), a((Collection<List<String>>) a5), b(a5), a(b5), a(b6), a(b7), a((Collection<List<String>>) a6), (split2 == null || split2.length == 2) ? split2 : null);
    }
}

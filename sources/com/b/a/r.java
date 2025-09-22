package com.b.a;

import com.b.a.a.c.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f828a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f829b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f830c = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String e;
    private final String f;
    private final long g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    private r(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.e = str;
        this.f = str2;
        this.g = j2;
        this.h = str3;
        this.i = str4;
        this.j = z;
        this.k = z2;
        this.m = z3;
        this.l = z4;
    }

    private static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static long a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02b9, code lost:
        if (com.b.a.a.c.c(r0) == false) goto L_0x02bd;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.b.a.r a(long r33, com.b.a.ac r35, java.lang.String r36) {
        /*
            r2 = r35
            r3 = r36
            int r4 = r36.length()
            r5 = 59
            r6 = 0
            int r7 = com.b.a.a.c.a((java.lang.String) r3, (int) r6, (int) r4, (char) r5)
            r8 = 61
            int r9 = com.b.a.a.c.a((java.lang.String) r3, (int) r6, (int) r7, (char) r8)
            r10 = 0
            if (r9 != r7) goto L_0x0019
            return r10
        L_0x0019:
            java.lang.String r12 = com.b.a.a.c.c(r3, r6, r9)
            boolean r11 = r12.isEmpty()
            if (r11 != 0) goto L_0x02f8
            int r11 = com.b.a.a.c.b(r12)
            r13 = -1
            if (r11 == r13) goto L_0x002c
            goto L_0x02f8
        L_0x002c:
            r11 = 1
            int r9 = r9 + r11
            java.lang.String r9 = com.b.a.a.c.c(r3, r9, r7)
            int r14 = com.b.a.a.c.b(r9)
            if (r14 == r13) goto L_0x0039
            return r10
        L_0x0039:
            int r7 = r7 + r11
            r16 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r22 = r10
            r20 = r16
            r18 = -1
            r23 = 0
            r24 = 0
            r25 = 1
            r26 = 0
        L_0x004d:
            if (r7 >= r4) goto L_0x0258
            int r14 = com.b.a.a.c.a((java.lang.String) r3, (int) r7, (int) r4, (char) r5)
            int r15 = com.b.a.a.c.a((java.lang.String) r3, (int) r7, (int) r14, (char) r8)
            java.lang.String r7 = com.b.a.a.c.c(r3, r7, r15)
            if (r15 >= r14) goto L_0x0064
            int r15 = r15 + 1
            java.lang.String r15 = com.b.a.a.c.c(r3, r15, r14)
            goto L_0x0066
        L_0x0064:
            java.lang.String r15 = ""
        L_0x0066:
            java.lang.String r8 = "expires"
            boolean r8 = r7.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x01e1
            int r7 = r15.length()     // Catch:{ IllegalArgumentException -> 0x01db }
            int r8 = a(r15, r6, r7, r6)     // Catch:{ IllegalArgumentException -> 0x01db }
            java.util.regex.Pattern r5 = d     // Catch:{ IllegalArgumentException -> 0x01db }
            java.util.regex.Matcher r5 = r5.matcher(r15)     // Catch:{ IllegalArgumentException -> 0x01db }
            r6 = -1
            r27 = -1
            r28 = -1
            r29 = -1
            r30 = -1
        L_0x0085:
            if (r8 >= r7) goto L_0x013f
            int r11 = r8 + 1
            r3 = 1
            int r11 = a(r15, r11, r7, r3)     // Catch:{ IllegalArgumentException -> 0x01db }
            r5.region(r8, r11)     // Catch:{ IllegalArgumentException -> 0x01db }
            r3 = -1
            if (r13 != r3) goto L_0x00c4
            java.util.regex.Pattern r3 = d     // Catch:{ IllegalArgumentException -> 0x01db }
            java.util.regex.Matcher r3 = r5.usePattern(r3)     // Catch:{ IllegalArgumentException -> 0x01db }
            boolean r3 = r3.matches()     // Catch:{ IllegalArgumentException -> 0x01db }
            if (r3 == 0) goto L_0x00c4
            r3 = 1
            java.lang.String r8 = r5.group(r3)     // Catch:{ IllegalArgumentException -> 0x01db }
            int r3 = java.lang.Integer.parseInt(r8)     // Catch:{ IllegalArgumentException -> 0x01db }
            r8 = 2
            java.lang.String r8 = r5.group(r8)     // Catch:{ IllegalArgumentException -> 0x01db }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ IllegalArgumentException -> 0x01db }
            r13 = 3
            java.lang.String r13 = r5.group(r13)     // Catch:{ IllegalArgumentException -> 0x01db }
            int r13 = java.lang.Integer.parseInt(r13)     // Catch:{ IllegalArgumentException -> 0x01db }
            r31 = r4
            r29 = r8
            r30 = r13
            r13 = r3
            goto L_0x0132
        L_0x00c4:
            r3 = r28
            r8 = -1
            if (r3 != r8) goto L_0x00e3
            java.util.regex.Pattern r8 = f830c     // Catch:{ IllegalArgumentException -> 0x01db }
            java.util.regex.Matcher r8 = r5.usePattern(r8)     // Catch:{ IllegalArgumentException -> 0x01db }
            boolean r8 = r8.matches()     // Catch:{ IllegalArgumentException -> 0x01db }
            if (r8 == 0) goto L_0x00e3
            r8 = 1
            java.lang.String r3 = r5.group(r8)     // Catch:{ IllegalArgumentException -> 0x01db }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ IllegalArgumentException -> 0x01db }
            r28 = r3
            r31 = r4
            goto L_0x0132
        L_0x00e3:
            r31 = r4
            r8 = r27
            r4 = -1
            if (r8 != r4) goto L_0x0113
            java.util.regex.Pattern r4 = f829b     // Catch:{ IllegalArgumentException -> 0x01dd }
            java.util.regex.Matcher r4 = r5.usePattern(r4)     // Catch:{ IllegalArgumentException -> 0x01dd }
            boolean r4 = r4.matches()     // Catch:{ IllegalArgumentException -> 0x01dd }
            if (r4 == 0) goto L_0x0112
            r4 = 1
            java.lang.String r8 = r5.group(r4)     // Catch:{ IllegalArgumentException -> 0x01dd }
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ IllegalArgumentException -> 0x01dd }
            java.lang.String r4 = r8.toLowerCase(r4)     // Catch:{ IllegalArgumentException -> 0x01dd }
            java.util.regex.Pattern r8 = f829b     // Catch:{ IllegalArgumentException -> 0x01dd }
            java.lang.String r8 = r8.pattern()     // Catch:{ IllegalArgumentException -> 0x01dd }
            int r4 = r8.indexOf(r4)     // Catch:{ IllegalArgumentException -> 0x01dd }
            int r4 = r4 / 4
            r28 = r3
            r27 = r4
            goto L_0x0132
        L_0x0112:
            r4 = -1
        L_0x0113:
            if (r6 != r4) goto L_0x012e
            java.util.regex.Pattern r4 = f828a     // Catch:{ IllegalArgumentException -> 0x01dd }
            java.util.regex.Matcher r4 = r5.usePattern(r4)     // Catch:{ IllegalArgumentException -> 0x01dd }
            boolean r4 = r4.matches()     // Catch:{ IllegalArgumentException -> 0x01dd }
            if (r4 == 0) goto L_0x012e
            r4 = 1
            java.lang.String r6 = r5.group(r4)     // Catch:{ IllegalArgumentException -> 0x01dd }
            int r4 = java.lang.Integer.parseInt(r6)     // Catch:{ IllegalArgumentException -> 0x01dd }
            r28 = r3
            r6 = r4
            goto L_0x0130
        L_0x012e:
            r28 = r3
        L_0x0130:
            r27 = r8
        L_0x0132:
            int r11 = r11 + 1
            r3 = 0
            int r8 = a(r15, r11, r7, r3)     // Catch:{ IllegalArgumentException -> 0x01dd }
            r4 = r31
            r3 = r36
            goto L_0x0085
        L_0x013f:
            r31 = r4
            r8 = r27
            r3 = r28
            r4 = 70
            if (r6 < r4) goto L_0x014f
            r4 = 99
            if (r6 > r4) goto L_0x014f
            int r6 = r6 + 1900
        L_0x014f:
            if (r6 < 0) goto L_0x0157
            r4 = 69
            if (r6 > r4) goto L_0x0157
            int r6 = r6 + 2000
        L_0x0157:
            r4 = 1601(0x641, float:2.243E-42)
            if (r6 >= r4) goto L_0x0161
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01dd }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x01dd }
            throw r3     // Catch:{ IllegalArgumentException -> 0x01dd }
        L_0x0161:
            r4 = -1
            if (r8 != r4) goto L_0x016a
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01dd }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x01dd }
            throw r3     // Catch:{ IllegalArgumentException -> 0x01dd }
        L_0x016a:
            if (r3 <= 0) goto L_0x01d3
            r5 = 31
            if (r3 <= r5) goto L_0x0171
            goto L_0x01d3
        L_0x0171:
            if (r13 < 0) goto L_0x01cb
            r5 = 23
            if (r13 <= r5) goto L_0x0178
            goto L_0x01cb
        L_0x0178:
            r5 = r29
            if (r5 < 0) goto L_0x01c3
            r11 = 59
            if (r5 <= r11) goto L_0x0181
            goto L_0x01c5
        L_0x0181:
            r7 = r30
            if (r7 < 0) goto L_0x01bd
            if (r7 <= r11) goto L_0x0188
            goto L_0x01bd
        L_0x0188:
            java.util.GregorianCalendar r15 = new java.util.GregorianCalendar     // Catch:{ IllegalArgumentException -> 0x0249 }
            java.util.TimeZone r4 = com.b.a.a.c.f     // Catch:{ IllegalArgumentException -> 0x0249 }
            r15.<init>(r4)     // Catch:{ IllegalArgumentException -> 0x0249 }
            r4 = 0
            r15.setLenient(r4)     // Catch:{ IllegalArgumentException -> 0x0249 }
            r4 = 1
            r15.set(r4, r6)     // Catch:{ IllegalArgumentException -> 0x0249 }
            int r4 = r8 + -1
            r6 = 2
            r15.set(r6, r4)     // Catch:{ IllegalArgumentException -> 0x0249 }
            r4 = 5
            r15.set(r4, r3)     // Catch:{ IllegalArgumentException -> 0x0249 }
            r3 = 11
            r15.set(r3, r13)     // Catch:{ IllegalArgumentException -> 0x0249 }
            r3 = 12
            r15.set(r3, r5)     // Catch:{ IllegalArgumentException -> 0x0249 }
            r3 = 13
            r15.set(r3, r7)     // Catch:{ IllegalArgumentException -> 0x0249 }
            r3 = 14
            r4 = 0
            r15.set(r3, r4)     // Catch:{ IllegalArgumentException -> 0x0249 }
            long r3 = r15.getTimeInMillis()     // Catch:{ IllegalArgumentException -> 0x0249 }
            r20 = r3
            goto L_0x01f3
        L_0x01bd:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0249 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0249 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0249 }
        L_0x01c3:
            r11 = 59
        L_0x01c5:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0249 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0249 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0249 }
        L_0x01cb:
            r11 = 59
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0249 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0249 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0249 }
        L_0x01d3:
            r11 = 59
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0249 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0249 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0249 }
        L_0x01db:
            r31 = r4
        L_0x01dd:
            r11 = 59
            goto L_0x0249
        L_0x01e1:
            r31 = r4
            r11 = 59
            java.lang.String r3 = "max-age"
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x01f6
            long r3 = a(r15)     // Catch:{  }
            r18 = r3
        L_0x01f3:
            r26 = 1
            goto L_0x0249
        L_0x01f6:
            java.lang.String r3 = "domain"
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0229
            java.lang.String r3 = "."
            boolean r3 = r15.endsWith(r3)     // Catch:{ IllegalArgumentException -> 0x0249 }
            if (r3 == 0) goto L_0x020c
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0249 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0249 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0249 }
        L_0x020c:
            java.lang.String r3 = "."
            boolean r3 = r15.startsWith(r3)     // Catch:{ IllegalArgumentException -> 0x0249 }
            if (r3 == 0) goto L_0x0219
            r3 = 1
            java.lang.String r15 = r15.substring(r3)     // Catch:{ IllegalArgumentException -> 0x0249 }
        L_0x0219:
            java.lang.String r3 = com.b.a.a.c.a((java.lang.String) r15)     // Catch:{ IllegalArgumentException -> 0x0249 }
            if (r3 != 0) goto L_0x0225
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0249 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x0249 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0249 }
        L_0x0225:
            r10 = r3
            r25 = 0
            goto L_0x0249
        L_0x0229:
            java.lang.String r3 = "path"
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0234
            r22 = r15
            goto L_0x0249
        L_0x0234:
            java.lang.String r3 = "secure"
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x023f
            r23 = 1
            goto L_0x0249
        L_0x023f:
            java.lang.String r3 = "httponly"
            boolean r3 = r7.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0249
            r24 = 1
        L_0x0249:
            int r7 = r14 + 1
            r4 = r31
            r3 = r36
            r5 = 59
            r6 = 0
            r8 = 61
            r11 = 1
            r13 = -1
            goto L_0x004d
        L_0x0258:
            r3 = -9223372036854775808
            int r5 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0260
        L_0x025e:
            r14 = r3
            goto L_0x0289
        L_0x0260:
            r3 = -1
            int r5 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0287
            r3 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r5 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0274
            r3 = 1000(0x3e8, double:4.94E-321)
            long r18 = r18 * r3
            goto L_0x0279
        L_0x0274:
            r18 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0279:
            r3 = 0
            long r3 = r33 + r18
            int r5 = (r3 > r33 ? 1 : (r3 == r33 ? 0 : -1))
            if (r5 < 0) goto L_0x0284
            int r0 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x025e
        L_0x0284:
            r14 = r16
            goto L_0x0289
        L_0x0287:
            r14 = r20
        L_0x0289:
            if (r10 != 0) goto L_0x0292
            java.lang.String r0 = r2.f750b
            r16 = r0
        L_0x028f:
            r10 = r22
            goto L_0x02c4
        L_0x0292:
            java.lang.String r0 = r2.f750b
            boolean r1 = r0.equals(r10)
            if (r1 == 0) goto L_0x029c
            r3 = 1
            goto L_0x02bd
        L_0x029c:
            boolean r1 = r0.endsWith(r10)
            if (r1 == 0) goto L_0x02bc
            int r1 = r0.length()
            int r3 = r10.length()
            int r1 = r1 - r3
            r3 = 1
            int r1 = r1 - r3
            char r1 = r0.charAt(r1)
            r4 = 46
            if (r1 != r4) goto L_0x02bc
            boolean r0 = com.b.a.a.c.c(r0)
            if (r0 != 0) goto L_0x02bc
            goto L_0x02bd
        L_0x02bc:
            r3 = 0
        L_0x02bd:
            if (r3 != 0) goto L_0x02c1
            r0 = 0
            return r0
        L_0x02c1:
            r16 = r10
            goto L_0x028f
        L_0x02c4:
            if (r10 == 0) goto L_0x02d2
            java.lang.String r0 = "/"
            boolean r0 = r10.startsWith(r0)
            if (r0 != 0) goto L_0x02cf
            goto L_0x02d2
        L_0x02cf:
            r17 = r10
            goto L_0x02e8
        L_0x02d2:
            java.lang.String r0 = r35.h()
            r1 = 47
            int r1 = r0.lastIndexOf(r1)
            if (r1 == 0) goto L_0x02e4
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r1)
            goto L_0x02e6
        L_0x02e4:
            java.lang.String r0 = "/"
        L_0x02e6:
            r17 = r0
        L_0x02e8:
            com.b.a.r r0 = new com.b.a.r
            r11 = r0
            r13 = r9
            r18 = r23
            r19 = r24
            r20 = r25
            r21 = r26
            r11.<init>(r12, r13, r14, r16, r17, r18, r19, r20, r21)
            return r0
        L_0x02f8:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.r.a(long, com.b.a.ac, java.lang.String):com.b.a.r");
    }

    public static List<r> a(ac acVar, aa aaVar) {
        int a2 = aaVar.a();
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i2 = 0; i2 < a2; i2++) {
            if ("Set-Cookie".equalsIgnoreCase(aaVar.a(i2))) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(2);
                }
                arrayList2.add(aaVar.b(i2));
            }
        }
        List unmodifiableList = arrayList2 != null ? Collections.unmodifiableList(arrayList2) : Collections.emptyList();
        int size = unmodifiableList.size();
        for (int i3 = 0; i3 < size; i3++) {
            r a3 = a(System.currentTimeMillis(), acVar, (String) unmodifiableList.get(i3));
            if (a3 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a3);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public final String a() {
        return this.e;
    }

    public final String b() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return rVar.e.equals(this.e) && rVar.f.equals(this.f) && rVar.h.equals(this.h) && rVar.i.equals(this.i) && rVar.g == this.g && rVar.j == this.j && rVar.k == this.k && rVar.l == this.l && rVar.m == this.m;
    }

    public final int hashCode() {
        return ((((((((((((((((this.e.hashCode() + 527) * 31) + this.f.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + ((int) (this.g ^ (this.g >>> 32)))) * 31) + (this.j ^ true ? 1 : 0)) * 31) + (this.k ^ true ? 1 : 0)) * 31) + (this.l ^ true ? 1 : 0)) * 31) + (this.m ^ true ? 1 : 0);
    }

    public final String toString() {
        String a2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        sb.append('=');
        sb.append(this.f);
        if (this.l) {
            if (this.g == Long.MIN_VALUE) {
                a2 = "; max-age=0";
            } else {
                sb.append("; expires=");
                a2 = d.a(new Date(this.g));
            }
            sb.append(a2);
        }
        if (!this.m) {
            sb.append("; domain=");
            sb.append(this.h);
        }
        sb.append("; path=");
        sb.append(this.i);
        if (this.j) {
            sb.append("; secure");
        }
        if (this.k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}

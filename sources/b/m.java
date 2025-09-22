package b;

import b.a.c;
import b.a.d.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class m {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f329c = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern d = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern e = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern f = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    public final String f330a;

    /* renamed from: b  reason: collision with root package name */
    public final String f331b;
    private final long g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f332a;

        /* renamed from: b  reason: collision with root package name */
        String f333b;

        /* renamed from: c  reason: collision with root package name */
        long f334c = d.f76a;
        String d;
        String e = "/";
        boolean f;
        boolean g;
        boolean h;
        boolean i;

        private a a() {
            this.f = true;
            return this;
        }

        private a a(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > d.f76a) {
                j = 253402300799999L;
            }
            this.f334c = j;
            this.h = true;
            return this;
        }

        private a a(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("name is not trimmed");
            } else {
                this.f332a = str;
                return this;
            }
        }

        private a a(String str, boolean z) {
            if (str == null) {
                throw new NullPointerException("domain == null");
            }
            String a2 = c.a(str);
            if (a2 == null) {
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            this.d = a2;
            this.i = z;
            return this;
        }

        private a b() {
            this.g = true;
            return this;
        }

        private a b(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("value is not trimmed");
            } else {
                this.f333b = str;
                return this;
            }
        }

        private a c(String str) {
            return a(str, false);
        }

        private m c() {
            return new m(this);
        }

        private a d(String str) {
            return a(str, true);
        }

        private a e(String str) {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.e = str;
            return this;
        }
    }

    m(a aVar) {
        if (aVar.f332a == null) {
            throw new NullPointerException("builder.name == null");
        } else if (aVar.f333b == null) {
            throw new NullPointerException("builder.value == null");
        } else if (aVar.d == null) {
            throw new NullPointerException("builder.domain == null");
        } else {
            this.f330a = aVar.f332a;
            this.f331b = aVar.f333b;
            this.g = aVar.f334c;
            this.h = aVar.d;
            this.i = aVar.e;
            this.j = aVar.f;
            this.k = aVar.g;
            this.l = aVar.h;
            this.m = aVar.i;
        }
    }

    private m(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f330a = str;
        this.f331b = str2;
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

    private static long a(String str, int i2) {
        int a2 = a(str, 0, i2, false);
        Matcher matcher = f.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (a2 < i2) {
            int a3 = a(str, a2 + 1, i2, true);
            matcher.region(a2, a3);
            if (i3 == -1 && matcher.usePattern(f).matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                int parseInt2 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
                i7 = parseInt2;
                i3 = parseInt;
            } else if (i5 == -1 && matcher.usePattern(e).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(d).matches()) {
                i6 = d.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(f329c).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i2, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i6 == -1) {
            throw new IllegalArgumentException();
        } else if (i5 <= 0 || i5 > 31) {
            throw new IllegalArgumentException();
        } else if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(c.f);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i3);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0277, code lost:
        if (r2 > b.a.d.d.f76a) goto L_0x027f;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02ac A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02ad  */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static b.m a(long r31, b.v r33, java.lang.String r34) {
        /*
            r2 = r34
            int r3 = r34.length()
            r4 = 59
            r5 = 0
            int r6 = b.a.c.a((java.lang.String) r2, (int) r5, (int) r3, (char) r4)
            r7 = 61
            int r8 = b.a.c.a((java.lang.String) r2, (int) r5, (int) r6, (char) r7)
            r9 = 0
            if (r8 != r6) goto L_0x0017
            return r9
        L_0x0017:
            java.lang.String r11 = b.a.c.c(r2, r5, r8)
            boolean r10 = r11.isEmpty()
            if (r10 != 0) goto L_0x02e3
            int r10 = b.a.c.b(r11)
            r12 = -1
            if (r10 == r12) goto L_0x002a
            goto L_0x02e3
        L_0x002a:
            r10 = 1
            int r8 = r8 + r10
            java.lang.String r8 = b.a.c.c(r2, r8, r6)
            int r13 = b.a.c.b(r8)
            if (r13 == r12) goto L_0x0037
            return r9
        L_0x0037:
            int r6 = r6 + r10
            r21 = r9
            r17 = -1
            r19 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r22 = 0
            r23 = 0
            r24 = 1
            r25 = 0
        L_0x0049:
            if (r6 >= r3) goto L_0x0246
            int r15 = b.a.c.a((java.lang.String) r2, (int) r6, (int) r3, (char) r4)
            int r13 = b.a.c.a((java.lang.String) r2, (int) r6, (int) r15, (char) r7)
            java.lang.String r6 = b.a.c.c(r2, r6, r13)
            if (r13 >= r15) goto L_0x0060
            int r13 = r13 + 1
            java.lang.String r13 = b.a.c.c(r2, r13, r15)
            goto L_0x0062
        L_0x0060:
            java.lang.String r13 = ""
        L_0x0062:
            java.lang.String r14 = "expires"
            boolean r14 = r6.equalsIgnoreCase(r14)
            if (r14 == 0) goto L_0x01cd
            int r6 = r13.length()     // Catch:{ IllegalArgumentException -> 0x01ca }
            int r14 = a(r13, r5, r6, r5)     // Catch:{ IllegalArgumentException -> 0x01ca }
            java.util.regex.Pattern r7 = f     // Catch:{ IllegalArgumentException -> 0x01ca }
            java.util.regex.Matcher r7 = r7.matcher(r13)     // Catch:{ IllegalArgumentException -> 0x01ca }
            r4 = -1
            r5 = -1
            r26 = -1
            r27 = -1
            r28 = -1
            r29 = -1
        L_0x0082:
            if (r14 >= r6) goto L_0x0130
            int r12 = r14 + 1
            int r12 = a(r13, r12, r6, r10)     // Catch:{ IllegalArgumentException -> 0x01ca }
            r7.region(r14, r12)     // Catch:{ IllegalArgumentException -> 0x01ca }
            r14 = -1
            if (r5 != r14) goto L_0x00c0
            java.util.regex.Pattern r14 = f     // Catch:{ IllegalArgumentException -> 0x01ca }
            java.util.regex.Matcher r14 = r7.usePattern(r14)     // Catch:{ IllegalArgumentException -> 0x01ca }
            boolean r14 = r14.matches()     // Catch:{ IllegalArgumentException -> 0x01ca }
            if (r14 == 0) goto L_0x00bc
            java.lang.String r5 = r7.group(r10)     // Catch:{ IllegalArgumentException -> 0x01ca }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IllegalArgumentException -> 0x01ca }
            r14 = 2
            java.lang.String r14 = r7.group(r14)     // Catch:{ IllegalArgumentException -> 0x01ca }
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ IllegalArgumentException -> 0x01ca }
            r10 = 3
            java.lang.String r10 = r7.group(r10)     // Catch:{ IllegalArgumentException -> 0x01ca }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ IllegalArgumentException -> 0x01ca }
            r29 = r10
            r28 = r14
            goto L_0x0124
        L_0x00bc:
            r10 = r27
            r14 = -1
            goto L_0x00c2
        L_0x00c0:
            r10 = r27
        L_0x00c2:
            if (r10 != r14) goto L_0x00dc
            java.util.regex.Pattern r14 = e     // Catch:{ IllegalArgumentException -> 0x01ca }
            java.util.regex.Matcher r14 = r7.usePattern(r14)     // Catch:{ IllegalArgumentException -> 0x01ca }
            boolean r14 = r14.matches()     // Catch:{ IllegalArgumentException -> 0x01ca }
            if (r14 == 0) goto L_0x00dc
            r14 = 1
            java.lang.String r10 = r7.group(r14)     // Catch:{ IllegalArgumentException -> 0x01ca }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ IllegalArgumentException -> 0x01ca }
        L_0x00d9:
            r27 = r10
            goto L_0x0124
        L_0x00dc:
            r14 = r26
            r2 = -1
            if (r14 != r2) goto L_0x0108
            java.util.regex.Pattern r2 = d     // Catch:{ IllegalArgumentException -> 0x01ca }
            java.util.regex.Matcher r2 = r7.usePattern(r2)     // Catch:{ IllegalArgumentException -> 0x01ca }
            boolean r2 = r2.matches()     // Catch:{ IllegalArgumentException -> 0x01ca }
            if (r2 == 0) goto L_0x0107
            r2 = 1
            java.lang.String r14 = r7.group(r2)     // Catch:{ IllegalArgumentException -> 0x01ca }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ IllegalArgumentException -> 0x01ca }
            java.lang.String r2 = r14.toLowerCase(r2)     // Catch:{ IllegalArgumentException -> 0x01ca }
            java.util.regex.Pattern r14 = d     // Catch:{ IllegalArgumentException -> 0x01ca }
            java.lang.String r14 = r14.pattern()     // Catch:{ IllegalArgumentException -> 0x01ca }
            int r2 = r14.indexOf(r2)     // Catch:{ IllegalArgumentException -> 0x01ca }
            int r2 = r2 / 4
            r26 = r2
            goto L_0x00d9
        L_0x0107:
            r2 = -1
        L_0x0108:
            if (r4 != r2) goto L_0x0120
            java.util.regex.Pattern r2 = f329c     // Catch:{ IllegalArgumentException -> 0x01ca }
            java.util.regex.Matcher r2 = r7.usePattern(r2)     // Catch:{ IllegalArgumentException -> 0x01ca }
            boolean r2 = r2.matches()     // Catch:{ IllegalArgumentException -> 0x01ca }
            if (r2 == 0) goto L_0x0120
            r2 = 1
            java.lang.String r4 = r7.group(r2)     // Catch:{ IllegalArgumentException -> 0x01ca }
            int r2 = java.lang.Integer.parseInt(r4)     // Catch:{ IllegalArgumentException -> 0x01ca }
            r4 = r2
        L_0x0120:
            r27 = r10
            r26 = r14
        L_0x0124:
            int r12 = r12 + 1
            r2 = 0
            int r14 = a(r13, r12, r6, r2)     // Catch:{ IllegalArgumentException -> 0x01ca }
            r2 = r34
            r10 = 1
            goto L_0x0082
        L_0x0130:
            r14 = r26
            r10 = r27
            r2 = 70
            if (r4 < r2) goto L_0x013e
            r2 = 99
            if (r4 > r2) goto L_0x013e
            int r4 = r4 + 1900
        L_0x013e:
            if (r4 < 0) goto L_0x0146
            r2 = 69
            if (r4 > r2) goto L_0x0146
            int r4 = r4 + 2000
        L_0x0146:
            r2 = 1601(0x641, float:2.243E-42)
            if (r4 >= r2) goto L_0x0150
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01ca }
            r2.<init>()     // Catch:{ IllegalArgumentException -> 0x01ca }
            throw r2     // Catch:{ IllegalArgumentException -> 0x01ca }
        L_0x0150:
            r2 = -1
            if (r14 != r2) goto L_0x0159
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x01ca }
            r4.<init>()     // Catch:{ IllegalArgumentException -> 0x01ca }
            throw r4     // Catch:{ IllegalArgumentException -> 0x01ca }
        L_0x0159:
            if (r10 <= 0) goto L_0x01c2
            r6 = 31
            if (r10 <= r6) goto L_0x0160
            goto L_0x01c2
        L_0x0160:
            if (r5 < 0) goto L_0x01ba
            r6 = 23
            if (r5 <= r6) goto L_0x0167
            goto L_0x01ba
        L_0x0167:
            r12 = r28
            if (r12 < 0) goto L_0x01b2
            r7 = 59
            if (r12 <= r7) goto L_0x0170
            goto L_0x01b4
        L_0x0170:
            r6 = r29
            if (r6 < 0) goto L_0x01ac
            if (r6 <= r7) goto L_0x0177
            goto L_0x01ac
        L_0x0177:
            java.util.GregorianCalendar r13 = new java.util.GregorianCalendar     // Catch:{ IllegalArgumentException -> 0x0216 }
            java.util.TimeZone r2 = b.a.c.f     // Catch:{ IllegalArgumentException -> 0x0216 }
            r13.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0216 }
            r2 = 0
            r13.setLenient(r2)     // Catch:{ IllegalArgumentException -> 0x0216 }
            r2 = 1
            r13.set(r2, r4)     // Catch:{ IllegalArgumentException -> 0x0216 }
            int r2 = r14 + -1
            r4 = 2
            r13.set(r4, r2)     // Catch:{ IllegalArgumentException -> 0x0216 }
            r2 = 5
            r13.set(r2, r10)     // Catch:{ IllegalArgumentException -> 0x0216 }
            r2 = 11
            r13.set(r2, r5)     // Catch:{ IllegalArgumentException -> 0x0216 }
            r2 = 12
            r13.set(r2, r12)     // Catch:{ IllegalArgumentException -> 0x0216 }
            r2 = 13
            r13.set(r2, r6)     // Catch:{ IllegalArgumentException -> 0x0216 }
            r2 = 14
            r4 = 0
            r13.set(r2, r4)     // Catch:{ IllegalArgumentException -> 0x0216 }
            long r4 = r13.getTimeInMillis()     // Catch:{ IllegalArgumentException -> 0x0216 }
            r19 = r4
            goto L_0x01dd
        L_0x01ac:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0216 }
            r2.<init>()     // Catch:{ IllegalArgumentException -> 0x0216 }
            throw r2     // Catch:{ IllegalArgumentException -> 0x0216 }
        L_0x01b2:
            r7 = 59
        L_0x01b4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0216 }
            r2.<init>()     // Catch:{ IllegalArgumentException -> 0x0216 }
            throw r2     // Catch:{ IllegalArgumentException -> 0x0216 }
        L_0x01ba:
            r7 = 59
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0216 }
            r2.<init>()     // Catch:{ IllegalArgumentException -> 0x0216 }
            throw r2     // Catch:{ IllegalArgumentException -> 0x0216 }
        L_0x01c2:
            r7 = 59
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0216 }
            r2.<init>()     // Catch:{ IllegalArgumentException -> 0x0216 }
            throw r2     // Catch:{ IllegalArgumentException -> 0x0216 }
        L_0x01ca:
            r7 = 59
            goto L_0x0216
        L_0x01cd:
            r7 = 59
            java.lang.String r2 = "max-age"
            boolean r2 = r6.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x01e1
            long r4 = a((java.lang.String) r13)     // Catch:{  }
            r17 = r4
        L_0x01dd:
            r2 = 1
            r25 = 1
            goto L_0x0239
        L_0x01e1:
            java.lang.String r2 = "domain"
            boolean r2 = r6.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0218
            java.lang.String r2 = "."
            boolean r2 = r13.endsWith(r2)     // Catch:{ IllegalArgumentException -> 0x0216 }
            if (r2 == 0) goto L_0x01f7
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0216 }
            r2.<init>()     // Catch:{ IllegalArgumentException -> 0x0216 }
            throw r2     // Catch:{ IllegalArgumentException -> 0x0216 }
        L_0x01f7:
            java.lang.String r2 = "."
            boolean r2 = r13.startsWith(r2)     // Catch:{ IllegalArgumentException -> 0x0216 }
            if (r2 == 0) goto L_0x0205
            r2 = 1
            java.lang.String r13 = r13.substring(r2)     // Catch:{ IllegalArgumentException -> 0x0239 }
            goto L_0x0206
        L_0x0205:
            r2 = 1
        L_0x0206:
            java.lang.String r4 = b.a.c.a((java.lang.String) r13)     // Catch:{ IllegalArgumentException -> 0x0239 }
            if (r4 != 0) goto L_0x0212
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0239 }
            r4.<init>()     // Catch:{ IllegalArgumentException -> 0x0239 }
            throw r4     // Catch:{ IllegalArgumentException -> 0x0239 }
        L_0x0212:
            r9 = r4
            r24 = 0
            goto L_0x0239
        L_0x0216:
            r2 = 1
            goto L_0x0239
        L_0x0218:
            r2 = 1
            java.lang.String r4 = "path"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0224
            r21 = r13
            goto L_0x0239
        L_0x0224:
            java.lang.String r4 = "secure"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x022f
            r22 = 1
            goto L_0x0239
        L_0x022f:
            java.lang.String r4 = "httponly"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0239
            r23 = 1
        L_0x0239:
            int r6 = r15 + 1
            r2 = r34
            r4 = 59
            r5 = 0
            r7 = 61
            r10 = 1
            r12 = -1
            goto L_0x0049
        L_0x0246:
            r2 = -9223372036854775808
            int r4 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0250
        L_0x024c:
            r0 = r33
            r13 = r2
            goto L_0x0287
        L_0x0250:
            r2 = -1
            int r4 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0283
            r2 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r4 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0264
            r2 = 1000(0x3e8, double:4.94E-321)
            long r17 = r17 * r2
            goto L_0x0269
        L_0x0264:
            r17 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0269:
            r2 = 0
            long r2 = r31 + r17
            int r4 = (r2 > r31 ? 1 : (r2 == r31 ? 0 : -1))
            if (r4 < 0) goto L_0x027a
            r0 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x024c
            goto L_0x027f
        L_0x027a:
            r0 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
        L_0x027f:
            r13 = r0
            r0 = r33
            goto L_0x0287
        L_0x0283:
            r0 = r33
            r13 = r19
        L_0x0287:
            java.lang.String r1 = r0.l
            if (r9 != 0) goto L_0x028e
            r15 = r1
            r2 = 0
            goto L_0x0298
        L_0x028e:
            boolean r2 = a((java.lang.String) r1, (java.lang.String) r9)
            if (r2 != 0) goto L_0x0296
            r2 = 0
            return r2
        L_0x0296:
            r2 = 0
            r15 = r9
        L_0x0298:
            int r1 = r1.length()
            int r3 = r15.length()
            if (r1 == r3) goto L_0x02ad
            b.a.i.a r1 = b.a.i.a.a()
            java.lang.String r1 = r1.a((java.lang.String) r15)
            if (r1 != 0) goto L_0x02ad
            return r2
        L_0x02ad:
            r9 = r21
            if (r9 == 0) goto L_0x02bd
            java.lang.String r1 = "/"
            boolean r1 = r9.startsWith(r1)
            if (r1 != 0) goto L_0x02ba
            goto L_0x02bd
        L_0x02ba:
            r16 = r9
            goto L_0x02d3
        L_0x02bd:
            java.lang.String r0 = r33.e()
            r1 = 47
            int r1 = r0.lastIndexOf(r1)
            if (r1 == 0) goto L_0x02cf
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r1)
            goto L_0x02d1
        L_0x02cf:
            java.lang.String r0 = "/"
        L_0x02d1:
            r16 = r0
        L_0x02d3:
            b.m r0 = new b.m
            r10 = r0
            r12 = r8
            r17 = r22
            r18 = r23
            r19 = r24
            r20 = r25
            r10.<init>(r11, r12, r13, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x02e3:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.m.a(long, b.v, java.lang.String):b.m");
    }

    private String a() {
        return this.f330a;
    }

    public static List<m> a(v vVar, u uVar) {
        List<String> b2 = uVar.b("Set-Cookie");
        int size = b2.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            m a2 = a(System.currentTimeMillis(), vVar, b2.get(i2));
            if (a2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a2);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    private boolean a(v vVar) {
        if (!(this.m ? vVar.l.equals(this.h) : a(vVar.l, this.h))) {
            return false;
        }
        String str = this.i;
        String e2 = vVar.e();
        if (!(e2.equals(str) || (e2.startsWith(str) && (str.endsWith("/") || e2.charAt(str.length()) == '/')))) {
            return false;
        }
        return !this.j || vVar.b();
    }

    private static boolean a(v vVar, String str) {
        String e2 = vVar.e();
        if (e2.equals(str)) {
            return true;
        }
        if (e2.startsWith(str)) {
            return str.endsWith("/") || e2.charAt(str.length()) == '/';
        }
        return false;
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !c.c(str);
    }

    @Nullable
    private static m b(v vVar, String str) {
        return a(System.currentTimeMillis(), vVar, str);
    }

    private String b() {
        return this.f331b;
    }

    private static String b(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String a2 = c.a(str);
        if (a2 != null) {
            return a2;
        }
        throw new IllegalArgumentException();
    }

    private boolean c() {
        return this.l;
    }

    private long d() {
        return this.g;
    }

    private boolean e() {
        return this.m;
    }

    private String f() {
        return this.h;
    }

    private String g() {
        return this.i;
    }

    private boolean h() {
        return this.k;
    }

    private boolean i() {
        return this.j;
    }

    private String j() {
        String a2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f330a);
        sb.append('=');
        sb.append(this.f331b);
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

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return mVar.f330a.equals(this.f330a) && mVar.f331b.equals(this.f331b) && mVar.h.equals(this.h) && mVar.i.equals(this.i) && mVar.g == this.g && mVar.j == this.j && mVar.k == this.k && mVar.l == this.l && mVar.m == this.m;
    }

    public final int hashCode() {
        return ((((((((((((((((this.f330a.hashCode() + 527) * 31) + this.f331b.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + ((int) (this.g ^ (this.g >>> 32)))) * 31) + (this.j ^ true ? 1 : 0)) * 31) + (this.k ^ true ? 1 : 0)) * 31) + (this.l ^ true ? 1 : 0)) * 31) + (this.m ^ true ? 1 : 0);
    }

    public final String toString() {
        String a2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f330a);
        sb.append('=');
        sb.append(this.f331b);
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

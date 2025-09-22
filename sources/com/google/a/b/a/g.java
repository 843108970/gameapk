package com.google.a.b.a;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g extends q {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f3024a = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");

    /* renamed from: b  reason: collision with root package name */
    private static final long[] f3025b = {604800000, 86400000, 3600000, 60000, 1000};

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f3026c = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
    private final String d;
    private final long e;
    private final boolean f;
    private final long g;
    private final boolean h;
    private final String i;
    private final String j;
    private final String[] k;
    private final String l;
    private final double m;
    private final double n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d2, double d3) {
        super(r.CALENDAR$3fc7421e);
        this.d = str;
        try {
            this.e = a(str2);
            if (str3 == null) {
                long a2 = a((CharSequence) str4);
                this.g = a2 < 0 ? -1 : this.e + a2;
            } else {
                try {
                    this.g = a(str3);
                } catch (ParseException e2) {
                    throw new IllegalArgumentException(e2.toString());
                }
            }
            boolean z = false;
            this.f = str2.length() == 8;
            if (str3 != null && str3.length() == 8) {
                z = true;
            }
            this.h = z;
            this.i = str5;
            this.j = str6;
            this.k = strArr;
            this.l = str7;
            this.m = d2;
            this.n = d3;
        } catch (ParseException e3) {
            throw new IllegalArgumentException(e3.toString());
        }
    }

    private static long a(CharSequence charSequence) {
        if (charSequence == null) {
            return -1;
        }
        Matcher matcher = f3024a.matcher(charSequence);
        if (!matcher.matches()) {
            return -1;
        }
        long j2 = 0;
        int i2 = 0;
        while (i2 < f3025b.length) {
            int i3 = i2 + 1;
            String group = matcher.group(i3);
            if (group != null) {
                j2 += f3025b[i2] * ((long) Integer.parseInt(group));
            }
            i2 = i3;
        }
        return j2;
    }

    private static long a(String str) throws ParseException {
        if (!f3026c.matcher(str).matches()) {
            throw new ParseException(str, 0);
        } else if (str.length() == 8) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        } else if (str.length() != 16 || str.charAt(15) != 'Z') {
            return b(str);
        } else {
            long b2 = b(str.substring(0, 15));
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            long j2 = b2 + ((long) gregorianCalendar.get(15));
            gregorianCalendar.setTime(new Date(j2));
            return j2 + ((long) gregorianCalendar.get(16));
        }
    }

    private static String a(boolean z, long j2) {
        if (j2 < 0) {
            return null;
        }
        return (z ? DateFormat.getDateInstance(2) : DateFormat.getDateTimeInstance(2, 2)).format(Long.valueOf(j2));
    }

    private static long b(String str) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH).parse(str).getTime();
    }

    private String b() {
        return this.d;
    }

    @Deprecated
    private Date c() {
        return new Date(this.e);
    }

    private long d() {
        return this.e;
    }

    private boolean e() {
        return this.f;
    }

    @Deprecated
    private Date f() {
        if (this.g < 0) {
            return null;
        }
        return new Date(this.g);
    }

    private long g() {
        return this.g;
    }

    private boolean h() {
        return this.h;
    }

    private String i() {
        return this.i;
    }

    private String j() {
        return this.j;
    }

    private String[] k() {
        return this.k;
    }

    private String l() {
        return this.l;
    }

    private double m() {
        return this.m;
    }

    private double n() {
        return this.n;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(100);
        a(this.d, sb);
        a(a(this.f, this.e), sb);
        a(a(this.h, this.g), sb);
        a(this.i, sb);
        a(this.j, sb);
        a(this.k, sb);
        a(this.l, sb);
        return sb.toString();
    }
}

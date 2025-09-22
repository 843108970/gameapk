package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.mail.EmailConstants;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final String UTC_ID = "UTC";

    private static boolean checkOffset(String str, int i, char c2) {
        return i < str.length() && str.charAt(i) == c2;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder((z ? 4 : 0) + 19 + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        char c2 = '-';
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append(FilenameUtils.EXTENSION_SEPARATOR);
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / EmailConstants.SOCKET_TIMEOUT_MS;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            if (offset >= 0) {
                c2 = '+';
            }
            sb.append(c2);
            padInt(sb, abs, 2);
            sb.append(':');
            padInt(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c7 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            r1 = r18
            r2 = r19
            int r3 = r19.getIndex()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            int r4 = r3 + 4
            int r3 = parseInt(r1, r3, r4)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r5 = 45
            boolean r6 = checkOffset(r1, r4, r5)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r6 == 0) goto L_0x0018
            int r4 = r4 + 1
        L_0x0018:
            int r6 = r4 + 2
            int r4 = parseInt(r1, r4, r6)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            boolean r7 = checkOffset(r1, r6, r5)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r7 == 0) goto L_0x0026
            int r6 = r6 + 1
        L_0x0026:
            int r7 = r6 + 2
            int r6 = parseInt(r1, r6, r7)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r8 = 84
            boolean r8 = checkOffset(r1, r7, r8)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r9 = 1
            if (r8 != 0) goto L_0x0049
            int r10 = r18.length()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r10 > r7) goto L_0x0049
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            int r4 = r4 - r9
            r5.<init>(r3, r4, r6)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r2.setIndex(r7)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.util.Date r3 = r5.getTime()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            return r3
        L_0x0049:
            r10 = 43
            r11 = 90
            if (r8 == 0) goto L_0x00bc
            int r7 = r7 + 1
            int r8 = r7 + 2
            int r7 = parseInt(r1, r7, r8)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r13 = 58
            boolean r14 = checkOffset(r1, r8, r13)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r14 == 0) goto L_0x0061
            int r8 = r8 + 1
        L_0x0061:
            int r14 = r8 + 2
            int r8 = parseInt(r1, r8, r14)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            boolean r13 = checkOffset(r1, r14, r13)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r13 == 0) goto L_0x006f
            int r14 = r14 + 1
        L_0x006f:
            int r13 = r18.length()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r13 <= r14) goto L_0x00ba
            char r13 = r1.charAt(r14)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r13 == r11) goto L_0x00ba
            if (r13 == r10) goto L_0x00ba
            if (r13 == r5) goto L_0x00ba
            int r13 = r14 + 2
            int r14 = parseInt(r1, r14, r13)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r15 = 59
            if (r14 <= r15) goto L_0x008f
            r15 = 63
            if (r14 >= r15) goto L_0x008f
            r14 = 59
        L_0x008f:
            r15 = 46
            boolean r15 = checkOffset(r1, r13, r15)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r15 == 0) goto L_0x00b8
            int r13 = r13 + 1
            int r15 = r13 + 1
            int r15 = indexOfNonDigit(r1, r15)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            int r12 = r13 + 3
            int r12 = java.lang.Math.min(r15, r12)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            int r16 = parseInt(r1, r13, r12)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            int r12 = r12 - r13
            switch(r12) {
                case 1: goto L_0x00b3;
                case 2: goto L_0x00b0;
                default: goto L_0x00ad;
            }     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
        L_0x00ad:
            r12 = r16
            goto L_0x00b6
        L_0x00b0:
            int r16 = r16 * 10
            goto L_0x00ad
        L_0x00b3:
            int r16 = r16 * 100
            goto L_0x00ad
        L_0x00b6:
            r13 = r15
            goto L_0x00c1
        L_0x00b8:
            r12 = 0
            goto L_0x00c1
        L_0x00ba:
            r13 = r14
            goto L_0x00bf
        L_0x00bc:
            r13 = r7
            r7 = 0
            r8 = 0
        L_0x00bf:
            r12 = 0
            r14 = 0
        L_0x00c1:
            int r15 = r18.length()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r15 > r13) goto L_0x00cf
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r4 = "No time zone indicator"
            r3.<init>(r4)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            throw r3     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
        L_0x00cf:
            char r15 = r1.charAt(r13)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r5 = 5
            if (r15 != r11) goto L_0x00db
            java.util.TimeZone r10 = TIMEZONE_UTC     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            int r13 = r13 + r9
            goto L_0x017b
        L_0x00db:
            if (r15 == r10) goto L_0x00fb
            r10 = 45
            if (r15 != r10) goto L_0x00e2
            goto L_0x00fb
        L_0x00e2:
            java.lang.IndexOutOfBoundsException r3 = new java.lang.IndexOutOfBoundsException     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r5 = "Invalid time zone indicator '"
            r4.<init>(r5)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r4.append(r15)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r5 = "'"
            r4.append(r5)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r4 = r4.toString()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r3.<init>(r4)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            throw r3     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
        L_0x00fb:
            java.lang.String r10 = r1.substring(r13)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            int r11 = r10.length()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r11 < r5) goto L_0x0106
            goto L_0x0117
        L_0x0106:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r11.<init>()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r11.append(r10)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r10 = "00"
            r11.append(r10)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r10 = r11.toString()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
        L_0x0117:
            int r11 = r10.length()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            int r13 = r13 + r11
            java.lang.String r11 = "+0000"
            boolean r11 = r11.equals(r10)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r11 != 0) goto L_0x0179
            java.lang.String r11 = "+00:00"
            boolean r11 = r11.equals(r10)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r11 == 0) goto L_0x012d
            goto L_0x0179
        L_0x012d:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r15 = "GMT"
            r11.<init>(r15)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r11.append(r10)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r10 = r11.toString()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.util.TimeZone r11 = java.util.TimeZone.getTimeZone(r10)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r15 = r11.getID()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            boolean r16 = r15.equals(r10)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r16 != 0) goto L_0x0177
            java.lang.String r5 = ":"
            java.lang.String r9 = ""
            java.lang.String r5 = r15.replace(r5, r9)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            boolean r5 = r5.equals(r10)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            if (r5 != 0) goto L_0x0177
            java.lang.IndexOutOfBoundsException r3 = new java.lang.IndexOutOfBoundsException     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r5 = "Mismatching time zone indicator: "
            r4.<init>(r5)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r4.append(r10)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r5 = " given, resolves to "
            r4.append(r5)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r5 = r11.getID()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r4.append(r5)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.lang.String r4 = r4.toString()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r3.<init>(r4)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            throw r3     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
        L_0x0177:
            r10 = r11
            goto L_0x017b
        L_0x0179:
            java.util.TimeZone r10 = TIMEZONE_UTC     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
        L_0x017b:
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r5.<init>(r10)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r9 = 0
            r5.setLenient(r9)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r9 = 1
            r5.set(r9, r3)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            int r4 = r4 - r9
            r3 = 2
            r5.set(r3, r4)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r3 = 5
            r5.set(r3, r6)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r3 = 11
            r5.set(r3, r7)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r3 = 12
            r5.set(r3, r8)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r3 = 13
            r5.set(r3, r14)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r3 = 14
            r5.set(r3, r12)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            r2.setIndex(r13)     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            java.util.Date r3 = r5.getTime()     // Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ad }
            return r3
        L_0x01ad:
            r0 = move-exception
            r3 = r0
            if (r1 != 0) goto L_0x01b3
            r1 = 0
            goto L_0x01c6
        L_0x01b3:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "\""
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r1 = "'"
            r4.append(r1)
            java.lang.String r1 = r4.toString()
        L_0x01c6:
            java.lang.String r4 = r3.getMessage()
            if (r4 == 0) goto L_0x01d2
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x01ed
        L_0x01d2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "("
            r4.<init>(r5)
            java.lang.Class r5 = r3.getClass()
            java.lang.String r5 = r5.getName()
            r4.append(r5)
            java.lang.String r5 = ")"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L_0x01ed:
            java.text.ParseException r5 = new java.text.ParseException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Failed to parse date ["
            r6.<init>(r7)
            r6.append(r1)
            java.lang.String r1 = "]: "
            r6.append(r1)
            r6.append(r4)
            java.lang.String r1 = r6.toString()
            int r2 = r19.getIndex()
            r5.<init>(r1, r2)
            r5.initCause(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -digit;
        } else {
            i4 = i;
            i3 = 0;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - digit2;
            i4 = i5;
        }
        return -i3;
    }
}

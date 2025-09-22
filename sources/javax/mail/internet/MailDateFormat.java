package javax.mail.internet;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class MailDateFormat extends SimpleDateFormat {
    private static Calendar cal = new GregorianCalendar(tz);
    static boolean debug = false;
    private static final long serialVersionUID = -8148227605210628779L;
    private static TimeZone tz = TimeZone.getTimeZone("GMT");

    public MailDateFormat() {
        super("EEE, d MMM yyyy HH:mm:ss 'XXXXX' (z)", Locale.US);
    }

    private static synchronized Date ourUTC(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        Date time;
        synchronized (MailDateFormat.class) {
            cal.clear();
            cal.setLenient(z);
            cal.set(1, i);
            cal.set(2, i2);
            cal.set(5, i3);
            cal.set(11, i4);
            cal.set(12, i5 + i7);
            cal.set(13, i6);
            time = cal.getTime();
        }
        return time;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (debug != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        r5 = java.lang.System.out;
        r5.println("No timezone? : '" + new java.lang.String(r11) + "'");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Date parseDate(char[] r11, java.text.ParsePosition r12, boolean r13) {
        /*
            javax.mail.internet.MailDateParser r0 = new javax.mail.internet.MailDateParser     // Catch:{ Exception -> 0x008c }
            r0.<init>(r11)     // Catch:{ Exception -> 0x008c }
            r0.skipUntilNumber()     // Catch:{ Exception -> 0x008c }
            int r3 = r0.parseNumber()     // Catch:{ Exception -> 0x008c }
            r1 = 45
            boolean r2 = r0.skipIfChar(r1)     // Catch:{ Exception -> 0x008c }
            if (r2 != 0) goto L_0x0017
            r0.skipWhiteSpace()     // Catch:{ Exception -> 0x008c }
        L_0x0017:
            int r2 = r0.parseMonth()     // Catch:{ Exception -> 0x008c }
            boolean r1 = r0.skipIfChar(r1)     // Catch:{ Exception -> 0x008c }
            if (r1 != 0) goto L_0x0024
            r0.skipWhiteSpace()     // Catch:{ Exception -> 0x008c }
        L_0x0024:
            int r1 = r0.parseNumber()     // Catch:{ Exception -> 0x008c }
            r4 = 50
            if (r1 >= r4) goto L_0x002f
            int r1 = r1 + 2000
            goto L_0x0035
        L_0x002f:
            r4 = 100
            if (r1 >= r4) goto L_0x0035
            int r1 = r1 + 1900
        L_0x0035:
            r0.skipWhiteSpace()     // Catch:{ Exception -> 0x008c }
            int r4 = r0.parseNumber()     // Catch:{ Exception -> 0x008c }
            r5 = 58
            r0.skipChar(r5)     // Catch:{ Exception -> 0x008c }
            int r6 = r0.parseNumber()     // Catch:{ Exception -> 0x008c }
            boolean r5 = r0.skipIfChar(r5)     // Catch:{ Exception -> 0x008c }
            r7 = 0
            if (r5 == 0) goto L_0x0052
            int r5 = r0.parseNumber()     // Catch:{ Exception -> 0x008c }
            r8 = r5
            goto L_0x0053
        L_0x0052:
            r8 = 0
        L_0x0053:
            r0.skipWhiteSpace()     // Catch:{ ParseException -> 0x005c }
            int r5 = r0.parseTimeZone()     // Catch:{ ParseException -> 0x005c }
            r7 = r5
            goto L_0x007d
        L_0x005c:
            boolean r5 = debug     // Catch:{ Exception -> 0x008c }
            if (r5 == 0) goto L_0x007d
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ Exception -> 0x008c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008c }
            java.lang.String r10 = "No timezone? : '"
            r9.<init>(r10)     // Catch:{ Exception -> 0x008c }
            java.lang.String r10 = new java.lang.String     // Catch:{ Exception -> 0x008c }
            r10.<init>(r11)     // Catch:{ Exception -> 0x008c }
            r9.append(r10)     // Catch:{ Exception -> 0x008c }
            java.lang.String r10 = "'"
            r9.append(r10)     // Catch:{ Exception -> 0x008c }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x008c }
            r5.println(r9)     // Catch:{ Exception -> 0x008c }
        L_0x007d:
            int r0 = r0.getIndex()     // Catch:{ Exception -> 0x008c }
            r12.setIndex(r0)     // Catch:{ Exception -> 0x008c }
            r5 = r6
            r6 = r8
            r8 = r13
            java.util.Date r13 = ourUTC(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x008c }
            return r13
        L_0x008c:
            r13 = move-exception
            boolean r0 = debug
            if (r0 == 0) goto L_0x00b1
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Bad date: '"
            r1.<init>(r2)
            java.lang.String r2 = new java.lang.String
            r2.<init>(r11)
            r1.append(r2)
            java.lang.String r11 = "'"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.println(r11)
            r13.printStackTrace()
        L_0x00b1:
            r11 = 1
            r12.setIndex(r11)
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MailDateFormat.parseDate(char[], java.text.ParsePosition, boolean):java.util.Date");
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        int i;
        int length = stringBuffer.length();
        super.format(date, stringBuffer, fieldPosition);
        int i2 = length + 25;
        while (stringBuffer.charAt(i2) != 'X') {
            i2++;
        }
        this.calendar.clear();
        this.calendar.setTime(date);
        int i3 = this.calendar.get(15) + this.calendar.get(16);
        if (i3 < 0) {
            i = i2 + 1;
            stringBuffer.setCharAt(i2, '-');
            i3 = -i3;
        } else {
            i = i2 + 1;
            stringBuffer.setCharAt(i2, '+');
        }
        int i4 = (i3 / 60) / 1000;
        int i5 = i4 / 60;
        int i6 = i4 % 60;
        int i7 = i + 1;
        stringBuffer.setCharAt(i, Character.forDigit(i5 / 10, 10));
        int i8 = i7 + 1;
        stringBuffer.setCharAt(i7, Character.forDigit(i5 % 10, 10));
        stringBuffer.setCharAt(i8, Character.forDigit(i6 / 10, 10));
        stringBuffer.setCharAt(i8 + 1, Character.forDigit(i6 % 10, 10));
        return stringBuffer;
    }

    public Date parse(String str, ParsePosition parsePosition) {
        return parseDate(str.toCharArray(), parsePosition, isLenient());
    }

    public void setCalendar(Calendar calendar) {
        throw new RuntimeException("Method setCalendar() shouldn't be called");
    }

    public void setNumberFormat(NumberFormat numberFormat) {
        throw new RuntimeException("Method setNumberFormat() shouldn't be called");
    }
}

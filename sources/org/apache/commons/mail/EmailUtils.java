package org.apache.commons.mail;

import android.support.v7.widget.ActivityChooserView;
import java.util.BitSet;
import java.util.Random;

final class EmailUtils {
    private static final char ESCAPE_CHAR = '%';
    private static final int RADIX = 16;
    private static final Random RANDOM = new Random();
    private static final BitSet SAFE_URL = new BitSet(256);
    private static final String US_ASCII = "US-ASCII";

    static {
        for (int i = 97; i <= 122; i++) {
            SAFE_URL.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            SAFE_URL.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            SAFE_URL.set(i3);
        }
        SAFE_URL.set(45);
        SAFE_URL.set(95);
        SAFE_URL.set(46);
        SAFE_URL.set(42);
        SAFE_URL.set(43);
        SAFE_URL.set(36);
        SAFE_URL.set(33);
        SAFE_URL.set(39);
        SAFE_URL.set(40);
        SAFE_URL.set(41);
        SAFE_URL.set(44);
        SAFE_URL.set(64);
    }

    private EmailUtils() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String encodeUrl(java.lang.String r6) throws java.io.UnsupportedEncodingException {
        /*
            if (r6 != 0) goto L_0x0004
            r6 = 0
            return r6
        L_0x0004:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "US-ASCII"
            byte[] r6 = r6.getBytes(r1)
            int r1 = r6.length
            r2 = 0
        L_0x0011:
            if (r2 >= r1) goto L_0x004a
            byte r3 = r6[r2]
            if (r3 >= 0) goto L_0x0019
            int r3 = r3 + 256
        L_0x0019:
            java.util.BitSet r4 = SAFE_URL
            boolean r4 = r4.get(r3)
            if (r4 == 0) goto L_0x0026
            char r3 = (char) r3
        L_0x0022:
            r0.append(r3)
            goto L_0x0047
        L_0x0026:
            r4 = 37
            r0.append(r4)
            int r4 = r3 >> 4
            r4 = r4 & 15
            r5 = 16
            char r4 = java.lang.Character.forDigit(r4, r5)
            char r4 = java.lang.Character.toUpperCase(r4)
            r3 = r3 & 15
            char r3 = java.lang.Character.forDigit(r3, r5)
            char r3 = java.lang.Character.toUpperCase(r3)
            r0.append(r4)
            goto L_0x0022
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x004a:
            java.lang.String r6 = r0.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.mail.EmailUtils.encodeUrl(java.lang.String):java.lang.String");
    }

    static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }

    static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    private static String random(int i, int i2, int i3, boolean z, boolean z2, char[] cArr, Random random) {
        if (i == 0) {
            return "";
        }
        if (i < 0) {
            throw new IllegalArgumentException("Requested random string length " + i + " is less than 0.");
        }
        if (i2 == 0 && i3 == 0) {
            i3 = 123;
            i2 = 32;
            if (!z && !z2) {
                i2 = 0;
                i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i4 = i3 - i2;
        while (true) {
            int i5 = i - 1;
            if (i == 0) {
                return stringBuffer.toString();
            }
            char nextInt = cArr == null ? (char) (random.nextInt(i4) + i2) : cArr[random.nextInt(i4) + i2];
            if ((!z || !z2 || !Character.isLetterOrDigit(nextInt)) && ((!z || !Character.isLetter(nextInt)) && ((!z2 || !Character.isDigit(nextInt)) && (z || z2)))) {
                i = i5 + 1;
            } else {
                stringBuffer.append(nextInt);
                i = i5;
            }
        }
    }

    static String randomAlphabetic(int i) {
        return random(i, 0, 0, true, false, (char[]) null, RANDOM);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042 A[SYNTHETIC, Splitter:B:16:0x0042] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void writeMimeMessage(java.io.File r3, javax.mail.internet.MimeMessage r4) throws java.io.IOException, javax.mail.MessagingException {
        /*
            r0 = 0
            java.io.File r1 = r3.getParentFile()     // Catch:{ all -> 0x003f }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x002d
            java.io.File r1 = r3.getParentFile()     // Catch:{ all -> 0x003f }
            boolean r1 = r1.mkdirs()     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x002d
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x003f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            java.lang.String r2 = "Failed to create the following parent directories: "
            r1.<init>(r2)     // Catch:{ all -> 0x003f }
            java.io.File r3 = r3.getParentFile()     // Catch:{ all -> 0x003f }
            r1.append(r3)     // Catch:{ all -> 0x003f }
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x003f }
            r4.<init>(r3)     // Catch:{ all -> 0x003f }
            throw r4     // Catch:{ all -> 0x003f }
        L_0x002d:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x003f }
            r1.<init>(r3)     // Catch:{ all -> 0x003f }
            r4.writeTo(r1)     // Catch:{ all -> 0x003c }
            r1.flush()     // Catch:{ all -> 0x003c }
            r1.close()     // Catch:{ all -> 0x003c }
            return
        L_0x003c:
            r3 = move-exception
            r0 = r1
            goto L_0x0040
        L_0x003f:
            r3 = move-exception
        L_0x0040:
            if (r0 == 0) goto L_0x004a
            r0.close()     // Catch:{ Exception -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r4 = move-exception
            r4.printStackTrace()
        L_0x004a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.mail.EmailUtils.writeMimeMessage(java.io.File, javax.mail.internet.MimeMessage):void");
    }
}
